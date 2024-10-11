package c.anurag.network.beans.checklist.elements;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistElementsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistElements> data = null;

    public List<ChecklistElements> getData() {
        return data;
    }

    public void setData(List<ChecklistElements> data) {
        this.data = data;
    }
}
