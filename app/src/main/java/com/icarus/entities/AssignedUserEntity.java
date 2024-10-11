package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "assigned_users", foreignKeys = {
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "assigned_by")})
public class AssignedUserEntity {
    @NonNull
    @ColumnInfo(name = "assigned_checklist_uuid")
    public String assignedCheklistUUID;
    @ColumnInfo(name = "assigned_by")
    @NonNull
    public Integer assignedBy;

    @NonNull
    public Integer getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(@NonNull Integer assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getAssignedCheklistUUID() {
        return assignedCheklistUUID;
    }

    public void setAssignedCheklistUUID(String assignedCheklistUUID) {
        this.assignedCheklistUUID = assignedCheklistUUID;
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

    @NonNull
    @ColumnInfo(name = "created")
    public String created;
    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
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
}
