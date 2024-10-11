package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.LogsEntity;

/**
 * Created by Monika Rana on 19/05/2020
 */
@Dao
public abstract class QRStepAttributeExecutionDao {

    @Insert
    abstract void insertStep(AssignedStepAttributesEntity assignedStepAttributesEntity);

    @Update
    abstract void updateStep(AssignedStepAttributesEntity assignedStepAttributesEntity);

    @Insert
    abstract void insertLogsEntity(LogsEntity logEntity);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_AND_PENDING_COUNT)
    abstract void updateCheckList(String executedAt, Integer userId, int incrementBy, String assignedChecklistUuid);


    @Transaction
    public void updateStepExecution(
            String assignedChecklistUuid,
            String executedAt,
            int incrementPendingElementBy,
            AssignedStepAttributesEntity insertAssignedStepAttributeEntity,
            AssignedStepAttributesEntity updateAssignedStepAttributeEntity,
            LogsEntity logsEntity) {

        if (insertAssignedStepAttributeEntity != null)
            insertStep(insertAssignedStepAttributeEntity);
        if (updateAssignedStepAttributeEntity != null)
            updateStep(updateAssignedStepAttributeEntity);
        insertLogsEntity(logsEntity);
        updateCheckList(executedAt, logsEntity.getUserId(), incrementPendingElementBy,
                assignedChecklistUuid);
    }
}
