package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistCommentRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssignedChecklistCommentResponse;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedChecklistCommentApi {

  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_checklist_comments.json")
  Observable<AddUpdateAssignedChecklistCommentResponse> assignedChecklistCommentAdd(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssignedChecklistCommentRequest addUpdateAssignedChecklistCommentRequest
  );
}
