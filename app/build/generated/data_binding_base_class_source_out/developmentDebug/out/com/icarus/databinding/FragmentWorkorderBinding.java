// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.icarus.R;
import com.icarus.viewmodels.DashboardViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWorkorderBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout emptyView;

  @NonNull
  public final AppCompatImageView emptyViewImage;

  @NonNull
  public final TextView emptyViewText2;

  @NonNull
  public final TextView emptyViewText3;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final RecyclerView recyclerView;

  @Bindable
  protected DashboardViewModel mViewModel;

  protected FragmentWorkorderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout emptyView, AppCompatImageView emptyViewImage, TextView emptyViewText2,
      TextView emptyViewText3, FloatingActionButton fab, RecyclerView recyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.emptyView = emptyView;
    this.emptyViewImage = emptyViewImage;
    this.emptyViewText2 = emptyViewText2;
    this.emptyViewText3 = emptyViewText3;
    this.fab = fab;
    this.recyclerView = recyclerView;
  }

  public abstract void setViewModel(@Nullable DashboardViewModel viewModel);

  @Nullable
  public DashboardViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentWorkorderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_workorder, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWorkorderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWorkorderBinding>inflateInternal(inflater, R.layout.fragment_workorder, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWorkorderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_workorder, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWorkorderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWorkorderBinding>inflateInternal(inflater, R.layout.fragment_workorder, null, false, component);
  }

  public static FragmentWorkorderBinding bind(@NonNull View view) {
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
  public static FragmentWorkorderBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentWorkorderBinding)bind(component, view, R.layout.fragment_workorder);
  }
}
