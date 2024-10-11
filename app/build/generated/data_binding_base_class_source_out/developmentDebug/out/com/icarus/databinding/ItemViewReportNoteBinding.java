// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.icarus.R;
import com.icarus.models.ChecklistNotesItem;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemViewReportNoteBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatTextView comment;

  @NonNull
  public final AppCompatTextView updatedAt;

  @NonNull
  public final AppCompatTextView updatedBy;

  @Bindable
  protected ChecklistNotesItem mItem;

  protected ItemViewReportNoteBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatTextView comment, AppCompatTextView updatedAt, AppCompatTextView updatedBy) {
    super(_bindingComponent, _root, _localFieldCount);
    this.comment = comment;
    this.updatedAt = updatedAt;
    this.updatedBy = updatedBy;
  }

  public abstract void setItem(@Nullable ChecklistNotesItem item);

  @Nullable
  public ChecklistNotesItem getItem() {
    return mItem;
  }

  @NonNull
  public static ItemViewReportNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_view_report_note, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemViewReportNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemViewReportNoteBinding>inflateInternal(inflater, R.layout.item_view_report_note, root, attachToRoot, component);
  }

  @NonNull
  public static ItemViewReportNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_view_report_note, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemViewReportNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemViewReportNoteBinding>inflateInternal(inflater, R.layout.item_view_report_note, null, false, component);
  }

  public static ItemViewReportNoteBinding bind(@NonNull View view) {
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
  public static ItemViewReportNoteBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemViewReportNoteBinding)bind(component, view, R.layout.item_view_report_note);
  }
}
