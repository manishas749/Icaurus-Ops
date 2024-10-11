package com.icarus.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.AllCheckListDao;
import com.icarus.dao.CheckListDetailDao;
import com.icarus.dao.ChecklistExecutionDao;
import com.icarus.dao.MyAssignmentDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.models.CheckListPPItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.ChecklistIDetailtems;
import com.icarus.models.UserItems;
import com.icarus.util.AppUtility;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by Monika Rana on 12/28/2018.
 */

public class ChecklistDetailRepository {
    private Application mApplication;

    public ChecklistDetailRepository(Application context) {
        mApplication = context;
    }

    /**
     *
     */
    public LiveData<PagedList<ChecklistElementItem>> getChecklistDetailList(PagedList.Config config, Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        DataSource.Factory<Integer, ChecklistElementItem> factory;

        factory = allCheckListDao.getCheckListDetail(checkListId, checkListUuid);

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     *
     */
    public LiveData<PagedList<ChecklistDetailItems>> getChecklistDetailIncompleteElements(PagedList.Config config, Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        DataSource.Factory<Integer, ChecklistDetailItems> factory;

        factory = allCheckListDao.getChecklistIncompleteElements(checkListId, checkListUuid);

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }


    /**
     *
     */
    public LiveData<PagedList<ChecklistElementItem>> getChecklistDetailListSkipped(PagedList.Config config, Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        DataSource.Factory<Integer, ChecklistElementItem> factory;

        factory = allCheckListDao.getCheckListDetailSkippedDeferred(checkListId, checkListUuid, ChecklistExecutionStatus.SKIPPED.getValue());

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     *
     */
    public LiveData<PagedList<ChecklistElementItem>> getChecklistDetailListDeffered(PagedList.Config config, Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        DataSource.Factory<Integer, ChecklistElementItem> factory;

        factory = allCheckListDao.getCheckListDetailSkippedDeferred(checkListId, checkListUuid, ChecklistExecutionStatus.DEFERRED.getValue());

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     *
     */
    public LiveData<Integer> getPendingElementCount(Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        return allCheckListDao.getPendingElementCount(checkListId, checkListUuid);
    }

    /**
     *
     */
    public LiveData<Integer> getTotalElementCount(Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        return allCheckListDao.getTotalElementCount(checkListId, checkListUuid);
    }

    /**
     *
     */
    public Integer getTotalElementCountForMarkComplete(Integer checkListId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        return allCheckListDao.getTotalElementCountInteger(checkListId, checkListUuid);
    }

    /**
     *
     */
    public void pauseAssignedCheckList(String uuid, String reason, Integer checklistId) {

        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();

        AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity = new AssignedCheckListPauseTimesEntity();
        assignedCheckListPauseTimesEntity.setUuid(AppUtility.Companion.getUuid());
        assignedCheckListPauseTimesEntity.setSync_status(Constants.SYNC_STATUS_NOT);
        assignedCheckListPauseTimesEntity.setIs_paused(Constants.PAUSED_YES);
        assignedCheckListPauseTimesEntity.setAssigned_checklist_uuid(uuid);
        assignedCheckListPauseTimesEntity.setUser_id(BaseApplication.getPreferenceManager().getUserId());
        assignedCheckListPauseTimesEntity.setIs_deleted(Constants.NOT_DELETED);
        assignedCheckListPauseTimesEntity.setResumed_by_user_id(null);
        assignedCheckListPauseTimesEntity.setReason(reason);
        assignedCheckListPauseTimesEntity.setCreated(currentTime);
        assignedCheckListPauseTimesEntity.setModified(currentTime);

        allCheckListDao.insertAssignedCheckListPauseTimesEntity(assignedCheckListPauseTimesEntity);
        allCheckListDao.updateAssignedChecklistPendingElementCount(uuid);

        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        myAssignmentDao.updateResumeAssignedChecklist(BaseApplication.getPreferenceManager().getUserId(), Constants.CHECL_LIST_STATUS_PAUSED, Constants.SYNC_STATUS_NOT, currentTime, uuid);

        LogsRepository logsRepository = new LogsRepository(mApplication);
        logsRepository.insertLogs(uuid, uuid, checklistId, 0, LogTableActions.PAUSED.getValue(), BaseApplication.getPreferenceManager().getUserFullName(), reason, "", BaseApplication.getPreferenceManager().getUserId());

    }

    /**
     *
     */
    public void cancelCheckList(String uuid, Integer checklistId, String reason) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        myAssignmentDao.updateResumeAssignedChecklist(BaseApplication.getPreferenceManager().getUserId(), Constants.CHECL_LIST_STATUS_CANCELLED, Constants.SYNC_STATUS_NOT, currentTime, uuid);

        LogsRepository logsRepository = new LogsRepository(mApplication);
        logsRepository.insertLogs(uuid, uuid, checklistId, 0, LogTableActions.CANCELED.getValue(), BaseApplication.getPreferenceManager().getUserFullName(), reason, "", BaseApplication.getPreferenceManager().getUserId());


    }

    /**
     *
     */
    public void completeChecklist(String uuid, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        MyAssignmentDao myAssignmentDao = appDatabase.myAssignmentDao();
        myAssignmentDao.updateResumeAssignedChecklist(BaseApplication.getPreferenceManager().getUserId(), Constants.CHECK_LIST_STATUS_COMPLETED, Constants.SYNC_STATUS_NOT, currentTime, uuid);

        LogsRepository logsRepository = new LogsRepository(mApplication);
        logsRepository.insertLogs(uuid, uuid, checklistId, 0, LogTableActions.COMPLETED.getValue(), BaseApplication.getPreferenceManager().getUserFullName(), "Checklist Completed", "", BaseApplication.getPreferenceManager().getUserId());
    }

    /**
     *
     */
    public List<CheckListPPItems> getCheckListPPForInformationPopUp(Integer checkListId) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getInformationIcons(checkListId);
    }

    /**
     * Method to return a list of user's who can be assigned to an assigned checklist. If a user is
     * already assigned to the checklist, they would be set as selected.
     * <p>
     * The user's returned are user's which belong to the same location and department as that
     * of the assigned checklist or if they are administrators.
     * <p>
     * Note: If the assigned checklist was first assigned to a department then the department
     * referenced is the department to which it was assigned, else the department of the checklist
     * at the time of assignment.
     *
     * @param assignedChecklistUuid UUID of the Assigned Checklist
     * @param departmentId          Department ID of the Assigned Checklist
     * @return List of UserItems
     */
    public List<UserItems> getUsersForAssignment(String assignedChecklistUuid, Integer departmentId) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        Integer locationId = BaseApplication.getPreferenceManager().getUserLocationId();

        List<UserItems> userItemsList;

        if (departmentId == null || departmentId == 0) {
            userItemsList = checklistExecutionDao.getUsersForTheLocation(assignedChecklistUuid, locationId);
        } else {
            userItemsList = checklistExecutionDao.getUsersForTheLocation(assignedChecklistUuid, locationId, departmentId);
        }

        for (UserItems userItem : userItemsList) {
            if (userItem.getAssignedChecklistUuid() != null) {
                userItem.setSelected(true);
            }
        }

        return userItemsList;
    }

    /**
     *
     */
    public void insertUsers(List<UserItems> users, String assignCheckListUUID, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        AllCheckListDao allCheckListDao = appDatabase.allCheckListDao();
        LogsRepository logsRepository = new LogsRepository(mApplication);

        for (UserItems assignedUser: users) {
            AssignedUserEntity assignedUserEntity = new AssignedUserEntity();
            assignedUserEntity.setAssignedCheklistUUID(assignCheckListUUID);
            assignedUserEntity.setAssignedBy(BaseApplication.getPreferenceManager().getUserId());
            assignedUserEntity.setUserId(assignedUser.getId());
            assignedUserEntity.setIsDeleted(Constants.NOT_DELETED);
            assignedUserEntity.setCreated(currentTime);
            assignedUserEntity.setModified(currentTime);
            assignedUserEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);

            AssignedUserEntity existUser = allCheckListDao.ifUserExist(assignedUser.getId(), assignCheckListUUID);

            // If a new user is being assigned to the checklist, then we can directly insert it
            if (existUser == null && assignedUser.isSelected()) {
                assignedUserEntity.setUuid(AppUtility.Companion.getUuid());

                allCheckListDao.insertUsers(assignedUserEntity);
                allCheckListDao.updateAssignedChecklistPendingElementCount(assignCheckListUUID);
                logsRepository.assignUser(assignCheckListUUID, checklistId, assignedUser.getId(), assignedUser.getUuid(), assignedUser.getFullName());
            } else if (existUser != null) {
                assignedUserEntity.setUuid(existUser.getUuid());
                assignedUserEntity.setCreated(existUser.getCreated());

                // If a user already exists, then we verify the new state of the user.
                // In case the user was earlier selected and now removed, we update the corresponding record.
                // In case the user was earlier not selected but now has been, then we again update the record.
                if (assignedUser.isSelected()
                        && existUser.isDeleted.equals(Constants.DELETED)) {
                    allCheckListDao.updateUsers(assignedUserEntity);
                    logsRepository.assignUser(assignCheckListUUID, checklistId, assignedUser.getId(), assignedUser.getUuid(), assignedUser.getFullName());

                    if (existUser.getSyncStatus().equals(Constants.SYNC_STATUS)) {
                        allCheckListDao.updateAssignedChecklistPendingElementCount(assignCheckListUUID);
                    }
                }

                if (!assignedUser.isSelected()
                        && existUser.isDeleted.equals(Constants.NOT_DELETED)) {
                    assignedUserEntity.setIsDeleted(Constants.DELETED);

                    allCheckListDao.updateUsers(assignedUserEntity);
                    logsRepository.divestUser(assignCheckListUUID, checklistId, assignedUser.getId(), assignedUser.getUuid(), assignedUser.getFullName());

                    if (existUser.getSyncStatus().equals(Constants.SYNC_STATUS)) {
                        allCheckListDao.updateAssignedChecklistPendingElementCount(assignCheckListUUID);
                    }
                }
            }
        }
    }

    public void executeStep(String assignedChecklistUuid, Integer stepId, Integer checklistElementId, Integer status, Integer checklistid, Integer elementId, Integer action, String stepDescription, String reasonToSkipDeffer) {

        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();

        String currentTime = AppUtility.Companion.getUtcTime();

        AssignedStepEntity assignedStepEntity = new AssignedStepEntity();
        assignedStepEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        assignedStepEntity.setStepId(stepId);
        assignedStepEntity.setChecklistElementId(checklistElementId);
        assignedStepEntity.setStatus(status);
        assignedStepEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        assignedStepEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedStepEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        assignedStepEntity.setCreated(currentTime);
        assignedStepEntity.setModified(currentTime);

        String uuid = "";
        int syncStatus = -1;
        AssignedStepEntity existSteps = checklistExecutionDao.getAssignedStepUuid(stepId, assignedChecklistUuid);
        if (existSteps != null && !TextUtils.isEmpty(existSteps.getUuid())) {
            syncStatus = existSteps.getSyncStatus();
            uuid = existSteps.getUuid();
            assignedStepEntity.setUuid(uuid);
            checklistExecutionDao.updateAssignedStep(assignedStepEntity);
        } else {
            uuid = AppUtility.Companion.getUuid();
            assignedStepEntity.setUuid(uuid);
            checklistExecutionDao.insertAssignedStep(assignedStepEntity);
        }

        if (existSteps == null || syncStatus != Constants.SYNC_STATUS_NOT) {
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);
        }

        LogsRepository logsRepository = new LogsRepository(mApplication);
        if (status == 1)
            logsRepository.insertLogs(uuid, assignedChecklistUuid, checklistid, elementId, action, null, stepDescription, null, null);
        else
            logsRepository.insertLogs(uuid, assignedChecklistUuid, checklistid, elementId, action, null, reasonToSkipDeffer, null, null);

    }

    public ChecklistIDetailtems getChecklistDetail(String checklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(mApplication);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getChecklistDetail(checklistUuid);
    }

}
