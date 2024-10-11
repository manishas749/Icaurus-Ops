package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.ClientSettingsObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AccountSettingsApi {
  /**
   * List Account Settings
   * List Account Settings
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only client settings where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only client settings where last activity is at or before this timestamp. (optional)
   * @param ids If supplied, return only the specific client settings requested. (optional)
   * @return Observable&lt;ClientSettingsObject&gt;
   */
  @GET("client_settings.json")
  Observable<ClientSettingsObject> clientSettingIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

}
