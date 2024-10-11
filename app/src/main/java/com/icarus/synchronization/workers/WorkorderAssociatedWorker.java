package com.icarus.synchronization.workers;

import com.icarus.activities.DashboardActivity;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderElements;
import com.icarus.synchronization.syncmodels.WorkorderAttachment;
import com.icarus.synchronization.syncmodels.WorkorderElement;
import com.icarus.synchronization.syncmodels.WorkorderNote;
import com.icarus.synchronization.syncmodels.WorkorderNoteDetail;
import com.icarus.util.StringUtil;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import c.anurag.network.subscriber.AbstractNetworkObservable;

public class WorkorderAssociatedWorker extends CommonWorker {

    public WorkorderAssociatedWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Intent intent = new Intent(DashboardActivity.TAG);
        intent.putExtra(DashboardActivity.SYNC_PERCENTAGE, DashboardActivity.SYNC_WORKORDER_PERCENTAGE);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

        final AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        List<Integer> workorders = getSynchronizationDao.getLatestWorkorders();

        for (Integer id : workorders) {
            hitAPI(id);
        }
        return Result.success();
    }

    private void hitAPI(int workorderId) {

        RetroUtils.getRetrofitInstance(getApplicationContext(), WorkorderAssociatedWorker.this).create(WorkOrdersApi.class).workorderElementIndex(Constants.HEADER_ACCEPT, workorderId, "true")
                .subscribe(new AbstractNetworkObservable<RetrieveAllWorkorderElements>() {

                    @Override
                    public void success(RetrieveAllWorkorderElements retrieveAllWorkorderElements) {

                        final AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
                        if (retrieveAllWorkorderElements != null && retrieveAllWorkorderElements.getData() != null) {

                            WorkorderElement data = retrieveAllWorkorderElements.getData();

                            if (StringUtil.INSTANCE.listNotNull(data.getWorkorderAttachment())) {
                                for (WorkorderAttachment attachment : data.getWorkorderAttachment()) {
                                    getSynchronizationDao.insertWorkorderAttachment(ModelMapper.mapWorkOrderAttachment(attachment, data.getId(), data.getAuthorId()));
                                }
                            }

                            if (StringUtil.INSTANCE.listNotNull(data.getWorkorderNote())) {
                                for (WorkorderNote attachment : data.getWorkorderNote()) {
                                    getSynchronizationDao.insertWorkorderNote(ModelMapper.mapWorkOrderNote(attachment, data.getId(), data.getAuthorId()));

                                    for (WorkorderNoteDetail workorderNoteDetail : attachment.getWorkorderNoteDetail()) {
                                        getSynchronizationDao.insertWorkorderNoteDetail(ModelMapper.mapWorkOrderNoteDetail(workorderNoteDetail, attachment.getId()));
                                    }
                                }
                            }
                            getSynchronizationDao.updateWorkorderExecutionStatus(data.getId());
                        }
                    }

                    @Override
                    public void failure(Throwable error) {
                        Log.d(Parameters.TAG, error.getMessage());
                    }
                });
    }
}
