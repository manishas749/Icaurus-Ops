package com.icarus.dao;

import com.icarus.database.Queries;
import com.icarus.models.CancelledCompletedChecklistItems;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface CancelledCompletedDao {
    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListSortByDueDate(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type, String[] users,String keyword);

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListSortByDueDateDesc(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type, String[] users,String keyword);

    //-----------------------
    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListTypeDue(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type,String keyword);

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListTypeDueDec(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type,String keyword);

    //--------------------------
    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDue(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] users,String keyword);

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueDec(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] users,String keyword);

//Admin

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListSortByDueDateAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type, String[] users,String keyword);

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListSortByDueDateDescAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type, String[] users,String keyword);

    //-----------------------
    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListTypeDueAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type,String keyword);

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.ASSIGNED_CHECKLIST_TYPE_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListTypeDueDecAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] type,String keyword);

    //--------------------------
    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] users,String keyword);

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.CHECKLIST_USER_CLAUSE + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueDecAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType, String[] users,String keyword);


    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueDateAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType,String keyword);


    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueDateDecAdmin(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType,String keyword);

    // --------------------------------------
    /*@Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.CHECKLIST_ORDERBY_NAME)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckList(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType,String keyword);*/

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.CHECKLIST_ORDERBY_LAST_UPDATE)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueDate(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType,String keyword);

    /*@Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDec(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType,String keyword);*/

    @Query(Queries.GET_CANCELLED_COMPLETED_CHECKLIST + Queries.CHECKLIST_ORDERBY_LAST_UPDATE_DESC)
    public DataSource.Factory<Integer,CancelledCompletedChecklistItems> getCheckListDueDateDec(Integer userId, Integer locationId, Integer checklistStatus, Integer assignType,String keyword);

}
