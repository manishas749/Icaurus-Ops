package com.icarus.enums;

import com.icarus.util.StringUtil;

import java.util.Locale;

/**
 * Created by Monika Rana on 2/1/2019.
 */

public enum LogTableActions {
    COMPLETED(4), SKIPPED(12), DEFERRED(13), UNDO(15), FILE(7), QA_VERIFICATION(8),
    OTHER_THAN_FILE(6), TEXT(17), IMAGE(18), ASSIGNED(0), UNASSIGNED(1), STARTED(2), CANCELED(3),
    ACKNOWLEDGED(5), DATA_CAPTURED(6), FILE_REQUIRED(7), PAUSED(9), RESUMED(10), DELETED(11), CREATED(14),
    ASSIGNED_TO_DEPARTMENT(15), ROOM_AND_EQUIPMENT_SELECTED(16), PLACEHOLDER_CAPTURED(19), CHECKLIST_APPROVED(21),
    CHECKLIST_SENT_FOR_APPROVAL(20), COMPLETED_CHECKLIST_FOR_ACCEPTANCE(22), REJECTED(23), CLOSED(24);

    private int action;

    LogTableActions(int code) {
        this.action = code;
    }

    public int getValue() {
        return action;
    }

    public static String getNameByCode(int code) {
        for (LogTableActions e : LogTableActions.values()) {
            if (code == e.getValue()) return StringUtil.INSTANCE.toTitleCase(e.name().replace("_"," "));
        }
        return "";
    }
}
