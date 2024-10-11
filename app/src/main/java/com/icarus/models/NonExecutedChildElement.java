package com.icarus.models;


import androidx.room.ColumnInfo;

public class NonExecutedChildElement {

    int acknowledged;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "sort_order")
    Integer sortOrder;
    @ColumnInfo(name = "item_type_id")
    private int itemTypeId;

    public int getAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(int acknowledged) {
        this.acknowledged = acknowledged;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
}
