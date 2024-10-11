package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLoginBindingImpl extends FragmentLoginBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.login_form, 4);
        sViewsWithIds.put(R.id.email_login_form, 5);
        sViewsWithIds.put(R.id.headerImage, 6);
        sViewsWithIds.put(R.id.usernamePasswordView, 7);
        sViewsWithIds.put(R.id.userNameView, 8);
        sViewsWithIds.put(R.id.username, 9);
        sViewsWithIds.put(R.id.passwordInputLayout, 10);
        sViewsWithIds.put(R.id.password, 11);
        sViewsWithIds.put(R.id.version, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback12;
    @Nullable
    private final android.view.View.OnClickListener mCallback11;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.Button) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ScrollView) bindings[4]
            , (android.widget.ProgressBar) bindings[3]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[11]
            , (com.google.android.material.textfield.TextInputLayout) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[7]
            , (android.widget.TextView) bindings[12]
            );
        this.emailSignInButton.setTag(null);
        this.forgotPassword.setTag(null);
        this.loginProgress.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback12 = new com.icarus.generated.callback.OnClickListener(this, 2);
        mCallback11 = new com.icarus.generated.callback.OnClickListener(this, 1);
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
            setViewModel((com.icarus.viewmodels.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.LoginViewModel ViewModel) {
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
                return onChangeViewModelIsLoading((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsLoading(androidx.databinding.ObservableBoolean ViewModelIsLoading, int fieldId) {
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
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        boolean viewModelIsLoadingGet = false;
        com.icarus.viewmodels.LoginViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.isLoading
                    viewModelIsLoading = viewModel.getIsLoading();
                }
                updateRegistration(0, viewModelIsLoading);


                if (viewModelIsLoading != null) {
                    // read viewModel.isLoading.get()
                    viewModelIsLoadingGet = viewModelIsLoading.get();
                }
            if((dirtyFlags & 0x7L) != 0) {
                if(viewModelIsLoadingGet) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.emailSignInButton.setOnClickListener(mCallback12);
            this.forgotPassword.setOnClickListener(mCallback11);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.loginProgress.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.LoginViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onLoginClick();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.icarus.viewmodels.LoginViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.onForgotPasswordClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isLoading
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}