package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklist_elements", foreignKeys = {
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id"),
        @ForeignKey(entity = ItemTypeEntity.class, parentColumns = "id", childColumns = "item_type_id"),
        @ForeignKey(entity = ChecklistElementsEntity.class, parentColumns = "id", childColumns = "parent_id")})
public class ChecklistElementsEntity {
    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @NonNull
    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(@NonNull String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    @NonNull
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(@NonNull Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @ColumnInfo(name = "checklist_id")
    public Integer checklistId;
    @ColumnInfo(name = "description")
    public String description;
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public Integer id;
    @ColumnInfo(name = "is_deleted")
    @NonNull
    public Integer isDeleted;
    @NonNull
    @ColumnInfo(name = "item_id")
    public Integer itemId;
    @NonNull
    @ColumnInfo(name = "item_type_id")
    public Integer itemTypeId;
    @ColumnInfo(name = "item_uuid")
    public String itemUuid;
    @ColumnInfo(name = "modified")
    @NonNull
    public String modified;
    @ColumnInfo(name = "parent_id")
    public Integer parentId;
    @ColumnInfo(name = "sequence_no")
    @NonNull
    public String sequenceNo;
    @ColumnInfo(name = "sort_order")
    @NonNull
    public Integer sortOrder;
    @ColumnInfo(name = "title")
    public String title;
}