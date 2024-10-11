package com.icarus.repositories;

import android.app.Application;
import android.text.TextUtils;

import com.icarus.constants.Constants;
import com.icarus.dao.ReportDao;
import com.icarus.database.AppDatabase;
import com.icarus.enums.LogTableActions;
import com.icarus.listeners.OnDownloadListener;
import com.icarus.models.AssignedChecklistSummary;
import com.icarus.models.AssignmentHistory;
import com.icarus.models.LogsSummary;
import com.icarus.models.PausedHistory;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.ChecklistElementsApi;
import com.icarus.util.FileUtils;
import com.icarus.util.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import c.anurag.network.subscriber.AbstractNetworkObservable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ReportRepository {
    private Application application;

    public ReportRepository(Application application) {
        this.application = application;
    }

    public AssignedChecklistSummary getSummary(String assignedChecklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ReportDao reportDao = appDatabase.reportDao();

        return reportDao.getSummary(assignedChecklistUuid);
    }

    public String getAssignees(String assignedChecklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ReportDao reportDao = appDatabase.reportDao();

        List<String> assignees = reportDao.getAssignees(assignedChecklistUuid);

        return TextUtils.join(", ", assignees);
    }

    public List<AssignmentHistory> getAssignmentHistory(String assignedChecklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ReportDao reportDao = appDatabase.reportDao();

        return reportDao.getAssignmentHistory(assignedChecklistUuid);
    }

    public List<PausedHistory> getPausedHistory(String assignedChecklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ReportDao reportDao = appDatabase.reportDao();

        return reportDao.getPauseHistory(
                assignedChecklistUuid,
                LogTableActions.RESUMED.getValue(),
                LogTableActions.PAUSED.getValue()
        );
    }

    public List<LogsSummary> getLogsSummary(String assignedChecklistUuid) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        ReportDao reportDao = appDatabase.reportDao();
        return reportDao.getLogsSummary(assignedChecklistUuid);
    }

    /**
     * This method is called when we click on the attached file template from file required attribute
     *
     * @param onDownloadListener Callback for handling result
     */
    public void downloadAttachedTemplateFile(String fileName, String itemUUID, final OnDownloadListener onDownloadListener) {
        try {
            final FileUtils fileUtils = FileUtils.getInstance();
            File directory = FileUtils.getResourcesAttachmentsDir();
            if (directory == null) {
                onDownloadListener.onFailed();
                return;
            }

            final File fileDestinationFolder = new File(directory, fileName);
            if (!fileDestinationFolder.exists()) {
                if (!Utilities.isOnline(application)) {
                    onDownloadListener.noInternetAvailable();
                    return;
                }
                RetroUtils.getRetrofitInstance(application, new InternetConnectionListener() {
                    @Override
                    public void onInternetUnavailable() {
                        onDownloadListener.noInternetAvailable();
                    }
                }).create(ChecklistElementsApi.class)
                        .capturedDataDownload(Constants.HEADER_ACCEPT, itemUUID)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbstractNetworkObservable<ResponseBody>() {
                            @Override
                            public void success(ResponseBody responseBody) {
                                if (responseBody != null) {
                                    try {
                                        if (fileDestinationFolder.createNewFile()) {
                                            fileUtils.saveToDisk(responseBody, fileDestinationFolder);
                                            onDownloadListener.onSuccess();
                                        } else {
                                            onDownloadListener.onFailed();
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        onDownloadListener.onFailed();
                                    }
                                }
                            }

                            @Override
                            public void failure(Throwable error) {
                                onDownloadListener.onFailed();
                            }
                        });
            } else {
                onDownloadListener.onSuccess();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            onDownloadListener.onFailed();
        }
    }
}
