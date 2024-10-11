package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetreiveChecklistExecutionPermission {

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
    @SerializedName("group_id")
    @Expose
    public Integer groupId;
    @SerializedName("checklist_type_id")
    @Expose
    public Integer checklistTypeId;
    @SerializedName("checklist_status_id")
    @Expose
    public Integer checklistStatusId;
    @SerializedName("is_executable")
    @Expose
    public Boolean isExecutable;
    @SerializedName("is_assignable")
    @Expose
    public Boolean isAssignable;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getChecklistTypeId() {
        return checklistTypeId;
    }

    public void setChecklistTypeId(Integer checklistTypeId) {
        this.checklistTypeId = checklistTypeId;
    }

    public Integer getChecklistStatusId() {
        return checklistStatusId;
    }

    public void setChecklistStatusId(Integer checklistStatusId) {
        this.checklistStatusId = checklistStatusId;
    }

    public Boolean getExecutable() {
        return isExecutable;
    }

    public void setExecutable(Boolean executable) {
        isExecutable = executable;
    }

    public Boolean getAssignable() {
        return isAssignable;
    }

    public void setAssignable(Boolean assignable) {
        isAssignable = assignable;
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