package com.icarus.checklistexecutionfragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentQrAttributeVerifyManuallyBinding;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.navigators.QRCodeScanNavigator;
import com.icarus.util.DialogUtility;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

/**
 * Created by Monika Rana on 29/04/2020
 * <p>
 * This fragment is added when we click verify manual on scan qr code for rooms for qr attribute
 * We will verify here if the qr code entered is correct and execution is performed in correct room
 */
public class QRCodeVerifyManualFragment extends BaseFragment<FragmentQrAttributeVerifyManuallyBinding, ChecklistExecutionViewModel> implements View.OnClickListener {
    private ChecklistExecutionViewModel mViewModel;
    private QRAttributeScanItem qrAttributeScanItem;
    private FragmentQrAttributeVerifyManuallyBinding binding;
    private QRCodeScanNavigator qrCodeScanNavigator;
    private String entityName;
    private boolean isScanNextPopUpShowing, isMisMatchPopUpShowing, isIntroductionPopUpShowing;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_qr_attribute_verify_manually;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }

    public static QRCodeVerifyManualFragment getInstance(QRCodeScanNavigator qrCodeScanNavigator) {
        QRCodeVerifyManualFragment qrCodeVerifyFragment = new QRCodeVerifyManualFragment();
        qrCodeVerifyFragment.setQrCodeScanNavigator(qrCodeScanNavigator);
        return qrCodeVerifyFragment;
    }

    private void setQrCodeScanNavigator(QRCodeScanNavigator qrCodeScanNavigator) {
        this.qrCodeScanNavigator = qrCodeScanNavigator;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        mViewModel = getViewModel();
        binding = getViewDataBinding();

        mViewModel.getNavigator().setToolbarText(getString(R.string.verify_manually));

        qrAttributeScanItem = mViewModel.getQrScanAttribute().getItemToBeScanned();
        binding.setHeader(qrAttributeScanItem.isRoom() ? BaseApplication.getPreferenceManager().getRoomName() : BaseApplication.getPreferenceManager().getAssetName());
        binding.btnSubmit.setOnClickListener(this);
        binding.txtLabelRoom.setOnClickListener(this);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isScanNextPopUpShowing", false))
                showScanNextPopUp(savedInstanceState.getString("EntityName", ""));

            if (savedInstanceState.getBoolean("isMisMatchPopUpShowing", false))
                showScanMisMatchPopUp();

            if (savedInstanceState.getBoolean("isIntroductionPopUpShowing", false))
                binding.txtLabelRoom.callOnClick();

            mViewModel.getNavigator().setToolbarText(getString(R.string.verify_manually));
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isScanNextPopUpShowing", isScanNextPopUpShowing);
        outState.putBoolean("isMisMatchPopUpShowing", isMisMatchPopUpShowing);
        outState.putBoolean("isIntroductionPopUpShowing", isIntroductionPopUpShowing);
        outState.putString("EntityName", entityName);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                boolean isValidated = true;
                binding.txtInputRoomName.setError(null);
                binding.txtInputReason.setError(null);
                if (TextUtils.isEmpty(binding.etRoomName.getText().toString().trim())) {
                    binding.txtInputRoomName.setError(getString(R.string.name_is_required));
                    isValidated = false;
                }

                if (TextUtils.isEmpty(binding.etReason.getText().toString().trim())) {
                    binding.txtInputReason.setError(getString(R.string.reason_is_required));
                    isValidated = false;
                } else if (binding.etReason.getText().toString().trim().length() < 3) {
                    binding.txtInputReason.setError(getString(R.string.at_least_three_characters_required));
                    isValidated = false;
                }

                if (!isValidated)
                    return;

                if (verifyScannedCode(binding.etRoomName.getText().toString().trim())) {
                    entityName = qrAttributeScanItem.getEntityName();
                    //It is a match execute the step and open next qr code if any or exit the screen
                    qrCodeScanNavigator.removeGetScanItemsLiveDataObserver();
                    mViewModel.executeQRScanStepAttribute(qrAttributeScanItem,
                            binding.etRoomName.getText().toString().trim(),
                            binding.etReason.getText().toString().trim(), qrCodeScanNavigator);

                    qrAttributeScanItem = mViewModel.getQrScanAttribute().getNextQRScanAttributeIfAny();
                    if (qrAttributeScanItem == null) {
                        openStepDetailFragment();
                    } else {
                       /* Utilities.getInstance(getActivity()).replaceFragmentWithSlideLeftToRightAnim(R.id.frame_layout, getInstance(qrCodeScanNavigator),
                                QRCodeVerifyManualFragment.class.getSimpleName(), false, getActivity());*/
                        showScanNextPopUp(entityName);
                    }
                } else {
                    //It is a mismatch show retry popup
                    showScanMisMatchPopUp();
                }

                break;

            case R.id.txtLabelRoom:
                isIntroductionPopUpShowing = true;
                DialogUtility.showAlertWithImage(getActivity(), qrAttributeScanItem.isRoom() ?
                                R.drawable.verify_room_instruction : R.drawable.verify_asset_instruction,
                        new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                isIntroductionPopUpShowing = false;
                            }
                        });
                break;
        }
    }

    private boolean verifyScannedCode(String scannedCode) {
        if (scannedCode == null || scannedCode.isEmpty()) {
            return false;
        }

        if (scannedCode.equalsIgnoreCase(qrAttributeScanItem.getEntityName())) {
            return true;
        }

        if (scannedCode.equalsIgnoreCase(qrAttributeScanItem.getUPCNumber())) {
            return true;
        }

        return false;
    }

    private void openStepDetailFragment() {
        if (getActivity() != null) { // Handle null
            getActivity().getSupportFragmentManager().popBackStack();
            getActivity().getSupportFragmentManager().popBackStack();
        }
        mViewModel.getNavigator().onQRScanClose();
    }

    private void showScanNextPopUp(String entityName) {
        isScanNextPopUpShowing = true;

        DialogUtility.showAlertWithOneButtonsOnly(getActivity(),
                getString(R.string.qr_code_attribute_scanned_success, entityName),
                R.string.scan_next,
                new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        isScanNextPopUpShowing = false;
                        if (getActivity() != null) { // Handle null
                            getActivity().onBackPressed();
                        }
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
                    }

                    @Override
                    public void onNegativeButtonClick() {
                        isMisMatchPopUpShowing = false;
                        openStepDetailFragment();
                    }
                });
    }

}
