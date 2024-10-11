package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.RetrieveAllClientLogo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AccountLogosApi {
  /**
   * Download Account Logo
   * TODO: Add Description
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the Account Logo to download (required)
   * @return Observable&lt;ResponseBody&gt;
   */
  @GET("client_logos/{uuid}/download.json")
  Observable<ResponseBody> clientLogoDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @Query("revision") Integer revision
  );

  /**
   * List Account Logos
   * List all of an organization logos.
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only logos where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only logoss where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;RetrieveAllClientLogos&gt;
   */
  @GET("client_logos.json")
  Observable<RetrieveAllClientLogo> clientLogoIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

}
