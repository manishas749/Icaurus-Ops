package com.icarus.synchronization.api;

import com.icarus.synchronization.syncmodels.ChecklistLocationObject;
import com.icarus.synchronization.syncmodels.RetrieveChecklists;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ChecklistApi {

    /*@GET("checklists.json")
    Observable<RetrieveChecklists> checklistIndex(@Header("Accept") String var1, @Query("per_page") Integer var2, @Query("page") Integer var3, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("embed") String embed,@Query("published") boolean isPublished,@Query("template") boolean isTemplate,@Query("status_id") String statusId,@Query("location_id") Integer locationId, @Query("revision") Integer revision);*/

    @GET("checklists.json")
    Call<RetrieveChecklists> checklistIndex(@Header("Accept") String var1, @Query("per_page") Integer var2, @Query("page") Integer var3, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("embed") String embed, @Query("published") boolean isPublished, @Query("template") boolean isTemplate, @Query("status_id") String statusId, @Query("location_id") Integer locationId, @Query("revision") Integer revision);

    /**
     * List Checklist Locations
     * List all checklist locations
     * @param accept The specific version of the API against which request is being made (required)
     * @param perPage Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter Return only ppes where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only ppes where last activity is at or before this timestamp. (optional)
     * @param embed If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
     * @return Observable&lt;Object&gt;
     */
    @GET("checklist_locations.json")
    Observable<ChecklistLocationObject> checklistLocationIndex(
            @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("embed") String embed, @Query("revision") Integer revision, @Query("checklist_ids") Integer checklistId
    );
}
