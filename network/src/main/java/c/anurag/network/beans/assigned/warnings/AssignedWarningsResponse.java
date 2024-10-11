package c.anurag.network.beans.assigned.warnings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedWarningsResponse extends DefaultResponse {
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
