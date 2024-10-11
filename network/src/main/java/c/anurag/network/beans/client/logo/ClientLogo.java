package c.anurag.network.beans.client.logo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import c.anurag.network.beans.DefaultChecklistResponse;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ClientLogo extends DefaultChecklistResponse {
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("file_md5_checksum")
    @Expose
    private String fileMd5Checksum;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileMd5Checksum() {
        return fileMd5Checksum;
    }

    public void setFileMd5Checksum(String fileMd5Checksum) {
        this.fileMd5Checksum = fileMd5Checksum;
    }
}
