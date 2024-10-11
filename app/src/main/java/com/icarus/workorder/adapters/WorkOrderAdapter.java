package com.icarus.workorder.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.viewmodels.DashboardViewModel;
import com.icarus.workorder.models.WorkOrderItems;

import androidx.paging.PagedListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Anurag Purwar on 17/1/19.
 */
public class WorkOrderAdapter extends PagedListAdapter<WorkOrderItems, WorkOrderAdapter.GenericViewHolder> {
    private DashboardViewModel dashboardViewModel;

    public WorkOrderAdapter(DashboardViewModel viewModel) {
        super(DIFF_CALLBACK);
        dashboardViewModel = viewModel;
    }

    @NonNull
    public WorkOrderAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_workorder, parent, false);

        return new WorkOrderAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkOrderAdapter.GenericViewHolder holder, int position) {
        holder.bind(getChecklist(position), dashboardViewModel);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public WorkOrderItems getChecklist(int position) {
        return getItem(position);
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(WorkOrderItems items, DashboardViewModel dashboardViewModel) {
            binding.setVariable(BR.item, items);
            binding.setVariable(BR.viewModel, dashboardViewModel);
            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<WorkOrderItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<WorkOrderItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull WorkOrderItems oldItem, @NonNull WorkOrderItems newItem) {
                    return oldItem.getWorkorderId().equals(newItem.getWorkorderId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull WorkOrderItems oldItem, @NonNull WorkOrderItems newItem) {
                    return oldItem.getWorkorderId().equals(newItem.getWorkorderId()) && oldItem.getStatus().equalsIgnoreCase(newItem.getStatus());
                }
            };
}
