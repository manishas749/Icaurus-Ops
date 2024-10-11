package com.icarus.workorder.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.constants.Constants;
import com.icarus.databinding.ActivityWorkOrderCompleteBinding;
import com.icarus.util.AppUtility;
import com.icarus.util.FileUtils;
import com.icarus.workorder.navigators.WorkOrderCompleteNavigator;
import com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel;

import java.io.File;

import c.anurag.cropannotate.annotations.activity.PhotoEditorActivity;
import c.anurag.cropannotate.crop.CropImage;
import c.anurag.database.util.CommonFunctions;

public class WorkOrderCompleteActivity extends BaseActivity<ActivityWorkOrderCompleteBinding, WorkOrderCompleteViewModel> implements WorkOrderCompleteNavigator {

    private WorkOrderCompleteViewModel mWorkOrderCompleteViewModel;
    private ActivityWorkOrderCompleteBinding mBinding;
    private String worOrderUuid;
    private Integer worOrderId;

    public static Intent getInstance(Context context, Integer workOrderId, String workOrderUuid) {
        return new Intent(context, WorkOrderCompleteActivity.class)
                .putExtra(Constants.WORK_ORDER_UUID, workOrderUuid)
                .putExtra(Constants.WORK_ORDER_ID, workOrderId);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_work_order_complete;
    }

    @Override
    public WorkOrderCompleteViewModel getViewModel() {
        return mWorkOrderCompleteViewModel = new ViewModelProvider(this).get(WorkOrderCompleteViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        worOrderUuid = getIntent().getStringExtra(Constants.WORK_ORDER_UUID);
        worOrderId = getIntent().getIntExtra(Constants.WORK_ORDER_ID, 0);
        mWorkOrderCompleteViewModel.setNavigator(this);
        mBinding = getViewDataBinding();
    }

    @Override
    public void onDescriptionError(int resID) {
        mBinding.etDescriptionView.setError(getString(resID));
        mBinding.etDescription.requestFocus();
    }

    @Override
    public void onCancelClick() {
        finish();
    }

    @Override
    public void onCompleteWorkOrder() {
        mBinding.etDescription.setError(null);
        mWorkOrderCompleteViewModel.saveWorkOrder(mBinding.etDescription.getText().toString().trim(), worOrderUuid, worOrderId);
    }

    @Override
    public void onSuccessfullySaveWorkOrder() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(Constants.REFRESH_SCREEN, true);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK)
            return;

        switch (requestCode) {
            case PhotoEditorActivity.REQUEST_CROP_IMAGE:
                if (null != data) {
                    String path = data.getStringExtra(PhotoEditorActivity.IMAGE_PATH);
                    mWorkOrderCompleteViewModel.getGalleryViewModel().displayImage(path);
                }
                break;

            case CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE:
                if (data != null && data.getData() != null) {
                    File directory = FileUtils.getWorkOrderAttachmentsDir();
                    if (directory != null) {
                        startActivityForResult(PhotoEditorActivity.newIntent(this,
                                data.getData(),
                                directory,
                                AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                    } else {
                        CommonFunctions.showToast(getString(R.string.file_create_error));
                    }
                }
                break;

            case CropImage.CLICK_IMAGE_CAMERA_REQUEST_CODE:
                File directory = FileUtils.getWorkOrderAttachmentsDir();
                if (directory != null) {
                    startActivityForResult(PhotoEditorActivity.newIntent(this,
                            mWorkOrderCompleteViewModel.getGalleryViewModel().getPhotoPathUri(),
                            directory,
                            AppUtility.Companion.getUtcTimeImageFileName()), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                } else {
                    CommonFunctions.showToast(getString(R.string.file_create_error));
                }
                break;
        }
    }
}
