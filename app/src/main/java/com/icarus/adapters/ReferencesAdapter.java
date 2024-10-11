package com.icarus.adapters;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemReferenceResourceTitleBinding;
import com.icarus.entities.ResourceEntity;
import com.icarus.navigators.ChecklistExecutionNavigator;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Monika Rana on 1/29/2019.
 */

public class ReferencesAdapter extends RecyclerView.Adapter<ReferencesAdapter.GenericViewHolder> {
    private List<ResourceEntity> mReferenceList;
    private Context mContext;
    private ChecklistExecutionNavigator navigator;

    public ReferencesAdapter(Context context, List<ResourceEntity> referenceList, ChecklistExecutionNavigator navigator) {
        mReferenceList = referenceList;
        mContext = context;
        this.navigator = navigator;
    }

    @Override
    public int getItemCount() {
        return mReferenceList.size();
    }

    @NonNull
    public ReferencesAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemReferenceResourceTitleBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_reference_resource_title, parent, false);
        return new ReferencesAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReferencesAdapter.GenericViewHolder holder, int position) {
        holder.bind(mReferenceList.get(position).getDisplayFileName(), mReferenceList.get(position).getFileName(), mReferenceList.get(position).getIsDownloaded(), position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemReferenceResourceTitleBinding binding;

        GenericViewHolder(ItemReferenceResourceTitleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String name, String fileName, Integer isDownloaded, final Integer position) {
            binding.setVariable(BR.name, name);
            binding.setVariable(BR.downloadPath, fileName);
            binding.setVariable(BR.isDownloaded, isDownloaded);
            binding.executePendingBindings();

            binding.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigator.openReferenceFile(mReferenceList.get(position));
                }
            });
        }

    }
}



