package com.icarus.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.constants.Constants;
import com.icarus.databinding.ActivityAllCaptureDataBinding;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.ElementAttributesItems;
import com.icarus.models.ElementWithCaptureDataItems;
import com.icarus.navigators.AllCaptureDataNavigator;
import com.icarus.util.DialogUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.AllCaptureDataViewModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Monika Rana on 04/10/2019
 */
public class AllCaptureDataActivity extends BaseActivity<ActivityAllCaptureDataBinding, AllCaptureDataViewModel> implements AllCaptureDataNavigator {
    private AllCaptureDataViewModel allCaptureDataViewModel;
    private ActivityAllCaptureDataBinding binding;

    public static Intent getIntent(Activity activity, int checklistId, String checklistUUID) {
        Intent itCaptureActivity = new Intent(activity, AllCaptureDataActivity.class);
        itCaptureActivity.putExtra(ChecklistDetailListingActivity.ASSIGNED_CHECKLIST_UUID, checklistUUID);
        itCaptureActivity.putExtra(Constants.CHECKLIST_ID, checklistId);
        return itCaptureActivity;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_capture_data;
    }

    @Override
    public AllCaptureDataViewModel getViewModel() {
        return new ViewModelProvider(this).get(AllCaptureDataViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();

        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.close_element_cross);
        }

        allCaptureDataViewModel = getViewModel();
        allCaptureDataViewModel.setNavigator(this);
        binding.setViewModel(allCaptureDataViewModel);
        String assignChecklistUUID = getIntent().getExtras().getString(ChecklistDetailListingActivity.ASSIGNED_CHECKLIST_UUID);
        int checklistID = getIntent().getExtras().getInt(Constants.CHECKLIST_ID);
        allCaptureDataViewModel.getElementListLiveData(assignChecklistUUID, checklistID).observe(this, new Observer<PagedList<ElementWithCaptureDataItems>>() {
            @Override
            public void onChanged(@Nullable PagedList<ElementWithCaptureDataItems> elementWithCaptureDataItems) {
                allCaptureDataViewModel.getElementListAdapter().submitList(elementWithCaptureDataItems);
                if (elementWithCaptureDataItems == null || elementWithCaptureDataItems.size() == 0)
                    binding.txtEmptyView.setVisibility(View.VISIBLE);
                else binding.txtEmptyView.setVisibility(View.GONE);
                //hide loader after list fetched
                allCaptureDataViewModel.setIsLoading(false);
            }
        });
        binding.executePendingBindings();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void observeElementAttribute(LiveData<List<ElementAttributesItems>> elementAttributesItemsLiveData, final int position) {
        elementAttributesItemsLiveData.observe(AllCaptureDataActivity.this, new Observer<List<ElementAttributesItems>>() {
            @Override
            public void onChanged(@Nullable List<ElementAttributesItems> elementAttributesItems) {

                if (elementAttributesItems != null && elementAttributesItems.size() > 0) {
                    Collections.sort(elementAttributesItems);
                    LinkedHashMap<Integer, List<ElementAttributesItems>> logsHashMapAttributes = new LinkedHashMap<>();

                    for (ElementAttributesItems attributeItem : elementAttributesItems) {
                        int key = attributeItem.getId();
                        if (logsHashMapAttributes.get(key) == null) {
                            logsHashMapAttributes.put(key, new ArrayList<ElementAttributesItems>());
                        }
                        logsHashMapAttributes.get(key).add(attributeItem);

                    }


                    allCaptureDataViewModel.getElementListAdapter().getChecklist(position).setElementAttributesItemsList(logsHashMapAttributes);
                    binding.rvElements.post(new Runnable() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void run() {
                            allCaptureDataViewModel.getElementListAdapter().notifyDataSetChanged();
                        }
                    });
                }

            }
        });
    }

    @Override
    public void openClickedFile(String filePath) {
        try {
            File fileDestinationFolder = FileUtils.getResourcesAttachmentsDir();
            if (fileDestinationFolder == null) {
                showMessage(getString(R.string.file_path_error));
                return;
            }

            String openFilePath = new File(fileDestinationFolder, filePath).getPath();
            String contentType = Utilities.getInstance(AllCaptureDataActivity.this).getMimeTypes(openFilePath);

            Utilities.getInstance(AllCaptureDataActivity.this)
                    .openFile(filePath,
                            contentType,
                            AllCaptureDataActivity.this);
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessage(getString(R.string.file_path_error));
        }
    }

    @Override
    public void showMessage(String message) {
        Utilities.getInstance(AllCaptureDataActivity.this).showToast(message, Toast.LENGTH_LONG, AllCaptureDataActivity.this);
    }

    @Override
    public void popUpAskDownload(final String filePath, final String itemUUID) {
        DialogUtility.showAlertWithTwoButtonsOnly(AllCaptureDataActivity.this,
                getString(R.string.ask_image_download), R.string.ok, R.string.cancel, new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        allCaptureDataViewModel.downloadCapturedFiles(filePath, itemUUID);
                    }

                    @Override
                    public void onNegativeButtonClick() {
                        //Do Nothing
                    }
                });
    }

}
