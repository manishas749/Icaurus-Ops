package c.anurag.network.beans.rooms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;
import c.anurag.network.database.Utility;

/**
 * Created by anuragpurwar on 26/3/18.
 */

public class Rooms extends DefaultChecklistResponse {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsDefault() {
        return Utility.convertBooleanToInt(isDefault);
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

}
