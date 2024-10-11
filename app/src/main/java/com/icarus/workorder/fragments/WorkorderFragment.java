package com.icarus.workorder.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseFragment;
import com.icarus.constants.Constants;
import com.icarus.databinding.FragmentWorkorderBinding;
import com.icarus.viewmodels.DashboardViewModel;
import com.icarus.workorder.activities.WorkOrderCreateActivity;
import com.icarus.workorder.activities.WorkOrderDetailActivity;
import com.icarus.workorder.models.WorkOrderItems;
import com.icarus.workorder.navigators.WorkOrderNavigator;

import c.anurag.common.navigation.Navigator;

/**
 * Created by Anurag Purwar on 1/10/2019.
 */

public class WorkorderFragment extends BaseFragment<FragmentWorkorderBinding, DashboardViewModel> implements WorkOrderNavigator {
    private FragmentWorkorderBinding mBinding;
    private DashboardViewModel mDashboardViewModel;

    public static WorkorderFragment getInstance() {
        WorkorderFragment workorderFragment = new WorkorderFragment();
        Bundle bundle = new Bundle();
        workorderFragment.setArguments(bundle);
        return workorderFragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_workorder;
    }

    @Override
    public DashboardViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(DashboardViewModel.class) : null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        mDashboardViewModel = getViewModel();
        mDashboardViewModel.setWorkOrderNavigator(this);
        mBinding.recyclerView.setItemAnimator(null);
        mDashboardViewModel.initializeWorkOrderFilterList();
        mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
    }

    @Override
    public void onWorkOrderClick(WorkOrderItems item) {
        Navigator.launchActivity(getActivity(), WorkOrderDetailActivity.getInstance(getActivity(), item.getWorkorderId(), item.getUuid()));
    }

    @Override
    public void onStartObserving() {
        mDashboardViewModel.observeWorkOrder().observe(getViewLifecycleOwner(), new Observer<PagedList<WorkOrderItems>>() {
            @Override
            public void onChanged(@Nullable PagedList<WorkOrderItems> workOrderItems) {
                mDashboardViewModel.setIsLoading(false);
                mDashboardViewModel.setWorkOrderInAdapter(workOrderItems);
            }
        });
    }

    @Override
    public void onRemoveObserver() {
        if (mDashboardViewModel.observeWorkOrder().hasObservers()) {
            mDashboardViewModel.observeWorkOrder().removeObservers(getViewLifecycleOwner());
        }
    }

    @Override
    public void onCreateWorkOrder() {
        com.icarus.util.Navigator.launchActivityWithResult(getActivity(), Constants.REQUEST_RESULT_FOR_WORK_ORDER, WorkOrderCreateActivity.getInstance(getActivity()));

    }

    public void reset() {
        mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
    }
}
