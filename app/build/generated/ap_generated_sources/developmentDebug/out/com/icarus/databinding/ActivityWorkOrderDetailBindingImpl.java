package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWorkOrderDetailBindingImpl extends ActivityWorkOrderDetailBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 2);
        sViewsWithIds.put(R.id.toolbar, 3);
        sViewsWithIds.put(R.id.main_content, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback16;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener markCompleteandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.footerText.get()
            //         is viewModel.footerText.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(markComplete);
            // localize variables for thread safety
            // viewModel.footerText.get()
            java.lang.String viewModelFooterTextGet = null;
            // viewModel
            com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;
            // viewModel.footerText
            androidx.databinding.ObservableField<java.lang.String> viewModelFooterText = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.footerText != null
            boolean viewModelFooterTextJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelFooterText = viewModel.footerText;

                viewModelFooterTextJavaLangObjectNull = (viewModelFooterText) != (null);
                if (viewModelFooterTextJavaLangObjectNull) {




                    viewModelFooterText.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityWorkOrderDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityWorkOrderDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.google.android.material.appbar.AppBarLayout) bindings[2]
            , (android.widget.FrameLayout) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (androidx.appcompat.widget.Toolbar) bindings[3]
            );
        this.markComplete.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback16 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
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
            case 0 :
                return onChangeViewModelFooterVisible((androidx.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeViewModelFooterText((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelFooterVisible(androidx.databinding.ObservableBoolean ViewModelFooterVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelFooterText(androidx.databinding.ObservableField<java.lang.String> ViewModelFooterText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        java.lang.String viewModelFooterTextGet = null;
        int viewModelFooterVisibleViewVISIBLEViewGONE = 0;
        boolean viewModelFooterVisibleGet = false;
        androidx.databinding.ObservableBoolean viewModelFooterVisible = null;
        com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;
        androidx.databinding.ObservableField<java.lang.String> viewModelFooterText = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.footerVisible
                        viewModelFooterVisible = viewModel.footerVisible;
                    }
                    updateRegistration(0, viewModelFooterVisible);


                    if (viewModelFooterVisible != null) {
                        // read viewModel.footerVisible.get()
                        viewModelFooterVisibleGet = viewModelFooterVisible.get();
                    }
                if((dirtyFlags & 0xdL) != 0) {
                    if(viewModelFooterVisibleGet) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }


                    // read viewModel.footerVisible.get() ? View.VISIBLE : View.GONE
                    viewModelFooterVisibleViewVISIBLEViewGONE = ((viewModelFooterVisibleGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.footerText
                        viewModelFooterText = viewModel.footerText;
                    }
                    updateRegistration(1, viewModelFooterText);


                    if (viewModelFooterText != null) {
                        // read viewModel.footerText.get()
                        viewModelFooterTextGet = viewModelFooterText.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.markComplete.setOnClickListener(mCallback16);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.markComplete, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, markCompleteandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.markComplete, viewModelFooterTextGet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.markComplete.setVisibility(viewModelFooterVisibleViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onFooterClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.footerVisible
        flag 1 (0x2L): viewModel.footerText
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): viewModel.footerVisible.get() ? View.VISIBLE : View.GONE
        flag 5 (0x6L): viewModel.footerVisible.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}