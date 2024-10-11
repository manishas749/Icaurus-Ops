package com.icarus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.icarus.R;
import com.icarus.databinding.BottomSheetSortBinding;
import com.icarus.models.SortChecklistBy;
import com.icarus.viewmodels.DashboardViewModel;

import java.util.ArrayList;

/**
 * Created by Monika Rana on 12/28/2018.
 */

public class SortBottomSheetFragment extends BottomSheetDialogFragment {
    private DashboardViewModel mDashboardViewModel;
    private BottomSheetSortBinding mBinding;


    public static SortBottomSheetFragment getInstance() {
        SortBottomSheetFragment fag = new SortBottomSheetFragment();
        Bundle bundle = new Bundle();
        fag.setArguments(bundle);
        return fag;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null)
            mDashboardViewModel = new ViewModelProvider(getActivity()).get(DashboardViewModel.class);
        setSortingList(mDashboardViewModel.getSortList());
        mBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                // mDashboardViewModel.selectedSortRadioButtonId = radioGroup.getCheckedRadioButtonId();
                mDashboardViewModel.sortChecklistBy.setName(mDashboardViewModel.getSortList().get(position).getName());
                mDashboardViewModel.sortChecklistBy.setTag(mDashboardViewModel.getSortList().get(position).getTag());
                mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
                dismiss();
            }
        });
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_sort, container, false);
        return mBinding.getRoot();
    }

    private void setSortingList(ArrayList<SortChecklistBy> sortList) {
        for (int i = 0; i < sortList.size(); i++) {
            RadioButton radioButton = new RadioButton(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int margin = (int) (5 * getResources().getDisplayMetrics().density);
            params.setMargins(margin, margin, margin, margin);
            radioButton.setLayoutParams(params);
            radioButton.setBackgroundResource(R.drawable.radio_background);
            radioButton.setText(sortList.get(i).getName());
            radioButton.setTag(sortList.get(i).getTag());
            radioButton.setId(i);
            radioButton.setTextColor(getResources().getColor(R.color.black));
            mBinding.radioGroup.addView(radioButton);
        }
        ((RadioButton) mBinding.getRoot().findViewWithTag(mDashboardViewModel.sortChecklistBy.getTag())).setChecked(true);

    }

}
