package com.icarus.workorder.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CreateWorkOrderDao_Impl implements CreateWorkOrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WorkOrderAttachmentsEntity> __insertionAdapterOfWorkOrderAttachmentsEntity;

  private final EntityInsertionAdapter<WorkOrderNoteDetailEntity> __insertionAdapterOfWorkOrderNoteDetailEntity;

  private final EntityInsertionAdapter<WorkOrderEntity> __insertionAdapterOfWorkOrderEntity;

  public CreateWorkOrderDao_Impl(RoomDatabase __db) {
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
    this.__insertionAdapterOfWorkOrderEntity = new EntityInsertionAdapter<WorkOrderEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorders` (`id`,`uuid`,`title`,`description`,`due_date`,`workorder_status_id`,`assigned_to_id`,`assigned_to_type`,`workorder_priority_id`,`author_id`,`location_id`,`checklist_id`,`workorder_billing_type_id`,`location_equipment_id`,`location_room_id`,`start_date`,`closed_date`,`modified`,`sync_status`,`created`,`execution_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderEntity value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.uuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.uuid);
        }
        if (value.title == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.dueDate == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.dueDate);
        }
        if (value.workorderStatusId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.workorderStatusId);
        }
        if (value.assignedToId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.assignedToId);
        }
        if (value.assignedToType == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.assignedToType);
        }
        if (value.workorderPriorityId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.workorderPriorityId);
        }
        if (value.authorId == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.authorId);
        }
        if (value.locationId == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.locationId);
        }
        if (value.checklistId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.checklistId);
        }
        if (value.workorderBillingTypeId == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.workorderBillingTypeId);
        }
        if (value.locationEquipmentId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.locationEquipmentId);
        }
        if (value.locationRoomId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.locationRoomId);
        }
        if (value.startDate == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.startDate);
        }
        if (value.closedDate == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.closedDate);
        }
        if (value.modified == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.created);
        }
        if (value.executionStatus == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindLong(21, value.executionStatus);
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
  public void insertWorkOrder(final WorkOrderEntity workOrderEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderEntity.insert(workOrderEntity);
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

  @Override
  public Integer getWorkOrderId() {
    final String _sql = "SELECT id FROM workorders ORDER BY id ASC LIMIT 1";
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
