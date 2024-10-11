package c.anurag.network.apiservice;

/**
 * Created by anuragpurwar
 */
public interface ApiCallback {
    abstract void onSyncComplete();

    abstract void onSyncFailure(Throwable throwable);
}
