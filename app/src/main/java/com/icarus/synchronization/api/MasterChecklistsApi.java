package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.RetrieveAllChecklistTypes;
import com.icarus.synchronization.syncmodels.RetrieveAllChecklistsStatuses;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MasterChecklistsApi {

  /**
   * List Checklist Statuses
   * List all checklist statuses
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only ppes where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only ppes where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;RetrieveAllChecklistsStatuses&gt;
   */
  @GET("checklist_statuses.json")
  Observable<RetrieveAllChecklistsStatuses> checklistStatusIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );
  /**
   * List Checklist Types
   * List checklist types
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only ppes where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only ppes where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;RetrieveAllChecklistTypes&gt;
   */
  @GET("checklist_types.json")
  Observable<RetrieveAllChecklistTypes> checklistTypeIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

  /**
   * Download Resource
   * Download Resource
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist logo to download (required)
   * @return Completable
   */
  @GET("resources/{uuid}/download.json")
  Call<ResponseBody> resourceDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );
}
