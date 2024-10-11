package com.icarus.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.R;
import com.icarus.databinding.ItemViewReportLogBinding;
import com.icarus.models.LogsSummary;
import com.icarus.viewmodels.ChecklistReportViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChecklistViewReportSameDateLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<LogsSummary> logsByDate = new ArrayList<>();
    private ChecklistReportViewModel viewModel;

    ChecklistViewReportSameDateLogAdapter(List<LogsSummary> datesArray, ChecklistReportViewModel viewModel) {
        logsByDate = datesArray;
        this.viewModel = viewModel;
    }

    @Override
    public int getItemCount() {
        return logsByDate.size();
    }


    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        ItemViewReportLogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_report_log, parent, false);
        return new ChecklistViewReportSameDateLogAdapter.ViewHolderLog(binding);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolderLog viewHolderLog = (ChecklistViewReportSameDateLogAdapter.ViewHolderLog) holder;
        viewHolderLog.setLogSummary(logsByDate.get(position));
    }

    class ViewHolderLog extends RecyclerView.ViewHolder {

        ItemViewReportLogBinding binding;

        ViewHolderLog(ItemViewReportLogBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setLogSummary(LogsSummary summary) {
            binding.setLogsSummary(summary);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }

}