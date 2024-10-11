package c.anurag.network.beans.location.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationEquipments extends DefaultChecklistResponse {
    @SerializedName("location_id")
    @Expose
    private int locationId;
    @SerializedName("equipment_id")
    @Expose
    private int equipmentId;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }
}