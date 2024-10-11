package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAllCapturedDataFilesBindingImpl extends ItemAllCapturedDataFilesBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback37;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAllCapturedDataFilesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemAllCapturedDataFilesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            );
        this.imgCaptured.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.txtCapturedBy.setTag(null);
        this.txtCapturedDate.setTag(null);
        this.txtValue.setTag(null);
        setRootTag(root);
        // listeners
        mCallback37 = new com.icarus.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.item == variableId) {
            setItem((com.icarus.models.ElementAttributesItems) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.AllCaptureDataViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.ElementAttributesItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.AllCaptureDataViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int itemIsDownloadedTxtValueAndroidColorCaptureDataTextColorTxtValueAndroidColorCaptureDataClickableColor = 0;
        boolean itemIsDownloaded = false;
        com.icarus.models.ElementAttributesItems item = mItem;
        boolean ItemIsDownloaded1 = false;
        java.lang.String itemCapturedBy = null;
        java.lang.String itemCapturedAt = null;
        java.lang.String stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy = null;
        com.icarus.viewmodels.AllCaptureDataViewModel viewModel = mViewModel;
        int itemIsDownloadedViewGONEViewVISIBLE = 0;
        java.lang.String itemGetFileName = null;
        java.lang.String itemCapturedValue = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (item != null) {
                    // read item.isDownloaded()
                    itemIsDownloaded = item.isDownloaded();
                    // read item.isDownloaded
                    ItemIsDownloaded1 = item.isDownloaded();
                    // read item.capturedBy
                    itemCapturedBy = item.getCapturedBy();
                    // read item.capturedAt
                    itemCapturedAt = item.getCapturedAt();
                    // read item.getFileName()
                    itemGetFileName = item.getFileName();
                    // read item.capturedValue
                    itemCapturedValue = item.getCapturedValue();
                }
            if((dirtyFlags & 0x5L) != 0) {
                if(itemIsDownloaded) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }
            if((dirtyFlags & 0x5L) != 0) {
                if(ItemIsDownloaded1) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read item.isDownloaded() ? View.GONE : View.VISIBLE
                itemIsDownloadedViewGONEViewVISIBLE = ((itemIsDownloaded) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read item.isDownloaded ? @android:color/capture_data_text_color : @android:color/capture_data_clickable_color
                itemIsDownloadedTxtValueAndroidColorCaptureDataTextColorTxtValueAndroidColorCaptureDataClickableColor = ((ItemIsDownloaded1) ? (getColorFromResource(txtValue, R.color.capture_data_text_color)) : (getColorFromResource(txtValue, R.color.capture_data_clickable_color)));
                // read String.format(@android:string/capture_by_label, item.capturedBy)
                stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy = java.lang.String.format(txtCapturedBy.getResources().getString(R.string.capture_by_label), itemCapturedBy);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.icarus.models.ElementAttributesItems.setImage(this.imgCaptured, itemGetFileName);
            this.mboundView2.setVisibility(itemIsDownloadedViewGONEViewVISIBLE);
            com.icarus.models.ElementAttributesItems.setImage(this.mboundView2, itemGetFileName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCapturedBy, stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCapturedDate, itemCapturedAt);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtValue, itemCapturedValue);
            this.txtValue.setTextColor(itemIsDownloadedTxtValueAndroidColorCaptureDataTextColorTxtValueAndroidColorCaptureDataClickableColor);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback37);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // item
        com.icarus.models.ElementAttributesItems item = mItem;
        // viewModel
        com.icarus.viewmodels.AllCaptureDataViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {



            viewModel.onImageClick(item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): item.isDownloaded ? @android:color/capture_data_text_color : @android:color/capture_data_clickable_color
        flag 4 (0x5L): item.isDownloaded ? @android:color/capture_data_text_color : @android:color/capture_data_clickable_color
        flag 5 (0x6L): item.isDownloaded() ? View.GONE : View.VISIBLE
        flag 6 (0x7L): item.isDownloaded() ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}