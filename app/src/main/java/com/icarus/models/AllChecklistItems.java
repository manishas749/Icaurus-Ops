package com.icarus.models;


import com.icarus.constants.Constants;
import com.icarus.enums.ChecklistStatus;
import com.icarus.util.DateUtility;
import com.icarus.util.StringUtil;

import androidx.room.ColumnInfo;

public class AllChecklistItems {

    @ColumnInfo(name = "id")
    private Integer checklistId;
    @ColumnInfo(name = "checklist_type_id")
    private Integer checklistTypeId;
    @ColumnInfo(name = "department_id")
    private Integer departmentId;
    @ColumnInfo(name = "is_sequential")
    private Integer isSequential;
    @ColumnInfo(name = "is_approval_required")
    private Integer isApprovalRequired;
    @ColumnInfo(name = "checkliststatus_name")
    private String checklistStatusName;
    @ColumnInfo(name = "checkliststatus_is_expired")
    private Integer checklistStatusIsExpired;
    @ColumnInfo(name = "is_assignable")
    private Integer isAssignable;
    @ColumnInfo(name = "is_executable")
    private Integer isExecutable;
    @ColumnInfo(name = "due_at")
    private String dueAt;
    @ColumnInfo(name = "is_favorite")
    private Integer isFavorite;
    @ColumnInfo(name = "checklist_placeholder_count")
    private Integer placeholderCount;
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "modified")
    private String modified;
    @ColumnInfo(name = "departmentName")
    private String departmentName;
    @ColumnInfo(name = "pending_resources_count")
    private Integer pendingResourcesCount;
    @ColumnInfo(name = "pending_references_count")
    private Integer pendingReferencesCount;

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

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    @ColumnInfo(name = "sync_status")
    private Integer syncStatus;

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
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

    public Integer isSequential() {
        return isSequential;
    }

    public void setIsSequential(Integer isSequential) {
        this.isSequential = isSequential;
    }

    public Integer isApprovalRequired() {
        return isApprovalRequired;
    }

    public void setIsApproStringRequired(Integer isApprovalRequired) {
        this.isApprovalRequired = isApprovalRequired;
    }

    public String getChecklistStatusName() {
        return checklistStatusName;
    }

    public void setChecklistStatusName(String checklistStatusName) {
        this.checklistStatusName = checklistStatusName;
    }

    public Integer getChecklistStatusIsExpired() {
        return checklistStatusIsExpired;
    }

    public void setChecklistStatusIsExpired(Integer checklistStatusIsExpired) {
        this.checklistStatusIsExpired = checklistStatusIsExpired;
    }

    public Integer isAssignable() {
        return isAssignable;
    }

    public void setIsAssignable(Integer isAssignable) {
        this.isAssignable = isAssignable;
    }

    public Integer isExecutable() {
        return isExecutable;
    }

    public void setIsExecutable(Integer isExecutable) {
        this.isExecutable = isExecutable;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public Integer isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getPlaceholderCount() {
        return placeholderCount;
    }

    public void setPlaceholderCount(Integer placeholderCount) {
        this.placeholderCount = placeholderCount;
    }

    public Integer isPlaceholderExists() {
        return getPlaceholderCount() != null && getPlaceholderCount() > 0 ? 1 : 0;
    }

    public void setIsApprovalRequired(Integer isApprovalRequired) {
        this.isApprovalRequired = isApprovalRequired;
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

    public String getModified() {
        return DateUtility.showFormattedDate(modified);
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getDepartmentName() {
        return departmentName != null ? StringUtil.INSTANCE.toCamelCase(departmentName) : "";
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ChecklistStatus getChecklistSyncStatus() {
        if (getSyncStatus().equals(Constants.SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED)) {
            return ChecklistStatus.NOT_SYNCHRONIZED;
        }

        if (isFavorite() == 1 && (getPendingResourcesCount() > 0 || getPendingReferencesCount() > 0)) {
            return ChecklistStatus.RESOURCE_NOT_SYNCHRONIZED;
        }

        if (isFavorite() == 0 && getPendingResourcesCount() > 0) {
            return ChecklistStatus.RESOURCE_NOT_SYNCHRONIZED;
        }

        return ChecklistStatus.SYNCHRONIZED;
    }

}
