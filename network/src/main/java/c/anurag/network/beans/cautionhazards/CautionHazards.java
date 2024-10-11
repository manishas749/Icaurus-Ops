package c.anurag.network.beans.cautionhazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class CautionHazards extends DefaultChecklistResponse {
    @SerializedName("caution_id")
    @Expose
    private int cautionId;
    @SerializedName("hazard_id")
    @Expose
    private int hazardId;

    public int getCautionId() {
        return cautionId;
    }

    public void setCautionId(int cautionId) {
        this.cautionId = cautionId;
    }

    public int getHazardId() {
        return hazardId;
    }

    public void setHazardId(int hazardId) {
        this.hazardId = hazardId;
    }
}
