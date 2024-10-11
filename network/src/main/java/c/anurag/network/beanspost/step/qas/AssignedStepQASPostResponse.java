package c.anurag.network.beanspost.step.qas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedStepQASPostResponse {
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
