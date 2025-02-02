// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.icarus.R;
import com.icarus.models.ElementAttributesItems;
import com.icarus.viewmodels.AllCaptureDataViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemAllCapturedDataFilesBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView imgCaptured;

  @NonNull
  public final AppCompatTextView txtCapturedBy;

  @NonNull
  public final AppCompatTextView txtCapturedDate;

  @NonNull
  public final AppCompatTextView txtValue;

  @Bindable
  protected AllCaptureDataViewModel mViewModel;

  @Bindable
  protected ElementAttributesItems mItem;

  protected ItemAllCapturedDataFilesBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatImageView imgCaptured, AppCompatTextView txtCapturedBy,
      AppCompatTextView txtCapturedDate, AppCompatTextView txtValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imgCaptured = imgCaptured;
    this.txtCapturedBy = txtCapturedBy;
    this.txtCapturedDate = txtCapturedDate;
    this.txtValue = txtValue;
  }

  public abstract void setViewModel(@Nullable AllCaptureDataViewModel viewModel);

  @Nullable
  public AllCaptureDataViewModel getViewModel() {
    return mViewModel;
  }

  public abstract void setItem(@Nullable ElementAttributesItems item);

  @Nullable
  public ElementAttributesItems getItem() {
    return mItem;
  }

  @NonNull
  public static ItemAllCapturedDataFilesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_all_captured_data_files, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemAllCapturedDataFilesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemAllCapturedDataFilesBinding>inflateInternal(inflater, R.layout.item_all_captured_data_files, root, attachToRoot, component);
  }

  @NonNull
  public static ItemAllCapturedDataFilesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_all_captured_data_files, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemAllCapturedDataFilesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemAllCapturedDataFilesBinding>inflateInternal(inflater, R.layout.item_all_captured_data_files, null, false, component);
  }

  public static ItemAllCapturedDataFilesBinding bind(@NonNull View view) {
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
  public static ItemAllCapturedDataFilesBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemAllCapturedDataFilesBinding)bind(component, view, R.layout.item_all_captured_data_files);
  }
}
