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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * RetrieveAllWorkorderBillingTypes
 */

public class RetrieveAllWorkorderBillingTypes {
  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  private List<WorkorderBillingTypeObject> data = new ArrayList<WorkorderBillingTypeObject>();

  public static final String SERIALIZED_NAME_PAGINATION = "pagination";
  @SerializedName(SERIALIZED_NAME_PAGINATION)
  private Object pagination = null;

  public RetrieveAllWorkorderBillingTypes data(List<WorkorderBillingTypeObject> data) {
    this.data = data;
    return this;
  }

  public RetrieveAllWorkorderBillingTypes addDataItem(WorkorderBillingTypeObject dataItem) {
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(required = true, value = "")
  public List<WorkorderBillingTypeObject> getData() {
    return data;
  }

  public void setData(List<WorkorderBillingTypeObject> data) {
    this.data = data;
  }

  public RetrieveAllWorkorderBillingTypes pagination(Object pagination) {
    this.pagination = pagination;
    return this;
  }

   /**
   * Get pagination
   * @return pagination
  **/
  @ApiModelProperty(required = true, value = "")
  public Object getPagination() {
    return pagination;
  }

  public void setPagination(Object pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrieveAllWorkorderBillingTypes retrieveAllWorkorderBillingTypes = (RetrieveAllWorkorderBillingTypes) o;
    return Objects.equals(this.data, retrieveAllWorkorderBillingTypes.data) &&
        Objects.equals(this.pagination, retrieveAllWorkorderBillingTypes.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, pagination);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveAllWorkorderBillingTypes {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

