package com.icarus.checklistexecutionfragments;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.zxing.Result;
import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentBarcodeScannerBinding;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by admin on 4/9/2018.
 */

public class BarcodeReaderFragment extends BaseFragment<FragmentBarcodeScannerBinding, ChecklistExecutionViewModel> implements ZXingScannerView.ResultHandler {
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private static final int REQUEST_PERMISSION_SETTING = 103;
    private FragmentBarcodeScannerBinding mBinding;
    private ZXingScannerView mScannerView;
    private boolean isCameraOpened = false;
    private ChecklistExecutionViewModel mViewModel;

    private void setMyPermissionsRequestCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                    showPermissionAlert();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
                }
            } else {
                openCamera();
            }
        } else {
            openCamera();
            
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = getViewDataBinding();
        mViewModel = getViewModel();
        mScannerView = new ZXingScannerView(getContext());
        mBinding.layoutScanner.addView(mScannerView);
        setMyPermissionsRequestCamera();
    }

    private void openCamera() {
        if (mScannerView != null) {
            mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
            mScannerView.startCamera();
            isCameraOpened = true;
        }
    }

    private void showPermissionAlert() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
        alertBuilder.setCancelable(false);
        alertBuilder.setTitle(getString(R.string.permission_required));
        alertBuilder.setMessage(R.string.ask_permission_camera);
        alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
                    alertBuilder.setCancelable(false);
                    alertBuilder.setTitle(getString(R.string.app_name));
                    alertBuilder.setMessage(getString(R.string.ask_permission_camera));
                    alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                            intent.setData(uri);
                            startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                            dialog.dismiss();
                        }
                    });
                    alertBuilder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            if (getActivity() != null)
                                getActivity().onBackPressed();
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();

                }
                return;
            }
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            // Make sure the request was successful
            setMyPermissionsRequestCamera();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isCameraOpened)
            setMyPermissionsRequestCamera();

        if (getActivity() != null && ((AppCompatActivity) getActivity()).getSupportActionBar() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mScannerView != null) {
            mScannerView.stopCamera();           // Stop camera on pause
        }
    }

    @Override
    public void handleResult(Result rawResult) {
        if (rawResult.getText() != null && !rawResult.getText().isEmpty()) {
            getViewModel().fetchNextData(true);
            if (getActivity() != null)
                getActivity().onBackPressed();
        }

        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (getActivity() != null && ((AppCompatActivity) getActivity()).getSupportActionBar() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_barcode_scanner;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }
}
