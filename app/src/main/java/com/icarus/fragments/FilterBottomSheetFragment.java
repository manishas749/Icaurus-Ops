package com.icarus.fragments;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.icarus.R;
import com.icarus.constants.ChecklistTag;
import com.icarus.databinding.BottomSheetFilterBinding;
import com.icarus.models.StringCheckBox;
import com.icarus.viewmodels.DashboardViewModel;

import java.util.ArrayList;

/**
 * Created by Monika Rana on 12/28/2018.
 */

public class FilterBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private DashboardViewModel mDashboardViewModel;
    private BottomSheetFilterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_filter, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null)
            mDashboardViewModel = new ViewModelProvider(getActivity()).get(DashboardViewModel.class);
        binding.setViewModel(mDashboardViewModel);
        if (mDashboardViewModel.selectedCheckList.equalsIgnoreCase(ChecklistTag.ALL_CHECKLIST)) {
            //Hiding status list if selected all checklist
            binding.recyclerViewStatus.setVisibility(View.GONE);
            binding.txtStatus.setVisibility(View.GONE);
            binding.viewStatus.setVisibility(View.GONE);
            //Hiding  department list if selected all checklist
            binding.recyclerViewDepartment.setVisibility(View.GONE);
            binding.txtDepartment.setVisibility(View.GONE);
            binding.viewDepartment.setVisibility(View.GONE);
        } else if (mDashboardViewModel.selectedCheckList.equalsIgnoreCase(ChecklistTag.CANCELLED_CHECKLIST)
                || mDashboardViewModel.selectedCheckList.equalsIgnoreCase(ChecklistTag.COMPLETED_CHECKLIST)) {
            //Showing status list if selected all checklist
            binding.recyclerViewStatus.setVisibility(View.GONE);
            binding.txtStatus.setVisibility(View.GONE);
            binding.viewStatus.setVisibility(View.GONE);
            //Showing  department list if selected all checklist
            binding.recyclerViewUser.setVisibility(View.VISIBLE);
            binding.txtUser.setVisibility(View.VISIBLE);
            binding.viewUser.setVisibility(View.VISIBLE);
        } else if (mDashboardViewModel.selectedCheckList.equalsIgnoreCase(ChecklistTag.WORK_ORDER)) {
            //Type, Author, Priority filters to be shown
            binding.recyclerViewType.setVisibility(View.GONE);
            binding.txtType.setVisibility(View.GONE);
            binding.viewType.setVisibility(View.GONE);

            binding.recyclerViewStatus.setVisibility(View.VISIBLE);
            binding.txtStatus.setVisibility(View.VISIBLE);
            binding.viewStatus.setVisibility(View.VISIBLE);

            binding.recyclerViewAuthor.setVisibility(View.VISIBLE);
            binding.txtAuthor.setVisibility(View.VISIBLE);
            binding.viewAuthor.setVisibility(View.VISIBLE);

            binding.recyclerViewAssignedTo.setVisibility(View.VISIBLE);
            binding.txtAssignedTo.setVisibility(View.VISIBLE);
            binding.viewAssignedTo.setVisibility(View.VISIBLE);

            binding.recyclerViewPriority.setVisibility(View.VISIBLE);
            binding.txtPriority.setVisibility(View.VISIBLE);
            binding.viewPriority.setVisibility(View.VISIBLE);

            setAssignedToList(mDashboardViewModel.getAssignedToFilterList());
            binding.recyclerViewAssignedTo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int position) {
                    for (int i = 0; i < mDashboardViewModel.getAssignedToFilterList().size(); i++) {
                        mDashboardViewModel.getAssignedToFilterList().get(i).setSelected(i == position);
                    }

                }
            });
        } else {
            //Showing status list if selected all checklist
            binding.recyclerViewStatus.setVisibility(View.VISIBLE);
            binding.txtStatus.setVisibility(View.VISIBLE);
            binding.viewStatus.setVisibility(View.VISIBLE);
            //Showing  department list if selected all checklist
            binding.recyclerViewDepartment.setVisibility(View.VISIBLE);
            binding.txtDepartment.setVisibility(View.VISIBLE);
            binding.viewDepartment.setVisibility(View.VISIBLE);
        }
        binding.btnApply.setOnClickListener(this);
        binding.clearFilter.setOnClickListener(this);
    }

    private void setAssignedToList(ArrayList<StringCheckBox> sortList) {
        int position = 0;
        for (int i = 0; i < sortList.size(); i++) {
            AppCompatRadioButton radioButton = new AppCompatRadioButton(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int margin = (int) (5 * getResources().getDisplayMetrics().density);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ColorStateList colorStateList = new ColorStateList(
                        new int[][]{
                                new int[]{android.R.attr.state_enabled} //enabled
                        },
                        new int[]{getResources().getColor(R.color.radio_button_custom)}
                );

                radioButton.setButtonTintList(colorStateList);
            }
            params.setMargins(margin, margin, margin, margin);
            radioButton.setLayoutParams(params);
            radioButton.setText(sortList.get(i).getTitle());
            radioButton.setTag(sortList.get(i).getPosition());
            radioButton.setId(i);
            if (sortList.get(i).isSelected) {
                position = i;
            }
            radioButton.setTextColor(getResources().getColor(R.color.black));
            binding.recyclerViewAssignedTo.addView(radioButton);
        }
        ((RadioButton) binding.getRoot().findViewWithTag(position)).setChecked(true);
    }

    public static FilterBottomSheetFragment getInstance() {
        FilterBottomSheetFragment fag = new FilterBottomSheetFragment();
        Bundle bundle = new Bundle();
        fag.setArguments(bundle);
        return fag;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnApply:
                mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
                dismiss();
                break;

            case R.id.clearFilter:
                if (mDashboardViewModel.selectedCheckList.equalsIgnoreCase(ChecklistTag.WORK_ORDER)) {
                    setAssignedToList(mDashboardViewModel.getAssignedToFilterList());
                }
                mDashboardViewModel.onClearFilter();
                mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
                dismiss();
                break;
        }
    }
}
