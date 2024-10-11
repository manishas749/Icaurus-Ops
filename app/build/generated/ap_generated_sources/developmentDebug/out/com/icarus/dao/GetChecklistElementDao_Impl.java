package com.icarus.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.CheckListPpesEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.CustomFieldsEntity;
import com.icarus.entities.ItemPlaceholdersEntity;
import com.icarus.entities.NcwHazardsEntity;
import com.icarus.entities.PlaceholderEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.entities.ResourcesLinksEntity;
import com.icarus.entities.StepAttributesEntity;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GetChecklistElementDao_Impl extends GetChecklistElementDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChecklistElementsEntity> __insertionAdapterOfChecklistElementsEntity;

  private final EntityInsertionAdapter<CustomFieldsEntity> __insertionAdapterOfCustomFieldsEntity;

  private final EntityInsertionAdapter<StepAttributesEntity> __insertionAdapterOfStepAttributesEntity;

  private final EntityInsertionAdapter<NcwHazardsEntity> __insertionAdapterOfNcwHazardsEntity;

  private final EntityInsertionAdapter<CheckListPpesEntity> __insertionAdapterOfCheckListPpesEntity;

  private final EntityInsertionAdapter<ResourcesLinksEntity> __insertionAdapterOfResourcesLinksEntity;

  private final EntityInsertionAdapter<ItemPlaceholdersEntity> __insertionAdapterOfItemPlaceholdersEntity;

  private final EntityInsertionAdapter<PlaceholderEntity> __insertionAdapterOfPlaceholderEntity;

  private final EntityInsertionAdapter<ResourceEntity> __insertionAdapterOfResourceEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChecklistSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChecklistPendingReferenceCount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChecklistPendingResourceCount;

  public GetChecklistElementDao_Impl(RoomDatabase __db) {
    this.__db = __db;
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
    this.__preparedStmtOfUpdateChecklistSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update checklists set sync_status = ? where id = ?";
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
  }

  @Override
  void insertChecklistElements(final List<ChecklistElementsEntity> checklistElements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChecklistElementsEntity.insert(checklistElements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertCustomFields(final List<CustomFieldsEntity> customFields) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomFieldsEntity.insert(customFields);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertStepAttributes(final List<StepAttributesEntity> stepAttributes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStepAttributesEntity.insert(stepAttributes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertNCWHazard(final NcwHazardsEntity ncwHazard) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNcwHazardsEntity.insert(ncwHazard);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertNCWHazards(final List<NcwHazardsEntity> ncwHazards) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNcwHazardsEntity.insert(ncwHazards);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertChecklistPpe(final CheckListPpesEntity checkListPpe) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCheckListPpesEntity.insert(checkListPpe);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertChecklistPpes(final List<CheckListPpesEntity> checkListPpes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCheckListPpesEntity.insert(checkListPpes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertReferenceLinks(final List<ResourcesLinksEntity> referenceLinks) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResourcesLinksEntity.insert(referenceLinks);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertItemPlaceholders(final List<ItemPlaceholdersEntity> itemPlaceholders) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfItemPlaceholdersEntity.insert(itemPlaceholders);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertPlaceholders(final List<PlaceholderEntity> placeholders) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPlaceholderEntity.insert(placeholders);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void insertResources(final List<ResourceEntity> resource) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResourceEntity.insert(resource);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChecklistElementsWithAssociatedDate(final Integer checklistId,
      final List<ChecklistElementsEntity> checklistElements,
      final List<CustomFieldsEntity> customFields, final List<StepAttributesEntity> stepAttributes,
      final List<NcwHazardsEntity> ncwHazards, final List<CheckListPpesEntity> stepPpes,
      final List<PlaceholderEntity> placeholders,
      final List<ItemPlaceholdersEntity> itemPlaceholders,
      final List<ResourcesLinksEntity> referenceLinks, final List<ResourceEntity> resources) {
    __db.beginTransaction();
    try {
      GetChecklistElementDao_Impl.super.insertChecklistElementsWithAssociatedDate(checklistId, checklistElements, customFields, stepAttributes, ncwHazards, stepPpes, placeholders, itemPlaceholders, referenceLinks, resources);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
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
  void updateChecklistPendingReferenceCount(final Integer checklistId) {
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
  void updateChecklistPendingResourceCount(final Integer checklistId) {
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
  CheckListPpesEntity checkIfChecklistPpesExists(final Integer stepId, final Integer ppeId) {
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
  NcwHazardsEntity checkIfNcwHazardsExists(final Integer itemTypeId, final Integer itemId,
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
}
