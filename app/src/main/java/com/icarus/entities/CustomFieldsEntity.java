package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "custom_fields")
public class CustomFieldsEntity {
    @ColumnInfo(name = "allow_description")
    @NonNull
    public Integer allowDescription;
    @ColumnInfo(name = "allow_gallery")
    public Integer allowGallery;
    @ColumnInfo(name = "allowed_media_types")
    public String allowedMediaTypes;
    @ColumnInfo(name = "default_value")
    public String defaultValue;
    @ColumnInfo(name = "display_as")
    public String displayAs;
    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    public Integer id;
    @ColumnInfo(name = "is_default")
    @NonNull
    public Integer isDefault;
    @ColumnInfo(name = "is_deleted")
    @NonNull
    public Integer isDeleted;
    @ColumnInfo(name = "max_length")
    public Integer maxLength;
    @ColumnInfo(name = "max_value")
    public Double maxValue;
    @ColumnInfo(name = "min_length")
    public Integer minLength;
    @ColumnInfo(name = "min_value")
    public Double minValue;
    @ColumnInfo(name = "model")
    @NonNull
    public String model;
    @ColumnInfo(name = "modified")
    @NonNull
    public String modified;
    @ColumnInfo(name = "multiple")
    @NonNull
    public Integer multiple;
    @ColumnInfo(name = "name")
    @NonNull
    public String name;
    @ColumnInfo(name = "possible_values")
    public String possibleValues;
    @ColumnInfo(name = "required")
    @NonNull
    public Integer required;
    @ColumnInfo(name = "sort_order")
    @NonNull
    public Integer sortOrder;
    @NonNull
    @ColumnInfo(name = "step_attribute_count")
    public Integer stepAttributeCount;
    @ColumnInfo(name = "type")
    @NonNull
    public String type;
    @ColumnInfo(name = "user_roles")
    public String userRoles;
    @ColumnInfo(name = "uuid")
    @NonNull
    public String uuid;

    @NonNull
    public Integer getAllowDescription() {
        return allowDescription;
    }

    public void setAllowDescription(@NonNull Integer allowDescription) {
        this.allowDescription = allowDescription;
    }

    public Integer getAllowGallery() {
        return allowGallery;
    }

    public void setAllowGallery(Integer allowGallery) {
        this.allowGallery = allowGallery;
    }

    public String getAllowedMediaTypes() {
        return allowedMediaTypes;
    }

    public void setAllowedMediaTypes(String allowedMediaTypes) {
        this.allowedMediaTypes = allowedMediaTypes;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDisplayAs() {
        return displayAs;
    }

    public void setDisplayAs(String displayAs) {
        this.displayAs = displayAs;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(@NonNull Integer isDefault) {
        this.isDefault = isDefault;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    @NonNull
    public String getModel() {
        return model;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(@NonNull Integer multiple) {
        this.multiple = multiple;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(String possibleValues) {
        this.possibleValues = possibleValues;
    }

    @NonNull
    public Integer getRequired() {
        return required;
    }

    public void setRequired(@NonNull Integer required) {
        this.required = required;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStepAttributeCount() {
        return stepAttributeCount;
    }

    public void setStepAttributeCount(Integer stepAttributeCount) {
        this.stepAttributeCount = stepAttributeCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }
}
