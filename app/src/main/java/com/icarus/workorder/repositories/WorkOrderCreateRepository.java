package com.icarus.workorder.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.LocationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.LocationEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.models.AttachmentItems;
import com.icarus.util.AppUtility;
import com.icarus.util.Utilities;
import com.icarus.workorder.dao.CreateWorkOrderDao;
import com.icarus.workorder.dao.WorkOrderCommonDao;
import com.icarus.workorder.dao.WorkOrderDao;
import com.icarus.workorder.models.RoomItems;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.databinding.ObservableList;

import java.util.List;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
public class WorkOrderCreateRepository {

    private Application application;

    public WorkOrderCreateRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<LocationEntity>> getLocations() {
        MutableLiveData<List<LocationEntity>> mutableLiveData = new MutableLiveData<>();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        LocationDao locationDao = appDatabase.locationDao();
        List<LocationEntity> list;
        if (BaseApplication.getPreferenceManager().getIsAdmin()) {
            list = locationDao.getLocations();
        } else {
            list = locationDao.getLocations(BaseApplication.getPreferenceManager().getUserId());
        }
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    public MutableLiveData<List<RoomItems>> getRooms(Integer locationId) {
        MutableLiveData<List<RoomItems>> mutableLiveData = new MutableLiveData<>();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDao workOrderDao = appDatabase.workOrderDao();
        List<RoomItems> list = workOrderDao.getRoom(locationId);

        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    public MutableLiveData<List<RoomItems>> getAssets(Integer locationId, Integer roomId) {
        MutableLiveData<List<RoomItems>> mutableLiveData = new MutableLiveData<>();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDao workOrderDao = appDatabase.workOrderDao();
        List<RoomItems> list = workOrderDao.getAssets(locationId, roomId);

        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    public void createWorkOrder(String title, Integer locationId, Integer roomId, Integer assetId,
                                String description, Integer checklistId, ObservableList<AttachmentItems> listAttachment) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderCommonDao workOrderCommonDao = appDatabase.workOrderCommonDao();
        CreateWorkOrderDao createWorkOrderDao = appDatabase.createWorkOrderDao();
        String currentTime = AppUtility.Companion.getUtcTime();
        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        Integer id = createWorkOrderDao.getWorkOrderId();

        if (id == null || id > 0) {
            id = -1;
        } else {
            id = id - 1;
        }
        WorkOrderEntity workOrderEntity = new WorkOrderEntity();
        workOrderEntity.setTitle(title);
        workOrderEntity.setWorkorderStatusId(Constants.WORK_ORDER_STATUS_ID);
        workOrderEntity.setAssignedToId(workOrderCommonDao.getQcmId());
        workOrderEntity.setWorkorderPriorityId(Constants.WORK_ORDER_PRIORITY_ID);
        workOrderEntity.setWorkorderBillingTypeId(Constants.WORK_ORDER_BILLING_TYPE_ID);
        workOrderEntity.setAuthorId(userId);
        workOrderEntity.setLocationId(locationId);
        workOrderEntity.setLocationRoomId(roomId);
        workOrderEntity.setLocationEquipmentId(assetId);
        workOrderEntity.setAssignedToType(Constants.WORK_ORDER_ASSIGNED_TO_TYPE);
        workOrderEntity.setDescription(description);
        workOrderEntity.setChecklistId(checklistId);
        workOrderEntity.setId(id);
        workOrderEntity.setCreated(currentTime);
        workOrderEntity.setModified(currentTime);
        workOrderEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        workOrderEntity.setExecutionStatus(Constants.EXECUTION_STATUS_DATA_NOT_SYNC);
        workOrderEntity.setUuid(AppUtility.Companion.getUuid());
        createWorkOrderDao.insertWorkOrder(workOrderEntity);

        //Integer workOrderNoteDetailId = createWorkOrderDao.getWorkOrderNoteDetailId();

        for (AttachmentItems item : listAttachment) {
            Integer workOrderAttachmentId = createWorkOrderDao.getWorkOrderAttachmentId();
            workOrderAttachmentId = Utilities.getNegativeId(workOrderAttachmentId);

            WorkOrderAttachmentsEntity workOrderAttachmentsEntity = new WorkOrderAttachmentsEntity();
            workOrderAttachmentsEntity.setId(workOrderAttachmentId);
            workOrderAttachmentsEntity.setUuid(AppUtility.Companion.getUuid());
            workOrderAttachmentsEntity.setCreated(currentTime);
            workOrderAttachmentsEntity.setModified(currentTime);
            workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
            workOrderAttachmentsEntity.setWorkorderId(id);
            workOrderAttachmentsEntity.setAuthorId(userId);
            workOrderAttachmentsEntity.setContentType(item.getMimeType());
            workOrderAttachmentsEntity.setDisplayFileName(item.getFileSource().getName());
            workOrderAttachmentsEntity.setFileMd5Checksum(item.getFileMd5Checksum());
            workOrderAttachmentsEntity.setFilesize(item.getFileSize());
            workOrderAttachmentsEntity.setFilename(item.getFileSource().getName());
            workOrderAttachmentsEntity.setIsUploaded(Constants.NOT_UPLOADED);
            workOrderAttachmentsEntity.setIsDownloaded(Constants.DOWNLOADED);
            createWorkOrderDao.insertWorkOrderAttachments(workOrderAttachmentsEntity);

            /*WorkOrderNoteDetailEntity workOrderNoteDetailEntity = new WorkOrderNoteDetailEntity(Utilities.getNegativeId(workOrderNoteDetailId), AppUtility.Companion.getUuid(), workOrderNoteId,
                    "workorder_attachment", workOrderAttachmentsEntity.getUuid(), null, item.getFileDestination().getName(), currentTime, currentTime);
            createWorkOrderDao.insertNoteDetails(workOrderNoteDetailEntity);*/
        }

    }
}
