package com.icarus.repositories;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.dao.AllCheckListDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.enums.AssignedType;
import com.icarus.enums.LogTableActions;
import com.icarus.models.AllChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.StringCheckBox;
import com.icarus.models.UserItems;
import com.icarus.util.AppUtility;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 */
public class AllCheckListRepository {

    private Application application;

    public AllCheckListRepository(Application application) {
        this.application = application;
    }

    /**
     * @param sortBy
     * @param statusBy
     * @param typeBy
     * @return
     */
    public LiveData<PagedList<AllChecklistItems>> getAllChecklist(PagedList.Config config, String sortBy, ArrayList<StringCheckBox> statusBy, ArrayList<StringCheckBox> typeBy, String keyword) {

        keyword = "%" + keyword + "%";

        String typeValue = "";
        if (typeBy != null && typeBy.size() > 0) {
            for (int i = 0; i < typeBy.size(); i++) {
                StringCheckBox item = typeBy.get(i);
                if (item.getId() != 0 && item.isSelected()) {
                    if (!TextUtils.isEmpty(typeValue)) {
                        typeValue += ",";
                    }
                    typeValue += item.getId();
                }
            }
        }

        String[] type = new String[]{};

        if (typeValue.length() > 0)
            type = typeValue.split(",");


        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        DataSource.Factory<Integer, AllChecklistItems> factory;

        if (sortBy.equals(SortingTag.MODIFIED_DESC)) {
            if (type.length > 0) {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByModifiedDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, keyword);
                else
                    factory = allCheckListDao.getAllCheckListModiefiedDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            } else {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByModifiedDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), keyword);
                else
                    factory = allCheckListDao.getAllCheckListModifiedDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            }
        } else if (sortBy.equals(SortingTag.MODIFIED_ASC)) {
            if (type.length > 0) {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByModified(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, keyword);
                else
                    factory = allCheckListDao.getAllCheckListModified(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            } else {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByModified(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), keyword);
                else
                    factory = allCheckListDao.getAllCheckListModified(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            }
        } else if (sortBy.equals(SortingTag.NAME_ASC)) {
            if (type.length > 0) {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, keyword);
                else
                    factory = allCheckListDao.getAllCheckList(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            } else {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdmin(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), keyword);
                else
                    factory = allCheckListDao.getAllCheckList(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            }
        } else if (sortBy.equals(SortingTag.NAME_DESC)) {
            if (type.length > 0) {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByNameDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, keyword);
                else
                    factory = allCheckListDao.getAllCheckListDec(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            } else {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByNameDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), keyword);
                else
                    factory = allCheckListDao.getAllCheckListSortByNameDesc(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            }
        } else {
            if (type.length > 0) {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByFav(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, keyword);
                else
                    factory = allCheckListDao.getAllCheckListFav(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), type, BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            } else {
                if (BaseApplication.getPreferenceManager().getIsAdmin())
                    factory = allCheckListDao.getAllCheckListAdminSortByFav(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), keyword);
                else
                    factory = allCheckListDao.getAllCheckListFav(BaseApplication.getPreferenceManager().getUserId(), BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getUserGroupId(), keyword);

            }

        }

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     * @return
     */
    public MutableLiveData<ArrayList<StringCheckBox>> getDepartmentFilterList() {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();

        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        Integer locationId = BaseApplication.getPreferenceManager().getUserLocationId();
        boolean isAdministrator = BaseApplication.getPreferenceManager().getIsAdmin();

        ArrayList<StringCheckBox> itemsList;

        if (isAdministrator) {
            itemsList = (ArrayList<StringCheckBox>) allCheckListDao.getDepartmentFilterList(locationId);
        } else {
            itemsList = (ArrayList<StringCheckBox>) allCheckListDao.getDepartmentFilterList(userId, locationId);
        }

        // Generate the default option of "All" and add it to the list.
        StringCheckBox defaultOption = new StringCheckBox();
        defaultOption.setSelected(true);
        defaultOption.setTitle(application.getResources().getString(R.string.all));
        itemsList.add(0, defaultOption);

        // As departments do not have an position per se at database level, we need to set that
        // manually else the logic applied for filtering would fail.
        for (StringCheckBox stringCheckBox : itemsList) {
            stringCheckBox.setPosition(itemsList.indexOf(stringCheckBox));
        }

        MutableLiveData<ArrayList<StringCheckBox>> items = new MutableLiveData<>();
        items.setValue(itemsList);

        return items;
    }

    /**
     * @return
     */
    public MutableLiveData<ArrayList<StringCheckBox>> getUserFilterList() {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        ArrayList<StringCheckBox> itemsList = (ArrayList<StringCheckBox>) allCheckListDao.getUserFilterList(BaseApplication.getPreferenceManager().getUserLocationId());
        MutableLiveData<ArrayList<StringCheckBox>> items = new MutableLiveData<>();
        StringCheckBox checkBox = new StringCheckBox();
        checkBox.setSelected(true);
        checkBox.setTitle("All");
        checkBox.setId(0);
        itemsList.add(0, checkBox);
        items.setValue(itemsList);
        return items;
    }

    /**
     * @param checkListId ID of checklist
     * @return
     */

    public MutableLiveData<List<RoomAssetItems>> getRoomAssets(Integer checkListId) {
        MutableLiveData<List<RoomAssetItems>> liveData = new MutableLiveData<>();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        List<RoomAssetItems> mRoomAssetsList = allCheckListDao.getRoomAssets(checkListId, BaseApplication.getPreferenceManager().getUserLocationId());
        liveData.setValue(mRoomAssetsList);
        return liveData;
    }

    /**
     * @param departmentID ID of department
     * @return
     */

    public MutableLiveData<List<UserItems>> getUsers(Integer departmentID) {
        MutableLiveData<List<UserItems>> mutableLiveData = new MutableLiveData<>();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        List<UserItems> list = allCheckListDao.getUsers(departmentID, BaseApplication.getPreferenceManager().getUserLocationId());

        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    /**
     * @return
     */

    public MutableLiveData<List<UserItems>> getUsers() {
        MutableLiveData<List<UserItems>> mutableLiveData = new MutableLiveData<>();

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        List<UserItems> list = allCheckListDao.getUsers(BaseApplication.getPreferenceManager().getUserLocationId());

        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    /**
     * @param checklistId
     * @param isFavourite
     */

    public void addUpdateFavourite(Integer checklistId, Integer isFavourite) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();

        if (isFavourite.equals(Constants.FAVOURITE)) {
            allCheckListDao.removeFavourite(checklistId, BaseApplication.getPreferenceManager().getUserId(), Constants.SYNC_STATUS_NOT, AppUtility.Companion.getUtcTime());

        } else {
            String uuid = allCheckListDao.checkIsFavouriteExist(checklistId, BaseApplication.getPreferenceManager().getUserId());
            if(!TextUtils.isEmpty(uuid)){
                allCheckListDao.updateFavourite(checklistId, BaseApplication.getPreferenceManager().getUserId(), Constants.SYNC_STATUS_NOT, AppUtility.Companion.getUtcTime());
            }else {
                UserFavouritesEntity userFavouritesEntity = new UserFavouritesEntity();
                userFavouritesEntity.setChecklistId(checklistId);
                userFavouritesEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
                userFavouritesEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
                userFavouritesEntity.setIsDeleted(Constants.NOT_DELETED);
                userFavouritesEntity.setUuid(AppUtility.Companion.getUuid());
                userFavouritesEntity.setCreated(AppUtility.Companion.getUtcTime());
                userFavouritesEntity.setModified(AppUtility.Companion.getUtcTime());
                allCheckListDao.addFavourite(userFavouritesEntity);
            }
        }

    }


    /**
     * @param assignedChecklistUuid
     * @param checklistId
     * @param departmentId
     * @param userId
     * @param dueDate
     */

    public void assignCheckList(String assignedChecklistUuid, Integer checklistId, Integer departmentId, Integer userId, String dueDate, List<UserItems> user, boolean isStart, RoomAssetItems roomAsset) {

        String currentTime = AppUtility.Companion.getUtcTime();

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();

        AssignCheckListEntity assignCheckListEntity = new AssignCheckListEntity();
        assignCheckListEntity.setUuid(assignedChecklistUuid);
        assignCheckListEntity.setChecklistId(checklistId);
        assignCheckListEntity.setDepartmentId(departmentId);
        assignCheckListEntity.setLocationId(BaseApplication.getPreferenceManager().getUserLocationId());
        assignCheckListEntity.setUserId(userId);
        assignCheckListEntity.setCreated(currentTime);
        assignCheckListEntity.setAssignedAt(currentTime);
        assignCheckListEntity.setDueDate(dueDate);
        assignCheckListEntity.setIsDeleted(Constants.NOT_DELETED);
        assignCheckListEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING);
        assignCheckListEntity.setModified(currentTime);
        assignCheckListEntity.setAssigneeType(AssignedType.user.getValue());
        assignCheckListEntity.setExecutionStatus(Constants.EXECUTION_STATUS_DATA_NOT_SYNC);
        assignCheckListEntity.setPendingElementsCount(Constants.DEFAULT_PENDING_RESOURCE_COUNT);
        assignCheckListEntity.setPendingResourcesCount(Constants.DEFAULT_PENDING_RESOURCE_COUNT);
        if (isStart) {
            assignCheckListEntity.setStartedByUserId(BaseApplication.getPreferenceManager().getUserId());
            assignCheckListEntity.setStartedAt(currentTime);
        } else {
            assignCheckListEntity.setStartedByUserId(null);
            assignCheckListEntity.setStartedAt(null);
        }

        allCheckListDao.assignCheckList(assignCheckListEntity);
        insertUsers(user, assignedChecklistUuid, checklistId, isStart);
        insertLogo(checklistId, assignedChecklistUuid);

        if (roomAsset != null)
            insertRoomAssets(roomAsset, assignedChecklistUuid, checklistId);
    }

    /**
     * @param checklistId ID of assigned check list id
     * @param uuid        UUID of assigned check list
     */
    private void insertLogo(Integer checklistId, String uuid) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();

        AssignedLogoEntity assignedLogoEntity = new AssignedLogoEntity();
        assignedLogoEntity.setAssignedChecklistUuid(uuid);
        assignedLogoEntity.setCreated(currentTime);
        assignedLogoEntity.setModified(currentTime);
        assignedLogoEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        assignedLogoEntity.setUuid(AppUtility.Companion.getUuid());
        assignedLogoEntity.setChecklistLogoId(allCheckListDao.getLogoId(checklistId));

        allCheckListDao.insertLog(assignedLogoEntity);
        allCheckListDao.updateAssignedChecklistPendingElementCount(uuid);

    }

    /**
     * @param user
     * @param assignCheckListUUID
     * @param checklistId
     * @param isStart
     */
    private void insertUsers(List<UserItems> user, String assignCheckListUUID, Integer checklistId, boolean isStart) {
        LogsRepository logsRepository = new LogsRepository(application);

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).isSelected()) {
                String currentTime = AppUtility.Companion.getUtcTime();
                AppDatabase appDatabase = AppDatabase.getInstance(application);
                AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
                AssignedUserEntity assignedUserEntity = new AssignedUserEntity();
                assignedUserEntity.setUuid(AppUtility.Companion.getUuid());
                assignedUserEntity.setAssignedCheklistUUID(assignCheckListUUID);
                assignedUserEntity.setUserId(user.get(i).getId());
                assignedUserEntity.setIsDeleted(Constants.NOT_DELETED);
                assignedUserEntity.setCreated(currentTime);
                assignedUserEntity.setModified(currentTime);
                assignedUserEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
                assignedUserEntity.setAssignedBy(BaseApplication.getPreferenceManager().getUserId());
                allCheckListDao.insertUsers(assignedUserEntity);
                allCheckListDao.updateAssignedChecklistPendingElementCount(assignCheckListUUID);

                logsRepository.insertLogs(assignedUserEntity.getUuid(), assignCheckListUUID,
                        checklistId, 0, LogTableActions.ASSIGNED.getValue(),
                        user.get(i).getFullName(), "Checklist Assigned",
                        "", user.get(i).getId());
            }
        }

        if (isStart) {
            logsRepository.insertLogs(assignCheckListUUID, assignCheckListUUID, checklistId,
                    0, LogTableActions.STARTED.getValue(),
                    BaseApplication.getPreferenceManager().getUserFullName(),
                    "Checklist Started", "",
                    BaseApplication.getPreferenceManager().getUserId());
        }
    }

    private void insertRoomAssets(RoomAssetItems roomAssetItems, String assignCheckListUUID, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        AssignRoomEquipmentsEntity assignRoomEquipmentsEntity = new AssignRoomEquipmentsEntity();
        assignRoomEquipmentsEntity.setAssignedChecklistUuid(assignCheckListUUID);
        assignRoomEquipmentsEntity.setUuid(AppUtility.Companion.getUuid());
        assignRoomEquipmentsEntity.setRoomId(roomAssetItems.roomId);
        assignRoomEquipmentsEntity.setEquipmentId(roomAssetItems.equipmentId);
        assignRoomEquipmentsEntity.setIsDeleted(Constants.NOT_DELETED);
        assignRoomEquipmentsEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        assignRoomEquipmentsEntity.setCreated(currentTime);
        assignRoomEquipmentsEntity.setModified(currentTime);
        allCheckListDao.insertRoomAsset(assignRoomEquipmentsEntity);
        allCheckListDao.updateAssignedChecklistPendingElementCount(assignCheckListUUID);

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(assignRoomEquipmentsEntity.getUuid(),
                assignCheckListUUID,
                checklistId, 0,
                LogTableActions.ROOM_AND_EQUIPMENT_SELECTED.getValue(),
                BaseApplication.getPreferenceManager().getUserFullName(),
                roomAssetItems.asset, roomAssetItems.room,
                BaseApplication.getPreferenceManager().getUserId());
    }

}
