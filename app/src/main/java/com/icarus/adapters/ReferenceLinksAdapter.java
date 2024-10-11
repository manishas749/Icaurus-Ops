package com.icarus.adapters;

import android.content.Context;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemReferenceTitleBinding;
import com.icarus.models.ResourceLinkItems;

import java.util.List;

/**
 * Created by Monika Rana on 1/30/2019.
 */

public class ReferenceLinksAdapter extends RecyclerView.Adapter<ReferenceLinksAdapter.GenericViewHolder> {
    private List<ResourceLinkItems> resourceLinkItems;
    private Context context;

    public ReferenceLinksAdapter(Context context, List<ResourceLinkItems> resourceLinkItems) {
        this.resourceLinkItems = resourceLinkItems;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return resourceLinkItems == null ? 0 : resourceLinkItems.size();
    }

    @NonNull
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemReferenceTitleBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_reference_title, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(String.valueOf(resourceLinkItems.get(position).linkTitle + " (" + resourceLinkItems.get(position).link + ")"), position, resourceLinkItems.get(position).link);
    }


    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemReferenceTitleBinding binding;

        GenericViewHolder(ItemReferenceTitleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String fileName, Integer position, final String link) {
            binding.setVariable(BR.name, fileName);
            binding.setVariable(BR.isDownloaded, 1);
            binding.executePendingBindings();
        }

    }
}

