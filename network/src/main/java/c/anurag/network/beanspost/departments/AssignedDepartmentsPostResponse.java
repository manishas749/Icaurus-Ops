package c.anurag.network.beanspost.departments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedDepartmentsPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedDepartments> data = null;

    public List<AssignedDepartments> getData() {
        return data;
    }

    public void setData(List<AssignedDepartments> data) {
        this.data = data;
    }
}
