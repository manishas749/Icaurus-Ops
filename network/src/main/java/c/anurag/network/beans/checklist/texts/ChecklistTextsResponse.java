package c.anurag.network.beans.checklist.texts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ChecklistTextsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ChecklistTexts> data = null;

    public List<ChecklistTexts> getData() {
        return data;
    }

    public void setData(List<ChecklistTexts> data) {
        this.data = data;
    }
}
