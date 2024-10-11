package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.icarus.constants.Constants;
import com.icarus.util.AppUtility;

@Entity(tableName = "logs", foreignKeys = {
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id")})
public class LogsEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    public String uuid;
    @ColumnInfo(name = "item_uuid")
    public String itemUuid;
    @ColumnInfo(name = "checklist_id")
    public Integer checklistId;
    @ColumnInfo(name = "checklist_element_id")
    public Integer checklistElementId;
    @NonNull
    @ColumnInfo(name = "action")
    public String action;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Integer userId;
    @ColumnInfo(name = "assigned_to")
    public Integer assignedTo;
    @NonNull
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "assigned_to_name")
    public String assignedToName;
    @ColumnInfo(name = "assigned_checklist_uuid")
    public String assignedChecklistUuid;
    @NonNull
    @ColumnInfo(name = "item_description")
    public String itemDescription;
    @ColumnInfo(name = "step_action")
    public String stepAction;
    @NonNull
    @ColumnInfo(name = "created")
    public String created;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;

    public LogsEntity(String itemUuid, Integer checklistId, Integer checklistElementId, Integer logAction,
                      @NonNull Integer performedByUserId, @NonNull String performedByUser,
                      Integer assignedToUserId, String assignedToUserName,
                      String assignedChecklistUuid, @NonNull String actionPerformed,
                      String actionDescription, @NonNull String performedAt) {
        this.uuid = AppUtility.Companion.getUuid();
        this.itemUuid = itemUuid;
        this.checklistId = checklistId;
        this.checklistElementId = checklistElementId;
        setAction(logAction);
        this.userId = performedByUserId;
        this.username = performedByUser;
        this.assignedTo = assignedToUserId;
        this.assignedToName = assignedToUserName;
        this.assignedChecklistUuid = assignedChecklistUuid;
        this.itemDescription = actionPerformed;
        this.stepAction = actionDescription;
        this.created = performedAt;
        this.modified = performedAt;
        this.syncStatus = Constants.SYNC_STATUS_NOT;
    }

    public LogsEntity() {

    }

    @NonNull
    public Integer getAction() {
        return Integer.parseInt(action);
    }

    public void setAction(@NonNull Integer action) {
        this.action = String.valueOf(action);
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    @NonNull
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(@NonNull String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    public String getStepAction() {
        return stepAction;
    }

    public void setStepAction(String stepAction) {
        this.stepAction = stepAction;
    }

    @NonNull
    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(@NonNull Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }
}
