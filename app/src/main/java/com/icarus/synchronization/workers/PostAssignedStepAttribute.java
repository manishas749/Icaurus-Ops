package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedStepAttributesApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepAttirbutes;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepAttirbutesResponse;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedStepAttribute extends CommonWorker {
    private final Context mContext;

    public PostAssignedStepAttribute(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext= context;
    }

    @NonNull
    @Override
    public ListenableWorker.Result doWork() {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        final List<AssignedStepAttributesEntity> stepAttributeList = postSynchronizationDao.getNonSyncedAssignedStepAttribute();

        if (stepAttributeList.size() > 0) {
            AddUpdateAssignedStepAttirbutes addUpdateAssignedStepsRequest = new AddUpdateAssignedStepAttirbutes();
            addUpdateAssignedStepsRequest.setData(PostModelMapper.mapAssignedStepAttribute(stepAttributeList));

            if (addUpdateAssignedStepsRequest.getData().size() > 0) {
                RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedStepAttributesApi.class).assignedStepAttributeAdd(Constants.HEADER_ACCEPT, addUpdateAssignedStepsRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedStepAttirbutesResponse>() {
                    @Override
                    public void success(AddUpdateAssignedStepAttirbutesResponse response) {
                        if (response.getData().size() > 0) {
                            for (int i = 0; i < response.getData().size(); i++) {
                                try {
                                    if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                            || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                        postSynchronizationDao.updateSyncStatusStepStepAttributes(response.getData().get(i).getUuid());
                                        postSynchronizationDao.updateAssignedChecklistPendingElementCount(response.getData().get(i).getAssignedChecklistUuid());
                                    } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                        getSynchronizationDao.insertAssignedStepAttribute(PostModelMapper.mapInsertAssignedStepAttributeEntity(response.getData().get(i)));
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
        }

        return ListenableWorker.Result.success();
    }
}
