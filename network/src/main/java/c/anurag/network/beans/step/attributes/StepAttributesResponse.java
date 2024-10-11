package c.anurag.network.beans.step.attributes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepAttributesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<StepAttributes> data = null;

    public List<StepAttributes> getData() {
        return data;
    }

    public void setData(List<StepAttributes> data) {
        this.data = data;
    }
}
