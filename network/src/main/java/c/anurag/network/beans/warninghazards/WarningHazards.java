package c.anurag.network.beans.warninghazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class WarningHazards extends DefaultChecklistResponse {
    @SerializedName("warning_id")
    @Expose
    private int warningId;
    @SerializedName("hazard_id")
    @Expose
    private int hazardId;

    public int getWarningId() {
        return warningId;
    }

    public void setWarningId(int warningId) {
        this.warningId = warningId;
    }

    public int getHazardId() {
        return hazardId;
    }

    public void setHazardId(int hazardId) {
        this.hazardId = hazardId;
    }
}
