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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to show the logs for the element
 */
public class ChecklistViewReportLogsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<LogsSummary> logsByDate = new ArrayList<>();
    private LinkedHashMap<String, List<LogsSummary>> logListLinkedHashMap;
    private ChecklistReportViewModel viewModel;

    ChecklistViewReportLogsAdapter(LinkedHashMap<String, List<LogsSummary>> listItemArrayList,
                                   ChecklistReportViewModel viewModel) {
        logListLinkedHashMap = listItemArrayList;
        this.viewModel = viewModel;

        //Calculates the size for inner list with different date
        for (Map.Entry<String, List<LogsSummary>> mapEntryDates : listItemArrayList.entrySet()) {
            logsByDate.add(mapEntryDates.getValue().get(0));
        }
    }

    @Override
    public int getItemCount() {
        return logListLinkedHashMap.size();
    }


    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        ItemViewReportLogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_report_log, parent, false);
        return new ChecklistViewReportLogsAdapter.ViewHolderLog(binding);
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolderLog viewHolderLog = (ChecklistViewReportLogsAdapter.ViewHolderLog) holder;
        viewHolderLog.setLogSummary(logsByDate.get(position), logListLinkedHashMap.get(logsByDate.get(position).getCreated()));


    }

    class ViewHolderLog extends RecyclerView.ViewHolder {

        ItemViewReportLogBinding binding;

        ViewHolderLog(ItemViewReportLogBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setLogSummary(LogsSummary summary, List<LogsSummary> datesArray) {
            //Checks if single date has multiple logs and sets the logs in inner list to be
            // shown in same block
            if (datesArray != null && datesArray.size() > 1) {
                //The first log is already displayed in this list so remove it
                datesArray.remove(0);
                ChecklistViewReportSameDateLogAdapter adapter = new ChecklistViewReportSameDateLogAdapter(datesArray, viewModel);
                binding.setSameDateAdapter(adapter);
            }
            binding.setLogsSummary(summary);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }

}