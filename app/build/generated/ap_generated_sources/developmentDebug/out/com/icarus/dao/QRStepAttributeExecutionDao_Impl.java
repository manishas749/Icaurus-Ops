package com.icarus.dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignedStepAttributesEntity;
import com.icarus.entities.LogsEntity;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QRStepAttributeExecutionDao_Impl extends QRStepAttributeExecutionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AssignedStepAttributesEntity> __insertionAdapterOfAssignedStepAttributesEntity;

  private final EntityInsertionAdapter<LogsEntity> __insertionAdapterOfLogsEntity;

  private final EntityDeletionOrUpdateAdapter<AssignedStepAttributesEntity> __updateAdapterOfAssignedStepAttributesEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCheckList;

  public QRStepAttributeExecutionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
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
    this.__insertionAdapterOfLogsEntity = new EntityInsertionAdapter<LogsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `logs` (`uuid`,`item_uuid`,`checklist_id`,`checklist_element_id`,`action`,`user_id`,`assigned_to`,`username`,`assigned_to_name`,`assigned_checklist_uuid`,`item_description`,`step_action`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
    this.__updateAdapterOfAssignedStepAttributesEntity = new EntityDeletionOrUpdateAdapter<AssignedStepAttributesEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `assigned_step_attributes` SET `assigned_checklist_uuid` = ?,`checklist_element_id` = ?,`created` = ?,`is_deleted` = ?,`item_uuid` = ?,`modified` = ?,`step_attribute_id` = ?,`step_id` = ?,`sync_status` = ?,`user_id` = ?,`uuid` = ?,`value` = ? WHERE `uuid` = ?";
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
        if (value.uuid == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.uuid);
        }
      }
    };
    this.__preparedStmtOfUpdateCheckList = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists set sync_status = 0, modified =?, user_id =?, pending_elements_count = pending_elements_count + ?  where uuid = ?";
        return _query;
      }
    };
  }

  @Override
  void insertStep(final AssignedStepAttributesEntity assignedStepAttributesEntity) {
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
  void insertLogsEntity(final LogsEntity logEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLogsEntity.insert(logEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void updateStep(final AssignedStepAttributesEntity assignedStepAttributesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAssignedStepAttributesEntity.handle(assignedStepAttributesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateStepExecution(final String assignedChecklistUuid, final String executedAt,
      final int incrementPendingElementBy,
      final AssignedStepAttributesEntity insertAssignedStepAttributeEntity,
      final AssignedStepAttributesEntity updateAssignedStepAttributeEntity,
      final LogsEntity logsEntity) {
    __db.beginTransaction();
    try {
      QRStepAttributeExecutionDao_Impl.super.updateStepExecution(assignedChecklistUuid, executedAt, incrementPendingElementBy, insertAssignedStepAttributeEntity, updateAssignedStepAttributeEntity, logsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void updateCheckList(final String executedAt, final Integer userId, final int incrementBy,
      final String assignedChecklistUuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCheckList.acquire();
    int _argIndex = 1;
    if (executedAt == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, executedAt);
    }
    _argIndex = 2;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, incrementBy);
    _argIndex = 4;
    if (assignedChecklistUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, assignedChecklistUuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCheckList.release(_stmt);
    }
  }
}
