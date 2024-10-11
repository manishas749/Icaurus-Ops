package com.icarus.workorder.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.viewmodels.WorkOrderDetailViewModel;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Anurag Purwar on 1/2/19.
 */
public class WorkOrderAttachmentAdapter extends RecyclerView.Adapter<WorkOrderAttachmentAdapter.GenericViewHolder> {
    private List<WorkOrderAttachmentItems> item;
    private WorkOrderDetailViewModel mViewModel;

    public WorkOrderAttachmentAdapter(WorkOrderDetailViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    public WorkOrderAttachmentAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_workorder_attachment, parent, false);

        return new WorkOrderAttachmentAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkOrderAttachmentAdapter.GenericViewHolder holder, int position) {
        holder.bind(item.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return item == null ? 0 : item.size();
    }

    public void setItem(List<WorkOrderAttachmentItems> list) {
        this.item = list;
        notifyDataSetChanged();
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(WorkOrderAttachmentItems item) {
            binding.setVariable(BR.workOrderAttachmentItem, item);
            binding.setVariable(BR.viewModel, mViewModel);
            binding.executePendingBindings();
        }
    }
}
