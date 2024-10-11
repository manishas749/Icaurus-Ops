package com.icarus.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignedDecisionEntity;
import com.icarus.entities.AssignedNCWEntity;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.AssignedStepEntity;
import com.icarus.entities.AssignedStepFileResourceEntity;
import com.icarus.entities.ChecklistElementsEntity;
import com.icarus.entities.ResourceEntity;
import com.icarus.models.CaptureDataItem;
import com.icarus.models.CheckListPPItems;
import com.icarus.models.CheckListStepAttributeItems;
import com.icarus.models.ChecklistDetailItems;
import com.icarus.models.ChecklistIDetailtems;
import com.icarus.models.NcwHazardsItems;
import com.icarus.models.NonExecutedChildElement;
import com.icarus.models.ParentDetailItem;
import com.icarus.models.QRAttributeScanItem;
import com.icarus.models.ResourceLinkItems;
import com.icarus.models.UserItems;
import com.icarus.models.UserMinimal;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChecklistExecutionDao_Impl implements ChecklistExecutionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AssignedNCWEntity> __insertionAdapterOfAssignedNCWEntity;

  private final EntityInsertionAdapter<AssignedDecisionEntity> __insertionAdapterOfAssignedDecisionEntity;

  private final EntityInsertionAdapter<AssignedStepAttributesEntity> __insertionAdapterOfAssignedStepAttributesEntity;

  private final EntityInsertionAdapter<AssignedStepEntity> __insertionAdapterOfAssignedStepEntity;

  private final EntityInsertionAdapter<AssignedStepFileResourceEntity> __insertionAdapterOfAssignedStepFileResourceEntity;

  private final EntityDeletionOrUpdateAdapter<AssignedStepEntity> __updateAdapterOfAssignedStepEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNCWExection;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedDecisionsExection;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedStepAttributes;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedStepAttributesQR;

  private final SharedSQLiteStatement __preparedStmtOfUpdateChildOnParentSkippedOrDeffered;

  private final SharedSQLiteStatement __preparedStmtOfRemoveFile;

  private final SharedSQLiteStatement __preparedStmtOfRemoveFileResource;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingElementCount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingResourceCount;

  public ChecklistExecutionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAssignedNCWEntity = new EntityInsertionAdapter<AssignedNCWEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_ncw` (`uuid`,`assigned_checklist_uuid`,`user_id`,`item_id`,`item_type_id`,`checklist_element_id`,`acknowledged`,`is_deleted`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
    this.__insertionAdapterOfAssignedDecisionEntity = new EntityInsertionAdapter<AssignedDecisionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_decisions` (`assigned_checklist_uuid`,`checklist_element_id`,`created`,`decision_id`,`is_deleted`,`modified`,`status`,`sync_status`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
    this.__insertionAdapterOfAssignedStepAttributesEntity = new EntityInsertionAdapter<AssignedStepAttributesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_step_attributes` (`assigned_checklist_uuid`,`checklist_element_id`,`created`,`is_deleted`,`item_uuid`,`modified`,`step_attribute_id`,`step_id`,`sync_status`,`user_id`,`uuid`,`value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
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
    this.__insertionAdapterOfAssignedStepEntity = new EntityInsertionAdapter<AssignedStepEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_steps` (`assigned_checklist_uuid`,`checklist_element_id`,`created`,`is_deleted`,`modified`,`status`,`step_id`,`sync_status`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
    this.__updateAdapterOfAssignedStepEntity = new EntityDeletionOrUpdateAdapter<AssignedStepEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `assigned_steps` SET `assigned_checklist_uuid` = ?,`checklist_element_id` = ?,`created` = ?,`is_deleted` = ?,`modified` = ?,`status` = ?,`step_id` = ?,`sync_status` = ?,`user_id` = ?,`uuid` = ? WHERE `uuid` = ?";
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
        if (value.uuid == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.uuid);
        }
      }
    };
    this.__preparedStmtOfUpdateNCWExection = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_ncw set is_deleted = 0 , sync_status = 0 , user_id = ? , acknowledged = ? , modified = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedDecisionsExection = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_decisions set is_deleted = 0 , sync_status = 0 , user_id = ? , status = ? , modified = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedStepAttributes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_attributes set is_deleted = ?, sync_status = 0,  modified =?, value = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedStepAttributesQR = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_attributes set is_deleted = 0, sync_status = 0, modified =?, value = ?, user_id =? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateChildOnParentSkippedOrDeffered = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_ncw set is_deleted = 1 , sync_status = 0 , modified = CURRENT_TIMESTAMP where assigned_ncw.checklist_element_id IN (select checklist_elements.id from checklist_elements where checklist_elements.parent_id = ?)";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveFile = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_attributes set is_deleted = 1, sync_status = 0  where value = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveFileResource = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_step_resources set is_deleted = 1, sync_status = 0  where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistPendingElementCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET pending_elements_count = pending_elements_count + 1 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistPendingResourceCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET pending_resources_count = pending_resources_count + 1 where uuid = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertNCWExection(final AssignedNCWEntity assignedNCWEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedNCWEntity.insert(assignedNCWEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAssignedDecisions(final AssignedDecisionEntity assignedDecisionEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedDecisionEntity.insert(assignedDecisionEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAssignedStepAttributes(
      final AssignedStepAttributesEntity assignedStepAttributesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedStepAttributesEntity.insert(assignedStepAttributesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAssignedStep(final AssignedStepEntity assignedStepEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedStepEntity.insert(assignedStepEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAssignedStepFileResources(
      final AssignedStepFileResourceEntity assignedStepAttributesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedStepFileResourceEntity.insert(assignedStepAttributesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAssignedStep(final AssignedStepEntity assignedStepEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAssignedStepEntity.handle(assignedStepEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateNCWExection(final String uuid, final Integer acknowledged, final Integer userId,
      final String currentTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNCWExection.acquire();
    int _argIndex = 1;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (acknowledged == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, acknowledged);
    }
    _argIndex = 3;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 4;
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
      __preparedStmtOfUpdateNCWExection.release(_stmt);
    }
  }

  @Override
  public void updateAssignedDecisionsExection(final String uuid, final Integer status,
      final int userId, final String currentTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedDecisionsExection.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, status);
    }
    _argIndex = 3;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 4;
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
      __preparedStmtOfUpdateAssignedDecisionsExection.release(_stmt);
    }
  }

  @Override
  public void updateAssignedStepAttributes(final String uuid, final Integer isDeleted,
      final String currentDate, final String value) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedStepAttributes.acquire();
    int _argIndex = 1;
    if (isDeleted == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, isDeleted);
    }
    _argIndex = 2;
    if (currentDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentDate);
    }
    _argIndex = 3;
    if (value == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, value);
    }
    _argIndex = 4;
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
      __preparedStmtOfUpdateAssignedStepAttributes.release(_stmt);
    }
  }

  @Override
  public void updateAssignedStepAttributesQR(final Integer userId, final String value,
      final String currentDate, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedStepAttributesQR.acquire();
    int _argIndex = 1;
    if (currentDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentDate);
    }
    _argIndex = 2;
    if (value == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, value);
    }
    _argIndex = 3;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
    _argIndex = 4;
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
      __preparedStmtOfUpdateAssignedStepAttributesQR.release(_stmt);
    }
  }

  @Override
  public void updateChildOnParentSkippedOrDeffered(final Integer parentid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateChildOnParentSkippedOrDeffered.acquire();
    int _argIndex = 1;
    if (parentid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, parentid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateChildOnParentSkippedOrDeffered.release(_stmt);
    }
  }

  @Override
  public void removeFile(final String fileUuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveFile.acquire();
    int _argIndex = 1;
    if (fileUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fileUuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveFile.release(_stmt);
    }
  }

  @Override
  public void removeFileResource(final String fileUuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveFileResource.acquire();
    int _argIndex = 1;
    if (fileUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fileUuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveFileResource.release(_stmt);
    }
  }

  @Override
  public void updateAssignedChecklistPendingElementCount(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedChecklistPendingElementCount.acquire();
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
      __preparedStmtOfUpdateAssignedChecklistPendingElementCount.release(_stmt);
    }
  }

  @Override
  public void updateAssignedChecklistPendingResourceCount(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedChecklistPendingResourceCount.acquire();
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
      __preparedStmtOfUpdateAssignedChecklistPendingResourceCount.release(_stmt);
    }
  }

  @Override
  public AssignedNCWEntity ifNCWAlreadyUpdated(final String uuid,
      final Integer checkListElementID) {
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
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _result.setUuid(_tmpUuid);
        final String _tmpAssigned_checklist_uuid;
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _tmpAssigned_checklist_uuid = null;
        } else {
          _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
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
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _tmpCreated = null;
        } else {
          _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        }
        _result.setCreated(_tmpCreated);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
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
  public ChecklistDetailItems getItem(final Integer currentSortOrder, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + "\tAssignedChecklist.checklist_id,\n"
            + "\tChecklistElement.id,\n"
            + "\tChecklistElement.item_type_id,\n"
            + "\tChecklistElement.item_id,\n"
            + "\tChecklistElement.item_uuid,\n"
            + "\tChecklistElement.parent_id,\n"
            + "\tChecklistElement.sort_order,\n"
            + "\tChecklistElement.sequence_no,\n"
            + "\tParentChecklistElement.item_type_id AS parent_type,\n"
            + "\tIFNULL(\n"
            + "\tCASE\n"
            + "\t\t\tWHEN ChecklistElement.item_type_id IN ( 1, 8, 12 ) THEN coalesce( PlacholderText.item_description, ChecklistElement.title ) \n"
            + "\t\t\tELSE ChecklistElement.title \n"
            + "\t\tEND,\n"
            + "\t\t'' \n"
            + "\t) AS title,\n"
            + "\tIFNULL(\n"
            + "\tCASE\n"
            + "\t\t\tWHEN ChecklistElement.item_type_id IN ( 1, 8, 12 ) THEN coalesce( PlacholderText.step_action, ChecklistElement.description ) \n"
            + "\t\t\tELSE coalesce( PlacholderText.item_description, ChecklistElement.description ) \n"
            + "\t\tEND,\n"
            + "\t\t'' \n"
            + "\t) AS description,\n"
            + "\tAssignedStep.status,\n"
            + "\tAssignedDecision.status AS \"decisionStatus\",\n"
            + "\tAssignedNCW.acknowledged,\n"
            + "\t( SELECT \"action\" FROM logs WHERE assigned_checklist_uuid = AssignedChecklist.uuid AND checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) ORDER BY created DESC LIMIT 1 ) AS \"imageTextStatus\",\n"
            + "\tCOALESCE( ParentAssignedStep.status, ParentAssignedDecision.status ) AS parent_status \n"
            + "FROM\n"
            + "\tassigned_checklists AS AssignedChecklist\n"
            + "\tLEFT JOIN checklist_elements AS ChecklistElement ON ( ChecklistElement.checklist_id = AssignedChecklist.checklist_id )\n"
            + "\tLEFT JOIN checklist_elements AS ParentChecklistElement ON ( ParentChecklistElement.id = ChecklistElement.parent_id )\n"
            + "\tLEFT JOIN logs AS PlacholderText ON (\n"
            + "\t\tPlacholderText.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND PlacholderText.checklist_element_id = ChecklistElement.id \n"
            + "\t\tAND PlacholderText.\"action\" = 19 \n"
            + "\t)\n"
            + "\tLEFT JOIN assigned_ncw AS AssignedNCW ON (\n"
            + "\t\tAssignedNCW.checklist_element_id = ChecklistElement.id \n"
            + "\t\tAND AssignedNCW.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND AssignedNCW.is_deleted = 0 \n"
            + "\t)\n"
            + "\tLEFT JOIN assigned_steps AS AssignedStep ON (\n"
            + "\t\tAssignedStep.checklist_element_id = ChecklistElement.id \n"
            + "\t\tAND AssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND AssignedStep.is_deleted = 0 \n"
            + "\t)\n"
            + "\tLEFT JOIN assigned_decisions AS AssignedDecision ON (\n"
            + "\t\tAssignedDecision.checklist_element_id = ChecklistElement.id \n"
            + "\t\tAND AssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND AssignedDecision.is_deleted = 0 \n"
            + "\t)\n"
            + "\tLEFT JOIN assigned_steps AS ParentAssignedStep ON (\n"
            + "\t\tParentAssignedStep.checklist_element_id = ParentChecklistElement.id \n"
            + "\t\tAND ParentAssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND ParentAssignedStep.is_deleted = 0 \n"
            + "\t)\n"
            + "\tLEFT JOIN assigned_decisions AS ParentAssignedDecision ON (\n"
            + "\t\tParentAssignedDecision.checklist_element_id = ParentChecklistElement.id \n"
            + "\t\tAND ParentAssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND ParentAssignedDecision.is_deleted = 0 \n"
            + "\t) \n"
            + "WHERE\n"
            + "\tAssignedChecklist.uuid = ? \n"
            + "\tAND ChecklistElement.is_deleted = 0 \n"
            + "\tAND ChecklistElement.item_type_id <> 9 \n"
            + "\tAND (\n"
            + "\t\t(\n"
            + "\t\t\tParentChecklistElement.item_type_id IN ( 1, 8, 12 ) \n"
            + "\t\t\tAND (\n"
            + "\t\t\t\tparent_status IS NULL \n"
            + "\t\t\t\tOR parent_status = 0 \n"
            + "\t\t\t\tOR parent_status = 1 \n"
            + "\t\t\t) \n"
            + "\t\t) \n"
            + "\t\tOR ( ParentChecklistElement.item_type_id = 2 AND parent_status = 1 ) \n"
            + "\t\tOR ParentChecklistElement.item_type_id IS NULL \n"
            + "\t) \n"
            + "\tAND ChecklistElement.sort_order = ?\n"
            + "ORDER BY\n"
            + "\tChecklistElement.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfParentType = 8;
      final int _cursorIndexOfTitle = 9;
      final int _cursorIndexOfDescription = 10;
      final int _cursorIndexOfStatus = 11;
      final int _cursorIndexOfDecisionStatus = 12;
      final int _cursorIndexOfAcknowledged = 13;
      final int _cursorIndexOfImageTextStatus = 14;
      final int _cursorIndexOfParentStatus = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
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
  public ChecklistDetailItems getSkippedItem(final Integer currentSortOrder,
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + " distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "checklist_elements.sort_order,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, (select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs  ON (logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n"
            + "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n"
            + "AND logs.action = 19)\n"
            + "WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.item_type_id <> 9 AND checklist_elements.is_deleted = 0 \n"
            + " AND sort_order = ?\n"
            + "ORDER BY\n"
            + "checklist_elements.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfParentType = 11;
      final int _cursorIndexOfParentStatus = 12;
      final int _cursorIndexOfImageTextStatus = 13;
      final int _cursorIndexOfTitle = 14;
      final int _cursorIndexOfDescription = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public ChecklistDetailItems getDefferedItem(final Integer currentSortOrder,
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + " distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "checklist_elements.sort_order,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus ,logs.action as imageTextStatus , (select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs  ON (logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n"
            + "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n"
            + "AND logs.action = 19)\n"
            + "WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.item_type_id <> 9 AND checklist_elements.is_deleted = 0 \n"
            + " AND sort_order = ?\n"
            + "ORDER BY\n"
            + "checklist_elements.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfImageTextStatus = 11;
      final int _cursorIndexOfParentType = 12;
      final int _cursorIndexOfParentStatus = 13;
      final int _cursorIndexOfTitle = 15;
      final int _cursorIndexOfDescription = 16;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public ChecklistDetailItems getNextItem(final Integer currentSortOrder,
      final String checkListUuid, final Integer checklistId) {
    final String _sql = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS ( \n"
            + "                    SELECT \n"
            + "                        checklist_elements.id, \n"
            + "                        checklist_elements.parent_id, \n"
            + "                        checklist_elements.checklist_id, \n"
            + "                        checklist_elements.item_id, \n"
            + "                        checklist_elements.item_type_id, \n"
            + "                        checklist_elements.item_uuid, \n"
            + "                        checklist_elements.title, \n"
            + "                        checklist_elements.description, \n"
            + "                        checklist_elements.sequence_no, \n"
            + "                        COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged,  \n"
            + "            (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id  \n"
            + "            AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18, 12, 13) \n"
            + "             AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1)) AS status, \n"
            + "                        checklist_elements.sort_order, \n"
            + "                        checklist_elements.id AS rootid, \n"
            + "                        0 AS level \n"
            + "                    FROM checklist_elements \n"
            + "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?) \n"
            + "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?) \n"
            + "                    LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = ?) \n"
            + "                    WHERE \n"
            + "                        checklist_elements.checklist_id = ? \n"
            + "                    AND checklist_elements.is_deleted = 0 \n"
            + "                    AND checklist_elements.item_type_id NOT IN ( 9 )\n"
            + "                    AND checklist_elements.sort_order > ?\n"
            + "                        UNION ALL \n"
            + "                    SELECT  \n"
            + "                        checklist_elements.id, \n"
            + "                        checklist_elements.parent_id, \n"
            + "                        checklist_elements.checklist_id, \n"
            + "                        checklist_elements.item_id, \n"
            + "                        checklist_elements.item_type_id, \n"
            + "                        checklist_elements.item_uuid, \n"
            + "                        checklist_elements.title, \n"
            + "                        checklist_elements.description, \n"
            + "                        checklist_elements.sequence_no, \n"
            + "                        COALESCE(assigned_steps.status, assigned_decisions.status) AS status, \n"
            + "                        checklist_elements.sort_order, \n"
            + "                        elements.rootid, \n"
            + "                        level + 1 AS level \n"
            + "                    FROM checklist_elements, elements \n"
            + "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?) \n"
            + "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?) \n"
            + "                    WHERE checklist_elements.id = elements.parent_id \n"
            + "            ) \n"
            + "            SELECT \n"
            + "                id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n"
            + "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title, \n"
            + "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description, \n"
            + "                sequence_no, status, sort_order, \n"
            + "                (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon, \n"
            + "                (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon, \n"
            + "                rootid, level, \n"
            + "                SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents, \n"
            + "                SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( 0, 1 ) OR status IS NULL) ) ) THEN 1 ELSE 0 END) AS total_executed_parents, \n"
            + "                SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent, \n"
            + "                SUM(CASE WHEN level = 1 THEN item_type_id ELSE 0 END) AS parent_type\n"
            + "            FROM elements \n"
            + "            LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.action = 19 AND placeholders_text.assigned_checklist_uuid = ?) \n"
            + "            GROUP BY rootid \n"
            + "            HAVING total_parents = total_executed_parents AND MIN(level) = 0 AND (has_step_parent = 0 OR (has_step_parent = 1 AND item_type_id NOT IN ( 10 )))\n"
            + "            ORDER BY sort_order LIMIT 1;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 9);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
    _argIndex = 6;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    _argIndex = 7;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 8;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 9;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfElementId = 0;
      final int _cursorIndexOfParentItemId = 1;
      final int _cursorIndexOfChecklistId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemTypeId = 4;
      final int _cursorIndexOfItemUuid = 5;
      final int _cursorIndexOfTitle = 6;
      final int _cursorIndexOfDescription = 7;
      final int _cursorIndexOfSequenceNo = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfSortOrder = 10;
      final int _cursorIndexOfPpesIcon = 11;
      final int _cursorIndexOfHazardsIcon = 12;
      final int _cursorIndexOfParentType = 18;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpPpesIcon;
        if (_cursor.isNull(_cursorIndexOfPpesIcon)) {
          _tmpPpesIcon = null;
        } else {
          _tmpPpesIcon = _cursor.getString(_cursorIndexOfPpesIcon);
        }
        _result.setPpesIcon(_tmpPpesIcon);
        final String _tmpHazardsIcon;
        if (_cursor.isNull(_cursorIndexOfHazardsIcon)) {
          _tmpHazardsIcon = null;
        } else {
          _tmpHazardsIcon = _cursor.getString(_cursorIndexOfHazardsIcon);
        }
        _result.setHazardsIcon(_tmpHazardsIcon);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
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
  public ChecklistDetailItems getNextSkippedItem(final Integer currentSortOrder,
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + " distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "min(checklist_elements.sort_order) as sort_order ,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, (select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs  ON (logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n"
            + "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n"
            + "AND logs.action = 19)\n"
            + "WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.item_type_id <> 9 AND (assigned_ncw.acknowledged = 2 or assigned_steps.status = 2 or assigned_decisions.status = 2 OR parent_status = 2 OR imageTextStatus = 12) AND checklist_elements.is_deleted = 0 \n"
            + " AND sort_order > ?\n"
            + "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)ORDER BY\n"
            + "checklist_elements.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfParentType = 11;
      final int _cursorIndexOfParentStatus = 12;
      final int _cursorIndexOfImageTextStatus = 13;
      final int _cursorIndexOfTitle = 14;
      final int _cursorIndexOfDescription = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public ChecklistDetailItems getNextDefferedItem(final Integer currentSortOrder,
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + " distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "min(checklist_elements.sort_order) as sort_order ,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, (select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs  ON (logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n"
            + "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n"
            + "AND logs.action = 19)\n"
            + "WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.item_type_id <> 9 AND (assigned_ncw.acknowledged = 3 or assigned_steps.status = 3 or assigned_decisions.status = 3 OR parent_status = 3 OR imageTextStatus = 13) AND checklist_elements.is_deleted = 0 \n"
            + " AND sort_order > ?\n"
            + "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)ORDER BY\n"
            + "checklist_elements.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfParentType = 11;
      final int _cursorIndexOfParentStatus = 12;
      final int _cursorIndexOfImageTextStatus = 13;
      final int _cursorIndexOfTitle = 14;
      final int _cursorIndexOfDescription = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public ChecklistDetailItems getPreviousItem(final Integer currentSortOrder,
      final String checkListUuid, final Integer checklistId) {
    final String _sql = "WITH RECURSIVE elements(id, parent_id, checklist_id, item_id, item_type_id, item_uuid, title, description, sequence_no, status, sort_order, rootid, level) AS ( \n"
            + "                    SELECT \n"
            + "                        checklist_elements.id, \n"
            + "                        checklist_elements.parent_id, \n"
            + "                        checklist_elements.checklist_id, \n"
            + "                        checklist_elements.item_id, \n"
            + "                        checklist_elements.item_type_id, \n"
            + "                        checklist_elements.item_uuid, \n"
            + "                        checklist_elements.title, \n"
            + "                        checklist_elements.description, \n"
            + "                        checklist_elements.sequence_no, \n"
            + "                        COALESCE(assigned_steps.status, assigned_decisions.status, assigned_ncw.acknowledged,  \n"
            + "            (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id  \n"
            + "            AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18, 12, 13) \n"
            + "             AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1)) AS status, \n"
            + "                        checklist_elements.sort_order, \n"
            + "                        checklist_elements.id AS rootid, \n"
            + "                        0 AS level \n"
            + "                    FROM checklist_elements \n"
            + "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?) \n"
            + "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?) \n"
            + "                    LEFT JOIN assigned_ncw ON (assigned_ncw.checklist_element_id = checklist_elements.id AND assigned_ncw.is_deleted = 0 AND assigned_ncw.assigned_checklist_uuid = ?) \n"
            + "\t\t\t\t\t\n"
            + "\t\t\t\t\t\n"
            + "                    WHERE \n"
            + "                        checklist_elements.checklist_id = ? \n"
            + "                    AND checklist_elements.is_deleted = 0 \n"
            + "                    AND checklist_elements.item_type_id NOT IN ( 9 )\n"
            + "                    AND checklist_elements.sort_order < ?\n"
            + "                        UNION ALL \n"
            + "                    SELECT  \n"
            + "                        checklist_elements.id, \n"
            + "                        checklist_elements.parent_id, \n"
            + "                        checklist_elements.checklist_id, \n"
            + "                        checklist_elements.item_id, \n"
            + "                        checklist_elements.item_type_id, \n"
            + "                        checklist_elements.item_uuid, \n"
            + "                        checklist_elements.title, \n"
            + "                        checklist_elements.description, \n"
            + "                        checklist_elements.sequence_no, \n"
            + "                        COALESCE(assigned_steps.status, assigned_decisions.status) AS status, \n"
            + "                        checklist_elements.sort_order, \n"
            + "                        elements.rootid, \n"
            + "                        level + 1 AS level \n"
            + "                    FROM checklist_elements, elements \n"
            + "                    LEFT JOIN assigned_steps ON (assigned_steps.checklist_element_id = checklist_elements.id AND assigned_steps.is_deleted = 0 AND assigned_steps.assigned_checklist_uuid = ?) \n"
            + "                    LEFT JOIN assigned_decisions ON (assigned_decisions.checklist_element_id = checklist_elements.id AND assigned_decisions.is_deleted = 0 AND assigned_decisions.assigned_checklist_uuid = ?) \n"
            + "                    WHERE checklist_elements.id = elements.parent_id \n"
            + "            ) \n"
            + "            SELECT \n"
            + "                id, parent_id, elements.checklist_id, item_id, item_type_id, elements.item_uuid,\n"
            + "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.item_description, elements.title) ELSE elements.title END, '') AS title, \n"
            + "                IFNULL(CASE WHEN elements.item_type_id IN ( 1, 8, 12 ) THEN COALESCE(placeholders_text.step_action, elements.description) ELSE COALESCE(placeholders_text.item_description, elements.description) END, '') AS description, \n"
            + "                sequence_no, status, sort_order, \n"
            + "                (SELECT GROUP_CONCAT(ppes.icon) FROM checklist_ppes LEFT JOIN ppes ON (ppes.id = checklist_ppes.ppe_id) WHERE checklist_ppes.step_id = elements.item_id AND elements.item_type_id IN (1, 8, 12) AND checklist_ppes.is_deleted = 0) AS ppes_icon, \n"
            + "                (SELECT GROUP_CONCAT(hazards.icon) FROM ncw_hazards LEFT JOIN hazards ON (hazards.id = ncw_hazards.hazard_id) WHERE ncw_hazards.item_id = elements.item_id AND ncw_hazards.item_type_id = elements.item_type_id AND ncw_hazards.is_deleted = 0) AS hazards_icon, \n"
            + "                rootid, level, \n"
            + "                SUM(CASE WHEN rootid != id THEN 1 ELSE 0 END) AS total_parents, \n"
            + "                SUM(CASE WHEN rootid != id AND ( ( item_type_id = 2 AND status = 1 ) OR ( item_type_id != 2 AND ( status IN ( 0, 1 ) OR status IS NULL) ) ) THEN 1 ELSE 0 END) AS total_executed_parents, \n"
            + "                SUM(CASE WHEN level = 1 AND item_type_id IN (1, 8, 12) THEN 1 ELSE 0 END) AS has_step_parent, \n"
            + "                SUM(CASE WHEN level = 1 THEN item_type_id ELSE 0 END) AS parent_type\n"
            + "            FROM elements \n"
            + "            LEFT JOIN logs AS placeholders_text ON ( placeholders_text.checklist_element_id = elements.id AND placeholders_text.action = 19 AND placeholders_text.assigned_checklist_uuid = ?) \n"
            + "            GROUP BY rootid \n"
            + "            HAVING total_parents = total_executed_parents AND MIN(level) = 0 AND ( has_step_parent = 0 OR ( has_step_parent = 1 AND item_type_id NOT IN ( 10 ) ) )\n"
            + "            ORDER BY sort_order DESC LIMIT 1;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 9);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
    _argIndex = 6;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    _argIndex = 7;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 8;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 9;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfElementId = 0;
      final int _cursorIndexOfParentItemId = 1;
      final int _cursorIndexOfChecklistId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemTypeId = 4;
      final int _cursorIndexOfItemUuid = 5;
      final int _cursorIndexOfTitle = 6;
      final int _cursorIndexOfDescription = 7;
      final int _cursorIndexOfSequenceNo = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfSortOrder = 10;
      final int _cursorIndexOfPpesIcon = 11;
      final int _cursorIndexOfHazardsIcon = 12;
      final int _cursorIndexOfParentType = 18;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpPpesIcon;
        if (_cursor.isNull(_cursorIndexOfPpesIcon)) {
          _tmpPpesIcon = null;
        } else {
          _tmpPpesIcon = _cursor.getString(_cursorIndexOfPpesIcon);
        }
        _result.setPpesIcon(_tmpPpesIcon);
        final String _tmpHazardsIcon;
        if (_cursor.isNull(_cursorIndexOfHazardsIcon)) {
          _tmpHazardsIcon = null;
        } else {
          _tmpHazardsIcon = _cursor.getString(_cursorIndexOfHazardsIcon);
        }
        _result.setHazardsIcon(_tmpHazardsIcon);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
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
  public ChecklistDetailItems getPreviousSkippedItem(final Integer currentSortOrder,
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + " distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "max(checklist_elements.sort_order) as sort_order,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus,(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs  ON (logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n"
            + "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n"
            + "AND logs.action = 19)\n"
            + "WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.item_type_id <> 9 AND checklist_elements.is_deleted = 0 \n"
            + "AND (assigned_ncw.acknowledged = 2 or assigned_steps.status = 2 or assigned_decisions.status = 2 OR parent_status = 2 OR imageTextStatus = 12)  AND sort_order < ?\n"
            + "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)ORDER BY\n"
            + "checklist_elements.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfParentType = 11;
      final int _cursorIndexOfParentStatus = 12;
      final int _cursorIndexOfImageTextStatus = 13;
      final int _cursorIndexOfTitle = 14;
      final int _cursorIndexOfDescription = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public ChecklistDetailItems getPreviousDefferedItem(final Integer currentSortOrder,
      final Integer checkListId, final String checkListUuid) {
    final String _sql = "SELECT\n"
            + " distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "max(checklist_elements.sort_order) as sort_order,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status, assigned_decisions.status as decisionStatus, (select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, (SELECT action FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 7, 10 ) AND action IN (17, 18, 12, 13) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus,CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs  ON (logs.assigned_checklist_uuid = assigned_steps.assigned_checklist_uuid\n"
            + "AND logs.checklist_element_id = assigned_steps.checklist_element_id\n"
            + "AND logs.action = 19)\n"
            + "WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.item_type_id <> 9 AND checklist_elements.is_deleted = 0 \n"
            + "AND (assigned_ncw.acknowledged = 3 or assigned_steps.status = 3 or assigned_decisions.status = 3 OR parent_status = 3 OR imageTextStatus = 13)  AND sort_order < ?\n"
            + "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or parent_type = 2)ORDER BY\n"
            + "checklist_elements.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    if (checkListId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checkListId);
    }
    _argIndex = 8;
    if (currentSortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, currentSortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfParentType = 11;
      final int _cursorIndexOfParentStatus = 12;
      final int _cursorIndexOfImageTextStatus = 13;
      final int _cursorIndexOfTitle = 14;
      final int _cursorIndexOfDescription = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public List<CheckListStepAttributeItems> getStepElments(final String stepId,
      final Integer elementId, final String assignedChecklistUuid) {
    final String _sql = "select distinct step_attributes.id, assigned_step_attributes.item_uuid,step_attributes.label,         step_attributes.sort_order,  custom_fields.step_attribute_count,        custom_fields.user_roles,  step_attributes.custom_field_id, step_attributes.step_id, step_attributes.uuid, step_attributes.description, custom_fields.name,        custom_fields.allow_gallery,custom_fields.allowed_media_types,custom_fields.multiple,custom_fields.default_value, custom_fields.max_length, custom_fields.max_value,       custom_fields.min_length,custom_fields.min_value,custom_fields.model,custom_fields.possible_values,custom_fields.allow_description,custom_fields.display_as,       custom_fields.required,custom_fields.type ,CASE WHEN custom_fields.type = 'qa' THEN users.username ELSE assigned_step_attributes.value END AS value\n"
            + "from        step_attributes LEFT JOIN        custom_fields ON        (step_attributes.custom_field_id = custom_fields.id)LEFT JOIN        assigned_step_attributes ON        (assigned_step_attributes.step_id = step_attributes.step_id and assigned_step_attributes.step_attribute_id =  step_attributes.id        and assigned_step_attributes.assigned_checklist_uuid = ? and assigned_step_attributes.checklist_element_id = ?        and assigned_step_attributes.is_deleted = 0)LEFT JOIN        users ON        (assigned_step_attributes.value = users.id and custom_fields.type = 'qa') where        step_attributes.step_id = ? and step_attributes.is_deleted = 0  GROUP BY  step_attributes.id ORDER BY step_attributes.sort_order";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 2;
    if (elementId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, elementId);
    }
    _argIndex = 3;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, stepId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfItemUuid = 1;
      final int _cursorIndexOfLabel = 2;
      final int _cursorIndexOfSortOrder = 3;
      final int _cursorIndexOfStepAttributeCount = 4;
      final int _cursorIndexOfUserRoles = 5;
      final int _cursorIndexOfCustomFieldId = 6;
      final int _cursorIndexOfStepId = 7;
      final int _cursorIndexOfStepAttributeUuid = 8;
      final int _cursorIndexOfDescription = 9;
      final int _cursorIndexOfName = 10;
      final int _cursorIndexOfAllowGallery = 11;
      final int _cursorIndexOfAllowedMediaTypes = 12;
      final int _cursorIndexOfMultiple = 13;
      final int _cursorIndexOfDefaultValue = 14;
      final int _cursorIndexOfMaxLength = 15;
      final int _cursorIndexOfMaxValue = 16;
      final int _cursorIndexOfMinLength = 17;
      final int _cursorIndexOfMinValue = 18;
      final int _cursorIndexOfModel = 19;
      final int _cursorIndexOfPossibleValues = 20;
      final int _cursorIndexOfAllowDescription = 21;
      final int _cursorIndexOfDisplayAs = 22;
      final int _cursorIndexOfRequired = 23;
      final int _cursorIndexOfType = 24;
      final int _cursorIndexOfAttributeValue = 25;
      final List<CheckListStepAttributeItems> _result = new ArrayList<CheckListStepAttributeItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CheckListStepAttributeItems _item;
        _item = new CheckListStepAttributeItems();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _item.itemUuid = null;
        } else {
          _item.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _item.label = null;
        } else {
          _item.label = _cursor.getString(_cursorIndexOfLabel);
        }
        if (_cursor.isNull(_cursorIndexOfSortOrder)) {
          _item.sortOrder = null;
        } else {
          _item.sortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        }
        if (_cursor.isNull(_cursorIndexOfStepAttributeCount)) {
          _item.stepAttributeCount = null;
        } else {
          _item.stepAttributeCount = _cursor.getString(_cursorIndexOfStepAttributeCount);
        }
        if (_cursor.isNull(_cursorIndexOfUserRoles)) {
          _item.userRoles = null;
        } else {
          _item.userRoles = _cursor.getString(_cursorIndexOfUserRoles);
        }
        if (_cursor.isNull(_cursorIndexOfCustomFieldId)) {
          _item.customFieldId = null;
        } else {
          _item.customFieldId = _cursor.getInt(_cursorIndexOfCustomFieldId);
        }
        if (_cursor.isNull(_cursorIndexOfStepId)) {
          _item.stepId = null;
        } else {
          _item.stepId = _cursor.getInt(_cursorIndexOfStepId);
        }
        if (_cursor.isNull(_cursorIndexOfStepAttributeUuid)) {
          _item.stepAttributeUuid = null;
        } else {
          _item.stepAttributeUuid = _cursor.getString(_cursorIndexOfStepAttributeUuid);
        }
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _item.description = null;
        } else {
          _item.description = _cursor.getString(_cursorIndexOfDescription);
        }
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        if (_cursor.isNull(_cursorIndexOfAllowGallery)) {
          _item.allowGallery = null;
        } else {
          _item.allowGallery = _cursor.getInt(_cursorIndexOfAllowGallery);
        }
        if (_cursor.isNull(_cursorIndexOfAllowedMediaTypes)) {
          _item.allowedMediaTypes = null;
        } else {
          _item.allowedMediaTypes = _cursor.getString(_cursorIndexOfAllowedMediaTypes);
        }
        if (_cursor.isNull(_cursorIndexOfMultiple)) {
          _item.multiple = null;
        } else {
          _item.multiple = _cursor.getInt(_cursorIndexOfMultiple);
        }
        if (_cursor.isNull(_cursorIndexOfDefaultValue)) {
          _item.defaultValue = null;
        } else {
          _item.defaultValue = _cursor.getInt(_cursorIndexOfDefaultValue);
        }
        if (_cursor.isNull(_cursorIndexOfMaxLength)) {
          _item.maxLength = null;
        } else {
          _item.maxLength = _cursor.getInt(_cursorIndexOfMaxLength);
        }
        if (_cursor.isNull(_cursorIndexOfMaxValue)) {
          _item.maxValue = null;
        } else {
          _item.maxValue = _cursor.getFloat(_cursorIndexOfMaxValue);
        }
        if (_cursor.isNull(_cursorIndexOfMinLength)) {
          _item.minLength = null;
        } else {
          _item.minLength = _cursor.getInt(_cursorIndexOfMinLength);
        }
        if (_cursor.isNull(_cursorIndexOfMinValue)) {
          _item.minValue = null;
        } else {
          _item.minValue = _cursor.getFloat(_cursorIndexOfMinValue);
        }
        if (_cursor.isNull(_cursorIndexOfModel)) {
          _item.model = null;
        } else {
          _item.model = _cursor.getString(_cursorIndexOfModel);
        }
        if (_cursor.isNull(_cursorIndexOfPossibleValues)) {
          _item.possibleValues = null;
        } else {
          _item.possibleValues = _cursor.getString(_cursorIndexOfPossibleValues);
        }
        if (_cursor.isNull(_cursorIndexOfAllowDescription)) {
          _item.allowDescription = null;
        } else {
          _item.allowDescription = _cursor.getInt(_cursorIndexOfAllowDescription);
        }
        if (_cursor.isNull(_cursorIndexOfDisplayAs)) {
          _item.displayAs = null;
        } else {
          _item.displayAs = _cursor.getString(_cursorIndexOfDisplayAs);
        }
        if (_cursor.isNull(_cursorIndexOfRequired)) {
          _item.required = null;
        } else {
          _item.required = _cursor.getInt(_cursorIndexOfRequired);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _item.type = null;
        } else {
          _item.type = _cursor.getString(_cursorIndexOfType);
        }
        if (_cursor.isNull(_cursorIndexOfAttributeValue)) {
          _item.attributeValue = null;
        } else {
          _item.attributeValue = _cursor.getString(_cursorIndexOfAttributeValue);
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
  public List<CheckListPPItems> getPPIcons(final Integer stepId) {
    final String _sql = "SELECT DISTINCT\n"
            + "\tppes.id,\n"
            + "\tppes.icon,\n"
            + "\tppes.label\n"
            + "FROM\n"
            + "\tchecklist_ppes\n"
            + "LEFT JOIN ppes ON (checklist_ppes.ppe_id = ppes.id)\n"
            + "WHERE\n"
            + "\tchecklist_ppes.step_id = ?\n"
            + "AND checklist_ppes.is_deleted = 0\n"
            + "ORDER BY checklist_ppes.id ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfIcon = 1;
      final int _cursorIndexOfLabel = 2;
      final List<CheckListPPItems> _result = new ArrayList<CheckListPPItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CheckListPPItems _item;
        _item = new CheckListPPItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpIcon;
        if (_cursor.isNull(_cursorIndexOfIcon)) {
          _tmpIcon = null;
        } else {
          _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        }
        _item.setIcon(_tmpIcon);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        _item.setLabel(_tmpLabel);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<NcwHazardsItems> getNcmHazards(final Integer itemId, final Integer itemTypeId) {
    final String _sql = "SELECT\n"
            + "\thazards.id,\n"
            + "\thazards.icon,\n"
            + "\thazards.label\n"
            + "FROM\n"
            + "\tncw_hazards\n"
            + "INNER JOIN hazards ON (hazards.id = ncw_hazards.hazard_id)\n"
            + "WHERE\n"
            + "\tncw_hazards.item_id = ?\n"
            + "AND ncw_hazards.item_type_id = ?\n"
            + "AND ncw_hazards.is_deleted = 0;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    _argIndex = 2;
    if (itemTypeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemTypeId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfIcon = 1;
      final int _cursorIndexOfLabel = 2;
      final List<NcwHazardsItems> _result = new ArrayList<NcwHazardsItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NcwHazardsItems _item;
        _item = new NcwHazardsItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpIcon;
        if (_cursor.isNull(_cursorIndexOfIcon)) {
          _tmpIcon = null;
        } else {
          _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        }
        _item.setIcon(_tmpIcon);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        _item.setLabel(_tmpLabel);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ResourceEntity> getCheckListReferances(final Integer itemId) {
    final String _sql = "select * from resources where item_id = ? and is_resource = 0 and is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFileSize = CursorUtil.getColumnIndexOrThrow(_cursor, "file_size");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfIsResource = CursorUtil.getColumnIndexOrThrow(_cursor, "is_resource");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<ResourceEntity> _result = new ArrayList<ResourceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResourceEntity _item;
        _item = new ResourceEntity();
        if (_cursor.isNull(_cursorIndexOfContentType)) {
          _item.contentType = null;
        } else {
          _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        }
        if (_cursor.isNull(_cursorIndexOfDisplayFileName)) {
          _item.displayFileName = null;
        } else {
          _item.displayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        }
        if (_cursor.isNull(_cursorIndexOfFileMd5Checksum)) {
          _item.fileMd5Checksum = null;
        } else {
          _item.fileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        }
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _item.fileName = null;
        } else {
          _item.fileName = _cursor.getString(_cursorIndexOfFileName);
        }
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfFileSize)) {
          _item.fileSize = null;
        } else {
          _item.fileSize = _cursor.getInt(_cursorIndexOfFileSize);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _item.isDownloaded = null;
        } else {
          _item.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        if (_cursor.isNull(_cursorIndexOfIsResource)) {
          _item.isResource = null;
        } else {
          _item.isResource = _cursor.getInt(_cursorIndexOfIsResource);
        }
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _item.itemId = null;
        } else {
          _item.itemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _item.itemTypeId = null;
        } else {
          _item.itemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _item.modified = null;
        } else {
          _item.modified = _cursor.getString(_cursorIndexOfModified);
        }
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _item.uuid = null;
        } else {
          _item.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public ResourceEntity getResource(final Integer itemId) {
    final String _sql = "select * from resources where id = ? and is_resource = 1 and is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFileSize = CursorUtil.getColumnIndexOrThrow(_cursor, "file_size");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfIsResource = CursorUtil.getColumnIndexOrThrow(_cursor, "is_resource");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final ResourceEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new ResourceEntity();
        if (_cursor.isNull(_cursorIndexOfContentType)) {
          _result.contentType = null;
        } else {
          _result.contentType = _cursor.getString(_cursorIndexOfContentType);
        }
        if (_cursor.isNull(_cursorIndexOfDisplayFileName)) {
          _result.displayFileName = null;
        } else {
          _result.displayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        }
        if (_cursor.isNull(_cursorIndexOfFileMd5Checksum)) {
          _result.fileMd5Checksum = null;
        } else {
          _result.fileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        }
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _result.fileName = null;
        } else {
          _result.fileName = _cursor.getString(_cursorIndexOfFileName);
        }
        if (_cursor.isNull(_cursorIndexOfId)) {
          _result.id = null;
        } else {
          _result.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfFileSize)) {
          _result.fileSize = null;
        } else {
          _result.fileSize = _cursor.getInt(_cursorIndexOfFileSize);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _result.isDownloaded = null;
        } else {
          _result.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        if (_cursor.isNull(_cursorIndexOfIsResource)) {
          _result.isResource = null;
        } else {
          _result.isResource = _cursor.getInt(_cursorIndexOfIsResource);
        }
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _result.itemId = null;
        } else {
          _result.itemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _result.itemTypeId = null;
        } else {
          _result.itemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _result.modified = null;
        } else {
          _result.modified = _cursor.getString(_cursorIndexOfModified);
        }
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _result.uuid = null;
        } else {
          _result.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public List<ResourceEntity> getCheckListResourcesEmbedded(final Integer itemId) {
    final String _sql = "select * from resources where item_id = ? and is_resource = 1 and is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfDisplayFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "display_file_name");
      final int _cursorIndexOfFileMd5Checksum = CursorUtil.getColumnIndexOrThrow(_cursor, "file_md5_checksum");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFileSize = CursorUtil.getColumnIndexOrThrow(_cursor, "file_size");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfIsDownloaded = CursorUtil.getColumnIndexOrThrow(_cursor, "is_downloaded");
      final int _cursorIndexOfIsResource = CursorUtil.getColumnIndexOrThrow(_cursor, "is_resource");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<ResourceEntity> _result = new ArrayList<ResourceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResourceEntity _item;
        _item = new ResourceEntity();
        if (_cursor.isNull(_cursorIndexOfContentType)) {
          _item.contentType = null;
        } else {
          _item.contentType = _cursor.getString(_cursorIndexOfContentType);
        }
        if (_cursor.isNull(_cursorIndexOfDisplayFileName)) {
          _item.displayFileName = null;
        } else {
          _item.displayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
        }
        if (_cursor.isNull(_cursorIndexOfFileMd5Checksum)) {
          _item.fileMd5Checksum = null;
        } else {
          _item.fileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        }
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _item.fileName = null;
        } else {
          _item.fileName = _cursor.getString(_cursorIndexOfFileName);
        }
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfFileSize)) {
          _item.fileSize = null;
        } else {
          _item.fileSize = _cursor.getInt(_cursorIndexOfFileSize);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _item.isDownloaded = null;
        } else {
          _item.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        if (_cursor.isNull(_cursorIndexOfIsResource)) {
          _item.isResource = null;
        } else {
          _item.isResource = _cursor.getInt(_cursorIndexOfIsResource);
        }
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _item.itemId = null;
        } else {
          _item.itemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _item.itemTypeId = null;
        } else {
          _item.itemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _item.modified = null;
        } else {
          _item.modified = _cursor.getString(_cursorIndexOfModified);
        }
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _item.uuid = null;
        } else {
          _item.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public AssignedDecisionEntity ifDecisionPointAlreadyUpdated(final String uuid,
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
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _result.assignedChecklistUuid = null;
        } else {
          _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _result.created = null;
        } else {
          _result.created = _cursor.getString(_cursorIndexOfCreated);
        }
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
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _result.modified = null;
        } else {
          _result.modified = _cursor.getString(_cursorIndexOfModified);
        }
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
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _result.uuid = null;
        } else {
          _result.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public List<ResourceLinkItems> getResourceLinks(final Integer itemId) {
    final String _sql = "select * from resource_links where item_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "link");
      final int _cursorIndexOfLinkTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "link_title");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final List<ResourceLinkItems> _result = new ArrayList<ResourceLinkItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResourceLinkItems _item;
        _item = new ResourceLinkItems();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _item.itemId = null;
        } else {
          _item.itemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _item.itemTypeId = null;
        } else {
          _item.itemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfLink)) {
          _item.link = null;
        } else {
          _item.link = _cursor.getString(_cursorIndexOfLink);
        }
        if (_cursor.isNull(_cursorIndexOfLinkTitle)) {
          _item.linkTitle = null;
        } else {
          _item.linkTitle = _cursor.getString(_cursorIndexOfLinkTitle);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _item.modified = null;
        } else {
          _item.modified = _cursor.getString(_cursorIndexOfModified);
        }
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _item.uuid = null;
        } else {
          _item.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public String getItemCommonUuid(final Integer checklistElementId,
      final String assignedChecklistUuid) {
    final String _sql = "select item_uuid from assigned_step_attributes where  checklist_element_id  = ?  and assigned_checklist_uuid = ? limit 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (checklistElementId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistElementId);
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
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
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
  public AssignedStepEntity getAssignedStepUuid(final Integer stepId,
      final String assignedChecklistUuid) {
    final String _sql = "select * from assigned_steps where checklist_element_id = ? and assigned_checklist_uuid = ?";
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
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _result.assignedChecklistUuid = null;
        } else {
          _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _result.created = null;
        } else {
          _result.created = _cursor.getString(_cursorIndexOfCreated);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _result.modified = null;
        } else {
          _result.modified = _cursor.getString(_cursorIndexOfModified);
        }
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
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _result.uuid = null;
        } else {
          _result.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public List<UserItems> getUsers(final Integer locationId, final Integer departmentId,
      final String[] groupIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.group_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.full_name ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tusers AS User");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.user_id = User.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND User.group_id IN (");
    final int _inputSize = groupIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ((");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\t\tUserLocationDepartment.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\t\tAND UserLocationDepartment.department_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tOR ( User.is_administrator = 1 ))");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : groupIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2 + _inputSize;
    if (departmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, departmentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfGroupId = 1;
      final int _cursorIndexOfUuid = 2;
      final int _cursorIndexOfFullName = 3;
      final List<UserItems> _result = new ArrayList<UserItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserItems _item_1;
        _item_1 = new UserItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item_1.setId(_tmpId);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _item_1.setGroupId(_tmpGroupId);
        final String _tmpUuid;
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _item_1.setUuid(_tmpUuid);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item_1.setFullName(_tmpFullName);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserItems> getUsers(final Integer locationId, final String[] groupIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDISTINCT User.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.group_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.full_name ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tusers AS User");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.user_id = User.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND User.group_id IN (");
    final int _inputSize = groupIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ((");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\t\tUserLocationDepartment.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tOR ( User.is_administrator = 1 ))");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : groupIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfGroupId = 1;
      final int _cursorIndexOfUuid = 2;
      final int _cursorIndexOfFullName = 3;
      final List<UserItems> _result = new ArrayList<UserItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserItems _item_1;
        _item_1 = new UserItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item_1.setId(_tmpId);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _item_1.setGroupId(_tmpGroupId);
        final String _tmpUuid;
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _item_1.setUuid(_tmpUuid);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item_1.setFullName(_tmpFullName);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserMinimal validateQA(final String username, final String password) {
    final String _sql = "SELECT\n"
            + "\tUser.id,\n"
            + "\tUser.group_id,\n"
            + "\tUser.is_administrator, \n"
            + "\tUser.full_name \n"
            + "FROM\n"
            + "\tusers AS User \n"
            + "WHERE\n"
            + "\tlower( User.username ) = ? \n"
            + "\tAND User.password = ? \n"
            + "\tAND User.is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfGroupId = 1;
      final int _cursorIndexOfIsAdministrator = 2;
      final int _cursorIndexOfFullName = 3;
      final UserMinimal _result;
      if(_cursor.moveToFirst()) {
        _result = new UserMinimal();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _result.setGroupId(_tmpGroupId);
        final boolean _tmpIsAdministrator;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAdministrator);
        _tmpIsAdministrator = _tmp != 0;
        _result.setAdministrator(_tmpIsAdministrator);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
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
  public List<CheckListPPItems> getInformationIcons(final Integer checklistId) {
    final String _sql = "SELECT DISTINCT\n"
            + "\tppes.id,\n"
            + "\tppes.icon,\n"
            + "\tppes.label\n"
            + "FROM\n"
            + "\tchecklist_elements\n"
            + "INNER JOIN checklist_ppes ON (checklist_ppes.step_id = checklist_elements.item_id)\n"
            + "INNER JOIN ppes ON (ppes.id = checklist_ppes.ppe_id)\n"
            + "WHERE\n"
            + "\tchecklist_elements.checklist_id = ?\n"
            + "AND checklist_elements.is_deleted = 0\n"
            + "AND checklist_elements.item_type_id IN (1, 8, 12)\n"
            + "AND checklist_ppes.is_deleted = 0\n"
            + "ORDER BY ppes.id ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfIcon = 1;
      final int _cursorIndexOfLabel = 2;
      final List<CheckListPPItems> _result = new ArrayList<CheckListPPItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CheckListPPItems _item;
        _item = new CheckListPPItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpIcon;
        if (_cursor.isNull(_cursorIndexOfIcon)) {
          _tmpIcon = null;
        } else {
          _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        }
        _item.setIcon(_tmpIcon);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        _item.setLabel(_tmpLabel);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AssignedStepAttributesEntity ifStepAttributeAlreadyExecuted(final String itemUUID,
      final Integer stepAttributeId, final Integer checklistElementId, final Integer stepId) {
    final String _sql = "select * from assigned_step_attributes where item_uuid = ? and checklist_element_id = ? and step_id = ? and step_attribute_id = ? and is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (itemUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemUUID);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistElementId);
    }
    _argIndex = 3;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepId);
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
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _result.assignedChecklistUuid = null;
        } else {
          _result.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _result.checklistElementId = null;
        } else {
          _result.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _result.created = null;
        } else {
          _result.created = _cursor.getString(_cursorIndexOfCreated);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _result.itemUuid = null;
        } else {
          _result.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _result.modified = null;
        } else {
          _result.modified = _cursor.getString(_cursorIndexOfModified);
        }
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
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _result.uuid = null;
        } else {
          _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        }
        if (_cursor.isNull(_cursorIndexOfValue)) {
          _result.value = null;
        } else {
          _result.value = _cursor.getString(_cursorIndexOfValue);
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
  public String getValueifStepAttributeAlreadyExecuted(final String itemUUID,
      final Integer stepAttributeId, final Integer checklistElementId, final Integer stepId) {
    final String _sql = "select value from assigned_step_attributes where item_uuid = ? and checklist_element_id = ? and step_id = ? and step_attribute_id = ? and is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (itemUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemUUID);
    }
    _argIndex = 2;
    if (checklistElementId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistElementId);
    }
    _argIndex = 3;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepId);
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
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
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
  public ChecklistDetailItems getNextItemDeffered(final int offset, final int checkListId,
      final String checkListUuid) {
    final String _sql = "SELECT\n"
            + "distinct checklist_elements.checklist_id,\n"
            + "checklist_elements.id,\n"
            + "checklist_elements.item_type_id,\n"
            + "checklist_elements.item_id,\n"
            + "checklist_elements.item_uuid,\n"
            + "checklist_elements.parent_id,\n"
            + "checklist_elements.sort_order,\n"
            + "checklist_elements.sequence_no,\n"
            + "assigned_ncw.acknowledged,assigned_steps.status,assigned_decisions.status as decisionStatus , logs.action as imageTextStatus ,(select item_type_id as parent_type FROM checklist_elements c where c.id = checklist_elements.parent_id ) as parent_type, (select status from assigned_steps where checklist_element_id =  checklist_elements.parent_id AND assigned_steps.assigned_checklist_uuid = ?) as parent_status, CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.item_description, checklist_elements.title),'') ELSE ifnull(checklist_elements.title,'') END AS title,\n"
            + "CASE WHEN checklist_elements.item_type_id IN (1, 8, 12) THEN ifnull(coalesce(logs.step_action, checklist_elements.description),'') ELSE ifnull(coalesce(logs.item_description, checklist_elements.description),'') END AS description\n"
            + "FROM\n"
            + "checklist_elements\n"
            + "LEFT OUTER JOIN resources ON ( checklist_elements.item_id = resources.id AND checklist_elements.item_type_id = 10 ) \n"
            + "LEFT JOIN assigned_ncw ON ( checklist_elements.id = assigned_ncw.checklist_element_id AND assigned_ncw.assigned_checklist_uuid = ? AND assigned_ncw.is_deleted = 0) LEFT JOIN assigned_steps ON ( checklist_elements.id = assigned_steps.checklist_element_id AND assigned_steps.assigned_checklist_uuid = ? AND assigned_steps.is_deleted = 0) LEFT JOIN assigned_decisions ON ( checklist_elements.id = assigned_decisions.checklist_element_id AND assigned_decisions.assigned_checklist_uuid = ? AND assigned_decisions.is_deleted = 0) LEFT JOIN logs ON ( checklist_elements.id = logs.checklist_element_id and (checklist_elements.item_type_id = 7 OR checklist_elements.item_type_id = 10 or logs.action = 19) AND logs.assigned_checklist_uuid = ? ) WHERE\n"
            + "((WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT id,parent_id,item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IS NULL OR (WITH RECURSIVE checklist_path (id,parent_id,item_type_id) AS\n"
            + "\t\t\t(\n"
            + "\t\t\t  SELECT g.id,g.parent_id,g.item_type_id\n"
            + "\t\t\t\tFROM checklist_elements g\n"
            + "\t\t\t\tWHERE g.id = checklist_elements.id \n"
            + "\t\t\t  UNION ALL\n"
            + "\t\t\t  SELECT c.id,c.parent_id,c.item_type_id\n"
            + "\t\t\t\tFROM checklist_path AS cp JOIN checklist_elements AS c\n"
            + "\t\t\t\t  ON cp.parent_id = c.id\n"
            + "\t\t\t)\n"
            + "\t\t\tSELECT id FROM checklist_path where item_type_id = 2 and id != checklist_elements.id\n"
            + "\n"
            + "        ) IN (select checklist_element_id from assigned_decisions where assigned_decisions.status = 1 AND assigned_decisions.assigned_checklist_uuid = ? and assigned_decisions.is_deleted = 0))\n"
            + "AND checklist_elements.checklist_id =  ? AND checklist_elements.is_deleted = 0 \n"
            + "AND checklist_elements.item_type_id <> 9 AND (assigned_ncw.acknowledged = 3 or assigned_steps.status = 3 or assigned_decisions.status = 3 OR parent_status = 3) ORDER BY\n"
            + "checklist_elements.sort_order ASC limit 1 offset ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 2;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 3;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 4;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 5;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 6;
    if (checkListUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUuid);
    }
    _argIndex = 7;
    _statement.bindLong(_argIndex, checkListId);
    _argIndex = 8;
    _statement.bindLong(_argIndex, offset);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfAcknowledged = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfDecisionStatus = 10;
      final int _cursorIndexOfImageTextStatus = 11;
      final int _cursorIndexOfParentType = 12;
      final int _cursorIndexOfParentStatus = 13;
      final int _cursorIndexOfTitle = 14;
      final int _cursorIndexOfDescription = 15;
      final ChecklistDetailItems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistDetailItems();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpAcknowledged;
        if (_cursor.isNull(_cursorIndexOfAcknowledged)) {
          _tmpAcknowledged = null;
        } else {
          _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        }
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpDecisionStatus;
        if (_cursor.isNull(_cursorIndexOfDecisionStatus)) {
          _tmpDecisionStatus = null;
        } else {
          _tmpDecisionStatus = _cursor.getInt(_cursorIndexOfDecisionStatus);
        }
        _result.setDecisionStatus(_tmpDecisionStatus);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _result.setImageTextStatus(_tmpImageTextStatus);
        final Integer _tmpParentType;
        if (_cursor.isNull(_cursorIndexOfParentType)) {
          _tmpParentType = null;
        } else {
          _tmpParentType = _cursor.getInt(_cursorIndexOfParentType);
        }
        _result.setParentType(_tmpParentType);
        final Integer _tmpParentStatus;
        if (_cursor.isNull(_cursorIndexOfParentStatus)) {
          _tmpParentStatus = null;
        } else {
          _tmpParentStatus = _cursor.getInt(_cursorIndexOfParentStatus);
        }
        _result.setParentStatus(_tmpParentStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public List<UserItems> getUsersForTheLocation(final String assignedChecklistUuid,
      final Integer locationId, final Integer departmentId) {
    final String _sql = "SELECT\n"
            + "\tUser.id,\n"
            + "\tUser.uuid,\n"
            + "\tUser.full_name,\n"
            + "\tUser.group_id,\n"
            + "\tRole.name AS role,\n"
            + "\tAssignedUser.assigned_checklist_uuid  \n"
            + "FROM\n"
            + "\tusers AS User\n"
            + "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON ( UserLocationDepartment.user_id = User.id )\n"
            + "\tLEFT JOIN assigned_users AS AssignedUser ON (\n"
            + "\t\tAssignedUser.user_id = User.id \n"
            + "\t\tAND AssignedUser.is_deleted = 0 \n"
            + "\t\tAND AssignedUser.assigned_checklist_uuid = ? \n"
            + "\t)\n"
            + "\tLEFT JOIN groups AS Role ON ( Role.id = User.group_id )\n"
            + "WHERE\n"
            + "\tUser.is_deleted = 0 \n"
            + "\tAND User.group_id NOT IN ( 1, 7 ) \n"
            + "\tAND ((\n"
            + "\t\tUserLocationDepartment.is_deleted = 0 \n"
            + "\t\tAND UserLocationDepartment.location_id = ? \n"
            + "\t\tAND UserLocationDepartment.department_id = ? \n"
            + "\t\t) \n"
            + "\tOR User.is_administrator = 1)\n"
            + "ORDER BY\n"
            + "\tAssignedUser.assigned_checklist_uuid DESC, Role.id ASC\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (departmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, departmentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfUuid = 1;
      final int _cursorIndexOfFullName = 2;
      final int _cursorIndexOfGroupId = 3;
      final int _cursorIndexOfRole = 4;
      final int _cursorIndexOfAssignedChecklistUuid = 5;
      final List<UserItems> _result = new ArrayList<UserItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserItems _item;
        _item = new UserItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _item.setUuid(_tmpUuid);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _item.setGroupId(_tmpGroupId);
        if (_cursor.isNull(_cursorIndexOfRole)) {
          _item.role = null;
        } else {
          _item.role = _cursor.getString(_cursorIndexOfRole);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _item.assignedChecklistUuid = null;
        } else {
          _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
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
  public List<UserItems> getUsersForTheLocation(final String assignedChecklistUuid,
      final Integer locationId) {
    final String _sql = "SELECT\n"
            + "\tDISTINCT User.id,\n"
            + "\tUser.uuid,\n"
            + "\tUser.full_name,\n"
            + "\tUser.group_id,\n"
            + "\tRole.name AS role,\n"
            + "\tAssignedUser.assigned_checklist_uuid  \n"
            + "FROM\n"
            + "\tusers AS User\n"
            + "\tLEFT JOIN user_location_departments AS UserLocationDepartment ON ( UserLocationDepartment.user_id = User.id )\n"
            + "\tLEFT JOIN assigned_users AS AssignedUser ON (\n"
            + "\t\tAssignedUser.user_id = User.id \n"
            + "\t\tAND AssignedUser.is_deleted = 0 \n"
            + "\t\tAND AssignedUser.assigned_checklist_uuid = ? \n"
            + "\t)\n"
            + "\tLEFT JOIN groups AS Role ON ( Role.id = User.group_id )\n"
            + "WHERE\n"
            + "\tUser.is_deleted = 0 \n"
            + "\tAND User.group_id NOT IN ( 1, 7 ) \n"
            + "\tAND ((\n"
            + "\t\tUserLocationDepartment.is_deleted = 0 \n"
            + "\t\tAND UserLocationDepartment.location_id = ? \n"
            + "\t\t) \n"
            + "\tOR User.is_administrator = 1)\n"
            + "ORDER BY\n"
            + "\tAssignedUser.assigned_checklist_uuid DESC, Role.id ASC\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
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
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfUuid = 1;
      final int _cursorIndexOfFullName = 2;
      final int _cursorIndexOfGroupId = 3;
      final int _cursorIndexOfRole = 4;
      final int _cursorIndexOfAssignedChecklistUuid = 5;
      final List<UserItems> _result = new ArrayList<UserItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserItems _item;
        _item = new UserItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _item.setUuid(_tmpUuid);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _item.setGroupId(_tmpGroupId);
        if (_cursor.isNull(_cursorIndexOfRole)) {
          _item.role = null;
        } else {
          _item.role = _cursor.getString(_cursorIndexOfRole);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _item.assignedChecklistUuid = null;
        } else {
          _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
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
  public boolean isChildExecuted(final String assignedChecklistUuid, final Integer parentId) {
    final String _sql = "SELECT \n"
            + "        IFNULL( COUNT( COALESCE( AssignedNCW.acknowledged, (SELECT action FROM logs WHERE checklist_element_id = ChecklistElement.id AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18 ) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) ) ) / COUNT( ChecklistElement.id ), 1 ) \n"
            + "        FROM \n"
            + "        checklist_elements AS ChecklistElement \n"
            + "        LEFT JOIN assigned_ncw AS AssignedNCW ON ( \n"
            + "        AssignedNCW.checklist_element_id = ChecklistElement.id  \n"
            + "        AND AssignedNCW.assigned_checklist_uuid = ?  \n"
            + "        AND AssignedNCW.is_deleted = 0)\n"
            + "        WHERE \n"
            + "        ChecklistElement.parent_id = ?\n"
            + "        AND ChecklistElement.is_deleted = 0\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, parentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ParentDetailItem getParentDetail(final Integer parentId, final String checklistUuid) {
    final String _sql = "SELECT   \n"
            + "        checklist_elements.checklist_id, \n"
            + "        checklist_elements.id, \n"
            + "        checklist_elements.item_type_id, \n"
            + "        checklist_elements.item_id, \n"
            + "        checklist_elements.item_uuid, \n"
            + "        checklist_elements.parent_id, \n"
            + "        checklist_elements.sort_order, \n"
            + "        checklist_elements.sequence_no, \n"
            + "        ParentStep.status,\n"
            + "        IFNULL( checklist_elements.title, '' ) AS title, \n"
            + "        IFNULL( checklist_elements.description, '' ) AS description from checklist_elements         LEFT JOIN assigned_steps AS ParentStep ON (ParentStep.checklist_element_id = ? AND ParentStep.assigned_checklist_uuid =  ? AND ParentStep.is_deleted = 0 )         where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, parentId);
    }
    _argIndex = 2;
    if (checklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUuid);
    }
    _argIndex = 3;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, parentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfElementId = 1;
      final int _cursorIndexOfItemTypeId = 2;
      final int _cursorIndexOfItemId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfParentItemId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfSequenceNo = 7;
      final int _cursorIndexOfStatus = 8;
      final int _cursorIndexOfTitle = 9;
      final int _cursorIndexOfDescription = 10;
      final ParentDetailItem _result;
      if(_cursor.moveToFirst()) {
        _result = new ParentDetailItem();
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _result.setChecklistId(_tmpChecklistId);
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _result.setElementId(_tmpElementId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _result.setItemId(_tmpItemId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _result.setItemUuid(_tmpItemUuid);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _result.setParentItemId(_tmpParentItemId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _result.setSequenceNo(_tmpSequenceNo);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.setDescription(_tmpDescription);
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
  public boolean isAnyDecisionChildExecuted(final String assignedChecklistUuid,
      final Integer elementId) {
    final String _sql = "SELECT\n"
            + "        COUNT(ChecklistElement.id)\n"
            + "    FROM\n"
            + "        assigned_checklists AS AssignedChecklist\n"
            + "    LEFT JOIN checklist_elements AS ChecklistElement ON ( ChecklistElement.checklist_id = AssignedChecklist.checklist_id )\n"
            + "    LEFT JOIN checklist_elements AS StepChildElement ON (\n"
            + "         StepChildElement.checklist_id = ChecklistElement.checklist_id\n"
            + "         AND StepChildElement.parent_id = ChecklistElement.id\n"
            + "         AND ChecklistElement.item_type_id IN ( 1, 8, 12 )\n"
            + "         AND StepChildElement.is_deleted = 0\n"
            + "        )\n"
            + "    LEFT JOIN assigned_steps AS AssignedStep ON (\n"
            + "         AssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid\n"
            + "         AND AssignedStep.checklist_element_id = ChecklistElement.id\n"
            + "         AND AssignedStep.is_deleted = 0\n"
            + "        )\n"
            + "    LEFT JOIN assigned_decisions AS AssignedDecision ON (\n"
            + "         AssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid\n"
            + "         AND AssignedDecision.checklist_element_id = ChecklistElement.id\n"
            + "         AND AssignedDecision.is_deleted = 0\n"
            + "        )\n"
            + "    LEFT JOIN assigned_ncw AS AssignedNCW ON (\n"
            + "         AssignedNCW.assigned_checklist_uuid = AssignedChecklist.uuid\n"
            + "         AND (\n"
            + "          AssignedNCW.checklist_element_id = ChecklistElement.id\n"
            + "          OR AssignedNCW.checklist_element_id = StepChildElement.id\n"
            + "         )\n"
            + "         AND AssignedNCW.is_deleted = 0\n"
            + "        )\n"
            + "    WHERE\n"
            + "        AssignedChecklist.uuid = ?\n"
            + "    AND ChecklistElement.is_deleted = 0\n"
            + "    AND COALESCE( AssignedStep.status,\n"
            + "         CASE\n"
            + "          WHEN AssignedDecision.status IN ( 0, 1 ) THEN\n"
            + "          1 ELSE NULL\n"
            + "         END,\n"
            + "         AssignedNCW.acknowledged,\n"
            + "         (SELECT action FROM logs WHERE ( checklist_element_id = ChecklistElement.id OR checklist_element_id = StepChildElement.id ) AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18 ) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1),\n"
            + "         0) <> 0\tAND ChecklistElement.parent_id = ?\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
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
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean isAnyElementAfterDecisionExecuted(final String assignedChecklistUuid,
      final Integer sortOrder) {
    final String _sql = "SELECT\n"
            + "        COUNT(ChecklistElement.id)\n"
            + "    FROM\n"
            + "        assigned_checklists AS AssignedChecklist\n"
            + "    LEFT JOIN checklist_elements AS ChecklistElement ON ( ChecklistElement.checklist_id = AssignedChecklist.checklist_id )\n"
            + "    LEFT JOIN checklist_elements AS StepChildElement ON (\n"
            + "         StepChildElement.checklist_id = ChecklistElement.checklist_id\n"
            + "         AND StepChildElement.parent_id = ChecklistElement.id\n"
            + "         AND ChecklistElement.item_type_id IN ( 1, 8, 12 )\n"
            + "         AND StepChildElement.is_deleted = 0\n"
            + "        )\n"
            + "    LEFT JOIN assigned_steps AS AssignedStep ON (\n"
            + "         AssignedStep.assigned_checklist_uuid = AssignedChecklist.uuid\n"
            + "         AND AssignedStep.checklist_element_id = ChecklistElement.id\n"
            + "         AND AssignedStep.is_deleted = 0\n"
            + "        )\n"
            + "    LEFT JOIN assigned_decisions AS AssignedDecision ON (\n"
            + "         AssignedDecision.assigned_checklist_uuid = AssignedChecklist.uuid\n"
            + "         AND AssignedDecision.checklist_element_id = ChecklistElement.id\n"
            + "         AND AssignedDecision.is_deleted = 0\n"
            + "        )\n"
            + "    LEFT JOIN assigned_ncw AS AssignedNCW ON (\n"
            + "         AssignedNCW.assigned_checklist_uuid = AssignedChecklist.uuid\n"
            + "         AND (\n"
            + "          AssignedNCW.checklist_element_id = ChecklistElement.id\n"
            + "          OR AssignedNCW.checklist_element_id = StepChildElement.id\n"
            + "         )\n"
            + "         AND AssignedNCW.is_deleted = 0\n"
            + "        )\n"
            + "    WHERE\n"
            + "        AssignedChecklist.uuid = ?\n"
            + "    AND ChecklistElement.is_deleted = 0\n"
            + "    AND COALESCE( AssignedStep.status,\n"
            + "         CASE\n"
            + "          WHEN AssignedDecision.status IN ( 0, 1 ) THEN\n"
            + "          1 ELSE NULL\n"
            + "         END,\n"
            + "         AssignedNCW.acknowledged,\n"
            + "         (SELECT action FROM logs WHERE ( checklist_element_id = ChecklistElement.id OR checklist_element_id = StepChildElement.id ) AND ChecklistElement.item_type_id IN ( 7, 10 ) AND action IN ( 17, 18 ) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1),\n"
            + "         0) <> 0\tAND ChecklistElement.sort_order\t> ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (sortOrder == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, sortOrder);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ChecklistIDetailtems getChecklistDetail(final String assignedChecklistUuid) {
    final String _sql = "SELECT\n"
            + "\tChecklist.id,\n"
            + "\tAssignedChecklist.uuid,\n"
            + "\tAssignedChecklist.checklist_status AS status,\n"
            + "\tChecklistType.type,\n"
            + "\tChecklist.is_sequential,\n"
            + "\tChecklistTitle.title,\n"
            + "\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,\n"
            + "\tRoomEquipment.room_id,\n"
            + "\tRoomEquipment.equipment_id,\n"
            + "\tRoom.name AS room,\n"
            + "\tEquipment.name AS equipment,\n"
            + "\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,\n"
            + "\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus\n"
            + "FROM\n"
            + "\tassigned_checklists AS AssignedChecklist\n"
            + "\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n"
            + "\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n"
            + "\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n"
            + "\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n"
            + "\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n"
            + "\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n"
            + "\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )\n"
            + "\tLEFT JOIN assigned_departments AS AssignedDepartment ON (\n"
            + "\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "\t\tAND AssignedDepartment.is_deleted = 0 \n"
            + "\t)\n"
            + "\tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )\n"
            + "WHERE \n"
            + "\tAssignedChecklist.uuid = ? \n"
            + "\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) \n"
            + "\tAND AssignedChecklist.is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = 0;
      final int _cursorIndexOfUuid = 1;
      final int _cursorIndexOfStatus = 2;
      final int _cursorIndexOfChecklistType = 3;
      final int _cursorIndexOfIsSequential = 4;
      final int _cursorIndexOfTitle = 5;
      final int _cursorIndexOfDepartmentId = 6;
      final int _cursorIndexOfRoomId = 7;
      final int _cursorIndexOfEquipmentId = 8;
      final int _cursorIndexOfRoom = 9;
      final int _cursorIndexOfEquipment = 10;
      final int _cursorIndexOfDueDays = 11;
      final int _cursorIndexOfChecklistStatus = 12;
      final ChecklistIDetailtems _result;
      if(_cursor.moveToFirst()) {
        _result = new ChecklistIDetailtems();
        final Integer _tmpChecklistId;
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _tmpChecklistId = null;
        } else {
          _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        _result.setChecklistId(_tmpChecklistId);
        final String _tmpUuid;
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _result.setUuid(_tmpUuid);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final Integer _tmpChecklistType;
        if (_cursor.isNull(_cursorIndexOfChecklistType)) {
          _tmpChecklistType = null;
        } else {
          _tmpChecklistType = _cursor.getInt(_cursorIndexOfChecklistType);
        }
        _result.setChecklistType(_tmpChecklistType);
        final boolean _tmpIsSequential;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSequential);
        _tmpIsSequential = _tmp != 0;
        _result.setSequential(_tmpIsSequential);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        if (_cursor.isNull(_cursorIndexOfDepartmentId)) {
          _result.departmentId = null;
        } else {
          _result.departmentId = _cursor.getInt(_cursorIndexOfDepartmentId);
        }
        final Integer _tmpRoomId;
        if (_cursor.isNull(_cursorIndexOfRoomId)) {
          _tmpRoomId = null;
        } else {
          _tmpRoomId = _cursor.getInt(_cursorIndexOfRoomId);
        }
        _result.setRoomId(_tmpRoomId);
        final Integer _tmpEquipmentId;
        if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
          _tmpEquipmentId = null;
        } else {
          _tmpEquipmentId = _cursor.getInt(_cursorIndexOfEquipmentId);
        }
        _result.setEquipmentId(_tmpEquipmentId);
        if (_cursor.isNull(_cursorIndexOfRoom)) {
          _result.room = null;
        } else {
          _result.room = _cursor.getString(_cursorIndexOfRoom);
        }
        if (_cursor.isNull(_cursorIndexOfEquipment)) {
          _result.equipment = null;
        } else {
          _result.equipment = _cursor.getString(_cursorIndexOfEquipment);
        }
        if (_cursor.isNull(_cursorIndexOfDueDays)) {
          _result.dueDays = null;
        } else {
          _result.dueDays = _cursor.getString(_cursorIndexOfDueDays);
        }
        final String _tmpChecklistStatus;
        if (_cursor.isNull(_cursorIndexOfChecklistStatus)) {
          _tmpChecklistStatus = null;
        } else {
          _tmpChecklistStatus = _cursor.getString(_cursorIndexOfChecklistStatus);
        }
        _result.setChecklistStatus(_tmpChecklistStatus);
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
  public DataSource.Factory<Integer, CaptureDataItem> getAllCapturedData(
      final String checklistUuid) {
    final String _sql = "SELECT checklist_elements.sequence_no,step_attributes.label ,assigned_step_attributes.value,custom_fields.type from assigned_step_attributes  left join checklist_elements on (checklist_elements.id = assigned_step_attributes.checklist_element_id) left join step_attributes on (step_attributes.id = assigned_step_attributes.step_attribute_id) inner join custom_fields on (step_attributes.custom_field_id = custom_fields.id and step_attributes.id = assigned_step_attributes.step_attribute_id) where assigned_step_attributes.assigned_checklist_uuid = ?   group by sequence_no order by checklist_elements.sort_order";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUuid);
    }
    return new DataSource.Factory<Integer, CaptureDataItem>() {
      @Override
      public LimitOffsetDataSource<CaptureDataItem> create() {
        return new LimitOffsetDataSource<CaptureDataItem>(__db, _statement, false, true , "assigned_step_attributes", "checklist_elements", "step_attributes", "custom_fields") {
          @Override
          protected List<CaptureDataItem> convertRows(Cursor cursor) {
            final int _cursorIndexOfSequenceNo = 0;
            final int _cursorIndexOfLabel = 1;
            final int _cursorIndexOfValue = 2;
            final int _cursorIndexOfType = 3;
            final List<CaptureDataItem> _res = new ArrayList<CaptureDataItem>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CaptureDataItem _item;
              _item = new CaptureDataItem();
              final String _tmpSequenceNo;
              if (cursor.isNull(_cursorIndexOfSequenceNo)) {
                _tmpSequenceNo = null;
              } else {
                _tmpSequenceNo = cursor.getString(_cursorIndexOfSequenceNo);
              }
              _item.setSequenceNo(_tmpSequenceNo);
              final String _tmpLabel;
              if (cursor.isNull(_cursorIndexOfLabel)) {
                _tmpLabel = null;
              } else {
                _tmpLabel = cursor.getString(_cursorIndexOfLabel);
              }
              _item.setLabel(_tmpLabel);
              final String _tmpValue;
              if (cursor.isNull(_cursorIndexOfValue)) {
                _tmpValue = null;
              } else {
                _tmpValue = cursor.getString(_cursorIndexOfValue);
              }
              _item.setValue(_tmpValue);
              final String _tmpType;
              if (cursor.isNull(_cursorIndexOfType)) {
                _tmpType = null;
              } else {
                _tmpType = cursor.getString(_cursorIndexOfType);
              }
              _item.setType(_tmpType);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public List<ChecklistElementsEntity> getChilds(final Integer parentId) {
    final String _sql = "select * from checklist_elements where parent_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, parentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_id");
      final int _cursorIndexOfItemTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "item_type_id");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_id");
      final int _cursorIndexOfSequenceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sequence_no");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sort_order");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final List<ChecklistElementsEntity> _result = new ArrayList<ChecklistElementsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChecklistElementsEntity _item;
        _item = new ChecklistElementsEntity();
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _item.checklistId = null;
        } else {
          _item.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _item.description = null;
        } else {
          _item.description = _cursor.getString(_cursorIndexOfDescription);
        }
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
        }
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _item.itemId = null;
        } else {
          _item.itemId = _cursor.getInt(_cursorIndexOfItemId);
        }
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _item.itemTypeId = null;
        } else {
          _item.itemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _item.itemUuid = null;
        } else {
          _item.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _item.modified = null;
        } else {
          _item.modified = _cursor.getString(_cursorIndexOfModified);
        }
        if (_cursor.isNull(_cursorIndexOfParentId)) {
          _item.parentId = null;
        } else {
          _item.parentId = _cursor.getInt(_cursorIndexOfParentId);
        }
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _item.sequenceNo = null;
        } else {
          _item.sequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        if (_cursor.isNull(_cursorIndexOfSortOrder)) {
          _item.sortOrder = null;
        } else {
          _item.sortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        }
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _item.title = null;
        } else {
          _item.title = _cursor.getString(_cursorIndexOfTitle);
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
  public boolean ifUserLocationDepartmentIsSame(final Integer userId, final int locationId,
      final Integer departmentId) {
    final String _sql = "SELECT (CASE WHEN COUNT(id) > 0 THEN 1 ELSE 0 END)\n"
            + "FROM\n"
            + "\tuser_location_departments\n"
            + "WHERE\n"
            + "\tuser_id = ? \n"
            + "\tAND location_id = ? \n"
            + "\tAND department_id = ?\n"
            + "\tAND is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (departmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, departmentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean ifUserLocationIsSame(final Integer userId, final int locationId) {
    final String _sql = "SELECT (CASE WHEN COUNT(id) > 0 THEN 1 ELSE 0 END)\n"
            + "FROM\n"
            + "\tuser_location_departments\n"
            + "WHERE\n"
            + "\tuser_id = ? \n"
            + "\tAND location_id = ? \n"
            + "\tAND is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getGroupIds() {
    final String _sql = "SELECT GROUP_CONCAT(id) FROM groups";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = _tmp;
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
  public List<AssignedStepFileResourceEntity> getFilesByAttributeId(final Integer stepAttributeId,
      final String assignedChecklistUuid, final Integer elementId) {
    final String _sql = "SELECT assigned_step_resources.uuid,assigned_step_resources.checklist_element_id,assigned_step_resources.assigned_checklist_uuid,\n"
            + "assigned_step_resources.content_type,assigned_step_resources.created,assigned_step_resources.display_file_name,\n"
            + "assigned_step_resources.file_md5_checksum,assigned_step_resources.file_name,assigned_step_resources.is_deleted,\n"
            + "assigned_step_resources.is_downloaded,assigned_step_resources.is_uploaded,assigned_step_resources.item_id,\n"
            + "assigned_step_resources.item_type_id,assigned_step_resources.user_id,assigned_step_resources.sync_status,\n"
            + "assigned_step_resources.modified \n"
            + "from \n"
            + "assigned_step_attributes \n"
            + "INNER join \n"
            + "assigned_step_resources \n"
            + "ON \n"
            + "(assigned_step_attributes.value = assigned_step_resources.uuid and assigned_step_resources.is_deleted = 0) \n"
            + "where\n"
            + "assigned_step_attributes.step_attribute_id = ?\n"
            + " and assigned_step_attributes.is_deleted = 0 and assigned_step_attributes.assigned_checklist_uuid = ? and assigned_step_resources.checklist_element_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (stepAttributeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepAttributeId);
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
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuid = 0;
      final int _cursorIndexOfChecklistElementId = 1;
      final int _cursorIndexOfAssignedChecklistUuid = 2;
      final int _cursorIndexOfContentType = 3;
      final int _cursorIndexOfCreated = 4;
      final int _cursorIndexOfDisplayFileName = 5;
      final int _cursorIndexOfFileMd5Checksum = 6;
      final int _cursorIndexOfFileName = 7;
      final int _cursorIndexOfIsDeleted = 8;
      final int _cursorIndexOfIsDownloaded = 9;
      final int _cursorIndexOfIsUploaded = 10;
      final int _cursorIndexOfItemId = 11;
      final int _cursorIndexOfItemTypeId = 12;
      final int _cursorIndexOfUserId = 13;
      final int _cursorIndexOfSyncStatus = 14;
      final int _cursorIndexOfModified = 15;
      final List<AssignedStepFileResourceEntity> _result = new ArrayList<AssignedStepFileResourceEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignedStepFileResourceEntity _item;
        _item = new AssignedStepFileResourceEntity();
        final String _tmpUuid;
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _tmpUuid = null;
        } else {
          _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        }
        _item.setUuid(_tmpUuid);
        final Integer _tmpChecklist_element_id;
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _tmpChecklist_element_id = null;
        } else {
          _tmpChecklist_element_id = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        _item.setChecklist_element_id(_tmpChecklist_element_id);
        final String _tmpAssigned_checklist_uuid;
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _tmpAssigned_checklist_uuid = null;
        } else {
          _tmpAssigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
        _item.setAssigned_checklist_uuid(_tmpAssigned_checklist_uuid);
        final String _tmpContent_type;
        if (_cursor.isNull(_cursorIndexOfContentType)) {
          _tmpContent_type = null;
        } else {
          _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        }
        _item.setContent_type(_tmpContent_type);
        final String _tmpCreated;
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _tmpCreated = null;
        } else {
          _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
        }
        _item.setCreated(_tmpCreated);
        final String _tmpDisplay_file_name;
        if (_cursor.isNull(_cursorIndexOfDisplayFileName)) {
          _tmpDisplay_file_name = null;
        } else {
          _tmpDisplay_file_name = _cursor.getString(_cursorIndexOfDisplayFileName);
        }
        _item.setDisplay_file_name(_tmpDisplay_file_name);
        final String _tmpFile_md5_checksum;
        if (_cursor.isNull(_cursorIndexOfFileMd5Checksum)) {
          _tmpFile_md5_checksum = null;
        } else {
          _tmpFile_md5_checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
        }
        _item.setFile_md5_checksum(_tmpFile_md5_checksum);
        final String _tmpFile_name;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFile_name = null;
        } else {
          _tmpFile_name = _cursor.getString(_cursorIndexOfFileName);
        }
        _item.setFile_name(_tmpFile_name);
        final Integer _tmpIs_deleted;
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _tmpIs_deleted = null;
        } else {
          _tmpIs_deleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _item.setIs_deleted(_tmpIs_deleted);
        final Integer _tmpIs_downloaded;
        if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
          _tmpIs_downloaded = null;
        } else {
          _tmpIs_downloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
        }
        _item.setIs_downloaded(_tmpIs_downloaded);
        final Integer _tmpIs_uploaded;
        if (_cursor.isNull(_cursorIndexOfIsUploaded)) {
          _tmpIs_uploaded = null;
        } else {
          _tmpIs_uploaded = _cursor.getInt(_cursorIndexOfIsUploaded);
        }
        _item.setIs_uploaded(_tmpIs_uploaded);
        final Integer _tmpItem_id;
        if (_cursor.isNull(_cursorIndexOfItemId)) {
          _tmpItem_id = null;
        } else {
          _tmpItem_id = _cursor.getInt(_cursorIndexOfItemId);
        }
        _item.setItem_id(_tmpItem_id);
        final Integer _tmpItem_type_id;
        if (_cursor.isNull(_cursorIndexOfItemTypeId)) {
          _tmpItem_type_id = null;
        } else {
          _tmpItem_type_id = _cursor.getInt(_cursorIndexOfItemTypeId);
        }
        _item.setItem_type_id(_tmpItem_type_id);
        final Integer _tmpUser_id;
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _tmpUser_id = null;
        } else {
          _tmpUser_id = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.setUser_id(_tmpUser_id);
        final Integer _tmpSync_status;
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _tmpSync_status = null;
        } else {
          _tmpSync_status = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        _item.setSync_status(_tmpSync_status);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getIfFileAlreadyExists(final String assignedChecklistUuid, final Integer itemId,
      final String fileMd5Checksum, final Integer stepAttributeid) {
    final String _sql = "SELECT resources.uuid from resources INNER join assigned_step_attributes on(resources.uuid = assigned_step_attributes.value and assigned_step_attributes.step_attribute_id = ? and assigned_step_attributes.is_deleted = 0 and assigned_step_attributes.assigned_checklist_uuid = ?) where resources.file_md5_checksum = ? and resources.item_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (stepAttributeid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepAttributeid);
    }
    _argIndex = 2;
    if (assignedChecklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedChecklistUuid);
    }
    _argIndex = 3;
    if (fileMd5Checksum == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fileMd5Checksum);
    }
    _argIndex = 4;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
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
  public List<ChecklistDetailItems> getStepEmbeddedImages(final String checklistUuid,
      final Integer checklistId, final Integer parentId) {
    final String _sql = "select id, parent_id, item_id, item_type_id, item_uuid, checklist_id, sort_order, title, description, (SELECT \"action\" FROM logs WHERE checklist_element_id = checklist_elements.id AND checklist_elements.item_type_id IN ( 10 ) AND \"action\" IN ( 18 ) AND assigned_checklist_uuid = ? ORDER BY created DESC LIMIT 1) AS imageTextStatus from checklist_elements where checklist_id = ? AND parent_id = ? AND item_type_id = 10 AND is_deleted = 0 order by sort_order ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (checklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUuid);
    }
    _argIndex = 2;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
    _argIndex = 3;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, parentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfElementId = 0;
      final int _cursorIndexOfParentItemId = 1;
      final int _cursorIndexOfItemId = 2;
      final int _cursorIndexOfItemTypeId = 3;
      final int _cursorIndexOfItemUuid = 4;
      final int _cursorIndexOfChecklistId = 5;
      final int _cursorIndexOfSortOrder = 6;
      final int _cursorIndexOfTitle = 7;
      final int _cursorIndexOfDescription = 8;
      final int _cursorIndexOfImageTextStatus = 9;
      final List<ChecklistDetailItems> _result = new ArrayList<ChecklistDetailItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChecklistDetailItems _item;
        _item = new ChecklistDetailItems();
        final int _tmpElementId;
        _tmpElementId = _cursor.getInt(_cursorIndexOfElementId);
        _item.setElementId(_tmpElementId);
        final int _tmpParentItemId;
        _tmpParentItemId = _cursor.getInt(_cursorIndexOfParentItemId);
        _item.setParentItemId(_tmpParentItemId);
        final int _tmpItemId;
        _tmpItemId = _cursor.getInt(_cursorIndexOfItemId);
        _item.setItemId(_tmpItemId);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _item.setItemTypeId(_tmpItemTypeId);
        final String _tmpItemUuid;
        if (_cursor.isNull(_cursorIndexOfItemUuid)) {
          _tmpItemUuid = null;
        } else {
          _tmpItemUuid = _cursor.getString(_cursorIndexOfItemUuid);
        }
        _item.setItemUuid(_tmpItemUuid);
        final int _tmpChecklistId;
        _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        _item.setChecklistId(_tmpChecklistId);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        _item.setSortOrder(_tmpSortOrder);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item.setDescription(_tmpDescription);
        final Integer _tmpImageTextStatus;
        if (_cursor.isNull(_cursorIndexOfImageTextStatus)) {
          _tmpImageTextStatus = null;
        } else {
          _tmpImageTextStatus = _cursor.getInt(_cursorIndexOfImageTextStatus);
        }
        _item.setImageTextStatus(_tmpImageTextStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getValidSortOrder(final int sortOrder, final int checklistId) {
    final String _sql = "SELECT min(checklist_elements.sort_order)\n"
            + "from checklist_elements\n"
            + "LEFT JOIN checklist_elements AS ParentElement ON (ParentElement.id = checklist_elements.parent_id)\n"
            + "where checklist_elements.sort_order >= ? AND  checklist_elements.checklist_id = ?\n"
            + "AND (checklist_elements.item_type_id != 10 or checklist_elements.parent_id IS NULL or ParentElement.item_type_id = 2);";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, sortOrder);
    _argIndex = 2;
    _statement.bindLong(_argIndex, checklistId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<QRAttributeScanItem>> getQRAttributeScanItem(final Integer stepAttributeId,
      final String itemUuid, final Integer stepId, final String checkListUUID) {
    final String _sql = "SELECT\n"
            + "    AssignedStepAttribute.uuid,\n"
            + "    AssignedStepAttribute.item_uuid,\n"
            + "    AssignedStepAttribute.step_attribute_id,\n"
            + "    AssignedStepAttribute.checklist_element_id,\n"
            + "    AssignedStepAttribute.assigned_checklist_uuid,\n"
            + "    AssignedItemPlaceholder.uuid AS entity_uuid,\n"
            + "    AssignedItemPlaceholder.value AS entity_name,\n"
            + "    AssignedItemPlaceholder.model,\n"
            + "    (\n"
            + "    SELECT\n"
            + "        step_action \n"
            + "    FROM\n"
            + "        logs \n"
            + "    WHERE\n"
            + "        assigned_checklist_uuid = AssignedStepAttribute.assigned_checklist_uuid \n"
            + "        AND checklist_element_id = AssignedStepAttribute.checklist_element_id \n"
            + "        AND item_uuid = AssignedStepAttribute.item_uuid \n"
            + "        AND \"action\" = 6 \n"
            + "        AND assigned_to_name = AssignedStepAttribute.uuid \n"
            + "    ORDER BY\n"
            + "        created DESC \n"
            + "        LIMIT 1 \n"
            + "    ) AS verification_reason,\n"
            + "   LocationEquipment.upc_number,\n"
            + "    QrStorage.code AS qr_code\n"
            + "FROM\n"
            + "    assigned_item_placeholders AssignedItemPlaceholder\n"
            + "    LEFT JOIN item_placeholders ItemPlaceholder ON ( ItemPlaceholder.id = AssignedItemPlaceholder.item_placeholder_id )\n"
            + "    LEFT JOIN assigned_step_attributes AssignedStepAttribute ON (\n"
            + "        AssignedStepAttribute.assigned_checklist_uuid = AssignedItemPlaceholder.assigned_checklist_uuid \n"
            + "        AND AssignedStepAttribute.checklist_element_id = AssignedItemPlaceholder.checklist_element_id \n"
            + "        AND AssignedStepAttribute.value = AssignedItemPlaceholder.uuid \n"
            + "        AND AssignedStepAttribute.step_attribute_id = ?\n"
            + "        AND AssignedStepAttribute.item_uuid = ?\n"
            + "    )\n"
            + "    LEFT JOIN location_equipments AS LocationEquipment ON (LocationEquipment.id = AssignedItemPlaceholder.foreign_key AND AssignedItemPlaceholder.model = 'LocationEquipment')    LEFT JOIN qr_storage QrStorage ON ( QrStorage.model = AssignedItemPlaceholder.model AND QrStorage.foreign_key = AssignedItemPlaceholder.foreign_key ) \n"
            + "WHERE\n"
            + "    AssignedItemPlaceholder.assigned_checklist_uuid = ?\n"
            + "    AND AssignedItemPlaceholder.checklist_element_id = ? \n"
            + "    AND AssignedItemPlaceholder.is_deleted = 0 \n"
            + "    AND AssignedItemPlaceholder.model IS NOT NULL \n"
            + "    AND AssignedItemPlaceholder.foreign_key IS NOT NULL\n"
            + "ORDER BY\n"
            + "    ItemPlaceholder.sort_order ASC;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (stepAttributeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepAttributeId);
    }
    _argIndex = 2;
    if (itemUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemUuid);
    }
    _argIndex = 3;
    if (checkListUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checkListUUID);
    }
    _argIndex = 4;
    if (stepId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"logs","assigned_item_placeholders","item_placeholders","assigned_step_attributes","location_equipments","qr_storage"}, false, new Callable<List<QRAttributeScanItem>>() {
      @Override
      public List<QRAttributeScanItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUuid = 0;
          final int _cursorIndexOfItemUuid = 1;
          final int _cursorIndexOfStepAttributeId = 2;
          final int _cursorIndexOfChecklistElementId = 3;
          final int _cursorIndexOfAssignedChecklistUuid = 4;
          final int _cursorIndexOfEntityUuid = 5;
          final int _cursorIndexOfEntityName = 6;
          final int _cursorIndexOfModel = 7;
          final int _cursorIndexOfVerificationReason = 8;
          final int _cursorIndexOfUpcNumber = 9;
          final int _cursorIndexOfQrCode = 10;
          final List<QRAttributeScanItem> _result = new ArrayList<QRAttributeScanItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final QRAttributeScanItem _item;
            _item = new QRAttributeScanItem();
            if (_cursor.isNull(_cursorIndexOfUuid)) {
              _item.uuid = null;
            } else {
              _item.uuid = _cursor.getString(_cursorIndexOfUuid);
            }
            if (_cursor.isNull(_cursorIndexOfItemUuid)) {
              _item.itemUuid = null;
            } else {
              _item.itemUuid = _cursor.getString(_cursorIndexOfItemUuid);
            }
            if (_cursor.isNull(_cursorIndexOfStepAttributeId)) {
              _item.stepAttributeId = null;
            } else {
              _item.stepAttributeId = _cursor.getInt(_cursorIndexOfStepAttributeId);
            }
            if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
              _item.checklistElementId = null;
            } else {
              _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
            }
            if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
              _item.assignedChecklistUuid = null;
            } else {
              _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
            }
            if (_cursor.isNull(_cursorIndexOfEntityUuid)) {
              _item.entityUuid = null;
            } else {
              _item.entityUuid = _cursor.getString(_cursorIndexOfEntityUuid);
            }
            if (_cursor.isNull(_cursorIndexOfEntityName)) {
              _item.entityName = null;
            } else {
              _item.entityName = _cursor.getString(_cursorIndexOfEntityName);
            }
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _item.model = null;
            } else {
              _item.model = _cursor.getString(_cursorIndexOfModel);
            }
            if (_cursor.isNull(_cursorIndexOfVerificationReason)) {
              _item.verificationReason = null;
            } else {
              _item.verificationReason = _cursor.getString(_cursorIndexOfVerificationReason);
            }
            if (_cursor.isNull(_cursorIndexOfUpcNumber)) {
              _item.upcNumber = null;
            } else {
              _item.upcNumber = _cursor.getString(_cursorIndexOfUpcNumber);
            }
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _item.qrCode = null;
            } else {
              _item.qrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public NonExecutedChildElement getNonExecutedChildElement(final Integer parentId,
      final String checklistUuid) {
    final String _sql = "SELECT AssignedNCW.acknowledged, ChecklistElement.sort_order, ChecklistElement.title, ChecklistElement.item_type_id\n"
            + "                FROM  \n"
            + "                checklist_elements AS ChecklistElement  \n"
            + "                LEFT JOIN assigned_ncw AS AssignedNCW ON (  \n"
            + "                AssignedNCW.checklist_element_id = ChecklistElement.id   \n"
            + "                AND AssignedNCW.assigned_checklist_uuid = ? \n"
            + "                AND AssignedNCW.is_deleted = 0) \n"
            + "                WHERE  \n"
            + "                ChecklistElement.parent_id = ? \n"
            + "                AND ChecklistElement.is_deleted = 0\n"
            + "\t\t\t\tAND AssignedNCW.acknowledged is NULL\n"
            + "\t\t\t\tAND ChecklistElement.item_type_id != 10\n"
            + "\t\t\t\tLIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (checklistUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUuid);
    }
    _argIndex = 2;
    if (parentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, parentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAcknowledged = 0;
      final int _cursorIndexOfSortOrder = 1;
      final int _cursorIndexOfTitle = 2;
      final int _cursorIndexOfItemTypeId = 3;
      final NonExecutedChildElement _result;
      if(_cursor.moveToFirst()) {
        _result = new NonExecutedChildElement();
        final int _tmpAcknowledged;
        _tmpAcknowledged = _cursor.getInt(_cursorIndexOfAcknowledged);
        _result.setAcknowledged(_tmpAcknowledged);
        final Integer _tmpSortOrder;
        if (_cursor.isNull(_cursorIndexOfSortOrder)) {
          _tmpSortOrder = null;
        } else {
          _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        }
        _result.setSortOrder(_tmpSortOrder);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final int _tmpItemTypeId;
        _tmpItemTypeId = _cursor.getInt(_cursorIndexOfItemTypeId);
        _result.setItemTypeId(_tmpItemTypeId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
