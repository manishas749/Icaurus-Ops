package c.anurag.network.beanspost.suggestion.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class UserSuggestionAttachmentsPostResponse {
    @SerializedName("data")
    @Expose
    private List<UserSuggestionAttachments> data = null;

    public List<UserSuggestionAttachments> getData() {
        return data;
    }

    public void setData(List<UserSuggestionAttachments> data) {
        this.data = data;
    }
}
