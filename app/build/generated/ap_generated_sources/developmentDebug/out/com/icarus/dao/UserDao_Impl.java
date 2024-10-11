package com.icarus.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public boolean isQCM(final Integer userId, final Integer locationId) {
    final String _sql = "SELECT COUNT(UserLocationDepartment.id) FROM user_location_departments AS UserLocationDepartment INNER JOIN departments AS Department ON (    Department.id = UserLocationDepartment.department_id ) WHERE    UserLocationDepartment.is_deleted = 0 AND UserLocationDepartment.user_id = ? AND UserLocationDepartment.location_id = ? AND Department.is_deleted = 0 AND Department.short_name = 'QCM'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
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
}
