package c.anurag.network.beans.checklist.locations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistLocationsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistLocations> data = null;

    public List<ChecklistLocations> getData() {
        return data;
    }

    public void setData(List<ChecklistLocations> data) {
        this.data = data;
    }
}
