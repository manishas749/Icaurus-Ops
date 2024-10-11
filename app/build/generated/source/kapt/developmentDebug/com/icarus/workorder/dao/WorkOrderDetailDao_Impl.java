package com.icarus.workorder.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.WorkOrderAttachmentsEntity;
import com.icarus.entities.WorkOrderNoteDetailEntity;
import com.icarus.entities.WorkOrderNotesEntity;
import com.icarus.workorder.models.WorkOrderAttachmentItems;
import com.icarus.workorder.models.WorkOrderDetailItems;
import com.icarus.workorder.models.WorkOrderNoteDetailItems;
import com.icarus.workorder.models.WorkOrderNoteInfoItems;
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
public final class WorkOrderDetailDao_Impl implements WorkOrderDetailDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WorkOrderAttachmentsEntity> __insertionAdapterOfWorkOrderAttachmentsEntity;

  private final EntityInsertionAdapter<WorkOrderNoteDetailEntity> __insertionAdapterOfWorkOrderNoteDetailEntity;

  private final EntityInsertionAdapter<WorkOrderNotesEntity> __insertionAdapterOfWorkOrderNotesEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWorkOrder;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWorkOrder_1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWorkOrderComplete;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWorkOrderAttachment;

  public WorkOrderDetailDao_Impl(RoomDatabase __db) {
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
    this.__insertionAdapterOfWorkOrderNotesEntity = new EntityInsertionAdapter<WorkOrderNotesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workorder_notes` (`id`,`uuid`,`workorder_id`,`user_id`,`workorder_notes`,`modified`,`sync_status`,`created`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WorkOrderNotesEntity value) {
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
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getUserId());
        }
        if (value.getWorkorderNotes() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getWorkorderNotes());
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.syncStatus);
        }
        if (value.created == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.created);
        }
      }
    };
    this.__preparedStmtOfUpdateWorkOrder = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorders set sync_status = 0, modified = ?, start_date = ?, workorder_status_id = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWorkOrder_1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorders set sync_status = 0, modified = ?, start_date = ?, workorder_status_id = ?, assigned_to_type = 1, assigned_to_id = ? where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWorkOrderComplete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorders set sync_status = 0, modified = ?, closed_date = ?, workorder_status_id = 3 where uuid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWorkOrderAttachment = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update workorder_attachments set is_downloaded = 1 WHERE uuid = ?";
        return _query;
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
  public void insertNotes(final WorkOrderNotesEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWorkOrderNotesEntity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkOrder(final String currentTime, final Integer workorderStatusId,
      final String workOrderUuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWorkOrder.acquire();
    int _argIndex = 1;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 2;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 3;
    if (workorderStatusId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, workorderStatusId);
    }
    _argIndex = 4;
    if (workOrderUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, workOrderUuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateWorkOrder.release(_stmt);
    }
  }

  @Override
  public void updateWorkOrder(final String currentTime, final Integer workorderStatusId,
      final String workOrderUuid, final Integer userId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWorkOrder_1.acquire();
    int _argIndex = 1;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 2;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 3;
    if (workorderStatusId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, workorderStatusId);
    }
    _argIndex = 4;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, userId);
    }
    _argIndex = 5;
    if (workOrderUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, workOrderUuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateWorkOrder_1.release(_stmt);
    }
  }

  @Override
  public void updateWorkOrderComplete(final String currentTime, final String workOrderUuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWorkOrderComplete.acquire();
    int _argIndex = 1;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 2;
    if (currentTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, currentTime);
    }
    _argIndex = 3;
    if (workOrderUuid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, workOrderUuid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateWorkOrderComplete.release(_stmt);
    }
  }

  @Override
  public void updateWorkOrderAttachment(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWorkOrderAttachment.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfUpdateWorkOrderAttachment.release(_stmt);
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
  public LiveData<WorkOrderDetailItems> getWorkOrderInfo(final String workOrderUuid) {
    final String _sql = "SELECT\n"
            + "\tWorkorder.id,\n"
            + "\tWorkorder.uuid,\n"
            + "\tWorkorder.title,\n"
            + "\tWorkorder.description,\n"
            + "\tWorkorder.due_date,\n"
            + "\tWorkorder.workorder_status_id,\n"
            + "\tWorkorder.assigned_to_id,\n"
            + "\tWorkorder.assigned_to_type,\n"
            + "\tWorkorder.workorder_priority_id,\n"
            + "\tWorkorder.author_id,\n"
            + "\tWorkorder.location_id,\n"
            + "\tWorkorder.checklist_id,\n"
            + "\tWorkorder.workorder_billing_type_id,\n"
            + "\tWorkorder.location_room_id,\n"
            + "\tWorkorder.location_equipment_id,\n"
            + "\tWorkorder.start_date,\n"
            + "\tWorkorder.closed_date,\n"
            + "\tWorkorder.created,\n"
            + "\tWorkorder.modified,\n"
            + "\t( CASE WHEN Workorder.assigned_to_type <> 2 THEN AssignedToUser.full_name ELSE AssignedToDepartment.name  END ) AS Workorder__assigned_to,\n"
            + "\t( CASE WHEN Workorder.assigned_to_type <> 2 THEN AssignedToUser.uuid ELSE AssignedToDepartment.uuid END  ) AS Workorder__assigned_to_uuid,\n"
            + "\tWorkorderStatus.name AS WorkorderStatusName,\n"
            + "\tAuthor.full_name AS Author__full_name,\n"
            + "\tAssignedToUser.id AS assignedToUserId,\n"
            + "\tAssignedToDepartment.id AS assignedToDepartmentId,\n"
            + "\tWorkorderBillingType.name AS WorkorderBillingTypeName,\n"
            + "\tLocation.name AS LocationName,\n"
            + "\tLocationRoomEquipment.id AS LocRoomEquipID,\n"
            + "\tLocationRoomEquipment.location_id AS Loc_id,\n"
            + "\tLocationRoomEquipment.room_id,\n"
            + "\tLocationRoomEquipment.equipment_id,\n"
            + "\tRoom.name AS RoomName,\n"
            + "\tEquipment.name AS EquipmentName \n"
            + "\tFROM\n"
            + "\t\t\tworkorders AS Workorder\n"
            + "\t\t\tLEFT JOIN workorder_statuses AS WorkorderStatus ON ( Workorder.workorder_status_id = WorkorderStatus.id )\n"
            + "\t\t\tLEFT JOIN users AS Author ON ( Workorder.author_id = Author.id )\n"
            + "\t\t\tLEFT JOIN users AS AssignedToUser ON (\n"
            + "\t\t\t\tWorkorder.assigned_to_id = AssignedToUser.id \n"
            + "\t\t\t\tAND Workorder.assigned_to_type <> 2 \n"
            + "\t\t\t)\n"
            + "\t\t\tLEFT JOIN departments AS AssignedToDepartment ON (\n"
            + "\t\t\t\tWorkorder.assigned_to_id = AssignedToDepartment.id \n"
            + "\t\t\t\tAND Workorder.assigned_to_type = 2 \n"
            + "\t\t\t)\n"
            + "\t\t\tLEFT JOIN workorder_billing_types AS WorkorderBillingType ON ( Workorder.workorder_billing_type_id = WorkorderBillingType.id )\n"
            + "\t\t\tLEFT JOIN locations AS Location ON ( Workorder.location_id = Location.id )\n"
            + "\t\t\tLEFT JOIN location_room_equipments AS LocationRoomEquipment ON (\n"
            + "\t\t\t\tWorkorder.location_room_id = LocationRoomEquipment.room_id \n"
            + "\t\t\t\tAND Workorder.location_equipment_id = LocationRoomEquipment.equipment_id \n"
            + "\t\t\t\tAND Workorder.location_id = LocationRoomEquipment.location_id \n"
            + "\t\t\t)\n"
            + "\t\t\tLEFT JOIN rooms AS Room ON ( Room.id = LocationRoomEquipment.room_id )\n"
            + "\t\t\tLEFT JOIN equipments AS Equipment ON ( Equipment.id = LocationRoomEquipment.equipment_id ) \n"
            + "\t\tWHERE\n"
            + "\t\tWorkorder.uuid = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderUuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workOrderUuid);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workorders","workorder_statuses","users","departments","workorder_billing_types","locations","location_room_equipments","rooms","equipments"}, false, new Callable<WorkOrderDetailItems>() {
      @Override
      public WorkOrderDetailItems call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfUuid = 1;
          final int _cursorIndexOfTitle = 2;
          final int _cursorIndexOfDescription = 3;
          final int _cursorIndexOfDueDate = 4;
          final int _cursorIndexOfWorkorderStatusId = 5;
          final int _cursorIndexOfAssignedToId = 6;
          final int _cursorIndexOfAssignedToType = 7;
          final int _cursorIndexOfWorkorderPriorityId = 8;
          final int _cursorIndexOfAuthorId = 9;
          final int _cursorIndexOfLocationId = 10;
          final int _cursorIndexOfChecklistId = 11;
          final int _cursorIndexOfWorkorderBillingTypeId = 12;
          final int _cursorIndexOfLocationRoomId = 13;
          final int _cursorIndexOfLocationEquipmentId = 14;
          final int _cursorIndexOfStartDate = 15;
          final int _cursorIndexOfClosedDate = 16;
          final int _cursorIndexOfCreated = 17;
          final int _cursorIndexOfModified = 18;
          final int _cursorIndexOfWorkorderAssignedTo = 19;
          final int _cursorIndexOfWorkorderAssignedToUuid = 20;
          final int _cursorIndexOfWorkorderStatusName = 21;
          final int _cursorIndexOfAuthorFullName = 22;
          final int _cursorIndexOfAssignedToUserId = 23;
          final int _cursorIndexOfAssignedToDepartmentId = 24;
          final int _cursorIndexOfWorkorderBillingTypeName = 25;
          final int _cursorIndexOfLocationName = 26;
          final int _cursorIndexOfLocRoomEquipID = 27;
          final int _cursorIndexOfLocId = 28;
          final int _cursorIndexOfRoomId = 29;
          final int _cursorIndexOfEquipmentId = 30;
          final int _cursorIndexOfRoomName = 31;
          final int _cursorIndexOfEquipmentName = 32;
          final WorkOrderDetailItems _result;
          if(_cursor.moveToFirst()) {
            _result = new WorkOrderDetailItems();
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _result.setId(_tmpId);
            final String _tmpUuid;
            if (_cursor.isNull(_cursorIndexOfUuid)) {
              _tmpUuid = null;
            } else {
              _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            }
            _result.setUuid(_tmpUuid);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            _result.setTitle(_tmpTitle);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _result.setDescription(_tmpDescription);
            final String _tmpDueDate;
            if (_cursor.isNull(_cursorIndexOfDueDate)) {
              _tmpDueDate = null;
            } else {
              _tmpDueDate = _cursor.getString(_cursorIndexOfDueDate);
            }
            _result.setDueDate(_tmpDueDate);
            final Integer _tmpWorkorderStatusId;
            if (_cursor.isNull(_cursorIndexOfWorkorderStatusId)) {
              _tmpWorkorderStatusId = null;
            } else {
              _tmpWorkorderStatusId = _cursor.getInt(_cursorIndexOfWorkorderStatusId);
            }
            _result.setWorkorderStatusId(_tmpWorkorderStatusId);
            final Integer _tmpAssignedToId;
            if (_cursor.isNull(_cursorIndexOfAssignedToId)) {
              _tmpAssignedToId = null;
            } else {
              _tmpAssignedToId = _cursor.getInt(_cursorIndexOfAssignedToId);
            }
            _result.setAssignedToId(_tmpAssignedToId);
            final Integer _tmpAssignedToType;
            if (_cursor.isNull(_cursorIndexOfAssignedToType)) {
              _tmpAssignedToType = null;
            } else {
              _tmpAssignedToType = _cursor.getInt(_cursorIndexOfAssignedToType);
            }
            _result.setAssignedToType(_tmpAssignedToType);
            final Integer _tmpWorkorderPriorityId;
            if (_cursor.isNull(_cursorIndexOfWorkorderPriorityId)) {
              _tmpWorkorderPriorityId = null;
            } else {
              _tmpWorkorderPriorityId = _cursor.getInt(_cursorIndexOfWorkorderPriorityId);
            }
            _result.setWorkorderPriorityId(_tmpWorkorderPriorityId);
            final String _tmpAuthorId;
            if (_cursor.isNull(_cursorIndexOfAuthorId)) {
              _tmpAuthorId = null;
            } else {
              _tmpAuthorId = _cursor.getString(_cursorIndexOfAuthorId);
            }
            _result.setAuthorId(_tmpAuthorId);
            final Integer _tmpLocationId;
            if (_cursor.isNull(_cursorIndexOfLocationId)) {
              _tmpLocationId = null;
            } else {
              _tmpLocationId = _cursor.getInt(_cursorIndexOfLocationId);
            }
            _result.setLocationId(_tmpLocationId);
            final Integer _tmpChecklistId;
            if (_cursor.isNull(_cursorIndexOfChecklistId)) {
              _tmpChecklistId = null;
            } else {
              _tmpChecklistId = _cursor.getInt(_cursorIndexOfChecklistId);
            }
            _result.setChecklistId(_tmpChecklistId);
            final Integer _tmpWorkorderBillingTypeId;
            if (_cursor.isNull(_cursorIndexOfWorkorderBillingTypeId)) {
              _tmpWorkorderBillingTypeId = null;
            } else {
              _tmpWorkorderBillingTypeId = _cursor.getInt(_cursorIndexOfWorkorderBillingTypeId);
            }
            _result.setWorkorderBillingTypeId(_tmpWorkorderBillingTypeId);
            final Integer _tmpLocationRoomId;
            if (_cursor.isNull(_cursorIndexOfLocationRoomId)) {
              _tmpLocationRoomId = null;
            } else {
              _tmpLocationRoomId = _cursor.getInt(_cursorIndexOfLocationRoomId);
            }
            _result.setLocationRoomId(_tmpLocationRoomId);
            final Integer _tmpLocationEquipmentId;
            if (_cursor.isNull(_cursorIndexOfLocationEquipmentId)) {
              _tmpLocationEquipmentId = null;
            } else {
              _tmpLocationEquipmentId = _cursor.getInt(_cursorIndexOfLocationEquipmentId);
            }
            _result.setLocationEquipmentId(_tmpLocationEquipmentId);
            final String _tmpStartDate;
            if (_cursor.isNull(_cursorIndexOfStartDate)) {
              _tmpStartDate = null;
            } else {
              _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
            }
            _result.setStartDate(_tmpStartDate);
            final String _tmpClosedDate;
            if (_cursor.isNull(_cursorIndexOfClosedDate)) {
              _tmpClosedDate = null;
            } else {
              _tmpClosedDate = _cursor.getString(_cursorIndexOfClosedDate);
            }
            _result.setClosedDate(_tmpClosedDate);
            final String _tmpCreated;
            if (_cursor.isNull(_cursorIndexOfCreated)) {
              _tmpCreated = null;
            } else {
              _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
            }
            _result.setCreated(_tmpCreated);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
            final String _tmpWorkorderAssignedTo;
            if (_cursor.isNull(_cursorIndexOfWorkorderAssignedTo)) {
              _tmpWorkorderAssignedTo = null;
            } else {
              _tmpWorkorderAssignedTo = _cursor.getString(_cursorIndexOfWorkorderAssignedTo);
            }
            _result.setWorkorderAssignedTo(_tmpWorkorderAssignedTo);
            final String _tmpWorkorderAssignedToUuid;
            if (_cursor.isNull(_cursorIndexOfWorkorderAssignedToUuid)) {
              _tmpWorkorderAssignedToUuid = null;
            } else {
              _tmpWorkorderAssignedToUuid = _cursor.getString(_cursorIndexOfWorkorderAssignedToUuid);
            }
            _result.setWorkorderAssignedToUuid(_tmpWorkorderAssignedToUuid);
            final String _tmpWorkorderStatusName;
            if (_cursor.isNull(_cursorIndexOfWorkorderStatusName)) {
              _tmpWorkorderStatusName = null;
            } else {
              _tmpWorkorderStatusName = _cursor.getString(_cursorIndexOfWorkorderStatusName);
            }
            _result.setWorkorderStatusName(_tmpWorkorderStatusName);
            final String _tmpAuthorFullName;
            if (_cursor.isNull(_cursorIndexOfAuthorFullName)) {
              _tmpAuthorFullName = null;
            } else {
              _tmpAuthorFullName = _cursor.getString(_cursorIndexOfAuthorFullName);
            }
            _result.setAuthorFullName(_tmpAuthorFullName);
            final Integer _tmpAssignedToUserId;
            if (_cursor.isNull(_cursorIndexOfAssignedToUserId)) {
              _tmpAssignedToUserId = null;
            } else {
              _tmpAssignedToUserId = _cursor.getInt(_cursorIndexOfAssignedToUserId);
            }
            _result.setAssignedToUserId(_tmpAssignedToUserId);
            final Integer _tmpAssignedToDepartmentId;
            if (_cursor.isNull(_cursorIndexOfAssignedToDepartmentId)) {
              _tmpAssignedToDepartmentId = null;
            } else {
              _tmpAssignedToDepartmentId = _cursor.getInt(_cursorIndexOfAssignedToDepartmentId);
            }
            _result.setAssignedToDepartmentId(_tmpAssignedToDepartmentId);
            final String _tmpWorkorderBillingTypeName;
            if (_cursor.isNull(_cursorIndexOfWorkorderBillingTypeName)) {
              _tmpWorkorderBillingTypeName = null;
            } else {
              _tmpWorkorderBillingTypeName = _cursor.getString(_cursorIndexOfWorkorderBillingTypeName);
            }
            _result.setWorkorderBillingTypeName(_tmpWorkorderBillingTypeName);
            final String _tmpLocationName;
            if (_cursor.isNull(_cursorIndexOfLocationName)) {
              _tmpLocationName = null;
            } else {
              _tmpLocationName = _cursor.getString(_cursorIndexOfLocationName);
            }
            _result.setLocationName(_tmpLocationName);
            final Integer _tmpLocRoomEquipID;
            if (_cursor.isNull(_cursorIndexOfLocRoomEquipID)) {
              _tmpLocRoomEquipID = null;
            } else {
              _tmpLocRoomEquipID = _cursor.getInt(_cursorIndexOfLocRoomEquipID);
            }
            _result.setLocRoomEquipID(_tmpLocRoomEquipID);
            final Integer _tmpLocId;
            if (_cursor.isNull(_cursorIndexOfLocId)) {
              _tmpLocId = null;
            } else {
              _tmpLocId = _cursor.getInt(_cursorIndexOfLocId);
            }
            _result.setLocId(_tmpLocId);
            final Integer _tmpRoomId;
            if (_cursor.isNull(_cursorIndexOfRoomId)) {
              _tmpRoomId = null;
            } else {
              _tmpRoomId = _cursor.getInt(_cursorIndexOfRoomId);
            }
            _result.setRoomId(_tmpRoomId);
            final Integer _tmpEquipmentId;
            if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
              _tmpEquipmentId = null;
            } else {
              _tmpEquipmentId = _cursor.getInt(_cursorIndexOfEquipmentId);
            }
            _result.setEquipmentId(_tmpEquipmentId);
            final String _tmpRoomName;
            if (_cursor.isNull(_cursorIndexOfRoomName)) {
              _tmpRoomName = null;
            } else {
              _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
            }
            _result.setRoomName(_tmpRoomName);
            final String _tmpEquipmentName;
            if (_cursor.isNull(_cursorIndexOfEquipmentName)) {
              _tmpEquipmentName = null;
            } else {
              _tmpEquipmentName = _cursor.getString(_cursorIndexOfEquipmentName);
            }
            _result.setEquipmentName(_tmpEquipmentName);
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
  public LiveData<List<WorkOrderNoteInfoItems>> getWorkOrderNoteInfo(final Integer workOrderId) {
    final String _sql = "SELECT  WorkorderNote.workorder_notes, WorkorderNote.created, WorkorderNote.user_id, \n"
            + "                WorkorderNote.id, User.full_name as name  \n"
            + "                FROM workorder_notes AS WorkorderNote                 LEFT JOIN users as User On (User.id = WorkorderNote.user_id)  \n"
            + "                WHERE WorkorderNote.workorder_id = ?   ORDER BY WorkorderNote.created ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, workOrderId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workorder_notes","users"}, false, new Callable<List<WorkOrderNoteInfoItems>>() {
      @Override
      public List<WorkOrderNoteInfoItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfWorkorderNotes = 0;
          final int _cursorIndexOfCreated = 1;
          final int _cursorIndexOfUserId = 2;
          final int _cursorIndexOfId = 3;
          final int _cursorIndexOfName = 4;
          final List<WorkOrderNoteInfoItems> _result = new ArrayList<WorkOrderNoteInfoItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WorkOrderNoteInfoItems _item;
            _item = new WorkOrderNoteInfoItems();
            final String _tmpWorkorderNotes;
            if (_cursor.isNull(_cursorIndexOfWorkorderNotes)) {
              _tmpWorkorderNotes = null;
            } else {
              _tmpWorkorderNotes = _cursor.getString(_cursorIndexOfWorkorderNotes);
            }
            _item.setWorkorderNotes(_tmpWorkorderNotes);
            final String _tmpCreated;
            if (_cursor.isNull(_cursorIndexOfCreated)) {
              _tmpCreated = null;
            } else {
              _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
            }
            _item.setCreated(_tmpCreated);
            final Integer _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            }
            _item.setUserId(_tmpUserId);
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
            _result.add(_item);
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
  public LiveData<List<WorkOrderAttachmentItems>> getWorkOrderAttachments(
      final Integer workOrderId) {
    final String _sql = "SELECT uuid, display_filename, file_md5_checksum, filename, content_type, is_downloaded from workorder_attachments \n"
            + "                AS WorkOrderAttachment WHERE WorkOrderAttachment.workorder_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workOrderId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, workOrderId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workorder_attachments"}, false, new Callable<List<WorkOrderAttachmentItems>>() {
      @Override
      public List<WorkOrderAttachmentItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUuid = 0;
          final int _cursorIndexOfDisplayFileName = 1;
          final int _cursorIndexOfFileMd5Checksum = 2;
          final int _cursorIndexOfFileName = 3;
          final int _cursorIndexOfContentType = 4;
          final int _cursorIndexOfIsDownloaded = 5;
          final List<WorkOrderAttachmentItems> _result = new ArrayList<WorkOrderAttachmentItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WorkOrderAttachmentItems _item;
            _item = new WorkOrderAttachmentItems();
            final String _tmpUuid;
            if (_cursor.isNull(_cursorIndexOfUuid)) {
              _tmpUuid = null;
            } else {
              _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
            }
            _item.setUuid(_tmpUuid);
            final String _tmpDisplayFileName;
            if (_cursor.isNull(_cursorIndexOfDisplayFileName)) {
              _tmpDisplayFileName = null;
            } else {
              _tmpDisplayFileName = _cursor.getString(_cursorIndexOfDisplayFileName);
            }
            _item.setDisplayFileName(_tmpDisplayFileName);
            final String _tmpFileMd5Checksum;
            if (_cursor.isNull(_cursorIndexOfFileMd5Checksum)) {
              _tmpFileMd5Checksum = null;
            } else {
              _tmpFileMd5Checksum = _cursor.getString(_cursorIndexOfFileMd5Checksum);
            }
            _item.setFileMd5Checksum(_tmpFileMd5Checksum);
            final String _tmpFileName;
            if (_cursor.isNull(_cursorIndexOfFileName)) {
              _tmpFileName = null;
            } else {
              _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
            }
            _item.setFileName(_tmpFileName);
            final String _tmpContentType;
            if (_cursor.isNull(_cursorIndexOfContentType)) {
              _tmpContentType = null;
            } else {
              _tmpContentType = _cursor.getString(_cursorIndexOfContentType);
            }
            _item.setContentType(_tmpContentType);
            if (_cursor.isNull(_cursorIndexOfIsDownloaded)) {
              _item.isDownloaded = null;
            } else {
              _item.isDownloaded = _cursor.getInt(_cursorIndexOfIsDownloaded);
            }
            _result.add(_item);
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
  public LiveData<List<WorkOrderNoteDetailItems>> getWorkOrderNoteDetail(final Integer[] noteId) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT WorkorderNoteDetail.property, WorkorderNoteDetail.property_key, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("                WorkorderNoteDetail.old_value, WorkorderNoteDetail.value, WorkorderNoteDetail.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("                WorkorderNoteDetail.workorder_note_id FROM workorder_note_details AS WorkorderNoteDetail ");
    _stringBuilder.append("\n");
    _stringBuilder.append("                 WHERE WorkorderNoteDetail.workorder_note_id IN (");
    final int _inputSize = noteId.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : noteId) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"workorder_note_details"}, false, new Callable<List<WorkOrderNoteDetailItems>>() {
      @Override
      public List<WorkOrderNoteDetailItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProperty = 0;
          final int _cursorIndexOfPropertyKey = 1;
          final int _cursorIndexOfOldValue = 2;
          final int _cursorIndexOfValue = 3;
          final int _cursorIndexOfId = 4;
          final int _cursorIndexOfWorkorderNoteId = 5;
          final List<WorkOrderNoteDetailItems> _result = new ArrayList<WorkOrderNoteDetailItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WorkOrderNoteDetailItems _item_1;
            _item_1 = new WorkOrderNoteDetailItems();
            final String _tmpProperty;
            if (_cursor.isNull(_cursorIndexOfProperty)) {
              _tmpProperty = null;
            } else {
              _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
            }
            _item_1.setProperty(_tmpProperty);
            final String _tmpPropertyKey;
            if (_cursor.isNull(_cursorIndexOfPropertyKey)) {
              _tmpPropertyKey = null;
            } else {
              _tmpPropertyKey = _cursor.getString(_cursorIndexOfPropertyKey);
            }
            _item_1.setPropertyKey(_tmpPropertyKey);
            final String _tmpOldValue;
            if (_cursor.isNull(_cursorIndexOfOldValue)) {
              _tmpOldValue = null;
            } else {
              _tmpOldValue = _cursor.getString(_cursorIndexOfOldValue);
            }
            _item_1.setOldValue(_tmpOldValue);
            final String _tmpValue;
            if (_cursor.isNull(_cursorIndexOfValue)) {
              _tmpValue = null;
            } else {
              _tmpValue = _cursor.getString(_cursorIndexOfValue);
            }
            _item_1.setValue(_tmpValue);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item_1.setId(_tmpId);
            final Integer _tmpWorkorderNoteId;
            if (_cursor.isNull(_cursorIndexOfWorkorderNoteId)) {
              _tmpWorkorderNoteId = null;
            } else {
              _tmpWorkorderNoteId = _cursor.getInt(_cursorIndexOfWorkorderNoteId);
            }
            _item_1.setWorkorderNoteId(_tmpWorkorderNoteId);
            _result.add(_item_1);
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
  public String getStatus(final Integer statusId) {
    final String _sql = "Select name from workorder_statuses WHERE id = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (statusId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, statusId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
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
  public Integer getWorkOrderNoteId() {
    final String _sql = "SELECT id FROM workorder_notes ORDER BY id ASC LIMIT 1";
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
  public List<Integer> getDepartmentList(final Integer locationId) {
    final String _sql = "SELECT DISTINCT\n"
            + "  departments.id\n"
            + "FROM\n"
            + "  departments\n"
            + "INNER JOIN location_departments ON departments.id = location_departments.department_id\n"
            + "WHERE\n"
            + "  departments.is_deleted = 0 AND\n"
            + "  location_departments.is_deleted = 0 AND\n"
            + "  location_departments.location_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
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
  public List<Integer> getDepartmentList(final Integer userId, final Integer locationId) {
    final String _sql = "SELECT DISTINCT\n"
            + "  departments.id\n"
            + "FROM\n"
            + "  departments\n"
            + "INNER JOIN user_location_departments ON departments.id = user_location_departments.department_id\n"
            + "WHERE\n"
            + "  departments.is_deleted = 0 AND\n"
            + "  user_location_departments.is_deleted = 0 AND\n"
            + "  user_location_departments.user_id = ? AND\n"
            + "  user_location_departments.location_id = ?";
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
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
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
