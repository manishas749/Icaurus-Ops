package com.icarus.synchronization.workers;

import com.icarus.R;
import com.icarus.activities.DashboardActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.util.NotificationUtil;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FailureWork extends Worker {
    private final Context mContext;

    /**
     * This work will be executed only case of successful syncing
     */
    public FailureWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
       // Log.e("Failure work", "Exception");
        //------------------ Saving Last Sync Time and Revision Number in the Datebase-/////////////
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        int result = postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_FAILED,
                BaseApplication.getPreferenceManager().getUserLocationId());

        WorkManager.getInstance(mContext).cancelAllWork();
        if (result <= 0) {
            //Broadcast is used for handling first time sync failure as no observer is called in initial sync failure
            Intent intent = new Intent(DashboardActivity.TAG);
            intent.putExtra(DashboardActivity.SYNC_FAILED, true);
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        }  //Do Nothing

        if (!NotificationUtil.isAppOnForeground(getApplicationContext())) {
            NotificationUtil.displayNotificationOne(getApplicationContext().getString(R.string.sync_failed), getApplicationContext());
        }

        return Result.success();
    }


}
