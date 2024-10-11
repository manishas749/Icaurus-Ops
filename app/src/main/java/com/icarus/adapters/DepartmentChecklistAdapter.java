package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.DepartmentChecklistItems;
import com.icarus.viewmodels.DashboardViewModel;

import androidx.paging.PagedListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Monika Rana on 1/9/2019.
 */

public class DepartmentChecklistAdapter extends PagedListAdapter<DepartmentChecklistItems, DepartmentChecklistAdapter.GenericViewHolder> {

    private DashboardViewModel mDashboardViewModel;

    public DepartmentChecklistAdapter(DashboardViewModel viewModel) {
        super(DIFF_CALLBACK);
        mDashboardViewModel = viewModel;
    }

    @NonNull
    public DepartmentChecklistAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_department_checklist, parent, false);
        return new DepartmentChecklistAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentChecklistAdapter.GenericViewHolder holder, int position) {
        holder.bind(getChecklist(position), position);
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public DepartmentChecklistItems getChecklist(int position) {
        return getItem(position);
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(DepartmentChecklistItems items, Integer position) {
            binding.setVariable(BR.item, items);
            binding.setVariable(BR.viewModel, mDashboardViewModel);
            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<DepartmentChecklistItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<DepartmentChecklistItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull DepartmentChecklistItems oldItem, @NonNull DepartmentChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull DepartmentChecklistItems oldItem, @NonNull DepartmentChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId())
                            && oldItem.getTitle().equalsIgnoreCase(newItem.getTitle())
                            && oldItem.getChecklistSyncStatus().equals(newItem.getChecklistSyncStatus());
                }
            };
}


