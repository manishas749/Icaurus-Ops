package com.icarus.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity(tableName = "placeholders")
public class PlaceholderEntity {

    @PrimaryKey
    @NonNull
    private Integer id;
    @NonNull
    private String uuid;
    @NonNull
    private String name;
    @NonNull
    private String placeholder;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
}