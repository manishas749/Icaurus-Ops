package com.icarus.workorder.models;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class RoomItems {

    @ColumnInfo(name = "Name")
    public String name;
    @ColumnInfo(name = "Id")
    public Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
