package c.anurag.network.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtil {
    /**
     * default constructor
     */
    private NetworkUtil() {
    }

    /**
     * @param context Context
     * @return boolean true if network is available for device either WIFI or Mobile
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connMgr.getActiveNetworkInfo();
        return (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
    }
}
