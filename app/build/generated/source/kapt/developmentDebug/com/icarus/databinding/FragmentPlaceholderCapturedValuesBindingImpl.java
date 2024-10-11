package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentPlaceholderCapturedValuesBindingImpl extends FragmentPlaceholderCapturedValuesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbarLayout, 7);
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.checklistInfo, 9);
        sViewsWithIds.put(R.id.placeholderList, 10);
        sViewsWithIds.put(R.id.bottomView, 11);
        sViewsWithIds.put(R.id.btnCancel, 12);
        sViewsWithIds.put(R.id.centreLine, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentPlaceholderCapturedValuesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentPlaceholderCapturedValuesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (android.widget.Button) bindings[12]
            , (android.widget.Button) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (com.icarus.customviews.ExpandableNestedListView) bindings[10]
            , (androidx.appcompat.widget.Toolbar) bindings[8]
            , (com.google.android.material.appbar.AppBarLayout) bindings[7]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            );
        this.btnStart.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtAssets.setTag(null);
        this.txtAssetsHeader.setTag(null);
        this.txtChecklistName.setTag(null);
        this.txtRoomHeader.setTag(null);
        this.txtRooms.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.assets == variableId) {
            setAssets((java.lang.String) variable);
        }
        else if (BR.rooms == variableId) {
            setRooms((java.lang.String) variable);
        }
        else if (BR.assetHeader == variableId) {
            setAssetHeader((java.lang.String) variable);
        }
        else if (BR.roomsHeader == variableId) {
            setRoomsHeader((java.lang.String) variable);
        }
        else if (BR.checklistStatus == variableId) {
            setChecklistStatus((java.lang.String) variable);
        }
        else if (BR.title == variableId) {
            setTitle((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAssets(@Nullable java.lang.String Assets) {
        this.mAssets = Assets;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.assets);
        super.requestRebind();
    }
    public void setRooms(@Nullable java.lang.String Rooms) {
        this.mRooms = Rooms;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.rooms);
        super.requestRebind();
    }
    public void setAssetHeader(@Nullable java.lang.String AssetHeader) {
        this.mAssetHeader = AssetHeader;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.assetHeader);
        super.requestRebind();
    }
    public void setRoomsHeader(@Nullable java.lang.String RoomsHeader) {
        this.mRoomsHeader = RoomsHeader;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.roomsHeader);
        super.requestRebind();
    }
    public void setChecklistStatus(@Nullable java.lang.String ChecklistStatus) {
        this.mChecklistStatus = ChecklistStatus;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.checklistStatus);
        super.requestRebind();
    }
    public void setTitle(@Nullable java.lang.String Title) {
        this.mTitle = Title;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.title);
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
        java.lang.String checklistStatusEqualsIgnoreCaseJavaLangStringInProgressJavaLangStringContinueJavaLangStringResume = null;
        boolean textUtilsIsEmptyAssets = false;
        boolean checklistStatusEqualsIgnoreCaseJavaLangStringNew = false;
        java.lang.String assets = mAssets;
        java.lang.String rooms = mRooms;
        java.lang.String checklistStatusEqualsIgnoreCaseJavaLangStringNewJavaLangStringStartChecklistStatusEqualsIgnoreCaseJavaLangStringInProgressJavaLangStringContinueJavaLangStringResume = null;
        java.lang.String assetHeader = mAssetHeader;
        java.lang.String roomsHeader = mRoomsHeader;
        java.lang.String textUtilsIsEmptyRoomsJavaLangStringNARooms = null;
        java.lang.String checklistStatus = mChecklistStatus;
        boolean checklistStatusEqualsIgnoreCaseJavaLangStringInProgress = false;
        java.lang.String textUtilsIsEmptyAssetsJavaLangStringNAAssets = null;
        java.lang.String title = mTitle;
        boolean textUtilsIsEmptyRooms = false;

        if ((dirtyFlags & 0x41L) != 0) {



                // read TextUtils.isEmpty(assets)
                textUtilsIsEmptyAssets = android.text.TextUtils.isEmpty(assets);
            if((dirtyFlags & 0x41L) != 0) {
                if(textUtilsIsEmptyAssets) {
                        dirtyFlags |= 0x4000L;
                }
                else {
                        dirtyFlags |= 0x2000L;
                }
            }
        }
        if ((dirtyFlags & 0x42L) != 0) {



                // read TextUtils.isEmpty(rooms)
                textUtilsIsEmptyRooms = android.text.TextUtils.isEmpty(rooms);
            if((dirtyFlags & 0x42L) != 0) {
                if(textUtilsIsEmptyRooms) {
                        dirtyFlags |= 0x1000L;
                }
                else {
                        dirtyFlags |= 0x800L;
                }
            }
        }
        if ((dirtyFlags & 0x44L) != 0) {
        }
        if ((dirtyFlags & 0x48L) != 0) {
        }
        if ((dirtyFlags & 0x50L) != 0) {



                if (checklistStatus != null) {
                    // read checklistStatus.equalsIgnoreCase("New")
                    checklistStatusEqualsIgnoreCaseJavaLangStringNew = checklistStatus.equalsIgnoreCase("New");
                }
            if((dirtyFlags & 0x50L) != 0) {
                if(checklistStatusEqualsIgnoreCaseJavaLangStringNew) {
                        dirtyFlags |= 0x400L;
                }
                else {
                        dirtyFlags |= 0x200L;
                }
            }
        }
        if ((dirtyFlags & 0x60L) != 0) {
        }
        // batch finished

        if ((dirtyFlags & 0x42L) != 0) {

                // read TextUtils.isEmpty(rooms) ? "N/A" : rooms
                textUtilsIsEmptyRoomsJavaLangStringNARooms = ((textUtilsIsEmptyRooms) ? ("N/A") : (rooms));
        }
        if ((dirtyFlags & 0x200L) != 0) {

                if (checklistStatus != null) {
                    // read checklistStatus.equalsIgnoreCase("In Progress")
                    checklistStatusEqualsIgnoreCaseJavaLangStringInProgress = checklistStatus.equalsIgnoreCase("In Progress");
                }
            if((dirtyFlags & 0x200L) != 0) {
                if(checklistStatusEqualsIgnoreCaseJavaLangStringInProgress) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }


                // read checklistStatus.equalsIgnoreCase("In Progress") ? "Continue" : "Resume"
                checklistStatusEqualsIgnoreCaseJavaLangStringInProgressJavaLangStringContinueJavaLangStringResume = ((checklistStatusEqualsIgnoreCaseJavaLangStringInProgress) ? ("Continue") : ("Resume"));
        }
        if ((dirtyFlags & 0x41L) != 0) {

                // read TextUtils.isEmpty(assets) ? "N/A" : assets
                textUtilsIsEmptyAssetsJavaLangStringNAAssets = ((textUtilsIsEmptyAssets) ? ("N/A") : (assets));
        }

        if ((dirtyFlags & 0x50L) != 0) {

                // read checklistStatus.equalsIgnoreCase("New") ? "Start" : checklistStatus.equalsIgnoreCase("In Progress") ? "Continue" : "Resume"
                checklistStatusEqualsIgnoreCaseJavaLangStringNewJavaLangStringStartChecklistStatusEqualsIgnoreCaseJavaLangStringInProgressJavaLangStringContinueJavaLangStringResume = ((checklistStatusEqualsIgnoreCaseJavaLangStringNew) ? ("Start") : (checklistStatusEqualsIgnoreCaseJavaLangStringInProgressJavaLangStringContinueJavaLangStringResume));
        }
        // batch finished
        if ((dirtyFlags & 0x50L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.btnStart, checklistStatusEqualsIgnoreCaseJavaLangStringNewJavaLangStringStartChecklistStatusEqualsIgnoreCaseJavaLangStringInProgressJavaLangStringContinueJavaLangStringResume);
        }
        if ((dirtyFlags & 0x41L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtAssets, textUtilsIsEmptyAssetsJavaLangStringNAAssets);
        }
        if ((dirtyFlags & 0x44L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtAssetsHeader, assetHeader);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtChecklistName, title);
        }
        if ((dirtyFlags & 0x48L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRoomHeader, roomsHeader);
        }
        if ((dirtyFlags & 0x42L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRooms, textUtilsIsEmptyRoomsJavaLangStringNARooms);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): assets
        flag 1 (0x2L): rooms
        flag 2 (0x3L): assetHeader
        flag 3 (0x4L): roomsHeader
        flag 4 (0x5L): checklistStatus
        flag 5 (0x6L): title
        flag 6 (0x7L): null
        flag 7 (0x8L): checklistStatus.equalsIgnoreCase("In Progress") ? "Continue" : "Resume"
        flag 8 (0x9L): checklistStatus.equalsIgnoreCase("In Progress") ? "Continue" : "Resume"
        flag 9 (0xaL): checklistStatus.equalsIgnoreCase("New") ? "Start" : checklistStatus.equalsIgnoreCase("In Progress") ? "Continue" : "Resume"
        flag 10 (0xbL): checklistStatus.equalsIgnoreCase("New") ? "Start" : checklistStatus.equalsIgnoreCase("In Progress") ? "Continue" : "Resume"
        flag 11 (0xcL): TextUtils.isEmpty(rooms) ? "N/A" : rooms
        flag 12 (0xdL): TextUtils.isEmpty(rooms) ? "N/A" : rooms
        flag 13 (0xeL): TextUtils.isEmpty(assets) ? "N/A" : assets
        flag 14 (0xfL): TextUtils.isEmpty(assets) ? "N/A" : assets
    flag mapping end*/
    //end
}