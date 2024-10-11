package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveUsers {

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

    public class UserLocationDepartment {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("user_id")
        @Expose
        public Integer userId;
        @SerializedName("location_id")
        @Expose
        public Integer locationId;
        @SerializedName("department_id")
        @Expose
        public Integer departmentId;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
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

    public class CustomFields {

        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("cet_level")
        @Expose
        public String cetLevel;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCetLevel() {
            return cetLevel;
        }

        public void setCetLevel(String cetLevel) {
            this.cetLevel = cetLevel;
        }
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("password")
        @Expose
        public String password;
        @SerializedName("group_id")
        @Expose
        public Integer groupId;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_name")
        @Expose
        public String lastName;
        @SerializedName("full_name")
        @Expose
        public String fullName;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("business_name")
        @Expose
        public String businessName;
        @SerializedName("is_administrator")
        @Expose
        public Boolean isAdministrator;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("user_location_departments")
        @Expose
        public List<UserLocationDepartment> userLocationDepartments = null;
        @SerializedName("custom_fields")
        @Expose
        public CustomFields customFields;

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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public Boolean getAdministrator() {
            return isAdministrator;
        }

        public void setAdministrator(Boolean administrator) {
            isAdministrator = administrator;
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

        public List<UserLocationDepartment> getUserLocationDepartments() {
            return userLocationDepartments;
        }

        public void setUserLocationDepartments(List<UserLocationDepartment> userLocationDepartments) {
            this.userLocationDepartments = userLocationDepartments;
        }

        public CustomFields getCustomFields() {
            return customFields;
        }

        public void setCustomFields(CustomFields customFields) {
            this.customFields = customFields;
        }
    }

}