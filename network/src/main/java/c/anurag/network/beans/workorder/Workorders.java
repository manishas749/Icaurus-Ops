package c.anurag.network.beans.workorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class Workorders extends DefaultChecklistResponse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("due_date")
    @Expose
    private String dueDate;
    @SerializedName("workorder_status_id")
    @Expose
    private Integer workorderStatusId;
    @SerializedName("assigned_to_type")
    @Expose
    private Integer assignedToType;
    @SerializedName("workorder_priority_id")
    @Expose
    private Integer workorderPriorityId;
    @SerializedName("author_id")
    @Expose
    private Integer authorId;
    @SerializedName("assigned_to_id")
    @Expose
    private Integer assignedToId;
    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("checklist_id")
    @Expose
    private Integer checklistId;
    @SerializedName("workorder_billing_type_id")
    @Expose
    private Integer workorderBillingTypeId;
    @SerializedName("location_equipment_id")
    @Expose
    private Integer locationEquipmentId;
    @SerializedName("location_room_id")
    @Expose
    private Integer locationRoomId;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("closed_date")
    @Expose
    private String closedDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAssignedToType() {
        return assignedToType;
    }

    public void setAssignedToType(Integer assignedToType) {
        this.assignedToType = assignedToType;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getWorkorderStatusId() {
        return workorderStatusId;
    }

    public void setWorkorderStatusId(Integer workorderStatusId) {
        this.workorderStatusId = workorderStatusId;
    }

    public Integer getWorkorderPriorityId() {
        return workorderPriorityId;
    }

    public void setWorkorderPriorityId(Integer workorderPriorityId) {
        this.workorderPriorityId = workorderPriorityId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Integer getWorkorderBillingTypeId() {
        return workorderBillingTypeId;
    }

    public void setWorkorderBillingTypeId(Integer workorderBillingTypeId) {
        this.workorderBillingTypeId = workorderBillingTypeId;
    }

    public Integer getLocationEquipmentId() {
        return locationEquipmentId;
    }

    public void setLocationEquipmentId(Integer locationEquipmentId) {
        this.locationEquipmentId = locationEquipmentId;
    }

    public Integer getLocationRoomId() {
        return locationRoomId;
    }

    public void setLocationRoomId(Integer locationRoomId) {
        this.locationRoomId = locationRoomId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
