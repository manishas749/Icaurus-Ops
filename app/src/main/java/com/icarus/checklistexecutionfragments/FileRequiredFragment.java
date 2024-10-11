package com.icarus.checklistexecutionfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.ChecklistExecutionActivity;
import com.icarus.adapters.FileRequiredAdapter;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentProcedureRecordImageBinding;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.models.CheckListStepAttributeItems;
import com.icarus.models.SelectedFile;
import com.icarus.navigators.SPExecutionNavigator;
import com.icarus.util.FileUtils;
import com.icarus.util.ImagePickerUtils;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;


/**
 * Created by Monika Rana on 1/25/2019.
 */

public class FileRequiredFragment extends BaseFragment<FragmentProcedureRecordImageBinding, ChecklistExecutionViewModel> implements View.OnClickListener {
    private FragmentProcedureRecordImageBinding binding;
    private ChecklistExecutionViewModel mViewModel;
    private CheckListStepAttributeItems mCheckListStepAttributeItems;
    private ImagePickerUtils mImagePickerUtils;
    private int positionOfAttribute;
    private FileRequiredAdapter mAdapter;
    private boolean isEditable = false;
    int fileAdapterPositionInViewModel = 0;

    public static FileRequiredFragment getInstance(int position, SPExecutionNavigator navigator) {
        Bundle args = new Bundle();
        args.putInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, position);
        FileRequiredFragment fragment = new FileRequiredFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_procedure_record_image;
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

        positionOfAttribute = getArguments() != null ? getArguments().getInt(ChecklistExecutionActivity.ATTRIBUTE_POSITION, 0) : 0;
        if (savedInstanceState == null) {
            fileAdapterPositionInViewModel = mViewModel.getFileAdapterPosition();
            mAdapter = new FileRequiredAdapter(mViewModel);
        } else {
            fileAdapterPositionInViewModel = savedInstanceState.getInt("fileAdapterPositionInViewModel", 0);
            mAdapter = mViewModel.getFileRequiredAdapter(fileAdapterPositionInViewModel);
        }

        if (mViewModel.attributeItemsList != null && positionOfAttribute < mViewModel.attributeItemsList.size()) {
            mCheckListStepAttributeItems = mViewModel.attributeItemsList.get(positionOfAttribute);

            binding.setItem(mCheckListStepAttributeItems);
            binding.setAttributeNo(positionOfAttribute + 1);
            List<AssignedStepFileResourceEntity> files = mViewModel.getAttributeFiles(positionOfAttribute, mViewModel.getChecklistElementDetail().getElementId());

            if (files == null || files.size() == 0) {
                binding.btnSubmit.setVisibility(View.VISIBLE);
                binding.editAttribute.setVisibility(View.INVISIBLE);
                binding.imgAdd.setEnabled(true);
                binding.imgAdd.setVisibility(View.VISIBLE);
            } else {
                if (savedInstanceState == null) {
                    for (int i = 0; i < files.size(); i++) {
                        AssignedStepFileResourceEntity assignedStepFleResourceEntity = files.get(i);
                        SelectedFile selectedFile = new SelectedFile(assignedStepFleResourceEntity.getFile_name(),
                                assignedStepFleResourceEntity.getFile_md5_checksum(), assignedStepFleResourceEntity.getDisplay_file_name(),
                                assignedStepFleResourceEntity.getContent_type(), assignedStepFleResourceEntity.getUuid(), false, true);
                        mViewModel.setFileRequiredItem(selectedFile, mAdapter);
                    }
                    mViewModel.setFileRequiredAdapterInList(mAdapter, fileAdapterPositionInViewModel);
                }
                binding.btnSubmit.setVisibility(View.INVISIBLE);
                binding.imgAdd.setEnabled(false);
                binding.imgAdd.setVisibility(View.GONE);

                if ((mViewModel.getChecklistElementDetail().isSkipped() || mViewModel.getChecklistElementDetail().isDeferred()) || !mViewModel.isStepExecuted()) {
                    binding.editAttribute.setVisibility(View.VISIBLE);
                    binding.imgAdd.setVisibility(View.GONE);
                } else
                    binding.editAttribute.setVisibility(View.INVISIBLE);
            }

            binding.recyclerViewSelectedImages.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.recyclerViewSelectedImages.setAdapter(mAdapter);
            binding.setViewModel(mViewModel);
            binding.executePendingBindings();
            binding.btnSubmit.setOnClickListener(this);
            binding.imgAdd.setOnClickListener(this);
            binding.editAttribute.setOnClickListener(this);
        }

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("isSubmitButtonVisible", false))
                binding.btnSubmit.setVisibility(View.VISIBLE);
            else
                binding.btnSubmit.setVisibility(View.INVISIBLE);

            if (savedInstanceState.getBoolean("isEditButtonVisible", false)) {
                binding.editAttribute.setVisibility(View.VISIBLE);
            } else
                binding.editAttribute.setVisibility(View.INVISIBLE);

            if (isEditable)
                binding.editAttribute.callOnClick();

            binding.label.setText(savedInstanceState.getString("sequenceNumber"));
        }
    }



    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isSubmitButtonVisible", binding.btnSubmit.getVisibility() == View.VISIBLE);
        outState.putBoolean("isEditButtonVisible", binding.editAttribute.getVisibility() == View.VISIBLE);
        outState.putInt("fileAdapterPositionInViewModel", fileAdapterPositionInViewModel);
        outState.putString("sequenceNumber", binding.label.getText().toString());
        outState.putBoolean("isEditable", isEditable);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                if ((FileRequiredAdapter) binding.recyclerViewSelectedImages.getAdapter() != null && mAdapter.getItemCount() > 0) {
                    mViewModel.executeStepFileResources(positionOfAttribute, (FileRequiredAdapter) binding.recyclerViewSelectedImages.getAdapter());
                    binding.editAttribute.setVisibility(View.VISIBLE);
                    binding.btnSubmit.setVisibility(View.INVISIBLE);
                    if ((SPFragment) getParentFragment() != null)
                        ((SPFragment) getParentFragment()).checkIfStepValidToComplete();
                    binding.editAttribute.setVisibility(View.VISIBLE);
                    binding.imgAdd.setEnabled(false);
                    binding.imgAdd.setVisibility(View.GONE);
                    for (SelectedFile selectedFile : mAdapter.getItems())
                        selectedFile.setDeletable(false);
                    mAdapter.notifyDataSetChanged();
                    isEditable = false;
                } else
                    Utilities.getInstance(getActivity()).showToast(getString(R.string.attach_file), Toast.LENGTH_LONG, getActivity());
                break;

            case R.id.editAttribute:
                binding.imgAdd.setOnClickListener(this);
                binding.editAttribute.setVisibility(View.INVISIBLE);
                binding.btnSubmit.setVisibility(View.VISIBLE);
                binding.imgAdd.setVisibility(View.VISIBLE);
                binding.imgAdd.setEnabled(true);
                isEditable = true;
                for (SelectedFile selectedFile : mAdapter.getItems())
                    selectedFile.setDeletable(true);
                mAdapter.notifyDataSetChanged();
                break;

            case R.id.imgAdd:
                File fileDestinationFolder = FileUtils.getResourcesAttachmentsDir();
                if (fileDestinationFolder == null) {
                    Utilities.getInstance(getActivity()).
                            showToast(getString(R.string.file_create_error), Toast.LENGTH_LONG, getActivity());
                    return;
                }
                mImagePickerUtils = ImagePickerUtils.getInstance(fileDestinationFolder, this, new ImagePickerUtils.ImagePickerListener() {
                    @Override
                    public void onImageSelected(SelectedFile selectedFile) {
                        if (mCheckListStepAttributeItems.getMultiple() != null && mCheckListStepAttributeItems.getMultiple() == 1)
                            mViewModel.setFileRequiredItem(selectedFile, (FileRequiredAdapter) binding.recyclerViewSelectedImages.getAdapter());
                        else
                            mViewModel.setSingleFileRequiredItem(selectedFile, (FileRequiredAdapter) binding.recyclerViewSelectedImages.getAdapter());

                        mViewModel.setFileRequiredAdapterInList(mAdapter, fileAdapterPositionInViewModel);
                    }

                    @Override
                    public void onImageSelectionError() {

                    }
                });

                mImagePickerUtils.selectImage(mCheckListStepAttributeItems.getAllowGallery(), mCheckListStepAttributeItems.getAllowedMediaTypes(), mCheckListStepAttributeItems.getMultiple());
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mImagePickerUtils != null)
            mImagePickerUtils.onActivityResult(requestCode, resultCode, data);
        else
            Utilities.getInstance(getActivity()).showToast(getString(R.string.error_while_getting_file), Toast.LENGTH_LONG, getActivity());
    }

    public void updateSequenceNumber(int sequenceNumber) {
        binding.setAttributeNo(sequenceNumber + 1);
        binding.executePendingBindings();
    }
}

