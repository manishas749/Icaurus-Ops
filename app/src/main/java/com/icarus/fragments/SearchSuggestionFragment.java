package com.icarus.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseFragment;
import com.icarus.databinding.FragmentSearchSuggestionsBinding;
import com.icarus.listeners.SearchSelectedListener;
import com.icarus.viewmodels.DashboardViewModel;

public class SearchSuggestionFragment extends BaseFragment<FragmentSearchSuggestionsBinding, DashboardViewModel> {
    private SearchSelectedListener onSearchSelected;

    public static SearchSuggestionFragment getInstance(SearchSelectedListener onSearchSelected) {
        SearchSuggestionFragment fragment = new SearchSuggestionFragment();
        fragment.setSearchSelectedListener(onSearchSelected);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void setSearchSelectedListener(SearchSelectedListener onSearchSelected) {
        this.onSearchSelected = onSearchSelected;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_suggestions;
    }

    @Override
    public DashboardViewModel getViewModel() {
        return getActivity() != null ? new ViewModelProvider(getActivity()).get(DashboardViewModel.class) : null;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentSearchSuggestionsBinding binding = getViewDataBinding();
        getViewModel().setSearchSelectedListener(onSearchSelected);
        binding.setViewModel(getViewModel());

        binding.executePendingBindings();
    }
}
