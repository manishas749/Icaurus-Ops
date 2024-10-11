package c.anurag.network.beans.step.result.functions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class StepResultFunctions extends DefaultChecklistResponse {
    @SerializedName("step_id")
    @Expose
    private int stepId;
    @SerializedName("capture_data")
    @Expose
    private boolean captureData;
    @SerializedName("pass_fail")
    @Expose
    private boolean passFail;
    @SerializedName("good_repair_marginal")
    @Expose
    private boolean goodRepairMarginal;
    @SerializedName("yes_no")
    @Expose
    private boolean yesNo;
    @SerializedName("capture_data_instruction")
    @Expose
    private String captureDataInstruction;

    @SerializedName("pass_fail_instruction")
    @Expose
    private String passFailInstruction;
    @SerializedName("grm_instruction")
    @Expose
    private String grmInstruction;
    @SerializedName("yes_no_instruction")
    @Expose
    private String yesNoInstruction;

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getCaptureData() {
        return Utility.convertBooleanToInt(captureData);
    }

    public void setCaptureData(boolean captureData) {
        this.captureData = captureData;
    }

    public int getPassFail() {
        return Utility.convertBooleanToInt(passFail);
    }

    public void setPassFail(boolean passFail) {
        this.passFail = passFail;
    }

    public int getGoodRepairMarginal() {
        return Utility.convertBooleanToInt(goodRepairMarginal);
    }

    public void setGoodRepairMarginal(boolean goodRepairMarginal) {
        this.goodRepairMarginal = goodRepairMarginal;
    }

    public int getYesNo() {
        return Utility.convertBooleanToInt(yesNo);
    }

    public void setYesNo(boolean yesNo) {
        this.yesNo = yesNo;
    }

    public String getCaptureDataInstruction() {
        return captureDataInstruction;
    }

    public void setCaptureDataInstruction(String captureDataInstruction) {
        this.captureDataInstruction = captureDataInstruction;
    }

    public String getPassFailInstruction() {
        return passFailInstruction;
    }

    public void setPassFailInstruction(String passFailInstruction) {
        this.passFailInstruction = passFailInstruction;
    }

    public String getGrmInstruction() {
        return grmInstruction;
    }

    public void setGrmInstruction(String grmInstruction) {
        this.grmInstruction = grmInstruction;
    }

    public String getYesNoInstruction() {
        return yesNoInstruction;
    }

    public void setYesNoInstruction(String yesNoInstruction) {
        this.yesNoInstruction = yesNoInstruction;
    }
}
