package c.anurag.network.beans.workorder.note.details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class WorkorderNoteDetails extends DefaultChecklistResponse {
    @SerializedName("workorder_note_id")
    @Expose
    private Integer workorderNoteId;
    @SerializedName("old_value")
    @Expose
    private String oldValue;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("property")
    @Expose
    private String property;
    @SerializedName("property_key")
    @Expose
    private String propertyKey;

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public Integer getWorkorderNoteId() {
        return workorderNoteId;
    }

    public void setWorkorderNoteId(Integer workorderNoteId) {
        this.workorderNoteId = workorderNoteId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
