package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAllCaptureDataBindingImpl extends ActivityAllCaptureDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.txtEmptyView, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAllCaptureDataBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityAllCaptureDataBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.appbar.AppBarLayout) bindings[3]
            , (android.widget.ProgressBar) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (androidx.appcompat.widget.Toolbar) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            );
        this.loginProgress.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rvElements.setTag(null);
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
            setViewModel((com.icarus.viewmodels.AllCaptureDataViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.AllCaptureDataViewModel ViewModel) {
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
                return onChangeViewModelIsLoading((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsLoading(androidx.databinding.ObservableBoolean ViewModelIsLoading, int fieldId) {
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
        com.icarus.adapters.AllCaptureDataElementsAdapter viewModelGetElementListAdapter = null;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        boolean viewModelIsLoadingGet = false;
        com.icarus.viewmodels.AllCaptureDataViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {


            if ((dirtyFlags & 0x6L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.getElementListAdapter()
                        viewModelGetElementListAdapter = viewModel.getElementListAdapter();
                    }
            }

                if (viewModel != null) {
                    // read viewModel.isLoading
                    viewModelIsLoading = viewModel.getIsLoading();
                }
                updateRegistration(0, viewModelIsLoading);


                if (viewModelIsLoading != null) {
                    // read viewModel.isLoading.get()
                    viewModelIsLoadingGet = viewModelIsLoading.get();
                }
            if((dirtyFlags & 0x7L) != 0) {
                if(viewModelIsLoadingGet) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.loginProgress.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setListItems(this.rvElements, viewModelGetElementListAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isLoading
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}