package c.anurag.network.beans.resource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

import static c.anurag.network.database.Utility.convertBooleanToInt;

/**
 * Created by anuragpurwar
 */

public class Resources extends DefaultChecklistResponse {
    @SerializedName("md5_checksum")
    @Expose
    private String fileMd5Checksum;
    @SerializedName("is_resource")
    @Expose
    private boolean isResource;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("display_filename")
    @Expose
    private String displayFileName;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type_id")
    @Expose
    private Integer itemTypeId;
    @SerializedName("filesize")
    @Expose
    private Integer fileSize;
    @SerializedName("content_type")
    @Expose
    private String fileType;

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public int getIsResource() {
        return convertBooleanToInt(isResource);
    }

    public void setIsResource(boolean isResource) {
        this.isResource = isResource;
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

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
