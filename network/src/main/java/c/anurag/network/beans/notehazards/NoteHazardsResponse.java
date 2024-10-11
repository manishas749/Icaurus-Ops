package c.anurag.network.beans.notehazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class NoteHazardsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<NoteHazards> data = null;

    public List<NoteHazards> getData() {
        return data;
    }

    public void setData(List<NoteHazards> data) {
        this.data = data;
    }
}
