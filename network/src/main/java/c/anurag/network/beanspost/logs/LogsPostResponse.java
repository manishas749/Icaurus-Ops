package c.anurag.network.beanspost.logs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class LogsPostResponse {
    @SerializedName("data")
    @Expose
    private List<Logs> data = null;

    public List<Logs> getData() {
        return data;
    }

    public void setData(List<Logs> data) {
        this.data = data;
    }
}
