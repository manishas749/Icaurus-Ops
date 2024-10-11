package c.anurag.network.beans.checklist.ppes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistPpes extends DefaultChecklistResponse {
    @SerializedName("ppe_id")
    @Expose
    private int ppeId;
    @SerializedName("step_id")
    @Expose
    private int stepId;
    @SerializedName("checklist_id")
    @Expose
    private int checklistId;

    public int getPpeId() {
        return ppeId;
    }

    public void setPpeId(int ppeId) {
        this.ppeId = ppeId;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }
}
