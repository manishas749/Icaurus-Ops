package c.anurag.network.beans.checklist.ppes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistPpesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistPpes> data = null;

    public List<ChecklistPpes> getData() {
        return data;
    }

    public void setData(List<ChecklistPpes> data) {
        this.data = data;
    }
}
