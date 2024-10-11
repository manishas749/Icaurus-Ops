package c.anurag.network.beanspost.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedRoomEquipmentsPostResponse {
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
