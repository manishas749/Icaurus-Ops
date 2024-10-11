package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWorkOrderCreateBindingImpl extends ActivityWorkOrderCreateBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.createWorkOrder, 7);
        sViewsWithIds.put(R.id.locationTitle, 8);
        sViewsWithIds.put(R.id.spinLocation, 9);
        sViewsWithIds.put(R.id.dividerLocation, 10);
        sViewsWithIds.put(R.id.etTitleView, 11);
        sViewsWithIds.put(R.id.spinRoom, 12);
        sViewsWithIds.put(R.id.dividerRoom, 13);
        sViewsWithIds.put(R.id.spinAsset, 14);
        sViewsWithIds.put(R.id.dividerAsset, 15);
        sViewsWithIds.put(R.id.etDescriptionView, 16);
        sViewsWithIds.put(R.id.etDescription, 17);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback57;
    @Nullable
    private final android.view.View.OnClickListener mCallback58;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWorkOrderCreateBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityWorkOrderCreateBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.view.View) bindings[15]
            , (android.view.View) bindings[10]
            , (android.view.View) bindings[13]
            , (com.google.android.material.textfield.TextInputEditText) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[11]
            , (com.icarus.widget.GalleryImageWidget) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            , (android.widget.TextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatSpinner) bindings[14]
            , (androidx.appcompat.widget.AppCompatSpinner) bindings[9]
            , (androidx.appcompat.widget.AppCompatSpinner) bindings[12]
            );
        this.assets.setTag(null);
        this.cancel.setTag(null);
        this.create.setTag(null);
        this.etTitle.setTag(null);
        this.galleryWidget.setTag(null);
        this.mainContent.setTag(null);
        this.room.setTag(null);
        setRootTag(root);
        // listeners
        mCallback57 = new com.icarus.generated.callback.OnClickListener(this, 1);
        mCallback58 = new com.icarus.generated.callback.OnClickListener(this, 2);
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
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderCreateViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderCreateViewModel ViewModel) {
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
        com.icarus.widget.viewmodel.GalleryViewModel viewModelGalleryViewModel = null;
        java.lang.String viewModelChecklistTitle = null;
        com.icarus.workorder.viewmodels.WorkOrderCreateViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.galleryViewModel
                    viewModelGalleryViewModel = viewModel.getGalleryViewModel();
                    // read viewModel.checklistTitle
                    viewModelChecklistTitle = viewModel.getChecklistTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.assets, com.icarus.base.BaseApplication.getPreferenceManager().getAssetName());
            this.cancel.setOnClickListener(mCallback58);
            this.create.setOnClickListener(mCallback57);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.room, com.icarus.base.BaseApplication.getPreferenceManager().getRoomName());
        }
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etTitle, viewModelChecklistTitle);
            com.icarus.bindings.CustomViewBindings.setContent(this.galleryWidget, viewModelGalleryViewModel);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.icarus.workorder.viewmodels.WorkOrderCreateViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onCreateClick();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // viewModel
                com.icarus.workorder.viewmodels.WorkOrderCreateViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onCancelClick();
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