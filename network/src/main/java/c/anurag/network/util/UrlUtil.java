package c.anurag.network.util;

import android.net.Uri;
import android.text.TextUtils;

import java.util.Map;

public final class UrlUtil {
    private static String defaultTime = "0000-00-00 00:00:00";
    public static final String REVISION = "revision";

    private UrlUtil() {
    }

    public static String getFormatedApiName(String apiName, String lastActivityAfter, String lastActivityBefore) {
        if (!TextUtils.isEmpty(lastActivityAfter)) {
            apiName = appendUrl(apiName, "last_activity_after=" + lastActivityAfter);
        } else {
            apiName = appendUrl(apiName, "last_activity_after=" + defaultTime);
        }
        if (!TextUtils.isEmpty(lastActivityBefore)) {
            apiName = appendUrl(apiName, "last_activity_before=" + lastActivityBefore);
        }
        return apiName;
    }

    public static String appendUrl(String apiName, String s) {
        if (!apiName.contains("?")) {
            apiName = apiName + "?";
        } else {
            apiName = apiName + "&";
        }
        return apiName + s;
    }

    /**
     * https://www.myawesomesite.com/turtles/types?type=1&sort=relevance#section-name
     * <p>
     * Uri.Builder builder = new Uri.Builder();
     * builder.scheme("https")
     * .authority("www.myawesomesite.com")
     * .appendPath("turtles")
     * .appendPath("types")
     * .appendQueryParameter("type", "1")
     * .appendQueryParameter("sort", "relevance")
     * .fragment("section-name");
     * return builder.build().toString();
     *
     * @param baseUrl     - String
     * @param params      - String[]
     * @param queryParams - Map<String, Object>
     * @return url
     */
    public static String getUrl(String baseUrl, String[] params, Map<String, Object> queryParams) {
        Uri.Builder builder = new Uri.Builder();
        if (baseUrl.startsWith("https")) {
            builder.scheme("https");
            builder.encodedAuthority(baseUrl.replace("https://", ""));
        } else if (baseUrl.startsWith("http")) {
            builder.scheme("http");
            builder.encodedAuthority(baseUrl.replace("http://", ""));
        }
        for (String str : params) {
            builder.appendPath(str);
        }
        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                if (queryParams.get(key) != null) {
                    builder.appendQueryParameter(key, queryParams.get(key).toString());
                }
            }
        }
        return builder.build().toString().replace("%2B", "+");
    }

    /**
     * https://www.myawesomesite.com/turtles/types?type=1&sort=relevance#section-name
     * <p>
     * Uri.Builder builder = new Uri.Builder();
     * builder.scheme("https")
     * .authority("www.myawesomesite.com")
     * .appendPath("turtles")
     * .appendPath("types")
     * .appendQueryParameter("type", "1")
     * .appendQueryParameter("sort", "relevance")
     * .fragment("section-name");
     * return builder.build().toString();
     *
     * @param baseUrl - String
     * @param params  - String[]
     * @return url
     */
    public static String getUrl(String baseUrl, String params) {
        return (baseUrl + (params.startsWith("/") ? "" : "/") + params).replace("%2B", "+");
    }
}
