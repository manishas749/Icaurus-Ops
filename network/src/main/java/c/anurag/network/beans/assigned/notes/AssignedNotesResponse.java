package c.anurag.network.beans.assigned.notes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedNotesResponse extends DefaultResponse {
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
