package com.icarus.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.icarus.constants.Constants;
import com.icarus.database.SyncQueries;
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.StepAttributesEntity;

import java.util.List;

@Dao
public abstract class GetChecklistElementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertChecklistElements(List<ChecklistElementsEntity> checklistElements);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertCustomFields(List<CustomFieldsEntity> customFields);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertStepAttributes(List<StepAttributesEntity> stepAttributes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertNCWHazard(NcwHazardsEntity ncwHazard);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertNCWHazards(List<NcwHazardsEntity> ncwHazards);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertChecklistPpe(CheckListPpesEntity checkListPpe);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertChecklistPpes(List<CheckListPpesEntity> checkListPpes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertReferenceLinks(List<ResourcesLinksEntity> referenceLinks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertItemPlaceholders(List<ItemPlaceholdersEntity> itemPlaceholders);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertPlaceholders(List<PlaceholderEntity> placeholders);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertResources(List<ResourceEntity> resource);

    @Query(SyncQueries.QUERY_CHECK_IF_CHECKLIST_PPE_EXIST)
    abstract CheckListPpesEntity checkIfChecklistPpesExists(Integer stepId, Integer ppeId);

    @Query(SyncQueries.QUERY_CHECK_IF_NCW_HAZARDS_EXIST)
    abstract NcwHazardsEntity checkIfNcwHazardsExists(Integer itemTypeId, Integer itemId, Integer hazardId);

    @Query(SyncQueries.UPDATE_SYNC_CHECKLIST_STATUS)
    public abstract void updateChecklistSyncStatus(Integer checklistID, Integer syncStatus);

    @Query(SyncQueries.UPDATE_SYNC_CHECKLIST_PENDING_REFERENCE_COUNT)
    abstract void updateChecklistPendingReferenceCount(Integer checklistId);

    @Query(SyncQueries.UPDATE_SYNC_CHECKLIST_PENDING_RESOURCE_COUNT)
    abstract void updateChecklistPendingResourceCount(Integer checklistId);

    @Transaction
    public void insertChecklistElementsWithAssociatedDate(
            Integer checklistId,
            List<ChecklistElementsEntity> checklistElements,
            List<CustomFieldsEntity> customFields,
            List<StepAttributesEntity> stepAttributes,
            List<NcwHazardsEntity> ncwHazards,
            List<CheckListPpesEntity> stepPpes,
            List<PlaceholderEntity> placeholders,
            List<ItemPlaceholdersEntity> itemPlaceholders,
            List<ResourcesLinksEntity> referenceLinks,
            List<ResourceEntity> resources
    ) {
        insertChecklistElements(checklistElements);

        insertCustomFields(customFields);
        insertStepAttributes(stepAttributes);

        for (NcwHazardsEntity ncwHazard: ncwHazards) {
            NcwHazardsEntity entity = checkIfNcwHazardsExists(
                    ncwHazard.getItem_type_id(),
                    ncwHazard.getItem_id(),
                    ncwHazard.getHazard_id()
            );

            if (entity == null) {
                insertNCWHazard(ncwHazard);
            }
        }

        for (CheckListPpesEntity stepPpe: stepPpes) {
            CheckListPpesEntity entity = checkIfChecklistPpesExists(
                    stepPpe.getStep_id(),
                    stepPpe.getPpe_id()
            );

            if (entity == null) {
                insertChecklistPpe(stepPpe);
            }
        }


        insertPlaceholders(placeholders);
        insertItemPlaceholders(itemPlaceholders);

        insertReferenceLinks(referenceLinks);
        insertResources(resources);

        updateChecklistSyncStatus(checklistId, Constants.SYNC_STATUS_CHECKLIST_FULLY_SYNCED);
        updateChecklistPendingResourceCount(checklistId);
        updateChecklistPendingReferenceCount(checklistId);
    }
}
