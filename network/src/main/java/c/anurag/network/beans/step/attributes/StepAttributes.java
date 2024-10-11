package c.anurag.network.beans.step.attributes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepAttributes extends DefaultChecklistResponse {
    @SerializedName("step_id")
    @Expose
    private int stepId;
    @SerializedName("is_qa_required")
    @Expose
    private boolean isQaRequired;
    @SerializedName("result_functions")
    @Expose
    private boolean resultFunctions;
    @SerializedName("is_file_required")
    @Expose
    private boolean isFileRequired;
    @SerializedName("resources")
    @Expose
    private boolean resources;

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getIsQaRequired() {
        return Utility.convertBooleanToInt(isQaRequired);
    }

    public void setQaRequired(boolean qaRequired) {
        isQaRequired = qaRequired;
    }

    public int getIsResultFunctions() {
        return Utility.convertBooleanToInt(resultFunctions);
    }

    public void setResultFunctions(boolean resultFunctions) {
        this.resultFunctions = resultFunctions;
    }

    public int getIsFileRequired() {
        return Utility.convertBooleanToInt(isFileRequired);
    }

    public void setFileRequired(boolean fileRequired) {
        isFileRequired = fileRequired;
    }

    public int getIsResources() {
        return Utility.convertBooleanToInt(resources);
    }

    public void setResources(boolean resources) {
        this.resources = resources;
    }
}
