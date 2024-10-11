package com.icarus.synchronization.workers;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.util.NotificationUtil;

import android.content.Context;

import androidx.annotation.NonNull;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FinalWork extends Worker {
    private final Context mContext;

    /**
     * This work will be executed only case of successful syncing
     */
    public FinalWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {


        //------------------ Saving Last Sync Time and Revision Number in the Datebase-/////////////
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

        if (!NotificationUtil.isAppOnForeground(getApplicationContext())) {
            NotificationUtil.displayNotificationOne(getApplicationContext().getString(R.string.sync_successful), getApplicationContext());
        }
        String lastSyncTime = postSynchronizationDao.getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());
        //WorkManager.getInstance().enqueue(new OneTimeWorkRequest.Builder(DownloadPepsHazardsWork.class).build());

        postSynchronizationDao.updateSyncTime(BaseApplication.getPreferenceManager().getLastActivityBefore(), BaseApplication.getPreferenceManager().getUserLocationId());
        postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_RESOURCE_DOWNLOAD_UPLOAD, BaseApplication.getPreferenceManager().getUserLocationId());

        if (BaseApplication.getPreferenceManager().getTempRevisionNumber() > 0)
            BaseApplication.getPreferenceManager().setRevisionNumber(BaseApplication.getPreferenceManager().getTempRevisionNumber());

        //WorkManager.getInstance().enqueue(new OneTimeWorkRequest.Builder(DownloadMediaWork.class).build());
        //WorkManager.getInstance().enqueue(new OneTimeWorkRequest.Builder(UploadMediaWork.class).build());

        OneTimeWorkRequest ppeDownload = new OneTimeWorkRequest.Builder(DownloadPepsHazardsWork.class).build();
        OneTimeWorkRequest downloadResources = new OneTimeWorkRequest.Builder(DownloadMediaWork.class).build();
        OneTimeWorkRequest uploadResources = new OneTimeWorkRequest.Builder(UploadMediaWork.class).build();
        OneTimeWorkRequest finalDownload = new OneTimeWorkRequest.Builder(FinalBackgroundWork.class).build();
        WorkManager.getInstance(mContext).beginWith(ppeDownload)
                .then(downloadResources)
                .then(uploadResources)
                .then(finalDownload).enqueue();

        return Result.success();
    }


}
