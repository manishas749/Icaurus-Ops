package c.anurag.network.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anuragpurwar
 */

public class Pagination {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("prev_url")
    @Expose
    private String prevUrl;
    private String nextUrl;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getPrevUrl() {
        return prevUrl;
    }

    public void setPrevUrl(String prevUrl) {
        this.prevUrl = prevUrl;
    }

    public String getNextUrl() {
        return "";
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }
}
