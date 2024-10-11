package com.icarus.workorder.navigators;

import com.icarus.workorder.models.WorkOrderItems;

/**
 * Created by Anurag Purwar on 17/1/19.
 */

public interface WorkOrderNavigator {
    void onWorkOrderClick(WorkOrderItems item);

    void onStartObserving();

    void onRemoveObserver();

    void onCreateWorkOrder();
}
