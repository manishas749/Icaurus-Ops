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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * AddUpdateAssignedDecisionResponse
 */

public class AddUpdateAssignedDecisionResponse {
  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  private List<AssignedDecisionObject> data = null;

  public AddUpdateAssignedDecisionResponse data(List<AssignedDecisionObject> data) {
    this.data = data;
    return this;
  }

  public AddUpdateAssignedDecisionResponse addDataItem(AssignedDecisionObject dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<AssignedDecisionObject>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  public List<AssignedDecisionObject> getData() {
    return data;
  }

  public void setData(List<AssignedDecisionObject> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddUpdateAssignedDecisionResponse addUpdateAssignedDecisionResponse = (AddUpdateAssignedDecisionResponse) o;
    return Objects.equals(this.data, addUpdateAssignedDecisionResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddUpdateAssignedDecisionResponse {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

