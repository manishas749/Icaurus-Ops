package c.anurag.network.beans.checklist.logos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistLogosResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistLogos> data = null;

    public List<ChecklistLogos> getData() {
        return data;
    }

    public void setData(List<ChecklistLogos> data) {
        this.data = data;
    }
}
