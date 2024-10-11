package c.anurag.network.beans.checklist.logos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistLogos extends DefaultChecklistResponse {
    @SerializedName("checklist_id")
    @Expose
    private int checklistId;
    @SerializedName("logo_type")
    @Expose
    private int logoType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("file_md5_checksum")
    @Expose
    private String fileMd5Checksum;

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public int getLogoType() {
        return logoType;
    }

    public void setLogoType(int logoType) {
        this.logoType = logoType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }
}
