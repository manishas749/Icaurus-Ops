package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemEquipmentsBindingImpl extends ItemEquipmentsBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemEquipmentsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ItemEquipmentsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            );
        this.img.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.folderName == variableId) {
            setFolderName((java.lang.String) variable);
        }
        else if (BR.fileName == variableId) {
            setFileName((java.lang.String) variable);
        }
        else if (BR.itemUUID == variableId) {
            setItemUUID((java.lang.String) variable);
        }
        else if (BR.name == variableId) {
            setName((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFolderName(@Nullable java.lang.String FolderName) {
        this.mFolderName = FolderName;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.folderName);
        super.requestRebind();
    }
    public void setFileName(@Nullable java.lang.String FileName) {
        this.mFileName = FileName;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.fileName);
        super.requestRebind();
    }
    public void setItemUUID(@Nullable java.lang.String ItemUUID) {
        this.mItemUUID = ItemUUID;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.itemUUID);
        super.requestRebind();
    }
    public void setName(@Nullable java.lang.String Name) {
        this.mName = Name;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.name);
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
        java.lang.String folderName = mFolderName;
        java.lang.String fileName = mFileName;
        java.lang.String itemUUID = mItemUUID;
        java.lang.String name = mName;

        if ((dirtyFlags & 0x17L) != 0) {
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x17L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setResourcesThumbnail(this.img, fileName, folderName, itemUUID, com.icarus.util.ImageLoader.ImageType.PPE);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, name);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): folderName
        flag 1 (0x2L): fileName
        flag 2 (0x3L): itemUUID
        flag 3 (0x4L): name
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}