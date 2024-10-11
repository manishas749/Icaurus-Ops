package com.icarus.synchronization.api;

import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsAttachmentresponse;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsAttachmentsrequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsrequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateUserSuggestionsresponse;
import com.icarus.synchronization.postsyncmodel.UserSuggestionAttachmentUploadResponse;
import com.icarus.synchronization.syncmodels.WordorderUploadResponse;

import io.reactivex.Completable;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface SuggestionsApi {
  /**
   * Bulk Add And Update User Suggestions
   * Bulk Add And Update User Suggestions
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateUserSuggestionsrequest  (optional)
   * @return Observable&lt;AddUpdateUserSuggestionsresponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("user_suggestions.json")
  Observable<AddUpdateUserSuggestionsresponse> userSuggestionAdd( @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateUserSuggestionsrequest addUpdateUserSuggestionsrequest
  );

  /**
   * Bulk Add And Update User Suggestion Attachments
   * Bulk Add And Update User Suggestion Attachments
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateUserSuggestionsAttachmentsrequest  (optional)
   * @return Observable&lt;AddUpdateUserSuggestionsAttachmentresponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("user_suggestion_attachments.json")
  Observable<AddUpdateUserSuggestionsAttachmentresponse> userSuggestionAttachmentAdd( @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateUserSuggestionsAttachmentsrequest addUpdateUserSuggestionsAttachmentsrequest
  );

  /**
   * Download Suggestion Attachment
   * Download Suggestion Attachment
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the suggestion attachment to download (required)
   * @return Completable
   */
  @GET("user_suggestion_attachments/{uuid}/download.json")
  Completable userSuggestionAttachmentDownload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );


  /**
   * Upload Suggestion Attachment
   * TODO: Add Description
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the Hazard to upload (required)
   * @param content  (required)
   * @return Observable&lt;UserSuggestionAttachmentUploadResponse&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("user_suggestion_attachments/{uuid}/upload.json")
  Observable<UserSuggestionAttachmentUploadResponse> userSuggestionAttachmentUpload(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid, @retrofit2.http.Field("content") String content
  );

  /**
   * List Suggestions
   * List User Suggestions
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only users&#39;s suggestions where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only users&#39;s suggestions where last activity is at or before this timestamp. (optional)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @param ids If supplied, return only the specific users&#39;s suggestions requested. (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("user_suggestions.json")
  Observable<Object> userSuggestionIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @retrofit2.http.Query("ids") String ids
  );

  /**
   * https://api-dev.icarusplus.com/workorder_attachments/{uuid}/upload.json
   * Upload Resource
   * Upload Resource
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the checklist logo to download (required)
   * @return Completable
   */
  @Multipart
  @POST("user_suggestion_attachments/{uuid}/upload.json")
  Observable<WordorderUploadResponse> resourceUpload(
          @retrofit2.http.Header("Accept") String accept, @Part MultipartBody.Part file, @retrofit2.http.Path("uuid") String uuid
  );

}
