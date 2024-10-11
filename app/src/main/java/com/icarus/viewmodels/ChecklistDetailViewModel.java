package com.icarus.viewmodels;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.annotation.NonNull;

import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.models.AttachmentItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.ChecklistIDetailtems;
import com.icarus.models.NonExecutedChildElement;
import com.icarus.models.ParentDetailItem;
import com.icarus.models.UserItems;
import com.icarus.navigators.ChecklistListingNavigator;
import com.icarus.repositories.CheckListExecuteRepository;
import com.icarus.repositories.ChecklistDetailRepository;
import com.icarus.repositories.UserSuggestionRepository;
import com.icarus.util.FileUtils;
import com.icarus.widget.viewmodel.GalleryViewModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Monika Rana on 2/6/2019.
 */

public class ChecklistDetailViewModel extends BaseViewModel<ChecklistListingNavigator> {
    private ChecklistDetailRepository mChecklistDetailRepository;
    private LiveData<Integer> totalCountLiveData, completeCountLiveData;
    public ObservableField<String> completeCount = new ObservableField<>("0");
    public ObservableField<String> totalCount = new ObservableField<>("0");
    public ObservableBoolean enableMarkComplete = new ObservableBoolean(false);
    private String checklistUUID;
    private Integer checklistID;
    private GalleryViewModel galleryViewModel;
    private LiveData<PagedList<ChecklistDetailItems>> liveDataPendingElements;
    private UserSuggestionRepository userSuggestionRepository;
    private boolean isSequential;
    private final static PagedList.Config config
            = new PagedList.Config.Builder()
            .setPageSize(Constants.PAGE_SIZE)
            .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
            .setEnablePlaceholders(true)
            .build();
    private ChecklistIDetailtems mChecklistDetailItem;
    private boolean isMarkCompletePopupVisible;

    public ChecklistDetailViewModel(@NonNull Application application) {
        super(application);
        mChecklistDetailRepository = new ChecklistDetailRepository(getApplication());
    }

    public void init(String checklistUUID) {
        getChecklistDetail(checklistUUID);
        this.isSequential = getChecklistDetailItem().isSequential();
    }

    public void getTotalChecklistCount() {
        totalCountLiveData = mChecklistDetailRepository.getTotalElementCount(checklistID, checklistUUID);
        getNavigator().observeTotalCount();
    }

    public Integer getTotalCountForMarkComplete() {
        return mChecklistDetailRepository.getTotalElementCountForMarkComplete(checklistID, checklistUUID);
    }

    public void getInformationPopup() {
        getNavigator().showInformationPopUp(mChecklistDetailRepository.getCheckListPPForInformationPopUp(checklistID));
    }

    public void getCompletedChecklistCount() {
        completeCountLiveData = mChecklistDetailRepository.getPendingElementCount(checklistID, checklistUUID);
        getNavigator().observeCompletedCount();
    }

    public LiveData<Integer> getCompletedCountLiveData() {
        return completeCountLiveData;
    }

    public LiveData<Integer> getTotalCountLiveData() {
        return totalCountLiveData;
    }

    public void pauseChecklist(String reason) {
        mChecklistDetailRepository.pauseAssignedCheckList(checklistUUID, reason, checklistID);
    }

    public void cancelChecklist(String reason) {
        mChecklistDetailRepository.cancelCheckList(checklistUUID, checklistID, reason);
    }

    public void completeChecklist() {
        mChecklistDetailRepository.completeChecklist(checklistUUID, checklistID);
        getNavigator().checklistCompleted();
    }

    public void setChecklistUUID(String checklistUUID) {
        this.checklistUUID = checklistUUID;
    }

    public void addSuggestion(String reason, ObservableList<AttachmentItems> listAttachment) {
        if (userSuggestionRepository == null)
            userSuggestionRepository = new UserSuggestionRepository(getApplication());
        userSuggestionRepository.addUserSuggestion(checklistUUID, checklistID, null, reason, listAttachment);
    }

    public GalleryViewModel getGalleryViewModel() {
        if (galleryViewModel == null) {
            File fileDestinationFolder = FileUtils.getSuggestionAttachmentsDir();
            galleryViewModel = new GalleryViewModel(getApplication(), fileDestinationFolder);
        }
        return galleryViewModel;
    }

    public void setGalleryViewModel(GalleryViewModel galleryViewModel) {
        this.galleryViewModel = galleryViewModel;
    }

    public ReasonPopUpViewModel getReasonPopUpViewModel() {
        return new ReasonPopUpViewModel(getApplication());
    }

    public List<UserItems> getUserList() {
        Integer departmentId = getChecklistDetailItem().getDepartmentId();

        return mChecklistDetailRepository.getUsersForAssignment(checklistUUID, departmentId);
    }

    public void assignChecklistUsers(List<UserItems> userItems) {
        //Assign checklist to selected users
        mChecklistDetailRepository.insertUsers(userItems, checklistUUID, checklistID);
    }

    public void getChecklistDetailPendingElements() {
        liveDataPendingElements = mChecklistDetailRepository.getChecklistDetailIncompleteElements(config, checklistID, checklistUUID);
    }

    public LiveData<PagedList<ChecklistDetailItems>> getPendingElementsLiveData() {
        return liveDataPendingElements;
    }

    public void onChecklistClick(int position, ChecklistDetailItems item) {
        if (item == null)
            return;

        int selectedTab = 0;
        if (item.isStepProcedureDataStep()) {
            CheckListExecuteRepository repository = new CheckListExecuteRepository(getApplication());
            NonExecutedChildElement nonExecutedChildElement = repository.getChildElementIfNotExecuted(item.getElementId(), checklistUUID);
            if (nonExecutedChildElement != null) {
                if (item.isDeferred())
                    selectedTab = 2;
                else if (item.isSkipped())
                    selectedTab = 1;

                item.setSortOrder(nonExecutedChildElement.getSortOrder());
                item.setTitle(nonExecutedChildElement.getTitle());
            }

        }

        ArrayList<ChecklistDetailItems> checklistDetailItems = new ArrayList<>();
        boolean isSkipDefer = true;
        if (isSequential)
            for (int i = 0; i < position; i++) {
                if (liveDataPendingElements == null || liveDataPendingElements.getValue() == null)
                    return;

                ChecklistDetailItems checklistDetailItem = liveDataPendingElements.getValue().get(i);
                if (checklistDetailItem != null && checkIfNotCompleted(checklistDetailItem)) {
                    checklistDetailItems.add(checklistDetailItem);

                }
            }
        if (checklistDetailItems.size() == 0)
            getNavigator().showElement(item.getSortOrder(), item, selectedTab);
        //    else
        //   getNavigator().showSkipDeffer(checklistDetailItems, isSkipDefer);

    }

    private void getChecklistDetail(String checklistUuid) {
        mChecklistDetailItem = mChecklistDetailRepository.getChecklistDetail(checklistUuid);
        checklistID = mChecklistDetailItem.getChecklistId();
    }

    private boolean checkIfNotCompleted(ChecklistDetailItems item) {
        if ((item.getItemTypeId() == ChecklistElementType.NOTE.getValue() || item.getItemTypeId() == ChecklistElementType.CAUTION.getValue() || item.getItemTypeId() == ChecklistElementType.WARNING.getValue()) && item.getAcknowledged() == null)
            return true;
        else if ((item.getItemTypeId() == ChecklistElementType.STEP.getValue() || item.getItemTypeId() == ChecklistElementType.PROCEDURE.getValue() || item.getItemTypeId() == ChecklistElementType.DATA_STEP.getValue()) && item.getStatus() == null)
            return true;
        else if (item.getItemTypeId() == ChecklistElementType.DECISION.getValue() && item.getDecisionStatus() == null)
            return true;
        else if (item.getItemTypeId() == ChecklistElementType.RESOURCE.getValue() && item.getImageTextStatus() == null)
            return true;
        else if (item.getItemTypeId() == ChecklistElementType.TEXT.getValue() && item.getImageTextStatus() == null)
            return true;
        else
            return false;
    }

    public void executeSkipDeffer(ArrayList<ChecklistElementItem> checklistDetailItems,
                                  ChecklistExecutionStatus status,
                                  LogTableActions actions,
                                  String reason) {
        CheckListExecuteRepository checkListExecuteRepository = new CheckListExecuteRepository(getApplication());
        for (int i = 0; i < checklistDetailItems.size(); i++) {
            ChecklistElementItem checklistElementDetail = checklistDetailItems.get(i);
            if (checklistElementDetail.isNCW() && !checklistElementDetail.isParentStep()) {
                checkListExecuteRepository.executeNCW(checklistUUID,
                        checklistElementDetail.getItemTypeId(),
                        checklistElementDetail.getElementId(),
                        checklistElementDetail.getItemId(),
                        status.getValue(),
                        checklistID,
                        checklistElementDetail.getDescription(),
                        reason);
            } else if (checklistElementDetail.isDecision() && !checklistElementDetail.isParentStep()) {
                checkListExecuteRepository.executeDecisionPoints(checklistUUID,
                        checklistElementDetail.getElementId(),
                        status.getValue(),
                        checklistElementDetail.getDescription(),
                        checklistID,
                        checklistElementDetail.getItemId(),
                        reason);
            } else if ((checklistElementDetail.isText() || checklistElementDetail.isResource()) && !checklistElementDetail.isParentStep()) {
                checkListExecuteRepository.executeImageText(checklistUUID,
                        checklistID,
                        checklistElementDetail.getElementId(),
                        status.getValue(),
                        checklistElementDetail.getItemUuid(),
                        checklistElementDetail.getDescription(),
                        reason);
            } else {
                boolean toBeExecuted = true;
                int elementId = checklistElementDetail.getElementId();
                int itemId = checklistElementDetail.getItemId();
                String description = checklistElementDetail.getDescription();

                if (checklistElementDetail.isParentStep()) {
                    ParentDetailItem parent = checkListExecuteRepository.getParentDetail(checklistElementDetail.getSkipDefferId(), checklistUUID);
                    elementId = parent.getElementId();
                    itemId = parent.getItemId();
                    description = parent.getDescription();
                    if (parent.getStatus() != null && parent.getStatus() == status.getValue())
                        toBeExecuted = false;

                }
                if (toBeExecuted)
                    checkListExecuteRepository.executeStep(checklistUUID, itemId, elementId, status.getValue(),
                            checklistID, elementId, actions.getValue(), description, reason);
            }
        }
    }

    public ChecklistIDetailtems getChecklistDetailItem() {
        return mChecklistDetailItem;
    }


    public boolean isMarkCompletePopupVisible() {
        return isMarkCompletePopupVisible;
    }

    public void setMarkCompletePopupVisible(boolean markCompletePopupVisible) {
        isMarkCompletePopupVisible = markCompletePopupVisible;
    }
}
