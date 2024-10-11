package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PopupReferencesBindingImpl extends PopupReferencesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvTitle, 3);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PopupReferencesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private PopupReferencesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.recyclerView.setTag(null);
        this.recyclerViewLinks.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.linksAdapter == variableId) {
            setLinksAdapter((com.icarus.adapters.ReferenceLinksAdapter) variable);
        }
        else if (BR.adapter == variableId) {
            setAdapter((com.icarus.adapters.ReferencesAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLinksAdapter(@Nullable com.icarus.adapters.ReferenceLinksAdapter LinksAdapter) {
        this.mLinksAdapter = LinksAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.linksAdapter);
        super.requestRebind();
    }
    public void setAdapter(@Nullable com.icarus.adapters.ReferencesAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.adapter);
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
        com.icarus.adapters.ReferenceLinksAdapter linksAdapter = mLinksAdapter;
        com.icarus.adapters.ReferencesAdapter adapter = mAdapter;

        if ((dirtyFlags & 0x5L) != 0) {
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerView, adapter);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewLinks, linksAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): linksAdapter
        flag 1 (0x2L): adapter
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}