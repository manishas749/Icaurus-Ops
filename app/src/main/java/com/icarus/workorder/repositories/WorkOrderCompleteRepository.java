package com.icarus.workorder.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.database.AppDatabase;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.enums.WorkorderStatus;
import com.icarus.models.AttachmentItems;
import com.icarus.util.AppUtility;
import com.icarus.util.Utilities;
import com.icarus.workorder.dao.WorkOrderDetailDao;

import android.app.Application;
import androidx.databinding.ObservableList;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
public class WorkOrderCompleteRepository {

    private Application application;

    public WorkOrderCompleteRepository(Application application) {
        this.application = application;
    }

    public void completeWorkOrder(String description, String workOrderUuid, Integer workOrderId, ObservableList<AttachmentItems> listAttachment) {
        String currentTime = AppUtility.Companion.getUtcTime();
        int userId = BaseApplication.getPreferenceManager().getUserId();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDetailDao workOrderDetailDao = appDatabase.workOrderDetailDao();
        workOrderDetailDao.updateWorkOrderComplete(currentTime, workOrderUuid);


        Integer workOrderNoteId =  Utilities.getNegativeId(workOrderDetailDao.getWorkOrderNoteId());
        WorkOrderNotesEntity workOrderNotesEntity = new WorkOrderNotesEntity(workOrderNoteId, AppUtility.Companion.getUuid(), workOrderId, userId, description, currentTime, currentTime);
        workOrderDetailDao.insertNotes(workOrderNotesEntity);

        Integer workOrderNoteDetailId = workOrderDetailDao.getWorkOrderNoteDetailId();
        workOrderNoteDetailId = Utilities.getNegativeId(workOrderNoteDetailId);

        WorkOrderNoteDetailEntity workOrderNoteDetailEntity = new WorkOrderNoteDetailEntity( workOrderNoteDetailId, AppUtility.Companion.getUuid(), workOrderNoteId,
                "workorder", "workorder_status_id", workOrderDetailDao.getStatus(WorkorderStatus.IN_PROGRESS.getValue()), workOrderDetailDao.getStatus(WorkorderStatus.COMPLETED.getValue()), currentTime, currentTime);
        workOrderDetailDao.insertNoteDetails(workOrderNoteDetailEntity);


        for (AttachmentItems item : listAttachment) {

            Integer workOrderAttachmentId = workOrderDetailDao.getWorkOrderAttachmentId();
            workOrderAttachmentId = Utilities.getNegativeId(workOrderAttachmentId);

            WorkOrderAttachmentsEntity workOrderAttachmentsEntity = new WorkOrderAttachmentsEntity();
            workOrderAttachmentsEntity.setId(workOrderAttachmentId);
            workOrderAttachmentsEntity.setUuid(AppUtility.Companion.getUuid());
            workOrderAttachmentsEntity.setCreated(currentTime);
            workOrderAttachmentsEntity.setModified(currentTime);
            workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
            workOrderAttachmentsEntity.setWorkorderId(workOrderId);
            workOrderAttachmentsEntity.setAuthorId(userId);
            workOrderAttachmentsEntity.setContentType(item.getMimeType());
            workOrderAttachmentsEntity.setDisplayFileName(item.getFileSource().getName());
            workOrderAttachmentsEntity.setFileMd5Checksum(item.getFileMd5Checksum());
            workOrderAttachmentsEntity.setFilesize(item.getFileSize());
            workOrderAttachmentsEntity.setFilename(item.getFileSource().getName());
            workOrderAttachmentsEntity.setIsUploaded(Constants.NOT_UPLOADED);
            workOrderAttachmentsEntity.setIsDownloaded(Constants.DOWNLOADED);
            workOrderDetailDao.insertWorkOrderAttachments(workOrderAttachmentsEntity);

            workOrderNoteDetailId = Utilities.getNegativeId(workOrderNoteDetailId);
            workOrderNoteDetailEntity = new WorkOrderNoteDetailEntity(workOrderNoteDetailId, AppUtility.Companion.getUuid(), workOrderNoteId,
                    "workorder_attachment", workOrderAttachmentsEntity.getUuid(), null, item.getFileSource().getName(), currentTime, currentTime);
            workOrderDetailDao.insertNoteDetails(workOrderNoteDetailEntity);
        }

    }
}
