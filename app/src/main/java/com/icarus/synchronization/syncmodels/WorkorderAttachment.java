package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkorderAttachment {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName(("workorder_id"))
    @Expose
    public Integer workorderId;
    @SerializedName("uuid")
    @Expose
    public String uuid;
    @SerializedName("display_filename")
    @Expose
    public String displayFilename;
    @SerializedName("filename")
    @Expose
    public String filename;
    @SerializedName("file_size")
    @Expose
    public Long fileSize;
    @SerializedName("content_type")
    @Expose
    public String contentType;
    @SerializedName("author_id")
    @Expose
    public Integer authorId;
    @SerializedName("disk_directory")
    @Expose
    public String diskDirectory;
    @SerializedName("md5_checksum")
    @Expose
    public String md5Checksum;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplayFilename() {
        return displayFilename;
    }

    public void setDisplayFilename(String displayFilename) {
        this.displayFilename = displayFilename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Integer workorderId) {
        this.workorderId = workorderId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getDiskDirectory() {
        return diskDirectory;
    }

    public void setDiskDirectory(String diskDirectory) {
        this.diskDirectory = diskDirectory;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}


