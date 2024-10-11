package com.icarus.synchronization.workers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;

import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.dao.PostSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.AsssignedDepartmentsEntity;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.AssignedChecklistsApi;
import com.icarus.synchronization.syncmodels.RetrieveAssignedChecklist;
import com.icarus.util.DateUtility;
import com.icarus.util.StringUtil;

import java.io.IOException;

import retrofit2.Call;

public class AssignedChecklistWork extends CommonWorker {

    private final Context mContext;

    public AssignedChecklistWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        mContext = context;
    }

    @NonNull
    @Override
    public synchronized ListenableWorker.Result doWork() {
        Integer pageCount = getInputData().getInt(Parameters.PAGE_COUNT, 0);
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

        final String lastSyncTime = postSynchronizationDao.getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());

        if (pageCount > 0)
            for (int i1 = 0; i1 < pageCount; i1++) {
                int pageNo = i1 + 1;
                AssignedChecklistsApi service = RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedChecklistsApi.class);

                Call<RetrieveAssignedChecklist> call = service.assignedChecklistIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        Parameters.PARAM_CHECKLIST_EMBED_ASSIGNED_LOGO_ROOM_EQUIPMENTS,
                        BaseApplication.getPreferenceManager().getUserLocationId(),
                        BaseApplication.getPreferenceManager().getRevisionNumber(),
                        TextUtils.isEmpty(lastSyncTime) ? "true" : null);
                try {
                    RetrieveAssignedChecklist retrieveChecklists = call.execute().body();

                    if (retrieveChecklists != null
                            && retrieveChecklists.getData() != null
                            && retrieveChecklists.getData().size() > 0) {

                        for (int i = 0; i < retrieveChecklists.getData().size(); i++) {
                            RetrieveAssignedChecklist.Datum data = retrieveChecklists.getData().get(i);

                            try {
                                String assignedChecklistUuid = data.getUuid();
                                AssignCheckListEntity checklistExistLocally = getSynchronizationDao.ifAssignedChecklistExists(assignedChecklistUuid);
                                AssignCheckListEntity assignCheckListEntity = ModelMapper.mapAssignedChecklistEntity(data);
                                if (checklistExistLocally != null) {
                                    if (DateUtility.isLatestData(assignCheckListEntity.getModified(), checklistExistLocally.getModified())) {
                                        assignCheckListEntity.setUuid(checklistExistLocally.getUuid());
                                        assignCheckListEntity.setPendingElementsCount(checklistExistLocally.getPendingElementsCount());
                                        assignCheckListEntity.setPendingResourcesCount(checklistExistLocally.getPendingResourcesCount());
                                        assignCheckListEntity.setExecutionStatus(checklistExistLocally.getExecutionStatus());
                                        getSynchronizationDao.insertAssignedChecklists(assignCheckListEntity);
                                    }
                                } else {
                                    getSynchronizationDao.insertAssignedChecklists(assignCheckListEntity);
                                }

                                if (retrieveChecklists.getData().get(i).getAssignedLogo() != null) {  // --- IF Assigned checklist have logos
                                    RetrieveAssignedChecklist.AssignedLogo logo = data.getAssignedLogo();
                                    AssignedLogoEntity logoExistLocally = getSynchronizationDao.ifAssignedLogoExists(assignedChecklistUuid);
                                    AssignedLogoEntity assignedLogoEntity = ModelMapper.mapAssignedLogoEntity(logo, assignedChecklistUuid);
                                    if (logoExistLocally != null) {
                                        if (DateUtility.isLatestData(assignedLogoEntity.getModified(), logoExistLocally.getModified())) {
                                            assignedLogoEntity.setUuid(logoExistLocally.getUuid());
                                            getSynchronizationDao.insertAssignedLogoEntity(assignedLogoEntity);
                                        }
                                    } else {
                                        getSynchronizationDao.insertAssignedLogoEntity(assignedLogoEntity);
                                    }
                                }

                                if (retrieveChecklists.getData().get(i).getAssignedRoomEquipment() != null) { //--  If Assigned checklist have room equipments
                                    RetrieveAssignedChecklist.AssignedRoomEquipment roomEquipment = data.getAssignedRoomEquipment();
                                    AssignRoomEquipmentsEntity roomEquimentExistLocally = getSynchronizationDao.ifAssignedRoomEquipmentExists(assignedChecklistUuid);
                                    AssignRoomEquipmentsEntity assignRoomEquipmentsEntity = ModelMapper.mapAssignedRoomEquipmentEntity(roomEquipment, assignedChecklistUuid);
                                    if (roomEquimentExistLocally != null) {
                                        if (DateUtility.isLatestData(assignRoomEquipmentsEntity.getModified(), roomEquimentExistLocally.getModified())) {
                                            assignRoomEquipmentsEntity.setUuid(roomEquimentExistLocally.getUuid());
                                            getSynchronizationDao.insertAssignedRoomEquipmentEntity(assignRoomEquipmentsEntity);
                                        }
                                    } else {
                                        getSynchronizationDao.insertAssignedRoomEquipmentEntity(assignRoomEquipmentsEntity);
                                    }
                                }

                                if (StringUtil.INSTANCE.listNotNull(retrieveChecklists.getData().get(i).getAssignedUsers())) {
                                    for (int j = 0; j < retrieveChecklists.getData().get(i).getAssignedUsers().size(); j++) {
                                        RetrieveAssignedChecklist.AssignedUser users = data.getAssignedUsers().get(j);
                                        AssignedUserEntity userExistLocally = getSynchronizationDao.ifAssignedUserExists(assignedChecklistUuid, users.getUserId());
                                        AssignedUserEntity assignedUserEntity = ModelMapper.mapAssignedUsersEntity(users, assignedChecklistUuid);
                                        if (userExistLocally != null) {
                                            if (DateUtility.isLatestData(assignedUserEntity.getModified(), userExistLocally.getModified())) {
                                                assignedUserEntity.setUuid(userExistLocally.getUuid());
                                                getSynchronizationDao.insertAssignedUsers(assignedUserEntity);
                                            }
                                        } else {
                                            getSynchronizationDao.insertAssignedUsers(assignedUserEntity);
                                        }
                                    }
                                }
                                if (StringUtil.INSTANCE.listNotNull(retrieveChecklists.getData().get(i).getAssignedDepartments())) {
                                    for (int j = 0; j < retrieveChecklists.getData().get(i).getAssignedDepartments().size(); j++) {
                                        RetrieveAssignedChecklist.AssignedDepartment department = data.getAssignedDepartments().get(j);
                                        AsssignedDepartmentsEntity departmentExistLocally = getSynchronizationDao.ifAssignedDepartmentExists(assignedChecklistUuid, department.getDepartmentId());
                                        AsssignedDepartmentsEntity asssignedDepartmentsEntity = ModelMapper.mapAssignedDepartmentntity(department, assignedChecklistUuid);
                                        if (departmentExistLocally != null) {
                                            if (DateUtility.isLatestData(asssignedDepartmentsEntity.getModified(), departmentExistLocally.getModified())) {
                                                asssignedDepartmentsEntity.setUuid(departmentExistLocally.getUuid());
                                                getSynchronizationDao.insertAssignedDepartment(asssignedDepartmentsEntity);
                                            }
                                        } else {
                                            getSynchronizationDao.insertAssignedDepartment(asssignedDepartmentsEntity);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(Parameters.TAG, "Assigned Checklist " + data.getUuid() +
                                        " of Checklist ID " + data.getChecklistId() +
                                        " and having status " + data.getStatus() +
                                        " could not be saved.");
                                WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
                            }

                            if (!TextUtils.isEmpty(lastSyncTime)) {
                                AssignedChecklistDetailWork.fetchDetail(retrieveChecklists.getData().get(i).getUuid(), getApplicationContext(), AssignedChecklistWork.this);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(Parameters.TAG, e.getMessage());
                    WorkManager.getInstance(mContext).enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
                }
            }


        return ListenableWorker.Result.success();
    }

    /**
     * @param pageNo // No of page
     */
    /*private synchronized void hitAPI(final Integer pageNo) {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        PostSynchronizationDao postSynchronizationDao = appDatabase.postSynchronizationDao();

        final String lastSyncTime = postSynchronizationDao.getLastSyncTime(BaseApplication.getPreferenceManager().getUserLocationId());
        *//*String checklistStatusParam = "";

        if (lastSyncTime != null && lastSyncTime.length() > 0)
            checklistStatusParam = "pending,paused";*//*

        RetroUtils.getRetrofitInstance(getApplicationContext(), this).create(AssignedChecklistsApi.class)
                .assignedChecklistIndex(Constants.HEADER_ACCEPT, Parameters.PAGE_SIZE, pageNo,
                        BaseApplication.getPreferenceManager().getLastActivityAfter(),
                        BaseApplication.getPreferenceManager().getLastActivityBefore(),
                        Parameters.PARAM_CHECKLIST_EMBED_ASSIGNED_LOGO_ROOM_EQUIPMENTS,
                        BaseApplication.getPreferenceManager().getUserLocationId(),
                        BaseApplication.getPreferenceManager().getRevisionNumber(),
                        TextUtils.isEmpty(lastSyncTime) ? "true" : null).subscribe(new AbstractNetworkObservable<RetrieveAssignedChecklist>() {
            @Override
            public void success(RetrieveAssignedChecklist retrieveChecklists) {
                if (retrieveChecklists != null) {
                    *//*if (retrieveChecklists.getPagination().getNextUrl() != null) {
                        pageNumber = pageNumber + 1;
                        hitAPI(pageNumber);
                    }*//*
                    if (retrieveChecklists.getData() != null && retrieveChecklists.getData().size() > 0) {

                        for (int i = 0; i < retrieveChecklists.getData().size(); i++) {
                            RetrieveAssignedChecklist.Datum data = retrieveChecklists.getData().get(i);
                            try {
                                String assignedChecklistUuid = data.getUuid();
                                AssignCheckListEntity checklistExistLocally = getSynchronizationDao.ifAssignedChecklistExists(assignedChecklistUuid);
                                AssignCheckListEntity assignCheckListEntity = ModelMapper.mapAssignedChecklistEntity(data);
                                if (checklistExistLocally != null) {
                                    if (DateUtility.isLatestData(assignCheckListEntity.getModified(), checklistExistLocally.getModified())) {
                                        assignCheckListEntity.setUuid(checklistExistLocally.getUuid());
                                        assignCheckListEntity.setPendingElementsCount(checklistExistLocally.getPendingElementsCount());
                                        assignCheckListEntity.setPendingResourcesCount(checklistExistLocally.getPendingResourcesCount());
                                        assignCheckListEntity.setExecutionStatus(checklistExistLocally.getExecutionStatus());
                                        getSynchronizationDao.insertAssignedChecklists(assignCheckListEntity);
                                    }
                                } else {
                                    getSynchronizationDao.insertAssignedChecklists(assignCheckListEntity);
                                }

                                if (retrieveChecklists.getData().get(i).getAssignedLogo() != null) {  // --- IF Assigned checklist have logos
                                    RetrieveAssignedChecklist.AssignedLogo logo = data.getAssignedLogo();
                                    AssignedLogoEntity logoExistLocally = getSynchronizationDao.ifAssignedLogoExists(assignedChecklistUuid);
                                    AssignedLogoEntity assignedLogoEntity = ModelMapper.mapAssignedLogoEntity(logo, assignedChecklistUuid);
                                    if (logoExistLocally != null) {
                                        if (DateUtility.isLatestData(assignedLogoEntity.getModified(), logoExistLocally.getModified())) {
                                            assignedLogoEntity.setUuid(logoExistLocally.getUuid());
                                            getSynchronizationDao.insertAssignedLogoEntity(assignedLogoEntity);
                                        }
                                    } else {
                                        getSynchronizationDao.insertAssignedLogoEntity(assignedLogoEntity);
                                    }
                                }

                                if (retrieveChecklists.getData().get(i).getAssignedRoomEquipment() != null) { //--  If Assigned checklist have room equipments
                                    RetrieveAssignedChecklist.AssignedRoomEquipment roomEquipment = data.getAssignedRoomEquipment();
                                    AssignRoomEquipmentsEntity roomEquimentExistLocally = getSynchronizationDao.ifAssignedRoomEquipmentExists(assignedChecklistUuid);
                                    AssignRoomEquipmentsEntity assignRoomEquipmentsEntity = ModelMapper.mapAssignedRoomEquipmentEntity(roomEquipment, assignedChecklistUuid);
                                    if (roomEquimentExistLocally != null) {
                                        if (DateUtility.isLatestData(assignRoomEquipmentsEntity.getModified(), roomEquimentExistLocally.getModified())) {
                                            assignRoomEquipmentsEntity.setUuid(roomEquimentExistLocally.getUuid());
                                            getSynchronizationDao.insertAssignedRoomEquipmentEntity(assignRoomEquipmentsEntity);
                                        }
                                    } else {
                                        getSynchronizationDao.insertAssignedRoomEquipmentEntity(assignRoomEquipmentsEntity);
                                    }
                                }

                                if (StringUtil.INSTANCE.listNotNull(retrieveChecklists.getData().get(i).getAssignedUsers())) {
                                    for (int j = 0; j < retrieveChecklists.getData().get(i).getAssignedUsers().size(); j++) {
                                        RetrieveAssignedChecklist.AssignedUser users = data.getAssignedUsers().get(j);
                                        AssignedUserEntity userExistLocally = getSynchronizationDao.ifAssignedUserExists(assignedChecklistUuid, users.getUserId());
                                        AssignedUserEntity assignedUserEntity = ModelMapper.mapAssignedUsersEntity(users, assignedChecklistUuid);
                                        if (userExistLocally != null) {
                                            if (DateUtility.isLatestData(assignedUserEntity.getModified(), userExistLocally.getModified())) {
                                                assignedUserEntity.setUuid(userExistLocally.getUuid());
                                                getSynchronizationDao.insertAssignedUsers(assignedUserEntity);
                                            }
                                        } else {
                                            getSynchronizationDao.insertAssignedUsers(assignedUserEntity);
                                        }
                                    }
                                }
                                if (StringUtil.INSTANCE.listNotNull(retrieveChecklists.getData().get(i).getAssignedDepartments())) {
                                    for (int j = 0; j < retrieveChecklists.getData().get(i).getAssignedDepartments().size(); j++) {
                                        RetrieveAssignedChecklist.AssignedDepartment department = data.getAssignedDepartments().get(j);
                                        AsssignedDepartmentsEntity departmentExistLocally = getSynchronizationDao.ifAssignedDepartmentExists(assignedChecklistUuid, department.getDepartmentId());
                                        AsssignedDepartmentsEntity asssignedDepartmentsEntity = ModelMapper.mapAssignedDepartmentntity(department, assignedChecklistUuid);
                                        if (departmentExistLocally != null) {
                                            if (DateUtility.isLatestData(asssignedDepartmentsEntity.getModified(), departmentExistLocally.getModified())) {
                                                asssignedDepartmentsEntity.setUuid(departmentExistLocally.getUuid());
                                                getSynchronizationDao.insertAssignedDepartment(asssignedDepartmentsEntity);
                                            }
                                        } else {
                                            getSynchronizationDao.insertAssignedDepartment(asssignedDepartmentsEntity);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("Assigned Checklist UUID", data.getUuid());

                            }
                            if (!TextUtils.isEmpty(lastSyncTime)) {
                                AssignedChecklistDetailWork.fetchDetail(retrieveChecklists.getData().get(i).getUuid(), getApplicationContext(), AssignedChecklistWork.this);
                            }
                        }
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.d(Parameters.TAG, error.getMessage());
                error.printStackTrace();
                //WorkManager.getInstance().enqueue(new OneTimeWorkRequest.Builder(FailureWork.class).setConstraints(Utils.getConstraints()).build());
            }
        });
    }*/
}

