package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "step_attributes",
        foreignKeys = {
                @ForeignKey(entity = CustomFieldsEntity.class,
                        parentColumns = "id",
                        childColumns = "custom_field_id")
        })
public class StepAttributesEntity {
    @PrimaryKey
    @NonNull
    public Integer id;

    @NonNull
    public String uuid;

    @NonNull
    @ColumnInfo(name = "step_id")
    public Integer stepId;

    @NonNull
    @ColumnInfo(name = "custom_field_id")
    public Integer customFieldId;

    @NonNull
    public String label;

    public String description;

    @NonNull
    @ColumnInfo(name = "sort_order")
    public Integer sortOrder;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;

    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(@NonNull Integer stepId) {
        this.stepId = stepId;
    }

    @NonNull
    public Integer getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(@NonNull Integer customFieldId) {
        this.customFieldId = customFieldId;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
