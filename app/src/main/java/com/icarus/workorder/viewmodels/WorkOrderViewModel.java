package com.icarus.workorder.viewmodels;

import com.icarus.R;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.constants.SortingTag;
import com.icarus.models.SortChecklistBy;
import com.icarus.models.StringCheckBox;
import com.icarus.workorder.adapters.FilterWorkOrderListAdapter;
import com.icarus.workorder.adapters.WorkOrderAdapter;
import com.icarus.workorder.enums.FilterWorkOrderListType;
import com.icarus.workorder.models.WorkOrderItems;
import com.icarus.workorder.navigators.WorkOrderNavigator;
import com.icarus.workorder.repositories.WorkOrderDashboardRepository;
import com.icarus.workorder.repositories.WorkorderRepository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.databinding.ObservableBoolean;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Anurag Purwar on 17/1/19.
 */

public class WorkOrderViewModel extends BaseViewModel<WorkOrderNavigator> {
    private ArrayList<SortChecklistBy> sortFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> typeFilterList = new ArrayList<>();
    private ArrayList<StringCheckBox> priorityFilterList = new ArrayList<>();
    public ArrayList<StringCheckBox> assignedToFilterList = new ArrayList<>();
    public ArrayList<StringCheckBox> authorFilterList = new ArrayList<>();
    private LiveData<PagedList<WorkOrderItems>> arrayWorkorderLiveData;
    private FilterWorkOrderListAdapter typeFilterListAdapter, priorityListAdapter, assignedToListAdapter, authorListAdapter;
    private WorkOrderAdapter workOrderAdapter;
    private WorkOrderDashboardRepository dashboardRepository;
    public SortChecklistBy sortWorkOrderBy;
    //public int selectedSortRadioButtonId = 0, selectedTypeFilterIndex = -1, selectedPriorityFilterIndex = -1, selectedAssignedToFilterIndex = -1, selectedAuthorFilterIndex = -1;
    public ObservableBoolean isChecklistEmpty = new ObservableBoolean(false);
    private WorkorderRepository workorderRepository;
    private final static PagedList.Config config
            = new PagedList.Config.Builder()
            .setPageSize(Constants.PAGE_SIZE)
            .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
            .setEnablePlaceholders(false)
            .build();
    private String searchKeyword = "";

    public WorkOrderViewModel(@NonNull Application application) {
        super(application);
        dashboardRepository = new WorkOrderDashboardRepository(this.getApplication());
        workorderRepository = new WorkorderRepository(this.getApplication());
     //   workOrderAdapter = new WorkOrderAdapter(this);
        initlizeFilterList();
        isChecklistEmpty.set(true);
        sortWorkOrderBy = new SortChecklistBy(getApplication().getResources().getString(R.string.due_date_desc), SortingTag.DUE_DATE_ASC);
    }

    private void initlizeFilterList() {
        authorFilterList = dashboardRepository.getAuthorFilterList();
        priorityFilterList = dashboardRepository.getPriorityFilterList();
        assignedToFilterList = dashboardRepository.getAssignedToFilterList();
        typeFilterList = dashboardRepository.getTypeFilterList();
    }

    //Observe All Check list
    public LiveData<PagedList<WorkOrderItems>> observeWorkorder() {
        return arrayWorkorderLiveData;
    }

    /**
     * Gets sort list for sort bottom sheet
     */
    public ArrayList<SortChecklistBy> getSortList() {
        if (sortFilterList.size() == 0)
            sortFilterList = dashboardRepository.getSortList();
        return sortFilterList;
    }

    /**
     * Gets priority filters for filter bottom sheet
     */
    public void getPriorityFilterList() {
        if (priorityListAdapter == null) {
            priorityListAdapter = new FilterWorkOrderListAdapter(R.layout.view_item_workorder_with_checkbox, this, FilterWorkOrderListType.Priority);
        }
        setPriorityFilterListInAdapter(priorityFilterList);
    }

    /**
     * Gets assigned to filters for filter bottom sheet
     */
    public void getAssignedToFilterList() {
        if (assignedToListAdapter == null) {
            assignedToListAdapter = new FilterWorkOrderListAdapter(R.layout.view_item_workorder_with_checkbox, this, FilterWorkOrderListType.AssignedTo);
        }
        setAssignedToFilterListInAdapter(assignedToFilterList);
    }

    /**
     * Gets assigned to filters for filter bottom sheet
     */
    public void getAuthorFilterList() {
        if (authorListAdapter == null) {
            authorListAdapter = new FilterWorkOrderListAdapter(R.layout.view_item_workorder_with_checkbox, this, FilterWorkOrderListType.Author);
        }
        setAuthorFilterListInAdapter(authorFilterList);
    }

    /**
     * Gets type filters for filter bottom sheet
     */
    public void getTypeFilterList() {
        if (typeFilterListAdapter == null) {
            typeFilterListAdapter = new FilterWorkOrderListAdapter(R.layout.view_item_workorder_with_checkbox, this, FilterWorkOrderListType.Type);
        }
        setTypeFilterListInAdapter(typeFilterList);
    }

    /**
     * Sets adapter on type recycler view
     */
    public FilterWorkOrderListAdapter getTypeListAdapter() {
        return typeFilterListAdapter;
    }

    /**
     * Sets adapter on priority recycler view
     */
    public FilterWorkOrderListAdapter getPriorityListAdapter() {
        return priorityListAdapter;
    }

    /**
     * Sets adapter on assigned to recycler view
     */
    public FilterWorkOrderListAdapter getAssignedToListAdapter() {
        return assignedToListAdapter;
    }

    /**
     * Sets adapter on author recycler view
     */
    public FilterWorkOrderListAdapter getAuthorListAdapter() {
        return authorListAdapter;
    }

    /**
     * Sets adapter on Department recycler view
     */
    public RecyclerView.Adapter getWorkOrderAdapter() {
        return workOrderAdapter;
    }

    private StringCheckBox getTypeFilterAt(Integer index) {
        if (index != null && typeFilterList.size() > 0 && typeFilterList.get(index) != null) {
            return typeFilterList.get(index);
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
        this.typeFilterListAdapter.setFilterList(filterList);
        this.typeFilterListAdapter.notifyDataSetChanged();
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
    private void setAssignedToFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.assignedToListAdapter.setFilterList(filterList);
        this.assignedToListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes priority adapter on data fetched or changed
     */
    private void setAuthorFilterListInAdapter(ArrayList<StringCheckBox> filterList) {
        this.authorListAdapter.setFilterList(filterList);
        this.authorListAdapter.notifyDataSetChanged();
    }

    /**
     * refreshes AllCheckList adapter on data fetched or changed
     */
    public void setWorkOrderInAdapter(PagedList<WorkOrderItems> allChecklistItems) {
        if (allChecklistItems.size() == 0)
            isChecklistEmpty.set(true);
        else
            isChecklistEmpty.set(false);
        workOrderAdapter.submitList(allChecklistItems);
    }

    public StringCheckBox detectFilterList(FilterWorkOrderListType filterListType, int index) {
        if (filterListType.equals(FilterWorkOrderListType.Type))
            return getTypeFilterAt(index);
        else if (filterListType.equals(FilterWorkOrderListType.Priority))
            return getPriorityFilterAt(index);
        else if (filterListType.equals(FilterWorkOrderListType.Author))
            return getAuthorFilterAt(index);
        else
            return getAssignedToFilterAt(index);
    }

    /*Filter fragment click events*/
    public void detectAndPerformFilterClick(FilterWorkOrderListType filterListType, int index) {
        if (filterListType.equals(FilterWorkOrderListType.Type))
            onTypeCheckClick(index);
        else if (filterListType.equals(FilterWorkOrderListType.Priority))
            onPriorityCheckClick(index);
        else if (filterListType.equals(FilterWorkOrderListType.AssignedTo))
            onAssignedToCheckClick(index);
        else if (filterListType.equals(FilterWorkOrderListType.Author))
            onAuthorCheckClick(index);

    }

    /**
     * Called when type list checkbox is clicked
     *
     * @param index clicked index
     */
    private void onTypeCheckClick(Integer index) {
        if (typeFilterList.size() == 0)
            return;
        if(index == -1){
            for (StringCheckBox item : typeFilterList)
                item.setSelected(false);
        }else {
            typeFilterList.get(index).setSelected(!typeFilterList.get(index).isSelected);
        }
        typeFilterListAdapter.setItemChecked(typeFilterList);
    }

    /**
     * gets selected checklist from database
     *
     * @param offset required for pagination
     */
    public void getWorkOrder(int offset, String keyword) {
        setIsLoading(true);
        arrayWorkorderLiveData = workorderRepository.getWorkOrders(config, sortWorkOrderBy.getTag(), typeFilterList, priorityFilterList, assignedToFilterList, searchKeyword, authorFilterList);
        //arrayWorkorderLiveData = new MediatorLiveData<>();
        getNavigator().onStartObserving();
    }

    /**
     * Called when priority list checkbox is clicked
     *
     * @param index clicked index
     */
    private void onPriorityCheckClick(Integer index) {
        if (priorityFilterList.size() == 0)
            return;
        if(index == -1){
            for (StringCheckBox item : priorityFilterList)
                item.setSelected(false);
        }else {
            priorityFilterList.get(index).setSelected(!priorityFilterList.get(index).isSelected);
        }
        priorityListAdapter.setItemChecked(priorityFilterList);
    }

    /**
     * Called when department list checkbox is clicked
     *
     * @param index clicked index
     */
    private void onAssignedToCheckClick(Integer index) {
        if (assignedToFilterList.size() == 0)
            return;
        if(index == -1){
            for (StringCheckBox item : assignedToFilterList)
                item.setSelected(false);
        }else {
            assignedToFilterList.get(index).setSelected(!assignedToFilterList.get(index).isSelected);
        }
        assignedToListAdapter.setItemChecked(assignedToFilterList);
    }

    /**
     * Called when department list checkbox is clicked
     *
     * @param index clicked index
     */
    private void onAuthorCheckClick(Integer index) {
        if (authorFilterList.size() == 0)
            return;
        if(index == -1){
            for (StringCheckBox item : authorFilterList)
                item.setSelected(false);
        }else {
            authorFilterList.get(index).setSelected(!authorFilterList.get(index).isSelected);
        }
        authorListAdapter.setItemChecked(authorFilterList);
    }

    /**
     * Called when Workorder list checkbox is clicked
     *
     * @param item clicked item
     */
    public void onWorkorderItemClick(WorkOrderItems item) {
       // getNavigator().onWorkorderClick(item);
    }

    /**
     * Called when cancel button on filter fragment is clicked
     */
    public void onClearFilter() {
        onPriorityCheckClick(-1);
        onTypeCheckClick(-1);
        onAssignedToCheckClick(-1);
        onAuthorCheckClick(-1);
        setSearchKeyword("");
    }


    /**
     * Called when checklist is changed and filters are refreshed
     */
    public void clearFilters() {
        sortFilterList.clear();
        priorityFilterList.clear();
        assignedToFilterList.clear();
        authorFilterList.clear();
        sortWorkOrderBy = new SortChecklistBy(getApplication().getResources().getString(R.string.due_date_desc), SortingTag.DUE_DATE_DESC);
        initlizeFilterList();
    }

    public void clearWorkOrder() {
        workOrderAdapter.submitList(null);
    }

    public void onAddClick() {
        getNavigator().onCreateWorkOrder();
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }
}
