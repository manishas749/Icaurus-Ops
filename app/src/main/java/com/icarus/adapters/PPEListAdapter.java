package com.icarus.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.constants.Constants;
import com.icarus.databinding.ItemEquipmentImageBinding;
import com.icarus.databinding.ItemEquipmentsBinding;
import com.icarus.databinding.ItemViewMoreBinding;
import com.icarus.models.CheckListPPItems;
import com.icarus.util.DialogUtility;

import java.util.List;

/**
 * Created by Monika Rana on 1/29/2019.
 */

public class PPEListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<CheckListPPItems> mPPEList;
    private int mSize = 0;
    private Context mContext;
    private String mItemUUID;
    private boolean isShowName;
    private static final int VIEW_TYPE_IMAGE = 1;
    private static final int VIEW_TYPE_ITEM = 2;
    private static final int VIEW_TYPE_MORE = 3;

    public PPEListAdapter(Context context, List<CheckListPPItems> ppItems, int size, String itemUUID, boolean isNameShow) {
        mPPEList = ppItems;
        mSize = size;
        mContext = context;
        mItemUUID = itemUUID;
        isShowName = isNameShow;
    }

    @Override
    public int getItemCount() {
        return mSize <= mPPEList.size() ? mSize : mPPEList.size();
    }

    @Override
    public int getItemViewType(int position) {
       if (isShowName)
            return VIEW_TYPE_ITEM;
        else
            return VIEW_TYPE_IMAGE;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case VIEW_TYPE_IMAGE:
                ItemEquipmentImageBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_equipment_image, parent, false);
                return new ViewHolderImage(binding);
            case VIEW_TYPE_ITEM:
                ItemEquipmentsBinding bindItem = DataBindingUtil.inflate(layoutInflater, R.layout.item_equipments, parent, false);
                return new ViewHolderImageName(bindItem);
            case VIEW_TYPE_MORE:
                ItemViewMoreBinding bindViewMore = DataBindingUtil.inflate(layoutInflater, R.layout.item_view_more, parent, false);
                return new ViewHolderViewMore(bindViewMore);
            default:
                ItemEquipmentImageBinding bindingImage = DataBindingUtil.inflate(layoutInflater, R.layout.item_equipment_image, parent, false);
                return new ViewHolderImage(bindingImage);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_IMAGE:
                ViewHolderImage holderImage = (ViewHolderImage) holder;
                holderImage.bindImage(mPPEList.get(position).getIcon());
                break;
            case VIEW_TYPE_ITEM:
                ViewHolderImageName holderItem = (ViewHolderImageName) holder;
                holderItem.bind(mPPEList.get(position).getIcon(), mPPEList.get(position).getLabel(), position);
                break;
            case VIEW_TYPE_MORE:
                ViewHolderViewMore holderViewMore = (ViewHolderViewMore) holder;
                holderViewMore.bind();
                holderViewMore.setViewMore();
                break;
        }

    }


    class ViewHolderImage extends RecyclerView.ViewHolder {
        final ItemEquipmentImageBinding binding;

        ViewHolderImage(ItemEquipmentImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindImage(String imgPath) {
            binding.setVariable(BR.fileName, imgPath);
            binding.setVariable(BR.name, "");
            binding.setVariable(BR.folderName, Constants.RESOURCES_PPE);
            binding.setVariable(BR.itemUUID, mItemUUID);
            binding.executePendingBindings();

            binding.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUtility.showListPopUp(mContext, R.string.ppe_icons, -1, new PPEListAdapter(mContext, mPPEList, mPPEList.size(), mItemUUID, true));
                }
            });
        }


    }

    class ViewHolderImageName extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        public ViewHolderImageName(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String imgPath, String name, Integer position) {
            binding.setVariable(BR.fileName, imgPath);
            binding.setVariable(BR.name, name);
            binding.setVariable(BR.folderName, Constants.RESOURCES_PPE);
            binding.setVariable(BR.itemUUID, mItemUUID);
            binding.executePendingBindings();
        }
    }

    class ViewHolderViewMore extends RecyclerView.ViewHolder {
        final ItemViewMoreBinding binding;

        ViewHolderViewMore(@NonNull ItemViewMoreBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind() {
            binding.setVariable(BR.count, String.valueOf(mPPEList.size() - 3));
            binding.executePendingBindings();
        }

        void setViewMore() {
            binding.txtViewMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUtility.showListPopUp(mContext, R.string.ppe_icons, -1, new PPEListAdapter(mContext, mPPEList, mPPEList.size(), mItemUUID, true));
                }
            });
        }
    }


}


