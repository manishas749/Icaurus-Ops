package c.anurag.network.beanspost.decisions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedDecisionsPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedDecisions> data = null;

    public List<AssignedDecisions> getData() {
        return data;
    }

    public void setData(List<AssignedDecisions> data) {
        this.data = data;
    }
}
