package com.icarus.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklists", foreignKeys = {
        @ForeignKey(entity = ChecklistStatusEntity.class, parentColumns = "id", childColumns = "checklist_status_id"),
        @ForeignKey(entity = ChecklistTypeEntity.class, parentColumns = "id", childColumns = "checklist_type_id")})
public class AllChecklistEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public Integer id;

    @ColumnInfo(name = "pending_resources_count")
    public Integer pendingResourcesCount;

    @ColumnInfo(name = "pending_references_count")
    public Integer pendingReferencesCount;

    @NonNull
    @ColumnInfo(name = "checklist_placeholder_count")
    public Integer placeholderCount;

    @ColumnInfo(name = "assigned_to_id")
    public Integer assignedToId;

    @NonNull
    @ColumnInfo(name = "author_id")
    public Integer authorId;

    @ColumnInfo(name = "checklist_status_id")
    public Integer checklistStatusId;

    @NonNull
    @ColumnInfo(name = "checklist_type_id")
    public Integer checklistTypeId;

    @NonNull
    @ColumnInfo(name = "department_id")
    public Integer departmentId;

    @ColumnInfo(name = "due_at")
    public String dueAt;

    @ColumnInfo(name = "estimate_hours")
    public String estimateHours;

    @NonNull
    @ColumnInfo(name = "is_approval_required")
    public Integer isApprovalRequired;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;

    @NonNull
    @ColumnInfo(name = "is_sequential")
    public Integer isSequential;

    @ColumnInfo(name = "is_template")
    public Integer isTemplate;

    @ColumnInfo(name = "modified")
    public String modified;

    @ColumnInfo(name = "parent_id")
    public Integer parentId;

    @NonNull
    @ColumnInfo(name = "uuid")
    public String uuid;

    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    @NonNull
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getChecklistStatusId() {
        return checklistStatusId;
    }

    public void setChecklistStatusId(Integer checklistStatusId) {
        this.checklistStatusId = checklistStatusId;
    }

    public Integer getChecklistTypeId() {
        return checklistTypeId;
    }

    public void setChecklistTypeId(Integer checklistTypeId) {
        this.checklistTypeId = checklistTypeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getEstimateHours() {
        return estimateHours;
    }

    public void setEstimateHours(String estimateHours) {
        this.estimateHours = estimateHours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsApprovalRequired() {
        return isApprovalRequired;
    }

    public void setIsApprovalRequired(Integer isApprovalRequired) {
        this.isApprovalRequired = isApprovalRequired;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsSequential() {
        return isSequential;
    }

    public void setIsSequential(Integer isSequential) {
        this.isSequential = isSequential;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getPlaceholderCount() {
        return placeholderCount;
    }

    public void setPlaceholderCount(Integer placeholderCount) {
        this.placeholderCount = placeholderCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getPendingResourcesCount() {
        return pendingResourcesCount;
    }

    public void setPendingResourcesCount(Integer pendingResourcesCount) {
        this.pendingResourcesCount = pendingResourcesCount;
    }

    public Integer getPendingReferencesCount() {
        return pendingReferencesCount;
    }

    public void setPendingReferencesCount(Integer pendingReferencesCount) {
        this.pendingReferencesCount = pendingReferencesCount;
    }
}