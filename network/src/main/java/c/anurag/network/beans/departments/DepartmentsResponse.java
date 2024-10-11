package c.anurag.network.beans.departments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class DepartmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Departments> data = null;

    public List<Departments> getData() {
        return data;
    }

    public void setData(List<Departments> data) {
        this.data = data;
    }
}
