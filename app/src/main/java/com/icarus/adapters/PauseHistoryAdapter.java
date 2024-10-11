package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemPauseHistoryBinding;
import com.icarus.models.PausedHistory;

import java.util.List;

public class PauseHistoryAdapter extends RecyclerView.Adapter<PauseHistoryAdapter.GenericViewHolder> {
    private List<PausedHistory> assignmentHistories;

    public PauseHistoryAdapter(List<PausedHistory> assignmentHistories) {
        this.assignmentHistories = assignmentHistories;
    }

    @NonNull
    public PauseHistoryAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPauseHistoryBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_pause_history, parent, false);
        return new PauseHistoryAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PauseHistoryAdapter.GenericViewHolder holder, int position) {
        holder.bind(assignmentHistories.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return assignmentHistories == null ? 0 : assignmentHistories.size();
    }


    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ItemPauseHistoryBinding binding;

        GenericViewHolder(ItemPauseHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final PausedHistory pausedHistory) {
            binding.setVariable(BR.name, pausedHistory);
            binding.executePendingBindings();

        }
    }
}
