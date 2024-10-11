package c.anurag.network.beanspost.workorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.workorder.Workorders;
import c.anurag.network.beans.workorder.attachment.WorkorderAttachments;
import c.anurag.network.beans.workorder.note.WorkorderNotes;
import c.anurag.network.beans.workorder.note.details.WorkorderNoteDetails;

public class WorkorderPost {
    @SerializedName("data")
    @Expose
    private List<Workorder> data = null;

    public List<Workorder> getData() {
        return data;
    }

    public void setData(List<Workorder> data) {
        this.data = data;
    }

    private class Workorder extends Workorders {

        @SerializedName("WorkorderAttachment")
        @Expose
        private List<WorkorderAttachments> workorderAttachment = null;
        @SerializedName("WorkorderNote")
        @Expose
        private List<WorkorderNote> workorderNote = null;

        public List<WorkorderAttachments> getWorkorderAttachment() {
            return workorderAttachment;
        }

        public void setWorkorderAttachment(List<WorkorderAttachments> workorderAttachment) {
            this.workorderAttachment = workorderAttachment;
        }

        public List<WorkorderNote> getWorkorderNote() {
            return workorderNote;
        }

        public void setWorkorderNote(List<WorkorderNote> workorderNote) {
            this.workorderNote = workorderNote;
        }

    }

    public class WorkorderNote extends WorkorderNotes {

        @SerializedName("WorkorderNoteDetail")
        @Expose
        private List<WorkorderNoteDetails> workorderNoteDetail = null;

        public List<WorkorderNoteDetails> getWorkorderNoteDetail() {
            return workorderNoteDetail;
        }

        public void setWorkorderNoteDetail(List<WorkorderNoteDetails> workorderNoteDetail) {
            this.workorderNoteDetail = workorderNoteDetail;
        }

    }
}
