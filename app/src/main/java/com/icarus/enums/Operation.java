package com.icarus.enums;

/**
 * Created by Anurag Purwar on 18/5/19.
 */
public enum Operation {
    ERROR("error"), UPDATE("update"), INSERT("insert"), CHANGE("change");

    private String error;

    Operation(String error) {
        this.error = error;
    }

    public String getValue() {
        return this.error;
    }
}
