package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "ncw_hazards", foreignKeys = {
        @ForeignKey(entity = HazardsEntity.class, parentColumns = "id", childColumns = "hazard_id")})
public class NcwHazardsEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    Integer id;
    @NonNull
    String uuid;
    @NonNull
    Integer item_id;
    @NonNull
    Integer item_type_id;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(@NonNull Integer item_id) {
        this.item_id = item_id;
    }

    @NonNull
    public Integer getItem_type_id() {
        return item_type_id;
    }

    public void setItem_type_id(@NonNull Integer item_type_id) {
        this.item_type_id = item_type_id;
    }

    @NonNull
    public Integer getHazard_id() {
        return hazard_id;
    }

    public void setHazard_id(@NonNull Integer hazard_id) {
        this.hazard_id = hazard_id;
    }

    @NonNull
    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(@NonNull Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    Integer hazard_id;
    @NonNull
    Integer is_deleted;
    @NonNull
    String modified;
}