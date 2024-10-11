package c.anurag.network.beans.location.room.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationRoomEquipmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<LocationRoomEquipments> data = null;

    public List<LocationRoomEquipments> getData() {
        return data;
    }

    public void setData(List<LocationRoomEquipments> data) {
        this.data = data;
    }
}
