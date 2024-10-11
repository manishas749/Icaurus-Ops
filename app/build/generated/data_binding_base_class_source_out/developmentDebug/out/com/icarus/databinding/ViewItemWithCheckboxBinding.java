// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.icarus.R;
import com.icarus.enums.FilterListType;
import com.icarus.viewmodels.DashboardViewModel;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Object;

public abstract class ViewItemWithCheckboxBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatCheckBox checkBoxSelect;

  @NonNull
  public final TextView textView;

  @Bindable
  protected FilterListType mFilterListType;

  @Bindable
  protected Integer mPosition;

  @Bindable
  protected DashboardViewModel mViewModel;

  protected ViewItemWithCheckboxBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatCheckBox checkBoxSelect, TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.checkBoxSelect = checkBoxSelect;
    this.textView = textView;
  }

  public abstract void setFilterListType(@Nullable FilterListType filterListType);

  @Nullable
  public FilterListType getFilterListType() {
    return mFilterListType;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  public abstract void setViewModel(@Nullable DashboardViewModel viewModel);

  @Nullable
  public DashboardViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ViewItemWithCheckboxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.view_item_with_checkbox, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ViewItemWithCheckboxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ViewItemWithCheckboxBinding>inflateInternal(inflater, R.layout.view_item_with_checkbox, root, attachToRoot, component);
  }

  @NonNull
  public static ViewItemWithCheckboxBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.view_item_with_checkbox, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ViewItemWithCheckboxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ViewItemWithCheckboxBinding>inflateInternal(inflater, R.layout.view_item_with_checkbox, null, false, component);
  }

  public static ViewItemWithCheckboxBinding bind(@NonNull View view) {
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
  public static ViewItemWithCheckboxBinding bind(@NonNull View view, @Nullable Object component) {
    return (ViewItemWithCheckboxBinding)bind(component, view, R.layout.view_item_with_checkbox);
  }
}
