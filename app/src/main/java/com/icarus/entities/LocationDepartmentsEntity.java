package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "location_departments", foreignKeys = {
        @ForeignKey(entity = DepartmentsEntity.class, parentColumns = "id", childColumns = "department_id"),
        @ForeignKey(entity = LocationEntity.class, parentColumns = "id", childColumns = "location_id")})
public class LocationDepartmentsEntity {

    @NonNull
    @PrimaryKey
    Integer id;
    @NonNull
    Integer location_id;
    @NonNull
    Integer department_id;
    @NonNull
    Integer is_deleted;
    @NonNull
    String modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
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
}
