package com.icarus.synchronization;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.synchronization.api.OthersApi;
import com.icarus.synchronization.syncmodels.SyncObject;
import com.icarus.synchronization.workers.AccountLogoWork;
import com.icarus.synchronization.workers.AssignedChecklistDetailWork;
import com.icarus.synchronization.workers.AssignedChecklistWork;
import com.icarus.synchronization.workers.ChecklistElementWork;
import com.icarus.synchronization.workers.ChecklistExecutionPermissionWork;
import com.icarus.synchronization.workers.ChecklistStatusesWork;
import com.icarus.synchronization.workers.ChecklistTypeWorker;
import com.icarus.synchronization.workers.ChecklistWork;
import com.icarus.synchronization.workers.ClientSettingWork;
import com.icarus.synchronization.workers.CommonWorker;
import com.icarus.synchronization.workers.DepartmentsWorker;
import com.icarus.synchronization.workers.DownloadMediaWork;
import com.icarus.synchronization.workers.FailureWork;
import com.icarus.synchronization.workers.FinalWork;
import com.icarus.synchronization.workers.GroupWork;
import com.icarus.synchronization.workers.HazardsWork;
import com.icarus.synchronization.workers.ItemTypeWork;
import com.icarus.synchronization.workers.LocationEquipmentWorker;
import com.icarus.synchronization.workers.LocationRoomEquipmentWorker;
import com.icarus.synchronization.workers.LocationRoomWorker;
import com.icarus.synchronization.workers.LocationWorker;
import com.icarus.synchronization.workers.PepsWork;
import com.icarus.synchronization.workers.PostAssignedChecklistCommentWork;
import com.icarus.synchronization.workers.PostAssignedChecklistPauseTimes;
import com.icarus.synchronization.workers.PostAssignedChecklistWork;
import com.icarus.synchronization.workers.PostAssignedDecisions;
import com.icarus.synchronization.workers.PostAssignedLogosWork;
import com.icarus.synchronization.workers.PostAssignedLogs;
import com.icarus.synchronization.workers.PostAssignedNCWWork;
import com.icarus.synchronization.workers.PostAssignedRoomEquipments;
import com.icarus.synchronization.workers.PostAssignedStepAttribute;
import com.icarus.synchronization.workers.PostAssignedStepResources;
import com.icarus.synchronization.workers.PostAssignedStepSkipDeferReasonsWork;
import com.icarus.synchronization.workers.PostAssignedStepWork;
import com.icarus.synchronization.workers.PostAssignedUserWork;
import com.icarus.synchronization.workers.PostUserFavorites;
import com.icarus.synchronization.workers.PostUserSuggestionWork;
import com.icarus.synchronization.workers.PostWorkordersWork;
import com.icarus.synchronization.workers.UnAuthorizedWork;
import com.icarus.synchronization.workers.UserFavouriteWork;
import com.icarus.synchronization.workers.UserWorker;
import com.icarus.synchronization.workers.WorkorderAssociatedWorker;
import com.icarus.synchronization.workers.WorkorderBillingWorker;
import com.icarus.synchronization.workers.WorkorderStatusesWorker;
import com.icarus.synchronization.workers.WorkordersWorker;
import com.icarus.util.AppUtility;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SyncWorkManager extends CommonWorker {

    private OneTimeWorkRequest checklistWorkRequest, assignedchecklistWorkRequest, userWorkRequest;
    private OneTimeWorkRequest locationWorkRequest, locationRoomWork, locationEquipmentWork,
            locationRoomEquipmentWork, checklistElementWorkRequest;
    private final Context mContext;

    public SyncWorkManager(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        BaseApplication.getPreferenceManager().setSyncIdentifier(AppUtility.Companion.getUuid());
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
        String lastSyncTime = postSynchronizationDao.getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());

        if (lastSyncTime != null && lastSyncTime.length() > 0) {
            BaseApplication.getPreferenceManager().setLastActivityAfter(lastSyncTime);
        } else {
            BaseApplication.getPreferenceManager().setLastActivityAfter("");
        }

        BaseApplication.getPreferenceManager().setLastActivityBefore(AppUtility.Companion.getUtcTime());

        RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(OthersApi.class).sync(Constants.HEADER_ACCEPT, BaseApplication.getPreferenceManager().getLastActivityAfter(), BaseApplication.getPreferenceManager().getLastActivityBefore(), BaseApplication.getPreferenceManager().getUserLocationId(), BaseApplication.getPreferenceManager().getRevisionNumber()).enqueue(new Callback<SyncObject>() {
            @Override
            public void onResponse(Call<SyncObject> call, Response<SyncObject> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    SyncObject syncObject = response.body();
                    OneTimeWorkRequest postAssignedChecklistWork = new OneTimeWorkRequest.Builder(PostAssignedChecklistWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedUserWork = new OneTimeWorkRequest.Builder(PostAssignedUserWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedLogo = new OneTimeWorkRequest.Builder(PostAssignedLogosWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedDecisions = new OneTimeWorkRequest.Builder(PostAssignedDecisions.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postUserFavorites = new OneTimeWorkRequest.Builder(PostUserFavorites.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedPauseTime = new OneTimeWorkRequest.Builder(PostAssignedChecklistPauseTimes.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedNCWWork = new OneTimeWorkRequest.Builder(PostAssignedNCWWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedStepWork = new OneTimeWorkRequest.Builder(PostAssignedStepWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedStepSkipDeferReasonWork = new OneTimeWorkRequest.Builder(PostAssignedStepSkipDeferReasonsWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedStepAttribute = new OneTimeWorkRequest.Builder(PostAssignedStepAttribute.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedStepResources = new OneTimeWorkRequest.Builder(PostAssignedStepResources.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedRoomEquipments = new OneTimeWorkRequest.Builder(PostAssignedRoomEquipments.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedLogsWork = new OneTimeWorkRequest.Builder(PostAssignedLogs.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postWorkorderWork = new OneTimeWorkRequest.Builder(PostWorkordersWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postAssignedChecklistCommentWork = new OneTimeWorkRequest.Builder(PostAssignedChecklistCommentWork.class).setConstraints(Utils.getConstraints()).build();

                    OneTimeWorkRequest userFavouriteWork = new OneTimeWorkRequest.Builder(UserFavouriteWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest clientLogoWork = new OneTimeWorkRequest.Builder(AccountLogoWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest finalWork = new OneTimeWorkRequest.Builder(FinalWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest downloadWork = new OneTimeWorkRequest.Builder(DownloadMediaWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest postUserSuggestion = new OneTimeWorkRequest.Builder(PostUserSuggestionWork.class).setConstraints(Utils.getConstraints()).build();

                    //--- Initializing Workers--//////
                    locationWorkRequest = new OneTimeWorkRequest.Builder(LocationWorker.class).setConstraints(Utils.getConstraints()).build();
                    locationRoomWork = new OneTimeWorkRequest.Builder(LocationRoomWorker.class).setConstraints(Utils.getConstraints()).build();
                    locationEquipmentWork = new OneTimeWorkRequest.Builder(LocationEquipmentWorker.class).setConstraints(Utils.getConstraints()).build();
                    locationRoomEquipmentWork = new OneTimeWorkRequest.Builder(LocationRoomEquipmentWorker.class).setConstraints(Utils.getConstraints()).build();

                    userWorkRequest = new OneTimeWorkRequest.Builder(UserWorker.class).setConstraints(Utils.getConstraints()).build();
                    checklistWorkRequest = new OneTimeWorkRequest.Builder(ChecklistWork.class).setConstraints(Utils.getConstraints()).build();
                    assignedchecklistWorkRequest = new OneTimeWorkRequest.Builder(AssignedChecklistWork.class).setConstraints(Utils.getConstraints()).build();
                    checklistElementWorkRequest = new OneTimeWorkRequest.Builder(ChecklistElementWork.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest workOrderWorkRequest = new OneTimeWorkRequest.Builder(WorkordersWorker.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest workOrderWorkAssociatedRequest = new OneTimeWorkRequest.Builder(WorkorderAssociatedWorker.class).setConstraints(Utils.getConstraints()).build();
                    OneTimeWorkRequest assignedChecklistElementWorkRequest = new OneTimeWorkRequest.Builder(AssignedChecklistDetailWork.class).setConstraints(Utils.getConstraints()).build();
                    //OneTimeWorkRequest checklistWorkRequestLocation = new OneTimeWorkRequest.Builder(ChecklistLocationWork.class).setConstraints(Utils.getConstraints()).build();

                    if (syncObject != null && syncObject.getData() != null && syncObject.getData().size() > 0) {
                        ArrayList<OneTimeWorkRequest> workerList = new ArrayList<>();
                        LinkedList<OneTimeWorkRequest> workerListAll = new LinkedList<>();
                        OneTimeWorkRequest groupWorkRequest = null;
                        OneTimeWorkRequest checklistTypeWorkRequest = null;
                        for (int i = 0; i < syncObject.getData().size(); i++) {


                            if (syncObject.getData().get(i).getCount() > 0) {

                                Data inputData = new Data.Builder().putInt(Parameters.PAGE_COUNT, (int) Math.ceil((syncObject.getData().get(i).getCount() / Parameters.PAGE_SIZE) + 0.5)).build(); //- Pass Checklist Id to Get Elements

                                if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_GROUP)) {
                                    groupWorkRequest = new OneTimeWorkRequest.Builder(GroupWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(groupWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_ITEM_TYPES)) {
                                    OneTimeWorkRequest itemTypeWorkRequest = new OneTimeWorkRequest.Builder(ItemTypeWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(itemTypeWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_PPES)) {
                                    OneTimeWorkRequest pepWorkRequest = new OneTimeWorkRequest.Builder(PepsWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(pepWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_HAZARDS)) {
                                    OneTimeWorkRequest hazardWorkRequest = new OneTimeWorkRequest.Builder(HazardsWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(hazardWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_CLIENT_SETTINGS)) {
                                    OneTimeWorkRequest clientSettingWorkRequest = new OneTimeWorkRequest.Builder(ClientSettingWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(clientSettingWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_CHECKLIST_TYPE)) {
                                    checklistTypeWorkRequest = new OneTimeWorkRequest.Builder(ChecklistTypeWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(checklistTypeWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_CHECKLIST_STATUS)) {
                                    OneTimeWorkRequest checklistStatusWorkRequest = new OneTimeWorkRequest.Builder(ChecklistStatusesWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(checklistStatusWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_CHECKLIST_EXECUSION_PERMISSION)) {
                                    OneTimeWorkRequest checklistExecutionPermissionWorkRequest = new OneTimeWorkRequest.Builder(ChecklistExecutionPermissionWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(checklistExecutionPermissionWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_WORKORDER_STATUS)) {
                                    OneTimeWorkRequest workOrderStatusWorkRequest = new OneTimeWorkRequest.Builder(WorkorderStatusesWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(workOrderStatusWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_WORKORDDER_BILLING)) {
                                    OneTimeWorkRequest workorderBillingWorkerWorkRequest = new OneTimeWorkRequest.Builder(WorkorderBillingWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(workorderBillingWorkerWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_DEPARTMENTS)) {
                                    OneTimeWorkRequest departmentWorkRequest = new OneTimeWorkRequest.Builder(DepartmentsWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerList.add(departmentWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_LOCATION)) {
                                    locationWorkRequest = new OneTimeWorkRequest.Builder(LocationWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(locationWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_USER)) {
                                    userWorkRequest = new OneTimeWorkRequest.Builder(UserWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(userWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_CHECKLIST)) {
                                    checklistWorkRequest = new OneTimeWorkRequest.Builder(ChecklistWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(checklistWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_ASSIGNED_CHECKLIST)) {
                                    assignedchecklistWorkRequest = new OneTimeWorkRequest.Builder(AssignedChecklistWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(assignedchecklistWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_WORKORDDER)) {
                                    workOrderWorkRequest = new OneTimeWorkRequest.Builder(WorkordersWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(workOrderWorkRequest);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_USER_FAVORITES)) {
                                    userFavouriteWork = new OneTimeWorkRequest.Builder(UserFavouriteWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(userFavouriteWork);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPES_CLIENT_LOGOS)) {
                                    clientLogoWork = new OneTimeWorkRequest.Builder(AccountLogoWork.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                    workerListAll.add(clientLogoWork);
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPE_LOCATION_ROOMS)) {
                                    locationRoomWork = new OneTimeWorkRequest.Builder(LocationRoomWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPE_LOCATION_EQUIPMENTS)) {
                                    locationEquipmentWork = new OneTimeWorkRequest.Builder(LocationEquipmentWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                } else if (syncObject.getData().get(i).getType().equals(Constants.SYNC_TYPE_LOCATION_ROOM_EQUIPMENTS)) {
                                    locationRoomEquipmentWork = new OneTimeWorkRequest.Builder(LocationRoomEquipmentWorker.class).setConstraints(Utils.getConstraints()).setInputData(inputData).build();
                                }
                            }
                        }
                        if (workerList.size() > 0) {
                            LinkedList<OneTimeWorkRequest> workerBeginWith = new LinkedList<>();

                            if (groupWorkRequest != null && workerList.contains(groupWorkRequest)) {
                                workerBeginWith.add(groupWorkRequest);
                                workerList.remove(groupWorkRequest);
                            }

                            if (checklistTypeWorkRequest != null && workerList.contains(checklistTypeWorkRequest)) {
                                workerBeginWith.add(checklistTypeWorkRequest);
                                workerList.remove(checklistTypeWorkRequest);
                            }

                            workerBeginWith.addAll(workerList);
                            WorkManager.getInstance(mContext).beginWith(workerBeginWith)
                                    .then(locationWorkRequest)
                                    .then(locationEquipmentWork)
                                    .then(locationRoomWork)
                                    .then(locationRoomEquipmentWork)
                                    .then(userWorkRequest)
                                    .then(checklistWorkRequest)
                                    .then(userFavouriteWork)
                                    .then(clientLogoWork)
                                    //.then(checklistWorkRequestLocation)
                                    .then(workOrderWorkRequest)
                                    .then(assignedchecklistWorkRequest)
                                    .then(checklistElementWorkRequest)
                                    .then(assignedChecklistElementWorkRequest)
                                    .then(workOrderWorkAssociatedRequest)
                                    .then(postUserFavorites)
                                    .then(postAssignedChecklistWork)
                                    .then(postAssignedUserWork)
                                    .then(postAssignedLogo)
                                    .then(postAssignedStepWork)
                                    .then(postAssignedStepAttribute)
                                    .then(postAssignedStepResources)
                                    .then(postAssignedNCWWork)
                                    .then(postAssignedStepSkipDeferReasonWork)
                                    .then(postAssignedRoomEquipments)
                                    .then(postUserSuggestion)
                                    .then(postAssignedDecisions)
                                    .then(postAssignedPauseTime)
                                    .then(postAssignedChecklistCommentWork)
                                    .then(postAssignedLogsWork)
                                    .then(postWorkorderWork)
                                    .then(finalWork).enqueue();

                        } else if (workerListAll.size() > 0) {
                            LinkedList<OneTimeWorkRequest> workerBeginWith = new LinkedList<>();

                           if (workerListAll.contains(locationWorkRequest)) {
                                workerBeginWith.add(locationWorkRequest);
                            }
                            if (workerListAll.contains(userWorkRequest)) {
                                workerBeginWith.add(userWorkRequest);
                            }
                            if (workerListAll.contains(checklistWorkRequest)) {
                                workerBeginWith.add(checklistWorkRequest);
                            }
                            if (workerListAll.contains(userFavouriteWork)) {
                                workerBeginWith.add(userFavouriteWork);
                            }
                            if (workerListAll.contains(clientLogoWork)) {
                                workerBeginWith.add(clientLogoWork);
                            }
                            if (workerListAll.contains(assignedchecklistWorkRequest)) {
                                workerBeginWith.add(assignedchecklistWorkRequest);
                            }
                            if (workerListAll.contains(workOrderWorkRequest)) {
                                workerBeginWith.add(workOrderWorkRequest);
                            }
                            WorkManager.getInstance(mContext)
                                    .beginWith(workerBeginWith)
                                    .then(locationRoomWork)
                                    .then(locationEquipmentWork)
                                    .then(locationRoomEquipmentWork)
                                    .then(checklistElementWorkRequest)
                                    .then(assignedChecklistElementWorkRequest)
                                    .then(workOrderWorkAssociatedRequest)
                                    .then(postUserFavorites)
                                    .then(postAssignedChecklistWork)
                                    .then(postAssignedUserWork)
                                    .then(postAssignedLogo)
                                    .then(postAssignedStepWork)
                                    .then(postAssignedStepAttribute)
                                    .then(postAssignedStepResources)
                                    .then(postAssignedNCWWork)
                                    .then(postAssignedStepSkipDeferReasonWork)
                                    .then(postAssignedRoomEquipments)
                                    .then(postUserSuggestion)
                                    .then(postAssignedDecisions)
                                    .then(postAssignedPauseTime)
                                    .then(postAssignedChecklistCommentWork)
                                    .then(postAssignedLogsWork)
                                    .then(postWorkorderWork)
                                    .then(finalWork).enqueue();
                        } else {
                            WorkManager.getInstance(mContext)
                                    .beginWith(checklistElementWorkRequest)
                                    .then(locationEquipmentWork)
                                    .then(locationRoomWork)
                                    .then(locationRoomEquipmentWork)
                                    .then(assignedChecklistElementWorkRequest)
                                    .then(workOrderWorkAssociatedRequest)
                                    .then(postAssignedChecklistWork)
                                    .then(postUserFavorites)
                                    .then(postAssignedUserWork)
                                    .then(postAssignedLogo)
                                    .then(postAssignedStepWork)
                                    .then(postAssignedStepAttribute)
                                    .then(postAssignedStepResources)
                                    .then(postAssignedNCWWork)
                                    .then(postAssignedStepSkipDeferReasonWork)
                                    .then(postAssignedRoomEquipments)
                                    .then(postUserSuggestion)
                                    .then(postAssignedDecisions)
                                    .then(postAssignedPauseTime)
                                    .then(postAssignedChecklistCommentWork)
                                    .then(postAssignedLogsWork)
                                    .then(postWorkorderWork)
                                    .then(finalWork).enqueue();
                        }
                    }


                    //Check if server time is less than last_sync_before
                    //if yes save server time as last sync at'
                    String serverTime = syncObject.getMeta().getServerDateTimeFormatted();
                    boolean isCurrentTimeSameWithServer = AppUtility.Companion.compairTwoDates(serverTime,
                            BaseApplication.getPreferenceManager().getLastActivityBefore());
                    if (!isCurrentTimeSameWithServer) {
                        BaseApplication.getPreferenceManager().setLastActivityBefore(serverTime);
                    }

                    if (syncObject.getMeta().getRevision() != null)
                        BaseApplication.getPreferenceManager().setTempRevisionNumber(syncObject.getMeta().getRevision());

                    //------------------ Saving Last Sync Time and Revision Number in the Datebase-/////////////
                    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                    final PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();
                    postSynchronizationDao.updateSyncStatus(Constants.SYNC_STATUS_INPROGRESS, BaseApplication.getPreferenceManager().getUserLocationId());
                } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(UnAuthorizedWork.class).setConstraints(Utils.getConstraints()).build());
                } else {
                    WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
                }
            }

            @Override
            public void onFailure(Call<SyncObject> call, Throwable error) {
                Log.d(Parameters.TAG, error.getMessage());
                WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());

            }
        });

        return Result.success();
    }
}
