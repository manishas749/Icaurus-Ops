package com.icarus.synchronization.api;


import com.icarus.synchronization.postsyncmodel.AddUpdateAssginedRoomEquipmentsRequest;
import com.icarus.synchronization.postsyncmodel.AddUpdateAssginedRoomEquipmentsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AssignedRoomEquipmentsApi {
  /**
   * List Assigned Room/Equipments of an Assigned Checklist
   * List Assigned Room/Equipments of an Assigned Checklist
   * @param accept The specific version of the API against which request is being made (required)
   * @param uuid UUID of the assigned checklist to fetch room equipments for (required)
   * @return Observable&lt;Object&gt;
   */
  @GET("assigned_checklists/{uuid}/assigned_room_equipments.json")
  Observable<Object> assignedChecklistAssignedRoomEquipmentIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Path("uuid") String uuid
  );

  /**
   * Bulk Add And Update Assgined Room/Equipments
   * Bulk Add And Update Assgined Room/Equipments
   * @param accept The specific version of the API against which request is being made (required)
   * @param addUpdateAssginedRoomEquipmentsRequest  (optional)
   * @return Observable&lt;AddUpdateAssginedRoomEquipmentsResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("assigned_room_equipments.json")
  Observable<AddUpdateAssginedRoomEquipmentsResponse> assignedRoomEquipmentAdd(@retrofit2.http.Header("Accept") String accept, @retrofit2.http.Body AddUpdateAssginedRoomEquipmentsRequest addUpdateAssginedRoomEquipmentsRequest
  );

  /**
   * List Assigned Room Equipments
   * List Assigned Room Equipments
   * @param accept The specific version of the API against which request is being made (required)
   * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
   * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
   * @param lastActivityAfter Return only users where last activity is at or after this timestamp. (optional)
   * @param lastActivityBefore Return only users where last activity is at or before this timestamp. (optional)
   * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
   * @param ids If supplied, return only the specific users requested. (optional)
   * @param revision If supplied, return only the specific assigned room equipment of requested revision. (optional)
   * @return Observable&lt;Object&gt;
   */
  @GET("assigned_room_equipments.json")
  Observable<Object> assignedRoomEquipmentIndex(
          @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @retrofit2.http.Query("ids") String ids, @retrofit2.http.Query("revision") Integer revision
  );

}
