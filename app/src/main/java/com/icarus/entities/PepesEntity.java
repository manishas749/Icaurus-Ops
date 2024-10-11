package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "ppes")
public class PepesEntity {

    @PrimaryKey
    @NonNull
    private Integer id;

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
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    @NonNull
    private String uuid;
    @NonNull
    private String label;
    private String icon;
    private Integer status;
    @NonNull
    private String modified;
    @NonNull
    @ColumnInfo(name = "file_md5_checksum")
    private String fileMd5Checksum;
}