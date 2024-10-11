package com.icarus.workorder.models;

import androidx.room.ColumnInfo;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
public class WorkOrderItems {
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "workorder_priority_id")
    private Integer workorderPriorityId;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "dueDays")
    private String dueDays;
    @ColumnInfo(name = "id")
    private Integer workorderId;
    @ColumnInfo(name = "workorder_status_id")
    private String workorderStatusId;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "modified")
    private String modified;
    @ColumnInfo(name = "assigned_to_type")
    private Integer assignedToType;
    @ColumnInfo(name = "assigned_to_id")
    private Integer assignedToId;
    @ColumnInfo(name = "assignee")
    private String assignee;
    @ColumnInfo(name = "due_date")
    private String dueDate;
    @ColumnInfo(name = "sync_status")
    private Integer syncStatus;

    public WorkOrderItems(String uuid, Integer workorderPriorityId, String title, String dueDays,
                          Integer workorderId, String workorderStatusId, String status, String modified,
                          Integer assignedToType, Integer assignedToId, String assignee, String dueDate,
                          Integer syncStatus) {
        this.uuid = uuid;
        this.workorderPriorityId = workorderPriorityId;
        this.title = title;
        this.dueDays = dueDays;
        this.workorderId = workorderId;
        this.workorderStatusId = workorderStatusId;
        this.status = status;
        this.modified = modified;
        this.assignedToType = assignedToType;
        this.assignedToId = assignedToId;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.syncStatus = syncStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAssignedToType() {
        return assignedToType;
    }

    public void setAssignedToType(Integer assignedToType) {
        this.assignedToType = assignedToType;
    }

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getWorkorderPriorityId() {
        return workorderPriorityId != null ? workorderPriorityId : 2;
    }

    public void setWorkorderPriorityId(Integer workorderPriorityId) {
        this.workorderPriorityId = workorderPriorityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDueDays() {
        return dueDays;
    }

    public void setDueDays(String dueDays) {
        this.dueDays = dueDays;
    }

    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Integer workorderId) {
        this.workorderId = workorderId;
    }

    public String getWorkorderStatusId() {
        return workorderStatusId;
    }

    public void setWorkorderStatusId(String workorderStatusId) {
        this.workorderStatusId = workorderStatusId;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
