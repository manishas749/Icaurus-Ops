package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.icarus.database.Queries;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.models.StringCheckBox;

import java.util.List;

@Dao
public interface DashboardDao {


    @Query(Queries.GET_ALL_CHECKLIST_TYPE)
    List<StringCheckBox> getAllChecklistTypesFilter();

    @Query(Queries.GET_CHECKLIST_TYPE)
    List<StringCheckBox> getChecklistTypes();

    @Query(Queries.GET_WORK_ORDER_STATUS_FILTER)
    List<StringCheckBox> getStatusWorkOrder();

    @Query(Queries.GET_ASSIGNED_ITEM_PLACEHOLDERS)
    List<ChecklistItemPlaceHolders> getItemPlaceHolders(String checklistUUID);
}
