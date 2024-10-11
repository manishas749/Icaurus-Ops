package c.anurag.network.beanspost.step.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedStepResultsPostResponse {
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
