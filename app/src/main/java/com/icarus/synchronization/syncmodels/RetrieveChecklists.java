package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveChecklists {

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

    public class ChecklistLogo {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("checklist_id")
        @Expose
        public Integer checklistId;
        @SerializedName("logo_type")
        @Expose
        public Integer logoType;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("file_md5_checksum")
        @Expose
        public String fileMd5Checksum;
        @SerializedName("links")
        @Expose
        public Links links;

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

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
        }

        public Integer getLogoType() {
            return logoType;
        }

        public void setLogoType(Integer logoType) {
            this.logoType = logoType;
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

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }
    }


    public class ChecklistTitle {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("name")
        @Expose
        public String name;

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
    }


    public class Datum {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("checklist_type_id")
        @Expose
        public Integer checklistTypeId;
        @SerializedName("department_id")
        @Expose
        public Integer departmentId;
        @SerializedName("author_id")
        @Expose
        public Integer authorId;
        @SerializedName("parent_id")
        @Expose
        public Integer parentId;
        @SerializedName("assigned_to_id")
        @Expose
        public Integer assignedToId;
        @SerializedName("checklist_status_id")
        @Expose
        public Integer checklistStatusId;
        @SerializedName("is_sequential")
        @Expose
        public Boolean isSequential;
        @SerializedName("is_template")
        @Expose
        public Boolean isTemplate;
        @SerializedName("is_approval_required")
        @Expose
        public Boolean isApprovalRequired;
        @SerializedName("is_deleted")
        @Expose
        public Boolean isDeleted;
        @SerializedName("delete_reason")
        @Expose
        public String deleteReason;
        @SerializedName("estimated_hours")
        @Expose
        public Double estimatedHours;
        @SerializedName("due_at")
        @Expose
        public String dueAt;
        @SerializedName("closed_at")
        @Expose
        public String closedAt;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("checklist_title")
        @Expose
        public ChecklistTitle checklistTitle;
        @SerializedName("checklist_placeholder_count")
        @Expose
        private Integer placeholderCount;
        @SerializedName("checklist_logos")
        @Expose
        public List<ChecklistLogo> checklistLogos = null;

        public Integer getPlaceholderCount() {
            return placeholderCount;
        }

        public void setPlaceholderCount(Integer placeholderCount) {
            this.placeholderCount = placeholderCount;
        }

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

        public Integer getChecklistTypeId() {
            return checklistTypeId;
        }

        public void setChecklistTypeId(Integer checklistTypeId) {
            this.checklistTypeId = checklistTypeId;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Integer getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Integer authorId) {
            this.authorId = authorId;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public Integer getAssignedToId() {
            return assignedToId;
        }

        public void setAssignedToId(Integer assignedToId) {
            this.assignedToId = assignedToId;
        }

        public Integer getChecklistStatusId() {
            return checklistStatusId;
        }

        public void setChecklistStatusId(Integer checklistStatusId) {
            this.checklistStatusId = checklistStatusId;
        }

        public Boolean getSequential() {
            return isSequential;
        }

        public void setSequential(Boolean sequential) {
            isSequential = sequential;
        }

        public Boolean getTemplate() {
            return isTemplate;
        }

        public void setTemplate(Boolean template) {
            isTemplate = template;
        }

        public Boolean getApprovalRequired() {
            return isApprovalRequired;
        }

        public void setApprovalRequired(Boolean approvalRequired) {
            isApprovalRequired = approvalRequired;
        }

        public Boolean getDeleted() {
            return isDeleted;
        }

        public void setDeleted(Boolean deleted) {
            isDeleted = deleted;
        }

        public String getDeleteReason() {
            return deleteReason;
        }

        public void setDeleteReason(String deleteReason) {
            this.deleteReason = deleteReason;
        }

        public Double getEstimatedHours() {
            return estimatedHours;
        }

        public void setEstimatedHours(Double estimatedHours) {
            this.estimatedHours = estimatedHours;
        }

        public String getDueAt() {
            return dueAt;
        }

        public void setDueAt(String dueAt) {
            this.dueAt = dueAt;
        }

        public String getClosedAt() {
            return closedAt;
        }

        public void setClosedAt(String closedAt) {
            this.closedAt = closedAt;
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

        public ChecklistTitle getChecklistTitle() {
            return checklistTitle;
        }

        public void setChecklistTitle(ChecklistTitle checklistTitle) {
            this.checklistTitle = checklistTitle;
        }

        public List<ChecklistLogo> getChecklistLogos() {
            return checklistLogos;
        }

        public void setChecklistLogos(List<ChecklistLogo> checklistLogos) {
            this.checklistLogos = checklistLogos;
        }
    }

    public class Links {

        @SerializedName("self")
        @Expose
        public String self;

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