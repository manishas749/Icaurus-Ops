package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedLogsResponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateLogsRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedLogsApi {
  /**
   * List Logs of an Assigned Checklist
   * List Logs of an Assigned Checklist
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of assigned checklist (required)
   * @return Observable&lt;Object&gt;
   */
  @GET("assigned_checklists/{uuid}/logs.json")
  Observable<Object> assignedChecklistLogIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

  /**
   * Bulk Add And Update Logs
   * Bulk Add And Update Logs
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateLogsRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedLogsResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("logs.json")
  Observable<AddUpdateAssignedLogsResponse> logAdd(@retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateLogsRequest addUpdateLogsRequest
  );

  /**
   * List Logs
   * List Logs
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only users where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only users where last activity is at or before this timestamp. (optional)
   * @param ids If supplied, return only the specific users requested. (optional)
   * @return Observable&lt;RetrieveAllLogs&gt;
   */
  @GET("logs.json")
  Observable<Object> logIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("ids") String ids
  );

}
