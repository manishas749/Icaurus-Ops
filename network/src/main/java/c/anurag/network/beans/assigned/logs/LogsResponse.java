package c.anurag.network.beans.assigned.logs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class LogsResponse extends DefaultResponse {
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
