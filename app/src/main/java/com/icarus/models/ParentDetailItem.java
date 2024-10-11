package com.icarus.models;

import androidx.room.ColumnInfo;

public class ParentDetailItem {
    @ColumnInfo(name = "id")
    private int elementId;
    @ColumnInfo(name = "checklist_id")
    private int checklistId;

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public int getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ColumnInfo(name = "item_type_id")
    private int itemTypeId;
    @ColumnInfo(name = "item_id")
    private int itemId;
    @ColumnInfo(name = "item_uuid")
    private String itemUuid;
    @ColumnInfo(name = "parent_id")
    private int parentItemId;
    @ColumnInfo(name = "sort_order")
    private int sortOrder;
    @ColumnInfo(name = "sequence_no")
    private String sequenceNo;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "status")
    private Integer status;

}
