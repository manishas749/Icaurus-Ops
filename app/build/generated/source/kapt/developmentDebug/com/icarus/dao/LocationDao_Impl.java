package com.icarus.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.icarus.entities.LocationEntity;
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
public final class LocationDao_Impl implements LocationDao {
  private final RoomDatabase __db;

  public LocationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public List<LocationEntity> getLocations(final Integer userId) {
    final String _sql = "SELECT  \n"
            + "  DISTINCT locations.id, \n"
            + "  locations.name, \n"
            + "  locations.timezone, \n"
            + "  locations.last_sync_time \n"
            + "FROM \n"
            + "  locations \n"
            + "  INNER JOIN user_location_departments ON user_location_departments.location_id = locations.id \n"
            + "WHERE \n"
            + "  user_location_departments.user_id = ?  and user_location_departments.is_deleted = 0";
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
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfName = 1;
      final int _cursorIndexOfTimezone = 2;
      final int _cursorIndexOfLastSyncTime = 3;
      final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LocationEntity _item;
        _item = new LocationEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpTimezone;
        if (_cursor.isNull(_cursorIndexOfTimezone)) {
          _tmpTimezone = null;
        } else {
          _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
        }
        _item.setTimezone(_tmpTimezone);
        final String _tmpLastSyncTime;
        if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
          _tmpLastSyncTime = null;
        } else {
          _tmpLastSyncTime = _cursor.getString(_cursorIndexOfLastSyncTime);
        }
        _item.setLastSyncTime(_tmpLastSyncTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<LocationEntity> getLocations() {
    final String _sql = "SELECT \n"
            + "  DISTINCT locations.id, \n"
            + "  locations.name, \n"
            + "  locations.timezone, \n"
            + "  locations.last_sync_time \n"
            + "FROM \n"
            + "  locations";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfName = 1;
      final int _cursorIndexOfTimezone = 2;
      final int _cursorIndexOfLastSyncTime = 3;
      final List<LocationEntity> _result = new ArrayList<LocationEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LocationEntity _item;
        _item = new LocationEntity();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpTimezone;
        if (_cursor.isNull(_cursorIndexOfTimezone)) {
          _tmpTimezone = null;
        } else {
          _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
        }
        _item.setTimezone(_tmpTimezone);
        final String _tmpLastSyncTime;
        if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
          _tmpLastSyncTime = null;
        } else {
          _tmpLastSyncTime = _cursor.getString(_cursorIndexOfLastSyncTime);
        }
        _item.setLastSyncTime(_tmpLastSyncTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LocationEntity get(final Integer id) {
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
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpTimezone;
        if (_cursor.isNull(_cursorIndexOfTimezone)) {
          _tmpTimezone = null;
        } else {
          _tmpTimezone = _cursor.getString(_cursorIndexOfTimezone);
        }
        _result.setTimezone(_tmpTimezone);
        final String _tmpLastSyncTime;
        if (_cursor.isNull(_cursorIndexOfLastSyncTime)) {
          _tmpLastSyncTime = null;
        } else {
          _tmpLastSyncTime = _cursor.getString(_cursorIndexOfLastSyncTime);
        }
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
