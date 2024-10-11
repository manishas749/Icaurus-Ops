package c.anurag.network.beans.client.logo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ClientLogoResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<ClientLogo> data = null;

    public List<ClientLogo> getData() {
        return data;
    }

    public void setData(List<ClientLogo> data) {
        this.data = data;
    }
}
