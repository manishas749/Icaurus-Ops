package com.icarus.dao;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.database.Queries;
import com.icarus.entities.LogsEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LogsDao {

    @Insert
    void insertLogs(LogsEntity logsEntity);

    @Query(Queries.GET_LOGS)
    List<LogsEntity> getReport(String assignedChecklistUuid);

    @Query(InsertUpdateQueries.UPDATE_CHECKLIST_MODIFIED)
    void updateCheckList(String checklistUuid,String currentTime);

    @Query(Queries.GET_UUID_LOGS)
    String getUuid(Integer checklist_element_id, String assignedChecklistUuid);

    @Update
    void updateLogs(LogsEntity logsEntity);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT)
    void updateAssignedChecklistPendingElementCount(String uuid);
}
