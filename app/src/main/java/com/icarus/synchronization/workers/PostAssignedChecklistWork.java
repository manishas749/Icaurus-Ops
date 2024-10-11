package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedChecklistsApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistsRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistsResponse;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedChecklistWork extends CommonWorker {
    private final Context mContext;
    public PostAssignedChecklistWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        final List<AssignCheckListEntity> getNonSyncedChecklists = postSynchronizationDao.getNonSyncedAssignedChecklist();

        if (getNonSyncedChecklists.size() > 0) {
            final AddUpdateAssignedChecklistsRequest addUpdateAssignedChecklistsRequest = new AddUpdateAssignedChecklistsRequest();
            addUpdateAssignedChecklistsRequest.setData(PostModelMapper.mapAssignedChecklist(getNonSyncedChecklists));

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedChecklistsApi.class).assignedChecklistAdd(Constants.HEADER_ACCEPT, addUpdateAssignedChecklistsRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedChecklistsResponse>() {


                @Override
                public void success(AddUpdateAssignedChecklistsResponse response) {

                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusAssignedCheclist(response.getData().get(i).getUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    AssignCheckListEntity checkListEntity = getSynchronizationDao.getAssignedChecklist(response.getData().get(i).getUuid());
                                    getSynchronizationDao.insertAssignedChecklists(PostModelMapper.mapInsertAssignedChecklistEntity(response.getData().get(i),
                                            checkListEntity));
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
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
        return Result.success();
    }
}
