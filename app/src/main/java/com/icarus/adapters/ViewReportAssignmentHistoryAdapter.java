package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemAssignmentHistoryBinding;
import com.icarus.models.AssignmentHistory;

import java.util.List;

public class ViewReportAssignmentHistoryAdapter extends RecyclerView.Adapter<ViewReportAssignmentHistoryAdapter.GenericViewHolder> {
    private List<AssignmentHistory> assignmentHistories;

    public ViewReportAssignmentHistoryAdapter(List<AssignmentHistory> assignmentHistories) {
        this.assignmentHistories = assignmentHistories;
    }

    @NonNull
    public ViewReportAssignmentHistoryAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemAssignmentHistoryBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_assignment_history, parent, false);
        return new ViewReportAssignmentHistoryAdapter.GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewReportAssignmentHistoryAdapter.GenericViewHolder holder, int position) {
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
        final ItemAssignmentHistoryBinding binding;

        GenericViewHolder(ItemAssignmentHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final AssignmentHistory assignmentHistory) {
            binding.setVariable(BR.name, assignmentHistory);
            binding.executePendingBindings();

        }
    }
}
