package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemDepartmentChecklistBindingImpl extends ItemDepartmentChecklistBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.view, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback39;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemDepartmentChecklistBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ItemDepartmentChecklistBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (android.view.View) bindings[7]
            );
        this.cardView.setTag(null);
        this.departmentTitle.setTag(null);
        this.dueTitle.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.newTitle.setTag(null);
        this.roomAssets.setTag(null);
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        mCallback39 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
            setItem((com.icarus.models.DepartmentChecklistItems) variable);
        }
        else if (BR.checklistType == variableId) {
            setChecklistType((com.icarus.enums.ChecklistType) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.DepartmentChecklistItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setChecklistType(@Nullable com.icarus.enums.ChecklistType ChecklistType) {
        this.mChecklistType = ChecklistType;
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.DashboardViewModel ViewModel) {
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
        java.lang.String itemDepartmentName = null;
        com.icarus.models.DepartmentChecklistItems item = mItem;
        com.icarus.enums.ChecklistStatus itemGetChecklistSyncStatus = null;
        java.lang.String stringFormatDepartmentTitleAndroidStringTitleDepartmentItemDepartmentName = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue = false;
        java.lang.String itemTitle = null;
        int androidxDatabindingViewDataBindingSafeUnboxItemChecklistType = 0;
        boolean textUtilsIsEmptyItemDepartmentName = false;
        int itemGetDueStatus = 0;
        java.lang.String itemChecklistStatus = null;
        int textUtilsIsEmptyItemRoomEquipmentViewGONEViewVISIBLE = 0;
        java.lang.Integer itemChecklistType = null;
        java.lang.String itemDueDays = null;
        boolean textUtilsIsEmptyItemRoomEquipment = false;
        java.lang.String itemRoomEquipment = null;
        int textUtilsIsEmptyItemDepartmentNameViewGONEViewVISIBLE = 0;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
        java.lang.String departmentTitleAndroidStringTitleDepartmentItemDepartmentName = null;
        android.graphics.drawable.Drawable androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValueCardViewAndroidDrawableEmergencyBackgroundCardViewAndroidDrawableWhiteBackground = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.departmentName
                    itemDepartmentName = item.getDepartmentName();
                    // read item.getChecklistSyncStatus()
                    itemGetChecklistSyncStatus = item.getChecklistSyncStatus();
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.getDueStatus()
                    itemGetDueStatus = item.getDueStatus();
                    // read item.checklistStatus
                    itemChecklistStatus = item.getChecklistStatus();
                    // read item.checklistType
                    itemChecklistType = item.getChecklistType();
                    // read item.dueDays
                    itemDueDays = item.getDueDays();
                    // read item.roomEquipment
                    itemRoomEquipment = item.getRoomEquipment();
                }


                // read TextUtils.isEmpty(item.departmentName)
                textUtilsIsEmptyItemDepartmentName = android.text.TextUtils.isEmpty(itemDepartmentName);
                // read @android:string/title_department
                departmentTitleAndroidStringTitleDepartmentItemDepartmentName = departmentTitle.getResources().getString(R.string.title_department, itemDepartmentName);
                // read androidx.databinding.ViewDataBinding.safeUnbox(item.checklistType)
                androidxDatabindingViewDataBindingSafeUnboxItemChecklistType = androidx.databinding.ViewDataBinding.safeUnbox(itemChecklistType);
                // read TextUtils.isEmpty(item.roomEquipment)
                textUtilsIsEmptyItemRoomEquipment = android.text.TextUtils.isEmpty(itemRoomEquipment);
            if((dirtyFlags & 0x9L) != 0) {
                if(textUtilsIsEmptyItemDepartmentName) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(textUtilsIsEmptyItemRoomEquipment) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read TextUtils.isEmpty(item.departmentName) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyItemDepartmentNameViewGONEViewVISIBLE = ((textUtilsIsEmptyItemDepartmentName) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read String.format(@android:string/title_department)
                stringFormatDepartmentTitleAndroidStringTitleDepartmentItemDepartmentName = java.lang.String.format(departmentTitleAndroidStringTitleDepartmentItemDepartmentName);
                // read androidx.databinding.ViewDataBinding.safeUnbox(item.checklistType) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue())
                androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue = (androidxDatabindingViewDataBindingSafeUnboxItemChecklistType) == (androidx.databinding.ViewDataBinding.safeUnbox(com.icarus.enums.ChecklistType.Emergency.getValue()));
                // read TextUtils.isEmpty(item.roomEquipment) ? View.GONE : View.VISIBLE
                textUtilsIsEmptyItemRoomEquipmentViewGONEViewVISIBLE = ((textUtilsIsEmptyItemRoomEquipment) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            if((dirtyFlags & 0x9L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(item.checklistType) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue()) ? @android:drawable/emergency_background : @android:drawable/white_background
                androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValueCardViewAndroidDrawableEmergencyBackgroundCardViewAndroidDrawableWhiteBackground = ((androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(cardView.getContext(), R.drawable.emergency_background)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(cardView.getContext(), R.drawable.white_background)));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.cardView, androidxDatabindingViewDataBindingSafeUnboxItemChecklistTypeAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValueCardViewAndroidDrawableEmergencyBackgroundCardViewAndroidDrawableWhiteBackground);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.departmentTitle, stringFormatDepartmentTitleAndroidStringTitleDepartmentItemDepartmentName);
            this.departmentTitle.setVisibility(textUtilsIsEmptyItemDepartmentNameViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setText(this.dueTitle, itemDueDays);
            com.icarus.bindings.CustomViewBindings.setDueDateTextColor(this.dueTitle, itemGetDueStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.newTitle, itemChecklistStatus);
            com.icarus.bindings.CustomViewBindings.setBackground(this.newTitle, itemChecklistStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.roomAssets, itemRoomEquipment);
            this.roomAssets.setVisibility(textUtilsIsEmptyItemRoomEquipmentViewGONEViewVISIBLE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, itemTitle);
            com.icarus.bindings.CustomViewBindings.setDrawableStart(this.title, androidxDatabindingViewDataBindingSafeUnboxItemChecklistType);
            com.icarus.bindings.CustomViewBindings.setAssignedChecklistTitleColor(this.title, itemGetChecklistSyncStatus);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback39);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // item
        com.icarus.models.DepartmentChecklistItems item = mItem;
        // viewModel
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {



            viewModel.onDepartmentChecklistItemClick(item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): checklistType
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): TextUtils.isEmpty(item.roomEquipment) ? View.GONE : View.VISIBLE
        flag 5 (0x6L): TextUtils.isEmpty(item.roomEquipment) ? View.GONE : View.VISIBLE
        flag 6 (0x7L): TextUtils.isEmpty(item.departmentName) ? View.GONE : View.VISIBLE
        flag 7 (0x8L): TextUtils.isEmpty(item.departmentName) ? View.GONE : View.VISIBLE
        flag 8 (0x9L): androidx.databinding.ViewDataBinding.safeUnbox(item.checklistType) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue()) ? @android:drawable/emergency_background : @android:drawable/white_background
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(item.checklistType) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue()) ? @android:drawable/emergency_background : @android:drawable/white_background
    flag mapping end*/
    //end
}