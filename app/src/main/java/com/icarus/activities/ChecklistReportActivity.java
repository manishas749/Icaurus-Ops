package com.icarus.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.databinding.ActivityChecklistReportBinding;
import com.icarus.listeners.OnSelectListener;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.ChecklistNotesItem;
import com.icarus.models.LogsSummary;
import com.icarus.navigators.ChecklistReportNavigator;
import com.icarus.util.DialogUtility;
import com.icarus.util.FileUtils;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChecklistReportViewModel;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

public class ChecklistReportActivity extends BaseActivity<ActivityChecklistReportBinding, ChecklistReportViewModel> implements ChecklistReportNavigator {

    private ActivityChecklistReportBinding binding;
    private ChecklistReportViewModel checklistReportViewModel;
    public static final String CHECKLIST_ID = "CHECKLIST_ID";
    public static final String CHECKLIST_UUID = "CHECKLIST_UUID";


    @Override
    public ActivityChecklistReportBinding getViewDataBinding() {
        return super.getViewDataBinding();
    }

    public static Intent getIntent(Context context, int checklistId, String checklistUUID) {
        return new Intent(context, ChecklistReportActivity.class)
                .putExtra(ChecklistReportActivity.CHECKLIST_ID, checklistId)
                .putExtra(ChecklistReportActivity.CHECKLIST_UUID, checklistUUID);

    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_checklist_report;
    }

    @Override
    public ChecklistReportViewModel getViewModel() {
        return checklistReportViewModel = new ViewModelProvider(this).get(ChecklistReportViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        binding.setViewModel(checklistReportViewModel);
        checklistReportViewModel.setNavigator(this);
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int checklistId = getIntent().getExtras().getInt(ChecklistExecutionActivity.CHECKLIST_ID);
        final String checklistUUId = getIntent().getExtras().getString(ChecklistExecutionActivity.CHECKLIST_UUID);

        checklistReportViewModel.fetchReport(checklistUUId, checklistId);
        // binding.executePendingBindings();
        //Observe notes list for adding on notes list adapter
        checklistReportViewModel.observeNotesList().observe(this, new Observer<PagedList<ChecklistNotesItem>>() {
            @Override
            public void onChanged(@Nullable PagedList<ChecklistNotesItem> checklistNotes) {
                checklistReportViewModel.getNotesAdapter().submitList(checklistNotes);
                if (checklistNotes == null || checklistNotes.size() == 0)
                    binding.txtNotesHeader.setVisibility(View.GONE);
                else
                    binding.txtNotesHeader.setVisibility(View.VISIBLE);
            }
        });

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
    public void onGetChecklistLogSummary(LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> checklistDetailItems) {
        getChecklistElements(checklistDetailItems);
    }

    @Override
    public void getChecklistElements(final LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> logsSummary) {

        checklistReportViewModel.getElementListLiveData().observe(ChecklistReportActivity.this,
                new Observer<PagedList<ChecklistElementItem>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<ChecklistElementItem> checklistDetailItems) {
                        checklistReportViewModel.getAdapter().setLogsHashMap(logsSummary);
                        checklistReportViewModel.getAdapter().submitList(checklistDetailItems);
                        checklistReportViewModel.setIsLoading(false);

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
            String contentType = Utilities.getInstance(ChecklistReportActivity.this).getMimeTypes(openFilePath);

            Utilities.getInstance(ChecklistReportActivity.this)
                    .openFile(filePath,
                            contentType,
                            ChecklistReportActivity.this);
        } catch (Exception ex) {
            ex.printStackTrace();
            showMessage(getString(R.string.file_path_error));
        }
    }

    @Override
    public void showMessage(String message) {
        Utilities.getInstance(ChecklistReportActivity.this).showToast(message, Toast.LENGTH_LONG, ChecklistReportActivity.this);
    }

    @Override
    public void popUpAskDownload(final String filePath, final String itemUUID) {
        DialogUtility.showAlertWithTwoButtonsOnly(ChecklistReportActivity.this,
                getString(R.string.ask_image_download), R.string.ok, R.string.cancel, new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        checklistReportViewModel.downloadCapturedFiles(filePath, itemUUID);
                    }

                    @Override
                    public void onNegativeButtonClick() {
                        //Do Nothing
                    }
                });
    }
}
