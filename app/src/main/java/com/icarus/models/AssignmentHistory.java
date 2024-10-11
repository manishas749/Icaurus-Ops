package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.databinding.BindingAdapter;
import androidx.appcompat.widget.AppCompatTextView;
import android.text.Html;

import com.icarus.enums.LogTableActions;
import com.icarus.util.AppUtility;

public class AssignmentHistory {
    @ColumnInfo(name = "performed_at")
    private String performedAt;

    private Integer action;

    @ColumnInfo(name = "assigned_by")
    private String assignedBy;

    @ColumnInfo(name = "assigned_to")
    private String assignedTo;

    public String getPerformedAt() {
        return performedAt == null ? "0" : performedAt;
    }

    public void setPerformedAt(String performedAt) {
        this.performedAt = performedAt;
    }

    public Integer getAction() {
        return action;
    }

    public String getActionTaken() {
        if(action == null)
            return "";
        else if (action.equals(LogTableActions.ASSIGNED.getValue()))
            return "Assigned To";
        else if (action.equals(LogTableActions.UNASSIGNED.getValue()))
            return "Removed";
        else if (action.equals(LogTableActions.ASSIGNED_TO_DEPARTMENT.getValue()))
            return "Assigned To Department";
        else
            return "";
    }


    public void setAction(Integer action) {
        this.action = action;
    }

    public String getAssignedBy() {
        return assignedBy == null ? "" : assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getAssignedTo() {
        return assignedTo == null ? "" : assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }


    @BindingAdapter("app:bindContent")
    public static void setContent(AppCompatTextView textView, AssignmentHistory item) {
        String assignmentTxt = "";
        if (item != null)
            assignmentTxt = AppUtility.Companion.parseDateToddMMyyyy(item.getPerformedAt()) + "<br>" + "<b>" + item.getActionTaken() + " </b> " + item.getAssignedTo() + " <b>By</b> " + item.getAssignedBy();

        textView.setText(Html.fromHtml(assignmentTxt));

    }


}
