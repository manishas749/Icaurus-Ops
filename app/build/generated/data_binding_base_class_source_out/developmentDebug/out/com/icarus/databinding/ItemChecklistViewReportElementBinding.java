// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.icarus.R;
import com.icarus.adapters.ChecklistViewReportLogsAdapter;
import com.icarus.customviews.DashedLine;
import com.icarus.models.ChecklistElementItem;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemChecklistViewReportElementBinding extends ViewDataBinding {
  @NonNull
  public final Barrier barrier;

  @NonNull
  public final DashedLine dashLine;

  @NonNull
  public final AppCompatTextView desc;

  @NonNull
  public final AppCompatTextView description;

  @NonNull
  public final AppCompatImageView image;

  @NonNull
  public final AppCompatImageView imageNCW;

  @NonNull
  public final AppCompatTextView label;

  @NonNull
  public final RecyclerView recyclerIcons;

  @NonNull
  public final RecyclerView recyclerLog;

  @NonNull
  public final TextView sequenceNumber;

  @Bindable
  protected ChecklistElementItem mItem;

  @Bindable
  protected Integer mPosition;

  @Bindable
  protected ChecklistViewReportLogsAdapter mLogsAdapter;

  protected ItemChecklistViewReportElementBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Barrier barrier, DashedLine dashLine, AppCompatTextView desc,
      AppCompatTextView description, AppCompatImageView image, AppCompatImageView imageNCW,
      AppCompatTextView label, RecyclerView recyclerIcons, RecyclerView recyclerLog,
      TextView sequenceNumber) {
    super(_bindingComponent, _root, _localFieldCount);
    this.barrier = barrier;
    this.dashLine = dashLine;
    this.desc = desc;
    this.description = description;
    this.image = image;
    this.imageNCW = imageNCW;
    this.label = label;
    this.recyclerIcons = recyclerIcons;
    this.recyclerLog = recyclerLog;
    this.sequenceNumber = sequenceNumber;
  }

  public abstract void setItem(@Nullable ChecklistElementItem item);

  @Nullable
  public ChecklistElementItem getItem() {
    return mItem;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  public abstract void setLogsAdapter(@Nullable ChecklistViewReportLogsAdapter logsAdapter);

  @Nullable
  public ChecklistViewReportLogsAdapter getLogsAdapter() {
    return mLogsAdapter;
  }

  @NonNull
  public static ItemChecklistViewReportElementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_checklist_view_report_element, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemChecklistViewReportElementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemChecklistViewReportElementBinding>inflateInternal(inflater, R.layout.item_checklist_view_report_element, root, attachToRoot, component);
  }

  @NonNull
  public static ItemChecklistViewReportElementBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_checklist_view_report_element, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemChecklistViewReportElementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemChecklistViewReportElementBinding>inflateInternal(inflater, R.layout.item_checklist_view_report_element, null, false, component);
  }

  public static ItemChecklistViewReportElementBinding bind(@NonNull View view) {
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
  public static ItemChecklistViewReportElementBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemChecklistViewReportElementBinding)bind(component, view, R.layout.item_checklist_view_report_element);
  }
}
