package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PopupWithEditBoxBindingImpl extends PopupWithEditBoxBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvTitle, 2);
        sViewsWithIds.put(R.id.tvSubTitle, 3);
        sViewsWithIds.put(R.id.txtInputReason, 4);
        sViewsWithIds.put(R.id.btnSubmit, 5);
        sViewsWithIds.put(R.id.btnCancel, 6);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etReasonandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.txtReason.get()
            //         is viewModel.txtReason.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etReason);
            // localize variables for thread safety
            // viewModel.txtReason != null
            boolean viewModelTxtReasonJavaLangObjectNull = false;
            // viewModel
            com.icarus.viewmodels.ReasonPopUpViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.txtReason.get()
            java.lang.String viewModelTxtReasonGet = null;
            // viewModel.txtReason
            androidx.databinding.ObservableField<java.lang.String> viewModelTxtReason = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelTxtReason = viewModel.getTxtReason();

                viewModelTxtReasonJavaLangObjectNull = (viewModelTxtReason) != (null);
                if (viewModelTxtReasonJavaLangObjectNull) {




                    viewModelTxtReason.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public PopupWithEditBoxBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private PopupWithEditBoxBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatButton) bindings[6]
            , (androidx.appcompat.widget.AppCompatButton) bindings[5]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            );
        this.etReason.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ReasonPopUpViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.ReasonPopUpViewModel ViewModel) {
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
            case 0 :
                return onChangeViewModelTxtReason((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelTxtReason(androidx.databinding.ObservableField<java.lang.String> ViewModelTxtReason, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        com.icarus.viewmodels.ReasonPopUpViewModel viewModel = mViewModel;
        java.lang.String viewModelTxtReasonGet = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelTxtReason = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.txtReason
                    viewModelTxtReason = viewModel.getTxtReason();
                }
                updateRegistration(0, viewModelTxtReason);


                if (viewModelTxtReason != null) {
                    // read viewModel.txtReason.get()
                    viewModelTxtReasonGet = viewModelTxtReason.get();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etReason, viewModelTxtReasonGet);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etReason, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etReasonandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.txtReason
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}