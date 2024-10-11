package com.icarus.synchronization;


import com.google.gson.GsonBuilder;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.icarus.BuildConfig;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroUtils {
    private static Retrofit retrofit;

    public static synchronized Retrofit getRetrofitInstance(final Context activity, final InternetConnectionListener mInternetConnectionListener) {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS);
            httpClient.addInterceptor(interceptor);
            httpClient.addInterceptor(new NetworkConnectionInterceptor() {
                @Override
                public boolean isInternetAvailable() {
                    ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
                }

                @Override
                public void onInternetUnavailable() {
                    mInternetConnectionListener.onInternetUnavailable();
                }

                @Override
                public synchronized Response intercept(Chain chain) throws IOException {
                    if(!isInternetAvailable()){
                        onInternetUnavailable();
                    }
                    Request request = chain.request();
                    PackageManager manager = BaseApplication.getContext().getPackageManager();
                    String versionCode = "";
                    String versionName = "";
                    try {
                        PackageInfo info = manager.getPackageInfo(c.anurag.database.application.BaseApplication.getContext().getPackageName(), 0);
                        versionCode = Integer.toString(info.versionCode);
                        versionName = info.versionName;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    // If the request already have an authorization (eg. Basic auth), do nothing
                    if (request.header("Authorization") == null) {
                        request = request.newBuilder()
                                .addHeader("Authorization", BaseApplication.getPreferenceManager().getUserCredintials())
                                .addHeader("sync-identifier", BaseApplication.getPreferenceManager().getSyncIdentifier())
                                .addHeader("Device-identifier", Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID))
                                .addHeader("Device-Manufacturer", Build.MANUFACTURER)
                                .addHeader("Device-Model", Build.MODEL)
                                .addHeader("Device-Name", Build.DEVICE)
                                .addHeader("OS", Build.VERSION.RELEASE)
                                .addHeader("VersionCode", versionCode)
                                .addHeader("Version", versionName)
                                .addHeader("Platform", Constants.PLATFORM)
                                .build();
                    }
                    return chain.proceed(request);
                }
            });

            String BASE_URL = BuildConfig.SERVERPATH;
            if (!BASE_URL.endsWith("/"))
                BASE_URL = BASE_URL + "/";
            httpClient.addNetworkInterceptor(new StethoInterceptor());
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static void clearInstance() {
        if (retrofit != null)
            retrofit = null;
    }
}
