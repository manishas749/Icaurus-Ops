package c.anurag.network.beanspost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static c.anurag.network.database.Utility.convertBooleanToInt;

/**
 * Created by anuragpurwar on 30/3/18.
 */

public abstract class DefaultChecklistPostResponse {
    @SerializedName("uuid")
    @Expose
    protected String uuid;
    @SerializedName("is_deleted")
    @Expose
    protected Boolean isDeleted;
    @SerializedName("created_at")
    @Expose
    protected String createdAt;
    @SerializedName("updated_at")
    @Expose
    protected String updatedAt;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIsDeleted() {
        return convertBooleanToInt(isDeleted);
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
