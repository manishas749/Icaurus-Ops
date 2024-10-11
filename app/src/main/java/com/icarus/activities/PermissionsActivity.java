package com.icarus.activities;

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
import com.icarus.navigators.SplashNavigator;
import com.icarus.util.Navigator;
import com.icarus.viewmodels.SplashViewModel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PermissionsActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    private static final int PERMISSIONS_REQUEST = 1234;

    private SplashViewModel mSplashViewModel;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        statusBarColor();
        mSplashViewModel.setNavigator(this);

        if (Build.VERSION.SDK_INT >= 23) {
            // checkPermissions();
        }
        checkPermissions();

    }


    private void statusBarColor() {
        Window window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ic_splash_background));
    }


    /**
     * Check if the required permissions have been granted, and
     * continue to next screen if they have. Otherwise
     * {@link #requestPermissions(String[], int)}.
     */
    @SuppressLint("NewApi")
    private void checkPermissions() {
        String[] unGrantedPermissions = requiredPermissionsStillNeeded();
        requestPermissionLauncher.launch(unGrantedPermissions);
    }

    private boolean checkPermissionDialogIsShow = false;
    private boolean requestPermissionLauncherResult = false;


    @Override
    protected void onResume() {
        super.onResume();
        if (checkPermissionDialogIsShow) {
            checkPermissionDialogIsShow = false;
            requestPermissionLauncherResult = false;
            String[] unGrantedPermissions = requiredPermissionsStillNeeded();
            requestPermissionLauncher.launch(unGrantedPermissions);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (requestPermissionLauncherResult) {
            alertDialog.hide();
            checkPermissionDialogIsShow = true;
        }

    }

    private ActivityResultLauncher<String[]> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), isGranted -> {
                if (isGranted.containsValue(false)) {
                    requestPermissionLauncherResult = true;
                    showPermissionDeniedDialog(getString(R.string.permission_required_for_further_operations));
                } else {
                    mSplashViewModel.openNextScreen();
                }
            });

    @SuppressLint("NewApi")
    public void getPermissionStatus(Activity activity, String permission) {
        if (ActivityCompat.checkSelfPermission(
                this,
                permission
        ) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(activity, "denied", Toast.LENGTH_SHORT).show();

        }
    }


    /**
     * Convert the array of required permissions to a {@link Set} to remove
     * redundant elements. Then remove already granted permissions, and return
     * an array of ungranted permissions.
     */
    @TargetApi(23)
    private String[] requiredPermissionsStillNeeded() {

        Set<String> permissions = new HashSet<String>();
        for (String permission : getRequiredPermissions()) {
            permissions.add(permission);
        }
        for (Iterator<String> i = permissions.iterator(); i.hasNext(); ) {
            String permission = i.next();
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                i.remove();

            }
        }

        return permissions.toArray(new String[0]);
    }

    /**
     * See if we now have all of the required dangerous permissions. Otherwise,
     * tell the user that they cannot continue without granting the permissions,
     * and then request the permissions again.
     */
    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST) {
            checkPermissions();
        }


    }


    /**
     * Get the list of required permissions by searching the manifest. If you
     * don't think the default behavior is working, then you could try
     * overriding this function to return something like:
     * <p>
     * <pre>
     * <code>
     * return new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
     * </code>
     * </pre>
     */
    public String[] getRequiredPermissions() {
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)) {
            return new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.READ_MEDIA_AUDIO, android.Manifest.permission.READ_MEDIA_IMAGES, android.Manifest.permission.READ_MEDIA_VIDEO};
        } else {
            return new String[]{
                    android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA
            };
        }
    }

    private AlertDialog alertDialog;

    private void showPermissionDeniedDialog(String message) {
        alertDialog = new AlertDialog.Builder(this)
                .setTitle(this.getString(R.string.permission_required))
                .setMessage(message)
                .setPositiveButton(this.getString(R.string.settings), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goToSettings();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void goToSettings() {
        Intent myAppSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + this.getPackageName()));
        myAppSettings.addCategory(Intent.CATEGORY_DEFAULT);
        myAppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(myAppSettings);
    }


}
