package c.anurag.network.beanspost.step.results;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beanspost.DefaultChecklistPostResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedStepResults extends DefaultChecklistPostResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("step_id")
    @Expose
    private Integer stepId;
    @SerializedName("checklist_element_id")
    @Expose
    private Integer checklistElementId;
    @SerializedName("capture_data_result")
    @Expose
    private String captureDataResult;
    @SerializedName("pass_fail_result")
    @Expose
    private Integer passFailResult;
    @SerializedName("yes_no_result")
    @Expose
    private Integer yesNoResult;
    @SerializedName("grm_result")
    @Expose
    private Integer grmResult;

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

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public String getCaptureDataResult() {
        return captureDataResult;
    }

    public void setCaptureDataResult(String captureDataResult) {
        this.captureDataResult = captureDataResult;
    }

    public Integer getPassFailResult() {
        return passFailResult;
    }

    public void setPassFailResult(Integer passFailResult) {
        this.passFailResult = passFailResult;
    }

    public Integer getYesNoResult() {
        return yesNoResult;
    }

    public void setYesNoResult(Integer yesNoResult) {
        this.yesNoResult = yesNoResult;
    }

    public Integer getGrmResult() {
        return grmResult;
    }

    public void setGrmResult(Integer grmResult) {
        this.grmResult = grmResult;
    }
}
