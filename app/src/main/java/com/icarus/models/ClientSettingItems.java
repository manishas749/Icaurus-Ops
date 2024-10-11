package com.icarus.models;

import androidx.room.ColumnInfo;

/**
 * Created by Monika Rana on 12/27/2018.
 */

public class ClientSettingItems {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "value")
    private String value;

    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
