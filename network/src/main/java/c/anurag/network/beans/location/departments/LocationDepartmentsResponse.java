package c.anurag.network.beans.location.departments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationDepartmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<LocationDepartments> data = null;

    public List<LocationDepartments> getData() {
        return data;
    }

    public void setData(List<LocationDepartments> data) {
        this.data = data;
    }
}
