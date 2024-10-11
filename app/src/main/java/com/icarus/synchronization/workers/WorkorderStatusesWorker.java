package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderStatuses;

import android.content.Context;

import androidx.annotation.NonNull;

import android.util.Log;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class WorkorderStatusesWorker extends CommonWorker {
    private final Context mContext;

    public WorkorderStatusesWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        Integer pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 1);
        for (int i = 0; i < pageCount; i++)
            hitAPI(i + 1);


        return Result.success();
    }

    private void hitAPI(int pageNo) {
        RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(WorkOrdersApi.class).workorderStatusIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo, BaseApplication.getPreferenceManager().getLastActivityAfter(), BaseApplication.getPreferenceManager().getLastActivityBefore(), BaseApplication.getPreferenceManager().getRevisionNumber()).subscribe(new AbstractNetworkObservable<RetrieveAllWorkorderStatuses>() {

            @Override
            public void success(RetrieveAllWorkorderStatuses retrieveAllWorkorderStatuses) {
                if (retrieveAllWorkorderStatuses != null && retrieveAllWorkorderStatuses.getData() != null && retrieveAllWorkorderStatuses.getData().size() > 0) {
                    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                    GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

                    for (int i = 0; i < retrieveAllWorkorderStatuses.getData().size(); i++) {
                        getSynchronizationDao.insertWorkorderStatus(ModelMapper.mapWorkorderStatusEntity(retrieveAllWorkorderStatuses.getData().get(i)));
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
