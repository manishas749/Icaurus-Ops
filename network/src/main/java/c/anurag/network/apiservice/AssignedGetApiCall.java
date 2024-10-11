package c.anurag.network.apiservice;

import android.content.Context;

import c.anurag.database.IcarusDatabaseManager;
import c.anurag.database.application.BaseApplication;
import c.anurag.network.ApiService;
import c.anurag.network.IEntry;
import c.anurag.network.RequestData;
import c.anurag.network.RetrofitApiServiceFactory;
import c.anurag.network.beans.assigned.cautions.AssignedCautionsEntry;
import c.anurag.network.beans.assigned.cautions.AssignedCautionsResponse;
import c.anurag.network.beans.assigned.checklist.AssignedChecklistsEntry;
import c.anurag.network.beans.assigned.checklist.AssignedChecklistsResponse;
import c.anurag.network.beans.assigned.decisions.AssignedDecisionsEntry;
import c.anurag.network.beans.assigned.decisions.AssignedDecisionsResponse;
import c.anurag.network.beans.assigned.departments.AssignedDepartmentsEntry;
import c.anurag.network.beans.assigned.departments.AssignedDepartmentsResponse;
import c.anurag.network.beans.assigned.logo.AssignedLogosEntry;
import c.anurag.network.beans.assigned.logo.AssignedLogosResponse;
import c.anurag.network.beans.assigned.logs.LogsEntry;
import c.anurag.network.beans.assigned.logs.LogsResponse;
import c.anurag.network.beans.assigned.notes.AssignedNotesEntry;
import c.anurag.network.beans.assigned.notes.AssignedNotesResponse;
import c.anurag.network.beans.assigned.pause.times.AssignedPauseTimesEntry;
import c.anurag.network.beans.assigned.pause.times.AssignedPauseTimesResponse;
import c.anurag.network.beans.assigned.room.equipments.AssignedRoomEquipmentsEntry;
import c.anurag.network.beans.assigned.room.equipments.AssignedRoomEquipmentsResponse;
import c.anurag.network.beans.assigned.skip.defer.reasons.AssignedSkipDeferReasonsEntry;
import c.anurag.network.beans.assigned.skip.defer.reasons.AssignedSkipDeferReasonsResponse;
import c.anurag.network.beans.assigned.step.qas.AssignedStepQASEntry;
import c.anurag.network.beans.assigned.step.qas.AssignedStepQASResponse;
import c.anurag.network.beans.assigned.step.resources.AssignedStepResourcesEntry;
import c.anurag.network.beans.assigned.step.resources.AssignedStepResourcesResponse;
import c.anurag.network.beans.assigned.step.results.AssignedStepResultsEntry;
import c.anurag.network.beans.assigned.step.results.AssignedStepResultsResponse;
import c.anurag.network.beans.assigned.steps.AssignedStepsEntry;
import c.anurag.network.beans.assigned.steps.AssignedStepsResponse;
import c.anurag.network.beans.assigned.users.AssignedUsersEntry;
import c.anurag.network.beans.assigned.users.AssignedUsersResponse;
import c.anurag.network.beans.assigned.warnings.AssignedWarningsEntry;
import c.anurag.network.beans.assigned.warnings.AssignedWarningsResponse;
import c.anurag.network.beans.user.suggestion.UserSuggestionsEntry;
import c.anurag.network.beans.user.suggestion.UserSuggestionsResponse;
import c.anurag.network.beans.user.suggestion.attachment.UserSuggestionAttachmentsEntry;
import c.anurag.network.beans.user.suggestion.attachment.UserSuggestionAttachmentsResponse;
import c.anurag.network.beans.workorder.WorkordersEntry;
import c.anurag.network.beans.workorder.WorkordersResponse;
import c.anurag.network.beans.workorder.attachment.WorkorderAttachmentsEntry;
import c.anurag.network.beans.workorder.attachment.WorkorderAttachmentsResponse;
import c.anurag.network.beans.workorder.billing.type.WorkorderBillingTypeEntry;
import c.anurag.network.beans.workorder.billing.type.WorkorderBillingTypesResponse;
import c.anurag.network.beans.workorder.note.WorkorderNotesEntry;
import c.anurag.network.beans.workorder.note.WorkorderNotesResponse;
import c.anurag.network.beans.workorder.note.details.WorkorderNoteDetailsEntry;
import c.anurag.network.beans.workorder.note.details.WorkorderNoteDetailsResponse;
import c.anurag.network.callback.IViewCallback;
import c.anurag.network.subscriber.AbstractNetworkObservable;
import c.anurag.network.util.TraceActivity;
import c.anurag.network.util.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anuragpurwar
 */

public abstract class AssignedGetApiCall extends IGetApiCall {
    public final ApiService service;
    public final Context context;
    public final IcarusDatabaseManager icarusDatabaseManager;
    private final ApiCallback apiCallback;
    private int count = 0;

    AssignedGetApiCall(Context context, RetrofitApiServiceFactory factory, ApiCallback apiCallback) {
        this.context = context;
        service = new ApiService(context, factory, BaseApplication.getPreferenceManager().getServerPath(), RequestData.getHeaders());
        icarusDatabaseManager = IcarusDatabaseManager.getInstance(context);
        this.apiCallback = apiCallback;
    }

    <T> void getGeneric(final String apiName, final Class<T> clazz, final IViewCallback<T> callback) {
        count++;
        TraceActivity.writeActivityError("Anurag " + count + "  " + apiName);
        String url = UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), apiName);
        Observable<T> observable =
                service.get(url, clazz)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<T>() {
            @Override
            public void success(T response) {
                if (response != null) {
                    callback.checkAndUpdate(response);
                }
                count--;
                TraceActivity.writeActivityError("Anurag success " + count + "  " + apiName);
                if (count == 0) {
                    apiCallback.onSyncComplete();
                }
            }

            @Override
            public void failure(Throwable error) {
                callback.onFailure(error);
                apiCallback.onSyncFailure(error);
            }

            @Override
            public void onComplete() {
                super.onComplete();
                TraceActivity.writeActivityError("Anurag onComplete " + count + "  " + apiName);
            }
        });
    }

    <T, S> void getGenericWithEntry(final String apiName, final Class<T> clazz, final IEntry<T> entry) {
        count++;
        TraceActivity.writeActivityError("Anurag " + count + "  " + apiName);
        String url = UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), apiName);
        Observable<T> observable =
                service.get2(url, clazz, entry)
                        .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new AbstractNetworkObservable<T>() {
            @Override
            public void success(T s) {
                count--;
                TraceActivity.writeActivityError("Anurag success " + count + "  " + apiName);
                if (count == 0) {
                    apiCallback.onSyncComplete();
                }
            }

            @Override
            public void failure(Throwable error) {
                apiCallback.onSyncFailure(error);
            }

            @Override
            public void onComplete() {
                super.onComplete();
                TraceActivity.writeActivityError("Anurag onComplete " + count + "  " + apiName);
            }
        });
    }

    @Override
    public void getAssignedChecklists(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedChecklistsResponse.class, new AssignedChecklistsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedCautions(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedCautionsResponse.class, new AssignedCautionsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedDecisions(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedDecisionsResponse.class, new AssignedDecisionsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedLogos(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedLogosResponse.class, new AssignedLogosEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedNotes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedNotesResponse.class, new AssignedNotesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedSteps(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedStepsResponse.class, new AssignedStepsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedStepQas(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedStepQASResponse.class, new AssignedStepQASEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedStepResults(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedStepResultsResponse.class, new AssignedStepResultsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedUsers(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedUsersResponse.class, new AssignedUsersEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedWarnings(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedWarningsResponse.class, new AssignedWarningsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedChecklistPauseTimes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedPauseTimesResponse.class, new AssignedPauseTimesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedStepSkipDiferReasons(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedSkipDeferReasonsResponse.class, new AssignedSkipDeferReasonsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedStepResources(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedStepResourcesResponse.class, new AssignedStepResourcesEntry(context, tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedDepartments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedDepartmentsResponse.class, new AssignedDepartmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getAssignedRoomEquipments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, AssignedRoomEquipmentsResponse.class, new AssignedRoomEquipmentsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getLogs(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, LogsResponse.class, new LogsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getWorkorderBillingTypes(final String apiName, final String tableName) {
        getWorkorderBillingTypesOrStatus(apiName, tableName);
    }

    private void getWorkorderBillingTypesOrStatus(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, WorkorderBillingTypesResponse.class, new WorkorderBillingTypeEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getWorkorders(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, WorkordersResponse.class, new WorkordersEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getWorkorderAttachments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, WorkorderAttachmentsResponse.class, new WorkorderAttachmentsEntry(context, tableName, icarusDatabaseManager));
    }

    @Override
    public void getWorkorderNotes(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, WorkorderNotesResponse.class, new WorkorderNotesEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getWorkorderNoteDetails(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, WorkorderNoteDetailsResponse.class, new WorkorderNoteDetailsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getWorkorderStatuses(final String apiName, final String tableName) {
        getWorkorderBillingTypesOrStatus(apiName, tableName);
    }

    @Override
    public void getUserSuggestions(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, UserSuggestionsResponse.class, new UserSuggestionsEntry(tableName, icarusDatabaseManager));
    }

    @Override
    public void getUserSuggestionAttachments(final String apiName, final String tableName) {
        getGenericWithEntry(apiName, UserSuggestionAttachmentsResponse.class, new UserSuggestionAttachmentsEntry(context, tableName, icarusDatabaseManager));
    }
}