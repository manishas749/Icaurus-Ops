package c.anurag.network.beans.assigned.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedUsers extends DefaultChecklistResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("assigned_by")
    @Expose
    private Integer assignedBy;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public Integer getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Integer assignedBy) {
        this.assignedBy = assignedBy;
    }
}
