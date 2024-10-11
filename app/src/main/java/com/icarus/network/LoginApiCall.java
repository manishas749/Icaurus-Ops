package com.icarus.network;

import android.content.Context;

import com.icarus.entities.Login;
import com.icarus.entities.LoginEntity;

import java.util.HashMap;
import java.util.Map;

import c.anurag.database.application.BaseApplication;
import c.anurag.network.ApiService;
import c.anurag.network.RequestData;
import c.anurag.network.RetrofitApiServiceFactory;

import c.anurag.network.beans.location.LocationsResponse;
import c.anurag.network.beans.login.LoginResponse;
import c.anurag.network.beans.user.locationdepartments.UserLocationDepartmentsResponse;
import c.anurag.network.callback.IViewCallback;
import c.anurag.network.subscriber.AbstractNetworkObservable;
import c.anurag.network.util.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anuragpurwar
 */

public class LoginApiCall extends ILoginApiCall {
    private final ApiService service;

    public LoginApiCall(Context context, RetrofitApiServiceFactory factory, Map<String, String> headers) {
        service = new ApiService(context, factory, BaseApplication.getPreferenceManager().getServerPath(), headers);
    }

    @Override
    public void getLogin(final IViewCallback<LoginEntity> abstractViewCallback) {
        String[] URL_APPEND = new String[]{"users", "authenticate.json"};
        Map<String, Object> queryParams = new HashMap<>(RequestData.getQueryParams());
        Observable<LoginEntity> observable =
                service.get(UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), URL_APPEND, queryParams), LoginEntity.class)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<LoginEntity>() {
            @Override
            public void success(LoginEntity response) {
                if (response != null) {
                    abstractViewCallback.checkAndUpdate(response);
                }
            }

            @Override
            public void failure(Throwable error) {
                abstractViewCallback.onFailure(error);
            }
        });
    }


}
