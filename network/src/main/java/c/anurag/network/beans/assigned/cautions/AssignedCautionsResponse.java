package c.anurag.network.beans.assigned.cautions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedCautionsResponse extends DefaultResponse {
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
