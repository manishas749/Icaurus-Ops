package com.icarus.workorder.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.icarus.R;
import com.icarus.databinding.BottomSheetWorkorderFilterBinding;
import com.icarus.workorder.viewmodels.WorkOrderViewModel;

/**
 * Created by Monika Rana on 12/28/2018.
 */

public class FilterBottomSheetWorkOrderFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private WorkOrderViewModel mDashboardViewModel;
    private BottomSheetWorkorderFilterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_workorder_filter, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null)
            mDashboardViewModel = new ViewModelProvider(getActivity()).get(WorkOrderViewModel.class);
        binding.setViewModel(mDashboardViewModel);

        mDashboardViewModel.getTypeFilterList();
        mDashboardViewModel.getPriorityFilterList();
        mDashboardViewModel.getAuthorFilterList();

        mDashboardViewModel.getAssignedToFilterList();
        binding.btnApply.setOnClickListener(this);
        binding.clearFilter.setOnClickListener(this);
    }

    public static FilterBottomSheetWorkOrderFragment getInstance() {
        FilterBottomSheetWorkOrderFragment fag = new FilterBottomSheetWorkOrderFragment();
        Bundle bundle = new Bundle();
        fag.setArguments(bundle);
        return fag;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnApply:
                /*if (mDashboardViewModel.getTypeListAdapter() != null)
                    mDashboardViewModel.selectedTypeFilterIndex = mDashboardViewModel.getTypeListAdapter().getCheckItemIndex();
                if (mDashboardViewModel.getAssignedToListAdapter() != null)
                    mDashboardViewModel.selectedAssignedToFilterIndex = mDashboardViewModel.getAssignedToListAdapter().getCheckItemIndex();
                if (mDashboardViewModel.getPriorityListAdapter() != null)
                    mDashboardViewModel.selectedPriorityFilterIndex = mDashboardViewModel.getPriorityListAdapter().getCheckItemIndex();
                if (mDashboardViewModel.getAssignedToListAdapter() != null)
                    mDashboardViewModel.selectedAuthorFilterIndex = mDashboardViewModel.getAuthorListAdapter().getCheckItemIndex();*/
                mDashboardViewModel.getWorkOrder(0, mDashboardViewModel.getSearchKeyword());
                dismiss();
                break;
            case R.id.clearFilter:
                mDashboardViewModel.onClearFilter();
                /*if (mDashboardViewModel.getTypeListAdapter() != null)
                    mDashboardViewModel.selectedTypeFilterIndex = mDashboardViewModel.getTypeListAdapter().getCheckItemIndex();
                if (mDashboardViewModel.getAssignedToListAdapter() != null)
                    mDashboardViewModel.selectedAssignedToFilterIndex = mDashboardViewModel.getAssignedToListAdapter().getCheckItemIndex();
                if (mDashboardViewModel.getPriorityListAdapter() != null)
                    mDashboardViewModel.selectedPriorityFilterIndex = mDashboardViewModel.getPriorityListAdapter().getCheckItemIndex();
                if (mDashboardViewModel.getAssignedToListAdapter() != null)
                    mDashboardViewModel.selectedAuthorFilterIndex = mDashboardViewModel.getAuthorListAdapter().getCheckItemIndex();*/
                mDashboardViewModel.getWorkOrder(0, mDashboardViewModel.getSearchKeyword());
                dismiss();
                break;
        }
    }
}
