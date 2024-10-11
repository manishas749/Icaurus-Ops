package c.anurag.network.beans.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar
 */

public class Checklists extends DefaultChecklistResponse {
    @SerializedName("checklist_type_id")
    @Expose
    private int checklistTypeId;
    @SerializedName("author_id")
    @Expose
    private int authorId;
    @SerializedName("department_id")
    @Expose
    private int departmentId;
    @SerializedName("is_published")
    @Expose
    private boolean isPublished;
    @SerializedName("delete_reason")
    @Expose
    private String deleteReason;
    @SerializedName("is_sequential")
    @Expose
    private boolean isSequential;
    @SerializedName("is_template")
    @Expose
    private boolean isTemplate;
    @SerializedName("estimated_hours")
    @Expose
    private Double estimatedHours;

    public int getChecklistTypeId() {
        return checklistTypeId;
    }

    public void setChecklistTypeId(int checklistTypeId) {
        this.checklistTypeId = checklistTypeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getIsPublished() {
        return Utility.convertBooleanToInt(isPublished);
    }

    public void setStatus(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public int getIsSequential() {
        return Utility.convertBooleanToInt(isSequential);
    }

    public void setSequential(boolean sequential) {
        isSequential = sequential;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public int getIsTemplate() {
        return Utility.convertBooleanToInt(isTemplate);
    }

    public void setIsTemplate(boolean template) {
        isTemplate = template;
    }

    public Double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
