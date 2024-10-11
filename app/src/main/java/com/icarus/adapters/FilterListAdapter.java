package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.enums.FilterListType;
import com.icarus.models.StringCheckBox;
import com.icarus.viewmodels.DashboardViewModel;

import java.util.ArrayList;

/**
 * Created by Monika Rana on 1/1/2019.
 */

public class FilterListAdapter extends RecyclerView.Adapter<FilterListAdapter.GenericViewHolder> {

    private int layoutId;
    private ArrayList<StringCheckBox> filterList;
    private DashboardViewModel viewModel;
    private FilterListType typeList;

    public FilterListAdapter(@LayoutRes int layoutId, DashboardViewModel viewModel, FilterListType typeList) {
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
        int selectedIndex = 0;
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

        void bind(DashboardViewModel viewModel, Integer position) {
            binding.setVariable(BR.filterListType, typeList);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }
}

