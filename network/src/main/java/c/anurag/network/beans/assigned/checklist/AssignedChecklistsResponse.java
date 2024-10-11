package c.anurag.network.beans.assigned.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedChecklistsResponse extends DefaultResponse {
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
