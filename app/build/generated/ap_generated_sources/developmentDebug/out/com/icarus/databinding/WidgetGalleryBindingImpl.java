package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class WidgetGalleryBindingImpl extends WidgetGalleryBinding implements com.icarus.generated.callback.OnClickListener.Listener {

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
    @Nullable
    private final android.view.View.OnClickListener mCallback18;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public WidgetGalleryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private WidgetGalleryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.galleryRecyclerView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.uploadView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback18 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
            setViewModel((com.icarus.widget.viewmodel.GalleryViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.widget.viewmodel.GalleryViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelListAttachment((androidx.databinding.ObservableList<com.icarus.models.AttachmentItems>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelListAttachment(androidx.databinding.ObservableList<com.icarus.models.AttachmentItems> ViewModelListAttachment, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        androidx.databinding.ObservableList<com.icarus.models.AttachmentItems> viewModelListAttachment = null;
        int viewModelListAttachmentSize = 0;
        int viewModelListAttachmentSizeInt0ViewVISIBLEViewGONE = 0;
        com.icarus.widget.viewmodel.GalleryViewModel viewModel = mViewModel;
        boolean viewModelListAttachmentSizeInt0 = false;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.listAttachment
                    viewModelListAttachment = viewModel.getListAttachment();
                }
                updateRegistration(0, viewModelListAttachment);


                if (viewModelListAttachment != null) {
                    // read viewModel.listAttachment.size()
                    viewModelListAttachmentSize = viewModelListAttachment.size();
                }


                // read viewModel.listAttachment.size() > 0
                viewModelListAttachmentSizeInt0 = (viewModelListAttachmentSize) > (0);
            if((dirtyFlags & 0x7L) != 0) {
                if(viewModelListAttachmentSizeInt0) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read viewModel.listAttachment.size() > 0 ? View.VISIBLE : View.GONE
                viewModelListAttachmentSizeInt0ViewVISIBLEViewGONE = ((viewModelListAttachmentSizeInt0) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.galleryRecyclerView.setVisibility(viewModelListAttachmentSizeInt0ViewVISIBLEViewGONE);
            com.icarus.widget.viewmodel.GalleryViewModel.setRecyclerGridView(this.galleryRecyclerView, viewModelListAttachment);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.uploadView.setOnClickListener(mCallback18);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.icarus.widget.viewmodel.GalleryViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {



            viewModel.getImage(callbackArg_0);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.listAttachment
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): viewModel.listAttachment.size() > 0 ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewModel.listAttachment.size() > 0 ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}