package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemQrLogReportBindingImpl extends ItemQrLogReportBinding  {

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
    private final androidx.appcompat.widget.AppCompatTextView mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView5;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemQrLogReportBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemQrLogReportBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatTextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (androidx.appcompat.widget.AppCompatTextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatTextView) bindings[5];
        this.mboundView5.setTag(null);
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
            setItem((com.icarus.models.LogsSummary) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.LogsSummary Item) {
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
        java.lang.String javaLangStringVerifiedByItemUsernameJavaLangStringOn = null;
        java.lang.String javaLangStringVerifiedByItemUsernameJavaLangStringOnItemCreated = null;
        com.icarus.models.LogsSummary item = mItem;
        java.lang.String itemItemDescription = null;
        int itemIsQRReasonVisible = 0;
        java.lang.String javaLangStringVerifiedByItemUsername = null;
        java.lang.String itemGetQRLabelName = null;
        int ItemIsQRReasonVisible1 = 0;
        java.lang.String itemGetQRReason = null;
        java.lang.String itemUsername = null;
        java.lang.String itemCreated = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.itemDescription
                    itemItemDescription = item.getItemDescription();
                    // read item.isQRReasonVisible()
                    itemIsQRReasonVisible = item.isQRReasonVisible();
                    // read item.getQRLabelName()
                    itemGetQRLabelName = item.getQRLabelName();
                    // read item.isQRReasonVisible
                    ItemIsQRReasonVisible1 = item.isQRReasonVisible();
                    // read item.getQRReason()
                    itemGetQRReason = item.getQRReason();
                    // read item.username
                    itemUsername = item.getUsername();
                    // read item.created
                    itemCreated = item.getCreated();
                }


                // read ("Verified by ") + (item.username)
                javaLangStringVerifiedByItemUsername = ("Verified by ") + (itemUsername);


                // read (("Verified by ") + (item.username)) + (" on ")
                javaLangStringVerifiedByItemUsernameJavaLangStringOn = (javaLangStringVerifiedByItemUsername) + (" on ");


                // read ((("Verified by ") + (item.username)) + (" on ")) + (item.created)
                javaLangStringVerifiedByItemUsernameJavaLangStringOnItemCreated = (javaLangStringVerifiedByItemUsernameJavaLangStringOn) + (itemCreated);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, itemItemDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, itemGetQRLabelName);
            this.mboundView3.setVisibility(itemIsQRReasonVisible);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, itemGetQRReason);
            this.mboundView4.setVisibility(ItemIsQRReasonVisible1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, javaLangStringVerifiedByItemUsernameJavaLangStringOnItemCreated);
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