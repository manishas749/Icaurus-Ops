package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "location_room_equipments")
public class LocationRoomEquipmentsEntity {

 @NonNull
 @PrimaryKey
 @ColumnInfo(name = "id")
 public Integer id;

 @ColumnInfo(name = "location_id")
 public Integer locationId;

 @ColumnInfo(name = "room_id")
 public Integer roomId;

 @ColumnInfo(name = "equipment_id")
 public Integer equipmentId;

 @NonNull
 @ColumnInfo(name = "is_deleted")
 public Integer isDeleted;

 @NonNull
 @ColumnInfo(name = "modified")
 public String modified;


 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public Integer getLocationId() {
  return locationId;
 }

 public void setLocationId(Integer locationId) {
  this.locationId = locationId;
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
