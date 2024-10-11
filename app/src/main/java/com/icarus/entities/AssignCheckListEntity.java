package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import static androidx.room.ForeignKey.NO_ACTION;

@Entity(tableName = "assigned_checklists", foreignKeys = {
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id", onDelete = NO_ACTION),
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id", onDelete = NO_ACTION),
        @ForeignKey(entity = LocationEntity.class, parentColumns = "id", childColumns = "location_id", onDelete = NO_ACTION)})
public class AssignCheckListEntity {

    @ColumnInfo(name = "assigned_at")
    public String assignedAt;

    @NonNull
    @ColumnInfo(name = "assignee_type")
    public Integer assigneeType;

    @NonNull
    @ColumnInfo(name = "checklist_id")
    public Integer checklistId;
    @NonNull
    @ColumnInfo(name = "checklist_status")
    public Integer checklistStatus;

    @NonNull
    @ColumnInfo(name = "created")
    public String created;

    @NonNull
    @ColumnInfo(name = "department_id")
    public Integer departmentId;

    @ColumnInfo(name = "due_date")
    public String dueDate;
    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @NonNull
    @ColumnInfo(name = "location_id")
    public Integer locationId;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @ColumnInfo(name = "started_at")
    public String startedAt;
    @ColumnInfo(name = "started_by_user_id")
    public Integer startedByUserId;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Integer userId;
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    public String uuid;
    @NonNull
    @ColumnInfo(name = "execution_status")
    public Integer executionStatus;
    @NonNull
    @ColumnInfo(name = "pending_elements_count")
    public Integer pendingElementsCount;
    @NonNull
    @ColumnInfo(name = "pending_resources_count")
    public Integer pendingResourcesCount;

    @NonNull
    public Integer getPendingElementsCount() {
        return pendingElementsCount;
    }

    public void setPendingElementsCount(@NonNull Integer pendingElementsCount) {
        this.pendingElementsCount = pendingElementsCount;
    }

    @NonNull
    public Integer getPendingResourcesCount() {
        return pendingResourcesCount;
    }

    public void setPendingResourcesCount(@NonNull Integer pendingResourcesCount) {
        this.pendingResourcesCount = pendingResourcesCount;
    }

    @NonNull
    public Integer getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(@NonNull Integer executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(String assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Integer getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(Integer assigneeType) {
        this.assigneeType = assigneeType;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Integer getChecklistStatus() {
        return checklistStatus;
    }

    public void setChecklistStatus(Integer checklistStatus) {
        this.checklistStatus = checklistStatus;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public Integer getStartedByUserId() {
        return startedByUserId;
    }

    public void setStartedByUserId(Integer startedByUserId) {
        this.startedByUserId = startedByUserId;
    }

    @NonNull
    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(@NonNull Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }
}
