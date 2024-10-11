package c.anurag.network.beanspost.favorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beanspost.DefaultChecklistPostResponse;

/**
 * Created by anuragpurwar on 24/3/18.
 */

public class UserFavorites extends DefaultChecklistPostResponse {
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("checklist_id")
    @Expose
    private Integer checklistId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }
}