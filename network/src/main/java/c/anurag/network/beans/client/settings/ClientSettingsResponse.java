package c.anurag.network.beans.client.settings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ClientSettingsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ClientSettings> data = null;

    public List<ClientSettings> getData() {
        return data;
    }

    public void setData(List<ClientSettings> data) {
        this.data = data;
    }
}
