package com.icarus.synchronization.api;

import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistsRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistsResponse;
import com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail;
import com.icarus.synchronization.syncmodels.RetrieveAssignedChecklist;
import com.icarus.synchronization.syncmodels.UploadResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface AssignedChecklistsApi {

  /**
   * List Assigned Checklists
   * List all assigned checklists
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only assigned checklists where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only assigned checklists where last activity is at or before this timestamp. (optional)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @param userLocationId location id of the user
   * @return Observable&lt;Object&gt;
   */
  /*@GET("assigned_checklists.json")
  Observable<RetrieveAssignedChecklist> assignedChecklistIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("embed") String embed,
          @Query("location_id") int userLocationId, @Query("revision") Integer revision, @Query("active") String active);*/

  @GET("assigned_checklists.json")
  Call<RetrieveAssignedChecklist> assignedChecklistIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("embed") String embed,
          @Query("location_id") int userLocationId, @Query("revision") Integer revision, @Query("active") String active);


  /**
   * Retrieve an Assigned Checklist
   * Retrieve a single assigned checklist.
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the assigned checklist to retrieve (required)
   * @param expand If supplied, return single assigned_checklist with additional assigned data (optional)
   * @return Observable&lt;AssignedChecklistViewObject&gt;
   */
  @GET("assigned_checklists/{uuid}.json")
  Observable<ReteriveAssignedChecklistDetail> assignedChecklistView(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @retrofit2.http.Query("expand") String expand
  );

  @GET("assigned_checklists/{uuid}.json")
  Call<ReteriveAssignedChecklistDetail> assignedChecklistView1(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @retrofit2.http.Query("expand") String expand
  );

  /**
   * Bulk Add And Update Assigned Checklists
   * Bulk Add And Update Assigned Checklists
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedChecklistsRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedChecklistsResponse&gt;
   */
  @Headers({
          "Content-Type:application/json"
  })
  @POST("assigned_checklists.json")
  Observable<AddUpdateAssignedChecklistsResponse> assignedChecklistAdd(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedChecklistsRequest addUpdateAssignedChecklistsRequest
  );


  /**https://api-dev.icarusplus.com/assigned_step_resources/{uuid}/upload.json
   * Upload Resource
   * Upload Resource
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist logo to download (required)
   * @return Completable
   */
  @Multipart
  @POST("assigned_step_resources/{uuid}/upload.json")
  Observable<UploadResponse> resourceUpload(
          @retrofit2.http.Header("Accept") String accept, @Part MultipartBody.Part file, @retrofit2.http.Path("uuid") String uuid
  );

}
