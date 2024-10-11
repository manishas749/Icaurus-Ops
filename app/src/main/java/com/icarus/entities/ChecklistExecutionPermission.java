package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklist_execution_permissions", foreignKeys = {
        @ForeignKey(entity = ChecklistTypeEntity.class, parentColumns = "id", childColumns = "checklist_type_id"),
        @ForeignKey(entity = GroupEntity.class, parentColumns = "id", childColumns = "group_id")})
public class ChecklistExecutionPermission {
    @PrimaryKey
    @NonNull
    Integer id;
    @NonNull
    Integer group_id;
    @NonNull
    Integer checklist_type_id;
    @NonNull
    Integer checklist_status_id;
    @NonNull
    Integer is_assignable;
    @NonNull
    Integer is_executable;
    @NonNull
    String modified;
    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(@NonNull Integer group_id) {
        this.group_id = group_id;
    }

    @NonNull
    public Integer getChecklist_type_id() {
        return checklist_type_id;
    }

    public void setChecklist_type_id(@NonNull Integer checklist_type_id) {
        this.checklist_type_id = checklist_type_id;
    }

    @NonNull
    public Integer getChecklist_status_id() {
        return checklist_status_id;
    }

    public void setChecklist_status_id(@NonNull Integer checklist_status_id) {
        this.checklist_status_id = checklist_status_id;
    }

    @NonNull
    public Integer getIs_assignable() {
        return is_assignable;
    }

    public void setIs_assignable(@NonNull Integer is_assignable) {
        this.is_assignable = is_assignable;
    }

    @NonNull
    public Integer getIs_executable() {
        return is_executable;
    }

    public void setIs_executable(@NonNull Integer is_executable) {
        this.is_executable = is_executable;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }
}