package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.icarus.database.SyncQueries;
import com.icarus.entities.AllChecklistEntity;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedItemPlaceholderEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.AsssignedDepartmentsEntity;
import com.icarus.entities.CheckListLogoEntity;
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.CheckListTitlesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.ChecklistExecutionPermission;
import com.icarus.entities.ChecklistLocationEntity;
import com.icarus.entities.ChecklistRoomEquipmentsEntity;
import com.icarus.entities.ChecklistStatusEntity;
import com.icarus.entities.ChecklistTypeEntity;
import com.icarus.entities.ClientLogoEntity;
import com.icarus.entities.ClientSettingEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.DepartmentsEntity;
import com.icarus.entities.EquipmentsEntity;
import com.icarus.entities.GroupEntity;
import com.icarus.entities.HazardsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.ItemTypeEntity;
import com.icarus.entities.LocationDepartmentsEntity;
import com.icarus.entities.LocationEntity;
import com.icarus.entities.LocationEquipmentsEntity;
import com.icarus.entities.LocationRoomEntity;
import com.icarus.entities.LocationRoomEquipmentsEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PepesEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.QRStorageEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.RoomsEntity;
import com.icarus.entities.StepAttributesEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.entities.UserLocationsDepartments;
import com.icarus.entities.UsersEntity;
import com.icarus.entities.WorkOrdeStatusEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderBillingTypeEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.models.ResourceDownloadItems;

import java.util.ArrayList;
import java.util.List;

import c.anurag.network.beanspost.workorder.Workorder;

@Dao
public abstract class GetSynchronizationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklistStatuses(ChecklistStatusEntity checklistStatusEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertDepartments(DepartmentsEntity departmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklistType(ChecklistTypeEntity checklistTypeEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertClientSetting(ClientSettingEntity clientSettingEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertItemType(ItemTypeEntity itemTypeEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertPpes(PepesEntity pepesEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklistExecutionPermissions(ChecklistExecutionPermission checklistExecutionPermission);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertWorkorderStatus(WorkOrdeStatusEntity workOrdeStatusEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklists(AllChecklistEntity allChecklistEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertEquipments(EquipmentsEntity equipmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertGroups(GroupEntity groupEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertHazards(HazardsEntity hazardsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertLocationEquipments(LocationRoomEquipmentsEntity locationRoomEquipmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertLocationRoomEquipments(List<LocationRoomEquipmentsEntity> locationRoomEquipmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertLocationDepartments(LocationDepartmentsEntity locationDepartmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertLocationDepartments(List<LocationDepartmentsEntity> locationDepartmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertLocations(LocationEntity locationEntity);

    @Query(SyncQueries.IF_LOCATION_EXISTS_QUERY)
    public abstract LocationEntity ifLocationExists(Integer id);

    @Transaction
    public void insertLocationsWithAssociatedData(
            List<LocationEntity> locationEntities,
            List<LocationDepartmentsEntity> locationDepartmentsEntities
    ) {
        for (LocationEntity locationEntity : locationEntities) {
            LocationEntity entity = ifLocationExists(locationEntity.getId());

            if (entity != null) {
                locationEntity.setLastSyncTime(entity.getLastSyncTime());
                locationEntity.setLastSyncStatus(entity.getLastSyncStatus());
            }
            insertLocations(locationEntity);
        }

        insertLocationDepartments(locationDepartmentsEntities);
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertUserEntity(UsersEntity usersEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertUserDepartments(UserLocationsDepartments userLocationsDepartments);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertUserFavouriteEntity(UserFavouritesEntity userFavouritesEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertClientLogo(ClientLogoEntity clientLogoEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklistLocation(ChecklistLocationEntity checklistLocationEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklistElements(ChecklistElementsEntity checklistElementsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertStepAttributes(StepAttributesEntity stepAttributesEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertNCWHazards(NcwHazardsEntity ncwHazardsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertChecklistPeps(CheckListPpesEntity checkListPpesEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedChecklists(AssignCheckListEntity assignCheckListEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedLogoEntity(AssignedLogoEntity assignedLogoEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedRoomEquipmentEntity(AssignRoomEquipmentsEntity assignRoomEquipmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedNCW(AssignedNCWEntity assignedNCWEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssigneComments(AssignedChecklistCommentsEntity assignedChecklistCommentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedPauseTime(AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssigneDecision(AssignedDecisionEntity assignedDecisionEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedDepartment(AsssignedDepartmentsEntity asssignedDepartmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedPlaceholder(AssignedItemPlaceholderEntity assignedItemPlaceholderEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedStepAttribute(AssignedStepAttributesEntity assignedStepAttributesEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedStepResources(AssignedStepFileResourceEntity assignedStepFleResourceEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedSteps(AssignedStepEntity assignedStepEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertAssignedUsers(AssignedUserEntity assignedUserEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRoomEntity(RoomsEntity mapRoomsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertLogs(LogsEntity mapLogs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertReferanceLinks(ResourcesLinksEntity mapReferanceLinks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertItemPlaceholder(ItemPlaceholdersEntity mapPlaceholder);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertPlaceholder(PlaceholderEntity mapPlaceholder);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertReferances(ResourceEntity mapReferances);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertChecklistLogo(List<CheckListLogoEntity> mapChecklistLogo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertChecklistRoomEquipments(List<ChecklistRoomEquipmentsEntity> mapRoomEquipment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertChecklistsTitle(CheckListTitlesEntity mapChecklistTitleEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertCustomFields(CustomFieldsEntity mapCustomField);

    @Query(SyncQueries.GET_LATEST_CHECKLISTS)
    public abstract List<Integer> getLatestChecklists(Integer locationId);

    @Query(SyncQueries.GET_LATEST_ASSIGNED_CHECKLISTS)
    public abstract List<String> getLatestAssignedChecklists(String modified, List<Integer> status);

    @Query(SyncQueries.GET_LATEST_WORKORDERS)
    public abstract List<Integer> getLatestWorkorders();

    @Query(SyncQueries.GET_LATEST_HAZARDS)
    public abstract List<HazardsEntity> getHazards();

    @Query(SyncQueries.GET_LATEST_PPES)
    public abstract List<PepesEntity> getPpes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insertWorkorderBillingType(WorkOrderBillingTypeEntity mapWorkOrderBillingTypeEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertWorkorder(WorkOrderEntity workOrderEntity);

    @Insert
    public abstract void insertWorkOrder(WorkOrderEntity workOrderEntity);

    @Update
    public abstract void updateWorkOrder(WorkOrderEntity workOrderEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertWorkorderAttachment(WorkOrderAttachmentsEntity workOrderAttachmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertWorkorderAttachment(List<WorkOrderAttachmentsEntity> workOrderAttachmentsEntity);

    @Insert
    public abstract void insertWorkOrderAttachments(List<WorkOrderAttachmentsEntity> workOrderAttachmentEntity);

    @Update
    public abstract void updateWorkOrderAttachments(List<WorkOrderAttachmentsEntity> workOrderAttachmentEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertWorkorderNote(WorkOrderNotesEntity workOrderNotesEntity);

    @Insert
    public abstract void insertWorkOrderNotes(List<WorkOrderNotesEntity> workOrderNotesEntity);

    @Update
    public abstract void updateWorkOrderNotes(List<WorkOrderNotesEntity> workOrderNotesEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertWorkorderNoteDetail(WorkOrderNoteDetailEntity workOrderNoteDetailEntity);

    @Insert
    public abstract void insertWorkOrderNoteDetails(List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntity);

    @Update
    public abstract void updateWorkOrderNoteDetails(List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntity);

    @Query(SyncQueries.GET_LATEST_CLIENT_LOGO)
    public abstract List<ClientLogoEntity> getClientLogo();

    @Query(SyncQueries.GET_LATEST_RESOURCES)
    public abstract List<ResourceDownloadItems> getResourcesToDownload(Integer userId);

    @Query(SyncQueries.UPDATE_RESOURCES)
    public abstract void updateResources(String uuid);

    @Query(SyncQueries.UPDATE_CLIENT_LOGO)
    public abstract void updateClientLogo(String uuid);

    @Query(SyncQueries.UPDATE_SYNC_CHECKLIST_STATUS)
    public abstract void updateChecklistSyncStatus(Integer checklistID, Integer syncStatus);

    @Query(SyncQueries.UPDATE_SYNC_ASSIGNED_CHECKLIST_STATUS)
    public abstract void updateAssignedChecklistSyncStatus(String uuid);

    @Query(SyncQueries.UPDATE_CHECKLIST_SYNC_PENDING_RESOURCE_AFTER_DOWNLOAD)
    public abstract void updateResourceSyncStatus(String checksum);

    @Query(SyncQueries.UPDATE_CHECKLIST_SYNC_PENDING_REFERENCE_AFTER_DOWNLOAD)
    public abstract void updateReferenceSyncStatus(String checksum);

    @Query(SyncQueries.GET_NON_SYNCED_CHECKLISTS)
    public abstract List<Integer> getNonSyncedChecklists();

    @Query(SyncQueries.UPDATE_SYNC_CHECKLIST_PENDING_REFERENCE_COUNT)
    public abstract void updateChecklistPendingReferenceCount(Integer checklistId);

    @Query(SyncQueries.UPDATE_SYNC_CHECKLIST_PENDING_RESOURCE_COUNT)
    public abstract void updateChecklistPendingResourceCount(Integer checklistId);

    @Query(SyncQueries.QUERY_CHECK_IF_CHECKLIST_PPE_EXIST)
    public abstract CheckListPpesEntity checkIfChecklistPpesExists(Integer stepId, Integer ppeId);

    @Query(SyncQueries.QUERY_CHECK_IF_NCW_HAZARDS_EXIST)
    public abstract NcwHazardsEntity checkIfNcwHazardsExists(Integer itemTypeId, Integer itemId, Integer hazardId);

    @Query(SyncQueries.UPDATE_SYNC_WORKORDER_EXECUTION_STATUS)
    public abstract void updateWorkorderExecutionStatus(Integer id);

    @Query(SyncQueries.UPDATE_REFERENCE_CHECKLIST_STATUS)
    public abstract void updateReferenceChecklistStatus(String referencesChecksum);

    @Query(SyncQueries.UPDATE_RESOURCE_CHECKLIST_STATUS)
    public abstract void updateResourceChecklistStatus(String resourceChecksum);

    @Query(SyncQueries.IF_PAUSE_TIMES_EXIST_QUERY)
    public abstract AssignedCheckListPauseTimesEntity ifPauseTimeExists(String uuid, String assignedChecklistUuid);

    @Query(SyncQueries.IF_COMMENT_EXIST_QUERY)
    public abstract AssignedChecklistCommentsEntity ifCommentExists(String uuid, String assignedChecklistUuid);

    @Query(SyncQueries.IF_PLACEHOLDER_EXIST_QUERY)
    public abstract AssignedItemPlaceholderEntity ifPlaceholderExists(Integer id, Integer checkListElementID, String assignedChecklistUuid);

    @Query(SyncQueries.IF_STEP_RESOURCES_EXIST_QUERY)
    public abstract AssignedStepFileResourceEntity ifStepResourceExists(String uuid, Integer checkListElementID, String assignedChecklistUuid);

    @Query(SyncQueries.IF_STEP_ATTRIBUTE_CUSTOM_FILED_QUERY)
    public abstract String customFieldType(Integer stepAttributeId);

    @Query(SyncQueries.IF_STEP_ATTRIBUTE_WITH_FILE_EXIST_QUERY)
    public abstract AssignedStepAttributesEntity ifStepAttributeWithFileExists(String uuid, Integer elementId, String value, String assignedChecklistUuid, Integer stepAttributeId);

    @Query(SyncQueries.IF_STEP_ATTRIBUTE_EXIST_QUERY)
    public abstract AssignedStepAttributesEntity ifStepAttributeExists(String uuid, Integer elementId, String assignedChecklistUuid, Integer stepAttributeId);

    @Query(SyncQueries.IF_NCW_UPDATED_QUERY)
    public abstract AssignedNCWEntity ifNCWExists(String uuid, Integer checkListElementID);

    @Query(SyncQueries.IF_DECISION_UPDATED_QUERY)
    public abstract AssignedDecisionEntity ifDecisionExists(String uuid, Integer checkListElementID);

    @Query(SyncQueries.GET_ASSIGNED_STEP_UUID)
    public abstract AssignedStepEntity ifStepExists(String assignedChecklistUuid, Integer stepId);

    @Query(SyncQueries.IF_ASSIGNED_CHECKLIST_EXIST_QUERY)
    public abstract AssignCheckListEntity ifAssignedChecklistExists(String uuid);

    @Query(SyncQueries.IF_ASSIGNED_LOGO_EXIST_QUERY)
    public abstract AssignedLogoEntity ifAssignedLogoExists(String uuid);

    @Query(SyncQueries.IF_ASSIGNED_ROOM_EQUIPMENT_EXIST_QUERY)
    public abstract AssignRoomEquipmentsEntity ifAssignedRoomEquipmentExists(String uuid);

    @Query(SyncQueries.IF_ASSIGNED_USERS_EXIST_QUERY)
    public abstract AssignedUserEntity ifAssignedUserExists(String uuid, Integer userId);

    @Query(SyncQueries.IF_ASSIGNED_DEPARTMENTS_EXIST_QUERY)
    public abstract AsssignedDepartmentsEntity ifAssignedDepartmentExists(String uuid, Integer depId);

    @Query(SyncQueries.IF_USER_FAVORITE_EXIST_QUERY)
    public abstract UserFavouritesEntity ifUserFavoriteExists(Integer id, Integer userId);

    @Query(SyncQueries.IF_WORK_ORDER_EXIST_QUERY)
    public abstract WorkOrderEntity ifWorkOrderExists(Integer workOrderId);

    @Query(SyncQueries.IF_WORK_ORDER_WITH_UUID_EXISTS)
    public abstract WorkOrderEntity workOrder(String workOrderUuid);

    @Query(SyncQueries.IF_WORK_ORDER_NOTE_EXIST_QUERY)
    public abstract WorkOrderNotesEntity workOrderNote(String workOrderNoteUuid);

    @Query(SyncQueries.IF_WORK_ORDER_NOTE_DETAIL_EXIST_QUERY)
    public abstract WorkOrderNoteDetailEntity workOrderNoteDetail(String workOrderNoteDetailUuid);

    @Query(SyncQueries.IF_WORK_ORDER_ATTACHMENT_EXIST_QUERY)
    public abstract WorkOrderAttachmentsEntity workOrderAttachment(String workOrderAttachmentUuid);

    @Query(SyncQueries.IF_LOCATION_ROOM_EXIST_QUERY)
    public abstract LocationRoomEntity ifLocationRoomExists(Integer locationId);

    @Query(SyncQueries.IF_LOCATION_EQUIPMENT_EXIST_QUERY)
    public abstract LocationEquipmentsEntity ifLocationEquipmentExists(Integer locationId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertLocationRooms(LocationRoomEntity locationRoomEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertLocationEquipment(LocationEquipmentsEntity locationEquipmentsEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertQRStorage(QRStorageEntity qrStorageEntity);

    @Query(SyncQueries.DELETE_QR_STORAGE)
    public abstract void deleteQRStorage(Integer qrStorageID);

    @Query(SyncQueries.GET_ASSIGNED_CHECKLIST)
    public abstract AssignCheckListEntity getAssignedChecklist(String checklistUuid);

    @Query(SyncQueries.QUERY_DELETE_OLD_WORKORDER_NOTE_ATTACHMENT)
    public abstract void deleteSyncedWorkorderAttachment(String oldId);

    @Query(SyncQueries.QUERY_DELETE_OLD_WORKORDER_NOTE_DETAIL)
    public abstract void deleteSyncedWorkorderNoteDetail(Integer oldId);

    @Query(SyncQueries.QUERY_DELETE_OLD_WORKORDER_NOTES)
    public abstract void deleteSyncedWorkorderNote(Integer oldId);

    @Query(SyncQueries.QUERY_DELETE_OLD_WORKORDER)
    public abstract void deleteSyncedWorkorder(Integer oldId);

    @Transaction
    public void insertChecklistAssociatedData(AllChecklistEntity checklist,
                                              CheckListTitlesEntity checklistTitle,
                                              List<CheckListLogoEntity> checklistLogos
    ) {
        insertChecklists(checklist);
        insertChecklistsTitle(checklistTitle);

        if (checklistLogos.size() > 0) {
            insertChecklistLogo(checklistLogos);
        }
    }

    @Transaction
    public void saveWorkOrder(WorkOrderEntity workOrderEntity,
                              List<WorkOrderNotesEntity> workOrderNoteEntities,
                              List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntities,
                              List<WorkOrderAttachmentsEntity> workOrderAttachmentEntities
    ) {
        if (workOrder(workOrderEntity.getUuid()) == null) {
            insertWorkOrder(workOrderEntity);
        } else {
            updateWorkOrder(workOrderEntity);
        }

        List<WorkOrderNotesEntity> insertNotes = new ArrayList<>();
        List<WorkOrderNotesEntity> updateNotes = new ArrayList<>();

        for (WorkOrderNotesEntity entity : workOrderNoteEntities) {
            if (workOrderNote(entity.getUuid()) == null) {
                insertNotes.add(entity);
            } else {
                updateNotes.add(entity);
            }
        }

        insertWorkOrderNotes(insertNotes);
        updateWorkOrderNotes(updateNotes);

        List<WorkOrderNoteDetailEntity> insertDetails = new ArrayList<>();
        List<WorkOrderNoteDetailEntity> updateDetails = new ArrayList<>();

        for (WorkOrderNoteDetailEntity entity :
                workOrderNoteDetailEntities) {
            if (workOrderNoteDetail(entity.getUuid()) == null) {
                insertDetails.add(entity);
            } else {
                updateDetails.add(entity);
            }
        }

        insertWorkOrderNoteDetails(insertDetails);
        updateWorkOrderNoteDetails(updateDetails);

        List<WorkOrderAttachmentsEntity> insertAttachments = new ArrayList<>();
        List<WorkOrderAttachmentsEntity> updateAttachments = new ArrayList<>();

        for (WorkOrderAttachmentsEntity entity : workOrderAttachmentEntities) {
            if (workOrderAttachment(entity.getUuid()) == null) {
                insertAttachments.add(entity);
            } else {
                updateAttachments.add(entity);
            }
        }

        insertWorkOrderAttachments(insertAttachments);
        updateWorkOrderAttachments(updateAttachments);
    }


}
