package c.anurag.network.beans.workorder.billing.type;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar
 */

public class WorkorderBillingType extends DefaultChecklistResponse {
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getIsDefault() {
        return Utility.convertBooleanToInt(isDefault);
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
