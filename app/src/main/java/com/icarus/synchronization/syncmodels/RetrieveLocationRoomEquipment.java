package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveLocationRoomEquipment {

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
        @SerializedName("room_id")
        @Expose
        private Integer roomId;
        @SerializedName("equipment_id")
        @Expose
        private Integer equipmentId;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("is_room_deleted")
        @Expose
        private Boolean isRoomDeleted;
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

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public Boolean getIsRoomDeleted() {
            return isRoomDeleted;
        }

        public void setIsRoomDeleted(Boolean isRoomDeleted) {
            this.isRoomDeleted = isRoomDeleted;
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
