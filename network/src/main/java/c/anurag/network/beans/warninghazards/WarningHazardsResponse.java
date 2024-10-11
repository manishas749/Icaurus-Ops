package c.anurag.network.beans.warninghazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class WarningHazardsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<WarningHazards> data = null;

    public List<WarningHazards> getData() {
        return data;
    }

    public void setData(List<WarningHazards> data) {
        this.data = data;
    }
}
