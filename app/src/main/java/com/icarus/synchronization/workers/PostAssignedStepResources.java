package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedStepResourcesApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepResourcesRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepsResourceResponse;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedStepResources extends CommonWorker {
    private final Context mContext;

    public PostAssignedStepResources(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

        AddUpdateAssignedStepResourcesRequest addUpdateAssignedStepResourcesRequest = new AddUpdateAssignedStepResourcesRequest();
        addUpdateAssignedStepResourcesRequest.setData(PostModelMapper.mapAssignedStepResources(
                postSynchronizationDao.getNonSyncedAssignedStepResources()));
        if (addUpdateAssignedStepResourcesRequest.getData().size() > 0) {

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedStepResourcesApi.class).assignedStepResourceAdd(Constants.HEADER_ACCEPT, addUpdateAssignedStepResourcesRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedStepsResourceResponse>() {
                @Override
                public void success(AddUpdateAssignedStepsResourceResponse response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusStepResources(response.getData().get(i).getUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertAssignedStepResources(PostModelMapper.mapInsertAssignedStepResourcesEntity(response.getData().get(i)));
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
