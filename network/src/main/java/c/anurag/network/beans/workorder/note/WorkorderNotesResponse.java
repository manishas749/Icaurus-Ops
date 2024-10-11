package c.anurag.network.beans.workorder.note;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class WorkorderNotesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<WorkorderNotes> data = null;

    public List<WorkorderNotes> getData() {
        return data;
    }

    public void setData(List<WorkorderNotes> data) {
        this.data = data;
    }
}
