package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRecordDetailBindingImpl extends FragmentRecordDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.editAttribute, 3);
        sViewsWithIds.put(R.id.linear, 4);
        sViewsWithIds.put(R.id.btnSubmit, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRecordDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentRecordDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (android.widget.FrameLayout) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (android.widget.LinearLayout) bindings[4]
            );
        this.description.setTag(null);
        this.label.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setItem((com.icarus.models.CheckListStepAttributeItems) variable);
        }
        else if (BR.attributeNo == variableId) {
            setAttributeNo((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.CheckListStepAttributeItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setAttributeNo(@Nullable java.lang.Integer AttributeNo) {
        this.mAttributeNo = AttributeNo;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.attributeNo);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
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
        int textUtilsIsEmptyItemLabelViewGONEViewVISIBLE = 0;
        com.icarus.models.CheckListStepAttributeItems item = mItem;
        boolean itemAllowDescriptionInt1 = false;
        java.lang.String itemLabel = null;
        boolean textUtilsIsEmptyItemLabel = false;
        java.lang.String itemDescription = null;
        boolean textUtilsIsEmptyItemDescription = false;
        java.lang.Integer itemAllowDescription = null;
        java.lang.Integer attributeNo = mAttributeNo;
        int textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalseViewVISIBLEViewINVISIBLE = 0;
        int androidxDatabindingViewDataBindingSafeUnboxItemAllowDescription = 0;
        java.lang.String stringFormatLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel = null;
        boolean TextUtilsIsEmptyItemDescription1 = false;
        boolean textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalse = false;

        if ((dirtyFlags & 0xbL) != 0) {



                if (item != null) {
                    // read item.label
                    itemLabel = item.getLabel();
                }

            if ((dirtyFlags & 0x9L) != 0) {

                    // read TextUtils.isEmpty(item.label)
                    textUtilsIsEmptyItemLabel = android.text.TextUtils.isEmpty(itemLabel);
                if((dirtyFlags & 0x9L) != 0) {
                    if(textUtilsIsEmptyItemLabel) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }


                    // read TextUtils.isEmpty(item.label) ? View.GONE : View.VISIBLE
                    textUtilsIsEmptyItemLabelViewGONEViewVISIBLE = ((textUtilsIsEmptyItemLabel) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }

                // read String.format(@android:string/attribute_label_bullet, attributeNo, item.label)
                stringFormatLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel = java.lang.String.format(label.getResources().getString(R.string.attribute_label_bullet), attributeNo, itemLabel);
            if ((dirtyFlags & 0x9L) != 0) {

                    if (item != null) {
                        // read item.description
                        itemDescription = item.getDescription();
                    }


                    // read TextUtils.isEmpty(item.description)
                    textUtilsIsEmptyItemDescription = android.text.TextUtils.isEmpty(itemDescription);


                    // read !TextUtils.isEmpty(item.description)
                    TextUtilsIsEmptyItemDescription1 = !textUtilsIsEmptyItemDescription;
                if((dirtyFlags & 0x9L) != 0) {
                    if(TextUtilsIsEmptyItemDescription1) {
                            dirtyFlags |= 0x200L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                    }
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x200L) != 0) {

                if (item != null) {
                    // read item.allowDescription
                    itemAllowDescription = item.getAllowDescription();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription)
                androidxDatabindingViewDataBindingSafeUnboxItemAllowDescription = androidx.databinding.ViewDataBinding.safeUnbox(itemAllowDescription);


                // read androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1
                itemAllowDescriptionInt1 = (androidxDatabindingViewDataBindingSafeUnboxItemAllowDescription) == (1);
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read !TextUtils.isEmpty(item.description) ? androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1 : false
                textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalse = ((TextUtilsIsEmptyItemDescription1) ? (itemAllowDescriptionInt1) : (false));
            if((dirtyFlags & 0x9L) != 0) {
                if(textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalse) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }


                // read !TextUtils.isEmpty(item.description) ? androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1 : false ? View.VISIBLE : View.INVISIBLE
                textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalseViewVISIBLEViewINVISIBLE = ((textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            this.description.setVisibility(textUtilsIsEmptyItemDescriptionItemAllowDescriptionInt1BooleanFalseViewVISIBLEViewINVISIBLE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.description, itemDescription);
            this.label.setVisibility(textUtilsIsEmptyItemLabelViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.label, stringFormatLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): attributeNo
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): TextUtils.isEmpty(item.label) ? View.GONE : View.VISIBLE
        flag 5 (0x6L): TextUtils.isEmpty(item.label) ? View.GONE : View.VISIBLE
        flag 6 (0x7L): !TextUtils.isEmpty(item.description) ? androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1 : false ? View.VISIBLE : View.INVISIBLE
        flag 7 (0x8L): !TextUtils.isEmpty(item.description) ? androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1 : false ? View.VISIBLE : View.INVISIBLE
        flag 8 (0x9L): !TextUtils.isEmpty(item.description) ? androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1 : false
        flag 9 (0xaL): !TextUtils.isEmpty(item.description) ? androidx.databinding.ViewDataBinding.safeUnbox(item.allowDescription) == 1 : false
    flag mapping end*/
    //end
}