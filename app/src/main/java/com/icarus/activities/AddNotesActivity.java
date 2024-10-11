package com.icarus.activities;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;

import com.icarus.BR;
import com.icarus.R;
import com.icarus.base.BaseActivity;
import com.icarus.databinding.ActivityAddNoteBinding;
import com.icarus.models.ChecklistNotesItem;
import com.icarus.viewmodels.NotesViewModel;


public class AddNotesActivity extends BaseActivity<ActivityAddNoteBinding, NotesViewModel> {
    private static final String CHECKLIST_ELEMENT_ID = "checklist_element_id";
    private NotesViewModel mNotesViewModel;

    public static Intent getIntent(Context context, String checklistUUID, Integer checklistId, Integer checklistElementId) {
        return new Intent(context, AddNotesActivity.class)
                .putExtra(ChecklistReportActivity.CHECKLIST_UUID, checklistUUID)
                .putExtra(AddNotesActivity.CHECKLIST_ELEMENT_ID, checklistElementId)
                .putExtra(ChecklistReportActivity.CHECKLIST_ID, checklistId);


    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_note;
    }

    @Override
    public NotesViewModel getViewModel() {
        return mNotesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityAddNoteBinding binding = getViewDataBinding();
        mNotesViewModel = getViewModel();
        //Get checklist uuid and sets empty if null
        mNotesViewModel.setChecklistUUID(getIntent() != null ? getIntent().getExtras() != null ?
                getIntent().getExtras().getString(ChecklistReportActivity.CHECKLIST_UUID, "")
                : ""
                : "");

        mNotesViewModel.setChecklistId(getIntent().getIntExtra(ChecklistReportActivity.CHECKLIST_ID, 0));
        mNotesViewModel.setChecklistElementId(getIntent().getIntExtra(AddNotesActivity.CHECKLIST_ELEMENT_ID, 0));
        //Observe notes list for adding on notes list adapter
        mNotesViewModel.observeNotesList().observe(this, new Observer<PagedList<ChecklistNotesItem>>() {
            @Override
            public void onChanged(@Nullable PagedList<ChecklistNotesItem> checklistNotes) {
                mNotesViewModel.getNotesAdapter().submitList(checklistNotes);
                binding.rvNotes.scrollToPosition(0);
            }
        });

        //Set reverse list behaviour on notes list
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
     //   layoutManager.setStackFromEnd(true);
        binding.rvNotes.setLayoutManager(layoutManager);
        binding.rvNotes.setAdapter(mNotesViewModel.getNotesAdapter());
        binding.setViewModel(mNotesViewModel);

        setSupportActionBar(binding.toolbar);
        //Shows back icon on toolbar
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Opens keyboard and focus on write note
        binding.etNote.requestFocus();
      //  Utilities.getInstance(this).showKeyboard(binding.etNote, this);


        //Add watcher on note edit text for getting if text entered change the save note image
        binding.etNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                if (TextUtils.isEmpty(text)) {
                    binding.btnAddNote.setImageResource(R.drawable.ic_add_note_disabled);
                } else
                    binding.btnAddNote.setImageResource(R.drawable.ic_add_note);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
