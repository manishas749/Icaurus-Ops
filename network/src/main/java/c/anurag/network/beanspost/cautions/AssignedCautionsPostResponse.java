package c.anurag.network.beanspost.cautions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedCautionsPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedCautions> data = null;

    public List<AssignedCautions> getData() {
        return data;
    }

    public void setData(List<AssignedCautions> data) {
        this.data = data;
    }
}
