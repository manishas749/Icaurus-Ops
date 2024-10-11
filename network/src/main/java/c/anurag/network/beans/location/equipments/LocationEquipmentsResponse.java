package c.anurag.network.beans.location.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationEquipmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<LocationEquipments> data = null;

    public List<LocationEquipments> getData() {
        return data;
    }

    public void setData(List<LocationEquipments> data) {
        this.data = data;
    }
}
