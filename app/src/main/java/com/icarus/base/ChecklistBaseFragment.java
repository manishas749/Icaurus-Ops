package com.icarus.base;

import androidx.databinding.ViewDataBinding;

import com.icarus.models.AllChecklistItems;
import com.icarus.models.DepartmentChecklistItems;
import com.icarus.models.MyAssignedChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.UserItems;
import com.icarus.navigators.DashboardNavigator;

import java.util.List;

/**
 * Created by Monika Rana on 1/10/2019.
 */

public abstract class ChecklistBaseFragment<T extends ViewDataBinding,V extends BaseViewModel> extends BaseFragment<T, V> implements DashboardNavigator{

    @Override
    public void onAllChecklistClick(AllChecklistItems item) {

    }

    @Override
    public void onDepartmentChecklistClick(DepartmentChecklistItems item) {

    }

    @Override
    public void onMyAssignedChecklistClick(MyAssignedChecklistItems item) {

    }

    @Override
    public void openStartChecklistDialog(AllChecklistItems item, int message) {

    }

    @Override
    public void assignChecklist(AllChecklistItems item) {

    }

    @Override
    public void startChecklist(AllChecklistItems item) {

    }

    @Override
    public void continueChecklist(List<UserItems> user, Integer checklistId, Integer departmentId, String checklistTitle, RoomAssetItems roomAsset, String dueDateString, boolean isStart, String uuid, int isSequential) {

    }

}
