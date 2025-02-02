// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.icarus.R;
import com.icarus.viewmodels.ChecklistExecutionViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentBarcodeScannerBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout layoutScanner;

  @Bindable
  protected ChecklistExecutionViewModel mViewModel;

  protected FragmentBarcodeScannerBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout layoutScanner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.layoutScanner = layoutScanner;
  }

  public abstract void setViewModel(@Nullable ChecklistExecutionViewModel viewModel);

  @Nullable
  public ChecklistExecutionViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentBarcodeScannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_barcode_scanner, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentBarcodeScannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentBarcodeScannerBinding>inflateInternal(inflater, R.layout.fragment_barcode_scanner, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentBarcodeScannerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_barcode_scanner, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentBarcodeScannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentBarcodeScannerBinding>inflateInternal(inflater, R.layout.fragment_barcode_scanner, null, false, component);
  }

  public static FragmentBarcodeScannerBinding bind(@NonNull View view) {
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
  public static FragmentBarcodeScannerBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentBarcodeScannerBinding)bind(component, view, R.layout.fragment_barcode_scanner);
  }
}
