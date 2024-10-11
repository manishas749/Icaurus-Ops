package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BottomSheetWorkorderFilterBindingImpl extends BottomSheetWorkorderFilterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtFilter, 5);
        sViewsWithIds.put(R.id.txtType, 6);
        sViewsWithIds.put(R.id.viewType, 7);
        sViewsWithIds.put(R.id.txtStatus, 8);
        sViewsWithIds.put(R.id.viewStatus, 9);
        sViewsWithIds.put(R.id.txtAssignedTo, 10);
        sViewsWithIds.put(R.id.viewAssignedTo, 11);
        sViewsWithIds.put(R.id.txtDepartment, 12);
        sViewsWithIds.put(R.id.viewDepartment, 13);
        sViewsWithIds.put(R.id.btnApply, 14);
        sViewsWithIds.put(R.id.clearFilter, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BottomSheetWorkorderFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private BottomSheetWorkorderFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (androidx.core.widget.NestedScrollView) bindings[0]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.view.View) bindings[11]
            , (android.view.View) bindings[13]
            , (android.view.View) bindings[9]
            , (android.view.View) bindings[7]
            );
        this.recyclerViewAssignedTo.setTag(null);
        this.recyclerViewDepartment.setTag(null);
        this.recyclerViewStatus.setTag(null);
        this.recyclerViewType.setTag(null);
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
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderViewModel ViewModel) {
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
        com.icarus.workorder.adapters.FilterWorkOrderListAdapter viewModelGetAssignedToListAdapter = null;
        com.icarus.workorder.adapters.FilterWorkOrderListAdapter viewModelGetTypeListAdapter = null;
        com.icarus.workorder.adapters.FilterWorkOrderListAdapter viewModelGetAuthorListAdapter = null;
        com.icarus.workorder.adapters.FilterWorkOrderListAdapter viewModelGetPriorityListAdapter = null;
        com.icarus.workorder.viewmodels.WorkOrderViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.getAssignedToListAdapter()
                    viewModelGetAssignedToListAdapter = viewModel.getAssignedToListAdapter();
                    // read viewModel.getTypeListAdapter()
                    viewModelGetTypeListAdapter = viewModel.getTypeListAdapter();
                    // read viewModel.getAuthorListAdapter()
                    viewModelGetAuthorListAdapter = viewModel.getAuthorListAdapter();
                    // read viewModel.getPriorityListAdapter()
                    viewModelGetPriorityListAdapter = viewModel.getPriorityListAdapter();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewAssignedTo, viewModelGetAssignedToListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewDepartment, viewModelGetAuthorListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewStatus, viewModelGetPriorityListAdapter);
            com.icarus.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.recyclerViewType, viewModelGetTypeListAdapter);
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