package com.icarus.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.icarus.models.ClientSettingItems;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ClientDao_Impl implements ClientDao {
  private final RoomDatabase __db;

  public ClientDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public List<ClientSettingItems> getClientSetting() {
    final String _sql = "SELECT name, value FROM client_settings";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final List<ClientSettingItems> _result = new ArrayList<ClientSettingItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ClientSettingItems _item;
        _item = new ClientSettingItems();
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        _item.setValue(_tmpValue);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
