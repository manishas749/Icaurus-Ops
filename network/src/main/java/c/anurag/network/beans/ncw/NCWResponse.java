package c.anurag.network.beans.ncw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class NCWResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<NCW> data = null;

    public List<NCW> getData() {
        return data;
    }

    public void setData(List<NCW> data) {
        this.data = data;
    }
}
