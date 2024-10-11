package com.icarus.repositories;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.LogsDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.LogsEntity;
import com.icarus.enums.LogTableActions;
import com.icarus.util.AppUtility;

import android.app.Application;

public class LogsRepository {

    Application application;

    public LogsRepository(Application application) {
        this.application = application;
    }

    /**
     * @param itemUuid              UUID fetched or saved in item table
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param checklist_id          ID of Checklist
     * @param checklist_element_id  ID of the element being executed
     * @param action                0 if removed or No, 1 if applied or Yes, 12 if skipped, 13 if deferred
     * @param assignedtoName        Full name of the user logged in and executing the element
     * @param itemDescription       Text of the item (decision point,NCW etc)
     * @param itemAction
     * @param assignedTo
     */


    public void insertLogs(String itemUuid, String assignedChecklistUuid, Integer checklist_id, Integer checklist_element_id, Integer action, String assignedtoName, String itemDescription, String itemAction, Integer assignedTo) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        LogsDao logsDao = appDatabase.getLogsDao();

        String currentTime = AppUtility.Companion.getUtcTime();
        LogsEntity logsEntity = new LogsEntity();
        logsEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        logsEntity.setAction(action);
        logsEntity.setAssignedToName(assignedtoName);
        if (checklist_element_id !=null && checklist_element_id == 0) checklist_element_id = null;
        logsEntity.setChecklistElementId(checklist_element_id);
        logsEntity.setItemUuid(itemUuid);
        logsEntity.setModified(currentTime);
        logsEntity.setChecklistId(checklist_id);
        logsEntity.setItemDescription(itemDescription);
        logsEntity.setUuid(AppUtility.Companion.getUuid());
        logsEntity.setCreated(currentTime);
        logsEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        logsEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        logsEntity.setAssignedTo(assignedTo);
        logsEntity.setStepAction(itemAction);
        logsEntity.setUsername(BaseApplication.getPreferenceManager().getUserFullName());


        logsDao.insertLogs(logsEntity);


        logsDao.updateCheckList(assignedChecklistUuid, currentTime);
        logsDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);

    }

    public void assignUser(
            String assignChecklistUuid,
            Integer checklistId,
            Integer userId,
            String userUuid,
            String userName
    ) {
        this.insertLogs(
                userUuid,
                assignChecklistUuid,
                checklistId,
                0,
                LogTableActions.ASSIGNED.getValue(),
                userName,
                "Checklist Assigned",
                "",
                userId
        );
    }

    public void divestUser(
            String assignChecklistUuid,
            Integer checklistId,
            Integer userId,
            String userUuid,
            String userName
    ) {
        this.insertLogs(
                userUuid,
                assignChecklistUuid,
                checklistId,
                0,
                LogTableActions.UNASSIGNED.getValue(),
                userName,
                "Checklist Divested",
                "",
                userId
        );
    }

    /**
     * @param itemUuid              UUID fetched or saved in item table
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param checklist_id          ID of Checklist
     * @param checklist_element_id  ID of the element being executed
     * @param action                0 if removed or No, 1 if applied or Yes, 12 if skipped, 13 if deferred
     * @param assignedtoName        Full name of the user logged in and executing the element
     * @param itemDescription       Text of the item (decision point,NCW etc)
     * @param itemAction
     * @param assignedTo
     */


    public void insertLogs(String itemUuid, String assignedChecklistUuid, Integer checklist_id, Integer checklist_element_id, Integer action, String assignedtoName, String itemDescription, String itemAction, Integer assignedTo, String userName) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        LogsDao logsDao = appDatabase.getLogsDao();

        String currentTime = AppUtility.Companion.getUtcTime();
        LogsEntity logsEntity = new LogsEntity();
        logsEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        logsEntity.setAction(action);
        logsEntity.setAssignedToName(assignedtoName);
        if (checklist_element_id == 0) checklist_element_id = null;
        logsEntity.setChecklistElementId(checklist_element_id);
        logsEntity.setItemUuid(itemUuid);
        logsEntity.setModified(currentTime);
        logsEntity.setChecklistId(checklist_id);
        logsEntity.setItemDescription(itemDescription);
        logsEntity.setUuid(AppUtility.Companion.getUuid());
        logsEntity.setCreated(currentTime);
        logsEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        logsEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        logsEntity.setAssignedTo(assignedTo);
        logsEntity.setStepAction(itemAction);
        logsEntity.setUsername(userName);

     /*   if(itemDescription!=null) {
            String uuid = logsDao.getUuid(checklist_element_id,assignedChecklistUuid);
            if(uuid!=null && uuid.length()>0){
                logsEntity.setUuid(uuid);
                logsDao.updateLogs(logsEntity);
            }else {*/
        logsDao.insertLogs(logsEntity);
        // }

        //   }

        logsDao.updateCheckList(assignedChecklistUuid, currentTime);
        logsDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);

    }
}
