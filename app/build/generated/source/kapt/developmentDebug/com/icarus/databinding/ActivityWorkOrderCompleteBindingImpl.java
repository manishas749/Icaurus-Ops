package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWorkOrderCompleteBindingImpl extends ActivityWorkOrderCompleteBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main_content, 4);
        sViewsWithIds.put(R.id.completeWorkOrder, 5);
        sViewsWithIds.put(R.id.etDescriptionView, 6);
        sViewsWithIds.put(R.id.etDescription, 7);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback32;
    @Nullable
    private final android.view.View.OnClickListener mCallback31;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWorkOrderCompleteBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityWorkOrderCompleteBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            );
        this.cancel.setTag(null);
        this.create.setTag(null);
        this.galleryWidget.setTag(null);
        this.scroll.setTag(null);
        setRootTag(root);
        // listeners
        mCallback32 = new com.icarus.generated.callback.OnClickListener(this, 2);
        mCallback31 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel viewModel = mViewModel;
        com.icarus.widget.viewmodel.GalleryViewModel viewModelGalleryViewModel = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.galleryViewModel
                    viewModelGalleryViewModel = viewModel.getGalleryViewModel();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.cancel.setOnClickListener(mCallback32);
            this.create.setOnClickListener(mCallback31);
        }
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel.setAttachmentView(this.galleryWidget, viewModelGalleryViewModel);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // viewModel
                com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onCancelClick();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onCompleteClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}