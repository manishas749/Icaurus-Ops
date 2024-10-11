// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.icarus.R;
import com.icarus.viewmodels.TermsAndConditionsViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityTermsAndConditionsBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final ContentTermsAndConditionsBinding contentTermsAndConditions;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final CollapsingToolbarLayout toolbarLayout;

  @Bindable
  protected TermsAndConditionsViewModel mViewModel;

  protected ActivityTermsAndConditionsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppBarLayout appBar,
      ContentTermsAndConditionsBinding contentTermsAndConditions, Toolbar toolbar,
      CollapsingToolbarLayout toolbarLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    this.contentTermsAndConditions = contentTermsAndConditions;
    setContainedBinding(this.contentTermsAndConditions);
    this.toolbar = toolbar;
    this.toolbarLayout = toolbarLayout;
  }

  public abstract void setViewModel(@Nullable TermsAndConditionsViewModel viewModel);

  @Nullable
  public TermsAndConditionsViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityTermsAndConditionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_terms_and_conditions, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTermsAndConditionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityTermsAndConditionsBinding>inflateInternal(inflater, R.layout.activity_terms_and_conditions, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTermsAndConditionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_terms_and_conditions, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTermsAndConditionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityTermsAndConditionsBinding>inflateInternal(inflater, R.layout.activity_terms_and_conditions, null, false, component);
  }

  public static ActivityTermsAndConditionsBinding bind(@NonNull View view) {
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
  public static ActivityTermsAndConditionsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityTermsAndConditionsBinding)bind(component, view, R.layout.activity_terms_and_conditions);
  }
}
