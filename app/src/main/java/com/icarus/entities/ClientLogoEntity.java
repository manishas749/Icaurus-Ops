package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "client_logos", foreignKeys = @ForeignKey(entity = UsersEntity.class,
        parentColumns = "id",
        childColumns = "user_id"))
public class ClientLogoEntity {

   @NonNull
   @ColumnInfo( name = "created")
    public String created;
    @NonNull
    @ColumnInfo( name = "file_md5_checksum")
    public String fileMd5Checksum;

    @NonNull
    public String getCreated() {
        return created;
    }

    public void setCreated(@NonNull String created) {
        this.created = created;
    }

    @NonNull
    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(@NonNull String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getIsDownloaded() {
        return isDownloaded;
    }

    public void setIsDownloaded(@NonNull Integer isDownloaded) {
        this.isDownloaded = isDownloaded;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
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
    @ColumnInfo( name = "id")
    public Integer id;
    @NonNull
    @ColumnInfo( name = "is_downloaded")
    public Integer isDownloaded;
    @NonNull
    @ColumnInfo( name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo( name = "name")
    public String name;
    @NonNull
    @ColumnInfo( name = "user_id")
    public Integer userId;
    @NonNull
    @ColumnInfo( name = "uuid")
    public String uuid;
}
