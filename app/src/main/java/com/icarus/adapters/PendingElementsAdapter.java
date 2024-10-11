package com.icarus.adapters;

import androidx.paging.PagedListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.viewmodels.ChecklistDetailViewModel;

public class PendingElementsAdapter extends PagedListAdapter<ChecklistDetailItems, PendingElementsAdapter.DataViewHolder> {
    private ChecklistDetailViewModel viewModel;

    public PendingElementsAdapter(ChecklistDetailViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public PendingElementsAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_pending_elements, parent, false);
        return new PendingElementsAdapter.DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingElementsAdapter.DataViewHolder holder, int position) {
        holder.setViewModel(position, getChecklist(position), viewModel);
    }

    public ChecklistDetailItems getChecklist(int position) {
        return getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    static class DataViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        DataViewHolder(ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        void setViewModel(int position, ChecklistDetailItems checklistDetailItems, ChecklistDetailViewModel viewModel) {
            binding.setVariable(BR.item, checklistDetailItems);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }
    }

    private static final DiffUtil.ItemCallback<ChecklistDetailItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ChecklistDetailItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull ChecklistDetailItems oldItem, @NonNull ChecklistDetailItems newItem) {
                    return oldItem.getItemId() == newItem.getItemId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull ChecklistDetailItems oldItem, @NonNull ChecklistDetailItems newItem) {
                    return  oldItem.getItemId() == newItem.getItemId() && (newItem.getStatus() != null
                            && oldItem.getStatus() .equals (newItem.getStatus()) || (newItem.getAcknowledged() != null
                            && oldItem.getAcknowledged() .equals (newItem.getAcknowledged())) || (newItem.getImageTextStatus() != null
                            && oldItem.getImageTextStatus() .equals (newItem.getImageTextStatus())) || (newItem.getDecisionStatus() != null
                            && oldItem.getDecisionStatus() .equals (newItem.getDecisionStatus())));
                }
            };
}