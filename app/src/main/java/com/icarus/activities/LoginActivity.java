package com.icarus.activities;

import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContentProviderCompat.requireContext;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.icarus.R;
import com.icarus.fragments.LoginFragment;
import com.icarus.util.Utilities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportFragmentManager().getFragments().size() == 0)
            Utilities.getInstance(LoginActivity.this).replaceFragment(R.id.frame_layout, new LoginFragment(), LoginFragment.class.getSimpleName(), false, LoginActivity.this);

    }


}