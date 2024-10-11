package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemSearchSuggestionBinding;
import com.icarus.util.Utilities;
import com.icarus.viewmodels.DashboardViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionAdapter extends RecyclerView.Adapter<SearchSuggestionAdapter.GenericViewHolder> implements Filterable {
    private List<String> originalData = null;
    private List<String> filteredData = null;
    private ItemFilter mFilter = new ItemFilter();
    private DashboardViewModel viewModel;

    public SearchSuggestionAdapter(DashboardViewModel viewModel) {
        this.viewModel = viewModel;
        originalData = Utilities.getSearchSuggestion();
        filteredData = originalData;
    }

    public void refreshList() {
        originalData = Utilities.getSearchSuggestion();
        filteredData = originalData;
        notifyDataSetChanged();
    }

    public List<String> getFilterList() {
        return filteredData != null ? filteredData : new ArrayList<String>();
    }

    @Override
    public int getItemCount() {
        return filteredData == null ? 0 : filteredData.size();
    }

    @NonNull
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSearchSuggestionBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_search_suggestion, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(viewModel, filteredData.get(position));
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemSearchSuggestionBinding binding;

        GenericViewHolder(ItemSearchSuggestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(DashboardViewModel viewModel, String text) {
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.title, text);
            binding.executePendingBindings();

        }

    }


    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<String> list = originalData;

            int count = list.size();
            final ArrayList<String> nlist = new ArrayList<String>(count);

            String filterableString;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(filterableString);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }

    }
}

