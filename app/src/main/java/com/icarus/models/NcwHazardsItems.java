package com.icarus.models;

import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

public class NcwHazardsItems {
    @NonNull
    String label;
    String icon;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    Integer id;

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }


}
