package com.icarus.synchronization.api;

import com.icarus.synchronization.postsyncmodel.WorkorderPostRequest;
import com.icarus.synchronization.postsyncmodel.WorkorderPostResponse;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderAttachments;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderBillingTypes;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderElements;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderNoteDetails;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderNotes;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorderStatuses;
import com.icarus.synchronization.syncmodels.RetrieveAllWorkorders;
import com.icarus.synchronization.syncmodels.WordorderUploadResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface WorkOrdersApi {

  @GET("workorder_billing_types.json")
  Observable<RetrieveAllWorkorderBillingTypes> workorderBillingTypeIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore,@retrofit2.http.Query("revision") Integer revision
  );



  /**
   * List Work Order Status
   * List Work Order Status
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only users where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only users where last activity is at or before this timestamp. (optional)
   * @param revision If supplied, return only the statuses of requested revisions. (optional)
   * @return Observable&lt;RetrieveAllWorkorderStatuses&gt;
   */
  @GET("workorder_statuses.json")
  Observable<RetrieveAllWorkorderStatuses> workorderStatusIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );


  @Headers({
          "Content-Type:application/json"
  })
  @POST("workorders.json")
  Observable<WorkorderPostResponse> addUpdateWorkorder(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body WorkorderPostRequest workorderPostRequest
  );


  @GET("workorders.json")
  Observable<RetrieveAllWorkorders> workorderIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("location_id") Integer locationId, @Query("revision") Integer revision
  );

  @GET("workorders/{id}.json")
  Observable<RetrieveAllWorkorderElements> workorderElementIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("id") Integer id, @retrofit2.http.Query("expand") String embed
  );

    @GET("workorder_attachments.json")
    Observable<RetrieveAllWorkorderAttachments> workorderAttachmentIndex(
            @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("location_id") Integer locationId, @Query("revision") Integer revision
    );

    @GET("workorder_notes.json")
    Observable<RetrieveAllWorkorderNotes> workorderNotesIndex(
            @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("location_id") Integer locationId, @Query("revision") Integer revision
    );

    @GET("workorder_note_details.json")
    Observable<RetrieveAllWorkorderNoteDetails> workorderNoteDetailsIndex(
            @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("location_id") Integer locationId, @Query("revision") Integer revision
    );

  /**
   * https://api-dev.icarusplus.com/workorder_attachments/{uuid}/upload.json
   * Upload Resource
   * Upload Resource
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist logo to download (required)
   * @return Completable
   */
  @Multipart
  @POST("workorder_attachments/{uuid}/upload.json")
  Observable<WordorderUploadResponse> resourceUpload(
          @retrofit2.http.Header("Accept") String accept, @Part MultipartBody.Part file, @retrofit2.http.Path("uuid") String uuid
  );




  @GET("workorder_attachments/{uuid}/download.json")
  Observable<ResponseBody> workOrderAttachmentDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

}
