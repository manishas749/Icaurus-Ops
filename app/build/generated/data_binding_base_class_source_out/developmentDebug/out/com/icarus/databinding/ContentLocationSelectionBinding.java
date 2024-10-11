// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.icarus.R;
import com.icarus.viewmodels.ChangeLocationViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ContentLocationSelectionBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar locationProgress;

  @NonNull
  public final NestedScrollView nestedScrollView;

  @NonNull
  public final RadioGroup radioGroup;

  @Bindable
  protected ChangeLocationViewModel mViewModel;

  protected ContentLocationSelectionBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ProgressBar locationProgress, NestedScrollView nestedScrollView,
      RadioGroup radioGroup) {
    super(_bindingComponent, _root, _localFieldCount);
    this.locationProgress = locationProgress;
    this.nestedScrollView = nestedScrollView;
    this.radioGroup = radioGroup;
  }

  public abstract void setViewModel(@Nullable ChangeLocationViewModel viewModel);

  @Nullable
  public ChangeLocationViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ContentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.content_location_selection, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ContentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ContentLocationSelectionBinding>inflateInternal(inflater, R.layout.content_location_selection, root, attachToRoot, component);
  }

  @NonNull
  public static ContentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.content_location_selection, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ContentLocationSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ContentLocationSelectionBinding>inflateInternal(inflater, R.layout.content_location_selection, null, false, component);
  }

  public static ContentLocationSelectionBinding bind(@NonNull View view) {
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
  public static ContentLocationSelectionBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ContentLocationSelectionBinding)bind(component, view, R.layout.content_location_selection);
  }
}
