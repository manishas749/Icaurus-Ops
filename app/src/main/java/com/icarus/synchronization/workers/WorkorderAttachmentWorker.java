package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderAttachments;

import android.content.Context;
import androidx.annotation.NonNull;

import androidx.work.WorkerParameters;
import c.anurag.network.subscriber.AbstractNetworkObservable;

public class WorkorderAttachmentWorker extends CommonWorker {

    public WorkorderAttachmentWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {

        Integer pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 1);
        for (int i = 0; i < pageCount; i++)
            hitAPI(i + 1);

        return Result.success();
    }

    private void hitAPI(int pageNumber) {
        RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(WorkOrdersApi.class).workorderAttachmentIndex(Constants.HEADER_ACCEPT,
                Parameters.PAGE_SIZE, pageNumber, BaseApplication.getPreferenceManager().getLastActivityAfter(),
                BaseApplication.getPreferenceManager().getLastActivityBefore(),  BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getRevisionNumber())
                .subscribe(new AbstractNetworkObservable<RetrieveAllWorkorderAttachments>() {

                    @Override
                    public void success(RetrieveAllWorkorderAttachments retrieveAllWorkorders) {
                        if (retrieveAllWorkorders != null && retrieveAllWorkorders.getData() != null && retrieveAllWorkorders.getData().size() > 0) {
                            AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                            GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

                            for (int i = 0; i < retrieveAllWorkorders.getData().size(); i++) {
                                //getSynchronizationDao.insertWorkorderAttachment(ModelMapper.mapWorkOrderAttachment(retrieveAllWorkorders.getData().get(i)));
                            }
                        }
                    }

                    @Override
                    public void failure(Throwable error) {

                        // WorkManager.getInstance().cancelAllWork();
                    }
                });
    }
}
