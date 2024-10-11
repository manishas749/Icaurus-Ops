package com.icarus.workorder.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.models.StringCheckBox;
import com.icarus.workorder.enums.FilterWorkOrderListType;
import com.icarus.workorder.viewmodels.WorkOrderViewModel;

import java.util.ArrayList;

/**
 * Created by Anurag Purwar on 17/1/19.
 */

public class FilterWorkOrderListAdapter extends RecyclerView.Adapter<FilterWorkOrderListAdapter.GenericViewHolder> {

    private int layoutId;
    private ArrayList<StringCheckBox> filterList;
    private WorkOrderViewModel viewModel;
    private FilterWorkOrderListType typeList;

    public FilterWorkOrderListAdapter(@LayoutRes int layoutId, WorkOrderViewModel viewModel, FilterWorkOrderListType typeList) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
        this.typeList = typeList;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return filterList == null ? 0 : filterList.size();
    }

    @NonNull
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setFilterList(ArrayList<StringCheckBox> list) {
        this.filterList = list;
    }

    /**
     * Saves selected filter in filter list
     */
    public void setItemChecked(ArrayList<StringCheckBox> filterList) {
        this.filterList = filterList;
        notifyDataSetChanged();
    }

    /**
     * Returns selected index when filter is applied
     */
    public int getCheckItemIndex() {
        int selectedIndex = -1;
        for (int i = 0; i < filterList.size(); i++)
            if (filterList.get(i).isSelected())
                selectedIndex = i;
        return selectedIndex;
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(WorkOrderViewModel viewModel, Integer position) {
            binding.setVariable(BR.filterListType, typeList);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }
}

