package c.anurag.network.beans.assigned.checklist;

import android.content.Context;

import c.anurag.database.application.BaseApplication;
import c.anurag.network.R;
import c.anurag.network.apiservice.IGetApiCall;
import c.anurag.network.util.UrlUtil;

public class FetchChildElementsData {

    private final Context context;

    public FetchChildElementsData(Context context) {
        this.context = context;
    }

    public void fetchData(String assignedChecklistUuid, String lastActivityAfter, String lastActivityBefore, IGetApiCall assignedService) {
        String[] stringArray = context.getResources().getStringArray(R.array.get_assigned_api_with_json_tag);
        for (String apiName : stringArray) {
            fetchDataFromApi(assignedService, apiName, lastActivityAfter, lastActivityBefore, assignedChecklistUuid);
        }

    }

    private void fetchDataFromApi(IGetApiCall assignedService, String apiName, String lastActivityAfter, String lastActivityBefore, String assignedChecklistUuid) {
        String tableName = apiName.replace(".json", "");
        String apiNameToMatch = apiName;
        String baseApiName = "assigned_checklists/" + assignedChecklistUuid + "/" + apiName;
        apiName = String.format(baseApiName, assignedChecklistUuid);
        apiName = UrlUtil.getFormatedApiName(apiName, lastActivityAfter, lastActivityBefore);
        apiName = UrlUtil.appendUrl(apiName, UrlUtil.REVISION + "=" + BaseApplication.getPreferenceManager().getCurrentRevision());
        if (apiNameToMatch.equalsIgnoreCase("assigned_cautions.json")) {
            assignedService.getAssignedCautions(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_decisions.json")) {
            assignedService.getAssignedDecisions(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_logos.json")) {
            assignedService.getAssignedLogos(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_notes.json")) {
            assignedService.getAssignedNotes(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_steps.json")) {
            assignedService.getAssignedSteps(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_step_qas.json")) {
            assignedService.getAssignedStepQas(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_step_results.json")) {
            assignedService.getAssignedStepResults(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_users.json")) {
            assignedService.getAssignedUsers(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_warnings.json")) {
            assignedService.getAssignedWarnings(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_checklist_pause_times.json")) {
            assignedService.getAssignedChecklistPauseTimes(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_step_skip_difer_reasons.json")) {
            assignedService.getAssignedStepSkipDiferReasons(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_step_resources.json")) {
            assignedService.getAssignedStepResources(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_departments.json")) {
            assignedService.getAssignedDepartments(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("assigned_room_equipments.json")) {
            assignedService.getAssignedRoomEquipments(apiName, tableName);
        } else if (apiNameToMatch.equalsIgnoreCase("logs.json")) {
            assignedService.getLogs(apiName, tableName);
        }
    }
}
