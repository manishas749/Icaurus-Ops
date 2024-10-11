package com.icarus.dao;

import android.database.Cursor;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignedChecklistCommentsEntity;
import com.icarus.models.ChecklistNotesItem;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotesDao_Impl extends NotesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AssignedChecklistCommentsEntity> __insertionAdapterOfAssignedChecklistCommentsEntity;

  public NotesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAssignedChecklistCommentsEntity = new EntityInsertionAdapter<AssignedChecklistCommentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_checklist_comments` (`uuid`,`assigned_checklist_uuid`,`user_id`,`comment`,`is_deleted`,`created`,`modified`,`sync_status`,`checklist_id`,`checklist_element_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedChecklistCommentsEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssigned_checklist_uuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssigned_checklist_uuid());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getUserId());
        }
        if (value.getComment() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getComment());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getIsDeleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getSyncStatus());
        }
        if (value.getChecklistId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getChecklistId());
        }
        if (value.getChecklistElementId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getChecklistElementId());
        }
      }
    };
  }

  @Override
  public void insertUserNote(
      final AssignedChecklistCommentsEntity assignedChecklistCommentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedChecklistCommentsEntity.insert(assignedChecklistCommentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public DataSource.Factory<Integer, ChecklistNotesItem> getNotesList(final String checklistUUID) {
    final String _sql = "SELECT     AssignedChecklistComment.comment,     AssignedChecklistComment.modified AS updatedAt,     User.full_name AS userFullName FROM     assigned_checklist_comments AS AssignedChecklistComment         LEFT JOIN     users AS User ON (AssignedChecklistComment.user_id = User.id) WHERE     AssignedChecklistComment.assigned_checklist_uuid = ? ORDER BY AssignedChecklistComment.modified DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistUUID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, checklistUUID);
    }
    return new DataSource.Factory<Integer, ChecklistNotesItem>() {
      @Override
      public LimitOffsetDataSource<ChecklistNotesItem> create() {
        return new LimitOffsetDataSource<ChecklistNotesItem>(__db, _statement, false , "assigned_checklist_comments", "users") {
          @Override
          protected List<ChecklistNotesItem> convertRows(Cursor cursor) {
            final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(cursor, "comment");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(cursor, "updatedAt");
            final int _cursorIndexOfUserFullName = CursorUtil.getColumnIndexOrThrow(cursor, "userFullName");
            final List<ChecklistNotesItem> _res = new ArrayList<ChecklistNotesItem>(cursor.getCount());
            while(cursor.moveToNext()) {
              final ChecklistNotesItem _item;
              _item = new ChecklistNotesItem();
              final String _tmpComment;
              _tmpComment = cursor.getString(_cursorIndexOfComment);
              _item.setComment(_tmpComment);
              final String _tmpUpdatedAt;
              _tmpUpdatedAt = cursor.getString(_cursorIndexOfUpdatedAt);
              _item.setUpdatedAt(_tmpUpdatedAt);
              final String _tmpUserFullName;
              _tmpUserFullName = cursor.getString(_cursorIndexOfUserFullName);
              _item.setUserFullName(_tmpUserFullName);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }
}
