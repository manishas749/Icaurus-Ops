package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveAllClientLogo {

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

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("file_md5_checksum")
        @Expose
        private String fileMd5Checksum;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFileMd5Checksum() {
            return fileMd5Checksum;
        }

        public void setFileMd5Checksum(String fileMd5Checksum) {
            this.fileMd5Checksum = fileMd5Checksum;
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
        private Object nextUrl;

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