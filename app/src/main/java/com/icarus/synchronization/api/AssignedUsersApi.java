package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedUsersRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedUsersResponse;

import java.time.OffsetDateTime;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedUsersApi {


  /**
   * Bulk Add And Update Assigned Users
   * Bulk Add And Update Assigned Users
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedUsersRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedUsersResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_users.json")
  Observable<AddUpdateAssignedUsersResponse> assignedUserAdd(
           @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedUsersRequest addUpdateAssignedUsersRequest
  );



}
