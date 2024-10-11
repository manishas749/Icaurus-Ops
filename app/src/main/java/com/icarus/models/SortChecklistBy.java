package com.icarus.models;

/**
 * Created by Monika Rana on 1/3/2019.
 */

public class SortChecklistBy {
    private String name, tag;

    public SortChecklistBy(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
