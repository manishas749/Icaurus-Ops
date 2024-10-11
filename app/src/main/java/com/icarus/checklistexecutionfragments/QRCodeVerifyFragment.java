package com.icarus.checklistexecutionfragments;

import android.os.Bundle;
import android.text.Html;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.zxing.Result;
import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseFragment;
import com.icarus.customviews.ZXingBarcodeScannerView;
import com.icarus.databinding.FragmentScanQrCodeAttributeBinding;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.navigators.QRCodeScanNavigator;
import com.icarus.util.DialogUtility;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Monika Rana on 28/04/2020
 * <p>
 * This fragment is shown if there is any qa attribute in step type element and is used
 * to verify the qr code for room and asset to check if being performed in correct room and correct
 * assets are being checked
 */
public class QRCodeVerifyFragment extends BaseFragment<FragmentScanQrCodeAttributeBinding, ChecklistExecutionViewModel>
        implements ZXingScannerView.ResultHandler, View.OnClickListener {
    private ChecklistExecutionViewModel mViewModel;
    private ZXingBarcodeScannerView mScannerView;
    private QRAttributeScanItem qrAttributeScanItem;
    private QRCodeScanNavigator qrCodeScanNavigator;
    private String entityName;
    private boolean isScanNextPopUpShowing, isMisMatchPopUpShowing;

    public static QRCodeVerifyFragment getInstance(QRCodeScanNavigator qrCodeScanNavigator) {
        QRCodeVerifyFragment qrCodeVerifyFragment = new QRCodeVerifyFragment();
        qrCodeVerifyFragment.setQrCodeScanNavigator(qrCodeScanNavigator);
        return qrCodeVerifyFragment;
    }

    public void setQrCodeScanNavigator(QRCodeScanNavigator qrCodeScanNavigator) {
        this.qrCodeScanNavigator = qrCodeScanNavigator;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_scan_qr_code_attribute;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        FragmentScanQrCodeAttributeBinding mBinding = getViewDataBinding();
        mViewModel = getViewModel();

        //get the scan entity detail
        qrAttributeScanItem = mViewModel.getQrScanAttribute().getItemToBeScanned();
        //handles the back button and toolbar title visibility
        mViewModel.getNavigator().onQRScanOpen(qrAttributeScanItem.getEntityName());
        mScannerView = new ZXingBarcodeScannerView(getContext());
        mBinding.layoutScanner.addView(mScannerView);

        //Make text for verifying manually clickable and underlined
        //Make scan barcode clickable and open barcode reader fragment
        mBinding.txtVerifyManual.setText(Html.fromHtml(getString(R.string.qr_code_scan_trouble)));
        mBinding.txtVerifyManual.setOnClickListener(this);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isScanNextPopUpShowing", false))
                showScanNextPopUp(savedInstanceState.getString("EntityName", ""));

            if (savedInstanceState.getBoolean("isMisMatchPopUpShowing", false))
                showScanMisMatchPopUp();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isScanNextPopUpShowing", isScanNextPopUpShowing);
        outState.putBoolean("isMisMatchPopUpShowing", isMisMatchPopUpShowing);
        outState.putString("EntityName", entityName);
    }

    private void openCamera() {
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }

    @Override
    public void onResume() {
        super.onResume();
        openCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        if (rawResult.getText() != null && !rawResult.getText().isEmpty()) {
            qrAttributeScanItem = mViewModel.getQrScanAttribute().getItemToBeScanned();
            entityName = qrAttributeScanItem.getEntityName();
            String scannedCode = rawResult.getText();
            if (verifyScannedCode(scannedCode)) {
                //It is a match execute the step and open next qr code if any or exit the screen
                qrCodeScanNavigator.removeGetScanItemsLiveDataObserver();
                mViewModel.executeQRScanStepAttribute(qrAttributeScanItem, scannedCode, null,
                        qrCodeScanNavigator);
                qrAttributeScanItem = mViewModel.getQrScanAttribute().getNextQRScanAttributeIfAny();
                if (qrAttributeScanItem == null) {
                    if (getActivity() != null)
                        getActivity().onBackPressed();
                } else {
                    showScanNextPopUp(entityName);
                }
            } else {
                //It is a mismatch show retry popup
                showScanMisMatchPopUp();
            }
        }


    }


    private boolean verifyScannedCode(String scannedCode) {
        if (scannedCode == null || scannedCode.isEmpty()) {
            return false;
        }

        if (scannedCode.equalsIgnoreCase(qrAttributeScanItem.getQrCode())) {
            return true;
        }

        if (scannedCode.equalsIgnoreCase(qrAttributeScanItem.getUPCNumber())) {
            return true;
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtVerifyManual:
                mScannerView.stopCamera();           // Stop camera on pause
                Utilities.getInstance(getActivity()).addFragment(R.id.frame_layout,
                        QRCodeVerifyManualFragment.getInstance(qrCodeScanNavigator), QRCodeVerifyManualFragment.class.getSimpleName(), true, getActivity());
                break;
        }
    }

    private void showScanNextPopUp(final String entityName) {
        isScanNextPopUpShowing = true;
        DialogUtility.showAlertWithOneButtonsOnly(getActivity(),
                getString(R.string.qr_code_attribute_scanned_success, entityName),
                R.string.scan_next,
                new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        isScanNextPopUpShowing = false;
                        QRCodeVerifyFragment.this.entityName = qrAttributeScanItem.getEntityName();
                        mScannerView.resumeCameraPreview(QRCodeVerifyFragment.this);
                        mViewModel.getNavigator().onQRScanOpen(qrAttributeScanItem.getEntityName());
                    }

                    @Override
                    public void onNegativeButtonClick() {
                        isScanNextPopUpShowing = false;
                    }
                });
    }

    private void showScanMisMatchPopUp() {
        isMisMatchPopUpShowing = true;
        DialogUtility.showAlertWithTwoButtonsOnly(getActivity(), getString(R.string.mismatch_detected),
                getString(R.string.qr_code_mismatch_message, qrAttributeScanItem.isRoom() ? BaseApplication.getPreferenceManager().getRoomName()
                        : BaseApplication.getPreferenceManager().getAssetName()), R.string.retry, R.string.cancel, new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        isMisMatchPopUpShowing = false;
                        mViewModel.getNavigator().onQRScanOpen(qrAttributeScanItem.getEntityName());
                        mScannerView.resumeCameraPreview(QRCodeVerifyFragment.this);
                    }

                    @Override
                    public void onNegativeButtonClick() {
                        isMisMatchPopUpShowing = false;
                        if (getActivity() != null)
                            getActivity().onBackPressed();
                    }
                });
    }

}
