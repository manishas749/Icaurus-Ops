package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.MyAssignedChecklistItems;
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
 * Created by Monika Rana on 1/3/2019.
 */

public class MyAssignedChecklistAdapter extends PagedListAdapter<MyAssignedChecklistItems, MyAssignedChecklistAdapter.GenericViewHolder> {

    private DashboardViewModel dashboardViewModel;

    public MyAssignedChecklistAdapter(DashboardViewModel viewModel) {
        super(DIFF_CALLBACK);
        dashboardViewModel = viewModel;
    }

    @NonNull
    public MyAssignedChecklistAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_my_assigned, parent, false);

        return new MyAssignedChecklistAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAssignedChecklistAdapter.GenericViewHolder holder, int position) {
        holder.bind(getChecklist(position));
    }

    public MyAssignedChecklistItems getChecklist(int position) {
        return getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MyAssignedChecklistItems items) {
            binding.setVariable(BR.item, items);
            binding.setVariable(BR.viewModel, dashboardViewModel);
            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<MyAssignedChecklistItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MyAssignedChecklistItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull MyAssignedChecklistItems oldItem, @NonNull MyAssignedChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull MyAssignedChecklistItems oldItem, @NonNull MyAssignedChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId())
                            && oldItem.getChecklistStatus()!=null
                            && oldItem.getChecklistStatus().equalsIgnoreCase(newItem.getChecklistStatus())
                            && oldItem.getChecklistSyncStatus().equals(newItem.getChecklistSyncStatus());
                }

            };

}


