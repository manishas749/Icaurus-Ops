package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChecklistLocationObject {

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

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

    @SerializedName("pagination")
    @Expose
    public Pagination pagination;


    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("checklist_id")
        @Expose
        public Integer checklistId;
        @SerializedName("location_id")
        @Expose
        public Integer locationId;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("checklist_room_equipments")
        @Expose
        private List<ChecklistRoomEquipment> checklistRoomEquipments ;

        public List<ChecklistRoomEquipment> getChecklistRoomEquipments() {
            return checklistRoomEquipments;
        }

        public void setChecklistRoomEquipments(List<ChecklistRoomEquipment> checklistRoomEquipments) {
            this.checklistRoomEquipments = checklistRoomEquipments;
        }



        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
        }

        public Integer getLocationId() {
            return locationId;
        }

        public void setLocationId(Integer locationId) {
            this.locationId = locationId;
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

    public class ChecklistRoomEquipment {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("checklist_location_id")
        @Expose
        private Integer checklistLocationId;
        @SerializedName("location_room_equipment_id")
        @Expose
        private Integer locationRoomEquipmentId;
        @SerializedName("room_id")
        @Expose
        private Integer roomId;
        @SerializedName("equipment_id")
        @Expose
        private Integer equipmentId;
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

        public Integer getChecklistLocationId() {
            return checklistLocationId;
        }

        public void setChecklistLocationId(Integer checklistLocationId) {
            this.checklistLocationId = checklistLocationId;
        }

        public Integer getLocationRoomEquipmentId() {
            return locationRoomEquipmentId;
        }

        public void setLocationRoomEquipmentId(Integer locationRoomEquipmentId) {
            this.locationRoomEquipmentId = locationRoomEquipmentId;
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
        public String nextUrl;

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

        public String getNextUrl() {
            return nextUrl;
        }

        public void setNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
        }
    }
}