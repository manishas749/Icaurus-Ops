package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTermsAndConditionsBindingImpl extends ActivityTermsAndConditionsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"content_terms_and_conditions"},
            new int[] {1},
            new int[] {com.icarus.R.layout.content_terms_and_conditions});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar, 2);
        sViewsWithIds.put(R.id.toolbar_layout, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTermsAndConditionsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityTermsAndConditionsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.appbar.AppBarLayout) bindings[2]
            , (com.icarus.databinding.ContentTermsAndConditionsBinding) bindings[1]
            , (androidx.appcompat.widget.Toolbar) bindings[4]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[3]
            );
        setContainedBinding(this.contentTermsAndConditions);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        contentTermsAndConditions.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (contentTermsAndConditions.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.TermsAndConditionsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.TermsAndConditionsViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        contentTermsAndConditions.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContentTermsAndConditions((com.icarus.databinding.ContentTermsAndConditionsBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContentTermsAndConditions(com.icarus.databinding.ContentTermsAndConditionsBinding ContentTermsAndConditions, int fieldId) {
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
        executeBindingsOn(contentTermsAndConditions);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): contentTermsAndConditions
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}