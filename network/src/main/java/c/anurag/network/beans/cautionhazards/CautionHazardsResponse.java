package c.anurag.network.beans.cautionhazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class CautionHazardsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<CautionHazards> data = null;

    public List<CautionHazards> getData() {
        return data;
    }

    public void setData(List<CautionHazards> data) {
        this.data = data;
    }
}
