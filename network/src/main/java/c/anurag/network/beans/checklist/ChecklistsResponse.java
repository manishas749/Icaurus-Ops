package c.anurag.network.beans.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<Checklists> data = null;

    public List<Checklists> getData() {
        return data;
    }

    public void setData(List<Checklists> data) {
        this.data = data;
    }
}
