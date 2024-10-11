package com.icarus.listeners;

/**
 * Created by Monika Rana on 2/7/2019.
 */

public interface OnDownloadListener {
    void onSuccess();

    void onFailed();

    void noInternetAvailable();
}
