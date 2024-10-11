package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChecklistDetailBindingImpl extends FragmentChecklistDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentChecklistDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentChecklistDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            );
        this.constraintLayout.setTag(null);
        this.description.setTag(null);
        this.recyclerViewChecklist.setTag(null);
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
            setViewModel((com.icarus.viewmodels.ChecklistDetailListingViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistDetailListingViewModel ViewModel) {
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
                return onChangeViewModelIsNoElements((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsNoElements(androidx.databinding.ObservableBoolean ViewModelIsNoElements, int fieldId) {
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
        androidx.databinding.ObservableBoolean viewModelIsNoElements = null;
        boolean viewModelIsNoElementsGet = false;
        com.icarus.viewmodels.ChecklistDetailListingViewModel viewModel = mViewModel;
        com.icarus.adapters.ChecklistDetailAdapter viewModelGetAdapter = null;
        int viewModelIsNoElementsViewVISIBLEViewGONE = 0;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.isNoElements
                    viewModelIsNoElements = viewModel.isNoElements;
                }
                updateRegistration(0, viewModelIsNoElements);


                if (viewModelIsNoElements != null) {
                    // read viewModel.isNoElements.get()
                    viewModelIsNoElementsGet = viewModelIsNoElements.get();
                }
            if((dirtyFlags & 0x7L) != 0) {
                if(viewModelIsNoElementsGet) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read viewModel.isNoElements.get() ? View.VISIBLE : View.GONE
                viewModelIsNoElementsViewVISIBLEViewGONE = ((viewModelIsNoElementsGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            if ((dirtyFlags & 0x6L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.getAdapter()
                        viewModelGetAdapter = viewModel.getAdapter();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.description.setVisibility(viewModelIsNoElementsViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewChecklist, viewModelGetAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isNoElements
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): viewModel.isNoElements.get() ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewModel.isNoElements.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}