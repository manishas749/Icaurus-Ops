package com.icarus.workorder.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkOrderCommonDao_Impl implements WorkOrderCommonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WorkOrderAttachmentsEntity> __insertionAdapterOfWorkOrderAttachmentsEntity;

  private final EntityInsertionAdapter<WorkOrderNoteDetailEntity> __insertionAdapterOfWorkOrderNoteDetailEntity;

  public WorkOrderCommonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWorkOrderAttachmentsEntity = new EntityInsertionAdapter<WorkOrderAttachmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorder_attachments` (`id`,`uuid`,`workorder_id`,`display_filename`,`filename`,`filesize`,`content_type`,`author_id`,`file_md5_checksum`,`modified`,`sync_status`,`created`,`is_downloaded`,`is_uploaded`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderAttachmentsEntity value) {
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
        if (value.getWorkorderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderId());
        }
        if (value.getDisplayFileName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDisplayFileName());
        }
        if (value.getFilename() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFilename());
        }
        if (value.getFilesize() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getFilesize());
        }
        if (value.getContentType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContentType());
        }
        if (value.getAuthorId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getAuthorId());
        }
        if (value.getFileMd5Checksum() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFileMd5Checksum());
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.created);
        }
        if (value.isDownloaded == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.isDownloaded);
        }
        if (value.isUploaded == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.isUploaded);
        }
      }
    };
    this.__insertionAdapterOfWorkOrderNoteDetailEntity = new EntityInsertionAdapter<WorkOrderNoteDetailEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorder_note_details` (`id`,`uuid`,`workorder_note_id`,`property`,`property_key`,`old_value`,`value`,`modified`,`sync_status`,`created`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNoteDetailEntity value) {
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
        if (value.getWorkorderNoteId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getWorkorderNoteId());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProperty());
        }
        if (value.getPropertyKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPropertyKey());
        }
        if (value.getOldValue() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOldValue());
        }
        if (value.getValue() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getValue());
        }
        if (value.modified == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.created);
        }
      }
    };
  }

  @Override
  public void insertWorkOrderAttachments(
      final WorkOrderAttachmentsEntity workOrderAttachmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderAttachmentsEntity.insert(workOrderAttachmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertNoteDetails(final WorkOrderNoteDetailEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderNoteDetailEntity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Integer getQcmId() {
    final String _sql = "SELECT id FROM departments WHERE short_name = 'QCM'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getInt(0);
        }
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
  public Integer getWorkOrderNoteDetailId() {
    final String _sql = "SELECT id FROM workorder_note_details ORDER BY id ASC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getInt(0);
        }
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
  public Integer getWorkOrderAttachmentId() {
    final String _sql = "SELECT id FROM workorder_attachments ORDER BY id ASC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getInt(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
