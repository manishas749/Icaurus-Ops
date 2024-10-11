package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentQrAttributeVerifyManuallyBindingImpl extends FragmentQrAttributeVerifyManuallyBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.etRoomName, 3);
        sViewsWithIds.put(R.id.txtInputReason, 4);
        sViewsWithIds.put(R.id.etReason, 5);
        sViewsWithIds.put(R.id.btnSubmit, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentQrAttributeVerifyManuallyBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentQrAttributeVerifyManuallyBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[6]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[5]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[1]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.txtInputRoomName.setTag(null);
        this.txtLabelRoom.setTag(null);
        setRootTag(root);
        // listeners
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
        if (BR.header == variableId) {
            setHeader((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHeader(@Nullable java.lang.String Header) {
        this.mHeader = Header;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.header);
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
        java.lang.String header = mHeader;
        java.lang.String stringFormatTxtLabelRoomAndroidStringEnterTheTextAfterRoomOnTheQrCodeHeader = null;
        java.lang.String txtLabelRoomAndroidStringEnterTheTextAfterRoomOnTheQrCodeHeader = null;

        if ((dirtyFlags & 0x3L) != 0) {



                // read @android:string/enter_the_text_after_room_on_the_qr_code
                txtLabelRoomAndroidStringEnterTheTextAfterRoomOnTheQrCodeHeader = txtLabelRoom.getResources().getString(R.string.enter_the_text_after_room_on_the_qr_code, header);


                // read String.format(@android:string/enter_the_text_after_room_on_the_qr_code)
                stringFormatTxtLabelRoomAndroidStringEnterTheTextAfterRoomOnTheQrCodeHeader = java.lang.String.format(txtLabelRoomAndroidStringEnterTheTextAfterRoomOnTheQrCodeHeader);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.txtInputRoomName.setHint(header);
            com.icarus.bindings.CustomViewBindings.setHTMLText(this.txtLabelRoom, stringFormatTxtLabelRoomAndroidStringEnterTheTextAfterRoomOnTheQrCodeHeader);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): header
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}