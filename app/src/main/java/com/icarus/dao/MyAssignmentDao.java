package com.icarus.dao;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.database.Queries;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.models.MyAssignedChecklistItems;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyAssignmentDao {
    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByLatestDue(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByLatestDueAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestDue(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_DUE_DATE)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestDueAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByRecentUpdated(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByRecentUpdatedAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestUpdated(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATED)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestUpdatedAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleAZ(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleAZAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleZA(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleZAAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusASC(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusASCAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_ASSIGNED_USER_JOIN + Queries.USER_DEFAULT_CLAUSE + Queries.USER_USER_ID_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusDESC(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    @Query(Queries.CHECKLIST_USER + Queries.USER_DEFAULT_CLAUSE + Queries.MY_ASSIGNED_DEPARTMENT_NAME_CLAUSE + Queries.DEPARTMENT_CHECKLIST_TYPE_CLAUSE + Queries.DEPARTMENT_CHECKLIST_STATUS_CLAUSE + Queries.CHECKLIST_ORDERBY_CHECKLIST_STATUS_DESC)
    DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusDESCAdmin(int userId, int locationId, List<String> department, List<String> type, List<String> status, String keyword);

    //--------------

    @Query(Queries.IS_ASSIGNED_USER_EXISTS)
    boolean isAssignedUsersExists(String assignedUuid, Integer userId);


    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_START)
    void updateStartAssignedChecklist(int userId, Integer sync_status, String currentTime, String uuid);


    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST)
    void updateResumeAssignedChecklist(int userId, Integer checklist_status, Integer sync_status, String currentTime, String uuid);

    @Query(InsertUpdateQueries.IF_PAUSE_TIMES_EXIST_QUERY)
    AssignedCheckListPauseTimesEntity ifPauseTimeExists(String uuid);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PAUSE_TIME_ENTRY)
    void updateAssignedCheckListPauseTimesEntity(int userId, Integer is_paused, String currentTime, Integer sync_status, String uuid);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT)
    void updateAssignedChecklistPendingElementCount(String uuid);

    @Query(Queries.CHECKLIST_COUNT_ADMIN)
    LiveData<Integer> geAssignedUserChecklistsAdminCount(int userId, int locationId);

    @Query(Queries.CHECKLIST_COUNT)
    LiveData<Integer> geAssignedUserChecklistsCount(int userId, int locationId);
}
