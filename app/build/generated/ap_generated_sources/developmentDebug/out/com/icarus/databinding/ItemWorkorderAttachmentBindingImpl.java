package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemWorkorderAttachmentBindingImpl extends ItemWorkorderAttachmentBinding implements com.icarus.generated.callback.OnClickListener.Listener {

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
    private final android.widget.TextView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback47;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemWorkorderAttachmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private ItemWorkorderAttachmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (android.widget.TextView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback47 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderDetailViewModel) variable);
        }
        else if (BR.workOrderAttachmentItem == variableId) {
            setWorkOrderAttachmentItem((com.icarus.workorder.models.WorkOrderAttachmentItems) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderDetailViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    public void setWorkOrderAttachmentItem(@Nullable com.icarus.workorder.models.WorkOrderAttachmentItems WorkOrderAttachmentItem) {
        this.mWorkOrderAttachmentItem = WorkOrderAttachmentItem;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.workOrderAttachmentItem);
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
        java.lang.String workOrderAttachmentItemGetDisplayFileName = null;
        com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;
        com.icarus.workorder.models.WorkOrderAttachmentItems workOrderAttachmentItem = mWorkOrderAttachmentItem;

        if ((dirtyFlags & 0x6L) != 0) {



                if (workOrderAttachmentItem != null) {
                    // read workOrderAttachmentItem.getDisplayFileName()
                    workOrderAttachmentItemGetDisplayFileName = workOrderAttachmentItem.getDisplayFileName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback47);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView0, workOrderAttachmentItemGetDisplayFileName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;
        // workOrderAttachmentItem
        com.icarus.workorder.models.WorkOrderAttachmentItems workOrderAttachmentItem = mWorkOrderAttachmentItem;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {



            viewModel.onAttachmentClick(workOrderAttachmentItem);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): workOrderAttachmentItem
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}