package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.RetrievePPEs;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface PpesApi {
  /**
   * Download PPE
   * Allows you to download the PPE icon
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the PPE to download (required)
   * @return Observable&lt;ResponseBody&gt;
   */
  @GET("ppes/{uuid}/download.json")
  Observable<ResponseBody> ppeDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

  /**
   * List PPEs
   * List all of an organization&#39;s PPE&#39;s
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only ppes where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only ppes where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;RetrievePPEs&gt;
   */
  @GET("ppes.json")
  Observable<RetrievePPEs> ppeIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

}
