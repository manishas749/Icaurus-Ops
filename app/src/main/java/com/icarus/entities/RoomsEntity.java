package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "rooms")
public class RoomsEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public Integer id;
    @ColumnInfo(name = "uuid")
    public String uuid;
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "is_default")
    public Integer isDefault;
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
