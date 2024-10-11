package com.icarus.dao;

import android.database.Cursor;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.icarus.entities.AssignCheckListEntity;
import com.icarus.entities.AssignRoomEquipmentsEntity;
import com.icarus.entities.AssignedLogoEntity;
import com.icarus.entities.AssignedUserEntity;
import com.icarus.entities.LogsEntity;
import com.icarus.entities.UserFavouritesEntity;
import com.icarus.models.AllChecklistItems;
import com.icarus.models.RoomAssetItems;
import com.icarus.models.StringCheckBox;
import com.icarus.models.UserItems;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AllCheckListDao_Impl implements AllCheckListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserFavouritesEntity> __insertionAdapterOfUserFavouritesEntity;

  private final EntityInsertionAdapter<LogsEntity> __insertionAdapterOfLogsEntity;

  private final EntityInsertionAdapter<AssignCheckListEntity> __insertionAdapterOfAssignCheckListEntity;

  private final EntityInsertionAdapter<AssignedUserEntity> __insertionAdapterOfAssignedUserEntity;

  private final EntityInsertionAdapter<AssignRoomEquipmentsEntity> __insertionAdapterOfAssignRoomEquipmentsEntity;

  private final EntityInsertionAdapter<AssignedLogoEntity> __insertionAdapterOfAssignedLogoEntity;

  private final EntityDeletionOrUpdateAdapter<AssignedUserEntity> __updateAdapterOfAssignedUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfRemoveFavourite;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFavourite;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssignedChecklistPendingElementCount;

  public AllCheckListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserFavouritesEntity = new EntityInsertionAdapter<UserFavouritesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user_favorites` (`uuid`,`user_id`,`checklist_id`,`is_deleted`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserFavouritesEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUserId());
        }
        if (value.getChecklistId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklistId());
        }
        if (value.getIsDeleted() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getIsDeleted());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getSyncStatus());
        }
      }
    };
    this.__insertionAdapterOfLogsEntity = new EntityInsertionAdapter<LogsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `logs` (`uuid`,`item_uuid`,`checklist_id`,`checklist_element_id`,`action`,`user_id`,`assigned_to`,`username`,`assigned_to_name`,`assigned_checklist_uuid`,`item_description`,`step_action`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LogsEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.itemUuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.itemUuid);
        }
        if (value.checklistId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.checklistId);
        }
        if (value.checklistElementId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.checklistElementId);
        }
        if (value.action == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.action);
        }
        if (value.userId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.userId);
        }
        if (value.assignedTo == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.assignedTo);
        }
        if (value.username == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.username);
        }
        if (value.assignedToName == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.assignedToName);
        }
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.assignedChecklistUuid);
        }
        if (value.itemDescription == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.itemDescription);
        }
        if (value.stepAction == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.stepAction);
        }
        if (value.created == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.created);
        }
        if (value.modified == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.syncStatus);
        }
      }
    };
    this.__insertionAdapterOfAssignCheckListEntity = new EntityInsertionAdapter<AssignCheckListEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_checklists` (`assigned_at`,`assignee_type`,`checklist_id`,`checklist_status`,`created`,`department_id`,`due_date`,`is_deleted`,`location_id`,`modified`,`started_at`,`started_by_user_id`,`sync_status`,`user_id`,`uuid`,`execution_status`,`pending_elements_count`,`pending_resources_count`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignCheckListEntity value) {
        if (value.assignedAt == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedAt);
        }
        if (value.assigneeType == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.assigneeType);
        }
        if (value.checklistId == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.checklistId);
        }
        if (value.checklistStatus == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.checklistStatus);
        }
        if (value.created == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.created);
        }
        if (value.departmentId == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.departmentId);
        }
        if (value.dueDate == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.dueDate);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.isDeleted);
        }
        if (value.locationId == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.locationId);
        }
        if (value.modified == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.modified);
        }
        if (value.startedAt == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.startedAt);
        }
        if (value.startedByUserId == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.startedByUserId);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.uuid);
        }
        if (value.executionStatus == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.executionStatus);
        }
        if (value.pendingElementsCount == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.pendingElementsCount);
        }
        if (value.pendingResourcesCount == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.pendingResourcesCount);
        }
      }
    };
    this.__insertionAdapterOfAssignedUserEntity = new EntityInsertionAdapter<AssignedUserEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_users` (`assigned_checklist_uuid`,`assigned_by`,`created`,`is_deleted`,`modified`,`sync_status`,`user_id`,`uuid`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedUserEntity value) {
        if (value.assignedCheklistUUID == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedCheklistUUID);
        }
        if (value.assignedBy == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.assignedBy);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.uuid);
        }
      }
    };
    this.__insertionAdapterOfAssignRoomEquipmentsEntity = new EntityInsertionAdapter<AssignRoomEquipmentsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_room_equipments` (`uuid`,`assigned_checklist_uuid`,`created`,`equipment_id`,`is_deleted`,`modified`,`room_id`,`sync_status`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignRoomEquipmentsEntity value) {
        if (value.uuid == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.uuid);
        }
        if (value.assignedChecklistUuid == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.assignedChecklistUuid);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.equipmentId == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.equipmentId);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.modified);
        }
        if (value.roomId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.roomId);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.syncStatus);
        }
      }
    };
    this.__insertionAdapterOfAssignedLogoEntity = new EntityInsertionAdapter<AssignedLogoEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `assigned_logos` (`uuid`,`assigned_checklist_uuid`,`checklist_logo_id`,`created`,`modified`,`sync_status`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedLogoEntity value) {
        if (value.getUuid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid());
        }
        if (value.getAssignedChecklistUuid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAssignedChecklistUuid());
        }
        if (value.getChecklistLogoId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getChecklistLogoId());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getSyncStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getSyncStatus());
        }
      }
    };
    this.__updateAdapterOfAssignedUserEntity = new EntityDeletionOrUpdateAdapter<AssignedUserEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `assigned_users` SET `assigned_checklist_uuid` = ?,`assigned_by` = ?,`created` = ?,`is_deleted` = ?,`modified` = ?,`sync_status` = ?,`user_id` = ?,`uuid` = ? WHERE `uuid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AssignedUserEntity value) {
        if (value.assignedCheklistUUID == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.assignedCheklistUUID);
        }
        if (value.assignedBy == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.assignedBy);
        }
        if (value.created == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.created);
        }
        if (value.isDeleted == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.isDeleted);
        }
        if (value.modified == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.modified);
        }
        if (value.syncStatus == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.syncStatus);
        }
        if (value.userId == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.userId);
        }
        if (value.uuid == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.uuid);
        }
        if (value.uuid == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.uuid);
        }
      }
    };
    this.__preparedStmtOfRemoveFavourite = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update user_favorites set is_deleted = 1,modified = ?, sync_status = ? where checklist_id = ? and user_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFavourite = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update user_favorites set is_deleted = 0, modified = ?, sync_status = ? where checklist_id = ? and user_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssignedChecklistPendingElementCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "update assigned_checklists SET pending_elements_count = pending_elements_count + 1 where uuid = ?";
        return _query;
      }
    };
  }

  @Override
  public void addFavourite(final UserFavouritesEntity userFavouritesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserFavouritesEntity.insert(userFavouritesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLogs(final LogsEntity logs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLogsEntity.insert(logs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void assignCheckList(final AssignCheckListEntity assignCheckListEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignCheckListEntity.insert(assignCheckListEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertUsers(final AssignedUserEntity assignedUserEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedUserEntity.insert(assignedUserEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertRoomAsset(final AssignRoomEquipmentsEntity assignRoomEquipmentsEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignRoomEquipmentsEntity.insert(assignRoomEquipmentsEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLog(final AssignedLogoEntity assignedLogoEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAssignedLogoEntity.insert(assignedLogoEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUsers(final AssignedUserEntity assignedUserEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAssignedUserEntity.handle(assignedUserEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeFavourite(final Integer checklistId, final Integer userId,
      final Integer sync_status, final String modified) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveFavourite.acquire();
    int _argIndex = 1;
    if (modified == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, modified);
    }
    _argIndex = 2;
    if (sync_status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, sync_status);
    }
    _argIndex = 3;
    if (checklistId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistId);
    }
    _argIndex = 4;
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
      __preparedStmtOfRemoveFavourite.release(_stmt);
    }
  }

  @Override
  public void updateFavourite(final Integer checklistId, final Integer userId,
      final Integer sync_status, final String modified) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFavourite.acquire();
    int _argIndex = 1;
    if (modified == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, modified);
    }
    _argIndex = 2;
    if (sync_status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, sync_status);
    }
    _argIndex = 3;
    if (checklistId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, checklistId);
    }
    _argIndex = 4;
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
      __preparedStmtOfUpdateFavourite.release(_stmt);
    }
  }

  @Override
  public void updateAssignedChecklistPendingElementCount(final String uuid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssignedChecklistPendingElementCount.acquire();
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
      __preparedStmtOfUpdateAssignedChecklistPendingElementCount.release(_stmt);
    }
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckList(final Integer udid,
      final Integer locationid, final String[] type, final Integer groupID, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  DISTINCT Checklist.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name as checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired as checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN user_location_departments AS UserLocationDepartment ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    UserLocationDepartment.department_id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.location_id = ChecklistLocation.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.is_deleted = 0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.group_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified =(");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.department_id = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR UserLocationDepartment.user_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  ) AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY lower(ChecklistTitle.title) ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListDec(final Integer udid,
      final Integer locationid, final String[] type, final Integer groupID, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  DISTINCT Checklist.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name as checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired as checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN user_location_departments AS UserLocationDepartment ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    UserLocationDepartment.department_id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.location_id = ChecklistLocation.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.is_deleted = 0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.group_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified =(");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.department_id = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR UserLocationDepartment.user_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  ) AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY lower(ChecklistTitle.title) DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModified(final Integer udid,
      final Integer locationid, final String[] type, final Integer groupID, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  DISTINCT Checklist.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name as checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired as checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN user_location_departments AS UserLocationDepartment ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    UserLocationDepartment.department_id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.location_id = ChecklistLocation.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.is_deleted = 0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.group_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified =(");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.department_id = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR UserLocationDepartment.user_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  ) AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY Checklist.modified  ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModiefiedDesc(
      final Integer udid, final Integer locationid, final String[] type, final Integer groupID,
      final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  DISTINCT Checklist.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name as checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired as checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN user_location_departments AS UserLocationDepartment ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    UserLocationDepartment.department_id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.location_id = ChecklistLocation.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.is_deleted = 0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.group_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified =(");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.department_id = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR UserLocationDepartment.user_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  ) AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY Checklist.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListFav(final Integer udid,
      final Integer locationid, final String[] type, final Integer groupID, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  DISTINCT Checklist.id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.uuid, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name as checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired as checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN user_location_departments AS UserLocationDepartment ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    UserLocationDepartment.department_id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.location_id = ChecklistLocation.location_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND UserLocationDepartment.is_deleted = 0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.group_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified =(");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.department_id = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR UserLocationDepartment.user_id = ");
    _stringBuilder.append("\n");
    _stringBuilder.append("?");
    _stringBuilder.append("  ) AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY Checklist.modified  ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 5 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 6;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckList(final Integer udid,
      final Integer locationid, final Integer groupID, final String keyword) {
    final String _sql = "SELECT \n"
            + "  DISTINCT Checklist.id, \n"
            + "  Checklist.uuid, \n"
            + "  ChecklistTitle.title, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name as checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n"
            + "    UserLocationDepartment.department_id = Checklist.department_id \n"
            + "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n"
            + "    AND UserLocationDepartment.is_deleted = 0\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.group_id = \n"
            + "?    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = \n"
            + "?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified =(\n"
            + "      SELECT \n"
            + "        max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    Checklist.department_id = 0 \n"
            + "    OR UserLocationDepartment.user_id = \n"
            + "?  ) AND (ChecklistTitle.title like ?) \n"
            + " ORDER BY lower(ChecklistTitle.title) ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListSortByNameDesc(
      final Integer udid, final Integer locationid, final Integer groupID, final String keyword) {
    final String _sql = "SELECT \n"
            + "  DISTINCT Checklist.id, \n"
            + "  Checklist.uuid, \n"
            + "  ChecklistTitle.title, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name as checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n"
            + "    UserLocationDepartment.department_id = Checklist.department_id \n"
            + "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n"
            + "    AND UserLocationDepartment.is_deleted = 0\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.group_id = \n"
            + "?    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = \n"
            + "?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified =(\n"
            + "      SELECT \n"
            + "        max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    Checklist.department_id = 0 \n"
            + "    OR UserLocationDepartment.user_id = \n"
            + "?  ) AND (ChecklistTitle.title like ?) \n"
            + " ORDER BY lower(ChecklistTitle.title) DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModified(final Integer udid,
      final Integer locationid, final Integer groupID, final String keyword) {
    final String _sql = "SELECT \n"
            + "  DISTINCT Checklist.id, \n"
            + "  Checklist.uuid, \n"
            + "  ChecklistTitle.title, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name as checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n"
            + "    UserLocationDepartment.department_id = Checklist.department_id \n"
            + "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n"
            + "    AND UserLocationDepartment.is_deleted = 0\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.group_id = \n"
            + "?    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = \n"
            + "?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified =(\n"
            + "      SELECT \n"
            + "        max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    Checklist.department_id = 0 \n"
            + "    OR UserLocationDepartment.user_id = \n"
            + "?  ) AND (ChecklistTitle.title like ?) \n"
            + " ORDER BY Checklist.modified  ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListModifiedDesc(
      final Integer udid, final Integer locationid, final Integer groupID, final String keyword) {
    final String _sql = "SELECT \n"
            + "  DISTINCT Checklist.id, \n"
            + "  Checklist.uuid, \n"
            + "  ChecklistTitle.title, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name as checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n"
            + "    UserLocationDepartment.department_id = Checklist.department_id \n"
            + "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n"
            + "    AND UserLocationDepartment.is_deleted = 0\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.group_id = \n"
            + "?    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = \n"
            + "?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified =(\n"
            + "      SELECT \n"
            + "        max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    Checklist.department_id = 0 \n"
            + "    OR UserLocationDepartment.user_id = \n"
            + "?  ) AND (ChecklistTitle.title like ?) \n"
            + " ORDER BY Checklist.modified DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListFav(final Integer udid,
      final Integer locationid, final Integer groupID, final String keyword) {
    final String _sql = "SELECT \n"
            + "  DISTINCT Checklist.id, \n"
            + "  Checklist.uuid, \n"
            + "  ChecklistTitle.title, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name as checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired as checkliststatus_is_expired, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN user_location_departments AS UserLocationDepartment ON(\n"
            + "    UserLocationDepartment.department_id = Checklist.department_id \n"
            + "    AND UserLocationDepartment.location_id = ChecklistLocation.location_id \n"
            + "    AND UserLocationDepartment.is_deleted = 0\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.group_id = \n"
            + "?    AND ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = \n"
            + "?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified =(\n"
            + "      SELECT \n"
            + "        max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    Checklist.department_id = 0 \n"
            + "    OR UserLocationDepartment.user_id = \n"
            + "?  ) AND (ChecklistTitle.title like ?) \n"
            + " ORDER BY is_favorite DESC, Checklist.modified DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (groupID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, groupID);
    }
    _argIndex = 2;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 3;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 4;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 5;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "user_location_departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdmin(final Integer udid,
      final Integer locationid, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name AS checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired AS checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified = (");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        Max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  )AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY lower(ChecklistTitle.title) ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByNameDesc(
      final Integer udid, final Integer locationid, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name AS checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired AS checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified = (");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        Max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  )AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY lower(ChecklistTitle.title) DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModified(
      final Integer udid, final Integer locationid, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name AS checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired AS checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified = (");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        Max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  )AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY Checklist.modified  ASC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModifiedDesc(
      final Integer udid, final Integer locationid, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name AS checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired AS checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified = (");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        Max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  )AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY Checklist.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByFav(
      final Integer udid, final Integer locationid, final String[] type, final String keyword) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.checklist_type_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_resources_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.pending_references_count, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.sync_status, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.department_id, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Departments.name as departmentName,  Checklist.is_sequential, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_approval_required, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.name AS checkliststatus_name, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ChecklistStatus.is_expired AS checkliststatus_is_expired, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_assignable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Ifnull(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    0");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) AS is_executable, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.due_at, ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.modified, ");
    _stringBuilder.append("\n");
    _stringBuilder.append(" CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count ");
    _stringBuilder.append("\n");
    _stringBuilder.append("FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  checklists AS Checklist ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_titles AS ChecklistTitle ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistTitle.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_statuses AS ChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistStatus.id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_types AS ChecklistType ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistType.id = Checklist.checklist_type_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  INNER JOIN checklist_locations AS ChecklistLocation ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistLocation.checklist_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklists AS NextChecklist ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Checklist.id = NextChecklist.parent_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.id = NextChecklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN departments AS Departments ON(");
    _stringBuilder.append("\n");
    _stringBuilder.append("    Departments.id = Checklist.department_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  LEFT OUTER JOIN user_favorites UserFavorite ON ( ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  UserFavorite.checklist_id = Checklist.id ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(") WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  Checklist.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND Checklist.is_template = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistStatus.is_closed = 1 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistType.type IN (1, 2) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND ChecklistLocation.location_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append("  AND ChecklistLocation.is_deleted = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklist.modified = (");
    _stringBuilder.append("\n");
    _stringBuilder.append("      SELECT ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        Max(modified) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      FROM ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        checklists ");
    _stringBuilder.append("\n");
    _stringBuilder.append("      WHERE ");
    _stringBuilder.append("\n");
    _stringBuilder.append("        parent_id = Checklist.id");
    _stringBuilder.append("\n");
    _stringBuilder.append("    ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklist.modified IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  ) ");
    _stringBuilder.append("\n");
    _stringBuilder.append("  AND (");
    _stringBuilder.append("\n");
    _stringBuilder.append("    NextChecklistStatus.is_closed = 0 ");
    _stringBuilder.append("\n");
    _stringBuilder.append("    OR NextChecklistStatus.is_closed IS NULL");
    _stringBuilder.append("\n");
    _stringBuilder.append("  )AND (ChecklistTitle.title like ");
    _stringBuilder.append("?");
    _stringBuilder.append(") AND Checklist.checklist_type_id IN (");
    final int _inputSize = type.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY is_favorite DESC, Checklist.modified DESC ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    _argIndex = 4;
    for (String _item : type) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item_1;
              _item_1 = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item_1.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item_1.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item_1.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item_1.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item_1.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item_1.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item_1.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item_1.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item_1.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item_1.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item_1.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item_1.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item_1.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item_1.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item_1.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item_1.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item_1.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item_1.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item_1.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdmin(final Integer udid,
      final Integer locationid, final String keyword) {
    final String _sql = "SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name AS checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired AS checkliststatus_is_expired, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = ?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified = (\n"
            + "      SELECT \n"
            + "        Max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  )AND (ChecklistTitle.title like ?) ORDER BY lower(ChecklistTitle.title) ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByNameDesc(
      final Integer udid, final Integer locationid, final String keyword) {
    final String _sql = "SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name AS checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired AS checkliststatus_is_expired, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = ?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified = (\n"
            + "      SELECT \n"
            + "        Max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  )AND (ChecklistTitle.title like ?) ORDER BY lower(ChecklistTitle.title) DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModified(
      final Integer udid, final Integer locationid, final String keyword) {
    final String _sql = "SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name AS checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired AS checkliststatus_is_expired, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = ?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified = (\n"
            + "      SELECT \n"
            + "        Max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  )AND (ChecklistTitle.title like ?) ORDER BY Checklist.modified  ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByModifiedDesc(
      final Integer udid, final Integer locationid, final String keyword) {
    final String _sql = "SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name AS checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired AS checkliststatus_is_expired, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = ?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified = (\n"
            + "      SELECT \n"
            + "        Max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  )AND (ChecklistTitle.title like ?) ORDER BY Checklist.modified DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, AllChecklistItems> getAllCheckListAdminSortByFav(
      final Integer udid, final Integer locationid, final String keyword) {
    final String _sql = "SELECT DISTINCT Checklist.id,  Checklist.uuid,  ChecklistTitle.title, \n"
            + "  Checklist.checklist_type_id, \n"
            + "  Checklist.pending_resources_count, \n"
            + "  Checklist.pending_references_count, \n"
            + "  Checklist.sync_status, \n"
            + "  Checklist.department_id, \n"
            + "  Departments.name as departmentName,  Checklist.is_sequential, \n"
            + "  Checklist.is_approval_required, \n"
            + "  ChecklistStatus.name AS checkliststatus_name, \n"
            + "  ChecklistStatus.is_expired AS checkliststatus_is_expired, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_assignable, \n"
            + "    0\n"
            + "  ) AS is_assignable, \n"
            + "  Ifnull(\n"
            + "    ChecklistExecutionPermission.is_executable, \n"
            + "    0\n"
            + "  ) AS is_executable, \n"
            + "  Checklist.due_at, \n"
            + "  Checklist.modified, \n"
            + " CASE WHEN (UserFavorite.checklist_id > 0)  THEN 1 ELSE 0 END as is_favorite,  Checklist.checklist_placeholder_count \n"
            + "FROM \n"
            + "  checklists AS Checklist \n"
            + "  INNER JOIN checklist_titles AS ChecklistTitle ON(\n"
            + "    ChecklistTitle.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_statuses AS ChecklistStatus ON(\n"
            + "    ChecklistStatus.id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_types AS ChecklistType ON(\n"
            + "    ChecklistType.id = Checklist.checklist_type_id\n"
            + "  ) \n"
            + "  INNER JOIN checklist_locations AS ChecklistLocation ON(\n"
            + "    ChecklistLocation.checklist_id = Checklist.id\n"
            + "  ) \n"
            + "  LEFT JOIN checklists AS NextChecklist ON(\n"
            + "    Checklist.id = NextChecklist.parent_id\n"
            + "  ) \n"
            + "  LEFT JOIN checklist_statuses AS NextChecklistStatus ON(\n"
            + "    NextChecklistStatus.id = NextChecklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT JOIN departments AS Departments ON(\n"
            + "    Departments.id = Checklist.department_id \n"
            + "  ) \n"
            + "  LEFT JOIN checklist_execution_permissions ChecklistExecutionPermission ON (\n"
            + "    ChecklistExecutionPermission.checklist_type_id = Checklist.checklist_type_id \n"
            + "    AND ChecklistExecutionPermission.checklist_status_id = Checklist.checklist_status_id\n"
            + "  ) \n"
            + "  LEFT OUTER JOIN user_favorites UserFavorite ON ( \n"
            + "  UserFavorite.checklist_id = Checklist.id \n"
            + "  AND UserFavorite.is_deleted = 0 AND UserFavorite.user_id = ?) WHERE \n"
            + "  Checklist.is_deleted = 0 \n"
            + "  AND Checklist.is_template = 0 \n"
            + "  AND ChecklistStatus.is_closed = 1 \n"
            + "  AND ChecklistType.type IN (1, 2) \n"
            + "  AND ChecklistLocation.location_id = ?  AND ChecklistLocation.is_deleted = 0 \n"
            + "  AND (\n"
            + "    NextChecklist.modified = (\n"
            + "      SELECT \n"
            + "        Max(modified) \n"
            + "      FROM \n"
            + "        checklists \n"
            + "      WHERE \n"
            + "        parent_id = Checklist.id\n"
            + "    ) \n"
            + "    OR NextChecklist.modified IS NULL\n"
            + "  ) \n"
            + "  AND (\n"
            + "    NextChecklistStatus.is_closed = 0 \n"
            + "    OR NextChecklistStatus.is_closed IS NULL\n"
            + "  )AND (ChecklistTitle.title like ?) ORDER BY is_favorite DESC, Checklist.modified DESC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (udid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, udid);
    }
    _argIndex = 2;
    if (locationid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationid);
    }
    _argIndex = 3;
    if (keyword == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyword);
    }
    return new DataSource.Factory<Integer, AllChecklistItems>() {
      @Override
      public LimitOffsetDataSource<AllChecklistItems> create() {
        return new LimitOffsetDataSource<AllChecklistItems>(__db, _statement, false , "checklists", "checklist_titles", "checklist_statuses", "checklist_types", "checklist_locations", "departments", "checklist_execution_permissions", "user_favorites") {
          @Override
          protected List<AllChecklistItems> convertRows(Cursor cursor) {
            final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(cursor, "uuid");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfChecklistTypeId = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_type_id");
            final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_resources_count");
            final int _cursorIndexOfPendingReferencesCount = CursorUtil.getColumnIndexOrThrow(cursor, "pending_references_count");
            final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(cursor, "sync_status");
            final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(cursor, "department_id");
            final int _cursorIndexOfDepartmentName = CursorUtil.getColumnIndexOrThrow(cursor, "departmentName");
            final int _cursorIndexOfIsSequential = CursorUtil.getColumnIndexOrThrow(cursor, "is_sequential");
            final int _cursorIndexOfIsApprovalRequired = CursorUtil.getColumnIndexOrThrow(cursor, "is_approval_required");
            final int _cursorIndexOfChecklistStatusName = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_name");
            final int _cursorIndexOfChecklistStatusIsExpired = CursorUtil.getColumnIndexOrThrow(cursor, "checkliststatus_is_expired");
            final int _cursorIndexOfIsAssignable = CursorUtil.getColumnIndexOrThrow(cursor, "is_assignable");
            final int _cursorIndexOfIsExecutable = CursorUtil.getColumnIndexOrThrow(cursor, "is_executable");
            final int _cursorIndexOfDueAt = CursorUtil.getColumnIndexOrThrow(cursor, "due_at");
            final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(cursor, "modified");
            final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(cursor, "is_favorite");
            final int _cursorIndexOfPlaceholderCount = CursorUtil.getColumnIndexOrThrow(cursor, "checklist_placeholder_count");
            final List<AllChecklistItems> _res = new ArrayList<AllChecklistItems>(cursor.getCount());
            while(cursor.moveToNext()) {
              final AllChecklistItems _item;
              _item = new AllChecklistItems();
              final Integer _tmpChecklistId;
              if (cursor.isNull(_cursorIndexOfChecklistId)) {
                _tmpChecklistId = null;
              } else {
                _tmpChecklistId = cursor.getInt(_cursorIndexOfChecklistId);
              }
              _item.setChecklistId(_tmpChecklistId);
              final String _tmpUuid;
              _tmpUuid = cursor.getString(_cursorIndexOfUuid);
              _item.setUuid(_tmpUuid);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _item.setTitle(_tmpTitle);
              final Integer _tmpChecklistTypeId;
              if (cursor.isNull(_cursorIndexOfChecklistTypeId)) {
                _tmpChecklistTypeId = null;
              } else {
                _tmpChecklistTypeId = cursor.getInt(_cursorIndexOfChecklistTypeId);
              }
              _item.setChecklistTypeId(_tmpChecklistTypeId);
              final Integer _tmpPendingResourcesCount;
              if (cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
                _tmpPendingResourcesCount = null;
              } else {
                _tmpPendingResourcesCount = cursor.getInt(_cursorIndexOfPendingResourcesCount);
              }
              _item.setPendingResourcesCount(_tmpPendingResourcesCount);
              final Integer _tmpPendingReferencesCount;
              if (cursor.isNull(_cursorIndexOfPendingReferencesCount)) {
                _tmpPendingReferencesCount = null;
              } else {
                _tmpPendingReferencesCount = cursor.getInt(_cursorIndexOfPendingReferencesCount);
              }
              _item.setPendingReferencesCount(_tmpPendingReferencesCount);
              final Integer _tmpSyncStatus;
              if (cursor.isNull(_cursorIndexOfSyncStatus)) {
                _tmpSyncStatus = null;
              } else {
                _tmpSyncStatus = cursor.getInt(_cursorIndexOfSyncStatus);
              }
              _item.setSyncStatus(_tmpSyncStatus);
              final Integer _tmpDepartmentId;
              if (cursor.isNull(_cursorIndexOfDepartmentId)) {
                _tmpDepartmentId = null;
              } else {
                _tmpDepartmentId = cursor.getInt(_cursorIndexOfDepartmentId);
              }
              _item.setDepartmentId(_tmpDepartmentId);
              final String _tmpDepartmentName;
              _tmpDepartmentName = cursor.getString(_cursorIndexOfDepartmentName);
              _item.setDepartmentName(_tmpDepartmentName);
              final Integer _tmpIsSequential;
              if (cursor.isNull(_cursorIndexOfIsSequential)) {
                _tmpIsSequential = null;
              } else {
                _tmpIsSequential = cursor.getInt(_cursorIndexOfIsSequential);
              }
              _item.setIsSequential(_tmpIsSequential);
              final Integer _tmpIsApprovalRequired;
              if (cursor.isNull(_cursorIndexOfIsApprovalRequired)) {
                _tmpIsApprovalRequired = null;
              } else {
                _tmpIsApprovalRequired = cursor.getInt(_cursorIndexOfIsApprovalRequired);
              }
              _item.setIsApprovalRequired(_tmpIsApprovalRequired);
              final String _tmpChecklistStatusName;
              _tmpChecklistStatusName = cursor.getString(_cursorIndexOfChecklistStatusName);
              _item.setChecklistStatusName(_tmpChecklistStatusName);
              final Integer _tmpChecklistStatusIsExpired;
              if (cursor.isNull(_cursorIndexOfChecklistStatusIsExpired)) {
                _tmpChecklistStatusIsExpired = null;
              } else {
                _tmpChecklistStatusIsExpired = cursor.getInt(_cursorIndexOfChecklistStatusIsExpired);
              }
              _item.setChecklistStatusIsExpired(_tmpChecklistStatusIsExpired);
              final Integer _tmpIsAssignable;
              if (cursor.isNull(_cursorIndexOfIsAssignable)) {
                _tmpIsAssignable = null;
              } else {
                _tmpIsAssignable = cursor.getInt(_cursorIndexOfIsAssignable);
              }
              _item.setIsAssignable(_tmpIsAssignable);
              final Integer _tmpIsExecutable;
              if (cursor.isNull(_cursorIndexOfIsExecutable)) {
                _tmpIsExecutable = null;
              } else {
                _tmpIsExecutable = cursor.getInt(_cursorIndexOfIsExecutable);
              }
              _item.setIsExecutable(_tmpIsExecutable);
              final String _tmpDueAt;
              _tmpDueAt = cursor.getString(_cursorIndexOfDueAt);
              _item.setDueAt(_tmpDueAt);
              final String _tmpModified;
              _tmpModified = cursor.getString(_cursorIndexOfModified);
              _item.setModified(_tmpModified);
              final Integer _tmpIsFavorite;
              if (cursor.isNull(_cursorIndexOfIsFavorite)) {
                _tmpIsFavorite = null;
              } else {
                _tmpIsFavorite = cursor.getInt(_cursorIndexOfIsFavorite);
              }
              _item.setIsFavorite(_tmpIsFavorite);
              final Integer _tmpPlaceholderCount;
              if (cursor.isNull(_cursorIndexOfPlaceholderCount)) {
                _tmpPlaceholderCount = null;
              } else {
                _tmpPlaceholderCount = cursor.getInt(_cursorIndexOfPlaceholderCount);
              }
              _item.setPlaceholderCount(_tmpPlaceholderCount);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public List<StringCheckBox> getDepartmentFilterList(final Integer locationId) {
    final String _sql = "SELECT DISTINCT\n"
            + "  departments.id,\n"
            + "  departments.name,\n"
            + "  departments.short_name\n"
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfShortName = CursorUtil.getColumnIndexOrThrow(_cursor, "short_name");
      final List<StringCheckBox> _result = new ArrayList<StringCheckBox>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StringCheckBox _item;
        _item = new StringCheckBox();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.title = _cursor.getString(_cursorIndexOfTitle);
        _item.shortName = _cursor.getString(_cursorIndexOfShortName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<StringCheckBox> getDepartmentFilterList(final Integer userId,
      final Integer locationId) {
    final String _sql = "SELECT DISTINCT\n"
            + "  departments.id,\n"
            + "  departments.name,\n"
            + "  departments.short_name\n"
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfShortName = CursorUtil.getColumnIndexOrThrow(_cursor, "short_name");
      final List<StringCheckBox> _result = new ArrayList<StringCheckBox>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StringCheckBox _item;
        _item = new StringCheckBox();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.title = _cursor.getString(_cursorIndexOfTitle);
        _item.shortName = _cursor.getString(_cursorIndexOfShortName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<StringCheckBox> getUserFilterList(final Integer locationId) {
    final String _sql = "SELECT users.id as id,\n"
            + "       users.full_name as name\n"
            + " FROM users\n"
            + " WHERE users.group_id = 2\n"
            + " UNION\n"
            + " SELECT users.id as id,\n"
            + "       users.full_name as name\n"
            + " FROM users\n"
            + " INNER JOIN user_location_departments ON user_location_departments.user_id = users.id\n"
            + " WHERE users.is_deleted = 0\n"
            + "    AND user_location_departments.is_deleted = 0\n"
            + "    AND user_location_departments.location_id = ?    AND users.group_id NOT IN (1,7)\n"
            + " ORDER BY name ASC";
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<StringCheckBox> _result = new ArrayList<StringCheckBox>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StringCheckBox _item;
        _item = new StringCheckBox();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.title = _cursor.getString(_cursorIndexOfTitle);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoomAssetItems> getRoomAssets(final Integer checklistId, final Integer locationId) {
    final String _sql = "SELECT rooms.id AS room_id,\n"
            + "       equipments.id AS equipment_id,\n"
            + "       rooms.name AS room,\n"
            + "       equipments.name AS asset,\n"
            + "       rooms.name || ' / ' || equipments.name AS room_asset\n"
            + " FROM checklist_room_equipments\n"
            + " LEFT JOIN checklist_locations ON checklist_locations.id = checklist_room_equipments.checklist_location_id\n"
            + " LEFT JOIN rooms ON rooms.id = checklist_room_equipments.room_id\n"
            + " LEFT JOIN equipments ON equipments.id = checklist_room_equipments.equipment_id\n"
            + " WHERE checklist_locations.checklist_id = ?  AND checklist_locations.location_id =   ?   AND checklist_room_equipments.is_deleted = 0\n"
            + "  AND checklist_locations.is_deleted = 0\n"
            + "  AND rooms.is_deleted = 0\n"
            + "  AND equipments.is_deleted = 0\n"
            + " ORDER BY rooms.name, equipments.name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
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
      final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "room_id");
      final int _cursorIndexOfEquipmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment_id");
      final int _cursorIndexOfRoom = CursorUtil.getColumnIndexOrThrow(_cursor, "room");
      final int _cursorIndexOfAsset = CursorUtil.getColumnIndexOrThrow(_cursor, "asset");
      final int _cursorIndexOfRoomAsset = CursorUtil.getColumnIndexOrThrow(_cursor, "room_asset");
      final List<RoomAssetItems> _result = new ArrayList<RoomAssetItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomAssetItems _item;
        _item = new RoomAssetItems();
        if (_cursor.isNull(_cursorIndexOfRoomId)) {
          _item.roomId = null;
        } else {
          _item.roomId = _cursor.getInt(_cursorIndexOfRoomId);
        }
        if (_cursor.isNull(_cursorIndexOfEquipmentId)) {
          _item.equipmentId = null;
        } else {
          _item.equipmentId = _cursor.getInt(_cursorIndexOfEquipmentId);
        }
        _item.room = _cursor.getString(_cursorIndexOfRoom);
        _item.asset = _cursor.getString(_cursorIndexOfAsset);
        _item.roomAsset = _cursor.getString(_cursorIndexOfRoomAsset);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserItems> getUsers(final Integer departmentId, final Integer locationId) {
    final String _sql = "SELECT users.id as id,\n"
            + "       users.uuid as uuid,\n"
            + "       users.full_name as full_name,\n"
            + "       users.group_id as group_id\n"
            + " FROM users\n"
            + " WHERE users.group_id = 2\n"
            + " UNION\n"
            + " SELECT users.id,\n"
            + "       users.uuid,\n"
            + "       users.full_name,\n"
            + "       users.group_id\n"
            + " FROM users\n"
            + " INNER JOIN user_location_departments ON user_location_departments.user_id = users.id\n"
            + " WHERE users.is_deleted = 0\n"
            + "    AND user_location_departments.is_deleted = 0\n"
            + "    AND user_location_departments.location_id = ?    AND user_location_departments.department_id = ?    AND users.group_id NOT IN (1,7)\n"
            + " ORDER BY users.full_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (locationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, locationId);
    }
    _argIndex = 2;
    if (departmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, departmentId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
      final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
      final List<UserItems> _result = new ArrayList<UserItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserItems _item;
        _item = new UserItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpFullName;
        _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        _item.setFullName(_tmpFullName);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _item.setGroupId(_tmpGroupId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserItems> getUsers(final Integer locationId) {
    final String _sql = "SELECT users.id as id,\n"
            + "       users.uuid as uuid,\n"
            + "       users.full_name as full_name,\n"
            + "       users.group_id as group_id\n"
            + " FROM users\n"
            + " WHERE users.group_id = 2\n"
            + " UNION\n"
            + " SELECT users.id,\n"
            + "       users.uuid,\n"
            + "       users.full_name,\n"
            + "       users.group_id\n"
            + " FROM users\n"
            + " INNER JOIN user_location_departments ON user_location_departments.user_id = users.id\n"
            + " WHERE users.is_deleted = 0\n"
            + "    AND user_location_departments.is_deleted = 0\n"
            + "    AND user_location_departments.location_id = ?    AND users.group_id NOT IN (1,7)\n"
            + " ORDER BY users.full_name ASC";
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "full_name");
      final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
      final List<UserItems> _result = new ArrayList<UserItems>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserItems _item;
        _item = new UserItems();
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpUuid;
        _tmpUuid = _cursor.getString(_cursorIndexOfUuid);
        _item.setUuid(_tmpUuid);
        final String _tmpFullName;
        _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        _item.setFullName(_tmpFullName);
        final Integer _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getInt(_cursorIndexOfGroupId);
        }
        _item.setGroupId(_tmpGroupId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AssignCheckListEntity> getAssignedCheckList() {
    final String _sql = "select * from assigned_checklists";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_at");
      final int _cursorIndexOfAssigneeType = CursorUtil.getColumnIndexOrThrow(_cursor, "assignee_type");
      final int _cursorIndexOfChecklistId = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_id");
      final int _cursorIndexOfChecklistStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "checklist_status");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfDepartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "department_id");
      final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "due_date");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfLocationId = CursorUtil.getColumnIndexOrThrow(_cursor, "location_id");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "started_at");
      final int _cursorIndexOfStartedByUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "started_by_user_id");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final int _cursorIndexOfExecutionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "execution_status");
      final int _cursorIndexOfPendingElementsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_elements_count");
      final int _cursorIndexOfPendingResourcesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "pending_resources_count");
      final List<AssignCheckListEntity> _result = new ArrayList<AssignCheckListEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AssignCheckListEntity _item;
        _item = new AssignCheckListEntity();
        _item.assignedAt = _cursor.getString(_cursorIndexOfAssignedAt);
        if (_cursor.isNull(_cursorIndexOfAssigneeType)) {
          _item.assigneeType = null;
        } else {
          _item.assigneeType = _cursor.getInt(_cursorIndexOfAssigneeType);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistId)) {
          _item.checklistId = null;
        } else {
          _item.checklistId = _cursor.getInt(_cursorIndexOfChecklistId);
        }
        if (_cursor.isNull(_cursorIndexOfChecklistStatus)) {
          _item.checklistStatus = null;
        } else {
          _item.checklistStatus = _cursor.getInt(_cursorIndexOfChecklistStatus);
        }
        _item.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfDepartmentId)) {
          _item.departmentId = null;
        } else {
          _item.departmentId = _cursor.getInt(_cursorIndexOfDepartmentId);
        }
        _item.dueDate = _cursor.getString(_cursorIndexOfDueDate);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _item.isDeleted = null;
        } else {
          _item.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        if (_cursor.isNull(_cursorIndexOfLocationId)) {
          _item.locationId = null;
        } else {
          _item.locationId = _cursor.getInt(_cursorIndexOfLocationId);
        }
        _item.modified = _cursor.getString(_cursorIndexOfModified);
        _item.startedAt = _cursor.getString(_cursorIndexOfStartedAt);
        if (_cursor.isNull(_cursorIndexOfStartedByUserId)) {
          _item.startedByUserId = null;
        } else {
          _item.startedByUserId = _cursor.getInt(_cursorIndexOfStartedByUserId);
        }
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _item.syncStatus = null;
        } else {
          _item.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _item.userId = null;
        } else {
          _item.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _item.uuid = _cursor.getString(_cursorIndexOfUuid);
        if (_cursor.isNull(_cursorIndexOfExecutionStatus)) {
          _item.executionStatus = null;
        } else {
          _item.executionStatus = _cursor.getInt(_cursorIndexOfExecutionStatus);
        }
        if (_cursor.isNull(_cursorIndexOfPendingElementsCount)) {
          _item.pendingElementsCount = null;
        } else {
          _item.pendingElementsCount = _cursor.getInt(_cursorIndexOfPendingElementsCount);
        }
        if (_cursor.isNull(_cursorIndexOfPendingResourcesCount)) {
          _item.pendingResourcesCount = null;
        } else {
          _item.pendingResourcesCount = _cursor.getInt(_cursorIndexOfPendingResourcesCount);
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
  public Integer getLogoId(final Integer checklistId) {
    final String _sql = "SELECT id FROM checklist_logos WHERE checklist_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
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
  public AssignedUserEntity ifUserExist(final Integer userId, final String uuid) {
    final String _sql = "select * from assigned_users where user_id = ? and assigned_checklist_uuid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    _argIndex = 2;
    if (uuid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uuid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAssignedCheklistUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_checklist_uuid");
      final int _cursorIndexOfAssignedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "assigned_by");
      final int _cursorIndexOfCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "created");
      final int _cursorIndexOfIsDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "is_deleted");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "modified");
      final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "sync_status");
      final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_id");
      final int _cursorIndexOfUuid = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
      final AssignedUserEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new AssignedUserEntity();
        _result.assignedCheklistUUID = _cursor.getString(_cursorIndexOfAssignedCheklistUUID);
        if (_cursor.isNull(_cursorIndexOfAssignedBy)) {
          _result.assignedBy = null;
        } else {
          _result.assignedBy = _cursor.getInt(_cursorIndexOfAssignedBy);
        }
        _result.created = _cursor.getString(_cursorIndexOfCreated);
        if (_cursor.isNull(_cursorIndexOfIsDeleted)) {
          _result.isDeleted = null;
        } else {
          _result.isDeleted = _cursor.getInt(_cursorIndexOfIsDeleted);
        }
        _result.modified = _cursor.getString(_cursorIndexOfModified);
        if (_cursor.isNull(_cursorIndexOfSyncStatus)) {
          _result.syncStatus = null;
        } else {
          _result.syncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
        }
        if (_cursor.isNull(_cursorIndexOfUserId)) {
          _result.userId = null;
        } else {
          _result.userId = _cursor.getInt(_cursorIndexOfUserId);
        }
        _result.uuid = _cursor.getString(_cursorIndexOfUuid);
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
  public String checkIsFavouriteExist(final Integer checklistId, final Integer userId) {
    final String _sql = "select uuid FROM user_favorites where checklist_id = ? AND user_id  = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (checklistId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, checklistId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
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
