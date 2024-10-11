package com.icarus.synchronization.postsyncmodel;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Anurag Purwar on 17/5/19.
 */
public class AssignedObjects {

    public static final String SERIALIZED_NAME_OPERATION = "operation";
    @SerializedName(SERIALIZED_NAME_OPERATION)
    private String operation;

    public AssignedObjects operation(String assignedChecklistUuid) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     * @return operation
     **/
    @ApiModelProperty(example = "", required = true, value = "")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
