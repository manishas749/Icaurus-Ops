package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.AttachmentItems;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Anurag Purwar on 8/2/19.
 */
public class AttachmentAdapter extends RecyclerView.Adapter<AttachmentAdapter.GenericViewHolder> {
    private List<AttachmentItems> item;

    @NonNull
    public AttachmentAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_attachment, parent, false);

        return new AttachmentAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AttachmentAdapter.GenericViewHolder holder, int position) {
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

    public void setItem(List<AttachmentItems> list) {
        this.item = list;
        notifyDataSetChanged();
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(AttachmentItems items) {
            binding.setVariable(BR.item, items);
            binding.executePendingBindings();
        }
    }
}
