package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "user_favorites", foreignKeys = {
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id")})
public class UserFavouritesEntity {


    @PrimaryKey
    @NonNull
    String uuid;


    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(@NonNull Integer checklistId) {
        this.checklistId = checklistId;
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

    @NonNull
    @ColumnInfo(name = "user_id")

    Integer userId;
    @NonNull
    @ColumnInfo(name = "checklist_id")
    Integer checklistId;
    @NonNull

    @ColumnInfo(name = "is_deleted")
    Integer isDeleted;

    @NonNull
    String created;

    @NonNull
    String modified;

    @NonNull
    @ColumnInfo(name = "sync_status")
    Integer syncStatus;
}