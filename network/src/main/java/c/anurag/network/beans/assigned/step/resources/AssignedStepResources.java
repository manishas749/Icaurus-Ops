package c.anurag.network.beans.assigned.step.resources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class AssignedStepResources extends DefaultChecklistResponse {
    @SerializedName("assigned_checklist_uuid")
    @Expose
    private String assignedChecklistUuid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("md5_checksum")
    @Expose
    private String fileMd5Checksum;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("display_filename")
    @Expose
    private String displayFileName;
    @SerializedName("content_type")
    @Expose
    private String fileType;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type_id")
    @Expose
    private Integer itemTypeId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("checklist_element_id")
    @Expose
    private Integer checklistElementId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDisplayFileName() {
        return displayFileName;
    }

    public void setDisplayFileName(String displayFileName) {
        this.displayFileName = displayFileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }
}
