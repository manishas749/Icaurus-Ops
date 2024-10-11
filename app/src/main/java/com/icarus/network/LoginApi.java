package com.icarus.network;

import com.icarus.entities.LoginEntity;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApi {

    @Headers({
            "Content-Type:application/json"
    })
    @POST("users/authenticate.json")
    Call<LoginEntity> login(
            @retrofit2.http.Header("Authorization") String credentials
    );

}
