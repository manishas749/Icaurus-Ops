package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "item_placeholders", foreignKeys = {
        @ForeignKey(entity = PlaceholderEntity.class, parentColumns = "id", childColumns = "placeholder_id")})
public class ItemPlaceholdersEntity {

    @NonNull
    @PrimaryKey
    Integer id;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(@NonNull Integer itemId) {
        this.itemId = itemId;
    }

    @NonNull
    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(@NonNull Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @NonNull
    public Integer getPlaceholderId() {
        return placeholderId;
    }

    public void setPlaceholderId(@NonNull Integer placeholderId) {
        this.placeholderId = placeholderId;
    }

    @NonNull
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(@NonNull Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    @ColumnInfo(name = "item_id")
    Integer itemId;
    @NonNull
    @ColumnInfo(name = "item_type_id")
    Integer itemTypeId;

    @NonNull
    @ColumnInfo(name = "placeholder_id")
    Integer placeholderId;

    @NonNull
    @ColumnInfo(name = "sort_order")
    Integer sortOrder;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    Integer isDeleted;

    @NonNull
    @ColumnInfo(name = "modified")
    String modified;

}
