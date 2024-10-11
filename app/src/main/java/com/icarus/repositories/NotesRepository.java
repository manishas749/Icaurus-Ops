package com.icarus.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.CheckListDetailDao;
import com.icarus.dao.NotesDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.models.ChecklistNotesItem;
import com.icarus.util.AppUtility;

/**
 * Created by Monika Rana on 11/09/2019
 */
public class NotesRepository {

    private Application application;

    public NotesRepository(Application application) {
        this.application = application;
    }


    /**
     *Adds the comment into database
     * @param checklistUUID The checklist UUID of selected checklist
     * @param note The note to be added by logged on user
     */
    public void addChecklistComment(String checklistUUID, String note, Integer checklistId, Integer checklistElementId){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        NotesDao notesDao = appDatabase.notesDao();

        String currentTime = AppUtility.Companion.getUtcTime();
        String assignedChecklistCommentUUID = AppUtility.Companion.getUuid();

        AssignedChecklistCommentsEntity assignedChecklistCommentsEntity = new AssignedChecklistCommentsEntity();
        assignedChecklistCommentsEntity.setAssigned_checklist_uuid(checklistUUID);
        assignedChecklistCommentsEntity.setUuid(assignedChecklistCommentUUID);
        assignedChecklistCommentsEntity.setCreated(currentTime);
        assignedChecklistCommentsEntity.setComment(note);
        assignedChecklistCommentsEntity.setIsDeleted(Constants.NOT_DELETED);
        assignedChecklistCommentsEntity.setSyncStatus(Constants.SYNC_STATUS_NOT);
        assignedChecklistCommentsEntity.setUserId(BaseApplication.getPreferenceManager().getUserId());
        assignedChecklistCommentsEntity.setModified(currentTime);
        assignedChecklistCommentsEntity.setChecklistId(checklistId);
        assignedChecklistCommentsEntity.setChecklistElementId(checklistElementId == 0 ? null : checklistElementId);
        notesDao.insertUserNote(assignedChecklistCommentsEntity);

        CheckListDetailDao allCheckListDao = appDatabase.checkListDetailDao();
        allCheckListDao.updateAssignedChecklistPendingElementCount(checklistUUID);


    }

    /**
     * Gets paged list of added notes by all users on this checklist
     * @param config Pages list configuration for pagination
     * @param checklistUUID The UUID of selected checklist
     * @return Paged List of added comments on checklist
     */
    public LiveData<PagedList<ChecklistNotesItem>> getNotes(PagedList.Config config, String checklistUUID) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        NotesDao notesDao = appDatabase.notesDao();
        DataSource.Factory<Integer, ChecklistNotesItem> factory;
        factory = notesDao.getNotesList(checklistUUID);
        return new LivePagedListBuilder<>(factory, config)
                .build();
    }
}
