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


package com.icarus.synchronization.syncmodels;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * UserFavorite
 */

public class UserFavorite {
  public static final String SERIALIZED_NAME_UUID = "uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public static final String SERIALIZED_NAME_USER_ID = "user_id";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private Integer userId;

  public static final String SERIALIZED_NAME_CHECKLIST_ID = "checklist_id";
  @SerializedName(SERIALIZED_NAME_CHECKLIST_ID)
  private Integer checklistId;

  public static final String SERIALIZED_NAME_IS_DELETED = "is_deleted";
  @SerializedName(SERIALIZED_NAME_IS_DELETED)
  private Boolean isDeleted;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public UserFavorite uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "2284b7f6-81c4-11e4-89d3-00ffd0b164b9", required = true, value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public UserFavorite userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public UserFavorite checklistId(Integer checklistId) {
    this.checklistId = checklistId;
    return this;
  }

   /**
   * Get checklistId
   * @return checklistId
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getChecklistId() {
    return checklistId;
  }

  public void setChecklistId(Integer checklistId) {
    this.checklistId = checklistId;
  }

  public UserFavorite isDeleted(Boolean isDeleted) {
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

  public UserFavorite createdAt(String  createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String  createdAt) {
    this.createdAt = createdAt;
  }

  public UserFavorite updatedAt(String  updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(required = true, value = "")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String  updatedAt) {
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
    UserFavorite userFavorite = (UserFavorite) o;
    return Objects.equals(this.uuid, userFavorite.uuid) &&
        Objects.equals(this.userId, userFavorite.userId) &&
        Objects.equals(this.checklistId, userFavorite.checklistId) &&
        Objects.equals(this.isDeleted, userFavorite.isDeleted) &&
        Objects.equals(this.createdAt, userFavorite.createdAt) &&
        Objects.equals(this.updatedAt, userFavorite.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, userId, checklistId, isDeleted, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserFavorite {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    checklistId: ").append(toIndentedString(checklistId)).append("\n");
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

