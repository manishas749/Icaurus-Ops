package c.anurag.network.beans.notehazards;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class NoteHazards extends DefaultChecklistResponse {
    @SerializedName("note_id")
    @Expose
    private int noteId;
    @SerializedName("hazard_id")
    @Expose
    private int hazardId;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getHazardId() {
        return hazardId;
    }

    public void setHazardId(int hazardId) {
        this.hazardId = hazardId;
    }
}
