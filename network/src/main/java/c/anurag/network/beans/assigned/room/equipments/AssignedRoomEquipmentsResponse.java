package c.anurag.network.beans.assigned.room.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedRoomEquipmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedRoomEquipments> data = null;

    public List<AssignedRoomEquipments> getData() {
        return data;
    }

    public void setData(List<AssignedRoomEquipments> data) {
        this.data = data;
    }
}
