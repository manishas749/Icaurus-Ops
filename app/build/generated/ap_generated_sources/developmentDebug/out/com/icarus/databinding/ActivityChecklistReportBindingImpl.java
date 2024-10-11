package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityChecklistReportBindingImpl extends ActivityChecklistReportBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 18);
        sViewsWithIds.put(R.id.toolbar, 19);
        sViewsWithIds.put(R.id.guideline, 20);
        sViewsWithIds.put(R.id.txtNotesHeader, 21);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView12;
    @NonNull
    private final android.view.View mboundView14;
    @NonNull
    private final android.widget.ProgressBar mboundView17;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView3;
    @NonNull
    private final android.view.View mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView5;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChecklistReportBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private ActivityChecklistReportBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.appbar.AppBarLayout) bindings[18]
            , (androidx.constraintlayout.widget.Guideline) bindings[20]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (androidx.appcompat.widget.Toolbar) bindings[19]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[10]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[9]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[21]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[7]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView12 = (androidx.appcompat.widget.AppCompatTextView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView14 = (android.view.View) bindings[14];
        this.mboundView14.setTag(null);
        this.mboundView17 = (android.widget.ProgressBar) bindings[17];
        this.mboundView17.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.AppCompatTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.view.View) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatTextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[6];
        this.mboundView6.setTag(null);
        this.rvAssignmentHistory.setTag(null);
        this.rvElements.setTag(null);
        this.rvNotes.setTag(null);
        this.rvPauseHistory.setTag(null);
        this.txtAssets.setTag(null);
        this.txtAssetsHeader.setTag(null);
        this.txtCompletedBy.setTag(null);
        this.txtRoom.setTag(null);
        this.txtRoomHeader.setTag(null);
        this.txtStartBy.setTag(null);
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
            setViewModel((com.icarus.viewmodels.ChecklistReportViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistReportViewModel ViewModel) {
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
        int viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalseViewVISIBLEViewGONE = 0;
        java.lang.String baseApplicationPreferenceManagerGetAssetName = null;
        java.lang.String baseApplicationPreferenceManagerGetRoomName = null;
        android.text.Spanned htmlFromHtmlViewModelGetStartByTitle = null;
        java.lang.String viewModelGetAssignees = null;
        android.text.Spanned htmlFromHtmlViewModelGetCancelledCompletedTitle = null;
        c.anurag.common.preference.PreferenceManager baseApplicationPreferenceManager = null;
        java.lang.String viewModelGetSummaryGetRoom = null;
        boolean viewModelIsLoadingGet = false;
        java.lang.String viewModelGetSummaryGetEquipment = null;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        boolean viewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNone = false;
        boolean viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNone = false;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        boolean viewModelGetPauseHistoryAdapterJavaLangObjectNull = false;
        java.lang.String viewModelGetCancelledCompletedTitle = null;
        java.lang.String stringFormatMboundView5AndroidStringRoomAndAssetXXBaseApplicationPreferenceManagerGetRoomNameBaseApplicationPreferenceManagerGetAssetName = null;
        int viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalseViewGONEViewVISIBLE = 0;
        com.icarus.adapters.ChecklistViewReportElementListAdapter viewModelGetAdapter = null;
        com.icarus.adapters.PauseHistoryAdapter viewModelGetPauseHistoryAdapter = null;
        boolean viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalse = false;
        boolean viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalse = false;
        com.icarus.adapters.ViewReportAssignmentHistoryAdapter viewModelGetAssignmentHistoryAdapter = null;
        int viewModelGetPauseHistoryAdapterGetItemCount = 0;
        com.icarus.models.AssignedChecklistSummary viewModelGetSummary = null;
        java.lang.String viewModelGetStartByTitle = null;
        com.icarus.viewmodels.ChecklistReportViewModel viewModel = mViewModel;
        boolean viewModelGetPauseHistoryAdapterGetItemCountInt0 = false;
        com.icarus.adapters.ViewReportNotesAdapter viewModelGetNotesAdapter = null;

        if ((dirtyFlags & 0x4L) != 0) {

                // read BaseApplication.preferenceManager
                baseApplicationPreferenceManager = com.icarus.base.BaseApplication.getPreferenceManager();


                if (baseApplicationPreferenceManager != null) {
                    // read BaseApplication.preferenceManager.getAssetName()
                    baseApplicationPreferenceManagerGetAssetName = baseApplicationPreferenceManager.getAssetName();
                    // read BaseApplication.preferenceManager.getRoomName()
                    baseApplicationPreferenceManagerGetRoomName = baseApplicationPreferenceManager.getRoomName();
                }


                // read String.format(@android:string/room_and_asset_x_x, BaseApplication.preferenceManager.getRoomName(), BaseApplication.preferenceManager.getAssetName())
                stringFormatMboundView5AndroidStringRoomAndAssetXXBaseApplicationPreferenceManagerGetRoomNameBaseApplicationPreferenceManagerGetAssetName = java.lang.String.format(mboundView5.getResources().getString(R.string.room_and_asset_x_x), baseApplicationPreferenceManagerGetRoomName, baseApplicationPreferenceManagerGetAssetName);
        }
        if ((dirtyFlags & 0x7L) != 0) {


            if ((dirtyFlags & 0x6L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.getAssignees()
                        viewModelGetAssignees = viewModel.getAssignees();
                        // read viewModel.getCancelledCompletedTitle()
                        viewModelGetCancelledCompletedTitle = viewModel.getCancelledCompletedTitle();
                        // read viewModel.getAdapter()
                        viewModelGetAdapter = viewModel.getAdapter();
                        // read viewModel.getPauseHistoryAdapter()
                        viewModelGetPauseHistoryAdapter = viewModel.getPauseHistoryAdapter();
                        // read viewModel.getAssignmentHistoryAdapter()
                        viewModelGetAssignmentHistoryAdapter = viewModel.getAssignmentHistoryAdapter();
                        // read viewModel.getSummary()
                        viewModelGetSummary = viewModel.getSummary();
                        // read viewModel.getStartByTitle()
                        viewModelGetStartByTitle = viewModel.getStartByTitle();
                        // read viewModel.getNotesAdapter()
                        viewModelGetNotesAdapter = viewModel.getNotesAdapter();
                    }


                    // read Html.fromHtml(viewModel.getCancelledCompletedTitle())
                    htmlFromHtmlViewModelGetCancelledCompletedTitle = android.text.Html.fromHtml(viewModelGetCancelledCompletedTitle);
                    // read viewModel.getPauseHistoryAdapter() != null
                    viewModelGetPauseHistoryAdapterJavaLangObjectNull = (viewModelGetPauseHistoryAdapter) != (null);
                    // read Html.fromHtml(viewModel.getStartByTitle())
                    htmlFromHtmlViewModelGetStartByTitle = android.text.Html.fromHtml(viewModelGetStartByTitle);
                if((dirtyFlags & 0x6L) != 0) {
                    if(viewModelGetPauseHistoryAdapterJavaLangObjectNull) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }
                    if (viewModelGetSummary != null) {
                        // read viewModel.getSummary().getRoom()
                        viewModelGetSummaryGetRoom = viewModelGetSummary.getRoom();
                        // read viewModel.getSummary().getEquipment()
                        viewModelGetSummaryGetEquipment = viewModelGetSummary.getEquipment();
                    }


                    if (viewModelGetSummaryGetRoom != null) {
                        // read viewModel.getSummary().getRoom().equalsIgnoreCase("None")
                        viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNone = viewModelGetSummaryGetRoom.equalsIgnoreCase("None");
                    }
                if((dirtyFlags & 0x6L) != 0) {
                    if(viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNone) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }
            }

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
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }


                // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished

        if ((dirtyFlags & 0x400L) != 0) {

                if (viewModelGetSummaryGetEquipment != null) {
                    // read viewModel.getSummary().getEquipment().equalsIgnoreCase("None")
                    viewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNone = viewModelGetSummaryGetEquipment.equalsIgnoreCase("None");
                }
        }
        if ((dirtyFlags & 0x1000L) != 0) {

                if (viewModelGetPauseHistoryAdapter != null) {
                    // read viewModel.getPauseHistoryAdapter().getItemCount()
                    viewModelGetPauseHistoryAdapterGetItemCount = viewModelGetPauseHistoryAdapter.getItemCount();
                }


                // read viewModel.getPauseHistoryAdapter().getItemCount() > 0
                viewModelGetPauseHistoryAdapterGetItemCountInt0 = (viewModelGetPauseHistoryAdapterGetItemCount) > (0);
        }

        if ((dirtyFlags & 0x6L) != 0) {

                // read viewModel.getSummary().getRoom().equalsIgnoreCase("None") ? viewModel.getSummary().getEquipment().equalsIgnoreCase("None") : false
                viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalse = ((viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNone) ? (viewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNone) : (false));
                // read viewModel.getPauseHistoryAdapter() != null ? viewModel.getPauseHistoryAdapter().getItemCount() > 0 : false
                viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalse = ((viewModelGetPauseHistoryAdapterJavaLangObjectNull) ? (viewModelGetPauseHistoryAdapterGetItemCountInt0) : (false));
            if((dirtyFlags & 0x6L) != 0) {
                if(viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalse) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }
            if((dirtyFlags & 0x6L) != 0) {
                if(viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalse) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read viewModel.getSummary().getRoom().equalsIgnoreCase("None") ? viewModel.getSummary().getEquipment().equalsIgnoreCase("None") : false ? View.GONE : View.VISIBLE
                viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalseViewGONEViewVISIBLE = ((viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalse) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read viewModel.getPauseHistoryAdapter() != null ? viewModel.getPauseHistoryAdapter().getItemCount() > 0 : false ? View.VISIBLE : View.GONE
                viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalseViewVISIBLEViewGONE = ((viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalse) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView12.setVisibility(viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalseViewVISIBLEViewGONE);
            this.mboundView14.setVisibility(viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalseViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, viewModelGetAssignees);
            this.mboundView4.setVisibility(viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalseViewGONEViewVISIBLE);
            this.mboundView5.setVisibility(viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalseViewGONEViewVISIBLE);
            this.mboundView6.setVisibility(viewModelGetSummaryGetRoomEqualsIgnoreCaseJavaLangStringNoneViewModelGetSummaryGetEquipmentEqualsIgnoreCaseJavaLangStringNoneBooleanFalseViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.rvAssignmentHistory, viewModelGetAssignmentHistoryAdapter);
            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.rvElements, viewModelGetAdapter);
            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.rvNotes, viewModelGetNotesAdapter);
            this.rvPauseHistory.setVisibility(viewModelGetPauseHistoryAdapterJavaLangObjectNullViewModelGetPauseHistoryAdapterGetItemCountInt0BooleanFalseViewVISIBLEViewGONE);
            com.icarus.bindings.CustomViewBindings.setListItemDivider(this.rvPauseHistory, viewModelGetPauseHistoryAdapter);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtAssets, viewModelGetSummaryGetEquipment);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtCompletedBy, htmlFromHtmlViewModelGetCancelledCompletedTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRoom, viewModelGetSummaryGetRoom);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtStartBy, htmlFromHtmlViewModelGetStartByTitle);
        }
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            this.mboundView17.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, stringFormatMboundView5AndroidStringRoomAndAssetXXBaseApplicationPreferenceManagerGetRoomNameBaseApplicationPreferenceManagerGetAssetName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtAssetsHeader, baseApplicationPreferenceManagerGetAssetName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRoomHeader, baseApplicationPreferenceManagerGetRoomName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isLoading
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
        flag 3 (0x4L): viewModel.getPauseHistoryAdapter() != null ? viewModel.getPauseHistoryAdapter().getItemCount() > 0 : false ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewModel.getPauseHistoryAdapter() != null ? viewModel.getPauseHistoryAdapter().getItemCount() > 0 : false ? View.VISIBLE : View.GONE
        flag 5 (0x6L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): viewModel.getSummary().getRoom().equalsIgnoreCase("None") ? viewModel.getSummary().getEquipment().equalsIgnoreCase("None") : false ? View.GONE : View.VISIBLE
        flag 8 (0x9L): viewModel.getSummary().getRoom().equalsIgnoreCase("None") ? viewModel.getSummary().getEquipment().equalsIgnoreCase("None") : false ? View.GONE : View.VISIBLE
        flag 9 (0xaL): viewModel.getSummary().getRoom().equalsIgnoreCase("None") ? viewModel.getSummary().getEquipment().equalsIgnoreCase("None") : false
        flag 10 (0xbL): viewModel.getSummary().getRoom().equalsIgnoreCase("None") ? viewModel.getSummary().getEquipment().equalsIgnoreCase("None") : false
        flag 11 (0xcL): viewModel.getPauseHistoryAdapter() != null ? viewModel.getPauseHistoryAdapter().getItemCount() > 0 : false
        flag 12 (0xdL): viewModel.getPauseHistoryAdapter() != null ? viewModel.getPauseHistoryAdapter().getItemCount() > 0 : false
    flag mapping end*/
    //end
}