package com.icarus.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.adapters.ItemPlaceholderAdapter;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.databinding.FragmentPlaceholderCapturedValuesBinding;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.viewmodels.PlaceholderCaptureListViewModel;

import java.util.LinkedHashMap;
import java.util.List;

public class PlaceholderCaptureListActivity extends BaseActivity<FragmentPlaceholderCapturedValuesBinding, PlaceholderCaptureListViewModel> implements View.OnClickListener {

    public static final String ASSIGNED_CHECKLIST_UUID = "assigned_checklist_uuid";
    public static final String ROOMS = "rooms";
    public static final String ASSETS = "assets";
    public static final String CHECKLIST_STATUS = "checklist_status";
    public static final String CHECKLIST_TITLE = "checklist_title";
    public static final String TOOLBAR_TITLE = "toolbar_title";

    public static final String IS_CHECKLIST_OPEN = "isChecklistOpen";
    private PlaceholderCaptureListViewModel mViewModel;

    public static Intent setBundleData(Context context, String assignedChecklistUuid, String rooms,
                                       String assets, String checklistStatus, String checklistTitle, String toolbarTitle) {
        Intent intent = new Intent(context, PlaceholderCaptureListActivity.class);
        intent.putExtra(ASSIGNED_CHECKLIST_UUID, assignedChecklistUuid);
        intent.putExtra(CHECKLIST_STATUS, checklistStatus);
        intent.putExtra(ROOMS, rooms);
        intent.putExtra(ASSETS, assets);
        intent.putExtra(CHECKLIST_TITLE, checklistTitle);
        intent.putExtra(TOOLBAR_TITLE, toolbarTitle);
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_placeholder_captured_values;
    }

    @Override
    public PlaceholderCaptureListViewModel getViewModel() {
        return mViewModel = new ViewModelProvider(this).get(PlaceholderCaptureListViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        FragmentPlaceholderCapturedValuesBinding mBinding = getViewDataBinding();

        String assignedUUID = getIntent().getStringExtra(ASSIGNED_CHECKLIST_UUID);
        String checklistTitle = getIntent().getStringExtra(CHECKLIST_TITLE);
        String rooms = getIntent().getStringExtra(ROOMS);
        String assets = getIntent().getStringExtra(ASSETS);
        String checklistStatus = getIntent().getStringExtra(CHECKLIST_STATUS);

        mBinding.toolbar.setTitle(getIntent().getStringExtra(TOOLBAR_TITLE));

        //Setting toolbar
        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBinding.setRoomsHeader(getString(R.string.header_with_colon, BaseApplication.getPreferenceManager().getRoomName()));
        mBinding.setAssetHeader(getString(R.string.header_with_colon, BaseApplication.getPreferenceManager().getAssetName()));
        mBinding.setAssets(assets);
        mBinding.setRooms(rooms);
        mBinding.setChecklistStatus(checklistStatus);
        mBinding.setTitle(checklistTitle);
        mBinding.executePendingBindings();


        LinkedHashMap<String, List<ChecklistItemPlaceHolders>> checklistItemPlaceHoldersHashMap = mViewModel.getItemPlaceHolders(assignedUUID);
        ItemPlaceholderAdapter itemPlaceholderAdapter = new ItemPlaceholderAdapter(PlaceholderCaptureListActivity.this, mBinding.placeholderList, checklistItemPlaceHoldersHashMap);
        mBinding.placeholderList.setAdapter(itemPlaceholderAdapter);
        for (int i = 0; i < itemPlaceholderAdapter.getGroupCount(); i++)
            mBinding.placeholderList.expandGroup(i);

        mBinding.placeholderList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return true; // This way the expander cannot be collapsed
            }
        });

        mBinding.btnStart.setOnClickListener(this);
        mBinding.btnCancel.setOnClickListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                Intent result = new Intent();
                result.putExtra(IS_CHECKLIST_OPEN, true);
                setResult(RESULT_OK, result);
                finish();
                break;

            case R.id.btnCancel:
                finish();
                break;
        }
    }
}
