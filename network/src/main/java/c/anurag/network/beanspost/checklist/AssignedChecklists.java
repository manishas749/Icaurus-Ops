package c.anurag.network.beanspost.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.AssigneeTypeEnum;
import c.anurag.network.beans.ChecklistStatusEnum;
import c.anurag.network.beanspost.DefaultChecklistPostResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedChecklists extends DefaultChecklistPostResponse {
    @SerializedName("checklist_id")
    @Expose
    private Integer checklistId;
    @SerializedName("department_id")
    @Expose
    private Integer departmentId;
    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("assignee_type")
    @Expose
    private String assigneeType;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("started_by_user_id")
    @Expose
    private Integer startedByUserId;
    @SerializedName("assigned_at")
    @Expose
    private String assignedAt;
    @SerializedName("due_at")
    @Expose
    private String dueAt;
    @SerializedName("started_at")
    @Expose
    private String startedAt;
    @SerializedName("reason")
    @Expose
    private String reason;

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getStatus() {
        return ChecklistStatusEnum.valueOf(status.toUpperCase()).getValue();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAssigneeType() {
        return AssigneeTypeEnum.valueOf(assigneeType.toLowerCase()).getValue();
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStartedByUserId() {
        return startedByUserId;
    }

    public void setStartedByUserId(Integer startedByUserId) {
        this.startedByUserId = startedByUserId;
    }

    public String getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(String assignedAt) {
        this.assignedAt = assignedAt;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
