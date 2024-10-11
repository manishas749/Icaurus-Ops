package com.icarus.models;

import androidx.room.ColumnInfo;
import android.text.TextUtils;

import java.util.ArrayList;


public class ResourceDownloadItems {
    @ColumnInfo(name = "id")
    public Integer id;
    @ColumnInfo(name = "is_deleted")
    public Integer isDeleted;
    @ColumnInfo(name = "uuid")
    public String uuid;
    @ColumnInfo(name = "file_md5_checksum")
    public String fileMd5Checksum;
    @ColumnInfo(name = "file_name")
    public String fileName;
    @ColumnInfo(name = "checklist_ids")
    public String checklistIds;
    @ColumnInfo(name = "is_resource")
    public Integer isResource;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public Integer getIsResource() {
        return isResource;
    }

    public void setIsResource(Integer isResource) {
        this.isResource = isResource;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getChecklistIds() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] list = checklistIds.split(",");

        for (String value : list) {
            arrayList.add(Integer.parseInt(value));
        }
        return list;
    }

    public String getPath() {
        if (TextUtils.isEmpty(fileMd5Checksum))
            return "";
        if (TextUtils.isEmpty(fileName))
            return "";
        return fileMd5Checksum + "." + fileName.split("\\.")[1];
    }

    public void setChecklistIds(String checklistIds) {
        this.checklistIds = checklistIds;
    }
}
