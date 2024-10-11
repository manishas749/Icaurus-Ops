package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemViewReportLogBindingImpl extends ItemViewReportLogBinding implements com.icarus.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(11);
        sIncludes.setIncludes(8, 
            new String[] {"item_qr_log_report"},
            new int[] {10},
            new int[] {com.icarus.R.layout.item_qr_log_report});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @Nullable
    private final com.icarus.databinding.ItemQrLogReportBinding mboundView8;
    @NonNull
    private final androidx.recyclerview.widget.RecyclerView mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback34;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemViewReportLogBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ItemViewReportLogBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[7]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            );
        this.imgAction.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView8 = (com.icarus.databinding.ItemQrLogReportBinding) bindings[10];
        setContainedBinding(this.mboundView8);
        this.mboundView9 = (androidx.recyclerview.widget.RecyclerView) bindings[9];
        this.mboundView9.setTag(null);
        this.parentLog.setTag(null);
        this.qrAttributeItemLogs.setTag(null);
        this.txtAction.setTag(null);
        this.txtCreatedOn.setTag(null);
        this.txtDecisionAction.setTag(null);
        this.txtDesc.setTag(null);
        this.txtReason.setTag(null);
        setRootTag(root);
        // listeners
        mCallback34 = new com.icarus.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        mboundView8.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView8.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.logsSummary == variableId) {
            setLogsSummary((com.icarus.models.LogsSummary) variable);
        }
        else if (BR.sameDateAdapter == variableId) {
            setSameDateAdapter((com.icarus.adapters.ChecklistViewReportSameDateLogAdapter) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistReportViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLogsSummary(@Nullable com.icarus.models.LogsSummary LogsSummary) {
        this.mLogsSummary = LogsSummary;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.logsSummary);
        super.requestRebind();
    }
    public void setSameDateAdapter(@Nullable com.icarus.adapters.ChecklistViewReportSameDateLogAdapter SameDateAdapter) {
        this.mSameDateAdapter = SameDateAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.sameDateAdapter);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistReportViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView8.setLifecycleOwner(lifecycleOwner);
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
        com.icarus.models.LogsSummary logsSummary = mLogsSummary;
        java.lang.String logsSummaryGetCreatedOnTitle = null;
        boolean logsSummaryGetActionLogTableActionsASSIGNEDGetValue = false;
        int logsSummaryIsReasonVisibleViewVISIBLEViewGONE = 0;
        boolean logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValue = false;
        int logsSummaryIsQRVisibleViewGONEViewVISIBLE = 0;
        boolean logsSummaryGetActionLogTableActionsUNASSIGNEDGetValue = false;
        int logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValueViewVISIBLEViewGONE = 0;
        boolean logsSummaryIsDescriptionImageClickable = false;
        java.lang.String checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0ToUpperCase = null;
        int logsSummaryGetAction = 0;
        boolean logsSummaryIsQRVisible = false;
        boolean logsSummaryGetActionInt0 = false;
        java.lang.String checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0 = null;
        java.lang.String logsSummaryGetItemDescription = null;
        int logsSummaryGetActionInt0Int1Int0 = 0;
        boolean sameDateAdapterJavaLangObjectNull = false;
        com.icarus.adapters.ChecklistViewReportSameDateLogAdapter sameDateAdapter = mSameDateAdapter;
        int logsSummaryIsQRVisibleViewVISIBLEViewGONE = 0;
        int sameDateAdapterJavaLangObjectNullViewVISIBLEViewGONE = 0;
        com.icarus.viewmodels.ChecklistReportViewModel viewModel = mViewModel;
        boolean logsSummaryIsReasonVisible = false;

        if ((dirtyFlags & 0x9L) != 0) {



                if (logsSummary != null) {
                    // read logsSummary.getCreatedOnTitle()
                    logsSummaryGetCreatedOnTitle = logsSummary.getCreatedOnTitle();
                    // read logsSummary.isDescriptionImageClickable()
                    logsSummaryIsDescriptionImageClickable = logsSummary.isDescriptionImageClickable();
                    // read logsSummary.getAction()
                    logsSummaryGetAction = logsSummary.getAction();
                    // read logsSummary.isQRVisible()
                    logsSummaryIsQRVisible = logsSummary.isQRVisible();
                    // read logsSummary.getItemDescription()
                    logsSummaryGetItemDescription = logsSummary.getItemDescription();
                    // read logsSummary.isReasonVisible()
                    logsSummaryIsReasonVisible = logsSummary.isReasonVisible();
                }
            if((dirtyFlags & 0x9L) != 0) {
                if(logsSummaryIsQRVisible) {
                        dirtyFlags |= 0x200L;
                        dirtyFlags |= 0x8000L;
                }
                else {
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x4000L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(logsSummaryIsReasonVisible) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read logsSummary.getAction() == LogTableActions.ASSIGNED.getValue()
                logsSummaryGetActionLogTableActionsASSIGNEDGetValue = (logsSummaryGetAction) == (com.icarus.enums.LogTableActions.ASSIGNED.getValue());
                // read logsSummary.getAction() == 0
                logsSummaryGetActionInt0 = (logsSummaryGetAction) == (0);
                // read logsSummary.isQRVisible() ? View.GONE : View.VISIBLE
                logsSummaryIsQRVisibleViewGONEViewVISIBLE = ((logsSummaryIsQRVisible) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read logsSummary.isQRVisible() ? View.VISIBLE : View.GONE
                logsSummaryIsQRVisibleViewVISIBLEViewGONE = ((logsSummaryIsQRVisible) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read logsSummary.isReasonVisible() ? View.VISIBLE : View.GONE
                logsSummaryIsReasonVisibleViewVISIBLEViewGONE = ((logsSummaryIsReasonVisible) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            if((dirtyFlags & 0x9L) != 0) {
                if(logsSummaryGetActionLogTableActionsASSIGNEDGetValue) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
            if((dirtyFlags & 0x9L) != 0) {
                if(logsSummaryGetActionInt0) {
                        dirtyFlags |= 0x2000L;
                }
                else {
                        dirtyFlags |= 0x1000L;
                }
            }


                // read logsSummary.getAction() == 0 ? 1 : 0
                logsSummaryGetActionInt0Int1Int0 = ((logsSummaryGetActionInt0) ? (1) : (0));


                // read ChecklistExecutionStatus.getNameByCode(logsSummary.getAction() == 0 ? 1 : 0)
                checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0 = com.icarus.enums.ChecklistExecutionStatus.getNameByCode(logsSummaryGetActionInt0Int1Int0);


                if (checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0 != null) {
                    // read ChecklistExecutionStatus.getNameByCode(logsSummary.getAction() == 0 ? 1 : 0).toUpperCase()
                    checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0ToUpperCase = checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0.toUpperCase();
                }
        }
        if ((dirtyFlags & 0xaL) != 0) {



                // read sameDateAdapter != null
                sameDateAdapterJavaLangObjectNull = (sameDateAdapter) != (null);
            if((dirtyFlags & 0xaL) != 0) {
                if(sameDateAdapterJavaLangObjectNull) {
                        dirtyFlags |= 0x20000L;
                }
                else {
                        dirtyFlags |= 0x10000L;
                }
            }


                // read sameDateAdapter != null ? View.VISIBLE : View.GONE
                sameDateAdapterJavaLangObjectNullViewVISIBLEViewGONE = ((sameDateAdapterJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished

        if ((dirtyFlags & 0x40L) != 0) {

                // read logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue()
                logsSummaryGetActionLogTableActionsUNASSIGNEDGetValue = (logsSummaryGetAction) == (com.icarus.enums.LogTableActions.UNASSIGNED.getValue());
        }

        if ((dirtyFlags & 0x9L) != 0) {

                // read logsSummary.getAction() == LogTableActions.ASSIGNED.getValue() ? true : logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue()
                logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValue = ((logsSummaryGetActionLogTableActionsASSIGNEDGetValue) ? (true) : (logsSummaryGetActionLogTableActionsUNASSIGNEDGetValue));
            if((dirtyFlags & 0x9L) != 0) {
                if(logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValue) {
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x400L;
                }
            }


                // read logsSummary.getAction() == LogTableActions.ASSIGNED.getValue() ? true : logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue() ? View.VISIBLE : View.GONE
                logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValueViewVISIBLEViewGONE = ((logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.icarus.models.LogsSummary.setActionLabel(this.imgAction, logsSummaryGetAction);
            this.mboundView8.setItem(logsSummary);
            this.parentLog.setVisibility(logsSummaryIsQRVisibleViewGONEViewVISIBLE);
            this.qrAttributeItemLogs.setVisibility(logsSummaryIsQRVisibleViewVISIBLEViewGONE);
            com.icarus.models.LogsSummary.setLabel(this.txtAction, logsSummary);
            androidx.databinding.adapters.ViewBindingAdapter.setOnClick(this.txtAction, mCallback34, logsSummaryIsDescriptionImageClickable);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCreatedOn, logsSummaryGetCreatedOnTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtDecisionAction, checklistExecutionStatusGetNameByCodeLogsSummaryGetActionInt0Int1Int0ToUpperCase);
            this.txtDecisionAction.setVisibility(logsSummaryGetActionLogTableActionsASSIGNEDGetValueBooleanTrueLogsSummaryGetActionLogTableActionsUNASSIGNEDGetValueViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtDesc, logsSummaryGetItemDescription);
            this.txtDesc.setVisibility(logsSummaryIsReasonVisibleViewVISIBLEViewGONE);
            this.txtReason.setVisibility(logsSummaryIsReasonVisibleViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            this.mboundView9.setVisibility(sameDateAdapterJavaLangObjectNullViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.mboundView9, sameDateAdapter);
        }
        executeBindingsOn(mboundView8);
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // logsSummary
        com.icarus.models.LogsSummary logsSummary = mLogsSummary;
        // viewModel
        com.icarus.viewmodels.ChecklistReportViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {



            viewModel.onImageClick(logsSummary);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): logsSummary
        flag 1 (0x2L): sameDateAdapter
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): logsSummary.isReasonVisible() ? View.VISIBLE : View.GONE
        flag 5 (0x6L): logsSummary.isReasonVisible() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): logsSummary.getAction() == LogTableActions.ASSIGNED.getValue() ? true : logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue()
        flag 7 (0x8L): logsSummary.getAction() == LogTableActions.ASSIGNED.getValue() ? true : logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue()
        flag 8 (0x9L): logsSummary.isQRVisible() ? View.GONE : View.VISIBLE
        flag 9 (0xaL): logsSummary.isQRVisible() ? View.GONE : View.VISIBLE
        flag 10 (0xbL): logsSummary.getAction() == LogTableActions.ASSIGNED.getValue() ? true : logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue() ? View.VISIBLE : View.GONE
        flag 11 (0xcL): logsSummary.getAction() == LogTableActions.ASSIGNED.getValue() ? true : logsSummary.getAction() == LogTableActions.UNASSIGNED.getValue() ? View.VISIBLE : View.GONE
        flag 12 (0xdL): logsSummary.getAction() == 0 ? 1 : 0
        flag 13 (0xeL): logsSummary.getAction() == 0 ? 1 : 0
        flag 14 (0xfL): logsSummary.isQRVisible() ? View.VISIBLE : View.GONE
        flag 15 (0x10L): logsSummary.isQRVisible() ? View.VISIBLE : View.GONE
        flag 16 (0x11L): sameDateAdapter != null ? View.VISIBLE : View.GONE
        flag 17 (0x12L): sameDateAdapter != null ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}