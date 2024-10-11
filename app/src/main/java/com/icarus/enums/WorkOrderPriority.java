package com.icarus.enums;

public enum WorkOrderPriority {
   URGENT(1), NORMAL(2), LOW(3);

    private int action;

    WorkOrderPriority(int code) {
        this.action = code;
    }

    public int getValue() {
        return action;
    }
}
