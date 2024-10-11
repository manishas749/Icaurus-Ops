package com.icarus.navigators;

import com.icarus.entities.ResourceEntity;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ResourceLinkItems;
import com.icarus.models.SelectedFile;

import java.util.List;

/**
 * Created by Monika Rana on 1/23/2019.
 */

public interface ChecklistExecutionNavigator {
    void openNCWExecution(boolean isNext);

    void openDecisionExecution(boolean isNext);

    void checklistFinished();

    void showReferenceDialog(List<ResourceEntity> resourceList, List<ResourceLinkItems> resourceLinkList, ChecklistExecutionNavigator navigator);

    void openReferenceFile(ResourceEntity entity);

    void showErrorMessage(String errorMsg);

    void openResource(ChecklistDetailItems entity);

    void openEmbeddedImage(ChecklistDetailItems entity);

    void openAttachFile(SelectedFile entity);

    void openPagerFragment(boolean isNext);

    void showProgressBar();

    void hideProgressBar();

    void openMenu(boolean isOpen);

    void skip();

    void defer();

    void addSuggestion();

    void addNote();

    void showDataCaptured();

    void onReferenceDialogCanceled();

    void openEmbeddedImageFragment(boolean isNext);

    void onQRScanOpen(String title);

    void onQRScanClose();

    void setToolbarText(String title);
}
