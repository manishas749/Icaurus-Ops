package c.anurag.network.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anuragpurwar
 */

public class DefaultResponse extends IResponse {
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
