package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemChecklistViewReportElementBindingImpl extends ItemChecklistViewReportElementBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.dashLine, 10);
        sViewsWithIds.put(R.id.barrier, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.Group mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemChecklistViewReportElementBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ItemChecklistViewReportElementBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.Barrier) bindings[11]
            , (com.icarus.customviews.DashedLine) bindings[10]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (android.widget.TextView) bindings[2]
            );
        this.desc.setTag(null);
        this.description.setTag(null);
        this.image.setTag(null);
        this.imageNCW.setTag(null);
        this.label.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView7 = (androidx.constraintlayout.widget.Group) bindings[7];
        this.mboundView7.setTag(null);
        this.recyclerIcons.setTag(null);
        this.recyclerLog.setTag(null);
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
        else if (BR.logsAdapter == variableId) {
            setLogsAdapter((com.icarus.adapters.ChecklistViewReportLogsAdapter) variable);
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
    public void setLogsAdapter(@Nullable com.icarus.adapters.ChecklistViewReportLogsAdapter LogsAdapter) {
        this.mLogsAdapter = LogsAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.logsAdapter);
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
        com.icarus.models.ChecklistElementItem item = mItem;
        java.lang.String itemIsStepProcedureDataStepItemTitleItemDescription = null;
        java.lang.String itemGetItemUuid = null;
        int itemIsStepViewVISIBLEViewGONE = 0;
        java.lang.String itemTitle = null;
        boolean itemIsResource = false;
        java.util.List<java.lang.String> itemGetHazardsIconList = null;
        boolean itemIsStepProcedureDataStep = false;
        java.lang.String itemIsResourceItemGetFileNameJavaLangString = null;
        java.lang.String itemDescription = null;
        int itemItemTypeId = 0;
        java.lang.String itemGetSequenceNo = null;
        boolean itemIsResourceBooleanTrueItemIsStep = false;
        java.util.List<java.lang.String> itemGetPPEsIconList = null;
        com.icarus.adapters.ChecklistViewReportLogsAdapter logsAdapter = mLogsAdapter;
        int itemIsResourceViewVISIBLEViewGONE = 0;
        boolean itemIsStep = false;
        int itemIsResourceBooleanTrueItemIsStepViewGONEViewVISIBLE = 0;
        java.lang.String itemGetFileName = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.getItemUuid()
                    itemGetItemUuid = item.getItemUuid();
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.isResource()
                    itemIsResource = item.isResource();
                    // read item.getHazardsIconList()
                    itemGetHazardsIconList = item.getHazardsIconList();
                    // read item.isStepProcedureDataStep()
                    itemIsStepProcedureDataStep = item.isStepProcedureDataStep();
                    // read item.description
                    itemDescription = item.getDescription();
                    // read item.itemTypeId
                    itemItemTypeId = item.getItemTypeId();
                    // read item.getSequenceNo()
                    itemGetSequenceNo = item.getSequenceNo();
                    // read item.getPPEsIconList()
                    itemGetPPEsIconList = item.getPPEsIconList();
                    // read item.isStep()
                    itemIsStep = item.isStep();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsResource) {
                        dirtyFlags |= 0x200L;
                        dirtyFlags |= 0x800L;
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x400L;
                        dirtyFlags |= 0x1000L;
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
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsStep) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }


                // read item.isResource() ? View.VISIBLE : View.GONE
                itemIsResourceViewVISIBLEViewGONE = ((itemIsResource) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read item.itemTypeId == ChecklistElementType.RESOURCE.getValue()
                itemItemTypeIdChecklistElementTypeRESOURCEGetValue = (itemItemTypeId) == (com.icarus.enums.ChecklistElementType.RESOURCE.getValue());
                // read item.isStep() ? View.VISIBLE : View.GONE
                itemIsStepViewVISIBLEViewGONE = ((itemIsStep) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0xcL) != 0) {
        }
        // batch finished

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.isStepProcedureDataStep() ? item.title : item.description
                itemIsStepProcedureDataStepItemTitleItemDescription = ((itemIsStepProcedureDataStep) ? (itemTitle) : (itemDescription));
                // read item.isResource() ? true : item.isStep()
                itemIsResourceBooleanTrueItemIsStep = ((itemIsResource) ? (true) : (itemIsStep));
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsResourceBooleanTrueItemIsStep) {
                        dirtyFlags |= 0x8000L;
                }
                else {
                        dirtyFlags |= 0x4000L;
                }
            }


                // read item.isResource() ? true : item.isStep() ? View.GONE : View.VISIBLE
                itemIsResourceBooleanTrueItemIsStepViewGONEViewVISIBLE = ((itemIsResourceBooleanTrueItemIsStep) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x200L) != 0) {

                if (item != null) {
                    // read item.getFileName()
                    itemGetFileName = item.getFileName();
                }
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read item.isResource() ? item.getFileName() : ""
                itemIsResourceItemGetFileNameJavaLangString = ((itemIsResource) ? (itemGetFileName) : (""));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.desc, itemDescription);
            this.description.setVisibility(itemIsResourceBooleanTrueItemIsStepViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.description, itemIsStepProcedureDataStepItemTitleItemDescription);
            this.image.setVisibility(itemIsResourceViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setResourcesImage(this.image, itemIsResourceItemGetFileNameJavaLangString, com.icarus.constants.Constants.RESOURCES, itemGetItemUuid, itemItemTypeIdChecklistElementTypeRESOURCEGetValue);
            com.icarus.models.ChecklistElementItem.setNCWIcon(this.imageNCW, itemItemTypeId);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.label, itemTitle);
            this.mboundView7.setVisibility(itemIsStepViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setEquipmentList(this.recyclerIcons, itemGetPPEsIconList, itemGetHazardsIconList, itemGetItemUuid);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.sequenceNumber, itemGetSequenceNo);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.recyclerLog, logsAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): position
        flag 2 (0x3L): logsAdapter
        flag 3 (0x4L): null
        flag 4 (0x5L): item.isStepProcedureDataStep() ? item.title : item.description
        flag 5 (0x6L): item.isStepProcedureDataStep() ? item.title : item.description
        flag 6 (0x7L): item.isStep() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): item.isStep() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): item.isResource() ? item.getFileName() : ""
        flag 9 (0xaL): item.isResource() ? item.getFileName() : ""
        flag 10 (0xbL): item.isResource() ? true : item.isStep()
        flag 11 (0xcL): item.isResource() ? true : item.isStep()
        flag 12 (0xdL): item.isResource() ? View.VISIBLE : View.GONE
        flag 13 (0xeL): item.isResource() ? View.VISIBLE : View.GONE
        flag 14 (0xfL): item.isResource() ? true : item.isStep() ? View.GONE : View.VISIBLE
        flag 15 (0x10L): item.isResource() ? true : item.isStep() ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}