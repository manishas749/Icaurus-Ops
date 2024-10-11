package com.icarus.synchronization.api;

import com.icarus.synchronization.syncmodels.RetrieveAllEquipments;
import com.icarus.synchronization.syncmodels.RetrieveLocationEquipment;
import com.icarus.synchronization.syncmodels.RetrieveLocationRoomEquipment;
import com.icarus.synchronization.syncmodels.RetrieveLocationRooms;
import com.icarus.synchronization.syncmodels.RetrieveLocations;
import com.icarus.synchronization.syncmodels.Rooms;


import java.time.OffsetDateTime;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LocationsApi {
    /**
     * List Equipments
     * List all equipments of the client
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only users where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only users where last activity is at or before this timestamp. (optional)
     * @return Observable&lt;RetrieveAllEquipments&gt;
     */
    @GET("equipments.json")
    Observable<RetrieveAllEquipments> equipmentIndex(
            @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("revision") Integer revision
    );

    /**
     * List Location Departments
     * List all location departments of the client
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only location departments where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only location departments where last activity is at or before this timestamp. (optional)
     * @param embed              If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
     * @return Observable&lt;Object&gt;
     */
    @GET("location_departments.json")
    Observable<Object> locationDepartmentIndex(
            @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @Query("revision") Integer revision
    );

    /**
     * List Location Equipments
     * List all location equipments of the client
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only location equipments where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only location equipments where last activity is at or before this timestamp. (optional)
     * @param embed              If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
     * @param ids                If supplied, return only the specific location equipment requested. (optional)
     * @return Observable&lt;Object&gt;
     */
    @GET("location_equipments.json")
    Observable<Object> locationEquipmentIndex(
            @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @retrofit2.http.Query("ids") String ids
    );

    /**
     * List Locations
     * List all locations of the client
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only locations where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only locations where last activity is at or before this timestamp. (optional)
     * @param embed              If supplied add the embed as an object containing embed info and remove foreign key reference from the parent data if exists. (optional)
     * @return Observable&lt;Object&gt;
     */
    @GET("locations.json")
    Observable<RetrieveLocations> locationIndex(
            @Header("Accept") String accept, @Query("per_page") Integer perPage, @Query("page") Integer page, @Query("last_activity_after") String lastActivityAfter, @Query("last_activity_before") String lastActivityBefore, @Query("embed") String embed, @Query("revision") Integer revision
    );

    /**
     * List Location Rooms/Equipments
     * List all location room equipments of the client
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only location room equipments where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only location room equipments where last activity is at or before this timestamp. (optional)
     * @param embed              If supplied add the embed as an object and remove foreign key reference from the parent data (optional)
     * @return Observable&lt;Object&gt;
     */
    @GET("location_room_equipments.json")
    Observable<Object> locationRoomEquipmentIndex(
            @retrofit2.http.Header("Accept") String accept, @retrofit2.http.Query("per_page") Integer perPage, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("last_activity_after") String lastActivityAfter, @retrofit2.http.Query("last_activity_before") String lastActivityBefore, @retrofit2.http.Query("embed") String embed, @Query("revision") Integer revision
    );

    /**
     * List Rooms
     * List all rooms of the client
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only rooms where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only rooms where last activity is at or before this timestamp. (optional)
     * @return Observable&lt;Rooms&gt;
     */
    @GET("rooms.json")
    Observable<Rooms> roomIndex(
            @retrofit2.http.Header("Accept") String accept,
            @retrofit2.http.Query("per_page") Integer perPage,
            @retrofit2.http.Query("page") Integer page,
            @retrofit2.http.Query("last_activity_after") String lastActivityAfter,
            @retrofit2.http.Query("last_activity_before") String lastActivityBefore,
            @Query("revision") Integer revision
    );

    /**
     * List Location Rooms
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only rooms where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only rooms where last activity is at or before this timestamp. (optional)
     * @param locationId         The selected location id by user
     * @return Observable&lt;LocationRooms&gt;
     */
    @GET("location_rooms.json")
    Observable<RetrieveLocationRooms> locationRoomsIndex(
            @retrofit2.http.Header("Accept") String accept,
            @retrofit2.http.Query("per_page") Integer perPage,
            @retrofit2.http.Query("page") Integer page,
            @retrofit2.http.Query("last_activity_after") String lastActivityAfter,
            @retrofit2.http.Query("last_activity_before") String lastActivityBefore,
            @Query("revision") Integer revision,
            @retrofit2.http.Query("location_id") Integer locationId
    );

    /**
     * List Location Equipments
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only rooms where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only rooms where last activity is at or before this timestamp. (optional)
     * @param locationId         The selected location id by user
     * @return Observable&lt;LocationEquipments&gt;
     */
    @GET("location_equipment.json")
    Observable<RetrieveLocationEquipment> locationEquipmentsIndex(
            @retrofit2.http.Header("Accept") String accept,
            @retrofit2.http.Query("per_page") Integer perPage,
            @retrofit2.http.Query("page") Integer page,
            @retrofit2.http.Query("last_activity_after") String lastActivityAfter,
            @retrofit2.http.Query("last_activity_before") String lastActivityBefore,
            @Query("revision") Integer revision,
            @retrofit2.http.Query("location_id") Integer locationId
    );

    /**
     * List LocationRoomEquipments
     *
     * @param accept             The specific version of the API against which request is being made (required)
     * @param perPage            Return up to this number of objects per response. Must be an integer between 1 and 100. Defaults to 100. (optional)
     * @param page               A cursor for use in pagination. Returns the n-th chunk of &#x60;per_page&#x60; objects (optional)
     * @param lastActivityAfter  Return only rooms where last activity is at or after this timestamp. (optional)
     * @param lastActivityBefore Return only rooms where last activity is at or before this timestamp. (optional)
     * @param locationId         The selected location id by user
     * @return Observable&lt;LocationRoomEquipments&gt;
     */
    @GET("location_room_equipments.json")
    Observable<RetrieveLocationRoomEquipment> locationRoomEquipmentsIndex(
            @retrofit2.http.Header("Accept") String accept,
            @retrofit2.http.Query("per_page") Integer perPage,
            @retrofit2.http.Query("page") Integer page,
            @retrofit2.http.Query("last_activity_after") String lastActivityAfter,
            @retrofit2.http.Query("last_activity_before") String lastActivityBefore,
            @Query("revision") Integer revision,
            @retrofit2.http.Query("location_id") Integer locationId
    );

}
