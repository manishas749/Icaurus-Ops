package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedLogoRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedLogosResponse;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedLogosApi {

  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_logos.json")
  Observable<AddUpdateAssignedLogosResponse> assignedLogoAdd(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedLogoRequest addUpdateAssignedLogoRequest
  );
}
