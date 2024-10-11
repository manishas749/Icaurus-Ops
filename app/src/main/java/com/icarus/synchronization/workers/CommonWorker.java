package com.icarus.synchronization.workers;

import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.Utils;

import android.content.Context;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Created by Anurag Purwar on 5/6/19.
 */
public abstract class CommonWorker extends Worker implements InternetConnectionListener {
    private final Context mContext;

    public CommonWorker(Context context, WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @Override
    public void onInternetUnavailable() {
        WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
    }
}
