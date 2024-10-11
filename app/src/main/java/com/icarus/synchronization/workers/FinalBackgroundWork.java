package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;

import android.content.Context;
import androidx.annotation.NonNull;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FinalBackgroundWork extends Worker {

    /**
     * This work will be executed only case of successful syncing
     */
    public FinalBackgroundWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_COMPLETED, BaseApplication.getPreferenceManager().getUserLocationId());
        return Result.success();
    }


}
