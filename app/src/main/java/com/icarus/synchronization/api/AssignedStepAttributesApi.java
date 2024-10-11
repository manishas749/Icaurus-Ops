package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepAttirbutes;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepAttirbutesResponse;

import java.time.OffsetDateTime;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedStepAttributesApi {

  /**
   * Bulk Add And Update Assgined Step Attributes
   * Bulk Add And Update Assgined Step Attributes
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedStepAttirbutes  (optional)
   * @return Observable&lt;AddUpdateAssignedStepAttirbutesResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_step_attributes.json")
  Observable<AddUpdateAssignedStepAttirbutesResponse> assignedStepAttributeAdd( @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedStepAttirbutes addUpdateAssignedStepAttirbutes
  );



}
