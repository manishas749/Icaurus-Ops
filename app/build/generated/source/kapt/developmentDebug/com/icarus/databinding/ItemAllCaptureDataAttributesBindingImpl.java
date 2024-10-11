package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAllCaptureDataAttributesBindingImpl extends ItemAllCaptureDataAttributesBinding  {

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
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAllCaptureDataAttributesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ItemAllCaptureDataAttributesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rvFiles.setTag(null);
        this.rvQR.setTag(null);
        this.txtCapturedBy.setTag(null);
        this.txtCapturedDate.setTag(null);
        this.txtDescription.setTag(null);
        this.txtLabel.setTag(null);
        this.txtSequenceNo.setTag(null);
        this.txtValue.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        else if (BR.fileAdapter == variableId) {
            setFileAdapter((com.icarus.adapters.AllCaptureDataAttributesFileAdapter) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.qrAttributesAdapter == variableId) {
            setQrAttributesAdapter((com.icarus.adapters.AllCaptureDataAttributesQRAdapter) variable);
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
    public void setFileAdapter(@Nullable com.icarus.adapters.AllCaptureDataAttributesFileAdapter FileAdapter) {
        this.mFileAdapter = FileAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.fileAdapter);
        super.requestRebind();
    }
    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }
    public void setQrAttributesAdapter(@Nullable com.icarus.adapters.AllCaptureDataAttributesQRAdapter QrAttributesAdapter) {
        this.mQrAttributesAdapter = QrAttributesAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.qrAttributesAdapter);
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
        com.icarus.models.ElementAttributesItems item = mItem;
        com.icarus.adapters.AllCaptureDataAttributesFileAdapter fileAdapter = mFileAdapter;
        java.lang.Integer position = mPosition;
        java.lang.String itemCapturedBy = null;
        java.lang.String itemLabel = null;
        java.lang.String stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy = null;
        int itemIsFileBooleanTrueItemIsQRViewGONEViewVISIBLE = 0;
        java.lang.String itemDescription = null;
        java.lang.String stringFormatTxtSequenceNoAndroidStringCaptureDataSequenceNumberStringValueOfPositionInt1 = null;
        boolean textUtilsIsEmptyItemDescription = false;
        java.lang.String itemCapturedValue = null;
        boolean itemIsFileBooleanTrueItemIsQR = false;
        int itemIsQRViewVISIBLEViewGONE = 0;
        com.icarus.adapters.AllCaptureDataAttributesQRAdapter qrAttributesAdapter = mQrAttributesAdapter;
        boolean itemIsQR = false;
        int positionInt1 = 0;
        java.lang.String itemCapturedAt = null;
        java.lang.String stringValueOfPositionInt1 = null;
        int textUtilsIsEmptyItemDescriptionViewGONEViewVISIBLE = 0;
        boolean itemIsFile = false;
        int androidxDatabindingViewDataBindingSafeUnboxPosition = 0;
        int itemIsFileViewVISIBLEViewGONE = 0;

        if ((dirtyFlags & 0x11L) != 0) {



                if (item != null) {
                    // read item.capturedBy
                    itemCapturedBy = item.getCapturedBy();
                    // read item.label
                    itemLabel = item.getLabel();
                    // read item.description
                    itemDescription = item.getDescription();
                    // read item.capturedValue
                    itemCapturedValue = item.getCapturedValue();
                    // read item.isQR()
                    itemIsQR = item.isQR();
                    // read item.capturedAt
                    itemCapturedAt = item.getCapturedAt();
                    // read item.isFile()
                    itemIsFile = item.isFile();
                }
            if((dirtyFlags & 0x11L) != 0) {
                if(itemIsQR) {
                        dirtyFlags |= 0x400L;
                }
                else {
                        dirtyFlags |= 0x200L;
                }
            }
            if((dirtyFlags & 0x11L) != 0) {
                if(itemIsFile) {
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x4000L;
                }
                else {
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x2000L;
                }
            }


                // read String.format(@android:string/capture_by_label, item.capturedBy)
                stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy = java.lang.String.format(txtCapturedBy.getResources().getString(R.string.capture_by_label), itemCapturedBy);
                // read TextUtils.isEmpty(item.description)
                textUtilsIsEmptyItemDescription = android.text.TextUtils.isEmpty(itemDescription);
                // read item.isQR() ? View.VISIBLE : View.GONE
                itemIsQRViewVISIBLEViewGONE = ((itemIsQR) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read item.isFile() ? View.VISIBLE : View.GONE
                itemIsFileViewVISIBLEViewGONE = ((itemIsFile) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            if((dirtyFlags & 0x11L) != 0) {
                if(textUtilsIsEmptyItemDescription) {
                        dirtyFlags |= 0x1000L;
                }
                else {
                        dirtyFlags |= 0x800L;
                }
            }


                // read TextUtils.isEmpty(item.description) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyItemDescriptionViewGONEViewVISIBLE = ((textUtilsIsEmptyItemDescription) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x12L) != 0) {
        }
        if ((dirtyFlags & 0x14L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(position)
                androidxDatabindingViewDataBindingSafeUnboxPosition = androidx.databinding.ViewDataBinding.safeUnbox(position);


                // read (androidx.databinding.ViewDataBinding.safeUnbox(position)) + (1)
                positionInt1 = (androidxDatabindingViewDataBindingSafeUnboxPosition) + (1);


                // read String.valueOf((androidx.databinding.ViewDataBinding.safeUnbox(position)) + (1))
                stringValueOfPositionInt1 = java.lang.String.valueOf(positionInt1);


                // read String.format(@android:string/capture_data_sequence_number, String.valueOf((androidx.databinding.ViewDataBinding.safeUnbox(position)) + (1)))
                stringFormatTxtSequenceNoAndroidStringCaptureDataSequenceNumberStringValueOfPositionInt1 = java.lang.String.format(txtSequenceNo.getResources().getString(R.string.capture_data_sequence_number), stringValueOfPositionInt1);
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished

        if ((dirtyFlags & 0x11L) != 0) {

                // read item.isFile() ? true : item.isQR()
                itemIsFileBooleanTrueItemIsQR = ((itemIsFile) ? (true) : (itemIsQR));
            if((dirtyFlags & 0x11L) != 0) {
                if(itemIsFileBooleanTrueItemIsQR) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }


                // read item.isFile() ? true : item.isQR() ? View.GONE : View.VISIBLE
                itemIsFileBooleanTrueItemIsQRViewGONEViewVISIBLE = ((itemIsFileBooleanTrueItemIsQR) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            this.rvFiles.setVisibility(itemIsFileViewVISIBLEViewGONE);
            this.rvQR.setVisibility(itemIsQRViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCapturedBy, stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy);
            this.txtCapturedBy.setVisibility(itemIsFileBooleanTrueItemIsQRViewGONEViewVISIBLE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCapturedDate, itemCapturedAt);
            this.txtCapturedDate.setVisibility(itemIsFileBooleanTrueItemIsQRViewGONEViewVISIBLE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtDescription, itemDescription);
            this.txtDescription.setVisibility(textUtilsIsEmptyItemDescriptionViewGONEViewVISIBLE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtLabel, itemLabel);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtValue, itemCapturedValue);
            this.txtValue.setVisibility(itemIsFileBooleanTrueItemIsQRViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.rvFiles, fileAdapter);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.rvQR, qrAttributesAdapter);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtSequenceNo, stringFormatTxtSequenceNoAndroidStringCaptureDataSequenceNumberStringValueOfPositionInt1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): fileAdapter
        flag 2 (0x3L): position
        flag 3 (0x4L): qrAttributesAdapter
        flag 4 (0x5L): null
        flag 5 (0x6L): item.isFile() ? true : item.isQR() ? View.GONE : View.VISIBLE
        flag 6 (0x7L): item.isFile() ? true : item.isQR() ? View.GONE : View.VISIBLE
        flag 7 (0x8L): item.isFile() ? true : item.isQR()
        flag 8 (0x9L): item.isFile() ? true : item.isQR()
        flag 9 (0xaL): item.isQR() ? View.VISIBLE : View.GONE
        flag 10 (0xbL): item.isQR() ? View.VISIBLE : View.GONE
        flag 11 (0xcL): TextUtils.isEmpty(item.description) ? View.GONE : View.VISIBLE
        flag 12 (0xdL): TextUtils.isEmpty(item.description) ? View.GONE : View.VISIBLE
        flag 13 (0xeL): item.isFile() ? View.VISIBLE : View.GONE
        flag 14 (0xfL): item.isFile() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}