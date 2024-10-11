package c.anurag.network.beans.step.result.functions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepResultFunctionsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<StepResultFunctions> data = null;

    public List<StepResultFunctions> getData() {
        return data;
    }

    public void setData(List<StepResultFunctions> data) {
        this.data = data;
    }
}
