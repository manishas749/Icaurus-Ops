package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icarus.R;
import com.icarus.databinding.ItemQrScanAttributeDetailBinding;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.navigators.QRCodeScanNavigator;

import java.util.List;

/**
 * Created by Monika Rana on 13/05/2020
 */
public class QRScanAttributeDetailItemsAdapter extends RecyclerView.Adapter<QRScanAttributeDetailItemsAdapter.GenericViewHolder> {

    private List<QRAttributeScanItem> qrAttributeScanItems;
    private QRCodeScanNavigator qrCodeScanNavigator;

    public QRScanAttributeDetailItemsAdapter(List<QRAttributeScanItem> items,
                                             QRCodeScanNavigator qrCodeScanNavigator) {
        qrAttributeScanItems = items;
        this.qrCodeScanNavigator = qrCodeScanNavigator;
    }

    @Override
    public int getItemCount() {
        return qrAttributeScanItems == null ? 0 : qrAttributeScanItems.size();
    }

    @NonNull
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemQrScanAttributeDetailBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_qr_scan_attribute_detail, parent, false);
        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(qrAttributeScanItems.get(position), position);
        holder.binding.executePendingBindings();
    }

    public void setItems(final List<QRAttributeScanItem> items) {
        qrAttributeScanItems = items;
        notifyDataSetChanged();
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemQrScanAttributeDetailBinding binding;

        GenericViewHolder(ItemQrScanAttributeDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final QRAttributeScanItem item, final int position) {
            binding.setQrAttributeItem(item);
            binding.executePendingBindings();

            binding.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qrCodeScanNavigator.onQRItemClick(position);
                }
            });
        }

    }
}


