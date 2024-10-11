package com.icarus.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemChecklistDetailBinding;
import com.icarus.models.ChecklistElementItem;
import com.icarus.viewmodels.ChecklistDetailListingViewModel;

/**
 * Created by Monika Rana on 1/16/2019.
 */

public class ChecklistDetailAdapter extends PagedListAdapter<ChecklistElementItem, ChecklistDetailAdapter.DataViewHolder> {
    private final ChecklistDetailListingViewModel viewModel;

    public ChecklistDetailAdapter(ChecklistDetailListingViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemChecklistDetailBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_checklist_detail, parent, false);
        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.setViewModel(getChecklist(position), viewModel);
    }

    public ChecklistElementItem getChecklist(int position) {
        return getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    static class DataViewHolder extends RecyclerView.ViewHolder {
        ItemChecklistDetailBinding binding;

        DataViewHolder(ItemChecklistDetailBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        void setViewModel(final ChecklistElementItem checklistDetailItems, final ChecklistDetailListingViewModel viewModel) {
            binding.setVariable(BR.item, checklistDetailItems);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, getBindingAdapterPosition());
            binding.executePendingBindings();
            setPPEHazardListVisibility(checklistDetailItems);

           binding.description.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.onChecklistClick(getLayoutPosition(), checklistDetailItems);
                }
            });

            binding.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.onChecklistClick(getLayoutPosition(), checklistDetailItems);
                }
            });
        }

        private void setPPEHazardListVisibility(ChecklistElementItem checklistDetailItems) {
            if (checklistDetailItems != null && checklistDetailItems.getPPEsIconList() != null && checklistDetailItems.getPPEsIconList().size() > 0)
                binding.recyclerIcons.setVisibility(View.VISIBLE);
            else if (checklistDetailItems != null && checklistDetailItems.getHazardsIconList() != null && checklistDetailItems.getHazardsIconList().size() > 0)
                binding.recyclerIcons.setVisibility(View.VISIBLE);
            else
                binding.recyclerIcons.setVisibility(View.GONE);
        }
    }

    private static final DiffUtil.ItemCallback<ChecklistElementItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ChecklistElementItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull ChecklistElementItem oldItem, @NonNull ChecklistElementItem newItem) {
                    return oldItem.getItemId() == newItem.getItemId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull ChecklistElementItem oldItem, @NonNull ChecklistElementItem newItem) {
                    return oldItem.getItemId() == newItem.getItemId()
                            && ((newItem.getStatus() != null && oldItem.getStatus() != null
                            && oldItem.getStatus().equals(newItem.getStatus()))
                            || (newItem.getImageTextStatus() != null && oldItem.getImageTextStatus() != null
                            && oldItem.getImageTextStatus().equals(newItem.getImageTextStatus()))
                    );
                }
            };
}