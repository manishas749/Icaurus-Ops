// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.icarus.R;
import com.icarus.models.CheckListStepAttributeItems;
import com.icarus.viewmodels.ChecklistExecutionViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentProcedureRecordImageBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final AppCompatTextView description;

  @NonNull
  public final FrameLayout editAttribute;

  @NonNull
  public final FrameLayout imgAdd;

  @NonNull
  public final AppCompatTextView label;

  @NonNull
  public final RecyclerView recyclerViewSelectedImages;

  @Bindable
  protected CheckListStepAttributeItems mItem;

  @Bindable
  protected Integer mAttributeNo;

  @Bindable
  protected ChecklistExecutionViewModel mViewModel;

  protected FragmentProcedureRecordImageBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnSubmit, AppCompatTextView description,
      FrameLayout editAttribute, FrameLayout imgAdd, AppCompatTextView label,
      RecyclerView recyclerViewSelectedImages) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSubmit = btnSubmit;
    this.description = description;
    this.editAttribute = editAttribute;
    this.imgAdd = imgAdd;
    this.label = label;
    this.recyclerViewSelectedImages = recyclerViewSelectedImages;
  }

  public abstract void setItem(@Nullable CheckListStepAttributeItems item);

  @Nullable
  public CheckListStepAttributeItems getItem() {
    return mItem;
  }

  public abstract void setAttributeNo(@Nullable Integer attributeNo);

  @Nullable
  public Integer getAttributeNo() {
    return mAttributeNo;
  }

  public abstract void setViewModel(@Nullable ChecklistExecutionViewModel viewModel);

  @Nullable
  public ChecklistExecutionViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentProcedureRecordImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_procedure_record_image, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProcedureRecordImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentProcedureRecordImageBinding>inflateInternal(inflater, R.layout.fragment_procedure_record_image, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentProcedureRecordImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_procedure_record_image, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentProcedureRecordImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentProcedureRecordImageBinding>inflateInternal(inflater, R.layout.fragment_procedure_record_image, null, false, component);
  }

  public static FragmentProcedureRecordImageBinding bind(@NonNull View view) {
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
  public static FragmentProcedureRecordImageBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentProcedureRecordImageBinding)bind(component, view, R.layout.fragment_procedure_record_image);
  }
}
