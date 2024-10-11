package com.icarus.synchronization.workers;

import com.icarus.activities.DashboardActivity;
import com.icarus.base.BaseApplication;
import com.icarus.constants.Constants;
import com.icarus.dao.GetChecklistElementDao;
import com.icarus.dao.GetSynchronizationDao;
import com.icarus.database.AppDatabase;
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.StepAttributesEntity;
import com.icarus.enums.ChecklistElementType;
import com.icarus.synchronization.InternetConnectionListener;
import com.icarus.synchronization.ModelMapper;
import com.icarus.synchronization.Parameters;
import com.icarus.synchronization.Utils;
import com.icarus.synchronization.api.ChecklistElementsApi;
import com.icarus.synchronization.syncmodels.RetrieveAllChecklistElement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import c.anurag.network.subscriber.AbstractNetworkObservable;

public class ChecklistElementWork extends CommonWorker {

    public ChecklistElementWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Intent intent = new Intent(DashboardActivity.TAG);
        intent.putExtra(DashboardActivity.SYNC_PERCENTAGE, DashboardActivity.SYNC_MASTER_PERCENTAGE);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        final GetSynchronizationDao getSynchronizationDao = appDatabase.getSynchronizationDao();
        List<Integer> latestChecklists = getSynchronizationDao.getLatestChecklists(BaseApplication.getPreferenceManager().getUserLocationId());
        if (latestChecklists.size() > 0) {
            for (int i = 0; i < latestChecklists.size(); i++)
                fetchDetail(latestChecklists.get(i), getApplicationContext(), this);
        }
        return Result.success();
    }

    public static synchronized void fetchDetail(final Integer checklistId, final Context context, InternetConnectionListener connectionListener) {
        RetroCacheUtils.getRetrofitInstance(context, connectionListener)
                .create(ChecklistElementsApi.class)
                .checklistChecklistElementIndex(Constants.HEADER_ACCEPT, checklistId + "", "item")
                .subscribe(new AbstractNetworkObservable<RetrieveAllChecklistElement>() {
            @SuppressLint("NewApi")
            @Override
            public void success(RetrieveAllChecklistElement retrieveAllChecklistElement) {
                AppDatabase appDatabase = AppDatabase.getInstance(context);
                final GetChecklistElementDao getChecklistElementDao = appDatabase.getChecklistElementDao();

                if (retrieveAllChecklistElement != null
                        && retrieveAllChecklistElement.getData() != null
                        && retrieveAllChecklistElement.getData().size() > 0) {
                    List<RetrieveAllChecklistElement.Datum> elements = retrieveAllChecklistElement.getData();
                    List<RetrieveAllChecklistElement.Datum> mainElements = new ArrayList<>();
                    List<RetrieveAllChecklistElement.Datum> childElements = new ArrayList<>();

                    for (RetrieveAllChecklistElement.Datum element: elements) {
                        if (element.getParentId() == null) {
                            mainElements.add(element);
                        } else {
                            childElements.add(element);
                        }
                    }

                    Comparator<RetrieveAllChecklistElement.Datum> byParentId = new Comparator<RetrieveAllChecklistElement.Datum>() {
                        @Override
                        public int compare(RetrieveAllChecklistElement.Datum t1, RetrieveAllChecklistElement.Datum t2) {
                            int parentId1 = t1.getParentId() == null ? 0 : 1;
                            int parentId2 = t2.getParentId() == null ? 0 : 1;

                            return parentId1 - parentId2;
                        }
                    };

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

                    Comparator<RetrieveAllChecklistElement.Datum> bySortOrder = new Comparator<RetrieveAllChecklistElement.Datum>() {
                        @Override
                        public int compare(RetrieveAllChecklistElement.Datum t1, RetrieveAllChecklistElement.Datum t2) {
                            return t1.getSortOrder() - t2.getSortOrder();
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

                    for (RetrieveAllChecklistElement.Datum element: reOrderedElements) {
                        RetrieveAllChecklistElement.Item item = element.getItem();

                        checklistElements.add(ModelMapper.mapChecklistElementsEntity(element));

                        // Custom Fields and Step Attributes
                        List<RetrieveAllChecklistElement.Attribute> attributes = item.getAttributes();

                        for (RetrieveAllChecklistElement.Attribute attribute: attributes) {
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

                        for (RetrieveAllChecklistElement.Item.Hazards hazard: hazards) {
                            ncwHazards.add(ModelMapper.mapNCWHazards(
                               hazard,
                               item.getId(),
                               element.getItemTypeId()
                            ));
                        }

                        // Step PPEs
                        List<RetrieveAllChecklistElement.Item.Ppes> ppes = item.getPpes();

                        for (RetrieveAllChecklistElement.Item.Ppes ppe: ppes) {
                            stepPpes.add(ModelMapper.mapChecklistPeps(
                                    ppe,
                                    item.getId()
                            ));
                        }

                        // Placeholders and ItemPlaceholders
                        List<RetrieveAllChecklistElement.Item.Placeholder> elementPlaceholders = item.getPlaceholders();

                        for (RetrieveAllChecklistElement.Item.Placeholder placeholder: elementPlaceholders) {
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

                        for (RetrieveAllChecklistElement.Item.ReferenceLink referenceLink: elementReferenceLinks) {
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

                        for (RetrieveAllChecklistElement.Item.Reference reference: references) {
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
                } else {
                    getChecklistElementDao.updateChecklistSyncStatus(checklistId, Constants.SYNC_STATUS_CHECKLIST_FULLY_SYNCED);
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.e(Parameters.TAG, "Checklist ID " + checklistId + " could not be saved due to " + error.getMessage());
            }
        });
    }
}
