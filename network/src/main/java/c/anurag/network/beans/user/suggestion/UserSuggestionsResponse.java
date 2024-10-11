package c.anurag.network.beans.user.suggestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class UserSuggestionsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<UserSuggestions> data = null;

    public List<UserSuggestions> getData() {
        return data;
    }

    public void setData(List<UserSuggestions> data) {
        this.data = data;
    }
}
