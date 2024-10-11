package com.icarus.models;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;

import com.bumptech.glide.Glide;
import com.icarus.constants.Constants;
import com.icarus.enums.AttributeType;
import com.icarus.util.AppUtility;
import com.icarus.util.ContentType;
import com.icarus.util.FileUtils;

import java.io.File;

/**
 * Created by Monika Rana on 08/10/2019
 */
public class ElementAttributesItems implements Comparable<ElementAttributesItems> {
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "label")
    private String label;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "sort_order")
    private int sortOrder;

    @ColumnInfo(name = "captured_uuid")
    private String capturedUUID;

    @ColumnInfo(name = "captured_value")
    private String capturedValue;

    @ColumnInfo(name = "captured_file")
    private String capturedFile;

    @ColumnInfo(name = "content_type")
    private String contentType;

    @ColumnInfo(name = "file_md5_checksum")
    private String fileMD5Checksum;

    @ColumnInfo(name = "is_downloaded")
    private boolean isDownloaded;

    @ColumnInfo(name = "captured_by")
    private String capturedBy;

    @ColumnInfo(name = "captured_at")
    private String capturedAt;

    @ColumnInfo(name = "type")
    private String type; //file or qr

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        if (TextUtils.isEmpty(description))
            return description;
        else
            return "(" + description + ")";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapturedUUID() {
        return capturedUUID;
    }

    public void setCapturedUUID(String capturedUUID) {
        this.capturedUUID = capturedUUID;
    }

    public String getCapturedValue() {
        return capturedValue;
    }

    public void setCapturedValue(String capturedValue) {
        this.capturedValue = capturedValue;
    }

    public String getCapturedFile() {
        return capturedFile;
    }

    public void setCapturedFile(String capturedFile) {
        this.capturedFile = capturedFile;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileMD5Checksum() {
        return fileMD5Checksum;
    }

    public void setFileMD5Checksum(String fileMD5Checksum) {
        this.fileMD5Checksum = fileMD5Checksum;
    }

    public boolean isDownloaded() {
        File file = FileUtils.getFileFromName(getFileName(), Constants.RESOURCES);
        return file.exists();
    }

    public void setDownloaded(boolean downloaded) {
        isDownloaded = downloaded;
    }

    public String getCapturedBy() {
        return capturedBy;
    }

    public void setCapturedBy(String capturedBy) {
        this.capturedBy = capturedBy;
    }

    public String getCapturedAt() {
        return AppUtility.Companion.parseDateToddMMyyyy(capturedAt);
    }

    public void setCapturedAt(String capturedAt) {
        this.capturedAt = capturedAt;
    }

    public boolean isQA() {
        return type.equalsIgnoreCase(AttributeType.QA.toString());
    }

    public boolean isFile() {
        return type.equalsIgnoreCase(AttributeType.FILE.toString());
    }

    public boolean isQR() {
        return type.equalsIgnoreCase(AttributeType.QR.toString());
    }

    public String getFileContentType() {
        String ext = "";
        if (capturedFile.split("\\.").length > 0)
            ext = capturedFile.split("\\.")[1];
        if (ContentType.isImageType(ext))
            return ContentType.IMAGE_PNG;
        else if (ContentType.isVideoType(ext))
            return ContentType.VIDEO_MP4;
        else return ext;
    }

    public String getFileName() {
        if (capturedFile.split("\\.").length > 0)
            return fileMD5Checksum + "." + capturedFile.split("\\.")[1];
        else return "";
    }

    @BindingAdapter("setImage")
    public static void setImage(AppCompatImageView imageView, String fileName) {
        File file = FileUtils.getFileFromName(fileName, Constants.RESOURCES);
        if (file.exists()) {
            Uri imageUri = Uri.fromFile(file);
            Glide.with(imageView.getContext())
                    .load(imageUri)
                    .into(imageView);

        }
    }

    public String getQRLabelName() {
        String entityName = capturedValue;// 2 -> The name of the attribute

        if (type != null && type.equalsIgnoreCase(AttributeType.QR.toString())) {
            String[] strings = capturedValue.split("<#>");

                entityName = strings[0];
        }
        return entityName;
    }

    public String getQRReason() {
        String reasonForManualVerification = null; // 5 -> Reason (if any)

        if (type != null && type.equalsIgnoreCase(AttributeType.QR.toString())) {
            String[] strings = capturedValue.split("<#>");

            if (strings.length == 3) {
                reasonForManualVerification = strings[2];
            }
        }
        return reasonForManualVerification;
    }

    public int isQRReasonVisible() {
        if (!TextUtils.isEmpty(getQRReason()))
            return View.VISIBLE;
        else
            return View.GONE;
    }

    @Override
    public int compareTo(ElementAttributesItems elementAttributesItem) {
        return getSortOrder() - elementAttributesItem.getSortOrder();
    }
}
