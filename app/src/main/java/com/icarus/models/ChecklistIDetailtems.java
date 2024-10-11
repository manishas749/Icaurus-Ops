package com.icarus.models;

import androidx.room.ColumnInfo;

/**
 * Created by Monika Rana on 12/28/2018.
 */

public class ChecklistIDetailtems {
    @ColumnInfo(name = "id")
    private Integer checklistId;

    private String uuid;

    private  Integer status;

    @ColumnInfo(name = "type")
    private  Integer checklistType;

    @ColumnInfo(name = "is_sequential")
    private boolean isSequential;

    private String title;

    @ColumnInfo(name = "department_id")
    public Integer departmentId;

    @ColumnInfo(name = "room_id")
    private Integer roomId;
    public String room;

    @ColumnInfo(name = "equipment_id")
    private Integer equipmentId;
    public String equipment;

    @ColumnInfo(name = "due_days")
    public String dueDays;

    private String checklistStatus;

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChecklistType() {
        return checklistType;
    }

    public void setChecklistType(Integer checklistType) {
        this.checklistType = checklistType;
    }

    public boolean isSequential() {
        return isSequential;
    }

    public void setSequential(boolean sequential) {
        isSequential = sequential;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDueDays() {
        return dueDays;
    }

    public void setDueDays(String dueDays) {
        this.dueDays = dueDays;
    }

    public String getChecklistStatus() {
        return checklistStatus;
    }

    public void setChecklistStatus(String checklistStatus) {
        this.checklistStatus = checklistStatus;
    }

    public String getRoomEquipment() {
        if (getRoom() == null || getEquipment() == null) {
            return "";
        }

        return getRoom().concat(" / ").concat(getEquipment());
    }
}
