// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.icarus.R;
import com.icarus.workorder.models.WorkOrderDetailItems;
import com.icarus.workorder.viewmodels.WorkOrderDetailViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWorkorderDetailBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final RecyclerView recyclerViewItem;

  @NonNull
  public final TextView title;

  @NonNull
  public final View view;

  @Bindable
  protected WorkOrderDetailItems mItem;

  @Bindable
  protected WorkOrderDetailViewModel mViewModel;

  protected FragmentWorkorderDetailBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView recyclerView, RecyclerView recyclerViewItem,
      TextView title, View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recyclerView = recyclerView;
    this.recyclerViewItem = recyclerViewItem;
    this.title = title;
    this.view = view;
  }

  public abstract void setItem(@Nullable WorkOrderDetailItems item);

  @Nullable
  public WorkOrderDetailItems getItem() {
    return mItem;
  }

  public abstract void setViewModel(@Nullable WorkOrderDetailViewModel viewModel);

  @Nullable
  public WorkOrderDetailViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentWorkorderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_workorder_detail, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWorkorderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWorkorderDetailBinding>inflateInternal(inflater, R.layout.fragment_workorder_detail, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWorkorderDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_workorder_detail, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWorkorderDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWorkorderDetailBinding>inflateInternal(inflater, R.layout.fragment_workorder_detail, null, false, component);
  }

  public static FragmentWorkorderDetailBinding bind(@NonNull View view) {
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
  public static FragmentWorkorderDetailBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentWorkorderDetailBinding)bind(component, view, R.layout.fragment_workorder_detail);
  }
}
