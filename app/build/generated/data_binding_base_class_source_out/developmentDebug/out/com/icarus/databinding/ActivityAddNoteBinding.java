// Generated by data binding compiler. Do not edit!
package com.icarus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.icarus.R;
import com.icarus.viewmodels.NotesViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAddNoteBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final AppCompatImageButton btnAddNote;

  @NonNull
  public final ConstraintLayout compose;

  @NonNull
  public final View divider;

  @NonNull
  public final AppCompatEditText etNote;

  @NonNull
  public final RecyclerView rvNotes;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected NotesViewModel mViewModel;

  protected ActivityAddNoteBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appbar, AppCompatImageButton btnAddNote, ConstraintLayout compose, View divider,
      AppCompatEditText etNote, RecyclerView rvNotes, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.btnAddNote = btnAddNote;
    this.compose = compose;
    this.divider = divider;
    this.etNote = etNote;
    this.rvNotes = rvNotes;
    this.toolbar = toolbar;
  }

  public abstract void setViewModel(@Nullable NotesViewModel viewModel);

  @Nullable
  public NotesViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityAddNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_add_note, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAddNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAddNoteBinding>inflateInternal(inflater, R.layout.activity_add_note, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAddNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_add_note, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAddNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAddNoteBinding>inflateInternal(inflater, R.layout.activity_add_note, null, false, component);
  }

  public static ActivityAddNoteBinding bind(@NonNull View view) {
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
  public static ActivityAddNoteBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAddNoteBinding)bind(component, view, R.layout.activity_add_note);
  }
}
