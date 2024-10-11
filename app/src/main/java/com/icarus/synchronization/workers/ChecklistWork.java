package com.icarus.synchronization.workers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AllChecklistEntity;
import com.icarus.entities.CheckListLogoEntity;
import com.icarus.entities.CheckListTitlesEntity;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.ChecklistApi;
import com.icarus.synchronization.syncmodels.RetrieveChecklists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ChecklistWork extends CommonWorker {

    private String lastSyncTime;
    private final Context mContext;

    public ChecklistWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public synchronized Result doWork() {
        Integer pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 0);
        lastSyncTime = AppDatabase.getInstance(getApplicationContext()).postSynchronizationDao().getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());

        Result result = Result.success();
        if (pageCount > 0) {
            for (int i = 0; i < pageCount; i++) {
                result = hitAPI(i + 1);
            }
        }

        return result;
    }

    /**
     * @param pageNo No of required page
     */
    private synchronized Result hitAPI(Integer pageNo) {
        ChecklistApi service = RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(ChecklistApi.class);

        Call<RetrieveChecklists> call = service.checklistIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo,
                BaseApplication.getPreferenceManager().getLastActivityAfter(),
                BaseApplication.getPreferenceManager().getLastActivityBefore(),
                Parameters.PARAM_CHECKLIST_EMBED_TITLE_LOGO,
                Parameters.PARAM_CHECKLIST_PUBLISHED,
                Parameters.PARAM_CHECKLIST_TEMPLATE,
                Parameters.PARAM_CHECKLIST_STATUS_ID,
                BaseApplication.getPreferenceManager().getUserLocationId(),
                BaseApplication.getPreferenceManager().getRevisionNumber());
        try {
            RetrieveChecklists response = call.execute().body();
            ParseResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(Parameters.TAG, e.getMessage());
            WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
        }
        return Result.success();

    }

    private void ParseResponse(RetrieveChecklists retrieveChecklists) {
        if (retrieveChecklists != null && retrieveChecklists.getData() != null && retrieveChecklists.getData().size() > 0) {
            AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
            GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
            String checklistIds = "";
            ArrayList<Integer> checklistIdList = new ArrayList<>();

            for (RetrieveChecklists.Datum checklist : retrieveChecklists.getData()) {
                try {
                    RetrieveChecklists.ChecklistTitle checklistTitle = checklist.getChecklistTitle();
                    Integer checklistId = checklist.getId();
                    List<RetrieveChecklists.ChecklistLogo> checklistLogos = checklist.getChecklistLogos();
                    String updatedAt = checklist.getUpdatedAt();

                    AllChecklistEntity allChecklistEntity = ModelMapper.mapChecklistEntity(checklist);
                    CheckListTitlesEntity checkListTitlesEntity = ModelMapper.mapChecklistTitleEntity(
                            checklistTitle, checklistId);
                    List<CheckListLogoEntity> checkListLogoEntities = ModelMapper.mapChecklistLogo(
                            checklistLogos, updatedAt);

                    getSynchronizationDao.insertChecklistAssociatedData(allChecklistEntity,
                            checkListTitlesEntity,
                            checkListLogoEntities);

                    //Add checklist in list to be fetched in checklist_location.json
                    checklistIdList.add(checklist.getId());

                    if (!TextUtils.isEmpty(checklistIds)) {
                        checklistIds += ",";
                    }
                    checklistIds += checklist.getId();

                } catch (Exception e) {
                    //Fetch checklist_locations for only those checklist ids which have been saved
                    // successfully in the database, so remove the id from list if not saved saved
                    //successfully
                    checklistIdList.remove(checklist.getId());
                    e.printStackTrace();
                }
            }

            for (Integer id : checklistIdList) {
                Data data = new Data.Builder().putInt(ChecklistLocationWork.CHECKLIST_ID, id).build();
                WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(ChecklistLocationWork.class).setInputData(data).build());
            }

            if (!TextUtils.isEmpty(lastSyncTime)) {
                for (String id : checklistIds.split(",")) {
                    ChecklistElementWork.fetchDetail(Integer.parseInt(id), getApplicationContext(),
                            ChecklistWork.this);
                }
            }
        }
    }
}
