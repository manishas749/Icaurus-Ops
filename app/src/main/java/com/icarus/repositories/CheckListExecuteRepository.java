package com.icarus.repositories;

import android.app.Application;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.CheckListDetailDao;
import com.icarus.dao.ChecklistExecutionDao;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.MyAssignmentDao;
import com.icarus.dao.QRStepAttributeExecutionDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.models.CaptureDataItem;
import com.icarus.models.CheckListPPItems;
import com.icarus.models.CheckListStepAttributeItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistIDetailtems;
import com.icarus.models.NcwHazardsItems;
import com.icarus.models.NonExecutedChildElement;
import com.icarus.models.ParentDetailItem;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.models.ResourceLinkItems;
import com.icarus.models.SelectedFile;
import com.icarus.models.UserItems;
import com.icarus.models.UserMinimal;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.ChecklistElementsApi;
import com.icarus.util.AppUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.MD5;
import com.icarus.util.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * For Execution of elements
 */
public class CheckListExecuteRepository {

    Application application;

    public CheckListExecuteRepository(Application application) {
        this.application = application;
    }


    /**
     *
     */

    public ChecklistDetailItems getChecklistElement(int currentSortOrder, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getItem(currentSortOrder, checkListUuid);
    }

    /**
     *
     */

    public ChecklistDetailItems getChecklistSkippedElement(int currentSortOrder, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getSkippedItem(currentSortOrder, checklistId, checkListUuid);
    }

    /**
     *
     */

    public ChecklistDetailItems getChecklistDefferedElement(int currentSortOrder, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getDefferedItem(currentSortOrder, checklistId, checkListUuid);
    }

    /**
     * @param currentSortOrder sort order of current element
     */

    public ChecklistDetailItems getChecklistPreviousElement(int currentSortOrder, String checkListUuid, Integer checklistId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        ChecklistDetailItems item = checklistExecutionDao.getPreviousItem(currentSortOrder, checkListUuid, checklistId);
        return item == null || item.getChecklistId() == 0 ? null : item;
    }

    /**
     * @param currentSortOrder sort order of current element
     */

    public ChecklistDetailItems getChecklistPreviousSkipedElement(int currentSortOrder, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        ChecklistDetailItems item = checklistExecutionDao.getPreviousSkippedItem(currentSortOrder, checklistId, checkListUuid);
        return item == null || item.getChecklistId() == 0 ? null : item;
    }

    /**
     * @param currentSortOrder sort order of current element
     */

    public ChecklistDetailItems getChecklistPreviousDefferedElement(int currentSortOrder, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        ChecklistDetailItems item = checklistExecutionDao.getPreviousDefferedItem(currentSortOrder, checklistId, checkListUuid);
        return item == null || item.getChecklistId() == 0 ? null : item;
    }

    /**
     * @param currentSortOrder sort order of current element
     */

    public ChecklistDetailItems getChecklistNextElement(int currentSortOrder, String checkListUuid, Integer checklistId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        ChecklistDetailItems item = checklistExecutionDao.getNextItem(currentSortOrder, checkListUuid, checklistId);
        return item == null || item.getChecklistId() == 0 ? null : item;
    }

    /**
     * @param currentSortOrder sort order of current element
     */

    public ChecklistDetailItems getChecklistNextSkippedElement(int currentSortOrder, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        ChecklistDetailItems item = checklistExecutionDao.getNextSkippedItem(currentSortOrder, checklistId, checkListUuid);
        return item == null || item.getChecklistId() == 0 ? null : item;
    }

    /**
     * @param currentSortOrder sort order of current element
     */

    public ChecklistDetailItems getChecklistNextDefferedElement(int currentSortOrder, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        ChecklistDetailItems item = checklistExecutionDao.getNextDefferedItem(currentSortOrder, checklistId, checkListUuid);
        return item == null || item.getChecklistId() == 0 ? null : item;
    }

    /**
     *
     */

    public ChecklistDetailItems getChecklistElementDeferred(int offset, int checklistId, String checkListUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getNextItemDeffered(offset, checklistId, checkListUuid);
    }


    /**
     *
     */
    public List<CheckListStepAttributeItems> getStepAttributes(String stepId, Integer elementId, String assignedChecklostUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getStepElments(stepId, elementId, assignedChecklostUuid);

    }

    /**
     * @param stepId ID of Step
     */
    public List<CheckListPPItems> getCheckListPP(Integer stepId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getPPIcons(stepId);
    }

    /**
     * @param itemId ID of procedure/Step/DS
     */
    public List<NcwHazardsItems> getNcwHazards(Integer itemId, Integer itemTypeId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getNcmHazards(itemId, itemTypeId);
    }

    /**
     * @param itemId ID of procedure/Step/DS
     */
    public List<ResourceEntity> getChecklistReferences(Integer itemId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getCheckListReferances(itemId);
    }

    /**
     * @param itemId ID of procedure/Step/DS
     */
    public ResourceEntity getChecklistResource(Integer itemId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getResource(itemId);
    }

    /**
     * @param itemId ID of procedure/Step/DS
     */
    public List<ResourceEntity> getCheckListResourcesEmbedded(Integer itemId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getCheckListResourcesEmbedded(itemId);
    }

    /**
     * Returns a list of user's based on the department id and group ids provided, for the location
     * currently selected.
     * <p>
     * If group ids are null or empty then user's belonging to any group would be returned
     * If department id is null or zero then all user's in that location irrespective of their
     * departments will be returned
     *
     * @param departmentId Department ID of the Assigned Checklist
     * @param groupIds     Group Ids of permitted users
     * @return List of User's (id, uuid, groupId, fullName)
     */

    public List<UserItems> getUsersByGroupId(Integer departmentId, String groupIds) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        Integer locationId = BaseApplication.getPreferenceManager().getUserLocationId();

        if (groupIds == null || TextUtils.isEmpty(groupIds)) {
            groupIds = checklistExecutionDao.getGroupIds();
        }

        String[] allowedRoleIds = groupIds.split(",");

        if (departmentId == null || departmentId == 0) {
            checklistExecutionDao.getUsers(locationId, allowedRoleIds);
        }

        return checklistExecutionDao.getUsers(locationId, departmentId, allowedRoleIds);
    }

    /**
     * @param itemId ID of procedure/Step/DS
     */

    public List<ResourceLinkItems> getResourcesLinks(Integer itemId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getResourceLinks(itemId);
    }

    /**
     * @param checklistId Id of the checklist
     * @param parentId    ID of Step
     */
    public List<ChecklistDetailItems> getStepEmbedded(String checklistUuid, Integer checklistId, Integer parentId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getStepEmbeddedImages(checklistUuid, checklistId, parentId);
    }

    /**
     * Execution of NCW elements
     *
     * @param checkListUuid      UUID of assigned checklist
     * @param itemTypeId         4 if caution, 5 if note, 6 if warning
     * @param checklistElementId ID of the element being executed
     * @param itemId             ID of note/caution/warning
     * @param acknowledge        0 if pending, 1 if acknowledged, 2 if skipped, 3 if deferred
     * @param checklistid        ID of Checklist
     * @param itemDescription    TEXT of note/caution/warning
     */
    public void executeNCW(String checkListUuid, Integer itemTypeId, Integer checklistElementId,
                           Integer itemId, Integer acknowledge, Integer checklistid,
                           String itemDescription, String reasonToSkipDeffer) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        AssignedNCWEntity existNCW = checklistExecutionDao.ifNCWAlreadyUpdated(checkListUuid, checklistElementId);
        String uuid = "";
        int syncStatus = -1;
        if (existNCW != null && !TextUtils.isEmpty(existNCW.getUuid())) {
            syncStatus = existNCW.getSync_status();
            uuid = existNCW.getUuid();
            String currentTime = AppUtility.Companion.getUtcTime();
            checklistExecutionDao.updateNCWExection(uuid, acknowledge, BaseApplication.getPreferenceManager().getUserId(), currentTime);
        } else {
            uuid = AppUtility.Companion.getUuid();
            String currentTime = AppUtility.Companion.getUtcTime();
            AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
            assignedNCWEntity.setAcknowledged(acknowledge);
            assignedNCWEntity.setAssigned_checklist_uuid(checkListUuid);
            assignedNCWEntity.setItemId(itemId);
            assignedNCWEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
            assignedNCWEntity.setUuid(uuid);
            assignedNCWEntity.setChecklistElementId(checklistElementId);
            assignedNCWEntity.setIs_deleted(Constants.NOT_DELETED);
            assignedNCWEntity.setItemTypeId(itemTypeId);
            assignedNCWEntity.setModified(currentTime);
            assignedNCWEntity.setCreated(currentTime);
            assignedNCWEntity.setSync_status(Constants.SYNC_STATUS_NOT);
            checklistExecutionDao.insertNCWExection(assignedNCWEntity);
        }
        if (existNCW == null || syncStatus != Constants.SYNC_STATUS_NOT) {
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(checkListUuid);
        }

        LogsRepository logsRepository = new LogsRepository(application);

        if (acknowledge == 1)
            acknowledge = 5;
        else if (acknowledge == ChecklistExecutionStatus.SKIPPED.getValue())
            acknowledge = LogTableActions.SKIPPED.getValue();
        else if (acknowledge == ChecklistExecutionStatus.DEFERRED.getValue())
            acknowledge = LogTableActions.DEFERRED.getValue();

        if (itemDescription == null)
            itemDescription = "";
        if (acknowledge == LogTableActions.SKIPPED.getValue() || acknowledge == LogTableActions.DEFERRED.getValue())
            logsRepository.insertLogs(uuid, checkListUuid, checklistid, checklistElementId, acknowledge, null, reasonToSkipDeffer
                    , null, null);
        else
            logsRepository.insertLogs(uuid, checkListUuid, checklistid, checklistElementId, acknowledge, null, itemDescription, null, null);
    }


    /**
     * Execution of Assigned Decision
     *
     * @param checkListUuid      UUID of assigned checklist
     * @param checkListElementId ID of the element being executed
     * @param status             0 if removed or No, 1 if applied or Yes, 2 if skipped, 3 if
     *                           deferred
     * @param itemDescription    TEXT of the decision point
     * @param checklistid        ID of Checklist
     */
    public void executeDecisionPoints(String checkListUuid, Integer checkListElementId, Integer status, String itemDescription, Integer checklistid, Integer decisionId, String reasonToSkipDeffer) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        AssignedDecisionEntity existDecision = checklistExecutionDao.ifDecisionPointAlreadyUpdated(checkListUuid, checkListElementId);
        String currentTime = AppUtility.Companion.getUtcTime();
        String uuid = "";
        int syncStatus = -1;
        if (existDecision != null && !TextUtils.isEmpty(existDecision.getUuid())) {
            uuid = existDecision.getUuid();
            syncStatus = existDecision.getSyncStatus();
            checklistExecutionDao.updateAssignedDecisionsExection(uuid, status, BaseApplication.getPreferenceManager().getUserId(), currentTime);
        } else {
            uuid = AppUtility.Companion.getUuid();
            AssignedDecisionEntity assignedDecisionEntity = new AssignedDecisionEntity();
            assignedDecisionEntity.setAssignedChecklistUuid(checkListUuid);
            assignedDecisionEntity.setChecklistElementId(checkListElementId);
            assignedDecisionEntity.setCreated(currentTime);
            assignedDecisionEntity.setDecisionId(decisionId);
            assignedDecisionEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
            assignedDecisionEntity.setModified(currentTime);
            assignedDecisionEntity.setIsDeleted(Constants.NOT_DELETED);
            assignedDecisionEntity.setUuid(uuid);
            assignedDecisionEntity.setStatus(status);
            assignedDecisionEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
            checklistExecutionDao.insertAssignedDecisions(assignedDecisionEntity);
        }

        if (existDecision == null || syncStatus != Constants.SYNC_STATUS_NOT) {
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(checkListUuid);
        }

        if (status == 1)
            status = 0;
        else if (status == 0)
            status = 1;
        else if (status == ChecklistExecutionStatus.SKIPPED.getValue())
            status = LogTableActions.SKIPPED.getValue();
        else if (status == ChecklistExecutionStatus.DEFERRED.getValue())
            status = LogTableActions.DEFERRED.getValue();

        LogsRepository logsRepository = new LogsRepository(application);
        if (status == LogTableActions.DEFERRED.getValue() || status == LogTableActions.SKIPPED.getValue())
            logsRepository.insertLogs(uuid, checkListUuid, checklistid, checkListElementId, status, null, reasonToSkipDeffer
                    , null, null);
        else
            logsRepository.insertLogs(uuid, checkListUuid, checklistid, checkListElementId, status,
                    null, itemDescription, null, null);

    }

    /**
     * @param assignedChecklistUuid Current Assigned checklist uuid
     * @param stepId                Step id
     * @param elementId             Current element id
     * @param value                 attribute value, in case if file/image then file name
     * @param itemUuid              Same uuid for all attributes on one step action(Completed/Undo)
     * @param stepAttributeId       Step attribute Id
     * @param checklistid           ID of Checklist
     * @param action                7 if File uploaded, 8 if QA Verification, 6 if other than file
     *                              and qa verification
     * @param attributeLabel        Attribute Label
     */

    public void executeStepAttribute(String assignedChecklistUuid, Integer stepId, Integer elementId,
                                     String value, String itemUuid, Integer stepAttributeId,
                                     Integer checklistid, Integer action, String attributeLabel,
                                     String userName, String stepAttributeUuid) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();


        String currentTime = AppUtility.Companion.getUtcTime();
        AssignedStepAttributesEntity assignedStepAttributesEntity = new AssignedStepAttributesEntity();
        assignedStepAttributesEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        assignedStepAttributesEntity.setStepId(stepId);
        assignedStepAttributesEntity.setStepAttributeId(stepAttributeId);
        assignedStepAttributesEntity.setChecklistElementId(elementId);
        assignedStepAttributesEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        assignedStepAttributesEntity.setValue(value);
        assignedStepAttributesEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedStepAttributesEntity.setCreated(currentTime);
        assignedStepAttributesEntity.setModified(currentTime);
        assignedStepAttributesEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);

        String orginalUuid = checklistExecutionDao.getItemCommonUuid(elementId, assignedChecklistUuid);

        if (orginalUuid != null && orginalUuid.length() > 0)
            assignedStepAttributesEntity.setItemUuid(orginalUuid);
        else
            assignedStepAttributesEntity.setItemUuid(AppUtility.Companion.getUuid());

        AssignedStepAttributesEntity existStepAttribute = checklistExecutionDao.ifStepAttributeAlreadyExecuted(
                assignedStepAttributesEntity.getItemUuid(), stepAttributeId, elementId, stepId);
        String uuid = "";
        int syncStatus = -1;
        if (existStepAttribute != null && !TextUtils.isEmpty(existStepAttribute.getUuid())) {
            uuid = existStepAttribute.getUuid();
            syncStatus = existStepAttribute.getSyncStatus();
            checklistExecutionDao.updateAssignedStepAttributes(uuid, Constants.NOT_DELETED, AppUtility.Companion.getUtcTime(), value);
        } else {
            uuid = AppUtility.Companion.getUuid();
            assignedStepAttributesEntity.setUuid(uuid);
            checklistExecutionDao.insertAssignedStepAttributes(assignedStepAttributesEntity);
        }

        if (existStepAttribute == null || syncStatus != Constants.SYNC_STATUS_NOT) {
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);
        }

        if (LogTableActions.QA_VERIFICATION.getValue() == action) {
            value = userName;
        }

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(assignedStepAttributesEntity.getItemUuid(), assignedChecklistUuid,
                checklistid, elementId, action, null, attributeLabel, value, null, userName);
    }


    /**
     * @param assignedChecklistUuid Current Assigned checklist uuid
     * @param stepId                Step id
     * @param elementId             Current element id
     * @param value                 attribute value, in case if file/image then file name
     * @param stepAttributeId       Step attribute Id
     * @param checklistid           ID of Checklist
     * @param action                7 if File uploaded, 8 if QA Verification, 6 if other than file
     *                              and qa verification
     * @param attributeLabel        Attribute Label
     */

    public void executeStepAttribute(String assignedChecklistUuid, Integer stepId, Integer elementId, String value, String diplayName, Integer stepAttributeId, Integer checklistid, Integer action, String attributeLabel) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();


        String currentTime = AppUtility.Companion.getUtcTime();
        AssignedStepAttributesEntity assignedStepAttributesEntity = new AssignedStepAttributesEntity();
        assignedStepAttributesEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        assignedStepAttributesEntity.setStepId(stepId);
        assignedStepAttributesEntity.setStepAttributeId(stepAttributeId);
        assignedStepAttributesEntity.setChecklistElementId(elementId);
        assignedStepAttributesEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        assignedStepAttributesEntity.setValue(value);
        assignedStepAttributesEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedStepAttributesEntity.setCreated(currentTime);
        assignedStepAttributesEntity.setModified(currentTime);
        assignedStepAttributesEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);


        String orginalUuid = checklistExecutionDao.getItemCommonUuid(elementId, assignedChecklistUuid);

        if (orginalUuid != null && orginalUuid.length() > 0)
            assignedStepAttributesEntity.setItemUuid(orginalUuid);
        else
            assignedStepAttributesEntity.setItemUuid(AppUtility.Companion.getUuid());

        //-- TO check if attribute already executed
        AssignedStepAttributesEntity existStepAttribute = checklistExecutionDao.ifStepAttributeAlreadyExecuted(assignedStepAttributesEntity.getItemUuid(), stepAttributeId, elementId, stepId);

        //-- To get last executed value, if attribute is already executed
        //String existingValue = checklistExecutionDao.getValueifStepAttributeAlreadyExecuted(assignedStepAttributesEntity.getItemUuid(), stepAttributeId, elementId, stepId);

        /*if (uuid != null && uuid.length() > 0 && action != LogTableActions.FILE.getValue()) {
            checklistExecutionDao.updateAssignedStepAttributes(uuid, Constants.DELETED, AppUtility.Companion.getUtcTime());
        }*/
        String uuid = "";
        int syncStatus = -1;
        boolean isValueChanged = true;
        if (existStepAttribute != null && existStepAttribute.getValue().equalsIgnoreCase(value)) {
            uuid = existStepAttribute.getUuid();
            syncStatus = existStepAttribute.getSyncStatus();
            isValueChanged = false;
        } else if (existStepAttribute != null && action != LogTableActions.FILE.getValue()) {
            uuid = existStepAttribute.getUuid();
            syncStatus = existStepAttribute.getSyncStatus();
            checklistExecutionDao.updateAssignedStepAttributes(uuid, Constants.NOT_DELETED, AppUtility.Companion.getUtcTime(), value);
        } else {
            uuid = AppUtility.Companion.getUuid();
            assignedStepAttributesEntity.setUuid(uuid);
            checklistExecutionDao.insertAssignedStepAttributes(assignedStepAttributesEntity);
        }

        if (existStepAttribute == null || syncStatus != Constants.SYNC_STATUS_NOT) {
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);
        }

        if (isValueChanged) {
            LogsRepository logsRepository = new LogsRepository(application);
            logsRepository.insertLogs(assignedStepAttributesEntity.getItemUuid(), assignedChecklistUuid, checklistid, elementId, action, null, attributeLabel, value, null);
        }
    }

    public void executeStepAttribute(String assignedChecklistUuid, Integer stepId, Integer elementId, String value, String diplayName, Integer stepAttributeId, Integer checklistid, Integer action, String attributeLabel, String logValue) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();


        String currentTime = AppUtility.Companion.getUtcTime();
        AssignedStepAttributesEntity assignedStepAttributesEntity = new AssignedStepAttributesEntity();
        assignedStepAttributesEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        assignedStepAttributesEntity.setStepId(stepId);
        assignedStepAttributesEntity.setStepAttributeId(stepAttributeId);
        assignedStepAttributesEntity.setChecklistElementId(elementId);
        assignedStepAttributesEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        assignedStepAttributesEntity.setValue(value);
        assignedStepAttributesEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedStepAttributesEntity.setCreated(currentTime);
        assignedStepAttributesEntity.setModified(currentTime);
        assignedStepAttributesEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);


        String orginalUuid = checklistExecutionDao.getItemCommonUuid(elementId, assignedChecklistUuid);

        if (orginalUuid != null && orginalUuid.length() > 0)
            assignedStepAttributesEntity.setItemUuid(orginalUuid);
        else
            assignedStepAttributesEntity.setItemUuid(AppUtility.Companion.getUuid());

        //-- TO check if attribute already executed
        AssignedStepAttributesEntity existStepAttribute = checklistExecutionDao.ifStepAttributeAlreadyExecuted(assignedStepAttributesEntity.getItemUuid(), stepAttributeId, elementId, stepId);

        String uuid = "";
        int syncStatus = -1;
        boolean isValueChanged = true;

        //-- To get last executed value, if attribute is already executed
        //String existingValue = checklistExecutionDao.getValueifStepAttributeAlreadyExecuted(assignedStepAttributesEntity.getItemUuid(), stepAttributeId, elementId, stepId);

        /*if (uuid != null && uuid.length() > 0 && action != LogTableActions.FILE.getValue()) {
            checklistExecutionDao.updateAssignedStepAttributes(uuid, Constants.DELETED, AppUtility.Companion.getUtcTime());
        }*/


        uuid = AppUtility.Companion.getUuid();
        assignedStepAttributesEntity.setUuid(uuid);

        if (existStepAttribute != null && existStepAttribute.getValue().equalsIgnoreCase(value)) {
            uuid = existStepAttribute.getUuid();
            syncStatus = existStepAttribute.getSyncStatus();
            isValueChanged = false;
        } else if (existStepAttribute != null) {
            uuid = existStepAttribute.getUuid();
            syncStatus = existStepAttribute.getSyncStatus();
            checklistExecutionDao.updateAssignedStepAttributes(uuid, Constants.NOT_DELETED, AppUtility.Companion.getUtcTime(), value);
        } else {
            uuid = AppUtility.Companion.getUuid();
            assignedStepAttributesEntity.setUuid(uuid);
            checklistExecutionDao.insertAssignedStepAttributes(assignedStepAttributesEntity);
        }
        if (existStepAttribute == null || syncStatus != Constants.SYNC_STATUS_NOT)
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);

        if (isValueChanged) {
            LogsRepository logsRepository = new LogsRepository(application);

            logsRepository.insertLogs(assignedStepAttributesEntity.getItemUuid(), assignedChecklistUuid, checklistid, elementId, action, null, attributeLabel, logValue, null);
        }
    }


    /**
     * @param assignedChecklistUuid Current Assigned checklist uuid
     * @param itemId                Current Element Item Id
     * @param elementId             Current element id
     * @param fileMd5CheckSum       MD5 checksum of file
     * @param contentType           content type of file e.g video/mp4, image/png etc
     * @param fileName              Unique id if captured using device camera else name of the
     *                              selected file from gallery
     * @param elementTypeId         Current Element Item type Id
     * @param displayFileName       Unique id if captured using device camera else name of the
     *                              selected file from gallery
     * @param checklistid           ID of Checklist
     * @param action                7 if File uploaded, 8 if QA Verification, 6 if other than file
     *                              and qa verification
     * @param attributeLabel        Attribute Label
     */

    public void executeStepFileResources(String assignedChecklistUuid, Integer itemId, Integer elementId, String fileMd5CheckSum, String contentType, String fileName, Integer elementTypeId, String displayFileName, Integer checklistid, Integer action, String attributeLabel, String uuid) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();

        String currentTime = AppUtility.Companion.getUtcTime();

        AssignedStepFileResourceEntity assignedStepAttributesEntity = new AssignedStepFileResourceEntity();
        assignedStepAttributesEntity.setUuid(uuid);
        assignedStepAttributesEntity.setAssigned_checklist_uuid(assignedChecklistUuid);
        assignedStepAttributesEntity.setItem_id(itemId);
        assignedStepAttributesEntity.setChecklist_element_id(elementId);
        assignedStepAttributesEntity.setUser_id(BaseApplication.getPreferenceManager().getUserId());
        assignedStepAttributesEntity.setIs_deleted(Constants.NOT_DELETED);
        assignedStepAttributesEntity.setCreated(currentTime);
        assignedStepAttributesEntity.setDisplay_file_name(displayFileName);
        assignedStepAttributesEntity.setModified(currentTime);
        assignedStepAttributesEntity.setSync_status(Constants.SYNC_STATUS_NOT);
        assignedStepAttributesEntity.setItem_type_id(elementTypeId);
        assignedStepAttributesEntity.setFile_name(fileName);
        assignedStepAttributesEntity.setContent_type(contentType);
        assignedStepAttributesEntity.setFile_md5_checksum(fileMd5CheckSum);
        assignedStepAttributesEntity.setIs_uploaded(Constants.NOT_UPLOADED);
        assignedStepAttributesEntity.setIs_downloaded(Constants.DOWNLOADED);

        checklistExecutionDao.insertAssignedStepFileResources(assignedStepAttributesEntity);
        checklistExecutionDao.updateAssignedChecklistPendingResourceCount(assignedChecklistUuid);

       /* LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(uuid, assignedChecklistUuid, checklistid, elementId, action, null, attributeLabel, null, null);
*/

    }

    /**
     * @param assignedChecklistUuid Current Assigned checklist uuid
     * @param stepId                Step id
     * @param checklistElementId    Current element id
     * @param status                0 if Undo, 1 if completed, 2 if skipped, 3 if deferred
     * @param checklistid           ID of Checklist
     * @param elementId             ID of the element being executed
     * @param action                4 if completed, 12 if Skipped, 13 if deferred, 15 if Undo
     * @param stepDescription       Step Description
     */

    public void executeStep(String assignedChecklistUuid, Integer stepId, Integer checklistElementId, Integer status, Integer checklistid, Integer elementId, Integer action, String stepDescription, String reasonToSkipDeffer) {

        AppDatabase appDatabase = AppDatabase.getInstance(application);
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

        AssignedStepEntity existStepAttribute = checklistExecutionDao.getAssignedStepUuid(checklistElementId, assignedChecklistUuid);
        if (existStepAttribute != null && !TextUtils.isEmpty(existStepAttribute.getUuid())) {
            syncStatus = existStepAttribute.getSyncStatus();
            uuid = existStepAttribute.getUuid();
            assignedStepEntity.setUuid(uuid);
            checklistExecutionDao.updateAssignedStep(assignedStepEntity);
        } else {
            uuid = AppUtility.Companion.getUuid();
            assignedStepEntity.setUuid(uuid);
            checklistExecutionDao.insertAssignedStep(assignedStepEntity);
        }
        if (existStepAttribute == null || syncStatus != Constants.SYNC_STATUS_NOT) {
            checklistExecutionDao.updateAssignedChecklistPendingElementCount(assignedChecklistUuid);
        }
        // As per logic of the old application we needn't reset child elements of
        // a step type element on being skipped or deferred for now. In case required,
        // just uncomment the following IF bloch.

        // if (status == 2 || status == 3) {
        // checklistExecutionDao.updateChildOnParentSkippedOrDeffered(checklistElementId);
        // }

        LogsRepository logsRepository = new LogsRepository(application);
        if (status == 1)
            logsRepository.insertLogs(uuid, assignedChecklistUuid, checklistid, elementId, action, null, stepDescription, stepDescription, null);
        else
            logsRepository.insertLogs(uuid, assignedChecklistUuid, checklistid, elementId, action, null, reasonToSkipDeffer, stepDescription, null);

    }

    /**
     * @param assignedChecklistUuid Current Assigned checklist uuid
     * @param checklistid           ID of Checklist
     * @param elementId             current element id
     * @param action                TEXT = 17, Image = 18
     * @param itemUUid              TEXT/Image uuid
     */

    public void executeImageText(String assignedChecklistUuid, Integer checklistid, Integer elementId, Integer action, String itemUUid, String description, String reasonToSkipDeffer) {

        LogsRepository logsRepository = new LogsRepository(application);
        if (action == ChecklistExecutionStatus.SKIPPED.getValue())
            action = LogTableActions.SKIPPED.getValue();
        else if (action == ChecklistExecutionStatus.DEFERRED.getValue())
            action = LogTableActions.DEFERRED.getValue();

        if (action == LogTableActions.DEFERRED.getValue() || action == LogTableActions.SKIPPED.getValue())
            logsRepository.insertLogs(itemUUid, assignedChecklistUuid, checklistid, elementId, action, null, reasonToSkipDeffer,
                    description, null);
        else
            logsRepository.insertLogs(itemUUid, assignedChecklistUuid, checklistid, elementId, action, null, description, null, null);

    }

    /**
     * @param username     - user name entered for QA
     * @param password     - Password entered for QA
     * @param userRoles    - User Roles allowed to verify
     * @param departmentId - Department ID of the Checklist
     * @return QA_VALIDATION_INVALID_CREDENTIALS = "Please enter valid credentials";
     * QA_VALIDATION_YOURSELF_CREDENTIALS = "You cannot verify yourself";
     * QA_VALIDATION_SAME_LOCATION = "User verifying should belong to same location/department";
     * QA_VALIDATION_NOT_AUTHORISED = "You are not authorised to verify";
     * QA_VALIDATION_AUTHORISED = "valid";
     */


    public UserMinimal validateQA(String username, String password, String userRoles, Integer departmentId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();

        String salt = application.getResources().getString(R.string.SALT);
        username = username.toLowerCase();
        password = MD5.sha1(password, salt);

        UserMinimal qa = checklistExecutionDao.validateQA(username, password);

        if (qa == null) {
            qa = new UserMinimal();
            qa.setVerificationResult(Constants.QA_VALIDATION_INVALID_CREDENTIALS);
            return qa;
        }

        Integer qaId = qa.getId();
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();

        if (qaId.equals(loggedInUserId)) {
            qa.setVerificationResult(Constants.QA_VALIDATION_YOURSELF_CREDENTIALS);
            return qa;
        }

        if (userRoles != null) {
            String qaRoleId = qa.getGroupId().toString();
            String[] allowedUserRoles = userRoles.split(",");

            if (!Arrays.asList(allowedUserRoles).contains(qaRoleId)) {
                qa.setVerificationResult(Constants.QA_VALIDATION_NOT_AUTHORISED);
                return qa;
            }
        }

        if (!qa.isAdministrator()) {
            int locationId = BaseApplication.getPreferenceManager().getUserLocationId();
            boolean isQALocationDepartmentSame;

            if (departmentId == null || departmentId == 0) {
                isQALocationDepartmentSame = checklistExecutionDao.ifUserLocationIsSame(qaId, locationId);
            } else {
                isQALocationDepartmentSame = checklistExecutionDao.ifUserLocationDepartmentIsSame(qaId, locationId, departmentId);
            }

            if (!isQALocationDepartmentSame) {
                qa.setVerificationResult(Constants.QA_VALIDATION_SAME_LOCATION);
                return qa;
            }
        }
        qa.setVerificationResult(Constants.QA_VALIDATION_AUTHORISED);
        return qa;
    }


    /**
     *
     */
    public void pauseAssignedCheckList(String uuid, String reason, Integer checklistId) {
        String currentTime = AppUtility.Companion.getUtcTime();
        AppDatabase appDatabase = AppDatabase.getInstance(application);
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

        LogsRepository logsRepository = new LogsRepository(application);
        logsRepository.insertLogs(
                uuid,
                uuid,
                checklistId,
                0,
                LogTableActions.PAUSED.getValue(),
                BaseApplication.getPreferenceManager().getUserFullName(),
                reason,
                "",
                BaseApplication.getPreferenceManager().getUserId()
        );
    }

    /**
     * @param checklistUuid UUID of the assigned checklist
     * @param parentId      id of the parent
     */
    public boolean isChildrenExecuted(String checklistUuid, Integer parentId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.isChildExecuted(checklistUuid, parentId);
    }

    /**
     * @param parentId id of the parent
     */
    public ParentDetailItem getParentDetail(Integer parentId, String checklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getParentDetail(parentId, checklistUuid);


    }

    /**
     * @param assignedChecklistUuid UUID of the assigned checklist
     * @param isSequential          If checklist is sequential or not
     * @param elementId             Id of the decision element
     * @param sortOrder             Sort Order of element
     * @return true if any element is executed
     * false if any element is not executed
     */
    public boolean isAnyDecisionChildExecuted(
            String assignedChecklistUuid,
            boolean isSequential,
            Integer elementId,
            Integer sortOrder
    ) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();

        if (isSequential) {
            return checklistExecutionDao.isAnyElementAfterDecisionExecuted(assignedChecklistUuid, sortOrder);
        }

        return checklistExecutionDao.isAnyDecisionChildExecuted(assignedChecklistUuid, elementId);
    }

    /**
     * @param checklistUuid - uuid of assigned checklist
     */


    public LiveData<PagedList<CaptureDataItem>> getAllCapturedToday(String checklistUuid, PagedList.Config config) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        DataSource.Factory<Integer, CaptureDataItem> factory;
        factory = checklistExecutionDao.getAllCapturedData(checklistUuid);

        return new LivePagedListBuilder<>(factory, config)
                .build();
    }

    /**
     * @param checklistUuid - uuid of assigned checklist
     */
    public ChecklistIDetailtems getChecklistDetail(String checklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getChecklistDetail(checklistUuid);

    }

    /**
     * This method is called when we click on the attached reference from file required attribute
     *
     * @param entity             The clicked file to download
     * @param onDownloadListener Callback for handling result
     */
    public void downloadFile(final ResourceEntity entity, final OnDownloadListener onDownloadListener) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = FileUtils.getResourcesAttachmentsDir();
            if (directory == null) {
                onDownloadListener.onFailed();
                return;
            }

            final File fileDestinationFolder = new File(directory, entity.getPath());

            if (!fileDestinationFolder.exists()) {
                if (!Utilities.isOnline(application)) {
                    onDownloadListener.noInternetAvailable();
                    return;
                }
                RetroUtils.getRetrofitInstance(application, new InternetConnectionListener() {
                    @Override
                    public void onInternetUnavailable() {
                        onDownloadListener.noInternetAvailable();
                    }
                }).create(ChecklistElementsApi.class)
                        .resourceDownload(Constants.HEADER_ACCEPT, entity.getUuid())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbstractNetworkObservable<ResponseBody>() {
                            @Override
                            public void success(ResponseBody responseBody) {
                                if (responseBody != null) {
                                    try {
                                        if (fileDestinationFolder.createNewFile()) {
                                            fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                                            update(entity, fileDestinationFolder);
                                            onDownloadListener.onSuccess();
                                        } else {
                                            onDownloadListener.onFailed();
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        onDownloadListener.onFailed();
                                    }
                                }
                            }

                            @Override
                            public void failure(Throwable error) {
                                onDownloadListener.onFailed();
                            }
                        });
            } else {
                update(entity, fileDestinationFolder);
                onDownloadListener.onSuccess();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            onDownloadListener.onFailed();
        }
    }


    /**
     * This method is called when we click on the attached file template from file required attribute
     *
     * @param selectedFile       The clicked file to download
     * @param onDownloadListener Callback for handling result
     */
    public void downloadAttachedTemplateFile(final SelectedFile selectedFile, final OnDownloadListener onDownloadListener) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = FileUtils.getResourcesAttachmentsDir();
            if (directory == null) {
                onDownloadListener.onFailed();
                return;
            }

            final File fileDestinationFolder = new File(directory, selectedFile.getFilePath());
            if (!fileDestinationFolder.exists()) {
                if (!Utilities.isOnline(application)) {
                    onDownloadListener.noInternetAvailable();
                    return;
                }
                RetroUtils.getRetrofitInstance(application, new InternetConnectionListener() {
                    @Override
                    public void onInternetUnavailable() {
                        onDownloadListener.noInternetAvailable();
                    }
                }).create(ChecklistElementsApi.class)
                        .capturedDataDownload(Constants.HEADER_ACCEPT, selectedFile.getFileUUID())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbstractNetworkObservable<ResponseBody>() {
                            @Override
                            public void success(ResponseBody responseBody) {
                                if (responseBody != null) {
                                    try {
                                        if (fileDestinationFolder.createNewFile()) {
                                            fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                                            onDownloadListener.onSuccess();
                                        } else {
                                            onDownloadListener.onFailed();
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        onDownloadListener.onFailed();
                                    }

                                }
                            }

                            @Override
                            public void failure(Throwable error) {
                                onDownloadListener.onFailed();
                            }
                        });
            } else {
                onDownloadListener.onSuccess();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            onDownloadListener.onFailed();
        }
    }


    public List<AssignedStepFileResourceEntity> getAttributeFiles(Integer stepAttributeId, String assignedChecklistUuid, Integer elementId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getFilesByAttributeId(stepAttributeId, assignedChecklistUuid, elementId);

    }

    public void removeFileFromStepAttribute(String fileUUID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        checklistExecutionDao.removeFile(fileUUID);
        checklistExecutionDao.removeFileResource(fileUUID);

    }

    public String getIfFileAlreadyExists(String checkListUUID, int itemId, String fileMd5Checksum, Integer stepAttributeUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getIfFileAlreadyExists(checkListUUID, itemId, fileMd5Checksum, stepAttributeUuid);

    }

    public void update(ResourceEntity resourceEntity, File fileDestinationFolder) {
        if (MD5.checkMD5(resourceEntity.getFileMd5Checksum(), fileDestinationFolder)) {
            AppDatabase appDatabase = AppDatabase.getInstance(application);
            GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
            getSynchronizationDao.updateResources(resourceEntity.getUuid());

            if (resourceEntity.getIsResource() == 1) {
                getSynchronizationDao.updateResourceChecklistStatus(resourceEntity.getFileMd5Checksum());
            } else {
                getSynchronizationDao.updateReferenceChecklistStatus(resourceEntity.getFileMd5Checksum());
            }
        }
    }


    public int getValidSortOrder(int sortOrder, int checklistId) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getValidSortOrder(sortOrder, checklistId);
    }


    /**
     * This method execute qr scan attribute items
     *
     * @param assignedChecklistUuid uuid of the checklist being executed
     * @param stepId                id of stepp being executed
     * @param elementId             id of parent element of step
     * @param value                 entity_uuid or AssignedItemPlaceholder.uuid
     * @param stepAttributeId       id of the attribute of the step
     * @param checklistId           id of the checklist executed
     * @param attributeLabel        label of the qr attribute being performed
     * @param stepAction            entity name if scanned using scanner and if manually executed the value will be as:
     *                              Original Name of the entity i.e. AssignedItemPlaceholder.value
     *                              followed by <#> followed by the Name of the entity given
     *                              followed by the separator <#> followed by the reason given.
     *                              So it would look as "{{Original Name}}<#>{{Name Given}}<#>{{Reason Given}}"
     * @param uuid                  assigned step attribute uuid
     */
    public String executeStepQRScanAttribute(String assignedChecklistUuid,
                                             Integer stepId,
                                             Integer elementId,
                                             String value,
                                             Integer stepAttributeId,
                                             Integer checklistId,
                                             String attributeLabel,
                                             String stepAction,
                                             String uuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        QRStepAttributeExecutionDao checklistExecutionActionDao = appDatabase.qrStepAttributeExecutionDao();

        String executedAt = AppUtility.Companion.getUtcTime();
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();
        String loggedInUserName = BaseApplication.getPreferenceManager().getUserFullName();

        String itemUuid = checklistExecutionDao.getItemCommonUuid(elementId, assignedChecklistUuid);

        if (TextUtils.isEmpty(itemUuid))
            itemUuid = AppUtility.Companion.getUuid();

        AssignedStepAttributesEntity assignedStepAttributesEntity = null;

        //-- TO check if attribute already executed
        AssignedStepAttributesEntity existStepAttribute = checklistExecutionDao.ifStepAttributeAlreadyExecuted(
                itemUuid, stepAttributeId, elementId, stepId);

        int syncStatus = -1;
        int incrementPendingElementCount = 0;

        //Check if qr code is already executed, if yes update existing record else add new entry
        // in assigned step attribute table
        if (existStepAttribute != null && !TextUtils.isEmpty(uuid)) {
            syncStatus = existStepAttribute.getSyncStatus();
            existStepAttribute.setIsDeleted(Constants.NOT_DELETED);
            existStepAttribute.setSyncStatus(Constants.SYNC_STATUS_NOT);
            existStepAttribute.setModified(executedAt);
            existStepAttribute.setValue(value);
            existStepAttribute.setUuid(uuid);
            existStepAttribute.setUserId(loggedInUserId);
        } else {
            assignedStepAttributesEntity = new AssignedStepAttributesEntity(
                    assignedChecklistUuid, elementId, executedAt, itemUuid, stepAttributeId,
                    stepId, loggedInUserId, value);
            uuid = assignedStepAttributesEntity.getUuid();
        }

        //Increment pending element count if sync status is 1
        if (existStepAttribute == null || syncStatus != Constants.SYNC_STATUS_NOT)
            incrementPendingElementCount += 1;

        LogsEntity logsEntity = new LogsEntity(itemUuid, checklistId, elementId, 6, loggedInUserId,
                loggedInUserName, stepAttributeId, uuid, assignedChecklistUuid, attributeLabel,
                stepAction, executedAt);
        //increment pending element count for log entry
        incrementPendingElementCount += 1;

        //execute all the queries in transaction
        checklistExecutionActionDao.updateStepExecution(assignedChecklistUuid, executedAt,
                incrementPendingElementCount, assignedStepAttributesEntity, existStepAttribute,
                logsEntity);
        return itemUuid;
    }

    public LiveData<List<QRAttributeScanItem>> getQRAttributeDetail(Integer stepAttributeId,
                                                                    String itemUuid,
                                                                    Integer stepId,
                                                                    String checkListUUID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getQRAttributeScanItem(stepAttributeId,
                itemUuid, stepId, checkListUUID);
    }

    public NonExecutedChildElement getChildElementIfNotExecuted(Integer parentId, String checkListUUID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ChecklistExecutionDao checklistExecutionDao = appDatabase.checklistExtecutionDao();
        return checklistExecutionDao.getNonExecutedChildElement(parentId, checkListUUID);
    }
}
