package com.icarus.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.databinding.ObservableBoolean;
import androidx.annotation.NonNull;

import com.icarus.adapters.ChecklistDetailAdapter;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.enums.ChecklistElementType;
import com.icarus.enums.ChecklistExecutionStatus;
import com.icarus.enums.LogTableActions;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.ParentDetailItem;
import com.icarus.navigators.ChecklistDetailNavigator;
import com.icarus.repositories.CheckListExecuteRepository;
import com.icarus.repositories.ChecklistDetailRepository;

import java.util.ArrayList;

/**
 * Created by Sameeer.Madaan on 28/12/18.
 */
public class ChecklistDetailListingViewModel extends BaseViewModel<ChecklistDetailNavigator> {
    private LiveData<PagedList<ChecklistElementItem>> liveData;
    private String assignedChecklistUuid;
    private int checklistId;
    private int tabPosition;
    private ChecklistDetailAdapter mAdapter;
    public ObservableBoolean isNoElements = new ObservableBoolean(false);

    private final static PagedList.Config config
            = new PagedList.Config.Builder()
            .setPageSize(Constants.PAGE_SIZE)
            .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
            .setEnablePlaceholders(true)
            .build();
    private boolean isSequential;

    public ChecklistDetailListingViewModel(@NonNull Application application) {
        super(application);
    }

    private void fetchData() {
        setIsLoading(true);
        ChecklistDetailRepository checklistDetailRepository = new ChecklistDetailRepository(getApplication());
        if (tabPosition == 0)
            liveData = checklistDetailRepository.getChecklistDetailList(config, checklistId, assignedChecklistUuid);
        else if (tabPosition == 1)
            liveData = checklistDetailRepository.getChecklistDetailListSkipped(config, checklistId, assignedChecklistUuid);
        else if (tabPosition == 2)
            liveData = checklistDetailRepository.getChecklistDetailListDeffered(config, checklistId, assignedChecklistUuid);
    }

    public LiveData<PagedList<ChecklistElementItem>> getLiveData() {
        return liveData;
    }

    public void setData(String assignedChecklistUuid, int checklistId, int selectedTab, boolean isSequential) {
        this.checklistId = checklistId;
        this.assignedChecklistUuid = assignedChecklistUuid;
        this.tabPosition = selectedTab;
        this.isSequential = isSequential;
        fetchData();
    }

    public ChecklistDetailAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new ChecklistDetailAdapter(this);
        }
        return mAdapter;
    }

    public void onChecklistClick(int position, ChecklistElementItem item) {
      //  if (tabPosition == 0)
            if (tabPosition == 0 && item.isDeferred()) {
                getNavigator().openDeferredTab(item);
            } else if (tabPosition == 0 && item.isSkipped()) {
                getNavigator().openSkippedTab(item);
            } else {
                if (isSequential)
                    checkAndExecute(position, item);
                else
                    getNavigator().openChecklistExecution(item.getChecklistId(), assignedChecklistUuid, item.getSortOrder(), item.getTitle());
            }
    }

    private void checkAndExecute(int position, ChecklistElementItem item) {
        CheckListExecuteRepository checkListExecuteRepository = new CheckListExecuteRepository(getApplication());
        boolean isResourceClicked = item.isResource();
        //If resource is clicked open parent step
        if (item.isParentStep() && isResourceClicked) {
            ParentDetailItem clickedElementParent = checkListExecuteRepository.getParentDetail(item.getParentId(), assignedChecklistUuid);
            //Change the clicked element to step as step is to be opened here
            if (clickedElementParent != null) {
                item = new ChecklistElementItem();
                item.setElementId(clickedElementParent.getElementId());
                item.setDescription(clickedElementParent.getDescription());
                item.setItemId(clickedElementParent.getItemId());
                item.setTitle(clickedElementParent.getTitle());
                item.setSequenceNo(clickedElementParent.getSequenceNo());
                item.setSortOrder(clickedElementParent.getSortOrder());
            }
        }

        if (liveData != null && liveData.getValue() != null) {
            ArrayList<ChecklistElementItem> checklistDetailItems = new ArrayList<>();
            for (int i = 0; i < position; i++) {
                if (liveData.getValue() == null) return;
                ChecklistElementItem checklistDetailItem = liveData.getValue().get(i);
                //Check if element is child of clicked step, open un-executed child if NCW
                if (checklistDetailItem!=null && !checklistDetailItem.isResource()
                        && item.getElementId() == checklistDetailItem.getParentId()
                        && checkIfNotCompleted(checklistDetailItem)) {
                    item = new ChecklistElementItem();
                    item.setElementId(checklistDetailItem.getElementId());
                    item.setDescription(checklistDetailItem.getDescription());
                    item.setItemId(checklistDetailItem.getItemId());
                    item.setTitle(checklistDetailItem.getTitle());
                    item.setSequenceNo(checklistDetailItem.getSequenceNo());
                    item.setSortOrder(checklistDetailItem.getSortOrder());
                }

                //Add element if is step/decision or is independent to bulk skip/defer list
                if (tabPosition == 0 && checklistDetailItem != null
                        && !checklistDetailItem.isParentStep()
                        && checkIfNotCompleted(checklistDetailItem)) {

                    checklistDetailItems.add(checklistDetailItem);
                }
            }
            if (checklistDetailItems.size() == 0)
                getNavigator().openChecklistExecution(checklistId, assignedChecklistUuid, item.getSortOrder(), item.getTitle());
            else {
                getNavigator().showSkipDeffer(checklistDetailItems, true);
            }
        } else
            getNavigator().openChecklistExecution(checklistId, assignedChecklistUuid, item.getSortOrder(), item.getTitle());

    }

    private boolean checkIfNotCompleted(ChecklistElementItem item) {
        if (item.isNCW() && item.getStatus() == null)
            return true;
        else if (item.isStepProcedureDataStep() && item.getStatus() == null)
            return true;
        else if (item.getItemTypeId() == ChecklistElementType.DECISION.getValue() && item.getStatus() == null)
            return true;
        else if (item.getItemTypeId() == ChecklistElementType.RESOURCE.getValue() && item.getImageTextStatus() == null)
            return true;
        else if (item.getItemTypeId() == ChecklistElementType.TEXT.getValue() && item.getImageTextStatus() == null)
            return true;
        else
            return false;
    }

    public int getLastExecutedPosition(PagedList<ChecklistElementItem> checklistDetailItems) {
        for (int i = 0; i < checklistDetailItems.size(); i++) {
            ChecklistElementItem checklistDetailItem = checklistDetailItems.get(i);
            if (checklistDetailItem != null && checkIfNotCompleted(checklistDetailItem)) {
                return checklistDetailItems.size() > i - 2 ? i - 2 : i;
            }
        }
        return 0;
    }

    public void executeSkipDeffer(ArrayList<ChecklistElementItem> checklistDetailItems,
                                  ChecklistExecutionStatus status,
                                  LogTableActions actions,
                                  String reason) {
        CheckListExecuteRepository checkListExecuteRepository = new CheckListExecuteRepository(getApplication());
        for (int i = 0; i < checklistDetailItems.size(); i++) {
            ChecklistElementItem checklistElementDetail = checklistDetailItems.get(i);
            if (checklistElementDetail.isNCW() && !checklistElementDetail.isParentStep()) {
                checkListExecuteRepository.executeNCW(assignedChecklistUuid,
                        checklistElementDetail.getItemTypeId(),
                        checklistElementDetail.getElementId(),
                        checklistElementDetail.getItemId(),
                        status.getValue(),
                        checklistId,
                        checklistElementDetail.getDescription(),
                        reason);
            } else if (checklistElementDetail.isDecision() && !checklistElementDetail.isParentStep()) {
                checkListExecuteRepository.executeDecisionPoints(assignedChecklistUuid,
                        checklistElementDetail.getElementId(),
                        status.getValue(),
                        checklistElementDetail.getDescription(),
                        checklistId,
                        checklistElementDetail.getItemId(),
                        reason);
            } else if ((checklistElementDetail.isText() || checklistElementDetail.isResource()) && !checklistElementDetail.isParentStep()) {
                checkListExecuteRepository.executeImageText(assignedChecklistUuid,
                        checklistId,
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
                    ParentDetailItem parent = checkListExecuteRepository.getParentDetail(checklistElementDetail.getSkipDefferId(), assignedChecklistUuid);
                    elementId = parent.getElementId();
                    itemId = parent.getItemId();
                    description = parent.getDescription();
                    if (parent.getStatus() != null && parent.getStatus() == status.getValue())
                        toBeExecuted = false;

                }
                if (toBeExecuted)
                    checkListExecuteRepository.executeStep(assignedChecklistUuid, itemId, elementId, status.getValue(),
                            checklistId, elementId, actions.getValue(), description, reason);
            }
        }
    }

    public ReasonPopUpViewModel getReasonPopUpViewModel() {
        return new ReasonPopUpViewModel(getApplication());
    }

}
