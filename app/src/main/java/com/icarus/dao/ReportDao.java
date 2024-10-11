package com.icarus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.icarus.database.Queries;
import com.icarus.database.ReportQueries;
import com.icarus.models.AssignedChecklistSummary;
import com.icarus.models.AssignmentHistory;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.LogsSummary;
import com.icarus.models.PausedHistory;

import java.util.List;

@Dao
public interface ReportDao {
    @Query(ReportQueries.SUMMARY)
    AssignedChecklistSummary getSummary(String assignedChecklistUuid);

    @Query(ReportQueries.ASSIGNED_MEMBERS)
    List<String> getAssignees(String assignedChecklistUuid);

    @Query(ReportQueries.ASSIGNMENT_HISTORY)
    List<AssignmentHistory> getAssignmentHistory(String assignedChecklistUuid);

    @Query(ReportQueries.PAUSE_HISTORY)
    List<PausedHistory> getPauseHistory(String assignedChecklistUuid, int resumeAction, int pauseAction);

    @Query(ReportQueries.GET_LOGS_SUMMARY)
    List<LogsSummary> getLogsSummary(String checklistUUID);

    @Query(Queries.GET_CHECKLIST_DETAIL)
    LiveData<List<ChecklistDetailItems>> getCheckList(Integer checkListId, String checkListUuid);
}
