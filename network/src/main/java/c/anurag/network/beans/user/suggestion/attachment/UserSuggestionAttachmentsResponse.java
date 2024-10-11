package c.anurag.network.beans.user.suggestion.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class UserSuggestionAttachmentsResponse extends DefaultResponse {
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
