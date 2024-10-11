package c.anurag.network.beans.checklist.elements;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ChecklistElements extends DefaultChecklistResponse {
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type_id")
    @Expose
    private Integer itemTypeId;
    @SerializedName("parent_id")
    @Expose
    private int parentId;
    @SerializedName("sort_order")
    @Expose
    private int sortOrder;
    @SerializedName("sequence_no")
    @Expose
    private String sequenceNo;
    @SerializedName("checklist_id")
    @Expose
    private int checklistId;
    @SerializedName("checklist_uuid")
    @Expose
    private String checklistUuid;

    @SerializedName("associated_checklist_uuid")
    @Expose
    private String associatedChecklistUuid;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public String getChecklistUuid() {
        return checklistUuid;
    }

    public void setChecklistUuid(String checklistUuid) {
        this.checklistUuid = checklistUuid;
    }

    public String getAssociatedChecklistUuid() {
        return associatedChecklistUuid;
    }

    public void setAssociatedChecklistUuid(String associatedChecklistUuid) {
        this.associatedChecklistUuid = associatedChecklistUuid;
    }

}
