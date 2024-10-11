package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "assigned_departments", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = DepartmentsEntity.class, parentColumns = "id", childColumns = "department_id")})
public class AsssignedDepartmentsEntity {

    @PrimaryKey
    @NonNull
    public String uuid;
    @NonNull
    String assigned_checklist_uuid;

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

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @NonNull

    Integer department_id;
    @NonNull
    Integer is_deleted;
    @NonNull
    String modified;

}
