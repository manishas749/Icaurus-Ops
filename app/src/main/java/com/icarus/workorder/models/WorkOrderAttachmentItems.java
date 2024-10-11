package com.icarus.workorder.models;

import androidx.lifecycle.ViewModel;
import androidx.room.ColumnInfo;
import androidx.core.content.FileProvider;
import android.text.TextUtils;

/**
 * Created by Anurag Purwar on 31/1/19.
 */
public class WorkOrderAttachmentItems {
    @ColumnInfo(name = "display_filename")
    private String displayFileName;
    @ColumnInfo(name = "uuid")
    private String uuid;
    @ColumnInfo(name = "filename")
    private String fileName;
    @ColumnInfo(name = "content_type")
    private String contentType;
    @ColumnInfo(name = "file_md5_checksum")
    private String fileMd5Checksum;
    @ColumnInfo(name = "is_downloaded")
    public Integer isDownloaded;

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public String getDisplayFileName() {
        return displayFileName;
    }

    public void setDisplayFileName(String displayFileName) {
        this.displayFileName = displayFileName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean getIsDownloaded() {
        return isDownloaded == 1;
    }

    public void setIsDownloaded(Integer isDownloaded) {
        this.isDownloaded = isDownloaded;
    }

    public String getPath() {
        if (TextUtils.isEmpty(fileMd5Checksum))
            return "";
        if (TextUtils.isEmpty(fileName))
            return "";
        return fileMd5Checksum + "." + fileName.split("\\.")[1];
    }

}
