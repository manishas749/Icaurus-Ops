package c.anurag.network.apiservice;

/**
 * Created by anuragpurwar
 */

public abstract class IPostApiCall {
    public abstract void postUserFavorites(final String apiName, final String tableName);

    public abstract void postAssignedChecklists(final String apiName, final String tableName);

    public abstract void postAssignedCautions(final String apiName, final String tableName);

    public abstract void postAssignedDecisions(final String apiName, final String tableName);

    public abstract void postAssignedLogos(final String apiName, final String tableName);

    public abstract void postAssignedNotes(final String apiName, final String tableName);

    public abstract void postAssignedSteps(final String apiName, final String tableName);

    public abstract void postAssignedStepQas(final String apiName, final String tableName);

    public abstract void postAssignedStepResults(final String apiName, final String tableName);

    public abstract void postAssignedUsers(final String apiName, final String tableName);

    public abstract void postAssignedWarnings(final String apiName, final String tableName);

    public abstract void postAssignedChecklistPauseTimes(final String apiName, final String tableName);

    public abstract void postAssignedStepSkipDiferReasons(final String apiName, final String tableName);

    public abstract void postAssignedStepResources(final String apiName, final String tableName);

    public abstract void postAssignedDepartments(final String apiName, final String tableName);

    public abstract void postAssignedRoomEquipments(final String apiName, final String tableName);

    public abstract void postLogs(final String apiName, final String tableName);

    public abstract void postUserSuggestions(final String apiName, final String tableName);

    public abstract void postUserSuggestionAttachments(final String apiName, final String tableName);

    public abstract void postWorkorders(final String apiName, final String[] arrayTableName, final String[] arrayModelName);
}
