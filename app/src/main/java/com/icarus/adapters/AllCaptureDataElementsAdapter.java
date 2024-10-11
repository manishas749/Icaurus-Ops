package com.icarus.adapters;

import androidx.paging.PagedListAdapter;
import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemAllCaptureDataElementsWithAttributesBinding;
import com.icarus.models.ElementWithCaptureDataItems;
import com.icarus.viewmodels.AllCaptureDataViewModel;

/**
 * Created by Monika Rana on 07/10/2019
 * Shows elements with attributes on captured data
 */
public class AllCaptureDataElementsAdapter extends PagedListAdapter<ElementWithCaptureDataItems, AllCaptureDataElementsAdapter.DataViewHolder> {
    private AllCaptureDataViewModel viewModel;
    private Context mActivity;

    public AllCaptureDataElementsAdapter(AllCaptureDataViewModel viewModel, Context activity) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
        mActivity = activity;
    }

    @NonNull
    @Override
    public AllCaptureDataElementsAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAllCaptureDataElementsWithAttributesBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_all_capture_data_elements_with_attributes, parent, false);
        return new AllCaptureDataElementsAdapter.DataViewHolder(binding, mActivity);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCaptureDataElementsAdapter.DataViewHolder holder, int position) {
        holder.setViewModel(position, getChecklist(position), viewModel);
    }

    public ElementWithCaptureDataItems getChecklist(int position) {
        return getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    static class DataViewHolder extends RecyclerView.ViewHolder {
        ItemAllCaptureDataElementsWithAttributesBinding binding;
        Context mActivity;

        DataViewHolder(ItemAllCaptureDataElementsWithAttributesBinding itemView, Context activity) {
            super(itemView.getRoot());
            this.binding = itemView;
            mActivity = activity;
        }

        void setViewModel(int position, ElementWithCaptureDataItems elementWithCaptureDataItems, AllCaptureDataViewModel viewModel) {
            binding.setVariable(BR.item, elementWithCaptureDataItems);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);


            if (elementWithCaptureDataItems == null)
                return;
            //Sets adapter on attributes and notifies if already set
             if (binding.rvAttributes.getAdapter() == null) {
                final AllCaptureDataElementsAttributeAdapter allCaptureDataElementsAttributeAdapter = new AllCaptureDataElementsAttributeAdapter(elementWithCaptureDataItems.getElementAttributesItemsList(), elementWithCaptureDataItems.getAttributesCount(), viewModel);
                binding.rvAttributes.setLayoutManager(new LinearLayoutManager(mActivity));
                binding.rvAttributes.setAdapter(allCaptureDataElementsAttributeAdapter);
            } else {
                AllCaptureDataElementsAttributeAdapter allCaptureDataElementsAttributeAdapter = (AllCaptureDataElementsAttributeAdapter) binding.rvAttributes.getAdapter();
                allCaptureDataElementsAttributeAdapter.setItem(elementWithCaptureDataItems.getElementAttributesItemsList());
                allCaptureDataElementsAttributeAdapter.notifyDataSetChanged();
            }

            //Calls query to get attributes if not fetched
            if (elementWithCaptureDataItems.getElementAttributesItemsList() == null) {
                viewModel.getElementsAttributeList(viewModel.getChecklistUUID(), elementWithCaptureDataItems.getChecklistElementId(), position);
                binding.rvAttributes.setVisibility(View.GONE);
            }else
                binding.rvAttributes.setVisibility(View.VISIBLE);

            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<ElementWithCaptureDataItems> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ElementWithCaptureDataItems>() {
                @Override
                public boolean areItemsTheSame(@NonNull ElementWithCaptureDataItems oldItem, @NonNull ElementWithCaptureDataItems newItem) {
                    return oldItem.getSequenceNo().equals(newItem.getSequenceNo());
                }

                @Override
                public boolean areContentsTheSame(@NonNull ElementWithCaptureDataItems oldItem, @NonNull ElementWithCaptureDataItems newItem) {
                    return oldItem.getSequenceNo().equals(newItem.getSequenceNo());
                }
            };
}