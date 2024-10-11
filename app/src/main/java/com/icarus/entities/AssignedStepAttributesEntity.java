package com.icarus.entities;

import org.jetbrains.annotations.NotNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.icarus.constants.Constants;
import com.icarus.util.AppUtility;

@Entity(tableName = "assigned_step_attributes", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid")})
public class AssignedStepAttributesEntity {

    @NonNull
    @ColumnInfo(name = "assigned_checklist_uuid")
    public String assignedChecklistUuid;
    @NonNull
    @ColumnInfo(name = "checklist_element_id")
    public Integer checklistElementId;
    @NonNull
    @ColumnInfo(name = "created")
    public String created;

    @NonNull
    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(@NonNull String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    @NonNull
    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(@NonNull Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(@NonNull String itemUuid) {
        this.itemUuid = itemUuid;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getStepAttributeId() {
        return stepAttributeId;
    }

    public void setStepAttributeId(@NonNull Integer stepAttributeId) {
        this.stepAttributeId = stepAttributeId;
    }

    @NonNull
    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(@NonNull Integer stepId) {
        this.stepId = stepId;
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
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public String getValue() {
        return value;
    }

    public void setValue(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @NonNull
    @ColumnInfo(name = "item_uuid")
    public String itemUuid;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @ColumnInfo(name = "step_attribute_id")
    @NotNull
    public Integer stepAttributeId;
    @NonNull
    @ColumnInfo(name = "step_id")
    public Integer stepId;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;
    @NonNull
    @ColumnInfo(name = "user_id")
    public Integer userId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    public String uuid;
    @NonNull
    @ColumnInfo(name = "value")
    public String value;

    public AssignedStepAttributesEntity() {
    }

    public AssignedStepAttributesEntity(
            @NonNull String assignedChecklistUuid,
            @NonNull Integer checklistElementId,
            @NonNull String created,
            @NonNull String itemUuid,
            @NotNull Integer stepAttributeId,
            @NonNull Integer stepId,
            @NonNull Integer userId,
            @NonNull String value) {
        this.uuid = AppUtility.Companion.getUuid();
        this.assignedChecklistUuid = assignedChecklistUuid;
        this.checklistElementId = checklistElementId;
        this.created = created;
        this.modified = created;
        this.itemUuid = itemUuid;
        this.stepAttributeId = stepAttributeId;
        this.stepId = stepId;
        this.userId = userId;
        this.value = value;
        this.syncStatus = Constants.SYNC_STATUS_NOT;
        this.isDeleted = Constants.NOT_DELETED;
    }

}
