package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "user_suggestions", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = ChecklistElementsEntity.class, parentColumns =  "id", childColumns = "checklist_element_id"),
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id")})
public class UserSuggestionEntity {

    @NonNull
    @PrimaryKey
    private String uuid;
    @NonNull
    @ColumnInfo(name = "user_id")
    private Integer user_id;
    @ColumnInfo(name = "assigned_checklist_uuid")
    private String assignedChecklistUuid;
    @ColumnInfo(name = "checklist_id")
    private Integer checklistId;
    @NonNull
    private String description;
    @NonNull
    @ColumnInfo(name = "is_deleted")
    private Integer isDeleted;
    @NonNull
    private String created;
    @NonNull
    private String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    private Integer syncStatus;
    @ColumnInfo(name = "checklist_element_id")
    private Integer checklistElementId;
    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(@NonNull Integer user_id) {
        this.user_id = user_id;
    }

    @NonNull
    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(@NonNull String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    @NonNull
    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(@NonNull Integer checklistId) {
        this.checklistId = checklistId;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(@NonNull Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }
}
