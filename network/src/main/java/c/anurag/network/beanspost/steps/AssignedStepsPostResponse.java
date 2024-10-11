package c.anurag.network.beanspost.steps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedStepsPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedSteps> data = null;

    public List<AssignedSteps> getData() {
        return data;
    }

    public void setData(List<AssignedSteps> data) {
        this.data = data;
    }
}
