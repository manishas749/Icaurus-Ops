package com.icarus.workorder.models;

/**
 * Created by Anurag Purwar on 30/1/19.
 */
public class WorkOrderInfoItems {
    private String title;
    private String value;

    public WorkOrderInfoItems(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value == null ? "" : value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
