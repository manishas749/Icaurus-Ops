package com.icarus.dao;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.database.Queries;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.models.AllChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.StringCheckBox;
import com.icarus.models.UserItems;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AllCheckListDao {


    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_NAME)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckList(Integer udid, Integer locationid, String[] type, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListDec(Integer udid, Integer locationid, String[] type, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_MODIFIED)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModified(Integer udid, Integer locationid, String[] type, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_MODIFIED_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModiefiedDesc(Integer udid, Integer locationid, String[] type, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_MODIFIED)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListFav(Integer udid, Integer locationid, String[] type, Integer groupID, String keyword);

    //----------------------------------

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLIST_ORDERBY_NAME)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckList(Integer udid, Integer locationid, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListSortByNameDesc(Integer udid, Integer locationid, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLIST_ORDERBY_MODIFIED)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModified(Integer udid, Integer locationid, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLIST_ORDERBY_MODIFIED_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModifiedDesc(Integer udid, Integer locationid, Integer groupID, String keyword);

    @Query(Queries.GET_CHECK_LIST + Queries.CHECKLIST_ORDERBY_FAV)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListFav(Integer udid, Integer locationid, Integer groupID, String keyword);


    //-----------------------

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_NAME)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdmin(Integer udid, Integer locationid, String[] type, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByNameDesc(Integer udid, Integer locationid, String[] type, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_MODIFIED)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModified(Integer udid, Integer locationid, String[] type, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_MODIFIED_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModifiedDesc(Integer udid, Integer locationid, String[] type, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLISTCLAUSE + Queries.CHECKLIST_ORDERBY_FAV)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByFav(Integer udid, Integer locationid, String[] type, String keyword);

    //---------------

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_NAME)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdmin(Integer udid, Integer locationid, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_NAME_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByNameDesc(Integer udid, Integer locationid, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_MODIFIED)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModified(Integer udid, Integer locationid, String keyword);

    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_MODIFIED_DESC)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModifiedDesc(Integer udid, Integer locationid, String keyword);


    @Query(Queries.GET_ALL_CHECKLIST_ADMIN + Queries.CHECKLIST_ORDERBY_FAV)
    public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByFav(Integer udid, Integer locationid, String keyword);

    //----------------------
    @Query(Queries.GET_LOCATION_DEPARTMENT_FILTER)
    public List<StringCheckBox> getDepartmentFilterList(Integer locationId);

    @Query(Queries.GET_USER_DEPARTMENT_FILTER)
    public List<StringCheckBox> getDepartmentFilterList(Integer userId, Integer locationId);

    @Query(Queries.GET_USER_FILTER)
    public List<StringCheckBox> getUserFilterList(Integer locationId);

    @Query(Queries.GET_ROOM_ASSETS)
    List<RoomAssetItems> getRoomAssets(Integer checklistId, Integer locationId);

    @Query(Queries.GET_USERS_DEPARTMENT)
    List<UserItems> getUsers(Integer departmentId, Integer locationId);

    @Query(Queries.GET_USERS)
    List<UserItems> getUsers(Integer locationId);

    @Query(InsertUpdateQueries.UPDATE_USER_FAV_REMOVE)
    void removeFavourite(Integer checklistId, Integer userId, Integer sync_status, String modified);

    @Insert
    void addFavourite(UserFavouritesEntity userFavouritesEntity);


    @Insert
    void insertLogs(LogsEntity logs);

    @Insert
    void assignCheckList(AssignCheckListEntity assignCheckListEntity);

    @Insert
    void insertUsers(AssignedUserEntity assignedUserEntity);

    @Insert
    void insertRoomAsset(AssignRoomEquipmentsEntity assignRoomEquipmentsEntity);

    @Query("select * from assigned_checklists")
    List<AssignCheckListEntity> getAssignedCheckList();

    @Query(InsertUpdateQueries.GET_LOGO_ID_QUERY)
    Integer getLogoId(Integer checklistId);

    @Insert
    void insertLog(AssignedLogoEntity assignedLogoEntity);

    @Query(Queries.IF_USER_ALREADY_INSERTED)
    AssignedUserEntity ifUserExist(Integer userId,String uuid);

    @Update
    void updateUsers(AssignedUserEntity assignedUserEntity);

    @Query(InsertUpdateQueries.CHECK_USER_FAV_EXIST)
    String checkIsFavouriteExist(Integer checklistId, Integer userId);


    @Query(InsertUpdateQueries.UPDATE_USER_FAV)
    void updateFavourite(Integer checklistId,  Integer userId, Integer sync_status, String modified);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT)
    void updateAssignedChecklistPendingElementCount(String uuid);
}
