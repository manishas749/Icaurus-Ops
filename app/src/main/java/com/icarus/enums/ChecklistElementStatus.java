package com.icarus.enums;

import com.icarus.util.StringUtil;

/**
 * Created by Monika Rana on 09/10/2019
 */
public enum ChecklistElementStatus {
    COMPLETED(1), SKIPPED(2), DEFERRED(3), IN_PROGRESS(0);

    private int action;

    ChecklistElementStatus(int code) {
        this.action = code;
    }

    public int getValue() {
        return action;
    }

    public static String getNameByCode(Integer code) {
        if (code != null)
            for (ChecklistElementStatus e : ChecklistElementStatus.values()) {
                if (code == e.getValue())
                    return StringUtil.INSTANCE.toTitleCase(e.name().replace("_", " "));
            }
        return "";
    }
}
