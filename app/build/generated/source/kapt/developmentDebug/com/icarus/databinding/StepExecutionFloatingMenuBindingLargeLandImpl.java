package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class StepExecutionFloatingMenuBindingLargeLandImpl extends StepExecutionFloatingMenuBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public StepExecutionFloatingMenuBindingLargeLandImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private StepExecutionFloatingMenuBindingLargeLandImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.view.View) bindings[1]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[8]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.FrameLayout) bindings[0]
            );
        this.background.setTag(null);
        this.fab.setTag(null);
        this.fabDataCaptured.setTag(null);
        this.fabDefer.setTag(null);
        this.fabNotes.setTag(null);
        this.fabReferences.setTag(null);
        this.fabSkip.setTag(null);
        this.fabSuggestion.setTag(null);
        this.parentContainer.setTag(null);
        setRootTag(root);
        // listeners
        mCallback8 = new com.icarus.generated.callback.OnClickListener(this, 6);
        mCallback6 = new com.icarus.generated.callback.OnClickListener(this, 4);
        mCallback4 = new com.icarus.generated.callback.OnClickListener(this, 2);
        mCallback10 = new com.icarus.generated.callback.OnClickListener(this, 8);
        mCallback9 = new com.icarus.generated.callback.OnClickListener(this, 7);
        mCallback7 = new com.icarus.generated.callback.OnClickListener(this, 5);
        mCallback5 = new com.icarus.generated.callback.OnClickListener(this, 3);
        mCallback3 = new com.icarus.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        boolean viewModelIsSkipAvailable = false;
        int viewModelIsOpenViewModelIsDeferAvailableBooleanFalseViewVISIBLEViewGONE = 0;
        boolean viewModelIsDeferAvailable = false;
        boolean viewModelIsOpenViewModelIsDeferAvailableBooleanFalse = false;
        int viewModelIsOpenViewVISIBLEViewGONE = 0;
        boolean viewModelIsOpenViewModelIsSkipAvailableBooleanFalse = false;
        boolean viewModelIsOpen = false;
        boolean viewModelIsOpenViewModelIsReferenceAvailableBooleanFalse = false;
        int viewModelIsOpenViewModelIsReferenceAvailableBooleanFalseViewVISIBLEViewGONE = 0;
        int viewModelIsOpenViewModelIsSkipAvailableBooleanFalseViewVISIBLEViewGONE = 0;
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
        boolean viewModelIsReferenceAvailable = false;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.isOpen
                    viewModelIsOpen = viewModel.isOpen;
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewModelIsOpen) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x200L;
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x400L;
                }
            }


                // read viewModel.isOpen ? View.VISIBLE : View.GONE
                viewModelIsOpenViewVISIBLEViewGONE = ((viewModelIsOpen) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished

        if ((dirtyFlags & 0x200L) != 0) {

                if (viewModel != null) {
                    // read viewModel.isSkipAvailable
                    viewModelIsSkipAvailable = viewModel.isSkipAvailable;
                }
        }
        if ((dirtyFlags & 0x20L) != 0) {

                if (viewModel != null) {
                    // read viewModel.isDeferAvailable
                    viewModelIsDeferAvailable = viewModel.isDeferAvailable;
                }
        }
        if ((dirtyFlags & 0x800L) != 0) {

                if (viewModel != null) {
                    // read viewModel.isReferenceAvailable
                    viewModelIsReferenceAvailable = viewModel.isReferenceAvailable;
                }
        }

        if ((dirtyFlags & 0x3L) != 0) {

                // read viewModel.isOpen ? viewModel.isDeferAvailable : false
                viewModelIsOpenViewModelIsDeferAvailableBooleanFalse = ((viewModelIsOpen) ? (viewModelIsDeferAvailable) : (false));
                // read viewModel.isOpen ? viewModel.isSkipAvailable : false
                viewModelIsOpenViewModelIsSkipAvailableBooleanFalse = ((viewModelIsOpen) ? (viewModelIsSkipAvailable) : (false));
                // read viewModel.isOpen ? viewModel.isReferenceAvailable : false
                viewModelIsOpenViewModelIsReferenceAvailableBooleanFalse = ((viewModelIsOpen) ? (viewModelIsReferenceAvailable) : (false));
            if((dirtyFlags & 0x3L) != 0) {
                if(viewModelIsOpenViewModelIsDeferAvailableBooleanFalse) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewModelIsOpenViewModelIsSkipAvailableBooleanFalse) {
                        dirtyFlags |= 0x8000L;
                }
                else {
                        dirtyFlags |= 0x4000L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewModelIsOpenViewModelIsReferenceAvailableBooleanFalse) {
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x1000L;
                }
            }


                // read viewModel.isOpen ? viewModel.isDeferAvailable : false ? View.VISIBLE : View.GONE
                viewModelIsOpenViewModelIsDeferAvailableBooleanFalseViewVISIBLEViewGONE = ((viewModelIsOpenViewModelIsDeferAvailableBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewModel.isOpen ? viewModel.isSkipAvailable : false ? View.VISIBLE : View.GONE
                viewModelIsOpenViewModelIsSkipAvailableBooleanFalseViewVISIBLEViewGONE = ((viewModelIsOpenViewModelIsSkipAvailableBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewModel.isOpen ? viewModel.isReferenceAvailable : false ? View.VISIBLE : View.GONE
                viewModelIsOpenViewModelIsReferenceAvailableBooleanFalseViewVISIBLEViewGONE = ((viewModelIsOpenViewModelIsReferenceAvailableBooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.background.setOnClickListener(mCallback3);
            this.fab.setOnClickListener(mCallback10);
            this.fabDataCaptured.setOnClickListener(mCallback5);
            this.fabDefer.setOnClickListener(mCallback8);
            this.fabNotes.setOnClickListener(mCallback6);
            this.fabReferences.setOnClickListener(mCallback4);
            this.fabSkip.setOnClickListener(mCallback9);
            this.fabSuggestion.setOnClickListener(mCallback7);
        }
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.background.setVisibility(viewModelIsOpenViewVISIBLEViewGONE);
            this.fabDataCaptured.setVisibility(viewModelIsOpenViewVISIBLEViewGONE);
            this.fabDefer.setVisibility(viewModelIsOpenViewModelIsDeferAvailableBooleanFalseViewVISIBLEViewGONE);
            this.fabNotes.setVisibility(viewModelIsOpenViewVISIBLEViewGONE);
            this.fabReferences.setVisibility(viewModelIsOpenViewModelIsReferenceAvailableBooleanFalseViewVISIBLEViewGONE);
            this.fabSkip.setVisibility(viewModelIsOpenViewModelIsSkipAvailableBooleanFalseViewVISIBLEViewGONE);
            this.fabSuggestion.setVisibility(viewModelIsOpenViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 6: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.deferElement();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.addNote();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.showReference();
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.showMenu();
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.skipElement();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.addSuggestion();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.showDataCaptured();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.showMenu();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
        flag 2 (0x3L): viewModel.isOpen ? viewModel.isDeferAvailable : false ? View.VISIBLE : View.GONE
        flag 3 (0x4L): viewModel.isOpen ? viewModel.isDeferAvailable : false ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewModel.isOpen ? viewModel.isDeferAvailable : false
        flag 5 (0x6L): viewModel.isOpen ? viewModel.isDeferAvailable : false
        flag 6 (0x7L): viewModel.isOpen ? View.VISIBLE : View.GONE
        flag 7 (0x8L): viewModel.isOpen ? View.VISIBLE : View.GONE
        flag 8 (0x9L): viewModel.isOpen ? viewModel.isSkipAvailable : false
        flag 9 (0xaL): viewModel.isOpen ? viewModel.isSkipAvailable : false
        flag 10 (0xbL): viewModel.isOpen ? viewModel.isReferenceAvailable : false
        flag 11 (0xcL): viewModel.isOpen ? viewModel.isReferenceAvailable : false
        flag 12 (0xdL): viewModel.isOpen ? viewModel.isReferenceAvailable : false ? View.VISIBLE : View.GONE
        flag 13 (0xeL): viewModel.isOpen ? viewModel.isReferenceAvailable : false ? View.VISIBLE : View.GONE
        flag 14 (0xfL): viewModel.isOpen ? viewModel.isSkipAvailable : false ? View.VISIBLE : View.GONE
        flag 15 (0x10L): viewModel.isOpen ? viewModel.isSkipAvailable : false ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}