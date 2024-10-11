package c.anurag.network.beans.groups;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class GroupsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Groups> data = null;

    public List<Groups> getData() {
        return data;
    }

    public void setData(List<Groups> data) {
        this.data = data;
    }
}
