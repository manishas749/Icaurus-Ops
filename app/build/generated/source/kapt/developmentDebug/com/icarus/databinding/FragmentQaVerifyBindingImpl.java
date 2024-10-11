package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentQaVerifyBindingImpl extends FragmentQaVerifyBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.editAttribute, 5);
        sViewsWithIds.put(R.id.username, 6);
        sViewsWithIds.put(R.id.password, 7);
        sViewsWithIds.put(R.id.txtBarcodeScan, 8);
        sViewsWithIds.put(R.id.btnSubmit, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentQaVerifyBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentQaVerifyBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[9]
            , (android.widget.FrameLayout) bindings[5]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[6]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.passwordInputLayout.setTag(null);
        this.txtDescription.setTag(null);
        this.txtLabel.setTag(null);
        this.userNameInputLayout.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
            setItem((com.icarus.models.CheckListStepAttributeItems) variable);
        }
        else if (BR.attributeNo == variableId) {
            setAttributeNo((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.CheckListStepAttributeItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setAttributeNo(@Nullable java.lang.Integer AttributeNo) {
        this.mAttributeNo = AttributeNo;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.attributeNo);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelQaUserNameError((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelQaPasswordError((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelQaUserNameError(androidx.databinding.ObservableField<java.lang.String> ViewModelQaUserNameError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelQaPasswordError(androidx.databinding.ObservableField<java.lang.String> ViewModelQaPasswordError, int fieldId) {
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
        int textUtilsIsEmptyItemLabelViewGONEViewVISIBLE = 0;
        com.icarus.models.CheckListStepAttributeItems item = mItem;
        java.lang.String itemLabel = null;
        boolean textUtilsIsEmptyItemLabel = false;
        java.lang.String itemDescription = null;
        boolean textUtilsIsEmptyItemDescription = false;
        java.lang.String stringFormatTxtLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelQaUserNameError = null;
        java.lang.String viewModelQaUserNameErrorGet = null;
        java.lang.Integer attributeNo = mAttributeNo;
        int textUtilsIsEmptyItemDescriptionViewGONEViewVISIBLE = 0;
        com.icarus.viewmodels.ChecklistExecutionViewModel viewModel = mViewModel;
        androidx.databinding.ObservableField<java.lang.String> viewModelQaPasswordError = null;
        java.lang.String viewModelQaPasswordErrorGet = null;

        if ((dirtyFlags & 0x2cL) != 0) {



                if (item != null) {
                    // read item.label
                    itemLabel = item.getLabel();
                }

            if ((dirtyFlags & 0x24L) != 0) {

                    // read TextUtils.isEmpty(item.label)
                    textUtilsIsEmptyItemLabel = android.text.TextUtils.isEmpty(itemLabel);
                if((dirtyFlags & 0x24L) != 0) {
                    if(textUtilsIsEmptyItemLabel) {
                            dirtyFlags |= 0x80L;
                    }
                    else {
                            dirtyFlags |= 0x40L;
                    }
                }


                    // read TextUtils.isEmpty(item.label) ? View.GONE : View.VISIBLE
                    textUtilsIsEmptyItemLabelViewGONEViewVISIBLE = ((textUtilsIsEmptyItemLabel) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }

                // read String.format(@android:string/attribute_label_bullet, attributeNo, item.label)
                stringFormatTxtLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel = java.lang.String.format(txtLabel.getResources().getString(R.string.attribute_label_bullet), attributeNo, itemLabel);
            if ((dirtyFlags & 0x24L) != 0) {

                    if (item != null) {
                        // read item.description
                        itemDescription = item.getDescription();
                    }


                    // read TextUtils.isEmpty(item.description)
                    textUtilsIsEmptyItemDescription = android.text.TextUtils.isEmpty(itemDescription);
                if((dirtyFlags & 0x24L) != 0) {
                    if(textUtilsIsEmptyItemDescription) {
                            dirtyFlags |= 0x200L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                    }
                }


                    // read TextUtils.isEmpty(item.description) ? View.GONE : View.VISIBLE
                    textUtilsIsEmptyItemDescriptionViewGONEViewVISIBLE = ((textUtilsIsEmptyItemDescription) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }
        }
        if ((dirtyFlags & 0x33L) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.qaUserNameError
                        viewModelQaUserNameError = viewModel.qaUserNameError;
                    }
                    updateRegistration(0, viewModelQaUserNameError);


                    if (viewModelQaUserNameError != null) {
                        // read viewModel.qaUserNameError.get()
                        viewModelQaUserNameErrorGet = viewModelQaUserNameError.get();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.qaPasswordError
                        viewModelQaPasswordError = viewModel.qaPasswordError;
                    }
                    updateRegistration(1, viewModelQaPasswordError);


                    if (viewModelQaPasswordError != null) {
                        // read viewModel.qaPasswordError.get()
                        viewModelQaPasswordErrorGet = viewModelQaPasswordError.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setErrorMessage(this.passwordInputLayout, viewModelQaPasswordErrorGet);
        }
        if ((dirtyFlags & 0x24L) != 0) {
            // api target 1

            this.txtDescription.setVisibility(textUtilsIsEmptyItemDescriptionViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.txtDescription, itemDescription);
            this.txtLabel.setVisibility(textUtilsIsEmptyItemLabelViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.txtLabel, stringFormatTxtLabelAndroidStringAttributeLabelBulletAttributeNoItemLabel);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setErrorMessage(this.userNameInputLayout, viewModelQaUserNameErrorGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.qaUserNameError
        flag 1 (0x2L): viewModel.qaPasswordError
        flag 2 (0x3L): item
        flag 3 (0x4L): attributeNo
        flag 4 (0x5L): viewModel
        flag 5 (0x6L): null
        flag 6 (0x7L): TextUtils.isEmpty(item.label) ? View.GONE : View.VISIBLE
        flag 7 (0x8L): TextUtils.isEmpty(item.label) ? View.GONE : View.VISIBLE
        flag 8 (0x9L): TextUtils.isEmpty(item.description) ? View.GONE : View.VISIBLE
        flag 9 (0xaL): TextUtils.isEmpty(item.description) ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}