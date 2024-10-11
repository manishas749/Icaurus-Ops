package com.icarus.workorder.navigators;

import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.models.WorkOrderDetailItems;

/**
 * Created by Anurag Purwar on 22/1/19.
 */

public interface WorkOrderDetailNavigator {

    void performInProgressAction(WorkOrderDetailItems workOrderDetailItems, String statusName);

    void performCompleteAction(WorkOrderDetailItems workOrderDetailItems);

    void openOrDownloadAttachment(WorkOrderAttachmentItems attachmentItem);

    void showProgressBar();

    void hideProgressBar();
}
