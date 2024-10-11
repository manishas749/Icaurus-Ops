package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedChecklistPauseTimesApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistPauseTimeRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistPauseTimesResponse;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedChecklistPauseTimes extends CommonWorker {
    private final Context mContext;
    public PostAssignedChecklistPauseTimes(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        List<AssignedCheckListPauseTimesEntity> list = postSynchronizationDao.getNonSyncedAssignedChecklistPauseTime();
        if (list.size() > 0) {

            AddUpdateAssignedChecklistPauseTimeRequest addUpdateAssignedChecklistPauseTimeRequest = new AddUpdateAssignedChecklistPauseTimeRequest();
            addUpdateAssignedChecklistPauseTimeRequest.setData(PostModelMapper.mapAssignedChecklistPauseTimes(list));

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedChecklistPauseTimesApi.class).assignedDecisionAdd(Constants.HEADER_ACCEPT, addUpdateAssignedChecklistPauseTimeRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedChecklistPauseTimesResponse>() {
                @Override
                public void success(AddUpdateAssignedChecklistPauseTimesResponse response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusPauseTime(response.getData().get(i).getUuid());
                                    postSynchronizationDao.updateAssignedChecklistPendingElementCount(response.getData().get(i).getAssignedChecklistUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertAssignedPauseTime(PostModelMapper.mapInsertAssignedPauseTimeEntity(response.getData().get(i)));
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
