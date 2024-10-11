package com.icarus.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.icarus.R;
import com.icarus.adapters.ChecklistViewReportElementListAdapter;
import com.icarus.adapters.PauseHistoryAdapter;
import com.icarus.adapters.ViewReportAssignmentHistoryAdapter;
import com.icarus.adapters.ViewReportNotesAdapter;
import com.icarus.backgroundTask.GetLogSummaryAsync;
import com.icarus.base.BaseViewModel;
import com.icarus.constants.Constants;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.models.AssignedChecklistSummary;
import com.icarus.models.AssignmentHistory;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistElementItem;
import com.icarus.models.ChecklistNotesItem;
import com.icarus.models.LogsSummary;
import com.icarus.models.PausedHistory;
import com.icarus.navigators.ChecklistReportNavigator;
import com.icarus.repositories.ChecklistDetailRepository;
import com.icarus.repositories.NotesRepository;
import com.icarus.repositories.ReportRepository;
import com.icarus.util.AppUtility;
import com.icarus.util.DateUtility;
import com.icarus.util.FileUtils;

import java.io.File;
import java.util.List;

public class ChecklistReportViewModel extends BaseViewModel<ChecklistReportNavigator> {

    private ReportRepository checklistReportRepository;
    private int checklistId;
    private String assigneeNames, assignedChecklistUuid;
    private List<AssignmentHistory> assignmentHistory;
    private List<PausedHistory> pausedHistories;
    private AssignedChecklistSummary assignedChecklistSummary;
    private ViewReportAssignmentHistoryAdapter assignmentHistoryAdapter;
    private PauseHistoryAdapter pauseHistoryAdapter;
    private String startByTitle = "";
    private String cancelledCompletedTitle = "";
    private ChecklistDetailRepository mChecklistDetailRepository;
    private ChecklistViewReportElementListAdapter mAdapter;
    private final static PagedList.Config config
            = new PagedList.Config.Builder()
            .setPageSize(Constants.PAGE_SIZE)
            .setInitialLoadSizeHint(Constants.PAGE_INITIAL_LOAD_SIZE_HINT)
            .setPrefetchDistance(Constants.PAGE_PREFETCH_DISTANCE)
            .setEnablePlaceholders(true)
            .build();
    private LiveData<PagedList<ChecklistDetailItems>> liveData;

    //Notes
    private LiveData<PagedList<ChecklistNotesItem>> checklistNotesLiveData;
    private ViewReportNotesAdapter notesAdapter;


    public ChecklistReportViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchReport(String assignedChecklistUuid, int checklistId) {
        setIsLoading(true);
        this.assignedChecklistUuid = assignedChecklistUuid;
        this.checklistId = checklistId;

        checklistReportRepository = new ReportRepository(getApplication());
        mChecklistDetailRepository = new ChecklistDetailRepository(getApplication());

        assigneeNames = checklistReportRepository.getAssignees(assignedChecklistUuid);
        assignmentHistory = checklistReportRepository.getAssignmentHistory(assignedChecklistUuid);
        pausedHistories = checklistReportRepository.getPausedHistory(assignedChecklistUuid);
        assignedChecklistSummary = checklistReportRepository.getSummary(assignedChecklistUuid);

        assignmentHistoryAdapter = new ViewReportAssignmentHistoryAdapter(assignmentHistory);
        pauseHistoryAdapter = new PauseHistoryAdapter(pausedHistories);

        startByTitle = getApplication().getString(R.string.started_detail,
                assignedChecklistSummary.getStartedBy(),
                AppUtility.Companion.parseDateToddMMyyyy(assignedChecklistSummary.getStartedAt()),
                assignedChecklistSummary.getTotalTime());

        cancelledCompletedTitle = getApplication().getString(R.string.completed_detail,
                (assignedChecklistSummary.getAction() != null
                        && assignedChecklistSummary.getAction()
                        == LogTableActions.CANCELED.getValue() ?
                        getApplication().getString(R.string.cancelled_by)
                        : assignedChecklistSummary.getAction() != null
                        && assignedChecklistSummary.getAction()
                        == LogTableActions.COMPLETED.getValue() ?
                        getApplication().getString(R.string.completed_by)
                        : getApplication().getString(R.string.last_performed_by)),
                assignedChecklistSummary.getLastPerformedBy(),
                AppUtility.Companion.parseDateToddMMyyyy(assignedChecklistSummary.getLastPerformedAt()),
                getTotalPauseTime());

        getLogSummaryList(assignedChecklistUuid);
//Gets notes list
        getAllNotesList(assignedChecklistUuid);
    }

    public LiveData<PagedList<ChecklistElementItem>> getElementListLiveData() {
        return mChecklistDetailRepository.getChecklistDetailList(config, checklistId, assignedChecklistUuid);
    }

    public String getAssignees() {
        return assigneeNames;
    }

    public ViewReportAssignmentHistoryAdapter getAssignmentHistoryAdapter() {
        return assignmentHistoryAdapter;
    }

    public PauseHistoryAdapter getPauseHistoryAdapter() {
        return pauseHistoryAdapter;
    }

    public AssignedChecklistSummary getSummary() {
        return assignedChecklistSummary;
    }

    public String getStartByTitle() {
        return startByTitle;
    }

    public String getCancelledCompletedTitle() {
        return cancelledCompletedTitle;
    }

    private String getTotalPauseTime() {
        String totalTime = "N/A";
        long totalTimeTaken = 0;
        if (pausedHistories != null) {
            for (int i = 0; i < pausedHistories.size(); i++) {
                totalTimeTaken = totalTimeTaken + pausedHistories.get(i).getPauseTime();
            }
            totalTime = DateUtility.getElapsedTime(totalTimeTaken);
        }
        return totalTime;
    }


    private void getLogSummaryList(String assignedChecklistUuid) {

        //Gets log summary and forms the 2-d hash map in background
        new GetLogSummaryAsync(assignedChecklistUuid, checklistReportRepository, getNavigator()).execute();
    }

    private List<LogsSummary> getLogsSummary(String checklistUUID) {
        return checklistReportRepository.getLogsSummary(checklistUUID);
    }

    public ChecklistViewReportElementListAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new ChecklistViewReportElementListAdapter(this);
        }
        return mAdapter;
    }


    /**
     * This method opens the clicked captured file
     *
     * @param logsSummary This param contains the captured file item info
     */
    public void onImageClick(final LogsSummary logsSummary) {
        try {
            File directory = FileUtils.getResourcesAttachmentsDir();
            if (directory == null) {
                getNavigator().showMessage(getApplication().getString(R.string.file_path_error));
                return;
            }

            final File fileDestinationFolder = new File(directory, logsSummary.getFileName());
            if (!fileDestinationFolder.exists()) {
                getNavigator().popUpAskDownload(logsSummary.getFileName(), logsSummary.getStepAction());
            } else
                getNavigator().openClickedFile(logsSummary.getFileName());
        } catch (Exception ex) {
            ex.printStackTrace();
            getNavigator().showMessage(getApplication().getString(R.string.file_path_error));
        }
    }

    /**
     * This method download the captured file
     *
     * @param fileName The name of the file to be downloaded
     * @param itemUUID The item UUID required for downloading file
     */
    public void downloadCapturedFiles(final String fileName, String itemUUID) {
        setIsLoading(true);
        checklistReportRepository.downloadAttachedTemplateFile(fileName, itemUUID, new OnDownloadListener() {
            @Override
            public void onSuccess() {
                setIsLoading(false);
                getNavigator().openClickedFile(fileName);
            }

            @Override
            public void onFailed() {
                setIsLoading(false);
                getNavigator().showMessage(getApplication().getString(R.string.error_downloading_file));
            }

            @Override
            public void noInternetAvailable() {
                setIsLoading(false);
                getNavigator().showMessage(getApplication().getString(R.string.no_internet_connection));
            }
        });
    }

    /**
     * This method gets the paged notes list for selected checklist
     */
    private void getAllNotesList(String assignedChecklistUuid) {
        NotesRepository notesRepository = new NotesRepository(getApplication());
        checklistNotesLiveData = notesRepository.getNotes(config, assignedChecklistUuid);
    }

    public LiveData<PagedList<ChecklistNotesItem>> observeNotesList() {
        return checklistNotesLiveData;
    }

    /**
     * This method returns the notes adapter to be set on notes list
     *
     * @return Instance of AssignedChecklistNotesAdapter
     */
    public ViewReportNotesAdapter getNotesAdapter() {
        if (notesAdapter == null)
            notesAdapter = new ViewReportNotesAdapter(this);
        return notesAdapter;
    }
}
