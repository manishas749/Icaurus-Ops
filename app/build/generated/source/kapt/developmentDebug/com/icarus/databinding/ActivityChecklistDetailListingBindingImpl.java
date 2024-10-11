package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityChecklistDetailListingBindingImpl extends ActivityChecklistDetailListingBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main_content, 4);
        sViewsWithIds.put(R.id.appbar, 5);
        sViewsWithIds.put(R.id.toolbar, 6);
        sViewsWithIds.put(R.id.collapsing_toolbar, 7);
        sViewsWithIds.put(R.id.toolbartitle, 8);
        sViewsWithIds.put(R.id.tabs, 9);
        sViewsWithIds.put(R.id.container, 10);
        sViewsWithIds.put(R.id.bottomView, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChecklistDetailListingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityChecklistDetailListingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.google.android.material.appbar.AppBarLayout) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[7]
            , (androidx.viewpager.widget.ViewPager) bindings[10]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[4]
            , (android.widget.Button) bindings[3]
            , (android.widget.ProgressBar) bindings[1]
            , (com.google.android.material.tabs.TabLayout) bindings[9]
            , (android.widget.TextView) bindings[2]
            , (androidx.appcompat.widget.Toolbar) bindings[6]
            , (android.widget.TextView) bindings[8]
            );
        this.markComplete.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBar.setTag(null);
        this.textViewOutOf.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistDetailViewModel ViewModel) {
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
            case 0 :
                return onChangeViewModelCompleteCount((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelEnableMarkComplete((androidx.databinding.ObservableBoolean) object, fieldId);
            case 2 :
                return onChangeViewModelTotalCount((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCompleteCount(androidx.databinding.ObservableField<java.lang.String> ViewModelCompleteCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelEnableMarkComplete(androidx.databinding.ObservableBoolean ViewModelEnableMarkComplete, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelTotalCount(androidx.databinding.ObservableField<java.lang.String> ViewModelTotalCount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
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
        java.lang.String stringFormatTextViewOutOfAndroidStringMarkCompleteCountViewModelCompleteCountViewModelTotalCount = null;
        java.lang.String textViewOutOfAndroidStringMarkCompleteCountViewModelCompleteCountViewModelTotalCount = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelCompleteCount = null;
        int integerParseIntViewModelCompleteCount = 0;
        boolean viewModelEnableMarkCompleteGet = false;
        java.lang.String viewModelTotalCountGet = null;
        androidx.databinding.ObservableBoolean viewModelEnableMarkComplete = null;
        int integerParseIntViewModelTotalCount = 0;
        int viewModelEnableMarkCompleteMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText = 0;
        androidx.databinding.ObservableField<java.lang.String> viewModelTotalCount = null;
        java.lang.String viewModelCompleteCountGet = null;
        com.icarus.viewmodels.ChecklistDetailViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x1dL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.completeCount
                        viewModelCompleteCount = viewModel.completeCount;
                        // read viewModel.totalCount
                        viewModelTotalCount = viewModel.totalCount;
                    }
                    updateRegistration(0, viewModelCompleteCount);
                    updateRegistration(2, viewModelTotalCount);


                    if (viewModelCompleteCount != null) {
                        // read viewModel.completeCount.get()
                        viewModelCompleteCountGet = viewModelCompleteCount.get();
                    }
                    if (viewModelTotalCount != null) {
                        // read viewModel.totalCount.get()
                        viewModelTotalCountGet = viewModelTotalCount.get();
                    }

                if ((dirtyFlags & 0x19L) != 0) {

                        // read Integer.parseInt(viewModel.completeCount.get())
                        integerParseIntViewModelCompleteCount = java.lang.Integer.parseInt(viewModelCompleteCountGet);
                }

                    // read @android:string/mark_complete_count
                    textViewOutOfAndroidStringMarkCompleteCountViewModelCompleteCountViewModelTotalCount = textViewOutOf.getResources().getString(R.string.mark_complete_count, viewModelCompleteCountGet, viewModelTotalCountGet);


                    // read String.format(@android:string/mark_complete_count)
                    stringFormatTextViewOutOfAndroidStringMarkCompleteCountViewModelCompleteCountViewModelTotalCount = java.lang.String.format(textViewOutOfAndroidStringMarkCompleteCountViewModelCompleteCountViewModelTotalCount);
                if ((dirtyFlags & 0x1cL) != 0) {

                        // read Integer.parseInt(viewModel.totalCount.get())
                        integerParseIntViewModelTotalCount = java.lang.Integer.parseInt(viewModelTotalCountGet);
                }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.enableMarkComplete
                        viewModelEnableMarkComplete = viewModel.enableMarkComplete;
                    }
                    updateRegistration(1, viewModelEnableMarkComplete);


                    if (viewModelEnableMarkComplete != null) {
                        // read viewModel.enableMarkComplete.get()
                        viewModelEnableMarkCompleteGet = viewModelEnableMarkComplete.get();
                    }
                if((dirtyFlags & 0x1aL) != 0) {
                    if(viewModelEnableMarkCompleteGet) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read viewModel.enableMarkComplete.get() ? @android:color/white : @android:color/disable_button_text
                    viewModelEnableMarkCompleteMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText = ((viewModelEnableMarkCompleteGet) ? (getColorFromResource(markComplete, R.color.white)) : (getColorFromResource(markComplete, R.color.disable_button_text)));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            this.markComplete.setEnabled(viewModelEnableMarkCompleteGet);
            this.markComplete.setTextColor(viewModelEnableMarkCompleteMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.markComplete.setOnClickListener(mCallback17);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.progressBar.setMax(integerParseIntViewModelTotalCount);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            this.progressBar.setProgress(integerParseIntViewModelCompleteCount);
        }
        if ((dirtyFlags & 0x1dL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewOutOf, stringFormatTextViewOutOfAndroidStringMarkCompleteCountViewModelCompleteCountViewModelTotalCount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.icarus.viewmodels.ChecklistDetailViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.completeChecklist();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.completeCount
        flag 1 (0x2L): viewModel.enableMarkComplete
        flag 2 (0x3L): viewModel.totalCount
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
        flag 5 (0x6L): viewModel.enableMarkComplete.get() ? @android:color/white : @android:color/disable_button_text
        flag 6 (0x7L): viewModel.enableMarkComplete.get() ? @android:color/white : @android:color/disable_button_text
    flag mapping end*/
    //end
}