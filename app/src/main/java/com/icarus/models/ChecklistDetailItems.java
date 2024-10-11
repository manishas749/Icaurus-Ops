package com.icarus.models;

import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import com.icarus.R;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anurag Purwar on 28/12/18.
 */
public class ChecklistDetailItems {

    @ColumnInfo(name = "id")
    private int elementId;
    @ColumnInfo(name = "checklist_id")
    private int checklistId;
    @ColumnInfo(name = "item_type_id")
    private int itemTypeId;
    @ColumnInfo(name = "item_id")
    private int itemId;
    @ColumnInfo(name = "item_uuid")
    private String itemUuid;
    @ColumnInfo(name = "parent_id")
    private int parentItemId;
    @ColumnInfo(name = "sort_order")
    private int sortOrder;
    @ColumnInfo(name = "sequence_no")
    private String sequenceNo;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "parent_type")
    private Integer parentType;

    @ColumnInfo(name = "ppes_icon")
    private String ppesIcon;
    @ColumnInfo(name = "hazards_icon")
    private String hazardsIcon;

    @Ignore
    private List<String> ppeList;
    @Ignore
    private List<String> hazardsList;

    public Integer getParentType() {
        return this.parentType;
    }

    public void setParentType(Integer parent_type) {
        this.parentType = parent_type;
    }

    public Integer getParentStatus() {
        return parentStatus;
    }

    public void setParentStatus(Integer parent_status) {
        this.parentStatus = parent_status;
    }

    @ColumnInfo(name = "parent_status")
    private Integer parentStatus;

    private Integer acknowledged, status;

    public Integer getImageTextStatus() {
        Integer executionStatus = status == null ? imageTextStatus : status;
        if (executionStatus != null && executionStatus == LogTableActions.DEFERRED.getValue())
            return ChecklistExecutionStatus.DEFERRED.getValue();
        else if (executionStatus != null && executionStatus == LogTableActions.SKIPPED.getValue())
            return ChecklistExecutionStatus.SKIPPED.getValue();
        else
            return executionStatus;
    }

    public String getPpesIcon() {
        return ppesIcon;
    }

    public void setPpesIcon(String ppesIcon) {
        this.ppesIcon = ppesIcon;
        if (ppesIcon != null)
            ppeList = new ArrayList<String>(
                    Arrays.asList(ppesIcon.split(",")));
    }

    public String getHazardsIcon() {
        return hazardsIcon;
    }

    public void setHazardsIcon(String hazardsIcon) {
        this.hazardsIcon = hazardsIcon;
        if (hazardsIcon != null)
            this.hazardsList = new ArrayList<String>(
                    Arrays.asList(hazardsIcon.split(",")));
    }

    public void setImageTextStatus(Integer imageTextStatus) {
        this.imageTextStatus = imageTextStatus;
    }

    private Integer decisionStatus, imageTextStatus;

    public Integer getDecisionStatus() {
        return status == null ? decisionStatus : status;
    }

    public void setDecisionStatus(Integer decisionStatus) {
        this.decisionStatus = decisionStatus;
    }

    public Integer getAcknowledged() {
        return status == null ? acknowledged : status;
    }

    public void setAcknowledged(Integer acknowledged) {
        this.acknowledged = acknowledged;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public int getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSkipDefferId() {
        if (getParentType() != null
                && (getParentType() == ChecklistElementType.STEP.getValue()
                || getParentType() == ChecklistElementType.PROCEDURE.getValue()
                || getParentType() == ChecklistElementType.DATA_STEP.getValue())) {
            return getParentItemId();
        }

        return getElementId();
    }

    public boolean isParentStep() {
        return (getParentType() != null
                && (getParentType() == ChecklistElementType.STEP.getValue()
                || getParentType() == ChecklistElementType.PROCEDURE.getValue()
                || getParentType() == ChecklistElementType.DATA_STEP.getValue()));
    }

    public boolean isStepProcedureDataStep() {
        return itemTypeId == ChecklistElementType.STEP.getValue()
                || itemTypeId == ChecklistElementType.PROCEDURE.getValue()
                || itemTypeId == ChecklistElementType.DATA_STEP.getValue();
    }

    public boolean isNCW() {
        return itemTypeId == ChecklistElementType.NOTE.getValue()
                || itemTypeId == ChecklistElementType.CAUTION.getValue()
                || itemTypeId == ChecklistElementType.WARNING.getValue();
    }

    public boolean isNCWTR() {
        return itemTypeId == ChecklistElementType.NOTE.getValue()
                || itemTypeId == ChecklistElementType.CAUTION.getValue()
                || itemTypeId == ChecklistElementType.WARNING.getValue()
                || itemTypeId == ChecklistElementType.TEXT.getValue()
                || itemTypeId == ChecklistElementType.RESOURCE.getValue();
    }

    public boolean isParentOfNCWSkipped() {
        return (isParentStep() && getParentStatus() != null
                && getParentStatus() == ChecklistExecutionStatus.SKIPPED.getValue());
    }

    public boolean isParentOfNCWDeferred() {
        return (isParentStep() && getParentStatus() != null
                && getParentStatus() == ChecklistExecutionStatus.DEFERRED.getValue());
    }

    public boolean isSkipped() {
        return (getStatus() != null && getStatus() == ChecklistExecutionStatus.SKIPPED.getValue()) ||
                (getAcknowledged() != null && getAcknowledged() == ChecklistExecutionStatus.SKIPPED.getValue())
                || (getDecisionStatus() != null && getDecisionStatus() == ChecklistExecutionStatus.SKIPPED.getValue())
                || (getImageTextStatus() != null && getImageTextStatus() == ChecklistExecutionStatus.SKIPPED.getValue());
    }

    public boolean isDeferred() {
        return (getStatus() != null && getStatus() == ChecklistExecutionStatus.DEFERRED.getValue())
                || (getAcknowledged() != null && getAcknowledged() == ChecklistExecutionStatus.DEFERRED.getValue())
                || (getDecisionStatus() != null && getDecisionStatus() == ChecklistExecutionStatus.DEFERRED.getValue())
                || (getImageTextStatus() != null && getImageTextStatus() == ChecklistExecutionStatus.DEFERRED.getValue());
    }

    public List<String> getPPEsIconList() {
        return ppeList;
    }

    public List<String> getHazardsIconList() {
        return hazardsList;
    }

    public int getStepExecutionStatus() {
        if (status == null)
            return R.string.slide_to_complete;
        else if (status == ChecklistExecutionStatus.ACKNOWLEDGE.getValue())
            return R.string.completed;
        else if (status == ChecklistExecutionStatus.SKIPPED.getValue())
            return R.string.skipped;
        else if (status == ChecklistExecutionStatus.DEFERRED.getValue())
            return R.string.deferred;
        else
            return R.string.slide_to_complete;
    }

    public boolean checkElementIfExecuted() {
        if ((getItemTypeId() == ChecklistElementType.NOTE.getValue() || getItemTypeId() == ChecklistElementType.CAUTION.getValue() || getItemTypeId() == ChecklistElementType.WARNING.getValue()) && getAcknowledged() != null && getAcknowledged() == ChecklistExecutionStatus.ACKNOWLEDGE.getValue())
            return true;
        else if ((getItemTypeId() == ChecklistElementType.STEP.getValue() || getItemTypeId() == ChecklistElementType.PROCEDURE.getValue() || getItemTypeId() == ChecklistElementType.DATA_STEP.getValue()) && getStatus() != null && getStatus() == ChecklistExecutionStatus.ACKNOWLEDGE.getValue())
            return true;
        else if (getItemTypeId() == ChecklistElementType.DECISION.getValue() && getDecisionStatus() != null && getDecisionStatus() != null && (getDecisionStatus() == ChecklistExecutionStatus.YES.getValue() || getDecisionStatus() == ChecklistExecutionStatus.NO.getValue()))
            return true;
        else if (getItemTypeId() == ChecklistElementType.RESOURCE.getValue() && getImageTextStatus() != null && getImageTextStatus() == LogTableActions.IMAGE.getValue())
            return true;
        else if (getItemTypeId() == ChecklistElementType.TEXT.getValue() && getImageTextStatus() != null && getImageTextStatus() == LogTableActions.TEXT.getValue())
            return true;
        else
            return false;
    }

    public boolean isStep() {
        return itemTypeId == ChecklistElementType.STEP.getValue();
    }

    public boolean isDecision() {
        return itemTypeId == ChecklistElementType.DECISION.getValue();
    }

    public boolean isResource() {
        return itemTypeId == ChecklistElementType.RESOURCE.getValue();
    }

    public boolean isText() {
        return itemTypeId == ChecklistElementType.TEXT.getValue();
    }

    public String getFileName() {
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description))
            return "";
        else if (description.split("\\.").length < 2)
            return "";
        else
            return title + "." + description.split("\\.")[1];
    }

    @BindingAdapter("setNCWIcon")
    public static void setNCWIcon(AppCompatImageView icon, int itemTypeId) {
        icon.setVisibility(View.VISIBLE);
        if (itemTypeId == ChecklistElementType.NOTE.getValue())
            icon.setImageResource(R.drawable.ic_note);
        else if (itemTypeId == ChecklistElementType.CAUTION.getValue())
            icon.setImageResource(R.drawable.ic_caution);
        else if (itemTypeId == ChecklistElementType.WARNING.getValue())
            icon.setImageResource(R.drawable.ic_warning);
        else
            icon.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof ChecklistDetailItems)) {
            return false;
        }
        ChecklistDetailItems person = (ChecklistDetailItems) obj;
        return person.getElementId() == getElementId();
    }

    @Override
    public int hashCode() {
        return getElementId();
    }
}
