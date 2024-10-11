package com.icarus.models;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;

import com.icarus.R;
import com.icarus.enums.AttributeType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.util.AppUtility;
import com.icarus.util.ContentType;

public class LogsSummary {
    String uuid;

    @ColumnInfo(name = "item_uuid")
    private String itemUUID;

    private int action;

    private String username;

    @ColumnInfo(name = "item_description")
    private String itemDescription;

    private String created;

    @ColumnInfo(name = "checklist_element_id")
    private String checklistElementId;

    @ColumnInfo(name = "step_action")
    private String stepAction;

    @ColumnInfo(name = "assigned_checklist_uuid")
    private String assignedChecklistUUID;

    @ColumnInfo(name = "file_md5_checksum")
    private String fileName;

    @ColumnInfo(name = "display_file_name")
    private String displayFileName;

    private String assignedStepResourceUUID;

    @ColumnInfo(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getItemUUID() {
        return itemUUID;
    }

    public void setItemUUID(String itemUUID) {
        this.itemUUID = itemUUID;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getCreated() {
        return AppUtility.Companion.parseDateToddMMyyyy(created);
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(String checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public String getStepAction() {
        return stepAction;
    }

    public void setStepAction(String stepAction) {
        this.stepAction = stepAction;
    }

    public String getAssignedChecklistUUID() {
        return assignedChecklistUUID;
    }

    public void setAssignedChecklistUUID(String assignedChecklistUUID) {
        this.assignedChecklistUUID = assignedChecklistUUID;
    }

    public String getFileName() {
        if (displayFileName.split("\\.").length > 0)
            return fileName + "." + displayFileName.split("\\.")[1];
        else return "";
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDisplayFileName() {
        return displayFileName;
    }

    public void setDisplayFileName(String displayFileName) {
        this.displayFileName = displayFileName;
    }

    public String getAssignedStepResourceUUID() {
        return assignedStepResourceUUID;
    }

    public void setAssignedStepResourceUUID(String assignedStepResourceUUID) {
        this.assignedStepResourceUUID = assignedStepResourceUUID;
    }

    public String getLabel() {
        if (action == LogTableActions.ASSIGNED.getValue() || action == LogTableActions.UNASSIGNED.getValue())
            return "Applied by: "; // Inverting action as logs have inverted values for yes and no
        else if (action == LogTableActions.COMPLETED.getValue() || action == LogTableActions.UNDO.getValue()
                || action == LogTableActions.SKIPPED.getValue()
                || action == LogTableActions.DEFERRED.getValue())
            return LogTableActions.getNameByCode(action) + " by: ";
        else if (action == LogTableActions.TEXT.getValue())
            return "Read by: ";
        else if (action == LogTableActions.IMAGE.getValue())
            return "Viewed by: ";
        else if (action == LogTableActions.ACKNOWLEDGED.getValue())
            return LogTableActions.getNameByCode(LogTableActions.ACKNOWLEDGED.getValue()) + " by: ";
        else
            return itemDescription + ": ";
    }

    public String getLabelDescription() {
        if (action == LogTableActions.OTHER_THAN_FILE.getValue() || action == LogTableActions.QA_VERIFICATION.getValue())
            return stepAction;
        else if (action == LogTableActions.FILE.getValue())
            return displayFileName;
        else
            return username;
    }

    public boolean isDescriptionImageClickable() {
        return action == LogTableActions.FILE.getValue();
    }

    public String getCreatedOnTitle() {
        if (action == LogTableActions.COMPLETED.getValue() || action == LogTableActions.UNDO.getValue()
                || action == LogTableActions.SKIPPED.getValue() || action == LogTableActions.DEFERRED.getValue()
                || action == LogTableActions.TEXT.getValue() || action == LogTableActions.IMAGE.getValue()
                || action == LogTableActions.ACKNOWLEDGED.getValue() || action == ChecklistExecutionStatus.NO.getValue()
                || action == ChecklistExecutionStatus.YES.getValue())
            return "on " + getCreated();
        else if (action == LogTableActions.FILE.getValue())
            return "Uploaded by " + username + " on " + getCreated();
        else
            return username + " on " + getCreated();
    }


    public String getDescription() {
        if (action == LogTableActions.OTHER_THAN_FILE.getValue()
                || action == LogTableActions.QA_VERIFICATION.getValue())
            return itemDescription;
        else
            return username;
    }

    public boolean isReasonVisible() {
        return !TextUtils.isEmpty(getItemDescription()) &&
                (getAction() == LogTableActions.SKIPPED.getValue() ||
                        getAction() == LogTableActions.DEFERRED.getValue()
                        || getAction() == LogTableActions.CANCELED.getValue());
    }

    public String getContentType() {
        String ext = "";
        if (displayFileName.split("\\.").length > 0)
            ext = displayFileName.split("\\.")[1];
        if (ContentType.isImageType(ext))
            return ContentType.IMAGE_PNG;
        else if (ContentType.isVideoType(ext))
            return ContentType.VIDEO_MP4;
        else return ext;
    }

    @BindingAdapter("setActionLabel")
    public static void setActionLabel(AppCompatImageView imageView, int action) {
        imageView.setVisibility(View.VISIBLE);
        if (action == LogTableActions.ASSIGNED.getValue() || action == LogTableActions.COMPLETED.getValue()
                || action == LogTableActions.TEXT.getValue() || action == LogTableActions.IMAGE.getValue()
                || action == LogTableActions.ACKNOWLEDGED.getValue())
            imageView.setImageResource(R.drawable.ic_tick_green);
        else if (action == LogTableActions.SKIPPED.getValue())
            imageView.setImageResource(R.drawable.ic_skip_next);
        else if (action == LogTableActions.UNASSIGNED.getValue())
            imageView.setImageResource(R.drawable.ic_cross);
        else if (action == LogTableActions.DEFERRED.getValue())
            imageView.setImageResource(R.drawable.ic_deferr);
        else {
            imageView.setVisibility(View.GONE);
        }
    }

    public String getQRLabelName() {
        String entityName = null;
        if (type != null && type.equalsIgnoreCase(AttributeType.QR.toString()) && stepAction != null) {
            String[] strings = stepAction.split("<#>");
            entityName = strings[0].trim();
        }
        return entityName;
    }

    public String getQRReason() {
        String reasonForManualVerification = null;

        if (type != null && type.equalsIgnoreCase(AttributeType.QR.toString()) && stepAction != null) {
            String[] strings = stepAction.split("<#>");

            if (strings.length == 3) {
                reasonForManualVerification = strings[2].trim();
            }
        }
        return reasonForManualVerification;
    }

    public boolean isQRVisible() {
        return type != null && type.equalsIgnoreCase(AttributeType.QR.toString());
    }

    public int isQRReasonVisible() {
        if (!TextUtils.isEmpty(getQRReason()))
            return View.VISIBLE;
        else
            return View.GONE;
    }

    @BindingAdapter("setLabel")
    public static void setLabel(TextView textView, LogsSummary item) {
        SpannableString textLabel = new SpannableString(item.getLabel());
        SpannableString textLabelDesc = new SpannableString(item.getLabelDescription());
        textLabel.setSpan(new TextAppearanceSpan(textView.getContext(), R.style.sansSarifMedium), 0, textLabel.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textLabel.setSpan(new ForegroundColorSpan(textView.getContext().getResources().getColor(R.color.black)), 0, textLabel.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textLabelDesc.setSpan(new TextAppearanceSpan(textView.getContext(), R.style.sansSarif), 0, textLabelDesc.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //If it is image set desc clickable and color blue
        if (item.isDescriptionImageClickable()) {
            textLabelDesc.setSpan(new ForegroundColorSpan(textView.getContext().getResources().getColor(R.color.button_text)),
                    0, textLabelDesc.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            textLabelDesc.setSpan(new ForegroundColorSpan(textView.getContext().getResources().getColor(R.color.black)),
                    0, textLabelDesc.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(textLabel);
        builder.append(textLabelDesc);
        textView.setText(builder);
    }

}
