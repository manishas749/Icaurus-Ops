package c.anurag.network.beans.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class UsersResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Users> data = null;

    public List<Users> getData() {
        return data;
    }

    public void setData(List<Users> data) {
        this.data = data;
    }
}
