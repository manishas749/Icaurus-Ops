package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Monika Rana on 12/27/2018.
 */

@Entity(tableName = "locations")
public class LocationEntity {

    public LocationEntity() {

    }

    public LocationEntity(Integer id, String name, String timezone, String lastSyncTime) {
        this.id = id;
        this.name = name;
        this.timezone = timezone;
        this.lastSyncTime = lastSyncTime;
    }

    @PrimaryKey
    @androidx.annotation.NonNull
    private Integer id;

    @androidx.annotation.NonNull
    private String name;

    @androidx.annotation.NonNull
    private String timezone;

    @ColumnInfo(name = "last_sync_time")
    private String lastSyncTime;

    @ColumnInfo(name = "last_sync_status")
    private Integer lastSyncStatus;


    public Integer getLastSyncStatus() {
        return lastSyncStatus;
    }

    public void setLastSyncStatus(Integer lastSyncStatus) {
        this.lastSyncStatus = lastSyncStatus;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(String lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }
}
