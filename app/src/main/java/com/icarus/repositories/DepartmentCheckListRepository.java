package com.icarus.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.dao.AllCheckListDao;
import com.icarus.dao.DepartmentChecklistDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.AsssignedDepartmentsEntity;
import com.icarus.enums.LogTableActions;
import com.icarus.models.DepartmentChecklistItems;
import com.icarus.models.StringCheckBox;
import com.icarus.util.AppUtility;

import java.util.ArrayList;
import java.util.List;

public class DepartmentCheckListRepository {
    Application application;

    public DepartmentCheckListRepository(Application application) {
        this.application = application;
    }

    /**
     * @param sortBy
     * @param statusBy
     * @param typeBy
     * @param departmentBy
     * @return
     */
    public LiveData<PagedList<DepartmentChecklistItems>> getDepartmentChecklist(
            PagedList.Config config,
            String sortBy,
            ArrayList<StringCheckBox> statusBy,
            ArrayList<StringCheckBox> typeBy,
            ArrayList<StringCheckBox> departmentBy,
            String keyword
    ) {
        keyword = "%" + keyword + "%";

        List<String> statuses = new ArrayList<>();
        List<String> types = new ArrayList<>();
        List<String> departments = new ArrayList<>();

        if (statusBy != null) {
            List<String> selectedStatuses = new ArrayList<>();

            for (StringCheckBox stringCheckBox : statusBy) {
                String status = stringCheckBox.getTitle();
                if (stringCheckBox.getPosition() != 0)
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
                if (item.getId() != 0)
                    types.add(id);

                if (item.getId() != 0 && item.isSelected()) {
                    selectedType.add(id);
                }
            }

            if (selectedType.size() > 0)
                types = selectedType;
        }


        if (departmentBy != null) {
            List<String> selectedDepartments = new ArrayList<>();

            for (StringCheckBox stringCheckBox : departmentBy) {
                String id = String.valueOf(stringCheckBox.getId());
                if (stringCheckBox.getPosition() != 0)
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
        DepartmentChecklistDao departmentChecklistDao = appDatabase.departmentChecklistDao();
        DataSource.Factory<Integer, DepartmentChecklistItems> factory;

        int userId = BaseApplication.getPreferenceManager().getUserId();
        int locationId = BaseApplication.getPreferenceManager().getUserLocationId();
        boolean isAdministrator = BaseApplication.getPreferenceManager().getIsAdmin();

        if (sortBy.equals(SortingTag.MODIFIED_DESC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByRecentUpdatedAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByRecentUpdated(userId, locationId, departments, types, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.MODIFIED_ASC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByOldestUpdatedAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByOldestUpdated(userId, locationId, departments, types, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.DUE_DATE_DESC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByLatestDueAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByLatestDue(userId, locationId, departments, types, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.NAME_ASC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByTitleAZAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByTitleAZ(userId, locationId, departments, types, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.NAME_DESC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByTitleZAAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByTitleZA(userId, locationId, departments, types, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.STATUS_ASC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByStatusASCAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByStatusASC(userId, locationId, departments, types, statuses, keyword);
            }
        } else if (sortBy.equals(SortingTag.STATUS_DESC)) {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByStatusDESCAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByStatusDESC(userId, locationId, departments, types, statuses, keyword);
            }
        } else {
            if (isAdministrator) {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByOldestDueAdmin(userId, locationId, departments, types, statuses, keyword);
            } else {
                factory = departmentChecklistDao.getAssignedDepartmentChecklistsOrderByOldestDue(userId, locationId, departments, types, statuses, keyword);
            }
        }

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     * @param uuid        Assigned Checklist uuid
     * @param checklistID
     */

    public void startAssignedCheckList(String uuid, Integer checklistID) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        DepartmentChecklistDao departmentChecklistDao = appDatabase.departmentChecklistDao();
        departmentChecklistDao.updateStartAssignedChecklist(uuid, BaseApplication.getPreferenceManager().getUserId(), currentTime);


        AsssignedDepartmentsEntity asssignedDepartmentsEntity = new AsssignedDepartmentsEntity();
        asssignedDepartmentsEntity.setAssigned_checklist_uuid(uuid);
        asssignedDepartmentsEntity.setIs_deleted(Constants.DELETED);
        asssignedDepartmentsEntity.setModified(currentTime);
        departmentChecklistDao.updateAsssignedDepartmentsEntity(uuid, currentTime);

        insertUsers(uuid, checklistID);

    }

    /**
     * @param assignCheckListUUID
     * @param checklistId
     */
    private void insertUsers(String assignCheckListUUID, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        AssignedUserEntity assignedUserEntity = new AssignedUserEntity();
        assignedUserEntity.setUuid(AppUtility.Companion.getUuid());
        assignedUserEntity.setAssignedCheklistUUID(assignCheckListUUID);
        assignedUserEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        assignedUserEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedUserEntity.setCreated(currentTime);
        assignedUserEntity.setModified(currentTime);
        assignedUserEntity.setAssignedBy(BaseApplication.getPreferenceManager().getUserId());
        assignedUserEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        allCheckListDao.insertUsers(assignedUserEntity);

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(assignedUserEntity.getUuid(), assignCheckListUUID, checklistId, null, LogTableActions.ASSIGNED.getValue(), BaseApplication.getPreferenceManager().getUserFullName(), "Checklist Assigned", null, BaseApplication.getPreferenceManager().getUserId());
        logsRepository.insertLogs(assignedUserEntity.getUuid(), assignCheckListUUID, checklistId, null, LogTableActions.STARTED.getValue(), BaseApplication.getPreferenceManager().getUserFullName(), "Checklist Started", null, BaseApplication.getPreferenceManager().getUserId());

    }


    public LiveData<Integer> getMyDepartmentChecklistCount(){
        LiveData<Integer> count;

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        DepartmentChecklistDao departmentChecklistDao = appDatabase.departmentChecklistDao();

        int userId = BaseApplication.getPreferenceManager().getUserId();
        int locationId = BaseApplication.getPreferenceManager().getUserLocationId();
        boolean isAdministrator = BaseApplication.getPreferenceManager().getIsAdmin();

        if (isAdministrator) {
            count = departmentChecklistDao.getAssignedDepartmentChecklistsAdminCount(userId, locationId);
        } else {
            count = departmentChecklistDao.getAssignedDepartmentChecklistsCount(userId, locationId);
        }
        return count;
    }
}
