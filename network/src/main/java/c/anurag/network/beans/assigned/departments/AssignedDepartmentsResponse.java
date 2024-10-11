package c.anurag.network.beans.assigned.departments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedDepartmentsResponse extends DefaultResponse {
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
