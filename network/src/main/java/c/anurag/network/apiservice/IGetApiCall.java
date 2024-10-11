package c.anurag.network.apiservice;

import c.anurag.network.ApiService;

/**
 * Created by anuragpurwar.
 */

public abstract class IGetApiCall {
    public abstract void getUsers(final String apiName, final String tableName);

    public abstract void getClientLogos(final String apiName, final String tableName);

    public abstract void getDepartments(final String apiName, final String tableName);

    public abstract void getChecklistTypes(final String apiName, final String tableName);

    public abstract void getHazards(final String apiName, final String tableName);

    public abstract void getPpes(final String apiName, final String tableName);

    public abstract void getGroups(final String apiName, final String tableName);

    public abstract void getItemTypes(final String apiName, final String tableName);

    public abstract void getLocations(final String apiName, final String tableName);

    public abstract void getRooms(final String apiName, final String tableName);

    public abstract void getEquipments(final String apiName, final String tableName);

    public abstract void getLocationDepartments(final String apiName, final String tableName);

    public abstract void getLocationEquipments(final String apiName, final String tableName);

    public abstract void getLocationRoomEquipments(final String apiName, final String tableName);

    public abstract void getUserLocationDepartments(final String apiName, final String tableName);

    public abstract void getChecklists(final String apiName, final String tableName);

    public abstract void getChecklistTitles(final String apiName, final String tableName);

    public abstract void getChecklistLogos(final String apiName, final String tableName);

    public abstract void getChecklistTexts(final String apiName, final String tableName);

    public abstract void getSteps(final String apiName, final String tableName);

    public abstract void getDecisions(final String apiName, final String tableName);

    public abstract void getCautions(final String apiName, final String tableName);

    public abstract void getNotes(final String apiName, final String tableName);

    public abstract void getWarnings(final String apiName, final String tableName);

    public abstract void getCautionHazards(final String apiName, final String tableName);

    public abstract void getWarningHazards(final String apiName, final String tableName);

    public abstract void getNoteHazards(final String apiName, final String tableName);

    public abstract void getStepAttributes(final String apiName, final String tableName);

    public abstract void getChecklistPpes(final String apiName, final String tableName);

    public abstract void getStepResultFunctions(final String apiName, final String tableName);

    public abstract void getResourceLinks(final String apiName, final String tableName);

    public abstract void getChecklistElements(final String apiName, final String tableName);

    public abstract void getChecklistRoomEquipments(final String apiName, final String tableName);

    public abstract void getAssociatedChecklists(final String apiName, final String tableName);

    public abstract void getResources(final String apiName, final String tableName);

    public abstract void getUserFavorites(final String apiName, final String tableName);

    public abstract void getAssignedChecklists(final String apiName, final String tableName);

    public abstract void getAssignedCautions(final String apiName, final String tableName);

    public abstract void getAssignedDecisions(final String apiName, final String tableName);

    public abstract void getAssignedLogos(final String apiName, final String tableName);

    public abstract void getAssignedNotes(final String apiName, final String tableName);

    public abstract void getAssignedSteps(final String apiName, final String tableName);

    public abstract void getAssignedStepQas(final String apiName, final String tableName);

    public abstract void getAssignedStepResults(final String apiName, final String tableName);

    public abstract void getAssignedUsers(final String apiName, final String tableName);

    public abstract void getAssignedWarnings(final String apiName, final String tableName);

    public abstract void getAssignedChecklistPauseTimes(final String apiName, final String tableName);

    public abstract void getAssignedStepSkipDiferReasons(final String apiName, final String tableName);

    public abstract void getAssignedStepResources(final String apiName, final String tableName);

    public abstract void getAssignedDepartments(final String apiName, final String tableName);

    public abstract void getAssignedRoomEquipments(final String apiName, final String tableName);

    public abstract void getChecklistLocations(final String apiName, final String tableName);

    public abstract void getLogs(final String apiName, final String tableName);

    public abstract void getWorkorderBillingTypes(final String apiName, final String tableName);

    public abstract void getWorkorders(final String apiName, final String tableName);

    public abstract void getWorkorderAttachments(final String apiName, final String tableName);

    public abstract void getWorkorderNotes(final String apiName, final String tableName);

    public abstract void getWorkorderNoteDetails(final String apiName, final String tableName);

    public abstract void getWorkorderStatuses(final String apiName, final String tableName);

    public abstract void getClientSettings(final String apiName, final String tableName);

    public abstract void getUserSuggestions(final String apiName, final String tableName);

    public abstract void getUserSuggestionAttachments(final String apiName, final String tableName);

    public abstract ApiService getService();
}
