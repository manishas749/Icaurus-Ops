package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "assigned_step_resources", foreignKeys = {
        @ForeignKey(entity = AssignCheckListEntity.class, parentColumns = "uuid", childColumns = "assigned_checklist_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id"),
        @ForeignKey(entity = ItemTypeEntity.class, parentColumns = "id", childColumns = "item_type_id"),
        @ForeignKey(entity = ChecklistElementsEntity.class, parentColumns = "id", childColumns = "checklist_element_id")})
public class AssignedStepFileResourceEntity {
    @PrimaryKey
    @NonNull
    private String uuid;
    @NonNull
    private String assigned_checklist_uuid;
    @NonNull
    private Integer checklist_element_id;

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public String getAssigned_checklist_uuid() {
        return assigned_checklist_uuid;
    }

    public void setAssigned_checklist_uuid(@NonNull String assigned_checklist_uuid) {
        this.assigned_checklist_uuid = assigned_checklist_uuid;
    }

    @NonNull
    public Integer getChecklist_element_id() {
        return checklist_element_id;
    }

    public void setChecklist_element_id(@NonNull Integer checklist_element_id) {
        this.checklist_element_id = checklist_element_id;
    }

    @NonNull
    public Integer getItem_type_id() {
        return item_type_id;
    }

    public void setItem_type_id(@NonNull Integer item_type_id) {
        this.item_type_id = item_type_id;
    }

    @NonNull
    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(@NonNull Integer item_id) {
        this.item_id = item_id;
    }

    @NonNull
    public String getDisplay_file_name() {
        return display_file_name;
    }

    public void setDisplay_file_name(@NonNull String display_file_name) {
        this.display_file_name = display_file_name;
    }

    @NonNull
    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(@NonNull String file_name) {
        this.file_name = file_name;
    }

    @NonNull
    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(@NonNull String content_type) {
        this.content_type = content_type;
    }

    @NonNull
    public String getFile_md5_checksum() {
        return file_md5_checksum;
    }

    public void setFile_md5_checksum(@NonNull String file_md5_checksum) {
        this.file_md5_checksum = file_md5_checksum;
    }

    @NonNull
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(@NonNull Integer user_id) {
        this.user_id = user_id;
    }

    @NonNull
    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(@NonNull Integer is_deleted) {
        this.is_deleted = is_deleted;
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
    public Integer getIs_uploaded() {
        return is_uploaded;
    }

    public void setIs_uploaded(@NonNull Integer is_uploaded) {
        this.is_uploaded = is_uploaded;
    }

    @NonNull
    public Integer getIs_downloaded() {
        return is_downloaded;
    }

    public void setIs_downloaded(@NonNull Integer is_downloaded) {
        this.is_downloaded = is_downloaded;
    }

    @NonNull
    public Integer getSync_status() {
        return sync_status;
    }

    public void setSync_status(@NonNull Integer sync_status) {
        this.sync_status = sync_status;
    }

    @NonNull
    private Integer item_type_id;
    @NonNull
    private Integer item_id;
    private String display_file_name;
    private String file_name;
    private String content_type;
    @NonNull
    private String file_md5_checksum;
    @NonNull
    private Integer user_id;
    @NonNull
    private Integer is_deleted;
    @NonNull
    private String created;
    @NonNull
    private String modified;
    @NonNull
    private Integer is_uploaded;
    @NonNull
    private Integer is_downloaded;
    @NonNull
    private Integer sync_status;
}
