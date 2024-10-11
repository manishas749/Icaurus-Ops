package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveLocationEquipment {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("location_id")
        @Expose
        private Integer locationId;
        @SerializedName("serial_number")
        @Expose
        private String serialNumber;
        @SerializedName("upc_number")
        @Expose
        private String upcNumber;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("equipment")
        @Expose
        private Equipment equipment;
        @SerializedName("qr_storage")
        @Expose
        private QrStorage qrStorage;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getLocationId() {
            return locationId;
        }

        public void setLocationId(Integer locationId) {
            this.locationId = locationId;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getUpcNumber() {
            return upcNumber;
        }

        public void setUpcNumber(String upcNumber) {
            this.upcNumber = upcNumber;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Equipment getEquipment() {
            return equipment;
        }

        public void setEquipment(Equipment equipment) {
            this.equipment = equipment;
        }

        public QrStorage getQrStorage() {
            return qrStorage;
        }

        public void setQrStorage(QrStorage qrStorage) {
            this.qrStorage = qrStorage;
        }


    }

    public class Equipment {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("is_default")
        @Expose
        private Boolean isDefault;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Boolean isDefault) {
            this.isDefault = isDefault;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

}

