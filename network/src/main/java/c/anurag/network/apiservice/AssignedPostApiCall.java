package c.anurag.network.apiservice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;

import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import c.anurag.database.IcarusDatabaseHelper;
import c.anurag.database.IcarusDatabaseManager;
import c.anurag.database.application.BaseApplication;
import c.anurag.network.ApiService;
import c.anurag.network.RequestData;
import c.anurag.network.RetrofitApiServiceFactory;
import c.anurag.network.beans.AssigneeDecsisionResultEnum;
import c.anurag.network.beans.AssigneeNCWResultEnum;
import c.anurag.network.beans.AssigneeStepResultEnum;
import c.anurag.network.beans.AssigneeTypeEnum;
import c.anurag.network.beans.ChecklistStatusEnum;
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
import c.anurag.network.beans.user.favorites.UserFavoritesEntry;
import c.anurag.network.beans.user.favorites.UserFavoritesResponse;
import c.anurag.network.beans.user.suggestion.UserSuggestionsEntry;
import c.anurag.network.beans.user.suggestion.UserSuggestionsResponse;
import c.anurag.network.beans.user.suggestion.attachment.UserSuggestionAttachmentsEntry;
import c.anurag.network.beans.user.suggestion.attachment.UserSuggestionAttachmentsResponse;
import c.anurag.network.beanspost.cautions.AssignedCautionsPostResponse;
import c.anurag.network.beanspost.checklist.AssignedChecklistsPostResponse;
import c.anurag.network.beanspost.decisions.AssignedDecisionsPostResponse;
import c.anurag.network.beanspost.departments.AssignedDepartmentsPostResponse;
import c.anurag.network.beanspost.equipments.AssignedRoomEquipmentsPostResponse;
import c.anurag.network.beanspost.favorites.UserFavoritesPostResponse;
import c.anurag.network.beanspost.logo.AssignedLogosPostResponse;
import c.anurag.network.beanspost.logs.LogsPostResponse;
import c.anurag.network.beanspost.reasons.AssignedSkipDeferReasonsPostResponse;
import c.anurag.network.beanspost.step.qas.AssignedStepQASPostResponse;
import c.anurag.network.beanspost.step.resources.AssignedStepResourcesPostResponse;
import c.anurag.network.beanspost.step.results.AssignedStepResultsPostResponse;
import c.anurag.network.beanspost.steps.AssignedStepsPostResponse;
import c.anurag.network.beanspost.suggestion.UserSuggestionsPostResponse;
import c.anurag.network.beanspost.suggestion.attachment.UserSuggestionAttachmentsPostResponse;
import c.anurag.network.beanspost.times.AssignedPauseTimesPostResponse;
import c.anurag.network.beanspost.users.AssignedUsersPostResponse;
import c.anurag.network.beanspost.warnings.AssignedWarningsPostResponse;
import c.anurag.network.beanspost.workorder.WorkorderPost;
import c.anurag.network.beanspost.workorder.WorkorderPostEntry;
import c.anurag.network.beanspost.workorder.WorkorderPostResponse;
import c.anurag.network.callback.IViewCallback;
import c.anurag.network.database.Utility;
import c.anurag.network.subscriber.AbstractNetworkObservable;
import c.anurag.network.util.TraceActivity;
import c.anurag.network.util.UrlUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by anuragpurwar
 */

public class AssignedPostApiCall extends IPostApiCall {
    public final ApiService service;
    public final Context context;
    public final IcarusDatabaseManager icarusDatabaseManager;

    public AssignedPostApiCall(Context context, RetrofitApiServiceFactory factory) {
        this.context = context;
        service = new ApiService(context, factory, BaseApplication.getPreferenceManager().getServerPath(), RequestData.getHeaders());
        icarusDatabaseManager = IcarusDatabaseManager.getInstance(context);
    }

    private <T> T getBody(String tableName, final Class<T> clazz) {
        String query = "Select * from " + tableName + " where sync_status = 0";
        JSONObject parent = new JSONObject();

        JSONArray subparent = new JSONArray();
        Cursor cursor = icarusDatabaseManager.executeAnyQuery(query);
        try {
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                        JSONObject jsonObject = new JSONObject();
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            putJsonValue(cursor, i, tableName, jsonObject);
                        }
                        subparent.put(jsonObject);
                    }
                    cursor.close();
                    parent.put("data", subparent);
                    TraceActivity.writeActivity("data : " + parent.toString());
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonString = String.valueOf(parent);
        T body = new GsonBuilder().serializeNulls().create().fromJson(jsonString, clazz);
        return body;
    }
    @SuppressLint("Range")
    private void putJsonValue(Cursor cursor, int i, String tableName, JSONObject jsonObject) throws JSONException {
        String columnName = cursor.getColumnName(i);
        if (!(columnName.trim().equals(IcarusDatabaseHelper.KEY_ID)
                || columnName.trim().equals(IcarusDatabaseHelper.KEY_ENTRY_TS)
                || columnName.trim().equals("res_action_type")
                || columnName.trim().equals("isuploaded")
                || columnName.trim().equals("is_uploaded")
                || columnName.trim().equals("isEmbeddedImagesDownloaded")
                || columnName.trim().equals("isStepResourcesDownloaded")
                || columnName.trim().equals("revision_id")
                || columnName.trim().equals("sync_status"))) {

            switch (cursor.getType(i)) {
                case Cursor.FIELD_TYPE_INTEGER:
                    int value = cursor.getInt(cursor.getColumnIndex(columnName));
                    switch (columnName.trim()) {
                        case "assigned_to":
                            if (tableName.equals("assigned_checklists")) {
                                jsonObject.put("assignee_type", String.valueOf(AssigneeTypeEnum.values()[value]));
                            } else {
                                jsonObject.put(columnName, value);
                            }
                            break;
                        case "pause_status":
                        case "is_resource":
                        case "is_default":
                        case "is_deleted":
                            jsonObject.put(columnName, Utility.convertIntToBoolean(value));
                            break;
                        case "checklist_status":
                            jsonObject.put("status", ChecklistStatusEnum.get(value).name().toLowerCase());
                            break;
                        case "acknowledged":
                            jsonObject.put("status", AssigneeNCWResultEnum.get(value).name());
                            break;
                        case "status":
                            if (tableName.equalsIgnoreCase("ppes")) {
                                jsonObject.put(columnName, Utility.convertIntToBoolean(value));
                            } else {
                                jsonObject.put("status", AssigneeStepResultEnum.get(value).name());
                            }
                            break;
                        case "is_applicable":
                            jsonObject.put("status", AssigneeDecsisionResultEnum.get(value).name());
                            break;
                        case "start_by_user_id":
                            jsonObject.put("started_by_user_id", value);
                            break;
                        case "assigned_checklist_step_id":
                            jsonObject.put("step_id", value);
                            break;
                        case "filesize":
                            jsonObject.put("file_size", value);
                            break;
                        default:
                            jsonObject.put(columnName, value);
                            break;
                    }
                    break;
                case Cursor.FIELD_TYPE_FLOAT:
                    jsonObject.put(columnName, cursor.getFloat(cursor.getColumnIndex(columnName)));
                    break;
                case Cursor.FIELD_TYPE_STRING:
                    String valueString = cursor.getString(cursor.getColumnIndex(columnName));
                    switch (columnName.trim()) {
                        case "modified":
                            jsonObject.put("updated_at", valueString);
                            break;
                        case "due_date":
                            jsonObject.put("due_at", valueString);
                            break;
                        case "created":
                            jsonObject.put("created_at", valueString);
                            break;
                        case "start_time":
                            jsonObject.put("started_at", valueString);
                            break;
                        case "start_datetime":
                            jsonObject.put("assigned_at", valueString);
                            break;
                        case "display_file_name":
                            jsonObject.put("display_filename", (TextUtils.isEmpty(valueString) ? "null" : valueString));
                            break;
                        case "file_md5_checksum":
                            jsonObject.put("md5_checksum", (TextUtils.isEmpty(valueString) ? "null" : valueString));
                            break;
                        case "file_type":
                            jsonObject.put("content_type", (TextUtils.isEmpty(valueString) ? "null" : valueString));
                            break;
                        case "name":
                            jsonObject.put("filename", (TextUtils.isEmpty(valueString) ? "null" : valueString));
                            break;
                        case "item_description":
                            jsonObject.put("item_description", (TextUtils.isEmpty(valueString) ? null : valueString));
                            break;
                        default:
                            jsonObject.put(columnName, valueString);
                            break;
                    }
                    break;
                case Cursor.FIELD_TYPE_NULL:
                    switch (columnName.trim()) {
                        case "start_time":
                            jsonObject.put("started_at", JSONObject.NULL);
                            break;
                        case "start_datetime":
                            jsonObject.put("assigned_at", JSONObject.NULL);
                            break;
                        case "due_date":
                            jsonObject.put("due_at", JSONObject.NULL);
                            break;
                        default:
                            TraceActivity.writeActivityError(tableName + " FIELD_TYPE_NULL : " + columnName);
                            jsonObject.putOpt(columnName, JSONObject.NULL);
                            break;
                    }
                    break;
                default:
                    TraceActivity.writeActivityError(tableName + " default : " + columnName);
                    jsonObject.putOpt(columnName, JSONObject.NULL);
                    break;
            }
        }
    }

    private <S, T> void postGeneric(String apiName, final String tableName, final Class<T> clazz, final Class<S> postClazz, final IViewCallback<T> callback) {
        S body = getBody(tableName, postClazz);
        if (body == null) {
            return;
        }
        String url = UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), apiName);
        Observable<T> observable =
                service.post(url, body, clazz)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<T>() {
            @Override
            public void success(T response) {
                if (response != null) {
                    callback.checkAndUpdate(response);
                }
            }

            @Override
            public void failure(Throwable error) {
                callback.onFailure(error);
            }
        });
    }

    @Override
    public void postUserFavorites(String apiName, final String tableName) {
        postGeneric(apiName, tableName, UserFavoritesResponse.class, UserFavoritesPostResponse.class, new IViewCallback<UserFavoritesResponse>() {
            @Override
            protected void onSuccess(UserFavoritesResponse response) {
                if (response != null) {
                    new UserFavoritesEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedChecklists(final String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedChecklistsResponse.class, AssignedChecklistsPostResponse.class, new IViewCallback<AssignedChecklistsResponse>() {
            @Override
            protected void onSuccess(AssignedChecklistsResponse response) {
                if (response != null) {
                    new AssignedChecklistsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedCautions(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedCautionsResponse.class, AssignedCautionsPostResponse.class, new IViewCallback<AssignedCautionsResponse>() {
            @Override
            protected void onSuccess(AssignedCautionsResponse response) {
                if (response != null) {
                    new AssignedCautionsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedDecisions(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedDecisionsResponse.class, AssignedDecisionsPostResponse.class, new IViewCallback<AssignedDecisionsResponse>() {
            @Override
            protected void onSuccess(AssignedDecisionsResponse response) {
                if (response != null) {
                    new AssignedDecisionsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedLogos(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedLogosResponse.class, AssignedLogosPostResponse.class, new IViewCallback<AssignedLogosResponse>() {
            @Override
            protected void onSuccess(AssignedLogosResponse response) {
                if (response != null) {
                    new AssignedLogosEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedNotes(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedNotesResponse.class, AssignedNotesResponse.class, new IViewCallback<AssignedNotesResponse>() {
            @Override
            protected void onSuccess(AssignedNotesResponse response) {
                if (response != null) {
                    new AssignedNotesEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedSteps(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedStepsResponse.class, AssignedStepsPostResponse.class, new IViewCallback<AssignedStepsResponse>() {
            @Override
            protected void onSuccess(AssignedStepsResponse response) {
                if (response != null) {
                    new AssignedStepsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedStepQas(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedStepQASResponse.class, AssignedStepQASPostResponse.class, new IViewCallback<AssignedStepQASResponse>() {
            @Override
            protected void onSuccess(AssignedStepQASResponse response) {
                if (response != null) {
                    new AssignedStepQASEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedStepResults(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedStepResultsResponse.class, AssignedStepResultsPostResponse.class, new IViewCallback<AssignedStepResultsResponse>() {
            @Override
            protected void onSuccess(AssignedStepResultsResponse response) {
                if (response != null) {
                    new AssignedStepResultsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedUsers(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedUsersResponse.class, AssignedUsersPostResponse.class, new IViewCallback<AssignedUsersResponse>() {
            @Override
            protected void onSuccess(AssignedUsersResponse response) {
                if (response != null) {
                    new AssignedUsersEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedWarnings(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedWarningsResponse.class, AssignedWarningsPostResponse.class, new IViewCallback<AssignedWarningsResponse>() {
            @Override
            protected void onSuccess(AssignedWarningsResponse response) {
                if (response != null) {
                    new AssignedWarningsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedChecklistPauseTimes(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedPauseTimesResponse.class, AssignedPauseTimesPostResponse.class, new IViewCallback<AssignedPauseTimesResponse>() {
            @Override
            protected void onSuccess(AssignedPauseTimesResponse response) {
                if (response != null) {
                    new AssignedPauseTimesEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedStepSkipDiferReasons(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedSkipDeferReasonsResponse.class, AssignedSkipDeferReasonsPostResponse.class, new IViewCallback<AssignedSkipDeferReasonsResponse>() {
            @Override
            protected void onSuccess(AssignedSkipDeferReasonsResponse response) {
                if (response != null) {
                    new AssignedSkipDeferReasonsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedStepResources(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedStepResourcesResponse.class, AssignedStepResourcesPostResponse.class, new IViewCallback<AssignedStepResourcesResponse>() {
            @Override
            protected void onSuccess(AssignedStepResourcesResponse response) {
                if (response != null) {
                    new AssignedStepResourcesEntry(context, tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedDepartments(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedDepartmentsResponse.class, AssignedDepartmentsPostResponse.class, new IViewCallback<AssignedDepartmentsResponse>() {
            @Override
            protected void onSuccess(AssignedDepartmentsResponse response) {
                if (response != null) {
                    new AssignedDepartmentsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postAssignedRoomEquipments(String apiName, final String tableName) {
        postGeneric(apiName, tableName, AssignedRoomEquipmentsResponse.class, AssignedRoomEquipmentsPostResponse.class, new IViewCallback<AssignedRoomEquipmentsResponse>() {
            @Override
            protected void onSuccess(AssignedRoomEquipmentsResponse response) {
                if (response != null) {
                    new AssignedRoomEquipmentsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postLogs(String apiName, final String tableName) {
        postGeneric(apiName, tableName, LogsResponse.class, LogsPostResponse.class, new IViewCallback<LogsResponse>() {
            @Override
            protected void onSuccess(LogsResponse response) {
                if (response != null) {
                    new LogsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    @SuppressLint("Range")
    public void postWorkorders(String apiName, final String[] arrayTableName, String[] arrayModelName) {
        Class<WorkorderPost> clazz = WorkorderPost.class;

        //String link = "clients/" + UUID + "/" + arr[0];
        String query = "SELECT\n" +
                "\t*\n" +
                "FROM workorders\n" +
                "WHERE id IN (\n" +
                "\tSELECT DISTINCT workorder_notes.workorder_id FROM workorder_notes WHERE workorder_notes.sync_status = 0\n" +
                "\tUNION\n" +
                "\tSELECT DISTINCT workorder_notes.workorder_id FROM workorder_note_details LEFT JOIN workorder_notes ON workorder_notes.id = workorder_note_details.workorder_note_id WHERE workorder_note_details.sync_status = 0\n" +
                "\tUNION\n" +
                "\tSELECT DISTINCT workorder_attachments.workorder_id FROM workorder_attachments WHERE workorder_attachments.sync_status = 0\n" +
                ") OR sync_status = 0;";

        JSONObject parent = new JSONObject();
        try {
            JSONArray subparent = new JSONArray();
            Cursor cursor = icarusDatabaseManager.executeAnyQuery(query);
            JSONObject jsonObject = new JSONObject();
            if (cursor != null) {
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    jsonObject = new JSONObject();
                    String workorder_id = "";
                    for (int j = 0; j < cursor.getColumnCount(); j++) {
                        putJsonValue(cursor, j, arrayTableName[0], jsonObject);
                        String ColomnName = cursor.getColumnName(j);

                        if (ColomnName.trim().equals(IcarusDatabaseHelper.KEY_ID)) {
                            String idValue = cursor.getString(cursor.getColumnIndex(ColomnName));
                            jsonObject.put(ColomnName, idValue);
                            workorder_id = idValue;
                        }
                    }
                    query = "Select * from " + arrayTableName[1] + " where sync_status = 0 AND workorder_id = " + workorder_id;
                    Cursor cursorAttachment = icarusDatabaseManager.executeAnyQuery(query);
                    JSONArray subparentAttachment = new JSONArray();
                    for (cursorAttachment.moveToFirst(); !cursorAttachment.isAfterLast(); cursorAttachment.moveToNext()) {
                        JSONObject jsonObjectAttachment = new JSONObject();
                        for (int j = 0; j < cursorAttachment.getColumnCount(); j++) {
                            putJsonValue(cursorAttachment, j, arrayTableName[1], jsonObjectAttachment);
                        }
                        subparentAttachment.put(jsonObjectAttachment);
                    }
                    jsonObject.put(arrayModelName[1], subparentAttachment);
                    cursorAttachment.close();

                    query = "Select * from " + arrayTableName[2] + " where sync_status = 0 AND workorder_id = " + workorder_id + " AND id < 0";
                    Cursor cursorNote = icarusDatabaseManager.executeAnyQuery(query);
                    JSONArray subparentNote = new JSONArray();
                    for (cursorNote.moveToFirst(); !cursorNote.isAfterLast(); cursorNote.moveToNext()) {
                        JSONObject jsonObjectNote = new JSONObject();
                        String workorder_note_id = "";
                        for (int j = 0; j < cursorNote.getColumnCount(); j++) {
                            putJsonValue(cursorNote, j, arrayTableName[2], jsonObjectNote);
                            String ColomnName = cursorNote.getColumnName(j);

                            if (ColomnName.trim().equals("id")) {
                                String idValue = cursor.getString(cursor.getColumnIndex(ColomnName));
                                jsonObjectNote.put(ColomnName, idValue);
                                workorder_note_id = cursorNote.getString(cursorNote.getColumnIndex(ColomnName));
                            }
                        }

                        query = "Select * from " + arrayTableName[3] + " where sync_status = 0 AND workorder_note_id = " + workorder_note_id;
                        Cursor cursorNoteDetail = icarusDatabaseManager.executeAnyQuery(query);
                        JSONArray subparentNoteDetail = new JSONArray();
                        for (cursorNoteDetail.moveToFirst(); !cursorNoteDetail.isAfterLast(); cursorNoteDetail.moveToNext()) {
                            JSONObject jsonObjectNoteDetail = new JSONObject();
                            for (int j = 0; j < cursorNoteDetail.getColumnCount(); j++) {
                                putJsonValue(cursorNoteDetail, j, arrayTableName[3], jsonObjectNoteDetail);
                            }
                            subparentNoteDetail.put(jsonObjectNoteDetail);
                        }
                        jsonObjectNote.put(arrayModelName[3], subparentNoteDetail);
                        cursorNoteDetail.close();
                        subparentNote.put(jsonObjectNote);
                    }
                    jsonObject.put(arrayModelName[2], subparentNote);
                    cursorNote.close();
                    subparent.put(jsonObject);
                }
                cursor.close();
            }
            //sub_parent.put(arrayModelName[0], subparent);
            parent.put("data", subparent);
            TraceActivity.writeActivity(parent.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonString = String.valueOf(parent);
        WorkorderPost body = new GsonBuilder().serializeNulls().create().fromJson(jsonString, clazz);
        if (body.getData() == null || body.getData().size() == 0) {
            return;
        }
        String url = UrlUtil.getUrl(BaseApplication.getPreferenceManager().getServerPath(), apiName);
        Observable<WorkorderPostResponse> observable =
                service.post(url, body, WorkorderPostResponse.class)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread());
        observable.subscribe(new AbstractNetworkObservable<WorkorderPostResponse>() {
            @Override
            public void success(WorkorderPostResponse response) {
                if (response != null) {
                    new WorkorderPostEntry().insertUpdate(response.getData(), icarusDatabaseManager);
                }
            }

            @Override
            public void failure(Throwable error) {

            }
        });
    }

    @Override
    public void postUserSuggestions(String apiName, final String tableName) {
        postGeneric(apiName, tableName, UserSuggestionsResponse.class, UserSuggestionsPostResponse.class, new IViewCallback<UserSuggestionsResponse>() {
            @Override
            protected void onSuccess(UserSuggestionsResponse response) {
                if (response != null) {
                    new UserSuggestionsEntry(tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }

    @Override
    public void postUserSuggestionAttachments(String apiName, final String tableName) {
        postGeneric(apiName, tableName, UserSuggestionAttachmentsResponse.class, UserSuggestionAttachmentsPostResponse.class, new IViewCallback<UserSuggestionAttachmentsResponse>() {
            @Override
            protected void onSuccess(UserSuggestionAttachmentsResponse response) {
                if (response != null) {
                    new UserSuggestionAttachmentsEntry(context, tableName, icarusDatabaseManager).insertUpdate(response);
                }
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }
}