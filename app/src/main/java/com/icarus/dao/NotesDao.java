package com.icarus.dao;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.icarus.database.ReportQueries;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.models.ChecklistNotesItem;

/**
 * Created by Monika Rana on 11/09/2019
 */

@Dao
public abstract class NotesDao {

    @Insert
    public abstract void insertUserNote(AssignedChecklistCommentsEntity assignedChecklistCommentsEntity);

    @Query(ReportQueries.GET_NOTES_LIST)
    public abstract DataSource.Factory<Integer, ChecklistNotesItem> getNotesList(String checklistUUID);
}
