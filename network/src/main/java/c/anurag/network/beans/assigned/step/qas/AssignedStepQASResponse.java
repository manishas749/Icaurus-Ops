package c.anurag.network.beans.assigned.step.qas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedStepQASResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedStepQAS> data = null;

    public List<AssignedStepQAS> getData() {
        return data;
    }

    public void setData(List<AssignedStepQAS> data) {
        this.data = data;
    }
}
