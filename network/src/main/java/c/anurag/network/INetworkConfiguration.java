package c.anurag.network;

/**
 * Created by anuragpurwar on 19/3/18.
 */

public interface INetworkConfiguration {
    int DEFAULT_READ_TIMEOUT = 90; //90 Seconds

    int DEFAULT_WRITE_TIMEOUT = 90; //90 Seconds

    int DEFAULT_CONNECTION_TIMEOUT = 90; //90 Seconds

    int getReadTimeout();

    int getWriteTimeout();

    int getConnectionTimeout();
}
