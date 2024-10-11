package com.icarus.enums;

public enum DueStatus {
    NORMAL (1), DUE (2), OVERDUE (3);

    private int dueStatus;

    DueStatus(Integer statusCode) {
        this.dueStatus = statusCode;
    }

    public int getValue() {
        return  dueStatus;
    }
}
