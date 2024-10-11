package com.icarus.checklistexecutionfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentDecisionExecutionBinding;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

/**
 * Created by Monika Rana on 1/24/2019.
 */

public class DecisionExecutionFragment extends BaseFragment<FragmentDecisionExecutionBinding, ChecklistExecutionViewModel> {
    private FragmentDecisionExecutionBinding binding;
    private ChecklistExecutionViewModel mViewModel;
    private Integer elementStatus;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_decision_execution;
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
        //binding.set
        binding.setViewModel(getViewModel());
        setFabIconOptions();
        binding.executePendingBindings();

        mViewModel.toolbarTitle.set(mViewModel.getChecklistElementDetail().getSequenceNo());
        elementStatus = mViewModel.getChecklistElementDetail().getDecisionStatus();

        // Disable progress bar of decision point if any child element of decision point is executed
        // in case of non-sequential checklist or any element after decision point is executed
        // in case of sequential checklists
        if (mViewModel.getSelectedTab() != 0)
            binding.seekBar.setEnabled(true);
        else {
            Integer elementId = mViewModel.getChecklistElementDetail().getElementId();
            Integer elementSortOrder = mViewModel.getChecklistElementDetail().getSortOrder();
            boolean isAnyElementAfterDecisionExecuted = mViewModel.isAnyDecisionChildExecuted(elementId, elementSortOrder);
            binding.seekBar.setEnabled(!isAnyElementAfterDecisionExecuted);
        }


        if (elementStatus != null) {
            if (mViewModel.getSelectedTab() == 0
                    && (elementStatus == ChecklistExecutionStatus.SKIPPED.getValue()
                    || elementStatus == ChecklistExecutionStatus.DEFERRED.getValue())) {
                binding.containerDecisionSeekbar.setVisibility(View.GONE);
                binding.btnSkipDefer.setVisibility(View.VISIBLE);
                if (elementStatus == ChecklistExecutionStatus.SKIPPED.getValue())
                    binding.btnSkipDefer.setText(getString(R.string.skipped));
                else
                    binding.btnSkipDefer.setText(getString(R.string.deferred));
            } else {
                int progress = 50;
                mViewModel.setExecuted(true);
                if (elementStatus == ChecklistExecutionStatus.NO.getValue()) {
                    progress = 0;
                } else if (elementStatus == ChecklistExecutionStatus.YES.getValue()) {
                    progress = 100;
                } else {
                    mViewModel.setExecuted(false);
                }
                binding.seekBar.setProgress(progress);
            }
        } else {
            mViewModel.setExecuted(false);
            binding.seekBar.setEnabled(true);
        }


        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                openNextStep(seekBar);
            }
        });
    }


    public void setFabIconOptions() {
        //Check if parent skipped or deferred and show icon
        if ((mViewModel.getChecklistElementDetail().isSkipped())) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = false;
        } else if ((mViewModel.getChecklistElementDetail().isDeferred())) {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = true;
        } else if (!mViewModel.getChecklistElementDetail().checkElementIfExecuted()) {
            mViewModel.isDeferAvailable = true;
            mViewModel.isSkipAvailable = true;
        } else {
            mViewModel.isDeferAvailable = false;
            mViewModel.isSkipAvailable = false;
        }

        mViewModel.isReferenceAvailable = false;
    }

    private void openNextStep(SeekBar seekBar) {
        int status = ChecklistExecutionStatus.NO.getValue();
        if (elementStatus != null) {
            if (seekBar.getProgress() <= 10 || seekBar.getProgress() >= 90) {
                if (seekBar.getProgress() < 50) {
                    seekBar.setProgress(0);
                    status = ChecklistExecutionStatus.NO.getValue();
                } else {
                    seekBar.setProgress(100);
                    mViewModel.setSelectedTab(0);
                    status = ChecklistExecutionStatus.YES.getValue();
                }

                if (status != elementStatus) {
                    mViewModel.executeDecisionPoints(status);
                    mViewModel.setExecuted(true);
                    mViewModel.fetchNextData(true);
                }
            } else {
                if (elementStatus == ChecklistExecutionStatus.NO.getValue())
                    seekBar.setProgress(0);
                else
                    seekBar.setProgress(100);
            }
        } else if (seekBar.getProgress() < 50 && seekBar.getProgress() > 10)
            seekBar.setProgress(50);
        else if (seekBar.getProgress() < 90 && seekBar.getProgress() > 50)
            seekBar.setProgress(50);
        else {
            if (seekBar.getProgress() == 0)
                status = ChecklistExecutionStatus.NO.getValue();
            else if (seekBar.getProgress() == 100) {
                mViewModel.setSelectedTab(0);
                status = ChecklistExecutionStatus.YES.getValue();
            }

            mViewModel.executeDecisionPoints(status);
            mViewModel.setExecuted(true);
            mViewModel.fetchNextData(true);
        }
    }

}

