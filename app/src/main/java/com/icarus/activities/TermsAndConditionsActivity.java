package com.icarus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.databinding.ActivityTermsAndConditionsBinding;
import com.icarus.navigators.TermsAndConditionsNavigator;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.TermsAndConditionsViewModel;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;

/**
 * Created by Monika Rana on 12/26/2018.
 */

public class TermsAndConditionsActivity extends BaseActivity<ActivityTermsAndConditionsBinding, TermsAndConditionsViewModel> implements TermsAndConditionsNavigator {
    private TermsAndConditionsViewModel mTermsAndConditionsViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_terms_and_conditions;
    }

    @Override
    public TermsAndConditionsViewModel getViewModel() {
        return mTermsAndConditionsViewModel = new ViewModelProvider(this).get(TermsAndConditionsViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTermsAndConditionsBinding mBinding = getViewDataBinding();
        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTermsAndConditionsViewModel.setNavigator(this);
        mBinding.contentTermsAndConditions.setViewModel(mTermsAndConditionsViewModel);
        Utilities.getInstance(this).setUnderlineText(getString(R.string.decline), mBinding.contentTermsAndConditions.btnDecline);
        mBinding.contentTermsAndConditions.text.setHtml(Utilities.getInstance(this).readFromFile(getString(R.string.terms_file_name), getResources().getAssets()), new HtmlHttpImageGetter(mBinding.contentTermsAndConditions.text));
    }


    @Override
    public void openDashboard() {
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, DashboardActivity.class));
    }

    @Override
    public void openChangeLocation() {
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LocationChangeActivity.class));
    }

    @Override
    public void openLogin() {
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LoginActivity.class));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_RESULT_FOR_LOCATION && resultCode == RESULT_OK && data != null) {
            boolean isLocationSelected = data.getBooleanExtra(LocationChangeActivity.IS_LOCATION_SELECTED, false);
            if (isLocationSelected) {
                BaseApplication.getPreferenceManager().setLoginUserLocations("");
                Navigator.launchActivityAndFinishCurrent(this, new Intent(this, DashboardActivity.class));
            }
        }
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
    public void onBackPressed() {
        mTermsAndConditionsViewModel.onDeclineClick();
        BaseApplication.getPreferenceManager().logout();
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LoginActivity.class));
    }
}
