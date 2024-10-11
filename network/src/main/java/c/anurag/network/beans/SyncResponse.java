package c.anurag.network.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SyncResponse implements Serializable{
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public class Data implements Serializable {

        @SerializedName("type")
        @Expose
        private String apiName;
        @SerializedName("count")
        @Expose
        private int value;

        public String getApiName() {
            return apiName;
        }

        public void setApiName(String apiName) {
            this.apiName = apiName;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public class Meta implements Serializable{

        @SerializedName("ServerDateTime")
        @Expose
        private int serverDateTime;
        @SerializedName("ServerDateTimeFormatted")
        @Expose
        private String serverDateTimeFormatted;
        @SerializedName("Revision")
        @Expose
        private int revision;

        public int getServerDateTime() {
            return serverDateTime;
        }

        public void setServerDateTime(int serverDateTime) {
            this.serverDateTime = serverDateTime;
        }

        public String getServerDateTimeFormatted() {
            return serverDateTimeFormatted;
        }

        public void setServerDateTimeFormatted(String serverDateTimeFormatted) {
            this.serverDateTimeFormatted = serverDateTimeFormatted;
        }

        public int getRevision() {
            return revision;
        }

        public void setRevision(int revision) {
            this.revision = revision;
        }

    }
}
