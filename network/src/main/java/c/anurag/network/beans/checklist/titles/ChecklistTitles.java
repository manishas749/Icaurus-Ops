package c.anurag.network.beans.checklist.titles;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistTitles extends DefaultChecklistResponse {
    @SerializedName("checklist_id")
    @Expose
    private int checklistId;
    @SerializedName("title")
    @Expose
    private String title;

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
