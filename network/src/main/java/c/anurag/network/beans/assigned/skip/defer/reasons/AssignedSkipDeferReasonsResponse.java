package c.anurag.network.beans.assigned.skip.defer.reasons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedSkipDeferReasonsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedSkipDeferReasons> data = null;

    public List<AssignedSkipDeferReasons> getData() {
        return data;
    }

    public void setData(List<AssignedSkipDeferReasons> data) {
        this.data = data;
    }
}
