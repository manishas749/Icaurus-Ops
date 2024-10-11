package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemFileRequiredBindingImpl extends ItemFileRequiredBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imgContainer, 4);
        sViewsWithIds.put(R.id.delete, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView3;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback41;
    @Nullable
    private final android.view.View.OnClickListener mCallback40;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemFileRequiredBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemFileRequiredBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.FrameLayout) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (android.widget.FrameLayout) bindings[4]
            );
        this.fileName.setTag(null);
        this.img.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatImageView) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        mCallback41 = new com.icarus.generated.callback.OnClickListener(this, 2);
        mCallback40 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.selectedFile == variableId) {
            setSelectedFile((com.icarus.models.SelectedFile) variable);
        }
        else if (BR.adapter == variableId) {
            setAdapter((com.icarus.adapters.FileRequiredAdapter) variable);
        }
        else if (BR.name == variableId) {
            setName((java.lang.String) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSelectedFile(@Nullable com.icarus.models.SelectedFile SelectedFile) {
        this.mSelectedFile = SelectedFile;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.selectedFile);
        super.requestRebind();
    }
    public void setAdapter(@Nullable com.icarus.adapters.FileRequiredAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }
    public void setName(@Nullable java.lang.String Name) {
        this.mName = Name;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.name);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
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
        com.icarus.models.SelectedFile selectedFile = mSelectedFile;
        com.icarus.adapters.FileRequiredAdapter adapter = mAdapter;
        java.lang.String name = mName;
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x11L) != 0) {
        }
        if ((dirtyFlags & 0x14L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fileName, name);
        }
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setThumbnail(this.img, selectedFile);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback40);
            this.mboundView3.setOnClickListener(mCallback41);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // selectedFile
                com.icarus.models.SelectedFile selectedFile = mSelectedFile;
                // adapter
                com.icarus.adapters.FileRequiredAdapter adapter = mAdapter;
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {




                    viewModel.deleteSelectedFile(selectedFile, adapter);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // selectedFile
                com.icarus.models.SelectedFile selectedFile = mSelectedFile;
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {



                    viewModel.openFile(selectedFile);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): selectedFile
        flag 1 (0x2L): adapter
        flag 2 (0x3L): name
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}