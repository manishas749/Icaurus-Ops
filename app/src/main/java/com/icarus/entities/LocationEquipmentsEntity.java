package com.icarus.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Created by Monika Rana on 06/05/2020
 */

@Entity(tableName = "location_equipments")
public class LocationEquipmentsEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "location_id")
    private Integer locationId;

    @ColumnInfo(name = "equipment_id")
    private Integer equipmentId;

    @ColumnInfo(name = "serial_number")
    private String serialNumber;

    @NonNull
    @ColumnInfo(name = "is_deleted")
    private Boolean isDeleted;

    @NonNull
    @ColumnInfo(name = "modified")
    private String modified;

    @ColumnInfo(name = "upc_number")
    private String upcNumber;

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
    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(@NonNull Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    @NonNull
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(@NonNull String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @NonNull
    public Boolean getIsDeleted() {
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

    @NonNull
    public String getUpcNumber() {
        return upcNumber;
    }

    public void setUpcNumber(@NonNull String upcNumber) {
        this.upcNumber = upcNumber;
    }
}
