package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.UserSuggestionAttachmentsEntity;
import com.icarus.entities.UserSuggestionEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.SuggestionsApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsAttachmentresponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsAttachmentsrequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsrequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsresponse;
import com.icarus.synchronization.postsyncmodel.UserSuggestion;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostUserSuggestionWork extends CommonWorker {
    private final Context mContext;

    public PostUserSuggestionWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

        final List<UserSuggestionEntity> entities = postSynchronizationDao.getNonSyncedUserSuggestion();
        AddUpdateUserSuggestionsrequest request = PostModelMapper.mapUserSuggestionAction(entities);

        if (request.getData().size() > 0) {
            RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                    .create(SuggestionsApi.class)
                    .userSuggestionAdd(Constants.HEADER_ACCEPT, request)
                    .subscribe(new AbstractNetworkObservable<AddUpdateUserSuggestionsresponse>() {
                        @Override
                        public void success(AddUpdateUserSuggestionsresponse response) {
                            if (response == null) {
                                return;
                            }

                            if (response.getData() == null) {
                                return;
                            }

                            List<UserSuggestion> objects = response.getData();

                            for (UserSuggestion object : objects) {
                                String operation = object.getOperation();
                                String uuid = object.getUuid();

                                if (operation == null) {
                                    continue;
                                }

                                try {
                                    if (operation.equalsIgnoreCase(Operation.INSERT.getValue())
                                            || operation.equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                        postSynchronizationDao.updateSyncStatusUserSuggestion(uuid);
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void failure(Throwable error) {

                        }
                    });
        }

        final List<UserSuggestionAttachmentsEntity> userSuggestionAttachmentsEntities = postSynchronizationDao.getNonSyncedUserSuggestionAttachments();

        AddUpdateUserSuggestionsAttachmentsrequest addUpdateUserSuggestionsAttachmentsrequest = new AddUpdateUserSuggestionsAttachmentsrequest();
        addUpdateUserSuggestionsAttachmentsrequest.setData(PostModelMapper.mapuserSuggestionAttachment(userSuggestionAttachmentsEntities));

        if (addUpdateUserSuggestionsAttachmentsrequest.getData().size() > 0) {

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(SuggestionsApi.class).userSuggestionAttachmentAdd(Constants.HEADER_ACCEPT, addUpdateUserSuggestionsAttachmentsrequest).subscribe(new AbstractNetworkObservable<AddUpdateUserSuggestionsAttachmentresponse>() {
                @Override
                public void success(AddUpdateUserSuggestionsAttachmentresponse addUpdateUserSuggestionsAttachmentresponse) {
                    if (addUpdateUserSuggestionsAttachmentresponse.getData().size() > 0) {
                        for (int i = 0; i < addUpdateUserSuggestionsAttachmentresponse.getData().size(); i++) {
                            try {
                                if (addUpdateUserSuggestionsAttachmentresponse.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || addUpdateUserSuggestionsAttachmentresponse.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusUserSuggestionAttachment(addUpdateUserSuggestionsAttachmentresponse.getData().get(i).getUuid());
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
