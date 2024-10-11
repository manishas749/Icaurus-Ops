package com.icarus.synchronization.postsyncmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkorderNote {

    @SerializedName("old_id")
    @Expose
    public Integer oldId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("uuid")
    @Expose
    public String uuid;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("workorder_notes")
    @Expose
    public String workorderNotes;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("WorkorderNoteDetail")
    @Expose
    public List<WorkorderNoteDetail> workorderNoteDetail = null;

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWorkorderNotes() {
        return workorderNotes;
    }

    public void setWorkorderNotes(String workorderNotes) {
        this.workorderNotes = workorderNotes;
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

    public List<WorkorderNoteDetail> getWorkorderNoteDetail() {
        return workorderNoteDetail;
    }

    public void setWorkorderNoteDetail(List<WorkorderNoteDetail> workorderNoteDetail) {
        this.workorderNoteDetail = workorderNoteDetail;
    }
}
