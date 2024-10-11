package c.anurag.network.beanspost.step.resources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedStepResourcesPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedStepResources> data = null;

    public List<AssignedStepResources> getData() {
        return data;
    }

    public void setData(List<AssignedStepResources> data) {
        this.data = data;
    }
}
