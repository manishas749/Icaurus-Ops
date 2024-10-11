package com.icarus.navigators;

import com.icarus.models.QRAttributeScanItem;

/**
 * Created by Monika Rana on 13/05/2020
 */
public interface QRCodeScanNavigator {
    void onQRItemClick(int position);

    void removeGetScanItemsLiveDataObserver();

    void observeQRScanItemsList();
}
