package com.icarus.models;

import com.icarus.constants.Constants;
import com.icarus.enums.ChecklistStatus;
import com.icarus.util.AppUtility;

import androidx.room.ColumnInfo;
import android.text.TextUtils;

/**
 * Created by Anurag Purwar on 2/6/2019.
 */

public class CancelledCompletedChecklistItems {

    private String uuid;
    private String title;
    private String modified;

    @ColumnInfo(name = "checklist_id")
    private Integer checklistId;

    @ColumnInfo(name = "checklist_type")
    private Integer checklistType;

    @ColumnInfo(name = "last_updated_by")
    private String lastUpdatedBy;

    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite;

    @ColumnInfo(name = "assigned_sync_status")
    private int synced;

    @ColumnInfo(name = "checklist_sync_status")
    private int masterSyncStatus;

    private int pendingReferencesCount;
    private int pendingResourcesCount;
    private Integer pendingAssignedElementsCount;
    private Integer pendingAssignedResourcesCount;

    public Integer getPendingAssignedElementsCount() {
        return pendingAssignedElementsCount == null ? 0 : pendingAssignedElementsCount;
    }

    public void setPendingAssignedElementsCount(Integer pendingAssignedElementsCount) {
        this.pendingAssignedElementsCount = pendingAssignedElementsCount;
    }

    public Integer getPendingAssignedResourcesCount() {
        return pendingAssignedResourcesCount == null ? 0 : pendingAssignedResourcesCount;
    }

    public void setPendingAssignedResourcesCount(Integer pendingAssignedResourcesCount) {
        this.pendingAssignedResourcesCount = pendingAssignedResourcesCount;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getSynced() {
        return synced;
    }

    public void setSynced(int synced) {
        this.synced = synced;
    }

    public int getPendingReferencesCount() {
        return pendingReferencesCount;
    }

    public void setPendingReferencesCount(int pendingReferencesCount) {
        this.pendingReferencesCount = pendingReferencesCount;
    }

    public int getPendingResourcesCount() {
        return pendingResourcesCount;
    }

    public void setPendingResourcesCount(int pendingResourcesCount) {
        this.pendingResourcesCount = pendingResourcesCount;
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
        return TextUtils.isEmpty(modified) ? "" : AppUtility.Companion.parseDateToddMMyyyy(modified);
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Integer getChecklistType() {
        return checklistType;
    }

    public void setChecklistType(Integer checklistType) {
        this.checklistType = checklistType;
    }

    public int getMasterSyncStatus() {
        return masterSyncStatus;
    }

    public void setMasterSyncStatus(int masterSyncStatus) {
        this.masterSyncStatus = masterSyncStatus;
    }

    public ChecklistStatus getChecklistSyncStatus() {
        if (getMasterSyncStatus() == Constants.SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED) {
            return ChecklistStatus.NOT_SYNCHRONIZED;
        }

        if (getSynced() == Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER) {
            return ChecklistStatus.NOT_SYNCHRONIZED;
        }

        if (getPendingResourcesCount() > 0) {
            return ChecklistStatus.RESOURCE_NOT_SYNCHRONIZED;
        }

        if(getPendingAssignedElementsCount() > 0 || getPendingAssignedResourcesCount() > 0) {
            return ChecklistStatus.EXECUTED_CHECKLIST;
        }

        return ChecklistStatus.SYNCHRONIZED;
    }
}
