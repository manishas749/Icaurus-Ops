package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAssignChecklistBindingImpl extends ItemAssignChecklistBinding  {

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
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAssignChecklistBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemAssignChecklistBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.checkBoxSelect.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView.setTag(null);
        this.textViewRole.setTag(null);
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
        if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.userItem == variableId) {
            setUserItem((com.icarus.models.UserItems) variable);
        }
        else if (BR.isEnabled == variableId) {
            setIsEnabled((java.lang.Boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
    }
    public void setUserItem(@Nullable com.icarus.models.UserItems UserItem) {
        this.mUserItem = UserItem;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.userItem);
        super.requestRebind();
    }
    public void setIsEnabled(@Nullable java.lang.Boolean IsEnabled) {
        this.mIsEnabled = IsEnabled;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.isEnabled);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        boolean userItemIsSelected = false;
        java.lang.String userItemGetRole = null;
        com.icarus.models.UserItems userItem = mUserItem;
        boolean androidxDatabindingViewDataBindingSafeUnboxIsEnabled = false;
        java.lang.Boolean isEnabled = mIsEnabled;
        java.lang.String userItemFullName = null;

        if ((dirtyFlags & 0xaL) != 0) {



                if (userItem != null) {
                    // read userItem.isSelected()
                    userItemIsSelected = userItem.isSelected();
                    // read userItem.getRole()
                    userItemGetRole = userItem.getRole();
                    // read userItem.fullName
                    userItemFullName = userItem.getFullName();
                }
        }
        if ((dirtyFlags & 0xcL) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(isEnabled)
                androidxDatabindingViewDataBindingSafeUnboxIsEnabled = androidx.databinding.ViewDataBinding.safeUnbox(isEnabled);
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.checkBoxSelect, userItemIsSelected);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, userItemFullName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewRole, userItemGetRole);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.checkBoxSelect.setEnabled(androidxDatabindingViewDataBindingSafeUnboxIsEnabled);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): position
        flag 1 (0x2L): userItem
        flag 2 (0x3L): isEnabled
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}