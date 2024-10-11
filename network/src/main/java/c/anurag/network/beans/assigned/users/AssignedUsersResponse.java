package c.anurag.network.beans.assigned.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedUsersResponse extends DefaultResponse {
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
