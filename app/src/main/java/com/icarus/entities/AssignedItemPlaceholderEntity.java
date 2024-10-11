package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "assigned_item_placeholders", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = ItemPlaceholdersEntity.class, parentColumns = "id", childColumns = "item_placeholder_id"),
        @ForeignKey(entity = ChecklistElementsEntity.class, parentColumns = "id", childColumns = "checklist_element_id")})
public class AssignedItemPlaceholderEntity {

    @PrimaryKey
    @NonNull
    private String uuid;
    @NonNull
    @ColumnInfo(name = "assigned_checklist_uuid")
    private String assignedChecklistUuid;
    @NonNull
    @ColumnInfo(name = "checklist_element_id")
    private Integer checklistElementId;
    @NonNull
    @ColumnInfo(name = "item_placeholder_id")
    private Integer itemPlaceholderId;
    @NonNull
    @ColumnInfo(name = "user_id")
    private Integer userId;
    @NonNull
    private String value;
    @NonNull
    @ColumnInfo(name = "is_deleted")
    private Integer isDeleted;
    @NonNull
    private String created;
    @NonNull
    private String modified;

    @ColumnInfo(name = "foreign_key")
    private Integer foreignKey;

    @ColumnInfo(name = "model")
    private String model;

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(@NonNull String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    @NonNull
    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(@NonNull Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    @NonNull
    public Integer getItemPlaceholderId() {
        return itemPlaceholderId;
    }

    public void setItemPlaceholderId(@NonNull Integer itemPlaceholderId) {
        this.itemPlaceholderId = itemPlaceholderId;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getValue() {
        return value;
    }

    public void setValue(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public String getModel() {
        return model;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    public Integer getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(Integer foreignKey) {
        this.foreignKey = foreignKey;
    }
}
