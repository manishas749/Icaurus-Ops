/*
 * ICARUS API
 * The API allows an organization to have access to most of their ICARUS data!
 *
 * OpenAPI spec version: 2.0
 * Contact: support@icarusops.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.icarus.synchronization.postsyncmodel;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * AddAndUpdateAssignedCautionObject
 */

public class AddAndUpdateAssignedCautionObject extends AssignedObjects {
  public static final String SERIALIZED_NAME_UUID = "uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public static final String SERIALIZED_NAME_ASSIGNED_CHECKLIST_UUID = "assigned_checklist_uuid";
  @SerializedName(SERIALIZED_NAME_ASSIGNED_CHECKLIST_UUID)
  private String assignedChecklistUuid;

  public static final String SERIALIZED_NAME_USER_ID = "user_id";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private Integer userId;

  public static final String SERIALIZED_NAME_CAUTION_ID = "caution_id";
  @SerializedName(SERIALIZED_NAME_CAUTION_ID)
  private Integer cautionId;

  public static final String SERIALIZED_NAME_CHECKLIST_ELEMENT_ID = "checklist_element_id";
  @SerializedName(SERIALIZED_NAME_CHECKLIST_ELEMENT_ID)
  private Integer checklistElementId;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private AssignedNoteObject.StatusEnum  status;

  public static final String SERIALIZED_NAME_IS_DELETED = "is_deleted";
  @SerializedName(SERIALIZED_NAME_IS_DELETED)
  private Boolean isDeleted;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public AddAndUpdateAssignedCautionObject uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "29ad457f-ac08-4802-9357-a240607fa25e", required = true, value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public AddAndUpdateAssignedCautionObject assignedChecklistUuid(String assignedChecklistUuid) {
    this.assignedChecklistUuid = assignedChecklistUuid;
    return this;
  }

   /**
   * Get assignedChecklistUuid
   * @return assignedChecklistUuid
  **/
  @ApiModelProperty(example = "a37c8cb5-059b-4612-870f-35676d2f1c8a", required = true, value = "")
  public String getAssignedChecklistUuid() {
    return assignedChecklistUuid;
  }

  public void setAssignedChecklistUuid(String assignedChecklistUuid) {
    this.assignedChecklistUuid = assignedChecklistUuid;
  }

  public AddAndUpdateAssignedCautionObject userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(example = "1194", required = true, value = "")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public AddAndUpdateAssignedCautionObject cautionId(Integer cautionId) {
    this.cautionId = cautionId;
    return this;
  }

   /**
   * Get cautionId
   * @return cautionId
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getCautionId() {
    return cautionId;
  }

  public void setCautionId(Integer cautionId) {
    this.cautionId = cautionId;
  }

  public AddAndUpdateAssignedCautionObject checklistElementId(Integer checklistElementId) {
    this.checklistElementId = checklistElementId;
    return this;
  }

   /**
   * Get checklistElementId
   * @return checklistElementId
  **/
  @ApiModelProperty(example = "20", required = true, value = "")
  public Integer getChecklistElementId() {
    return checklistElementId;
  }

  public void setChecklistElementId(Integer checklistElementId) {
    this.checklistElementId = checklistElementId;
  }

  public AddAndUpdateAssignedCautionObject status(AssignedNoteObject.StatusEnum  status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "acknowledged", required = true, value = "")
  public AssignedNoteObject.StatusEnum  getStatus() {
    return status;
  }

  public void setStatus(AssignedNoteObject.StatusEnum status) {
    this.status = status;
  }

  public AddAndUpdateAssignedCautionObject isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

   /**
   * Get isDeleted
   * @return isDeleted
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public AddAndUpdateAssignedCautionObject createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(example = "2016-07-14 06:57:13", required = true, value = "")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public AddAndUpdateAssignedCautionObject updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(example = "2016-07-14 06:57:13", required = true, value = "")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddAndUpdateAssignedCautionObject addAndUpdateAssignedCautionObject = (AddAndUpdateAssignedCautionObject) o;
    return Objects.equals(this.uuid, addAndUpdateAssignedCautionObject.uuid) &&
        Objects.equals(this.assignedChecklistUuid, addAndUpdateAssignedCautionObject.assignedChecklistUuid) &&
        Objects.equals(this.userId, addAndUpdateAssignedCautionObject.userId) &&
        Objects.equals(this.cautionId, addAndUpdateAssignedCautionObject.cautionId) &&
        Objects.equals(this.checklistElementId, addAndUpdateAssignedCautionObject.checklistElementId) &&
        Objects.equals(this.status, addAndUpdateAssignedCautionObject.status) &&
        Objects.equals(this.isDeleted, addAndUpdateAssignedCautionObject.isDeleted) &&
        Objects.equals(this.createdAt, addAndUpdateAssignedCautionObject.createdAt) &&
        Objects.equals(this.updatedAt, addAndUpdateAssignedCautionObject.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, assignedChecklistUuid, userId, cautionId, checklistElementId, status, isDeleted, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAndUpdateAssignedCautionObject {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    assignedChecklistUuid: ").append(toIndentedString(assignedChecklistUuid)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    cautionId: ").append(toIndentedString(cautionId)).append("\n");
    sb.append("    checklistElementId: ").append(toIndentedString(checklistElementId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

