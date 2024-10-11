package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemPendingElementsBindingImpl extends ItemPendingElementsBinding implements com.icarus.generated.callback.OnClickListener.Listener {

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
    @Nullable
    private final android.view.View.OnClickListener mCallback45;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemPendingElementsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemPendingElementsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.check.setTag(null);
        this.image.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvDesc.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        // listeners
        mCallback45 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
            setItem((com.icarus.models.ChecklistDetailItems) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.ChecklistDetailItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistDetailViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
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
        boolean itemItemTypeIdChecklistElementTypeRESOURCEGetValue = false;
        com.icarus.models.ChecklistDetailItems item = mItem;
        java.lang.Integer position = mPosition;
        boolean itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValue = false;
        boolean itemItemTypeIdChecklistElementTypeSTEPGetValue = false;
        java.lang.String itemGetItemUuid = null;
        java.lang.String itemTitle = null;
        java.lang.String itemDescription = null;
        java.lang.String itemSequenceNo = null;
        java.lang.String itemGetDescription = null;
        int itemItemTypeId = 0;
        boolean itemItemTypeIdChecklistElementTypeDATASTEPGetValue = false;
        int itemItemTypeIdChecklistElementTypeRESOURCEGetValueViewVISIBLEViewGONE = 0;
        boolean itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValue = false;
        boolean itemItemTypeIdChecklistElementTypeMEMORYLINEGetValue = false;
        boolean itemItemTypeIdChecklistElementTypePROCEDUREGetValue = false;
        java.lang.String itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValueItemTitleItemDescription = null;
        com.icarus.viewmodels.ChecklistDetailViewModel viewModel = mViewModel;
        int itemItemTypeIdChecklistElementTypeRESOURCEGetValueViewGONEViewVISIBLE = 0;
        boolean itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValue = false;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.getItemUuid()
                    itemGetItemUuid = item.getItemUuid();
                    // read item.sequenceNo
                    itemSequenceNo = item.getSequenceNo();
                    // read item.getDescription()
                    itemGetDescription = item.getDescription();
                    // read item.itemTypeId
                    itemItemTypeId = item.getItemTypeId();
                }


                // read item.itemTypeId == ChecklistElementType.RESOURCE.getValue()
                itemItemTypeIdChecklistElementTypeRESOURCEGetValue = (itemItemTypeId) == (com.icarus.enums.ChecklistElementType.RESOURCE.getValue());
                // read item.itemTypeId == ChecklistElementType.STEP.getValue()
                itemItemTypeIdChecklistElementTypeSTEPGetValue = (itemItemTypeId) == (com.icarus.enums.ChecklistElementType.STEP.getValue());
            if((dirtyFlags & 0x9L) != 0) {
                if(itemItemTypeIdChecklistElementTypeRESOURCEGetValue) {
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x1000L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemItemTypeIdChecklistElementTypeSTEPGetValue) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }


                // read item.itemTypeId == ChecklistElementType.RESOURCE.getValue() ? View.VISIBLE : View.GONE
                itemItemTypeIdChecklistElementTypeRESOURCEGetValueViewVISIBLEViewGONE = ((itemItemTypeIdChecklistElementTypeRESOURCEGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read item.itemTypeId == ChecklistElementType.RESOURCE.getValue() ? View.GONE : View.VISIBLE
                itemItemTypeIdChecklistElementTypeRESOURCEGetValueViewGONEViewVISIBLE = ((itemItemTypeIdChecklistElementTypeRESOURCEGetValue) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished

        if ((dirtyFlags & 0x100L) != 0) {

                // read item.itemTypeId == ChecklistElementType.PROCEDURE.getValue()
                itemItemTypeIdChecklistElementTypePROCEDUREGetValue = (itemItemTypeId) == (com.icarus.enums.ChecklistElementType.PROCEDURE.getValue());
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue()
                itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValue = ((itemItemTypeIdChecklistElementTypeSTEPGetValue) ? (true) : (itemItemTypeIdChecklistElementTypePROCEDUREGetValue));
            if((dirtyFlags & 0x9L) != 0) {
                if(itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValue) {
                        dirtyFlags |= 0x8000L;
                }
                else {
                        dirtyFlags |= 0x4000L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x4000L) != 0) {

                // read item.itemTypeId == ChecklistElementType.DATA_STEP.getValue()
                itemItemTypeIdChecklistElementTypeDATASTEPGetValue = (itemItemTypeId) == (com.icarus.enums.ChecklistElementType.DATA_STEP.getValue());
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue()
                itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValue = ((itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValue) ? (true) : (itemItemTypeIdChecklistElementTypeDATASTEPGetValue));
            if((dirtyFlags & 0x9L) != 0) {
                if(itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValue) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x10L) != 0) {

                // read item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue()
                itemItemTypeIdChecklistElementTypeMEMORYLINEGetValue = (itemItemTypeId) == (com.icarus.enums.ChecklistElementType.MEMORY_LINE.getValue());
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue()
                itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValue = ((itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValue) ? (true) : (itemItemTypeIdChecklistElementTypeMEMORYLINEGetValue));
            if((dirtyFlags & 0x9L) != 0) {
                if(itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValue) {
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x400L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x800L) != 0) {

                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                }
        }
        if ((dirtyFlags & 0x400L) != 0) {

                if (item != null) {
                    // read item.description
                    itemDescription = item.getDescription();
                }
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue() ? item.title : item.description
                itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValueItemTitleItemDescription = ((itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValue) ? (itemTitle) : (itemDescription));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setAcknowledgedIcon(this.check, item);
            this.image.setVisibility(itemItemTypeIdChecklistElementTypeRESOURCEGetValueViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setResourcesImage(this.image, itemGetDescription, com.icarus.constants.Constants.RESOURCES, itemGetItemUuid, itemItemTypeIdChecklistElementTypeRESOURCEGetValue);
            this.tvDesc.setVisibility(itemItemTypeIdChecklistElementTypeRESOURCEGetValueViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setItemDesc(this.tvDesc, itemItemTypeIdChecklistElementTypeSTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypePROCEDUREGetValueBooleanTrueItemItemTypeIdChecklistElementTypeDATASTEPGetValueBooleanTrueItemItemTypeIdChecklistElementTypeMEMORYLINEGetValueItemTitleItemDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, itemSequenceNo);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback45);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // item
        com.icarus.models.ChecklistDetailItems item = mItem;
        // position
        java.lang.Integer position = mPosition;
        // viewModel
        com.icarus.viewmodels.ChecklistDetailViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {




            viewModel.onChecklistClick(position, item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): position
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue()
        flag 5 (0x6L): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue()
        flag 6 (0x7L): item.itemTypeId == ChecklistElementType.RESOURCE.getValue() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): item.itemTypeId == ChecklistElementType.RESOURCE.getValue() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue()
        flag 9 (0xaL): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue()
        flag 10 (0xbL): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue() ? item.title : item.description
        flag 11 (0xcL): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.MEMORY_LINE.getValue() ? item.title : item.description
        flag 12 (0xdL): item.itemTypeId == ChecklistElementType.RESOURCE.getValue() ? View.GONE : View.VISIBLE
        flag 13 (0xeL): item.itemTypeId == ChecklistElementType.RESOURCE.getValue() ? View.GONE : View.VISIBLE
        flag 14 (0xfL): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue()
        flag 15 (0x10L): item.itemTypeId == ChecklistElementType.STEP.getValue() ? true : item.itemTypeId == ChecklistElementType.PROCEDURE.getValue() ? true : item.itemTypeId == ChecklistElementType.DATA_STEP.getValue()
    flag mapping end*/
    //end
}