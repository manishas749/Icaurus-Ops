package c.anurag.network.beans.assigned.logo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedLogos extends DefaultChecklistResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("checklist_logo_id")
    @Expose
    private Integer checklistLogoId;

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public Integer getChecklistLogoId() {
        return checklistLogoId;
    }

    public void setChecklistLogoId(Integer checklistLogoId) {
        this.checklistLogoId = checklistLogoId;
    }
}
