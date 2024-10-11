package com.icarus.databinding;
import com.icarus.R;
import com.icarus.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentStepProcedureBindingImpl extends FragmentStepProcedureBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nestedScrollView, 6);
        sViewsWithIds.put(R.id.recyclerViewEquipments, 7);
        sViewsWithIds.put(R.id.embeddedImageContainer, 8);
        sViewsWithIds.put(R.id.viewPagerEmbeddedImages, 9);
        sViewsWithIds.put(R.id.pagerDots, 10);
        sViewsWithIds.put(R.id.dashLine, 11);
        sViewsWithIds.put(R.id.recordDetails, 12);
        sViewsWithIds.put(R.id.containerAttributes, 13);
        sViewsWithIds.put(R.id.btnSlide, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentStepProcedureBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private FragmentStepProcedureBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.icarus.customviews.SlideButton) bindings[14]
            , (android.widget.LinearLayout) bindings[13]
            , (com.icarus.customviews.DashedLine) bindings[11]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (android.widget.RelativeLayout) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (com.icarus.customviews.VerticalScrollView) bindings[6]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.Button) bindings[12]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            , (androidx.viewpager.widget.ViewPager) bindings[9]
            );
        this.desc.setTag(null);
        this.label.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.appcompat.widget.AppCompatTextView) bindings[1];
        this.mboundView1.setTag(null);
        this.stepDetail.setTag(null);
        this.txtDescription.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
            setItem((com.icarus.models.ChecklistDetailItems) variable);
        }
        else if (BR.totalEmbeddedImageCount == variableId) {
            setTotalEmbeddedImageCount((java.lang.Integer) variable);
        }
        else if (BR.currentEmbeddedImageCount == variableId) {
            setCurrentEmbeddedImageCount((java.lang.Integer) variable);
        }
        else if (BR.resourceEntity == variableId) {
            setResourceEntity((com.icarus.entities.ResourceEntity) variable);
        }
        else if (BR.constants == variableId) {
            setConstants((com.icarus.constants.Constants) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.icarus.viewmodels.ChecklistExecutionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.icarus.models.ChecklistDetailItems Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setTotalEmbeddedImageCount(@Nullable java.lang.Integer TotalEmbeddedImageCount) {
        this.mTotalEmbeddedImageCount = TotalEmbeddedImageCount;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.totalEmbeddedImageCount);
        super.requestRebind();
    }
    public void setCurrentEmbeddedImageCount(@Nullable java.lang.Integer CurrentEmbeddedImageCount) {
        this.mCurrentEmbeddedImageCount = CurrentEmbeddedImageCount;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.currentEmbeddedImageCount);
        super.requestRebind();
    }
    public void setResourceEntity(@Nullable com.icarus.entities.ResourceEntity ResourceEntity) {
        this.mResourceEntity = ResourceEntity;
    }
    public void setConstants(@Nullable com.icarus.constants.Constants Constants) {
        this.mConstants = Constants;
    }
    public void setViewModel(@Nullable com.icarus.viewmodels.ChecklistExecutionViewModel ViewModel) {
        this.mViewModel = ViewModel;
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
        com.icarus.models.ChecklistDetailItems item = mItem;
        java.lang.Integer totalEmbeddedImageCount = mTotalEmbeddedImageCount;
        java.lang.Integer currentEmbeddedImageCount = mCurrentEmbeddedImageCount;
        int itemIsStepViewVISIBLEViewGONE = 0;
        java.lang.String itemTitle = null;
        java.lang.String itemDescription = null;
        int itemIsStepViewGONEViewVISIBLE = 0;
        java.lang.String mboundView1AndroidStringMarkCompleteCountCurrentEmbeddedImageCountTotalEmbeddedImageCount = null;
        boolean itemIsStep = false;
        java.lang.String stringFormatMboundView1AndroidStringMarkCompleteCountCurrentEmbeddedImageCountTotalEmbeddedImageCount = null;

        if ((dirtyFlags & 0x41L) != 0) {



                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.description
                    itemDescription = item.getDescription();
                    // read item.isStep()
                    itemIsStep = item.isStep();
                }
            if((dirtyFlags & 0x41L) != 0) {
                if(itemIsStep) {
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x400L;
                }
                else {
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x200L;
                }
            }


                // read item.isStep() ? View.VISIBLE : View.GONE
                itemIsStepViewVISIBLEViewGONE = ((itemIsStep) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read item.isStep() ? View.GONE : View.VISIBLE
                itemIsStepViewGONEViewVISIBLE = ((itemIsStep) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x46L) != 0) {



                // read @android:string/mark_complete_count
                mboundView1AndroidStringMarkCompleteCountCurrentEmbeddedImageCountTotalEmbeddedImageCount = mboundView1.getResources().getString(R.string.mark_complete_count, currentEmbeddedImageCount, totalEmbeddedImageCount);


                // read String.format(@android:string/mark_complete_count)
                stringFormatMboundView1AndroidStringMarkCompleteCountCurrentEmbeddedImageCountTotalEmbeddedImageCount = java.lang.String.format(mboundView1AndroidStringMarkCompleteCountCurrentEmbeddedImageCountTotalEmbeddedImageCount);
        }
        // batch finished
        if ((dirtyFlags & 0x41L) != 0) {
            // api target 1

            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.desc, itemDescription);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.label, itemTitle);
            this.stepDetail.setVisibility(itemIsStepViewVISIBLEViewGONE);
            this.txtDescription.setVisibility(itemIsStepViewGONEViewVISIBLE);
            com.icarus.bindings.CustomViewBindings.setCompactHtml(this.txtDescription, itemTitle);
        }
        if ((dirtyFlags & 0x46L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, stringFormatMboundView1AndroidStringMarkCompleteCountCurrentEmbeddedImageCountTotalEmbeddedImageCount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): totalEmbeddedImageCount
        flag 2 (0x3L): currentEmbeddedImageCount
        flag 3 (0x4L): resourceEntity
        flag 4 (0x5L): constants
        flag 5 (0x6L): viewModel
        flag 6 (0x7L): null
        flag 7 (0x8L): item.isStep() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): item.isStep() ? View.VISIBLE : View.GONE
        flag 9 (0xaL): item.isStep() ? View.GONE : View.VISIBLE
        flag 10 (0xbL): item.isStep() ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}