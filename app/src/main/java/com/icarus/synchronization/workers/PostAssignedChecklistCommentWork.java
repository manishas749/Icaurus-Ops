package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedChecklistCommentApi;
import com.icarus.synchronization.postsyncmodel.AddANdUpdateAssignedChecklistCommentObject;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistCommentRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistCommentResponse;

import android.content.Context;

import androidx.annotation.NonNull;

import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedChecklistCommentWork extends CommonWorker {
    private final Context mContext;

    public PostAssignedChecklistCommentWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());

        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();

        final List<AssignedChecklistCommentsEntity> entities = postSynchronizationDao.getNonSyncedAssignedComment();
        AddUpdateAssignedChecklistCommentRequest request = PostModelMapper.mapAssignedChecklistComment(entities);

        if (request.getData().size() > 0) {
            RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                    .create(AssignedChecklistCommentApi.class)
                    .assignedChecklistCommentAdd(Constants.HEADER_ACCEPT, request)
                    .subscribe(new AbstractNetworkObservable<AddUpdateAssignedChecklistCommentResponse>() {
                        @Override
                        public void success(AddUpdateAssignedChecklistCommentResponse response) {
                            if (response == null) {
                                return;
                            }

                            if (response.getData() == null) {
                                return;
                            }


                            List<AddANdUpdateAssignedChecklistCommentObject> objects = response.getData();

                            for (AddANdUpdateAssignedChecklistCommentObject object : objects) {
                                String operation = object.getOperation();
                                String uuid = object.getUuid();
                                String assignedChecklistUuid = object.getAssignedChecklistUuid();

                                if (operation == null) {
                                    continue;
                                }
                                try {
                                    if (operation.equalsIgnoreCase(Operation.INSERT.getValue())
                                            || operation.equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                        postSynchronizationDao.updateSyncStatusAssignedChecklistComment(uuid);
                                        postSynchronizationDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);
                                        continue;
                                    }

                                    if (operation.equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                        getSynchronizationDao.insertAssigneComments(PostModelMapper.mapAssignedChecklistCommentEntity(object));
                                        postSynchronizationDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
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
