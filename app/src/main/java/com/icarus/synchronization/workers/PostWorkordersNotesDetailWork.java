package com.icarus.synchronization.workers;

import android.content.Context;
import androidx.annotation.NonNull;

import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class PostWorkordersNotesDetailWork extends Worker {

    public PostWorkordersNotesDetailWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        return Result.success();
    }
}
