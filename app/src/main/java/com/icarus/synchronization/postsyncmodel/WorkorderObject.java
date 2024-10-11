package com.icarus.synchronization.postsyncmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkorderObject extends AssignedObjects {

    @SerializedName("old_id")
    @Expose
    public Integer oldId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("uuid")
    @Expose
    public String uuid;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("due_date")
    @Expose
    public String dueDate;
    @SerializedName("workorder_status_id")
    @Expose
    public Integer workorderStatusId;
    @SerializedName("assigned_to_id")
    @Expose
    public Integer assignedToId;
    @SerializedName("assigned_to_type")
    @Expose
    public Integer assignedToType;
    @SerializedName("checklist_id")
    @Expose
    public Integer checklistId;
    @SerializedName("workorder_billing_type_id")
    @Expose
    public Integer workorderBillingTypeId;
    @SerializedName("workorder_priority_id")
    @Expose
    public Integer workorderPriorityId;
    @SerializedName("author_id")
    @Expose
    public Integer authorId;
    @SerializedName("location_id")
    @Expose
    public Integer locationId;
    @SerializedName("location_room_id")
    @Expose
    public Integer locationRoomId;
    @SerializedName("location_equipment_id")
    @Expose
    public Integer locationEquipmentId;
    @SerializedName("start_date")
    @Expose
    public String startDate;
    @SerializedName("closed_date")
    @Expose
    public String closedDate;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("WorkorderAttachment")
    @Expose
    public List<WorkorderAttachment> workorderAttachment = null;
    @SerializedName("WorkorderNote")
    @Expose
    public List<WorkorderNote> workorderNote = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    public Integer getAssignedToType() {
        return assignedToType;
    }

    public void setAssignedToType(Integer assignedToType) {
        this.assignedToType = assignedToType;
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

    public Integer getLocationRoomId() {
        return locationRoomId;
    }

    public void setLocationRoomId(Integer locationRoomId) {
        this.locationRoomId = locationRoomId;
    }

    public Integer getLocationEquipmentId() {
        return locationEquipmentId;
    }

    public void setLocationEquipmentId(Integer locationEquipmentId) {
        this.locationEquipmentId = locationEquipmentId;
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

    public List<WorkorderAttachment> getWorkorderAttachment() {
        return workorderAttachment;
    }

    public void setWorkorderAttachment(List<WorkorderAttachment> workorderAttachment) {
        this.workorderAttachment = workorderAttachment;
    }

    public List<WorkorderNote> getWorkorderNote() {
        return workorderNote;
    }

    public void setWorkorderNote(List<WorkorderNote> workorderNote) {
        this.workorderNote = workorderNote;
    }

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }
}