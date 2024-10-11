package com.icarus.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.LogsEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LogsDao_Impl implements LogsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LogsEntity> __insertionAdapterOfLogsEntity;

  private final EntityDeletionOrUpdateAdapter<LogsEntity> __updateAdapterOfLogsEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCheckList;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingElementCount;

  public LogsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
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
    this.__updateAdapterOfLogsEntity = new EntityDeletionOrUpdateAdapter<LogsEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `logs` SET `uuid` = ?,`item_uuid` = ?,`checklist_id` = ?,`checklist_element_id` = ?,`action` = ?,`user_id` = ?,`assigned_to` = ?,`username` = ?,`assigned_to_name` = ?,`assigned_checklist_uuid` = ?,`item_description` = ?,`step_action` = ?,`created` = ?,`modified` = ?,`sync_status` = ? WHERE `uuid` = ?";
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
        if (value.uuid == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.uuid);
        }
      }
    };
    this.__preparedStmtOfUpdateCheckList = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET modified = ? , sync_status = 0, execution_status = 0 where uuid = ?";
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
  }

  @Override
  public void insertLogs(final LogsEntity logsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLogsEntity.insert(logsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateLogs(final LogsEntity logsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLogsEntity.handle(logsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCheckList(final String checklistUuid, final String currentTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCheckList.acquire();
    int _argIndex = 1;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 2;
    if (checklistUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, checklistUuid);
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
  public List<LogsEntity> getReport(final String assignedChecklistUuid) {
    final String _sql = "select * from logs where assigned_checklist_uuid = ?";
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
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfItemUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "item_uuid");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistElementId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_element_id");
      final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfAssignedTo = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfAssignedToName = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_to_name");
      final int _cursorIndexOfAssignedChecklistUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfItemDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "item_description");
      final int _cursorIndexOfStepAction = CursorUtil.getColumnIndexOrThrow(_cursor, "step_action");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final List<LogsEntity> _result = new ArrayList<LogsEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LogsEntity _item;
        _item = new LogsEntity();
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
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _item.checklistId = null;
        } else {
          _item.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistElementId)) {
          _item.checklistElementId = null;
        } else {
          _item.checklistElementId = _cursor.getInt(_cursorIndexOfChecklistElementId);
        }
        if (_cursor.isNull(_cursorIndexOfAction)) {
          _item.action = null;
        } else {
          _item.action = _cursor.getString(_cursorIndexOfAction);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedTo)) {
          _item.assignedTo = null;
        } else {
          _item.assignedTo = _cursor.getInt(_cursorIndexOfAssignedTo);
        }
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _item.username = null;
        } else {
          _item.username = _cursor.getString(_cursorIndexOfUsername);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedToName)) {
          _item.assignedToName = null;
        } else {
          _item.assignedToName = _cursor.getString(_cursorIndexOfAssignedToName);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _item.assignedChecklistUuid = null;
        } else {
          _item.assignedChecklistUuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
        if (_cursor.isNull(_cursorIndexOfItemDescription)) {
          _item.itemDescription = null;
        } else {
          _item.itemDescription = _cursor.getString(_cursorIndexOfItemDescription);
        }
        if (_cursor.isNull(_cursorIndexOfStepAction)) {
          _item.stepAction = null;
        } else {
          _item.stepAction = _cursor.getString(_cursorIndexOfStepAction);
        }
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _item.created = null;
        } else {
          _item.created = _cursor.getString(_cursorIndexOfCreated);
        }
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _item.modified = null;
        } else {
          _item.modified = _cursor.getString(_cursorIndexOfModified);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
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
  public String getUuid(final Integer checklist_element_id, final String assignedChecklistUuid) {
    final String _sql = "select uuid from logs where logs.checklist_element_id = ? and logs.assigned_checklist_uuid = ?;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (checklist_element_id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklist_element_id);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
