package com.icarus.models;

import java.io.File;

/**
 * Created by Monika Rana on 2/20/2019.
 */

public class SelectedFile {
    private String fileMd5Checksum;
    private String fileName;
    private String displayName;
    private String contentType;
    private boolean isDeletable, isExecuted;
    private String fileUUID;

    public SelectedFile(String fileName, String fileMd5Checksum, String displayName, String contentType, String fileUUID, boolean isDeletable, boolean isExecuted) {
        this.fileMd5Checksum = fileMd5Checksum;
        this.fileName = fileName;
        this.displayName = displayName;
        this.contentType = contentType;
        this.fileUUID = fileUUID;
        this.isDeletable = isDeletable;
        this.isExecuted = isExecuted;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDeletable() {
        return isDeletable;
    }

    public void setDeletable(boolean deletable) {
        isDeletable = deletable;
    }

    public String getFileUUID() {
        return fileUUID;
    }

    public void setFileUUID(String fileUUID) {
        this.fileUUID = fileUUID;
    }

    public String getFilePath() {
        return fileMd5Checksum + "." + fileName.split("\\.")[1];
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }
}
