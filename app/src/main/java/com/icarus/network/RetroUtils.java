package com.icarus.network;


import android.content.Context;

import com.icarus.base.BaseApplication;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroUtils {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(Context activity) {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            String BASE_URL = "https://api-jedi.icarusplus.com/";
            if (!BASE_URL.endsWith("/"))
                BASE_URL = BASE_URL + "/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
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
