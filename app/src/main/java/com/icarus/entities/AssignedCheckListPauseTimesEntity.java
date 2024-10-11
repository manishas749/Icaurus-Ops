package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "assigned_checklist_pause_times", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id")})
public class AssignedCheckListPauseTimesEntity {

    @PrimaryKey
    @NonNull
    public  String uuid;
    @NonNull
    public String assigned_checklist_uuid;
    @NonNull
    public Integer user_id;

    public Integer resumed_by_user_id;
    @NonNull
    public String reason;
    @NonNull
    public Integer is_paused;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAssigned_checklist_uuid() {
        return assigned_checklist_uuid;
    }

    public void setAssigned_checklist_uuid(String assigned_checklist_uuid) {
        this.assigned_checklist_uuid = assigned_checklist_uuid;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getResumed_by_user_id() {
        return resumed_by_user_id;
    }

    public void setResumed_by_user_id(Integer resumed_by_user_id) {
        this.resumed_by_user_id = resumed_by_user_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIs_paused() {
        return is_paused;
    }

    public void setIs_paused(Integer is_paused) {
        this.is_paused = is_paused;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getSync_status() {
        return sync_status;
    }

    public void setSync_status(Integer sync_status) {
        this.sync_status = sync_status;
    }

    @NonNull
    Integer is_deleted;
    @NonNull
    String created;
    @NonNull
    String modified;
    @NonNull
    Integer sync_status;
}
