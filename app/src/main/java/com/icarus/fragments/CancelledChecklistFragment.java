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
import com.icarus.activities.ChecklistReportActivity;
import com.icarus.base.ChecklistBaseFragment;
import com.icarus.constants.Constants;
import com.icarus.databinding.FragmentChecklistBinding;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.CancelledCompletedChecklistItems;
import com.icarus.models.StringCheckBox;
import com.icarus.synchronization.workers.AssignedChecklistOnDemandWork;
import com.icarus.util.DialogUtility;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.DashboardViewModel;

import java.util.ArrayList;

/**
 * Created by Anurag Purwar on 7/2/2019.
 */
public class CancelledChecklistFragment extends ChecklistBaseFragment<FragmentChecklistBinding, DashboardViewModel> {
    private static final String STATUS = "STATUS";
    private DashboardViewModel mDashboardViewModel;
    private FragmentChecklistBinding mBinding;

    public static CancelledChecklistFragment getInstance() {
        CancelledChecklistFragment fragment = new CancelledChecklistFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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
        mBinding.recyclerView.setItemAnimator(null);
       /* if (mDashboardViewModel.getAllCheckListAdapter().getItemCount() == 0)
            mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
        else
            mDashboardViewModel.isChecklistEmpty.set(false);*/


        mDashboardViewModel.getTypeFilterList();
        mDashboardViewModel.getUserFilterList();
        mDashboardViewModel.observeUserFilterList().observe(getViewLifecycleOwner(), new Observer<ArrayList<StringCheckBox>>() {
            @Override
            public void onChanged(@Nullable ArrayList<StringCheckBox> filterList) {
                mDashboardViewModel.setIsLoading(false);
                if (filterList != null && filterList.size() > 0) {
                    filterList.get(0).setSelected(true);
                    mDashboardViewModel.userFilterList.addAll(filterList);
                    mDashboardViewModel.setUserFilterListInAdapter(filterList);
                }

                mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
            }
        });

        mBinding.emptyViewText2.setText(getString(R.string.empty_cancelled_checklist_message));
    }


    @Override
    public void openChecklistDetailScreen(int checklistId, String assignedChecklistUuid, String checklistTitle, int isSequential) {

    }

    @Override
    public <T> void continueChecklist(T assignedChecklist) {
        final CancelledCompletedChecklistItems item = (CancelledCompletedChecklistItems) assignedChecklist;

        if (item.getMasterSyncStatus() == Constants.SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED ||
                item.getSynced() == Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER) {

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
                                    .putInt(AssignedChecklistOnDemandWork.ASSIGNED_SYNC_STATUS, item.getSynced())
                                    .putInt(AssignedChecklistOnDemandWork.CHECKLIST_SYNC_STATUS, item.getMasterSyncStatus())
                                    .build();

                            final WorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(AssignedChecklistOnDemandWork.class).setInputData(data).build();
                            WorkManager.getInstance(getActivity()).enqueue(oneTimeWorkRequest);
                            mDashboardViewModel.setIsLoading(true);
                            WorkManager.getInstance(getActivity()).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                                    .observe(getViewLifecycleOwner(), new Observer<WorkInfo>() {
                                        @Override
                                        public void onChanged(@Nullable WorkInfo workStatus) {
                                            if (workStatus.getState() == WorkInfo.State.SUCCEEDED) {
                                                WorkManager.getInstance(getActivity()).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).removeObservers(CancelledChecklistFragment.this);
                                                Navigator.launchActivity(getActivity(), ChecklistReportActivity.getIntent(getActivity(), item.getChecklistId(), item.getUuid()));
                                                mDashboardViewModel.setIsLoading(false);
                                            } else if (workStatus.getState() == WorkInfo.State.FAILED) {
                                                mDashboardViewModel.setIsLoading(false);
                                                Utilities.getInstance(getActivity()).showToast(getString(R.string.no_internet_connection), Toast.LENGTH_LONG, getActivity());
                                            }
                                        }
                                    });
                        }

                        @Override
                        public void onNegativeButtonClick() {
                            //DO Nothing
                        }
                    });
        } else {
            Intent intent = ChecklistReportActivity.getIntent(
                    getActivity(),
                    item.getChecklistId(),
                    item.getUuid()
            );

            Navigator.launchActivity(getActivity(), intent);
        }
    }

    @Override
    public void onStartObserving() {
        mDashboardViewModel.observeCancelledCheckList().observe(getViewLifecycleOwner(), new Observer<PagedList<CancelledCompletedChecklistItems>>() {
            @Override
            public void onChanged(@Nullable PagedList<CancelledCompletedChecklistItems> departmentChecklistItems) {
                mDashboardViewModel.setIsLoading(false);
                mDashboardViewModel.setCancelledChecklistInAdapter(departmentChecklistItems);
            }
        });
    }

    @Override
    public void removeObserverIfAny() {
        if (mDashboardViewModel.observeCancelledCheckList() != null && mDashboardViewModel.observeCancelledCheckList().hasObservers())
            mDashboardViewModel.observeCancelledCheckList().removeObservers(getViewLifecycleOwner());

    }

}
