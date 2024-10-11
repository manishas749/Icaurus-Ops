package com.icarus.models;

import androidx.room.ColumnInfo;

public class ChecklistItemPlaceHolders {

    private Integer checklistId;

    @ColumnInfo(name = "sequence_no")
    private String sequenceNo;

    private String name;

    private String value;

    @ColumnInfo(name = "captured_at")
    private String capturedAt;

    @ColumnInfo(name = "captured_by")
    private String capturedBy;

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCapturedAt() {
        return capturedAt;
    }

    public void setCapturedAt(String capturedAt) {
        this.capturedAt = capturedAt;
    }

    public String getCapturedBy() {
        return capturedBy;
    }

    public void setCapturedBy(String capturedBy) {
        this.capturedBy = capturedBy;
    }
}
