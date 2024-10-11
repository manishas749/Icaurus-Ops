package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BottomSheetFilterBindingImpl extends BottomSheetFilterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtFilter, 7);
        sViewsWithIds.put(R.id.txtType, 8);
        sViewsWithIds.put(R.id.viewType, 9);
        sViewsWithIds.put(R.id.txtStatus, 10);
        sViewsWithIds.put(R.id.viewStatus, 11);
        sViewsWithIds.put(R.id.txtDepartment, 12);
        sViewsWithIds.put(R.id.viewDepartment, 13);
        sViewsWithIds.put(R.id.txtUser, 14);
        sViewsWithIds.put(R.id.viewUser, 15);
        sViewsWithIds.put(R.id.txtAssignedTo, 16);
        sViewsWithIds.put(R.id.viewAssignedTo, 17);
        sViewsWithIds.put(R.id.recyclerViewAssignedTo, 18);
        sViewsWithIds.put(R.id.txtAuthor, 19);
        sViewsWithIds.put(R.id.viewAuthor, 20);
        sViewsWithIds.put(R.id.txtPriority, 21);
        sViewsWithIds.put(R.id.viewPriority, 22);
        sViewsWithIds.put(R.id.btnApply, 23);
        sViewsWithIds.put(R.id.clearFilter, 24);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BottomSheetFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private BottomSheetFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[23]
            , (android.widget.TextView) bindings[24]
            , (android.widget.RadioGroup) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[14]
            , (android.view.View) bindings[17]
            , (android.view.View) bindings[20]
            , (android.view.View) bindings[13]
            , (android.view.View) bindings[22]
            , (android.view.View) bindings[11]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[15]
            );
        this.recyclerViewAuthor.setTag(null);
        this.recyclerViewDepartment.setTag(null);
        this.recyclerViewPriority.setTag(null);
        this.recyclerViewStatus.setTag(null);
        this.recyclerViewType.setTag(null);
        this.recyclerViewUser.setTag(null);
        this.top.setTag(null);
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
        if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.viewmodels.DashboardViewModel ViewModel) {
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
        com.icarus.adapters.FilterListAdapter viewModelGetTypeListAdapter = null;
        com.icarus.adapters.FilterListAdapter viewModelGetUserListAdapter = null;
        com.icarus.adapters.FilterListAdapter viewModelGetPriorityListAdapter = null;
        com.icarus.adapters.FilterListAdapter viewModelGetDepartmentListAdapter = null;
        com.icarus.adapters.FilterListAdapter viewModelGetAuthorListAdapter = null;
        com.icarus.viewmodels.DashboardViewModel viewModel = mViewModel;
        com.icarus.adapters.FilterListAdapter viewModelGetStatusListAdapter = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.getTypeListAdapter()
                    viewModelGetTypeListAdapter = viewModel.getTypeListAdapter();
                    // read viewModel.getUserListAdapter()
                    viewModelGetUserListAdapter = viewModel.getUserListAdapter();
                    // read viewModel.getPriorityListAdapter()
                    viewModelGetPriorityListAdapter = viewModel.getPriorityListAdapter();
                    // read viewModel.getDepartmentListAdapter()
                    viewModelGetDepartmentListAdapter = viewModel.getDepartmentListAdapter();
                    // read viewModel.getAuthorListAdapter()
                    viewModelGetAuthorListAdapter = viewModel.getAuthorListAdapter();
                    // read viewModel.getStatusListAdapter()
                    viewModelGetStatusListAdapter = viewModel.getStatusListAdapter();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewAuthor, viewModelGetAuthorListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewDepartment, viewModelGetDepartmentListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewPriority, viewModelGetPriorityListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewStatus, viewModelGetStatusListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewType, viewModelGetTypeListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewUser, viewModelGetUserListAdapter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}