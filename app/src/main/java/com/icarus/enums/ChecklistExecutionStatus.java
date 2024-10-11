package com.icarus.enums;

import com.icarus.util.StringUtil;

/**
 * Created by Monika Rana on 2/1/2019.
 */

public enum ChecklistExecutionStatus {
    NO(0), YES(1), SKIPPED(2), DEFERRED(3), PENDING(0), ACKNOWLEDGE(1);

    private int checklistExecutionStatus;

    ChecklistExecutionStatus(int code) {
        this.checklistExecutionStatus = code;
    }

    public int getValue() {
        return checklistExecutionStatus;
    }

    public static String getNameByCode(int code){
        for(ChecklistExecutionStatus e : ChecklistExecutionStatus.values()){
            if(code == e.getValue()) return StringUtil.INSTANCE.toTitleCase(e.name());
        }
        return "";
    }

}
