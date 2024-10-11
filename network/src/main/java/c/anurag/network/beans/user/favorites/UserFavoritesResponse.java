package c.anurag.network.beans.user.favorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 24/3/18.
 */

public class UserFavoritesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<UserFavorites> data = null;

    public List<UserFavorites> getData() {
        return data;
    }

    public void setData(List<UserFavorites> data) {
        this.data = data;
    }
}
