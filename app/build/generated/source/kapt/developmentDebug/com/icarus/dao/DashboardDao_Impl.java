package com.icarus.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import com.icarus.models.ChecklistItemPlaceHolders;
import com.icarus.models.StringCheckBox;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DashboardDao_Impl implements DashboardDao {
  private final RoomDatabase __db;

  public DashboardDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public List<StringCheckBox> getAllChecklistTypesFilter() {
    final String _sql = "select id, description as name from checklist_types where is_deleted = 0 and type <> 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfTitle = 1;
      final List<StringCheckBox> _result = new ArrayList<StringCheckBox>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StringCheckBox _item;
        _item = new StringCheckBox();
        _item.id = _cursor.getInt(_cursorIndexOfId);
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
  public List<StringCheckBox> getChecklistTypes() {
    final String _sql = "select id, description as name  from checklist_types where is_deleted = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfTitle = 1;
      final List<StringCheckBox> _result = new ArrayList<StringCheckBox>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StringCheckBox _item;
        _item = new StringCheckBox();
        _item.id = _cursor.getInt(_cursorIndexOfId);
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
  public List<StringCheckBox> getStatusWorkOrder() {
    final String _sql = "select id, name from workorder_statuses where id not in (4, 6, 7)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfTitle = 1;
      final List<StringCheckBox> _result = new ArrayList<StringCheckBox>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StringCheckBox _item;
        _item = new StringCheckBox();
        _item.id = _cursor.getInt(_cursorIndexOfId);
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
  public List<ChecklistItemPlaceHolders> getItemPlaceHolders(final String checklistUUID) {
    final String _sql = "SELECT \n"
            + "ChecklistElement.id,\n"
            + "ChecklistElement.sequence_no,\n"
            + "Placeholder.name,\n"
            + "AssignedItemPlaceholder.value,\n"
            + "AssignedItemPlaceholder.created AS captured_at,\n"
            + "User.full_name AS captured_by\n"
            + "FROM assigned_item_placeholders AssignedItemPlaceholder\n"
            + "LEFT JOIN checklist_elements ChecklistElement ON (ChecklistElement.id = AssignedItemPlaceholder.checklist_element_id)\n"
            + "LEFT JOIN item_placeholders ItemPlaceholder ON (ItemPlaceholder.id = AssignedItemPlaceholder.item_placeholder_id)\n"
            + "LEFT JOIN placeholders Placeholder ON (Placeholder.id = ItemPlaceholder.placeholder_id)\n"
            + "LEFT JOIN users User ON (User.id = AssignedItemPlaceholder.user_id)\n"
            + "WHERE\n"
            + "    AssignedItemPlaceholder.assigned_checklist_uuid = ?    AND AssignedItemPlaceholder.is_deleted = 0\n"
            + "    AND ChecklistElement.is_deleted = 0\n"
            + "ORDER BY ChecklistElement.sort_order ASC, ItemPlaceholder.sort_order ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUUID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSequenceNo = 1;
      final int _cursorIndexOfName = 2;
      final int _cursorIndexOfValue = 3;
      final int _cursorIndexOfCapturedAt = 4;
      final int _cursorIndexOfCapturedBy = 5;
      final List<ChecklistItemPlaceHolders> _result = new ArrayList<ChecklistItemPlaceHolders>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChecklistItemPlaceHolders _item;
        _item = new ChecklistItemPlaceHolders();
        final String _tmpSequenceNo;
        if (_cursor.isNull(_cursorIndexOfSequenceNo)) {
          _tmpSequenceNo = null;
        } else {
          _tmpSequenceNo = _cursor.getString(_cursorIndexOfSequenceNo);
        }
        _item.setSequenceNo(_tmpSequenceNo);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpValue;
        if (_cursor.isNull(_cursorIndexOfValue)) {
          _tmpValue = null;
        } else {
          _tmpValue = _cursor.getString(_cursorIndexOfValue);
        }
        _item.setValue(_tmpValue);
        final String _tmpCapturedAt;
        if (_cursor.isNull(_cursorIndexOfCapturedAt)) {
          _tmpCapturedAt = null;
        } else {
          _tmpCapturedAt = _cursor.getString(_cursorIndexOfCapturedAt);
        }
        _item.setCapturedAt(_tmpCapturedAt);
        final String _tmpCapturedBy;
        if (_cursor.isNull(_cursorIndexOfCapturedBy)) {
          _tmpCapturedBy = null;
        } else {
          _tmpCapturedBy = _cursor.getString(_cursorIndexOfCapturedBy);
        }
        _item.setCapturedBy(_tmpCapturedBy);
        _result.add(_item);
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
