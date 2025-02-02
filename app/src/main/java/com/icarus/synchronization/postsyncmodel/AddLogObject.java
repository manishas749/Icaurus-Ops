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
 * AddLogObject
 */

public class AddLogObject extends AssignedObjects {
  public static final String SERIALIZED_NAME_UUID = "uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public static final String SERIALIZED_NAME_ASSIGNED_CHECKLIST_UUID = "assigned_checklist_uuid";
  @SerializedName(SERIALIZED_NAME_ASSIGNED_CHECKLIST_UUID)
  private String assignedChecklistUuid;

  public static final String SERIALIZED_NAME_ITEM_UUID = "item_uuid";
  @SerializedName(SERIALIZED_NAME_ITEM_UUID)
  private String itemUuid;

  public static final String SERIALIZED_NAME_CHECKLIST_ID = "checklist_id";
  @SerializedName(SERIALIZED_NAME_CHECKLIST_ID)
  private Integer checklistId;

  public static final String SERIALIZED_NAME_CHECKLIST_ELEMENT_ID = "checklist_element_id";
  @SerializedName(SERIALIZED_NAME_CHECKLIST_ELEMENT_ID)
  private Integer checklistElementId;

  public static final String SERIALIZED_NAME_ACTION = "action";
  @SerializedName(SERIALIZED_NAME_ACTION)
  private Integer action;

  public static final String SERIALIZED_NAME_ASSIGNED_TO = "assigned_to";
  @SerializedName(SERIALIZED_NAME_ASSIGNED_TO)
  private Integer assignedTo;

  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_ASSIGNED_TO_NAME = "assigned_to_name";
  @SerializedName(SERIALIZED_NAME_ASSIGNED_TO_NAME)
  private String assignedToName;

  public static final String SERIALIZED_NAME_ITEM_DESCRIPTION = "item_description";
  @SerializedName(SERIALIZED_NAME_ITEM_DESCRIPTION)
  private String itemDescription;

  public static final String SERIALIZED_NAME_STEP_ACTION = "step_action";
  @SerializedName(SERIALIZED_NAME_STEP_ACTION)
  private String stepAction;

  public static final String SERIALIZED_NAME_USER_ID = "user_id";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private Integer userId;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public AddLogObject uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "fb343caa-3bc3-4e16-8b28-c4b92a0ed2de", required = true, value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public AddLogObject assignedChecklistUuid(String assignedChecklistUuid) {
    this.assignedChecklistUuid = assignedChecklistUuid;
    return this;
  }

   /**
   * Get assignedChecklistUuid
   * @return assignedChecklistUuid
  **/
  @ApiModelProperty(example = "fc343caa-3bc3-4e16-8b28-c4b92a0ed2de", required = true, value = "")
  public String getAssignedChecklistUuid() {
    return assignedChecklistUuid;
  }

  public void setAssignedChecklistUuid(String assignedChecklistUuid) {
    this.assignedChecklistUuid = assignedChecklistUuid;
  }

  public AddLogObject itemUuid(String itemUuid) {
    this.itemUuid = itemUuid;
    return this;
  }

   /**
   * Get itemUuid
   * @return itemUuid
  **/
  @ApiModelProperty(example = "{{$guid}}", required = true, value = "")
  public String getItemUuid() {
    return itemUuid;
  }

  public void setItemUuid(String itemUuid) {
    this.itemUuid = itemUuid;
  }

  public AddLogObject checklistId(Integer checklistId) {
    this.checklistId = checklistId;
    return this;
  }

   /**
   * Get checklistId
   * @return checklistId
  **/
  @ApiModelProperty(example = "2", required = true, value = "")
  public Integer getChecklistId() {
    return checklistId;
  }

  public void setChecklistId(Integer checklistId) {
    this.checklistId = checklistId;
  }

  public AddLogObject checklistElementId(Integer checklistElementId) {
    this.checklistElementId = checklistElementId;
    return this;
  }

   /**
   * Get checklistElementId
   * @return checklistElementId
  **/
  @ApiModelProperty(example = "2", required = true, value = "")
  public Integer getChecklistElementId() {
    return checklistElementId;
  }

  public void setChecklistElementId(Integer checklistElementId) {
    this.checklistElementId = checklistElementId;
  }

  public AddLogObject action(Integer action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * minimum: 0
   * maximum: 19
   * @return action
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  public Integer getAction() {
    return action;
  }

  public void setAction(Integer action) {
    this.action = action;
  }

  public AddLogObject assignedTo(Integer assignedTo) {
    this.assignedTo = assignedTo;
    return this;
  }

   /**
   * Get assignedTo
   * @return assignedTo
  **/
  @ApiModelProperty(example = "0", required = true, value = "")
  public Integer getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(Integer assignedTo) {
    this.assignedTo = assignedTo;
  }

  public AddLogObject username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(example = "UCS Developer", required = true, value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AddLogObject assignedToName(String assignedToName) {
    this.assignedToName = assignedToName;
    return this;
  }

   /**
   * Get assignedToName
   * @return assignedToName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAssignedToName() {
    return assignedToName;
  }

  public void setAssignedToName(String assignedToName) {
    this.assignedToName = assignedToName;
  }

  public AddLogObject itemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
    return this;
  }

   /**
   * Get itemDescription
   * @return itemDescription
  **/
  @ApiModelProperty(example = "test", required = true, value = "")
  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public AddLogObject stepAction(String stepAction) {
    this.stepAction = stepAction;
    return this;
  }

   /**
   * Get stepAction
   * @return stepAction
  **/
  @ApiModelProperty(required = true, value = "")
  public String getStepAction() {
    return stepAction;
  }

  public void setStepAction(String stepAction) {
    this.stepAction = stepAction;
  }

  public AddLogObject userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(example = "4", required = true, value = "")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public AddLogObject createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(example = "2016-04-19 07:22:32", required = true, value = "")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public AddLogObject updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(example = "2016-04-19 07:22:35", required = true, value = "")
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
    AddLogObject addLogObject = (AddLogObject) o;
    return Objects.equals(this.uuid, addLogObject.uuid) &&
        Objects.equals(this.assignedChecklistUuid, addLogObject.assignedChecklistUuid) &&
        Objects.equals(this.itemUuid, addLogObject.itemUuid) &&
        Objects.equals(this.checklistId, addLogObject.checklistId) &&
        Objects.equals(this.checklistElementId, addLogObject.checklistElementId) &&
        Objects.equals(this.action, addLogObject.action) &&
        Objects.equals(this.assignedTo, addLogObject.assignedTo) &&
        Objects.equals(this.username, addLogObject.username) &&
        Objects.equals(this.assignedToName, addLogObject.assignedToName) &&
        Objects.equals(this.itemDescription, addLogObject.itemDescription) &&
        Objects.equals(this.stepAction, addLogObject.stepAction) &&
        Objects.equals(this.userId, addLogObject.userId) &&
        Objects.equals(this.createdAt, addLogObject.createdAt) &&
        Objects.equals(this.updatedAt, addLogObject.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, assignedChecklistUuid, itemUuid, checklistId, checklistElementId, action, assignedTo, username, assignedToName, itemDescription, stepAction, userId, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddLogObject {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    assignedChecklistUuid: ").append(toIndentedString(assignedChecklistUuid)).append("\n");
    sb.append("    itemUuid: ").append(toIndentedString(itemUuid)).append("\n");
    sb.append("    checklistId: ").append(toIndentedString(checklistId)).append("\n");
    sb.append("    checklistElementId: ").append(toIndentedString(checklistElementId)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    assignedTo: ").append(toIndentedString(assignedTo)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    assignedToName: ").append(toIndentedString(assignedToName)).append("\n");
    sb.append("    itemDescription: ").append(toIndentedString(itemDescription)).append("\n");
    sb.append("    stepAction: ").append(toIndentedString(stepAction)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

