// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.icarus.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityWebviewBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final WebView webView;

  protected ActivityWebviewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Toolbar toolbar, WebView webView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.toolbar = toolbar;
    this.webView = webView;
  }

  @NonNull
  public static ActivityWebviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_webview, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWebviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityWebviewBinding>inflateInternal(inflater, R.layout.activity_webview, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWebviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_webview, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWebviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityWebviewBinding>inflateInternal(inflater, R.layout.activity_webview, null, false, component);
  }

  public static ActivityWebviewBinding bind(@NonNull View view) {
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
  public static ActivityWebviewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityWebviewBinding)bind(component, view, R.layout.activity_webview);
  }
}
