package c.anurag.network.beanspost.warnings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedWarningsPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedWarnings> data = null;

    public List<AssignedWarnings> getData() {
        return data;
    }

    public void setData(List<AssignedWarnings> data) {
        this.data = data;
    }
}
