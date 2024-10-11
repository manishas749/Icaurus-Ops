package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

public class CheckListStepAttributeItems {
    @ColumnInfo(name = "allow_description")
    @NonNull
    public Integer allowDescription;
    @ColumnInfo(name = "allow_gallery")
    public Integer allowGallery;
    @ColumnInfo(name = "allowed_media_types")
    public String allowedMediaTypes;
    @ColumnInfo(name = "default_value")
    public Integer defaultValue;
    @ColumnInfo(name = "display_as")
    public String displayAs;
    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    public Integer id;
    @ColumnInfo(name = "max_length")
    public Integer maxLength;
    @ColumnInfo(name = "max_value")
    public Float maxValue;
    @ColumnInfo(name = "min_length")
    public Integer minLength;
    @ColumnInfo(name = "min_value")
    public Float minValue;
    @ColumnInfo(name = "model")
    @NonNull
    public String model;
    @ColumnInfo(name = "name")
    @NonNull
    public String name;
    @ColumnInfo(name = "possible_values")
    public String possibleValues;
    @ColumnInfo(name = "required")
    @NonNull
    public Integer required;
    @ColumnInfo(name = "sort_order")
    public Integer sortOrder;
    @ColumnInfo(name = "step_attribute_count")
    public String stepAttributeCount;
    @ColumnInfo(name = "type")
    public String type;
    @ColumnInfo(name = "user_roles")
    public String userRoles;
    @ColumnInfo(name = "multiple")
    public Integer multiple;
    @ColumnInfo(name = "custom_field_id")
    public Integer customFieldId;
    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "label")
    public String label;

    @ColumnInfo(name = "step_id")
    public Integer stepId;
    @ColumnInfo(name = "uuid")
    public String stepAttributeUuid;

    @ColumnInfo(name = "item_uuid")
    public String itemUuid;

    @ColumnInfo(name = "value")
    public String attributeValue;

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

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
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

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Float getMinValue() {
        return minValue;
    }

    public void setMinValue(Float minValue) {
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

    public String getStepAttributeCount() {
        return stepAttributeCount;
    }

    public void setStepAttributeCount(String stepAttributeCount) {
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

    public Integer getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(Integer customFieldId) {
        this.customFieldId = customFieldId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public String getStepAttributeUuid() {
        return stepAttributeUuid;
    }

    public void setStepAttributeUuid(String stepAttributeUuid) {
        this.stepAttributeUuid = stepAttributeUuid;
    }

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }
}
