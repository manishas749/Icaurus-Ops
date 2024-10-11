package com.icarus.activities;


import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.databinding.ActivitySplashBinding;
import com.icarus.fragments.LoginFragment;
import com.icarus.navigators.SplashNavigator;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.SplashViewModel;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Monika Rana on 12/24/2018.
 */

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    private static final int PERMISSIONS_REQUEST = 1234;
    private SplashViewModel mSplashViewModel;
    SplashScreen splashScreen;
    /**
     * The code used when requesting permissions
     */

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
    }

    @Override
    public void openLoginScreen() {
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LoginActivity.class));
    }

    @Override
    public void openDashBoardScreen() {
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, DashboardActivity.class));
    }

    @Override
    public void openChangeLocationScreen() {
        Navigator.launchActivityAndFinishCurrent(this, new Intent(this, LocationChangeActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_RESULT_FOR_LOCATION && resultCode == RESULT_OK && data != null) {
            boolean isLocationSelected = data.getBooleanExtra(LocationChangeActivity.IS_LOCATION_SELECTED, false);
            if (isLocationSelected) {
                BaseApplication.getPreferenceManager().setLoginUserLocations("");
                Navigator.launchActivityAndFinishCurrent(this, new Intent(this, DashboardActivity.class));
                return;
            }
        }
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        splashScreen = SplashScreen.installSplashScreen(this);
        splashScreen.setKeepOnScreenCondition(() -> true);
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        checkPermissionGranted();
    }


    private void checkPermissionGranted()
    {
        if (((Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU))) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_MEDIA_AUDIO
            ) != PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_MEDIA_IMAGES
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_MEDIA_VIDEO
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                Navigator.launchActivityAndFinishCurrent(this, new Intent(this, PermissionsActivity.class));

            }else{
                mSplashViewModel.openNextScreen();
            }
        } else {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                   this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
            ) {
                Navigator.launchActivityAndFinishCurrent(this, new Intent(this, PermissionsActivity.class));
            }else{
                mSplashViewModel.openNextScreen();
            }

        }
    }


}

