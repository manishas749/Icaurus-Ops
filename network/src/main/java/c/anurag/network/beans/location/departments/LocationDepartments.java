package c.anurag.network.beans.location.departments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class LocationDepartments extends DefaultChecklistResponse {
    @SerializedName("location_id")
    @Expose
    private int locationId;
    @SerializedName("department_id")
    @Expose
    private int departmentId;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
