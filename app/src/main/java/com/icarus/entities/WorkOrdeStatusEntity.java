package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
@Entity(tableName = "workorder_statuses")
public class WorkOrdeStatusEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name ="is_default")
    private Integer isDefault;
    @NonNull @ColumnInfo(name ="name")
    private String name;
    @NonNull
    private String modified;

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
