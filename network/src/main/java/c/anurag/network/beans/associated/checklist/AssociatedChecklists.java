package c.anurag.network.beans.associated.checklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class AssociatedChecklists extends DefaultChecklistResponse {
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type_id")
    @Expose
    private Integer itemTypeId;
    @SerializedName("inserted_at")
    @Expose
    private Integer insertedAt;
    @SerializedName("inserted_under")
    @Expose
    private Integer insertedUnder;
    @SerializedName("associated_checklist_id")
    @Expose
    private Integer associatedChecklistId;

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

    public Integer getInsertedAt() {
        return insertedAt;
    }

    public void setInsertedAt(Integer insertedAt) {
        this.insertedAt = insertedAt;
    }

    public Integer getInsertedUnder() {
        return insertedUnder;
    }

    public void setInsertedUnder(Integer insertedUnder) {
        this.insertedUnder = insertedUnder;
    }

    public Integer getAssociatedChecklistId() {
        return associatedChecklistId;
    }

    public void setAssociatedChecklistId(Integer associatedChecklistId) {
        this.associatedChecklistId = associatedChecklistId;
    }
}
