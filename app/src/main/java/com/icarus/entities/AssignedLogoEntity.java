package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "assigned_logos", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = CheckListLogoEntity.class, parentColumns = "id", childColumns = "checklist_logo_id")})
public class AssignedLogoEntity {

    @NonNull
    @PrimaryKey
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public Integer getChecklistLogoId() {
        return checklistLogoId;
    }

    public void setChecklistLogoId(Integer checklistLogoId) {
        this.checklistLogoId = checklistLogoId;
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

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    @NonNull
    @ColumnInfo(name = "assigned_checklist_uuid")
    private String assignedChecklistUuid;

    @NonNull
    @ColumnInfo(name = "checklist_logo_id")
    private Integer checklistLogoId;
    @NonNull
    String created;
    @NonNull
    private String modified;

    @NonNull
    @ColumnInfo(name = "sync_status")
    private Integer syncStatus;


}
