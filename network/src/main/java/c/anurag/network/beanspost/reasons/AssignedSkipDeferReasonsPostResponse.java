package c.anurag.network.beanspost.reasons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedSkipDeferReasonsPostResponse {
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
