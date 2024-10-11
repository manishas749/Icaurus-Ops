package c.anurag.network.beans.assigned.cautions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.AssigneeNCWResultEnum;
import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedCautions extends DefaultChecklistResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("caution_id")
    @Expose
    private Integer cautionId;
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

    public Integer getCautionId() {
        return cautionId;
    }

    public void setCautionId(Integer cautionId) {
        this.cautionId = cautionId;
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
