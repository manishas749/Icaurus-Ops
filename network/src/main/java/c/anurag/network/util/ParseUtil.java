package c.anurag.network.util;

import android.text.TextUtils;

import com.google.gson.Gson;

public final class ParseUtil {
    private ParseUtil() {
    }

    public static <T> T getObject(String json, Class<T> className) {
        if (!TextUtils.isEmpty(json)) {
            return new Gson().fromJson(json, className);
        }
        return null;
    }
}
