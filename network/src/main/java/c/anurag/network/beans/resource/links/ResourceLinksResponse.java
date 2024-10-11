package c.anurag.network.beans.resource.links;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ResourceLinksResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ResourceLinks> data = null;

    public List<ResourceLinks> getData() {
        return data;
    }

    public void setData(List<ResourceLinks> data) {
        this.data = data;
    }
}
