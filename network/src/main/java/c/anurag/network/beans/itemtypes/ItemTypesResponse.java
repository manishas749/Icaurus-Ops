package c.anurag.network.beans.itemtypes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class ItemTypesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ItemTypes> data = null;

    public List<ItemTypes> getData() {
        return data;
    }

    public void setData(List<ItemTypes> data) {
        this.data = data;
    }
}
