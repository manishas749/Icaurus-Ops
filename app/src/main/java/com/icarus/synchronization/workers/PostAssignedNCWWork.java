package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.Operation;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.PostModelMapper;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedNCWApi;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedCaution;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedCautionsRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedNotesRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedNotesResponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedWarningResponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedWarningsRequest;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostAssignedNCWWork extends CommonWorker {
    private final Context mContext;

    public PostAssignedNCWWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        final List<AssignedNCWEntity> mNoteList = postSynchronizationDao.getNonSyncedAssignedNCW(ChecklistElementType.NOTE.getValue());
        final List<AssignedNCWEntity> mCautionList = postSynchronizationDao.getNonSyncedAssignedNCW(ChecklistElementType.CAUTION.getValue());
        final List<AssignedNCWEntity> mWarningList = postSynchronizationDao.getNonSyncedAssignedNCW(ChecklistElementType.WARNING.getValue());

        AddUpdateAssignedNotesRequest addUpdateAssignedNotesRequest = new AddUpdateAssignedNotesRequest();
        addUpdateAssignedNotesRequest.setData(PostModelMapper.mapAssignedNotes(mNoteList));

        AddUpdateAssignedCautionsRequest addUpdateAssignedCautionsRequest = new AddUpdateAssignedCautionsRequest();
        addUpdateAssignedCautionsRequest.setData(PostModelMapper.mapAssignedCausion(mCautionList));

        AddUpdateAssignedWarningsRequest addUpdateAssignedWarningsRequest = new AddUpdateAssignedWarningsRequest();
        addUpdateAssignedWarningsRequest.setData(PostModelMapper.mapAssignedWarning(mWarningList));

        if (addUpdateAssignedNotesRequest.getData().size() > 0) {

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedNCWApi.class).assignedNoteAdd(Constants.HEADER_ACCEPT, addUpdateAssignedNotesRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedNotesResponse>() {
                @Override
                public void success(AddUpdateAssignedNotesResponse response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusNCW(response.getData().get(i).getUuid());
                                    postSynchronizationDao.updateAssignedChecklistPendingElementCount(response.getData().get(i).getAssignedChecklistUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertAssignedNCW(PostModelMapper.mapInsertAssignedNotesEntity(response.getData().get(i)));
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

        if (addUpdateAssignedCautionsRequest.getData().size() > 0) {

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedNCWApi.class).assignedCautionAdd(Constants.HEADER_ACCEPT, addUpdateAssignedCautionsRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedCaution>() {
                @Override
                public void success(AddUpdateAssignedCaution response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusNCW(response.getData().get(i).getUuid());
                                    postSynchronizationDao.updateAssignedChecklistPendingElementCount(response.getData().get(i).getAssignedChecklistUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertAssignedNCW(PostModelMapper.mapInsertAssignedCautionEntity(response.getData().get(i)));
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
        if (addUpdateAssignedWarningsRequest.getData().size() > 0) {

            RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedNCWApi.class).assignedWarningAdd(Constants.HEADER_ACCEPT, addUpdateAssignedWarningsRequest).subscribe(new AbstractNetworkObservable<AddUpdateAssignedWarningResponse>() {
                @Override
                public void success(AddUpdateAssignedWarningResponse response) {
                    if (response.getData().size() > 0) {
                        for (int i = 0; i < response.getData().size(); i++) {
                            try {
                                if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.INSERT.getValue())
                                        || response.getData().get(i).getOperation().equalsIgnoreCase(Operation.UPDATE.getValue())) {
                                    postSynchronizationDao.updateSyncStatusNCW(response.getData().get(i).getUuid());
                                    postSynchronizationDao.updateAssignedChecklistPendingElementCount(response.getData().get(i).getAssignedChecklistUuid());
                                } else if (response.getData().get(i).getOperation().equalsIgnoreCase(Operation.CHANGE.getValue())) {
                                    getSynchronizationDao.insertAssignedNCW(PostModelMapper.mapInsertAssignedWarningEntity(response.getData().get(i)));
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
