package com.icarus.workorder.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import com.icarus.workorder.models.RoomItems;
import com.icarus.workorder.models.WorkOrderItems;
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
public final class WorkOrderDao_Impl implements WorkOrderDao {
  private final RoomDatabase __db;

  public WorkOrderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getWorkOrder(final Integer locationId,
      final Integer userId, final List<String> statusIds, final List<Integer> priorityLevels,
      final Integer authorId, final Integer assignedTo, final List<Integer> departmentIds,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_3 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_3);
    _stringBuilder.append("))) ORDER BY WorkOrder.due_date ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 11 + _inputSize + _inputSize_1 + _inputSize_2 + _inputSize_3;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 10 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 11 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 12 + _inputSize + _inputSize_1 + _inputSize_2;
    for (Integer _item_3 : departmentIds) {
      if (_item_3 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_3);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_4;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_4 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_4);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrder(final Integer locationId,
      final Integer userId, final List<String> statusIds, final List<Integer> priorityLevels,
      final Integer authorId, final Integer assignedTo, final List<Integer> departmentIds,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY WorkOrder.due_date ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_3;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderDueDateDESC(
      final Integer locationId, final Integer userId, final List<String> statusIds,
      final List<Integer> priorityLevels, final Integer authorId, final Integer assignedTo,
      final List<Integer> departmentIds, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY WorkOrder.due_date DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_3;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderDueDateDESC(
      final Integer locationId, final Integer userId, final List<String> statusIds,
      final List<Integer> priorityLevels, final Integer authorId, final Integer assignedTo,
      final List<Integer> departmentIds, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_3 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_3);
    _stringBuilder.append("))) ORDER BY WorkOrder.due_date DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 11 + _inputSize + _inputSize_1 + _inputSize_2 + _inputSize_3;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 10 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 11 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 12 + _inputSize + _inputSize_1 + _inputSize_2;
    for (Integer _item_3 : departmentIds) {
      if (_item_3 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_3);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_4;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_4 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_4);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderNameDESC(final Integer locationId,
      final Integer userId, final List<String> statusIds, final List<Integer> priorityLevels,
      final Integer authorId, final Integer assignedTo, final List<Integer> departmentIds,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_3 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_3);
    _stringBuilder.append("))) ORDER BY WorkOrder.title COLLATE NOCASE DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 11 + _inputSize + _inputSize_1 + _inputSize_2 + _inputSize_3;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 10 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 11 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 12 + _inputSize + _inputSize_1 + _inputSize_2;
    for (Integer _item_3 : departmentIds) {
      if (_item_3 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_3);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_4;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_4 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_4);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderNameDESC(
      final Integer locationId, final Integer userId, final List<String> statusIds,
      final List<Integer> priorityLevels, final Integer authorId, final Integer assignedTo,
      final List<Integer> departmentIds, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY WorkOrder.title COLLATE NOCASE DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_3;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderNameASC(final Integer locationId,
      final Integer userId, final List<String> statusIds, final List<Integer> priorityLevels,
      final Integer authorId, final Integer assignedTo, final List<Integer> departmentIds,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_3 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_3);
    _stringBuilder.append("))) ORDER BY WorkOrder.title COLLATE NOCASE ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 11 + _inputSize + _inputSize_1 + _inputSize_2 + _inputSize_3;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 10 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 11 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 12 + _inputSize + _inputSize_1 + _inputSize_2;
    for (Integer _item_3 : departmentIds) {
      if (_item_3 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_3);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_4;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_4 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_4);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderNameASC(
      final Integer locationId, final Integer userId, final List<String> statusIds,
      final List<Integer> priorityLevels, final Integer authorId, final Integer assignedTo,
      final List<Integer> departmentIds, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY WorkOrder.title COLLATE NOCASE ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_3;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderIdASC(final Integer locationId,
      final Integer userId, final List<String> statusIds, final List<Integer> priorityLevels,
      final Integer authorId, final Integer assignedTo, final List<Integer> departmentIds,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_3 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_3);
    _stringBuilder.append("))) ORDER BY WorkOrder.id ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 11 + _inputSize + _inputSize_1 + _inputSize_2 + _inputSize_3;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 10 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 11 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 12 + _inputSize + _inputSize_1 + _inputSize_2;
    for (Integer _item_3 : departmentIds) {
      if (_item_3 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_3);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_4;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_4 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_4);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderIdASC(
      final Integer locationId, final Integer userId, final List<String> statusIds,
      final List<Integer> priorityLevels, final Integer authorId, final Integer assignedTo,
      final List<Integer> departmentIds, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY WorkOrder.id ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_3;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getWorkOrderIdDESC(final Integer locationId,
      final Integer userId, final List<String> statusIds, final List<Integer> priorityLevels,
      final Integer authorId, final Integer assignedTo, final List<Integer> departmentIds,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_3 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_3);
    _stringBuilder.append("))) ORDER BY WorkOrder.id DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 11 + _inputSize + _inputSize_1 + _inputSize_2 + _inputSize_3;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 10 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 11 + _inputSize + _inputSize_1 + _inputSize_2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 12 + _inputSize + _inputSize_1 + _inputSize_2;
    for (Integer _item_3 : departmentIds) {
      if (_item_3 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_3);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_4;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_4 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_4);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, WorkOrderItems> getAdminWorkOrderIdDESC(
      final Integer locationId, final Integer userId, final List<String> statusIds,
      final List<Integer> priorityLevels, final Integer authorId, final Integer assignedTo,
      final List<Integer> departmentIds, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_priority_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CAST ((JULIANDAY(DATE(WorkOrder.due_date)) - JULIANDAY(DATE(CURRENT_DATE))) AS Integer) AS dueDays, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.workorder_status_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.name AS status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_type, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.assigned_to_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   coalesce(Department.name, User.full_name) AS assignee, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.due_date, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.sync_status ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityLevels.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.id LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("OR WorkOrder.title LIKE ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" IS NOT NULL THEN WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ELSE 1 = 1 END ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND CASE        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 1 THEN (WorkOrder.assigned_to_type = 1 AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(")        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 2 THEN (WorkOrder.assigned_to_type = 2 AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append("))        WHEN ");
    _stringBuilder.append("?");
    _stringBuilder.append(" = 3 THEN (WorkOrder.assigned_to_type = 3)        ELSE 1 = 1    END ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" ORDER BY WorkOrder.id DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (String _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityLevels) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 5 + _inputSize + _inputSize_1;
    if (authorId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, authorId);
    }
    _argIndex = 6 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 7 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 8 + _inputSize + _inputSize_1;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    _argIndex = 9 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize + _inputSize_1 + _inputSize_2;
    if (assignedTo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignedTo);
    }
    return new DataSource.Factory<Integer, WorkOrderItems>() {
      @Override
      public LimitOffsetDataSource<WorkOrderItems> create() {
        return new LimitOffsetDataSource<WorkOrderItems>(__db, _statement, false, true , "workorders", "workorder_statuses", "departments", "users") {
          @Override
          protected List<WorkOrderItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfWorkorderId = 0;
            final int _cursorIndexOfUuid = 1;
            final int _cursorIndexOfTitle = 2;
            final int _cursorIndexOfWorkorderPriorityId = 3;
            final int _cursorIndexOfDueDays = 4;
            final int _cursorIndexOfWorkorderStatusId = 5;
            final int _cursorIndexOfStatus = 6;
            final int _cursorIndexOfAssignedToType = 7;
            final int _cursorIndexOfAssignedToId = 8;
            final int _cursorIndexOfAssignee = 9;
            final int _cursorIndexOfDueDate = 10;
            final int _cursorIndexOfModified = 11;
            final int _cursorIndexOfSyncStatus = 12;
            final List<WorkOrderItems> _res = new ArrayList<WorkOrderItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final WorkOrderItems _item_3;
              final Integer _tmpWorkorderId;
              if (cursor.isNull(_cursorIndexOfWorkorderId)) {
                _tmpWorkorderId = null;
              } else {
                _tmpWorkorderId = cursor.getInt(_cursorIndexOfWorkorderId);
              }
              final String _tmpUuid;
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _tmpUuid = null;
              } else {
                _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final Integer _tmpWorkorderPriorityId;
              if (cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
                _tmpWorkorderPriorityId = null;
              } else {
                _tmpWorkorderPriorityId = cursor.getInt(_cursorIndexOfWorkorderPriorityId);
              }
              final String _tmpDueDays;
              if (cursor.isNull(_cursorIndexOfDueDays)) {
                _tmpDueDays = null;
              } else {
                _tmpDueDays = cursor.getString(_cursorIndexOfDueDays);
              }
              final String _tmpWorkorderStatusId;
              if (cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
                _tmpWorkorderStatusId = null;
              } else {
                _tmpWorkorderStatusId = cursor.getString(_cursorIndexOfWorkorderStatusId);
              }
              final String _tmpStatus;
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              }
              final Integer _tmpAssignedToType;
              if (cursor.isNull(_cursorIndexOfAssignedToType)) {
                _tmpAssignedToType = null;
              } else {
                _tmpAssignedToType = cursor.getInt(_cursorIndexOfAssignedToType);
              }
              final Integer _tmpAssignedToId;
              if (cursor.isNull(_cursorIndexOfAssignedToId)) {
                _tmpAssignedToId = null;
              } else {
                _tmpAssignedToId = cursor.getInt(_cursorIndexOfAssignedToId);
              }
              final String _tmpAssignee;
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _tmpAssignee = null;
              } else {
                _tmpAssignee = cursor.getString(_cursorIndexOfAssignee);
              }
              final String _tmpDueDate;
              if (cursor.isNull(_cursorIndexOfDueDate)) {
                _tmpDueDate = null;
              } else {
                _tmpDueDate = cursor.getString(_cursorIndexOfDueDate);
              }
              final String _tmpModified;
              if (cursor.isNull(_cursorIndexOfModified)) {
                _tmpModified = null;
              } else {
                _tmpModified = cursor.getString(_cursorIndexOfModified);
              }
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_3 = new WorkOrderItems(_tmpUuid,_tmpWorkorderPriorityId,_tmpTitle,_tmpDueDays,_tmpWorkorderId,_tmpWorkorderStatusId,_tmpStatus,_tmpModified,_tmpAssignedToType,_tmpAssignedToId,_tmpAssignee,_tmpDueDate,_tmpSyncStatus);
              _res.add(_item_3);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public List<RoomItems> getRoom(final Integer locationId) {
    final String _sql = "Select DISTINCT Room.name as Name, Room.id as Id  FROM location_room_equipments LocationRoom  LEFT JOIN rooms Room On Room.id = LocationRoom.room_id  where LocationRoom.location_id = ? AND LocationRoom.is_deleted = 0 AND Room.is_deleted = 0";
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
      final int _cursorIndexOfName = 0;
      final int _cursorIndexOfId = 1;
      final List<RoomItems> _result = new ArrayList<RoomItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomItems _item;
        _item = new RoomItems();
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
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
  public List<RoomItems> getAssets(final Integer locationId, final Integer roomId) {
    final String _sql = "Select EquipmentItems.name as Name, EquipmentItems.id as Id FROM location_room_equipments LocationEquipment LEFT JOIN equipments EquipmentItems On EquipmentItems.id = LocationEquipment.equipment_id where LocationEquipment.location_id= ?  AND LocationEquipment.room_id = ? AND LocationEquipment.is_deleted = 0 AND EquipmentItems.is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    if (roomId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, roomId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = 0;
      final int _cursorIndexOfId = 1;
      final List<RoomItems> _result = new ArrayList<RoomItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomItems _item;
        _item = new RoomItems();
        if (_cursor.isNull(_cursorIndexOfName)) {
          _item.name = null;
        } else {
          _item.name = _cursor.getString(_cursorIndexOfName);
        }
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getInt(_cursorIndexOfId);
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
  public LiveData<Integer> getWorkOrderAdminCount(final Integer locationId,
      final List<Integer> statusIds, final List<Integer> priorityIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   count(WorkOrder.id)");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize + _inputSize_1;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (Integer _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityIds) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workorders","workorder_statuses","departments","users"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> getWorkOrderCount(final Integer userId, final Integer locationId,
      final List<Integer> statusIds, final List<Integer> priorityIds,
      final List<Integer> departmentIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   count(WorkOrder.id)");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   workorders AS WorkOrder ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN workorder_statuses AS WorkOrderStatus ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrderStatus.id = WorkOrder.workorder_status_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN departments AS Department ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   Department.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type = 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(")  ");
    _stringBuilder.append("\n");
    _stringBuilder.append("LEFT JOIN users AS User ON( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   User.id = WorkOrder.assigned_to_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND WorkOrder.assigned_to_type <> 2 ");
    _stringBuilder.append("\n");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   WorkOrder.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_status_id IN (");
    final int _inputSize = statusIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND WorkOrder.workorder_priority_id IN (");
    final int _inputSize_1 = priorityIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") AND ((    WorkOrder.assigned_to_type = 1    AND WorkOrder.assigned_to_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   ) OR ( WorkOrder.author_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ) OR ( WorkOrder.assigned_to_type = 3 ) OR (    WorkOrder.assigned_to_type = 2    AND WorkOrder.assigned_to_id IN (");
    final int _inputSize_2 = departmentIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_2);
    _stringBuilder.append(")))");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize + _inputSize_1 + _inputSize_2;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    for (Integer _item : statusIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize;
    for (Integer _item_1 : priorityIds) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    _argIndex = 2 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3 + _inputSize + _inputSize_1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 4 + _inputSize + _inputSize_1;
    for (Integer _item_2 : departmentIds) {
      if (_item_2 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item_2);
      }
      _argIndex ++;
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workorders","workorder_statuses","departments","users"}, false, new Callable<Integer>() {
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
