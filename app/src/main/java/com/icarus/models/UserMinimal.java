package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

public class UserMinimal {
    private Integer id;

    @ColumnInfo(name = "group_id")
    private Integer groupId;

    @ColumnInfo(name = "is_administrator")
    private boolean isAdministrator;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @Ignore
    private String verificationResult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public String getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(String verificationResult) {
        this.verificationResult = verificationResult;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
