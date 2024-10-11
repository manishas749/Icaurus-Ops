package com.icarus.dao;

import android.database.Cursor;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.StringUtil;
import com.icarus.models.CancelledCompletedChecklistItems;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CancelledCompletedDao_Impl implements CancelledCompletedDao {
  private final RoomDatabase __db;

  public CancelledCompletedDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListSortByDueDate(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_users.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(")  AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND users.id IN (");
    final int _inputSize_1 = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 8 + _inputSize + _inputSize_1;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 9;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize;
    for (String _item_1 : users) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_2;
              _item_2 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_2.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_2.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_2.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_2.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_2.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_2.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_2.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_2.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_2.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_2.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_2.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_2.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_2.setChecklistType(_tmpChecklistType);
              _res.add(_item_2);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListSortByDueDateDesc(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_users.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(")  AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND users.id IN (");
    final int _inputSize_1 = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 8 + _inputSize + _inputSize_1;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 9;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 9 + _inputSize;
    for (String _item_1 : users) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_2;
              _item_2 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_2.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_2.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_2.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_2.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_2.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_2.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_2.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_2.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_2.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_2.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_2.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_2.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_2.setChecklistType(_tmpChecklistType);
              _res.add(_item_2);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListTypeDue(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_users.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(")  AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 8 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 9;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListTypeDueDec(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_users.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(")  AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 8 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 9;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDue(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_users.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(")  AND users.id IN (");
    final int _inputSize = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 8 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 9;
    for (String _item : users) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueDec(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    )");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_users.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(")  AND users.id IN (");
    final int _inputSize = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 8 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 9;
    for (String _item : users) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListSortByDueDateAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND users.id IN (");
    final int _inputSize_1 = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 7 + _inputSize + _inputSize_1;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 8 + _inputSize;
    for (String _item_1 : users) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_2;
              _item_2 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_2.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_2.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_2.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_2.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_2.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_2.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_2.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_2.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_2.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_2.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_2.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_2.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_2.setChecklistType(_tmpChecklistType);
              _res.add(_item_2);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListSortByDueDateDescAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND users.id IN (");
    final int _inputSize_1 = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize_1);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 7 + _inputSize + _inputSize_1;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 8 + _inputSize;
    for (String _item_1 : users) {
      if (_item_1 == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item_1);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_2;
              _item_2 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_2.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_2.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_2.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_2.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_2.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_2.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_2.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_2.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_2.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_2.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_2.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_2.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_2.setChecklistType(_tmpChecklistType);
              _res.add(_item_2);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListTypeDueAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 7 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListTypeDueDecAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND checklists.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 7 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND users.id IN (");
    final int _inputSize = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 7 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    for (String _item : users) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueDecAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String[] users, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.uuid,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.checklist_id,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.modified,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklist_titles.title,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   users.full_name AS last_updated_by,");
    _stringBuilder.append("\n");
    _stringBuilder.append("    checklists.pending_resources_count as pendingResourcesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.pending_references_count as pendingReferencesCount, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.execution_status as assigned_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.sync_status as checklist_sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,");
    _stringBuilder.append("\n");
    _stringBuilder.append("   checklists.checklist_type_id as checklist_type");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM");
    _stringBuilder.append("\n");
    _stringBuilder.append("   assigned_checklists");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   INNER JOIN users ON assigned_checklists.user_id = users.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("   LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("WHERE");
    _stringBuilder.append("\n");
    _stringBuilder.append("    assigned_checklists.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_users.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.checklist_status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND assigned_checklists.assignee_type = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ");
    _stringBuilder.append("\n");
    _stringBuilder.append("AND (checklist_titles.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR  rooms.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(" OR equipments.name like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND users.id IN (");
    final int _inputSize = users.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY assigned_checklists.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 7 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    for (String _item : users) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item_1;
              _item_1 = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item_1.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item_1.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item_1.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item_1.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item_1.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item_1.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item_1.setChecklistType(_tmpChecklistType);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueDateAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String keyword) {
    final String _sql = "SELECT DISTINCT\n"
            + "   assigned_checklists.uuid,\n"
            + "   assigned_checklists.checklist_id,\n"
            + "   assigned_checklists.modified,\n"
            + "   checklist_titles.title,\n"
            + "   users.full_name AS last_updated_by,\n"
            + "    checklists.pending_resources_count as pendingResourcesCount, \n"
            + "   checklists.pending_references_count as pendingReferencesCount, \n"
            + "   assigned_checklists.execution_status as assigned_sync_status, \n"
            + "   checklists.sync_status as checklist_sync_status, \n"
            + "   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,\n"
            + "   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,\n"
            + "   checklists.checklist_type_id as checklist_type\n"
            + "FROM\n"
            + "   assigned_checklists\n"
            + "   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n"
            + "   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n"
            + "   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   INNER JOIN users ON assigned_checklists.user_id = users.id\n"
            + "   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n"
            + "   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n"
            + "   LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ?    ) \n"
            + "WHERE\n"
            + "    assigned_checklists.location_id = ? \n"
            + "AND assigned_users.is_deleted = 0 \n"
            + "AND assigned_checklists.checklist_status = ? \n"
            + "AND assigned_checklists.is_deleted = 0 \n"
            + "AND assigned_checklists.assignee_type = ? \n"
            + "AND (checklist_titles.title like ? OR  rooms.name like ? OR equipments.name like ?) \n"
            + " ORDER BY assigned_checklists.modified ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 7);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item;
              _item = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item.setChecklistType(_tmpChecklistType);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueDateDecAdmin(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String keyword) {
    final String _sql = "SELECT DISTINCT\n"
            + "   assigned_checklists.uuid,\n"
            + "   assigned_checklists.checklist_id,\n"
            + "   assigned_checklists.modified,\n"
            + "   checklist_titles.title,\n"
            + "   users.full_name AS last_updated_by,\n"
            + "    checklists.pending_resources_count as pendingResourcesCount, \n"
            + "   checklists.pending_references_count as pendingReferencesCount, \n"
            + "   assigned_checklists.execution_status as assigned_sync_status, \n"
            + "   checklists.sync_status as checklist_sync_status, \n"
            + "   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   assigned_checklists.pending_elements_count as pendingAssignedElementsCount,\n"
            + "   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,\n"
            + "   checklists.checklist_type_id as checklist_type\n"
            + "FROM\n"
            + "   assigned_checklists\n"
            + "   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n"
            + "   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n"
            + "   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   INNER JOIN users ON assigned_checklists.user_id = users.id\n"
            + "   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n"
            + "   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n"
            + "   LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "       UserFavorite.checklist_id = checklists.id        AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ?    ) \n"
            + "WHERE\n"
            + "    assigned_checklists.location_id = ? \n"
            + "AND assigned_users.is_deleted = 0 \n"
            + "AND assigned_checklists.checklist_status = ? \n"
            + "AND assigned_checklists.is_deleted = 0 \n"
            + "AND assigned_checklists.assignee_type = ? \n"
            + "AND (checklist_titles.title like ? OR  rooms.name like ? OR equipments.name like ?) \n"
            + " ORDER BY assigned_checklists.modified DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 7);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 3;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 4;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item;
              _item = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item.setLastUpdatedBy(_tmpLastUpdatedBy);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item.setMasterSyncStatus(_tmpMasterSyncStatus);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item.setFavorite(_tmpIsFavorite);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item.setChecklistType(_tmpChecklistType);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueDate(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String keyword) {
    final String _sql = "SELECT DISTINCT\n"
            + "   assigned_checklists.uuid,\n"
            + "   assigned_checklists.checklist_id,\n"
            + "   assigned_checklists.modified,\n"
            + "   checklist_titles.title,\n"
            + "   checklists.pending_resources_count as pendingResourcesCount, \n"
            + "   checklists.pending_references_count as pendingReferencesCount, \n"
            + "   assigned_checklists.execution_status as assigned_sync_status, \n"
            + "   checklists.sync_status as checklist_sync_status, \n"
            + "   users.full_name AS last_updated_by,\n"
            + "    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,\n"
            + "   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,\n"
            + "   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type\n"
            + "FROM\n"
            + "   assigned_checklists\n"
            + "   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n"
            + "   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n"
            + "   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   INNER JOIN users ON assigned_checklists.user_id = users.id\n"
            + "   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n"
            + "   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n"
            + "   LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "       UserFavorite.checklist_id = checklists.id \n"
            + "       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ?    )\n"
            + "WHERE\n"
            + "   assigned_users.user_id = ?    AND assigned_checklists.location_id = ? \n"
            + "   AND assigned_users.is_deleted = 0 \n"
            + "   AND assigned_checklists.checklist_status = ? \n"
            + "   AND assigned_checklists.is_deleted = 0 \n"
            + "   AND assigned_checklists.assignee_type = ? \n"
            + "   AND (checklist_titles.title like ? OR  rooms.name like ? OR equipments.name like ?)  ORDER BY assigned_checklists.modified ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item;
              _item = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item.setChecklistType(_tmpChecklistType);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, CancelledCompletedChecklistItems> getCheckListDueDateDec(
      final Integer userId, final Integer locationId, final Integer checklistStatus,
      final Integer assignType, final String keyword) {
    final String _sql = "SELECT DISTINCT\n"
            + "   assigned_checklists.uuid,\n"
            + "   assigned_checklists.checklist_id,\n"
            + "   assigned_checklists.modified,\n"
            + "   checklist_titles.title,\n"
            + "   checklists.pending_resources_count as pendingResourcesCount, \n"
            + "   checklists.pending_references_count as pendingReferencesCount, \n"
            + "   assigned_checklists.execution_status as assigned_sync_status, \n"
            + "   checklists.sync_status as checklist_sync_status, \n"
            + "   users.full_name AS last_updated_by,\n"
            + "    assigned_checklists.pending_elements_count as pendingAssignedElementsCount,\n"
            + "   assigned_checklists.pending_resources_count as pendingAssignedResourcesCount,\n"
            + "   CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,   checklists.checklist_type_id as checklist_type\n"
            + "FROM\n"
            + "   assigned_checklists\n"
            + "   INNER JOIN checklists ON assigned_checklists.checklist_id = checklists.id\n"
            + "   INNER JOIN checklist_titles ON checklist_titles.checklist_id = checklists.id\n"
            + "   INNER JOIN assigned_users ON assigned_users.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   INNER JOIN users ON assigned_checklists.user_id = users.id\n"
            + "   LEFT JOIN assigned_room_equipments ON assigned_room_equipments.assigned_checklist_uuid = assigned_checklists.uuid\n"
            + "   LEFT JOIN rooms ON assigned_room_equipments.room_id = rooms.id\n"
            + "   LEFT JOIN equipments ON assigned_room_equipments.equipment_id = equipments.id \n"
            + "   LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "       UserFavorite.checklist_id = checklists.id \n"
            + "       AND UserFavorite.is_deleted = 0        AND UserFavorite.user_id = ?    )\n"
            + "WHERE\n"
            + "   assigned_users.user_id = ?    AND assigned_checklists.location_id = ? \n"
            + "   AND assigned_users.is_deleted = 0 \n"
            + "   AND assigned_checklists.checklist_status = ? \n"
            + "   AND assigned_checklists.is_deleted = 0 \n"
            + "   AND assigned_checklists.assignee_type = ? \n"
            + "   AND (checklist_titles.title like ? OR  rooms.name like ? OR equipments.name like ?)  ORDER BY assigned_checklists.modified DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 8);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 3;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 4;
    if (checklistStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistStatus);
    }
    _argIndex = 5;
    if (assignType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, assignType);
    }
    _argIndex = 6;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 7;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 8;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, CancelledCompletedChecklistItems>() {
      @Override
      public LimitOffsetDataSource<CancelledCompletedChecklistItems> create() {
        return new LimitOffsetDataSource<CancelledCompletedChecklistItems>(__db, _statement, false , "assigned_checklists", "checklists", "checklist_titles", "assigned_users", "users", "assigned_room_equipments", "rooms", "equipments", "user_favorites") {
          @Override
          protected List<CancelledCompletedChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_id");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingResourcesCount");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingReferencesCount");
            final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(cursor, "assigned_sync_status");
            final int _cursorIndexOfMasterSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_sync_status");
            final int _cursorIndexOfLastUpdatedBy = CursorUtil.getColumnIndexOrThrow(cursor, "last_updated_by");
            final int _cursorIndexOfPendingAssignedElementsCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedElementsCount");
            final int _cursorIndexOfPendingAssignedResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pendingAssignedResourcesCount");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfChecklistType = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type");
            final List<CancelledCompletedChecklistItems> _res = new ArrayList<CancelledCompletedChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final CancelledCompletedChecklistItems _item;
              _item = new CancelledCompletedChecklistItems();
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final int _tmpPendingResourcesCount;
              _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final int _tmpPendingReferencesCount;
              _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final int _tmpSynced;
              _tmpSynced = cursor.getInt(_cursorIndexOfSynced);
              _item.setSynced(_tmpSynced);
              final int _tmpMasterSyncStatus;
              _tmpMasterSyncStatus = cursor.getInt(_cursorIndexOfMasterSyncStatus);
              _item.setMasterSyncStatus(_tmpMasterSyncStatus);
              final String _tmpLastUpdatedBy;
              _tmpLastUpdatedBy = cursor.getString(_cursorIndexOfLastUpdatedBy);
              _item.setLastUpdatedBy(_tmpLastUpdatedBy);
              final Integer _tmpPendingAssignedElementsCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedElementsCount)) {
                _tmpPendingAssignedElementsCount = null;
              } else {
                _tmpPendingAssignedElementsCount = cursor.getInt(_cursorIndexOfPendingAssignedElementsCount);
              }
              _item.setPendingAssignedElementsCount(_tmpPendingAssignedElementsCount);
              final Integer _tmpPendingAssignedResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingAssignedResourcesCount)) {
                _tmpPendingAssignedResourcesCount = null;
              } else {
                _tmpPendingAssignedResourcesCount = cursor.getInt(_cursorIndexOfPendingAssignedResourcesCount);
              }
              _item.setPendingAssignedResourcesCount(_tmpPendingAssignedResourcesCount);
              final boolean _tmpIsFavorite;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsFavorite);
              _tmpIsFavorite = _tmp != 0;
              _item.setFavorite(_tmpIsFavorite);
              final Integer _tmpChecklistType;
              if (cursor.isNull(_cursorIndexOfChecklistType)) {
                _tmpChecklistType = null;
              } else {
                _tmpChecklistType = cursor.getInt(_cursorIndexOfChecklistType);
              }
              _item.setChecklistType(_tmpChecklistType);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }
}
