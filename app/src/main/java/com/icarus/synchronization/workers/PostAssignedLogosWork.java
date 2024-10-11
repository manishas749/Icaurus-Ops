package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedLogosApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedLogoRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedLogosResponse;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedLogosWork extends CommonWorker {
    private final Context mContext;

    public PostAssignedLogosWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        final List<AssignedLogoEntity> nonSyncedAssignedLogo = postSynchronizationDao.getNonSyncedAssignedLogo();
        AddUpdateAssignedLogoRequest addUpdateAssignedLogoRequest = new AddUpdateAssignedLogoRequest();
        addUpdateAssignedLogoRequest.setData(PostModelMapper.mapAssignedLogo(nonSyncedAssignedLogo));
        if (addUpdateAssignedLogoRequest.getData().size() > 0) {

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedLogosApi.class).assignedLogoAdd(Constants.HEADER_ACCEPT, addUpdateAssignedLogoRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedLogosResponse>() {
                @Override
                public void success(AddUpdateAssignedLogosResponse response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusLogo(response.getData().get(i).getUuid());
                                    postSynchronizationDao.updateAssignedChecklistPendingElementCount(response.getData().get(i).getAssignedChecklistUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertAssignedLogoEntity(PostModelMapper.mapInsertAssignedLogoEntity(response.getData().get(i)));
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
