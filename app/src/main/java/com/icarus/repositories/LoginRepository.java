package com.icarus.repositories;

import com.google.gson.Gson;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.dao.MainUserDao;
import com.icarus.database.UserDatabase;
import com.icarus.entities.Login;
import com.icarus.entities.LoginEntity;
import com.icarus.network.LoginApi;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.RetroUtils;
import com.icarus.util.MD5;
import com.icarus.util.Utilities;

import androidx.lifecycle.MutableLiveData;
import android.content.Context;
import androidx.annotation.NonNull;

import java.net.HttpURLConnection;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private Context application;

    public LoginRepository(Context application) {
        this.application = application;
    }

    public MutableLiveData<Login> validate(String username, String password) {
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        final MainUserDao mainUserDao = userDatabase.userDao();
        final MutableLiveData<Login> liveData = new MutableLiveData<>();
        final String base64EncodedCredentials = Credentials.basic(username, password);

        String salt = application.getResources().getString(R.string.SALT);
        username = username.toLowerCase();
        password = MD5.sha1(password, salt);

        final Login login = mainUserDao.validateUser(username, password);

        if (login != null) {
            BaseApplication.getPreferenceManager().setUserCredintials(base64EncodedCredentials);
            BaseApplication.getPreferenceManager().setUserId(login.getId());
            BaseApplication.getPreferenceManager().setUserGroupId(login.getGroupId());
            BaseApplication.getPreferenceManager().setUserName(login.getUsername());
            BaseApplication.getPreferenceManager().setClientUuid(login.getClientUuid());
            BaseApplication.getPreferenceManager().setUserUuid(login.getUuid());
            BaseApplication.getPreferenceManager().setUserFullName(login.getFullName());
            BaseApplication.getPreferenceManager().setIsAdmin(login.isAdministrator());
            login.setCode(HttpURLConnection.HTTP_OK);
            liveData.setValue(login);
        } else {
            if (Utilities.isOnline(application)) {
                RetroUtils.getRetrofitInstance(application, new InternetConnectionListener() {
                    @Override
                    public void onInternetUnavailable() {
                        Login loginErrorUnexpected = new Login();
                        loginErrorUnexpected.setMessage(application.getString(R.string.no_internet_connection));
                        liveData.postValue(loginErrorUnexpected);
                    }
                }).create(LoginApi.class).login(base64EncodedCredentials).enqueue(new Callback<LoginEntity>() {
                    @Override
                    public void onResponse(@NonNull Call<LoginEntity> call, @NonNull Response<LoginEntity> response) {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            LoginEntity loginResponse = response.body();

                            BaseApplication.getPreferenceManager().setUserCredintials(base64EncodedCredentials);
                            BaseApplication.getPreferenceManager().setUserId(loginResponse.getData().getId());
                            BaseApplication.getPreferenceManager().setUserGroupId(loginResponse.getData().getGroupId());
                            BaseApplication.getPreferenceManager().setUserName(loginResponse.getData().getUsername());
                            BaseApplication.getPreferenceManager().setClientUuid(loginResponse.getMeta().getAccount().getUuid());
                            BaseApplication.getPreferenceManager().setUserUuid(loginResponse.getData().getUuid());
                            BaseApplication.getPreferenceManager().setUserFullName(loginResponse.getData().getFullName());
                            BaseApplication.getPreferenceManager().setIsAdmin(loginResponse.getData().isAdministrator());
                            loginResponse.getData().setCode(response.code());

                            loginResponse.getData().setCredentials(base64EncodedCredentials);
                            loginResponse.getData().setClientUuid(loginResponse.getMeta().getAccount().getUuid());
                            mainUserDao.insertUser(loginResponse.getData());
                            BaseApplication.getPreferenceManager().setLoginUserLocations(new Gson().toJson(loginResponse.getMeta().getLocations()));
                            liveData.setValue(loginResponse.getData());
                        } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                            Login loginError = new Login();
                            loginError.setMessage(application.getString(R.string.invalid_credentials));
                            loginError.setCode(response.code());
                            liveData.setValue(loginError);
                        } else {
                            Login loginErrorUnexpected = new Login();
                            loginErrorUnexpected.setMessage(application.getString(R.string.login_error_message));
                            loginErrorUnexpected.setCode(response.code());
                            liveData.setValue(loginErrorUnexpected);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginEntity> call, Throwable t) {
                        Login loginErrorUnexpected = new Login();
                        loginErrorUnexpected.setMessage(application.getString(R.string.login_error_message));
                        liveData.setValue(loginErrorUnexpected);
                    }
                });
            } else {//handle no internet
                Login loginNoInternet = new Login();
                loginNoInternet.setMessage(application.getString(R.string.no_internet_connection));
                liveData.setValue(loginNoInternet);
            }
        }

        return liveData;
    }

    public void updateUserTerms(boolean isTermsAccepted) {
        UserDatabase mainDatabase = UserDatabase.getInstance(application);
        final MainUserDao mainUserDao = mainDatabase.userDao();
        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        mainUserDao.updateUserTerms(userId, isTermsAccepted);
    }

    public boolean isTermsAccepted() {
        UserDatabase mainDatabase = UserDatabase.getInstance(application);
        final MainUserDao mainUserDao = mainDatabase.userDao();
        Integer userId = BaseApplication.getPreferenceManager().getUserId();
        return mainUserDao.isTermsAccepted(userId);
    }
}


