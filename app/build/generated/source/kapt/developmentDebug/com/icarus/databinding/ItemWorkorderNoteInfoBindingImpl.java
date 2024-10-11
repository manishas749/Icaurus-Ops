package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemWorkorderNoteInfoBindingImpl extends ItemWorkorderNoteInfoBinding  {

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
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView2;
    @NonNull
    private final androidx.recyclerview.widget.RecyclerView mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemWorkorderNoteInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ItemWorkorderNoteInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (android.view.View) bindings[5]
            );
        this.attachmentCount.setTag(null);
        this.content.setTag(null);
        this.description.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatTextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView7 = (androidx.recyclerview.widget.RecyclerView) bindings[7];
        this.mboundView7.setTag(null);
        this.title.setTag(null);
        this.view.setTag(null);
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
            setItem((com.icarus.workorder.models.WorkOrderNoteInfoItems) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.workorder.models.WorkOrderNoteInfoItems Item) {
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
    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderDetailViewModel ViewModel) {
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
        com.icarus.workorder.models.WorkOrderNoteInfoItems item = mItem;
        java.lang.String stringFormatAttachmentCountAndroidStringXAttachmentItemGetAttachmentsSize = null;
        java.lang.Integer position = mPosition;
        java.util.List<com.icarus.workorder.models.WorkOrderAttachmentItems> itemGetAttachments = null;
        java.lang.String stringFormatTitleAndroidStringUpdatedByXItemName = null;
        boolean positionInt0 = false;
        int itemGetAttachmentsSize = 0;
        int itemGetAttachmentsSizeInt0ViewVISIBLEViewGONE = 0;
        java.lang.String itemCreated = null;
        java.lang.String positionInt0StringFormatTitleAndroidStringAddedByXItemNameStringFormatTitleAndroidStringUpdatedByXItemName = null;
        java.lang.String itemName = null;
        boolean textUtilsIsEmptyItemWorkorderNotes = false;
        int textUtilsIsEmptyItemWorkorderNotesViewGONEViewVISIBLE = 0;
        int androidxDatabindingViewDataBindingSafeUnboxPosition = 0;
        com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;
        java.lang.String stringFormatTitleAndroidStringAddedByXItemName = null;
        boolean itemGetAttachmentsSizeInt0 = false;
        java.lang.String itemWorkorderNotes = null;

        if ((dirtyFlags & 0xdL) != 0) {



                if (item != null) {
                    // read item.getAttachments()
                    itemGetAttachments = item.getAttachments();
                }

            if ((dirtyFlags & 0x9L) != 0) {

                    if (itemGetAttachments != null) {
                        // read item.getAttachments().size()
                        itemGetAttachmentsSize = itemGetAttachments.size();
                    }


                    // read String.format(@android:string/x_attachment, item.getAttachments().size())
                    stringFormatAttachmentCountAndroidStringXAttachmentItemGetAttachmentsSize = java.lang.String.format(attachmentCount.getResources().getString(R.string.x_attachment), itemGetAttachmentsSize);
                    // read item.getAttachments().size() > 0
                    itemGetAttachmentsSizeInt0 = (itemGetAttachmentsSize) > (0);
                if((dirtyFlags & 0x9L) != 0) {
                    if(itemGetAttachmentsSizeInt0) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }


                    // read item.getAttachments().size() > 0 ? View.VISIBLE : View.GONE
                    itemGetAttachmentsSizeInt0ViewVISIBLEViewGONE = ((itemGetAttachmentsSizeInt0) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x9L) != 0) {

                    if (item != null) {
                        // read item.created
                        itemCreated = item.getCreated();
                        // read item.workorderNotes
                        itemWorkorderNotes = item.getWorkorderNotes();
                    }


                    // read TextUtils.isEmpty(item.workorderNotes)
                    textUtilsIsEmptyItemWorkorderNotes = android.text.TextUtils.isEmpty(itemWorkorderNotes);
                if((dirtyFlags & 0x9L) != 0) {
                    if(textUtilsIsEmptyItemWorkorderNotes) {
                            dirtyFlags |= 0x200L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                    }
                }


                    // read TextUtils.isEmpty(item.workorderNotes) ? View.GONE : View.VISIBLE
                    textUtilsIsEmptyItemWorkorderNotesViewGONEViewVISIBLE = ((textUtilsIsEmptyItemWorkorderNotes) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }
        }
        if ((dirtyFlags & 0xbL) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(position)
                androidxDatabindingViewDataBindingSafeUnboxPosition = androidx.databinding.ViewDataBinding.safeUnbox(position);


                // read androidx.databinding.ViewDataBinding.safeUnbox(position) == 0
                positionInt0 = (androidxDatabindingViewDataBindingSafeUnboxPosition) == (0);
            if((dirtyFlags & 0xbL) != 0) {
                if(positionInt0) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0xc0L) != 0) {



                if (item != null) {
                    // read item.name
                    itemName = item.getName();
                }

            if ((dirtyFlags & 0x40L) != 0) {

                    // read String.format(@android:string/updated_by_x, item.name)
                    stringFormatTitleAndroidStringUpdatedByXItemName = java.lang.String.format(title.getResources().getString(R.string.updated_by_x), itemName);
            }
            if ((dirtyFlags & 0x80L) != 0) {

                    // read String.format(@android:string/added_by_x, item.name)
                    stringFormatTitleAndroidStringAddedByXItemName = java.lang.String.format(title.getResources().getString(R.string.added_by_x), itemName);
            }
        }

        if ((dirtyFlags & 0xbL) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(position) == 0 ? String.format(@android:string/added_by_x, item.name) : String.format(@android:string/updated_by_x, item.name)
                positionInt0StringFormatTitleAndroidStringAddedByXItemNameStringFormatTitleAndroidStringUpdatedByXItemName = ((positionInt0) ? (stringFormatTitleAndroidStringAddedByXItemName) : (stringFormatTitleAndroidStringUpdatedByXItemName));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.attachmentCount, stringFormatAttachmentCountAndroidStringXAttachmentItemGetAttachmentsSize);
            this.attachmentCount.setVisibility(itemGetAttachmentsSizeInt0ViewVISIBLEViewGONE);
            com.icarus.workorder.models.WorkOrderNoteInfoItems.setContent(this.content, item);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.description, itemWorkorderNotes);
            this.description.setVisibility(textUtilsIsEmptyItemWorkorderNotesViewGONEViewVISIBLE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, itemCreated);
            this.mboundView7.setVisibility(itemGetAttachmentsSizeInt0ViewVISIBLEViewGONE);
            this.view.setVisibility(itemGetAttachmentsSizeInt0ViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            com.icarus.workorder.models.WorkOrderNoteInfoItems.setRecyclerView(this.mboundView7, itemGetAttachments, viewModel);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, positionInt0StringFormatTitleAndroidStringAddedByXItemNameStringFormatTitleAndroidStringUpdatedByXItemName);
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
        flag 4 (0x5L): item.getAttachments().size() > 0 ? View.VISIBLE : View.GONE
        flag 5 (0x6L): item.getAttachments().size() > 0 ? View.VISIBLE : View.GONE
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(position) == 0 ? String.format(@android:string/added_by_x, item.name) : String.format(@android:string/updated_by_x, item.name)
        flag 7 (0x8L): androidx.databinding.ViewDataBinding.safeUnbox(position) == 0 ? String.format(@android:string/added_by_x, item.name) : String.format(@android:string/updated_by_x, item.name)
        flag 8 (0x9L): TextUtils.isEmpty(item.workorderNotes) ? View.GONE : View.VISIBLE
        flag 9 (0xaL): TextUtils.isEmpty(item.workorderNotes) ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}