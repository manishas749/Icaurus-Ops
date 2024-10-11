package com.icarus.models;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.databinding.BindingAdapter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.appcompat.widget.AppCompatTextView;

import com.icarus.R;
import com.icarus.enums.ChecklistElementStatus;
import com.icarus.enums.ChecklistElementType;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Monika Rana on 04/10/2019
 */
public class ElementWithCaptureDataItems {

    @ColumnInfo(name = "checklist_element_id")
    private Integer checklistElementId;

    @ColumnInfo(name = "item_type_id")
    private Integer itemTypeId;

    @ColumnInfo(name = "sequence_no")
    private String sequenceNo;

    private String title;

    private String description;

    private Integer status;

    @ColumnInfo(name = "attributes_count")
    private Integer attributesCount;

    @Ignore
    private LinkedHashMap<Integer, List<ElementAttributesItems>> elementAttributesItemsList;

    public Integer getChecklistElementId() {
        return checklistElementId;
    }

    public void setChecklistElementId(Integer checklistElementId) {
        this.checklistElementId = checklistElementId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
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

    public Integer getStatus() {
        return status;
    }

    public String getExecutionStatus() {
        return ChecklistElementStatus.getNameByCode(status);
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(Integer attributesCount) {
        this.attributesCount = attributesCount;
    }

    public LinkedHashMap<Integer, List<ElementAttributesItems>> getElementAttributesItemsList() {
        return elementAttributesItemsList;
    }

    public void setElementAttributesItemsList(LinkedHashMap<Integer, List<ElementAttributesItems>> elementAttributesItemsList) {
        this.elementAttributesItemsList = elementAttributesItemsList;
    }

    public boolean isStep() {
        return itemTypeId == ChecklistElementType.STEP.getValue();
    }

    @BindingAdapter("setExecutionColorAndImage")
    public static void setExecutionTextColorAndDrawable(AppCompatTextView textView, Integer status) {
        if (status == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else if (status == ChecklistElementStatus.COMPLETED.getValue()) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.green));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.element_status_complete, 0, 0, 0);
            }
        } else if (status == ChecklistElementStatus.SKIPPED.getValue()) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.capture_data_skipped));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.element_status_skipped, 0, 0, 0);
            }
        } else if (status == ChecklistElementStatus.DEFERRED.getValue()) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.capture_data_deferred));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.element_status_deferred, 0, 0, 0);
            }
        } else if (status == ChecklistElementStatus.IN_PROGRESS.getValue()) {
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.capture_data_progress));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.element_status_in_progress, 0, 0, 0);

            }
        }
    }

}
