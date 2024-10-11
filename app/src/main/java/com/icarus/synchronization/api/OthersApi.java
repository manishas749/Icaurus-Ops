package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.SyncObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OthersApi {


  /**
   * Sync
   * Synchronization
   * @param accept The specific version of the API against which request is being made (required)
   * @return Observable&lt;SyncObject&gt;
   */
  @GET("sync.json")
  Call<SyncObject> sync(
          @retrofit2.http.Header("Accept") String accept,@retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore , @retrofit2.http.Query("location_id") Integer locationId, @Query("revision") Integer revision
  );



}
