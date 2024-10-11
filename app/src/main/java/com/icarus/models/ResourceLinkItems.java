package com.icarus.models;

import androidx.room.ColumnInfo;


public class ResourceLinkItems {
    @ColumnInfo( name = "id")
    public Integer id;
    @ColumnInfo ( name = "is_deleted")
    public Integer isDeleted;
    @ColumnInfo ( name = "item_id")
    public Integer itemId;
    @ColumnInfo ( name = "item_type_id")
    public Integer itemTypeId;
    @ColumnInfo ( name = "link")
    public String link;
    @ColumnInfo ( name = "link_title")
    public String linkTitle;
    @ColumnInfo ( name = "modified")
    public String modified;
    @ColumnInfo ( name = "uuid")
    public String uuid;
}
