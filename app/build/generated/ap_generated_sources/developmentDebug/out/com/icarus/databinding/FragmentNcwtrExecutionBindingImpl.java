package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentNcwtrExecutionBindingImpl extends FragmentNcwtrExecutionBinding  {

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
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentNcwtrExecutionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private FragmentNcwtrExecutionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.markComplete.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.recyclerViewEquipments.setTag(null);
        this.txtDescription.setTag(null);
        this.txtNCWTitle.setTag(null);
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
            setItem((com.icarus.models.ChecklistDetailItems) variable);
        }
        else if (BR.constants == variableId) {
            setConstants((com.icarus.constants.Constants) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
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
    public void setConstants(@Nullable com.icarus.constants.Constants Constants) {
        this.mConstants = Constants;
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
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
        int itemIsNCWViewVISIBLEViewINVISIBLE = 0;
        int viewModelIsButtonVisibleViewVISIBLEViewGONE = 0;
        com.icarus.models.ChecklistDetailItems item = mItem;
        boolean viewModelIsButtonVisible = false;
        boolean itemIsResource = false;
        java.lang.String itemDescription = null;
        boolean ItemIsResource1 = false;
        java.lang.String viewModelGetBtnText = null;
        boolean itemIsNCW = false;
        int itemIsResourceViewVISIBLEViewGONE = 0;
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
        boolean viewModelIsButtonEnabled = false;
        int viewModelIsButtonEnabledMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText = 0;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.isResource()
                    itemIsResource = item.isResource();
                    // read item.description
                    itemDescription = item.getDescription();
                    // read item.isNCW()
                    itemIsNCW = item.isNCW();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(itemIsNCW) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read !item.isResource()
                ItemIsResource1 = !itemIsResource;
                // read item.isNCW() ? View.VISIBLE : View.INVISIBLE
                itemIsNCWViewVISIBLEViewINVISIBLE = ((itemIsNCW) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
            if((dirtyFlags & 0x9L) != 0) {
                if(ItemIsResource1) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }


                // read !item.isResource() ? View.VISIBLE : View.GONE
                itemIsResourceViewVISIBLEViewGONE = ((ItemIsResource1) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (viewModel != null) {
                    // read viewModel.isButtonVisible
                    viewModelIsButtonVisible = viewModel.isButtonVisible();
                    // read viewModel.getBtnText()
                    viewModelGetBtnText = viewModel.getBtnText();
                    // read viewModel.isButtonEnabled
                    viewModelIsButtonEnabled = viewModel.isButtonEnabled();
                }
            if((dirtyFlags & 0xcL) != 0) {
                if(viewModelIsButtonVisible) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
            if((dirtyFlags & 0xcL) != 0) {
                if(viewModelIsButtonEnabled) {
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x400L;
                }
            }


                // read viewModel.isButtonVisible ? View.VISIBLE : View.GONE
                viewModelIsButtonVisibleViewVISIBLEViewGONE = ((viewModelIsButtonVisible) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewModel.isButtonEnabled ? @android:color/white : @android:color/disable_button_text
                viewModelIsButtonEnabledMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText = ((viewModelIsButtonEnabled) ? (getColorFromResource(markComplete, R.color.white)) : (getColorFromResource(markComplete, R.color.disable_button_text)));
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.markComplete.setEnabled(viewModelIsButtonEnabled);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.markComplete, viewModelGetBtnText);
            this.markComplete.setTextColor(viewModelIsButtonEnabledMarkCompleteAndroidColorWhiteMarkCompleteAndroidColorDisableButtonText);
            this.markComplete.setVisibility(viewModelIsButtonVisibleViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            this.recyclerViewEquipments.setVisibility(itemIsNCWViewVISIBLEViewINVISIBLE);
            this.txtDescription.setVisibility(itemIsResourceViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.txtDescription, itemDescription);
            com.icarus.bindings.CustomViewBindings.setNCWTitle(this.txtNCWTitle, item);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): constants
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): item.isNCW() ? View.VISIBLE : View.INVISIBLE
        flag 5 (0x6L): item.isNCW() ? View.VISIBLE : View.INVISIBLE
        flag 6 (0x7L): viewModel.isButtonVisible ? View.VISIBLE : View.GONE
        flag 7 (0x8L): viewModel.isButtonVisible ? View.VISIBLE : View.GONE
        flag 8 (0x9L): !item.isResource() ? View.VISIBLE : View.GONE
        flag 9 (0xaL): !item.isResource() ? View.VISIBLE : View.GONE
        flag 10 (0xbL): viewModel.isButtonEnabled ? @android:color/white : @android:color/disable_button_text
        flag 11 (0xcL): viewModel.isButtonEnabled ? @android:color/white : @android:color/disable_button_text
    flag mapping end*/
    //end
}