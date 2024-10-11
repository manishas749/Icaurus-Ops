package c.anurag.network;

import android.content.Context;

/**
 * Created by anuragpurwar on 22/3/18.
 */

public class ServiceLocator {
    private RetrofitApiServiceFactory apiServiceFactory;
    private Context mContext;

    public ServiceLocator(Context ctx)
    {
        mContext = ctx;
        apiServiceFactory = new RetrofitApiServiceFactory();
    }
}
