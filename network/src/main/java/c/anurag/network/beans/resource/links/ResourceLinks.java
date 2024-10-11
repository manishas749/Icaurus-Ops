package c.anurag.network.beans.resource.links;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar
 */

public class ResourceLinks extends DefaultChecklistResponse {
    @SerializedName("link_title")
    @Expose
    private String linkTitle;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_type_id")
    @Expose
    private Integer itemTypeId;

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

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
}
