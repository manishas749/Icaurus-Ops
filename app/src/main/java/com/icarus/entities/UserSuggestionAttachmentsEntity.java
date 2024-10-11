package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "user_suggestion_attachments", foreignKeys = {
        @ForeignKey(entity = UserSuggestionEntity.class, parentColumns = "uuid", childColumns = "user_suggestion_uuid"),
        @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "user_id")})
public class UserSuggestionAttachmentsEntity {

    @NonNull
    @PrimaryKey
    private String uuid;
    @NonNull
    @ColumnInfo(name = "user_suggestion_uuid")
    private String user_suggestion_uuid;
    @NonNull
    @ColumnInfo(name = "display_filename")
    private String display_filename;
    @NonNull
    private String filename;
    @NonNull
    private Integer filesize;
    private String content_type;
    @NonNull
    @ColumnInfo(name = "user_id")
    private Integer user_id;
    @NonNull
    @ColumnInfo(name = "file_md5_checksum")
    private String file_md5_checksum;
    @NonNull
    @ColumnInfo(name = "is_uploaded")
    private Integer is_uploaded;
    @NonNull
    private String created;
    @NonNull
    private String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    private Integer sync_status;

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@NonNull String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    public String getUser_suggestion_uuid() {
        return user_suggestion_uuid;
    }

    public void setUser_suggestion_uuid(@NonNull String user_suggestion_uuid) {
        this.user_suggestion_uuid = user_suggestion_uuid;
    }

    @NonNull
    public String getDisplay_filename() {
        return display_filename;
    }

    public void setDisplay_filename(@NonNull String display_filename) {
        this.display_filename = display_filename;
    }

    @NonNull
    public String getFilename() {
        return filename;
    }

    public void setFilename(@NonNull String filename) {
        this.filename = filename;
    }

    @NonNull
    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(@NonNull Integer filesize) {
        this.filesize = filesize;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    @NonNull
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(@NonNull Integer user_id) {
        this.user_id = user_id;
    }

    @NonNull
    public String getFile_md5_checksum() {
        return file_md5_checksum;
    }

    public void setFile_md5_checksum(@NonNull String file_md5_checksum) {
        this.file_md5_checksum = file_md5_checksum;
    }

    @NonNull
    public Integer getIs_uploaded() {
        return is_uploaded;
    }

    public void setIs_uploaded(@NonNull Integer is_uploaded) {
        this.is_uploaded = is_uploaded;
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
    public Integer getSync_status() {
        return sync_status;
    }

    public void setSync_status(@NonNull Integer sync_status) {
        this.sync_status = sync_status;
    }
}