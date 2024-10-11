package com.icarus.entities;

import com.icarus.constants.Constants;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Anurag Purwar on 31/1/19.
 */
@Entity(tableName = "workorder_notes",
        foreignKeys = {
                @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
                @ForeignKey(onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.NO_ACTION,
                        entity = WorkOrderEntity.class, parentColumns = "id", childColumns = "workorder_id")},
        indices = {
                @Index(value = "id", unique = true)}
)

public class WorkOrderNotesEntity {

    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;
    @NonNull
    @ColumnInfo(name = "workorder_id")
    private Integer workorderId;
    @NonNull
    @ColumnInfo(name = "user_id")
    private Integer userId;
    @ColumnInfo(name = "workorder_notes")
    private String workorderNotes;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus = Constants.SYNC_STATUS_NOT;
    @NonNull
    @ColumnInfo(name = "created")
    public String created;
    @Ignore
    private Integer oldId;

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
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
    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(@NonNull Integer workorderId) {
        this.workorderId = workorderId;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getWorkorderNotes() {
        return workorderNotes;
    }

    public void setWorkorderNotes(@NonNull String workorderNotes) {
        this.workorderNotes = workorderNotes;
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

    public WorkOrderNotesEntity(@NonNull Integer id, @NonNull String uuid, @NonNull Integer workorderId, @NonNull Integer userId, @NonNull String workorderNotes, @NonNull String modified, @NonNull String created) {
        this.id = id;
        this.uuid = uuid;
        this.workorderId = workorderId;
        this.userId = userId;
        this.workorderNotes = workorderNotes;
        this.modified = modified;
        this.created = created;
    }

    public WorkOrderNotesEntity() {

    }
}
