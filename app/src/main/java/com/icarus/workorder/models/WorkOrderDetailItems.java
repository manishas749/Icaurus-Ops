package com.icarus.workorder.models;

import androidx.room.ColumnInfo;
import android.text.TextUtils;

import com.icarus.util.AppUtility;

/**
 * Created by Anurag Purwar on 30/1/19.
 */
public class WorkOrderDetailItems {
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "due_date")
    private String dueDate;
    @ColumnInfo(name = "workorder_status_id")
    private Integer workorderStatusId;
    @ColumnInfo(name = "assigned_to_id")
    private Integer assignedToId;
    @ColumnInfo(name = "assigned_to_type")
    private Integer assignedToType;
    @ColumnInfo(name = "workorder_priority_id")
    private Integer workorderPriorityId;
    @ColumnInfo(name = "author_id")
    private String authorId;
    @ColumnInfo(name = "location_id")
    private Integer locationId;
    @ColumnInfo(name = "checklist_id")
    private Integer checklistId;
    @ColumnInfo(name = "workorder_billing_type_id")
    private Integer workorderBillingTypeId;
    @ColumnInfo(name = "location_room_id")
    private Integer locationRoomId;
    @ColumnInfo(name = "location_equipment_id")
    private Integer locationEquipmentId;
    @ColumnInfo(name = "start_date")
    private String startDate;
    @ColumnInfo(name = "closed_date")
    private String closedDate;
    @ColumnInfo(name = "created")
    private String created;
    @ColumnInfo(name = "modified")
    private String modified;
    @ColumnInfo(name = "Workorder__assigned_to")
    private String WorkorderAssignedTo;
    @ColumnInfo(name = "Workorder__assigned_to_uuid")
    private String WorkorderAssignedToUuid;
    @ColumnInfo(name = "WorkorderStatusName")
    private String WorkorderStatusName;
    @ColumnInfo(name = "Author__full_name")
    private String AuthorFullName;
    @ColumnInfo(name = "assignedToUserId")
    private Integer assignedToUserId;
    @ColumnInfo(name = "assignedToDepartmentId")
    private Integer assignedToDepartmentId;
    @ColumnInfo(name = "LocationName")
    private String locationName;
    @ColumnInfo(name = "WorkorderBillingTypeName")
    private String WorkorderBillingTypeName;
    @ColumnInfo(name = "LocRoomEquipID")
    private Integer locRoomEquipID;
    @ColumnInfo(name = "Loc_id")
    private Integer locId;
    @ColumnInfo(name = "room_id")
    private Integer roomId;
    @ColumnInfo(name = "equipment_id")
    private Integer equipmentId;
    @ColumnInfo(name = "RoomName")
    private String roomName;
    @ColumnInfo(name = "EquipmentName")
    private String equipmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return TextUtils.isEmpty(dueDate) ? "" : AppUtility.Companion.parseDateToddMMyyyy(dueDate);
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getWorkorderStatusId() {
        return workorderStatusId;
    }

    public void setWorkorderStatusId(Integer workorderStatusId) {
        this.workorderStatusId = workorderStatusId;
    }

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    public Integer getAssignedToType() {
        return assignedToType;
    }

    public void setAssignedToType(Integer assignedToType) {
        this.assignedToType = assignedToType;
    }

    public Integer getWorkorderPriorityId() {
        return workorderPriorityId;
    }

    public void setWorkorderPriorityId(Integer workorderPriorityId) {
        this.workorderPriorityId = workorderPriorityId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Integer getWorkorderBillingTypeId() {
        return workorderBillingTypeId;
    }

    public void setWorkorderBillingTypeId(Integer workorderBillingTypeId) {
        this.workorderBillingTypeId = workorderBillingTypeId;
    }

    public Integer getLocationRoomId() {
        return locationRoomId;
    }

    public void setLocationRoomId(Integer locationRoomId) {
        this.locationRoomId = locationRoomId;
    }

    public Integer getLocationEquipmentId() {
        return locationEquipmentId;
    }

    public void setLocationEquipmentId(Integer locationEquipmentId) {
        this.locationEquipmentId = locationEquipmentId;
    }

    public String getStartDate() {
        return AppUtility.Companion.parseDateToddMMyyyy(startDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getClosedDate() {
        return AppUtility.Companion.parseDateToddMMyyyy(closedDate);
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getCreated() {
        return AppUtility.Companion.parseDateToddMMyyyy(created);
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return AppUtility.Companion.parseDateToddMMyyyy(modified);
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getWorkorderAssignedTo() {
        return WorkorderAssignedTo;
    }

    public void setWorkorderAssignedTo(String workorderAssignedTo) {
        WorkorderAssignedTo = workorderAssignedTo;
    }

    public String getWorkorderAssignedToUuid() {
        return WorkorderAssignedToUuid;
    }

    public void setWorkorderAssignedToUuid(String workorderAssignedToUuid) {
        WorkorderAssignedToUuid = workorderAssignedToUuid;
    }

    public String getWorkorderStatusName() {
        return WorkorderStatusName;
    }

    public void setWorkorderStatusName(String workorderStatusName) {
        WorkorderStatusName = workorderStatusName;
    }

    public String getAuthorFullName() {
        return AuthorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        AuthorFullName = authorFullName;
    }

    public Integer getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(Integer assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public Integer getAssignedToDepartmentId() {
        return assignedToDepartmentId;
    }

    public void setAssignedToDepartmentId(Integer assignedToDepartmentId) {
        this.assignedToDepartmentId = assignedToDepartmentId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getWorkorderBillingTypeName() {
        return TextUtils.isEmpty(WorkorderBillingTypeName) ? "" : WorkorderBillingTypeName;
    }

    public void setWorkorderBillingTypeName(String workorderBillingTypeName) {
        WorkorderBillingTypeName = workorderBillingTypeName;
    }

    public Integer getLocRoomEquipID() {
        return locRoomEquipID;
    }

    public void setLocRoomEquipID(Integer locRoomEquipID) {
        this.locRoomEquipID = locRoomEquipID;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
