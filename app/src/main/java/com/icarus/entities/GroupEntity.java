package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 *
 * Created by Anurag Purwar on 17/1/19.
 */
@Entity(tableName = "groups")
public class GroupEntity {
    @PrimaryKey
    @NonNull
    private Integer id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    private String modified;

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }
}
