package com.icarus.models;

import android.text.TextUtils;

import com.icarus.util.AppUtility;

/**
 * Created by Monika Rana on 11/09/2019
 */
public class ChecklistNotesItem {
    private String comment;

    private String updatedAt;

    private String userFullName;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUpdatedAt() {
        return TextUtils.isEmpty(updatedAt) ? "" : AppUtility.Companion.parseDateToddMMyyyy(updatedAt);
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
