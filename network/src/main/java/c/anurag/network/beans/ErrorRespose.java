package c.anurag.network.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorRespose {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("message")
    @Expose
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
