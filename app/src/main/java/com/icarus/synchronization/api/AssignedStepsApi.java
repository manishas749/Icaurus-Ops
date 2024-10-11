package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepsRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepsResponse;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedStepsApi {

  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_steps.json")
  Observable<AddUpdateAssignedStepsResponse> assignedStepAdd(
           @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedStepsRequest addUpdateAssignedStepsRequest
  );


  @Headers({
          "Content-Type:application/json"
  })
  @POST("assigned_step_skip_difer_reasons.json")
  Observable<AddUpdateAssignedStepsResponse> assignedStepSkipDeferAdd(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedStepsRequest addUpdateAssignedStepsRequest
  );
}
