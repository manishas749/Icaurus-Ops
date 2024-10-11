package com.icarus.workorder.dao;

import com.icarus.database.WorkOrderQueries;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by Anurag Purwar on 5/2/19.
 */
@Dao
public interface WorkOrderCommonDao {

    @Query(WorkOrderQueries.QCM_ID)
    public Integer getQcmId();

    @Insert
    void insertWorkOrderAttachments(WorkOrderAttachmentsEntity workOrderAttachmentsEntity);

    @Query(WorkOrderQueries.WORK_ORDER_NOTE_DETAIL_ID)
    public Integer getWorkOrderNoteDetailId();

    @Query(WorkOrderQueries.WORK_ORDER_ATTACHMENTS_ID)
    public Integer getWorkOrderAttachmentId();

    @Insert
    void insertNoteDetails(WorkOrderNoteDetailEntity entity);

}
