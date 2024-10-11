package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityChecklistExecutionBindingImpl extends ActivityChecklistExecutionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(0, 
            new String[] {"item_execution_bottom_bar", "step_execution_floating_menu"},
            new int[] {3, 4},
            new int[] {com.icarus.R.layout.item_execution_bottom_bar,
                com.icarus.R.layout.step_execution_floating_menu});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.frame_layout, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChecklistExecutionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityChecklistExecutionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (com.icarus.databinding.ItemExecutionBottomBarBinding) bindings[3]
            , (com.icarus.databinding.StepExecutionFloatingMenuBinding) bindings[4]
            , (android.widget.FrameLayout) bindings[5]
            , (android.widget.ProgressBar) bindings[2]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            );
        setContainedBinding(this.bottomBar);
        setContainedBinding(this.fabMenu);
        this.loginProgress.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.toolbar.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        bottomBar.invalidateAll();
        fabMenu.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (bottomBar.hasPendingBindings()) {
            return true;
        }
        if (fabMenu.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        bottomBar.setLifecycleOwner(lifecycleOwner);
        fabMenu.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBottomBar((com.icarus.databinding.ItemExecutionBottomBarBinding) object, fieldId);
            case 1 :
                return onChangeFabMenu((com.icarus.databinding.StepExecutionFloatingMenuBinding) object, fieldId);
            case 2 :
                return onChangeViewModelToolbarTitle((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelIsLoading((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBottomBar(com.icarus.databinding.ItemExecutionBottomBarBinding BottomBar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeFabMenu(com.icarus.databinding.StepExecutionFloatingMenuBinding FabMenu, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelToolbarTitle(androidx.databinding.ObservableField<java.lang.String> ViewModelToolbarTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsLoading(androidx.databinding.ObservableBoolean ViewModelIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        java.lang.String viewModelToolbarTitleGet = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelToolbarTitle = null;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        boolean viewModelIsLoadingGet = false;
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x3cL) != 0) {


            if ((dirtyFlags & 0x34L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.toolbarTitle
                        viewModelToolbarTitle = viewModel.toolbarTitle;
                    }
                    updateRegistration(2, viewModelToolbarTitle);


                    if (viewModelToolbarTitle != null) {
                        // read viewModel.toolbarTitle.get()
                        viewModelToolbarTitleGet = viewModelToolbarTitle.get();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isLoading
                        viewModelIsLoading = viewModel.getIsLoading();
                    }
                    updateRegistration(3, viewModelIsLoading);


                    if (viewModelIsLoading != null) {
                        // read viewModel.isLoading.get()
                        viewModelIsLoadingGet = viewModelIsLoading.get();
                    }
                if((dirtyFlags & 0x38L) != 0) {
                    if(viewModelIsLoadingGet) {
                            dirtyFlags |= 0x80L;
                    }
                    else {
                            dirtyFlags |= 0x40L;
                    }
                }


                    // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                    viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            this.bottomBar.setViewModel(viewModel);
            this.fabMenu.setViewModel(viewModel);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            this.loginProgress.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            this.toolbar.setTitle(viewModelToolbarTitleGet);
        }
        executeBindingsOn(bottomBar);
        executeBindingsOn(fabMenu);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): bottomBar
        flag 1 (0x2L): fabMenu
        flag 2 (0x3L): viewModel.toolbarTitle
        flag 3 (0x4L): viewModel.isLoading
        flag 4 (0x5L): viewModel
        flag 5 (0x6L): null
        flag 6 (0x7L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}