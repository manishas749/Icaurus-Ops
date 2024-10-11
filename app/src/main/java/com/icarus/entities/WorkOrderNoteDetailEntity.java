package com.icarus.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.icarus.constants.Constants;

/**
 * Created by Anurag Purwar on 31/1/19.
 */
@Entity(tableName = "workorder_note_details",
        foreignKeys = {
                @ForeignKey(onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.NO_ACTION,
                        entity = WorkOrderNotesEntity.class, parentColumns = "id", childColumns = "workorder_note_id")})
public class WorkOrderNoteDetailEntity {
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "uuid")
    private String uuid;
    @NonNull
    @ColumnInfo(name = "workorder_note_id")
    private Integer workorderNoteId;
    @NonNull
    @ColumnInfo(name = "property")
    private String property;
    @NonNull
    @ColumnInfo(name = "property_key")
    private String propertyKey;
    @ColumnInfo(name = "old_value")
    private String oldValue;
    @ColumnInfo(name = "value")
    private String value;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus = Constants.SYNC_STATUS_NOT;
    @NonNull
    @ColumnInfo(name = "created")
    public String created;

    public WorkOrderNoteDetailEntity(@NonNull Integer id, @NonNull String uuid, @NonNull Integer workorderNoteId,
                                     @NonNull String property, @NonNull String propertyKey, @NonNull String oldValue,
                                     @NonNull String value, @NonNull String modified, @NonNull String created) {
        this.id = id;
        this.uuid = uuid;
        this.workorderNoteId = workorderNoteId;
        this.property = property;
        this.propertyKey = propertyKey;
        this.oldValue = oldValue;
        this.value = value;
        this.modified = modified;
        this.created = created;
    }

    public WorkOrderNoteDetailEntity() {

    }



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
    public Integer getWorkorderNoteId() {
        return workorderNoteId;
    }

    public void setWorkorderNoteId(@NonNull Integer workorderNoteId) {
        this.workorderNoteId = workorderNoteId;
    }

    @NonNull
    public String getProperty() {
        return property;
    }

    public void setProperty(@NonNull String property) {
        this.property = property;
    }

    @NonNull
    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(@NonNull String propertyKey) {
        this.propertyKey = propertyKey;
    }

    @NonNull
    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(@NonNull String oldValue) {
        this.oldValue = oldValue;
    }

    @NonNull
    public String getValue() {
        return value;
    }

    public void setValue(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(@NonNull Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }
}