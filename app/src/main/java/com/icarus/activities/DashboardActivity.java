package com.icarus.activities;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.google.android.material.navigation.NavigationView;
import com.icarus.BR;
import com.icarus.BuildConfig;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.ChecklistTag;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.dao.MainUserDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.database.UserDatabase;
import com.icarus.databinding.ActivityDashboardBinding;
import com.icarus.databinding.DialogSyncingBinding;
import com.icarus.entities.LocationEntity;
import com.icarus.fragments.AllChecklistFragment;
import com.icarus.fragments.CancelledChecklistFragment;
import com.icarus.fragments.CompletedChecklistFragment;
import com.icarus.fragments.DepartmentChecklistFragment;
import com.icarus.fragments.FilterBottomSheetFragment;
import com.icarus.fragments.MyAssignedFragment;
import com.icarus.fragments.SearchSuggestionFragment;
import com.icarus.fragments.SortBottomSheetFragment;
import com.icarus.listeners.OnSelectListener;
import com.icarus.listeners.SearchSelectedListener;
import com.icarus.synchronization.SyncWorkManager;
import com.icarus.util.DialogUtility;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.DashboardViewModel;
import com.icarus.workorder.fragments.WorkorderFragment;

import java.util.LinkedHashMap;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class DashboardActivity extends BaseActivity<ActivityDashboardBinding, DashboardViewModel> implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SearchSelectedListener {
    public static final int SYNC_INITIAL_PERCENTAGE = 0;
    public static final int SYNC_MASTER_PERCENTAGE = 20;
    public static final int SYNC_ASSIGNED_PERCENTAGE = 40;
    public static final int SYNC_WORKORDER_PERCENTAGE = 60;
    public static final int SYNC_POST_PERCENTAGE = 80;
    public static final String TAG = "DashboardActivity";
    public static final String SYNC_FAILED = "sync_failed";
    public static final String SYNC_PERCENTAGE = "sync_percentage";
    public static final String IS_NOTIFICATION = "is_notification";
    private DashboardViewModel mDashboardViewModel;
    private ActivityDashboardBinding mBinding;
    public static String IS_FILTER_EMERGENCY = "is_filter_emergency";
    private AlertDialog syncDialog, retrySyncDialog;
    private LiveData<Integer> lastLiveSyncStatus;
    private Menu menu;
    private DialogSyncingBinding syncDialogBinding;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isSyncFailed = intent.getBooleanExtra(SYNC_FAILED, false);
            if (isSyncFailed) {
                cancelAlert();
                showSyncRetryDialog(true);
            }
        }
    };

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }

    @Override
    public DashboardViewModel getViewModel() {
        return mDashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  mDashboardViewModel.setNavigator(this);
        mBinding = getViewDataBinding();
        setSupportActionBar(mBinding.navigationDrawer.toolbar);
        setupNavDrawer(true);
        setClickListener();
        mDashboardViewModel.setClientSetting();
        if (getIntent() != null && getIntent().getBooleanExtra(IS_FILTER_EMERGENCY, false)) {
            //If emergency paused show paused checklist
            handleIntent(getIntent());
        } else
            //Showing My assigned checklist initially
            displayAllChecklist(ChecklistTag.MY_ASSIGNED_CHECKLIST);

        mBinding.navigationDrawer.searchView.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBinding.navigationDrawer.frameLayoutSearch.setVisibility(View.VISIBLE);
                //    mDashboardViewModel.getSearchSuggestionAdapter().getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBinding.navigationDrawer.searchView.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String searchTxt = v.getText().toString();
                    mDashboardViewModel.setSearchKeyword(v.getText().toString());
                    mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
                    if (!searchTxt.isEmpty()) {
                        mDashboardViewModel.saveSearchSuggestionList(searchTxt);
                        mDashboardViewModel.getSearchSuggestionAdapter().refreshList();
                    }
                    mBinding.navigationDrawer.frameLayoutSearch.setVisibility(View.GONE);
                    Utilities.getInstance(DashboardActivity.this).closeKeyboard(v, DashboardActivity.this);
                    return true;
                }
                return false;
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        // get menu from side navigationView
        menu = navigationView.getMenu();
        //set click listeners
        mBinding.navigationDrawer.searchView.imageClear.setOnClickListener(this);
        mBinding.version.setText(String.format(getString(R.string.version_name), BuildConfig.VERSION_NAME));
        mBinding.sync.setOnClickListener(this);
        startSyncing(getIntent().getBooleanExtra(IS_NOTIFICATION, false));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.navigationDrawer.searchView.etSearch.clearFocus();
    }

    private void handleIntent(Intent intent) {
        if (intent != null && getIntent().getBooleanExtra(IS_FILTER_EMERGENCY, false)) {
            mDashboardViewModel.clearFilters();
            mDashboardViewModel.setSearchKeyword("");
            mBinding.navigationDrawer.searchView.etSearch.setText("");
            mDashboardViewModel.selectedCheckList = ChecklistTag.ALL_CHECKLIST;
            mDashboardViewModel.setTypeEmergencyFilter();
            AllChecklistFragment fragment = new AllChecklistFragment();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.all_checklist));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.favorite_on_top));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.FAVORITE);
            setFragment(fragment, mDashboardViewModel.selectedCheckList);
        }
        Utilities.getInstance(DashboardActivity.this).closeKeyboard(mBinding.navigationDrawer.searchView.etSearch, DashboardActivity.this);
        hideSearchView();
    }

    private void setClickListener() {
        mBinding.navigationDrawer.sort.setOnClickListener(this);
        mBinding.navigationDrawer.filter.setOnClickListener(this);
    }

    private void setupNavDrawer(boolean isFirstTime) {
        if (isFirstTime) {
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, mBinding.drawerLayout, mBinding.navigationDrawer.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mBinding.drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            mBinding.navView.setNavigationItemSelectedListener(this);
        }

        mDashboardViewModel.setUserName(BaseApplication.getPreferenceManager().getUserFullName());
        mDashboardViewModel.getLocation();
    }

    @Override
    public void onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else if (mBinding.navigationDrawer.searchView.parent.getVisibility() == View.VISIBLE) {
            mBinding.navigationDrawer.searchView.etSearch.setText("");
            mBinding.navigationDrawer.searchView.parent.setVisibility(View.GONE);
            mBinding.navigationDrawer.frameLayoutSearch.setVisibility(View.GONE);
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
                mBinding.navigationDrawer.searchView.parent.setVisibility(View.VISIBLE);
                mBinding.navigationDrawer.frameLayoutSearch.setVisibility(View.VISIBLE);
                mBinding.navigationDrawer.searchView.etSearch.setHint(mDashboardViewModel.getSearchHint());
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayoutSearch, SearchSuggestionFragment.getInstance(this), SearchSuggestionFragment.class.getSimpleName());
                fragmentTransaction.commitAllowingStateLoss();
                mBinding.navigationDrawer.searchView.etSearch.requestFocus();
                Utilities.getInstance(DashboardActivity.this).showKeyboard(mBinding.navigationDrawer.searchView.etSearch, DashboardActivity.this);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        switch (menuItem.getItemId()) {
            case R.id.nav_all_checklist:
                displayAllChecklist(ChecklistTag.ALL_CHECKLIST);
                break;
            case R.id.nav_my_assigned_checklist:
                displayAllChecklist(ChecklistTag.MY_ASSIGNED_CHECKLIST);
                break;
            case R.id.nav_my_department_checklist:
                displayAllChecklist(ChecklistTag.MY_DEPARTMENT_CHECKLIST);
                break;
            case R.id.nav_cancelled_checklist:
                displayAllChecklist(ChecklistTag.CANCELLED_CHECKLIST);
                break;
            case R.id.nav_completed_checklist:
                displayAllChecklist(ChecklistTag.COMPLETED_CHECKLIST);
                break;
            case R.id.nav_workorder:
                displayAllChecklist(ChecklistTag.WORK_ORDER);
                // Navigator.launchActivity(this, new Intent(this, WorkorderActivity.class));
                break;
            case R.id.nav_change_location:
                Navigator.launchActivityWithResult(this, Constants.REQUEST_RESULT_FOR_LOCATION, new Intent(this, LocationChangeActivity.class));
                break;
            case R.id.nav_logout:
                final AppDatabase appDatabase = AppDatabase.getInstance(this);
                final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
                Integer lastSyncStatus = postSynchronizationDao.getLastSyncStatus(BaseApplication.getPreferenceManager().getUserLocationId());
                if (lastSyncStatus.equals(Constants.SYNC_STATUS_RESOURCE_DOWNLOAD_UPLOAD)) {
                    DialogUtility.showAlertWithTwoButtonsOnly(DashboardActivity.this,
                            getString(R.string.logout_popup_message),
                            R.string.yes_logout, R.string.no,
                            new OnSelectListener() {
                                @Override
                                public void onPositiveButtonClick() {
                                    WorkManager.getInstance(BaseApplication.getContext()).cancelAllWork();
                                    if (lastLiveSyncStatus != null) {
                                        lastLiveSyncStatus.removeObservers(DashboardActivity.this);
                                    }
                                    postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_COMPLETED, BaseApplication.getPreferenceManager().getUserLocationId());
                                    BaseApplication.getPreferenceManager().logout();
                                    Navigator.launchActivityAndFinishCurrent(DashboardActivity.this, new Intent(DashboardActivity.this, LoginActivity.class));
                                }

                                @Override
                                public void onNegativeButtonClick() {

                                }
                            });
                } else {
                    BaseApplication.getPreferenceManager().logout();
                    Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LoginActivity.class));
                }
                break;
        }
        mBinding.drawerLayout.closeDrawer(GravityCompat.START);

        Utilities.getInstance(DashboardActivity.this).closeKeyboard(mBinding.navigationDrawer.searchView.etSearch, DashboardActivity.this);
        return false;
    }

    private void updateSyncTime(final boolean isFirstSync) {
        LocalBroadcastManager.getInstance(DashboardActivity.this).registerReceiver(broadcastReceiverForSyncMessage, new IntentFilter(TAG));
        final AppDatabase appDatabase = AppDatabase.getInstance(this);
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_INPROGRESS, BaseApplication.getPreferenceManager().getUserLocationId());
        if (lastLiveSyncStatus != null) {
            lastLiveSyncStatus.removeObservers(this);
        }
        lastLiveSyncStatus = postSynchronizationDao.getLiveLastSyncStatus(BaseApplication.getPreferenceManager().getUserLocationId());
        if (isFirstSync) {
            LocalBroadcastManager.getInstance(DashboardActivity.this).registerReceiver(broadcastReceiver, new IntentFilter(TAG));
        }
        lastLiveSyncStatus.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer lastSyncStatus) {
                if (lastSyncStatus != null) {
                    if (lastSyncStatus.equals(Constants.SYNC_STATUS_RESOURCE_DOWNLOAD_UPLOAD)) {
                        setCountOnSideMenu(menu);
                        if (syncDialog != null && syncDialog.isShowing()) {
                            Utilities.getInstance(DashboardActivity.this).showToast(isFirstSync ? getString(R.string.sync_successful) :
                                    getString(R.string.synchronization_completed), Toast.LENGTH_LONG, DashboardActivity.this);
                        }
                        //  BaseApplication.getPreferenceManager().setLoginUserLocations("");
                        //updateUI(postSynchronizationDao);
                        if (broadcastReceiver != null)
                            LocalBroadcastManager.getInstance(DashboardActivity.this).unregisterReceiver(broadcastReceiver);

                        if (broadcastReceiverForSyncMessage != null)
                            LocalBroadcastManager.getInstance(DashboardActivity.this).unregisterReceiver(broadcastReceiverForSyncMessage);
                        mDashboardViewModel.setClientSetting();
                        checkLocationIfStillExist(postSynchronizationDao);
                        mBinding.navigationDrawer.message.setVisibility(View.VISIBLE);
                        cancelAlert();
                    } else if (lastSyncStatus.equals(Constants.SYNC_STATUS_FAILED)) {
                        setCountOnSideMenu(menu);
                        showSyncRetryDialog(isFirstSync);
                        postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_PENDING, BaseApplication.getPreferenceManager().getUserLocationId());
                        cancelAlert();
                    } else if (lastSyncStatus.equals(Constants.SYNC_STATUS_UNAUTHORIZED)) {
                        postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_PENDING, BaseApplication.getPreferenceManager().getUserLocationId());
                        Utilities.getInstance(DashboardActivity.this).showToast(getString(R.string.unauthorized), Toast.LENGTH_LONG, DashboardActivity.this);
                        cancelAlert();
                        UserDatabase userDatabase = UserDatabase.getInstance(DashboardActivity.this);
                        final MainUserDao mainUserDao = userDatabase.userDao();
                        mainUserDao.deleteUser(BaseApplication.getPreferenceManager().getUserId());
                        BaseApplication.getPreferenceManager().logout();
                        Navigator.launchActivityAndFinishCurrent(DashboardActivity.this, new Intent(DashboardActivity.this, LoginActivity.class));
                    } else if (lastSyncStatus.equals(Constants.SYNC_STATUS_COMPLETED)) {
                        setCountOnSideMenu(menu);
                        if (syncDialog != null && syncDialog.isShowing()) {
                            Utilities.getInstance(DashboardActivity.this).showToast(isFirstSync ? getString(R.string.sync_successful) :
                                    getString(R.string.synchronization_completed), Toast.LENGTH_LONG, DashboardActivity.this);
                        }
                        setupNavDrawer(false);
                        mDashboardViewModel.setClientSetting();
                        checkLocationIfStillExist(postSynchronizationDao);
                        mBinding.navigationDrawer.message.setVisibility(View.GONE);
                        cancelAlert();
                    }

                }
            }
        });
    }

    /**
     * @param postSynchronizationDao This method fetches location list and handles the result
     */
    private void checkLocationIfStillExist(final PostSynchronizationDao postSynchronizationDao) {
        mDashboardViewModel.fetchLocation();

        //Observing Location response is logged user is not admin
        mDashboardViewModel.observeLocationsResponse().observe(this, new Observer<LinkedHashMap<Integer, LocationEntity>>() {
            @Override
            public void onChanged(@Nullable LinkedHashMap<Integer, LocationEntity> locationItemsLinkedHashMap) {
                BaseApplication.getPreferenceManager().setLoginUserLocations("");
                //Check if location saved exist or not, if saved location does not exists exit the screen
                if (mDashboardViewModel.ifSelectedLocationStillExist(BaseApplication.getPreferenceManager().getUserLocationId(), locationItemsLinkedHashMap))
                    updateUI(postSynchronizationDao);
                else
                    showChangeLocationLogoutPopup();
                getViewModel().setIsLoading(false);
            }
        });
    }

    private void showChangeLocationLogoutPopup() {
        BaseApplication.getPreferenceManager().setUserLocationName("");
        BaseApplication.getPreferenceManager().setUserLocationId(-1);
        DialogUtility.showAlertWithTwoButtonsOnly(DashboardActivity.this, getString(R.string.location_changed), R.string.change_location, R.string.logout, new OnSelectListener() {
            @Override
            public void onPositiveButtonClick() {
                Navigator.launchActivityAndFinishCurrent(DashboardActivity.this, new Intent(DashboardActivity.this, LocationChangeActivity.class));
            }

            @Override
            public void onNegativeButtonClick() {
                BaseApplication.getPreferenceManager().logout();
                Navigator.launchActivityAndFinishCurrent(DashboardActivity.this, new Intent(DashboardActivity.this, LoginActivity.class));
            }
        });
    }

    private void updateUI(PostSynchronizationDao postSynchronizationDao) {
        if (mDashboardViewModel.isChecklistEmpty.get())
            displayAllChecklist(mDashboardViewModel.selectedCheckList);
        mDashboardViewModel.setLastSync(postSynchronizationDao.getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId()));
    }


    private void displayAllChecklist(String tag) {
        Fragment fragment = new Fragment();
        mDashboardViewModel.clearFilters();
        mDashboardViewModel.isFilterApplied.set(false);
        mBinding.navigationDrawer.searchView.etSearch.setText("");
        mBinding.navigationDrawer.searchView.parent.setVisibility(View.GONE);
        mBinding.navigationDrawer.frameLayoutSearch.setVisibility(View.GONE);
        if (tag.equals(ChecklistTag.MY_ASSIGNED_CHECKLIST)) {
            fragment = new MyAssignedFragment();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.my_assigned_checklist));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.due_date_asc));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.DUE_DATE_ASC);
        } else if (tag.equals(ChecklistTag.ALL_CHECKLIST)) {
            fragment = new AllChecklistFragment();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.all_checklist));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.favorite_on_top));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.FAVORITE);
        } else if (tag.equals(ChecklistTag.MY_DEPARTMENT_CHECKLIST)) {
            fragment = new DepartmentChecklistFragment();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.my_department_checklist));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.due_date_asc));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.DUE_DATE_ASC);
        } else if (tag.equals(ChecklistTag.COMPLETED_CHECKLIST)) {
            fragment = CompletedChecklistFragment.getInstance();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.completed_checklist));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.last_updated_desc));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.MODIFIED_DESC);
        } else if (tag.equals(ChecklistTag.CANCELLED_CHECKLIST)) {
            fragment = CancelledChecklistFragment.getInstance();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.cancelled_checklist));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.last_updated_desc));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.MODIFIED_DESC);
        } else if (tag.equals(ChecklistTag.WORK_ORDER)) {
            fragment = WorkorderFragment.getInstance();
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(getString(R.string.work_order));
            mDashboardViewModel.sortChecklistBy.setName(getResources().getString(R.string.due_date_asc));
            mDashboardViewModel.sortChecklistBy.setTag(SortingTag.DUE_DATE_ASC);
        }
        setFragment(fragment, tag);
    }

    private void setFragment(Fragment fragment, String tag) {
        mDashboardViewModel.selectedCheckList = tag;
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment, tag);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sort:
                if (!isFinishing()) {
                    SortBottomSheetFragment myBottomSheet = SortBottomSheetFragment.getInstance();
                    myBottomSheet.show(getSupportFragmentManager(), SortBottomSheetFragment.class.getSimpleName());
                }
                break;

            case R.id.filter:
                if (!isFinishing()) {
                    FilterBottomSheetFragment myBottomSheet = FilterBottomSheetFragment.getInstance();
                    myBottomSheet.show(getSupportFragmentManager(), FilterBottomSheetFragment.class.getSimpleName());
                }
                break;

            case R.id.imageClear:
                if (!TextUtils.isEmpty(mBinding.navigationDrawer.searchView.etSearch.getText().toString().trim())) {
                    mBinding.navigationDrawer.searchView.etSearch.setText("");
                    mBinding.navigationDrawer.searchView.etSearch.requestFocus();
                    Utilities.getInstance(DashboardActivity.this).showKeyboard(mBinding.navigationDrawer.searchView.etSearch, DashboardActivity.this);
                } else {
                    hideSearchView();
                }
                break;
            case R.id.sync:
                mBinding.drawerLayout.closeDrawer(GravityCompat.START);
                startSyncing(false);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_RESULT_FOR_LOCATION && resultCode == RESULT_OK && data != null) {
            boolean isLocationSelected = data.getBooleanExtra(LocationChangeActivity.IS_LOCATION_SELECTED, false);
            if (isLocationSelected) {
                //Refresh checklist when location is changed
                setupNavDrawer(false);
                mDashboardViewModel.setLastSync(AppDatabase.getInstance(this).postSynchronizationDao()
                        .getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId()));
                startSyncing(false);
                mDashboardViewModel.clearFilters();
                mDashboardViewModel.clearCheckList();
                displayAllChecklist(mDashboardViewModel.selectedCheckList);
                //setCountOnSideMenu(menu);
            }
        } else if (requestCode == Constants.REQUEST_RESULT_FOR_CANCELLED_COMPLETED && resultCode == RESULT_OK) {
            //If checklist is mark completed or cancelled from checklist detail listing
            if (data.getBooleanExtra(ChecklistDetailListingActivity.IS_CHECKLIST_CANCELLED, false))
                displayAllChecklist(ChecklistTag.CANCELLED_CHECKLIST);
            else if (data.getBooleanExtra(ChecklistDetailListingActivity.IS_CHECKLIST_COMPLETED, false))
                displayAllChecklist(ChecklistTag.COMPLETED_CHECKLIST);
            startSyncing(false);
        }
    }

    @Override
    public void onSearchSuggestionSelected(String text) {
        mBinding.navigationDrawer.searchView.etSearch.setText(text);
        mBinding.navigationDrawer.searchView.etSearch.setSelection(text.length());
    }

    public void hideSearchView() {
        mBinding.navigationDrawer.searchView.parent.setVisibility(View.GONE);
        mBinding.navigationDrawer.frameLayoutSearch.setVisibility(View.GONE);
        Utilities.getInstance(DashboardActivity.this).closeKeyboard(mBinding.navigationDrawer.searchView.etSearch, DashboardActivity.this);
        mDashboardViewModel.setSearchKeyword("");
        mDashboardViewModel.getChecklist(0, mDashboardViewModel.getSearchKeyword());
    }


    public void startSyncing(boolean isComingFromNotification) {
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

        String lastSyncTime = postSynchronizationDao.getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());
        Integer lastSyncStatus = postSynchronizationDao.getLastSyncStatus(BaseApplication.getPreferenceManager().getUserLocationId());
        mDashboardViewModel.setLastSync(lastSyncTime);

        if (isComingFromNotification) {
            setCountOnSideMenu(menu);
            return;
        }

        if (lastSyncStatus.equals(Constants.SYNC_STATUS_RESOURCE_DOWNLOAD_UPLOAD)) {
            DialogUtility.showAlertOnly(DashboardActivity.this, getString(R.string.file_download_message), R.string.ok);
        } else if (lastSyncStatus == 0 || lastSyncStatus.equals(Constants.SYNC_STATUS_FAILED)) {
            if (!(lastSyncTime != null && lastSyncTime.length() > 0)) {
                startWork(true);
            } else {
                showSyncNowDialog();
            }
        } else if (TextUtils.isEmpty(lastSyncTime)) {
            startWork(true);
        } else {
            showSyncNowDialog();
        }

    }


    private void showSyncNowDialog() {
        DialogUtility.showAlertWithTwoButtonsOnly(DashboardActivity.this, getString(R.string.sync_again), R.string.txt_sync_now, R.string.txt_sync_later, new OnSelectListener() {
            @Override
            public void onPositiveButtonClick() {
                startWork(false);
            }

            @Override
            public void onNegativeButtonClick() {
                setCountOnSideMenu(menu);
            }
        });
    }


    private void showSyncRetryDialog(final boolean isFirstSync) {
        String msg = getString(R.string.sync_failed);
        if (!Utilities.isOnline(this)) {
            msg = getString(R.string.retry_sync_no_network);
        }
        if (retrySyncDialog == null || !retrySyncDialog.isShowing())
            if (isFirstSync)
                retrySyncDialog = DialogUtility.showAlertWithOneButtonsOnly(DashboardActivity.this, msg, R.string.retry, new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        startWork(isFirstSync);
                        retrySyncDialog.dismiss();
                    }

                    @Override
                    public void onNegativeButtonClick() {

                    }
                });
            else
                retrySyncDialog = DialogUtility.showAlertWithTwoButtonsOnly(DashboardActivity.this, msg, R.string.retry, R.string.cancel, new OnSelectListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        startWork(isFirstSync);
                        retrySyncDialog.dismiss();
                    }

                    @Override
                    public void onNegativeButtonClick() {

                    }
                });
    }


    public void startWork(boolean isFirstSync) {
        WorkManager.getInstance(BaseApplication.getContext()).cancelAllWork();
        WorkManager workManager = WorkManager.getInstance(BaseApplication.getContext());
        WorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(SyncWorkManager.class).build();

        workManager.enqueue(uploadWorkRequest);
        updateSyncTime(isFirstSync);
        showAlertWithoutButton(isFirstSync);
    }

    public void showAlertWithoutButton(boolean isFirstTime) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        syncDialog = builder.create();
        syncDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.dialog_syncing, null, false);

        setSyncMessage(isFirstTime, 0);
        syncDialog.setView(syncDialogBinding.getRoot());
        syncDialog.setCancelable(false);

        if (!isFirstTime) {
            syncDialogBinding.message.setText(getString(R.string.syncing));
        } else {
            syncDialogBinding.message.setText(getString(R.string.sync_message));
        }

        if (!syncDialog.isShowing())
            syncDialog.show();
    }

    private void setSyncMessage(boolean isFirstTime, int syncPercentage) {
        int message;
        if (syncPercentage == SYNC_INITIAL_PERCENTAGE) {
            message = R.string.sync_initial_message;
        } else if (syncPercentage == SYNC_MASTER_PERCENTAGE) {
            message = R.string.sync_master_message;
        } else if (syncPercentage == SYNC_ASSIGNED_PERCENTAGE) {
            message = R.string.sync_assigned_message;
        } else if (syncPercentage == SYNC_WORKORDER_PERCENTAGE) {
            message = R.string.sync_workorder_message;
        } else if (syncPercentage == SYNC_POST_PERCENTAGE) {
            message = R.string.sync_post_message;
        } else {
            message = R.string.syncing;
        }
        syncDialogBinding.ProgressBar.setProgress(syncPercentage);
        syncDialogBinding.subMessage.setText(getString(message));
        if (syncPercentage > 0) {
            syncDialogBinding.progressText.setText(syncPercentage + "%");
            int width = syncDialogBinding.getRoot().getWidth();
            int widthPercentage = width * (syncPercentage - 10) / 100;
            syncDialogBinding.progressText.setPadding(widthPercentage, 0, 0, 5);
        }
    }

    private BroadcastReceiver broadcastReceiverForSyncMessage = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int syncPercentage = intent.getIntExtra(SYNC_PERCENTAGE, 0);
            if (syncPercentage > 0 && syncDialogBinding != null) {
                setSyncMessage(false, syncPercentage);
            }
        }
    };

    public void cancelAlert() {
        if (syncDialog != null) {
            syncDialog.dismiss();
            syncDialog.cancel();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void setCountOnSideMenu(final Menu menu) {
        menu.findItem(R.id.nav_my_assigned_checklist).setActionView(R.layout.item_menu_checklist_count);
        View actionMyAssigned = menu.findItem(R.id.nav_my_assigned_checklist).getActionView();
        final AppCompatTextView txtMyAssignedCountTv = actionMyAssigned.findViewById(R.id.txtCount);

        menu.findItem(R.id.nav_my_department_checklist).setActionView(R.layout.item_menu_checklist_count);
        View actionViewMyDept = menu.findItem(R.id.nav_my_department_checklist).getActionView();
        final AppCompatTextView txtMyDeptCountTv = actionViewMyDept.findViewById(R.id.txtCount);

        menu.findItem(R.id.nav_workorder).setActionView(R.layout.item_menu_checklist_count);
        View actionViewWorkOrder = menu.findItem(R.id.nav_workorder).getActionView();
        final AppCompatTextView txtWorkOrderCountTv = actionViewWorkOrder.findViewById(R.id.txtCount);

        mDashboardViewModel.getMyAssignedChecklistCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer count) {
                if (count == null || count == 0) {
                    txtMyAssignedCountTv.setText("0");
                    return;
                }
                String listSize = "";
                if (count < 100)
                    listSize = String.valueOf(count);
                else
                    listSize = String.valueOf("99+");

                txtMyAssignedCountTv.setText(listSize);
            }
        });

        mDashboardViewModel.getMyDepartmentChecklistCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer count) {
                if (count == null || count == 0) {
                    txtMyDeptCountTv.setText("0");
                    return;
                }
                String listSize = "";
                if (count < 100)
                    listSize = String.valueOf(count);
                else
                    listSize = String.valueOf("99+");

                txtMyDeptCountTv.setText(listSize);
            }
        });

        mDashboardViewModel.getWorkOrderChecklistCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer count) {
                if (count == null || count == 0) {
                    txtWorkOrderCountTv.setText("0");
                    return;
                }
                String listSize = "";
                if (count < 100)
                    listSize = String.valueOf(count);
                else
                    listSize = String.valueOf("99+");

                txtWorkOrderCountTv.setText(listSize);

            }
        });
    }


}
