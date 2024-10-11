package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemViewReportNoteBindingImpl extends ItemViewReportNoteBinding  {

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

    public ItemViewReportNoteBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemViewReportNoteBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.comment.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.updatedAt.setTag(null);
        this.updatedBy.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setItem((com.icarus.models.ChecklistNotesItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.ChecklistNotesItem Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
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
        com.icarus.models.ChecklistNotesItem item = mItem;
        java.lang.String stringFormatUpdatedByAndroidStringViewReportNoteCompletedByItemUserFullName = null;
        java.lang.String itemUserFullName = null;
        java.lang.String itemUpdatedAt = null;
        java.lang.String itemComment = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.userFullName
                    itemUserFullName = item.getUserFullName();
                    // read item.updatedAt
                    itemUpdatedAt = item.getUpdatedAt();
                    // read item.comment
                    itemComment = item.getComment();
                }


                // read String.format(@android:string/view_report_note_completed_by, item.userFullName)
                stringFormatUpdatedByAndroidStringViewReportNoteCompletedByItemUserFullName = java.lang.String.format(updatedBy.getResources().getString(R.string.view_report_note_completed_by), itemUserFullName);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.comment, itemComment);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.updatedAt, itemUpdatedAt);
            com.icarus.bindings.CustomViewBindings.setHTMLText(this.updatedBy, stringFormatUpdatedByAndroidStringViewReportNoteCompletedByItemUserFullName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}