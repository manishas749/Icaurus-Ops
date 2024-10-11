package com.icarus.synchronization.workers;

import android.content.Context;

import androidx.annotation.NonNull;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.util.NotificationUtil;

import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UnAuthorizedWork extends Worker {
    private final Context mContext;

    /**
     * This work will be executed only case of un authorized syncing
     *
     * @param context
     * @param params
     */
    public UnAuthorizedWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        //------------------ Saving Last Sync Time and Revision Number in the Datebase-/////////////
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        int result = postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_UNAUTHORIZED,
                BaseApplication.getPreferenceManager().getUserLocationId());

        if (result > 0)
            WorkManager.getInstance(mContext).cancelAllWork();

        if (!NotificationUtil.isAppOnForeground(getApplicationContext())) {
            NotificationUtil.displayNotificationOne(getApplicationContext().getString(R.string.unauthorized), getApplicationContext());
        }

        return Result.success();
    }


}
