package c.anurag.network.beans.assigned.pause.times;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar
 */

public class AssignedPauseTimes extends DefaultChecklistResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
        @SerializedName("resumed_by_user_id")
    @Expose
    private Integer resumedByUserId;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("pause_status")
    @Expose
    private boolean pauseStatus;

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

    public Integer getResumedByUserId() {
        return resumedByUserId;
    }

    public void setResumedByUserId(Integer resumedByUserId) {
        this.resumedByUserId = resumedByUserId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getPauseStatus() {
        return Utility.convertBooleanToInt(pauseStatus);
    }

    public void setPauseStatus(boolean pauseStatus) {
        this.pauseStatus = pauseStatus;
    }
}
