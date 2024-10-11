package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.CancelledCompletedChecklistItems;
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

public class CancelledCompletedChecklistAdapter extends PagedListAdapter<CancelledCompletedChecklistItems, CancelledCompletedChecklistAdapter.GenericViewHolder>  {

    private DashboardViewModel dashboardViewModel;

    public CancelledCompletedChecklistAdapter(DashboardViewModel viewModel) {
        super(DIFF_CALLBACK);
        dashboardViewModel = viewModel;
    }

    @NonNull
    public CancelledCompletedChecklistAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_cancelled_completed, parent, false);

        return new CancelledCompletedChecklistAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CancelledCompletedChecklistAdapter.GenericViewHolder holder, int position) {
        holder.bind(getChecklist(position));
    }

    public CancelledCompletedChecklistItems getChecklist(int position) {
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

        void bind(CancelledCompletedChecklistItems items) {
            binding.setVariable(BR.item, items);
            binding.setVariable(BR.viewModel, dashboardViewModel);
            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<CancelledCompletedChecklistItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<CancelledCompletedChecklistItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull CancelledCompletedChecklistItems oldItem, @NonNull CancelledCompletedChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull CancelledCompletedChecklistItems oldItem, @NonNull CancelledCompletedChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId())
                            && ((oldItem.getModified()!=null && oldItem.getModified().equalsIgnoreCase(newItem.getModified())) || oldItem.getSynced() != newItem.getSynced())
                            && oldItem.getChecklistSyncStatus().equals(newItem.getChecklistSyncStatus());
                }
            };

}


