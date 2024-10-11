package c.anurag.network.beans.workorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class WorkordersResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Workorders> data = null;

    public List<Workorders> getData() {
        return data;
    }

    public void setData(List<Workorders> data) {
        this.data = data;
    }
}
