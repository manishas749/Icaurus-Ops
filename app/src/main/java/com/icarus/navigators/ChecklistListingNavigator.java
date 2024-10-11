package com.icarus.navigators;

import com.icarus.models.CheckListPPItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika Rana on 2/7/2019.
 */

public interface ChecklistListingNavigator {

    void observeTotalCount();

    void observeCompletedCount();

    void checklistCompleted();

    void showInformationPopUp(List<CheckListPPItems> checkListPPForInformationPopUp);

    void updateSkippedElementCount(int count);

    void updateDeferredElementCount(int count);

    void showElement(int position, ChecklistDetailItems item, int selectedTab);

    void showSkipDeffer(ArrayList<ChecklistElementItem> checklistDetailItems, boolean isSkipDefer);

    void openDeferredTab();

    void openSkippedTab();
}
