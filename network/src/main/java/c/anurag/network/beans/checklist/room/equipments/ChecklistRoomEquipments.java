package c.anurag.network.beans.checklist.room.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistRoomEquipments extends DefaultChecklistResponse {
    @SerializedName("checklist_location_id")
    @Expose
    private Integer checklistLocationId;
    @SerializedName("location_room_equipment_id")
    @Expose
    private Integer locationRoomEquipmentId;
    @SerializedName("room_id")
    @Expose
    private int roomId;
    @SerializedName("equipment_id")
    @Expose
    private int equipmentId;

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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

}
