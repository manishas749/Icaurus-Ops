package com.icarus.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.annotation.NonNull;

import android.text.TextUtils;

import com.icarus.R;
import com.icarus.base.BaseViewModel;
import com.icarus.entities.Login;
import com.icarus.navigators.LoginNavigator;
import com.icarus.repositories.LoginRepository;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    private LiveData<Login> loginResponseLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);

    }

    public void login(String userName, String password) {
        boolean isValidated = true;
        //getNavigator().showProgress(true);
        if (TextUtils.isEmpty(userName)) {
            getNavigator().onEmailError(R.string.error_field_required);
            isValidated = false;
        }

        if (TextUtils.isEmpty(password)) {
            getNavigator().onPasswordError(R.string.error_field_required);
            isValidated = false;
        } else if (password.length() < 4) {
            getNavigator().onPasswordError(R.string.error_invalid_password);
            isValidated = false;
        }

        if (isValidated) {
            setIsLoading(true);
            LoginRepository loginRepository = new LoginRepository(this.getApplication());
            loginResponseLiveData = loginRepository.validate(userName, password);
            getNavigator().onValidateLoginSuccess();
        }
    }

    public LiveData<Login> observeLogin() {
        return loginResponseLiveData;
    }

    public void onLoginClick() {
        getNavigator().performLogin();
    }

    public void onForgotPasswordClick() {
        getNavigator().openForgotPassword();
    }

}
