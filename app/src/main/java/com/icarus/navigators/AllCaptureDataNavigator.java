package com.icarus.navigators;

import androidx.lifecycle.LiveData;

import com.icarus.models.ElementAttributesItems;

import java.util.List;

/**
 * Created by Monika Rana on 09/10/2019
 */
public interface AllCaptureDataNavigator {

    void observeElementAttribute(LiveData<List<ElementAttributesItems>> elementAttributesItemsLiveData, int position);

    void openClickedFile(String filePath);

    void showMessage(String message);

    void popUpAskDownload(String filePath, String itemUUID);
}
