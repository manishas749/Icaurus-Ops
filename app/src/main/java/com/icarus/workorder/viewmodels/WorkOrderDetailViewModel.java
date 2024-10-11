package com.icarus.workorder.viewmodels;

import com.icarus.R;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.enums.AssignedType;
import com.icarus.enums.WorkOrderPriority;
import com.icarus.enums.WorkorderStatus;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.util.StringUtil;
import com.icarus.workorder.adapters.WorkOrderAttachmentAdapter;
import com.icarus.workorder.adapters.WorkOrderDetailInfoAdapter;
import com.icarus.workorder.adapters.WorkOrderNoteInfoAdapter;
import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.models.WorkOrderDetailItems;
import com.icarus.workorder.models.WorkOrderInfoItems;
import com.icarus.workorder.models.WorkOrderNoteDetailItems;
import com.icarus.workorder.models.WorkOrderNoteInfoItems;
import com.icarus.workorder.navigators.WorkOrderDetailNavigator;
import com.icarus.workorder.repositories.WorkOrderDetailRepository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anurag Purwar on 22/1/18.
 */
public class WorkOrderDetailViewModel extends BaseViewModel<WorkOrderDetailNavigator> {
    private final WorkOrderDetailRepository workOrderDetailRepository;
    private WorkOrderDetailInfoAdapter workOrderInfoAdapter;
    private WorkOrderNoteInfoAdapter mWorkOrderNoteInfoAdapter;
    private LiveData<WorkOrderDetailItems> liveData;
    private LiveData<List<WorkOrderNoteInfoItems>> noteLiveData;
    private LiveData<List<WorkOrderAttachmentItems>> attachmentLiveData;
    private WorkOrderNoteInfoItems workOrderNoteInfoItems = new WorkOrderNoteInfoItems();
    private LiveData<List<WorkOrderNoteDetailItems>> noteDetailLiveData;
    private List<WorkOrderAttachmentItems> workOrderAttachmentItems = new ArrayList<>();
    private WorkOrderAttachmentAdapter attachmentAdapter;
    public ObservableField<String> footerText = new ObservableField<>();
    public ObservableBoolean footerVisible = new ObservableBoolean();
    private WorkOrderDetailItems workOrderDetailItems;

    public WorkOrderDetailViewModel(@NonNull Application application) {
        super(application);
        workOrderDetailRepository = new WorkOrderDetailRepository(getApplication());
        workOrderInfoAdapter = new WorkOrderDetailInfoAdapter();
        mWorkOrderNoteInfoAdapter = new WorkOrderNoteInfoAdapter(this);
        attachmentAdapter = new WorkOrderAttachmentAdapter(this);
    }

    public WorkOrderNoteInfoItems getWorkOrderNoteInfoItems() {
        return workOrderNoteInfoItems;
    }

    public void setWorkOrderNoteInfoItems(WorkOrderNoteInfoItems workOrderNoteInfoItems) {
        this.workOrderNoteInfoItems = workOrderNoteInfoItems;
    }

    public LiveData<WorkOrderDetailItems> getLiveData() {
        return liveData;
    }

    public LiveData<List<WorkOrderNoteInfoItems>> getNoteLiveData() {
        return noteLiveData;
    }

    public LiveData<List<WorkOrderAttachmentItems>> getAttachmentLiveData() {
        return attachmentLiveData;
    }

    public RecyclerView.Adapter getWorkOrderInfoAdapter() {
        return workOrderInfoAdapter;
    }

    public RecyclerView.Adapter getAttachmentAdapter() {
        return attachmentAdapter;
    }

    public void setWorkOrderId(int workOrderId, String uuid) {
        liveData = workOrderDetailRepository.getInfo(uuid);
        noteLiveData = workOrderDetailRepository.getWorkOrderNoteInfo(workOrderId);
        attachmentLiveData = workOrderDetailRepository.getWorkOrderAttachment(workOrderId);
    }

    public void setInfoAdapter(WorkOrderDetailItems workOrderDetailItems) {
        this.workOrderDetailItems = workOrderDetailItems;
        WorkOrderNoteInfoItems workOrderNoteInfoItems = new WorkOrderNoteInfoItems();
        workOrderNoteInfoItems.setCreated(workOrderDetailItems.getCreated());
        workOrderNoteInfoItems.setName(workOrderDetailItems.getAuthorFullName());
        workOrderNoteInfoItems.setWorkorderNotes(workOrderDetailItems.getDescription());

        setWorkOrderNoteInfoItems(workOrderNoteInfoItems);

        footerText.set(workOrderDetailItems.getWorkorderStatusName());

        List<WorkOrderInfoItems> list = new ArrayList<>();
        WorkOrderInfoItems status = new WorkOrderInfoItems(getApplication().getString(R.string.status), workOrderDetailItems.getWorkorderStatusName());
        list.add(status);

        WorkOrderInfoItems priority = new WorkOrderInfoItems(getApplication().getString(R.string.priority), getPriority(workOrderDetailItems.getWorkorderPriorityId()));
        list.add(priority);

        WorkOrderInfoItems location = new WorkOrderInfoItems(getApplication().getString(R.string.location), workOrderDetailItems.getLocationName());
        list.add(location);

        WorkOrderInfoItems dueDate = new WorkOrderInfoItems(getApplication().getString(R.string.due_date), workOrderDetailItems.getDueDate());
        list.add(dueDate);

        WorkOrderInfoItems billing = new WorkOrderInfoItems(getApplication().getString(R.string.billing), workOrderDetailItems.getWorkorderBillingTypeName());
        list.add(billing);

        WorkOrderInfoItems assignedTo = new WorkOrderInfoItems(getApplication().getString(R.string.assigned_to), workOrderDetailItems.getWorkorderAssignedTo());
        list.add(assignedTo);

        WorkOrderInfoItems room = new WorkOrderInfoItems(BaseApplication.getPreferenceManager().getRoomName(), workOrderDetailItems.getRoomName());
        list.add(room);

        WorkOrderInfoItems asset = new WorkOrderInfoItems(BaseApplication.getPreferenceManager().getAssetName(), workOrderDetailItems.getEquipmentName());
        list.add(asset);
        workOrderInfoAdapter.setItem(list);

        if (workOrderDetailItems.getWorkorderStatusId() == WorkorderStatus.OPEN.getValue() || workOrderDetailItems.getWorkorderStatusId() == WorkorderStatus.RE_OPENED.getValue()) {
            footerText.set(getApplication().getString(R.string.start_work_order));
        } else {
            footerText.set(getApplication().getString(R.string.complete_work_order));
        }

        // Be default, hide the bottom footer
        footerVisible.set(false);

        Integer assigneeType = workOrderDetailItems.getAssignedToType();
        Integer departmentId = workOrderDetailItems.getAssignedToDepartmentId();
        Integer userId = workOrderDetailItems.getAssignedToUserId();
        Integer loggedInUserId = BaseApplication.getPreferenceManager().getUserId();

        if (workOrderDetailItems.getWorkorderStatusId() == WorkorderStatus.COMPLETED.getValue())
            footerVisible.set(false);
        else if (assigneeType == AssignedType.vendor.getValue()) {
            footerVisible.set(true);
        } else if (assigneeType == AssignedType.department.getValue()
                && departmentId != null
                && ifUserBelongsToSameDepartment(departmentId)) {
            footerVisible.set(true);
        } else if (assigneeType == AssignedType.user.getValue()
                && userId != null
                && userId.equals(loggedInUserId)) {
            footerVisible.set(true);
        }
    }

    private boolean ifUserBelongsToSameDepartment(int departmentID) {
        int userId = BaseApplication.getPreferenceManager().getUserId();
        int locationId = BaseApplication.getPreferenceManager().getUserLocationId();
        boolean isAdministrator = BaseApplication.getPreferenceManager().getIsAdmin();

        ArrayList<Integer> departmentList;

        if (isAdministrator) {
            departmentList = (ArrayList<Integer>) workOrderDetailRepository.getDepartmentList(locationId);
        } else {
            departmentList = (ArrayList<Integer>) workOrderDetailRepository.getDepartmentList(locationId, userId);
        }
        return departmentList.contains(departmentID);
    }

    private String getPriority(Integer workorderPriorityId) {
        String priority = "";
        if (workorderPriorityId == WorkOrderPriority.URGENT.getValue()) {
            priority = getApplication().getString(R.string.work_order_priority_urgent);
        } else if (workorderPriorityId == WorkOrderPriority.NORMAL.getValue()) {
            priority = getApplication().getString(R.string.work_order_priority_normal);
        } else if (workorderPriorityId == WorkOrderPriority.LOW.getValue()) {
            priority = getApplication().getString(R.string.work_order_priority_low);
        }
        return priority;
    }

    public WorkOrderNoteInfoAdapter getWorkOrderNoteInfoAdapter() {
        return mWorkOrderNoteInfoAdapter;
    }

    public void setNoteInfoAdapter(List<WorkOrderNoteInfoItems> workOrderNoteInfoItemList, List<WorkOrderAttachmentItems> attachmentItemList, List<WorkOrderNoteDetailItems> workOrderDetailItemList) {

        HashMap<Integer, List<WorkOrderNoteDetailItems>> noteDetailHashMapList = new HashMap<>();
        HashMap<Integer, List<WorkOrderAttachmentItems>> attachmentHashMapList = new HashMap<>();
        List<WorkOrderNoteInfoItems> workOrderNoteItems = new ArrayList<>();

        for (WorkOrderNoteDetailItems item : workOrderDetailItemList) {
            List<WorkOrderNoteDetailItems> items
                    = noteDetailHashMapList.get(item.getWorkorderNoteId());
            if (!StringUtil.INSTANCE.listNotNull(items)) {
                items = new ArrayList<>();
            }
            items.add(item);

            List<WorkOrderAttachmentItems> attachmentItems = attachmentHashMapList.get(item.getWorkorderNoteId());
            if (!StringUtil.INSTANCE.listNotNull(attachmentItems)) {
                attachmentItems = new ArrayList<>();
            }
            if (StringUtil.INSTANCE.listNotNull(attachmentItemList)) {
                for (WorkOrderAttachmentItems attachmentItem : attachmentItemList) {

                    if (item.getPropertyKey().equals(attachmentItem.getUuid())) {
                        attachmentItems.add(attachmentItem);
                    }
                }
                for (WorkOrderAttachmentItems attachmentItem : attachmentItems) {
                    attachmentItemList.remove(attachmentItem);
                }
            }

            attachmentHashMapList.put(item.getWorkorderNoteId(), attachmentItems);
            noteDetailHashMapList.put(item.getWorkorderNoteId(), items);
        }

        WorkOrderNoteInfoItems workOrderNoteInfoItems = getWorkOrderNoteInfoItems();
        workOrderNoteInfoItems.setAttachments(attachmentItemList);
        workOrderNoteItems.add(workOrderNoteInfoItems);
        for (WorkOrderNoteInfoItems item : workOrderNoteInfoItemList) {
            if (noteDetailHashMapList.containsKey(item.getId())) {
                List<WorkOrderNoteDetailItems> noteItems = noteDetailHashMapList.get(item.getId());
                List<WorkOrderAttachmentItems> attachmentItems = attachmentHashMapList.get(item.getId());
                item.setNoteDetail(noteItems);
                item.setAttachments(attachmentItems);
            }
            workOrderNoteItems.add(item);
        }
        mWorkOrderNoteInfoAdapter.setItem(workOrderNoteItems);
    }

    public void fetchNoteDetail(Integer[] noteId) {
        noteDetailLiveData = workOrderDetailRepository.getWorkOrderNoteDetail(noteId);
    }

    public LiveData<List<WorkOrderNoteDetailItems>> getNoteDetailLiveData() {
        return noteDetailLiveData;
    }

    public void setWorkOrderAttachmentItems(List<WorkOrderAttachmentItems> workOrderAttachmentItems) {
        this.workOrderAttachmentItems = workOrderAttachmentItems;
    }

    public List<WorkOrderAttachmentItems> getWorkOrderAttachmentItems() {
        return workOrderAttachmentItems;
    }

    @BindingAdapter("setGridAdapter")
    public static void bindRecyclerViewGridAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("setAdapterDecorated")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void onFooterClick() {
        if (workOrderDetailItems.getWorkorderStatusId() == WorkorderStatus.OPEN.getValue() || workOrderDetailItems.getWorkorderStatusId() == WorkorderStatus.RE_OPENED.getValue()) {
            getNavigator().performInProgressAction(workOrderDetailItems, workOrderDetailRepository.getStatus(WorkorderStatus.IN_PROGRESS.getValue()));
        } else {
            getNavigator().performCompleteAction(workOrderDetailItems);
        }
    }

    public void performInProgressAction(WorkOrderDetailItems workOrderDetailItems, String statusName) {
        workOrderDetailRepository.inProgressAction(workOrderDetailItems, statusName);
    }

    public void onAttachmentClick(WorkOrderAttachmentItems attachmentItem) {
        getNavigator().openOrDownloadAttachment(attachmentItem);
    }


    public void downloadFile(WorkOrderAttachmentItems attachmentItem, OnDownloadListener onDownloadListener) {
        workOrderDetailRepository.downloadFile(attachmentItem, onDownloadListener);
    }
}
