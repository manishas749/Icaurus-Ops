package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.MainUserDao;
import com.icarus.database.AppDatabase;
import com.icarus.database.UserDatabase;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.UsersApi;
import com.icarus.synchronization.syncmodels.RetrieveUsers;

import android.content.Context;

import androidx.annotation.NonNull;

import android.util.Log;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class UserWorker extends CommonWorker {
    private final Context mContext;

    public UserWorker(@NonNull Context context, @NonNull WorkerParameters params) {
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

    private void hitAPI(Integer pageNo) {
        RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(UsersApi.class).userIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo, BaseApplication.getPreferenceManager().getLastActivityAfter(), BaseApplication.getPreferenceManager().getLastActivityBefore(), BaseApplication.getPreferenceManager().getRevisionNumber()).subscribe(new AbstractNetworkObservable<RetrieveUsers>() {
            @Override
            public void success(RetrieveUsers retrieveUsers) {
                if (retrieveUsers != null && retrieveUsers.getData() != null && retrieveUsers.getData().size() > 0) {
                    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                    UserDatabase userDatabase = UserDatabase.getInstance(getApplicationContext());
                    GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
                    final MainUserDao mainUserDao = userDatabase.userDao();
                    for (int i = 0; i < retrieveUsers.getData().size(); i++) {
                        userDatabase.userDao().insertUser(ModelMapper.mapLoginUserEntity(retrieveUsers.getData().get(i), userDatabase.userDao().isTermsAccepted(retrieveUsers.getData().get(i).getId())));
                        getSynchronizationDao.insertUserEntity(ModelMapper.mapUserEntity(retrieveUsers.getData().get(i)));
                        for (int j = 0; j < retrieveUsers.getData().get(i).getUserLocationDepartments().size(); j++) {
                            getSynchronizationDao.insertUserDepartments(ModelMapper.mapUserLocationDepartment(retrieveUsers.getData().get(i).getUserLocationDepartments().get(j), retrieveUsers.getData().get(i)));
                        }
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
