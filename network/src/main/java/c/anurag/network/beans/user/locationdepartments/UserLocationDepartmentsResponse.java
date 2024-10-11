package c.anurag.network.beans.user.locationdepartments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class UserLocationDepartmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<UserLocationDepartments> data = null;

    public List<UserLocationDepartments> getData() {
        return data;
    }

    public void setData(List<UserLocationDepartments> data) {
        this.data = data;
    }
}
