package com.icarus.synchronization.api;

import com.icarus.synchronization.postsyncmodel.AddUpdateUserFavoritesRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserFavoritesResponse;
import com.icarus.synchronization.syncmodels.RetrieveUsersFavourites;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserFavoritesApi {


  /**
   * List User&#39;s Favorite Checklists
   * List User&#39;s Favorite Checklists
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only user&#39;s favorites where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only user&#39;s favorites where last activity is at or before this timestamp. (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("user_favorites.json")
  Observable<RetrieveUsersFavourites> userFavoriteIndex(
          @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
  );

  @Headers({
          "Content-Type:application/json"
  })
  @POST("user_favorites.json")
  Observable<AddUpdateUserFavoritesResponse> addUpdateUserFavorite(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateUserFavoritesRequest userFavoritesRequest
  );
}
