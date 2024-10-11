package com.icarus.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignedCheckListPauseTimesEntity;
import com.icarus.models.MyAssignedChecklistItems;
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
public final class MyAssignmentDao_Impl implements MyAssignmentDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStartAssignedChecklist;

  private final SharedSQLiteStatement __preparedStmtOfUpdateResumeAssignedChecklist;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedCheckListPauseTimesEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingElementCount;

  public MyAssignmentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfUpdateStartAssignedChecklist = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET user_id = ? , started_by_user_id = ?, started_at = ? , modified = ? , sync_status = ?, execution_status = 0 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateResumeAssignedChecklist = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET user_id = ? , modified = ? , checklist_status = ? , sync_status = ?, execution_status = 0 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedCheckListPauseTimesEntity = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklist_pause_times SET resumed_by_user_id = ? , is_paused = ? , modified = ? , sync_status = ? where assigned_checklist_uuid = ? and is_paused = 1";
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
  public void updateStartAssignedChecklist(final int userId, final Integer sync_status,
      final String currentTime, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStartAssignedChecklist.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, userId);
    _argIndex = 3;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 4;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 5;
    if (sync_status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, sync_status);
    }
    _argIndex = 6;
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
      __preparedStmtOfUpdateStartAssignedChecklist.release(_stmt);
    }
  }

  @Override
  public void updateResumeAssignedChecklist(final int userId, final Integer checklist_status,
      final Integer sync_status, final String currentTime, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateResumeAssignedChecklist.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 3;
    if (checklist_status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklist_status);
    }
    _argIndex = 4;
    if (sync_status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, sync_status);
    }
    _argIndex = 5;
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
      __preparedStmtOfUpdateResumeAssignedChecklist.release(_stmt);
    }
  }

  @Override
  public void updateAssignedCheckListPauseTimesEntity(final int userId, final Integer is_paused,
      final String currentTime, final Integer sync_status, final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedCheckListPauseTimesEntity.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    _argIndex = 2;
    if (is_paused == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, is_paused);
    }
    _argIndex = 3;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 4;
    if (sync_status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, sync_status);
    }
    _argIndex = 5;
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
      __preparedStmtOfUpdateAssignedCheckListPauseTimesEntity.release(_stmt);
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
  public DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByLatestDue(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.due_date DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByLatestDueAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.due_date DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestDue(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.due_date ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestDueAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.due_date ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByRecentUpdated(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> getAssignedUserChecklistsOrderByRecentUpdatedAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestUpdated(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByOldestUpdatedAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY AssignedChecklist.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleAZ(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY lower(ChecklistTitle.title) ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleAZAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY lower(ChecklistTitle.title) ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleZA(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY lower(ChecklistTitle.title) DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByTitleZAAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY lower(ChecklistTitle.title) DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusASC(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY checklistStatus ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusASCAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY checklistStatus ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusDESC(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_users AS AssignedUser ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedUser.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedUser.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY checklistStatus DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 6 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 7;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites", "assigned_users") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MyAssignedChecklistItems> geAssignedUserChecklistsOrderByStatusDESCAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tChecklistType.type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(AssignedDepartmentDepartment.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCAST ((JULIANDAY(DATE(AssignedChecklist.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS due_days,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCASE WHEN AssignedChecklist.checklist_status = 0 AND ( AssignedChecklist.started_by_user_id = 0 OR AssignedChecklist.started_by_user_id IS NULL ) THEN 'New' WHEN AssignedChecklist.checklist_status = 0 THEN 'In Progress' WHEN AssignedChecklist.checklist_status = 4 THEN 'Paused' END AS checklistStatus,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.modified AS updated_at");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tassigned_checklists AS AssignedChecklist");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tINNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_departments AS AssignedDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND AssignedDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t)");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") \tLEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.checklist_status IN ( 0, 4 ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND (ChecklistTitle.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  Room.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR Equipment.name LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND AssignedChecklist.department_id IN( ");
    final int _inputSize = department.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND ChecklistType.type IN( ");
    final int _inputSize_1 = type.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND checklistStatus IN( ");
    final int _inputSize_2 = status.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY checklistStatus DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : department) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize;
    for (String _item_1 : type) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    for (String _item_2 : status) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, MyAssignedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<MyAssignedChecklistItems> create() {
        return new LimitOffsetDataSource<MyAssignedChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "assigned_room_equipments", "rooms", "equipments", "departments", "assigned_departments", "user_favorites") {
          @Override
          protected List<MyAssignedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfMasterSyncStatus = 2;
            final int _cursorIndexOfSyncStatus = 3;
            final int _cursorIndexOfStatus = 4;
            final int _cursorIndexOfPendingResourcesCount = 5;
            final int _cursorIndexOfPendingReferencesCount = 6;
            final int _cursorIndexOfIsFavorite = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfStartedByUserId = 14;
            final int _cursorIndexOfDueAt = 15;
            final int _cursorIndexOfAssignedAt = 16;
            final int _cursorIndexOfPendingAssignedElementsCount = 17;
            final int _cursorIndexOfPendingAssignedResourcesCount = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<MyAssignedChecklistItems> _res = new ArrayList<MyAssignedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MyAssignedChecklistItems _item_3;
              _item_3 = new MyAssignedChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              final Integer _tmpMasterSyncStatus;
              if (cursor.isNull(_cursorIndexOfMasterSyncStatus)) {
                _tmpMasterSyncStatus = null;
              } else {
                _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              }
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3.setSyncStatus(_tmpSyncStatus);
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_3.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_3.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_3.setIsFavorite(_tmpIsFavorite);
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _item_3.checklistType = null;
              } else {
                _item_3.checklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _item_3.isSequential = null;
              } else {
                _item_3.isSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _item_3.title = null;
              } else {
                _item_3.title = cursor.getString(_cursorIndexOfTitle);
              }
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _item_3.departmentId = null;
              } else {
                _item_3.departmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              if (cursor.isNull(_cursorIndexOfRoom)) {
                _item_3.room = null;
              } else {
                _item_3.room = cursor.getString(_cursorIndexOfRoom);
              }
              if (cursor.isNull(_cursorIndexOfEquipment)) {
                _item_3.equipment = null;
              } else {
                _item_3.equipment = cursor.getString(_cursorIndexOfEquipment);
              }
              if (cursor.isNull(_cursorIndexOfStartedByUserId)) {
                _item_3.startedByUserId = null;
              } else {
                _item_3.startedByUserId = cursor.getInt(_cursorIndexOfStartedByUserId);
              }
              if (cursor.isNull(_cursorIndexOfDueAt)) {
                _item_3.dueAt = null;
              } else {
                _item_3.dueAt = cursor.getString(_cursorIndexOfDueAt);
              }
              if (cursor.isNull(_cursorIndexOfAssignedAt)) {
                _item_3.assignedAt = null;
              } else {
                _item_3.assignedAt = cursor.getString(_cursorIndexOfAssignedAt);
              }
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_3.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_3.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _item_3.dueDays = null;
              } else {
                _item_3.dueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              if (cursor.isNull(_cursorIndexOfChecklistStatus)) {
                _item_3.checklistStatus = null;
              } else {
                _item_3.checklistStatus = cursor.getString(_cursorIndexOfChecklistStatus);
              }
              if (cursor.isNull(_cursorIndexOfUpdatedAt)) {
                _item_3.updatedAt = null;
              } else {
                _item_3.updatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              }
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public boolean isAssignedUsersExists(final String assignedUuid, final Integer userId) {
    final String _sql = "SELECT COUNT(user_id) FROM assigned_users WHERE assigned_checklist_uuid = ? AND user_id = ? AND is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (assignedUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, assignedUuid);
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
  public AssignedCheckListPauseTimesEntity ifPauseTimeExists(final String uuid) {
    final String _sql = "SELECT \n"
            + "    *\n"
            + "FROM \n"
            + "    assigned_checklist_pause_times\n"
            + "WHERE \n"
            + " assigned_checklist_uuid = ? AND is_deleted = 0 ORDER BY modified DESC";
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
        if (_cursor.isNull(_cursorIndexOfUuid)) {
          _result.uuid = null;
        } else {
          _result.uuid = _cursor.getString(_cursorIndexOfUuid);
        }
        if (_cursor.isNull(_cursorIndexOfAssignedChecklistUuid)) {
          _result.assigned_checklist_uuid = null;
        } else {
          _result.assigned_checklist_uuid = _cursor.getString(_cursorIndexOfAssignedChecklistUuid);
        }
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
        if (_cursor.isNull(_cursorIndexOfReason)) {
          _result.reason = null;
        } else {
          _result.reason = _cursor.getString(_cursorIndexOfReason);
        }
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
  public LiveData<Integer> geAssignedUserChecklistsAdminCount(final int userId,
      final int locationId) {
    final String _sql = "SELECT COUNT (DISTINCT AssignedChecklist.uuid) FROM \n"
            + " assigned_checklists AS AssignedChecklist \n"
            + " INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id ) \n"
            + " INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id ) \n"
            + " INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id ) \n"
            + " LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid ) \n"
            + " LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id ) \n"
            + " LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id ) \n"
            + " LEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id ) \n"
            + " LEFT JOIN assigned_departments AS AssignedDepartment ON ( AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid  \n"
            + "AND AssignedDepartment.is_deleted = 0  \n"
            + " ) \n"
            + "    LEFT OUTER JOIN user_favorites UserFavorite ON (  \n"
            + "    UserFavorite.checklist_id = Checklist.id  \n"
            + "    AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) \n"
            + "LEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )\n"
            + "\n"
            + "WHERE AssignedChecklist.assignee_type = 1 AND AssignedChecklist.checklist_status IN ( 0, 4 ) AND AssignedChecklist.location_id = ? AND AssignedChecklist.is_deleted = 0\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"assigned_checklists","checklists","checklist_titles","checklist_types","assigned_room_equipments","rooms","equipments","departments","assigned_departments","user_favorites"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
  public LiveData<Integer> geAssignedUserChecklistsCount(final int userId, final int locationId) {
    final String _sql = "SELECT COUNT (DISTINCT AssignedChecklist.uuid) FROM \n"
            + "assigned_checklists AS AssignedChecklist\n"
            + "INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )        \n"
            + "INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )        \n"
            + "INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )        \n"
            + "LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )        \n"
            + "LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )        \n"
            + "LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )        \n"
            + "LEFT JOIN departments AS Department ON ( Department.id = AssignedChecklist.department_id )        \n"
            + "LEFT JOIN assigned_departments AS AssignedDepartment ON ( AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid         \n"
            + "AND AssignedDepartment.is_deleted = 0)\n"
            + "LEFT OUTER JOIN user_favorites UserFavorite ON (\n"
            + "UserFavorite.checklist_id = Checklist.id         \n"
            + "AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?)        \n"
            + "LEFT JOIN departments AS AssignedDepartmentDepartment ON ( AssignedDepartmentDepartment.id = AssignedDepartment.department_id )       \n"
            + "LEFT JOIN assigned_users AS AssignedUser ON (AssignedUser.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "AND AssignedUser.is_deleted = 0)   \n"
            + "WHERE AssignedChecklist.assignee_type = 1 AND AssignedChecklist.checklist_status IN ( 0, 4 ) AND AssignedChecklist.location_id = ? AND AssignedChecklist.is_deleted = 0 \n"
            + "AND AssignedUser.user_id = ?\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    _statement.bindLong(_argIndex, userId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"assigned_checklists","checklists","checklist_titles","checklist_types","assigned_room_equipments","rooms","equipments","departments","assigned_departments","user_favorites","assigned_users"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
