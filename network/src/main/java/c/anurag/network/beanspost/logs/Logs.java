package c.anurag.network.beanspost.logs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anuragpurwar
 */

public class Logs {
    @SerializedName("item_uuid")
    @Expose
    private String itemUuid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("assigned_to_name")
    @Expose
    private String assignedToName;
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("item_description")
    @Expose
    private String itemDescription;
    @SerializedName("step_action")
    @Expose
    private String stepAction;
    @SerializedName("checklist_id")
    @Expose
    private Integer checklistId;
    @SerializedName("checklist_element_id")
    @Expose
    private Integer checklistElementId;
    @SerializedName("action")
    @Expose
    private Integer action;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("assigned_to")
    @Expose
    private Integer assignedTo;
    @SerializedName("uuid")
    @Expose
    protected String uuid;
    @SerializedName("created_at")
    @Expose
    protected String createdAt;
    @SerializedName("updated_at")
    @Expose
    protected String updatedAt;
    @SerializedName("operation")
    @Expose
    private String operation;

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAssignedToName() {
        return assignedToName;
    }

    public void setAssignedToName(String assignedToName) {
        this.assignedToName = assignedToName;
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getStepAction() {
        return stepAction;
    }

    public void setStepAction(String stepAction) {
        this.stepAction = stepAction;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
