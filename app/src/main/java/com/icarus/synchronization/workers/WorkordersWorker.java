package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.synchronization.postsyncmodel.WorkorderObject;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorders;
import com.icarus.util.DateUtility;

import android.content.Context;

import androidx.annotation.NonNull;

import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class WorkordersWorker extends CommonWorker {
    private final Context mContext;

    public WorkordersWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        int pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 0);

        for (int i = 0; i < pageCount; i++) {
            hitAPI(i + 1);
        }

        return Result.success();
    }

    private void hitAPI(int pageNumber) {
        RetroUtils
                .getRetrofitInstance(getApplicationContext(), this)
                .create(WorkOrdersApi.class)
                .workorderIndex(
                        Constants.HEADER_ACCEPT,
                        Parameters.PAGE_SIZE,
                        pageNumber,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        BaseApplication.getPreferenceManager().getUserLocationId(),
                        BaseApplication.getPreferenceManager().getRevisionNumber()
                )
                .subscribe(new AbstractNetworkObservable<RetrieveAllWorkorders>() {
                    @Override
                    public void success(RetrieveAllWorkorders retrieveAllWorkorders) {
                        if (retrieveAllWorkorders != null
                                && retrieveAllWorkorders.getData() != null
                                && retrieveAllWorkorders.getData().size() > 0) {
                            final AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                            final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

                            List<WorkorderObject> workOrders = retrieveAllWorkorders.getData();

                            for (WorkorderObject workOrder : workOrders) {
                                WorkOrderEntity oldWorkOrder = getSynchronizationDao.ifWorkOrderExists(workOrder.getId());
                                WorkOrderEntity newWorkOrder = ModelMapper.mapWorkOrderEntity(
                                        workOrder,
                                        Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER
                                );

                                if (oldWorkOrder == null) {
                                    getSynchronizationDao.insertWorkorder(newWorkOrder);
                                } else {
                                    //newWorkOrder.setSyncStatus(oldWorkOrder.getSyncStatus());
                                    // If there is an existing work order, then if the local record
                                    // is older than the one received from the server, we will
                                    // save the new record received else we only need to update
                                    // the execution status of the local order in order to ensure
                                    // associated data is fetched.
                                    if (DateUtility.isLatestData(newWorkOrder.getModified(), oldWorkOrder.getModified())) {
                                        getSynchronizationDao.insertWorkorder(newWorkOrder);
                                    } else {
                                        oldWorkOrder.setExecutionStatus(Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER);
                                        getSynchronizationDao.insertWorkorder(oldWorkOrder);
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.d(Parameters.TAG, error.getMessage());
                        WorkManager.getInstance(mContext)
                                .enqueue(
                                        new OneTimeWorkRequest.Builder(FailureWork.class)
                                                .setConstraints(Utils.getConstraints())
                                                .build()
                                );
                    }
                });
    }
}
