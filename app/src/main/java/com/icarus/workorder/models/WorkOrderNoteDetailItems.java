package com.icarus.workorder.models;

import androidx.room.ColumnInfo;
import android.text.TextUtils;

/**
 * Created by Anurag Purwar on 31/1/19.
 */
public class WorkOrderNoteDetailItems {
    @ColumnInfo(name = "property")
    private String property;
    @ColumnInfo(name = "property_key")
    private String propertyKey;
    @ColumnInfo(name = "old_value")
    private String oldValue;
    @ColumnInfo(name = "value")
    private String value;
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "workorder_note_id")
    private Integer workorderNoteId;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getOldValue() {
        return TextUtils.isEmpty(oldValue) ? "" : oldValue.replace("null", "");
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkorderNoteId() {
        return workorderNoteId;
    }

    public void setWorkorderNoteId(Integer workorderNoteId) {
        this.workorderNoteId = workorderNoteId;
    }
}
