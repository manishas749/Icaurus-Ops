package com.icarus.dao;

import com.icarus.database.InsertUpdateQueries;
import com.icarus.database.Queries;
import com.icarus.database.QueriesExecution;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.ResourceEntity;
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
import com.icarus.models.UserItems;
import com.icarus.models.UserMinimal;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChecklistExecutionDao {


    @Query(Queries.IF_NCW_UPDATED_QUERY)
    AssignedNCWEntity ifNCWAlreadyUpdated(String uuid, Integer checkListElementID);


    @Query(InsertUpdateQueries.UPDATE_ASSIGN_NCW)
    void updateNCWExection(String uuid, Integer acknowledged, Integer userId, String currentTime);

    @Insert
    void insertNCWExection(AssignedNCWEntity assignedNCWEntity);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_CURRENT_ELEMENT)
    ChecklistDetailItems getItem(Integer currentSortOrder, String checkListUuid);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_CURRENT_SKIPPED_ELEMENT)
    ChecklistDetailItems getSkippedItem(Integer currentSortOrder, Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_CURRENT_DEFFERED_ELEMENT)
    ChecklistDetailItems getDefferedItem(Integer currentSortOrder, Integer checkListId,String checkListUuid);


    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_NEXT_ELEMENT)
    ChecklistDetailItems getNextItem(Integer currentSortOrder, String checkListUuid, Integer checklistId);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_NEXT_SKIPPED_ELEMENT)
    ChecklistDetailItems getNextSkippedItem(Integer currentSortOrder, Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_NEXT_DEFFERED_ELEMENT)
    ChecklistDetailItems getNextDefferedItem(Integer currentSortOrder, Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_PREVIOUS_ELEMENT)
    ChecklistDetailItems getPreviousItem(Integer currentSortOrder, String checkListUuid, Integer checklistId);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_PREVIOUS_SKIPPED_ELEMENT)
    ChecklistDetailItems getPreviousSkippedItem(Integer currentSortOrder, Integer checkListId,String checkListUuid);

    @Query(Queries.GET_CHECKLIST_EXECUTION_DETAIL_PREVIOUS_DEFFERED_ELEMENT)
    ChecklistDetailItems getPreviousDefferedItem(Integer currentSortOrder, Integer checkListId,String checkListUuid);

    @Query(Queries.GET_STEP_ATTRIBUTES)
    List<CheckListStepAttributeItems> getStepElments(String stepId,Integer elementId,String assignedChecklistUuid);

    @Query(Queries.GET_CHECLIST_PPES)
    List<CheckListPPItems> getPPIcons(Integer stepId);

    @Query(Queries.GET_NCW_HAZARDS)
    List<NcwHazardsItems> getNcmHazards(Integer itemId, Integer itemTypeId);


    @Query(Queries.GET_ELEMENT_RESOURCES)
    List<ResourceEntity> getCheckListReferances(Integer itemId);

    @Query(Queries.GET_RESOURCES)
    ResourceEntity getResource(Integer itemId);

    @Query(Queries.GET_ELEMENT_RESOURCES_EMBEDDED)
    List<ResourceEntity> getCheckListResourcesEmbedded(Integer itemId);

    @Query(Queries.IF_DECISION_UPDATED_QUERY)
    AssignedDecisionEntity ifDecisionPointAlreadyUpdated(String uuid, Integer checkListElementID);

    @Query(InsertUpdateQueries.UPDATE_ASSIGN_DECISIONS)
    void updateAssignedDecisionsExection(String uuid, Integer status, int userId, String currentTime);

    @Insert
    void insertAssignedDecisions(AssignedDecisionEntity assignedDecisionEntity);

    @Query(Queries.GET_ELEMENT_RESOURCES_URL)
    List<ResourceLinkItems> getResourceLinks(Integer itemId);

    @Insert
    void insertAssignedStepAttributes(AssignedStepAttributesEntity assignedStepAttributesEntity);

    @Insert
    void insertAssignedStep(AssignedStepEntity assignedStepEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAssignedStepFileResources(AssignedStepFileResourceEntity assignedStepAttributesEntity);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_STEP_ATTRIBUTE)
    void updateAssignedStepAttributes(String uuid, Integer isDeleted, String currentDate, String value);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_STEP_ATTRIBUTE_QR)
    void updateAssignedStepAttributesQR(Integer userId, String value, String currentDate, String uuid);

    @Query(Queries.GET_ITEM_UUID_FOR_STEP_ATTRIBUTE)
    String getItemCommonUuid(Integer checklistElementId, String assignedChecklistUuid);

    @Query(Queries.GET_ASSIGNED_STEP_UUID)
    AssignedStepEntity getAssignedStepUuid(Integer stepId, String assignedChecklistUuid);

    @Update
    void updateAssignedStep(AssignedStepEntity assignedStepEntity);

    @Query(Queries.GET_USERS_FOR_ROLES)
    List<UserItems> getUsers(Integer locationId, Integer departmentId, String[] groupIds);

    @Query(Queries.GET_ALL_USERS_FOR_ROLES)
    List<UserItems> getUsers(Integer locationId, String[] groupIds);

    @Query(Queries.VALIDATE_QA)
    UserMinimal validateQA(String username, String password);

    @Query(Queries.GET_CHECLIST_PPES_FOR_CHECKLIST)
    List<CheckListPPItems> getInformationIcons(Integer checklistId);

    @Query(Queries.IF_STEP_ATTRIBUTE_ALREADY_EXECUTED)
    AssignedStepAttributesEntity ifStepAttributeAlreadyExecuted(String itemUUID, Integer stepAttributeId, Integer checklistElementId, Integer stepId);

    @Query(Queries.GET_VALUE_IF_STEP_ATTRIBUTE_ALREADY_EXECUTED)
    String getValueifStepAttributeAlreadyExecuted(String itemUUID, Integer stepAttributeId, Integer checklistElementId, Integer stepId);

    @Query(Queries.GET_CHECKLIST_DETAIL_NEXT_DEFFERED)
    ChecklistDetailItems getNextItemDeffered(int offset, int checkListId,String checkListUuid);

    @Query(Queries.GET_USERS_FOR_ASSIGNMENT)
    List<UserItems> getUsersForTheLocation(String assignedChecklistUuid, Integer locationId, Integer departmentId);

    @Query(Queries.GET_ALL_USERS_FOR_ASSIGNMENT)
    List<UserItems> getUsersForTheLocation(String assignedChecklistUuid, Integer locationId);

    @Query(Queries.IS_CHILD_EXECUTED)
    boolean isChildExecuted(String assignedChecklistUuid, Integer parentId);

    @Query(Queries.GET_PARENT_DETAILS)
    ParentDetailItem getParentDetail(Integer parentId, String checklistUuid);

    @Query(Queries.IS_ANY_ELEMENT_AFTER_DECISION_EXECUTED + Queries.DECISION_PARENT_ID_CLAUSE)
    boolean isAnyDecisionChildExecuted(String assignedChecklistUuid, Integer elementId);

    @Query(Queries.IS_ANY_ELEMENT_AFTER_DECISION_EXECUTED + Queries.DECISION_SORT_ORDER_CLAUSE)
    boolean isAnyElementAfterDecisionExecuted(String assignedChecklistUuid, Integer sortOrder);

    @Query(QueriesExecution.GET_CHECKLIST_DETAIL)
    ChecklistIDetailtems getChecklistDetail(String assignedChecklistUuid);


    @Query(QueriesExecution.GET_CAPTURED_DATA)
    DataSource.Factory<Integer,CaptureDataItem> getAllCapturedData(String checklistUuid);

    @Query(InsertUpdateQueries.UPDATE_CHILDS_ON_PARENT)
    void updateChildOnParentSkippedOrDeffered(Integer parentid);


    @Query(Queries.GET_CHILDS_BY_PARENT)
    List<ChecklistElementsEntity> getChilds(Integer parentId);

    @Query(Queries.COMPARE_LOCATION_DEPARTMENT_QUERY)
    boolean ifUserLocationDepartmentIsSame(Integer userId, int locationId, Integer departmentId);

    @Query(Queries.COMPARE_LOCATION_QUERY)
    boolean ifUserLocationIsSame(Integer userId, int locationId);

    @Query(Queries.GET_GROUP_IDS)
    String getGroupIds();

    @Query(Queries.GET_FILES_BY_ATTRIBUTE_ID)
    List<AssignedStepFileResourceEntity> getFilesByAttributeId(Integer stepAttributeId, String assignedChecklistUuid, Integer elementId);

    @Query(InsertUpdateQueries.REMOVE_FILE_FROM_ATTRIBUTE)
    void removeFile(String fileUuid);

    @Query(InsertUpdateQueries.REMOVE_FILE_FROM_ATTRIBUTE_FILE)
    void removeFileResource(String fileUuid);

    /*@Query(SyncQueries.UPDATE_SYNC_RESOURCE_CHECKLIST_STATUS)
    void updateResourceSyncStatus(String checklistIds);

    @Query(SyncQueries.UPDATE_SYNC_REFERENCE_CHECKLIST_STATUS)
    void updateReferenceSyncStatus(String checklistIds);*/

    @Query(Queries.GET_UUID_FILE_ALREADY_EXISTS)
    String getIfFileAlreadyExists(String assignedChecklistUuid, Integer itemId, String fileMd5Checksum, Integer stepAttributeid);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_ELEMENT)
    void updateAssignedChecklistPendingElementCount(String uuid);

    @Query(InsertUpdateQueries.UPDATE_ASSIGNED_CHECKLIST_PENDING_RESOURCE)
    void updateAssignedChecklistPendingResourceCount(String uuid);

    @Query(Queries.GET_STEP_EMBEDDED_IMAGES)
    List<ChecklistDetailItems> getStepEmbeddedImages(String checklistUuid, Integer checklistId, Integer parentId);

    @Query(Queries.GET_SORT_ORDER_SKIPPING_CHILD_EMBEDDED_IMAGE)
    int getValidSortOrder(int sortOrder, int checklistId);

    @Query(Queries.GET_QR_SCAN_ATTRIBUTE_ITEM)
    LiveData<List<QRAttributeScanItem>> getQRAttributeScanItem(Integer stepAttributeId, String itemUuid, Integer stepId, String checkListUUID);

    @Query(Queries.GET_NON_EXECUTED_CHILD_ELEMENT)
    NonExecutedChildElement getNonExecutedChildElement(Integer parentId, String checklistUuid);

}
