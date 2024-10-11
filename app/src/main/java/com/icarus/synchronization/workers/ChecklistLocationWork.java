package com.icarus.synchronization.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.ChecklistApi;
import com.icarus.synchronization.syncmodels.ChecklistLocationObject;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class ChecklistLocationWork extends CommonWorker {

    private Integer pageNumber = 1;
    public static String CHECKLIST_ID = "CHECKLIST_ID";
    private final Context mContext;

    public ChecklistLocationWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Integer checklistId = getInputData().getInt(CHECKLIST_ID, 0);
        hitAPI(pageNumber, checklistId);
        return Result.success();
    }

    private synchronized void hitAPI(Integer pageNo, final Integer checklistId) {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

        RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                .create(ChecklistApi.class)
                .checklistLocationIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        "checklist_room_equipments", BaseApplication.getPreferenceManager().getRevisionNumber(),
                        checklistId).subscribe(new AbstractNetworkObservable<ChecklistLocationObject>() {
            @Override
            public void success(ChecklistLocationObject checklistLocationObject) {
                if (checklistLocationObject != null && checklistLocationObject.getData() != null && checklistLocationObject.getData().size() > 0) {


                    for (int i = 0; i < checklistLocationObject.getData().size(); i++) {
                        try {
                            getSynchronizationDao.insertChecklistLocation(ModelMapper.mapChecklistLocationEntity(checklistLocationObject.getData().get(i)));
                            getSynchronizationDao.insertChecklistRoomEquipments(ModelMapper.mapRoomEquipment(checklistLocationObject.getData().get(i).getChecklistRoomEquipments()));
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d(Parameters.TAG, checklistLocationObject.getData().get(i).getChecklistId() + " " + checklistLocationObject.getData().get(i).getId());
                        }
                    }

                    if ((checklistLocationObject.getPagination().getNextUrl() != null)) {
                        hitAPI(++pageNumber, checklistId);
                    }

                }
            }

            @Override
            public void failure(Throwable error) {
                Log.d(Parameters.TAG, error.getMessage());
                WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
            }
        });
    }

}
