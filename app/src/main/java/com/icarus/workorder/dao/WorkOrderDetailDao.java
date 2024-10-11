package com.icarus.workorder.dao;

import com.icarus.database.Queries;
import com.icarus.database.WorkOrderQueries;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.models.WorkOrderDetailItems;
import com.icarus.workorder.models.WorkOrderNoteDetailItems;
import com.icarus.workorder.models.WorkOrderNoteInfoItems;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WorkOrderDetailDao extends WorkOrderCommonDao{
    @Query(WorkOrderQueries.WORK_ORDER_INFO)
    public LiveData<WorkOrderDetailItems> getWorkOrderInfo(String workOrderUuid);

    @Query(WorkOrderQueries.WORK_ORDER_NOTE_INFO)
    public LiveData<List<WorkOrderNoteInfoItems>> getWorkOrderNoteInfo(Integer workOrderId);

    @Query(WorkOrderQueries.WORK_ORDER_ATTACHMENTS)
    public LiveData<List<WorkOrderAttachmentItems>> getWorkOrderAttachments(Integer workOrderId);

    @Query(WorkOrderQueries.WORK_ORDER_NOTE_DETAIL)
    public LiveData<List<WorkOrderNoteDetailItems>> getWorkOrderNoteDetail(Integer[] noteId);

    @Query(WorkOrderQueries.WORK_ORDER_STATUS_NAME)
    String getStatus(Integer statusId);


    @Query(WorkOrderQueries.WORK_ORDER_NOTE_ID)
    public Integer getWorkOrderNoteId();

    @Query(WorkOrderQueries.WORK_ORDER_UPDATE)
    void updateWorkOrder(String currentTime, Integer workorderStatusId, String workOrderUuid);

    @Query(WorkOrderQueries.WORK_ORDER_UPDATE_TO_USER)
    void updateWorkOrder(String currentTime, Integer workorderStatusId, String workOrderUuid, Integer userId);

    @Query(WorkOrderQueries.WORK_ORDER_COMPLETE)
    void updateWorkOrderComplete(String currentTime, String workOrderUuid);

    @Insert
    void insertNotes(WorkOrderNotesEntity entity);

    @Query(WorkOrderQueries.WORK_ORDER_ATTACHMENT_DOWNLOAD)
    void updateWorkOrderAttachment(String uuid);

    //----------------------
    @Query(Queries.GET_LOCATION_DEPARTMENT_ID_LIST)
    public List<Integer> getDepartmentList(Integer locationId);

    @Query(Queries.GET_USER_DEPARTMENT_ID_LIST)
    public List<Integer> getDepartmentList(Integer userId, Integer locationId);

}

