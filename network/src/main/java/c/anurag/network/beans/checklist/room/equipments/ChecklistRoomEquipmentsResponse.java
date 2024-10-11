package c.anurag.network.beans.checklist.room.equipments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistRoomEquipmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistRoomEquipments> data = null;

    public List<ChecklistRoomEquipments> getData() {
        return data;
    }

    public void setData(List<ChecklistRoomEquipments> data) {
        this.data = data;
    }
}
