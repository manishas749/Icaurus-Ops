package com.icarus.workorder.navigators;

/**
 * Created by Anurag Purwar on 22/1/19.
 */

public interface WorkOrderCreateNavigator {
    void onTitleError(int resID);

    void onDescriptionError(int resID);

    void onRoomError(int resID);

    void onAssetError(int resID);

    void onStartLocationObserving();

    void onStartRoomObserving();

    void onStartAssetsObserving();

    void onCancelClick();

    void onSaveWorkOrder();

    void onSuccessfullySaveWorkOrder();
}
