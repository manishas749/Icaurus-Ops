package com.icarus.models;

import com.icarus.base.BaseApplication;
import com.icarus.util.ImageLoader;

import androidx.databinding.BindingAdapter;
import androidx.appcompat.widget.AppCompatImageView;

import java.io.File;

/**
 * Created by Anurag Purwar on 8/2/19.
 */
public class AttachmentItems {
    File fileDestination;
    File fileSource;
    String mimeType;
    long fileSize;
    String fileMd5Checksum;

    public AttachmentItems(File fileDestination, File fileSource, String mimeType, long fileSize, String fileMd5Checksum) {
        this.fileDestination = fileDestination;
        this.fileSource = fileSource;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
        this.fileMd5Checksum = fileMd5Checksum;
    }

    public File getFileDestination() {
        return fileDestination;
    }

    public void setFileDestination(File fileDestination) {
        this.fileDestination = fileDestination;
    }

    public File getFileSource() {
        return fileSource;
    }

    public void setFileSource(File fileSource) {
        this.fileSource = fileSource;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }


    @BindingAdapter("app:bindImage")
    public static void setImageView(AppCompatImageView image, AttachmentItems items) {
        BaseApplication.getImageLoader().loadImage(items.fileDestination, image, ImageLoader.ImageType.Workorder, null);
    }

}
