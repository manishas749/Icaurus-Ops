package com.icarus.checklistexecutionfragments;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentEmbeddedImageBinding;
import com.icarus.enums.LogTableActions;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

/**
 * Created by Monika Rana on 09/04/2020
 */
public class EmbeddedImageFragment extends BaseFragment<FragmentEmbeddedImageBinding, ChecklistExecutionViewModel> implements View.OnClickListener {
    private FragmentEmbeddedImageBinding binding;
    private ChecklistExecutionViewModel mViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_embedded_image;
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

        binding.markComplete.setOnClickListener(this);
    }

    public void setFabIconOptions() {
        //Check if parent skipped or deferred and show icon
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
                mViewModel.executeImageText(LogTableActions.IMAGE.getValue());
                mViewModel.setExecuted(true);
                mViewModel.fetchNextData(true);
                break;
        }
    }
}


