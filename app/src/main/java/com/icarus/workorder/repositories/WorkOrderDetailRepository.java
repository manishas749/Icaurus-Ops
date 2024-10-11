package com.icarus.workorder.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.database.AppDatabase;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.WorkOrdersApi;
import com.icarus.util.AppUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.Utilities;
import com.icarus.workorder.dao.WorkOrderCommonDao;
import com.icarus.workorder.dao.WorkOrderDetailDao;
import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.models.WorkOrderDetailItems;
import com.icarus.workorder.models.WorkOrderNoteDetailItems;
import com.icarus.workorder.models.WorkOrderNoteInfoItems;

import java.io.File;
import java.io.IOException;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Anurag Purwar on 30/1/19.
 */

public class WorkOrderDetailRepository {
    private Application application;

    public WorkOrderDetailRepository(Application application) {
        this.application = application;
    }

    public LiveData<WorkOrderDetailItems> getInfo(String workOrderUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDao = appDatabase.workOrderDetailDao();
        return workOrderDao.getWorkOrderInfo(workOrderUuid);
    }

    public LiveData<List<WorkOrderNoteInfoItems>> getWorkOrderNoteInfo(int workOrderId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        return workOrderDetailDao.getWorkOrderNoteInfo(workOrderId);
    }

    public LiveData<List<WorkOrderNoteDetailItems>> getWorkOrderNoteDetail(Integer[] noteId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        return workOrderDetailDao.getWorkOrderNoteDetail(noteId);
    }

    public LiveData<List<WorkOrderAttachmentItems>> getWorkOrderAttachment(int workOrderId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        return workOrderDetailDao.getWorkOrderAttachments(workOrderId);
    }

    public String getStatus(int statusId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        return workOrderDetailDao.getStatus(statusId);
    }

    public List<Integer> getDepartmentList(int locationID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        return workOrderDetailDao.getDepartmentList(locationID);
    }

    public List<Integer> getDepartmentList(int locationID, int userID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        return workOrderDetailDao.getDepartmentList(userID, locationID);
    }

    public void inProgressAction(WorkOrderDetailItems workOrderDetailItems, String statusName) {
        String currentTime = AppUtility.Companion.getUtcTime();
        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderCommonDao workOrderDao = appDatabase.workOrderCommonDao();
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        // Default is SET to 1 as most of the clients has QCM as Department ID = 1
        int departmentId = 1;
        boolean isAssignToDepartment = false;
        if (workOrderDetailItems.getAssignedToType() == 2) {
            departmentId = workOrderDao.getQcmId();
            if (workOrderDetailItems.getAssignedToDepartmentId() == departmentId)
                isAssignToDepartment = true;
        }
        if (isAssignToDepartment) {
            workOrderDetailDao.updateWorkOrder(currentTime, 2, workOrderDetailItems.getUuid(), userId);
        } else {
            workOrderDetailDao.updateWorkOrder(currentTime, 2, workOrderDetailItems.getUuid());
        }

        Integer workOrderNoteId = Utilities.getNegativeId(workOrderDetailDao.getWorkOrderNoteId());

        WorkOrderNotesEntity workOrderNotesEntity = new WorkOrderNotesEntity(workOrderNoteId, AppUtility.Companion.getUuid(), workOrderDetailItems.getId(), userId, "", currentTime, currentTime);
        workOrderDetailDao.insertNotes(workOrderNotesEntity);

        Integer workOrderNoteDetailId = Utilities.getNegativeId(workOrderDetailDao.getWorkOrderNoteDetailId());

        WorkOrderNoteDetailEntity workOrderNoteDetailEntity = new WorkOrderNoteDetailEntity(workOrderNoteDetailId, AppUtility.Companion.getUuid(), workOrderNoteId,
                "workorder", "workorder_status_id", workOrderDetailItems.getWorkorderStatusName(), statusName, currentTime, currentTime);
        workOrderDetailDao.insertNoteDetails(workOrderNoteDetailEntity);

        if (isAssignToDepartment) {
            workOrderNoteDetailId = Utilities.getNegativeId(workOrderNoteDetailId);
            workOrderNoteDetailEntity = new WorkOrderNoteDetailEntity(workOrderNoteDetailId, AppUtility.Companion.getUuid(), workOrderNoteId,
                    "workorder", "assigned_to_id", workOrderDetailItems.getWorkorderAssignedTo() + " (" + (workOrderDetailItems.getAssignedToType() == 2 ? "Department" : "User") + ")",
                    BaseApplication.getPreferenceManager().getUserFullName() + " (User)", currentTime, currentTime);
            workOrderDetailDao.insertNoteDetails(workOrderNoteDetailEntity);

            workOrderNoteDetailId = Utilities.getNegativeId(workOrderNoteDetailId);
            workOrderNoteDetailEntity = new WorkOrderNoteDetailEntity(workOrderNoteDetailId, AppUtility.Companion.getUuid(), workOrderNoteId,
                    "workorder", "assigned_to_type", (workOrderDetailItems.getAssignedToType() == 2 ? "Department" : "User"),
                    "User", currentTime, currentTime);
            workOrderDetailDao.insertNoteDetails(workOrderNoteDetailEntity);
        }
    }

    public void downloadFile(final WorkOrderAttachmentItems attachmentItem, final OnDownloadListener onDownloadListener) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = FileUtils.getWorkOrderAttachmentsDir();
            if (directory == null) {
                onDownloadListener.onFailed();
                return;
            }
            final File fileDestinationFolder = new File(directory, attachmentItem.getPath());

            if (!fileDestinationFolder.exists()) {

                RetroUtils.getRetrofitInstance(application.getApplicationContext(), new InternetConnectionListener() {
                    @Override
                    public void onInternetUnavailable() {
                        onDownloadListener.noInternetAvailable();
                    }
                }).create(WorkOrdersApi.class)
                        .workOrderAttachmentDownload(Constants.HEADER_ACCEPT, attachmentItem.getUuid())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).
                        subscribe(new AbstractNetworkObservable<ResponseBody>() {
                            @Override
                            public void success(ResponseBody responseBody) {
                                if (responseBody != null) {
                                    try {
                                        if (fileDestinationFolder.createNewFile()) {
                                            fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                                            onDownloadListener.onSuccess();
                                        } else
                                            onDownloadListener.onFailed();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        onDownloadListener.onFailed();
                                    }

                                } else
                                    onDownloadListener.onFailed();
                            }

                            @Override
                            public void failure(Throwable error) {
                                onDownloadListener.onFailed();
                            }
                        });
            } else {
                onDownloadListener.onSuccess();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            onDownloadListener.onFailed();
        }
    }

}
