package c.anurag.network.beans.location.room.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationRoomEquipments extends DefaultChecklistResponse {
    @SerializedName("location_id")
    @Expose
    private int locationId;
    @SerializedName("room_id")
    @Expose
    private int roomId;
    @SerializedName("equipment_id")
    @Expose
    private int equipmentId;
    @SerializedName("is_room_deleted")
    @Expose
    private boolean isRoomDeleted;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public int getIsRoomDeleted() {
        return Utility.convertBooleanToInt(isRoomDeleted);
    }

    public void setIsRoomDeleted(boolean isRoomDeleted) {
        this.isRoomDeleted = isRoomDeleted;
    }
}