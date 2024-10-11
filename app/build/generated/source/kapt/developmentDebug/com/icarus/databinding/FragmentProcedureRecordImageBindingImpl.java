package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProcedureRecordImageBindingImpl extends FragmentProcedureRecordImageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.editAttribute, 3);
        sViewsWithIds.put(R.id.imgAdd, 4);
        sViewsWithIds.put(R.id.recyclerViewSelectedImages, 5);
        sViewsWithIds.put(R.id.btnSubmit, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProcedureRecordImageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentProcedureRecordImageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (android.widget.FrameLayout) bindings[3]
            , (android.widget.FrameLayout) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            );
        this.description.setTag(null);
        this.label.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
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
            setItem((com.icarus.models.CheckListStepAttributeItems) variable);
        }
        else if (BR.attributeNo == variableId) {
            setAttributeNo((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.CheckListStepAttributeItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setAttributeNo(@Nullable java.lang.Integer AttributeNo) {
        this.mAttributeNo = AttributeNo;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.attributeNo);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
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
        com.icarus.models.CheckListStepAttributeItems item = mItem;
        java.lang.String itemLabel = null;
        java.lang.Integer attributeNo = mAttributeNo;
        java.lang.String stringFormatLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel = null;
        java.lang.String itemGetDescription = null;

        if ((dirtyFlags & 0xbL) != 0) {



                if (item != null) {
                    // read item.label
                    itemLabel = item.getLabel();
                }


                // read String.format(@android:string/attribute_label_bullet, attributeNo, item.label)
                stringFormatLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel = java.lang.String.format(label.getResources().getString(R.string.attribute_label_bullet), attributeNo, itemLabel);
            if ((dirtyFlags & 0x9L) != 0) {

                    if (item != null) {
                        // read item.getDescription()
                        itemGetDescription = item.getDescription();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.description, itemGetDescription);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.label, stringFormatLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): attributeNo
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}