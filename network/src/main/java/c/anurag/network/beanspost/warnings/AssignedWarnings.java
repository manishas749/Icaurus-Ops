package c.anurag.network.beanspost.warnings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.AssigneeNCWResultEnum;
import c.anurag.network.beanspost.DefaultChecklistPostResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedWarnings extends DefaultChecklistPostResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("warning_id")
    @Expose
    private Integer warningId;
    @SerializedName("checklist_element_id")
    @Expose
    private Integer checklistElementId;
    @SerializedName("status")
    @Expose
    private String status;

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

    public Integer getWarningId() {
        return warningId;
    }

    public void setWarningId(Integer warningId) {
        this.warningId = warningId;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public Integer getStatus() {
        return AssigneeNCWResultEnum.valueOf(status.toLowerCase()).getValue();
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
