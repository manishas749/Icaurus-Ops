package com.icarus.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.database.Queries;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.models.DepartmentChecklistItems;

import java.util.List;

@Dao
public interface DepartmentChecklistDao {
    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByLatestDue(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByLatestDueAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestDue(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestDueAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByRecentUpdated(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByRecentUpdatedAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestUpdated(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestUpdatedAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleAZ(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleAZAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleZA(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleZAAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusASC(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusASCAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_USER_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_USER_ID_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusDESC(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_DEPARTMENT + Queries.DEPARTMENT_LOCATION_DEPARTMENT_JOIN + Queries.DEPARTMENT_DEFAULT_CLAUSE + Queries.DEPARTMENT_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS_DESC)
    DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusDESCAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(InsertUpdateQueries.UPDATE_DEPARTMENT_ASSIGNED)
    void updateAsssignedDepartmentsEntity(String uuid,String currentTime);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_DEPARTMENT)
    void updateStartAssignedChecklist(String uuid,Integer userId,String currentTime);

   @Insert
    void insertStartAssignedChecklist(AssignCheckListEntity assignCheckListEntity);

   @Query(Queries.CHECKLIST_DEPARTMENT_ADMIN_COUNT)
    LiveData<Integer> getAssignedDepartmentChecklistsAdminCount(int userId, int locationId);

    @Query(Queries.CHECKLIST_DEPARTMENT_COUNT)
    LiveData<Integer> getAssignedDepartmentChecklistsCount(int userId, int locationId);
}
