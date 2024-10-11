package com.icarus.workorder.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.workorder.models.WorkOrderNoteInfoItems;
import com.icarus.workorder.viewmodels.WorkOrderDetailViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Anurag Purwar on 31/1/19.
 */
public class WorkOrderNoteInfoAdapter extends RecyclerView.Adapter<WorkOrderNoteInfoAdapter.GenericViewHolder> {
    private List<WorkOrderNoteInfoItems> item;
    private WorkOrderDetailViewModel mViewModel;

    public WorkOrderNoteInfoAdapter(WorkOrderDetailViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    public WorkOrderNoteInfoAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_workorder_note_info, parent, false);

        return new WorkOrderNoteInfoAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkOrderNoteInfoAdapter.GenericViewHolder holder, int position) {
        holder.bind(item.get(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return item == null ? 0 : item.size();
    }

    public void setItem(List<WorkOrderNoteInfoItems> list) {
        this.item = list;
        notifyDataSetChanged();
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(WorkOrderNoteInfoItems items, int position) {
            binding.setVariable(BR.item, items);
            binding.setVariable(BR.position, position);
            binding.setVariable(BR.viewModel, mViewModel);
            binding.executePendingBindings();
        }

    }
}
