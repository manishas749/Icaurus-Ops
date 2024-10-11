package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemReferenceTitleBindingImpl extends ItemReferenceTitleBinding  {

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

    public ItemReferenceTitleBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private ItemReferenceTitleBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[0]
            );
        this.tvName.setTag(null);
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
        if (BR.isDownloaded == variableId) {
            setIsDownloaded((java.lang.Integer) variable);
        }
        else if (BR.name == variableId) {
            setName((java.lang.String) variable);
        }
        else if (BR.downloadPath == variableId) {
            setDownloadPath((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIsDownloaded(@Nullable java.lang.Integer IsDownloaded) {
        this.mIsDownloaded = IsDownloaded;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.isDownloaded);
        super.requestRebind();
    }
    public void setName(@Nullable java.lang.String Name) {
        this.mName = Name;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.name);
        super.requestRebind();
    }
    public void setDownloadPath(@Nullable java.lang.String DownloadPath) {
        this.mDownloadPath = DownloadPath;
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
        int isDownloadedInt1TvNameAndroidColorChecklistSubHeadTvNameAndroidColorColorPrimary = 0;
        java.lang.Integer isDownloaded = mIsDownloaded;
        boolean isDownloadedInt1 = false;
        int androidxDatabindingViewDataBindingSafeUnboxIsDownloaded = 0;
        java.lang.String name = mName;

        if ((dirtyFlags & 0x9L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(isDownloaded)
                androidxDatabindingViewDataBindingSafeUnboxIsDownloaded = androidx.databinding.ViewDataBinding.safeUnbox(isDownloaded);


                // read androidx.databinding.ViewDataBinding.safeUnbox(isDownloaded) == 1
                isDownloadedInt1 = (androidxDatabindingViewDataBindingSafeUnboxIsDownloaded) == (1);
            if((dirtyFlags & 0x9L) != 0) {
                if(isDownloadedInt1) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(isDownloaded) == 1 ? @android:color/checklist_sub_head : @android:color/colorPrimary
                isDownloadedInt1TvNameAndroidColorChecklistSubHeadTvNameAndroidColorColorPrimary = ((isDownloadedInt1) ? (getColorFromResource(tvName, R.color.checklist_sub_head)) : (getColorFromResource(tvName, R.color.colorPrimary)));
        }
        if ((dirtyFlags & 0xaL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, name);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            this.tvName.setTextColor(isDownloadedInt1TvNameAndroidColorChecklistSubHeadTvNameAndroidColorColorPrimary);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): isDownloaded
        flag 1 (0x2L): name
        flag 2 (0x3L): downloadPath
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(isDownloaded) == 1 ? @android:color/checklist_sub_head : @android:color/colorPrimary
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(isDownloaded) == 1 ? @android:color/checklist_sub_head : @android:color/colorPrimary
    flag mapping end*/
    //end
}