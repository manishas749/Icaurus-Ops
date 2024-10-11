package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PopupSuggestionBindingImpl extends PopupSuggestionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.createWorkOrder, 3);
        sViewsWithIds.put(R.id.etDescriptionView, 4);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etDescriptionandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.txtSuggestion.get()
            //         is viewModel.txtSuggestion.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etDescription);
            // localize variables for thread safety
            // viewModel.txtSuggestion
            androidx.databinding.ObservableField<java.lang.String> viewModelTxtSuggestion = null;
            // viewModel.txtSuggestion.get()
            java.lang.String viewModelTxtSuggestionGet = null;
            // viewModel
            com.icarus.widget.viewmodel.GalleryViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.txtSuggestion != null
            boolean viewModelTxtSuggestionJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelTxtSuggestion = viewModel.getTxtSuggestion();

                viewModelTxtSuggestionJavaLangObjectNull = (viewModelTxtSuggestion) != (null);
                if (viewModelTxtSuggestionJavaLangObjectNull) {




                    viewModelTxtSuggestion.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public PopupSuggestionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private PopupSuggestionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[3]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            );
        this.etDescription.setTag(null);
        this.galleryWidget.setTag(null);
        this.mainContent.setTag(null);
        setRootTag(root);
        // listeners
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
                return onChangeViewModelTxtSuggestion((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelTxtSuggestion(androidx.databinding.ObservableField<java.lang.String> ViewModelTxtSuggestion, int fieldId) {
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
        androidx.databinding.ObservableField<java.lang.String> viewModelTxtSuggestion = null;
        java.lang.String viewModelTxtSuggestionGet = null;
        com.icarus.widget.viewmodel.GalleryViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.txtSuggestion
                    viewModelTxtSuggestion = viewModel.getTxtSuggestion();
                }
                updateRegistration(0, viewModelTxtSuggestion);


                if (viewModelTxtSuggestion != null) {
                    // read viewModel.txtSuggestion.get()
                    viewModelTxtSuggestionGet = viewModelTxtSuggestion.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etDescription, viewModelTxtSuggestionGet);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etDescription, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etDescriptionandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.icarus.workorder.viewmodels.WorkOrderCompleteViewModel.setAttachmentView(this.galleryWidget, viewModel);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.txtSuggestion
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}