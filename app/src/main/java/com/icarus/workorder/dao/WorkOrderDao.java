package com.icarus.workorder.dao;

import com.icarus.database.WorkOrderQueries;
import com.icarus.workorder.models.RoomItems;
import com.icarus.workorder.models.WorkOrderItems;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WorkOrderDao {
    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER + WorkOrderQueries.ORDERBY_DUE_DATE_ASC)
    public DataSource.Factory<Integer, WorkOrderItems> getWorkOrder(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.ORDERBY_DUE_DATE_ASC)
    public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrder(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.ORDERBY_DUE_DATE_DESC)
    public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderDueDateDESC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER + WorkOrderQueries.ORDERBY_DUE_DATE_DESC)
    public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderDueDateDESC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER + WorkOrderQueries.ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderNameDESC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderNameDESC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER + WorkOrderQueries.ORDERBY_NAME_ASC)
    public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderNameASC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.ORDERBY_NAME_ASC)
    public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderNameASC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER + WorkOrderQueries.ORDERBY_ID_ASC)
    public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderIdASC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.ORDERBY_ID_ASC)
    public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderIdASC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER + WorkOrderQueries.ORDERBY_ID_DESC)
    public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderIdDESC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_WORK_ORDER + WorkOrderQueries.ORDERBY_ID_DESC)
    public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderIdDESC(Integer locationId, Integer userId, List<String> statusIds, List<Integer> priorityLevels, Integer authorId, Integer assignedTo, List<Integer> departmentIds, String keyword);

    @Query(WorkOrderQueries.GET_ROOMS)
    public List<RoomItems> getRoom(Integer locationId);

    @Query(WorkOrderQueries.GET_ASSETS)
    public List<RoomItems> getAssets(Integer locationId, Integer roomId);


    @Query(WorkOrderQueries.WORK_ORDER_COUNT)
    LiveData<Integer> getWorkOrderAdminCount(Integer locationId, List<Integer> statusIds, List<Integer> priorityIds);

    @Query(WorkOrderQueries.WORK_ORDER_COUNT + WorkOrderQueries.WORKORDER_TYPE_CLAUSE_FOR_USER)
    LiveData<Integer> getWorkOrderCount(Integer userId, Integer locationId, List<Integer> statusIds, List<Integer> priorityIds, List<Integer> departmentIds);
}

