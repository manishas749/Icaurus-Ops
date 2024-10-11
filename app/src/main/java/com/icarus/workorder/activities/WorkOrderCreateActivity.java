package com.icarus.workorder.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.databinding.ActivityWorkOrderCreateBinding;
import com.icarus.entities.LocationEntity;
import com.icarus.util.AppUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.StringUtil;
import com.icarus.util.Utilities;
import com.icarus.workorder.models.RoomItems;
import com.icarus.workorder.navigators.WorkOrderCreateNavigator;
import com.icarus.workorder.viewmodels.WorkOrderCreateViewModel;

import java.io.File;
import java.util.List;

import c.anurag.cropannotate.annotations.activity.PhotoEditorActivity;
import c.anurag.cropannotate.crop.CropImage;
import c.anurag.database.util.CommonFunctions;

public class WorkOrderCreateActivity extends BaseActivity<ActivityWorkOrderCreateBinding, WorkOrderCreateViewModel> implements WorkOrderCreateNavigator {

    private WorkOrderCreateViewModel mWorkOrderDetailModel;
    private ActivityWorkOrderCreateBinding mBinding;

    public static Intent getInstance(Context context, String checklistTitle, Integer checklistId, Integer roomId, Integer assetId) {
        return new Intent(context, WorkOrderCreateActivity.class)
                .putExtra(Constants.CHECKLIST_TITLE, checklistTitle)
                .putExtra(Constants.CHECKLIST_ID, checklistId)
                .putExtra(Constants.ROOM_ID, roomId)
                .putExtra(Constants.ASSET_ID, assetId);
    }

    public static Intent getInstance(Context context, String checklistTitle, Integer checklistId) {
        return new Intent(context, WorkOrderCreateActivity.class)
                .putExtra(Constants.CHECKLIST_TITLE, checklistTitle)
                .putExtra(Constants.CHECKLIST_ID, checklistId);
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, WorkOrderCreateActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_work_order_create;
    }

    @Override
    public WorkOrderCreateViewModel getViewModel() {
        return mWorkOrderDetailModel = new ViewModelProvider(this).get(WorkOrderCreateViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        String checklistTitle = getIntent().getStringExtra(Constants.CHECKLIST_TITLE);
        Integer checklistId = getIntent().getIntExtra(Constants.CHECKLIST_ID, 0);
        Integer roomId = getIntent().getIntExtra(Constants.ROOM_ID, 0);
        Integer assetId = getIntent().getIntExtra(Constants.ASSET_ID, 0);
        mWorkOrderDetailModel.setNavigator(this);
        mWorkOrderDetailModel.setValues(checklistId, roomId, assetId);
        mBinding = getViewDataBinding();
        mWorkOrderDetailModel.getLocationList();
        if (!TextUtils.isEmpty(checklistTitle)) {
            mBinding.etTitle.setText(checklistTitle);
        }
        //mBinding.galleryWidget.setItem(mWorkOrderDetailModel.getGalleryViewModel());
        mBinding.spinLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mWorkOrderDetailModel.getRoomList(mWorkOrderDetailModel.locationList.get(position).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBinding.spinLocation.setEnabled(false);
        mBinding.spinAsset.setEnabled(false);
        mBinding.spinRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mWorkOrderDetailModel.roomList.size() == mBinding.spinRoom.getAdapter().getCount()) {
                    mWorkOrderDetailModel.getAssetList(mWorkOrderDetailModel.getLocationId(), mWorkOrderDetailModel.roomList.get(position).getId());
                    mBinding.spinAsset.setEnabled(true);
                    mBinding.assets.setVisibility(View.VISIBLE);
                    mBinding.spinAsset.setVisibility(View.VISIBLE);
                    mBinding.dividerAsset.setVisibility(View.VISIBLE);
                } else if (position > 0) {
                    mWorkOrderDetailModel.getAssetList(mWorkOrderDetailModel.getLocationId(), mWorkOrderDetailModel.roomList.get(position - 1).getId());
                    mBinding.spinAsset.setEnabled(true);
                    mBinding.assets.setVisibility(View.VISIBLE);
                    mBinding.spinAsset.setVisibility(View.VISIBLE);
                    mBinding.dividerAsset.setVisibility(View.VISIBLE);
                } else {
                    mBinding.assets.setVisibility(View.GONE);
                    mBinding.spinAsset.setVisibility(View.GONE);
                    mBinding.dividerAsset.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onTitleError(int resID) {
        mBinding.etTitleView.setError(getString(resID));
        mBinding.etTitle.requestFocus();
    }

    @Override
    public void onDescriptionError(int resID) {
        mBinding.etDescriptionView.setError(getString(resID));
        mBinding.etDescription.requestFocus();
    }

    @Override
    public void onRoomError(int resID) {
        Utilities.getInstance(this).showToast(String.format(getString(resID), BaseApplication.getPreferenceManager().getRoomName()), Toast.LENGTH_LONG, this);
    }

    @Override
    public void onAssetError(int resID) {
        Utilities.getInstance(this).showToast(String.format(getString(resID), BaseApplication.getPreferenceManager().getAssetName()), Toast.LENGTH_LONG, this);
    }

    @Override
    public void onStartLocationObserving() {
        mWorkOrderDetailModel.observeLocationResponse().observe(this, new Observer<List<LocationEntity>>() {
            @Override
            public void onChanged(@Nullable List<LocationEntity> locationItems) {
                if (StringUtil.INSTANCE.listNotNull(locationItems)) {
                    mBinding.spinLocation.setAdapter(mWorkOrderDetailModel.getLocationListInAdapter(locationItems));
                    for (int i = 0; i < locationItems.size(); i++) {
                        if (locationItems.get(i).getId() == BaseApplication.getPreferenceManager().getUserLocationId()) {
                            mBinding.spinLocation.setSelection(i);
                            mWorkOrderDetailModel.getRoomList(mWorkOrderDetailModel.locationList.get(i).getId());
                            break;
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onStartRoomObserving() {
        mWorkOrderDetailModel.observeRoomResponse().observe(this, new Observer<List<RoomItems>>() {
            @Override
            public void onChanged(@Nullable List<RoomItems> roomItems) {
                if (StringUtil.INSTANCE.listNotNull(roomItems)) {
                    mBinding.spinRoom.setAdapter(mWorkOrderDetailModel.getRoomListInAdapter(roomItems));
                    for (int i = 0; i < roomItems.size(); i++) {
                        if (roomItems.get(i).getId().equals(mWorkOrderDetailModel.getRoomId())) {
                            int position = i;
                            if (mBinding.spinRoom.getAdapter().getCount() != roomItems.size()) {
                                position = i + 1;
                            }
                            mBinding.spinRoom.setSelection(position);
                            break;
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onStartAssetsObserving() {
        mWorkOrderDetailModel.observeAssetResponse().observe(this, new Observer<List<RoomItems>>() {
            @Override
            public void onChanged(@Nullable List<RoomItems> assetItems) {
                if (StringUtil.INSTANCE.listNotNull(assetItems)) {
                    mBinding.spinAsset.setAdapter(mWorkOrderDetailModel.getAssetListInAdapter(assetItems));
                    for (int i = 0; i < assetItems.size(); i++) {
                        if (assetItems.get(i).getId().equals(mWorkOrderDetailModel.getAssetId())) {
                            int position = i;
                            if (mBinding.spinAsset.getAdapter().getCount() != assetItems.size()) {
                                position = i + 1;
                            }
                            mBinding.spinAsset.setSelection(position);
                            break;
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onCancelClick() {
        finish();
    }

    @Override
    public void onSaveWorkOrder() {
        mBinding.etTitle.setError(null);
        mBinding.etDescription.setError(null);
        mWorkOrderDetailModel.saveWorkOrder(mBinding.etTitle.getText().toString().trim(), (mBinding.etDescription.getText().toString().trim()),
                mBinding.spinLocation.getSelectedItemPosition(),
                mBinding.spinRoom.getSelectedItemPosition(),
                mBinding.spinAsset.getSelectedItemPosition(), mWorkOrderDetailModel.getGalleryViewModel().getListAttachment());
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
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case PhotoEditorActivity.REQUEST_CROP_IMAGE:
                if (data != null) {
                    String path = data.getStringExtra(PhotoEditorActivity.IMAGE_PATH);
                    mWorkOrderDetailModel.getGalleryViewModel().displayImage(path);
                }
                break;
            case CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE:
                if (data != null && data.getData() != null) {
                    File directory = FileUtils.getWorkOrderAttachmentsDir();
                    if (directory != null)
                        startActivityForResult(PhotoEditorActivity.newIntent(
                                WorkOrderCreateActivity.this,
                                data.getData(),
                                directory,
                                AppUtility.Companion.getUtcTimeImageFileName()
                        ), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                    else
                        CommonFunctions.showToast(getString(R.string.file_create_error));
                }
                break;
            case CropImage.CLICK_IMAGE_CAMERA_REQUEST_CODE:
                File directory = FileUtils.getWorkOrderAttachmentsDir();
                if (directory != null)
                    startActivityForResult(PhotoEditorActivity.newIntent(
                            WorkOrderCreateActivity.this,
                            mWorkOrderDetailModel.getGalleryViewModel().getPhotoPathUri(),
                            directory,
                            AppUtility.Companion.getUtcTimeImageFileName()
                    ), PhotoEditorActivity.REQUEST_CROP_IMAGE);
                else
                    CommonFunctions.showToast(getString(R.string.file_create_error));
                break;

        }
    }
}
