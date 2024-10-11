package com.icarus.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.dao.AllCheckListDao;
import com.icarus.dao.DashboardDao;
import com.icarus.dao.MyAssignmentDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.enums.LogTableActions;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.models.MyAssignedChecklistItems;
import com.icarus.models.StringCheckBox;
import com.icarus.util.AppUtility;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class MyAssignedCheckListRepository {

    private Application application;

    public MyAssignedCheckListRepository(Application application) {
        this.application = application;
    }

    /**
     *
     */
    public LiveData<PagedList<MyAssignedChecklistItems>> getMyAssignedChecklist(
            PagedList.Config config,
            String sortBy,
            ArrayList<StringCheckBox> statusBy,
            ArrayList<StringCheckBox> typeBy,
            ArrayList<StringCheckBox> departmentBy,
            String keyword
    ) {
        keyword = "%" + keyword + "%";

        List<String> statuses = new ArrayList<>();
        List<String> type = new ArrayList<>();
        List<String> departments = new ArrayList<>();

        if (statusBy != null) {
            List<String> selectedStatuses = new ArrayList<>();

            for (StringCheckBox stringCheckBox : statusBy) {
                String status = stringCheckBox.getTitle();
                statuses.add(status);

                if (stringCheckBox.getPosition() != 0 && stringCheckBox.isSelected()) {
                    selectedStatuses.add(status);
                }
            }

            if (selectedStatuses.size() > 0) {
                statuses = selectedStatuses;
            }
        }

        if (typeBy != null && typeBy.size() > 0) {
            List<String> selectedType = new ArrayList<>();
            for (int i = 0; i < typeBy.size(); i++) {
                StringCheckBox item = typeBy.get(i);

                String id = String.valueOf(item.getId());
                type.add(id);

                if (item.getId() != 0 && item.isSelected()) {
                    selectedType.add(id);
                }
            }

            if (selectedType.size() > 0)
                type = selectedType;
        }


        if (departmentBy != null) {
            List<String> selectedDepartments = new ArrayList<>();

            for (StringCheckBox stringCheckBox : departmentBy) {
                String id = String.valueOf(stringCheckBox.getId());
                departments.add(id);

                if (stringCheckBox.getPosition() != 0 && stringCheckBox.isSelected()) {
                    selectedDepartments.add(id);
                }
            }

            if (selectedDepartments.size() > 0) {
                departments = selectedDepartments;
            }
        }

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        DataSource.Factory<Integer, MyAssignedChecklistItems> factory;

        int userId = BaseApplication.getPreferenceManager().getUserId();
        int locationId = BaseApplication.getPreferenceManager().getUserLocationId();
        boolean isAdministrator = BaseApplication.getPreferenceManager().getIsAdmin();

        if (sortBy.equals(SortingTag.MODIFIED_DESC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.getAssignedUserChecklistsOrderByRecentUpdatedAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.getAssignedUserChecklistsOrderByRecentUpdated(userId, locationId, departments, type, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.MODIFIED_ASC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByOldestUpdatedAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByOldestUpdated(userId, locationId, departments, type, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.DUE_DATE_DESC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.getAssignedUserChecklistsOrderByLatestDueAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.getAssignedUserChecklistsOrderByLatestDue(userId, locationId, departments, type, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.NAME_ASC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByTitleAZAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByTitleAZ(userId, locationId, departments, type, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.NAME_DESC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByTitleZAAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByTitleZA(userId, locationId, departments, type, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.STATUS_ASC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByStatusASCAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByStatusASC(userId, locationId, departments, type, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.STATUS_DESC)) {
            if (isAdministrator) {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByStatusDESCAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByStatusDESC(userId, locationId, departments, type, statuses, keyword);
            }
        } else {
            if (isAdministrator) {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByOldestDueAdmin(userId, locationId, departments, type, statuses, keyword);
            } else {
                factory = myAssignmentDao.geAssignedUserChecklistsOrderByOldestDue(userId, locationId, departments, type, statuses, keyword);
            }
        }

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }


    public LiveData<Integer> getAssignedChecklistCount() {
        LiveData<Integer> count;
        boolean isAdministrator = BaseApplication.getPreferenceManager().getIsAdmin();
        int userId = BaseApplication.getPreferenceManager().getUserId();
        int locationId = BaseApplication.getPreferenceManager().getUserLocationId();

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        if (isAdministrator) {
            count = myAssignmentDao.geAssignedUserChecklistsAdminCount(userId, locationId);
        } else {
            count = myAssignmentDao.geAssignedUserChecklistsCount(userId, locationId);
        }

        return count;
    }

    /**
     *
     */


    public void updateStartAssignedCheckList(String uuid, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();
        String loggedInUserName = BaseApplication.getPreferenceManager().getUserFullName();

        // Verify checklist is assigned to the logged in user. If it isn't then first assign
        // checklist to the user, thereafter allow the user to resume.
        if (!isUserExists(uuid)) {
            insertUsers(uuid, checklistId, loggedInUserId, loggedInUserName);
        }

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        myAssignmentDao.updateStartAssignedChecklist(
                loggedInUserId,
                Constants.SYNC_STATUS_NOT,
                currentTime,
                uuid
        );

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(
                uuid,
                uuid,
                checklistId,
                0,
                LogTableActions.STARTED.getValue(),
                loggedInUserName,
                "Checklist Started",
                "",
                loggedInUserId
        );
    }

    public void resumeAssignedCheckList(String uuid, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();
        String loggedInUserName = BaseApplication.getPreferenceManager().getUserFullName();

        // Verify checklist is assigned to the logged in user. If it isn't then first assign
        // checklist to the user, thereafter allow the user to resume.
        if (!isUserExists(uuid)) {
            insertUsers(uuid, checklistId, loggedInUserId, loggedInUserName);
        }

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();

        AssignedCheckListPauseTimesEntity existPauseTime = myAssignmentDao.ifPauseTimeExists(uuid);

        if (existPauseTime != null) {
            myAssignmentDao.updateResumeAssignedChecklist(
                    loggedInUserId,
                    Constants.CHECL_LIST_STATUS_RESUMED,
                    Constants.SYNC_STATUS_NOT,
                    currentTime,
                    uuid
            );

            myAssignmentDao.updateAssignedCheckListPauseTimesEntity(
                    loggedInUserId,
                    Constants.RESUMED,
                    currentTime,
                    Constants.SYNC_STATUS_NOT,
                    uuid
            );

            if (existPauseTime.getSync_status().equals(Constants.SYNC_STATUS)) {
                myAssignmentDao.updateAssignedChecklistPendingElementCount(uuid);
            }

            LogsRepository logsRepository = new LogsRepository(application);
            logsRepository.insertLogs(
                    uuid,
                    uuid,
                    checklistId,
                    0,
                    LogTableActions.RESUMED.getValue(),
                    loggedInUserName,
                    "Checklist Resumed",
                    "",
                    loggedInUserId
            );
        }
    }

    private void insertUsers(String assignCheckListUUID, Integer checklistId, Integer userId, String userName) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        LogsRepository logsRepository = new LogsRepository(application);

        AssignedUserEntity assignedUserEntity = new AssignedUserEntity();
        assignedUserEntity.setUuid(AppUtility.Companion.getUuid());
        assignedUserEntity.setAssignedCheklistUUID(assignCheckListUUID);
        assignedUserEntity.setUserId(userId);
        assignedUserEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedUserEntity.setCreated(currentTime);
        assignedUserEntity.setModified(currentTime);
        assignedUserEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        assignedUserEntity.setAssignedBy(userId);

        allCheckListDao.insertUsers(assignedUserEntity);
        allCheckListDao.updateAssignedChecklistPendingElementCount(assignCheckListUUID);

        logsRepository.assignUser(assignCheckListUUID, checklistId, userId, assignedUserEntity.getUuid(), userName);
    }

    public boolean isUserExists(String assignedChecklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();

        return myAssignmentDao.isAssignedUsersExists(assignedChecklistUuid, loggedInUserId);
    }


    public List<ChecklistItemPlaceHolders> getItemPlaceholders(String checklistUUID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        DashboardDao dashboardDao = appDatabase.getDashboardDao();
        return dashboardDao.getItemPlaceHolders(checklistUUID);
    }

    public LinkedHashMap<String, List<ChecklistItemPlaceHolders>> parsePlaceHolderList
            (List<ChecklistItemPlaceHolders> checklistItemPlaceHolders) {
        LinkedHashMap<String, List<ChecklistItemPlaceHolders>> checklistItemPlaceHoldersHashMap =
                new LinkedHashMap<String, List<ChecklistItemPlaceHolders>>();

        ArrayList<ChecklistItemPlaceHolders> itemPlaceHolders = new ArrayList<>();
        String key = "";
        for (int index = 0; index < checklistItemPlaceHolders.size(); index++) {
            //for index = 0 save key
            if (index == 0) {
                key = checklistItemPlaceHolders.get(index).getSequenceNo();
                itemPlaceHolders.add(checklistItemPlaceHolders.get(index));
                //if size is 1 save the hash map
                if (index == checklistItemPlaceHolders.size() - 1)
                    checklistItemPlaceHoldersHashMap.put(key, itemPlaceHolders);
            } else if (!key.equalsIgnoreCase(checklistItemPlaceHolders.get(index).getSequenceNo())) {
                //Checks if key is same than add the value to array list
                checklistItemPlaceHoldersHashMap.put(key, itemPlaceHolders);
                key = checklistItemPlaceHolders.get(index).getSequenceNo();
                itemPlaceHolders = new ArrayList<>();
                itemPlaceHolders.add(checklistItemPlaceHolders.get(index));
                //if last item save the hash map
                if (index == checklistItemPlaceHolders.size() - 1)
                    checklistItemPlaceHoldersHashMap.put(key, itemPlaceHolders);
            } else if (index == checklistItemPlaceHolders.size() - 1) {
                //If last item save the placeholder and put into list
                itemPlaceHolders.add(checklistItemPlaceHolders.get(index));
                checklistItemPlaceHoldersHashMap.put(key, itemPlaceHolders);
            }
            else
                itemPlaceHolders.add(checklistItemPlaceHolders.get(index));
        }

        return checklistItemPlaceHoldersHashMap;
    }

}
