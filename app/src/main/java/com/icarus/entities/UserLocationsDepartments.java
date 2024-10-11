package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "user_location_departments", foreignKeys = {
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = LocationEntity.class, parentColumns = "id", childColumns = "location_id")})
public class UserLocationsDepartments {
    @NonNull
    private Integer user_id;

    @PrimaryKey
    @NonNull
    private Integer id;
    @ColumnInfo(name = "is_deleted")
    @NonNull private Integer isDeleted;

    @ColumnInfo(name = "location_id")
    @NonNull private Integer locationId;
    @NonNull private String modified;

    @NonNull
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(@NonNull Integer user_id) {
        this.user_id = user_id;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull Integer locationId) {
        this.locationId = locationId;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @NonNull
    String created;

    @ColumnInfo(name = "department_id")
    Integer departmentId;


}
