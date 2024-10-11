package com.icarus.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.models.DepartmentChecklistItems;
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
public final class DepartmentChecklistDao_Impl implements DepartmentChecklistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AssignCheckListEntity> __insertionAdapterOfAssignCheckListEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAsssignedDepartmentsEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStartAssignedChecklist;

  public DepartmentChecklistDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAssignCheckListEntity = new EntityInsertionAdapter<AssignCheckListEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_checklists` (`assigned_at`,`assignee_type`,`checklist_id`,`checklist_status`,`created`,`department_id`,`due_date`,`is_deleted`,`location_id`,`modified`,`started_at`,`started_by_user_id`,`sync_status`,`user_id`,`uuid`,`execution_status`,`pending_elements_count`,`pending_resources_count`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
    this.__preparedStmtOfUpdateAsssignedDepartmentsEntity = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE assigned_departments SET is_deleted =1, modified=? WHERE  uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStartAssignedChecklist = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE assigned_checklists SET user_id = ?, started_by_user_id= ?, started_at= ?, assignee_type = 1, modified=?, sync_status=0, execution_status = 0 WHERE  uuid = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertStartAssignedChecklist(final AssignCheckListEntity assignCheckListEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignCheckListEntity.insert(assignCheckListEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAsssignedDepartmentsEntity(final String uuid, final String currentTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAsssignedDepartmentsEntity.acquire();
    int _argIndex = 1;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateAsssignedDepartmentsEntity.release(_stmt);
    }
  }

  @Override
  public void updateStartAssignedChecklist(final String uuid, final Integer userId,
      final String currentTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStartAssignedChecklist.acquire();
    int _argIndex = 1;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByLatestDue(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByLatestDueAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestDue(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestDueAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByRecentUpdated(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByRecentUpdatedAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestUpdated(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByOldestUpdatedAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleAZ(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleAZAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleZA(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByTitleZAAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusASC(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusASCAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusDESC(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN user_location_departments AS UserLocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tUserLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND UserLocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND UserLocationDepartment.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "user_location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public DataSource.Factory<Integer, DepartmentChecklistItems> getAssignedDepartmentChecklistsOrderByStatusDESCAdmin(
      final int userId, final int locationId, final List<String> department,
      final List<String> type, final List<String> status, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AssignedChecklist.execution_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,\tAssignedChecklist.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.checklist_status AS status,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistType.type AS type,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklist.is_sequential,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tChecklistTitle.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tCOALESCE(Department.id, AssignedChecklist.department_id) AS department_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tRoom.name AS room,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tEquipment.name AS equipment,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAuthor.full_name AS author,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tDepartment.name AS assignee,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.started_by_user_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.due_date AS due_at,");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assigned_at,");
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
    _stringBuilder.append("\tINNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )");
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
    _stringBuilder.append(") \tLEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tLEFT JOIN location_departments AS LocationDepartment ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tLocationDepartment.location_id = AssignedChecklist.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.department_id = AssignedDepartment.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t\tAND LocationDepartment.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("\t) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("\tAssignedChecklist.assignee_type = 2 ");
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
    _stringBuilder.append("\tAND Department.id IN( ");
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
    return new DataSource.Factory<Integer, DepartmentChecklistItems>() {
      @Override
      public LimitOffsetDataSource<DepartmentChecklistItems> create() {
        return new LimitOffsetDataSource<DepartmentChecklistItems>(__db, _statement, false, true , "assigned_checklists", "checklists", "checklist_titles", "checklist_types", "users", "assigned_room_equipments", "rooms", "equipments", "assigned_departments", "user_favorites", "departments", "location_departments") {
          @Override
          protected List<DepartmentChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = 0;
            final int _cursorIndexOfMasterSyncStatus = 1;
            final int _cursorIndexOfSyncStatus = 2;
            final int _cursorIndexOfPendingResourcesCount = 3;
            final int _cursorIndexOfPendingReferencesCount = 4;
            final int _cursorIndexOfIsFavorite = 5;
            final int _cursorIndexOfUuid = 6;
            final int _cursorIndexOfStatus = 7;
            final int _cursorIndexOfChecklistType = 8;
            final int _cursorIndexOfIsSequential = 9;
            final int _cursorIndexOfTitle = 10;
            final int _cursorIndexOfDepartmentId = 11;
            final int _cursorIndexOfRoom = 12;
            final int _cursorIndexOfEquipment = 13;
            final int _cursorIndexOfAuthor = 14;
            final int _cursorIndexOfAssignee = 15;
            final int _cursorIndexOfStartedByUserId = 16;
            final int _cursorIndexOfDueAt = 17;
            final int _cursorIndexOfAssignedAt = 18;
            final int _cursorIndexOfDueDays = 19;
            final int _cursorIndexOfChecklistStatus = 20;
            final int _cursorIndexOfUpdatedAt = 21;
            final List<DepartmentChecklistItems> _res = new ArrayList<DepartmentChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final DepartmentChecklistItems _item_3;
              _item_3 = new DepartmentChecklistItems();
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _item_3.checklistId = null;
              } else {
                _item_3.checklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_3.setMasterSyncStatus(_tmpMasterSyncStatus);
              final int _tmpSyncStatus;
              _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              _item_3.setSyncStatus(_tmpSyncStatus);
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
              if (cursor.isNull(_cursorIndexOfUuid)) {
                _item_3.uuid = null;
              } else {
                _item_3.uuid = cursor.getString(_cursorIndexOfUuid);
              }
              if (cursor.isNull(_cursorIndexOfStatus)) {
                _item_3.status = null;
              } else {
                _item_3.status = cursor.getInt(_cursorIndexOfStatus);
              }
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
              if (cursor.isNull(_cursorIndexOfAuthor)) {
                _item_3.author = null;
              } else {
                _item_3.author = cursor.getString(_cursorIndexOfAuthor);
              }
              if (cursor.isNull(_cursorIndexOfAssignee)) {
                _item_3.assignee = null;
              } else {
                _item_3.assignee = cursor.getString(_cursorIndexOfAssignee);
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
  public LiveData<Integer> getAssignedDepartmentChecklistsAdminCount(final int userId,
      final int locationId) {
    final String _sql = "SELECT count (DISTINCT AssignedChecklist.uuid) FROM\n"
            + "        assigned_checklists AS AssignedChecklist\n"
            + "        INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n"
            + "        INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n"
            + "        INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n"
            + "        INNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )\n"
            + "        LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n"
            + "        LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n"
            + "        LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n"
            + "        LEFT JOIN assigned_departments AS AssignedDepartment ON (\n"
            + "        AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "        AND AssignedDepartment.is_deleted = 0 \n"
            + "        )\n"
            + "          LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "          UserFavorite.checklist_id = Checklist.id \n"
            + "          AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ? \n"
            + "        )  \n"
            + "        LEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )\n"
            + "LEFT JOIN location_departments AS LocationDepartment ON (\n"
            + "        LocationDepartment.location_id = AssignedChecklist.location_id \n"
            + "        AND LocationDepartment.department_id = AssignedDepartment.department_id \n"
            + "        AND LocationDepartment.is_deleted = 0)\n"
            + "WHERE\n"
            + "        AssignedChecklist.assignee_type = 2 \n"
            + "        AND AssignedChecklist.checklist_status IN ( 0, 4 ) \n"
            + "        AND AssignedChecklist.location_id = ? \n"
            + "        AND AssignedChecklist.is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"assigned_checklists","checklists","checklist_titles","checklist_types","users","assigned_room_equipments","rooms","equipments","assigned_departments","user_favorites","departments","location_departments"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> getAssignedDepartmentChecklistsCount(final int userId,
      final int locationId) {
    final String _sql = "SELECT count (DISTINCT AssignedChecklist.uuid) FROM\n"
            + "        assigned_checklists AS AssignedChecklist\n"
            + "        INNER JOIN checklists AS Checklist ON ( Checklist.id = AssignedChecklist.checklist_id )\n"
            + "        INNER JOIN checklist_titles AS ChecklistTitle ON ( ChecklistTitle.checklist_id = Checklist.id )\n"
            + "        INNER JOIN checklist_types AS ChecklistType ON ( ChecklistType.id = Checklist.checklist_type_id )\n"
            + "        INNER JOIN users AS Author ON ( Author.id = AssignedChecklist.user_id )\n"
            + "        LEFT JOIN assigned_room_equipments AS RoomEquipment ON ( RoomEquipment.assigned_checklist_uuid = AssignedChecklist.uuid )\n"
            + "        LEFT JOIN rooms AS Room ON ( Room.id = RoomEquipment.room_id )\n"
            + "        LEFT JOIN equipments AS Equipment ON ( Equipment.id = RoomEquipment.equipment_id )\n"
            + "        LEFT JOIN assigned_departments AS AssignedDepartment ON (\n"
            + "        AssignedDepartment.assigned_checklist_uuid = AssignedChecklist.uuid \n"
            + "        AND AssignedDepartment.is_deleted = 0 \n"
            + "        )\n"
            + "          LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "          UserFavorite.checklist_id = Checklist.id \n"
            + "          AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ? \n"
            + "        )  \n"
            + "        LEFT JOIN departments AS Department ON ( Department.id = AssignedDepartment.department_id )\n"
            + "LEFT JOIN user_location_departments AS UserLocationDepartment ON (UserLocationDepartment.location_id = AssignedChecklist.location_id\n"
            + "        AND UserLocationDepartment.department_id = AssignedDepartment.department_id \n"
            + "        AND UserLocationDepartment.is_deleted = 0)\n"
            + "WHERE\n"
            + "        AssignedChecklist.assignee_type = 2 \n"
            + "        AND AssignedChecklist.checklist_status IN ( 0, 4 ) \n"
            + "        AND AssignedChecklist.location_id = ? \n"
            + "        AND AssignedChecklist.is_deleted = 0\n"
            + "AND UserLocationDepartment.user_id = ?\n";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, locationId);
    _argIndex = 3;
    _statement.bindLong(_argIndex, userId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"assigned_checklists","checklists","checklist_titles","checklist_types","users","assigned_room_equipments","rooms","equipments","assigned_departments","user_favorites","departments","user_location_departments"}, false, new Callable<Integer>() {
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
