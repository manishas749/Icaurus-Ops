package c.anurag.network.beans.assigned.logo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedLogosResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedLogos> data = null;

    public List<AssignedLogos> getData() {
        return data;
    }

    public void setData(List<AssignedLogos> data) {
        this.data = data;
    }
}
