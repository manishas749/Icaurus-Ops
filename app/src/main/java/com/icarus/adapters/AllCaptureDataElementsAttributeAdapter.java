package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemAllCaptureDataAttributesBinding;
import com.icarus.databinding.ItemAllCaptureDataAttributesShimmerBinding;
import com.icarus.enums.AttributeType;
import com.icarus.models.ElementAttributesItems;
import com.icarus.viewmodels.AllCaptureDataViewModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Monika Rana on 08/10/2019
 * Shows the attribute for elements
 */
public class AllCaptureDataElementsAttributeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LinkedHashMap<Integer, List<ElementAttributesItems>> item;
    private int listSize = 0;
    private static final int VIEW_TYPE_HOLDER = 1;
    private static final int VIEW_TYPE_SHIMMER = 2;
    private List<Integer> capturedDateList = new ArrayList<>();
    private AllCaptureDataViewModel viewModel;

    AllCaptureDataElementsAttributeAdapter(LinkedHashMap<Integer, List<ElementAttributesItems>> item, int size, AllCaptureDataViewModel allCaptureDataViewModel) {
        this.item = item;
        listSize = size;
        viewModel = allCaptureDataViewModel;
        //Calculates the size for inner list with different date
        if (item != null) {
            for (Map.Entry<Integer, List<ElementAttributesItems>> mapEntryDates : item.entrySet()) {
                capturedDateList.add(mapEntryDates.getKey());
            }
            listSize = capturedDateList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (item == null || item.size() == 0)
            return VIEW_TYPE_SHIMMER;
        else
            return VIEW_TYPE_HOLDER;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case VIEW_TYPE_HOLDER:
                ItemAllCaptureDataAttributesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_capture_data_attributes, parent, false);
                return new AllCaptureDataElementsAttributeAdapter.ViewHolder(binding);
            case VIEW_TYPE_SHIMMER:
                ItemAllCaptureDataAttributesShimmerBinding bindItem = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_capture_data_attributes_shimmer, parent, false);
                return new AllCaptureDataElementsAttributeAdapter.ViewHolderShimmer(bindItem);
            default:
                ItemAllCaptureDataAttributesShimmerBinding bindDefault = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_capture_data_attributes_shimmer, parent, false);
                return new AllCaptureDataElementsAttributeAdapter.ViewHolderShimmer(bindDefault);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case VIEW_TYPE_HOLDER:
                if (item != null && capturedDateList.size() > position && item.get(capturedDateList.get(position)) != null &&
                        item.containsKey(capturedDateList.get(position)) &&
                        item.get(capturedDateList.get(position)).size() > 0) {
                    AllCaptureDataElementsAttributeAdapter.ViewHolder holderImage = (AllCaptureDataElementsAttributeAdapter.ViewHolder) viewHolder;
                    holderImage.bind(item.get(capturedDateList.get(position)), position);
                }
                break;
            case VIEW_TYPE_SHIMMER:
                AllCaptureDataElementsAttributeAdapter.ViewHolderShimmer holderItem = (AllCaptureDataElementsAttributeAdapter.ViewHolderShimmer) viewHolder;
                holderItem.bind();
                break;
        }

    }


    @Override
    public int getItemCount() {
        return listSize;
    }

    public void setItem(LinkedHashMap<Integer, List<ElementAttributesItems>> list) {
        this.item = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ItemAllCaptureDataAttributesBinding binding;

        ViewHolder(ItemAllCaptureDataAttributesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(List<ElementAttributesItems> items, int position) {
            binding.setVariable(BR.item, items.get(0));
            binding.setVariable(BR.position, position);

            if (items.get(0).getType().equalsIgnoreCase(AttributeType.QR.toString())) {
                AllCaptureDataAttributesQRAdapter allCaptureDataAttributesQRAdapter = new AllCaptureDataAttributesQRAdapter(items);
                binding.setQrAttributesAdapter(allCaptureDataAttributesQRAdapter);
            }else if (items.get(0).getType().equalsIgnoreCase(AttributeType.FILE.toString())) {
                AllCaptureDataAttributesFileAdapter allCaptureDataAttributesFileAdapter = new AllCaptureDataAttributesFileAdapter(items, viewModel);
                binding.setFileAdapter(allCaptureDataAttributesFileAdapter);
            }

            binding.executePendingBindings();

        }
    }

    class ViewHolderShimmer extends RecyclerView.ViewHolder {
        final ItemAllCaptureDataAttributesShimmerBinding binding;

        ViewHolderShimmer(ItemAllCaptureDataAttributesShimmerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind() {
            binding.shimmerContainer.startShimmer();
        }
    }
}
