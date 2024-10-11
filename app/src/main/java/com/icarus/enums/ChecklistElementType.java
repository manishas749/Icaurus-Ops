package com.icarus.enums;

/**
 * Created by Monika Rana on 1/25/2019.
 */

public enum ChecklistElementType {
    STEP(1), DECISION(2), CHECKLIST(3), CAUTION(4), NOTE(5), WARNING(6), TEXT(7), PROCEDURE(8), MEMORY_LINE(9), RESOURCE(10),
    TITLE(11), DATA_STEP(12), DEPARTMENT(13);

    private int checklistElementType;

    ChecklistElementType(int code) {
        this.checklistElementType = code;
    }

    public int getValue() {
        return checklistElementType;
    }

}
