package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklist_locations", foreignKeys = {
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id"),
        @ForeignKey(entity = LocationEntity.class, parentColumns = "id", childColumns = "location_id")})
public class ChecklistLocationEntity {

    @NonNull
    @ColumnInfo(name = "checklist_id")
    private Integer checklistId;

    @PrimaryKey
    @NonNull
    private Integer id;
    @ColumnInfo(name = "is_deleted")
    @NonNull
    private Integer isDeleted;

    @ColumnInfo(name = "location_id")
    @NonNull
    private Integer locationId;
    @NonNull
    private String modified;

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

}