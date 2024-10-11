package com.icarus.viewmodels;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import android.text.TextUtils;

import com.icarus.adapters.AssignedChecklistNotesAdapter;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.models.ChecklistNotesItem;
import com.icarus.navigators.NotesNavigator;
import com.icarus.repositories.NotesRepository;


public class NotesViewModel extends BaseViewModel<NotesNavigator> {
    private NotesRepository notesRepository;
    private String checklistUUID;
    private Integer checklistId, checklistElementId;
    private LiveData<PagedList<ChecklistNotesItem>> checklistNotesLiveData;
    private final static PagedList.Config config
            = new PagedList.Config.Builder()
            .setPageSize(Constants.PAGE_SIZE)
            .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
            .setEnablePlaceholders(true)
            .build();

    private AssignedChecklistNotesAdapter notesAdapter;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        notesRepository = new NotesRepository(application);
    }

    //Sets the selected checklist UUID
    public void setChecklistUUID(String checklistUUID) {
        this.checklistUUID = checklistUUID;
        getAllNotesList();
    }

    public void setChecklistId(Integer checklistId){
        this.checklistId = checklistId;
    }

    public void setChecklistElementId(Integer checklistElementId){
        this.checklistElementId = checklistElementId;
    }
    /**
     * This method is called when user clicks on add note button, and returns if text is empty
     * @param etNote Edit text for adding note
     */
    public void addNote(AppCompatEditText etNote) {
        if (etNote.getText()!=null && !TextUtils.isEmpty(etNote.getText().toString().trim()))
            notesRepository.addChecklistComment(checklistUUID, etNote.getText().toString().trim(), checklistId, checklistElementId);
        etNote.setText("");
    }

    /**
     * This method gets the paged notes list for selected checklist
     */
    private void getAllNotesList(){
        checklistNotesLiveData = notesRepository.getNotes(config, checklistUUID);
    }

    public LiveData<PagedList<ChecklistNotesItem>> observeNotesList(){
        return checklistNotesLiveData;
    }

    /**
     * This method returns the notes adapter to be set on notes list
     * @return Instance of AssignedChecklistNotesAdapter
     */
    public AssignedChecklistNotesAdapter getNotesAdapter(){
        if(notesAdapter == null)
            notesAdapter = new AssignedChecklistNotesAdapter(this);
        return notesAdapter;
    }
}
