package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentEmbeddedImageBindingImpl extends FragmentEmbeddedImageBinding implements com.icarus.generated.callback.OnClickListener.Listener {

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
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback33;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentEmbeddedImageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentEmbeddedImageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (androidx.appcompat.widget.AppCompatButton) bindings[2]
            );
        this.image.setTag(null);
        this.markComplete.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback33 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else if (BR.constants == variableId) {
            setConstants((com.icarus.constants.Constants) variable);
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
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    public void setConstants(@Nullable com.icarus.constants.Constants Constants) {
        this.mConstants = Constants;
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
        int viewModelIsButtonVisibleViewVISIBLEViewGONE = 0;
        com.icarus.models.ChecklistDetailItems item = mItem;
        java.lang.String viewModelGetBtnText = null;
        boolean viewModelIsButtonVisible = false;
        int itemIsResourceViewVISIBLEViewGONE = 0;
        boolean itemIsResource = false;
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
        boolean viewModelIsButtonEnabled = false;
        int viewModelIsButtonEnabledMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText = 0;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.isResource()
                    itemIsResource = item.isResource();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsResource) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }


                // read item.isResource() ? View.VISIBLE : View.GONE
                itemIsResourceViewVISIBLEViewGONE = ((itemIsResource) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0xaL) != 0) {



                if (viewModel != null) {
                    // read viewModel.getBtnText()
                    viewModelGetBtnText = viewModel.getBtnText();
                    // read viewModel.isButtonVisible
                    viewModelIsButtonVisible = viewModel.isButtonVisible();
                    // read viewModel.isButtonEnabled
                    viewModelIsButtonEnabled = viewModel.isButtonEnabled();
                }
            if((dirtyFlags & 0xaL) != 0) {
                if(viewModelIsButtonVisible) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
            if((dirtyFlags & 0xaL) != 0) {
                if(viewModelIsButtonEnabled) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }


                // read viewModel.isButtonVisible ? View.VISIBLE : View.GONE
                viewModelIsButtonVisibleViewVISIBLEViewGONE = ((viewModelIsButtonVisible) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewModel.isButtonEnabled ? @android:color/white : @android:color/disable_button_text
                viewModelIsButtonEnabledMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText = ((viewModelIsButtonEnabled) ? (getColorFromResource(markComplete, R.color.white)) : (getColorFromResource(markComplete, R.color.disable_button_text)));
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.image.setOnClickListener(mCallback33);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            this.image.setVisibility(itemIsResourceViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setResourcesImage(this.image, item);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.markComplete.setEnabled(viewModelIsButtonEnabled);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.markComplete, viewModelGetBtnText);
            this.markComplete.setTextColor(viewModelIsButtonEnabledMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText);
            this.markComplete.setVisibility(viewModelIsButtonVisibleViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onResourceClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): constants
        flag 3 (0x4L): null
        flag 4 (0x5L): viewModel.isButtonVisible ? View.VISIBLE : View.GONE
        flag 5 (0x6L): viewModel.isButtonVisible ? View.VISIBLE : View.GONE
        flag 6 (0x7L): item.isResource() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): item.isResource() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): viewModel.isButtonEnabled ? @android:color/white : @android:color/disable_button_text
        flag 9 (0xaL): viewModel.isButtonEnabled ? @android:color/white : @android:color/disable_button_text
    flag mapping end*/
    //end
}