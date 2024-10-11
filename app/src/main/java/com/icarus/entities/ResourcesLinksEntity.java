package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "resource_links", foreignKeys = {
        @ForeignKey(entity = ItemTypeEntity.class, parentColumns = "id", childColumns = "item_type_id")})
public class ResourcesLinksEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public Integer id;
    @NonNull
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @NonNull
    @ColumnInfo(name = "item_id")
    public Integer itemId;
    @NonNull
    @ColumnInfo(name = "item_type_id")
    public Integer itemTypeId;
    @NonNull
    @ColumnInfo(name = "link")
    public String link;
    @NonNull
    @ColumnInfo(name = "link_title")
    public String linkTitle;
    @NonNull
    @ColumnInfo(name = "modified")
    public String modified;
    @NonNull
    @ColumnInfo(name = "uuid")
    public String uuid;

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
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(@NonNull Integer itemId) {
        this.itemId = itemId;
    }

    @NonNull
    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(@NonNull Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @NonNull
    public String getLink() {
        return link;
    }

    public void setLink(@NonNull String link) {
        this.link = link;
    }

    @NonNull
    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(@NonNull String linkTitle) {
        this.linkTitle = linkTitle;
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
}
