package c.anurag.network.beans.associated.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssociatedChecklistsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<AssociatedChecklists> data = null;

    public List<AssociatedChecklists> getData() {
        return data;
    }

    public void setData(List<AssociatedChecklists> data) {
        this.data = data;
    }
}
