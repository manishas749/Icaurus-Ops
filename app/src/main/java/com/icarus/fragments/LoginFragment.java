package com.icarus.fragments;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.icarus.BR;
import com.icarus.BuildConfig;
import com.icarus.R;
import com.icarus.activities.DashboardActivity;
import com.icarus.activities.LocationChangeActivity;
import com.icarus.activities.TermsAndConditionsActivity;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentLoginBinding;
import com.icarus.entities.Login;
import com.icarus.navigators.LoginNavigator;
import com.icarus.util.Navigator;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.LoginViewModel;

import java.net.HttpURLConnection;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginViewModel> implements LoginNavigator {
    private LoginViewModel mLoginViewModel;
    private FragmentLoginBinding mFragmentLoginBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLoginViewModel.setNavigator(this);
        mFragmentLoginBinding = getViewDataBinding();
        mFragmentLoginBinding.version.setText(String.format(getString(R.string.version_name), BuildConfig.VERSION_NAME));
    }

    @Override
    public void performLogin() {
        mFragmentLoginBinding.userNameView.setError(null);
        mFragmentLoginBinding.passwordInputLayout.setError(null);
        mLoginViewModel.login(mFragmentLoginBinding.username.getText().toString().trim(), (mFragmentLoginBinding.password.getText().toString().trim()));


    }

    @Override
    public void onEmailError(int resID) {
        mFragmentLoginBinding.userNameView.setError(getString(resID));
        mFragmentLoginBinding.username.requestFocus();
    }

    @Override
    public void onPasswordError(int resID) {
        mFragmentLoginBinding.passwordInputLayout.setError(getString(resID));
        mFragmentLoginBinding.password.requestFocus();
    }

    @Override
    public void openTCScreen() {
        Navigator.launchActivityAndFinishCurrent(getActivity(), new Intent(getActivity(), TermsAndConditionsActivity.class));
    }

    @Override
    public void openDashBoardScreen() {
        Navigator.launchActivityAndFinishCurrent(getActivity(), new Intent(getActivity(), DashboardActivity.class));
    }

    @Override
    public void openForgotPassword() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.FORGOTPASSWORDPATH));
        startActivity(browserIntent);
        //  Navigator.launchActivity(getActivity(), WebViewActivity.getIntent(getActivity(), BuildConfig.SERVERPATH));
    }

    @Override
    public void onValidateLoginSuccess() {
        mLoginViewModel.observeLogin().observe(this, new Observer<Login>() {
            @Override
            public void onChanged(@Nullable Login loginResponse) {
                mLoginViewModel.setIsLoading(false);
                if (loginResponse != null && loginResponse.getCode() == HttpURLConnection.HTTP_OK) {
                    if (loginResponse.isTermsAccepted() && (!TextUtils.isEmpty(BaseApplication.getPreferenceManager().getLoginUserLocations()) || !TextUtils.isEmpty(BaseApplication.getPreferenceManager().getUserLocationName()))) {
                        openDashBoardScreen();
                    } else if (loginResponse.isTermsAccepted()) {
                        Navigator.launchActivityAndFinishCurrent(getActivity(), new Intent(getActivity(), LocationChangeActivity.class));
                    } else {
                        openTCScreen();
                    }
                } else
                    Utilities.getInstance(getActivity()).showToast(loginResponse.getMessage() != null
                                    ? loginResponse.getMessage() : getString(R.string.login_error_message)
                            , Toast.LENGTH_LONG, getActivity());
            }
        });

    }

    @Override
    public void noInternet() {
        Utilities.getInstance(getActivity()).showToast(getString(R.string.no_internet_connection), Toast.LENGTH_LONG, getActivity());
    }


}
