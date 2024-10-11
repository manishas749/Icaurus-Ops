package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "assigned_steps", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = ChecklistElementsEntity.class, parentColumns = "id", childColumns = "checklist_element_id")})
public class AssignedStepEntity {
    @NonNull
    @ColumnInfo( name = "assigned_checklist_uuid")
    public String assignedChecklistUuid;

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
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getStatus() {
        return status;
    }

    public void setStatus(@NonNull Integer status) {
        this.status = status;
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

    @ColumnInfo( name = "checklist_element_id")
    public Integer checklistElementId;
    @NonNull
    @ColumnInfo( name = "created")
    public String created;
    @NonNull
    @ColumnInfo( name = "is_deleted")
    public Integer isDeleted;
    @NonNull
    @ColumnInfo( name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo( name = "status")
    public Integer status;
    @NonNull
    @ColumnInfo( name = "step_id")
    public Integer stepId;
    @NonNull
    @ColumnInfo( name = "sync_status")
    public Integer syncStatus;
    @NonNull
    @ColumnInfo( name = "user_id")
    public Integer userId;
    @NonNull
    @PrimaryKey
    @ColumnInfo( name = "uuid")
    public String uuid;
}
