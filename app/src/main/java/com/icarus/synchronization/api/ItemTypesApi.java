package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.RetrieveAllItemTypes;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ItemTypesApi {
  /**
   * List Item Types
   * List all of an orgranization&#39;s item types.
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only item types where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only item types where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;RetrieveAllItemTypes&gt;
   */
  @GET("item_types.json")
  Observable<RetrieveAllItemTypes> itemTypeIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

}
