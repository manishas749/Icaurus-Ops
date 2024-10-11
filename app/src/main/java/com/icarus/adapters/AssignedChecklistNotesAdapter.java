package com.icarus.adapters;

import androidx.paging.PagedListAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.models.ChecklistNotesItem;
import com.icarus.viewmodels.NotesViewModel;

/**
 * Created by Monika Rana on 12/09/2019
 * This adapter is used to bind the list with added notes on assigned checklist by users
 */
public class AssignedChecklistNotesAdapter extends PagedListAdapter<ChecklistNotesItem, AssignedChecklistNotesAdapter.GenericViewHolder> {

    private NotesViewModel notesViewModel;

    public AssignedChecklistNotesAdapter(NotesViewModel viewModel) {
        super(DIFF_CALLBACK);
        notesViewModel = viewModel;
    }

    @NonNull
    public AssignedChecklistNotesAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_assigned_checklist_note, parent, false);

        return new AssignedChecklistNotesAdapter.GenericViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull AssignedChecklistNotesAdapter.GenericViewHolder holder, int position) {
        holder.bind(getNoteItem(position));
    }

    public ChecklistNotesItem getNoteItem(int position) {
        return getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ChecklistNotesItem items) {
            binding.setVariable(BR.item, items);
            binding.executePendingBindings();
        }

    }

    private static final DiffUtil.ItemCallback<ChecklistNotesItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ChecklistNotesItem>() {
                @Override
                public boolean areItemsTheSame(@NonNull ChecklistNotesItem oldItem, @NonNull ChecklistNotesItem newItem) {
                    return oldItem.getUpdatedAt().equals(newItem.getUpdatedAt());
                }

                @Override
                public boolean areContentsTheSame(@NonNull ChecklistNotesItem oldItem, @NonNull ChecklistNotesItem newItem) {
                    return oldItem.getUpdatedAt().equals(newItem.getUpdatedAt());
                }

            };

}


