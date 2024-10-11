package com.icarus.workorder.activities;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;
import com.icarus.BR;
import com.icarus.R;
import com.icarus.activities.DashboardActivity;
import com.icarus.activities.LocationChangeActivity;
import com.icarus.activities.LoginActivity;
import com.icarus.base.BaseActivity;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.databinding.ActivityWorkorderBinding;
import com.icarus.util.Navigator;
import com.icarus.util.SearchContentProvider;
import com.icarus.workorder.fragments.FilterBottomSheetWorkOrderFragment;
import com.icarus.workorder.fragments.SortBottomSheetWorkOrderFragment;
import com.icarus.workorder.fragments.WorkorderFragment;
import com.icarus.workorder.viewmodels.WorkOrderViewModel;

import c.anurag.database.application.BaseApplication;

/**
 * Created by Anurag Purwar on 12/25/2018.
 */

public class WorkorderActivity extends BaseActivity<ActivityWorkorderBinding, WorkOrderViewModel> implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private WorkOrderViewModel mWorkOrderViewModel;
    private ActivityWorkorderBinding mBinding;
    private WorkorderFragment fragment;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_workorder;
    }

    @Override
    public WorkOrderViewModel getViewModel() {
        return mWorkOrderViewModel = new ViewModelProvider(this).get(WorkOrderViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  mWorkOrderViewModel.setNavigator(this);
        mBinding = getViewDataBinding();
        setSupportActionBar(mBinding.navigationDrawer.toolbar);

        setupNavDrawer();
        setClickListener();
        //Showing My assigned checklist initially
        displayFragment();
        /*View fab = findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.launchActivityWithResult(v.getContext(), Constants.REQUEST_RESULT_FOR_WORK_ORDER, new Intent(v.getContext(), WorkOrderCreateActivity.class));
            }
        });*/
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
        //Handle search
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (intent != null && Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SearchContentProvider.AUTHORITY, SearchContentProvider.MODE);
            suggestions.saveRecentQuery(query, null);
            mWorkOrderViewModel.setSearchKeyword(query);
            mWorkOrderViewModel.getWorkOrder(0, mWorkOrderViewModel.getSearchKeyword());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void setClickListener() {
        mBinding.navigationDrawer.sort.setOnClickListener(this);
        mBinding.navigationDrawer.filter.setOnClickListener(this);
    }

    private void setupNavDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mBinding.drawerLayout, mBinding.navigationDrawer.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mBinding.navView.setNavigationItemSelectedListener(this);
        ((TextView) mBinding.navView.getHeaderView(0).findViewById(R.id.name)).setText(BaseApplication.getPreferenceManager().getUserFullName());
        ((TextView) mBinding.navView.getHeaderView(0).findViewById(R.id.location)).setText(BaseApplication.getPreferenceManager().getUserLocationName());

    }

    @Override
    public void onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                super.onSearchRequested();
                break;
            default:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayFragment() {
        fragment = new WorkorderFragment();
        mWorkOrderViewModel.clearFilters();
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getString(R.string.workorder));
        mWorkOrderViewModel.sortWorkOrderBy.setName(getResources().getString(R.string.due_date_desc));
        mWorkOrderViewModel.sortWorkOrderBy.setTag(SortingTag.DUE_DATE_DESC);

        setFragment(fragment);
    }

    private void setFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sort:
                if (!isFinishing()) {
                    SortBottomSheetWorkOrderFragment myBottomSheet = SortBottomSheetWorkOrderFragment.getInstance();
                    myBottomSheet.show(getSupportFragmentManager(), SortBottomSheetWorkOrderFragment.class.getSimpleName());
                }
                break;
            case R.id.filter:
                if (!isFinishing()) {
                    FilterBottomSheetWorkOrderFragment myBottomSheet = FilterBottomSheetWorkOrderFragment.getInstance();
                    myBottomSheet.show(getSupportFragmentManager(), FilterBottomSheetWorkOrderFragment.class.getSimpleName());
                }
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Refresh checklist when location is changed
        if (requestCode == Constants.REQUEST_RESULT_FOR_LOCATION && resultCode == RESULT_OK && data != null) {
            boolean isLocationSelected = data.getBooleanExtra(LocationChangeActivity.IS_LOCATION_SELECTED, false);
            if (isLocationSelected) {
                mWorkOrderViewModel.clearFilters();
                mWorkOrderViewModel.clearWorkOrder();
                displayFragment();
            }
        } else if (requestCode == Constants.REQUEST_RESULT_FOR_WORK_ORDER && resultCode == RESULT_OK && data != null) {
            boolean refresh = data.getBooleanExtra(Constants.REFRESH_SCREEN, false);
            if (refresh) {
                fragment.reset();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        switch (menuItem.getItemId()) {
            case R.id.nav_all_checklist:
                Navigator.launchActivity(this, new Intent(this, DashboardActivity.class));
                break;
            case R.id.nav_my_assigned_checklist:
                //displayAllChecklist(ChecklistTag.MY_ASSIGNED_CHECKLIST);
                break;
            case R.id.nav_my_department_checklist:
                //displayAllChecklist(ChecklistTag.MY_DEPARTMENT_CHECKLIST);
                break;
            case R.id.nav_workorder:
                Navigator.launchActivity(this, new Intent(this, WorkorderActivity.class));
                break;
            case R.id.nav_change_location:
                Navigator.launchActivityWithResult(this, Constants.REQUEST_RESULT_FOR_LOCATION, new Intent(this, LocationChangeActivity.class));
                break;
            case R.id.nav_logout:
                com.icarus.base.BaseApplication.getPreferenceManager().logout();
                Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LoginActivity.class));
                break;
        }
        mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
