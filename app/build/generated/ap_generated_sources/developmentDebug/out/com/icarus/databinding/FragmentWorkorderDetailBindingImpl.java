package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWorkorderDetailBindingImpl extends FragmentWorkorderDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.view, 5);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.ProgressBar mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener titleandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of item.title
            //         is item.setTitle((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(title);
            // localize variables for thread safety
            // item.title
            java.lang.String itemTitle = null;
            // item
            com.icarus.workorder.models.WorkOrderDetailItems item = mItem;
            // item != null
            boolean itemJavaLangObjectNull = false;



            itemJavaLangObjectNull = (item) != (null);
            if (itemJavaLangObjectNull) {




                item.setTitle(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentWorkorderDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentWorkorderDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (android.view.View) bindings[5]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.ProgressBar) bindings[4];
        this.mboundView4.setTag(null);
        this.recyclerView.setTag(null);
        this.recyclerViewItem.setTag(null);
        this.title.setTag(null);
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
            setItem((com.icarus.workorder.models.WorkOrderDetailItems) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.workorder.viewmodels.WorkOrderDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.workorder.models.WorkOrderDetailItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.icarus.workorder.viewmodels.WorkOrderDetailViewModel ViewModel) {
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
        com.icarus.workorder.models.WorkOrderDetailItems item = mItem;
        androidx.recyclerview.widget.RecyclerView.Adapter viewModelGetWorkOrderInfoAdapter = null;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        java.lang.String itemTitle = null;
        com.icarus.workorder.adapters.WorkOrderNoteInfoAdapter viewModelGetWorkOrderNoteInfoAdapter = null;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        boolean viewModelIsLoadingGet = false;
        com.icarus.workorder.viewmodels.WorkOrderDetailViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xaL) != 0) {



                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                }
        }
        if ((dirtyFlags & 0xdL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.getWorkOrderInfoAdapter()
                        viewModelGetWorkOrderInfoAdapter = viewModel.getWorkOrderInfoAdapter();
                        // read viewModel.getWorkOrderNoteInfoAdapter()
                        viewModelGetWorkOrderNoteInfoAdapter = viewModel.getWorkOrderNoteInfoAdapter();
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
            if((dirtyFlags & 0xdL) != 0) {
                if(viewModelIsLoadingGet) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read viewModel.isLoading.get() ? View.VISIBLE : View.GONE
                viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.mboundView4.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.icarus.workorder.viewmodels.WorkOrderDetailViewModel.bindRecyclerViewGridAdapter(this.recyclerView, viewModelGetWorkOrderInfoAdapter);
            com.icarus.workorder.viewmodels.WorkOrderDetailViewModel.bindRecyclerViewAdapter(this.recyclerViewItem, viewModelGetWorkOrderNoteInfoAdapter);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, itemTitle);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.title, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, titleandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isLoading
        flag 1 (0x2L): item
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 5 (0x6L): viewModel.isLoading.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}