package c.anurag.network.beans.user.suggestion.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class UserSuggestionAttachments extends DefaultChecklistResponse {
    @SerializedName("user_suggestion_uuid")
    @Expose
    private String userSuggestionUuid;
    @SerializedName("display_filename")
    @Expose
    private String displayFilename;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("file_size")
    @Expose
    private Integer filesize;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("md5_checksum")
    @Expose
    private String md5Checksum;
    @SerializedName("user_id")
    @Expose
    private Integer authorId;

    public String getUserSuggestionUuid() {
        return userSuggestionUuid;
    }

    public void setUserSuggestionUuid(String userSuggestionUuid) {
        this.userSuggestionUuid = userSuggestionUuid;
    }

    public String getDisplayFilename() {
        return displayFilename;
    }

    public void setDisplayFilename(String displayFilename) {
        this.displayFilename = displayFilename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
