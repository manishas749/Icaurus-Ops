package com.icarus.synchronization;

import android.content.Context;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
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
import com.icarus.entities.Login;
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
import com.icarus.enums.ChecklistElementType;
import com.icarus.synchronization.postsyncmodel.WorkorderAttachment;
import com.icarus.synchronization.postsyncmodel.WorkorderNote;
import com.icarus.synchronization.postsyncmodel.WorkorderNoteDetail;
import com.icarus.synchronization.postsyncmodel.WorkorderObject;
import com.icarus.synchronization.syncmodels.ChecklistLocationObject;
import com.icarus.synchronization.syncmodels.ChecklistStatusObject;
import com.icarus.synchronization.syncmodels.ChecklistTypeObject;
import com.icarus.synchronization.syncmodels.ClientSettingObject;
import com.icarus.synchronization.syncmodels.DepartmentObject;
import com.icarus.synchronization.syncmodels.EquipmentObject;
import com.icarus.synchronization.syncmodels.GroupObject;
import com.icarus.synchronization.syncmodels.HazardObject;
import com.icarus.synchronization.syncmodels.ItemTypeObject;
import com.icarus.synchronization.syncmodels.PpeObject;
import com.icarus.synchronization.syncmodels.QrStorage;
import com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail;
import com.icarus.synchronization.syncmodels.RetreiveChecklistExecutionPermission;
import com.icarus.synchronization.syncmodels.RetrieveAllChecklistElement;
import com.icarus.synchronization.syncmodels.RetrieveAllClientLogo;
import com.icarus.synchronization.syncmodels.RetrieveAssignedChecklist;
import com.icarus.synchronization.syncmodels.RetrieveChecklists;
import com.icarus.synchronization.syncmodels.RetrieveLocationEquipment;
import com.icarus.synchronization.syncmodels.RetrieveLocationRoomEquipment;
import com.icarus.synchronization.syncmodels.RetrieveLocationRooms;
import com.icarus.synchronization.syncmodels.RetrieveLocations;
import com.icarus.synchronization.syncmodels.RetrieveUsers;
import com.icarus.synchronization.syncmodels.RetrieveUsersFavourites;
import com.icarus.synchronization.syncmodels.RoomObject;
import com.icarus.synchronization.syncmodels.WorkorderBillingTypeObject;
import com.icarus.synchronization.syncmodels.WorkorderStatusObject;
import com.icarus.util.FileUtils;
import com.icarus.util.MD5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import c.anurag.network.beans.AssigneeTypeEnum;

public class ModelMapper {


    public static GroupEntity mapGroupEntity(GroupObject groupObject) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(groupObject.getId());
        groupEntity.setName(groupObject.getName());
        groupEntity.setModified(groupObject.getUpdatedAt());
        return groupEntity;
    }

    public static ItemTypeEntity mapItemTypeEntity(ItemTypeObject itemTypeObject) {
        ItemTypeEntity itemTypeEntity = new ItemTypeEntity();
        itemTypeEntity.setDescription(itemTypeObject.getDescription());
        itemTypeEntity.setId(itemTypeObject.getId());
        itemTypeEntity.setUuid(itemTypeObject.getUuid());
        return itemTypeEntity;
    }

    public static PepesEntity mapPepesEntity(PpeObject ppeObject) {
        PepesEntity pepesEntity = new PepesEntity();
        pepesEntity.setIcon(ppeObject.getIcon());
        pepesEntity.setId((int) Math.round(ppeObject.getId()));
        pepesEntity.setLabel(ppeObject.getLabel());
        pepesEntity.setModified(ppeObject.getUpdatedAt() + "");
        pepesEntity.setUuid(ppeObject.getUuid());
        pepesEntity.setStatus(ppeObject.getStatus() ? 1 : 0);
        pepesEntity.setFileMd5Checksum(ppeObject.getFileMd5Checksum());
        return pepesEntity;
    }

    public static HazardsEntity mapHazardsEntity(HazardObject hazardObject) {
        HazardsEntity hazardsEntity = new HazardsEntity();
        hazardsEntity.setIcon(hazardObject.getIcon());
        hazardsEntity.setId((int) Math.round(hazardObject.getId()));
        hazardsEntity.setLabel(hazardObject.getLabel());
        hazardsEntity.setModified(hazardObject.getUpdatedAt() + "");
        hazardsEntity.setFileMd5Checksum(hazardObject.getFileMd5Checksum());
        hazardsEntity.setUuid(hazardObject.getUuid());
        return hazardsEntity;
    }

    public static ClientSettingEntity mapClientSettingEntity(ClientSettingObject clientSettingObject) {
        ClientSettingEntity clientSettingEntity = new ClientSettingEntity();
        clientSettingEntity.setCreated(clientSettingObject.getCreatedAt() + "");
        clientSettingEntity.setId(clientSettingObject.getId());
        clientSettingEntity.setModified(clientSettingObject.getUpdatedAt() + "");
        clientSettingEntity.setName(clientSettingObject.getName());
        clientSettingEntity.setValue(clientSettingObject.getValue());
        clientSettingEntity.setUuid(clientSettingObject.getUuid());
        return clientSettingEntity;
    }

    public static ChecklistTypeEntity mapChecklistTypeEntity(ChecklistTypeObject checklistTypeObject) {
        ChecklistTypeEntity checklistTypeEntity = new ChecklistTypeEntity();
        checklistTypeEntity.setDescription(checklistTypeObject.getDescription());
        checklistTypeEntity.setId(checklistTypeObject.getId());
        checklistTypeEntity.setIsDeleted(checklistTypeObject.getIsDeleted() ? 1 : 0);
        checklistTypeEntity.setModified(checklistTypeObject.getUpdatedAt() + "");
        checklistTypeEntity.setType(checklistTypeObject.getType() + "");
        checklistTypeEntity.setDescription(checklistTypeObject.getDescription() + "");
        checklistTypeEntity.setUuid(checklistTypeObject.getUuid());
        return checklistTypeEntity;
    }

    public static ChecklistStatusEntity mapChecklistStatusEntity(ChecklistStatusObject checklistStatusObject) {
        ChecklistStatusEntity checklistStatusEntity = new ChecklistStatusEntity();
        checklistStatusEntity.setModified(checklistStatusObject.getUpdatedAt() + "");
        checklistStatusEntity.setDescription(checklistStatusObject.getDescription());
        checklistStatusEntity.setEditAllowed(checklistStatusObject.getEditAllowed() ? 1 : 0);
        checklistStatusEntity.setId(checklistStatusObject.getId());
        checklistStatusEntity.setIsDefault(checklistStatusObject.getIsDefault() ? 1 : 0);
        checklistStatusEntity.setIsClosed(checklistStatusObject.getIsClosed() ? 1 : 0);
        checklistStatusEntity.setIsDeleted(Constants.NOT_DELETED);
        checklistStatusEntity.setIsExpired(checklistStatusObject.getIsExpired() ? 1 : 0);
        checklistStatusEntity.setName(checklistStatusObject.getName());
        checklistStatusEntity.setModified(checklistStatusObject.getUpdatedAt() + "");
        checklistStatusEntity.setSortOrder(checklistStatusObject.getSortOrder());
        return checklistStatusEntity;
    }

    public static ChecklistExecutionPermission mapChecklistExecutionPermissionEntity(RetreiveChecklistExecutionPermission.Datum datum) {
        ChecklistExecutionPermission checklistExecutionPermission = new ChecklistExecutionPermission();
        checklistExecutionPermission.setId(datum.getId());
        checklistExecutionPermission.setChecklist_status_id(datum.getChecklistStatusId());
        checklistExecutionPermission.setChecklist_type_id(datum.getChecklistTypeId());
        checklistExecutionPermission.setGroup_id(datum.getGroupId());
        checklistExecutionPermission.setIs_assignable(datum.getAssignable() ? 1 : 0);
        checklistExecutionPermission.setIs_executable(datum.getExecutable() ? 1 : 0);
        checklistExecutionPermission.setModified(datum.getUpdatedAt());
        return checklistExecutionPermission;
    }

    public static WorkOrdeStatusEntity mopWorkOrdeStatusEntity(WorkorderStatusObject workorderStatusObject) {
        WorkOrdeStatusEntity workOrdeStatusEntity = new WorkOrdeStatusEntity();
        workOrdeStatusEntity.setId(workorderStatusObject.getId());
        workOrdeStatusEntity.setIsDefault(workorderStatusObject.getIsDefault() ? 1 : 0);
        workOrdeStatusEntity.setName(workorderStatusObject.getName().getValue());
        return workOrdeStatusEntity;
    }

    public static WorkOrderBillingTypeEntity mapWorkOrderBillingTypeEntity(WorkorderBillingTypeObject workorderBillingTypeObject) {
        WorkOrderBillingTypeEntity workOrderBillingTypeEntity = new WorkOrderBillingTypeEntity();
        workOrderBillingTypeEntity.setId(workorderBillingTypeObject.getId());
        workOrderBillingTypeEntity.setIsDefault(workorderBillingTypeObject.getIsDefault() ? 1 : 0);
        workOrderBillingTypeEntity.setName(workorderBillingTypeObject.getName());
        workOrderBillingTypeEntity.setModified(workorderBillingTypeObject.getUpdatedAt());
        return workOrderBillingTypeEntity;
    }

    public static WorkOrderEntity mapWorkOrderEntity(WorkorderObject workorderObject, Integer executionStatus) {
        WorkOrderEntity workOrderEntity = new WorkOrderEntity();
        workOrderEntity.setId(workorderObject.getId());
        workOrderEntity.setAssignedToId(workorderObject.getAssignedToId());
        workOrderEntity.setAssignedToType(workorderObject.getAssignedToType());
        workOrderEntity.setAuthorId(workorderObject.getAuthorId());
        workOrderEntity.setChecklistId(workorderObject.getChecklistId());
        workOrderEntity.setClosedDate(workorderObject.getClosedDate());
        workOrderEntity.setCreated(workorderObject.getCreatedAt());
        workOrderEntity.setDescription(workorderObject.getDescription());
        workOrderEntity.setDueDate(workorderObject.getDueDate());
        workOrderEntity.setLocationEquipmentId(workorderObject.getLocationEquipmentId());
        workOrderEntity.setLocationId(workorderObject.getLocationId());
        workOrderEntity.setLocationRoomId(workorderObject.getLocationRoomId());
        workOrderEntity.setStartDate(workorderObject.getStartDate());
        workOrderEntity.setTitle(workorderObject.getTitle());
        workOrderEntity.setUuid(workorderObject.getUuid());
        workOrderEntity.setWorkorderBillingTypeId(workorderObject.getWorkorderBillingTypeId());
        workOrderEntity.setWorkorderPriorityId(workorderObject.getWorkorderPriorityId());
        workOrderEntity.setWorkorderStatusId(workorderObject.getWorkorderStatusId());
        workOrderEntity.setModified(workorderObject.getUpdatedAt());
        workOrderEntity.setSyncStatus(Constants.SYNC_STATUS);
        workOrderEntity.setExecutionStatus(executionStatus);
        return workOrderEntity;
    }

    public static WorkOrderAttachmentsEntity mapWorkOrderAttachment(com.icarus.synchronization.syncmodels.WorkorderAttachment workorderAttachment, Integer workorderId, Integer authorId) {
        WorkOrderAttachmentsEntity workOrderAttachmentsEntity = new WorkOrderAttachmentsEntity();
        workOrderAttachmentsEntity.setId(workorderAttachment.getId());
        workOrderAttachmentsEntity.setAuthorId(workorderAttachment.getAuthorId() == null ? authorId : workorderAttachment.getAuthorId());
        workOrderAttachmentsEntity.setContentType(workorderAttachment.getContentType());
        workOrderAttachmentsEntity.setCreated(workorderAttachment.getCreatedAt());
        workOrderAttachmentsEntity.setDisplayFileName(workorderAttachment.getDisplayFilename());
        workOrderAttachmentsEntity.setFileMd5Checksum(workorderAttachment.getMd5Checksum());
        workOrderAttachmentsEntity.setFilename(workorderAttachment.getFilename());
        workOrderAttachmentsEntity.setFilesize(workorderAttachment.getFileSize());
        workOrderAttachmentsEntity.setUuid(workorderAttachment.getUuid());
        workOrderAttachmentsEntity.setWorkorderId(workorderId);
        workOrderAttachmentsEntity.setModified(workorderAttachment.getUpdatedAt());
        workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        workOrderAttachmentsEntity.setIsUploaded(Constants.UPLOADED);
        workOrderAttachmentsEntity.setIsDownloaded(Constants.NOT_DOWNLOADED);
        return workOrderAttachmentsEntity;
    }

    public static WorkOrderAttachmentsEntity mapWorkOrderAttachmentPost(com.icarus.synchronization.postsyncmodel.WorkorderAttachment workorderAttachment, Integer workorderId, Integer authorId) {
        WorkOrderAttachmentsEntity workOrderAttachmentsEntity = new WorkOrderAttachmentsEntity();
        workOrderAttachmentsEntity.setId(workorderAttachment.getId());
        workOrderAttachmentsEntity.setAuthorId(workorderAttachment.getAuthorId() == null ? authorId : workorderAttachment.getAuthorId());
        workOrderAttachmentsEntity.setContentType(workorderAttachment.getContentType());
        workOrderAttachmentsEntity.setCreated(workorderAttachment.getCreatedAt());
        workOrderAttachmentsEntity.setDisplayFileName(workorderAttachment.getDisplayFilename());
        workOrderAttachmentsEntity.setFileMd5Checksum(workorderAttachment.getMd5Checksum());
        workOrderAttachmentsEntity.setFilename(workorderAttachment.getFilename());
        workOrderAttachmentsEntity.setFilesize(workorderAttachment.getFileSize());
        workOrderAttachmentsEntity.setUuid(workorderAttachment.getUuid());
        workOrderAttachmentsEntity.setWorkorderId(workorderId);
        workOrderAttachmentsEntity.setModified(workorderAttachment.getUpdatedAt());
        workOrderAttachmentsEntity.setIsDownloaded(Constants.DOWNLOADED);
        workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        return workOrderAttachmentsEntity;
    }

    public static WorkOrderNotesEntity mapWorkOrderNote(com.icarus.synchronization.syncmodels.WorkorderNote workorderAttachment, Integer workorderId, Integer userId) {
        WorkOrderNotesEntity workOrderAttachmentsEntity = new WorkOrderNotesEntity();
        workOrderAttachmentsEntity.setId(workorderAttachment.getId());
        workOrderAttachmentsEntity.setUserId(workorderAttachment.getUserId());
        workOrderAttachmentsEntity.setWorkorderNotes(workorderAttachment.getWorkorderNotes());
        workOrderAttachmentsEntity.setCreated(workorderAttachment.getCreatedAt());
        workOrderAttachmentsEntity.setUuid(workorderAttachment.getUuid());
        workOrderAttachmentsEntity.setWorkorderId(workorderId);
        workOrderAttachmentsEntity.setUserId(workorderAttachment.getUserId() == null ? userId : workorderAttachment.getUserId());
        workOrderAttachmentsEntity.setModified(workorderAttachment.getUpdatedAt());
        workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        return workOrderAttachmentsEntity;
    }

    public static WorkOrderNotesEntity mapWorkOrderNotePost(com.icarus.synchronization.postsyncmodel.WorkorderNote workorderAttachment, Integer workorderId, Integer userId) {
        WorkOrderNotesEntity workOrderAttachmentsEntity = new WorkOrderNotesEntity();
        workOrderAttachmentsEntity.setId(workorderAttachment.getId());
        workOrderAttachmentsEntity.setUserId(workorderAttachment.getUserId());
        workOrderAttachmentsEntity.setWorkorderNotes(workorderAttachment.getWorkorderNotes());
        workOrderAttachmentsEntity.setCreated(workorderAttachment.getCreatedAt());
        workOrderAttachmentsEntity.setUuid(workorderAttachment.getUuid());
        workOrderAttachmentsEntity.setWorkorderId(workorderId);
        workOrderAttachmentsEntity.setUserId(workorderAttachment.getUserId() == null ? userId : workorderAttachment.getUserId());
        workOrderAttachmentsEntity.setModified(workorderAttachment.getUpdatedAt());
        workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        return workOrderAttachmentsEntity;
    }

    public static WorkOrderNoteDetailEntity mapWorkOrderNoteDetail(com.icarus.synchronization.syncmodels.WorkorderNoteDetail workorderAttachment, Integer workorderNoteId) {
        WorkOrderNoteDetailEntity workOrderAttachmentsEntity = new WorkOrderNoteDetailEntity();
        workOrderAttachmentsEntity.setId(workorderAttachment.getId());
        workOrderAttachmentsEntity.setOldValue(workorderAttachment.getOldValue());
        workOrderAttachmentsEntity.setValue(workorderAttachment.getValue());
        workOrderAttachmentsEntity.setProperty(workorderAttachment.getProperty());
        workOrderAttachmentsEntity.setPropertyKey(workorderAttachment.getPropertyKey());
        workOrderAttachmentsEntity.setCreated(workorderAttachment.getCreatedAt());
        workOrderAttachmentsEntity.setUuid(workorderAttachment.getUuid());
        workOrderAttachmentsEntity.setWorkorderNoteId(workorderNoteId);
        workOrderAttachmentsEntity.setModified(workorderAttachment.getUpdatedAt());
        workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        return workOrderAttachmentsEntity;
    }

    public static WorkOrderNoteDetailEntity mapWorkOrderNoteDetailPost(com.icarus.synchronization.postsyncmodel.WorkorderNoteDetail workorderAttachment, Integer workorderNoteId) {
        WorkOrderNoteDetailEntity workOrderAttachmentsEntity = new WorkOrderNoteDetailEntity();
        workOrderAttachmentsEntity.setId(workorderAttachment.getId());
        workOrderAttachmentsEntity.setOldValue(workorderAttachment.getOldValue());
        workOrderAttachmentsEntity.setValue(workorderAttachment.getValue());
        workOrderAttachmentsEntity.setProperty(workorderAttachment.getProperty());
        workOrderAttachmentsEntity.setPropertyKey(workorderAttachment.getPropertyKey());
        workOrderAttachmentsEntity.setCreated(workorderAttachment.getCreatedAt());
        workOrderAttachmentsEntity.setUuid(workorderAttachment.getUuid());
        workOrderAttachmentsEntity.setWorkorderNoteId(workorderNoteId);
        workOrderAttachmentsEntity.setModified(workorderAttachment.getUpdatedAt());
        workOrderAttachmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        return workOrderAttachmentsEntity;
    }

    public static DepartmentsEntity mapDepartmentEntity(DepartmentObject departmentObject) {
        DepartmentsEntity departmentsEntity = new DepartmentsEntity();
        departmentsEntity.setId(departmentObject.getId());
        departmentsEntity.setIsDeleted(departmentObject.getIsDeleted() ? 1 : 0);
        departmentsEntity.setModified(departmentObject.getUpdatedAt() + "");
        departmentsEntity.setShortName(departmentObject.getShortName());
        departmentsEntity.setUuid(departmentObject.getUuid());
        departmentsEntity.setName(departmentObject.getName());
        return departmentsEntity;
    }

    public static RoomsEntity mapRoomsEntity(RetrieveLocationRooms.Room roomObject) {
        RoomsEntity roomsEntity = new RoomsEntity();
        roomsEntity.setId(roomObject.getId());
        roomsEntity.setIsDefault(roomObject.getIsDefault() ? 1 : 0);
        roomsEntity.setIsDeleted(roomObject.getIsDeleted() ? 1 : 0);
        roomsEntity.setModified(roomObject.getUpdatedAt() + "");
        roomsEntity.setName(roomObject.getName());
        roomsEntity.setUuid(roomObject.getUuid());
        return roomsEntity;
    }

    public static EquipmentsEntity mapEquipmentsEntity(RetrieveLocationEquipment.Equipment equipmentObject) {
        EquipmentsEntity equipmentsEntity = new EquipmentsEntity();
        equipmentsEntity.setId(equipmentObject.getId());
        equipmentsEntity.setIsDefault(equipmentObject.getIsDefault() ? 1 : 0);
        equipmentsEntity.setIsDeleted(equipmentObject.getIsDeleted() ? 1 : 0);
        equipmentsEntity.setModified(equipmentObject.getUpdatedAt() + "");
        equipmentsEntity.setName(equipmentObject.getName());
        equipmentsEntity.setUuid(equipmentObject.getUuid());
        return equipmentsEntity;
    }


    public static WorkOrdeStatusEntity mapWorkorderStatusEntity(WorkorderStatusObject workorderStatusObject) {
        WorkOrdeStatusEntity workOrdeStatusEntity = new WorkOrdeStatusEntity();
        workOrdeStatusEntity.setId(workorderStatusObject.getId());
        workOrdeStatusEntity.setIsDefault(workorderStatusObject.getIsDefault() ? 1 : 0);
        workOrdeStatusEntity.setName(workorderStatusObject.getName() + "");
        workOrdeStatusEntity.setModified(workorderStatusObject.getUpdatedAt());
        return workOrdeStatusEntity;
    }

    public static AllChecklistEntity mapChecklistEntity(RetrieveChecklists.Datum cheklistObject) {
        AllChecklistEntity allChecklistEntity = new AllChecklistEntity();
        allChecklistEntity.setUuid(cheklistObject.getUuid());
        allChecklistEntity.setAuthorId(cheklistObject.getAuthorId());
        allChecklistEntity.setAssignedToId(cheklistObject.getAssignedToId());
        allChecklistEntity.setChecklistStatusId(cheklistObject.getChecklistStatusId());
        allChecklistEntity.setDueAt(cheklistObject.getDueAt());
        allChecklistEntity.setIsApprovalRequired(cheklistObject.getApprovalRequired() ? 1 : 0);
        allChecklistEntity.setChecklistStatusId(cheklistObject.getChecklistStatusId());
        allChecklistEntity.setChecklistTypeId(cheklistObject.getChecklistTypeId());
        allChecklistEntity.setDepartmentId(cheklistObject.getDepartmentId());
        allChecklistEntity.setId(cheklistObject.getId());
        allChecklistEntity.setEstimateHours(cheklistObject.getEstimatedHours() + "");
        allChecklistEntity.setIsSequential(cheklistObject.getSequential() ? 1 : 0);
        allChecklistEntity.setIsTemplate(cheklistObject.getTemplate() ? 1 : 0);
        allChecklistEntity.setModified(cheklistObject.getUpdatedAt());
        allChecklistEntity.setParentId(cheklistObject.getParentId());
        allChecklistEntity.setIsDeleted(cheklistObject.getDeleted() ? 1 : 0);
        allChecklistEntity.setPlaceholderCount(cheklistObject.getPlaceholderCount());
        allChecklistEntity.setSyncStatus(Constants.SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED);
        allChecklistEntity.setPendingReferencesCount(Constants.DEFAULT_PENDING_RESOURCE_COUNT);
        allChecklistEntity.setPendingResourcesCount(Constants.DEFAULT_PENDING_RESOURCE_COUNT);
        return allChecklistEntity;
    }

    public static LocationEntity mapLocationEntity(RetrieveLocations.Datum datum) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setId(datum.getId());
        locationEntity.setName(datum.getName());
        locationEntity.setTimezone(datum.getTimezone());
        return locationEntity;
    }

    public static LocationDepartmentsEntity mapLocationDepartmentEntity(
            RetrieveLocations.LocationDepartment locationDepartment
    ) {
        LocationDepartmentsEntity locationEntity = new LocationDepartmentsEntity();
        locationEntity.setDepartment_id(locationDepartment.getDepartmentId());
        locationEntity.setId(locationDepartment.getId());
        locationEntity.setIs_deleted(locationDepartment.getDeleted() ? 1 : 0);
        locationEntity.setLocation_id(locationDepartment.getLocationId());
        locationEntity.setModified(locationDepartment.getUpdatedAt());
        return locationEntity;
    }

    public static LocationRoomEquipmentsEntity mapLocationRoomEquipmentsEntity(
            RetrieveLocationRoomEquipment.Datum locationRoomEquipment)
    {
        LocationRoomEquipmentsEntity locationRoomEquipmentsEntity = new LocationRoomEquipmentsEntity();
        locationRoomEquipmentsEntity.setEquipmentId(locationRoomEquipment.getEquipmentId());
        locationRoomEquipmentsEntity.setId(locationRoomEquipment.getId());
        locationRoomEquipmentsEntity.setIsDeleted(locationRoomEquipment.getIsDeleted() ? 1 : 0);
        locationRoomEquipmentsEntity.setLocationId(locationRoomEquipment.getLocationId());
        locationRoomEquipmentsEntity.setRoomId(locationRoomEquipment.getRoomId());
        locationRoomEquipmentsEntity.setModified(locationRoomEquipment.getUpdatedAt());
        return locationRoomEquipmentsEntity;
    }

    public static LocationEquipmentsEntity mapLocationEquipmentsEntity(RetrieveLocationEquipment.Datum location) {
        RetrieveLocationEquipment.Equipment locationEquipment = location.getEquipment();
        LocationEquipmentsEntity locationEquipmentsEntity = new LocationEquipmentsEntity();
        locationEquipmentsEntity.setEquipmentId(locationEquipment.getId());
        locationEquipmentsEntity.setId(location.getId());
        locationEquipmentsEntity.setIsDeleted(location.getIsDeleted());
        locationEquipmentsEntity.setLocationId(location.getLocationId());
        locationEquipmentsEntity.setModified(location.getUpdatedAt());
        locationEquipmentsEntity.setSerialNumber(location.getSerialNumber());
        locationEquipmentsEntity.setUpcNumber(location.getUpcNumber());
        return locationEquipmentsEntity;
    }

    public static LocationRoomEntity mapLocationRoomEntity(RetrieveLocationRooms.Datum location) {
        LocationRoomEntity locationRoomEntity = new LocationRoomEntity();
        RetrieveLocationRooms.Room locationRoom = location.getRoom();
        locationRoomEntity.setId(location.getId());
        locationRoomEntity.setIsDeleted(location.getIsDeleted());
        locationRoomEntity.setLocationId(location.getLocationId());
        locationRoomEntity.setModified(location.getUpdatedAt());
        locationRoomEntity.setRoomId(locationRoom.getId());
        return locationRoomEntity;
    }

    public static QRStorageEntity mapQRStorage(QrStorage qrStorage,
                                               Integer locationRoomId,
                                               String model) {
        QRStorageEntity qrStorageEntity = new QRStorageEntity();
        qrStorageEntity.setId(qrStorage.getId());
        qrStorageEntity.setCode(qrStorage.getCode());
        qrStorageEntity.setUuid(qrStorage.getUuid());
        qrStorageEntity.setForeignKey(String.valueOf(locationRoomId));
        qrStorageEntity.setModel(model);
        qrStorageEntity.setModified(qrStorage.getUpdatedAt());
        return qrStorageEntity;
    }

    public static Login mapLoginUserEntity(RetrieveUsers.Datum datum, boolean termsAccepted) {
        Login userEntity = new Login();
        userEntity.setClientUuid(BaseApplication.getPreferenceManager().getClientUuid());
        userEntity.setEmail(datum.getEmail());
        userEntity.setFullName(datum.getFullName());
        userEntity.setPassword(datum.getPassword());
        userEntity.setUuid(datum.getUuid());
        userEntity.setUsername(datum.getUsername());
        userEntity.setGroupId(datum.getGroupId());
        userEntity.setId(datum.getId());
        userEntity.setAdministrator(datum.getAdministrator());
        userEntity.setDeleted(datum.getDeleted());
        userEntity.setUuid(datum.getUuid());
        userEntity.setTermsAccepted(termsAccepted);
        return userEntity;
    }

    public static UsersEntity mapUserEntity(RetrieveUsers.Datum datum) {
        UsersEntity userEntity = new UsersEntity();
        userEntity.setAccountUuid(BaseApplication.getPreferenceManager().getClientUuid());
        userEntity.setBusinessName(datum.getBusinessName());
        userEntity.setEmail(datum.getEmail());
        userEntity.setFullName(datum.getFullName());
        userEntity.setIsAdministrator(datum.getAdministrator() ? 1 : 0);
        userEntity.setIsDeleted(datum.getDeleted() ? 1 : 0);
        userEntity.setLastLocationId(BaseApplication.getPreferenceManager().getUserLocationId());
        userEntity.setPassword(datum.getPassword());
        userEntity.setUuid(datum.getUuid());
        userEntity.setUsername(datum.getUsername());
        userEntity.setGroupId(datum.getGroupId());
        userEntity.setModified(datum.getUpdatedAt());
        userEntity.setId(datum.getId());
        return userEntity;
    }

    public static UserLocationsDepartments mapUserLocationDepartment(RetrieveUsers.UserLocationDepartment userLocationDepartment, RetrieveUsers.Datum data) {
        UserLocationsDepartments userLocationsDepartmentEntitt = new UserLocationsDepartments();
        userLocationsDepartmentEntitt.setDepartmentId(userLocationDepartment.getDepartmentId());
        userLocationsDepartmentEntitt.setCreated(data.getCreatedAt());
        userLocationsDepartmentEntitt.setId(userLocationDepartment.getId());
        userLocationsDepartmentEntitt.setLocationId(userLocationDepartment.getLocationId());
        userLocationsDepartmentEntitt.setModified(data.getUpdatedAt());
        userLocationsDepartmentEntitt.setUser_id(userLocationDepartment.getUserId());
        userLocationsDepartmentEntitt.setIsDeleted(userLocationDepartment.getDeleted() ? 1 : 0);
        return userLocationsDepartmentEntitt;
    }


    public static UserFavouritesEntity mapUserFavourite(RetrieveUsersFavourites.Datum datum) {
        UserFavouritesEntity userFavouritesEntity = new UserFavouritesEntity();
        userFavouritesEntity.setModified(datum.getUpdatedAt());
        userFavouritesEntity.setCreated(datum.getCreatedAt());
        userFavouritesEntity.setUuid(datum.getUuid());
        userFavouritesEntity.setSyncStatus(Constants.SYNC_STATUS);
        userFavouritesEntity.setUserId(datum.getUserId());
        userFavouritesEntity.setChecklistId(datum.getChecklistId());
        userFavouritesEntity.setIsDeleted(datum.getDeleted() ? 1 : 0);
        return userFavouritesEntity;
    }

    public static ClientLogoEntity mapClientLogoEntity(RetrieveAllClientLogo.Datum clientLogoObject) {
        ClientLogoEntity clientLogoEntity = new ClientLogoEntity();
        clientLogoEntity.setFileMd5Checksum(clientLogoObject.getFileMd5Checksum());
        clientLogoEntity.setCreated(clientLogoObject.getCreatedAt());
        clientLogoEntity.setId(clientLogoObject.getId());
        clientLogoEntity.setIsDownloaded(0);
        clientLogoEntity.setModified(clientLogoObject.getUpdatedAt());
        clientLogoEntity.setName(clientLogoObject.getName());
        clientLogoEntity.setUuid(clientLogoObject.getUuid());
        clientLogoEntity.setUserId(clientLogoObject.getUserId());
        return clientLogoEntity;
    }

    public static ChecklistLocationEntity mapChecklistLocationEntity(ChecklistLocationObject.Datum datum) {
        ChecklistLocationEntity checklistLocationEntity = new ChecklistLocationEntity();
        checklistLocationEntity.setChecklistId(datum.getChecklistId());
        checklistLocationEntity.setId(datum.getId());
        checklistLocationEntity.setIsDeleted(datum.getDeleted() ? 1 : 0);
        checklistLocationEntity.setLocationId(datum.getLocationId());
        checklistLocationEntity.setModified(datum.getUpdatedAt());
        return checklistLocationEntity;
    }

    public static ChecklistElementsEntity mapChecklistElementsEntity(RetrieveAllChecklistElement.Datum datum) {
        ChecklistElementsEntity checklistElementsEntity = new ChecklistElementsEntity();
        checklistElementsEntity.setChecklistId(datum.getChecklistId());
        if (datum.getItem() != null)
            checklistElementsEntity.setDescription(datum.getItem().getDescription() != null ? datum.getItem().getDescription().toString() : "");
        checklistElementsEntity.setId(datum.getId());
        checklistElementsEntity.setIsDeleted(datum.getIsDeleted() ? 1 : 0);
        if (datum.getItem() != null)
            checklistElementsEntity.setItemId(datum.getItem().getId());
        else
            checklistElementsEntity.setItemId(1);

        checklistElementsEntity.setItemTypeId(datum.getItemTypeId());
        if (datum.getItem() != null)
            checklistElementsEntity.setItemUuid(datum.getItem().getUuid());
        checklistElementsEntity.setModified(datum.getUpdatedAt());
        checklistElementsEntity.setParentId(datum.getParentId());
        checklistElementsEntity.setSequenceNo(datum.getSequenceNo());
        checklistElementsEntity.setSortOrder(datum.getSortOrder());
        if (datum.getItem() != null)
            checklistElementsEntity.setTitle(datum.getItem().getTitle());
        return checklistElementsEntity;
    }

    public static StepAttributesEntity mapStepAttributes(RetrieveAllChecklistElement.Attribute attribute, String modified) {
        StepAttributesEntity stepAttributes = new StepAttributesEntity();
        stepAttributes.setCustomFieldId(attribute.getCustomField().getId());
        stepAttributes.setDescription(attribute.getDescription() != null ? attribute.getDescription().toString() : "");
        stepAttributes.setId(attribute.getId());
        stepAttributes.setIsDeleted(attribute.getIsDeleted() ? 1 : 0);
        stepAttributes.setLabel(attribute.getLabel());
        stepAttributes.setCustomFieldId(attribute.getCustomField().getId());
        stepAttributes.setStepId(attribute.getItemId());
        stepAttributes.setUuid(attribute.getUuid());
        stepAttributes.setModified(modified);
        stepAttributes.setSortOrder(attribute.getSortOrder());
        return stepAttributes;
    }

    public static CustomFieldsEntity mapCustomField(RetrieveAllChecklistElement.CustomField customField, String modified) {
        CustomFieldsEntity customFieldsEntity = new CustomFieldsEntity();
        customFieldsEntity.setAllowDescription(customField.getAllowDescription() != null && customField.getAllowDescription() ? 1 : 0);
        customFieldsEntity.setAllowedMediaTypes(customField.getAllowedMediaTypes());
        customFieldsEntity.setAllowGallery(customField.getAllowGallery() != null && customField.getAllowGallery() ? 1 : 0);
        customFieldsEntity.setDefaultValue(customField.getDefaultValue());
        customFieldsEntity.setDisplayAs(customField.getDisplayAs());
        customFieldsEntity.setId(customField.getId());
        customFieldsEntity.setIsDefault(customField.getIsDefault() != null && customField.getIsDefault() ? 1 : 0);
        customFieldsEntity.setMaxLength(customField.getMaxLength());
        customFieldsEntity.setMinLength(customField.getMinLength());
        customFieldsEntity.setMaxValue(customField.getMaxValue());
        customFieldsEntity.setMinValue(customField.getMinValue());
        customFieldsEntity.setIsDeleted(customField.getIsDeleted() != null && customField.getIsDeleted() ? 1 : 0);
        customFieldsEntity.setModel(customField.getModel());
        customFieldsEntity.setUuid(customField.getUuid());
        customFieldsEntity.setType(customField.getType());
        customFieldsEntity.setStepAttributeCount(0);
        customFieldsEntity.setSortOrder(customField.getSortOrder());
        customFieldsEntity.setRequired(customField.getIsRequired() != null && customField.getIsRequired() ? 1 : 0);
        customFieldsEntity.setUserRoles(Utils.join(customField.getUserRoles()));
        customFieldsEntity.setMultiple(customField.getIsMultiple() != null && customField.getIsMultiple() ? 1 : 0);
        customFieldsEntity.setName(customField.getName());
        customFieldsEntity.setModified(modified);
        customFieldsEntity.setPossibleValues(Utils.join(customField.getPossibleValues()));
        return customFieldsEntity;
    }

    public static NcwHazardsEntity mapNCWHazards(RetrieveAllChecklistElement.Item.Hazards hazards, Integer itemId, Integer itemTypeId) {
        NcwHazardsEntity ncwHazardsEntity = new NcwHazardsEntity();
        ncwHazardsEntity.setUuid(hazards.getUuid());
        //ncwHazardsEntity.setId(hazards.getId());
        ncwHazardsEntity.setHazard_id(hazards.getHazardId());
        ncwHazardsEntity.setModified(hazards.getUpdatedAt());
        ncwHazardsEntity.setIs_deleted(hazards.isDeleted() ? 1 : 0);
        ncwHazardsEntity.setItem_id(itemId);
        ncwHazardsEntity.setItem_type_id(itemTypeId);
        return ncwHazardsEntity;
    }

    public static CheckListPpesEntity mapChecklistPeps(RetrieveAllChecklistElement.Item.Ppes ppes, Integer itemId) {
        CheckListPpesEntity pepesEntity = new CheckListPpesEntity();
        pepesEntity.setId(ppes.getId());
        pepesEntity.setUuid(ppes.getUuid());
        pepesEntity.setIs_deleted(ppes.isDeleted() ? 1 : 0);
        pepesEntity.setStep_id(itemId);
        pepesEntity.setModified(ppes.getUpdatedAt());
        pepesEntity.setPpe_id(ppes.getPpeId());
        return pepesEntity;
    }

   /* public static CheckListPpesEntity mapChecklistPeps(Integer integer, Integer checklistId, Integer itemId) {
        CheckListPpesEntity pepesEntity = new CheckListPpesEntity();
        pepesEntity.setIs_deleted(Constants.NOT_DELETED);
        pepesEntity.setStep_id(itemId);
        pepesEntity.setModified(AppUtility.Companion.getUtcTime());
        pepesEntity.setPpe_id(integer);
        pepesEntity.setChecklist_id(checklistId);


        return pepesEntity;
    }*/

    public static PlaceholderEntity mapPlaceholder(RetrieveAllChecklistElement.Item.PlaceholderDate placeholder) {
        PlaceholderEntity placeholderEntity = new PlaceholderEntity();
        placeholderEntity.setId(placeholder.getId());
        placeholderEntity.setUuid(placeholder.getUuid());
        placeholderEntity.setName(placeholder.getName());
        placeholderEntity.setPlaceholder(placeholder.getPlaceholder());
        return placeholderEntity;
    }

    public static ItemPlaceholdersEntity mapItemPlaceholder(RetrieveAllChecklistElement.Item.Placeholder placeholder, String modified) {
        ItemPlaceholdersEntity itemPlaceholdersEntity = new ItemPlaceholdersEntity();
        itemPlaceholdersEntity.setId(placeholder.getId());
        itemPlaceholdersEntity.setIsDeleted(Constants.DELETED);
        itemPlaceholdersEntity.setItemId(placeholder.getItem_id());
        itemPlaceholdersEntity.setIsDeleted(placeholder.isIs_deleted() ? 1 : 0);
        itemPlaceholdersEntity.setPlaceholderId(placeholder.getPlaceholder().getId());
        itemPlaceholdersEntity.setItemTypeId(placeholder.getItem_type_id());
        itemPlaceholdersEntity.setSortOrder(placeholder.getSort_order());
        itemPlaceholdersEntity.setModified(modified);
        return itemPlaceholdersEntity;

    }

    public static AssignCheckListEntity mapAssignedChecklistEntity(RetrieveAssignedChecklist.Datum assignedCheckList) {
        AssignCheckListEntity assignCheckListEntity = new AssignCheckListEntity();
        assignCheckListEntity.setDepartmentId(assignedCheckList.getDepartmentId());
        assignCheckListEntity.setChecklistId(assignedCheckList.getChecklistId());
        assignCheckListEntity.setAssigneeType(assignedCheckList.getAssigneeType().equals(AssigneeTypeEnum.user.name()) ? AssigneeTypeEnum.user.getValue() : AssigneeTypeEnum.department.getValue());
        assignCheckListEntity.setIsDeleted(assignedCheckList.getIsDeleted() != null && assignedCheckList.getIsDeleted() ? 1 : 0);
        assignCheckListEntity.setModified(assignedCheckList.getUpdatedAt());
        if (assignedCheckList.getStatus().equals("pending"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING);
        else if (assignedCheckList.getStatus().equals("completed"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECK_LIST_STATUS_COMPLETED);
        else if (assignedCheckList.getStatus().equals("cancelled"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_CANCELLED);
        else if (assignedCheckList.getStatus().equals("paused"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PAUSED);
        else if (assignedCheckList.getStatus().equals("rejected"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_REJECTED);
        else if (assignedCheckList.getStatus().equals("closed"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_CLOSED);
        else if (assignedCheckList.getStatus().equals("pending_approval"))
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_PENDING_APPROVAL);
        else
            assignCheckListEntity.setChecklistStatus(Constants.CHECL_LIST_STATUS_RESUMED);

        assignCheckListEntity.setLocationId(assignedCheckList.getLocationId());
        assignCheckListEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignCheckListEntity.setStartedByUserId(assignedCheckList.getStartedByUserId());
        assignCheckListEntity.setUuid(assignedCheckList.getUuid());
        assignCheckListEntity.setDueDate(assignedCheckList.getDueAt());
        assignCheckListEntity.setUserId(assignedCheckList.getUserId());
        assignCheckListEntity.setAssignedAt(assignedCheckList.getAssignedAt());
        assignCheckListEntity.setCreated(assignedCheckList.getCreatedAt());
        assignCheckListEntity.setStartedAt(assignedCheckList.getStartedAt());
        assignCheckListEntity.setExecutionStatus(Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER);
        assignCheckListEntity.setPendingElementsCount(0);
        assignCheckListEntity.setPendingResourcesCount(0);
        return assignCheckListEntity;
    }


    public static AssignedLogoEntity mapAssignedLogoEntity(RetrieveAssignedChecklist.AssignedLogo assignedLogo, String assignedchecklistUuid) {
        AssignedLogoEntity assignedLogoEntity = new AssignedLogoEntity();
        assignedLogoEntity.setChecklistLogoId(assignedLogo.getChecklistLogoId());
        assignedLogoEntity.setUuid(assignedLogo.getUuid());
        assignedLogoEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignedLogoEntity.setAssignedChecklistUuid(assignedchecklistUuid);
        assignedLogoEntity.setModified(assignedLogo.getUpdatedAt());
        assignedLogoEntity.setCreated(assignedLogo.getCreatedAt());
        return assignedLogoEntity;
    }

    public static AssignRoomEquipmentsEntity mapAssignedRoomEquipmentEntity(RetrieveAssignedChecklist.AssignedRoomEquipment assignedRoomEquipment, String assignedChecklistUuid) {
        AssignRoomEquipmentsEntity assignRoomEquipmentsEntity = new AssignRoomEquipmentsEntity();
        assignRoomEquipmentsEntity.setModified(assignedRoomEquipment.getUpdatedAt());
        assignRoomEquipmentsEntity.setCreated(assignedRoomEquipment.getCreatedAt());
        assignRoomEquipmentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignRoomEquipmentsEntity.setIsDeleted(assignedRoomEquipment.getIsDeleted() ? 1 : 0);
        assignRoomEquipmentsEntity.setEquipmentId(assignedRoomEquipment.getEquipmentId());
        assignRoomEquipmentsEntity.setRoomId(assignedRoomEquipment.getRoomId());
        assignRoomEquipmentsEntity.setUuid(assignedRoomEquipment.getUuid());
        assignRoomEquipmentsEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        return assignRoomEquipmentsEntity;
    }

    public static AssignedNCWEntity mapAssignedCautionEntity(ReteriveAssignedChecklistDetail.AssignedCaution assignedCaution, String assigndChecklistUuid) {
        AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
        assignedNCWEntity.setSync_status(Constants.SYNC_STATUS);
        assignedNCWEntity.setCreated(assignedCaution.getCreatedAt() + "");
        assignedNCWEntity.setModified(assignedCaution.getUpdatedAt() + "");
        assignedNCWEntity.setUuid(assignedCaution.getUuid());
        assignedNCWEntity.setItemTypeId(ChecklistElementType.CAUTION.getValue());
        assignedNCWEntity.setAssigned_checklist_uuid(assigndChecklistUuid);
        assignedNCWEntity.setItemId(assignedCaution.getCautionId());
        if (assignedCaution.getStatus().equals(Parameters.ACKNOWLEDGE))
            assignedNCWEntity.setAcknowledged(1);
        else if (assignedCaution.getStatus().equals(Parameters.SKIPPED))
            assignedNCWEntity.setAcknowledged(2);
        else if (assignedCaution.getStatus().equals(Parameters.DEFERRED))
            assignedNCWEntity.setAcknowledged(3);
        else
            assignedNCWEntity.setAcknowledged(0);
        assignedNCWEntity.setIs_deleted(assignedCaution.getIsDeleted() ? 1 : 0);
        assignedNCWEntity.setUserId(assignedCaution.getUserId());
        assignedNCWEntity.setChecklistElementId(assignedCaution.getChecklistElementId());

        return assignedNCWEntity;
    }

    public static AssignedChecklistCommentsEntity mapAssignedCommentsEntity(ReteriveAssignedChecklistDetail.AssignedChecklistComment assignedChecklistComment, String assigndChecklistUuid) {
        AssignedChecklistCommentsEntity assignedChecklistCommentsEntity = new AssignedChecklistCommentsEntity();
        assignedChecklistCommentsEntity.setUuid(assignedChecklistComment.getUuid());
        assignedChecklistCommentsEntity.setAssigned_checklist_uuid(assigndChecklistUuid);
        assignedChecklistCommentsEntity.setChecklistId(assignedChecklistComment.getChecklistId());
        assignedChecklistCommentsEntity.setChecklistElementId(assignedChecklistComment.getChecklistElementId());
        assignedChecklistCommentsEntity.setComment(assignedChecklistComment.getComment());
        assignedChecklistCommentsEntity.setUserId(assignedChecklistComment.getUserId());
        assignedChecklistCommentsEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedChecklistCommentsEntity.setCreated(assignedChecklistComment.getCreatedAt());
        assignedChecklistCommentsEntity.setModified(assignedChecklistComment.getUpdatedAt());
        assignedChecklistCommentsEntity.setSyncStatus(Constants.SYNC_STATUS);
        return assignedChecklistCommentsEntity;
    }

    public static AssignedCheckListPauseTimesEntity mapAssignedPauseTimeEntity(ReteriveAssignedChecklistDetail.AssignedChecklistPauseTime assignedChecklistPauseTime, String assignedChecklistUuid) {
        AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity = new AssignedCheckListPauseTimesEntity();
        assignedCheckListPauseTimesEntity.setModified(assignedChecklistPauseTime.getUpdatedAt());
        assignedCheckListPauseTimesEntity.setReason(assignedChecklistPauseTime.getReason() != null ? assignedChecklistPauseTime.getReason() : "");
        assignedCheckListPauseTimesEntity.setResumed_by_user_id(assignedChecklistPauseTime.getResumedByUserId());
        assignedCheckListPauseTimesEntity.setIs_deleted(assignedChecklistPauseTime.getIsDeleted() ? 1 : 0);
        assignedCheckListPauseTimesEntity.setUser_id(assignedChecklistPauseTime.getUserId() != null ? assignedChecklistPauseTime.getUserId() : BaseApplication.getPreferenceManager().getUserId());
        assignedCheckListPauseTimesEntity.setUuid(assignedChecklistPauseTime.getUuid());
        assignedCheckListPauseTimesEntity.setSync_status(Constants.SYNC_STATUS);
        assignedCheckListPauseTimesEntity.setIs_paused(assignedChecklistPauseTime.getIsPaused() ? 1 : 0);
        assignedCheckListPauseTimesEntity.setCreated(assignedChecklistPauseTime.getCreatedAt());
        assignedCheckListPauseTimesEntity.setAssigned_checklist_uuid(assignedChecklistUuid);
        assignedCheckListPauseTimesEntity.setUuid(assignedChecklistPauseTime.getUuid());
        return assignedCheckListPauseTimesEntity;
    }

    public static AssignedDecisionEntity mapAssignedDecisionEntity(ReteriveAssignedChecklistDetail.AssignedDecision assignedDecision, String assigndChecklistUuid) {
        AssignedDecisionEntity assignedDecisionEntity = new AssignedDecisionEntity();
        if (assignedDecision.getStatus().equals(Parameters.SKIPPED))
            assignedDecisionEntity.setStatus(2);
        else if (assignedDecision.getStatus().equals(Parameters.DEFERRED))
            assignedDecisionEntity.setStatus(3);
        else if (assignedDecision.getStatus().equalsIgnoreCase(Parameters.YES))
            assignedDecisionEntity.setStatus(1);
        else
            assignedDecisionEntity.setStatus(0);
        assignedDecisionEntity.setUserId(assignedDecision.getUserId());
        assignedDecisionEntity.setUuid(assignedDecision.getUuid());
        assignedDecisionEntity.setIsDeleted(assignedDecision.getIsDeleted() ? 1 : 0);
        assignedDecisionEntity.setModified(assignedDecision.getUpdatedAt());
        assignedDecisionEntity.setDecisionId(assignedDecision.getDecisionId());
        assignedDecisionEntity.setChecklistElementId(assignedDecision.getChecklistElementId());
        assignedDecisionEntity.setAssignedChecklistUuid(assigndChecklistUuid);
        assignedDecisionEntity.setCreated(assignedDecision.getCreatedAt());
        assignedDecisionEntity.setSyncStatus(Constants.SYNC_STATUS);
        return assignedDecisionEntity;
    }

    public static AsssignedDepartmentsEntity mapAssignedDepartmentntity(RetrieveAssignedChecklist.AssignedDepartment assignedDepartment, String assignedchecklistUuid) {
        AsssignedDepartmentsEntity asssignedDepartmentsEntity = new AsssignedDepartmentsEntity();
        asssignedDepartmentsEntity.setModified(assignedDepartment.getUpdatedAt());
        asssignedDepartmentsEntity.setIs_deleted(assignedDepartment.getIsDeleted() ? 1 : 0);
        asssignedDepartmentsEntity.setDepartment_id(assignedDepartment.getDepartmentId());
        asssignedDepartmentsEntity.setUuid(assignedDepartment.getUuid());
        asssignedDepartmentsEntity.setAssigned_checklist_uuid(assignedchecklistUuid);
        return asssignedDepartmentsEntity;
    }

    public static AssignedItemPlaceholderEntity mapAssignedPlaceholdersEntity(ReteriveAssignedChecklistDetail.AssignedItemPlaceholder assignedItemPlaceholder, String assignedChecklistUUID) {
        AssignedItemPlaceholderEntity assignedItemPlaceholderEntity = new AssignedItemPlaceholderEntity();
        assignedItemPlaceholderEntity.setAssignedChecklistUuid(assignedItemPlaceholder.getAssignedChecklistUuid() != null ? assignedItemPlaceholder.getAssignedChecklistUuid() : assignedChecklistUUID);
        assignedItemPlaceholderEntity.setChecklistElementId(assignedItemPlaceholder.getChecklistElementId());
        assignedItemPlaceholderEntity.setCreated(assignedItemPlaceholder.getCreatedAt());
        assignedItemPlaceholderEntity.setIsDeleted(assignedItemPlaceholder.getIsDeleted() ? 1 : 0);
        assignedItemPlaceholderEntity.setItemPlaceholderId(assignedItemPlaceholder.getItemPlaceholderId());
        assignedItemPlaceholderEntity.setUserId(assignedItemPlaceholder.getUserId());
        assignedItemPlaceholderEntity.setValue(assignedItemPlaceholder.getValue() + "");
        assignedItemPlaceholderEntity.setModified(assignedItemPlaceholder.getUpdatedAt());
        assignedItemPlaceholderEntity.setCreated(assignedItemPlaceholder.getCreatedAt());
        assignedItemPlaceholderEntity.setUuid(assignedItemPlaceholder.getUuid());
        assignedItemPlaceholderEntity.setForeignKey(assignedItemPlaceholder.getForeignKey());
        assignedItemPlaceholderEntity.setModel(assignedItemPlaceholder.getModel());
        return assignedItemPlaceholderEntity;
    }

    public static AssignedNCWEntity mapAssignedNotesEntity(ReteriveAssignedChecklistDetail.AssignedNote assignedNote, String assigndChecklistUuid) {
        AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
        assignedNCWEntity.setSync_status(Constants.SYNC_STATUS);
        assignedNCWEntity.setCreated(assignedNote.getCreatedAt() + "");
        assignedNCWEntity.setModified(assignedNote.getUpdatedAt() + "");
        assignedNCWEntity.setUuid(assignedNote.getUuid());
        assignedNCWEntity.setItemTypeId(ChecklistElementType.NOTE.getValue());
        assignedNCWEntity.setAssigned_checklist_uuid(assigndChecklistUuid);
        assignedNCWEntity.setItemId(assignedNote.getNoteId());
        if (assignedNote.getStatus().equals(Parameters.ACKNOWLEDGE))
            assignedNCWEntity.setAcknowledged(1);
        else if (assignedNote.getStatus().equals(Parameters.SKIPPED))
            assignedNCWEntity.setAcknowledged(2);
        else if (assignedNote.getStatus().equals(Parameters.DEFERRED))
            assignedNCWEntity.setAcknowledged(3);
        else
            assignedNCWEntity.setAcknowledged(0);

        assignedNCWEntity.setIs_deleted(assignedNote.getIsDeleted() ? 1 : 0);
        assignedNCWEntity.setUserId(assignedNote.getUserId());
        assignedNCWEntity.setChecklistElementId(assignedNote.getChecklistElementId());

        return assignedNCWEntity;
    }

    public static AssignedStepAttributesEntity mapAssignedStepAttributeEntity(ReteriveAssignedChecklistDetail.AssignedStepAttribute assignedStepAttribute, String assigndChecklistUuid) {
        AssignedStepAttributesEntity assignedStepAttributesEntity = new AssignedStepAttributesEntity();
        assignedStepAttributesEntity.setItemUuid(assignedStepAttribute.getItemUuid());
        assignedStepAttributesEntity.setStepAttributeId(assignedStepAttribute.getStepAttributeId());
        assignedStepAttributesEntity.setIsDeleted(assignedStepAttribute.getIsDeleted() ? 1 : 0);
        assignedStepAttributesEntity.setValue(assignedStepAttribute.getValue());
        assignedStepAttributesEntity.setCreated(assignedStepAttribute.getCreatedAt());
        assignedStepAttributesEntity.setUserId(assignedStepAttribute.getUserId());
        assignedStepAttributesEntity.setUuid(assignedStepAttribute.getUuid());
        assignedStepAttributesEntity.setChecklistElementId(assignedStepAttribute.getChecklistElementId());
        assignedStepAttributesEntity.setStepId(assignedStepAttribute.getStepId());
        assignedStepAttributesEntity.setAssignedChecklistUuid(assigndChecklistUuid);
        assignedStepAttributesEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignedStepAttributesEntity.setModified(assignedStepAttribute.getUpdatedAt());
        return assignedStepAttributesEntity;
    }

    public static AssignedStepFileResourceEntity mapAssignedStepResourcesEntity(ReteriveAssignedChecklistDetail.AssignedStepResource assignedStepResource, String assigndChecklistUuid) {
        AssignedStepFileResourceEntity assignedStepFleResourceEntity = new AssignedStepFileResourceEntity();
        assignedStepFleResourceEntity.setDisplay_file_name(assignedStepResource.getDisplayFilename());
        assignedStepFleResourceEntity.setIs_downloaded(Constants.NOT_DOWNLOADED);
        assignedStepFleResourceEntity.setIs_uploaded(Constants.UPLOADED);
        assignedStepFleResourceEntity.setFile_md5_checksum(assignedStepResource.getMd5Checksum());
        assignedStepFleResourceEntity.setContent_type(assignedStepResource.getContentType());
        assignedStepFleResourceEntity.setFile_name(assignedStepResource.getFilename());
        assignedStepFleResourceEntity.setItem_type_id(assignedStepResource.getItemTypeId());
        assignedStepFleResourceEntity.setChecklist_element_id(assignedStepResource.getChecklistElementId());
        assignedStepFleResourceEntity.setSync_status(Constants.SYNC_STATUS);
        assignedStepFleResourceEntity.setCreated(assignedStepResource.getCreatedAt());
        assignedStepFleResourceEntity.setUuid(assignedStepResource.getUuid());
        assignedStepFleResourceEntity.setModified(assignedStepResource.getUpdatedAt());
        assignedStepFleResourceEntity.setAssigned_checklist_uuid(assigndChecklistUuid);
        assignedStepFleResourceEntity.setItem_id(assignedStepResource.getItemId());
        assignedStepFleResourceEntity.setIs_deleted(assignedStepResource.getIsDeleted() ? 1 : 0);
        assignedStepFleResourceEntity.setUser_id(assignedStepResource.getUserId());
        return assignedStepFleResourceEntity;
    }

    public static AssignedStepEntity mapAssignedStepEntity(ReteriveAssignedChecklistDetail.AssignedStep assignedStep, String assigndChecklistUuid) {
        AssignedStepEntity assignedStepEntity = new AssignedStepEntity();
        assignedStepEntity.setModified(assignedStep.getUpdatedAt());
        assignedStepEntity.setCreated(assignedStep.getCreatedAt());
        assignedStepEntity.setSyncStatus(Constants.SYNC_STATUS);
        assignedStepEntity.setIsDeleted(assignedStep.getIsDeleted() ? 1 : 0);
        assignedStepEntity.setUserId(assignedStep.getUserId());
        assignedStepEntity.setUuid(assignedStep.getUuid());
        if (assignedStep.getStatus().equals(Parameters.COMPLETED))
            assignedStepEntity.setStatus(1);
        else if (assignedStep.getStatus().equals(Parameters.SKIPPED))
            assignedStepEntity.setStatus(2);
        else if (assignedStep.getStatus().equals(Parameters.DEFERRED))
            assignedStepEntity.setStatus(3);
        else
            assignedStepEntity.setStatus(0);

        assignedStepEntity.setStepId(assignedStep.getStepId());
        assignedStepEntity.setChecklistElementId(assignedStep.getChecklistElementId());
        assignedStepEntity.setAssignedChecklistUuid(assigndChecklistUuid);
        return assignedStepEntity;
    }

    public static AssignedNCWEntity mapAssignedWarningEntity(ReteriveAssignedChecklistDetail.AssignedWarning assignedWarning, String assigndChecklistUuid) {
        AssignedNCWEntity assignedNCWEntity = new AssignedNCWEntity();
        assignedNCWEntity.setSync_status(Constants.SYNC_STATUS);
        assignedNCWEntity.setCreated(assignedWarning.getCreatedAt() + "");
        assignedNCWEntity.setModified(assignedWarning.getUpdatedAt() + "");
        assignedNCWEntity.setUuid(assignedWarning.getUuid());
        assignedNCWEntity.setItemTypeId(ChecklistElementType.WARNING.getValue());
        assignedNCWEntity.setAssigned_checklist_uuid(assigndChecklistUuid);
        assignedNCWEntity.setItemId(assignedWarning.getWarningId());
        if (assignedWarning.getStatus().equals(Parameters.ACKNOWLEDGE))
            assignedNCWEntity.setAcknowledged(1);
        else if (assignedWarning.getStatus().equals(Parameters.SKIPPED))
            assignedNCWEntity.setAcknowledged(2);
        else if (assignedWarning.getStatus().equals(Parameters.DEFERRED))
            assignedNCWEntity.setAcknowledged(3);
        else
            assignedNCWEntity.setAcknowledged(0);
        assignedNCWEntity.setIs_deleted(assignedWarning.getIsDeleted() ? 1 : 0);
        assignedNCWEntity.setUserId(assignedWarning.getUserId());
        assignedNCWEntity.setChecklistElementId(assignedWarning.getChecklistElementId());
        return assignedNCWEntity;
    }

    public static AssignedUserEntity mapAssignedUsersEntity(RetrieveAssignedChecklist.AssignedUser assignedUser, String assignedChecklistUuid) {
        AssignedUserEntity assignedUserEntity = new AssignedUserEntity();
        assignedUserEntity.setAssignedBy(assignedUser.getAssignedBy() != null ? assignedUser.getAssignedBy() : assignedUser.getUserId());
        assignedUserEntity.setCreated(assignedUser.getCreatedAt());
        assignedUserEntity.setUserId(assignedUser.getUserId());
        assignedUserEntity.setIsDeleted(assignedUser.getIsDeleted() ? 1 : 0);
        assignedUserEntity.setAssignedCheklistUUID(assignedChecklistUuid);
        assignedUserEntity.setUuid(assignedUser.getUuid());
        assignedUserEntity.setModified(assignedUser.getUpdatedAt());
        assignedUserEntity.setUserId(assignedUser.getUserId());
        assignedUserEntity.setSyncStatus(Constants.SYNC_STATUS);
        return assignedUserEntity;
    }

    public static LogsEntity mapLogs(ReteriveAssignedChecklistDetail.Log log, String assignedChecklistUuid) {
        LogsEntity logsEntity = new LogsEntity();
        logsEntity.setAction(log.getAction());
        logsEntity.setAssignedChecklistUuid(assignedChecklistUuid);
        logsEntity.setAssignedTo(log.getAssignedTo());
        logsEntity.setAssignedToName(log.getAssignedToName());
        logsEntity.setChecklistId(log.getChecklistId());
        logsEntity.setCreated(log.getCreatedAt());
        logsEntity.setChecklistElementId(log.getChecklistElementId());
        logsEntity.setUuid(log.getUuid());
        logsEntity.setUserId(log.getUserId());
        logsEntity.setSyncStatus(Constants.SYNC_STATUS);
        logsEntity.setStepAction(log.getStepAction());
        logsEntity.setUsername(log.getUsername());
        logsEntity.setItemDescription(log.getItemDescription() != null ? log.getItemDescription() : "");
        logsEntity.setModified(log.getUpdatedAt());
        logsEntity.setItemUuid(log.getItemUuid());
        return logsEntity;
    }


    public static ResourceEntity mapReferances(RetrieveAllChecklistElement.Item.Reference reference, Integer itemId, Integer itemTypeId, String modified) {
        ResourceEntity resourceEntity = new ResourceEntity();
        resourceEntity.setContentType(reference.getContentType());
        resourceEntity.setDisplayFileName(reference.getDisplayFilename());
        resourceEntity.setFileMd5Checksum(reference.getMd5Checksum() != null ? reference.getMd5Checksum() : "");
        resourceEntity.setFileName(reference.getFilename() != null ? reference.getFilename() : "");
        resourceEntity.setFileSize(reference.getFilesize());
        resourceEntity.setId(reference.getId());
        resourceEntity.setIsDeleted(reference.getDeleted() != null && reference.getDeleted() ? 1 : 0);
        resourceEntity.setUuid(reference.getUuid());
        resourceEntity.setItemTypeId(itemTypeId);
        resourceEntity.setItemId(itemId);
        resourceEntity.setIsResource(reference.getResource() != null && reference.getResource() ? 1 : 0);
        int isDownloaded = Constants.NOT_DOWNLOADED;
        File directory = FileUtils.getResourcesAttachmentsDir();
        if (directory != null) {
            final File fileDestinationFolder = new File(directory, resourceEntity.getPath());
            if (fileDestinationFolder.exists() && MD5.checkMD5(resourceEntity.getFileMd5Checksum(), fileDestinationFolder)) {
                isDownloaded = Constants.DOWNLOADED;
            }
        }
        resourceEntity.setIsDownloaded(isDownloaded);
        resourceEntity.setModified(modified);
        return resourceEntity;
    }

    public static ResourceEntity mapResource(Integer itemId, Integer itemTypeId, String md5, String uuid, String filename, String modified) {
        ResourceEntity resourceEntity = new ResourceEntity();
        resourceEntity.setContentType("image/jpeg");
        resourceEntity.setDisplayFileName(filename);
        resourceEntity.setFileMd5Checksum(md5);
        resourceEntity.setFileName(md5 + "." + filename.split("\\.")[1]);
        resourceEntity.setFileSize(0);
        resourceEntity.setIsDeleted(0);
        resourceEntity.setUuid(uuid);
        resourceEntity.setItemTypeId(itemTypeId);
        resourceEntity.setItemId(0);
        resourceEntity.setId(itemId);
        resourceEntity.setIsResource(1);
        int isDownloaded = Constants.NOT_DOWNLOADED;
        File directory = FileUtils.getResourcesAttachmentsDir();
        if (directory != null) {
            final File fileDestinationFolder = new File(directory, resourceEntity.getPath());
            if (fileDestinationFolder.exists() && MD5.checkMD5(resourceEntity.getFileMd5Checksum(), fileDestinationFolder)) {
                isDownloaded = Constants.DOWNLOADED;
            }
        }
        resourceEntity.setIsDownloaded(isDownloaded);
        resourceEntity.setModified(modified);
        return resourceEntity;
    }

    public static ResourcesLinksEntity mapReferanceLinks(RetrieveAllChecklistElement.Item.ReferenceLink reference, Integer itemTypeId, Integer itemId, String modified) {
        ResourcesLinksEntity resourceEntity = new ResourcesLinksEntity();
        resourceEntity.setId(reference.getId());
        resourceEntity.setIsDeleted(reference.getDeleted() != null && reference.getDeleted() ? 1 : 0);
        resourceEntity.setUuid(reference.getUuid());
        resourceEntity.setItemTypeId(itemTypeId);
        resourceEntity.setItemId(itemId);
        resourceEntity.setLink(reference.getLink());
        resourceEntity.setLinkTitle(reference.getLinkTitle());
        resourceEntity.setModified(modified);
        return resourceEntity;
    }

    public static List<CheckListLogoEntity> mapChecklistLogo(List<RetrieveChecklists.ChecklistLogo> checklistLogos, String updatedTime) {
        List<CheckListLogoEntity> checkListLogoEntities = new ArrayList<>();
        for (int i = 0; i < checklistLogos.size(); i++) {
            RetrieveChecklists.ChecklistLogo checklistLogo = checklistLogos.get(i);
            CheckListLogoEntity checkListLogoEntity = new CheckListLogoEntity();
            checkListLogoEntity.setChecklist_id(checklistLogo.getChecklistId());
            checkListLogoEntity.setFile_md5_checksum(checklistLogo.getFileMd5Checksum());
            checkListLogoEntity.setId(checklistLogo.getId());
            checkListLogoEntity.setLogo_type(checklistLogo.getLogoType());
            checkListLogoEntity.setName(checklistLogo.getName());
            checkListLogoEntity.setModified(updatedTime);
            checkListLogoEntity.setIs_downloaded(0);
            checkListLogoEntity.setUuid(checklistLogo.getUuid());

            checkListLogoEntities.add(checkListLogoEntity);
        }

        return checkListLogoEntities;
    }

    public static List<ChecklistRoomEquipmentsEntity> mapRoomEquipment(List<ChecklistLocationObject.ChecklistRoomEquipment> checklistRoomEquipments) {
        List<ChecklistRoomEquipmentsEntity> checklistRoomEquipmentsEntities = new ArrayList<>();
        for (int i = 0; i < checklistRoomEquipments.size(); i++) {
            ChecklistRoomEquipmentsEntity checklistRoomEquipmentsEntity = new ChecklistRoomEquipmentsEntity();
            ChecklistLocationObject.ChecklistRoomEquipment checklistRoomEquipment = checklistRoomEquipments.get(i);
            checklistRoomEquipmentsEntity.setChecklistLocationId(checklistRoomEquipment.getChecklistLocationId());
            checklistRoomEquipmentsEntity.setEquipmentId(checklistRoomEquipment.getEquipmentId());
            checklistRoomEquipmentsEntity.setId(checklistRoomEquipment.getId());
            checklistRoomEquipmentsEntity.setRoomId(checklistRoomEquipment.getRoomId());
            checklistRoomEquipmentsEntity.setIsDeleted(checklistRoomEquipment.getIsDeleted() ? 1 : 0);
            checklistRoomEquipmentsEntity.setLocationRoomEquipmentId(checklistRoomEquipment.getLocationRoomEquipmentId());
            checklistRoomEquipmentsEntity.setModified(checklistRoomEquipment.getUpdatedAt());

            checklistRoomEquipmentsEntities.add(checklistRoomEquipmentsEntity);
        }

        return checklistRoomEquipmentsEntities;
    }

    public static CheckListTitlesEntity mapChecklistTitleEntity(RetrieveChecklists.ChecklistTitle checklistTitle, Integer checklistId) {
        CheckListTitlesEntity checkListTitlesEntity = new CheckListTitlesEntity();
        checkListTitlesEntity.setId(checklistTitle.getId());
        checkListTitlesEntity.setTitle(checklistTitle.getName());
        checkListTitlesEntity.setUuid(checklistTitle.getUuid());
        checkListTitlesEntity.setChecklist_id(checklistId);
        return checkListTitlesEntity;
    }

    public static WorkorderObject mapWorkOrderPost(WorkOrderEntity workOrderEntity, List<WorkOrderAttachmentsEntity> attachmentsEntities, List<WorkOrderNotesEntity> workOrderNotesEntities, Context context) {
        WorkorderObject workorder = new WorkorderObject();
        workorder.setAssignedToId(workOrderEntity.getAssignedToId());
        workorder.setAssignedToType(workOrderEntity.getAssignedToType());
        workorder.setAuthorId(workOrderEntity.getAuthorId());
        workorder.setChecklistId(workOrderEntity.getChecklistId());
        workorder.setClosedDate(workOrderEntity.getClosedDate());
        workorder.setCreatedAt(workOrderEntity.getCreated());
        workorder.setDescription(workOrderEntity.getDescription());
        workorder.setDueDate(workOrderEntity.getDueDate());
        workorder.setId(workOrderEntity.getId());
        workorder.setLocationEquipmentId(workOrderEntity.getLocationEquipmentId());
        workorder.setLocationRoomId(workOrderEntity.getLocationRoomId());
        workorder.setLocationId(workOrderEntity.getLocationId());
        workorder.setStartDate(workOrderEntity.getStartDate());
        workorder.setWorkorderStatusId(workOrderEntity.getSyncStatus());
        workorder.setWorkorderPriorityId(workOrderEntity.getWorkorderPriorityId());
        workorder.setWorkorderBillingTypeId(workOrderEntity.getWorkorderBillingTypeId());
        workorder.setUuid(workOrderEntity.getUuid());
        workorder.setTitle(workOrderEntity.getTitle());
        workorder.setUpdatedAt(workOrderEntity.getModified());
        workorder.setWorkorderStatusId(workOrderEntity.getWorkorderStatusId());
        workorder.setWorkorderAttachment(mapWorkOrderAttahhmentPost(attachmentsEntities));
        workorder.setWorkorderNote(mapWorkorderNotesPost(workOrderNotesEntities, context));
        return workorder;
    }

    private static List<WorkorderNote> mapWorkorderNotesPost(List<WorkOrderNotesEntity> workOrderNotesEntities, Context context) {

        AppDatabase appDatabase = AppDatabase.getInstance(context);
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

        List<WorkorderNote> workorderNotes = new ArrayList<>();
        for (int i = 0; i < workOrderNotesEntities.size(); i++) {
            WorkorderNote workorderNote = new WorkorderNote();
            WorkOrderNotesEntity workOrderNotesEntity = workOrderNotesEntities.get(i);
            workorderNote.setCreatedAt(workOrderNotesEntity.getCreated());
            workorderNote.setId(workOrderNotesEntity.getId());
            workorderNote.setUpdatedAt(workOrderNotesEntity.getModified());
            workorderNote.setUserId(workOrderNotesEntity.getUserId());
            workorderNote.setUuid(workOrderNotesEntity.getUuid());
            workorderNote.setWorkorderNotes(workOrderNotesEntity.getWorkorderNotes());
            workorderNote.setWorkorderNoteDetail(mapWorkOrderNoteDetailPost(postSynchronizationDao.getNonSyncedWorkOrdersNotesDetail(workOrderNotesEntity.getId())));

            workorderNotes.add(workorderNote);
        }
        return workorderNotes;
    }

    private static List<WorkorderAttachment> mapWorkOrderAttahhmentPost(List<WorkOrderAttachmentsEntity> attachmentsEntities) {
        List<WorkorderAttachment> workorderAttachments = new ArrayList<>();
        for (int i = 0; i < attachmentsEntities.size(); i++) {
            WorkorderAttachment workorderAttachment = new WorkorderAttachment();
            WorkOrderAttachmentsEntity workOrderAttachmentsEntity = attachmentsEntities.get(i);
            workorderAttachment.setAuthorId(workOrderAttachmentsEntity.getAuthorId());
            workorderAttachment.setContentType(workOrderAttachmentsEntity.getContentType());
            workorderAttachment.setCreatedAt(workOrderAttachmentsEntity.getCreated());
            workorderAttachment.setDiskDirectory(workOrderAttachmentsEntity.getDisplayFileName());
            workorderAttachment.setMd5Checksum(workOrderAttachmentsEntity.getFileMd5Checksum());
            workorderAttachment.setDisplayFilename(workOrderAttachmentsEntity.getDisplayFileName());
            workorderAttachment.setFilename(workOrderAttachmentsEntity.getFilename());
            workorderAttachment.setFileSize(workOrderAttachmentsEntity.getFilesize());
            workorderAttachment.setId(workOrderAttachmentsEntity.getId());
            workorderAttachment.setUuid(workOrderAttachmentsEntity.getUuid());
            workorderAttachment.setUpdatedAt(workOrderAttachmentsEntity.getModified());

            workorderAttachments.add(workorderAttachment);
        }
        return workorderAttachments;
    }

    private static List<WorkorderNoteDetail> mapWorkOrderNoteDetailPost(List<WorkOrderNoteDetailEntity> attachmentsEntities) {
        List<WorkorderNoteDetail> workorderNoteDetails = new ArrayList<>();
        for (int i = 0; i < attachmentsEntities.size(); i++) {
            WorkorderNoteDetail workorderNoteDetail = new WorkorderNoteDetail();
            WorkOrderNoteDetailEntity workOrderNoteDetailEntity = attachmentsEntities.get(i);
            workorderNoteDetail.setOldValue(workOrderNoteDetailEntity.getOldValue());
            workorderNoteDetail.setProperty(workOrderNoteDetailEntity.getProperty());
            workorderNoteDetail.setCreatedAt(workOrderNoteDetailEntity.getCreated());
            workorderNoteDetail.setPropertyKey(workOrderNoteDetailEntity.getPropertyKey());
            workorderNoteDetail.setValue(workOrderNoteDetailEntity.getValue());
            workorderNoteDetail.setId(workOrderNoteDetailEntity.getId());
            workorderNoteDetail.setUuid(workOrderNoteDetailEntity.getUuid());
            workorderNoteDetail.setUpdatedAt(workOrderNoteDetailEntity.getModified());
            workorderNoteDetail.setUpdatedAt(workOrderNoteDetailEntity.getModified());

            workorderNoteDetails.add(workorderNoteDetail);
        }
        return workorderNoteDetails;
    }
}
