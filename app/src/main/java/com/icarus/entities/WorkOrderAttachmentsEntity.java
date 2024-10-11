package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "workorder_attachments",
        foreignKeys = {
                @ForeignKey(entity = UsersEntity.class, parentColumns = "id", childColumns = "author_id"),
                @ForeignKey(onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.NO_ACTION,
                        entity = WorkOrderEntity.class, parentColumns = "id", childColumns = "workorder_id")})

public class WorkOrderAttachmentsEntity {
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "workorder_id")
    private Integer workorderId;
    @NonNull
    @ColumnInfo(name = "display_filename")
    private String displayFileName;
    @NonNull
    @ColumnInfo(name = "filename")
    private String filename;
    @NonNull
    @ColumnInfo(name = "filesize")
    private Long filesize;
    @ColumnInfo(name = "content_type")
    private String contentType;
    @NonNull
    @ColumnInfo(name = "author_id")
    private Integer authorId;
    @NonNull
    @ColumnInfo(name = "file_md5_checksum")
    private String fileMd5Checksum;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo(name = "sync_status")
    public Integer syncStatus;
    @NonNull
    @ColumnInfo(name = "created")
    public String created;
    @ColumnInfo(name = "is_downloaded")
    @NonNull
    public Integer isDownloaded;
    @ColumnInfo(name = "is_uploaded")
    @NonNull
    public Integer isUploaded = 0;

    @NonNull
    public Integer getIsDownloaded() {
        return isDownloaded;
    }

    public void setIsDownloaded(@NonNull Integer isDownloaded) {
        this.isDownloaded = isDownloaded;
    }

    @NonNull
    public Integer getIsUploaded() {
        return isUploaded;
    }

    public void setIsUploaded(@NonNull Integer isUploaded) {
        this.isUploaded = isUploaded;
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
    public String getDisplayFileName() {
        return displayFileName;
    }

    public void setDisplayFileName(@NonNull String displayFileName) {
        this.displayFileName = displayFileName;
    }

    @NonNull
    public String getFilename() {
        return filename;
    }

    public void setFilename(@NonNull String filename) {
        this.filename = filename;
    }

    @NonNull
    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(@NonNull Long filesize) {
        this.filesize = filesize;
    }

    @NonNull
    public String getContentType() {
        return contentType;
    }

    public void setContentType(@NonNull String contentType) {
        this.contentType = contentType;
    }

    @NonNull
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(@NonNull Integer authorId) {
        this.authorId = authorId;
    }

    @NonNull
    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(@NonNull String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
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