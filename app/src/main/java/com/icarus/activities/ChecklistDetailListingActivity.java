package com.icarus.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.adapters.ChecklistDetailPagerAdapter;
import com.icarus.adapters.PPEListAdapter;
import com.icarus.adapters.PendingElementsAdapter;
import com.icarus.base.BaseActivity;
import com.icarus.databinding.ActivityChecklistDetailListingBinding;
import com.icarus.databinding.PopupListBinding;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.fragments.ChecklistDetailListingFragment;
import com.icarus.listeners.OnAssignUserChecklist;
import com.icarus.listeners.OnReason;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.CheckListPPItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.FragmentsModel;
import com.icarus.models.UserItems;
import com.icarus.navigators.ChecklistListingNavigator;
import com.icarus.util.AppUtility;
import com.icarus.util.DialogUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistDetailViewModel;
import com.icarus.workorder.activities.WorkOrderCreateActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import c.anurag.cropannotate.annotations.activity.PhotoEditorActivity;
import c.anurag.cropannotate.crop.CropImage;
import c.anurag.database.util.CommonFunctions;

/**
 * Created by Anurag Purwar on 29/12/18.
 */
public class ChecklistDetailListingActivity extends BaseActivity<ActivityChecklistDetailListingBinding, ChecklistDetailViewModel> implements ChecklistListingNavigator {

    public static final String ASSIGNED_CHECKLIST_UUID = "assigned_checklist_uuid";
    public static final String IS_CHECKLIST_CANCELLED = "is_checklist_cancelled";
    public static final String IS_CHECKLIST_COMPLETED = "is_checklist_completed";
    private ChecklistDetailViewModel mChecklistDetailViewModel;
    private ActivityChecklistDetailListingBinding mBinding;
    private String checklistUUID;
    private String checklistTitle;
    private int checklistId;
    private boolean isSequential;
    private List<FragmentsModel> fragmentsModels = new ArrayList<>();
    private AlertDialog pendingElementDialog;

    public static Intent newChecklistDetailIntent(Context context, String assignedChecklistUuid) {
        return new Intent(context, ChecklistDetailListingActivity.class)
                .putExtra(ChecklistDetailListingActivity.ASSIGNED_CHECKLIST_UUID, assignedChecklistUuid);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public ChecklistDetailViewModel getViewModel() {
        return mChecklistDetailViewModel = new ViewModelProvider(this).get(ChecklistDetailViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_checklist_detail_listing;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mChecklistDetailViewModel = getViewModel();
        mChecklistDetailViewModel.setNavigator(this);
        setSupportActionBar(mBinding.toolbar);

        mBinding.progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.progress), PorterDuff.Mode.SRC_IN);

        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        checklistUUID = getIntent().getStringExtra(ASSIGNED_CHECKLIST_UUID);
        mChecklistDetailViewModel.init(checklistUUID);

        checklistTitle = mChecklistDetailViewModel.getChecklistDetailItem().getTitle();
        checklistId = mChecklistDetailViewModel.getChecklistDetailItem().getChecklistId();
        isSequential = mChecklistDetailViewModel.getChecklistDetailItem().isSequential();


        String[] statusArray = getResources().getStringArray(R.array.detail_tab);

        for (int i = 0; i < statusArray.length; i++) {
            mBinding.tabs.addTab(mBinding.tabs.newTab().setText(statusArray[i]));
            ChecklistDetailListingFragment detailFragment = ChecklistDetailListingFragment.getInstance(i, checklistId, checklistUUID, isSequential);
            detailFragment.setOnUpdateTabCountListener(this);
            fragmentsModels.add(new FragmentsModel(detailFragment, statusArray[i]));
        }

        ChecklistDetailPagerAdapter adapter = new ChecklistDetailPagerAdapter(getSupportFragmentManager(), fragmentsModels);
        mBinding.container.setAdapter(adapter);
        mBinding.toolbartitle.setText(checklistTitle);
        mBinding.tabs.setupWithViewPager(mBinding.container);
        mBinding.container.setOffscreenPageLimit(2);

        mChecklistDetailViewModel.setChecklistUUID(checklistUUID);
        mChecklistDetailViewModel.getTotalChecklistCount();
        mChecklistDetailViewModel.getInformationPopup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_checklist_detail, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DialogUtility.getReasonPopup(ChecklistDetailListingActivity.this, getString(R.string.pause_checklist),
                String.format(getString(R.string.give_a_resaon_percentage), getString(R.string.pause)), pauseListener, getString(R.string.pause).length(), mChecklistDetailViewModel.getReasonPopUpViewModel());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.pause_checklist:
                DialogUtility.getReasonPopup(ChecklistDetailListingActivity.this, getString(R.string.pause_checklist),
                        String.format(getString(R.string.give_a_resaon_percentage), getString(R.string.pause)), pauseListener, getString(R.string.pause).length(), mChecklistDetailViewModel.getReasonPopUpViewModel());
                break;

            case R.id.suggestion:
                mChecklistDetailViewModel.setGalleryViewModel(null);
                DialogUtility.getSuggestionPopup(ChecklistDetailListingActivity.this, mChecklistDetailViewModel.getGalleryViewModel(), suggestionListener);
                break;

            case R.id.action_emergency:
                mChecklistDetailViewModel.pauseChecklist(getString(R.string.emergency_pause_reason));
                Intent intent = new Intent(ChecklistDetailListingActivity.this, DashboardActivity.class);
                intent.putExtra(DashboardActivity.IS_FILTER_EMERGENCY, true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Navigator.launchActivityAndFinishCurrent(ChecklistDetailListingActivity.this, intent);
                break;

            case R.id.cancel_checklist:
                DialogUtility.getReasonPopup(ChecklistDetailListingActivity.this, getString(R.string.cancel_checklist),
                        String.format(getString(R.string.give_a_resaon_percentage), getString(R.string.cancel).toLowerCase()), cancelListener, getString(R.string.cancel).length(), mChecklistDetailViewModel.getReasonPopUpViewModel());
                break;

            case R.id.workorder:
                Navigator.launchActivity(this, WorkOrderCreateActivity.getInstance(this, checklistTitle, checklistId, mChecklistDetailViewModel.getChecklistDetailItem().getRoomId(), mChecklistDetailViewModel.getChecklistDetailItem().getEquipmentId()));
                break;

            case R.id.assign:
                final List<UserItems> userItems = mChecklistDetailViewModel.getUserList();

                if (userItems.size() > 0) {
                    DialogUtility.showAssignChecklistDialog(userItems, ChecklistDetailListingActivity.this, new OnAssignUserChecklist() {
                        @Override
                        public void assignUserChecklist(List<UserItems> userItemsList) {
                            userItems.clear();
                            userItems.addAll(userItemsList);
                            mChecklistDetailViewModel.assignChecklistUsers(userItemsList);
                        }

                        @Override
                        public void cancelAssign() {

                        }
                    });
                } else {
                    DialogUtility.showAlertWithCloseOnly(ChecklistDetailListingActivity.this, getString(R.string.no_users_department), R.string.assign);
                }
                break;

            case R.id.view_report:
                Navigator.launchActivity(this, ChecklistReportActivity.getIntent(this, checklistId, checklistUUID));
                break;


            case R.id.all_capture_data:
                Navigator.launchActivity(this, AllCaptureDataActivity.getIntent(this, checklistId, checklistUUID));
                break;

            case R.id.pending_elements:
                mChecklistDetailViewModel.setIsLoading(true);
                mChecklistDetailViewModel.getChecklistDetailPendingElements();
                final PendingElementsAdapter adapter = new PendingElementsAdapter(mChecklistDetailViewModel);
                mChecklistDetailViewModel.getPendingElementsLiveData().observe(this, new Observer<PagedList<ChecklistDetailItems>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<ChecklistDetailItems> checklistDetailItems) {
                        mChecklistDetailViewModel.setIsLoading(false);
                        adapter.submitList(checklistDetailItems);
                        mChecklistDetailViewModel.getPendingElementsLiveData().removeObservers(ChecklistDetailListingActivity.this);
                        if (checklistDetailItems != null && checklistDetailItems.size() > 0)
                            showPendingListPopUp(ChecklistDetailListingActivity.this, adapter);
                        else
                            Utilities.getInstance(ChecklistDetailListingActivity.this).showToast(getString(R.string.no_pending_element), Toast.LENGTH_LONG, ChecklistDetailListingActivity.this);
                    }
                });

                break;

            case R.id.notes:
                Navigator.launchActivity(this, AddNotesActivity.getIntent(this, checklistUUID, checklistId, null));
                break;

        }
        return super.onOptionsItemSelected(item);

    }

    OnReason pauseListener = new OnReason() {
        @Override
        public void onContinue(String reason, Context context) {
            mChecklistDetailViewModel.pauseChecklist(reason);
            finish();
        }

        @Override
        public void onCancel() {

        }

    };


    OnReason cancelListener = new OnReason() {
        @Override
        public void onContinue(String reason, Context context) {
            mChecklistDetailViewModel.cancelChecklist(reason);
            Intent result = new Intent();
            result.putExtra(IS_CHECKLIST_CANCELLED, true);
            setResult(RESULT_OK, result);
            finish();
        }

        @Override
        public void onCancel() {

        }
    };

    OnReason suggestionListener = new OnReason() {
        @Override
        public void onContinue(String reason, Context context) {
            mChecklistDetailViewModel.addSuggestion(reason, mChecklistDetailViewModel.getGalleryViewModel().getListAttachment());
        }

        @Override
        public void onCancel() {

        }
    };


    @Override
    public void observeTotalCount() {
        mChecklistDetailViewModel.getTotalCountLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                if (mChecklistDetailViewModel.getCompletedCountLiveData() == null)
                    mChecklistDetailViewModel.getCompletedChecklistCount();
                if (value != null) {
                    mChecklistDetailViewModel.totalCount.set(String.valueOf(value));
                } else
                    mChecklistDetailViewModel.totalCount.set("0");
            }
        });
    }

    @Override
    public void observeCompletedCount() {
        mChecklistDetailViewModel.getCompletedCountLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                if (value != null) {
                    mChecklistDetailViewModel.completeCount.set(String.valueOf(value));
                    if (mChecklistDetailViewModel.getTotalCountForMarkComplete().equals(value)) {
                        mChecklistDetailViewModel.enableMarkComplete.set(true);
                        openMarkCompletePopup();
                    } else
                        mChecklistDetailViewModel.enableMarkComplete.set(false);
                } else
                    mChecklistDetailViewModel.completeCount.set("0");
            }
        });
    }

    @Override
    public void checklistCompleted() {
        Intent result = new Intent();
        result.putExtra(IS_CHECKLIST_COMPLETED, true);
        setResult(RESULT_OK, result);
        finish();
    }

    @Override
    public void showInformationPopUp(List<CheckListPPItems> checkListPPForInformationPopUp) {
        if (checkListPPForInformationPopUp != null && checkListPPForInformationPopUp.size() > 0)
            DialogUtility.showListPopUp(ChecklistDetailListingActivity.this, R.string.information, R.string.information_popup_msg, new PPEListAdapter(ChecklistDetailListingActivity.this, checkListPPForInformationPopUp, checkListPPForInformationPopUp.size(), "", true));
    }

    @Override
    public void updateSkippedElementCount(int count) {
        mBinding.tabs.getTabAt(1).setText(String.format(getResources().getString(R.string.skipped_count), String.valueOf(count)));
    }

    @Override
    public void updateDeferredElementCount(int count) {
        mBinding.tabs.getTabAt(2).setText(String.format(getResources().getString(R.string.deferred_count), String.valueOf(count)));
    }

    @Override
    public void showElement(int position, ChecklistDetailItems item, int selectedTab) {
        if (pendingElementDialog != null)
            pendingElementDialog.dismiss();

        Navigator.launchActivity(ChecklistDetailListingActivity.this, ChecklistExecutionActivity.getIntent(ChecklistDetailListingActivity.this, checklistId, checklistUUID, position, selectedTab, isSequential));
    }

    @Override
    public void showSkipDeffer(final ArrayList<ChecklistElementItem> checklistDetailItems, boolean isSkipDefer) {
        //Ask user to skip or deffer pending elements if the list is sequential

        AlertDialog.Builder dialog = new AlertDialog.Builder(ChecklistDetailListingActivity.this);
        if (isSkipDefer)
            dialog.setTitle(R.string.ask_skip_deffer_element_list);
        else
            dialog.setTitle(R.string.cannot_skip_sequential_list);


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ChecklistDetailListingActivity.this, android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(Utilities.getChecklistTitleList(checklistDetailItems));
        dialog.setAdapter(arrayAdapter, null);
        if (isSkipDefer)
            dialog.setNegativeButton(getString(R.string.skip), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DialogUtility.getReasonPopup(ChecklistDetailListingActivity.this, getString(R.string.skip_checklist),
                            String.format(getString(R.string.give_a_resaon_percentage_skip_defer), getString(R.string.skip).toLowerCase()), new OnReason() {
                                @Override
                                public void onContinue(String reason, Context context) {
                                    pendingElementDialog.dismiss();
                                    getViewModel().executeSkipDeffer(checklistDetailItems, ChecklistExecutionStatus.SKIPPED, LogTableActions.SKIPPED, reason);
                                    openSkippedTab();
                                }

                                @Override
                                public void onCancel() {

                                }
                            }, getString(R.string.skip).length(), mChecklistDetailViewModel.getReasonPopUpViewModel());


                    dialog.dismiss();
                }
            });

        if (isSkipDefer)
            dialog.setPositiveButton(getString(R.string.defer), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    DialogUtility.getReasonPopup(ChecklistDetailListingActivity.this, getString(R.string.deffer_checklist),
                            String.format(getString(R.string.give_a_resaon_percentage_skip_defer), getString(R.string.defer).toLowerCase()), new OnReason() {
                                @Override
                                public void onContinue(String reason, Context context) {
                                    pendingElementDialog.dismiss();
                                    getViewModel().executeSkipDeffer(checklistDetailItems, ChecklistExecutionStatus.DEFERRED, LogTableActions.DEFERRED, reason);
                                    openDeferredTab();
                                }

                                @Override
                                public void onCancel() {

                                }
                            }, getString(R.string.defer).length(), mChecklistDetailViewModel.getReasonPopUpViewModel());

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

        AlertDialog mAlertDialog = dialog.create();
        // Display the alert dialog on interface
        mAlertDialog.show();


    }

    @Override
    public void openDeferredTab() {
        mBinding.tabs.getTabAt(2).select();
    }

    @Override
    public void openSkippedTab() {
        mBinding.tabs.getTabAt(1).select();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case PhotoEditorActivity.REQUEST_CROP_IMAGE:
                if (null != data) {
                    String path = data.getStringExtra(PhotoEditorActivity.IMAGE_PATH);
                    mChecklistDetailViewModel.getGalleryViewModel().displayImage(path);
                }
                break;

            case CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE:
                if (data != null && data.getData() != null) {
                    File directory = FileUtils.getSuggestionAttachmentsDir();
                    if (directory != null)
                        startActivityForResult(PhotoEditorActivity.newIntent(this,
                                data.getData(),
                                directory,
                                AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                    else
                        CommonFunctions.showToast(getString(R.string.file_create_error));
                }
                break;

            case CropImage.CLICK_IMAGE_CAMERA_REQUEST_CODE:
                File directory = FileUtils.getSuggestionAttachmentsDir();
                if (directory != null)
                    startActivityForResult(PhotoEditorActivity.newIntent(this,
                            mChecklistDetailViewModel.getGalleryViewModel().getPhotoPathUri(),
                            directory,
                            AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                else
                    CommonFunctions.showToast(getString(R.string.file_create_error));
                break;

        }
    }


    private void showPendingListPopUp(final Context context, RecyclerView.Adapter<?> adapter) {
        //Inflate the dialog with custom view
        PopupListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_list, null, false);
        //AlertDialogBuilder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot())
                .setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        mBuilder.setCancelable(false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL);
        binding.recyclerViewImages.addItemDecoration(dividerItemDecoration);
        binding.recyclerViewImages.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerViewImages.setAdapter(adapter);
        binding.tvTitle.setText(R.string.pending_elements);
        binding.tvDesc.setVisibility(View.GONE);
        pendingElementDialog = mBuilder.create();
        pendingElementDialog.show();
    }

    private void openMarkCompletePopup() {
        if (!mChecklistDetailViewModel.isMarkCompletePopupVisible())
            DialogUtility.showAlertWithTwoButtonsOnly(ChecklistDetailListingActivity.this, getString(R.string.ask_mark_complete), R.string.mark_complete, R.string.cancel, new OnSelectListener() {
                @Override
                public void onPositiveButtonClick() {
                    mChecklistDetailViewModel.setMarkCompletePopupVisible(false);
                    mChecklistDetailViewModel.completeChecklist();
                }

                @Override
                public void onNegativeButtonClick() {
                    mChecklistDetailViewModel.setMarkCompletePopupVisible(false);
                }
            });
        mChecklistDetailViewModel.setMarkCompletePopupVisible(true);
    }
}
