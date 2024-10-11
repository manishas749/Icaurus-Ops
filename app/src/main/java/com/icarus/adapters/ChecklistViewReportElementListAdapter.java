package com.icarus.adapters;

import androidx.paging.PagedListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.databinding.ItemChecklistViewReportElementBinding;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.LogsSummary;
import com.icarus.viewmodels.ChecklistReportViewModel;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * This class is used to show the list element list
 */
public class ChecklistViewReportElementListAdapter extends PagedListAdapter<ChecklistElementItem, ChecklistViewReportElementListAdapter.DataViewHolder> {
    private ChecklistReportViewModel viewModel;
    private LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> logsHashMap;

    public ChecklistViewReportElementListAdapter(ChecklistReportViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    public void setLogsHashMap(LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> logsHashMap) {
        if (this.logsHashMap == null)
            this.logsHashMap = logsHashMap;
    }

    @NonNull
    @Override
    public ChecklistViewReportElementListAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemChecklistViewReportElementBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_checklist_view_report_element, parent, false);
        return new ChecklistViewReportElementListAdapter.DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistViewReportElementListAdapter.DataViewHolder holder, int position) {
        holder.setViewModel(position, getChecklist(position), viewModel);
    }

    public ChecklistElementItem getChecklist(int position) {
        return getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    public class DataViewHolder extends RecyclerView.ViewHolder {
        ItemChecklistViewReportElementBinding binding;

        DataViewHolder(ItemChecklistViewReportElementBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        void setViewModel(int position, ChecklistElementItem checklistDetailItems, ChecklistReportViewModel viewModel) {
            binding.setVariable(BR.item, checklistDetailItems);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);

            //Checks if log exist for the element and sets the data in inner list for showing logs
            if (logsHashMap != null && logsHashMap.size() > 0 && checklistDetailItems != null) {
                LinkedHashMap<String, List<LogsSummary>> elementLogByDate = logsHashMap.get(String.valueOf(checklistDetailItems.getElementId()));
                if (elementLogByDate != null && elementLogByDate.size() > 0) {
                    ChecklistViewReportLogsAdapter adapter = new ChecklistViewReportLogsAdapter(elementLogByDate, viewModel);
                    binding.setLogsAdapter(adapter);
                }
            }

            binding.executePendingBindings();
            setPPEHazardListVisibility(checklistDetailItems);
        }

        private void setPPEHazardListVisibility(ChecklistElementItem checklistDetailItems) {
            if (checklistDetailItems != null && checklistDetailItems.getPPEsIconList() != null && checklistDetailItems.getPPEsIconList().size() > 0)
                binding.recyclerIcons.setVisibility(View.VISIBLE);
            else if (checklistDetailItems != null && checklistDetailItems.getHazardsIconList() != null && checklistDetailItems.getHazardsIconList().size() > 0)
                binding.recyclerIcons.setVisibility(View.VISIBLE);
            else
                binding.recyclerIcons.setVisibility(View.GONE);
        }
    }

    private static final DiffUtil.ItemCallback<ChecklistElementItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ChecklistElementItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull ChecklistElementItem oldItem, @NonNull ChecklistElementItem newItem) {
                    return oldItem.getItemId() == newItem.getItemId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull ChecklistElementItem oldItem, @NonNull ChecklistElementItem newItem) {
                    return oldItem.getItemId() == newItem.getItemId();
                }
            };
}