package com.icarus.backgroundTask;

import android.os.AsyncTask;

import com.icarus.models.LogsSummary;
import com.icarus.navigators.ChecklistReportNavigator;
import com.icarus.repositories.ChecklistReportRepository;
import com.icarus.repositories.ReportRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GetLogSummaryAsync extends AsyncTask<Void, Void, LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>>> {
    private String checklistUUID;
    private ReportRepository checklistReportRepository;
    private ChecklistReportNavigator checklistReportNavigator;

    public GetLogSummaryAsync(String checklistUUID, ReportRepository checklistReportRepository,
                              ChecklistReportNavigator checklistReportNavigator) {
        this.checklistUUID = checklistUUID;
        this.checklistReportRepository = checklistReportRepository;
        this.checklistReportNavigator = checklistReportNavigator;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> doInBackground(Void... params) {
        List<LogsSummary> logsSummariesList = checklistReportRepository.getLogsSummary(checklistUUID);

        LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> logsSummaryHashMap = new LinkedHashMap<>();

        List<LogsSummary> logsSummaries = new ArrayList<>();
        LinkedHashMap<String, List<LogsSummary>> logsHashMapWithDate = new LinkedHashMap<>();
        //This value is used for comparing the date key and putting the key in hash map
        String keyDate = "";
        //This value is used for comparing the element id key and saving the value in parent 2d hash map
        String keyElementId = "";

        //this loop checks all the log elements and creates 2-d array with 2-d hash map with element id
        // as parent key and date as child key, creates an array for multiple logs as log with same date need
        //to be shown in same block
        for (int i = 0; i < logsSummariesList.size(); i++) {

            if (keyDate.isEmpty()) {
                //For first index
                keyDate = logsSummariesList.get(i).getCreated();
                keyElementId = logsSummariesList.get(i).getChecklistElementId();
                //Add the logs data in array for later saving it in hash map
                logsSummaries.add(logsSummariesList.get(i));

            } else if (keyDate.equalsIgnoreCase(logsSummariesList.get(i).getCreated()) &&
                    keyElementId.equalsIgnoreCase(logsSummariesList.get(i).getChecklistElementId())) {
                //If date and element id both are same
                //The logs needs to be saved in an array
                logsSummaries.add(logsSummariesList.get(i));

            } else if (!keyDate.equalsIgnoreCase(logsSummariesList.get(i).getCreated()) &&
                    keyElementId.equalsIgnoreCase(logsSummariesList.get(i).getChecklistElementId())) {
                //If date is different and element id is same
                //The saved array is put in hash map with previous date as key
                logsHashMapWithDate.put(keyDate, logsSummaries);

                //new date is saved
                keyDate = logsSummariesList.get(i).getCreated();
                //Add the new log values in array
                logsSummaries = new ArrayList<>();
                logsSummaries.add(logsSummariesList.get(i));

            } else {
                //if element id is different

                //The saved array is put in hash map with previous date as key
                logsHashMapWithDate.put(keyDate, logsSummaries);
                //Save the hash map for previous element in 2d hash map
                logsSummaryHashMap.put(keyElementId, logsHashMapWithDate);

                //Create new hash map for key as date for saving new values
                logsHashMapWithDate = new LinkedHashMap<>();
                //Saves new date
                keyDate = logsSummariesList.get(i).getCreated();
                //Save the new element id
                keyElementId = logsSummariesList.get(i).getChecklistElementId();
                //Create new array for saving log data for next date
                logsSummaries = new ArrayList<>();
                //Save the current log in array to be saved later
                logsSummaries.add(logsSummariesList.get(i));
            }

            //Check if last index than save the values in hash map as the loop will not execute again and values should be saved
            if (logsSummariesList.size() - 1 == i) {
                logsHashMapWithDate.put(keyDate, logsSummaries);
                logsSummaryHashMap.put(keyElementId, logsHashMapWithDate);
            }

        }
        return logsSummaryHashMap;
    }

    @Override
    protected void onPostExecute(LinkedHashMap<String, LinkedHashMap<String, List<LogsSummary>>> logsSummary) {
        super.onPostExecute(logsSummary);
        checklistReportNavigator.onGetChecklistLogSummary(logsSummary);
    }
}
