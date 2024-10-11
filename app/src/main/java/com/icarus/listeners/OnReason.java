package com.icarus.listeners;

import android.content.Context;

/**
 * Created by Monika Rana on 1/16/2019.
 */

public interface OnReason {
    void onContinue(String reason, Context context);
    void onCancel();
}
