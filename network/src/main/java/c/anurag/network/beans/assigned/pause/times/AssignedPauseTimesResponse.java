package c.anurag.network.beans.assigned.pause.times;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedPauseTimesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedPauseTimes> data = null;

    public List<AssignedPauseTimes> getData() {
        return data;
    }

    public void setData(List<AssignedPauseTimes> data) {
        this.data = data;
    }
}
