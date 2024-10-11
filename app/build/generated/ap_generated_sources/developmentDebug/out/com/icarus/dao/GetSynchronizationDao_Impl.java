package com.icarus.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AllChecklistEntity;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedItemPlaceholderEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.AsssignedDepartmentsEntity;
import com.icarus.entities.CheckListLogoEntity;
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.CheckListTitlesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.ChecklistExecutionPermission;
import com.icarus.entities.ChecklistLocationEntity;
import com.icarus.entities.ChecklistRoomEquipmentsEntity;
import com.icarus.entities.ChecklistStatusEntity;
import com.icarus.entities.ChecklistTypeEntity;
import com.icarus.entities.ClientLogoEntity;
import com.icarus.entities.ClientSettingEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.DepartmentsEntity;
import com.icarus.entities.EquipmentsEntity;
import com.icarus.entities.GroupEntity;
import com.icarus.entities.HazardsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.ItemTypeEntity;
import com.icarus.entities.LocationDepartmentsEntity;
import com.icarus.entities.LocationEntity;
import com.icarus.entities.LocationEquipmentsEntity;
import com.icarus.entities.LocationRoomEntity;
import com.icarus.entities.LocationRoomEquipmentsEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PepesEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.QRStorageEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.RoomsEntity;
import com.icarus.entities.StepAttributesEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.entities.UserLocationsDepartments;
import com.icarus.entities.UsersEntity;
import com.icarus.entities.WorkOrdeStatusEntity;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderBillingTypeEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.models.ResourceDownloadItems;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GetSynchronizationDao_Impl extends GetSynchronizationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChecklistStatusEntity> __insertionAdapterOfChecklistStatusEntity;

  private final EntityInsertionAdapter<DepartmentsEntity> __insertionAdapterOfDepartmentsEntity;

  private final EntityInsertionAdapter<ChecklistTypeEntity> __insertionAdapterOfChecklistTypeEntity;

  private final EntityInsertionAdapter<ClientSettingEntity> __insertionAdapterOfClientSettingEntity;

  private final EntityInsertionAdapter<ItemTypeEntity> __insertionAdapterOfItemTypeEntity;

  private final EntityInsertionAdapter<PepesEntity> __insertionAdapterOfPepesEntity;

  private final EntityInsertionAdapter<ChecklistExecutionPermission> __insertionAdapterOfChecklistExecutionPermission;

  private final EntityInsertionAdapter<WorkOrdeStatusEntity> __insertionAdapterOfWorkOrdeStatusEntity;

  private final EntityInsertionAdapter<AllChecklistEntity> __insertionAdapterOfAllChecklistEntity;

  private final EntityInsertionAdapter<EquipmentsEntity> __insertionAdapterOfEquipmentsEntity;

  private final EntityInsertionAdapter<GroupEntity> __insertionAdapterOfGroupEntity;

  private final EntityInsertionAdapter<HazardsEntity> __insertionAdapterOfHazardsEntity;

  private final EntityInsertionAdapter<LocationRoomEquipmentsEntity> __insertionAdapterOfLocationRoomEquipmentsEntity;

  private final EntityInsertionAdapter<LocationDepartmentsEntity> __insertionAdapterOfLocationDepartmentsEntity;

  private final EntityInsertionAdapter<LocationEntity> __insertionAdapterOfLocationEntity;

  private final EntityInsertionAdapter<UsersEntity> __insertionAdapterOfUsersEntity;

  private final EntityInsertionAdapter<UserLocationsDepartments> __insertionAdapterOfUserLocationsDepartments;

  private final EntityInsertionAdapter<UserFavouritesEntity> __insertionAdapterOfUserFavouritesEntity;

  private final EntityInsertionAdapter<ClientLogoEntity> __insertionAdapterOfClientLogoEntity;

  private final EntityInsertionAdapter<ChecklistLocationEntity> __insertionAdapterOfChecklistLocationEntity;

  private final EntityInsertionAdapter<ChecklistElementsEntity> __insertionAdapterOfChecklistElementsEntity;

  private final EntityInsertionAdapter<StepAttributesEntity> __insertionAdapterOfStepAttributesEntity;

  private final EntityInsertionAdapter<NcwHazardsEntity> __insertionAdapterOfNcwHazardsEntity;

  private final EntityInsertionAdapter<CheckListPpesEntity> __insertionAdapterOfCheckListPpesEntity;

  private final EntityInsertionAdapter<AssignCheckListEntity> __insertionAdapterOfAssignCheckListEntity;

  private final EntityInsertionAdapter<AssignedLogoEntity> __insertionAdapterOfAssignedLogoEntity;

  private final EntityInsertionAdapter<AssignRoomEquipmentsEntity> __insertionAdapterOfAssignRoomEquipmentsEntity;

  private final EntityInsertionAdapter<AssignedNCWEntity> __insertionAdapterOfAssignedNCWEntity;

  private final EntityInsertionAdapter<AssignedChecklistCommentsEntity> __insertionAdapterOfAssignedChecklistCommentsEntity;

  private final EntityInsertionAdapter<AssignedCheckListPauseTimesEntity> __insertionAdapterOfAssignedCheckListPauseTimesEntity;

  private final EntityInsertionAdapter<AssignedDecisionEntity> __insertionAdapterOfAssignedDecisionEntity;

  private final EntityInsertionAdapter<AsssignedDepartmentsEntity> __insertionAdapterOfAsssignedDepartmentsEntity;

  private final EntityInsertionAdapter<AssignedItemPlaceholderEntity> __insertionAdapterOfAssignedItemPlaceholderEntity;

  private final EntityInsertionAdapter<AssignedStepAttributesEntity> __insertionAdapterOfAssignedStepAttributesEntity;

  private final EntityInsertionAdapter<AssignedStepFileResourceEntity> __insertionAdapterOfAssignedStepFileResourceEntity;

  private final EntityInsertionAdapter<AssignedStepEntity> __insertionAdapterOfAssignedStepEntity;

  private final EntityInsertionAdapter<AssignedUserEntity> __insertionAdapterOfAssignedUserEntity;

  private final EntityInsertionAdapter<RoomsEntity> __insertionAdapterOfRoomsEntity;

  private final EntityInsertionAdapter<LogsEntity> __insertionAdapterOfLogsEntity;

  private final EntityInsertionAdapter<ResourcesLinksEntity> __insertionAdapterOfResourcesLinksEntity;

  private final EntityInsertionAdapter<ItemPlaceholdersEntity> __insertionAdapterOfItemPlaceholdersEntity;

  private final EntityInsertionAdapter<PlaceholderEntity> __insertionAdapterOfPlaceholderEntity;

  private final EntityInsertionAdapter<ResourceEntity> __insertionAdapterOfResourceEntity;

  private final EntityInsertionAdapter<CheckListLogoEntity> __insertionAdapterOfCheckListLogoEntity;

  private final EntityInsertionAdapter<ChecklistRoomEquipmentsEntity> __insertionAdapterOfChecklistRoomEquipmentsEntity;

  private final EntityInsertionAdapter<CheckListTitlesEntity> __insertionAdapterOfCheckListTitlesEntity;

  private final EntityInsertionAdapter<CustomFieldsEntity> __insertionAdapterOfCustomFieldsEntity;

  private final EntityInsertionAdapter<WorkOrderBillingTypeEntity> __insertionAdapterOfWorkOrderBillingTypeEntity;

  private final EntityInsertionAdapter<WorkOrderEntity> __insertionAdapterOfWorkOrderEntity;

  private final EntityInsertionAdapter<WorkOrderEntity> __insertionAdapterOfWorkOrderEntity_1;

  private final EntityInsertionAdapter<WorkOrderAttachmentsEntity> __insertionAdapterOfWorkOrderAttachmentsEntity;

  private final EntityInsertionAdapter<WorkOrderAttachmentsEntity> __insertionAdapterOfWorkOrderAttachmentsEntity_1;

  private final EntityInsertionAdapter<WorkOrderNotesEntity> __insertionAdapterOfWorkOrderNotesEntity;

  private final EntityInsertionAdapter<WorkOrderNotesEntity> __insertionAdapterOfWorkOrderNotesEntity_1;

  private final EntityInsertionAdapter<WorkOrderNoteDetailEntity> __insertionAdapterOfWorkOrderNoteDetailEntity;

  private final EntityInsertionAdapter<WorkOrderNoteDetailEntity> __insertionAdapterOfWorkOrderNoteDetailEntity_1;

  private final EntityInsertionAdapter<LocationRoomEntity> __insertionAdapterOfLocationRoomEntity;

  private final EntityInsertionAdapter<LocationEquipmentsEntity> __insertionAdapterOfLocationEquipmentsEntity;

  private final EntityInsertionAdapter<QRStorageEntity> __insertionAdapterOfQRStorageEntity;

  private final EntityDeletionOrUpdateAdapter<WorkOrderEntity> __updateAdapterOfWorkOrderEntity;

  private final EntityDeletionOrUpdateAdapter<WorkOrderAttachmentsEntity> __updateAdapterOfWorkOrderAttachmentsEntity;

  private final EntityDeletionOrUpdateAdapter<WorkOrderNotesEntity> __updateAdapterOfWorkOrderNotesEntity;

  private final EntityDeletionOrUpdateAdapter<WorkOrderNoteDetailEntity> __updateAdapterOfWorkOrderNoteDetailEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateResources;

  private final SharedSQLiteStatement __preparedStmtOfUpdateClientLogo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChecklistSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateResourceSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReferenceSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChecklistPendingReferenceCount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChecklistPendingResourceCount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWorkorderExecutionStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReferenceChecklistStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateResourceChecklistStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteQRStorage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSyncedWorkorderAttachment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSyncedWorkorderNoteDetail;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSyncedWorkorderNote;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSyncedWorkorder;

  public GetSynchronizationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChecklistStatusEntity = new EntityInsertionAdapter<ChecklistStatusEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_statuses` (`description`,`edit_allowed`,`id`,`is_closed`,`is_default`,`is_deleted`,`is_expired`,`modified`,`name`,`sort_order`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChecklistStatusEntity value) {
        if (value.getDescription() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDescription());
        }
        if (value.getEditAllowed() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getEditAllowed());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
        if (value.getIsClosed() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getIsClosed());
        }
        if (value.getIsDefault() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIsDefault());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIsDeleted());
        }
        if (value.getIsExpired() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getIsExpired());
        }
        if (value.getModified() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getModified());
        }
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
        if (value.getSortOrder() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getSortOrder());
        }
      }
    };
    this.__insertionAdapterOfDepartmentsEntity = new EntityInsertionAdapter<DepartmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `departments` (`id`,`uuid`,`name`,`short_name`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DepartmentsEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        if (value.shortName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.shortName);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
      }
    };
    this.__insertionAdapterOfChecklistTypeEntity = new EntityInsertionAdapter<ChecklistTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_types` (`id`,`uuid`,`type`,`description`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChecklistTypeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIsDeleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfClientSettingEntity = new EntityInsertionAdapter<ClientSettingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `client_settings` (`id`,`uuid`,`name`,`value`,`created`,`modified`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClientSettingEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getValue() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getValue());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfItemTypeEntity = new EntityInsertionAdapter<ItemTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_types` (`id`,`uuid`,`description`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemTypeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
      }
    };
    this.__insertionAdapterOfPepesEntity = new EntityInsertionAdapter<PepesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ppes` (`id`,`uuid`,`label`,`icon`,`status`,`modified`,`file_md5_checksum`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PepesEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLabel());
        }
        if (value.getIcon() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIcon());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getStatus());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
        if (value.getFileMd5Checksum() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFileMd5Checksum());
        }
      }
    };
    this.__insertionAdapterOfChecklistExecutionPermission = new EntityInsertionAdapter<ChecklistExecutionPermission>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_execution_permissions` (`id`,`group_id`,`checklist_type_id`,`checklist_status_id`,`is_assignable`,`is_executable`,`modified`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChecklistExecutionPermission value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getGroup_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getGroup_id());
        }
        if (value.getChecklist_type_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklist_type_id());
        }
        if (value.getChecklist_status_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getChecklist_status_id());
        }
        if (value.getIs_assignable() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIs_assignable());
        }
        if (value.getIs_executable() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIs_executable());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfWorkOrdeStatusEntity = new EntityInsertionAdapter<WorkOrdeStatusEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `workorder_statuses` (`id`,`is_default`,`name`,`modified`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrdeStatusEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIsDefault() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIsDefault());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getModified() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfAllChecklistEntity = new EntityInsertionAdapter<AllChecklistEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklists` (`id`,`pending_resources_count`,`pending_references_count`,`checklist_placeholder_count`,`assigned_to_id`,`author_id`,`checklist_status_id`,`checklist_type_id`,`department_id`,`due_at`,`estimate_hours`,`is_approval_required`,`is_deleted`,`is_sequential`,`is_template`,`modified`,`parent_id`,`uuid`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AllChecklistEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.pendingResourcesCount == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.pendingResourcesCount);
        }
        if (value.pendingReferencesCount == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.pendingReferencesCount);
        }
        if (value.placeholderCount == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.placeholderCount);
        }
        if (value.assignedToId == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.assignedToId);
        }
        if (value.authorId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.authorId);
        }
        if (value.checklistStatusId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.checklistStatusId);
        }
        if (value.checklistTypeId == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.checklistTypeId);
        }
        if (value.departmentId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.departmentId);
        }
        if (value.dueAt == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.dueAt);
        }
        if (value.estimateHours == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.estimateHours);
        }
        if (value.isApprovalRequired == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.isApprovalRequired);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.isDeleted);
        }
        if (value.isSequential == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.isSequential);
        }
        if (value.isTemplate == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.isTemplate);
        }
        if (value.modified == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.modified);
        }
        if (value.parentId == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.parentId);
        }
        if (value.uuid == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.uuid);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.syncStatus);
        }
      }
    };
    this.__insertionAdapterOfEquipmentsEntity = new EntityInsertionAdapter<EquipmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `equipments` (`id`,`is_default`,`is_deleted`,`modified`,`name`,`uuid`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EquipmentsEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.isDefault == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.isDefault);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.modified);
        }
        if (value.name == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.name);
        }
        if (value.uuid == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfGroupEntity = new EntityInsertionAdapter<GroupEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `groups` (`id`,`name`,`modified`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GroupEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getModified() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfHazardsEntity = new EntityInsertionAdapter<HazardsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `hazards` (`id`,`uuid`,`label`,`icon`,`modified`,`file_md5_checksum`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HazardsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLabel());
        }
        if (value.getIcon() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIcon());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getFileMd5Checksum() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFileMd5Checksum());
        }
      }
    };
    this.__insertionAdapterOfLocationRoomEquipmentsEntity = new EntityInsertionAdapter<LocationRoomEquipmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `location_room_equipments` (`id`,`location_id`,`room_id`,`equipment_id`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationRoomEquipmentsEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.locationId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.locationId);
        }
        if (value.roomId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.roomId);
        }
        if (value.equipmentId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.equipmentId);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
      }
    };
    this.__insertionAdapterOfLocationDepartmentsEntity = new EntityInsertionAdapter<LocationDepartmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `location_departments` (`id`,`location_id`,`department_id`,`is_deleted`,`modified`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationDepartmentsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getLocation_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getLocation_id());
        }
        if (value.getDepartment_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getDepartment_id());
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getIs_deleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfLocationEntity = new EntityInsertionAdapter<LocationEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `locations` (`id`,`name`,`timezone`,`last_sync_time`,`last_sync_status`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getTimezone() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTimezone());
        }
        if (value.getLastSyncTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastSyncTime());
        }
        if (value.getLastSyncStatus() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getLastSyncStatus());
        }
      }
    };
    this.__insertionAdapterOfUsersEntity = new EntityInsertionAdapter<UsersEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`account_uuid`,`business_name`,`email`,`full_name`,`group_id`,`id`,`is_administrator`,`is_deleted`,`last_location_id`,`modified`,`password`,`username`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UsersEntity value) {
        if (value.accountUuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.accountUuid);
        }
        if (value.businessName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.businessName);
        }
        if (value.email == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.email);
        }
        if (value.fullName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.fullName);
        }
        if (value.groupId == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.groupId);
        }
        if (value.id == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.id);
        }
        if (value.isAdministrator == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.isAdministrator);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.isDeleted);
        }
        if (value.lastLocationId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.lastLocationId);
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.password == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.password);
        }
        if (value.username == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.username);
        }
        if (value.uuid == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfUserLocationsDepartments = new EntityInsertionAdapter<UserLocationsDepartments>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user_location_departments` (`user_id`,`id`,`is_deleted`,`location_id`,`modified`,`created`,`department_id`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserLocationsDepartments value) {
        if (value.getUser_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getUser_id());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getIsDeleted());
        }
        if (value.getLocationId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getLocationId());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreated());
        }
        if (value.getDepartmentId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getDepartmentId());
        }
      }
    };
    this.__insertionAdapterOfUserFavouritesEntity = new EntityInsertionAdapter<UserFavouritesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user_favorites` (`uuid`,`user_id`,`checklist_id`,`is_deleted`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserFavouritesEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUserId());
        }
        if (value.getChecklistId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklistId());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getIsDeleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getSyncStatus());
        }
      }
    };
    this.__insertionAdapterOfClientLogoEntity = new EntityInsertionAdapter<ClientLogoEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `client_logos` (`created`,`file_md5_checksum`,`id`,`is_downloaded`,`modified`,`name`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClientLogoEntity value) {
        if (value.created == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.created);
        }
        if (value.fileMd5Checksum == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.fileMd5Checksum);
        }
        if (value.id == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.id);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDownloaded);
        }
        if (value.modified == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.modified);
        }
        if (value.name == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.name);
        }
        if (value.userId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfChecklistLocationEntity = new EntityInsertionAdapter<ChecklistLocationEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_locations` (`checklist_id`,`id`,`is_deleted`,`location_id`,`modified`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChecklistLocationEntity value) {
        if (value.getChecklistId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getChecklistId());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getIsDeleted());
        }
        if (value.getLocationId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getLocationId());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfChecklistElementsEntity = new EntityInsertionAdapter<ChecklistElementsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_elements` (`checklist_id`,`description`,`id`,`is_deleted`,`item_id`,`item_type_id`,`item_uuid`,`modified`,`parent_id`,`sequence_no`,`sort_order`,`title`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChecklistElementsEntity value) {
        if (value.checklistId == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.checklistId);
        }
        if (value.description == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.description);
        }
        if (value.id == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.id);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDeleted);
        }
        if (value.itemId == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.itemId);
        }
        if (value.itemTypeId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.itemTypeId);
        }
        if (value.itemUuid == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.itemUuid);
        }
        if (value.modified == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.modified);
        }
        if (value.parentId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.parentId);
        }
        if (value.sequenceNo == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.sequenceNo);
        }
        if (value.sortOrder == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.sortOrder);
        }
        if (value.title == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.title);
        }
      }
    };
    this.__insertionAdapterOfStepAttributesEntity = new EntityInsertionAdapter<StepAttributesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `step_attributes` (`id`,`uuid`,`step_id`,`custom_field_id`,`label`,`description`,`sort_order`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StepAttributesEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.stepId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.stepId);
        }
        if (value.customFieldId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.customFieldId);
        }
        if (value.label == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.label);
        }
        if (value.description == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.description);
        }
        if (value.sortOrder == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.sortOrder);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.modified);
        }
      }
    };
    this.__insertionAdapterOfNcwHazardsEntity = new EntityInsertionAdapter<NcwHazardsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ncw_hazards` (`id`,`uuid`,`item_id`,`item_type_id`,`hazard_id`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NcwHazardsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getItem_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getItem_id());
        }
        if (value.getItem_type_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getItem_type_id());
        }
        if (value.getHazard_id() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getHazard_id());
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIs_deleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfCheckListPpesEntity = new EntityInsertionAdapter<CheckListPpesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_ppes` (`id`,`ppe_id`,`step_id`,`is_deleted`,`modified`,`uuid`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CheckListPpesEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getPpe_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getPpe_id());
        }
        if (value.getStep_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getStep_id());
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getIs_deleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUuid());
        }
      }
    };
    this.__insertionAdapterOfAssignCheckListEntity = new EntityInsertionAdapter<AssignCheckListEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_checklists` (`assigned_at`,`assignee_type`,`checklist_id`,`checklist_status`,`created`,`department_id`,`due_date`,`is_deleted`,`location_id`,`modified`,`started_at`,`started_by_user_id`,`sync_status`,`user_id`,`uuid`,`execution_status`,`pending_elements_count`,`pending_resources_count`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignCheckListEntity value) {
        if (value.assignedAt == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedAt);
        }
        if (value.assigneeType == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.assigneeType);
        }
        if (value.checklistId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.checklistId);
        }
        if (value.checklistStatus == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.checklistStatus);
        }
        if (value.created == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.created);
        }
        if (value.departmentId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.departmentId);
        }
        if (value.dueDate == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.dueDate);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.isDeleted);
        }
        if (value.locationId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.locationId);
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.startedAt == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.startedAt);
        }
        if (value.startedByUserId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.startedByUserId);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.uuid);
        }
        if (value.executionStatus == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.executionStatus);
        }
        if (value.pendingElementsCount == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.pendingElementsCount);
        }
        if (value.pendingResourcesCount == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.pendingResourcesCount);
        }
      }
    };
    this.__insertionAdapterOfAssignedLogoEntity = new EntityInsertionAdapter<AssignedLogoEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_logos` (`uuid`,`assigned_checklist_uuid`,`checklist_logo_id`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedLogoEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssignedChecklistUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssignedChecklistUuid());
        }
        if (value.getChecklistLogoId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklistLogoId());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getSyncStatus());
        }
      }
    };
    this.__insertionAdapterOfAssignRoomEquipmentsEntity = new EntityInsertionAdapter<AssignRoomEquipmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_room_equipments` (`uuid`,`assigned_checklist_uuid`,`created`,`equipment_id`,`is_deleted`,`modified`,`room_id`,`sync_status`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignRoomEquipmentsEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.assignedChecklistUuid);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.equipmentId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.equipmentId);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.roomId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.roomId);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.syncStatus);
        }
      }
    };
    this.__insertionAdapterOfAssignedNCWEntity = new EntityInsertionAdapter<AssignedNCWEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_ncw` (`uuid`,`assigned_checklist_uuid`,`user_id`,`item_id`,`item_type_id`,`checklist_element_id`,`acknowledged`,`is_deleted`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedNCWEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssigned_checklist_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssigned_checklist_uuid());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUserId());
        }
        if (value.getItemId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getItemId());
        }
        if (value.getItemTypeId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getItemTypeId());
        }
        if (value.getChecklistElementId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getChecklistElementId());
        }
        if (value.getAcknowledged() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getAcknowledged());
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getIs_deleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModified());
        }
        if (value.getSync_status() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getSync_status());
        }
      }
    };
    this.__insertionAdapterOfAssignedChecklistCommentsEntity = new EntityInsertionAdapter<AssignedChecklistCommentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_checklist_comments` (`uuid`,`assigned_checklist_uuid`,`user_id`,`comment`,`is_deleted`,`created`,`modified`,`sync_status`,`checklist_id`,`checklist_element_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedChecklistCommentsEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssigned_checklist_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssigned_checklist_uuid());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUserId());
        }
        if (value.getComment() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComment());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIsDeleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getSyncStatus());
        }
        if (value.getChecklistId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getChecklistId());
        }
        if (value.getChecklistElementId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getChecklistElementId());
        }
      }
    };
    this.__insertionAdapterOfAssignedCheckListPauseTimesEntity = new EntityInsertionAdapter<AssignedCheckListPauseTimesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_checklist_pause_times` (`uuid`,`assigned_checklist_uuid`,`user_id`,`resumed_by_user_id`,`reason`,`is_paused`,`is_deleted`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedCheckListPauseTimesEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.assigned_checklist_uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.assigned_checklist_uuid);
        }
        if (value.user_id == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.user_id);
        }
        if (value.resumed_by_user_id == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.resumed_by_user_id);
        }
        if (value.reason == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.reason);
        }
        if (value.is_paused == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.is_paused);
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getIs_deleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModified());
        }
        if (value.getSync_status() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getSync_status());
        }
      }
    };
    this.__insertionAdapterOfAssignedDecisionEntity = new EntityInsertionAdapter<AssignedDecisionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_decisions` (`assigned_checklist_uuid`,`checklist_element_id`,`created`,`decision_id`,`is_deleted`,`modified`,`status`,`sync_status`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedDecisionEntity value) {
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedChecklistUuid);
        }
        if (value.checklistElementId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.checklistElementId);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.decisionId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.decisionId);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.status == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.status);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfAsssignedDepartmentsEntity = new EntityInsertionAdapter<AsssignedDepartmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_departments` (`uuid`,`assigned_checklist_uuid`,`department_id`,`is_deleted`,`modified`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AsssignedDepartmentsEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.getAssigned_checklist_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssigned_checklist_uuid());
        }
        if (value.getDepartment_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getDepartment_id());
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getIs_deleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfAssignedItemPlaceholderEntity = new EntityInsertionAdapter<AssignedItemPlaceholderEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_item_placeholders` (`uuid`,`assigned_checklist_uuid`,`checklist_element_id`,`item_placeholder_id`,`user_id`,`value`,`is_deleted`,`created`,`modified`,`foreign_key`,`model`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedItemPlaceholderEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssignedChecklistUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssignedChecklistUuid());
        }
        if (value.getChecklistElementId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklistElementId());
        }
        if (value.getItemPlaceholderId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getItemPlaceholderId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getUserId());
        }
        if (value.getValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getValue());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getIsDeleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModified());
        }
        if (value.getForeignKey() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getForeignKey());
        }
        if (value.getModel() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getModel());
        }
      }
    };
    this.__insertionAdapterOfAssignedStepAttributesEntity = new EntityInsertionAdapter<AssignedStepAttributesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_step_attributes` (`assigned_checklist_uuid`,`checklist_element_id`,`created`,`is_deleted`,`item_uuid`,`modified`,`step_attribute_id`,`step_id`,`sync_status`,`user_id`,`uuid`,`value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedStepAttributesEntity value) {
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedChecklistUuid);
        }
        if (value.checklistElementId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.checklistElementId);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDeleted);
        }
        if (value.itemUuid == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.itemUuid);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.stepAttributeId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.stepAttributeId);
        }
        if (value.stepId == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.stepId);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.uuid);
        }
        if (value.value == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.value);
        }
      }
    };
    this.__insertionAdapterOfAssignedStepFileResourceEntity = new EntityInsertionAdapter<AssignedStepFileResourceEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_step_resources` (`uuid`,`assigned_checklist_uuid`,`checklist_element_id`,`item_type_id`,`item_id`,`display_file_name`,`file_name`,`content_type`,`file_md5_checksum`,`user_id`,`is_deleted`,`created`,`modified`,`is_uploaded`,`is_downloaded`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedStepFileResourceEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssigned_checklist_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssigned_checklist_uuid());
        }
        if (value.getChecklist_element_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklist_element_id());
        }
        if (value.getItem_type_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getItem_type_id());
        }
        if (value.getItem_id() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getItem_id());
        }
        if (value.getDisplay_file_name() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDisplay_file_name());
        }
        if (value.getFile_name() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFile_name());
        }
        if (value.getContent_type() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getContent_type());
        }
        if (value.getFile_md5_checksum() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFile_md5_checksum());
        }
        if (value.getUser_id() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getUser_id());
        }
        if (value.getIs_deleted() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getIs_deleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getModified());
        }
        if (value.getIs_uploaded() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getIs_uploaded());
        }
        if (value.getIs_downloaded() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getIs_downloaded());
        }
        if (value.getSync_status() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.getSync_status());
        }
      }
    };
    this.__insertionAdapterOfAssignedStepEntity = new EntityInsertionAdapter<AssignedStepEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_steps` (`assigned_checklist_uuid`,`checklist_element_id`,`created`,`is_deleted`,`modified`,`status`,`step_id`,`sync_status`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedStepEntity value) {
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedChecklistUuid);
        }
        if (value.checklistElementId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.checklistElementId);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.modified);
        }
        if (value.status == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.status);
        }
        if (value.stepId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.stepId);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfAssignedUserEntity = new EntityInsertionAdapter<AssignedUserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `assigned_users` (`assigned_checklist_uuid`,`assigned_by`,`created`,`is_deleted`,`modified`,`sync_status`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedUserEntity value) {
        if (value.assignedCheklistUUID == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedCheklistUUID);
        }
        if (value.assignedBy == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.assignedBy);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfRoomsEntity = new EntityInsertionAdapter<RoomsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `rooms` (`id`,`uuid`,`name`,`is_default`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomsEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        if (value.isDefault == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDefault);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
      }
    };
    this.__insertionAdapterOfLogsEntity = new EntityInsertionAdapter<LogsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `logs` (`uuid`,`item_uuid`,`checklist_id`,`checklist_element_id`,`action`,`user_id`,`assigned_to`,`username`,`assigned_to_name`,`assigned_checklist_uuid`,`item_description`,`step_action`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LogsEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.itemUuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.itemUuid);
        }
        if (value.checklistId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.checklistId);
        }
        if (value.checklistElementId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.checklistElementId);
        }
        if (value.action == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.action);
        }
        if (value.userId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.userId);
        }
        if (value.assignedTo == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.assignedTo);
        }
        if (value.username == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.username);
        }
        if (value.assignedToName == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.assignedToName);
        }
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.assignedChecklistUuid);
        }
        if (value.itemDescription == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.itemDescription);
        }
        if (value.stepAction == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.stepAction);
        }
        if (value.created == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.created);
        }
        if (value.modified == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.syncStatus);
        }
      }
    };
    this.__insertionAdapterOfResourcesLinksEntity = new EntityInsertionAdapter<ResourcesLinksEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `resource_links` (`id`,`is_deleted`,`item_id`,`item_type_id`,`link`,`link_title`,`modified`,`uuid`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ResourcesLinksEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.isDeleted);
        }
        if (value.itemId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.itemId);
        }
        if (value.itemTypeId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.itemTypeId);
        }
        if (value.link == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.link);
        }
        if (value.linkTitle == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.linkTitle);
        }
        if (value.modified == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.modified);
        }
        if (value.uuid == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfItemPlaceholdersEntity = new EntityInsertionAdapter<ItemPlaceholdersEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `item_placeholders` (`id`,`item_id`,`item_type_id`,`placeholder_id`,`sort_order`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemPlaceholdersEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getItemId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getItemId());
        }
        if (value.getItemTypeId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getItemTypeId());
        }
        if (value.getPlaceholderId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getPlaceholderId());
        }
        if (value.getSortOrder() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSortOrder());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIsDeleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfPlaceholderEntity = new EntityInsertionAdapter<PlaceholderEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `placeholders` (`id`,`uuid`,`name`,`placeholder`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlaceholderEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getPlaceholder() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPlaceholder());
        }
      }
    };
    this.__insertionAdapterOfResourceEntity = new EntityInsertionAdapter<ResourceEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `resources` (`content_type`,`display_file_name`,`file_md5_checksum`,`file_name`,`id`,`file_size`,`is_deleted`,`is_downloaded`,`is_resource`,`item_id`,`item_type_id`,`modified`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ResourceEntity value) {
        if (value.contentType == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.contentType);
        }
        if (value.displayFileName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.displayFileName);
        }
        if (value.fileMd5Checksum == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.fileMd5Checksum);
        }
        if (value.fileName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.fileName);
        }
        if (value.id == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.id);
        }
        if (value.fileSize == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.fileSize);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.isDeleted);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.isDownloaded);
        }
        if (value.isResource == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.isResource);
        }
        if (value.itemId == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.itemId);
        }
        if (value.itemTypeId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.itemTypeId);
        }
        if (value.modified == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.modified);
        }
        if (value.uuid == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfCheckListLogoEntity = new EntityInsertionAdapter<CheckListLogoEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_logos` (`id`,`uuid`,`name`,`checklist_id`,`logo_type`,`file_md5_checksum`,`modified`,`is_downloaded`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CheckListLogoEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getChecklist_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getChecklist_id());
        }
        if (value.getLogo_type() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getLogo_type());
        }
        if (value.getFile_md5_checksum() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFile_md5_checksum());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
        if (value.getIs_downloaded() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getIs_downloaded());
        }
      }
    };
    this.__insertionAdapterOfChecklistRoomEquipmentsEntity = new EntityInsertionAdapter<ChecklistRoomEquipmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_room_equipments` (`id`,`checklist_location_id`,`location_room_equipment_id`,`room_id`,`equipment_id`,`is_deleted`,`modified`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChecklistRoomEquipmentsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getChecklistLocationId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getChecklistLocationId());
        }
        if (value.getLocationRoomEquipmentId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getLocationRoomEquipmentId());
        }
        if (value.getRoomId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRoomId());
        }
        if (value.getEquipmentId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getEquipmentId());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIsDeleted());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfCheckListTitlesEntity = new EntityInsertionAdapter<CheckListTitlesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `checklist_titles` (`id`,`uuid`,`checklist_id`,`title`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CheckListTitlesEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getChecklist_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklist_id());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitle());
        }
      }
    };
    this.__insertionAdapterOfCustomFieldsEntity = new EntityInsertionAdapter<CustomFieldsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `custom_fields` (`allow_description`,`allow_gallery`,`allowed_media_types`,`default_value`,`display_as`,`id`,`is_default`,`is_deleted`,`max_length`,`max_value`,`min_length`,`min_value`,`model`,`modified`,`multiple`,`name`,`possible_values`,`required`,`sort_order`,`step_attribute_count`,`type`,`user_roles`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CustomFieldsEntity value) {
        if (value.allowDescription == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.allowDescription);
        }
        if (value.allowGallery == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.allowGallery);
        }
        if (value.allowedMediaTypes == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.allowedMediaTypes);
        }
        if (value.defaultValue == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.defaultValue);
        }
        if (value.displayAs == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.displayAs);
        }
        if (value.id == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.id);
        }
        if (value.isDefault == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.isDefault);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.isDeleted);
        }
        if (value.maxLength == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.maxLength);
        }
        if (value.maxValue == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.maxValue);
        }
        if (value.minLength == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.minLength);
        }
        if (value.minValue == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.minValue);
        }
        if (value.model == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.model);
        }
        if (value.modified == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.modified);
        }
        if (value.multiple == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.multiple);
        }
        if (value.name == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.name);
        }
        if (value.possibleValues == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.possibleValues);
        }
        if (value.required == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.required);
        }
        if (value.sortOrder == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.sortOrder);
        }
        if (value.stepAttributeCount == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindLong(20, value.stepAttributeCount);
        }
        if (value.type == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.type);
        }
        if (value.userRoles == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.userRoles);
        }
        if (value.uuid == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderBillingTypeEntity = new EntityInsertionAdapter<WorkOrderBillingTypeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `workorder_billing_types` (`id`,`is_default`,`name`,`modified`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderBillingTypeEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIsDefault() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIsDefault());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getModified() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfWorkOrderEntity = new EntityInsertionAdapter<WorkOrderEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `workorders` (`id`,`uuid`,`title`,`description`,`due_date`,`workorder_status_id`,`assigned_to_id`,`assigned_to_type`,`workorder_priority_id`,`author_id`,`location_id`,`checklist_id`,`workorder_billing_type_id`,`location_equipment_id`,`location_room_id`,`start_date`,`closed_date`,`modified`,`sync_status`,`created`,`execution_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.title == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.dueDate == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.dueDate);
        }
        if (value.workorderStatusId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.workorderStatusId);
        }
        if (value.assignedToId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.assignedToId);
        }
        if (value.assignedToType == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.assignedToType);
        }
        if (value.workorderPriorityId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.workorderPriorityId);
        }
        if (value.authorId == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.authorId);
        }
        if (value.locationId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.locationId);
        }
        if (value.checklistId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.checklistId);
        }
        if (value.workorderBillingTypeId == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.workorderBillingTypeId);
        }
        if (value.locationEquipmentId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.locationEquipmentId);
        }
        if (value.locationRoomId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.locationRoomId);
        }
        if (value.startDate == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.startDate);
        }
        if (value.closedDate == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.closedDate);
        }
        if (value.modified == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.created);
        }
        if (value.executionStatus == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.executionStatus);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderEntity_1 = new EntityInsertionAdapter<WorkOrderEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorders` (`id`,`uuid`,`title`,`description`,`due_date`,`workorder_status_id`,`assigned_to_id`,`assigned_to_type`,`workorder_priority_id`,`author_id`,`location_id`,`checklist_id`,`workorder_billing_type_id`,`location_equipment_id`,`location_room_id`,`start_date`,`closed_date`,`modified`,`sync_status`,`created`,`execution_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.title == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.dueDate == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.dueDate);
        }
        if (value.workorderStatusId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.workorderStatusId);
        }
        if (value.assignedToId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.assignedToId);
        }
        if (value.assignedToType == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.assignedToType);
        }
        if (value.workorderPriorityId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.workorderPriorityId);
        }
        if (value.authorId == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.authorId);
        }
        if (value.locationId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.locationId);
        }
        if (value.checklistId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.checklistId);
        }
        if (value.workorderBillingTypeId == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.workorderBillingTypeId);
        }
        if (value.locationEquipmentId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.locationEquipmentId);
        }
        if (value.locationRoomId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.locationRoomId);
        }
        if (value.startDate == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.startDate);
        }
        if (value.closedDate == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.closedDate);
        }
        if (value.modified == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.created);
        }
        if (value.executionStatus == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.executionStatus);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderAttachmentsEntity = new EntityInsertionAdapter<WorkOrderAttachmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `workorder_attachments` (`id`,`uuid`,`workorder_id`,`display_filename`,`filename`,`filesize`,`content_type`,`author_id`,`file_md5_checksum`,`modified`,`sync_status`,`created`,`is_downloaded`,`is_uploaded`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderAttachmentsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getDisplayFileName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDisplayFileName());
        }
        if (value.getFilename() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFilename());
        }
        if (value.getFilesize() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getFilesize());
        }
        if (value.getContentType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContentType());
        }
        if (value.getAuthorId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getAuthorId());
        }
        if (value.getFileMd5Checksum() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFileMd5Checksum());
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.created);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.isDownloaded);
        }
        if (value.isUploaded == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.isUploaded);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderAttachmentsEntity_1 = new EntityInsertionAdapter<WorkOrderAttachmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorder_attachments` (`id`,`uuid`,`workorder_id`,`display_filename`,`filename`,`filesize`,`content_type`,`author_id`,`file_md5_checksum`,`modified`,`sync_status`,`created`,`is_downloaded`,`is_uploaded`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderAttachmentsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getDisplayFileName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDisplayFileName());
        }
        if (value.getFilename() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFilename());
        }
        if (value.getFilesize() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getFilesize());
        }
        if (value.getContentType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContentType());
        }
        if (value.getAuthorId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getAuthorId());
        }
        if (value.getFileMd5Checksum() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFileMd5Checksum());
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.created);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.isDownloaded);
        }
        if (value.isUploaded == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.isUploaded);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderNotesEntity = new EntityInsertionAdapter<WorkOrderNotesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `workorder_notes` (`id`,`uuid`,`workorder_id`,`user_id`,`workorder_notes`,`modified`,`sync_status`,`created`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNotesEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUserId());
        }
        if (value.getWorkorderNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWorkorderNotes());
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.created);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderNotesEntity_1 = new EntityInsertionAdapter<WorkOrderNotesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorder_notes` (`id`,`uuid`,`workorder_id`,`user_id`,`workorder_notes`,`modified`,`sync_status`,`created`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNotesEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUserId());
        }
        if (value.getWorkorderNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWorkorderNotes());
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.created);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderNoteDetailEntity = new EntityInsertionAdapter<WorkOrderNoteDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `workorder_note_details` (`id`,`uuid`,`workorder_note_id`,`property`,`property_key`,`old_value`,`value`,`modified`,`sync_status`,`created`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNoteDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderNoteId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderNoteId());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProperty());
        }
        if (value.getPropertyKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPropertyKey());
        }
        if (value.getOldValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOldValue());
        }
        if (value.getValue() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getValue());
        }
        if (value.modified == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.created);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderNoteDetailEntity_1 = new EntityInsertionAdapter<WorkOrderNoteDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorder_note_details` (`id`,`uuid`,`workorder_note_id`,`property`,`property_key`,`old_value`,`value`,`modified`,`sync_status`,`created`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNoteDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderNoteId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderNoteId());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProperty());
        }
        if (value.getPropertyKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPropertyKey());
        }
        if (value.getOldValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOldValue());
        }
        if (value.getValue() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getValue());
        }
        if (value.modified == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.created);
        }
      }
    };
    this.__insertionAdapterOfLocationRoomEntity = new EntityInsertionAdapter<LocationRoomEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `location_rooms` (`id`,`location_id`,`room_id`,`is_deleted`,`modified`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationRoomEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getLocationId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getLocationId());
        }
        if (value.getRoomId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getRoomId());
        }
        final Integer _tmp;
        _tmp = value.isDeleted() == null ? null : (value.isDeleted() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfLocationEquipmentsEntity = new EntityInsertionAdapter<LocationEquipmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `location_equipments` (`id`,`location_id`,`equipment_id`,`serial_number`,`is_deleted`,`modified`,`upc_number`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationEquipmentsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getLocationId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getLocationId());
        }
        if (value.getEquipmentId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getEquipmentId());
        }
        if (value.getSerialNumber() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSerialNumber());
        }
        final Integer _tmp;
        _tmp = value.getIsDeleted() == null ? null : (value.getIsDeleted() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
        if (value.getUpcNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUpcNumber());
        }
      }
    };
    this.__insertionAdapterOfQRStorageEntity = new EntityInsertionAdapter<QRStorageEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `qr_storage` (`id`,`uuid`,`model`,`foreign_key`,`code`,`modified`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QRStorageEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getModel() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModel());
        }
        if (value.getForeignKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getForeignKey());
        }
        if (value.getCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCode());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
      }
    };
    this.__updateAdapterOfWorkOrderEntity = new EntityDeletionOrUpdateAdapter<WorkOrderEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workorders` SET `id` = ?,`uuid` = ?,`title` = ?,`description` = ?,`due_date` = ?,`workorder_status_id` = ?,`assigned_to_id` = ?,`assigned_to_type` = ?,`workorder_priority_id` = ?,`author_id` = ?,`location_id` = ?,`checklist_id` = ?,`workorder_billing_type_id` = ?,`location_equipment_id` = ?,`location_room_id` = ?,`start_date` = ?,`closed_date` = ?,`modified` = ?,`sync_status` = ?,`created` = ?,`execution_status` = ? WHERE `uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.title == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.dueDate == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.dueDate);
        }
        if (value.workorderStatusId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.workorderStatusId);
        }
        if (value.assignedToId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.assignedToId);
        }
        if (value.assignedToType == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.assignedToType);
        }
        if (value.workorderPriorityId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.workorderPriorityId);
        }
        if (value.authorId == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.authorId);
        }
        if (value.locationId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.locationId);
        }
        if (value.checklistId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.checklistId);
        }
        if (value.workorderBillingTypeId == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.workorderBillingTypeId);
        }
        if (value.locationEquipmentId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.locationEquipmentId);
        }
        if (value.locationRoomId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.locationRoomId);
        }
        if (value.startDate == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.startDate);
        }
        if (value.closedDate == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.closedDate);
        }
        if (value.modified == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.created);
        }
        if (value.executionStatus == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.executionStatus);
        }
        if (value.uuid == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.uuid);
        }
      }
    };
    this.__updateAdapterOfWorkOrderAttachmentsEntity = new EntityDeletionOrUpdateAdapter<WorkOrderAttachmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workorder_attachments` SET `id` = ?,`uuid` = ?,`workorder_id` = ?,`display_filename` = ?,`filename` = ?,`filesize` = ?,`content_type` = ?,`author_id` = ?,`file_md5_checksum` = ?,`modified` = ?,`sync_status` = ?,`created` = ?,`is_downloaded` = ?,`is_uploaded` = ? WHERE `uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderAttachmentsEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getDisplayFileName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDisplayFileName());
        }
        if (value.getFilename() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFilename());
        }
        if (value.getFilesize() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getFilesize());
        }
        if (value.getContentType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContentType());
        }
        if (value.getAuthorId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getAuthorId());
        }
        if (value.getFileMd5Checksum() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFileMd5Checksum());
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.created);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.isDownloaded);
        }
        if (value.isUploaded == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.isUploaded);
        }
        if (value.getUuid() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getUuid());
        }
      }
    };
    this.__updateAdapterOfWorkOrderNotesEntity = new EntityDeletionOrUpdateAdapter<WorkOrderNotesEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workorder_notes` SET `id` = ?,`uuid` = ?,`workorder_id` = ?,`user_id` = ?,`workorder_notes` = ?,`modified` = ?,`sync_status` = ?,`created` = ? WHERE `uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNotesEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUserId());
        }
        if (value.getWorkorderNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWorkorderNotes());
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.created);
        }
        if (value.getUuid() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUuid());
        }
      }
    };
    this.__updateAdapterOfWorkOrderNoteDetailEntity = new EntityDeletionOrUpdateAdapter<WorkOrderNoteDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workorder_note_details` SET `id` = ?,`uuid` = ?,`workorder_note_id` = ?,`property` = ?,`property_key` = ?,`old_value` = ?,`value` = ?,`modified` = ?,`sync_status` = ?,`created` = ? WHERE `uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNoteDetailEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getWorkorderNoteId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderNoteId());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProperty());
        }
        if (value.getPropertyKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPropertyKey());
        }
        if (value.getOldValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOldValue());
        }
        if (value.getValue() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getValue());
        }
        if (value.modified == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.created);
        }
        if (value.getUuid() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUuid());
        }
      }
    };
    this.__preparedStmtOfUpdateResources = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update resources set is_downloaded = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateClientLogo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update client_logos set is_downloaded = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateChecklistSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update checklists set sync_status = ? where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists set execution_status = 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateResourceSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE checklists\n"
                + "SET pending_resources_count = pending_resources_count - (\n"
                + "\tSELECT COUNT(DISTINCT resources.file_md5_checksum)\n"
                + "\tFROM resources\n"
                + "\tLEFT JOIN checklist_elements ON (resources.id = checklist_elements.item_id AND checklist_elements.item_type_id = 10)\n"
                + "\tWHERE\n"
                + "\t\tchecklist_elements.is_deleted = 0\n"
                + "\t\tAND resources.is_deleted = 0\n"
                + "\t\tAND resources.is_resource = 1\n"
                + "\t\tAND resources.is_downloaded = 1\n"
                + "\t\tAND resources.file_md5_checksum = ?\n"
                + ")\n"
                + "WHERE\n"
                + "\tchecklists.id IN (\n"
                + "\t\tSELECT DISTINCT checklist_elements.checklist_id\n"
                + "\t\tFROM checklist_elements\n"
                + "\t\tLEFT JOIN resources ON (checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10)\n"
                + "\t\tWHERE\n"
                + "\t\t\tchecklist_elements.is_deleted = 0\n"
                + "\t\t\tAND resources.is_deleted = 0\n"
                + "\t\t\tAND resources.is_resource = 1\n"
                + "\t\t\tAND resources.is_downloaded = 1\n"
                + "\t\t\tAND resources.file_md5_checksum = ?\n"
                + "\t)\n"
                + "\tAND checklists.pending_resources_count > 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateReferenceSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE checklists\n"
                + "SET pending_references_count = pending_references_count - (\n"
                + "\tSELECT COUNT(DISTINCT resources.file_md5_checksum)\n"
                + "\tFROM resources resources\n"
                + "\tLEFT JOIN checklist_elements checklist_elements ON (resources.item_id = checklist_elements.item_id AND resources.item_type_id = checklist_elements.item_type_id)\n"
                + "\tWHERE\n"
                + "\t\tchecklist_elements.is_deleted = 0\n"
                + "\t\tAND resources.is_deleted = 0\n"
                + "\t\tAND resources.is_resource = 0\n"
                + "\t\tAND resources.is_downloaded = 1\n"
                + "\t\tAND resources.file_md5_checksum = ?\n"
                + ")\n"
                + "WHERE\n"
                + "\tchecklists.id IN (\n"
                + "\t\tSELECT DISTINCT checklist_elements.checklist_id\n"
                + "\t\tFROM checklist_elements\n"
                + "\t\tLEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id)\n"
                + "\t\tWHERE\n"
                + "\t\t\tchecklist_elements.is_deleted = 0\n"
                + "\t\t\tAND resources.is_deleted = 0\n"
                + "\t\t\tAND resources.is_resource = 0\n"
                + "\t\t\tAND resources.is_downloaded = 1\n"
                + "\t\t\tAND resources.file_md5_checksum = ?\n"
                + "\t)\n"
                + "\tAND checklists.pending_references_count > 0";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateChecklistPendingReferenceCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE checklists\n"
                + "SET pending_references_count = (\n"
                + "  SELECT count(DISTINCT resources.file_md5_checksum) \n"
                + "  FROM checklist_elements \n"
                + "  LEFT JOIN resources ON (checklist_elements.item_id = resources.item_id AND checklist_elements.item_type_id = resources.item_type_id)\n"
                + "  WHERE \n"
                + "  checklist_elements.checklist_id = ?\n"
                + "  AND checklist_elements.is_deleted = 0 \n"
                + "  AND resources.is_resource = 0 \n"
                + "  AND resources.is_deleted = 0 \n"
                + "  AND resources.is_downloaded = 0\n"
                + ")\n"
                + "WHERE\n"
                + "\tchecklists.id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateChecklistPendingResourceCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE checklists\n"
                + "SET pending_resources_count = (\n"
                + "  SELECT count(DISTINCT resources.file_md5_checksum) \n"
                + "  FROM checklist_elements \n"
                + "  LEFT JOIN resources ON (checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10)\n"
                + "  WHERE \n"
                + "  checklist_elements.checklist_id = ?\n"
                + "  AND checklist_elements.is_deleted = 0 \n"
                + "  AND resources.is_resource = 1\n"
                + "  AND resources.is_deleted = 0 \n"
                + "  AND resources.is_downloaded = 0\n"
                + ")\n"
                + "WHERE\n"
                + "\tchecklists.id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWorkorderExecutionStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorders set execution_status = 1 where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateReferenceChecklistStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE checklists SET pending_references_count = pending_references_count - 1 WHERE id IN ( SELECT DISTINCT ChecklistElement.checklist_id FROM resources AS Resource LEFT JOIN checklist_elements AS ChecklistElement ON ( ( ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR ( ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) ) WHERE Resource.file_md5_checksum = ? AND ChecklistElement.is_deleted = 0 )";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateResourceChecklistStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE checklists SET pending_resources_count = pending_resources_count - 1 WHERE id IN (SELECT DISTINCT ChecklistElement.checklist_id FROM resources AS Resource LEFT JOIN checklist_elements AS ChecklistElement ON ( ( ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR ( ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) ) WHERE Resource.file_md5_checksum = ? AND ChecklistElement.is_deleted = 0 )";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteQRStorage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM qr_storage where id =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSyncedWorkorderAttachment = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM workorder_attachments where uuid = ? and sync_status = 0";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSyncedWorkorderNoteDetail = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM workorder_note_details where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSyncedWorkorderNote = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM workorder_notes where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSyncedWorkorder = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM workorders where id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insertChecklistStatuses(final ChecklistStatusEntity checklistStatusEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfChecklistStatusEntity.insertAndReturnId(checklistStatusEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertDepartments(final DepartmentsEntity departmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfDepartmentsEntity.insertAndReturnId(departmentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertChecklistType(final ChecklistTypeEntity checklistTypeEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfChecklistTypeEntity.insertAndReturnId(checklistTypeEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertClientSetting(final ClientSettingEntity clientSettingEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfClientSettingEntity.insertAndReturnId(clientSettingEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertItemType(final ItemTypeEntity itemTypeEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfItemTypeEntity.insertAndReturnId(itemTypeEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertPpes(final PepesEntity pepesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPepesEntity.insertAndReturnId(pepesEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertChecklistExecutionPermissions(
      final ChecklistExecutionPermission checklistExecutionPermission) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfChecklistExecutionPermission.insertAndReturnId(checklistExecutionPermission);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertWorkorderStatus(final WorkOrdeStatusEntity workOrdeStatusEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfWorkOrdeStatusEntity.insertAndReturnId(workOrdeStatusEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertChecklists(final AllChecklistEntity allChecklistEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAllChecklistEntity.insertAndReturnId(allChecklistEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertEquipments(final EquipmentsEntity equipmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfEquipmentsEntity.insertAndReturnId(equipmentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertGroups(final GroupEntity groupEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfGroupEntity.insertAndReturnId(groupEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertHazards(final HazardsEntity hazardsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfHazardsEntity.insertAndReturnId(hazardsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertLocationEquipments(
      final LocationRoomEquipmentsEntity locationRoomEquipmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfLocationRoomEquipmentsEntity.insertAndReturnId(locationRoomEquipmentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLocationRoomEquipments(
      final List<LocationRoomEquipmentsEntity> locationRoomEquipmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocationRoomEquipmentsEntity.insert(locationRoomEquipmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertLocationDepartments(final LocationDepartmentsEntity locationDepartmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfLocationDepartmentsEntity.insertAndReturnId(locationDepartmentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLocationDepartments(
      final List<LocationDepartmentsEntity> locationDepartmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocationDepartmentsEntity.insert(locationDepartmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLocations(final LocationEntity locationEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocationEntity.insert(locationEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertUserEntity(final UsersEntity usersEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUsersEntity.insertAndReturnId(usersEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertUserDepartments(final UserLocationsDepartments userLocationsDepartments) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUserLocationsDepartments.insertAndReturnId(userLocationsDepartments);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertUserFavouriteEntity(final UserFavouritesEntity userFavouritesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUserFavouritesEntity.insertAndReturnId(userFavouritesEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertClientLogo(final ClientLogoEntity clientLogoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfClientLogoEntity.insertAndReturnId(clientLogoEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertChecklistLocation(final ChecklistLocationEntity checklistLocationEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfChecklistLocationEntity.insertAndReturnId(checklistLocationEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertChecklistElements(final ChecklistElementsEntity checklistElementsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfChecklistElementsEntity.insertAndReturnId(checklistElementsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertStepAttributes(final StepAttributesEntity stepAttributesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfStepAttributesEntity.insertAndReturnId(stepAttributesEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertNCWHazards(final NcwHazardsEntity ncwHazardsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfNcwHazardsEntity.insertAndReturnId(ncwHazardsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertChecklistPeps(final CheckListPpesEntity checkListPpesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfCheckListPpesEntity.insertAndReturnId(checkListPpesEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedChecklists(final AssignCheckListEntity assignCheckListEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignCheckListEntity.insertAndReturnId(assignCheckListEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedLogoEntity(final AssignedLogoEntity assignedLogoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedLogoEntity.insertAndReturnId(assignedLogoEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedRoomEquipmentEntity(
      final AssignRoomEquipmentsEntity assignRoomEquipmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignRoomEquipmentsEntity.insertAndReturnId(assignRoomEquipmentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedNCW(final AssignedNCWEntity assignedNCWEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedNCWEntity.insertAndReturnId(assignedNCWEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssigneComments(
      final AssignedChecklistCommentsEntity assignedChecklistCommentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedChecklistCommentsEntity.insertAndReturnId(assignedChecklistCommentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedPauseTime(
      final AssignedCheckListPauseTimesEntity assignedCheckListPauseTimesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedCheckListPauseTimesEntity.insertAndReturnId(assignedCheckListPauseTimesEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssigneDecision(final AssignedDecisionEntity assignedDecisionEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedDecisionEntity.insertAndReturnId(assignedDecisionEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedDepartment(
      final AsssignedDepartmentsEntity asssignedDepartmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAsssignedDepartmentsEntity.insertAndReturnId(asssignedDepartmentsEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedPlaceholder(
      final AssignedItemPlaceholderEntity assignedItemPlaceholderEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedItemPlaceholderEntity.insertAndReturnId(assignedItemPlaceholderEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedStepAttribute(
      final AssignedStepAttributesEntity assignedStepAttributesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedStepAttributesEntity.insertAndReturnId(assignedStepAttributesEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedStepResources(
      final AssignedStepFileResourceEntity assignedStepFleResourceEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedStepFileResourceEntity.insertAndReturnId(assignedStepFleResourceEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedSteps(final AssignedStepEntity assignedStepEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedStepEntity.insertAndReturnId(assignedStepEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertAssignedUsers(final AssignedUserEntity assignedUserEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAssignedUserEntity.insertAndReturnId(assignedUserEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertRoomEntity(final RoomsEntity mapRoomsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoomsEntity.insert(mapRoomsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLogs(final LogsEntity mapLogs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLogsEntity.insert(mapLogs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertReferanceLinks(final ResourcesLinksEntity mapReferanceLinks) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResourcesLinksEntity.insert(mapReferanceLinks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertItemPlaceholder(final ItemPlaceholdersEntity mapPlaceholder) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfItemPlaceholdersEntity.insert(mapPlaceholder);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertPlaceholder(final PlaceholderEntity mapPlaceholder) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlaceholderEntity.insert(mapPlaceholder);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertReferances(final ResourceEntity mapReferances) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResourceEntity.insert(mapReferances);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChecklistLogo(final List<CheckListLogoEntity> mapChecklistLogo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCheckListLogoEntity.insert(mapChecklistLogo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChecklistRoomEquipments(
      final List<ChecklistRoomEquipmentsEntity> mapRoomEquipment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChecklistRoomEquipmentsEntity.insert(mapRoomEquipment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChecklistsTitle(final CheckListTitlesEntity mapChecklistTitleEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCheckListTitlesEntity.insert(mapChecklistTitleEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertCustomFields(final CustomFieldsEntity mapCustomField) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomFieldsEntity.insert(mapCustomField);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkorderBillingType(
      final WorkOrderBillingTypeEntity mapWorkOrderBillingTypeEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderBillingTypeEntity.insert(mapWorkOrderBillingTypeEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkorder(final WorkOrderEntity workOrderEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderEntity.insert(workOrderEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkOrder(final WorkOrderEntity workOrderEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderEntity_1.insert(workOrderEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkorderAttachment(
      final WorkOrderAttachmentsEntity workOrderAttachmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderAttachmentsEntity.insert(workOrderAttachmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkorderAttachment(
      final List<WorkOrderAttachmentsEntity> workOrderAttachmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderAttachmentsEntity.insert(workOrderAttachmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkOrderAttachments(
      final List<WorkOrderAttachmentsEntity> workOrderAttachmentEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderAttachmentsEntity_1.insert(workOrderAttachmentEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkorderNote(final WorkOrderNotesEntity workOrderNotesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderNotesEntity.insert(workOrderNotesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkOrderNotes(final List<WorkOrderNotesEntity> workOrderNotesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderNotesEntity_1.insert(workOrderNotesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkorderNoteDetail(final WorkOrderNoteDetailEntity workOrderNoteDetailEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderNoteDetailEntity.insert(workOrderNoteDetailEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkOrderNoteDetails(
      final List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderNoteDetailEntity_1.insert(workOrderNoteDetailEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLocationRooms(final LocationRoomEntity locationRoomEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocationRoomEntity.insert(locationRoomEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLocationEquipment(final LocationEquipmentsEntity locationEquipmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocationEquipmentsEntity.insert(locationEquipmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertQRStorage(final QRStorageEntity qrStorageEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQRStorageEntity.insert(qrStorageEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkOrder(final WorkOrderEntity workOrderEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkOrderEntity.handle(workOrderEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkOrderAttachments(
      final List<WorkOrderAttachmentsEntity> workOrderAttachmentEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkOrderAttachmentsEntity.handleMultiple(workOrderAttachmentEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkOrderNotes(final List<WorkOrderNotesEntity> workOrderNotesEntities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkOrderNotesEntity.handleMultiple(workOrderNotesEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkOrderNoteDetails(
      final List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWorkOrderNoteDetailEntity.handleMultiple(workOrderNoteDetailEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLocationsWithAssociatedData(final List<LocationEntity> locationEntities,
      final List<LocationDepartmentsEntity> locationDepartmentsEntities) {
    __db.beginTransaction();
    try {
      GetSynchronizationDao_Impl.super.insertLocationsWithAssociatedData(locationEntities, locationDepartmentsEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChecklistAssociatedData(final AllChecklistEntity checklist,
      final CheckListTitlesEntity checklistTitle, final List<CheckListLogoEntity> checklistLogos) {
    __db.beginTransaction();
    try {
      GetSynchronizationDao_Impl.super.insertChecklistAssociatedData(checklist, checklistTitle, checklistLogos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void saveWorkOrder(final WorkOrderEntity workOrderEntity,
      final List<WorkOrderNotesEntity> workOrderNoteEntities,
      final List<WorkOrderNoteDetailEntity> workOrderNoteDetailEntities,
      final List<WorkOrderAttachmentsEntity> workOrderAttachmentEntities) {
    __db.beginTransaction();
    try {
      GetSynchronizationDao_Impl.super.saveWorkOrder(workOrderEntity, workOrderNoteEntities, workOrderNoteDetailEntities, workOrderAttachmentEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateResources(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateResources.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateResources.release(_stmt);
    }
  }

  @Override
  public void updateClientLogo(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateClientLogo.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateClientLogo.release(_stmt);
    }
  }

  @Override
  public void updateChecklistSyncStatus(final Integer checklistID, final Integer syncStatus) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateChecklistSyncStatus.acquire();
    int _argIndex = 1;
    if (syncStatus == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, syncStatus);
    }
    _argIndex = 2;
    if (checklistID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateChecklistSyncStatus.release(_stmt);
    }
  }

  @Override
  public void updateAssignedChecklistSyncStatus(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedChecklistSyncStatus.acquire();
    int _argIndex = 1;
    if (uuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAssignedChecklistSyncStatus.release(_stmt);
    }
  }

  @Override
  public void updateResourceSyncStatus(final String checksum) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateResourceSyncStatus.acquire();
    int _argIndex = 1;
    if (checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, checksum);
    }
    _argIndex = 2;
    if (checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, checksum);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateResourceSyncStatus.release(_stmt);
    }
  }

  @Override
  public void updateReferenceSyncStatus(final String checksum) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReferenceSyncStatus.acquire();
    int _argIndex = 1;
    if (checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, checksum);
    }
    _argIndex = 2;
    if (checksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, checksum);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateReferenceSyncStatus.release(_stmt);
    }
  }

  @Override
  public void updateChecklistPendingReferenceCount(final Integer checklistId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateChecklistPendingReferenceCount.acquire();
    int _argIndex = 1;
    if (checklistId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistId);
    }
    _argIndex = 2;
    if (checklistId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateChecklistPendingReferenceCount.release(_stmt);
    }
  }

  @Override
  public void updateChecklistPendingResourceCount(final Integer checklistId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateChecklistPendingResourceCount.acquire();
    int _argIndex = 1;
    if (checklistId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistId);
    }
    _argIndex = 2;
    if (checklistId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateChecklistPendingResourceCount.release(_stmt);
    }
  }

  @Override
  public void updateWorkorderExecutionStatus(final Integer id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWorkorderExecutionStatus.acquire();
    int _argIndex = 1;
    if (id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, id);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateWorkorderExecutionStatus.release(_stmt);
    }
  }

  @Override
  public void updateReferenceChecklistStatus(final String referencesChecksum) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReferenceChecklistStatus.acquire();
    int _argIndex = 1;
    if (referencesChecksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, referencesChecksum);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateReferenceChecklistStatus.release(_stmt);
    }
  }

  @Override
  public void updateResourceChecklistStatus(final String resourceChecksum) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateResourceChecklistStatus.acquire();
    int _argIndex = 1;
    if (resourceChecksum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, resourceChecksum);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateResourceChecklistStatus.release(_stmt);
    }
  }

  @Override
  public void deleteQRStorage(final Integer qrStorageID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteQRStorage.acquire();
    int _argIndex = 1;
    if (qrStorageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, qrStorageID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteQRStorage.release(_stmt);
    }
  }

  @Override
  public void deleteSyncedWorkorderAttachment(final String oldId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSyncedWorkorderAttachment.acquire();
    int _argIndex = 1;
    if (oldId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSyncedWorkorderAttachment.release(_stmt);
    }
  }

  @Override
  public void deleteSyncedWorkorderNoteDetail(final Integer oldId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSyncedWorkorderNoteDetail.acquire();
    int _argIndex = 1;
    if (oldId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, oldId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSyncedWorkorderNoteDetail.release(_stmt);
    }
  }

  @Override
  public void deleteSyncedWorkorderNote(final Integer oldId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSyncedWorkorderNote.acquire();
    int _argIndex = 1;
    if (oldId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, oldId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSyncedWorkorderNote.release(_stmt);
    }
  }

  @Override
  public void deleteSyncedWorkorder(final Integer oldId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSyncedWorkorder.acquire();
    int _argIndex = 1;
    if (oldId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, oldId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSyncedWorkorder.release(_stmt);
    }
  }

  @Override
  public LocationEntity ifLocationExists(final Integer id) {
    final String _sql = "SELECT * FROM locations WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "timezone");
      final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "last_sync_time");
      final int _cursorIndexOfLastSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "last_sync_status");
      final LocationEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new LocationEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result.setName(_tmpName);
        final String _tmpTimezone;
        _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
        _result.setTimezone(_tmpTimezone);
        final String _tmpLastSyncTime;
        _tmpLastSyncTime = _cursor.getString(_cursorIndexOfLastSyncTime);
        _result.setLastSyncTime(_tmpLastSyncTime);
        final Integer _tmpLastSyncStatus;
        if (_cursor.isNull(_cursorIndexOfLastSyncStatus)) {
          _tmpLastSyncStatus = null;
        } else {
          _tmpLastSyncStatus = _cursor.getInt(_cursorIndexOfLastSyncStatus);
        }
        _result.setLastSyncStatus(_tmpLastSyncStatus);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getLatestChecklists(final Integer locationId) {
    final String _sql = "SELECT DISTINCT\n"
            + "   Checklist.id \n"
            + " FROM checklists AS Checklist\n"
            + "   INNER JOIN checklist_statuses AS ChecklistStatus ON ( ChecklistStatus.id = Checklist.checklist_status_id )\n"
            + "   INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n"
            + "   LEFT JOIN checklists AS NextChecklist ON ( Checklist.id = NextChecklist.parent_id )\n"
            + "   LEFT JOIN checklist_statuses AS NextChecklistStatus ON ( NextChecklistStatus.id = NextChecklist.checklist_status_id )\n"
            + "   LEFT JOIN checklist_locations AS ChecklistLocation ON (ChecklistLocation.checklist_id = Checklist.id  AND ChecklistLocation.is_deleted = 0) \n"
            + " WHERE\n"
            + "   Checklist.is_deleted = 0 \n"
            + "   AND Checklist.is_template = 0 \n"
            + "   AND ChecklistStatus.is_closed = 1 \n"
            + "   AND ChecklistLocation.location_id = ? \n"
            + "   AND (NextChecklist.modified = (SELECT max(modified) FROM checklists WHERE parent_id = Checklist.id) OR NextChecklist.modified IS NULL) \n"
            + "   AND (NextChecklistStatus.is_closed = 0 OR NextChecklistStatus.is_closed IS NULL)  AND Checklist.sync_status = 2  UNION SELECT AssignedChecklist.checklist_id  FROM assigned_checklists AS AssignedChecklist      LEFT JOIN checklists AS Checklist ON (Checklist.id = AssignedChecklist.checklist_id)    WHERE AssignedChecklist.checklist_status IN ( 0, 4 )  AND AssignedChecklist.is_deleted = 0 \n"
            + "   AND AssignedChecklist.location_id = ? AND Checklist.sync_status = 2.";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getLatestAssignedChecklists(final String modified,
      final List<Integer> status) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("select uuid from assigned_checklists where assigned_checklists.checklist_status IN (");
    final int _inputSize = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") and modified > ");
    _stringBuilder.append("?");
    _stringBuilder.append(" and execution_status = -1");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : status) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (modified == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, modified);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item_1;
        _item_1 = _cursor.getString(0);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getLatestWorkorders() {
    final String _sql = "select id from workorders where execution_status = -1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<HazardsEntity> getHazards() {
    final String _sql = "select * from hazards";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final List<HazardsEntity> _result = new ArrayList<HazardsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HazardsEntity _item;
        _item = new HazardsEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        _item.setIcon(_tmpIcon);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final String _tmpFileMd5Checksum;
        _tmpFileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFileMd5Checksum(_tmpFileMd5Checksum);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PepesEntity> getPpes() {
    final String _sql = "select * from ppes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final List<PepesEntity> _result = new ArrayList<PepesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PepesEntity _item;
        _item = new PepesEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpLabel;
        _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        _item.setLabel(_tmpLabel);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        _item.setIcon(_tmpIcon);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _item.setModified(_tmpModified);
        final String _tmpFileMd5Checksum;
        _tmpFileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.setFileMd5Checksum(_tmpFileMd5Checksum);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ClientLogoEntity> getClientLogo() {
    final String _sql = "select * from client_logos where is_downloaded = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<ClientLogoEntity> _result = new ArrayList<ClientLogoEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ClientLogoEntity _item;
        _item = new ClientLogoEntity();
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        _item.fileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _item.isDownloaded = null;
        } else {
          _item.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        _item.name = _cursor.getString(_cursorIndexOfName);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ResourceDownloadItems> getResourcesToDownload(final Integer userId) {
    final String _sql = "SELECT\n"
            + "   \tResource.id,\n"
            + "   \tResource.uuid,\n"
            + "   \tResource.file_md5_checksum,\n"
            + "   \tResource.file_name,\n"
            + "   \tResource.is_deleted,\n"
            + "   \tResource.is_resource,\n"
            + "   \tGROUP_CONCAT(DISTINCT Checklist.id) AS checklist_ids\n"
            + " FROM\n"
            + "   \tresources AS Resource\n"
            + " \tLEFT JOIN checklist_elements AS ChecklistElement ON ((ChecklistElement.item_id = Resource.id AND ChecklistElement.item_type_id = 10 AND Resource.is_resource = 1 ) OR (ChecklistElement.item_id = Resource.item_id AND ChecklistElement.item_type_id = Resource.item_type_id AND Resource.is_resource = 0 ) )\n"
            + " \tLEFT JOIN checklists AS Checklist ON ( Checklist.id = ChecklistElement.checklist_id )\n"
            + " \tLEFT JOIN user_favorites AS UserFavorite ON (UserFavorite.checklist_id = Checklist.id AND UserFavorite.user_id = ? AND UserFavorite.is_deleted = 0 ) \n"
            + " \n"
            + " WHERE\n"
            + "   \tResource.is_deleted = 0\n"
            + "   \tAND Resource.is_downloaded = 0\n"
            + "   \tAND ChecklistElement.is_deleted = 0\n"
            + "   \tAND (\n"
            + "   \tResource.is_resource = 1 \n"
            + "   \tOR (\n"
            + "   \tResource.is_resource = 0 \n"
            + "   \tAND ifnull(UserFavorite.is_deleted, 1) = 0 \n"
            + "   \t) \n"
            + "   \t)\n"
            + "GROUP BY Resource.id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfIsResource = CursorUtil.getColumnIndexOrThrow(_cursor, "is_resource");
      final int _cursorIndexOfChecklistIds = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_ids");
      final List<ResourceDownloadItems> _result = new ArrayList<ResourceDownloadItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResourceDownloadItems _item;
        _item = new ResourceDownloadItems();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        _item.fileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _item.fileName = _cursor.getString(_cursorIndexOfFileName);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfIsResource)) {
          _item.isResource = null;
        } else {
          _item.isResource = _cursor.getInt(_cursorIndexOfIsResource);
        }
        _item.checklistIds = _cursor.getString(_cursorIndexOfChecklistIds);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getNonSyncedChecklists() {
    final String _sql = "select id from checklists where sync_status = 2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CheckListPpesEntity checkIfChecklistPpesExists(final Integer stepId, final Integer ppeId) {
    final String _sql = "select * FROM checklist_ppes where ppe_id = ? and step_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (ppeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, ppeId);
    }
    _argIndex = 2;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPpeId = CursorUtil.getColumnIndexOrThrow(_cursor, "ppe_id");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final CheckListPpesEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new CheckListPpesEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Integer _tmpPpe_id;
        if (_cursor.isNull(_cursorIndexOfPpeId)) {
          _tmpPpe_id = null;
        } else {
          _tmpPpe_id = _cursor.getInt(_cursorIndexOfPpeId);
        }
        _result.setPpe_id(_tmpPpe_id);
        final Integer _tmpStep_id;
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _tmpStep_id = null;
        } else {
          _tmpStep_id = _cursor.getInt(_cursorIndexOfStepId);
        }
        _result.setStep_id(_tmpStep_id);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIs_deleted(_tmpIs_deleted);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public NcwHazardsEntity checkIfNcwHazardsExists(final Integer itemTypeId, final Integer itemId,
      final Integer hazardId) {
    final String _sql = "select * FROM ncw_hazards where item_type_id = ? and item_id = ? and hazard_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (itemTypeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemTypeId);
    }
    _argIndex = 2;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    _argIndex = 3;
    if (hazardId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, hazardId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfHazardId = CursorUtil.getColumnIndexOrThrow(_cursor, "hazard_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final NcwHazardsEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new NcwHazardsEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final Integer _tmpItem_id;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItem_id = null;
        } else {
          _tmpItem_id = _cursor.getInt(_cursorIndexOfItemId);
        }
        _result.setItem_id(_tmpItem_id);
        final Integer _tmpItem_type_id;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItem_type_id = null;
        } else {
          _tmpItem_type_id = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _result.setItem_type_id(_tmpItem_type_id);
        final Integer _tmpHazard_id;
        if (_cursor.isNull(_cursorIndexOfHazardId)) {
          _tmpHazard_id = null;
        } else {
          _tmpHazard_id = _cursor.getInt(_cursorIndexOfHazardId);
        }
        _result.setHazard_id(_tmpHazard_id);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIs_deleted(_tmpIs_deleted);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedCheckListPauseTimesEntity ifPauseTimeExists(final String uuid,
      final String assignedChecklistUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_checklist_pause_times\n"
            + "WHERE \n"
            + "    uuid = ? \n"
            + "AND assigned_checklist_uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfResumedByUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "resumed_by_user_id");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfIsPaused = CursorUtil.getColumnIndexOrThrow(_cursor, "is_paused");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final AssignedCheckListPauseTimesEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedCheckListPauseTimesEntity();
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.assigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.user_id = null;
        } else {
          _result.user_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfResumedByUserId)) {
          _result.resumed_by_user_id = null;
        } else {
          _result.resumed_by_user_id = _cursor.getInt(_cursorIndexOfResumedByUserId);
        }
        _result.reason = _cursor.getString(_cursorIndexOfReason);
        if (_cursor.isNull(_cursorIndexOfIsPaused)) {
          _result.is_paused = null;
        } else {
          _result.is_paused = _cursor.getInt(_cursorIndexOfIsPaused);
        }
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.setSync_status(_tmpSync_status);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedChecklistCommentsEntity ifCommentExists(final String uuid,
      final String assignedChecklistUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_checklist_comments\n"
            + "WHERE \n"
            + "    uuid = ? \n"
            + "AND assigned_checklist_uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final AssignedChecklistCommentsEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedChecklistCommentsEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.setUserId(_tmpUserId);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        _result.setComment(_tmpComment);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.setSyncStatus(_tmpSyncStatus);
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _result.setChecklistId(_tmpChecklistId);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.setChecklistElementId(_tmpChecklistElementId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedItemPlaceholderEntity ifPlaceholderExists(final Integer id,
      final Integer checkListElementID, final String assignedChecklistUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_item_placeholders\n"
            + "WHERE \n"
            + "    item_placeholder_id = ? \n"
            + " AND assigned_checklist_uuid = ?  AND checklist_element_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (checkListElementID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListElementID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfItemPlaceholderId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_placeholder_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfForeignKey = CursorUtil.getColumnIndexOrThrow(_cursor, "foreign_key");
      final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
      final AssignedItemPlaceholderEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedItemPlaceholderEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpAssignedChecklistUuid;
        _tmpAssignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.setAssignedChecklistUuid(_tmpAssignedChecklistUuid);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.setChecklistElementId(_tmpChecklistElementId);
        final Integer _tmpItemPlaceholderId;
        if (_cursor.isNull(_cursorIndexOfItemPlaceholderId)) {
          _tmpItemPlaceholderId = null;
        } else {
          _tmpItemPlaceholderId = _cursor.getInt(_cursorIndexOfItemPlaceholderId);
        }
        _result.setItemPlaceholderId(_tmpItemPlaceholderId);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.setUserId(_tmpUserId);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        _result.setValue(_tmpValue);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpForeignKey;
        if (_cursor.isNull(_cursorIndexOfForeignKey)) {
          _tmpForeignKey = null;
        } else {
          _tmpForeignKey = _cursor.getInt(_cursorIndexOfForeignKey);
        }
        _result.setForeignKey(_tmpForeignKey);
        final String _tmpModel;
        _tmpModel = _cursor.getString(_cursorIndexOfModel);
        _result.setModel(_tmpModel);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedStepFileResourceEntity ifStepResourceExists(final String uuid,
      final Integer checkListElementID, final String assignedChecklistUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_step_resources\n"
            + "WHERE \n"
            + "    uuid = ? \n"
            + "AND assigned_checklist_uuid = ?  AND checklist_element_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (checkListElementID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListElementID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final AssignedStepFileResourceEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedStepFileResourceEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpChecklist_element_id;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklist_element_id = null;
        } else {
          _tmpChecklist_element_id = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.setChecklist_element_id(_tmpChecklist_element_id);
        final Integer _tmpItem_type_id;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItem_type_id = null;
        } else {
          _tmpItem_type_id = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _result.setItem_type_id(_tmpItem_type_id);
        final Integer _tmpItem_id;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItem_id = null;
        } else {
          _tmpItem_id = _cursor.getInt(_cursorIndexOfItemId);
        }
        _result.setItem_id(_tmpItem_id);
        final String _tmpDisplay_file_name;
        _tmpDisplay_file_name = _cursor.getString(_cursorIndexOfDisplayFileName);
        _result.setDisplay_file_name(_tmpDisplay_file_name);
        final String _tmpFile_name;
        _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
        _result.setFile_name(_tmpFile_name);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        _result.setContent_type(_tmpContent_type);
        final String _tmpFile_md5_checksum;
        _tmpFile_md5_checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _result.setFile_md5_checksum(_tmpFile_md5_checksum);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.setUser_id(_tmpUser_id);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpIs_uploaded;
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _tmpIs_uploaded = null;
        } else {
          _tmpIs_uploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _result.setIs_uploaded(_tmpIs_uploaded);
        final Integer _tmpIs_downloaded;
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _tmpIs_downloaded = null;
        } else {
          _tmpIs_downloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        _result.setIs_downloaded(_tmpIs_downloaded);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.setSync_status(_tmpSync_status);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String customFieldType(final Integer stepAttributeId) {
    final String _sql = "SELECT    CustomField.type \n"
            + "FROM    step_attributes StepAttribute\n"
            + " INNER JOIN custom_fields CustomField ON (CustomField.id = StepAttribute.custom_field_id)\n"
            + " WHERE\n"
            + " StepAttribute.id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stepAttributeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepAttributeId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedStepAttributesEntity ifStepAttributeWithFileExists(final String uuid,
      final Integer elementId, final String value, final String assignedChecklistUuid,
      final Integer stepAttributeId) {
    final String _sql = "SELECT    * FROM    assigned_step_attributes  WHERE item_uuid = ?  AND assigned_checklist_uuid = ?  AND checklist_element_id = ?  AND step_attribute_id = ? AND value = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (elementId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, elementId);
    }
    _argIndex = 4;
    if (stepAttributeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepAttributeId);
    }
    _argIndex = 5;
    if (value == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, value);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStepAttributeId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_attribute_id");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final AssignedStepAttributesEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedStepAttributesEntity();
        _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStepAttributeId)) {
          _result.stepAttributeId = null;
        } else {
          _result.stepAttributeId = _cursor.getInt(_cursorIndexOfStepAttributeId);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _result.stepId = null;
        } else {
          _result.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.value = _cursor.getString(_cursorIndexOfValue);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedStepAttributesEntity ifStepAttributeExists(final String uuid,
      final Integer elementId, final String assignedChecklistUuid, final Integer stepAttributeId) {
    final String _sql = "SELECT    * FROM    assigned_step_attributes  WHERE item_uuid = ?  AND assigned_checklist_uuid = ?  AND checklist_element_id = ?  AND step_attribute_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (elementId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, elementId);
    }
    _argIndex = 4;
    if (stepAttributeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepAttributeId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStepAttributeId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_attribute_id");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final AssignedStepAttributesEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedStepAttributesEntity();
        _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStepAttributeId)) {
          _result.stepAttributeId = null;
        } else {
          _result.stepAttributeId = _cursor.getInt(_cursorIndexOfStepAttributeId);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _result.stepId = null;
        } else {
          _result.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.value = _cursor.getString(_cursorIndexOfValue);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedNCWEntity ifNCWExists(final String uuid, final Integer checkListElementID) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_ncw\n"
            + "WHERE \n"
            + "    assigned_checklist_uuid = ? \n"
            + "AND checklist_element_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (checkListElementID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListElementID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfAcknowledged = CursorUtil.getColumnIndexOrThrow(_cursor, "acknowledged");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final AssignedNCWEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedNCWEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.setUserId(_tmpUserId);
        final Integer _tmpItemId;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItemId = null;
        } else {
          _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        _result.setItemId(_tmpItemId);
        final Integer _tmpItemTypeId;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItemTypeId = null;
        } else {
          _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _result.setItemTypeId(_tmpItemTypeId);
        final Integer _tmpChecklistElementId;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklistElementId = null;
        } else {
          _tmpChecklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.setChecklistElementId(_tmpChecklistElementId);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIs_deleted(_tmpIs_deleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.setSync_status(_tmpSync_status);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedDecisionEntity ifDecisionExists(final String uuid,
      final Integer checkListElementID) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_decisions\n"
            + "WHERE \n"
            + "    assigned_checklist_uuid = ? \n"
            + "AND checklist_element_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (checkListElementID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListElementID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfDecisionId = CursorUtil.getColumnIndexOrThrow(_cursor, "decision_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final AssignedDecisionEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedDecisionEntity();
        _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfDecisionId)) {
          _result.decisionId = null;
        } else {
          _result.decisionId = _cursor.getInt(_cursorIndexOfDecisionId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _result.status = null;
        } else {
          _result.status = _cursor.getInt(_cursorIndexOfStatus);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedStepEntity ifStepExists(final String assignedChecklistUuid, final Integer stepId) {
    final String _sql = "SELECT    * FROM    assigned_steps WHERE    checklist_element_id = ?  AND assigned_checklist_uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepId);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfStepId = CursorUtil.getColumnIndexOrThrow(_cursor, "step_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final AssignedStepEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedStepEntity();
        _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _result.status = null;
        } else {
          _result.status = _cursor.getInt(_cursorIndexOfStatus);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _result.stepId = null;
        } else {
          _result.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignCheckListEntity ifAssignedChecklistExists(final String uuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_checklists\n"
            + "WHERE \n"
            + "    uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_at");
      final int _cursorIndexOfAssigneeType = CursorUtil.getColumnIndexOrThrow(_cursor, "assignee_type");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "department_id");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "started_at");
      final int _cursorIndexOfStartedByUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "started_by_user_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final int _cursorIndexOfPendingElementsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_elements_count");
      final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_resources_count");
      final AssignCheckListEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignCheckListEntity();
        _result.assignedAt = _cursor.getString(_cursorIndexOfAssignedAt);
        if (_cursor.isNull(_cursorIndexOfAssigneeType)) {
          _result.assigneeType = null;
        } else {
          _result.assigneeType = _cursor.getInt(_cursorIndexOfAssigneeType);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _result.checklistId = null;
        } else {
          _result.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistStatus)) {
          _result.checklistStatus = null;
        } else {
          _result.checklistStatus = _cursor.getInt(_cursorIndexOfChecklistStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfDepartmentId)) {
          _result.departmentId = null;
        } else {
          _result.departmentId = _cursor.getInt(_cursorIndexOfDepartmentId);
        }
        _result.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _result.locationId = null;
        } else {
          _result.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        _result.startedAt = _cursor.getString(_cursorIndexOfStartedAt);
        if (_cursor.isNull(_cursorIndexOfStartedByUserId)) {
          _result.startedByUserId = null;
        } else {
          _result.startedByUserId = _cursor.getInt(_cursorIndexOfStartedByUserId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _result.executionStatus = null;
        } else {
          _result.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
        if (_cursor.isNull(_cursorIndexOfPendingElementsCount)) {
          _result.pendingElementsCount = null;
        } else {
          _result.pendingElementsCount = _cursor.getInt(_cursorIndexOfPendingElementsCount);
        }
        if (_cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
          _result.pendingResourcesCount = null;
        } else {
          _result.pendingResourcesCount = _cursor.getInt(_cursorIndexOfPendingResourcesCount);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedLogoEntity ifAssignedLogoExists(final String uuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_logos\n"
            + "WHERE \n"
            + "    assigned_checklist_uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfChecklistLogoId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_logo_id");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final AssignedLogoEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedLogoEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpAssignedChecklistUuid;
        _tmpAssignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.setAssignedChecklistUuid(_tmpAssignedChecklistUuid);
        final Integer _tmpChecklistLogoId;
        if (_cursor.isNull(_cursorIndexOfChecklistLogoId)) {
          _tmpChecklistLogoId = null;
        } else {
          _tmpChecklistLogoId = _cursor.getInt(_cursorIndexOfChecklistLogoId);
        }
        _result.setChecklistLogoId(_tmpChecklistLogoId);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.setSyncStatus(_tmpSyncStatus);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignRoomEquipmentsEntity ifAssignedRoomEquipmentExists(final String uuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_room_equipments\n"
            + "WHERE \n"
            + "    assigned_checklist_uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "room_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final AssignRoomEquipmentsEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignRoomEquipmentsEntity();
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
          _result.equipmentId = null;
        } else {
          _result.equipmentId = _cursor.getInt(_cursorIndexOfEquipmentId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfRoomId)) {
          _result.roomId = null;
        } else {
          _result.roomId = _cursor.getInt(_cursorIndexOfRoomId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedUserEntity ifAssignedUserExists(final String uuid, final Integer userId) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_users\n"
            + "WHERE \n"
            + "    assigned_checklist_uuid = ?  AND user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedCheklistUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfAssignedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_by");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final AssignedUserEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedUserEntity();
        _result.assignedCheklistUUID = _cursor.getString(_cursorIndexOfAssignedCheklistUUID);
        if (_cursor.isNull(_cursorIndexOfAssignedBy)) {
          _result.assignedBy = null;
        } else {
          _result.assignedBy = _cursor.getInt(_cursorIndexOfAssignedBy);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AsssignedDepartmentsEntity ifAssignedDepartmentExists(final String uuid,
      final Integer depId) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_departments\n"
            + "WHERE \n"
            + "    assigned_checklist_uuid = ?  AND department_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    _argIndex = 2;
    if (depId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, depId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "department_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final AsssignedDepartmentsEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AsssignedDepartmentsEntity();
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        final String _tmpAssigned_checklist_uuid;
        _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        _result.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final Integer _tmpDepartment_id;
        if (_cursor.isNull(_cursorIndexOfDepartmentId)) {
          _tmpDepartment_id = null;
        } else {
          _tmpDepartment_id = _cursor.getInt(_cursorIndexOfDepartmentId);
        }
        _result.setDepartment_id(_tmpDepartment_id);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIs_deleted(_tmpIs_deleted);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserFavouritesEntity ifUserFavoriteExists(final Integer id, final Integer userId) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    user_favorites\n"
            + "WHERE \n"
            + "    checklist_id = ?  AND user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final UserFavouritesEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new UserFavouritesEntity();
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.setUserId(_tmpUserId);
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _result.setChecklistId(_tmpChecklistId);
        final Integer _tmpIsDeleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIsDeleted = null;
        } else {
          _tmpIsDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.setIsDeleted(_tmpIsDeleted);
        final String _tmpCreated;
        _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final Integer _tmpSyncStatus;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSyncStatus = null;
        } else {
          _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.setSyncStatus(_tmpSyncStatus);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WorkOrderEntity ifWorkOrderExists(final Integer workOrderId) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    workorders\n"
            + "WHERE \n"
            + "    id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, workOrderId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfWorkorderStatusId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_status_id");
      final int _cursorIndexOfAssignedToId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_id");
      final int _cursorIndexOfAssignedToType = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_type");
      final int _cursorIndexOfWorkorderPriorityId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_priority_id");
      final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "author_id");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfWorkorderBillingTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_billing_type_id");
      final int _cursorIndexOfLocationEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_equipment_id");
      final int _cursorIndexOfLocationRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_room_id");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
      final int _cursorIndexOfClosedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "closed_date");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final WorkOrderEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new WorkOrderEntity();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _result.id = null;
        } else {
          _result.id = _cursor.getInt(_cursorIndexOfId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.title = _cursor.getString(_cursorIndexOfTitle);
        _result.description = _cursor.getString(_cursorIndexOfDescription);
        _result.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
          _result.workorderStatusId = null;
        } else {
          _result.workorderStatusId = _cursor.getInt(_cursorIndexOfWorkorderStatusId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToId)) {
          _result.assignedToId = null;
        } else {
          _result.assignedToId = _cursor.getInt(_cursorIndexOfAssignedToId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToType)) {
          _result.assignedToType = null;
        } else {
          _result.assignedToType = _cursor.getInt(_cursorIndexOfAssignedToType);
        }
        if (_cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
          _result.workorderPriorityId = null;
        } else {
          _result.workorderPriorityId = _cursor.getInt(_cursorIndexOfWorkorderPriorityId);
        }
        if (_cursor.isNull(_cursorIndexOfAuthorId)) {
          _result.authorId = null;
        } else {
          _result.authorId = _cursor.getInt(_cursorIndexOfAuthorId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _result.locationId = null;
        } else {
          _result.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _result.checklistId = null;
        } else {
          _result.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfWorkorderBillingTypeId)) {
          _result.workorderBillingTypeId = null;
        } else {
          _result.workorderBillingTypeId = _cursor.getInt(_cursorIndexOfWorkorderBillingTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationEquipmentId)) {
          _result.locationEquipmentId = null;
        } else {
          _result.locationEquipmentId = _cursor.getInt(_cursorIndexOfLocationEquipmentId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationRoomId)) {
          _result.locationRoomId = null;
        } else {
          _result.locationRoomId = _cursor.getInt(_cursorIndexOfLocationRoomId);
        }
        _result.startDate = _cursor.getString(_cursorIndexOfStartDate);
        _result.closedDate = _cursor.getString(_cursorIndexOfClosedDate);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _result.executionStatus = null;
        } else {
          _result.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WorkOrderEntity workOrder(final String workOrderUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    workorders\n"
            + "WHERE \n"
            + "    uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workOrderUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfWorkorderStatusId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_status_id");
      final int _cursorIndexOfAssignedToId = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_id");
      final int _cursorIndexOfAssignedToType = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_type");
      final int _cursorIndexOfWorkorderPriorityId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_priority_id");
      final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "author_id");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfWorkorderBillingTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_billing_type_id");
      final int _cursorIndexOfLocationEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_equipment_id");
      final int _cursorIndexOfLocationRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_room_id");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "start_date");
      final int _cursorIndexOfClosedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "closed_date");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final WorkOrderEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new WorkOrderEntity();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _result.id = null;
        } else {
          _result.id = _cursor.getInt(_cursorIndexOfId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        _result.title = _cursor.getString(_cursorIndexOfTitle);
        _result.description = _cursor.getString(_cursorIndexOfDescription);
        _result.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
          _result.workorderStatusId = null;
        } else {
          _result.workorderStatusId = _cursor.getInt(_cursorIndexOfWorkorderStatusId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToId)) {
          _result.assignedToId = null;
        } else {
          _result.assignedToId = _cursor.getInt(_cursorIndexOfAssignedToId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToType)) {
          _result.assignedToType = null;
        } else {
          _result.assignedToType = _cursor.getInt(_cursorIndexOfAssignedToType);
        }
        if (_cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
          _result.workorderPriorityId = null;
        } else {
          _result.workorderPriorityId = _cursor.getInt(_cursorIndexOfWorkorderPriorityId);
        }
        if (_cursor.isNull(_cursorIndexOfAuthorId)) {
          _result.authorId = null;
        } else {
          _result.authorId = _cursor.getInt(_cursorIndexOfAuthorId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _result.locationId = null;
        } else {
          _result.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _result.checklistId = null;
        } else {
          _result.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfWorkorderBillingTypeId)) {
          _result.workorderBillingTypeId = null;
        } else {
          _result.workorderBillingTypeId = _cursor.getInt(_cursorIndexOfWorkorderBillingTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationEquipmentId)) {
          _result.locationEquipmentId = null;
        } else {
          _result.locationEquipmentId = _cursor.getInt(_cursorIndexOfLocationEquipmentId);
        }
        if (_cursor.isNull(_cursorIndexOfLocationRoomId)) {
          _result.locationRoomId = null;
        } else {
          _result.locationRoomId = _cursor.getInt(_cursorIndexOfLocationRoomId);
        }
        _result.startDate = _cursor.getString(_cursorIndexOfStartDate);
        _result.closedDate = _cursor.getString(_cursorIndexOfClosedDate);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _result.executionStatus = null;
        } else {
          _result.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WorkOrderNotesEntity workOrderNote(final String workOrderNoteUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    workorder_notes\n"
            + "WHERE \n"
            + "    uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderNoteUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workOrderNoteUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_id");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfWorkorderNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_notes");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final WorkOrderNotesEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new WorkOrderNotesEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final Integer _tmpWorkorderId;
        if (_cursor.isNull(_cursorIndexOfWorkorderId)) {
          _tmpWorkorderId = null;
        } else {
          _tmpWorkorderId = _cursor.getInt(_cursorIndexOfWorkorderId);
        }
        _result.setWorkorderId(_tmpWorkorderId);
        final Integer _tmpUserId;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUserId = null;
        } else {
          _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.setUserId(_tmpUserId);
        final String _tmpWorkorderNotes;
        _tmpWorkorderNotes = _cursor.getString(_cursorIndexOfWorkorderNotes);
        _result.setWorkorderNotes(_tmpWorkorderNotes);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WorkOrderNoteDetailEntity workOrderNoteDetail(final String workOrderNoteDetailUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    workorder_note_details\n"
            + "WHERE \n"
            + "    uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderNoteDetailUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workOrderNoteDetailUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderNoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_note_id");
      final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "property");
      final int _cursorIndexOfPropertyKey = CursorUtil.getColumnIndexOrThrow(_cursor, "property_key");
      final int _cursorIndexOfOldValue = CursorUtil.getColumnIndexOrThrow(_cursor, "old_value");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final WorkOrderNoteDetailEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new WorkOrderNoteDetailEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final Integer _tmpWorkorderNoteId;
        if (_cursor.isNull(_cursorIndexOfWorkorderNoteId)) {
          _tmpWorkorderNoteId = null;
        } else {
          _tmpWorkorderNoteId = _cursor.getInt(_cursorIndexOfWorkorderNoteId);
        }
        _result.setWorkorderNoteId(_tmpWorkorderNoteId);
        final String _tmpProperty;
        _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
        _result.setProperty(_tmpProperty);
        final String _tmpPropertyKey;
        _tmpPropertyKey = _cursor.getString(_cursorIndexOfPropertyKey);
        _result.setPropertyKey(_tmpPropertyKey);
        final String _tmpOldValue;
        _tmpOldValue = _cursor.getString(_cursorIndexOfOldValue);
        _result.setOldValue(_tmpOldValue);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        _result.setValue(_tmpValue);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WorkOrderAttachmentsEntity workOrderAttachment(final String workOrderAttachmentUuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    workorder_attachments\n"
            + "WHERE \n"
            + "    uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderAttachmentUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workOrderAttachmentUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfWorkorderId = CursorUtil.getColumnIndexOrThrow(_cursor, "workorder_id");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_filename");
      final int _cursorIndexOfFilename = CursorUtil.getColumnIndexOrThrow(_cursor, "filename");
      final int _cursorIndexOfFilesize = CursorUtil.getColumnIndexOrThrow(_cursor, "filesize");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "author_id");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfIsUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_uploaded");
      final WorkOrderAttachmentsEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new WorkOrderAttachmentsEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final Integer _tmpWorkorderId;
        if (_cursor.isNull(_cursorIndexOfWorkorderId)) {
          _tmpWorkorderId = null;
        } else {
          _tmpWorkorderId = _cursor.getInt(_cursorIndexOfWorkorderId);
        }
        _result.setWorkorderId(_tmpWorkorderId);
        final String _tmpDisplayFileName;
        _tmpDisplayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        _result.setDisplayFileName(_tmpDisplayFileName);
        final String _tmpFilename;
        _tmpFilename = _cursor.getString(_cursorIndexOfFilename);
        _result.setFilename(_tmpFilename);
        final Long _tmpFilesize;
        if (_cursor.isNull(_cursorIndexOfFilesize)) {
          _tmpFilesize = null;
        } else {
          _tmpFilesize = _cursor.getLong(_cursorIndexOfFilesize);
        }
        _result.setFilesize(_tmpFilesize);
        final String _tmpContentType;
        _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
        _result.setContentType(_tmpContentType);
        final Integer _tmpAuthorId;
        if (_cursor.isNull(_cursorIndexOfAuthorId)) {
          _tmpAuthorId = null;
        } else {
          _tmpAuthorId = _cursor.getInt(_cursorIndexOfAuthorId);
        }
        _result.setAuthorId(_tmpAuthorId);
        final String _tmpFileMd5Checksum;
        _tmpFileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        _result.setFileMd5Checksum(_tmpFileMd5Checksum);
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _result.isDownloaded = null;
        } else {
          _result.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _result.isUploaded = null;
        } else {
          _result.isUploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LocationRoomEntity ifLocationRoomExists(final Integer locationId) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    location_rooms\n"
            + "WHERE \n"
            + "    id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "room_id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final LocationRoomEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new LocationRoomEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Integer _tmpLocationId;
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _tmpLocationId = null;
        } else {
          _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        _result.setLocationId(_tmpLocationId);
        final Integer _tmpRoomId;
        if (_cursor.isNull(_cursorIndexOfRoomId)) {
          _tmpRoomId = null;
        } else {
          _tmpRoomId = _cursor.getInt(_cursorIndexOfRoomId);
        }
        _result.setRoomId(_tmpRoomId);
        final Boolean _tmpIsDeleted;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _tmpIsDeleted = _tmp == null ? null : _tmp != 0;
        _result.setIsDeleted(_tmpIsDeleted);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LocationEquipmentsEntity ifLocationEquipmentExists(final Integer locationId) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    location_equipments\n"
            + "WHERE \n"
            + "    id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment_id");
      final int _cursorIndexOfSerialNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "serial_number");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfUpcNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "upc_number");
      final LocationEquipmentsEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new LocationEquipmentsEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Integer _tmpLocationId;
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _tmpLocationId = null;
        } else {
          _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        _result.setLocationId(_tmpLocationId);
        final Integer _tmpEquipmentId;
        if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
          _tmpEquipmentId = null;
        } else {
          _tmpEquipmentId = _cursor.getInt(_cursorIndexOfEquipmentId);
        }
        _result.setEquipmentId(_tmpEquipmentId);
        final String _tmpSerialNumber;
        _tmpSerialNumber = _cursor.getString(_cursorIndexOfSerialNumber);
        _result.setSerialNumber(_tmpSerialNumber);
        final Boolean _tmpIsDeleted;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _tmpIsDeleted = _tmp == null ? null : _tmp != 0;
        _result.setIsDeleted(_tmpIsDeleted);
        final String _tmpModified;
        _tmpModified = _cursor.getString(_cursorIndexOfModified);
        _result.setModified(_tmpModified);
        final String _tmpUpcNumber;
        _tmpUpcNumber = _cursor.getString(_cursorIndexOfUpcNumber);
        _result.setUpcNumber(_tmpUpcNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignCheckListEntity getAssignedChecklist(final String checklistUuid) {
    final String _sql = "Select * From assigned_checklists where uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_at");
      final int _cursorIndexOfAssigneeType = CursorUtil.getColumnIndexOrThrow(_cursor, "assignee_type");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "department_id");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "started_at");
      final int _cursorIndexOfStartedByUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "started_by_user_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final int _cursorIndexOfPendingElementsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_elements_count");
      final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_resources_count");
      final AssignCheckListEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignCheckListEntity();
        _result.assignedAt = _cursor.getString(_cursorIndexOfAssignedAt);
        if (_cursor.isNull(_cursorIndexOfAssigneeType)) {
          _result.assigneeType = null;
        } else {
          _result.assigneeType = _cursor.getInt(_cursorIndexOfAssigneeType);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _result.checklistId = null;
        } else {
          _result.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistStatus)) {
          _result.checklistStatus = null;
        } else {
          _result.checklistStatus = _cursor.getInt(_cursorIndexOfChecklistStatus);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfDepartmentId)) {
          _result.departmentId = null;
        } else {
          _result.departmentId = _cursor.getInt(_cursorIndexOfDepartmentId);
        }
        _result.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _result.locationId = null;
        } else {
          _result.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        _result.startedAt = _cursor.getString(_cursorIndexOfStartedAt);
        if (_cursor.isNull(_cursorIndexOfStartedByUserId)) {
          _result.startedByUserId = null;
        } else {
          _result.startedByUserId = _cursor.getInt(_cursorIndexOfStartedByUserId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _result.executionStatus = null;
        } else {
          _result.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
        if (_cursor.isNull(_cursorIndexOfPendingElementsCount)) {
          _result.pendingElementsCount = null;
        } else {
          _result.pendingElementsCount = _cursor.getInt(_cursorIndexOfPendingElementsCount);
        }
        if (_cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
          _result.pendingResourcesCount = null;
        } else {
          _result.pendingResourcesCount = _cursor.getInt(_cursorIndexOfPendingResourcesCount);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
