package c.anurag.network.beans.user.locationdepartments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.beans.location.Locations;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class UserLocationDepartments extends DefaultChecklistResponse {
    @SerializedName("location_id")
    @Expose
    private int locationId;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("department_id")
    @Expose
    private int departmentId;
    @SerializedName("location")
    @Expose
    private Locations location;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}
