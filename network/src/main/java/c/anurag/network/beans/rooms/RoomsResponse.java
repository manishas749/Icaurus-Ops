package c.anurag.network.beans.rooms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class RoomsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Rooms> data = null;

    public List<Rooms> getData() {
        return data;
    }

    public void setData(List<Rooms> data) {
        this.data = data;
    }
}
