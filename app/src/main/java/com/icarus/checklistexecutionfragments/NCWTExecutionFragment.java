package com.icarus.checklistexecutionfragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.icarus.BR;
import com.icarus.R;
import com.icarus.adapters.HazardsEquipmentAdapter;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentNcwtrExecutionBinding;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

/**
 * Created by Monika Rana on 1/23/2019.
 */


public class NCWTExecutionFragment extends BaseFragment<FragmentNcwtrExecutionBinding, ChecklistExecutionViewModel> implements View.OnClickListener {
    private FragmentNcwtrExecutionBinding binding;
    private ChecklistExecutionViewModel mViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ncwtr_execution;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Utilities.getInstance(getActivity()).showHideKeyboard(false, getActivity());
        binding = getViewDataBinding();
        mViewModel = getViewModel();
        binding.setItem(mViewModel.getChecklistElementDetail());
        mViewModel.getData(mViewModel.getChecklistElementDetail());
        binding.setViewModel(getViewModel());

        setFabIconOptions();

        binding.executePendingBindings();

        //Show hazard or e
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(binding.recyclerViewEquipments.getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.recyclerViewEquipments.setLayoutManager(layoutManager);
        if (mViewModel.getCheNcwHazardsItemsList() != null && mViewModel.getCheNcwHazardsItemsList().size() > 0)
            binding.recyclerViewEquipments.setAdapter(new HazardsEquipmentAdapter(getActivity(),
                    mViewModel.getCheNcwHazardsItemsList(), mViewModel.getCheNcwHazardsItemsList().size(),
                    mViewModel.getChecklistElementDetail().getItemUuid(), false));
        else
            binding.recyclerViewEquipments.setVisibility(View.GONE);

        binding.markComplete.setOnClickListener(this);
    }

    public void setFabIconOptions() {
        //Check if parent skipped or deferred and show icon
        if (mViewModel.getChecklistElementDetail().isSkipped()) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = false;
        } else if (mViewModel.getChecklistElementDetail().isDeferred()) {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = true;
        } else if (mViewModel.getChecklistElementDetail().isParentOfNCWSkipped()) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = false;
        } else if (mViewModel.getChecklistElementDetail().isParentOfNCWDeferred()) {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = true;
        } else if (!mViewModel.getChecklistElementDetail().checkElementIfExecuted()) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = true;
        } else {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = false;
        }

        mViewModel.isReferenceAvailable = (mViewModel.getChecklistElementDetail().isStepProcedureDataStep()) && getViewModel().isReference();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.markComplete:
                if (mViewModel.getChecklistElementDetail().getItemTypeId() == ChecklistElementType.WARNING.getValue() || mViewModel.getChecklistElementDetail().getItemTypeId() == ChecklistElementType.NOTE.getValue() || mViewModel.getChecklistElementDetail().getItemTypeId() == ChecklistElementType.CAUTION.getValue())
                    mViewModel.executeNCW(ChecklistExecutionStatus.ACKNOWLEDGE.getValue());
                else if (mViewModel.getChecklistElementDetail().getItemTypeId() == ChecklistElementType.TEXT.getValue())
                    mViewModel.executeImageText(LogTableActions.TEXT.getValue());

                mViewModel.setExecuted(true);
                mViewModel.fetchNextData(true);
                break;
        }
    }
}

