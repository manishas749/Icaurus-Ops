package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Monika Rana on 06/05/2020
 */
@Entity(tableName = "location_rooms")
public class LocationRoomEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "location_id")
    private Integer locationId;

    @ColumnInfo(name = "room_id")
    private Integer roomId;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    private Boolean isDeleted;

    @NonNull
    @ColumnInfo(name = "modified")
    private String modified;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull Integer locationId) {
        this.locationId = locationId;
    }

    @NonNull
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(@NonNull Integer roomId) {
        this.roomId = roomId;
    }

    @NonNull
    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(@NonNull Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @NonNull
    public String getModified() {
        return modified;
    }

    public void setModified(@NonNull String modified) {
        this.modified = modified;
    }
}
