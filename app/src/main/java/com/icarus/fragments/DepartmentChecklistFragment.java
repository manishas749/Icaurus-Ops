package com.icarus.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.ChecklistDetailListingActivity;
import com.icarus.activities.PlaceholderCaptureListActivity;
import com.icarus.base.ChecklistBaseFragment;
import com.icarus.constants.Constants;
import com.icarus.databinding.FragmentChecklistBinding;
import com.icarus.enums.ChecklistStatus;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.DepartmentChecklistItems;
import com.icarus.models.StringCheckBox;
import com.icarus.synchronization.workers.AssignedChecklistOnDemandWork;
import com.icarus.util.DialogUtility;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.DashboardViewModel;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Monika Rana on 1/3/2019.
 */
public class DepartmentChecklistFragment extends ChecklistBaseFragment<FragmentChecklistBinding, DashboardViewModel> {
    private DashboardViewModel mDashboardViewModel;
    private FragmentChecklistBinding mBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_checklist;
    }

    @Override
    public DashboardViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(DashboardViewModel.class) : null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDashboardViewModel = getViewModel();
        mBinding = getViewDataBinding();
        mDashboardViewModel.setNavigator(this);
       /* if (mDashboardViewModel.getAllCheckListAdapter().getItemCount() == 0)
            mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
        else
            mDashboardViewModel.isChecklistEmpty.set(false);
*/
        mBinding.recyclerView.setItemAnimator(null);
        mDashboardViewModel.getTypeFilterList();
        mDashboardViewModel.getStatusFilterList();
        mDashboardViewModel.getDepartmentFilterList();
        mDashboardViewModel.observeDepartmentalFilterList().observe(getViewLifecycleOwner(), new Observer<ArrayList<StringCheckBox>>() {
            @Override
            public void onChanged(@Nullable ArrayList<StringCheckBox> filterList) {
                mDashboardViewModel.setIsLoading(false);
                if (filterList != null && filterList.size() > 0) {
                    filterList.get(0).setSelected(true);
                    mDashboardViewModel.departmentalFilterList.addAll(filterList);
                    mDashboardViewModel.setDepartmentFilterListInAdapter(filterList);
                }
                mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
            }
        });

        mBinding.emptyViewText2.setText(getString(R.string.empty_assigned_checklist_message));
    }


    @Override
    public void onDepartmentChecklistClick(final DepartmentChecklistItems item) {
        super.onDepartmentChecklistClick(item);
        if (item != null)
            if (item.getChecklistSyncStatus() == ChecklistStatus.NOT_SYNCHRONIZED) {
                DialogUtility.showAlertWithTwoButtonsOnly(
                        getActivity(),
                        getString(R.string.ask_sync_checklist),
                        R.string.ok,
                        R.string.cancel,
                        new OnSelectListener() {
                            @Override
                            public void onPositiveButtonClick() {
                                Data data = new Data.Builder()
                                        .putString(AssignedChecklistOnDemandWork.ASSIGNED_CHECKLIST_UUID, item.getUuid())
                                        .putInt(AssignedChecklistOnDemandWork.CHECKLIST_ID, item.getChecklistId())
                                        .putInt(AssignedChecklistOnDemandWork.ASSIGNED_SYNC_STATUS, item.getSyncStatus())
                                        .putInt(AssignedChecklistOnDemandWork.CHECKLIST_SYNC_STATUS, item.getMasterSyncStatus())
                                        .build();

                                final WorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                                        .Builder(AssignedChecklistOnDemandWork.class)
                                        .setInputData(data)
                                        .build();

                                WorkManager.getInstance(getActivity()).enqueue(oneTimeWorkRequest);
                                mDashboardViewModel.setIsLoading(true);

                                WorkManager.getInstance(getActivity()).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                                        .observe(getViewLifecycleOwner(), new Observer<WorkInfo>() {
                                            @Override
                                            public void onChanged(@Nullable WorkInfo workStatus) {
                                                if (workStatus != null) {
                                                    if (workStatus.getState() == WorkInfo.State.SUCCEEDED) {
                                                        WorkManager.getInstance(getActivity())
                                                                .getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                                                                .removeObservers(getViewLifecycleOwner());

                                                        item.setSyncStatus(Constants.EXECUTION_STATUS_SYNC_TO_SERVER);
                                                        item.setMasterSyncStatus(Constants.SYNC_STATUS_CHECKLIST_FULLY_SYNCED);

                                                        onDepartmentChecklistClick(item);
                                                        mDashboardViewModel.setIsLoading(false);
                                                    } else if (workStatus.getState() == WorkInfo.State.FAILED) {
                                                        mDashboardViewModel.setIsLoading(false);
                                                        Utilities.getInstance(getActivity()).showToast(getString(R.string.no_internet_connection), Toast.LENGTH_LONG, getActivity());
                                                    }
                                                }
                                            }
                                        });
                            }

                            @Override
                            public void onNegativeButtonClick() {
                                //DO Nothing
                            }
                        });
            } else if (mDashboardViewModel.getItemPlaceHolders(item.getUuid()).size() > 0) {
                openPlaceholderList(item);
            } else {
                DialogUtility.showAlertWithCloseContinueOnly(getActivity(), getString(R.string.start_assign_checklist_message), 0, this, item, getString(R.string.assigne_start));
            }
    }

    @Override
    public void openChecklistDetailScreen(int checklistId, String assignedChecklistUuid, String checklistTitle, int isSequential) {
        Navigator.launchActivityWithResult(getActivity(), Constants.REQUEST_RESULT_FOR_CANCELLED_COMPLETED, ChecklistDetailListingActivity.newChecklistDetailIntent(getActivity(), assignedChecklistUuid));
    }

    @Override
    public <T> void continueChecklist(T departmentChecklistItems) {
        DepartmentChecklistItems item = (DepartmentChecklistItems) departmentChecklistItems;
        //  String assignedChecklistUUID = AppUtility.Companion.getUuid();
        mDashboardViewModel.updateDepartmentChecklist(item.uuid, item);
        openChecklistDetailScreen(item.getChecklistId(), item.getUuid(), item.getTitle(), item.getIsSequential());
    }

    @Override
    public void onStartObserving() {
        mDashboardViewModel.observeDeptCheckList().observe(getViewLifecycleOwner(), new Observer<PagedList<DepartmentChecklistItems>>() {
            @Override
            public void onChanged(@Nullable PagedList<DepartmentChecklistItems> departmentChecklistItems) {
                mDashboardViewModel.setIsLoading(false);
                mDashboardViewModel.setDepartmentChecklistInAdapter(departmentChecklistItems);
            }
        });
    }

    @Override
    public void removeObserverIfAny() {
        if (mDashboardViewModel.observeDeptCheckList() != null && mDashboardViewModel.observeDeptCheckList().hasObservers())
            mDashboardViewModel.observeDeptCheckList().removeObservers(getViewLifecycleOwner());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Checks the result from placeholder screen and process the result
        if (requestCode == Constants.REQUEST_RESULT_FOR_START_CHECKLIST && resultCode == RESULT_OK) {
            if (mDashboardViewModel.getDepartmentChecklistItems() != null
                    && mDashboardViewModel.getDepartmentChecklistItems().getChecklistStatus().equals("In Progress")) {
                openChecklistDetailScreen(mDashboardViewModel.getDepartmentChecklistItems().getChecklistId(), mDashboardViewModel.getDepartmentChecklistItems().getUuid(), mDashboardViewModel.getDepartmentChecklistItems().getTitle(), mDashboardViewModel.getDepartmentChecklistItems().getIsSequential());
            } else
                continueChecklist(mDashboardViewModel.getDepartmentChecklistItems());
        }
    }

    private void openPlaceholderList(DepartmentChecklistItems items) {
        if (getActivity() != null)
            Navigator.launchActivityWithResult(DepartmentChecklistFragment.this, Constants.REQUEST_RESULT_FOR_START_CHECKLIST,
                    PlaceholderCaptureListActivity.setBundleData(getActivity(), items.getUuid(),
                            items.getRoom(), items.getEquipment(), items.getChecklistStatus(),
                            items.getTitle(), getString(R.string.my_department_checklist)));

    }

}
