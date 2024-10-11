package com.icarus.entities;

import org.jetbrains.annotations.NotNull;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "assigned_ncw", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = ChecklistElementsEntity.class, parentColumns = "id", childColumns = "checklist_element_id")})
public class AssignedNCWEntity {
    @NotNull
    @PrimaryKey
    String uuid;

    @NotNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NotNull String uuid) {
        this.uuid = uuid;
    }

    @NotNull
    public String getAssigned_checklist_uuid() {
        return assigned_checklist_uuid;
    }

    public void setAssigned_checklist_uuid(@NotNull String assigned_checklist_uuid) {
        this.assigned_checklist_uuid = assigned_checklist_uuid;
    }

    @NotNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull Integer userId) {
        this.userId = userId;
    }

    @NotNull
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(@NotNull Integer itemId) {
        this.itemId = itemId;
    }

    @NotNull
    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(@NotNull Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @NotNull
    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(@NotNull Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    @NotNull
    public Integer getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(@NotNull Integer acknowledged) {
        this.acknowledged = acknowledged;
    }

    @NotNull
    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(@NotNull Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    @NotNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NotNull String created) {
        this.created = created;
    }

    @NotNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NotNull String modified) {
        this.modified = modified;
    }

    @NotNull
    public Integer getSync_status() {
        return sync_status;
    }

    public void setSync_status(@NotNull Integer sync_status) {
        this.sync_status = sync_status;
    }

    @NotNull
    private String assigned_checklist_uuid;
    @NotNull
    @ColumnInfo(name = "user_id")
    private Integer userId;
    @NotNull
    @ColumnInfo(name = "item_id")
    private Integer itemId;
    @NotNull
    @ColumnInfo(name = "item_type_id")
    private Integer itemTypeId;
    @ColumnInfo(name = "checklist_element_id")
    private Integer checklistElementId;
    @NotNull
    private Integer acknowledged;
    @NotNull
    @ColumnInfo(name = "is_deleted")
    private Integer is_deleted;
    @NotNull
    private String created;
    @NotNull
    private String modified;
    @NotNull
    @ColumnInfo(name = "sync_status")
    private Integer sync_status;
}
