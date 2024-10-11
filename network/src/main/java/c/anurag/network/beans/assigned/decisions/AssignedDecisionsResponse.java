package c.anurag.network.beans.assigned.decisions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedDecisionsResponse extends DefaultResponse {
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
