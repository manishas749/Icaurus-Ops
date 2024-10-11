package com.icarus.synchronization.workers;

import com.icarus.constants.Constants;
import com.icarus.dao.GetChecklistElementDao;
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
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.StepAttributesEntity;
import com.icarus.enums.ChecklistElementType;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.RetroUtils;
import com.icarus.synchronization.api.AssignedChecklistsApi;
import com.icarus.synchronization.api.ChecklistElementsApi;
import com.icarus.synchronization.syncmodels.ReteriveAssignedChecklistDetail;
import com.icarus.synchronization.syncmodels.RetrieveAllChecklistElement;
import com.icarus.util.DateUtility;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import androidx.work.Worker;
import androidx.work.WorkerParameters;
import retrofit2.Call;

public class AssignedChecklistOnDemandWork extends Worker {

    public static final String ASSIGNED_CHECKLIST_UUID = "ASSIGNED_CHECKLIST_UUID";
    public static final String CHECKLIST_ID = "CHECKLIST_ID";
    public static final String ASSIGNED_SYNC_STATUS = "ASSIGNED_SYNC_STATUS";
    public static final String CHECKLIST_SYNC_STATUS = "CHECKLIST_SYNC_STATUS";

    //-- Initialize Database
    AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
    final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
    private final GetChecklistElementDao getChecklistElementDao = appDatabase.getChecklistElementDao();


    public AssignedChecklistOnDemandWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        final String uuid = getInputData().getString(ASSIGNED_CHECKLIST_UUID);
        final int checklistId = getInputData().getInt(CHECKLIST_ID, 0);
        final int assignedSyncStatus = getInputData().getInt(ASSIGNED_SYNC_STATUS, Constants.EXECUTION_STATUS_SYNC_TO_SERVER);
        final int checklistSyncStatus = getInputData().getInt(CHECKLIST_SYNC_STATUS, Constants.SYNC_STATUS_CHECKLIST_FULLY_SYNCED);

        final boolean[] isError = {false};

        if (checklistSyncStatus == Constants.SYNC_STATUS_CHECKLIST_PARTIAL_SYNCED) {
            ChecklistElementsApi checklistElementsApi = RetroUtils
                    .getRetrofitInstance(
                            getApplicationContext(),
                            new InternetConnectionListener() {
                                @Override
                                public void onInternetUnavailable() {
                                    isError[0] = true;
                                }
                            })
                    .create(ChecklistElementsApi.class);

            Call<RetrieveAllChecklistElement> checklistElementCall = checklistElementsApi
                    .checklistChecklistElementIndex1(Constants.HEADER_ACCEPT, checklistId + "", "item");

            try {
                RetrieveAllChecklistElement response = checklistElementCall.execute().body();
                saveChecklistElementData(checklistId, response);
            } catch (IOException e) {
                isError[0] = true;
                e.printStackTrace();
                Log.d(Parameters.TAG, e.getMessage());
            }
        }

        if (assignedSyncStatus == Constants.EXECUTION_STATUS_DATA_NOT_SYNC_FROM_SERVER) {
            AssignedChecklistsApi assignedChecklistsApi = RetroUtils
                    .getRetrofitInstance(
                            getApplicationContext(),
                            new InternetConnectionListener() {
                                @Override
                                public void onInternetUnavailable() {
                                    isError[0] = true;
                                }
                            })
                    .create(AssignedChecklistsApi.class);

            Call<ReteriveAssignedChecklistDetail> assignedChecklistDetailCall = assignedChecklistsApi
                    .assignedChecklistView1(Constants.HEADER_ACCEPT, uuid, "true");
            try {
                ReteriveAssignedChecklistDetail response = assignedChecklistDetailCall.execute().body();
                saveAssignedChecklistData(uuid, response);
            } catch (IOException e) {
                isError[0] = true;

                e.printStackTrace();
                Log.d(Parameters.TAG, e.getMessage());
            }
        }

        if (isError[0]) {
            return Result.failure();
        }

        return Result.success();
    }

    private void saveChecklistElementData(int checklistId, RetrieveAllChecklistElement retrieveAllChecklistElement) {
        if (retrieveAllChecklistElement != null
                && retrieveAllChecklistElement.getData() != null
                && retrieveAllChecklistElement.getData().size() > 0) {
            List<RetrieveAllChecklistElement.Datum> elements = retrieveAllChecklistElement.getData();
            List<RetrieveAllChecklistElement.Datum> mainElements = new ArrayList<>();
            List<RetrieveAllChecklistElement.Datum> childElements = new ArrayList<>();

            for (RetrieveAllChecklistElement.Datum element : elements) {
                if (element.getParentId() == null) {
                    mainElements.add(element);
                } else {
                    childElements.add(element);
                }
            }

            Comparator<RetrieveAllChecklistElement.Datum> byItemType = new Comparator<RetrieveAllChecklistElement.Datum>() {
                @Override
                public int compare(RetrieveAllChecklistElement.Datum t1, RetrieveAllChecklistElement.Datum t2) {
                    int elementOrder1 = 0;
                    int elementOrder2 = 0;

                    if (t1.getItemTypeId().equals(ChecklistElementType.DECISION.getValue())) {
                        elementOrder1 = 1;
                    } else if (t1.getItemTypeId().equals(ChecklistElementType.STEP.getValue())
                            || t1.getItemTypeId().equals(ChecklistElementType.PROCEDURE.getValue())
                            || t1.getItemTypeId().equals(ChecklistElementType.DATA_STEP.getValue())) {
                        elementOrder1 = 2;
                    } else {
                        elementOrder1 = 3;
                    }

                    if (t2.getItemTypeId().equals(ChecklistElementType.DECISION.getValue())) {
                        elementOrder2 = 1;
                    } else if (t2.getItemTypeId().equals(ChecklistElementType.STEP.getValue())
                            || t2.getItemTypeId().equals(ChecklistElementType.PROCEDURE.getValue())
                            || t2.getItemTypeId().equals(ChecklistElementType.DATA_STEP.getValue())) {
                        elementOrder2 = 2;
                    } else {
                        elementOrder2 = 3;
                    }

                    return elementOrder1 - elementOrder2;
                }
            };

            Collections.sort(mainElements, byItemType);
            Collections.sort(childElements, byItemType);

            List<RetrieveAllChecklistElement.Datum> reOrderedElements = new ArrayList<>();
            reOrderedElements.addAll(mainElements);
            reOrderedElements.addAll(childElements);

            List<ChecklistElementsEntity> checklistElements = new ArrayList<>();
            List<CustomFieldsEntity> customFields = new ArrayList<>();
            List<StepAttributesEntity> stepAttributes = new ArrayList<>();
            List<NcwHazardsEntity> ncwHazards = new ArrayList<>();
            List<CheckListPpesEntity> stepPpes = new ArrayList<>();
            List<PlaceholderEntity> placeholders = new ArrayList<>();
            List<ItemPlaceholdersEntity> itemPlaceholders = new ArrayList<>();
            List<ResourcesLinksEntity> referenceLinks = new ArrayList<>();
            List<ResourceEntity> resources = new ArrayList<>();

            for (RetrieveAllChecklistElement.Datum element : reOrderedElements) {
                RetrieveAllChecklistElement.Item item = element.getItem();

                checklistElements.add(ModelMapper.mapChecklistElementsEntity(element));

                // Custom Fields and Step Attributes
                List<RetrieveAllChecklistElement.Attribute> attributes = item.getAttributes();

                for (RetrieveAllChecklistElement.Attribute attribute : attributes) {
                    customFields.add(ModelMapper.mapCustomField(
                            attribute.getCustomField(),
                            element.getUpdatedAt()
                    ));

                    stepAttributes.add(ModelMapper.mapStepAttributes(
                            attribute,
                            element.getUpdatedAt()
                    ));
                }

                // NCW Hazards
                List<RetrieveAllChecklistElement.Item.Hazards> hazards = item.getHazards();

                for (RetrieveAllChecklistElement.Item.Hazards hazard : hazards) {
                    ncwHazards.add(ModelMapper.mapNCWHazards(
                            hazard,
                            item.getId(),
                            element.getItemTypeId()
                    ));
                }

                // Step PPEs
                List<RetrieveAllChecklistElement.Item.Ppes> ppes = item.getPpes();

                for (RetrieveAllChecklistElement.Item.Ppes ppe : ppes) {
                    stepPpes.add(ModelMapper.mapChecklistPeps(
                            ppe,
                            item.getId()
                    ));
                }

                // Placeholders and ItemPlaceholders
                List<RetrieveAllChecklistElement.Item.Placeholder> elementPlaceholders = item.getPlaceholders();

                for (RetrieveAllChecklistElement.Item.Placeholder placeholder : elementPlaceholders) {
                    if (placeholder.getPlaceholder() != null) {
                        placeholders.add(ModelMapper.mapPlaceholder(placeholder.getPlaceholder()));
                    }

                    itemPlaceholders.add(ModelMapper.mapItemPlaceholder(
                            placeholder,
                            element.getUpdatedAt()
                    ));
                }

                // Reference Links
                List<RetrieveAllChecklistElement.Item.ReferenceLink> elementReferenceLinks = item.getReferenceLinks();

                for (RetrieveAllChecklistElement.Item.ReferenceLink referenceLink : elementReferenceLinks) {
                    referenceLinks.add(ModelMapper.mapReferanceLinks(
                            referenceLink,
                            element.getItemTypeId(),
                            item.getId(),
                            element.getUpdatedAt()
                    ));
                }

                // Resources
                if (element.getItemTypeId().equals(ChecklistElementType.RESOURCE.getValue())) {
                    resources.add(ModelMapper.mapResource(
                            item.getId(),
                            element.getItemTypeId(),
                            item.getTitle(),
                            item.getUuid(),
                            item.getDescription(),
                            element.getUpdatedAt()
                    ));
                }

                // References
                List<RetrieveAllChecklistElement.Item.Reference> references = item.getReferences();

                for (RetrieveAllChecklistElement.Item.Reference reference : references) {
                    resources.add(ModelMapper.mapReferances(
                            reference,
                            item.getId(),
                            element.getItemTypeId(),
                            element.getUpdatedAt()
                    ));
                }
            }

            getChecklistElementDao.insertChecklistElementsWithAssociatedDate(
                    checklistId,
                    checklistElements,
                    customFields,
                    stepAttributes,
                    ncwHazards,
                    stepPpes,
                    placeholders,
                    itemPlaceholders,
                    referenceLinks,
                    resources
            );
        }
    }

    private void saveAssignedChecklistData(String uuid, ReteriveAssignedChecklistDetail reteriveAssignedChecklistDetail) {
        if (reteriveAssignedChecklistDetail != null && reteriveAssignedChecklistDetail.getData() != null) {
            AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
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

                if (checklistExistLocally.getExecutionStatus() == -1) {
                    getSynchronizationDao.updateAssignedChecklistSyncStatus(assignedChecklistUuid);
                }

                if (updateCount > 0) {

                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(Parameters.TAG, uuid);
            }
        }
    }
}
