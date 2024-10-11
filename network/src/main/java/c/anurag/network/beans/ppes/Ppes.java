package c.anurag.network.beans.ppes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class Ppes extends DefaultChecklistResponse {
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("file_md5_checksum")
    @Expose
    private String fileMd5Checksum;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public int getStatus() {
        return Utility.convertBooleanToInt(status);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
