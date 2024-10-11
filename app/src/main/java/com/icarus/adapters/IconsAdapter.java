package com.icarus.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemIconsBinding;
import com.icarus.databinding.ItemViewMoreBinding;
import com.icarus.databinding.PopupListBinding;

import java.util.List;

public class IconsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mIconsList;
    private int mSize = 0, mTitleId;
    private String mFolderName;
    private Context mContext;
    private static final int VIEW_TYPE_IMAGE = 1;
    private static final int VIEW_TYPE_MORE = 3;
    private String mItemUUID;

    public IconsAdapter(Context context, List<String> iconsList, int size, String folderName, int titleId, String itemUUID) {
        mIconsList = iconsList;
        mSize = size;
        mFolderName = folderName;
        mContext = context;
        mTitleId = titleId;
        mItemUUID = itemUUID;
    }

    @Override
    public int getItemCount() {
        return mIconsList.size();
    }

    @Override
    public int getItemViewType(int position) {
            return VIEW_TYPE_IMAGE;
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case VIEW_TYPE_IMAGE:
                ItemIconsBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_icons, parent, false);
                return new IconsAdapter.ViewHolderImage(binding);
            case VIEW_TYPE_MORE:
                ItemViewMoreBinding bindViewMore = DataBindingUtil.inflate(layoutInflater, R.layout.item_view_more, parent, false);
                return new IconsAdapter.ViewHolderViewMore(bindViewMore);
            default:
                ItemIconsBinding bindingImage = DataBindingUtil.inflate(layoutInflater, R.layout.item_icons, parent, false);
                return new IconsAdapter.ViewHolderImage(bindingImage);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_IMAGE:
                ViewHolderImage holderImage = (ViewHolderImage) holder;
                holderImage.bindImage(mIconsList.get(position));
                break;
            case VIEW_TYPE_MORE:
                ViewHolderViewMore holderViewMore = (ViewHolderViewMore) holder;
                holderViewMore.bind();
                holderViewMore.setViewMore();
                break;
            default:
                ViewHolderImage defaultHolder = (ViewHolderImage) holder;
                defaultHolder.bindImage(mIconsList.get(position));
                break;
        }

    }


    class ViewHolderImage extends RecyclerView.ViewHolder {
        final ItemIconsBinding binding;

        ViewHolderImage(ItemIconsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindImage(String imgPath) {
            binding.setVariable(BR.fileName, imgPath);
            binding.setVariable(BR.folderName, mFolderName);
            binding.setVariable(BR.itemUUID, mItemUUID);
            binding.executePendingBindings();

            binding.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopUp(mContext, mTitleId, new IconsAdapter(mContext, mIconsList, mIconsList.size(), mFolderName, mTitleId, mItemUUID));
                }
            });
        }
    }


    class ViewHolderViewMore extends RecyclerView.ViewHolder {
        final ItemViewMoreBinding binding;

        ViewHolderViewMore(@NonNull ItemViewMoreBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind() {
            binding.setVariable(BR.count, String.valueOf(mIconsList.size() - 3));
            binding.executePendingBindings();
        }

        void setViewMore() {
            binding.txtViewMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopUp(mContext, mTitleId, new IconsAdapter(mContext, mIconsList, mIconsList.size(), mFolderName, mTitleId, mItemUUID));
                }
            });
        }
    }

    private void showPopUp(final Context context, int title, RecyclerView.Adapter<?> adapter) {
        //Inflate the dialog with custom view
        PopupListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.popup_list, null, false);
        //AlertDialogBuilder
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context)
                .setView(binding.getRoot())
                .setPositiveButton(context.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        mBuilder.setCancelable(false);
        binding.recyclerViewImages.setLayoutManager(new GridLayoutManager(context, 6));
        binding.recyclerViewImages.setAdapter(adapter);
        binding.tvTitle.setText(title);
        binding.tvDesc.setVisibility(View.GONE);
        final AlertDialog mAlertDialog = mBuilder.create();
        mAlertDialog.show();
    }

}



