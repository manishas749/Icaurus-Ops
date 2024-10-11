package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklist_statuses")
public class ChecklistStatusEntity {

    private String description;


    @ColumnInfo(name = "edit_allowed")
    private Integer editAllowed;

    @PrimaryKey @NonNull
    private Integer id;

    @ColumnInfo(name = "is_closed")
    private Integer isClosed;
    @ColumnInfo(name = "is_default")
    private Integer isDefault;
    @ColumnInfo(name = "is_deleted")
    private Integer isDeleted;

    @ColumnInfo(name = "is_expired")
    @NonNull
    private Integer isExpired;

    @NonNull
    private String modified;

    @NonNull
    private String name;

    @ColumnInfo(name = "sort_order")
    private Integer sortOrder;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEditAllowed() {
        return editAllowed;
    }

    public void setEditAllowed(Integer editAllowed) {
        this.editAllowed = editAllowed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
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

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
