package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveAssignedChecklist {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

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

    public class AssignedLogo {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("checklist_logo_id")
        @Expose
        private Integer checklistLogoId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public Integer getChecklistLogoId() {
            return checklistLogoId;
        }

        public void setChecklistLogoId(Integer checklistLogoId) {
            this.checklistLogoId = checklistLogoId;
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

    public class AssignedRoomEquipment {

        @SerializedName("uuid")
        @Expose
        private String uuid;
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

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
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

    public class AssignedDepartment {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("department_id")
        @Expose
        private Integer departmentId;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getAssignedChecklistUuid() {
            return assignedChecklistUuid;
        }

        public void setAssignedChecklistUuid(String assignedChecklistUuid) {
            this.assignedChecklistUuid = assignedChecklistUuid;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
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

    public class AssignedUser {
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("assigned_by")
        @Expose
        private Integer assignedBy;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

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

        public Integer getAssignedBy() {
            return assignedBy;
        }

        public void setAssignedBy(Integer assignedBy) {
            this.assignedBy = assignedBy;
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

    public class Datum {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("checklist_id")
        @Expose
        private Integer checklistId;
        @SerializedName("department_id")
        @Expose
        private Integer departmentId;
        @SerializedName("location_id")
        @Expose
        private Integer locationId;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("assignee_type")
        @Expose
        private String assigneeType;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("started_by_user_id")
        @Expose
        private Integer startedByUserId;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("assigned_at")
        @Expose
        private String assignedAt;
        @SerializedName("due_at")
        @Expose
        private String dueAt;
        @SerializedName("started_at")
        @Expose
        private String startedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("assigned_room_equipment")
        @Expose
        private AssignedRoomEquipment assignedRoomEquipment;
        @SerializedName("assigned_logo")
        @Expose
        private AssignedLogo assignedLogo;
        @SerializedName("assigned_departments")
        @Expose
        private List<AssignedDepartment> assignedDepartments = null;
        @SerializedName("assigned_users")
        @Expose
        private List<AssignedUser> assignedUsers = null;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Integer getLocationId() {
            return locationId;
        }

        public void setLocationId(Integer locationId) {
            this.locationId = locationId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAssigneeType() {
            return assigneeType;
        }

        public void setAssigneeType(String assigneeType) {
            this.assigneeType = assigneeType;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getStartedByUserId() {
            return startedByUserId;
        }

        public void setStartedByUserId(Integer startedByUserId) {
            this.startedByUserId = startedByUserId;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getAssignedAt() {
            return assignedAt;
        }

        public void setAssignedAt(String assignedAt) {
            this.assignedAt = assignedAt;
        }

        public String getDueAt() {
            return dueAt;
        }

        public void setDueAt(String dueAt) {
            this.dueAt = dueAt;
        }

        public String getStartedAt() {
            return startedAt;
        }

        public void setStartedAt(String startedAt) {
            this.startedAt = startedAt;
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

        public AssignedRoomEquipment getAssignedRoomEquipment() {
            return assignedRoomEquipment;
        }

        public void setAssignedRoomEquipment(AssignedRoomEquipment assignedRoomEquipment) {
            this.assignedRoomEquipment = assignedRoomEquipment;
        }

        public AssignedLogo getAssignedLogo() {
            return assignedLogo;
        }

        public void setAssignedLogo(AssignedLogo assignedLogo) {
            this.assignedLogo = assignedLogo;
        }

        public List<AssignedDepartment> getAssignedDepartments() {
            return assignedDepartments;
        }

        public void setAssignedDepartments(List<AssignedDepartment> assignedDepartments) {
            this.assignedDepartments = assignedDepartments;
        }

        public List<AssignedUser> getAssignedUsers() {
            return assignedUsers;
        }

        public void setAssignedUsers(List<AssignedUser> assignedUsers) {
            this.assignedUsers = assignedUsers;
        }
    }

    public class Pagination {

        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("per_page")
        @Expose
        private Integer perPage;
        @SerializedName("prev_url")
        @Expose
        private Object prevUrl;
        @SerializedName("next_url")
        @Expose
        private String nextUrl;

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