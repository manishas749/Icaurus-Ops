package com.icarus.entities;

import org.jetbrains.annotations.NotNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
@Entity(tableName = "workorders",
        indices={
                @Index(value="id", unique = true)
        })
public class WorkOrderEntity {
    @NonNull
    @ColumnInfo(name = "id")
    public Integer id;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    public String uuid;
    @NonNull
    @ColumnInfo(name = "title")
    public String title;
    @NonNull
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "due_date")
    public String dueDate;
    @NonNull
    @ColumnInfo(name = "workorder_status_id")
    public Integer workorderStatusId;
    @NonNull
    @ColumnInfo(name = "assigned_to_id")
    public Integer assignedToId;
    @NonNull
    @ColumnInfo(name = "assigned_to_type")
    public Integer assignedToType;
    @NonNull
    @ColumnInfo(name = "workorder_priority_id")
    public Integer workorderPriorityId;
    @NonNull
    @ColumnInfo(name = "author_id")
    public Integer authorId;
    @NonNull
    @ColumnInfo(name = "location_id")
    public Integer locationId;
    @ColumnInfo(name = "checklist_id")
    public Integer checklistId;
    @ColumnInfo(name = "workorder_billing_type_id")
    public Integer workorderBillingTypeId;
    @ColumnInfo(name = "location_equipment_id")
    public Integer locationEquipmentId;
    @ColumnInfo(name = "location_room_id")
    public Integer locationRoomId;
    @ColumnInfo(name = "start_date")
    public String startDate;
    @ColumnInfo(name = "closed_date")
    public String closedDate;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;
    @NonNull
    @ColumnInfo(name = "created")
    public String created;
    @NonNull
    @ColumnInfo(name = "execution_status")
    public Integer executionStatus;

    @NonNull
    public Integer getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(@NonNull Integer executionStatus) {
        this.executionStatus = executionStatus;
    }

    @NotNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NotNull String created) {
        this.created = created;
    }

    @NonNull
    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(@NonNull Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAssignedToType() {
        return assignedToType;
    }

    public void setAssignedToType(Integer assignedToType) {
        this.assignedToType = assignedToType;
    }

    public String getDueDate() {
        return dueDate;
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

    public Integer getWorkorderPriorityId() {
        return workorderPriorityId;
    }

    public void setWorkorderPriorityId(Integer workorderPriorityId) {
        this.workorderPriorityId = workorderPriorityId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
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

    public Integer getLocationEquipmentId() {
        return locationEquipmentId;
    }

    public void setLocationEquipmentId(Integer locationEquipmentId) {
        this.locationEquipmentId = locationEquipmentId;
    }

    public Integer getLocationRoomId() {
        return locationRoomId;
    }

    public void setLocationRoomId(Integer locationRoomId) {
        this.locationRoomId = locationRoomId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

}
