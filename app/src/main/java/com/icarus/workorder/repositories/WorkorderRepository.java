package com.icarus.workorder.repositories;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.SortingTag;
import com.icarus.dao.AllCheckListDao;
import com.icarus.dao.DashboardDao;
import com.icarus.dao.UserDao;
import com.icarus.database.AppDatabase;
import com.icarus.models.StringCheckBox;
import com.icarus.workorder.dao.WorkOrderDao;
import com.icarus.workorder.models.WorkOrderItems;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
public class WorkorderRepository {

    private Application application;

    public WorkorderRepository(Application application) {
        this.application = application;
    }

    public LiveData<PagedList<WorkOrderItems>> getWorkOrders(
            PagedList.Config config,
            String sortBy,
            ArrayList<StringCheckBox> statusFilterList,
            ArrayList<StringCheckBox> priorityFilterList,
            ArrayList<StringCheckBox> assignedToFilterList,
            String keyword,
            ArrayList<StringCheckBox> authorFilterList
    ) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDao workOrderDao = appDatabase.workOrderDao();
        UserDao userDao = appDatabase.userDao();
        AllCheckListDao checkListDao = appDatabase.allCheckListDao();

        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        Integer locationId = BaseApplication.getPreferenceManager().getUserLocationId();
        boolean isAdmin = BaseApplication.getPreferenceManager().getIsAdmin();

        // If user is not administrator, then check is user is a QCM for the location chosen
        // In case the user is then set isAdmin to the value of isQCM
        if (!isAdmin) {
            isAdmin = userDao.isQCM(userId, locationId);
        }

        List<String> statusIds = new ArrayList<>();
        List<Integer> priorityLevels = new ArrayList<>();
        List<StringCheckBox> departments;
        List<Integer> departmentIds = new ArrayList<>();
        keyword = "%" + keyword + "%";
        Integer assignedTo = null;
        Integer authorId = null;

        if (isAdmin) {
            departments = checkListDao.getDepartmentFilterList(locationId);
        } else {
            departments = checkListDao.getDepartmentFilterList(userId, locationId);
        }

        for (StringCheckBox department : departments) {
            departmentIds.add(department.getId());
        }

        if (statusFilterList != null) {
            List<String> selectedStatusIds = new ArrayList<>();

            for (StringCheckBox stringCheckBox : statusFilterList) {
                String statusId = String.valueOf(stringCheckBox.getId());

                if (stringCheckBox.getId() != -1) {
                    statusIds.add(statusId);

                    if (stringCheckBox.isSelected()) {
                        selectedStatusIds.add(statusId);
                    }
                }
            }

            if (selectedStatusIds.size() > 0) {
                statusIds = selectedStatusIds;
            }
        }

        if (priorityFilterList != null) {
            List<Integer> selectedPriority = new ArrayList<>();

            for (StringCheckBox stringCheckBox : priorityFilterList) {
                Integer priority = stringCheckBox.getId();

                if (stringCheckBox.getPosition() != -1) {
                    priorityLevels.add(priority);

                    if (stringCheckBox.isSelected()) {
                        selectedPriority.add(priority);
                    }
                }
            }

            if (selectedPriority.size() > 0) {
                priorityLevels = selectedPriority;
            }
        }

        if (assignedToFilterList != null) {
            for (StringCheckBox stringCheckBox : assignedToFilterList) {
                if (stringCheckBox.getPosition() != 0 && stringCheckBox.isSelected()) {
                    assignedTo = stringCheckBox.getId();
                }
            }
        }

        if (authorFilterList != null) {
            for (StringCheckBox user : authorFilterList) {
                if (user.isSelected()) {
                    authorId = userId;
                }
            }
        }

        DataSource.Factory<Integer, WorkOrderItems> factory;

        if (sortBy.equalsIgnoreCase(SortingTag.DUE_DATE_DESC)) {
            if (isAdmin) {
                factory = workOrderDao.getAdminWorkOrderDueDateDESC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            } else {
                factory = workOrderDao.getWorkOrderDueDateDESC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            }
        } else if (sortBy.equalsIgnoreCase(SortingTag.ID_ASC)) {
            if (isAdmin) {
                factory = workOrderDao.getAdminWorkOrderIdASC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            } else {
                factory = workOrderDao.getWorkOrderIdASC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            }
        } else if (sortBy.equalsIgnoreCase(SortingTag.ID_DESC)) {
            if (isAdmin) {
                factory = workOrderDao.getAdminWorkOrderIdDESC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            } else {
                factory = workOrderDao.getWorkOrderIdDESC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            }
        } else if (sortBy.equalsIgnoreCase(SortingTag.NAME_ASC)) {
            if (isAdmin) {
                factory = workOrderDao.getAdminWorkOrderNameASC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            } else {
                factory = workOrderDao.getWorkOrderNameASC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            }
        } else if (sortBy.equalsIgnoreCase(SortingTag.NAME_DESC)) {
            if (isAdmin) {
                factory = workOrderDao.getAdminWorkOrderNameDESC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            } else {
                factory = workOrderDao.getWorkOrderNameDESC(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            }
        } else {
            if (isAdmin) {
                factory = workOrderDao.getAdminWorkOrder(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            } else {
                factory = workOrderDao.getWorkOrder(locationId, userId, statusIds, priorityLevels, authorId, assignedTo, departmentIds, keyword);
            }
        }

        return new LivePagedListBuilder<>(factory, config).build();
    }


    public LiveData<Integer> getWorkOrderChecklistCount() {
        LiveData<Integer> count;
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        WorkOrderDao workOrderDao = appDatabase.workOrderDao();
        UserDao userDao = appDatabase.userDao();
        AllCheckListDao checkListDao = appDatabase.allCheckListDao();
        DashboardDao dashboardDao = appDatabase.getDashboardDao();

        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        Integer locationId = BaseApplication.getPreferenceManager().getUserLocationId();

        boolean isAdmin = BaseApplication.getPreferenceManager().getIsAdmin();
// If user is not administrator, then check is user is a QCM for the location chosen
        // In case the user is then set isAdmin to the value of isQCM
        if (!isAdmin) {
            isAdmin = userDao.isQCM(userId, locationId);
        }
        List<StringCheckBox> statuses;
        statuses = dashboardDao.getStatusWorkOrder();

        List<Integer> statusIds = new ArrayList<>();
        for (StringCheckBox department : statuses) {
            statusIds.add(department.getId());
        }

        List<Integer> priorityIds = new ArrayList<>();
        int[] priorityList = application.getResources().getIntArray(R.array.priority_id);
        for (int id : priorityList) {
            if (id != -1)
                priorityIds.add(id);
        }
        List<StringCheckBox> departments;
        if (isAdmin) {
            departments = checkListDao.getDepartmentFilterList(locationId);
        } else {
            departments = checkListDao.getDepartmentFilterList(userId, locationId);
        }

        List<Integer> departmentIds = new ArrayList<>();
        for (StringCheckBox department : departments) {
            departmentIds.add(department.getId());
        }

        if (isAdmin) {
            count = workOrderDao.getWorkOrderAdminCount(locationId, statusIds, priorityIds);
        } else
            count = workOrderDao.getWorkOrderCount(userId, locationId, statusIds, priorityIds, departmentIds);
        return count;
    }
}
