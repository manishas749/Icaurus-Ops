package com.icarus.checklistexecutionfragments;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.ChecklistExecutionActivity;
import com.icarus.base.BaseFragment;
import com.icarus.constants.Constants;
import com.icarus.databinding.FragmentQaVerifyBinding;
import com.icarus.enums.LogTableActions;
import com.icarus.models.UserMinimal;
import com.icarus.navigators.SPExecutionNavigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Monika Rana on 1/26/2019.
 */

public class QAVerifyFragment extends BaseFragment<FragmentQaVerifyBinding, ChecklistExecutionViewModel> implements View.OnClickListener {
    private ChecklistExecutionViewModel mViewModel;
    private FragmentQaVerifyBinding binding;
    private int position = 0;
    private boolean isEditable;

    public static QAVerifyFragment getInstance(int position, SPExecutionNavigator navigator) {
        Bundle args = new Bundle();
        args.putInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, position);
        QAVerifyFragment fragment = new QAVerifyFragment();
        fragment.setNavigatorListener(navigator);
        fragment.setArguments(args);
        return fragment;
    }

    public void setNavigatorListener(SPExecutionNavigator navigatorListener) {
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_qa_verify;
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
        binding = getViewDataBinding();
        mViewModel = getViewModel();

        binding.setViewModel(mViewModel);

        position = getArguments() != null ? getArguments().getInt(
                ChecklistExecutionActivity.ATTRIBUTE_POSITION, 0) : 0;

        if (mViewModel.attributeItemsList != null && position < mViewModel.attributeItemsList.size()) {
            mViewModel.setBtnText(getString(R.string.submit));
            if (mViewModel.attributeItemsList.get(position).getAttributeValue() == null ||
                    (mViewModel.attributeItemsList.get(position).getAttributeValue().isEmpty())) {
                binding.btnSubmit.setVisibility(View.VISIBLE);
            } else {
                binding.btnSubmit.setVisibility(View.GONE);
                binding.username.setText((mViewModel.attributeItemsList.get(position).getAttributeValue()));
                binding.password.setText(mViewModel.attributeItemsList.get(position).getAttributeValue());
                binding.username.setEnabled(false);
                binding.password.setEnabled(false);
                binding.username.setFocusable(false);
                binding.password.setFocusable(false);

                if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted()) {
                    binding.editAttribute.setVisibility(View.VISIBLE);
                } else
                    binding.editAttribute.setVisibility(View.INVISIBLE);
            }

            binding.setItem(mViewModel.attributeItemsList.get(position));
            binding.setAttributeNo(position + 1);
            binding.executePendingBindings();
            binding.btnSubmit.setOnClickListener(this);
            binding.editAttribute.setOnClickListener(this);

            //Make scan barcode clickable and open barcode reader fragment
            Utilities
                    .createLink(binding.txtBarcodeScan, getString(R.string.or_scan_qr_code_for_qa_verification), getString(R.string.scan_QR_code),
                            new ClickableSpan() {
                                @Override
                                public void onClick(View widget) {
                                    Utilities.getInstance(getActivity()).replaceFragment(R.id.frame_layout, new BarcodeReaderFragment(), BarcodeReaderFragment.class.getSimpleName(), true, getActivity());

                                }

                                @Override
                                public void updateDrawState(TextPaint ds) {
                                    super.updateDrawState(ds);
                                    int linkColor = ContextCompat.getColor(getActivity(), R.color.colorPrimary);
                                    ds.setColor(linkColor);
                                    ds.setUnderlineText(false);
                                }
                            });
        }

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isSubmitButtonVisible", false))
                binding.btnSubmit.setVisibility(View.VISIBLE);
            else
                binding.btnSubmit.setVisibility(View.INVISIBLE);

            if (savedInstanceState.getBoolean("isEditButtonVisible", false)) {
                binding.editAttribute.setVisibility(View.VISIBLE);
                enableEditing();
            } else
                binding.editAttribute.setVisibility(View.INVISIBLE);

            if (isEditable)
                enableEditing();

            binding.txtLabel.setText(savedInstanceState.getString("sequenceNumber"));
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isSubmitButtonVisible", binding.btnSubmit.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditButtonVisible", binding.editAttribute.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditable", isEditable);
        outState.putString("sequenceNumber", binding.txtLabel.getText().toString());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                UserMinimal userMinimal = mViewModel.verifyQA(binding.username.getText().toString().trim(), binding.password.getText().toString().trim(), mViewModel.attributeItemsList.get(position).getUserRoles());
                if (userMinimal != null && userMinimal.getVerificationResult() != null && userMinimal.getVerificationResult().equalsIgnoreCase(Constants.QA_VALIDATION_AUTHORISED)) {
                    mViewModel.executeStepAttribute(String.valueOf(userMinimal.getId()), LogTableActions.QA_VERIFICATION.getValue(), userMinimal.getFullName(), position);
                    if ((SPFragment) getParentFragment() != null)
                        ((SPFragment) getParentFragment()).checkIfStepValidToComplete();
                    binding.passwordInputLayout.setError(null);
                    binding.userNameInputLayout.setError(null);
                    binding.btnSubmit.setVisibility(View.GONE);
                    binding.editAttribute.setVisibility(View.VISIBLE);
                    binding.username.setFocusable(false);
                    binding.password.setFocusable(false);
                    binding.username.setEnabled(false);
                    binding.password.setEnabled(false);
                    isEditable = false;
                } else if (userMinimal != null && userMinimal.getVerificationResult() != null)
                    binding.passwordInputLayout.setError(userMinimal.getVerificationResult());
                break;

            case R.id.editAttribute:
                isEditable = true;
                binding.username.setText("");
                binding.password.setText("");
                enableEditing();
                break;
        }
    }

    private void enableEditing() {
        binding.btnSubmit.setVisibility(View.VISIBLE);
        binding.editAttribute.setVisibility(View.GONE);
        binding.username.setEnabled(true);
        binding.password.setEnabled(true);
        binding.username.setFocusableInTouchMode(true);
        binding.password.setFocusableInTouchMode(true);
    }

    public void updateSequenceNumber(int sequenceNumber) {
        binding.setAttributeNo(sequenceNumber + 1);
        binding.executePendingBindings();
    }
}
