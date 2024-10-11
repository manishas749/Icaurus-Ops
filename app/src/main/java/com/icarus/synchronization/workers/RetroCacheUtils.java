package com.icarus.synchronization.workers;


import com.google.gson.GsonBuilder;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.icarus.BuildConfig;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.NetworkConnectionInterceptor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroCacheUtils {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(final Context activity, final InternetConnectionListener mInternetConnectionListener) {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            int cacheSize = 20 * 1024 * 1024; // 10 MB
            File fileDestinationFolder = new File(BaseApplication.getCommonFunctions().getStoragePath(), Constants.CACHE);
            fileDestinationFolder.mkdirs();
            Cache cache = new Cache(fileDestinationFolder, cacheSize);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS);
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
                public Response intercept(Chain chain) throws IOException {
                    if (!isInternetAvailable()) {
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
