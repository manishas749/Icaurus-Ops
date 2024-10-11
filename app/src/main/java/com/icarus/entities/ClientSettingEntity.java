package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Anurag Purwar on 2/2/19.
 * CREATE TABLE `client_settings` (
 *   `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 *   `uuid` TEXT NOT NULL,
 *   `name` TEXT NOT NULL,
 *   `value` TEXT NOT NULL,
 *   `created` TEXT NOT NULL,
 *   `modified` TEXT NOT NULL
 * )
 */
@Entity(tableName = "client_settings")
public class ClientSettingEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;
    @NonNull @ColumnInfo(name ="uuid")
    private String uuid;
    @NonNull @ColumnInfo(name ="name")
    private String name;
    @NonNull @ColumnInfo(name ="value")
    private String value;
    @NonNull @ColumnInfo(name ="created")
    private String created;
    @NonNull @ColumnInfo(name ="modified")
    private String modified;

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
    public String getValue() {
        return value;
    }

    public void setValue(@NonNull String value) {
        this.value = value;
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
}
