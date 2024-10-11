package c.anurag.network.beans.location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Locations> data = null;

    public List<Locations> getData() {
        return data;
    }

    public void setData(List<Locations> data) {
        this.data = data;
    }
}
