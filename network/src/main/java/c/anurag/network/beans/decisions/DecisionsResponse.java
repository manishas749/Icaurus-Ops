package c.anurag.network.beans.decisions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class DecisionsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Decisions> data = null;

    public List<Decisions> getData() {
        return data;
    }

    public void setData(List<Decisions> data) {
        this.data = data;
    }
}
