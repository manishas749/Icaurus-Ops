package com.icarus.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.ChecklistExecutionActivity;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentChecklistDetailBinding;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnReason;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import com.icarus.navigators.ChecklistDetailNavigator;
import com.icarus.navigators.ChecklistListingNavigator;
import com.icarus.util.DialogUtility;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistDetailListingViewModel;

import java.util.ArrayList;

/**
 * Created by Monika Rana on 1/16/2019.
 */

public class ChecklistDetailListingFragment extends
        BaseFragment<FragmentChecklistDetailBinding, ChecklistDetailListingViewModel> implements ChecklistDetailNavigator {
    public static final String ASSIGNED_CHECKLIST_UUID = "ASSIGNED_CHECKLIST_UUID";
    public static final String CHECKLIST_ID = "CHECKLIST_ID";
    private static final String SELECTED_TAB = "SELECTED_TAB";
    private static final String IS_SEQUENTIAL = "is_sequential";
    private int selectedTab;
    private ChecklistListingNavigator checklistListingNavigator;
    private ChecklistDetailListingViewModel mChecklistDetailListingModel;
    private FragmentChecklistDetailBinding mBinding;
    private boolean isSequential;

    public static ChecklistDetailListingFragment getInstance(int tabPosition, int checklistId, String checklistUUID, boolean isSequential) {
        Bundle args = new Bundle();
        args.putInt(SELECTED_TAB, tabPosition);
        args.putInt(CHECKLIST_ID, checklistId);
        args.putString(ASSIGNED_CHECKLIST_UUID, checklistUUID);
        args.putBoolean(IS_SEQUENTIAL, isSequential);
        ChecklistDetailListingFragment fragment = new ChecklistDetailListingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setOnUpdateTabCountListener(ChecklistListingNavigator navigator) {
        checklistListingNavigator = navigator;
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_checklist_detail;
    }

    @Override
    public ChecklistDetailListingViewModel getViewModel() {
        return mChecklistDetailListingModel = new ViewModelProvider(this).get(ChecklistDetailListingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChecklistDetailListingModel.setNavigator(this);
        mBinding = getViewDataBinding();

        String assignedChecklistUuid = getArguments().getString(ASSIGNED_CHECKLIST_UUID, "");
        int checklistId = getArguments().getInt(CHECKLIST_ID);
        selectedTab = getArguments().getInt(SELECTED_TAB);
        isSequential = getArguments().getBoolean(IS_SEQUENTIAL, false);

        mChecklistDetailListingModel.setData(assignedChecklistUuid, checklistId, selectedTab, isSequential);
        mChecklistDetailListingModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<PagedList<ChecklistElementItem>>() {
            @Override
            public void onChanged(@Nullable PagedList<ChecklistElementItem> checklistDetailItems) {
                //Update checklist element list items
                mChecklistDetailListingModel.getAdapter().submitList(checklistDetailItems);

                //Shows list or no elements text if element list is empty
                if (checklistDetailItems == null || checklistDetailItems.size() == 0) {
                    mChecklistDetailListingModel.isNoElements.set(true);
                } else
                    mChecklistDetailListingModel.isNoElements.set(false);

                //Update Skip and deffer count on tabs
                if (selectedTab == 1 && checklistListingNavigator != null)
                    checklistListingNavigator.updateSkippedElementCount(
                            checklistDetailItems == null ||
                                    checklistDetailItems.size() == 0 ? 0 : checklistDetailItems.size());
                else if (selectedTab == 2 && checklistListingNavigator != null)
                    checklistListingNavigator.updateDeferredElementCount(
                            checklistDetailItems == null || checklistDetailItems.size() == 0 ?
                                    0 : checklistDetailItems.size());

                //Scrolls checklist to last executed element if checklist is resumed
                if (selectedTab == 0 && checklistDetailItems != null)
                    mBinding.recyclerViewChecklist.scrollToPosition(mChecklistDetailListingModel.
                            getLastExecutedPosition(checklistDetailItems));
            }
        });
    }


    @Override
    public void openChecklistExecution(int checklistId, String checklistUUID, int position, String checklistTitle) {
        Navigator.launchActivity(getActivity(), ChecklistExecutionActivity.getIntent(getActivity(), checklistId, checklistUUID, position, selectedTab, isSequential));
    }

    @Override
    public void showSkipDeffer(final ArrayList<ChecklistElementItem> checklistDetailItems, boolean isSkipDefer) {
        //Ask user to skip or deffer pending elements if the list is sequential

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        if (isSkipDefer)
            dialog.setTitle(R.string.ask_skip_deffer_element_list);
        else
            dialog.setTitle(R.string.cannot_skip_sequential_list);


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(Utilities.getChecklistTitleList(checklistDetailItems));
        dialog.setAdapter(arrayAdapter, null);
        if (isSkipDefer)
            dialog.setNegativeButton(getString(R.string.skip), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DialogUtility.getReasonPopup(getActivity(), getString(R.string.skip_checklist),
                            String.format(getString(R.string.give_a_resaon_percentage_skip_defer), getString(R.string.skip).toLowerCase()), new OnReason() {
                                @Override
                                public void onContinue(String reason, Context context) {
                                    getViewModel().executeSkipDeffer(checklistDetailItems, ChecklistExecutionStatus.SKIPPED, LogTableActions.SKIPPED, reason);
                                }

                                @Override
                                public void onCancel() {

                                }
                            }, getString(R.string.skip).length(), mChecklistDetailListingModel.getReasonPopUpViewModel());

                    dialog.dismiss();
                }
            });

        if (isSkipDefer)
            dialog.setPositiveButton(getString(R.string.defer), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DialogUtility.getReasonPopup(getActivity(), getString(R.string.deffer_checklist),
                            String.format(getString(R.string.give_a_resaon_percentage_skip_defer), getString(R.string.defer).toLowerCase()), new OnReason() {
                                @Override
                                public void onContinue(String reason, Context context) {
                                    getViewModel().executeSkipDeffer(checklistDetailItems, ChecklistExecutionStatus.DEFERRED, LogTableActions.DEFERRED, reason);
                                }

                                @Override
                                public void onCancel() {

                                }
                            }, getString(R.string.defer).length(), mChecklistDetailListingModel.getReasonPopUpViewModel());
                    dialog.dismiss();
                }
            });

        dialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (isSkipDefer)
            dialog.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        else
            dialog.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

        AlertDialog alertDialog = dialog.create();
        // Display the alert dialog on interface
        alertDialog.show();

    }

    @Override
    public void openDeferredTab(ChecklistElementItem item) {
        checklistListingNavigator.openDeferredTab();
    }

    @Override
    public void openSkippedTab(ChecklistElementItem item) {
        checklistListingNavigator.openSkippedTab();
    }

}
