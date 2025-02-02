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
import androidx.recyclerview.widget.RecyclerView;
import com.icarus.R;
import com.icarus.adapters.AllCaptureDataAttributesFileAdapter;
import com.icarus.adapters.AllCaptureDataAttributesQRAdapter;
import com.icarus.models.ElementAttributesItems;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemAllCaptureDataAttributesBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvFiles;

  @NonNull
  public final RecyclerView rvQR;

  @NonNull
  public final AppCompatTextView txtCapturedBy;

  @NonNull
  public final AppCompatTextView txtCapturedDate;

  @NonNull
  public final AppCompatTextView txtDescription;

  @NonNull
  public final AppCompatTextView txtLabel;

  @NonNull
  public final AppCompatTextView txtSequenceNo;

  @NonNull
  public final AppCompatTextView txtValue;

  @Bindable
  protected ElementAttributesItems mItem;

  @Bindable
  protected Integer mPosition;

  @Bindable
  protected AllCaptureDataAttributesFileAdapter mFileAdapter;

  @Bindable
  protected AllCaptureDataAttributesQRAdapter mQrAttributesAdapter;

  protected ItemAllCaptureDataAttributesBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvFiles, RecyclerView rvQR,
      AppCompatTextView txtCapturedBy, AppCompatTextView txtCapturedDate,
      AppCompatTextView txtDescription, AppCompatTextView txtLabel, AppCompatTextView txtSequenceNo,
      AppCompatTextView txtValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvFiles = rvFiles;
    this.rvQR = rvQR;
    this.txtCapturedBy = txtCapturedBy;
    this.txtCapturedDate = txtCapturedDate;
    this.txtDescription = txtDescription;
    this.txtLabel = txtLabel;
    this.txtSequenceNo = txtSequenceNo;
    this.txtValue = txtValue;
  }

  public abstract void setItem(@Nullable ElementAttributesItems item);

  @Nullable
  public ElementAttributesItems getItem() {
    return mItem;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  public abstract void setFileAdapter(@Nullable AllCaptureDataAttributesFileAdapter fileAdapter);

  @Nullable
  public AllCaptureDataAttributesFileAdapter getFileAdapter() {
    return mFileAdapter;
  }

  public abstract void setQrAttributesAdapter(
      @Nullable AllCaptureDataAttributesQRAdapter qrAttributesAdapter);

  @Nullable
  public AllCaptureDataAttributesQRAdapter getQrAttributesAdapter() {
    return mQrAttributesAdapter;
  }

  @NonNull
  public static ItemAllCaptureDataAttributesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_all_capture_data_attributes, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemAllCaptureDataAttributesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemAllCaptureDataAttributesBinding>inflateInternal(inflater, R.layout.item_all_capture_data_attributes, root, attachToRoot, component);
  }

  @NonNull
  public static ItemAllCaptureDataAttributesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_all_capture_data_attributes, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemAllCaptureDataAttributesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemAllCaptureDataAttributesBinding>inflateInternal(inflater, R.layout.item_all_capture_data_attributes, null, false, component);
  }

  public static ItemAllCaptureDataAttributesBinding bind(@NonNull View view) {
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
  public static ItemAllCaptureDataAttributesBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemAllCaptureDataAttributesBinding)bind(component, view, R.layout.item_all_capture_data_attributes);
  }
}
