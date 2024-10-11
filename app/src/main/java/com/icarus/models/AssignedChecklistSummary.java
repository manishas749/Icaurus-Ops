package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.databinding.BindingAdapter;
import androidx.appcompat.widget.AppCompatTextView;

import android.text.TextUtils;

import com.icarus.enums.LogTableActions;
import com.icarus.util.DateUtility;

import java.util.Date;

public class AssignedChecklistSummary {
    @ColumnInfo(name = "started_by")
    private String startedBy;

    @ColumnInfo(name = "started_at")
    private String startedAt;

    private Integer action;

    @ColumnInfo(name = "last_performed_by")
    private String lastPerformedBy;

    @ColumnInfo(name = "last_performed_at")
    private String lastPerformedAt;

    @ColumnInfo(name = "reason")
    private String actionReason;

    @ColumnInfo(name = "closed_by")
    private String closedBy;

    @ColumnInfo(name = "closed_at")
    private String closedAt;

    @ColumnInfo(name = "department")
    private String department;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "room")
    private String room;

    @ColumnInfo(name = "equipment")
    private String equipment;

    public String getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(String startedBy) {
        this.startedBy = startedBy;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getLastPerformedBy() {
        if (TextUtils.isEmpty(lastPerformedBy))
            return "N/A";
        else
            return lastPerformedBy;
    }

    public void setLastPerformedBy(String lastPerformedBy) {
        this.lastPerformedBy = lastPerformedBy;
    }

    public String getLastPerformedAt() {
        if (TextUtils.isEmpty(lastPerformedAt))
            return "N/A";
        else
            return lastPerformedAt;
    }

    public void setLastPerformedAt(String lastPerformedAt) {
        this.lastPerformedAt = lastPerformedAt;
    }

    public String getActionReason() {
        return actionReason;
    }

    public void setActionReason(String actionReason) {
        this.actionReason = actionReason;
    }

    public String getClosedBy() {
        if (TextUtils.isEmpty(closedBy))
            return "None";
        else
            return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public String getClosedAt() {
        if (TextUtils.isEmpty(closedAt))
            return "None";
        else
            return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRoom() {
        if (room == null || room.isEmpty()) {
            return "None";
        }

        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEquipment() {
        if (equipment == null || equipment.isEmpty()) {
            return "None";
        }

        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getTotalTime() {
        Date startedAt = DateUtility.getDateFromString(getStartedAt());
        Date lastPerformedAt = new Date();

        // If a checklist is completed or canceled then that is the last action
        // that could be performed on a checklist. Hence, we need to consider time
        // only up to that point.
        if (getAction() != null
                && (getAction() == LogTableActions.CANCELED.getValue()
                || getAction() == LogTableActions.COMPLETED.getValue()
        )) {
            lastPerformedAt = DateUtility.getDateFromString(getLastPerformedAt());
        }

       /* long difference = lastPerformedAt.getTime() - startedAt.getTime(); // In milliseconds
        long secondsInMilli = 1000;*/

        return DateUtility.getElapsedTime(lastPerformedAt.getTime() - startedAt.getTime());
    }

}
