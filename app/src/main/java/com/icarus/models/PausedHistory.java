package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.databinding.BindingAdapter;
import androidx.appcompat.widget.AppCompatTextView;
import android.text.Html;
import android.text.Spanned;

import com.icarus.R;
import com.icarus.util.AppUtility;
import com.icarus.util.DateUtility;

import java.util.Date;

public class PausedHistory {
    private String uuid;

    @ColumnInfo(name = "paused_by")
    private String pausedBy;

    @ColumnInfo(name = "paused_at")
    private String pausedAt;

    @ColumnInfo(name = "pause_reason")
    private String pauseReason;

    @ColumnInfo(name = "resumed_by")
    private String resumedBy;

    @ColumnInfo(name = "resumed_at")
    private String resumedAt;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPausedBy() {
        return pausedBy == null ? "" : pausedBy;
    }

    public void setPausedBy(String pausedBy) {
        this.pausedBy = pausedBy;
    }

    public String getPausedAt() {
        return pausedAt == null ? "0" : pausedAt;
    }

    public void setPausedAt(String pausedAt) {
        this.pausedAt = pausedAt;
    }

    public String getResumedBy() {
        return resumedBy == null ? "" : resumedBy;
    }

    public void setResumedBy(String resumedBy) {
        this.resumedBy = resumedBy;
    }

    public String getResumedAt() {
        return resumedAt == null ? "0" : resumedAt;
    }

    public void setResumedAt(String resumedAt) {
        this.resumedAt = resumedAt;
    }

    public String getPauseReason() {
        return pauseReason;
    }

    public void setPauseReason(String pauseReason) {
        this.pauseReason = pauseReason;
    }

    @BindingAdapter("app:bindContent")
    public static void setContent(AppCompatTextView textView, PausedHistory item) {
        String pauseTxt = "";
        if (item != null)
            pauseTxt = textView.getContext().getString(R.string.pause_history_detail, item.getPausedBy(), AppUtility.Companion.parseDateToddMMyyyy(item.getPausedAt()), DateUtility.getElapsedTime(item.getPauseTime()), item.getPauseReason(), item.getResumedBy(), AppUtility.Companion.parseDateToddMMyyyy(item.getResumedAt()));
        Spanned styledText = Html.fromHtml(pauseTxt);

      /* "<b>" + textView.getContext().getString(R.string.paused_by) + "</b> " + item.getPausedBy() + " <br> " + item.getPausedAt() + "(Paused for " + DateUtility.getElapsedTime(item.getPauseTime()) + ")"
                    + "<br>" + "<b>+" +textView.getContext().getString(R.string.reason) +"</b> " + item.getPauseReason()
                    + "<br>" + "<b>"+textView.getContext().getString(R.string.resumed_by)+" </b>" + item.getResumedBy() + " on " + item.getResumedAt();*/
        textView.setText(styledText);

    }

    public long getPauseTime() {
        if (getPausedAt() == null)
            return 0;
        if (getResumedAt() == null)
            return 0;

        Date pausedAt = DateUtility.getDateFromString(getPausedAt());
        Date resumedAt = DateUtility.getDateFromString(getResumedAt());
        //    Days.between(startDate, endDate);

        long difference = resumedAt.getTime() - pausedAt.getTime(); // In milliseconds
        // long secondsInMilli = 1000;

        return difference;
    }
}
