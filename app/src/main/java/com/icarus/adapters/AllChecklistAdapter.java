package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.AllChecklistItems;
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

public class AllChecklistAdapter extends PagedListAdapter<AllChecklistItems, AllChecklistAdapter.GenericViewHolder> {

  //  private List<AllChecklistItems> checklistItemsList;
    private DashboardViewModel dashboardViewModel;

    public AllChecklistAdapter(DashboardViewModel viewModel) {
        super(DIFF_CALLBACK);
        //  this.checklistItemsList = checklistItemsList;
        dashboardViewModel = viewModel;
    }

    @NonNull
    public AllChecklistAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_checklist, parent, false);

        return new AllChecklistAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllChecklistAdapter.GenericViewHolder holder, int position) {
        holder.bind(getChecklist(position), dashboardViewModel,position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public AllChecklistItems getChecklist(int position) {
        return getItem(position);
    }

    /*public void setCheckList(List<AllChecklistItems> list, int offset) {
        if (checklistItemsList != null) {
            //Filters are refreshed offset is 0
            if (offset == 0)
                this.checklistItemsList.clear();
            this.checklistItemsList.addAll(list);
        } else
            this.checklistItemsList = list;
    }

    public List<AllChecklistItems> getListItems() {
        return checklistItemsList;
    }*/

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(AllChecklistItems items, DashboardViewModel dashboardViewModel,Integer position) {
            binding.setVariable(BR.items, items);
            binding.setVariable(BR.viewModel, dashboardViewModel);
            binding.setVariable(BR.position,position);
            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<AllChecklistItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<AllChecklistItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull AllChecklistItems oldItem, @NonNull AllChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull AllChecklistItems oldItem, @NonNull AllChecklistItems newItem) {
                    return oldItem.getChecklistId().equals(newItem.getChecklistId())
                            && oldItem.isFavorite().equals(newItem.isFavorite())
                            && oldItem.getChecklistSyncStatus().equals(newItem.getChecklistSyncStatus());
                }
            };

}


