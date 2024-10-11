package com.icarus.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import android.text.TextUtils;

import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.navigators.TermsAndConditionsNavigator;
import com.icarus.repositories.LoginRepository;

import c.anurag.database.IcarusDatabaseHelper;

/**
 * Created by Monika Rana on 12/26/2018.
 */

public class TermsAndConditionsViewModel extends BaseViewModel<TermsAndConditionsNavigator> {

    public TermsAndConditionsViewModel(@NonNull Application application) {
        super(application);
    }

    public void onDeclineClick() {
        LoginRepository loginRepository = new LoginRepository(this.getApplication());
        loginRepository.updateUserTerms(false);

        getNavigator().openLogin();
    }

    public void onAcceptClick() {
        LoginRepository loginRepository = new LoginRepository(this.getApplication());
        loginRepository.updateUserTerms(true);

        boolean isClientExist = IcarusDatabaseHelper.checkDatabaseExist(this.getApplication(), BaseApplication.getPreferenceManager().getClientUuid());
        boolean isLocationExist = TextUtils.isEmpty(BaseApplication.getPreferenceManager().getUserLocationName());

        if (isClientExist && !isLocationExist) {
            getNavigator().openDashboard();
        } else {
            getNavigator().openChangeLocation();
        }
    }
}
