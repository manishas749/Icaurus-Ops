package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemWorkorderBindingImpl extends ItemWorkorderBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.view, 9);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView3;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView6;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback46;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemWorkorderBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ItemWorkorderBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[7]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (android.view.View) bindings[9]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            );
        this.assignedTo.setTag(null);
        this.dueDate.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView6 = (androidx.appcompat.widget.AppCompatTextView) bindings[6];
        this.mboundView6.setTag(null);
        this.newTitle.setTag(null);
        this.title.setTag(null);
        this.workorderId.setTag(null);
        setRootTag(root);
        // listeners
        mCallback46 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.item == variableId) {
            setItem((com.icarus.workorder.models.WorkOrderItems) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.workorder.models.WorkOrderItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
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
        boolean itemWorkorderIdJavaLangObjectNull = false;
        com.icarus.workorder.models.WorkOrderItems item = mItem;
        java.lang.String itemAssignee = null;
        int androidxDatabindingViewDataBindingSafeUnboxItemWorkorderId = 0;
        java.lang.Integer itemWorkorderId = null;
        java.lang.String itemTitle = null;
        java.lang.String itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalseStringFormatWorkorderIdAndroidStringWorkorderIdXStringValueOfItemWorkorderIdWorkorderIdAndroidStringWorkorderIdNoValue = null;
        java.lang.Integer itemWorkorderPriorityId = null;
        boolean itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalse = false;
        java.lang.String itemDueDate = null;
        boolean textUtilsIsEmptyItemDueDate = false;
        int textUtilsIsEmptyItemDueDateViewGONEViewVISIBLE = 0;
        java.lang.String stringFormatWorkorderIdAndroidStringWorkorderIdXStringValueOfItemWorkorderId = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0 = false;
        java.lang.String itemDueDays = null;
        int itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalseViewGONEViewVISIBLE = 0;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
        java.lang.String itemStatus = null;
        java.lang.String stringValueOfItemWorkorderId = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (item != null) {
                    // read item.assignee
                    itemAssignee = item.getAssignee();
                    // read item.workorderId
                    itemWorkorderId = item.getWorkorderId();
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.workorderPriorityId
                    itemWorkorderPriorityId = item.getWorkorderPriorityId();
                    // read item.dueDate
                    itemDueDate = item.getDueDate();
                    // read item.dueDays
                    itemDueDays = item.getDueDays();
                    // read item.status
                    itemStatus = item.getStatus();
                }


                // read item.workorderId != null
                itemWorkorderIdJavaLangObjectNull = (itemWorkorderId) != (null);
                // read TextUtils.isEmpty(item.dueDate)
                textUtilsIsEmptyItemDueDate = android.text.TextUtils.isEmpty(itemDueDate);
            if((dirtyFlags & 0x5L) != 0) {
                if(itemWorkorderIdJavaLangObjectNull) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }
            if((dirtyFlags & 0x5L) != 0) {
                if(textUtilsIsEmptyItemDueDate) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }


                // read TextUtils.isEmpty(item.dueDate) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyItemDueDateViewGONEViewVISIBLE = ((textUtilsIsEmptyItemDueDate) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished

        if ((dirtyFlags & 0x40L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId)
                androidxDatabindingViewDataBindingSafeUnboxItemWorkorderId = androidx.databinding.ViewDataBinding.safeUnbox(itemWorkorderId);


                // read androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0
                androidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0 = (androidxDatabindingViewDataBindingSafeUnboxItemWorkorderId) > (0);
        }

        if ((dirtyFlags & 0x5L) != 0) {

                // read item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false
                itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalse = ((itemWorkorderIdJavaLangObjectNull) ? (androidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0) : (false));
            if((dirtyFlags & 0x5L) != 0) {
                if(itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalse) {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x400L;
                }
                else {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x200L;
                }
            }


                // read item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false ? View.GONE : View.VISIBLE
                itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalseViewGONEViewVISIBLE = ((itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalse) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        // batch finished

        if ((dirtyFlags & 0x10L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId)
                androidxDatabindingViewDataBindingSafeUnboxItemWorkorderId = androidx.databinding.ViewDataBinding.safeUnbox(itemWorkorderId);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId))
                stringValueOfItemWorkorderId = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxItemWorkorderId);


                // read String.format(@android:string/workorder_id_x, String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId)))
                stringFormatWorkorderIdAndroidStringWorkorderIdXStringValueOfItemWorkorderId = java.lang.String.format(workorderId.getResources().getString(R.string.workorder_id_x), stringValueOfItemWorkorderId);
        }

        if ((dirtyFlags & 0x5L) != 0) {

                // read item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false ? String.format(@android:string/workorder_id_x, String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId))) : @android:string/workorder_id_no_value
                itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalseStringFormatWorkorderIdAndroidStringWorkorderIdXStringValueOfItemWorkorderIdWorkorderIdAndroidStringWorkorderIdNoValue = ((itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalse) ? (stringFormatWorkorderIdAndroidStringWorkorderIdXStringValueOfItemWorkorderId) : (workorderId.getResources().getString(R.string.workorder_id_no_value)));
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.assignedTo, itemAssignee);
            this.dueDate.setVisibility(textUtilsIsEmptyItemDueDateViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setText(this.dueDate, itemDueDays);
            this.mboundView3.setVisibility(itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalseViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setText(this.mboundView6, itemWorkorderPriorityId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.newTitle, itemStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, itemTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.workorderId, itemWorkorderIdJavaLangObjectNullAndroidxDatabindingViewDataBindingSafeUnboxItemWorkorderIdInt0BooleanFalseStringFormatWorkorderIdAndroidStringWorkorderIdXStringValueOfItemWorkorderIdWorkorderIdAndroidStringWorkorderIdNoValue);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback46);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // item
        com.icarus.workorder.models.WorkOrderItems item = mItem;
        // viewModel
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {



            viewModel.onWorkorderItemClick(item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false ? String.format(@android:string/workorder_id_x, String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId))) : @android:string/workorder_id_no_value
        flag 4 (0x5L): item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false ? String.format(@android:string/workorder_id_x, String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId))) : @android:string/workorder_id_no_value
        flag 5 (0x6L): item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false
        flag 6 (0x7L): item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false
        flag 7 (0x8L): TextUtils.isEmpty(item.dueDate) ? View.GONE : View.VISIBLE
        flag 8 (0x9L): TextUtils.isEmpty(item.dueDate) ? View.GONE : View.VISIBLE
        flag 9 (0xaL): item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false ? View.GONE : View.VISIBLE
        flag 10 (0xbL): item.workorderId != null ? androidx.databinding.ViewDataBinding.safeUnbox(item.workorderId) > 0 : false ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}