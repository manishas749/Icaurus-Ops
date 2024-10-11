package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWorkorderBindingImpl extends ActivityWorkorderBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(4);
        sIncludes.setIncludes(0, 
            new String[] {"app_bar_base_navigation_drawer"},
            new int[] {1},
            new int[] {com.icarus.R.layout.app_bar_base_navigation_drawer});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nav_view, 2);
        sViewsWithIds.put(R.id.sync, 3);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWorkorderBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityWorkorderBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (com.google.android.material.navigation.NavigationView) bindings[2]
            , (com.icarus.databinding.AppBarBaseNavigationDrawerBinding) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.drawerLayout.setTag(null);
        setContainedBinding(this.navigationDrawer);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderViewModel ViewModel) {
        this.mViewModel = ViewModel;
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
                return onChangeNavigationDrawer((com.icarus.databinding.AppBarBaseNavigationDrawerBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeNavigationDrawer(com.icarus.databinding.AppBarBaseNavigationDrawerBinding NavigationDrawer, int fieldId) {
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
        // batch finished
        executeBindingsOn(navigationDrawer);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): navigationDrawer
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}