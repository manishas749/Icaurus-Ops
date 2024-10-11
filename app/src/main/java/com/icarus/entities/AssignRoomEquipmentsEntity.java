package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "assigned_room_equipments", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid")})
public class AssignRoomEquipmentsEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    public String uuid;

    @NonNull
    @ColumnInfo(name = "assigned_checklist_uuid")
    public String assignedChecklistUuid;

    @NonNull
    @ColumnInfo(name = "created")
    public String created;

    @ColumnInfo(name = "equipment_id")
    public Integer equipmentId;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;

    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;

    @ColumnInfo(name = "room_id")
    public Integer roomId;

    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
