package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepResourcesRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepsResourceResponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedStepsResponse;
import com.icarus.synchronization.postsyncmodel.AssignedAttributeUploadResponse;

import java.time.OffsetDateTime;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedStepResourcesApi {
  /**
   * List Assigned Step Resources of an Assigned Checklist
   * List Assigned Step Resources of an Assigned Checklist
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the assigned_checklist (required)
   * @return Observable&lt;Object&gt;
   */
  @GET("assigned_checklists/{uuid}/assigned_step_resources.json")
  Observable<Object> assignedChecklistAssignedStepResourceIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

  /**
   * Bulk Add And Update Assigned Step Resources
   * Bulk Add And Update Assigned Step Resources
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedStepResourcesRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedStepsResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_step_resources.json")
  Observable<AddUpdateAssignedStepsResourceResponse> assignedStepResourceAdd(@retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedStepResourcesRequest addUpdateAssignedStepResourcesRequest
  );


}
