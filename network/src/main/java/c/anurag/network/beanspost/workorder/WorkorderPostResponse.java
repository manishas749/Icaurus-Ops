package c.anurag.network.beanspost.workorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.workorder.Workorders;
import c.anurag.network.beans.workorder.attachment.WorkorderAttachments;
import c.anurag.network.beans.workorder.note.WorkorderNotes;
import c.anurag.network.beans.workorder.note.details.WorkorderNoteDetails;

public class WorkorderPostResponse {
    @SerializedName("data")
    @Expose
    private List<Workorder> data = null;

    public List<Workorder> getData() {
        return data;
    }

    public void setData(List<Workorder> data) {
        this.data = data;
    }

    public class Workorder extends Workorders {
        @SerializedName("old_id")
        @Expose
        private int oldId;
        @SerializedName("WorkorderAttachment")
        @Expose
        private List<WorkorderAttachment> workorderAttachment = null;
        @SerializedName("WorkorderNote")
        @Expose
        private List<WorkorderNote> workorderNote = null;

        public int getOldId() {
            return oldId;
        }

        public void setOldId(int oldId) {
            this.oldId = oldId;
        }

        public List<WorkorderAttachment> getWorkorderAttachment() {
            return workorderAttachment;
        }

        public void setWorkorderAttachment(List<WorkorderAttachment> workorderAttachment) {
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
        @SerializedName("old_id")
        @Expose
        private int oldId;

        public int getOldId() {
            return oldId;
        }

        public void setOldId(int oldId) {
            this.oldId = oldId;
        }

        @SerializedName("WorkorderNoteDetail")
        @Expose
        private List<WorkorderNoteDetail> workorderNoteDetail = null;

        public List<WorkorderNoteDetail> getWorkorderNoteDetail() {
            return workorderNoteDetail;
        }

        public void setWorkorderNoteDetail(List<WorkorderNoteDetail> workorderNoteDetail) {
            this.workorderNoteDetail = workorderNoteDetail;
        }

    }

    public class WorkorderAttachment extends WorkorderAttachments {
        @SerializedName("old_id")
        @Expose
        private int oldId;

        public int getOldId() {
            return oldId;
        }

        public void setOldId(int oldId) {
            this.oldId = oldId;
        }
    }

    public class WorkorderNoteDetail extends WorkorderNoteDetails {
        @SerializedName("old_id")
        @Expose
        private int oldId;

        public int getOldId() {
            return oldId;
        }

        public void setOldId(int oldId) {
            this.oldId = oldId;
        }
    }
}
