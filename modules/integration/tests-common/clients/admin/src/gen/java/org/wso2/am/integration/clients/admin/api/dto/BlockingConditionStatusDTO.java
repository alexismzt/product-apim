/*
 * WSO2 API Manager - Admin
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Admin Portal. Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.5.176/components/apimgt/org.wso2.carbon.apimgt.rest.api.admin/src/main/resources/admin-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: v1.2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.admin.api.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Blocking Conditions Status
 */
@ApiModel(description = "Blocking Conditions Status")

public class BlockingConditionStatusDTO {
  @SerializedName("conditionId")
  private String conditionId = null;

  @SerializedName("conditionStatus")
  private Boolean conditionStatus = null;

  public BlockingConditionStatusDTO conditionId(String conditionId) {
    this.conditionId = conditionId;
    return this;
  }

   /**
   * Id of the blocking condition
   * @return conditionId
  **/
  @ApiModelProperty(example = "b513eb68-69e8-4c32-92cf-852c101363cf", value = "Id of the blocking condition")
  public String getConditionId() {
    return conditionId;
  }

  public void setConditionId(String conditionId) {
    this.conditionId = conditionId;
  }

  public BlockingConditionStatusDTO conditionStatus(Boolean conditionStatus) {
    this.conditionStatus = conditionStatus;
    return this;
  }

   /**
   * Status of the blocking condition
   * @return conditionStatus
  **/
  @ApiModelProperty(example = "true", required = true, value = "Status of the blocking condition")
  public Boolean isConditionStatus() {
    return conditionStatus;
  }

  public void setConditionStatus(Boolean conditionStatus) {
    this.conditionStatus = conditionStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockingConditionStatusDTO blockingConditionStatus = (BlockingConditionStatusDTO) o;
    return Objects.equals(this.conditionId, blockingConditionStatus.conditionId) &&
        Objects.equals(this.conditionStatus, blockingConditionStatus.conditionStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conditionId, conditionStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockingConditionStatusDTO {\n");
    
    sb.append("    conditionId: ").append(toIndentedString(conditionId)).append("\n");
    sb.append("    conditionStatus: ").append(toIndentedString(conditionStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
