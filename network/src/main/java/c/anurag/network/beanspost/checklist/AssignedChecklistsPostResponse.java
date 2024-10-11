package c.anurag.network.beanspost.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedChecklistsPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedChecklists> data = null;

    public List<AssignedChecklists> getData() {
        return data;
    }

    public void setData(List<AssignedChecklists> data) {
        this.data = data;
    }
}
