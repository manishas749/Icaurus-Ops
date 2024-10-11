package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.RetrieveHazards;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface HazardsApi {
  /**
   * Download Hazard
   * Download Hazard icon for the given Hazard UUID
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the Hazard to download (required)
   * @return Observable&lt;ResponseBody&gt;
   */
  @GET("hazards/{uuid}/download.json")
  Observable<ResponseBody> hazardDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

  /**
   * List Hazards
   * List all of an organization&#39;s hazards.
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only hazards where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only hazards where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;RetrieveHazards&gt;
   */
  @GET("hazards.json")
  Observable<RetrieveHazards> hazardIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

}
