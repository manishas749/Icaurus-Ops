package com.icarus.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.checklistexecutionfragments.DecisionExecutionFragment;
import com.icarus.checklistexecutionfragments.EmbeddedImageFragment;
import com.icarus.checklistexecutionfragments.NCWTExecutionFragment;
import com.icarus.checklistexecutionfragments.QRCodeVerifyFragment;
import com.icarus.checklistexecutionfragments.QRCodeVerifyManualFragment;
import com.icarus.checklistexecutionfragments.SPFragment;
import com.icarus.constants.Constants;
import com.icarus.databinding.ActivityChecklistExecutionBinding;
import com.icarus.entities.ResourceEntity;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.listeners.OnReason;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ResourceLinkItems;
import com.icarus.models.SelectedFile;
import com.icarus.navigators.ChecklistExecutionNavigator;
import com.icarus.util.AppUtility;
import com.icarus.util.ContentType;
import com.icarus.util.DialogUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.ImageLoader;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.util.ViewAnimation;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import java.io.File;
import java.util.List;

import c.anurag.cropannotate.annotations.activity.PhotoEditorActivity;
import c.anurag.cropannotate.crop.CropImage;
import c.anurag.database.util.CommonFunctions;

/**
 * Created by Monika Rana on 1/23/2019.
 */

public class ChecklistExecutionActivity extends BaseActivity<ActivityChecklistExecutionBinding,
        ChecklistExecutionViewModel> implements ChecklistExecutionNavigator {

    private static final String SELECTED_TAB = "selected_tab";
    private ActivityChecklistExecutionBinding binding;
    private ChecklistExecutionViewModel mViewModel;
    public static final String CHECKLIST_ID = "CHECKLIST_ID";
    public static final String CHECKLIST_UUID = "CHECKLIST_UUID";
    public static final String SORT_ORDER = "SORT_ORDER";
    public static final String ATTRIBUTE_POSITION = "ATTRIBUTE_POSITION";
    public static final String IS_SEQUENTIAL = "IS_SEQUENTIAL";
    private AlertDialog alertDialog;
    private ProgressDialog progressDialog;
    private String checklistUuid;
    private int checklistId;
    private boolean isSkipDialogOpen, isDeferDialogOpen, isSuggestionDialogOpen, isDownloadingFile,
            isReferenceDialogOpen;

    public static Intent getIntent(Context context, int checklistId, String checklistUUID, int position,
                                   int selectedTab, boolean isSequential) {
        return new Intent(context, ChecklistExecutionActivity.class)
                .putExtra(ChecklistExecutionActivity.SORT_ORDER, position)
                .putExtra(ChecklistExecutionActivity.CHECKLIST_ID, checklistId)
                .putExtra(ChecklistExecutionActivity.CHECKLIST_UUID, checklistUUID)
                .putExtra(ChecklistExecutionActivity.SELECTED_TAB, selectedTab)
                .putExtra(ChecklistExecutionActivity.IS_SEQUENTIAL, isSequential);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_checklist_execution;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return new ViewModelProvider(this).get(ChecklistExecutionViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        mViewModel = getViewModel();

        //On orientation change if download in progress show download dialog
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isSkipDialogOpen", false))
                skip();
            if (savedInstanceState.getBoolean("isDeferDialogOpen", false))
                defer();
            if (savedInstanceState.getBoolean("isSuggestionDialogOpen", false))
                addSuggestion();
            if (savedInstanceState.getBoolean("isReferenceDialogOpen", false))
                mViewModel.showReference();

            openMenu(mViewModel.isOpen);
        }

        mViewModel.setNavigator(this);
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setNavigationIcon(R.mipmap.close_element_cross);

        int position = getIntent().getExtras().getInt(ChecklistExecutionActivity.SORT_ORDER);
        checklistId = getIntent().getExtras().getInt(ChecklistExecutionActivity.CHECKLIST_ID);
        int selectedTab = getIntent().getExtras().getInt(ChecklistExecutionActivity.SELECTED_TAB);
        checklistUuid = getIntent().getExtras().getString(ChecklistExecutionActivity.CHECKLIST_UUID);
        boolean isSequential = getIntent().getExtras().getBoolean(ChecklistExecutionActivity.IS_SEQUENTIAL, false);

        mViewModel.setSequential(isSequential);

        //If orientation changed, prevent add fragment as already added
        if (savedInstanceState == null)
            mViewModel.fetchData(position, checklistId, checklistUuid, selectedTab);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isDownloadingFile", isDownloadingFile);
        outState.putBoolean("isReferenceDialogOpen", isReferenceDialogOpen);
        outState.putBoolean("isSkipDialogOpen", isSkipDialogOpen);
        outState.putBoolean("isDeferDialogOpen", isDeferDialogOpen);
        outState.putBoolean("isSuggestionDialogOpen", isSuggestionDialogOpen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_checklist_execution, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.action_emergency:
                mViewModel.pauseChecklist(getString(R.string.emergency_pause_reason));
                Intent intent = new Intent(ChecklistExecutionActivity.this, DashboardActivity.class);
                intent.putExtra(DashboardActivity.IS_FILTER_EMERGENCY, true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Navigator.launchActivityAndFinishCurrent(ChecklistExecutionActivity.this, intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openNCWExecution(boolean isNext) {
        if (isNext)
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnim(R.id.frame_layout,
                    new NCWTExecutionFragment(), NCWTExecutionFragment.class.getSimpleName(), false,
                    ChecklistExecutionActivity.this);
        else
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnimPrevious(R.id.frame_layout,
                    new NCWTExecutionFragment(), NCWTExecutionFragment.class.getSimpleName(),
                    false, ChecklistExecutionActivity.this);
    }

    @Override
    public void showReferenceDialog(List<ResourceEntity> resourceList, List<ResourceLinkItems> resourceLinkList,
                                    ChecklistExecutionNavigator navigator) {
        isReferenceDialogOpen = true;
        alertDialog = DialogUtility.showReferencePopUp(this, resourceList, resourceLinkList, navigator);
    }

    @Override
    public void openReferenceFile(ResourceEntity entity) {
        isReferenceDialogOpen = false;
        if (alertDialog != null)
            alertDialog.cancel();
        onReferenceClicked(entity);
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        Utilities.getInstance(ChecklistExecutionActivity.this).showToast(errorMsg, Toast.LENGTH_LONG,
                ChecklistExecutionActivity.this);
    }

    @Override
    public void openResource(final ChecklistDetailItems detailItems) {
        if (alertDialog != null)
            alertDialog.cancel();
        onResourceClicked(detailItems, false);
    }

    @Override
    public void openEmbeddedImage(ChecklistDetailItems detailItem) {
        if (alertDialog != null)
            alertDialog.cancel();
        onResourceClicked(detailItem, true);
    }

    @Override
    public void openAttachFile(final SelectedFile detailItems) {
        if (alertDialog != null)
            alertDialog.cancel();
        onAttachFileClicked(detailItems);
    }

    private void onResourceClicked(final ChecklistDetailItems detailItems, final boolean markViewed) {
        final File file = FileUtils.getFileFromName(detailItems.getFileName(), Constants.RESOURCES);
        if (FileUtils.isFileExist(file.getPath())) {
            Utilities.getInstance(this).openFile(detailItems.getFileName(), ContentType.IMAGE_JPG,
                    ChecklistExecutionActivity.this);
        } else
            DialogUtility.showAlertWithTwoButtonsOnly(ChecklistExecutionActivity.this,
                    getString(R.string.ask_image_download), R.string.ok, R.string.cancel, new OnSelectListener() {
                        @Override
                        public void onPositiveButtonClick() {
                            showProgressBar();
                            isDownloadingFile = true;
                            BaseApplication.getImageLoader().loadImage(file, ImageLoader.ImageType.Resource,
                                    detailItems.getItemUuid(), detailItems.getTitle(), new OnDownloadListener() {
                                        @Override
                                        public void onSuccess() {
                                            isDownloadingFile = false;
                                            hideProgressBar();
                                            if (markViewed) {
                                                mViewModel.executeImage(detailItems.getElementId(), detailItems.getItemUuid(),
                                                        detailItems.getDescription());
                                                detailItems.setImageTextStatus(LogTableActions.IMAGE.getValue());
                                            }
                                            Utilities.getInstance(ChecklistExecutionActivity.this).openFile(detailItems.getFileName(),
                                                    ContentType.IMAGE_JPG, ChecklistExecutionActivity.this);
                                        }

                                        @Override
                                        public void onFailed() {
                                            isDownloadingFile = false;
                                            hideProgressBar();
                                            runOnUiThread(new Runnable() {
                                                public void run() {
                                                    CommonFunctions.showToast(getString(R.string.error_downloading_file));
                                                }
                                            });
                                        }

                                        @Override
                                        public void noInternetAvailable() {
                                            isDownloadingFile = false;
                                            hideProgressBar();
                                            CommonFunctions.showToast(getString(R.string.no_internet_connection));
                                        }
                                    });
                        }

                        @Override
                        public void onNegativeButtonClick() {
                            //Do Nothing
                        }
                    });
    }


    private void onAttachFileClicked(final SelectedFile selectedFile) {
        final File file = FileUtils.getFileFromName(selectedFile.getFilePath(), Constants.RESOURCES);
        if (FileUtils.isFileExist(file.getPath())) {
            Utilities.getInstance(getApplication()).openFile(selectedFile.getFilePath(), selectedFile.getContentType(),
                    getApplication());
        } else
            DialogUtility.showAlertWithTwoButtonsOnly(ChecklistExecutionActivity.this,
                    getString(R.string.ask_image_download), R.string.ok, R.string.cancel, new OnSelectListener() {
                        @Override
                        public void onPositiveButtonClick() {
                            showProgressBar();
                            isDownloadingFile = true;
                            if (ContentType.getImageTypes().contains(selectedFile.getContentType()))
                                BaseApplication.getImageLoader().loadImage(file, ImageLoader.ImageType.AssignedStepResource,
                                        selectedFile.getFileUUID(), selectedFile.getFileMd5Checksum(), new OnDownloadListener() {
                                            @Override
                                            public void onSuccess() {
                                                isDownloadingFile = false;
                                                hideProgressBar();
                                                Utilities.getInstance(getApplication()).openFile(selectedFile.getFilePath(),
                                                        selectedFile.getContentType(), getApplication());
                                            }

                                            @Override
                                            public void onFailed() {
                                                isDownloadingFile = false;
                                                hideProgressBar();
                                                runOnUiThread(new Runnable() {
                                                    public void run() {
                                                        CommonFunctions.showToast(getString(R.string.error_downloading_file));
                                                    }
                                                });
                                            }

                                            @Override
                                            public void noInternetAvailable() {
                                                isDownloadingFile = false;
                                                hideProgressBar();
                                                CommonFunctions.showToast(getString(R.string.no_internet_connection));
                                            }
                                        });
                            else {
                                mViewModel.downloadAttachedFileRequired(selectedFile, new OnDownloadListener() {
                                    @Override
                                    public void onSuccess() {
                                        isDownloadingFile = false;
                                        hideProgressBar();
                                        Utilities.getInstance(getApplication()).openFile(selectedFile.getFilePath(),
                                                selectedFile.getContentType(), getApplication());
                                    }

                                    @Override
                                    public void onFailed() {
                                        isDownloadingFile = false;
                                        hideProgressBar();
                                        CommonFunctions.showToast(getString(R.string.error_downloading_file));
                                    }

                                    @Override
                                    public void noInternetAvailable() {
                                        isDownloadingFile = false;
                                        hideProgressBar();
                                        CommonFunctions.showToast(getString(R.string.no_internet_connection));
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNegativeButtonClick() {
                            //Do Nothing
                        }
                    });
    }

    private void onReferenceClicked(final ResourceEntity entity) {
        if (entity.getIsDownloaded() == 1) {
            Utilities.getInstance(this).openFile(entity.getPath(), entity.getContentType(), ChecklistExecutionActivity.this);
        } else {
            final File file = FileUtils.getFileFromName(entity.getPath(), Constants.RESOURCES);

            DialogUtility.showAlertWithTwoButtonsOnly(ChecklistExecutionActivity.this,
                    getString(R.string.ask_file_download), R.string.ok, R.string.cancel, new OnSelectListener() {
                        @Override
                        public void onPositiveButtonClick() {
                            showProgressBar();
                            isDownloadingFile = true;
                            //Check if file or image is to be downloaded
                            if (ContentType.getImageTypes().contains(entity.getContentType()))
                                BaseApplication.getImageLoader().loadImage(file, ImageLoader.ImageType.Resource,
                                        entity.getUuid(), entity.getFileMd5Checksum(), new OnDownloadListener() {
                                            @Override
                                            public void onSuccess() {
                                                isDownloadingFile = false;
                                                hideProgressBar();
                                                mViewModel.updateDownloadResource(entity, file);
                                                Utilities.getInstance(ChecklistExecutionActivity.this).openFile(entity.getPath(),
                                                        entity.getContentType(), ChecklistExecutionActivity.this);
                                                entity.setIsDownloaded(Constants.DOWNLOADED);
                                            }

                                            @Override
                                            public void onFailed() {
                                                isDownloadingFile = false;
                                                hideProgressBar();
                                                runOnUiThread(new Runnable() {
                                                    public void run() {
                                                        CommonFunctions.showToast(getString(R.string.error_downloading_file));
                                                    }
                                                });
                                            }

                                            @Override
                                            public void noInternetAvailable() {
                                                isDownloadingFile = false;
                                                hideProgressBar();
                                                CommonFunctions.showToast(getString(R.string.no_internet_connection));
                                            }
                                        });
                            else {
                                mViewModel.downloadFile(entity, new OnDownloadListener() {
                                    @Override
                                    public void onSuccess() {
                                        isDownloadingFile = false;
                                        hideProgressBar();
                                        Utilities.getInstance(ChecklistExecutionActivity.this)
                                                .openFile(entity.getPath(),
                                                        entity.getContentType(),
                                                        ChecklistExecutionActivity.this);
                                        entity.setIsDownloaded(Constants.DOWNLOADED);
                                    }

                                    @Override
                                    public void onFailed() {
                                        isDownloadingFile = false;
                                        hideProgressBar();
                                        CommonFunctions.showToast(getString(R.string.error_downloading_file));
                                    }

                                    @Override
                                    public void noInternetAvailable() {
                                        isDownloadingFile = false;
                                        hideProgressBar();
                                        CommonFunctions.showToast(getString(R.string.no_internet_connection));
                                    }
                                });
                            }

                        }

                        @Override
                        public void onNegativeButtonClick() {
                            //Do Nothing
                        }
                    });
        }
    }

    @Override
    public void openPagerFragment(boolean isNext) {
        if (isNext)
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnim(R.id.frame_layout,
                    new SPFragment(), SPFragment.class.getSimpleName(), false, ChecklistExecutionActivity.this);
        else
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnimPrevious(R.id.frame_layout,
                    new SPFragment(), SPFragment.class.getSimpleName(), false, ChecklistExecutionActivity.this);
    }

    @Override
    public void showProgressBar() {
        progressDialog = ProgressDialog.show(this, getString(R.string.app_name), getString(R.string.downloading_file), true);
        progressDialog.setCancelable(false);
    }

    @Override
    public void hideProgressBar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        hideProgressBar();
        super.onDestroy();
    }

    @Override
    public void openMenu(boolean isOpen) {
        ViewAnimation.rotateFab(binding.fabMenu.fab, isOpen);
        binding.fabMenu.invalidateAll();
    }

    @Override
    public void skip() {
        isSkipDialogOpen = true;
        DialogUtility.getReasonPopup(ChecklistExecutionActivity.this, getString(R.string.skip_checklist),
                String.format(getString(R.string.give_a_resaon_percentage_skip_defer), getString(R.string.skip).toLowerCase()),
                skipStepListener, getString(R.string.skip).length(), mViewModel.getReasonPopUpViewModel());
    }

    @Override
    public void defer() {
        isDeferDialogOpen = true;
        DialogUtility.getReasonPopup(ChecklistExecutionActivity.this, getString(R.string.deffer_checklist),
                String.format(getString(R.string.give_a_resaon_percentage_skip_defer), getString(R.string.defer).toLowerCase()),
                defferStepListener, getString(R.string.defer).length(), mViewModel.getReasonPopUpViewModel());
    }

    @Override
    public void addSuggestion() {
        isSuggestionDialogOpen = true;
        DialogUtility.getSuggestionPopup(ChecklistExecutionActivity.this, mViewModel.getGalleryViewModel(), suggestionListener);
    }

    @Override
    public void addNote() {
        Navigator.launchActivity(this, AddNotesActivity.getIntent(this, checklistUuid, checklistId, mViewModel.getChecklistElementDetail().getElementId()));
    }

    @Override
    public void showDataCaptured() {
        Navigator.launchActivity(this, AllCaptureDataActivity.getIntent(this, checklistId, checklistUuid));
    }

    @Override
    public void onReferenceDialogCanceled() {
        isReferenceDialogOpen = false;
    }

    @Override
    public void openEmbeddedImageFragment(boolean isNext) {
        if (isNext)
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnim(R.id.frame_layout,
                    new EmbeddedImageFragment(), EmbeddedImageFragment.class.getSimpleName(), false,
                    ChecklistExecutionActivity.this);
        else
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnimPrevious(R.id.frame_layout,
                    new EmbeddedImageFragment(), EmbeddedImageFragment.class.getSimpleName(), false,
                    ChecklistExecutionActivity.this);
    }

    @Override
    public void onQRScanOpen(String title) {
        mViewModel.toolbarTitle.set(getString(R.string.toolbar_scan_title, title));
        binding.toolbar.setNavigationIcon(R.drawable.icon_back_toolbar);
        binding.bottomBar.parentContainer.setVisibility(View.GONE);
        binding.fabMenu.parentContainer.setVisibility(View.GONE);
    }

    @Override
    public void onQRScanClose() {
        binding.toolbar.setNavigationIcon(R.mipmap.close_element_cross);
        mViewModel.toolbarTitle.set(mViewModel.getChecklistElementDetail().getSequenceNo());
        binding.bottomBar.parentContainer.setVisibility(View.VISIBLE);
        binding.fabMenu.parentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void setToolbarText(String title) {
        mViewModel.toolbarTitle.set(title);
    }

    @Override
    public void openDecisionExecution(boolean isNext) {
        if (isNext)
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnim(R.id.frame_layout,
                    new DecisionExecutionFragment(), DecisionExecutionFragment.class.getSimpleName(), false,
                    ChecklistExecutionActivity.this);
        else
            Utilities.getInstance(ChecklistExecutionActivity.this).replaceFragmentWithAnimPrevious(R.id.frame_layout,
                    new DecisionExecutionFragment(), DecisionExecutionFragment.class.getSimpleName(), false,
                    ChecklistExecutionActivity.this);
    }

    @Override
    public void checklistFinished() {
        finish();
    }

    OnReason skipStepListener = new OnReason() {
        @Override
        public void onContinue(String reason, Context context) {
            isSkipDialogOpen = false;
            mViewModel.setReasonPopUpViewModel(null);
            mViewModel.skipDefferElement(ChecklistExecutionStatus.SKIPPED.getValue(), reason,
                    LogTableActions.SKIPPED.getValue());
        }

        @Override
        public void onCancel() {
            isSkipDialogOpen = false;
            mViewModel.setReasonPopUpViewModel(null);
        }
    };


    OnReason defferStepListener = new OnReason() {
        @Override
        public void onContinue(String reason, Context context) {
            isDeferDialogOpen = false;
            mViewModel.setReasonPopUpViewModel(null);
            mViewModel.skipDefferElement(ChecklistExecutionStatus.DEFERRED.getValue(), reason,
                    LogTableActions.DEFERRED.getValue());
        }

        @Override
        public void onCancel() {
            isDeferDialogOpen = false;
            mViewModel.setReasonPopUpViewModel(null);
        }
    };

    OnReason suggestionListener = new OnReason() {
        @Override
        public void onContinue(String reason, Context context) {
            isSuggestionDialogOpen = false;
            mViewModel.addSuggestion(reason, mViewModel.getGalleryViewModel().getListAttachment());
        }

        @Override
        public void onCancel() {
            isSuggestionDialogOpen = false;
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case PhotoEditorActivity.REQUEST_CROP_IMAGE:
                if (data != null) {
                    String path = data.getStringExtra(PhotoEditorActivity.IMAGE_PATH);
                    mViewModel.getGalleryViewModel().displayImage(path);
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
                            mViewModel.getGalleryViewModel().getPhotoPathUri(),
                            directory,
                            AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                else
                    CommonFunctions.showToast(getString(R.string.file_create_error));
                break;

        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (fragment instanceof QRCodeVerifyManualFragment) {
            onQRScanOpen(mViewModel.getQrScanAttribute().getItemToBeScanned().getEntityName());
            getSupportFragmentManager().getFragments()
                    .get(getSupportFragmentManager().getBackStackEntryCount() - 1).onResume();
        } else if (fragment instanceof QRCodeVerifyFragment) {
            onQRScanClose();
        }
        super.onBackPressed();
    }
}
