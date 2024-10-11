package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDashboardBindingImpl extends ActivityDashboardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(0, 
            new String[] {"app_bar_base_navigation_drawer"},
            new int[] {3},
            new int[] {com.icarus.R.layout.app_bar_base_navigation_drawer});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.version, 4);
        sViewsWithIds.put(R.id.divider, 5);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDashboardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityDashboardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.view.View) bindings[5]
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (com.google.android.material.navigation.NavigationView) bindings[1]
            , (com.icarus.databinding.AppBarBaseNavigationDrawerBinding) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.drawerLayout.setTag(null);
        this.navView.setTag(null);
        setContainedBinding(this.navigationDrawer);
        this.sync.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        navigationDrawer.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (navigationDrawer.hasPendingBindings()) {
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
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        navigationDrawer.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelLastSync((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeNavigationDrawer((com.icarus.databinding.AppBarBaseNavigationDrawerBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelLastSync(androidx.databinding.ObservableField<java.lang.String> ViewModelLastSync, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNavigationDrawer(com.icarus.databinding.AppBarBaseNavigationDrawerBinding NavigationDrawer, int fieldId) {
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
        java.lang.String stringFormatSyncAndroidStringLastSyncXViewModelLastSync = null;
        java.lang.String viewModelLastSyncGet = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelLastSync = null;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {



                if (viewModel != null) {
                    // read viewModel.lastSync
                    viewModelLastSync = viewModel.lastSync;
                }
                updateRegistration(0, viewModelLastSync);


                if (viewModelLastSync != null) {
                    // read viewModel.lastSync.get()
                    viewModelLastSyncGet = viewModelLastSync.get();
                }


                // read String.format(@android:string/last_sync_x, viewModel.lastSync.get())
                stringFormatSyncAndroidStringLastSyncXViewModelLastSync = java.lang.String.format(sync.getResources().getString(R.string.last_sync_x), viewModelLastSyncGet);
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.loadHeader(this.navView, viewModel);
            this.navigationDrawer.setViewModel(viewModel);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.sync, stringFormatSyncAndroidStringLastSyncXViewModelLastSync);
        }
        executeBindingsOn(navigationDrawer);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.lastSync
        flag 1 (0x2L): navigationDrawer
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}