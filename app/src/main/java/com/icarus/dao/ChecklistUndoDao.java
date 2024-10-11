package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.icarus.database.UndoQueries;

@Dao
public interface ChecklistUndoDao {

    @Query(UndoQueries.UPDATE_NCW_ON_UNDO)
    void updateAssignedNCW(Integer checklistElementId,String date);

    @Query(UndoQueries.UPDATE_STEP_ON_UNDO)
    void updateAssignedStep(Integer checklistElementId,String date);

    @Query(UndoQueries.UPDATE_STEP_RESOURCES_ON_UNDO)
    void updateAssignedResources(Integer checklistElementId,String date);

    @Query(UndoQueries.UPDATE_STEP_ATTRIBUTES_UNDO)
    void updateAssignedStepAttribute(Integer checklistElementId,String date);

    @Query(UndoQueries.UPDATE_DECISIONS_ON_UNDO)
    void updateAssignedDecision(Integer checklistElementId,String date);



}
