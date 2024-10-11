package c.anurag.network.beans.checklist.texts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistTexts extends DefaultChecklistResponse {
    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
