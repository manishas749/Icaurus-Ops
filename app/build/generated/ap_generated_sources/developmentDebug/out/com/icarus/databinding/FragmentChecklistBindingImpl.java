package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChecklistBindingImpl extends FragmentChecklistBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.emptyViewImage, 5);
        sViewsWithIds.put(R.id.emptyViewText2, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.ProgressBar mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentChecklistBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentChecklistBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            );
        this.emptyView.setTag(null);
        this.emptyViewText3.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.ProgressBar) bindings[4];
        this.mboundView4.setTag(null);
        this.recyclerView.setTag(null);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsChecklistEmpty((androidx.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeViewModelIsLoading((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsChecklistEmpty(androidx.databinding.ObservableBoolean ViewModelIsChecklistEmpty, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsLoading(androidx.databinding.ObservableBoolean ViewModelIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        int viewModelIsChecklistEmptyViewGONEViewVISIBLE = 0;
        java.lang.String viewModelGetSearchKeyword = null;
        boolean viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse = false;
        boolean viewModelGetSearchKeywordIsEmpty = false;
        boolean viewModelIsChecklistEmptyGet = false;
        int viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalseViewVISIBLEViewGONE = 0;
        boolean viewModelIsLoadingGet = false;
        androidx.databinding.ObservableBoolean viewModelIsChecklistEmpty = null;
        int ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalseViewVISIBLEViewGONE1 = 0;
        boolean ViewModelGetSearchKeywordIsEmpty1 = false;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        boolean ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse1 = false;
        androidx.recyclerview.widget.RecyclerView.Adapter viewModelGetAllCheckListAdapter = null;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isChecklistEmpty
                        viewModelIsChecklistEmpty = viewModel.isChecklistEmpty;
                    }
                    updateRegistration(0, viewModelIsChecklistEmpty);


                    if (viewModelIsChecklistEmpty != null) {
                        // read viewModel.isChecklistEmpty.get()
                        viewModelIsChecklistEmptyGet = viewModelIsChecklistEmpty.get();
                    }
                if((dirtyFlags & 0xdL) != 0) {
                    if(viewModelIsChecklistEmptyGet) {
                            dirtyFlags |= 0x20L;
                            dirtyFlags |= 0x80L;
                            dirtyFlags |= 0x8000L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                            dirtyFlags |= 0x40L;
                            dirtyFlags |= 0x4000L;
                    }
                }


                    // read viewModel.isChecklistEmpty.get() ? View.GONE : View.VISIBLE
                    viewModelIsChecklistEmptyViewGONEViewVISIBLE = ((viewModelIsChecklistEmptyGet) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }
            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.getAllCheckListAdapter()
                        viewModelGetAllCheckListAdapter = viewModel.getAllCheckListAdapter();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isLoading
                        viewModelIsLoading = viewModel.getIsLoading();
                    }
                    updateRegistration(1, viewModelIsLoading);


                    if (viewModelIsLoading != null) {
                        // read viewModel.isLoading.get()
                        viewModelIsLoadingGet = viewModelIsLoading.get();
                    }
                if((dirtyFlags & 0xeL) != 0) {
                    if(viewModelIsLoadingGet) {
                            dirtyFlags |= 0x2000L;
                    }
                    else {
                            dirtyFlags |= 0x1000L;
                    }
                }


                    // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                    viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished

        if ((dirtyFlags & 0x8080L) != 0) {

                if (viewModel != null) {
                    // read viewModel.getSearchKeyword()
                    viewModelGetSearchKeyword = viewModel.getSearchKeyword();
                }


                if (viewModelGetSearchKeyword != null) {
                    // read viewModel.getSearchKeyword().isEmpty()
                    ViewModelGetSearchKeywordIsEmpty1 = viewModelGetSearchKeyword.isEmpty();
                }

            if ((dirtyFlags & 0x80L) != 0) {

                    // read !viewModel.getSearchKeyword().isEmpty()
                    viewModelGetSearchKeywordIsEmpty = !ViewModelGetSearchKeywordIsEmpty1;
            }
        }

        if ((dirtyFlags & 0xdL) != 0) {

                // read viewModel.isChecklistEmpty.get() ? !viewModel.getSearchKeyword().isEmpty() : false
                viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse = ((viewModelIsChecklistEmptyGet) ? (viewModelGetSearchKeywordIsEmpty) : (false));
                // read viewModel.isChecklistEmpty.get() ? viewModel.getSearchKeyword().isEmpty() : false
                ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse1 = ((viewModelIsChecklistEmptyGet) ? (ViewModelGetSearchKeywordIsEmpty1) : (false));
            if((dirtyFlags & 0xdL) != 0) {
                if(viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }
            if((dirtyFlags & 0xdL) != 0) {
                if(ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse1) {
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x400L;
                }
            }


                // read viewModel.isChecklistEmpty.get() ? !viewModel.getSearchKeyword().isEmpty() : false ? View.VISIBLE : View.GONE
                viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalseViewVISIBLEViewGONE = ((viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewModel.isChecklistEmpty.get() ? viewModel.getSearchKeyword().isEmpty() : false ? View.VISIBLE : View.GONE
                ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalseViewVISIBLEViewGONE1 = ((ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalse1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.emptyView.setVisibility(ViewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalseViewVISIBLEViewGONE1);
            this.emptyViewText3.setVisibility(viewModelIsChecklistEmptyViewModelGetSearchKeywordIsEmptyBooleanFalseViewVISIBLEViewGONE);
            this.recyclerView.setVisibility(viewModelIsChecklistEmptyViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            this.mboundView4.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerView, viewModelGetAllCheckListAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isChecklistEmpty
        flag 1 (0x2L): viewModel.isLoading
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): viewModel.isChecklistEmpty.get() ? View.GONE : View.VISIBLE
        flag 5 (0x6L): viewModel.isChecklistEmpty.get() ? View.GONE : View.VISIBLE
        flag 6 (0x7L): viewModel.isChecklistEmpty.get() ? !viewModel.getSearchKeyword().isEmpty() : false
        flag 7 (0x8L): viewModel.isChecklistEmpty.get() ? !viewModel.getSearchKeyword().isEmpty() : false
        flag 8 (0x9L): viewModel.isChecklistEmpty.get() ? !viewModel.getSearchKeyword().isEmpty() : false ? View.VISIBLE : View.GONE
        flag 9 (0xaL): viewModel.isChecklistEmpty.get() ? !viewModel.getSearchKeyword().isEmpty() : false ? View.VISIBLE : View.GONE
        flag 10 (0xbL): viewModel.isChecklistEmpty.get() ? viewModel.getSearchKeyword().isEmpty() : false ? View.VISIBLE : View.GONE
        flag 11 (0xcL): viewModel.isChecklistEmpty.get() ? viewModel.getSearchKeyword().isEmpty() : false ? View.VISIBLE : View.GONE
        flag 12 (0xdL): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 13 (0xeL): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 14 (0xfL): viewModel.isChecklistEmpty.get() ? viewModel.getSearchKeyword().isEmpty() : false
        flag 15 (0x10L): viewModel.isChecklistEmpty.get() ? viewModel.getSearchKeyword().isEmpty() : false
    flag mapping end*/
    //end
}