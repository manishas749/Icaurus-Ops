package com.icarus.synchronization.workers;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.UserFavoritesApi;
import com.icarus.synchronization.syncmodels.RetrieveUsersFavourites;
import com.icarus.util.DateUtility;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import c.anurag.network.subscriber.AbstractNetworkObservable;

public class UserFavouriteWork extends CommonWorker {
private final Context mContext;

    public UserFavouriteWork(@NonNull Context context, @NonNull WorkerParameters params) {
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
        RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(UserFavoritesApi.class).userFavoriteIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo, BaseApplication.getPreferenceManager().getLastActivityAfter(), BaseApplication.getPreferenceManager().getLastActivityBefore(), BaseApplication.getPreferenceManager().getRevisionNumber()).subscribe(new AbstractNetworkObservable<RetrieveUsersFavourites>() {
            @Override
            public void success(RetrieveUsersFavourites retrieveUsersFavourites) {
                if (retrieveUsersFavourites != null && retrieveUsersFavourites.getData() != null && retrieveUsersFavourites.getData().size() > 0) {
                    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                    GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
                    for (int i = 0; i < retrieveUsersFavourites.getData().size(); i++) {
                        try {
                            RetrieveUsersFavourites.Datum favourite = retrieveUsersFavourites.getData().get(i);
                            UserFavouritesEntity favouriteExistLocally = getSynchronizationDao.ifUserFavoriteExists(favourite.getChecklistId(), favourite.getUserId());
                            UserFavouritesEntity userFavouritesEntity = ModelMapper.mapUserFavourite(favourite);
                            if (favouriteExistLocally != null) {
                                if (DateUtility.isLatestData(userFavouritesEntity.getModified(), favouriteExistLocally.getModified())) {
                                    userFavouritesEntity.setUuid(favouriteExistLocally.getUuid());
                                    getSynchronizationDao.insertUserFavouriteEntity(userFavouritesEntity);
                                }
                            } else {
                                getSynchronizationDao.insertUserFavouriteEntity(userFavouritesEntity);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
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
