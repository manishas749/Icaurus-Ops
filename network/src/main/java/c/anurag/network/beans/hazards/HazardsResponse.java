package c.anurag.network.beans.hazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class HazardsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Hazards> data = null;

    public List<Hazards> getData() {
        return data;
    }

    public void setData(List<Hazards> data) {
        this.data = data;
    }
}
