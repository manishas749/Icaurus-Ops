package c.anurag.network.beanspost.logo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedLogosPostResponse {
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
