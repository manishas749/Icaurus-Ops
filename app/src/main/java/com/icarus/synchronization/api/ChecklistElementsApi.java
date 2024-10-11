package com.icarus.synchronization.api;

import com.icarus.synchronization.syncmodels.RetrieveAllChecklistElement;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChecklistElementsApi {
  /**
   * List Elements of an Assigned Checklist
   * List Elements of an Assigned Checklist
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist to fetch elements for (required)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("assigned_checklists/{uuid}/checklist_elements.json")
  Observable<Object> assignedChecklistChecklistElementIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @retrofit2.http.Query("embed") String embed, @Query("revision") Integer revision
  );

  /**
   * List Elements of a Master Checklist
   * List Elements of a Master Checklist
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist to fetch elements for (required)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("checklists/{uuid}/checklist_elements.json")
  Observable<RetrieveAllChecklistElement> checklistChecklistElementIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @retrofit2.http.Query("embed") String embed
  );

  @GET("checklists/{uuid}/checklist_elements.json")
  Call<RetrieveAllChecklistElement> checklistChecklistElementIndex1(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @retrofit2.http.Query("embed") String embed
  );

  /**
   * List Checklist Elements
   * List all checklist elements
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only ppes where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only ppes where last activity is at or before this timestamp. (optional)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @param ids If supplied, return only the specific checklist elements requested. (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("checklist_elements.json")
  Observable<Object> checklistElementIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @retrofit2.http.Query("ids") String ids
  );


  /**
   * Download Resource
   * Download Resource
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist logo to download (required)
   * @return Completable
   */
  @GET("resources/{uuid}/download.json")
  Observable<ResponseBody> resourceDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );


  /**
   * Download Resource
   * Download Resource
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist logo to download (required)
   * @return Completable
   */
  @GET("assigned_step_resources/{uuid}/download.json")
  Observable<ResponseBody> capturedDataDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

}
