package com.icarus.models;

import com.icarus.constants.Constants;
import com.icarus.enums.ChecklistStatus;
import com.icarus.enums.ChecklistType;
import com.icarus.enums.DueStatus;
import com.icarus.util.DateUtility;

import androidx.room.ColumnInfo;

import java.util.Date;

public class DepartmentChecklistItems {
    @ColumnInfo(name = "id")
    public Integer checklistId;

    public String uuid;

    public Integer status;

    @ColumnInfo(name = "type")
    public Integer checklistType;

    @ColumnInfo(name = "is_sequential")
    public Integer isSequential;

    public String title;

    @ColumnInfo(name = "department_id")
    public Integer departmentId;
    public String room;
    public String equipment;

    public String author;
    public String assignee;

    @ColumnInfo(name = "due_at")
    public String dueAt;

    @ColumnInfo(name = "due_days")
    public String dueDays;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    @ColumnInfo(name = "started_by_user_id")
    public Integer startedByUserId;

    @ColumnInfo(name = "assigned_at")
    public String assignedAt;

    public String checklistStatus;

    @ColumnInfo(name = "pending_resources_count")
    private Integer pendingResourcesCount;
    @ColumnInfo(name = "pending_references_count")
    private Integer pendingReferencesCount;
    @ColumnInfo(name = "is_favorite")
    private Integer isFavorite;
    @ColumnInfo(name = "sync_status")
    private int masterSyncStatus;
    @ColumnInfo(name = "execution_status")
    private int syncStatus;

    public Integer isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
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

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getChecklistStatus() {
        return checklistStatus;
    }

    public void setChecklistStatus(String checklistStatus) {
        this.checklistStatus = checklistStatus;
    }

    public Integer getChecklistType() {
        return checklistType;
    }

    public void setChecklistType(Integer checklistType) {
        this.checklistType = checklistType;
    }

    public Integer getIsSequential() {
        return isSequential;
    }

    public void setIsSequential(Integer isSequential) {
        this.isSequential = isSequential;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getRoomEquipment() {
        if (getRoom() == null && getEquipment() == null) {
            return "";
        }

        return getRoom().concat(" / ").concat(getEquipment());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDepartmentName() {
        if (getAssignee() == null) {
            return "All";
        }

        return getAssignee();
    }

    public String getDueDays() {
        return dueDays;
    }

    public void setDueDays(String dueDays) {
        this.dueDays = dueDays;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStartedByUserId() {
        return startedByUserId;
    }

    public void setStartedByUserId(Integer startedByUserId) {
        this.startedByUserId = startedByUserId;
    }

    public String getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(String assignedAt) {
        this.assignedAt = assignedAt;
    }

    public boolean isEmergency() {
        return getChecklistType() == ChecklistType.Emergency.getValue();
    }

    public int getDueStatus() {
        if (isEmergency()) {
            return DueStatus.NORMAL.getValue();
        }

        Date dueAt = DateUtility.getDateFromString(getDueAt());
        Date now = new Date();

        if (now.after(dueAt)) {
            return DueStatus.OVERDUE.getValue();
        }

        Date assignedAt = DateUtility.getDateFromString(getAssignedAt());
        double remainingTime = dueAt.getTime() - now.getTime();
        double totalTime = dueAt.getTime() - assignedAt.getTime();
        double ratio = remainingTime / totalTime;

        if (ratio <= 0.4) {
            return DueStatus.DUE.getValue();
        }

        return DueStatus.NORMAL.getValue();
    }

    public int getMasterSyncStatus() {
        return masterSyncStatus;
    }

    public void setMasterSyncStatus(int masterSyncStatus) {
        this.masterSyncStatus = masterSyncStatus;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public ChecklistStatus getChecklistSyncStatus() {
        if (getMasterSyncStatus() == Constants.SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED) {
            return ChecklistStatus.NOT_SYNCHRONIZED;
        }

        if (getSyncStatus() == Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER) {
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
