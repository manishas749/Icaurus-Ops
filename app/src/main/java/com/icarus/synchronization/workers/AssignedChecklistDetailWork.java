package com.icarus.synchronization.workers;

import com.icarus.activities.DashboardActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedItemPlaceholderEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedChecklistsApi;
import com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail;
import com.icarus.util.DateUtility;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import c.anurag.network.subscriber.AbstractNetworkObservable;

public class AssignedChecklistDetailWork extends CommonWorker {
    //-- Initialize Database
    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
    final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();


    public AssignedChecklistDetailWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public ListenableWorker.Result doWork() {
        Intent intent = new Intent(DashboardActivity.TAG);
        intent.putExtra(DashboardActivity.SYNC_PERCENTAGE, DashboardActivity.SYNC_ASSIGNED_PERCENTAGE);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

        String lastSyncTime = appDatabase.postSynchronizationDao().getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());
        List<Integer> status = new ArrayList<>();
        status.add(Constants.CHECL_LIST_STATUS_PENDING);
        status.add(Constants.CHECL_LIST_STATUS_PAUSED);
        if (!TextUtils.isEmpty(lastSyncTime)) {
            status.add(Constants.CHECL_LIST_STATUS_CANCELLED);
            status.add(Constants.CHECK_LIST_STATUS_COMPLETED);
        }

        List<String> latestChecklists = getSynchronizationDao.getLatestAssignedChecklists(BaseApplication.getPreferenceManager().getLastActivityAfter(), status);

        if (latestChecklists.size() > 0) {
            Log.d("KAMAL_DHIMAN", "doWork: " + latestChecklists.size());
            for (int i = 0; i < latestChecklists.size(); i++) {
                fetchDetail(latestChecklists.get(i), getApplicationContext(), this);
            }
        }
        return ListenableWorker.Result.success();
    }

    public static synchronized void fetchDetail(final String assigndChecklistUuid, final Context context, InternetConnectionListener internetConnectionListener) {
        RetroUtils.getRetrofitInstance(context, internetConnectionListener).create(AssignedChecklistsApi.class).assignedChecklistView(Constants.HEADER_ACCEPT, assigndChecklistUuid, "true").subscribe(new AbstractNetworkObservable<ReteriveAssignedChecklistDetail>() {
            @Override
            public void success(ReteriveAssignedChecklistDetail reteriveAssignedChecklistDetail) {
                if (reteriveAssignedChecklistDetail != null && reteriveAssignedChecklistDetail.getData() != null) {
                    AppDatabase appDatabase = AppDatabase.getInstance(context);
                    GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
                    int updateCount = 0;
                    try {
                        ReteriveAssignedChecklistDetail.Data data = reteriveAssignedChecklistDetail.getData();
                        String assignedChecklistUuid = data.getUuid();
                        for (int i = 0; i < data.getAssignedCautions().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedCaution cautions = data.getAssignedCautions().get(i);
                            AssignedNCWEntity ncwExistLocally = getSynchronizationDao.ifNCWExists(assignedChecklistUuid, cautions.getChecklistElementId());
                            AssignedNCWEntity assignedNCWEntity = ModelMapper.mapAssignedCautionEntity(cautions, assignedChecklistUuid);
                            if (ncwExistLocally != null) {
                                if (DateUtility.isLatestData(assignedNCWEntity.getModified(), ncwExistLocally.getModified())) {
                                    assignedNCWEntity.setUuid(ncwExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedNCW(assignedNCWEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedNCW(assignedNCWEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedChecklistComments().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedChecklistComment comment = data.getAssignedChecklistComments().get(i);
                            AssignedChecklistCommentsEntity commentExistLocally = getSynchronizationDao.ifCommentExists(comment.getUuid(), assignedChecklistUuid);
                            AssignedChecklistCommentsEntity assignedChecklistCommentsEntity = ModelMapper.mapAssignedCommentsEntity(comment, assignedChecklistUuid);
                            if (commentExistLocally != null) {
                                if (DateUtility.isLatestData(assignedChecklistCommentsEntity.getModified(), commentExistLocally.getModified())) {
                                    assignedChecklistCommentsEntity.setUuid(commentExistLocally.getUuid());
                                    getSynchronizationDao.insertAssigneComments(assignedChecklistCommentsEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssigneComments(assignedChecklistCommentsEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedChecklistPauseTimes().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedChecklistPauseTime pauseTime = data.getAssignedChecklistPauseTimes().get(i);
                            AssignedCheckListPauseTimesEntity pauseTimeExistLocally = getSynchronizationDao.ifPauseTimeExists(pauseTime.getUuid(), assignedChecklistUuid);
                            AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity = ModelMapper.mapAssignedPauseTimeEntity(pauseTime, assignedChecklistUuid);
                            if (pauseTimeExistLocally != null) {
                                if (DateUtility.isLatestData(assignedCheckListPauseTimesEntity.getModified(), pauseTimeExistLocally.getModified())) {
                                    assignedCheckListPauseTimesEntity.setUuid(pauseTimeExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedPauseTime(assignedCheckListPauseTimesEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedPauseTime(assignedCheckListPauseTimesEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedDecisions().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedDecision decision = data.getAssignedDecisions().get(i);
                            AssignedDecisionEntity decisionExistLocally = getSynchronizationDao.ifDecisionExists(assignedChecklistUuid, decision.getChecklistElementId());
                            AssignedDecisionEntity assignedDecisionEntity = ModelMapper.mapAssignedDecisionEntity(decision, assignedChecklistUuid);
                            if (decisionExistLocally != null) {
                                if (DateUtility.isLatestData(assignedDecisionEntity.getModified(), decisionExistLocally.getModified())) {
                                    assignedDecisionEntity.setUuid(decisionExistLocally.getUuid());
                                    getSynchronizationDao.insertAssigneDecision(assignedDecisionEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssigneDecision(assignedDecisionEntity);
                            }
                        }
                        /*for (int i = 0; i < data.getAssignedDepartments().size(); i++)
                            getSynchronizationDao.insertAssignedDepartment(ModelMapper.mapAssignedDepartmentntity(data.getAssignedDepartments().get(i), assignedChecklistUuid));*/

                        for (int i = 0; i < data.getAssignedItemPlaceholders().size(); i++) {
                            try {
                                ReteriveAssignedChecklistDetail.AssignedItemPlaceholder itemPlaceholder = data.getAssignedItemPlaceholders().get(i);
                                AssignedItemPlaceholderEntity placeholderExistLocally = getSynchronizationDao.ifPlaceholderExists(itemPlaceholder.getItemPlaceholderId(), itemPlaceholder.getChecklistElementId(), assignedChecklistUuid);
                                AssignedItemPlaceholderEntity assignedItemPlaceholderEntity = ModelMapper.mapAssignedPlaceholdersEntity(itemPlaceholder, assignedChecklistUuid);
                                if (placeholderExistLocally != null) {
                                    if (DateUtility.isLatestData(assignedItemPlaceholderEntity.getModified(), placeholderExistLocally.getModified())) {
                                        assignedItemPlaceholderEntity.setUuid(placeholderExistLocally.getUuid());
                                        getSynchronizationDao.insertAssignedPlaceholder(assignedItemPlaceholderEntity);
                                        updateCount++;
                                    }
                                } else {
                                    getSynchronizationDao.insertAssignedPlaceholder(assignedItemPlaceholderEntity);
                                }
                            } catch (Exception e) {
                                Log.d(Parameters.TAG, e.getMessage());

                            }
                        }

                        for (int i = 0; i < data.getAssignedNotes().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedNote note = data.getAssignedNotes().get(i);
                            AssignedNCWEntity ncwExistLocally = getSynchronizationDao.ifNCWExists(assignedChecklistUuid, note.getChecklistElementId());
                            AssignedNCWEntity assignedNCWEntity = ModelMapper.mapAssignedNotesEntity(note, assignedChecklistUuid);
                            if (ncwExistLocally != null) {
                                if (DateUtility.isLatestData(assignedNCWEntity.getModified(), ncwExistLocally.getModified())) {
                                    assignedNCWEntity.setUuid(ncwExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedNCW(assignedNCWEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedNCW(assignedNCWEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedStepAttributes().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedStepAttribute stepAttribute = data.getAssignedStepAttributes().get(i);
                            String customType = getSynchronizationDao.customFieldType(stepAttribute.getStepAttributeId());
                            AssignedStepAttributesEntity placeholderExistLocally;
                            if (customType.equalsIgnoreCase("file") || customType.equalsIgnoreCase("qr")) {
                                placeholderExistLocally = getSynchronizationDao.ifStepAttributeWithFileExists(stepAttribute.getItemUuid(), stepAttribute.getChecklistElementId(), stepAttribute.getValue(), assignedChecklistUuid, stepAttribute.getStepAttributeId());
                            } else {
                                placeholderExistLocally = getSynchronizationDao.ifStepAttributeExists(stepAttribute.getItemUuid(), stepAttribute.getChecklistElementId(), assignedChecklistUuid, stepAttribute.getStepAttributeId());
                            }
                            AssignedStepAttributesEntity assignedStepAttributesEntity = ModelMapper.mapAssignedStepAttributeEntity(stepAttribute, assignedChecklistUuid);
                            if (placeholderExistLocally != null) {
                                if (DateUtility.isLatestData(assignedStepAttributesEntity.getModified(), placeholderExistLocally.getModified())) {
                                    assignedStepAttributesEntity.setUuid(placeholderExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedStepAttribute(assignedStepAttributesEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedStepAttribute(assignedStepAttributesEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedStepResources().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedStepResource stepResource = data.getAssignedStepResources().get(i);
                            AssignedStepFileResourceEntity stepResourceExistLocally = getSynchronizationDao.ifStepResourceExists(stepResource.getUuid(), stepResource.getChecklistElementId(), assignedChecklistUuid);
                            AssignedStepFileResourceEntity assignedStepFileResourceEntity = ModelMapper.mapAssignedStepResourcesEntity(stepResource, assignedChecklistUuid);
                            if (stepResourceExistLocally != null) {
                                if (DateUtility.isLatestData(assignedStepFileResourceEntity.getModified(), stepResourceExistLocally.getModified())) {
                                    assignedStepFileResourceEntity.setUuid(stepResourceExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedStepResources(assignedStepFileResourceEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedStepResources(assignedStepFileResourceEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedSteps().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedStep step = data.getAssignedSteps().get(i);
                            AssignedStepEntity stepExistLocally = getSynchronizationDao.ifStepExists(assignedChecklistUuid, step.getChecklistElementId());
                            AssignedStepEntity assignedStepEntity = ModelMapper.mapAssignedStepEntity(step, assignedChecklistUuid);
                            if (stepExistLocally != null) {
                                if (DateUtility.isLatestData(assignedStepEntity.getModified(), stepExistLocally.getModified())) {
                                    assignedStepEntity.setUuid(stepExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedSteps(assignedStepEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedSteps(assignedStepEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedStepSkipDeferReason().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedStep step = data.getAssignedStepSkipDeferReason().get(i);
                            AssignedStepEntity stepExistLocally = getSynchronizationDao.ifStepExists(assignedChecklistUuid, step.getChecklistElementId());
                            AssignedStepEntity assignedStepEntity = ModelMapper.mapAssignedStepEntity(step, assignedChecklistUuid);
                            if (stepExistLocally != null) {
                                if (DateUtility.isLatestData(assignedStepEntity.getModified(), stepExistLocally.getModified())) {
                                    assignedStepEntity.setUuid(stepExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedSteps(assignedStepEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedSteps(assignedStepEntity);
                            }
                        }

                        for (int i = 0; i < data.getAssignedWarnings().size(); i++) {
                            ReteriveAssignedChecklistDetail.AssignedWarning warning = data.getAssignedWarnings().get(i);
                            AssignedNCWEntity ncwExistLocally = getSynchronizationDao.ifNCWExists(assignedChecklistUuid, warning.getChecklistElementId());
                            AssignedNCWEntity assignedNCWEntity = ModelMapper.mapAssignedWarningEntity(warning, assignedChecklistUuid);
                            if (ncwExistLocally != null) {
                                if (DateUtility.isLatestData(assignedNCWEntity.getModified(), ncwExistLocally.getModified())) {
                                    assignedNCWEntity.setUuid(ncwExistLocally.getUuid());
                                    getSynchronizationDao.insertAssignedNCW(assignedNCWEntity);
                                    updateCount++;
                                }
                            } else {
                                getSynchronizationDao.insertAssignedNCW(assignedNCWEntity);
                            }
                        }

                        /*for (int i = 0; i < data.getAssignedUsers().size(); i++)
                            getSynchronizationDao.insertAssignedUsers(ModelMapper.mapAssignedUsersEntity(data.getAssignedUsers().get(i), assignedChecklistUuid));*/

                        for (int i = 0; i < data.getLogs().size(); i++) {
                            ReteriveAssignedChecklistDetail.Log warning = data.getLogs().get(i);
                            //LogsEntity logExistLocally = getSynchronizationDao.ifLogExists(assignedChecklistUuid, warning.getChecklistElementId());
                            LogsEntity logsEntity = ModelMapper.mapLogs(warning, assignedChecklistUuid);
                            /*if (logExistLocally != null) {
                                if (DateUtility.isLatestData(logsEntity.getModified(), logExistLocally.getModified())) {
                                    logsEntity.setUuid(logExistLocally.getUuid());
                                    getSynchronizationDao.insertLogs(logsEntity);
                                }
                            } else {
                                getSynchronizationDao.insertLogs(logsEntity);
                            }*/
                            getSynchronizationDao.insertLogs(logsEntity);
                        }

                        AssignCheckListEntity checklistExistLocally = getSynchronizationDao.ifAssignedChecklistExists(assignedChecklistUuid);

                        if (checklistExistLocally != null && checklistExistLocally.getExecutionStatus() == -1) {
                            getSynchronizationDao.updateAssignedChecklistSyncStatus(assignedChecklistUuid);
                        }

                        if (updateCount > 0) {

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(Parameters.TAG, assigndChecklistUuid);
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.d(Parameters.TAG, error.getMessage());
                //WorkManager.getInstance().enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
            }
        });
    }
}
