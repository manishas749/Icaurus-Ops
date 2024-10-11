package c.anurag.network.beanspost.times;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedPauseTimesPostResponse {
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
