package com.icarus.navigators;

import com.icarus.models.AllChecklistItems;
import com.icarus.models.DepartmentChecklistItems;
import com.icarus.models.MyAssignedChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.UserItems;
import com.icarus.workorder.models.WorkOrderItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Monika Rana on 12/27/2018.
 */

public interface DashboardNavigator {
    void onAllChecklistClick(AllChecklistItems item);

    void onMyAssignedChecklistClick(MyAssignedChecklistItems item);

    void onDepartmentChecklistClick(DepartmentChecklistItems item);

    void openStartChecklistDialog(AllChecklistItems item, int message);

    void openChecklistDetailScreen(int checklistId, String assignedChecklistUuid, String checklistTitle, int isSequential);

    <T> void continueChecklist(T item);

    void assignChecklist(AllChecklistItems item);

    void startChecklist(AllChecklistItems item);

    void continueChecklist(List<UserItems> user, Integer checklistId, Integer departmentId, String checklistTitle, RoomAssetItems roomAsset, String dueDateString, boolean isStart, String uuid, int isSequential);

    void onStartObserving();

    void removeObserverIfAny();
}
