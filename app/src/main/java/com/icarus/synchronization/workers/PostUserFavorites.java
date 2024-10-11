package com.icarus.synchronization.workers;

import com.icarus.activities.DashboardActivity;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.UserFavoritesApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserFavoritesRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserFavoritesResponse;

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

public class PostUserFavorites extends CommonWorker {
    private final Context mContext;

    public PostUserFavorites(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Intent intent = new Intent(DashboardActivity.TAG);
        intent.putExtra(DashboardActivity.SYNC_PERCENTAGE, DashboardActivity.SYNC_POST_PERCENTAGE);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        List<UserFavouritesEntity> list = postSynchronizationDao.getNonSyncedUserFavorites();
        if (list.size() > 0) {

            AddUpdateUserFavoritesRequest addUpdateUserFavoritesRequest = new AddUpdateUserFavoritesRequest();
            addUpdateUserFavoritesRequest.setData(PostModelMapper.mapuserFavoritesAction(list));

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(UserFavoritesApi.class).addUpdateUserFavorite(Constants.HEADER_ACCEPT, addUpdateUserFavoritesRequest).subscribe(new AbstractNetworkObservable<AddUpdateUserFavoritesResponse>() {
                @Override
                public void success(AddUpdateUserFavoritesResponse response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusUserFavorite(response.getData().get(i).getUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertUserFavouriteEntity(PostModelMapper.mapInsertUserFavourite(response.getData().get(i)));
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
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
        return Result.success();
    }
}
