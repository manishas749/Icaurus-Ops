package com.icarus.dao;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.database.Queries;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CheckListDetailDao {
    @Query(Queries.GET_CHECKLIST_DETAIL)
    DataSource.Factory<Integer, ChecklistElementItem> getCheckListDetail(Integer checkListId, String checkListUuid);

    @Query(Queries.GET_CHECKLIST_INCOMPLETE_ELEMENTS)
    DataSource.Factory<Integer, ChecklistDetailItems> getChecklistIncompleteElements(Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_PENDING_ELEMENT_COUNT)
    LiveData<Integer> getPendingElementCount(Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_TOTAL_ELEMENT_COUNT)
    LiveData<Integer> getTotalElementCount(Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_TOTAL_ELEMENT_COUNT)
    Integer getTotalElementCountInteger(Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_DETAIL_SKIPPED_DEFER)
    DataSource.Factory<Integer, ChecklistElementItem> getCheckListDetailSkippedDeferred(Integer checklistId, String assignedchecklistUuid, Integer status);


    @Insert
    void insertAssignedCheckListPauseTimesEntity(AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT)
    void updateAssignedChecklistPendingElementCount(String uuid);
}
