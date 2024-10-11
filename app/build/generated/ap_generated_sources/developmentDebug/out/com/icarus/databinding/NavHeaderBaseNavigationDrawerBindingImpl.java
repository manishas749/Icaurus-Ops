package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class NavHeaderBaseNavigationDrawerBindingImpl extends NavHeaderBaseNavigationDrawerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 3);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public NavHeaderBaseNavigationDrawerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private NavHeaderBaseNavigationDrawerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.location.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
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
        if (BR.item == variableId) {
            setItem((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.viewmodels.DashboardViewModel Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItemUserName((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeItemLocationName((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItemUserName(androidx.databinding.ObservableField<java.lang.String> ItemUserName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeItemLocationName(androidx.databinding.ObservableField<java.lang.String> ItemLocationName, int fieldId) {
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
        com.icarus.viewmodels.DashboardViewModel item = mItem;
        java.lang.String itemLocationNameGet = null;
        androidx.databinding.ObservableField<java.lang.String> itemUserName = null;
        java.lang.String itemUserNameGet = null;
        androidx.databinding.ObservableField<java.lang.String> itemLocationName = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (item != null) {
                        // read item.userName
                        itemUserName = item.userName;
                    }
                    updateRegistration(0, itemUserName);


                    if (itemUserName != null) {
                        // read item.userName.get()
                        itemUserNameGet = itemUserName.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (item != null) {
                        // read item.locationName
                        itemLocationName = item.locationName;
                    }
                    updateRegistration(1, itemLocationName);


                    if (itemLocationName != null) {
                        // read item.locationName.get()
                        itemLocationNameGet = itemLocationName.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.location, itemLocationNameGet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, itemUserNameGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item.userName
        flag 1 (0x2L): item.locationName
        flag 2 (0x3L): item
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}