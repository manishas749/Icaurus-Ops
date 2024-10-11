package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.R;
import com.icarus.BR;
import com.icarus.databinding.ItemFileRequiredBinding;
import com.icarus.models.SelectedFile;
import com.icarus.viewmodels.ChecklistExecutionViewModel;

import java.util.ArrayList;

/**
 * Created by Monika Rana on 2/13/2019.
 */

public class FileRequiredAdapter extends RecyclerView.Adapter<FileRequiredAdapter.GenericViewHolder> {
    private ArrayList<SelectedFile> itemList = new ArrayList<>();
    private ChecklistExecutionViewModel mViewModel;
    private ArrayList<SelectedFile> deletedItemList = new ArrayList<>();

    public FileRequiredAdapter(ChecklistExecutionViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    public FileRequiredAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFileRequiredBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_file_required, parent, false);
        return new FileRequiredAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FileRequiredAdapter.GenericViewHolder holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public void setItem(SelectedFile selectedFile) {
        this.itemList.add(0, selectedFile);
        notifyDataSetChanged();
    }

    public void setSingleItem(SelectedFile selectedFile) {
        if (this.itemList.size() > 0) {
            setDeleteFile(itemList.get(0));
            this.itemList.set(0, selectedFile);
        } else
            this.itemList.add(0, selectedFile);
        notifyDataSetChanged();
    }

    public ArrayList<SelectedFile> getItems() {
        return itemList;
    }

    public void setDeleteFile(SelectedFile file) {
        if (deletedItemList == null)
            deletedItemList = new ArrayList<>();
        deletedItemList.add(file);
    }


    public ArrayList<SelectedFile> getDeletedFileList() {
        return deletedItemList;
    }

    public void clearList() {
        itemList.clear();
    }

    public void removeItem(SelectedFile selectedFile) {
        if (itemList.contains(selectedFile))
            itemList.remove(selectedFile);
        notifyDataSetChanged();
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemFileRequiredBinding binding;

        GenericViewHolder(ItemFileRequiredBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final SelectedFile selectedFile) {
            binding.setVariable(BR.name, selectedFile.getDisplayName());
            binding.setVariable(BR.viewModel, mViewModel);
            binding.setVariable(BR.selectedFile, selectedFile);
            binding.setVariable(BR.adapter, FileRequiredAdapter.this);
            binding.executePendingBindings();

        }
    }
}
