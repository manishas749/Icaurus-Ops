package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ViewItemWithCheckboxBindingImpl extends ViewItemWithCheckboxBinding implements com.icarus.generated.callback.OnClickListener.Listener {

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
    private final android.view.View.OnClickListener mCallback19;
    @Nullable
    private final android.view.View.OnClickListener mCallback20;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ViewItemWithCheckboxBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ViewItemWithCheckboxBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatCheckBox) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.checkBoxSelect.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback19 = new com.icarus.generated.callback.OnClickListener(this, 1);
        mCallback20 = new com.icarus.generated.callback.OnClickListener(this, 2);
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
        if (BR.filterListType == variableId) {
            setFilterListType((com.icarus.enums.FilterListType) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFilterListType(@Nullable com.icarus.enums.FilterListType FilterListType) {
        this.mFilterListType = FilterListType;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.filterListType);
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
        com.icarus.enums.FilterListType filterListType = mFilterListType;
        java.lang.Integer position = mPosition;
        com.icarus.models.StringCheckBox viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPosition = null;
        boolean viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPositionSelected = false;
        java.lang.String viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPositionTitle = null;
        int androidxDatabindingViewDataBindingSafeUnboxPosition = 0;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(position)
                androidxDatabindingViewDataBindingSafeUnboxPosition = androidx.databinding.ViewDataBinding.safeUnbox(position);


                if (viewModel != null) {
                    // read viewModel.detectFilterList(filterListType, androidx.databinding.ViewDataBinding.safeUnbox(position))
                    viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPosition = viewModel.detectFilterList(filterListType, androidxDatabindingViewDataBindingSafeUnboxPosition);
                }


                if (viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPosition != null) {
                    // read viewModel.detectFilterList(filterListType, androidx.databinding.ViewDataBinding.safeUnbox(position)).selected
                    viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPositionSelected = viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPosition.isSelected();
                    // read viewModel.detectFilterList(filterListType, androidx.databinding.ViewDataBinding.safeUnbox(position)).title
                    viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPositionTitle = viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPosition.getTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.checkBoxSelect, viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPositionSelected);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, viewModelDetectFilterListFilterListTypeAndroidxDatabindingViewDataBindingSafeUnboxPositionTitle);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.checkBoxSelect.setOnClickListener(mCallback20);
            this.mboundView0.setOnClickListener(mCallback19);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // filterListType
                com.icarus.enums.FilterListType filterListType = mFilterListType;
                // position
                java.lang.Integer position = mPosition;
                // androidx.databinding.ViewDataBinding.safeUnbox(position)
                int androidxDatabindingViewDataBindingSafeUnboxPosition = 0;
                // viewModel
                com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {




                    androidxDatabindingViewDataBindingSafeUnboxPosition = androidx.databinding.ViewDataBinding.safeUnbox(position);

                    viewModel.detectAndPerformFilterClick(filterListType, androidxDatabindingViewDataBindingSafeUnboxPosition);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // filterListType
                com.icarus.enums.FilterListType filterListType = mFilterListType;
                // position
                java.lang.Integer position = mPosition;
                // androidx.databinding.ViewDataBinding.safeUnbox(position)
                int androidxDatabindingViewDataBindingSafeUnboxPosition = 0;
                // viewModel
                com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {




                    androidxDatabindingViewDataBindingSafeUnboxPosition = androidx.databinding.ViewDataBinding.safeUnbox(position);

                    viewModel.detectAndPerformFilterClick(filterListType, androidxDatabindingViewDataBindingSafeUnboxPosition);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): filterListType
        flag 1 (0x2L): position
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}