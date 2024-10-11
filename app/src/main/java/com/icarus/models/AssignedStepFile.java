package com.icarus.models;

import androidx.room.ColumnInfo;

public class AssignedStepFile {
    @ColumnInfo(name = "fileMd5Checksum")
    private String fileMd5Checksum;
    @ColumnInfo(name = "Name")
    private String fileName;
    @ColumnInfo(name = "DisplayFileName")
    private String displayName;
    @ColumnInfo(name = "contentType")
    private String contentType;
    @ColumnInfo(name = "UUID")
    private String fileUUID;
    @ColumnInfo(name = "ChecklistUuid")
    private String checklistUUID;

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


    public String getFileUUID() {
        return fileUUID;
    }

    public void setFileUUID(String fileUUID) {
        this.fileUUID = fileUUID;
    }

    public String getFilePath() {
        return fileMd5Checksum + "." + fileName.split("\\.")[1];
    }

    public String getChecklistUUID() {
        return checklistUUID;
    }

    public void setChecklistUUID(String checklistUUID) {
        this.checklistUUID = checklistUUID;
    }
}
