package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAllCaptureDataElementsWithAttributesBindingImpl extends ItemAllCaptureDataElementsWithAttributesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.space, 8);
        sViewsWithIds.put(R.id.layoutContent, 9);
        sViewsWithIds.put(R.id.dashLine, 10);
        sViewsWithIds.put(R.id.rvAttributes, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAllCaptureDataElementsWithAttributesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ItemAllCaptureDataElementsWithAttributesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.icarus.customviews.DashedLine) bindings[10]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (android.widget.Space) bindings[8]
            , (android.widget.Space) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.desc.setTag(null);
        this.label.setTag(null);
        this.layoutStepDetail.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.space1.setTag(null);
        this.txtDescription.setTag(null);
        this.txtElementStatus.setTag(null);
        this.txtSequenceNo.setTag(null);
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
            setItem((com.icarus.models.ElementWithCaptureDataItems) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.AllCaptureDataViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.ElementWithCaptureDataItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.AllCaptureDataViewModel ViewModel) {
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
        com.icarus.models.ElementWithCaptureDataItems item = mItem;
        int itemIsStepViewVISIBLEViewGONE = 0;
        java.lang.String itemSequenceNo = null;
        int itemIsStepViewGONEViewVISIBLE = 0;
        java.lang.String itemGetDescription = null;
        java.lang.String itemGetExecutionStatus = null;
        boolean itemGetStatusJavaLangObjectNull = false;
        java.lang.String itemGetTitle = null;
        boolean itemIsStep = false;
        java.lang.Integer itemGetStatus = null;
        java.lang.Integer itemStatus = null;
        int itemGetStatusJavaLangObjectNullViewGONEViewVISIBLE = 0;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.sequenceNo
                    itemSequenceNo = item.getSequenceNo();
                    // read item.getDescription()
                    itemGetDescription = item.getDescription();
                    // read item.getExecutionStatus()
                    itemGetExecutionStatus = item.getExecutionStatus();
                    // read item.getTitle()
                    itemGetTitle = item.getTitle();
                    // read item.isStep()
                    itemIsStep = item.isStep();
                    // read item.getStatus()
                    itemGetStatus = item.getStatus();
                    // read item.status
                    itemStatus = item.getStatus();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsStep) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                }
            }


                // read item.isStep() ? View.VISIBLE : View.GONE
                itemIsStepViewVISIBLEViewGONE = ((itemIsStep) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read item.isStep() ? View.GONE : View.VISIBLE
                itemIsStepViewGONEViewVISIBLE = ((itemIsStep) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read item.getStatus() == null
                itemGetStatusJavaLangObjectNull = (itemGetStatus) == (null);
            if((dirtyFlags & 0x9L) != 0) {
                if(itemGetStatusJavaLangObjectNull) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }


                // read item.getStatus() == null ? View.GONE : View.VISIBLE
                itemGetStatusJavaLangObjectNullViewGONEViewVISIBLE = ((itemGetStatusJavaLangObjectNull) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.desc, itemGetDescription);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.label, itemGetTitle);
            this.layoutStepDetail.setVisibility(itemIsStepViewVISIBLEViewGONE);
            this.space1.setVisibility(itemGetStatusJavaLangObjectNullViewGONEViewVISIBLE);
            this.txtDescription.setVisibility(itemIsStepViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.txtDescription, itemGetTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtElementStatus, itemGetExecutionStatus);
            this.txtElementStatus.setVisibility(itemGetStatusJavaLangObjectNullViewGONEViewVISIBLE);
            com.icarus.models.ElementWithCaptureDataItems.setExecutionTextColorAndDrawable(this.txtElementStatus, itemStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtSequenceNo, itemSequenceNo);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): position
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): item.isStep() ? View.VISIBLE : View.GONE
        flag 5 (0x6L): item.isStep() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): item.isStep() ? View.GONE : View.VISIBLE
        flag 7 (0x8L): item.isStep() ? View.GONE : View.VISIBLE
        flag 8 (0x9L): item.getStatus() == null ? View.GONE : View.VISIBLE
        flag 9 (0xaL): item.getStatus() == null ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}