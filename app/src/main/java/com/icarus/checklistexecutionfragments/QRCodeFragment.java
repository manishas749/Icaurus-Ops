package com.icarus.checklistexecutionfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.ChecklistExecutionActivity;
import com.icarus.adapters.QRScanAttributeDetailItemsAdapter;
import com.icarus.base.BaseFragment;
import com.icarus.customviews.DividerItemDecorator;
import com.icarus.databinding.FragmentQrScanAttributeBinding;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.navigators.QRCodeScanNavigator;
import com.icarus.navigators.SPExecutionNavigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Monika Rana on 08/05/2020
 */
public class QRCodeFragment extends BaseFragment<FragmentQrScanAttributeBinding, ChecklistExecutionViewModel> implements QRCodeScanNavigator, View.OnClickListener {
    private SPExecutionNavigator mNavigatorListener;
    private ChecklistExecutionViewModel mViewModel;
    private FragmentQrScanAttributeBinding mBinding;
    private QRScanAttributeDetailItemsAdapter qrScanAttributeDetailItemsAdapter;
    private int attributePosition;
    private boolean isEditable;
    private LiveData<List<QRAttributeScanItem>> listLiveData;

    public static QRCodeFragment getInstance(int position, SPExecutionNavigator navigator) {
        Bundle args = new Bundle();
        args.putInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, position);
        QRCodeFragment fragment = new QRCodeFragment();
        fragment.setNavigatorListener(navigator);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    public void setNavigatorListener(SPExecutionNavigator navigatorListener) {
        mNavigatorListener = navigatorListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_qr_scan_attribute;
    }

    @Override
    public ChecklistExecutionViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(ChecklistExecutionViewModel.class) : null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        Utilities.getInstance(getActivity()).showHideKeyboard(false, getActivity());
        mViewModel = getViewModel();
        mBinding = getViewDataBinding();
        mBinding.rvQRScanItems.addItemDecoration(new DividerItemDecorator(ContextCompat.getDrawable(getActivity(), R.drawable.divider)));

        if (getArguments() == null)
            return;

        attributePosition = getArguments().getInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, 0);
        //Set label for attribute
        mBinding.txtLabel.setText(String.format(getString(R.string.attribute_label_bullet),
                String.valueOf(attributePosition + 1),
                mViewModel.attributeItemsList.get(attributePosition).getLabel()));


        mBinding.btnSubmit.setOnClickListener(this);
        mBinding.editAttribute.setOnClickListener(this);

        //Handle orientation change
        if (savedInstanceState != null) {
            qrScanAttributeDetailItemsAdapter = new QRScanAttributeDetailItemsAdapter(
                    mViewModel.getQrScanAttribute().getScanQRAttributesSparseArray().get(attributePosition),
                    QRCodeFragment.this);
            mBinding.rvQRScanItems.setAdapter(qrScanAttributeDetailItemsAdapter);

            if (savedInstanceState.getBoolean("isSubmitButtonVisible", false))
                mBinding.btnSubmit.setVisibility(View.VISIBLE);
            else
                mBinding.btnSubmit.setVisibility(View.INVISIBLE);

            if (savedInstanceState.getBoolean("isEditButtonVisible", false)) {
                mBinding.editAttribute.setVisibility(View.VISIBLE);
            } else
                mBinding.editAttribute.setVisibility(View.INVISIBLE);

            if (isEditable)
                mBinding.editAttribute.callOnClick();

            mBinding.txtLabel.setText(savedInstanceState.getString("sequenceNumber"));
        } else {
            observeQRScanItemsList();
        }
    }



    private void manageViewsState() {
        //Manage click events and editable state of qr attribute items
        //If step is executed nothing is editable and no button is visible
        //If step is not completed yet, check if all the qr codes are scanned, if all rooms/assets are scanned then show edit button
        // and disable submit button and editable is false
        if (mViewModel.getSelectedTab() == 0 && mViewModel.isStepExecuted()) {
            isEditable = false;
            mBinding.editAttribute.setVisibility(View.INVISIBLE);
            mBinding.btnSubmit.setVisibility(View.INVISIBLE);
        } else {
            mBinding.editAttribute.setVisibility(View.VISIBLE);
            boolean isQRCodeExecutionPending = mViewModel.getQrScanAttribute().checkIfQRScanPendingForAttribute(attributePosition);
            isEditable = isQRCodeExecutionPending;
            mBinding.btnSubmit.setVisibility(isQRCodeExecutionPending ? View.VISIBLE : View.INVISIBLE);
            mBinding.editAttribute.setVisibility(isQRCodeExecutionPending ? View.INVISIBLE : View.VISIBLE);
        }
        SPFragment spFragment = ((SPFragment) getParentFragment());
        if (spFragment != null) spFragment.checkIfStepValidToComplete();
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isSubmitButtonVisible", mBinding.btnSubmit.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditButtonVisible", mBinding.editAttribute.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditable", isEditable);
        outState.putString("sequenceNumber", mBinding.txtLabel.getText().toString());
    }


    @Override
    public void onQRItemClick(int position) {
        if (isEditable) {
            mViewModel.getQrScanAttribute().setAttributePosition(attributePosition);
            mViewModel.getQrScanAttribute().setQrScanDetailItemPosition(position);
            Utilities.getInstance(getActivity()).addFragment(R.id.frame_layout,
                    QRCodeVerifyFragment.getInstance(this), QRCodeVerifyFragment.class.getSimpleName(), true, getActivity());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                if (mViewModel.getQrScanAttribute().checkIfQRScanPendingForAttribute(attributePosition))
                    Utilities.getInstance(getActivity()).showToast(getString(R.string.execute_all_qr_scan_elements),
                            Toast.LENGTH_LONG, getActivity());
                else {
                    SPFragment spFragment = ((SPFragment) getParentFragment());
                    if (spFragment != null) spFragment.checkIfStepValidToComplete();
                    mBinding.btnSubmit.setVisibility(View.INVISIBLE);
                    isEditable = false;
                    mBinding.editAttribute.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.editAttribute:
                isEditable = true;
                mBinding.btnSubmit.setVisibility(View.VISIBLE);
                mBinding.editAttribute.setVisibility(View.INVISIBLE);
                break;

        }
    }

    @Override
    public void removeGetScanItemsLiveDataObserver() {
        if (listLiveData.hasActiveObservers()) {
            listLiveData.removeObservers(getViewLifecycleOwner());
        }
    }

    @Override
    public void observeQRScanItemsList() {
        listLiveData = mViewModel.getQRAttributeDetail(attributePosition);
        listLiveData.observe(getViewLifecycleOwner(), new Observer<List<QRAttributeScanItem>>() {
            @Override
            public void onChanged(@Nullable List<QRAttributeScanItem> qrAttributeScanItems) {
                //If returned rows are 0 don'
                // t show qr attribute
                if (qrAttributeScanItems == null || qrAttributeScanItems.size() == 0) {
                    mNavigatorListener.removeQRAttributeIfNoItemToScan(attributePosition);
                    return;
                }

                listLiveData.removeObservers(getViewLifecycleOwner());
                //Check if attribute is executed for first if yes item uuid is to be added
                // in the query for fetching added item uuid for assigned step attribute
                if (getActivity() == null) return;
                if (mViewModel.getQrScanAttribute() == null) return;
                if (qrScanAttributeDetailItemsAdapter == null) {
                    qrScanAttributeDetailItemsAdapter = new QRScanAttributeDetailItemsAdapter(qrAttributeScanItems, QRCodeFragment.this);
                    mBinding.rvQRScanItems.setAdapter(qrScanAttributeDetailItemsAdapter);
                } else {
                    qrScanAttributeDetailItemsAdapter.setItems(qrAttributeScanItems);
                }
                mViewModel.getQrScanAttribute().getScanQRAttributesSparseArray().put(attributePosition, qrAttributeScanItems);
                manageViewsState();
            }
        });
    }

    public QRCodeScanNavigator getNavigator() {
        return this;
    }

    public void updateSequenceNumber(int sequenceNumber) {
        mBinding.txtLabel.setText(String.format(getString(R.string.attribute_label_bullet),
                String.valueOf(sequenceNumber + 1),
                mViewModel.attributeItemsList.get(attributePosition).getLabel()));

    }
}
