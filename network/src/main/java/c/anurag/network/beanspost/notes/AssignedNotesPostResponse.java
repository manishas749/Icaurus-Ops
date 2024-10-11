package c.anurag.network.beanspost.notes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anuragpurwar
 */

public class AssignedNotesPostResponse {
    @SerializedName("data")
    @Expose
    private List<AssignedNotes> data = null;

    public List<AssignedNotes> getData() {
        return data;
    }

    public void setData(List<AssignedNotes> data) {
        this.data = data;
    }
}
