package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAllCaptureDataQrAttributesBindingImpl extends ItemAllCaptureDataQrAttributesBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView1;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView2;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView3;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView5;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAllCaptureDataQrAttributesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemAllCaptureDataQrAttributesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatTextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatTextView) bindings[5];
        this.mboundView5.setTag(null);
        this.txtCapturedBy.setTag(null);
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
        if (BR.item == variableId) {
            setItem((com.icarus.models.ElementAttributesItems) variable);
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
        java.lang.String itemGetQRReason = null;
        com.icarus.models.ElementAttributesItems item = mItem;
        int itemIsQRReasonVisible = 0;
        java.lang.String itemCapturedBy = null;
        java.lang.String itemGetQRLabelName = null;
        java.lang.String itemCapturedAt = null;
        java.lang.String stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.getQRReason()
                    itemGetQRReason = item.getQRReason();
                    // read item.isQRReasonVisible()
                    itemIsQRReasonVisible = item.isQRReasonVisible();
                    // read item.capturedBy
                    itemCapturedBy = item.getCapturedBy();
                    // read item.getQRLabelName()
                    itemGetQRLabelName = item.getQRLabelName();
                    // read item.capturedAt
                    itemCapturedAt = item.getCapturedAt();
                }


                // read String.format(@android:string/capture_by_label, item.capturedBy)
                stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy = java.lang.String.format(txtCapturedBy.getResources().getString(R.string.capture_by_label), itemCapturedBy);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, itemGetQRLabelName);
            this.mboundView2.setVisibility(itemIsQRReasonVisible);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, itemGetQRReason);
            this.mboundView3.setVisibility(itemIsQRReasonVisible);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, itemCapturedAt);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCapturedBy, stringFormatTxtCapturedByAndroidStringCaptureByLabelItemCapturedBy);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}