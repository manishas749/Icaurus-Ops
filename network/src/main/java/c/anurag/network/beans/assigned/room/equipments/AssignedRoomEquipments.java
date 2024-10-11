package c.anurag.network.beans.assigned.room.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedRoomEquipments extends DefaultChecklistResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("room_id")
    @Expose
    private Integer roomId;
    @SerializedName("equipment_id")
    @Expose
    private Integer equipmentId;

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
