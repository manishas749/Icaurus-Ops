package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemChecklistDetailBindingImpl extends ItemChecklistDetailBinding  {

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
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemChecklistDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemChecklistDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.check.setTag(null);
        this.description.setTag(null);
        this.image.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.recyclerIcons.setTag(null);
        this.sequenceNumber.setTag(null);
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
            setItem((com.icarus.models.ChecklistElementItem) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistDetailListingViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.ChecklistElementItem Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistDetailListingViewModel ViewModel) {
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
        com.icarus.models.ChecklistElementItem item = mItem;
        java.lang.String itemIsStepProcedureDataStepItemTitleItemDescription = null;
        java.lang.String itemGetItemUuid = null;
        java.lang.String itemTitle = null;
        boolean itemIsResource = false;
        java.util.List<java.lang.String> itemGetHazardsIconList = null;
        boolean itemIsStepProcedureDataStep = false;
        java.lang.String itemDescription = null;
        java.lang.String itemGetSequenceNo = null;
        java.util.List<java.lang.String> itemGetPPEsIconList = null;
        int itemIsResourceViewVISIBLEViewGONE = 0;
        int itemIsResourceViewGONEViewVISIBLE = 0;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.getItemUuid()
                    itemGetItemUuid = item.getItemUuid();
                    // read item.isResource()
                    itemIsResource = item.isResource();
                    // read item.getHazardsIconList()
                    itemGetHazardsIconList = item.getHazardsIconList();
                    // read item.isStepProcedureDataStep()
                    itemIsStepProcedureDataStep = item.isStepProcedureDataStep();
                    // read item.getSequenceNo()
                    itemGetSequenceNo = item.getSequenceNo();
                    // read item.getPPEsIconList()
                    itemGetPPEsIconList = item.getPPEsIconList();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsResource) {
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x100L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsStepProcedureDataStep) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read item.isResource() ? View.VISIBLE : View.GONE
                itemIsResourceViewVISIBLEViewGONE = ((itemIsResource) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read item.isResource() ? View.GONE : View.VISIBLE
                itemIsResourceViewGONEViewVISIBLE = ((itemIsResource) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished

        if ((dirtyFlags & 0x20L) != 0) {

                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                }
        }
        if ((dirtyFlags & 0x10L) != 0) {

                if (item != null) {
                    // read item.description
                    itemDescription = item.getDescription();
                }
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.isStepProcedureDataStep() ? item.title : item.description
                itemIsStepProcedureDataStepItemTitleItemDescription = ((itemIsStepProcedureDataStep) ? (itemTitle) : (itemDescription));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setAcknowledgedIcon(this.check, item);
            this.description.setVisibility(itemIsResourceViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.description, itemIsStepProcedureDataStepItemTitleItemDescription);
            this.image.setVisibility(itemIsResourceViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setEmbeddedImage(this.image, item);
            com.icarus.bindings.CustomViewBindings.setEquipmentList(this.recyclerIcons, itemGetPPEsIconList, itemGetHazardsIconList, itemGetItemUuid);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.sequenceNumber, itemGetSequenceNo);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): position
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): item.isStepProcedureDataStep() ? item.title : item.description
        flag 5 (0x6L): item.isStepProcedureDataStep() ? item.title : item.description
        flag 6 (0x7L): item.isResource() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): item.isResource() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): item.isResource() ? View.GONE : View.VISIBLE
        flag 9 (0xaL): item.isResource() ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}