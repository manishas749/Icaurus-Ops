package com.icarus.synchronization.api;

import com.icarus.synchronization.syncmodels.RetrieveUsers;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UsersApi {
  /**
   * List Users
   * List users of the client along with user location departments and custom fields
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only users where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only users where last activity is at or before this timestamp. (optional)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("users.json")
  Observable<RetrieveUsers> userIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

  /**
   * List User&#39;s Locations/Departments
   * List User&#39;s location departments
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only user&#39;s favorites where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only user&#39;s favorites where last activity is at or before this timestamp. (optional)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("user_location_departments.json")
  Observable<Object> userLocationDepartmentIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @Query("revision") Integer revision
  );

}
