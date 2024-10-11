package c.anurag.network.beans.step;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Steps> data = null;

    public List<Steps> getData() {
        return data;
    }

    public void setData(List<Steps> data) {
        this.data = data;
    }
}
