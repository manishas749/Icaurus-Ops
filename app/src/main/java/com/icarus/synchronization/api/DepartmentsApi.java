package com.icarus.synchronization.api;


import com.icarus.synchronization.syncmodels.DepartmentsObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface DepartmentsApi {
  /**
   * List Departments
   * List all of the organization&#39;s departments.
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only departments where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only departments where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;DepartmentsObject&gt;
   */
  @GET("departments.json")
  Observable<DepartmentsObject> departmentIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore,@Query("revision") Integer revision
  );

}
