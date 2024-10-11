package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "resources")
public class ResourceEntity {

    @ColumnInfo(name = "content_type")
    public String contentType;
    @ColumnInfo(name = "display_file_name")
    public String displayFileName;
    @ColumnInfo(name = "file_md5_checksum")
    @NonNull
    public String fileMd5Checksum;
    @ColumnInfo(name = "file_name")
    @NonNull
    public String fileName;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer id;
    @ColumnInfo(name = "file_size")
    @NonNull
    public Integer fileSize;
    @ColumnInfo(name = "is_deleted")
    @NonNull
    public Integer isDeleted;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDisplayFileName() {
        return displayFileName;
    }

    public void setDisplayFileName(String displayFileName) {
        this.displayFileName = displayFileName;
    }

    @NonNull
    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(@NonNull String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    @NonNull
    public String getFileName() {
        return fileName;
    }

    public void setFileName(@NonNull String fileName) {
        this.fileName = fileName;
    }

    @NonNull
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(@NonNull Integer fileSize) {
        this.fileSize = fileSize;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public Integer getIsDownloaded() {
        return isDownloaded;
    }

    public void setIsDownloaded(@NonNull Integer isDownloaded) {
        this.isDownloaded = isDownloaded;
    }

    @NonNull
    public Integer getIsResource() {
        return isResource;
    }

    public void setIsResource(@NonNull Integer isResource) {
        this.isResource = isResource;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
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

    @ColumnInfo(name = "is_downloaded")
    @NonNull
    public Integer isDownloaded;
    @ColumnInfo(name = "is_resource")
    @NonNull
    public Integer isResource;
    @ColumnInfo(name = "item_id")
    public Integer itemId;
    @ColumnInfo(name = "item_type_id")
    public Integer itemTypeId;
    @ColumnInfo(name = "modified")
    @NonNull
    public String modified;
    @ColumnInfo(name = "uuid")
    @NonNull
    public String uuid;

    public String getPath() {
        return fileMd5Checksum + "." + displayFileName.split("\\.")[1];
    }
}
