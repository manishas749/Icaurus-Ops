// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.icarus.R;
import com.icarus.constants.Constants;
import com.icarus.customviews.DashedLine;
import com.icarus.customviews.SlideButton;
import com.icarus.customviews.VerticalScrollView;
import com.icarus.entities.ResourceEntity;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.viewmodels.ChecklistExecutionViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentStepProcedureBinding extends ViewDataBinding {
  @NonNull
  public final SlideButton btnSlide;

  @NonNull
  public final LinearLayout containerAttributes;

  @NonNull
  public final DashedLine dashLine;

  @NonNull
  public final AppCompatTextView desc;

  @NonNull
  public final RelativeLayout embeddedImageContainer;

  @NonNull
  public final AppCompatTextView label;

  @NonNull
  public final VerticalScrollView nestedScrollView;

  @NonNull
  public final LinearLayout pagerDots;

  @NonNull
  public final Button recordDetails;

  @NonNull
  public final RecyclerView recyclerViewEquipments;

  @NonNull
  public final ConstraintLayout stepDetail;

  @NonNull
  public final AppCompatTextView txtDescription;

  @NonNull
  public final ViewPager viewPagerEmbeddedImages;

  @Bindable
  protected ChecklistDetailItems mItem;

  @Bindable
  protected Constants mConstants;

  @Bindable
  protected ResourceEntity mResourceEntity;

  @Bindable
  protected ChecklistExecutionViewModel mViewModel;

  @Bindable
  protected Integer mCurrentEmbeddedImageCount;

  @Bindable
  protected Integer mTotalEmbeddedImageCount;

  protected FragmentStepProcedureBinding(Object _bindingComponent, View _root, int _localFieldCount,
      SlideButton btnSlide, LinearLayout containerAttributes, DashedLine dashLine,
      AppCompatTextView desc, RelativeLayout embeddedImageContainer, AppCompatTextView label,
      VerticalScrollView nestedScrollView, LinearLayout pagerDots, Button recordDetails,
      RecyclerView recyclerViewEquipments, ConstraintLayout stepDetail,
      AppCompatTextView txtDescription, ViewPager viewPagerEmbeddedImages) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSlide = btnSlide;
    this.containerAttributes = containerAttributes;
    this.dashLine = dashLine;
    this.desc = desc;
    this.embeddedImageContainer = embeddedImageContainer;
    this.label = label;
    this.nestedScrollView = nestedScrollView;
    this.pagerDots = pagerDots;
    this.recordDetails = recordDetails;
    this.recyclerViewEquipments = recyclerViewEquipments;
    this.stepDetail = stepDetail;
    this.txtDescription = txtDescription;
    this.viewPagerEmbeddedImages = viewPagerEmbeddedImages;
  }

  public abstract void setItem(@Nullable ChecklistDetailItems item);

  @Nullable
  public ChecklistDetailItems getItem() {
    return mItem;
  }

  public abstract void setConstants(@Nullable Constants constants);

  @Nullable
  public Constants getConstants() {
    return mConstants;
  }

  public abstract void setResourceEntity(@Nullable ResourceEntity resourceEntity);

  @Nullable
  public ResourceEntity getResourceEntity() {
    return mResourceEntity;
  }

  public abstract void setViewModel(@Nullable ChecklistExecutionViewModel viewModel);

  @Nullable
  public ChecklistExecutionViewModel getViewModel() {
    return mViewModel;
  }

  public abstract void setCurrentEmbeddedImageCount(@Nullable Integer currentEmbeddedImageCount);

  @Nullable
  public Integer getCurrentEmbeddedImageCount() {
    return mCurrentEmbeddedImageCount;
  }

  public abstract void setTotalEmbeddedImageCount(@Nullable Integer totalEmbeddedImageCount);

  @Nullable
  public Integer getTotalEmbeddedImageCount() {
    return mTotalEmbeddedImageCount;
  }

  @NonNull
  public static FragmentStepProcedureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_step_procedure, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStepProcedureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentStepProcedureBinding>inflateInternal(inflater, R.layout.fragment_step_procedure, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentStepProcedureBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_step_procedure, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStepProcedureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentStepProcedureBinding>inflateInternal(inflater, R.layout.fragment_step_procedure, null, false, component);
  }

  public static FragmentStepProcedureBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentStepProcedureBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentStepProcedureBinding)bind(component, view, R.layout.fragment_step_procedure);
  }
}
