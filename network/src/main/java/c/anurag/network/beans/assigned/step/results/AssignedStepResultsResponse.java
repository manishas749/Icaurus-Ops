package c.anurag.network.beans.assigned.step.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedStepResultsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedStepResults> data = null;

    public List<AssignedStepResults> getData() {
        return data;
    }

    public void setData(List<AssignedStepResults> data) {
        this.data = data;
    }
}
