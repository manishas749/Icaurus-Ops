package com.icarus.synchronization.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.enums.Operation;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.synchronization.postsyncmodel.WorkorderAttachment;
import com.icarus.synchronization.postsyncmodel.WorkorderNote;
import com.icarus.synchronization.postsyncmodel.WorkorderNoteDetail;
import com.icarus.synchronization.postsyncmodel.WorkorderObject;
import com.icarus.synchronization.postsyncmodel.WorkorderPostRequest;
import com.icarus.synchronization.postsyncmodel.WorkorderPostResponse;
import com.icarus.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class PostWorkordersWork extends CommonWorker {
    private final Context mContext;

    public PostWorkordersWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        final AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        final List<WorkOrderEntity> workOrderEntities = postSynchronizationDao.getNonSyncedWorkOrders(
                BaseApplication.getPreferenceManager().getUserLocationId());
        WorkorderPostRequest workorderPostRequest = new WorkorderPostRequest();

        List<WorkorderObject> workOrderObjectList = new ArrayList<>();
        for (int i = 0; i < workOrderEntities.size(); i++) {

            final List<WorkOrderNotesEntity> workOrderNotesEntities = postSynchronizationDao
                    .getNonSyncedWorkOrdersNotes(workOrderEntities.get(i).getId());
            final List<WorkOrderAttachmentsEntity> workOrderAttachmentsEntities =
                    postSynchronizationDao.getNonSyncedWorkOrdersAttachments(workOrderEntities.get(i).getId());

            WorkorderObject workOrder = ModelMapper.mapWorkOrderPost(workOrderEntities.get(i),
                    workOrderAttachmentsEntities, workOrderNotesEntities, getApplicationContext());

            workOrderObjectList.add(workOrder);

        }
        workorderPostRequest.setData(workOrderObjectList);

        if (StringUtil.INSTANCE.listNotNull(workorderPostRequest.getData())) {
            RetroUtils.getRetrofitInstance(getApplicationContext(), this)
                    .create(WorkOrdersApi.class)
                    .addUpdateWorkorder(Constants.HEADER_ACCEPT, workorderPostRequest)
                    .subscribe(new AbstractNetworkObservable<WorkorderPostResponse>() {
                @Override
                public void success(WorkorderPostResponse workorderPostResponse) {
                    if (workorderPostResponse == null) {
                        return;
                    }

                    List<WorkorderObject> objects = workorderPostResponse.getData();

                    if (objects.isEmpty()) {
                        return;
                    }

                    // List of operations we need to consider for making changes to the local
                    // database.
                    List<String> operations = Arrays.asList(
                            Operation.INSERT.getValue(),
                            Operation.UPDATE.getValue(),
                            Operation.CHANGE.getValue()
                    );

                    for (WorkorderObject object : objects) {
                        try {
                           String operation = object.getOperation();

                            if (operation == null || ! operations.contains(operation)) {
                                continue;
                            }

                            WorkOrderEntity workOrderEntity = ModelMapper.mapWorkOrderEntity(
                                    object,
                                    Constants.EXECUTION_STATUS_SYNC_TO_SERVER
                            );

                            List<WorkOrderAttachmentsEntity> workOrderAttachmentEntities = new ArrayList<>();
                            List<WorkOrderNotesEntity> workOrderNoteEntities = new ArrayList<>();
                            List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntities = new ArrayList<>();

                            if (StringUtil.INSTANCE.listNotNull(object.getWorkorderNote())) {
                                for (WorkorderNote workorderNote : object.getWorkorderNote()) {
                                    workOrderNoteEntities.add(ModelMapper.mapWorkOrderNotePost(
                                            workorderNote, object.getId(), object.getAuthorId()
                                    ));

                                    for (WorkorderNoteDetail workorderNoteDetail : workorderNote.getWorkorderNoteDetail()) {
                                        workOrderNoteDetailEntities.add(
                                                ModelMapper.mapWorkOrderNoteDetailPost(
                                                        workorderNoteDetail, workorderNote.getId()
                                                )
                                        );
                                    }
                                }
                            }

                            if (StringUtil.INSTANCE.listNotNull(object.getWorkorderAttachment())) {
                                for (WorkorderAttachment attachment : object.getWorkorderAttachment()) {
                                    workOrderAttachmentEntities.add(
                                            ModelMapper.mapWorkOrderAttachmentPost(
                                                    attachment, object.getId(), object.getAuthorId()
                                            )
                                    );
                                }
                            }

                            getSynchronizationDao.saveWorkOrder(
                                    workOrderEntity,
                                    workOrderNoteEntities,
                                    workOrderNoteDetailEntities,
                                    workOrderAttachmentEntities
                            );
                        } catch (Exception e) {
                            Log.e("SYNCHRONIZATION", e.getMessage());
                        }

                    }
                }

                @Override
                public void failure(Throwable error) {
                    Log.d(Parameters.TAG, error.getMessage());
                    WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(
                            FailureWork.class).setConstraints(Utils.getConstraints()).build());
                }
            });
        }

        return Result.success();
    }
}
