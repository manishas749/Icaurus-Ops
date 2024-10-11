package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AppBarBaseNavigationDrawerBindingImpl extends AppBarBaseNavigationDrawerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes.setIncludes(1, 
            new String[] {"item_search_layout"},
            new int[] {4},
            new int[] {com.icarus.R.layout.item_search_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 5);
        sViewsWithIds.put(R.id.topView, 6);
        sViewsWithIds.put(R.id.sort, 7);
        sViewsWithIds.put(R.id.filter, 8);
        sViewsWithIds.put(R.id.txtLabelFilter, 9);
        sViewsWithIds.put(R.id.message, 10);
        sViewsWithIds.put(R.id.frameLayout, 11);
        sViewsWithIds.put(R.id.frameLayoutSearch, 12);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView2;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AppBarBaseNavigationDrawerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private AppBarBaseNavigationDrawerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.FrameLayout) bindings[11]
            , (android.widget.FrameLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (com.icarus.databinding.ItemSearchLayoutBinding) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (androidx.appcompat.widget.Toolbar) bindings[5]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        searchView.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (searchView.hasPendingBindings()) {
            return true;
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
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        searchView.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelFilterCount((androidx.databinding.ObservableInt) object, fieldId);
            case 1 :
                return onChangeViewModelIsFilterApplied((androidx.databinding.ObservableBoolean) object, fieldId);
            case 2 :
                return onChangeSearchView((com.icarus.databinding.ItemSearchLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelFilterCount(androidx.databinding.ObservableInt ViewModelFilterCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsFilterApplied(androidx.databinding.ObservableBoolean ViewModelIsFilterApplied, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSearchView(com.icarus.databinding.ItemSearchLayoutBinding SearchView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        androidx.databinding.ObservableInt viewModelFilterCount = null;
        java.lang.String stringValueOfViewModelFilterCount = null;
        int viewModelIsFilterAppliedViewVISIBLEViewGONE = 0;
        boolean viewModelIsFilterAppliedGet = false;
        int viewModelFilterCountGet = 0;
        androidx.databinding.ObservableBoolean viewModelIsFilterApplied = null;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1bL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.filterCount
                        viewModelFilterCount = viewModel.filterCount;
                    }
                    updateRegistration(0, viewModelFilterCount);


                    if (viewModelFilterCount != null) {
                        // read viewModel.filterCount.get()
                        viewModelFilterCountGet = viewModelFilterCount.get();
                    }


                    // read String.valueOf(viewModel.filterCount.get())
                    stringValueOfViewModelFilterCount = java.lang.String.valueOf(viewModelFilterCountGet);
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isFilterApplied
                        viewModelIsFilterApplied = viewModel.isFilterApplied;
                    }
                    updateRegistration(1, viewModelIsFilterApplied);


                    if (viewModelIsFilterApplied != null) {
                        // read viewModel.isFilterApplied.get()
                        viewModelIsFilterAppliedGet = viewModelIsFilterApplied.get();
                    }
                if((dirtyFlags & 0x1aL) != 0) {
                    if(viewModelIsFilterAppliedGet) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read viewModel.isFilterApplied.get() ? View.VISIBLE : View.GONE
                    viewModelIsFilterAppliedViewVISIBLEViewGONE = ((viewModelIsFilterAppliedGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.mboundView2.setVisibility(viewModelIsFilterAppliedViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringValueOfViewModelFilterCount);
        }
        executeBindingsOn(searchView);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.filterCount
        flag 1 (0x2L): viewModel.isFilterApplied
        flag 2 (0x3L): searchView
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
        flag 5 (0x6L): viewModel.isFilterApplied.get() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): viewModel.isFilterApplied.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}