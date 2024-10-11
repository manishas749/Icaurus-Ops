package com.icarus.synchronization.api;

import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistPauseTimeRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistPauseTimesResponse;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedChecklistPauseTimesApi {

  /**
   * Bulk Add And Update Assigned Decisions
   * Bulk Add And Update Assigned Decisions
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedDecisionsRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedDecisionResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_checklist_pause_times.json")
  Observable<AddUpdateAssignedChecklistPauseTimesResponse> assignedDecisionAdd(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedChecklistPauseTimeRequest addUpdateAssignedDecisionsRequest
  );


}
