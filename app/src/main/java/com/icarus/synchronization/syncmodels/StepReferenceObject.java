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
 * StepReferenceObject
 */

public class StepReferenceObject {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_UUID = "uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public static final String SERIALIZED_NAME_ITEM_TYPE_ID = "item_type_id";
  @SerializedName(SERIALIZED_NAME_ITEM_TYPE_ID)
  private Integer itemTypeId;

  public static final String SERIALIZED_NAME_ITEM_ID = "item_id";
  @SerializedName(SERIALIZED_NAME_ITEM_ID)
  private Integer itemId;

  public static final String SERIALIZED_NAME_DISPLAY_FILENAME = "display_filename";
  @SerializedName(SERIALIZED_NAME_DISPLAY_FILENAME)
  private String displayFilename;

  public static final String SERIALIZED_NAME_FILE_SIZE = "file_size";
  @SerializedName(SERIALIZED_NAME_FILE_SIZE)
  private Integer fileSize;

  public static final String SERIALIZED_NAME_MD5_CHECKSUM = "md5_checksum";
  @SerializedName(SERIALIZED_NAME_MD5_CHECKSUM)
  private String md5Checksum;

  public static final String SERIALIZED_NAME_CONTENT_TYPE = "content_type";
  @SerializedName(SERIALIZED_NAME_CONTENT_TYPE)
  private String contentType;

  public static final String SERIALIZED_NAME_IS_RESOURCE = "is_resource";
  @SerializedName(SERIALIZED_NAME_IS_RESOURCE)
  private Boolean isResource;

  public static final String SERIALIZED_NAME_IS_DELETED = "is_deleted";
  @SerializedName(SERIALIZED_NAME_IS_DELETED)
  private Boolean isDeleted;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Object links = null;

  public StepReferenceObject id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "7", required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public StepReferenceObject uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(example = "5d899e22-7d5a-4456-a3bb-eea2e95e61ef", required = true, value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public StepReferenceObject itemTypeId(Integer itemTypeId) {
    this.itemTypeId = itemTypeId;
    return this;
  }

   /**
   * Get itemTypeId
   * @return itemTypeId
  **/
  @ApiModelProperty(example = "7", required = true, value = "")
  public Integer getItemTypeId() {
    return itemTypeId;
  }

  public void setItemTypeId(Integer itemTypeId) {
    this.itemTypeId = itemTypeId;
  }

  public StepReferenceObject itemId(Integer itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * Get itemId
   * @return itemId
  **/
  @ApiModelProperty(example = "7", required = true, value = "")
  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public StepReferenceObject displayFilename(String displayFilename) {
    this.displayFilename = displayFilename;
    return this;
  }

   /**
   * Get displayFilename
   * @return displayFilename
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDisplayFilename() {
    return displayFilename;
  }

  public void setDisplayFilename(String displayFilename) {
    this.displayFilename = displayFilename;
  }

  public StepReferenceObject fileSize(Integer fileSize) {
    this.fileSize = fileSize;
    return this;
  }

   /**
   * Get fileSize
   * @return fileSize
  **/
  @ApiModelProperty(example = "1234444", required = true, value = "")
  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public StepReferenceObject md5Checksum(String md5Checksum) {
    this.md5Checksum = md5Checksum;
    return this;
  }

   /**
   * Get md5Checksum
   * @return md5Checksum
  **/
  @ApiModelProperty(required = true, value = "")
  public String getMd5Checksum() {
    return md5Checksum;
  }

  public void setMd5Checksum(String md5Checksum) {
    this.md5Checksum = md5Checksum;
  }

  public StepReferenceObject contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * Get contentType
   * @return contentType
  **/
  @ApiModelProperty(required = true, value = "")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public StepReferenceObject isResource(Boolean isResource) {
    this.isResource = isResource;
    return this;
  }

   /**
   * Get isResource
   * @return isResource
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean getIsResource() {
    return isResource;
  }

  public void setIsResource(Boolean isResource) {
    this.isResource = isResource;
  }

  public StepReferenceObject isDeleted(Boolean isDeleted) {
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

  public StepReferenceObject createdAt(String  createdAt) {
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

  public StepReferenceObject updatedAt(String  updatedAt) {
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

  public StepReferenceObject links(Object links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getLinks() {
    return links;
  }

  public void setLinks(Object links) {
    this.links = links;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StepReferenceObject stepReferenceObject = (StepReferenceObject) o;
    return Objects.equals(this.id, stepReferenceObject.id) &&
        Objects.equals(this.uuid, stepReferenceObject.uuid) &&
        Objects.equals(this.itemTypeId, stepReferenceObject.itemTypeId) &&
        Objects.equals(this.itemId, stepReferenceObject.itemId) &&
        Objects.equals(this.displayFilename, stepReferenceObject.displayFilename) &&
        Objects.equals(this.fileSize, stepReferenceObject.fileSize) &&
        Objects.equals(this.md5Checksum, stepReferenceObject.md5Checksum) &&
        Objects.equals(this.contentType, stepReferenceObject.contentType) &&
        Objects.equals(this.isResource, stepReferenceObject.isResource) &&
        Objects.equals(this.isDeleted, stepReferenceObject.isDeleted) &&
        Objects.equals(this.createdAt, stepReferenceObject.createdAt) &&
        Objects.equals(this.updatedAt, stepReferenceObject.updatedAt) &&
        Objects.equals(this.links, stepReferenceObject.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, uuid, itemTypeId, itemId, displayFilename, fileSize, md5Checksum, contentType, isResource, isDeleted, createdAt, updatedAt, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StepReferenceObject {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    itemTypeId: ").append(toIndentedString(itemTypeId)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    displayFilename: ").append(toIndentedString(displayFilename)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("    md5Checksum: ").append(toIndentedString(md5Checksum)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    isResource: ").append(toIndentedString(isResource)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

