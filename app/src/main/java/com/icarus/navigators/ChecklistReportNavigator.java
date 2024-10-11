package com.icarus.navigators;

import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.LogsSummary;

import java.util.LinkedHashMap;
import java.util.List;

public interface ChecklistReportNavigator  {
    void onGetChecklistLogSummary(LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> checklistDetailItems);

    void getChecklistElements(LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> logsSummary);

    void openClickedFile(String filePath);

    void showMessage(String message);

    void popUpAskDownload(String filePath, String itemUUID);
}
