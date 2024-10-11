package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "checklist_room_equipments", foreignKeys = {
        @ForeignKey(entity = ChecklistLocationEntity.class, parentColumns = "id", childColumns = "checklist_location_id")})
public class ChecklistRoomEquipmentsEntity {

    @NonNull
    @PrimaryKey
    Integer id;

    @ColumnInfo(name = "checklist_location_id")
    Integer checklistLocationId;

    @ColumnInfo(name = "location_room_equipment_id")
    Integer locationRoomEquipmentId;

    @ColumnInfo(name = "room_id")
    Integer roomId;

    @ColumnInfo(name = "equipment_id")
    Integer equipmentId;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    Integer isDeleted;

    @NonNull
    String modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChecklistLocationId() {
        return checklistLocationId;
    }

    public void setChecklistLocationId(Integer checklistLocationId) {
        this.checklistLocationId = checklistLocationId;
    }

    public Integer getLocationRoomEquipmentId() {
        return locationRoomEquipmentId;
    }

    public void setLocationRoomEquipmentId(Integer locationRoomEquipmentId) {
        this.locationRoomEquipmentId = locationRoomEquipmentId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
}