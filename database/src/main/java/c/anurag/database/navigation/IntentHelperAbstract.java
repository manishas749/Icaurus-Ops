package c.anurag.database.navigation;

import android.content.Context;
import android.content.Intent;

import c.anurag.common.navigation.IIntentHelper;

/**
 * Created by anuragpurwar
 */
public abstract class IntentHelperAbstract implements IIntentHelper
{
    public abstract Intent newDashBoardIntent(Context context);

    public abstract Intent newLoginIntent(Context context);

    public abstract Intent newTermsAndConditionIntent(Context context);

    public abstract Intent newLocationChangeIntent(Context context);

    public abstract Intent newChecklistDetailIntent(Context context, int checklistId, String assignedChecklistUuid, String checklistTitle);
}

