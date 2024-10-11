package c.anurag.network.beans.checklist.types;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistTypesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistTypes> data = null;

    public List<ChecklistTypes> getData() {
        return data;
    }

    public void setData(List<ChecklistTypes> data) {
        this.data = data;
    }
}
