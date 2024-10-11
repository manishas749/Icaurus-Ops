package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveUsersFavourites {

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
        @SerializedName("user_id")
        @Expose
        public Integer userId;
        @SerializedName("checklist_id")
        @Expose
        public Integer checklistId;
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

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
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

}