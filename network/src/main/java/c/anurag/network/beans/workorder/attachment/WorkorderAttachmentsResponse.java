package c.anurag.network.beans.workorder.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class WorkorderAttachmentsResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<WorkorderAttachments> data = null;

    public List<WorkorderAttachments> getData() {
        return data;
    }

    public void setData(List<WorkorderAttachments> data) {
        this.data = data;
    }
}
