package c.anurag.network;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;

import java.util.HashMap;
import java.util.Map;

import c.anurag.database.application.BaseApplication;

/**
 * RequestHeaderInterceptor class to add headers in the request to server.
 *
 * @author Anurag Purwar
 * @version 1.0
 */
public class RequestData {
    private static Map<String, String> headers = new HashMap<>();
    private static Map<String, Object> queryParams = new HashMap<>();

    static {

        final String credentials = BaseApplication.getPreferenceManager().getUserCredintials();
        headers.put("Authorization", credentials);
        headers.put("Accept", "application/vnd.icarus.v1.2+json");
        headers.put("Sync-Identifier", BaseApplication.getPreferenceManager().getSyncIdentifier());
        headers.put("Device-identifier", Settings.Secure.getString(BaseApplication.getContext().getContentResolver(), Settings.Secure.ANDROID_ID));
        headers.put("Device-Manufacturer", Build.MANUFACTURER);
        headers.put("Device-Model", Build.MODEL);
        headers.put("Device-Name", Build.DEVICE);
        headers.put("OS", Build.VERSION.RELEASE);
        PackageManager manager = BaseApplication.getContext().getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
            headers.put("VersionCode", Integer.toString(info.versionCode));
            headers.put("Version", info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getHeaders() {
        return headers;
    }

    public static Map<String, Object> getQueryParams() {
        return queryParams;
    }
}
