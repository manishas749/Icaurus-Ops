package com.icarus.entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "checklist_logos", foreignKeys = {
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id")})
public class CheckListLogoEntity {

    @NonNull
    @PrimaryKey
    private Integer id;
    @NonNull
    private String uuid;
    @NonNull
    private String name;
    @NonNull
    private Integer checklist_id;
    @NonNull
    private Integer logo_type;
    @NonNull
    private String file_md5_checksum;
    @NonNull
    private String modified;
    @NonNull
    private Integer is_downloaded;

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
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Integer getChecklist_id() {
        return checklist_id;
    }

    public void setChecklist_id(@NonNull Integer checklist_id) {
        this.checklist_id = checklist_id;
    }

    @NonNull
    public Integer getLogo_type() {
        return logo_type;
    }

    public void setLogo_type(@NonNull Integer logo_type) {
        this.logo_type = logo_type;
    }

    @NonNull
    public String getFile_md5_checksum() {
        return file_md5_checksum;
    }

    public void setFile_md5_checksum(@NonNull String file_md5_checksum) {
        this.file_md5_checksum = file_md5_checksum;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }

    @NonNull
    public Integer getIs_downloaded() {
        return is_downloaded;
    }

    public void setIs_downloaded(@NonNull Integer is_downloaded) {
        this.is_downloaded = is_downloaded;
    }
}
