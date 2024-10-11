package c.anurag.network.apiservice;

import android.content.Context;

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
        headers.putAll(RequestData.getHeaders());
        service = new ApiService(context, factory, BaseApplication.getPreferenceManager().getServerPath(), headers);
    }

    @Override
    public void getLogin(final IViewCallback<LoginResponse> abstractViewCallback) {
        Map<String, Object> queryParams = new HashMap<>();
        String[] URL_APPEND = new String[]{"users", "authenticate.json"};
        queryParams.putAll(RequestData.getQueryParams());
        Observable<LoginResponse> observable =
                service.get(UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), URL_APPEND, queryParams), LoginResponse.class)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<LoginResponse>() {
            @Override
            public void success(LoginResponse response) {
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

    @Override
    public void getLocation(final IViewCallback<LocationsResponse> abstractViewCallback) {
        Map<String, Object> queryParams = new HashMap<>();
        String[] URL_APPEND = new String[]{"locations.json"};
        queryParams.putAll(RequestData.getQueryParams());
        Observable<LocationsResponse> observable =
                service.get(UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), URL_APPEND, queryParams), LocationsResponse.class)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<LocationsResponse>() {
            @Override
            public void success(LocationsResponse response) {
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

    @Override
    public void getUserLocationDepartment(final IViewCallback<UserLocationDepartmentsResponse> abstractViewCallback) {
        Map<String, Object> queryParams = new HashMap<>();
        String[] URL_APPEND = new String[]{"user_location_departments.json"};
        queryParams.put("embed", "location");
        queryParams.putAll(RequestData.getQueryParams());
        Observable<UserLocationDepartmentsResponse> observable =
                service.get(UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), URL_APPEND, queryParams), UserLocationDepartmentsResponse.class)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<UserLocationDepartmentsResponse>() {
            @Override
            public void success(UserLocationDepartmentsResponse response) {
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
