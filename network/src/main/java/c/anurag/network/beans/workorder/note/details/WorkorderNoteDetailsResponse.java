package c.anurag.network.beans.workorder.note.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class WorkorderNoteDetailsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<WorkorderNoteDetails> data = null;

    public List<WorkorderNoteDetails> getData() {
        return data;
    }

    public void setData(List<WorkorderNoteDetails> data) {
        this.data = data;
    }
}
