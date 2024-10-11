package com.icarus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.databinding.ActivityLocationSelectionBinding;
import com.icarus.entities.LocationEntity;
import com.icarus.navigators.ChangeLocationNavigator;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.ChangeLocationViewModel;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class LocationChangeActivity extends BaseActivity<ActivityLocationSelectionBinding, ChangeLocationViewModel> implements ChangeLocationNavigator {
    public static final String STATE_ITEMS = "STATE_ITEMS";
    public static final String IS_LOCATION_SELECTED = "isLocationSelected";
    private ChangeLocationViewModel mChangeLocationViewModel;
    private ActivityLocationSelectionBinding mBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_location_selection;
    }

    @Override
    public ChangeLocationViewModel getViewModel() {
        return mChangeLocationViewModel = new ViewModelProvider(this).get(ChangeLocationViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_location, menu);
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mBinding.contentLocationSelection.setViewModel(mChangeLocationViewModel);
        mChangeLocationViewModel.setNavigator(this);
        mChangeLocationViewModel.setBackButtonToBeShown();
        //Setting toolbar
        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null &&
                mChangeLocationViewModel.isBackButtonToBeShown())
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Fetch location
        mChangeLocationViewModel.fetchLocation();

        //Observing Location response is logged user is not admin
        mChangeLocationViewModel.observeLocationsResponse().observe(this, new Observer<LinkedHashMap<Integer, LocationEntity>>() {
            @Override
            public void onChanged(@Nullable LinkedHashMap<Integer, LocationEntity> locationItemsLinkedHashMap) {
                getViewModel().setIsLoading(false);
                if (locationItemsLinkedHashMap != null)
                    for (int key : locationItemsLinkedHashMap.keySet()) {
                        setRadioGroup(locationItemsLinkedHashMap.get(key));
                    }

                //Check if location saved exist or not, if saved location does not exists exit the screen
                if (mChangeLocationViewModel.validateLocation(BaseApplication.getPreferenceManager().getUserLocationId(), locationItemsLinkedHashMap)) {
                    mBinding.contentLocationSelection.radioGroup.check(BaseApplication.getPreferenceManager().getUserLocationId());
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                int selectedRadioButtonID = mBinding.contentLocationSelection.radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonID > 0) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonID);
                    LocationEntity locationItem = (LocationEntity) selectedRadioButton.getTag();
                    BaseApplication.getPreferenceManager().setUserLocationId(locationItem.getId());
                    BaseApplication.getPreferenceManager().setUserLocationName(locationItem.getName());
                    BaseApplication.getPreferenceManager().setUserLocationTimeZone(locationItem.getTimezone());
                    BaseApplication.getPreferenceManager().setLoginUserLocations("");

                    //Check if locations back press is enabled and previous screen is to be shown
                    if (mChangeLocationViewModel.isBackButtonToBeShown()) {
                        Intent result = new Intent();
                        result.putExtra(IS_LOCATION_SELECTED, true);
                        setResult(RESULT_OK, result);
                        finish();
                    } else
                        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, DashboardActivity.class));
                } else {
                    Utilities.getInstance(this).showToast(getString(R.string.location_not_selected_error), Toast.LENGTH_LONG, this);
                }
                break;

            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onSaveLocationError(String errorMsg) {

    }

    @Override
    public void onSaveLocationSuccess() {

    }

    @Override
    public void onGetLocationSuccess(List<LocationEntity> locationList) {
        for (LocationEntity item : locationList)
            setRadioGroup(item);
    }

    @Override
    public void internetNotConnected() {
        Utilities.getInstance(this).showToast(getString(R.string.no_internet_connection), Toast.LENGTH_LONG, this);
    }

    private void setRadioGroup(LocationEntity item) {
        RadioButton radioButton = new RadioButton(this, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = (int) (5 * getResources().getDisplayMetrics().density);
        params.setMargins(margin, margin, margin, margin);
        radioButton.setLayoutParams(params);
        radioButton.setTag(item);
        radioButton.setBackgroundResource(R.drawable.radio_background);
        radioButton.setText(item.getName());
        radioButton.setTextColor(getResources().getColor(R.color.black));
        radioButton.setId(item.getId());
        mBinding.contentLocationSelection.radioGroup.addView(radioButton);
    }
}
