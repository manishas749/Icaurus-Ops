package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemAllCapturedDataFilesBinding;
import com.icarus.models.ElementAttributesItems;
import com.icarus.viewmodels.AllCaptureDataViewModel;

import java.util.List;

/**
 * Created by Monika Rana on 10/10/2019
 * Shows the captured files for data captured
 */

public class AllCaptureDataAttributesFileAdapter extends RecyclerView.Adapter<AllCaptureDataAttributesFileAdapter.GenericViewHolder> {
    private List<ElementAttributesItems> elementAttributesItems;
    private AllCaptureDataViewModel viewModel;

    AllCaptureDataAttributesFileAdapter(List<ElementAttributesItems> elementAttributesItems, AllCaptureDataViewModel allCaptureDataViewModel) {
        this.elementAttributesItems = elementAttributesItems;
        viewModel = allCaptureDataViewModel;
    }

    @NonNull
    public AllCaptureDataAttributesFileAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAllCapturedDataFilesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_captured_data_files, parent, false);
        return new AllCaptureDataAttributesFileAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCaptureDataAttributesFileAdapter.GenericViewHolder holder, int position) {
        holder.bind(elementAttributesItems.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return elementAttributesItems == null ? 0 : elementAttributesItems.size();
    }


    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemAllCapturedDataFilesBinding binding;

        GenericViewHolder(ItemAllCapturedDataFilesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final ElementAttributesItems items) {
            binding.setVariable(BR.item, items);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();

        }
    }
}
