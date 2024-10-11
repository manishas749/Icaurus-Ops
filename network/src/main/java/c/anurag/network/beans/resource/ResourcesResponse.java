package c.anurag.network.beans.resource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ResourcesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Resources> data = null;

    public List<Resources> getData() {
        return data;
    }

    public void setData(List<Resources> data) {
        this.data = data;
    }
}
