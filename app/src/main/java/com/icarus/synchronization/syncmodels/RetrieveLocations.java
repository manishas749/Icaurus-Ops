package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveLocations {

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;
    @SerializedName("pagination")
    @Expose
    public Pagination pagination;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("address")
        @Expose
        public String address;
        @SerializedName("latitude")
        @Expose
        public Float latitude;
        @SerializedName("longitude")
        @Expose
        public Float longitude;
        @SerializedName("timezone")
        @Expose
        public String timezone;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("location_departments")
        @Expose
        public List<LocationDepartment> locationDepartments = null;
        @SerializedName("location_room_equipments")
        @Expose
        public List<LocationRoomEquipment> locationRoomEquipments = null;
        @SerializedName("location_rooms")
        @Expose
        public List<LocationRoom> locationRooms = null;
        @SerializedName("location_equipments")
        @Expose
        public List<LocationEquipments> locationEquipments = null;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public Float getLongitude() {
            return longitude;
        }

        public void setLongitude(Float longitude) {
            this.longitude = longitude;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Boolean getDeleted() {
            return isDeleted;
        }

        public void setDeleted(Boolean deleted) {
            isDeleted = deleted;
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

        public List<LocationDepartment> getLocationDepartments() {
            return locationDepartments;
        }

        public void setLocationDepartments(List<LocationDepartment> locationDepartments) {
            this.locationDepartments = locationDepartments;
        }

        public List<LocationRoomEquipment> getLocationRoomEquipments() {
            return locationRoomEquipments;
        }

        public void setLocationRoomEquipments(List<LocationRoomEquipment> locationRoomEquipments) {
            this.locationRoomEquipments = locationRoomEquipments;
        }

        public List<LocationRoom> getLocationRooms() {
            return locationRooms;
        }

        public void setLocationRooms(List<LocationRoom> locationRooms) {
            this.locationRooms = locationRooms;
        }

        public List<LocationEquipments> getLocationEquipments() {
            return locationEquipments;
        }

        public void setLocationEquipments(List<LocationEquipments> locationEquipments) {
            this.locationEquipments = locationEquipments;
        }
    }


    public class LocationDepartment {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("location_id")
        @Expose
        public Integer locationId;
        @SerializedName("department_id")
        @Expose
        public Integer departmentId;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;

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

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Boolean getDeleted() {
            return isDeleted;
        }

        public void setDeleted(Boolean deleted) {
            isDeleted = deleted;
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

    public class LocationRoomEquipment {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("location_id")
        @Expose
        public Integer locationId;
        @SerializedName("room_id")
        @Expose
        public Integer roomId;
        @SerializedName("equipment_id")
        @Expose
        public Integer equipmentId;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;

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

        public Integer getRoomId() {
            return roomId;
        }

        public void setRoomId(Integer roomId) {
            this.roomId = roomId;
        }

        public Integer getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(Integer equipmentId) {
            this.equipmentId = equipmentId;
        }

        public Boolean getDeleted() {
            return isDeleted;
        }

        public void setDeleted(Boolean deleted) {
            isDeleted = deleted;
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

    public class Pagination {

        @SerializedName("page")
        @Expose
        public Integer page;
        @SerializedName("per_page")
        @Expose
        public Integer perPage;
        @SerializedName("prev_url")
        @Expose
        public Object prevUrl;
        @SerializedName("next_url")
        @Expose
        public Object nextUrl;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Object getPrevUrl() {
            return prevUrl;
        }

        public void setPrevUrl(Object prevUrl) {
            this.prevUrl = prevUrl;
        }

        public Object getNextUrl() {
            return nextUrl;
        }

        public void setNextUrl(Object nextUrl) {
            this.nextUrl = nextUrl;
        }
    }


    public class LocationRoom {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("location_id")
        @Expose
        private Integer locationId;
        @SerializedName("room_id")
        @Expose
        private Integer roomId;
        @SerializedName("serial_number")
        @Expose
        private String serialNumber;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
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

        public Integer getRoomId() {
            return roomId;
        }

        public void setRoomId(Integer roomId) {
            this.roomId = roomId;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public Boolean isDeleted() {
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

        public QrStorage getQrStorage() {
            return qrStorage;
        }

        public void setQrStorage(QrStorage qrStorage) {
            this.qrStorage = qrStorage;
        }

    }

    public class LocationEquipments {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("location_id")
        @Expose
        private Integer locationId;
        @SerializedName("equipment_id")
        @Expose
        private Integer equipmentId;
        @SerializedName("serial_number")
        @Expose
        private String serialNumber;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("qr_storage")
        @Expose
        private QrStorage qrStorage;
        @SerializedName("upc_number")
        @Expose
        private String upcNumber;

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

        public Integer getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(Integer equipmentId) {
            this.equipmentId = equipmentId;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public Boolean isDeleted() {
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

        public QrStorage getQrStorage() {
            return qrStorage;
        }

        public void setQrStorage(QrStorage qrStorage) {
            this.qrStorage = qrStorage;
        }

        public String getUpcNumber() {
            return upcNumber;
        }

        public void setUpcNumber(String upcNumber) {
            this.upcNumber = upcNumber;
        }
    }

    public class QrStorage {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("links")
        @Expose
        private Links links;

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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }
    }

    public class Links {

        @SerializedName("self")
        @Expose
        private String self;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

    }
}