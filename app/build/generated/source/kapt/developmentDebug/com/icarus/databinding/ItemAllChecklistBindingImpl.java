package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAllChecklistBindingImpl extends ItemAllChecklistBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.buttons, 9);
        sViewsWithIds.put(R.id.divider, 10);
        sViewsWithIds.put(R.id.imgDepartment, 11);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback43;
    @Nullable
    private final android.view.View.OnClickListener mCallback42;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAllChecklistBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ItemAllChecklistBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (android.view.View) bindings[10]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[11]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            );
        this.ar.setTag(null);
        this.imgFav.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView7 = (androidx.appcompat.widget.AppCompatTextView) bindings[7];
        this.mboundView7.setTag(null);
        this.ph.setTag(null);
        this.sq.setTag(null);
        this.title.setTag(null);
        this.txtModified.setTag(null);
        setRootTag(root);
        // listeners
        mCallback43 = new com.icarus.generated.callback.OnClickListener(this, 2);
        mCallback42 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.checklistType == variableId) {
            setChecklistType((com.icarus.enums.ChecklistType) variable);
        }
        else if (BR.items == variableId) {
            setItems((com.icarus.models.AllChecklistItems) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }
    public void setChecklistType(@Nullable com.icarus.enums.ChecklistType ChecklistType) {
        this.mChecklistType = ChecklistType;
    }
    public void setItems(@Nullable com.icarus.models.AllChecklistItems Items) {
        this.mItems = Items;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.items);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.DashboardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
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
        boolean androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue = false;
        java.lang.Integer itemsChecklistTypeId = null;
        java.lang.Integer itemsIsApprovalRequired = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1 = false;
        boolean androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1 = false;
        java.lang.String textUtilsIsEmptyItemsGetDepartmentNameMboundView7AndroidStringAllItemsGetDepartmentName = null;
        com.icarus.enums.ChecklistStatus itemsGetChecklistSyncStatus = null;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExists = 0;
        java.lang.String itemsGetModified = null;
        java.lang.Integer itemsIsFavorite = null;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1ViewVISIBLEViewGONE = 0;
        java.lang.Integer itemsIsSequential = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1 = false;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1ViewVISIBLEViewGONE = 0;
        java.lang.Integer itemsIsPlaceholderExists = null;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsSequential = 0;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1ViewVISIBLEViewGONE = 0;
        java.lang.Integer position = mPosition;
        java.lang.String itemsTitleJavaLangObjectNullJavaLangStringGettingChecklistItemsTitle = null;
        java.lang.String itemsTitle = null;
        int androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeId = 0;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsFavorite = 0;
        android.graphics.drawable.Drawable androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValueMboundView0AndroidDrawableEmergencyBackgroundMboundView0AndroidDrawableWhiteBackground = null;
        java.lang.String itemsGetDepartmentName = null;
        com.icarus.models.AllChecklistItems items = mItems;
        boolean textUtilsIsEmptyItemsGetDepartmentName = false;
        boolean itemsTitleJavaLangObjectNull = false;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
        int androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequired = 0;

        if ((dirtyFlags & 0x14L) != 0) {



                if (items != null) {
                    // read items.checklistTypeId
                    itemsChecklistTypeId = items.getChecklistTypeId();
                    // read items.isApprovalRequired()
                    itemsIsApprovalRequired = items.isApprovalRequired();
                    // read items.getChecklistSyncStatus()
                    itemsGetChecklistSyncStatus = items.getChecklistSyncStatus();
                    // read items.getModified()
                    itemsGetModified = items.getModified();
                    // read items.isFavorite
                    itemsIsFavorite = items.isFavorite();
                    // read items.isSequential()
                    itemsIsSequential = items.isSequential();
                    // read items.isPlaceholderExists()
                    itemsIsPlaceholderExists = items.isPlaceholderExists();
                    // read items.title
                    itemsTitle = items.getTitle();
                    // read items.getDepartmentName()
                    itemsGetDepartmentName = items.getDepartmentName();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(items.checklistTypeId)
                androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeId = androidx.databinding.ViewDataBinding.safeUnbox(itemsChecklistTypeId);
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isApprovalRequired())
                androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequired = androidx.databinding.ViewDataBinding.safeUnbox(itemsIsApprovalRequired);
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isFavorite)
                androidxDatabindingViewDataBindingSafeUnboxItemsIsFavorite = androidx.databinding.ViewDataBinding.safeUnbox(itemsIsFavorite);
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isSequential())
                androidxDatabindingViewDataBindingSafeUnboxItemsIsSequential = androidx.databinding.ViewDataBinding.safeUnbox(itemsIsSequential);
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isPlaceholderExists())
                androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExists = androidx.databinding.ViewDataBinding.safeUnbox(itemsIsPlaceholderExists);
                // read items.title == null
                itemsTitleJavaLangObjectNull = (itemsTitle) == (null);
                // read TextUtils.isEmpty(items.getDepartmentName())
                textUtilsIsEmptyItemsGetDepartmentName = android.text.TextUtils.isEmpty(itemsGetDepartmentName);
            if((dirtyFlags & 0x14L) != 0) {
                if(itemsTitleJavaLangObjectNull) {
                        dirtyFlags |= 0x4000L;
                }
                else {
                        dirtyFlags |= 0x2000L;
                }
            }
            if((dirtyFlags & 0x14L) != 0) {
                if(textUtilsIsEmptyItemsGetDepartmentName) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(items.checklistTypeId) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue())
                androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue = (androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeId) == (androidx.databinding.ViewDataBinding.safeUnbox(com.icarus.enums.ChecklistType.Emergency.getValue()));
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isApprovalRequired()) == 1
                androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1 = (androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequired) == (1);
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isSequential()) == 1
                androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1 = (androidxDatabindingViewDataBindingSafeUnboxItemsIsSequential) == (1);
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isPlaceholderExists()) == 1
                androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1 = (androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExists) == (1);
            if((dirtyFlags & 0x14L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue) {
                        dirtyFlags |= 0x10000L;
                }
                else {
                        dirtyFlags |= 0x8000L;
                }
            }
            if((dirtyFlags & 0x14L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }
            if((dirtyFlags & 0x14L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1) {
                        dirtyFlags |= 0x400L;
                }
                else {
                        dirtyFlags |= 0x200L;
                }
            }
            if((dirtyFlags & 0x14L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1) {
                        dirtyFlags |= 0x1000L;
                }
                else {
                        dirtyFlags |= 0x800L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(items.checklistTypeId) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue()) ? @android:drawable/emergency_background : @android:drawable/white_background
                androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValueMboundView0AndroidDrawableEmergencyBackgroundMboundView0AndroidDrawableWhiteBackground = ((androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValue) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView0.getContext(), R.drawable.emergency_background)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView0.getContext(), R.drawable.white_background)));
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isApprovalRequired()) == 1 ? View.VISIBLE : View.GONE
                androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1ViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isSequential()) == 1 ? View.VISIBLE : View.GONE
                androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1ViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read androidx.databinding.ViewDataBinding.safeUnbox(items.isPlaceholderExists()) == 1 ? View.VISIBLE : View.GONE
                androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1ViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished

        if ((dirtyFlags & 0x14L) != 0) {

                // read TextUtils.isEmpty(items.getDepartmentName()) ? @android:string/all : items.getDepartmentName()
                textUtilsIsEmptyItemsGetDepartmentNameMboundView7AndroidStringAllItemsGetDepartmentName = ((textUtilsIsEmptyItemsGetDepartmentName) ? (mboundView7.getResources().getString(R.string.all)) : (itemsGetDepartmentName));
                // read items.title == null ? "Getting checklist..." : items.title
                itemsTitleJavaLangObjectNullJavaLangStringGettingChecklistItemsTitle = ((itemsTitleJavaLangObjectNull) ? ("Getting checklist...") : (itemsTitle));
        }
        // batch finished
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            this.ar.setVisibility(androidxDatabindingViewDataBindingSafeUnboxItemsIsApprovalRequiredInt1ViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setImageResource(this.imgFav, androidxDatabindingViewDataBindingSafeUnboxItemsIsFavorite);
            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.mboundView0, androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeIdAndroidxDatabindingViewDataBindingSafeUnboxChecklistTypeEmergencyGetValueMboundView0AndroidDrawableEmergencyBackgroundMboundView0AndroidDrawableWhiteBackground);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, textUtilsIsEmptyItemsGetDepartmentNameMboundView7AndroidStringAllItemsGetDepartmentName);
            this.ph.setVisibility(androidxDatabindingViewDataBindingSafeUnboxItemsIsPlaceholderExistsInt1ViewVISIBLEViewGONE);
            this.sq.setVisibility(androidxDatabindingViewDataBindingSafeUnboxItemsIsSequentialInt1ViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, itemsTitleJavaLangObjectNullJavaLangStringGettingChecklistItemsTitle);
            com.icarus.bindings.CustomViewBindings.setChecklistTitleColor(this.title, itemsGetChecklistSyncStatus);
            com.icarus.bindings.CustomViewBindings.setDrawableStart(this.title, androidxDatabindingViewDataBindingSafeUnboxItemsChecklistTypeId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtModified, itemsGetModified);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.imgFav.setOnClickListener(mCallback43);
            this.mboundView1.setOnClickListener(mCallback42);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // position
                java.lang.Integer position = mPosition;
                // viewModel
                com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;
                // items
                com.icarus.models.AllChecklistItems items = mItems;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {




                    viewModel.onAddToFav(items, position);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;
                // items
                com.icarus.models.AllChecklistItems items = mItems;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {



                    viewModel.onAllChecklistItemClick(items);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): position
        flag 1 (0x2L): checklistType
        flag 2 (0x3L): items
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
        flag 5 (0x6L): TextUtils.isEmpty(items.getDepartmentName()) ? @android:string/all : items.getDepartmentName()
        flag 6 (0x7L): TextUtils.isEmpty(items.getDepartmentName()) ? @android:string/all : items.getDepartmentName()
        flag 7 (0x8L): androidx.databinding.ViewDataBinding.safeUnbox(items.isApprovalRequired()) == 1 ? View.VISIBLE : View.GONE
        flag 8 (0x9L): androidx.databinding.ViewDataBinding.safeUnbox(items.isApprovalRequired()) == 1 ? View.VISIBLE : View.GONE
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(items.isSequential()) == 1 ? View.VISIBLE : View.GONE
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(items.isSequential()) == 1 ? View.VISIBLE : View.GONE
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(items.isPlaceholderExists()) == 1 ? View.VISIBLE : View.GONE
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(items.isPlaceholderExists()) == 1 ? View.VISIBLE : View.GONE
        flag 13 (0xeL): items.title == null ? "Getting checklist..." : items.title
        flag 14 (0xfL): items.title == null ? "Getting checklist..." : items.title
        flag 15 (0x10L): androidx.databinding.ViewDataBinding.safeUnbox(items.checklistTypeId) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue()) ? @android:drawable/emergency_background : @android:drawable/white_background
        flag 16 (0x11L): androidx.databinding.ViewDataBinding.safeUnbox(items.checklistTypeId) == androidx.databinding.ViewDataBinding.safeUnbox(ChecklistType.Emergency.getValue()) ? @android:drawable/emergency_background : @android:drawable/white_background
    flag mapping end*/
    //end
}