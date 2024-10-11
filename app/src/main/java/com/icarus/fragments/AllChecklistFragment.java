package com.icarus.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.icarus.base.BaseApplication;
import com.icarus.base.ChecklistBaseFragment;
import com.icarus.constants.Constants;
import com.icarus.databinding.FragmentChecklistBinding;
import com.icarus.enums.ChecklistStatus;
import com.icarus.enums.ChecklistType;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.AllChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.UserItems;
import com.icarus.synchronization.workers.AssignedChecklistOnDemandWork;
import com.icarus.util.AppUtility;
import com.icarus.util.DialogUtility;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.DashboardViewModel;

import java.time.DateTimeException;
import java.util.List;

/**
 * Created by Monika Rana on 1/3/2019.
 */

public class AllChecklistFragment extends ChecklistBaseFragment<FragmentChecklistBinding, DashboardViewModel> {
    private FragmentChecklistBinding mBinding;
    private DashboardViewModel mDashboardViewModel;

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
        mBinding = getViewDataBinding();
        mDashboardViewModel = getViewModel();
        mDashboardViewModel.setNavigator(this);
        mBinding.recyclerView.setItemAnimator(null);
       /* if (mDashboardViewModel.getAllCheckListAdapter().getItemCount() == 0)
            mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
        else
            mDashboardViewModel.isChecklistEmpty.set(false);*/

        mDashboardViewModel.getTypeFilterList();

        mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());

        mBinding.emptyViewText2.setText(getString(R.string.empty_checklist_message));
    }


    @Override
    public void onAllChecklistClick(final AllChecklistItems item) {
        super.onAllChecklistClick(item);
        if (item != null) {
            if (item.getChecklistSyncStatus() == ChecklistStatus.NOT_SYNCHRONIZED) {
                DialogUtility.showAlertWithTwoButtonsOnly(getActivity(), getString(R.string.ask_sync_checklist), R.string.ok, R.string.cancel, new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        Data data = new Data.Builder()
                                .putString(AssignedChecklistOnDemandWork.ASSIGNED_CHECKLIST_UUID, "")
                                .putInt(AssignedChecklistOnDemandWork.CHECKLIST_ID, item.getChecklistId())
                                .putInt(AssignedChecklistOnDemandWork.ASSIGNED_SYNC_STATUS, Constants.EXECUTION_STATUS_SYNC_TO_SERVER)
                                .putInt(AssignedChecklistOnDemandWork.CHECKLIST_SYNC_STATUS, item.getSyncStatus())
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

                                                item.setSyncStatus(Constants.SYNC_STATUS_CHECKLIST_FULLY_SYNCED);

                                                onAllChecklistClick(item);
                                                mDashboardViewModel.setIsLoading(false);
                                            } else if (workStatus.getState() == WorkInfo.State.FAILED) {
                                                mDashboardViewModel.setIsLoading(false);
                                                Utilities.getInstance(getActivity()).showToast(getString(R.string.no_internet_connection), Toast.LENGTH_SHORT, getActivity());
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
            } else if (item.isApprovalRequired() == 1) {
            /*If the checklist requires execution approval (isApprovalRequired is 1),
            then when a user taps on the checklist show the message,
            This checklist requires execution approval. Please go to the web application and request for approval..*/
                if (getActivity() != null)
                    DialogUtility.showAlertWithCloseOnly(getActivity(), getString(R.string.approval_message), 0);
            } else if (item.isPlaceholderExists() == 1 && item.isApprovalRequired() != 1) {
           /* If the checklist has placeholders (isPlaceholderExists is 1), then when a user taps on the checklist show the message,
            This checklist contains pre-fill data capture. Please go to the web application to fill those prior to execution..*/
                if (getActivity() != null)
                    DialogUtility.showAlertWithCloseOnly(getActivity(), getString(R.string.no_approval_but_placeholder_message), 0);
            } else if (item.isAssignable() == 0 && item.isExecutable() == 0) {
            /*If a checklist cannot be assigned nor executed (isAssignable AND isExecutable are 0), then when a user taps on the checklist show the message,
            You are not allowed to start or assign this checklist as it {checklistStatusName}..*/
                if (getActivity() != null)
                    DialogUtility.showAlertWithCloseOnly(getActivity(),
                            String.format(getString(R.string.no_approval_no_placeholder_but_review_date_passed_with_status_message), item.getChecklistStatusName()), 0);
            } else if ((item.isAssignable() == 1 || item.isExecutable() == 1) && !TextUtils.isEmpty(item.getDueAt()) && AppUtility.Companion.compairTwoDates(AppUtility.Companion.getUtcTime(), item.getDueAt()) || item.getChecklistStatusIsExpired() == 1) {
            /*If a checklist can be assigned or executed (isAssignable OR isExecutable is 1) and if the due date of the checklist is in the past
              (dueAt < current UTC time) or if the status of the checklist is of type expired (checklistStatusIsExpired is 1), then on tapping on the
              checklist first display This checklist is past its review date. Are you sure you want to continue? along with Continue and Cancel
              buttons. Clicking on Continue would take the user to Start/Assign dialog whereas clicking on Cancel would take the user back to listing page.*/
                if (getActivity() != null)
                    DialogUtility.showAlertWithCloseContinueOnly(getActivity(), getString(R.string.not_approval_no_placeholder_but_review_date_passed_expired_message), 0, this, item,
                            getString(R.string.continue_string));
            } else if (item.isApprovalRequired() != 1 && item.isPlaceholderExists() != 1 && item.getChecklistStatusIsExpired() != 1
                    && (item.isAssignable() == 1 || item.isExecutable() == 1)) {
            /*If a checklist doesn't require approval, doesn't contain placeholders and is not expired and can be executed or assigned,
            then simply display the Start/Assign dialog. Please note, checklists of type of Emergency shall have only a Start button.*/
                if (item.getChecklistTypeId() == ChecklistType.Emergency.getValue()) {
                    if (getActivity() != null)
                        DialogUtility.showAlertForEmergencyStart(getActivity(), R.string.start_checklist_message, 0, this, item);
                } else {
                    if (getActivity() != null)
                        DialogUtility.showAlertWithStartAssign(getActivity(), getString(R.string.start_assign_checklist_message), 0, this, item);
                }
            } else {
                if (getActivity() != null)
                    DialogUtility.showAlertWithCloseOnly(getActivity(), getString(R.string.case_not_handled), 0);
            }
        }
    }

    @Override
    public void openStartChecklistDialog(AllChecklistItems item, int message) {
        super.openStartChecklistDialog(item, message);
        assign(item, getActivity(), message);
    }

    @Override
    public void openChecklistDetailScreen(int checklistId, String assignedChecklistUuid, String checklistTitle, int isSequential) {
        Navigator.launchActivityWithResult(getActivity(), Constants.REQUEST_RESULT_FOR_CANCELLED_COMPLETED, ChecklistDetailListingActivity.newChecklistDetailIntent(getActivity(), assignedChecklistUuid));
    }

    @Override
    public void assignChecklist(AllChecklistItems item) {
        super.assignChecklist(item);
        assign(item, getActivity(), R.string.assign_checklist);
    }

    @Override
    public void startChecklist(AllChecklistItems item) {
        super.startChecklist(item);
        assign(item, getActivity(), R.string.start_checklist);
    }

    @Override
    public <T> void continueChecklist(T item) {
        DialogUtility.showAlertWithStartAssign(getActivity(), getString(R.string.start_assign_checklist_message), 0, this, (AllChecklistItems) item);
    }

    @Override
    public void continueChecklist(List<UserItems> user, Integer checklistId, Integer departmentId,
                                  String checklistTitle, RoomAssetItems roomAsset, String dueDateString,
                                  boolean isStart, String uuid, int isSequential) {
        super.continueChecklist(user, checklistId, departmentId, checklistTitle, roomAsset, dueDateString, isStart, uuid, isSequential);
        String assignedChecklistUUID = AppUtility.Companion.getUuid();
        try {
            String dueDate = null;
            if (!TextUtils.isEmpty(dueDateString)) {
                dueDate = AppUtility.Companion.formatDueDate(dueDateString + " 23:59:59");
            }
            mDashboardViewModel.assignAllChecklist(assignedChecklistUUID, checklistId, departmentId,
                    BaseApplication.getPreferenceManager().getUserId(), dueDate, user, isStart, roomAsset);
            if (isStart)
                openChecklistDetailScreen(checklistId, assignedChecklistUUID, checklistTitle, isSequential);
        } catch (DateTimeException ex) {
            ex.printStackTrace();
            Utilities.getInstance(getActivity())
                    .showToast(getString(R.string.error_assigning_checklist),
                            Toast.LENGTH_SHORT, getActivity());
        }
    }

    @Override
    public void onStartObserving() {
        if (mDashboardViewModel != null && mDashboardViewModel.observeAllCheckList() != null)
            mDashboardViewModel.observeAllCheckList().observe(getViewLifecycleOwner(), new Observer<PagedList<AllChecklistItems>>() {
                @Override
                public void onChanged(@Nullable PagedList<AllChecklistItems> allChecklistItems) {
                    mDashboardViewModel.setIsLoading(false);
                    mDashboardViewModel.setAllCheckListInAdapter(allChecklistItems);
                }
            });


    }

    @Override
    public void removeObserverIfAny() {
        if (mDashboardViewModel != null && mDashboardViewModel.observeAllCheckList() != null && mDashboardViewModel.observeAllCheckList().hasObservers())
            mDashboardViewModel.observeAllCheckList().removeObservers(getViewLifecycleOwner());
    }


    private void assign(final AllChecklistItems item, final Context context, final int message) {
        if (item.getChecklistTypeId() == ChecklistType.Emergency.getValue()) {
            List<UserItems> userItems = mDashboardViewModel.getLoggedInUserItem();
            getRoomAssetList(item, userItems, context, message);
        } else
            mDashboardViewModel.observeUserList(item.getDepartmentId()).observe(getViewLifecycleOwner(), new Observer<List<UserItems>>() {
                @Override
                public void onChanged(@Nullable final List<UserItems> userItems) {
                    getRoomAssetList(item, userItems, context, message);

                }
            });
    }

    private void getRoomAssetList(final AllChecklistItems item, final List<UserItems> userItems, final Context context, final int message) {
        mDashboardViewModel.observeRoomAssetsList(item.getChecklistId()).observe(getViewLifecycleOwner(), new Observer<List<RoomAssetItems>>() {
            @Override
            public void onChanged(@Nullable List<RoomAssetItems> roomAssetItems) {
                DialogUtility.startChecklistDialog(context, message, AllChecklistFragment.this, item.getChecklistTypeId(), item.getChecklistId(), item.getDepartmentId(), item.getTitle(), roomAssetItems, userItems, item.getUuid(), item.isSequential());
            }
        });
    }
}
