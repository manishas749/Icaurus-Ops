package com.icarus.workorder.navigators;

/**
 * Created by Anurag Purwar on 22/1/19.
 */

public interface WorkOrderCompleteNavigator {
    void onDescriptionError(int resID);

    void onCancelClick();

    void onCompleteWorkOrder();

    void onSuccessfullySaveWorkOrder();
}
