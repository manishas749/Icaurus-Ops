package c.anurag.network.beans.step;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class Steps extends DefaultChecklistResponse {
    @SerializedName("decision_id")
    @Expose
    private int decisionId;
    @SerializedName("step")
    @Expose
    private String step;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("is_indented")
    @Expose
    private boolean isIndented;

    public int getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(int decisionId) {
        this.decisionId = decisionId;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getIsIndented() {
        return Utility.convertBooleanToInt(isIndented);
    }

    public void setIsIndented(boolean isIndented) {
        this.isIndented = isIndented;
    }
}
