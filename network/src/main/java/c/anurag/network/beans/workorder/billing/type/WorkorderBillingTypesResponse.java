package c.anurag.network.beans.workorder.billing.type;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import c.anurag.network.beans.DefaultResponse;

/**
 * Created by anuragpurwar
 */

public class WorkorderBillingTypesResponse extends DefaultResponse {
    @SerializedName("data")
    @Expose
    private List<WorkorderBillingType> data = null;

    public List<WorkorderBillingType> getData() {
        return data;
    }

    public void setData(List<WorkorderBillingType> data) {
        this.data = data;
    }
}
