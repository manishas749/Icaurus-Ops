package c.anurag.network.beans.workorder.note;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class WorkorderNotes extends DefaultChecklistResponse {
    @SerializedName("workorder_id")
    @Expose
    private Integer workorderId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("workorder_notes")
    @Expose
    private String workorderNotes;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Integer workorderId) {
        this.workorderId = workorderId;
    }

    public String getWorkorderNotes() {
        return workorderNotes;
    }

    public void setWorkorderNotes(String workorderNotes) {
        this.workorderNotes = workorderNotes;
    }
}
