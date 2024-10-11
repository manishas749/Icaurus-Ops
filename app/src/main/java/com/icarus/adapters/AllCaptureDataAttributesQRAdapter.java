package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemAllCaptureDataQrAttributesBinding;
import com.icarus.models.ElementAttributesItems;

import java.util.List;

/**
 * Created by Monika Rana on 17/05/2020
 */
public class AllCaptureDataAttributesQRAdapter extends RecyclerView.Adapter<AllCaptureDataAttributesQRAdapter.GenericViewHolder> {
    private List<ElementAttributesItems> elementAttributesItems;

    AllCaptureDataAttributesQRAdapter(List<ElementAttributesItems> elementAttributesItems) {
        this.elementAttributesItems = elementAttributesItems;
    }

    @NonNull
    public AllCaptureDataAttributesQRAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAllCaptureDataQrAttributesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_capture_data_qr_attributes, parent, false);
        return new AllCaptureDataAttributesQRAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCaptureDataAttributesQRAdapter.GenericViewHolder holder, int position) {
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
        final ItemAllCaptureDataQrAttributesBinding binding;

        GenericViewHolder(ItemAllCaptureDataQrAttributesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final ElementAttributesItems items) {
            binding.setVariable(BR.item, items);
            binding.executePendingBindings();

        }
    }
}
