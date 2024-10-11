package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedCaution;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedCautionsRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedNotesRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedNotesResponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedWarningResponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedWarningsRequest;

import java.time.OffsetDateTime;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedNCWApi {

  /**
   * Bulk Add And Update Assigned Note
   * Bulk Add And Update Assigned Notes
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedNotesRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedNotesResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_notes.json")
  Observable<AddUpdateAssignedNotesResponse> assignedNoteAdd(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedNotesRequest addUpdateAssignedNotesRequest
  );

  /**
   * Bulk Add And Update Assigned Cautions
   * Bulk Add And Update Assigned Cautions
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedCautionsRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedCaution&gt;
   */
  @Headers({
          "Content-Type:application/json"
  })
  @POST("assigned_cautions.json")
  Observable<AddUpdateAssignedCaution> assignedCautionAdd(@retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedCautionsRequest addUpdateAssignedCautionsRequest
  );

  /**
   * Bulk Add And Update Assigned Warnings
   * Bulk Add And Update Assigned Warnings
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssignedWarningsRequest  (optional)
   * @return Observable&lt;AddUpdateAssignedWarningResponse&gt;
   */
  @Headers({
          "Content-Type:application/json"
  })
  @POST("assigned_warnings.json")
  Observable<AddUpdateAssignedWarningResponse> assignedWarningAdd( @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedWarningsRequest addUpdateAssignedWarningsRequest
  );

}
