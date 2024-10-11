package com.icarus.navigators;

import com.icarus.models.ChecklistElementItem;

import java.util.ArrayList;

/**
 * Created by Anurag Purwar on 29/12/18.
 */
public interface ChecklistDetailNavigator {

    void openChecklistExecution(int checklistId, String checklistUUID, int position, String checklistTitle);

    void showSkipDeffer(ArrayList<ChecklistElementItem> checklistDetailItems, boolean isSkipDefer);

    void openDeferredTab(ChecklistElementItem item);

    void openSkippedTab(ChecklistElementItem item);

}
