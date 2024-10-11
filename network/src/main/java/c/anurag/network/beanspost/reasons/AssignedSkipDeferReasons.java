package c.anurag.network.beanspost.reasons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.AssigneeStepResultEnum;
import c.anurag.network.beanspost.DefaultChecklistPostResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedSkipDeferReasons extends DefaultChecklistPostResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("step_id")
    @Expose
    private Integer assignedChecklistStepId;
    @SerializedName("checklist_element_id")
    @Expose
    private Integer checklistElementId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("reason")
    @Expose
    private String reason;

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

    public Integer getAssignedChecklistStepId() {
        return assignedChecklistStepId;
    }

    public void setAssignedChecklistStepId(Integer assignedChecklistStepId) {
        this.assignedChecklistStepId = assignedChecklistStepId;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public Integer getStatus() {
        return AssigneeStepResultEnum.valueOf(status.toLowerCase()).getValue();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
