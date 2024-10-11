package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemQrScanAttributeDetailBindingImpl extends ItemQrScanAttributeDetailBinding  {

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
    private final androidx.appcompat.widget.AppCompatTextView mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemQrScanAttributeDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemQrScanAttributeDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[0]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            );
        this.mboundView4 = (androidx.appcompat.widget.AppCompatTextView) bindings[4];
        this.mboundView4.setTag(null);
        this.parent.setTag(null);
        this.txtExecutionStatus.setTag(null);
        this.txtName.setTag(null);
        this.txtTitleReason.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.qrAttributeItem == variableId) {
            setQrAttributeItem((com.icarus.models.QRAttributeScanItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setQrAttributeItem(@Nullable com.icarus.models.QRAttributeScanItem QrAttributeItem) {
        this.mQrAttributeItem = QrAttributeItem;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.qrAttributeItem);
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
        com.icarus.models.QRAttributeScanItem qrAttributeItem = mQrAttributeItem;
        java.lang.String qrAttributeItemUuid = null;
        java.lang.String qrAttributeItemEntityName = null;
        boolean textUtilsIsEmptyQrAttributeItemGetReason = false;
        java.lang.String qrAttributeItemGetReason = null;
        int textUtilsIsEmptyQrAttributeItemGetReasonViewGONEViewVISIBLE = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (qrAttributeItem != null) {
                    // read qrAttributeItem.uuid
                    qrAttributeItemUuid = qrAttributeItem.getUuid();
                    // read qrAttributeItem.entityName
                    qrAttributeItemEntityName = qrAttributeItem.getEntityName();
                    // read qrAttributeItem.getReason()
                    qrAttributeItemGetReason = qrAttributeItem.getReason();
                }


                // read TextUtils.isEmpty(qrAttributeItem.getReason())
                textUtilsIsEmptyQrAttributeItemGetReason = android.text.TextUtils.isEmpty(qrAttributeItemGetReason);
            if((dirtyFlags & 0x3L) != 0) {
                if(textUtilsIsEmptyQrAttributeItemGetReason) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read TextUtils.isEmpty(qrAttributeItem.getReason()) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyQrAttributeItemGetReasonViewGONEViewVISIBLE = ((textUtilsIsEmptyQrAttributeItemGetReason) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, qrAttributeItemGetReason);
            this.mboundView4.setVisibility(textUtilsIsEmptyQrAttributeItemGetReasonViewGONEViewVISIBLE);
            com.icarus.models.QRAttributeScanItem.setTextFromResourceId(this.txtExecutionStatus, qrAttributeItemUuid);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtName, qrAttributeItemEntityName);
            this.txtTitleReason.setVisibility(textUtilsIsEmptyQrAttributeItemGetReasonViewGONEViewVISIBLE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): qrAttributeItem
        flag 1 (0x2L): null
        flag 2 (0x3L): TextUtils.isEmpty(qrAttributeItem.getReason()) ? View.GONE : View.VISIBLE
        flag 3 (0x4L): TextUtils.isEmpty(qrAttributeItem.getReason()) ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}