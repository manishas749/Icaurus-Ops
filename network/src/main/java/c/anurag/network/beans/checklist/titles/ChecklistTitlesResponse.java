package c.anurag.network.beans.checklist.titles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistTitlesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistTitles> data = null;

    public List<ChecklistTitles> getData() {
        return data;
    }

    public void setData(List<ChecklistTitles> data) {
        this.data = data;
    }
}
