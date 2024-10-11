package c.anurag.network.beanspost.favorites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar on 24/3/18.
 */

public class UserFavoritesPostResponse {
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
