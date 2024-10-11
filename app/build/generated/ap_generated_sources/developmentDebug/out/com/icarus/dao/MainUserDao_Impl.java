package com.icarus.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.Login;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MainUserDao_Impl implements MainUserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Login> __insertionAdapterOfLogin;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserTerms;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUser;

  public MainUserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLogin = new EntityInsertionAdapter<Login>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`id`,`uuid`,`username`,`password`,`group_id`,`first_name`,`last_name`,`full_name`,`email`,`is_deleted`,`created_at`,`updated_at`,`is_administrator`,`account_uuid`,`terms_accepted`,`credentials`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Login value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUuid());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        if (value.getGroupId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getGroupId());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLastName());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFullName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEmail());
        }
        final int _tmp;
        _tmp = value.isDeleted() ? 1 : 0;
        stmt.bindLong(10, _tmp);
        if (value.getCreatedAt() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCreatedAt());
        }
        if (value.getUpdatedAt() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUpdatedAt());
        }
        final int _tmp_1;
        _tmp_1 = value.isAdministrator() ? 1 : 0;
        stmt.bindLong(13, _tmp_1);
        if (value.getClientUuid() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getClientUuid());
        }
        final int _tmp_2;
        _tmp_2 = value.isTermsAccepted() ? 1 : 0;
        stmt.bindLong(15, _tmp_2);
        if (value.getCredentials() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getCredentials());
        }
      }
    };
    this.__preparedStmtOfUpdateUserTerms = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE users SET terms_accepted = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUser = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete From users WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertUser(final Login entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLogin.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUserTerms(final Integer userId, final boolean isTermsAccepted) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserTerms.acquire();
    int _argIndex = 1;
    final int _tmp;
    _tmp = isTermsAccepted ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUserTerms.release(_stmt);
    }
  }

  @Override
  public void deleteUser(final int userId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUser.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, userId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUser.release(_stmt);
    }
  }

  @Override
  public Login validateUser(final String username, final String password) {
    final String _sql = "SELECT * FROM users WHERE LOWER(username) = ? AND password = ? AND is_deleted = 0 AND group_id NOT IN ( 1 ,7 )";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "created_at");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfIsAdministrator = CursorUtil.getColumnIndexOrThrow(_cursor, "is_administrator");
      final int _cursorIndexOfClientUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "account_uuid");
      final int _cursorIndexOfIsTermsAccepted = CursorUtil.getColumnIndexOrThrow(_cursor, "terms_accepted");
      final int _cursorIndexOfCredentials = CursorUtil.getColumnIndexOrThrow(_cursor, "credentials");
      final Login _result;
      if(_cursor.moveToFirst()) {
        _result = new Login();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _result.setUuid(_tmpUuid);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result.setUsername(_tmpUsername);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _result.setGroupId(_tmpGroupId);
        final String _tmpFirstName;
        _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        _result.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        _result.setLastName(_tmpLastName);
        final String _tmpFullName;
        _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        _result.setFullName(_tmpFullName);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _result.setEmail(_tmpEmail);
        final boolean _tmpIsDeleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDeleted);
        _tmpIsDeleted = _tmp != 0;
        _result.setDeleted(_tmpIsDeleted);
        final String _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        _result.setCreatedAt(_tmpCreatedAt);
        final String _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getString(_cursorIndexOfUpdatedAt);
        _result.setUpdatedAt(_tmpUpdatedAt);
        final boolean _tmpIsAdministrator;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsAdministrator);
        _tmpIsAdministrator = _tmp_1 != 0;
        _result.setAdministrator(_tmpIsAdministrator);
        final String _tmpClientUuid;
        _tmpClientUuid = _cursor.getString(_cursorIndexOfClientUuid);
        _result.setClientUuid(_tmpClientUuid);
        final boolean _tmpIsTermsAccepted;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsTermsAccepted);
        _tmpIsTermsAccepted = _tmp_2 != 0;
        _result.setTermsAccepted(_tmpIsTermsAccepted);
        final String _tmpCredentials;
        _tmpCredentials = _cursor.getString(_cursorIndexOfCredentials);
        _result.setCredentials(_tmpCredentials);
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
  public boolean isTermsAccepted(final Integer userId) {
    final String _sql = "Select terms_accepted FROM users WHERE id = ?";
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
