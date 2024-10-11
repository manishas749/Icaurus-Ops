package c.anurag.network.beans.assigned.steps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedStepsResponse extends DefaultResponse {
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
