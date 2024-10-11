package com.icarus.entities;


import org.jetbrains.annotations.NotNull;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "checklist_titles", foreignKeys = {
        @ForeignKey(entity = AllChecklistEntity.class, parentColumns = "id", childColumns = "checklist_id")})
public class CheckListTitlesEntity {

    @PrimaryKey
    @NotNull
    Integer id;
    @NotNull
    String uuid;
    @NotNull
    Integer checklist_id;
    @NotNull
    String title;

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


    public Integer getChecklist_id() {
        return checklist_id;
    }

    public void setChecklist_id(Integer checklist_id) {
        this.checklist_id = checklist_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
