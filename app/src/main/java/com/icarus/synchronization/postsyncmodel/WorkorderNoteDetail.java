package com.icarus.synchronization.postsyncmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkorderNoteDetail {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("uuid")
    @Expose
    public String uuid;
    @SerializedName("property")
    @Expose
    public String property;
    @SerializedName("property_key")
    @Expose
    public String propertyKey;
    @SerializedName("old_value")
    @Expose
    public String oldValue;
    @SerializedName("value")
    @Expose
    public String value;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("old_id")
    @Expose
    public Integer oldId;

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
        return oldValue;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}