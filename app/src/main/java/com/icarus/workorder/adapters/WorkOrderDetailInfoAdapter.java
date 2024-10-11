package com.icarus.workorder.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.workorder.models.WorkOrderInfoItems;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Anurag Purwar on 30/1/19.
 */
public class WorkOrderDetailInfoAdapter extends RecyclerView.Adapter<WorkOrderDetailInfoAdapter.GenericViewHolder> {
    private List<WorkOrderInfoItems> item;

    @NonNull
    public WorkOrderDetailInfoAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_workorder_detail_info, parent, false);

        return new WorkOrderDetailInfoAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkOrderDetailInfoAdapter.GenericViewHolder holder, int position) {
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

    public void setItem(List<WorkOrderInfoItems> list) {
        this.item = list;
        notifyDataSetChanged();
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(WorkOrderInfoItems items) {
            binding.setVariable(BR.item, items);
            binding.executePendingBindings();
        }

    }
}
