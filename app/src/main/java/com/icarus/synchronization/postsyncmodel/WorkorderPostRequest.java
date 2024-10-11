package com.icarus.synchronization.postsyncmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkorderPostRequest {

@SerializedName("data")
@Expose
public List<WorkorderObject> data = null;

    public List<WorkorderObject> getData() {
        return data;
    }

    public void setData(List<WorkorderObject> data) {
        this.data = data;
    }
}