package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReteriveAssignedChecklistDetail {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class AssignedCaution {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("caution_id")
        @Expose
        private Integer cautionId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("status")
        @Expose
        private String status;
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getCautionId() {
            return cautionId;
        }

        public void setCautionId(Integer cautionId) {
            this.cautionId = cautionId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    public class AssignedChecklistComment {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("checklist_id")
        @Expose
        private Integer checklistId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("comment")
        @Expose
        private String comment;
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

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
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

    public class AssignedChecklistPauseTime {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("resumed_by_user_id")
        @Expose
        private Integer resumedByUserId;
        @SerializedName("pause_reason")
        @Expose
        private String reason;
        @SerializedName("is_paused")
        @Expose
        private Boolean isPaused;
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getResumedByUserId() {
            return resumedByUserId;
        }

        public void setResumedByUserId(Integer resumedByUserId) {
            this.resumedByUserId = resumedByUserId;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public Boolean getIsPaused() {
            return isPaused;
        }

        public void setIsPaused(Boolean isPaused) {
            this.isPaused = isPaused;
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

    public class AssignedDecision {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("decision_id")
        @Expose
        private Integer decisionId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("status")
        @Expose
        private String status;
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getDecisionId() {
            return decisionId;
        }

        public void setDecisionId(Integer decisionId) {
            this.decisionId = decisionId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    public class AssignedItemPlaceholder {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("item_placeholder_id")
        @Expose
        private Integer itemPlaceholderId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("model")
        @Expose
        private String model;
        @SerializedName("foreign_key")
        @Expose
        private Integer foreignKey;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Integer getForeignKey() {
            return foreignKey;
        }

        public void setForeignKey(Integer foreignKey) {
            this.foreignKey = foreignKey;
        }

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

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public Integer getItemPlaceholderId() {
            return itemPlaceholderId;
        }

        public void setItemPlaceholderId(Integer itemPlaceholderId) {
            this.itemPlaceholderId = itemPlaceholderId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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

    public class AssignedNote {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("note_id")
        @Expose
        private Integer noteId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("status")
        @Expose
        private String status;
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getNoteId() {
            return noteId;
        }

        public void setNoteId(Integer noteId) {
            this.noteId = noteId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

    public class AssignedStep {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("step_id")
        @Expose
        private Integer stepId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
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

        public Integer getStepId() {
            return stepId;
        }

        public void setStepId(Integer stepId) {
            this.stepId = stepId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
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


    public class AssignedStepAttribute {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("item_uuid")
        @Expose
        private String itemUuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("step_id")
        @Expose
        private Integer stepId;
        @SerializedName("step_attribute_id")
        @Expose
        private Integer stepAttributeId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("value")
        @Expose
        private String value;
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

        public String getItemUuid() {
            return itemUuid;
        }

        public void setItemUuid(String itemUuid) {
            this.itemUuid = itemUuid;
        }

        public String getAssignedChecklistUuid() {
            return assignedChecklistUuid;
        }

        public void setAssignedChecklistUuid(String assignedChecklistUuid) {
            this.assignedChecklistUuid = assignedChecklistUuid;
        }

        public Integer getStepId() {
            return stepId;
        }

        public void setStepId(Integer stepId) {
            this.stepId = stepId;
        }

        public Integer getStepAttributeId() {
            return stepAttributeId;
        }

        public void setStepAttributeId(Integer stepAttributeId) {
            this.stepAttributeId = stepAttributeId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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

    public class AssignedStepResource {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("item_type_id")
        @Expose
        private Integer itemTypeId;
        @SerializedName("item_id")
        @Expose
        private Integer itemId;
        @SerializedName("display_filename")
        @Expose
        private String displayFilename;
        @SerializedName("filename")
        @Expose
        private String filename;
        @SerializedName("content_type")
        @Expose
        private String contentType;
        @SerializedName("md5_checksum")
        @Expose
        private String md5Checksum;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("is_deleted")
        @Expose
        private Boolean isDeleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("links")
        @Expose
        private Links links;

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

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public Integer getItemTypeId() {
            return itemTypeId;
        }

        public void setItemTypeId(Integer itemTypeId) {
            this.itemTypeId = itemTypeId;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public String getDisplayFilename() {
            return displayFilename;
        }

        public void setDisplayFilename(String displayFilename) {
            this.displayFilename = displayFilename;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getMd5Checksum() {
            return md5Checksum;
        }

        public void setMd5Checksum(String md5Checksum) {
            this.md5Checksum = md5Checksum;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
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

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
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


    public class AssignedWarning {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("assigned_checklist_uuid")
        @Expose
        private String assignedChecklistUuid;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("warning_id")
        @Expose
        private Integer warningId;
        @SerializedName("status")
        @Expose
        private String status;
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

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getWarningId() {
            return warningId;
        }

        public void setWarningId(Integer warningId) {
            this.warningId = warningId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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


    public class Data {

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
        private Object startedByUserId;
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
        private Object startedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("assigned_cautions")
        @Expose
        private List<AssignedCaution> assignedCautions = null;
        @SerializedName("assigned_checklist_pause_times")
        @Expose
        private List<AssignedChecklistPauseTime> assignedChecklistPauseTimes = null;
        @SerializedName("assigned_decisions")
        @Expose
        private List<AssignedDecision> assignedDecisions = null;
        @SerializedName("assigned_item_placeholders")
        @Expose
        private List<AssignedItemPlaceholder> assignedItemPlaceholders = null;
        @SerializedName("assigned_notes")
        @Expose
        private List<AssignedNote> assignedNotes = null;
        @SerializedName("assigned_step_attributes")
        @Expose
        private List<AssignedStepAttribute> assignedStepAttributes = null;
        @SerializedName("assigned_step_resources")
        @Expose
        private List<AssignedStepResource> assignedStepResources = null;
        @SerializedName("assigned_step_skip_difer_reasons")
        @Expose
        private List<AssignedStep> assignedStepSkipDeferReason = null;
        @SerializedName("assigned_steps")
        @Expose
        private List<AssignedStep> assignedSteps = null;
        @SerializedName("assigned_warnings")
        @Expose
        private List<AssignedWarning> assignedWarnings = null;
        @SerializedName("logs")
        @Expose
        private List<Log> logs = null;
        @SerializedName("assigned_departments")
        @Expose
        private List<AssignedDepartment> assignedDepartments = null;
        @SerializedName("assigned_users")
        @Expose
        private List<AssignedUser> assignedUsers = null;
        @SerializedName("assigned_checklist_comments")
        @Expose
        private List<AssignedChecklistComment> assignedChecklistComments = null;

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

        public Object getStartedByUserId() {
            return startedByUserId;
        }

        public void setStartedByUserId(Object startedByUserId) {
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

        public Object getStartedAt() {
            return startedAt;
        }

        public void setStartedAt(Object startedAt) {
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

        public List<AssignedCaution> getAssignedCautions() {
            return assignedCautions;
        }

        public void setAssignedCautions(List<AssignedCaution> assignedCautions) {
            this.assignedCautions = assignedCautions;
        }

        public List<AssignedChecklistPauseTime> getAssignedChecklistPauseTimes() {
            return assignedChecklistPauseTimes;
        }

        public void setAssignedChecklistPauseTimes(List<AssignedChecklistPauseTime> assignedChecklistPauseTimes) {
            this.assignedChecklistPauseTimes = assignedChecklistPauseTimes;
        }

        public List<AssignedDecision> getAssignedDecisions() {
            return assignedDecisions;
        }

        public void setAssignedDecisions(List<AssignedDecision> assignedDecisions) {
            this.assignedDecisions = assignedDecisions;
        }

        public List<AssignedItemPlaceholder> getAssignedItemPlaceholders() {
            return assignedItemPlaceholders;
        }

        public void setAssignedItemPlaceholders(List<AssignedItemPlaceholder> assignedItemPlaceholders) {
            this.assignedItemPlaceholders = assignedItemPlaceholders;
        }

        public List<AssignedNote> getAssignedNotes() {
            return assignedNotes;
        }

        public void setAssignedNotes(List<AssignedNote> assignedNotes) {
            this.assignedNotes = assignedNotes;
        }

        public List<AssignedStepAttribute> getAssignedStepAttributes() {
            return assignedStepAttributes;
        }

        public void setAssignedStepAttributes(List<AssignedStepAttribute> assignedStepAttributes) {
            this.assignedStepAttributes = assignedStepAttributes;
        }

        public List<AssignedStepResource> getAssignedStepResources() {
            return assignedStepResources;
        }

        public void setAssignedStepResources(List<AssignedStepResource> assignedStepResources) {
            this.assignedStepResources = assignedStepResources;
        }

        public List<AssignedStep> getAssignedStepSkipDeferReason() {
            return assignedStepSkipDeferReason;
        }

        public void setAssignedStepSkipDeferReason(List<AssignedStep> assignedStepSkipDeferReason) {
            this.assignedStepSkipDeferReason = assignedStepSkipDeferReason;
        }

        public List<AssignedStep> getAssignedSteps() {
            return assignedSteps;
        }

        public void setAssignedSteps(List<AssignedStep> assignedSteps) {
            this.assignedSteps = assignedSteps;
        }

        public List<AssignedWarning> getAssignedWarnings() {
            return assignedWarnings;
        }

        public void setAssignedWarnings(List<AssignedWarning> assignedWarnings) {
            this.assignedWarnings = assignedWarnings;
        }

        public List<Log> getLogs() {
            return logs;
        }

        public void setLogs(List<Log> logs) {
            this.logs = logs;
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

        public List<AssignedChecklistComment> getAssignedChecklistComments() {
            return assignedChecklistComments;
        }

        public void setAssignedChecklistComments(List<AssignedChecklistComment> assignedChecklistComments) {
            this.assignedChecklistComments = assignedChecklistComments;
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

    public class Log {

        @SerializedName("uuid")
        @Expose
        private String uuid;
        @SerializedName("item_uuid")
        @Expose
        private String itemUuid;
        @SerializedName("checklist_id")
        @Expose
        private Integer checklistId;
        @SerializedName("checklist_element_id")
        @Expose
        private Integer checklistElementId;
        @SerializedName("action")
        @Expose
        private Integer action;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("assigned_to")
        @Expose
        private Integer assignedTo;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("assigned_to_name")
        @Expose
        private String assignedToName;
        @SerializedName("item_description")
        @Expose
        private String itemDescription;
        @SerializedName("step_action")
        @Expose
        private String stepAction;
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

        public String getItemUuid() {
            return itemUuid;
        }

        public void setItemUuid(String itemUuid) {
            this.itemUuid = itemUuid;
        }

        public Integer getChecklistId() {
            return checklistId;
        }

        public void setChecklistId(Integer checklistId) {
            this.checklistId = checklistId;
        }

        public Integer getChecklistElementId() {
            return checklistElementId;
        }

        public void setChecklistElementId(Integer checklistElementId) {
            this.checklistElementId = checklistElementId;
        }

        public Integer getAction() {
            return action;
        }

        public void setAction(Integer action) {
            this.action = action;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getAssignedTo() {
            return assignedTo;
        }

        public void setAssignedTo(Integer assignedTo) {
            this.assignedTo = assignedTo;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAssignedToName() {
            return assignedToName;
        }

        public void setAssignedToName(String assignedToName) {
            this.assignedToName = assignedToName;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String getStepAction() {
            return stepAction;
        }

        public void setStepAction(String stepAction) {
            this.stepAction = stepAction;
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