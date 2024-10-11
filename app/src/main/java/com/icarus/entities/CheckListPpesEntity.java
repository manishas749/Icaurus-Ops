package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklist_ppes", foreignKeys = {
        @ForeignKey(entity = PepesEntity.class, parentColumns = "id", childColumns = "ppe_id")})
public class CheckListPpesEntity {

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getPpe_id() {
        return ppe_id;
    }

    public void setPpe_id(@NonNull Integer ppe_id) {
        this.ppe_id = ppe_id;
    }

    @NonNull
    public Integer getStep_id() {
        return step_id;
    }

    public void setStep_id(@NonNull Integer step_id) {
        this.step_id = step_id;
    }

    @NonNull
    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(@NonNull Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @PrimaryKey
    @NonNull
    private Integer id;
    @NonNull
    private Integer ppe_id;
    @NonNull
    private Integer step_id;
    @NonNull
    private Integer is_deleted;
    @NonNull
    private String modified;
    @NonNull
    private String uuid;
}