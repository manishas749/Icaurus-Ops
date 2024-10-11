package c.anurag.network.beans.assigned.step.resources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedStepResourcesResponse extends DefaultResponse {
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
