package c.anurag.network.beans.checklist.locations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistLocations extends DefaultChecklistResponse {
    @SerializedName("checklist_id")
    @Expose
    private int checklistId;
    @SerializedName("location_id")
    @Expose
    private int locationId;


    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
