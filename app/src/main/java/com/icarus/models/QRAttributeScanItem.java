package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.databinding.BindingAdapter;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.AppCompatTextView;

import com.icarus.R;

/**
 * Created by Monika Rana on 05/05/2020
 */
public class QRAttributeScanItem {
    @ColumnInfo(name = "uuid")
    public String uuid;

    @ColumnInfo(name = "item_uuid")
    public String itemUuid;

    @ColumnInfo(name = "step_attribute_id")
    public Integer stepAttributeId;

    @ColumnInfo(name = "checklist_element_id")
    public Integer checklistElementId;

    @ColumnInfo(name = "assigned_checklist_uuid")
    public String assignedChecklistUuid;

    @ColumnInfo(name = "entity_uuid")
    public String entityUuid;

    @ColumnInfo(name = "entity_name")
    public String entityName;

    @ColumnInfo(name = "verification_reason")
    public String verificationReason;

    @ColumnInfo(name = "qr_code")
    public String qrCode;

    @ColumnInfo(name = "model")
    public String model;

    @ColumnInfo(name = "upc_number")
    public String upcNumber;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public Integer getStepAttributeId() {
        return stepAttributeId;
    }

    public void setStepAttributeId(Integer stepAttributeId) {
        this.stepAttributeId = stepAttributeId;
    }

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public String getAssignedChecklistUuid() {
        return assignedChecklistUuid;
    }

    public void setAssignedChecklistUuid(String assignedChecklistUuid) {
        this.assignedChecklistUuid = assignedChecklistUuid;
    }

    public String getEntityUuid() {
        return entityUuid;
    }

    public void setEntityUuid(String entityUuid) {
        this.entityUuid = entityUuid;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getVerificationReason() {
        return verificationReason;
    }

    public void setVerificationReason(String verificationReason) {
        this.verificationReason = verificationReason;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getUPCNumber() {
        return upcNumber;
    }

    public void setUPCNumber(String upcNumber) {
        this.upcNumber = upcNumber;
    }

    @BindingAdapter("app:setQRScanExecutionStatus")
    public static void setTextFromResourceId(AppCompatTextView textView, String uuid) {
        if (uuid == null) {
            textView.setText(R.string.pending);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.emergency_color_error));
        } else {
            textView.setText(R.string.verified);
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.green));
        }
    }

    public boolean isRoom() {
        return model.equalsIgnoreCase("LocationRoom");
    }

    public String getReason() {
        if (getVerificationReason() == null)
            return null;
        String reasonForManualVerification = null; // 5 -> Reason (if any)
        String[] strings = getVerificationReason().split("<#>");

        if (strings.length == 3) {
            reasonForManualVerification = strings[2];
        }
        return reasonForManualVerification;
    }
}
