package c.anurag.network.beanspost.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedUsersPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedUsers> data = null;

    public List<AssignedUsers> getData() {
        return data;
    }

    public void setData(List<AssignedUsers> data) {
        this.data = data;
    }
}
