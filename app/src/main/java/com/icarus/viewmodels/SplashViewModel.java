package com.icarus.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;

import android.text.TextUtils;

import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.navigators.SplashNavigator;
import com.icarus.repositories.LoginRepository;

import c.anurag.database.IcarusDatabaseHelper;


/**
 * Created by Monika Rana on 12/25/2018.
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(@NonNull Application application) {
        super(application);
    }

    public void openNextScreen() {
        LoginRepository loginRepository = new LoginRepository(getApplication());
        boolean isTermsAccepted = loginRepository.isTermsAccepted();
        if (BaseApplication.getPreferenceManager().getUserId() > 0 && isTermsAccepted) {
            boolean isClientExist = IcarusDatabaseHelper.checkDatabaseExist(getApplication(), BaseApplication.getPreferenceManager().getClientUuid());
            boolean isLocationExist = TextUtils.isEmpty(BaseApplication.getPreferenceManager().getUserLocationName());
            if (isClientExist && !isLocationExist)
                getNavigator().openDashBoardScreen();
            else
                getNavigator().openChangeLocationScreen();
        } else {
            getNavigator().openLoginScreen();
        }
    }
}
