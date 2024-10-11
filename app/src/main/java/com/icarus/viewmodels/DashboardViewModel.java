package com.icarus.viewmodels;

import com.icarus.R;
import com.icarus.adapters.AllChecklistAdapter;
import com.icarus.adapters.CancelledCompletedChecklistAdapter;
import com.icarus.adapters.DepartmentChecklistAdapter;
import com.icarus.adapters.FilterListAdapter;
import com.icarus.adapters.MyAssignedChecklistAdapter;
import com.icarus.adapters.SearchSuggestionAdapter;
import com.icarus.base.BaseApplication;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.ChecklistTag;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.entities.LocationEntity;
import com.icarus.enums.FilterListType;
import com.icarus.listeners.SearchSelectedListener;
import com.icarus.models.AllChecklistItems;
import com.icarus.models.CancelledCompletedChecklistItems;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.models.DepartmentChecklistItems;
import com.icarus.models.MyAssignedChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.SortChecklistBy;
import com.icarus.models.StringCheckBox;
import com.icarus.models.UserItems;
import com.icarus.navigators.DashboardNavigator;
import com.icarus.repositories.AllCheckListRepository;
import com.icarus.repositories.CancelledCompletedCheckListRepository;
import com.icarus.repositories.DashboardRepository;
import com.icarus.repositories.DepartmentCheckListRepository;
import com.icarus.repositories.LocationRepository;
import com.icarus.repositories.MyAssignedCheckListRepository;
import com.icarus.util.AppUtility;
import com.icarus.util.Utilities;
import com.icarus.workorder.adapters.WorkOrderAdapter;
import com.icarus.workorder.models.WorkOrderItems;
import com.icarus.workorder.navigators.WorkOrderNavigator;
import com.icarus.workorder.repositories.WorkorderRepository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Monika Rana on 12/25/2018.
 */

public class DashboardViewModel extends BaseViewModel<DashboardNavigator> {

    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> locationName = new ObservableField<>();
    //Initialising filter arrays
    private ArrayList<SortChecklistBy> sortFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> typeFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> statusFilterList = new ArrayList<>();
    public ArrayList<StringCheckBox> departmentalFilterList = new ArrayList<>();
    public ArrayList<StringCheckBox> userFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> priorityFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> assignedToFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> authorFilterList = new ArrayList<>();

    private LiveData<ArrayList<StringCheckBox>> departmentalFilterListLiveData;
    private LiveData<ArrayList<StringCheckBox>> userFilterListLiveData;

    private LiveData<PagedList<AllChecklistItems>> arrayAllCheckListLiveData;
    private LiveData<PagedList<MyAssignedChecklistItems>> arrayMyAssignedCheckListLiveData;
    private LiveData<PagedList<CancelledCompletedChecklistItems>> arrayCancelledCheckListLiveData;
    private LiveData<PagedList<CancelledCompletedChecklistItems>> arrayCompletedCheckListLiveData;
    private LiveData<PagedList<DepartmentChecklistItems>> arrayDeptCheckListLiveData;
    private LiveData<PagedList<WorkOrderItems>> arrayWorkOrderLiveData;

    private FilterListAdapter typeFilterListAdapter, statusListAdapter, departmentalListAdapter, userListAdapter, priorityListAdapter, authorListAdapter;

    private AllChecklistAdapter allChecklistAdapter;
    private DepartmentChecklistAdapter departmentChecklistAdapter;
    private MyAssignedChecklistAdapter myAssignedChecklistAdapter;
    private CancelledCompletedChecklistAdapter cancelledChecklistAdapter;
    private CancelledCompletedChecklistAdapter completedChecklistAdapter;
    private WorkOrderAdapter workOrderAdapter;
    public SortChecklistBy sortChecklistBy;
    public String selectedCheckList = ChecklistTag.MY_ASSIGNED_CHECKLIST;
    public ObservableBoolean isChecklistEmpty = new ObservableBoolean(false);

    private DashboardRepository dashboardRepository;
    private AllCheckListRepository allCheckListRepository;
    private DepartmentCheckListRepository departmentCheckListRepository;
    private MyAssignedCheckListRepository myAssignedCheckListRepository;
    private CancelledCompletedCheckListRepository cancelledCompletedCheckListRepository;
    private WorkorderRepository workorderRepository;
    private LocationRepository mLocationRepository;

    private PagedList.Config config;
    private String searchKeyword = "";
    private SearchSuggestionAdapter searchSuggestionAdapter;
    private SearchSelectedListener onSearchSelected;
    public ObservableBoolean isFilterApplied = new ObservableBoolean(false);
    public ObservableInt filterCount = new ObservableInt(0);
    public ObservableField<String> lastSync = new ObservableField<>("");
    private LiveData<LinkedHashMap<Integer, LocationEntity>> locationsLiveData;
    private WorkOrderNavigator workOrderNavigator;
    private MyAssignedChecklistItems myAssignedChecklistItem;
    private DepartmentChecklistItems departmentChecklistItems;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        dashboardRepository = new DashboardRepository(this.getApplication());
        allCheckListRepository = new AllCheckListRepository(this.getApplication());
        myAssignedCheckListRepository = new MyAssignedCheckListRepository(getApplication());
        departmentCheckListRepository = new DepartmentCheckListRepository(getApplication());
        cancelledCompletedCheckListRepository = new CancelledCompletedCheckListRepository(getApplication());
        workorderRepository = new WorkorderRepository(getApplication());
        mLocationRepository = new LocationRepository(application);

        arrayDeptCheckListLiveData = new MutableLiveData<>();
        arrayWorkOrderLiveData = new MutableLiveData<>();

        allChecklistAdapter = new AllChecklistAdapter(this);
        myAssignedChecklistAdapter = new MyAssignedChecklistAdapter(this);
        departmentChecklistAdapter = new DepartmentChecklistAdapter(this);
        cancelledChecklistAdapter = new CancelledCompletedChecklistAdapter(this);
        completedChecklistAdapter = new CancelledCompletedChecklistAdapter(this);
        workOrderAdapter = new WorkOrderAdapter(this);

        isChecklistEmpty.set(true);
        sortChecklistBy = new SortChecklistBy(getApplication().getResources().getString(R.string.due_date_desc), SortingTag.DUE_DATE_ASC);

        //Setting pagination
        config = new PagedList.Config.Builder()
                .setPageSize(Constants.PAGE_SIZE)
                .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
                .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setLocationName(String locationName) {
        this.locationName.set(locationName);
    }

    //Observe departmental list
    public LiveData<ArrayList<StringCheckBox>> observeDepartmentalFilterList() {
        return departmentalFilterListLiveData;
    }

    //Observe departmental list
    public LiveData<ArrayList<StringCheckBox>> observeUserFilterList() {
        return userFilterListLiveData;
    }

    //Observe All Check list
    public LiveData<PagedList<AllChecklistItems>> observeAllCheckList() {
        return arrayAllCheckListLiveData;
    }

    //Observe All Check list
    public LiveData<PagedList<MyAssignedChecklistItems>> observeMyAssignedCheckList() {
        return arrayMyAssignedCheckListLiveData;
    }

    //Observe All Check list
    public LiveData<PagedList<DepartmentChecklistItems>> observeDeptCheckList() {
        return arrayDeptCheckListLiveData;
    }

    //Observe cancelled list
    public LiveData<PagedList<CancelledCompletedChecklistItems>> observeCancelledCheckList() {
        return arrayCancelledCheckListLiveData;
    }

    //Observe completed list
    public LiveData<PagedList<CancelledCompletedChecklistItems>> observeCompletedCheckList() {
        return arrayCompletedCheckListLiveData;
    }

    //Observe Room Assets list
    public LiveData<List<RoomAssetItems>> observeRoomAssetsList(int checklistId) {
        return allCheckListRepository.getRoomAssets(checklistId);
    }

    //Observe WorkOrder list
    public LiveData<PagedList<WorkOrderItems>> observeWorkOrder() {
        return arrayWorkOrderLiveData;
    }


    public List<UserItems> getLoggedInUserItem() {
        List<UserItems> userItems = new ArrayList<>();
        UserItems userItems1 = new UserItems().getItem(BaseApplication.getPreferenceManager().getUserFullName(), BaseApplication.getPreferenceManager().getUserId());
        userItems1.setSelected(true);
        userItems.add(userItems1);
        return userItems;
    }

    //Observe User list
    public LiveData<List<UserItems>> observeUserList(int departmentId) {
        return allCheckListRepository.getUsers(departmentId);
    }

    //
    public void initializeWorkOrderFilterList() {
        getAuthorFilterList();
        getPriorityFilterList();
        getAssignedToFilterList();
        getStatusFilterList();
    }

    /**
     * Gets status filters for filter bottom sheet
     */
    public void getStatusFilterList() {
        if (statusFilterList.size() == 0) {
            statusListAdapter = new FilterListAdapter(R.layout.view_item_with_checkbox, this, FilterListType.Status);
            statusFilterList = dashboardRepository.getStatusFilterList(selectedCheckList);
            statusFilterList.get(0).setSelected(true);
        }
        setStatusFilterListInAdapter(statusFilterList);
    }

    /**
     * Gets type filters for filter bottom sheet
     */
    public void getTypeFilterList() {
        if (typeFilterList.size() == 0) {
            typeFilterListAdapter = new FilterListAdapter(R.layout.view_item_with_checkbox, this, FilterListType.Type);
            typeFilterList = dashboardRepository.getTypeFilterList(selectedCheckList);
            typeFilterList.get(0).setSelected(true);
        }
        setTypeFilterListInAdapter(typeFilterList);
    }

    /**
     * Fetches department list from database
     */
    public void getDepartmentFilterList() {
        if (departmentalFilterList.size() == 0) {
            departmentalListAdapter = new FilterListAdapter(R.layout.view_item_with_checkbox, this, FilterListType.Department);
            departmentalFilterListLiveData = allCheckListRepository.getDepartmentFilterList();
        } else
            setDepartmentFilterListInAdapter(departmentalFilterList);
    }

    /**
     * Fetches department list from database
     */
    public void getUserFilterList() {
        if (userFilterList.size() == 0) {
            userListAdapter = new FilterListAdapter(R.layout.view_item_with_checkbox, this, FilterListType.User);
            setIsLoading(true);
            userFilterListLiveData = allCheckListRepository.getUserFilterList();
        } else
            setUserFilterListInAdapter(userFilterList);
    }

    /**
     * Gets priority filters for filter bottom sheet
     */
    private void getPriorityFilterList() {
        if (priorityFilterList.size() == 0) {
            priorityListAdapter = new FilterListAdapter(R.layout.view_item_with_checkbox, this, FilterListType.Priority);
            priorityFilterList = dashboardRepository.getPriorityFilterList();
        }
        setPriorityFilterListInAdapter(priorityFilterList);
    }

    /**
     * Gets assigned to filters for filter bottom sheet
     */
    private void getAuthorFilterList() {
        if (authorFilterList.size() == 0) {
            authorListAdapter = new FilterListAdapter(R.layout.view_item_with_checkbox, this, FilterListType.Author);
            authorFilterList = dashboardRepository.getAuthorFilterList();
        }
        setAuthorFilterListInAdapter(authorFilterList);
    }

    /**
     * Sets adapter on TYPE recycler view
     */
    public FilterListAdapter getTypeListAdapter() {
        return typeFilterListAdapter;
    }

    /**
     * Sets adapter on priority recycler view
     */
    public FilterListAdapter getPriorityListAdapter() {
        return priorityListAdapter;
    }

    /**
     * Sets adapter on assigned to recycler view
     */
    public ArrayList<StringCheckBox> getAssignedToFilterList() {
        if (assignedToFilterList.size() == 0)
            assignedToFilterList = dashboardRepository.getAssignedToFilterList();
        return assignedToFilterList;
    }

    /**
     * Sets adapter on author recycler view
     */
    public FilterListAdapter getAuthorListAdapter() {
        return authorListAdapter;
    }


    public void setTypeEmergencyFilter() {
        getTypeFilterList();
        //selectedTypeFilterIndex = 2;
        for (StringCheckBox item : typeFilterList)
            item.setSelected(false);
        typeFilterList.get(2).setSelected(true);
        typeFilterListAdapter.setItemChecked(typeFilterList);
    }

    /**
     * Sets adapter on STATUS recycler view
     */
    public FilterListAdapter getStatusListAdapter() {
        return statusListAdapter;
    }

    /**
     * Sets adapter on Department recycler view
     */
    public FilterListAdapter getDepartmentListAdapter() {
        return departmentalListAdapter;
    }

    public FilterListAdapter getUserListAdapter() {
        return userListAdapter;
    }

    /**
     * Sets adapter on Department recycler view
     */
    public RecyclerView.Adapter getAllCheckListAdapter() {
        if (selectedCheckList.equalsIgnoreCase(ChecklistTag.ALL_CHECKLIST))
            return allChecklistAdapter;
        else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.MY_DEPARTMENT_CHECKLIST))
            return departmentChecklistAdapter;
        else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.CANCELLED_CHECKLIST))
            return cancelledChecklistAdapter;
        else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.COMPLETED_CHECKLIST))
            return completedChecklistAdapter;
        else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.WORK_ORDER))
            return workOrderAdapter;
        else
            return myAssignedChecklistAdapter;
    }

    private StringCheckBox getTypeFilterAt(Integer index) {
        if (index != null && typeFilterList.size() > 0 && typeFilterList.get(index) != null) {
            return typeFilterList.get(index);
        }
        return null;
    }

    private StringCheckBox getStatusFilterAt(Integer index) {
        if (index != null && statusFilterList.size() > 0 && statusFilterList.get(index) != null) {
            return statusFilterList.get(index);
        }
        return null;
    }

    private StringCheckBox getDepartmentFilterAt(Integer index) {
        if (index != null && departmentalFilterList.size() > 0 && departmentalFilterList.get(index) != null) {
            return departmentalFilterList.get(index);
        }
        return null;
    }

    private StringCheckBox getUserFilterAt(Integer index) {
        if (index != null && userFilterList.size() > 0 && userFilterList.get(index) != null) {
            return userFilterList.get(index);
        }
        return null;
    }

    private StringCheckBox getPriorityFilterAt(Integer index) {
        if (index != null && priorityFilterList.size() > 0 && priorityFilterList.get(index) != null) {
            return priorityFilterList.get(index);
        }
        return null;
    }

    private StringCheckBox getAuthorFilterAt(Integer index) {
        if (index != null && authorFilterList.size() > 0 && authorFilterList.get(index) != null) {
            return authorFilterList.get(index);
        }
        return null;
    }

    private StringCheckBox getAssignedToFilterAt(Integer index) {
        if (index != null && assignedToFilterList.size() > 0 && assignedToFilterList.get(index) != null) {
            return assignedToFilterList.get(index);
        }
        return null;
    }


    /**
     * refreshes type filter adapter on data fetced or changed
     */
    private void setTypeFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.getTypeListAdapter().setFilterList(filterList);
        this.typeFilterListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes status adapter on data fetched or changed
     */
    private void setStatusFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.statusListAdapter.setFilterList(filterList);
        this.statusListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes department adapter on data fetched or changed
     */
    public void setDepartmentFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.departmentalListAdapter.setFilterList(filterList);
        this.departmentalListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes department adapter on data fetched or changed
     */
    public void setUserFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.userListAdapter.setFilterList(filterList);
        this.userListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes priority adapter on data fetched or changed
     */
    private void setPriorityFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.priorityListAdapter.setFilterList(filterList);
        this.priorityListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes priority adapter on data fetched or changed
     */
    private void setAuthorFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.authorListAdapter.setFilterList(filterList);
        this.authorListAdapter.notifyDataSetChanged();
    }


    /**
     * Gets sort list for sort bottom sheet
     */
    public ArrayList<SortChecklistBy> getSortList() {
        if (sortFilterList.size() == 0)
            sortFilterList = dashboardRepository.getSortList(selectedCheckList);
        return sortFilterList;
    }

    /**
     * refreshes AllCheckList adapter on data fetched or changed
     */
    public void setAllCheckListInAdapter(PagedList<AllChecklistItems> allChecklistItems) {
        if (allChecklistItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        allChecklistAdapter.submitList(allChecklistItems);
    }

    /**
     * refreshes AllCheckList adapter on data fetched or changed
     */
    public void setMyAssignedChecklistAdapter(PagedList<MyAssignedChecklistItems> myAssignedChecklistItems) {
        if (myAssignedChecklistItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        this.myAssignedChecklistAdapter.submitList(myAssignedChecklistItems);
        this.myAssignedChecklistAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes AllCheckList adapter on data fetched or changed
     */
    public void setDepartmentChecklistInAdapter(PagedList<DepartmentChecklistItems> departmentChecklistItems) {
        if (departmentChecklistItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        this.departmentChecklistAdapter.submitList(departmentChecklistItems);
        this.departmentChecklistAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes CancelledCheckList adapter on data fetched or changed
     */
    public void setCancelledChecklistInAdapter(PagedList<CancelledCompletedChecklistItems> cancelledChecklistItems) {
        if (cancelledChecklistItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        this.cancelledChecklistAdapter.submitList(cancelledChecklistItems);
        this.cancelledChecklistAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes CompletedCheckList adapter on data fetched or changed
     */
    public void setCompletedChecklistInAdapter(PagedList<CancelledCompletedChecklistItems> completedChecklistItems) {
        if (completedChecklistItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        completedChecklistAdapter.submitList(completedChecklistItems);
        completedChecklistAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes WorkOrdre adapter on data fetched or changed
     */
    public void setWorkOrderInAdapter(PagedList<WorkOrderItems> workOrderItems) {
        if (workOrderItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        workOrderAdapter.submitList(workOrderItems);
        workOrderAdapter.notifyDataSetChanged();
    }


    public StringCheckBox detectFilterList(FilterListType filterListType, int index) {
        if (filterListType.equals(FilterListType.Type))
            return getTypeFilterAt(index);
        else if (filterListType.equals(FilterListType.Status))
            return getStatusFilterAt(index);
        else if (filterListType.equals(FilterListType.User))
            return getUserFilterAt(index);
        else if (filterListType.equals(FilterListType.Priority))
            return getPriorityFilterAt(index);
        else if (filterListType.equals(FilterListType.Author))
            return getAuthorFilterAt(index);
        else if (filterListType.equals(FilterListType.AssignedTo))
            return getAssignedToFilterAt(index);
        else
            return getDepartmentFilterAt(index);
    }

    /**
     * Assign all checklist and update data in database
     */
    public void assignAllChecklist(String assignedChecklistUuid, Integer checklistId, Integer departmentId, Integer userId, String dueDate, List<UserItems> userItems, boolean isStart, RoomAssetItems roomAsset) {
        allCheckListRepository.assignCheckList(assignedChecklistUuid, checklistId, departmentId, userId, dueDate, userItems, isStart, roomAsset);
    }

    public boolean isUserExist(String uuid) {
        return myAssignedCheckListRepository.isUserExists(uuid);
    }

    public void updateMyAssignedChecklist(MyAssignedChecklistItems item) {
        if (item.getChecklistStatus().equalsIgnoreCase("New")) {
            myAssignedCheckListRepository.updateStartAssignedCheckList(item.getUuid(), item.getChecklistId());
            item.setChecklistStatus("In Progress");
        } else if (item.getChecklistStatus().equalsIgnoreCase("Paused")) {
            myAssignedCheckListRepository.resumeAssignedCheckList(item.getUuid(), item.getChecklistId());
            item.setChecklistStatus("In Progress");
        }
    }

    public void updateDepartmentChecklist(String uuid, DepartmentChecklistItems item) {
        departmentCheckListRepository.startAssignedCheckList(uuid, item.getChecklistId());
    }

    /*Filter fragment click events*/
    public void detectAndPerformFilterClick(FilterListType filterListType, int index) {
        if (filterListType.equals(FilterListType.Type))
            onFilterClicked(index, typeFilterList, typeFilterListAdapter);
        else if (filterListType.equals(FilterListType.Status))
            onFilterClicked(index, statusFilterList, statusListAdapter);
        else if (filterListType.equals(FilterListType.Department))
            onFilterClicked(index, departmentalFilterList, departmentalListAdapter);
        else if (filterListType.equals(FilterListType.User))
            onFilterClicked(index, userFilterList, userListAdapter);
        else if (filterListType.equals(FilterListType.Priority))
            onFilterClicked(index, priorityFilterList, priorityListAdapter);
        else if (filterListType.equals(FilterListType.Author))
            onFilterClicked(index, authorFilterList, authorListAdapter);
    }

    /**
     * Called when type list checkbox is clicked
     *
     * @param index clicked index
     */

    private void onFilterClicked(Integer index, ArrayList<StringCheckBox> filterList, FilterListAdapter adapter) {
        if (filterList.size() == 0)
            return;
        if (filterList.get(index).getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
            for (StringCheckBox item : filterList)
                item.setSelected(false);
            filterList.get(0).setSelected(true);
        } else {
            filterList.get(0).setSelected(false);
            //Exclude first item in filter
            if (index != 0)
                filterList.get(index).setSelected(!filterList.get(index).isSelected);

            //If no filter is selected set all as selected
            boolean isOneCheckBoxSelected = false;
            for (StringCheckBox checkBox : filterList)
                if (checkBox.isSelected)
                    isOneCheckBoxSelected = true;

            if (!isOneCheckBoxSelected)
                filterList.get(0).setSelected(true);
        }
        if (adapter != null)
            adapter.setItemChecked(filterList);

    }

    /**
     * Called when AllCheck list checkbox is clicked
     *
     * @param item clicked item
     */
    public void onAllChecklistItemClick(AllChecklistItems item) {
        getNavigator().onAllChecklistClick(item);
    }

    /**
     * Called when department list checkbox is clicked
     *
     * @param item clicked item
     */
    public void onDepartmentChecklistItemClick(DepartmentChecklistItems item) {
        setDepartmentChecklist(item);
        getNavigator().onDepartmentChecklistClick(item);
    }

    /**
     * Called when MyAssigned list checkbox is clicked
     *
     * @param item clicked item
     */
    public void onMyAssignedChecklistItemClick(MyAssignedChecklistItems item) {
        setMyAssignedChecklist(item);
        getNavigator().onMyAssignedChecklistClick(item);
    }

    /**
     * Called when MyAssigned list checkbox is clicked
     *
     * @param item clicked item
     */
    public void onCancelledCompletedChecklistItemClick(CancelledCompletedChecklistItems item) {
        getNavigator().continueChecklist(item);
    }

    /**
     * Called when Workorder list checkbox is clicked
     *
     * @param item clicked item
     */
    public void onWorkorderItemClick(WorkOrderItems item) {
        getWorkOrderNavigator().onWorkOrderClick(item);
    }

    public void onAddOrderClick() {
        getWorkOrderNavigator().onCreateWorkOrder();
    }

    /**
     * Called when cancel button on filter fragment is clicked
     */
    public void onClearFilter() {
        onFilterClicked(0, typeFilterList, typeFilterListAdapter);
        onFilterClicked(0, statusFilterList, statusListAdapter);
        onFilterClicked(0, departmentalFilterList, departmentalListAdapter);
        onFilterClicked(0, userFilterList, userListAdapter);
        onFilterClicked(0, assignedToFilterList, null);
        onFilterClicked(0, priorityFilterList, priorityListAdapter);
        onClearAuthorFilter();
    }

    /**
     * Method called if author filter in work order is to be refreshed
     */
    private void onClearAuthorFilter() {
        if (authorFilterList != null && authorFilterList.size() > 0)
            authorFilterList.get(0).setSelected(false);
    }

    /**
     * Called when add to fav is clicked from all checklist
     */
    public void onAddToFav(AllChecklistItems item, int position) {
        if (item != null)
            allCheckListRepository.addUpdateFavourite(item.getChecklistId(), item.isFavorite());

        if (item != null && position != -1) {
            item.setIsFavorite(item.isFavorite() == 0 ? 1 : 0);
            allChecklistAdapter.notifyItemChanged(position, item);
        }
    }

    /**
     * Called when search suggestion clicked
     */
    public void onSearchSuggestionClick(String searchSuggestion) {
        if (onSearchSelected != null)
            onSearchSelected.onSearchSuggestionSelected(searchSuggestion);
    }


    /**
     * gets selected checklist from database
     *
     * @param offset required for pagination
     */
    public void getChecklist(int offset, String keyword) {
        setIsLoading(true);
        hideShowFilterIcon();

        if (selectedCheckList.equalsIgnoreCase(ChecklistTag.WORK_ORDER)) {
            getWorkOrderNavigator().onRemoveObserver();
            arrayWorkOrderLiveData = workorderRepository.getWorkOrders(config, sortChecklistBy.getTag(), statusFilterList, priorityFilterList, assignedToFilterList, searchKeyword, authorFilterList);
            getWorkOrderNavigator().onStartObserving();
            return;
        }

        getNavigator().removeObserverIfAny();
        clearCheckList();
        if (selectedCheckList.equalsIgnoreCase(ChecklistTag.ALL_CHECKLIST)) {
            arrayAllCheckListLiveData = allCheckListRepository.getAllChecklist(config, sortChecklistBy.getTag(), statusFilterList, typeFilterList, keyword);
        } else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.MY_ASSIGNED_CHECKLIST)) {
            arrayMyAssignedCheckListLiveData = myAssignedCheckListRepository.getMyAssignedChecklist(config, sortChecklistBy.getTag(), statusFilterList, typeFilterList, departmentalFilterList, keyword);
        } else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.MY_DEPARTMENT_CHECKLIST)) {
            arrayDeptCheckListLiveData = departmentCheckListRepository.getDepartmentChecklist(config, sortChecklistBy.getTag(), statusFilterList, typeFilterList, departmentalFilterList, keyword);
        } else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.CANCELLED_CHECKLIST)) {
            arrayCancelledCheckListLiveData = cancelledCompletedCheckListRepository.getCancelledCompletedChecklist(config, sortChecklistBy.getTag(), typeFilterList, userFilterList, Constants.CHECL_LIST_STATUS_CANCELLED, keyword);
        } else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.COMPLETED_CHECKLIST)) {
            arrayCompletedCheckListLiveData = cancelledCompletedCheckListRepository.getCancelledCompletedChecklist(config, sortChecklistBy.getTag(), typeFilterList, userFilterList, Constants.CHECK_LIST_STATUS_COMPLETED, keyword);
        }
        getNavigator().onStartObserving();
    }

    private void hideShowFilterIcon() {
        filterCount.set(0);
        isFilterApplied.set(false);
        if (statusFilterList != null && statusFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : statusFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

        if (typeFilterList != null && typeFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : typeFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

        if (userFilterList != null && userFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : userFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

        if (departmentalFilterList != null && departmentalFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : departmentalFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

        if (priorityFilterList != null && priorityFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : priorityFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

        if (assignedToFilterList != null && assignedToFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : assignedToFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

        if (authorFilterList != null && authorFilterList.size() > 0) {
            for (StringCheckBox stringCheckBox : authorFilterList)
                if (stringCheckBox.isSelected) {
                    if (!stringCheckBox.getTitle().equalsIgnoreCase(getApplication().getString(R.string.all))) {
                        isFilterApplied.set(true);
                        filterCount.set(filterCount.get() + 1);
                        break;
                    }
                }
        }

    }

    /**
     * Called when checklist is changed and filters are refreshed
     */
    public void clearFilters() {
        setSearchKeyword("");
        //refresh filter
        sortFilterList.clear();
        typeFilterList.clear();
        statusFilterList.clear();
        userFilterList.clear();
        departmentalFilterList.clear();
        authorFilterList.clear();
        priorityFilterList.clear();
        assignedToFilterList.clear();

        //Refresh sort order
        sortChecklistBy = new SortChecklistBy(getApplication().getResources().getString(R.string.due_date_asc), SortingTag.DUE_DATE_ASC);
    }

    public void clearCheckList() {
        allChecklistAdapter.submitList(null);
        myAssignedChecklistAdapter.submitList(null);
        departmentChecklistAdapter.submitList(null);
        cancelledChecklistAdapter.submitList(null);
        workOrderAdapter.submitList(null);
    }

    public void setClientSetting() {
        dashboardRepository.getClientSetting();
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public SearchSuggestionAdapter getSearchSuggestionAdapter() {
        if (searchSuggestionAdapter == null)
            searchSuggestionAdapter = new SearchSuggestionAdapter(this);
        return searchSuggestionAdapter;
    }

    public void saveSearchSuggestionList(String suggestion) {
        if (searchSuggestionAdapter != null) {
            ArrayList<String> searchSuggestion = new ArrayList<>(searchSuggestionAdapter.getFilterList());
            if (!searchSuggestion.contains(suggestion)) {
                searchSuggestion.add(0, suggestion);
                Utilities.saveSearchSuggestion(searchSuggestion);
            }
        }
    }

    public void setSearchSelectedListener(SearchSelectedListener onSearchSelected) {
        this.onSearchSelected = onSearchSelected;
    }

    public int getSearchHint() {
        if (selectedCheckList.equalsIgnoreCase(ChecklistTag.ALL_CHECKLIST))
            return R.string.search_checklist_hint;
        else if (selectedCheckList.equalsIgnoreCase(ChecklistTag.WORK_ORDER)) {
            return R.string.enter_workorder_search_text;
        } else {
            return R.string.enter_search_text;
        }
    }

    private WorkOrderNavigator getWorkOrderNavigator() {
        return workOrderNavigator;
    }

    public void setWorkOrderNavigator(WorkOrderNavigator workOrderNavigator) {
        this.workOrderNavigator = workOrderNavigator;
    }

    public void setLastSync(String lastSync) {
        if (TextUtils.isEmpty(lastSync)) {
            this.lastSync.set("");
        } else {
            this.lastSync.set(AppUtility.Companion.parseDateToddMMyyyy(lastSync));
        }
    }


    /**
     * This method is called after syncing to check if selected location is disassociated from server,
     * if yes show popup asking for logout or change location
     * if no do nothing
     */
    public void fetchLocation() {
        setIsLoading(true);
        LocationRepository locationRepository = new LocationRepository(getApplication());
        locationsLiveData = locationRepository.getLocationList();
    }

    /**
     * This method is used for observing the location list
     */
    public LiveData<LinkedHashMap<Integer, LocationEntity>> observeLocationsResponse() {
        return locationsLiveData;
    }


    /**
     * This method is called after syncing to check if selected location is disassociated from server,
     * if yes show popup asking for logout or change location
     * if no do nothing
     * returns true if selected location exist
     */
    public boolean ifSelectedLocationStillExist(int userLocationId, LinkedHashMap<Integer, LocationEntity> locationItemsLinkedHashMap) {
        if (locationItemsLinkedHashMap != null)
            for (int key : locationItemsLinkedHashMap.keySet()) {
                LocationEntity locationItem = locationItemsLinkedHashMap.get(key);
                if (locationItem != null && locationItem.getId() == userLocationId)
                    return true;
            }
        return false;
    }

    public List<ChecklistItemPlaceHolders> getItemPlaceHolders(String checklistUUID) {
        return dashboardRepository.getItemPlaceholders(checklistUUID);
    }

    private void setMyAssignedChecklist(MyAssignedChecklistItems myAssignedChecklist) {
        myAssignedChecklistItem = myAssignedChecklist;
    }

    public MyAssignedChecklistItems getMyAssignedChecklistItem() {
        return myAssignedChecklistItem;
    }

    private void setDepartmentChecklist(DepartmentChecklistItems departmentChecklist) {
        this.departmentChecklistItems = departmentChecklist;
    }

    public DepartmentChecklistItems getDepartmentChecklistItems() {
        return departmentChecklistItems;
    }

    //Observe my assigned count
    public LiveData<Integer> getMyAssignedChecklistCount() {
        return myAssignedCheckListRepository.getAssignedChecklistCount();
    }

    //Observe department count
    public LiveData<Integer> getMyDepartmentChecklistCount() {
        return departmentCheckListRepository.getMyDepartmentChecklistCount();
    }


    //Observe work order count
    public LiveData<Integer> getWorkOrderChecklistCount() {
        return workorderRepository.getWorkOrderChecklistCount();
    }

    public void getLocation() {
        Integer locationId = BaseApplication.getPreferenceManager().getUserLocationId();

        LocationEntity locationEntity = mLocationRepository.getLocation(locationId);

        if (locationEntity == null) {
            setLocationName("");
            return;
        }

        String locationName = locationEntity.getName();

        BaseApplication.getPreferenceManager().setUserLocationName(locationName);
        BaseApplication.getPreferenceManager().setUserLocationTimeZone(locationEntity.getTimezone());

        setLocationName(locationName);
    }
}
